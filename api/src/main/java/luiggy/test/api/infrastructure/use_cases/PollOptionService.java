package luiggy.test.api.infrastructure.use_cases;

import lombok.AllArgsConstructor;
import luiggy.test.api.application.use_cases.IPollOptionService;
import luiggy.test.api.domain.entities.PollOption;
import luiggy.test.api.domain.repositories.IPollOptionRepository;
import luiggy.test.api.domain.repositories.IPollVoteRepository;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPollOption;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PollOptionService implements IPollOptionService {

    private final ModelMapper modelMapper;
    private final IPollVoteRepository voteRepository;
    private final IPollOptionRepository pollOptionRepository;

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
        return pollOptionRepository.getAllByPollId(pollId)
                .stream()
                .map(pollOption -> modelMapper.map(pollOption, FetchedPollOption.class))
                .toList();
    }
}
