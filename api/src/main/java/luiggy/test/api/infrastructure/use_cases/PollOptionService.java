package luiggy.test.api.infrastructure.use_cases;

import lombok.AllArgsConstructor;
import luiggy.test.api.application.use_cases.IPollOptionService;
import luiggy.test.api.domain.entities.PollOption;
import luiggy.test.api.domain.entities.PollVote;
import luiggy.test.api.domain.repositories.IPollOptionRepository;
import luiggy.test.api.domain.repositories.IPollVoteRepository;
import luiggy.test.api.infrastructure.dtos.requests.VoteOptionDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPollOption;
import luiggy.test.api.infrastructure.dtos.responses.VoteResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PollOptionService implements IPollOptionService {

    private final ModelMapper modelMapper;
    private final IPollVoteRepository voteRepository;
    private final IPollOptionRepository pollOptionRepository;

    @Override
    public VoteResponseDto vote(UUID pollId, VoteOptionDto voteOptionDto) {
        Optional<PollOption> option = pollOptionRepository.getById(voteOptionDto.getOptionId());

        if (option.isEmpty() || !option.get().getPollId().equals(pollId)) {
            throw new RuntimeException("poll option not found");
        }

        PollVote pollVoteToCreate = new PollVote(UUID.randomUUID(), voteOptionDto.getVoterEmail(), voteOptionDto.getOptionId());
        PollVote pollVoted = voteRepository.save(pollVoteToCreate);

        return new VoteResponseDto(pollVoted.getId(), pollId, pollVoted.getPollOptionId(), pollVoted.getUserEmail());
    }

    @Override
    public List<FetchedPollOption> saveMany(List<String> options, UUID pollId) {
        List<PollOption> pollOptions = options.stream()
                .map(s -> new PollOption(UUID.randomUUID(), s, pollId))
                .toList();

        return pollOptionRepository
                .saveMany(pollOptions)
                .stream()
                .map(pollOption -> modelMapper.map(pollOption, FetchedPollOption.class))
                .toList();
    }

    @Override
    public List<FetchedPollOption> getAllByPollId(UUID pollId) {
        List<FetchedPollOption> options = pollOptionRepository.getAllByPollId(pollId)
                .stream()
                .map(pollOption -> modelMapper.map(pollOption, FetchedPollOption.class))
                .toList();
        options.forEach(fetchedPollOption -> fetchedPollOption.setVotes(voteRepository.countVotesByPollOptionId(fetchedPollOption.getId())));

        return options;
    }
}
