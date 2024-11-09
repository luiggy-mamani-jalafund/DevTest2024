package luiggy.test.api.infrastructure.use_cases;

import lombok.AllArgsConstructor;
import luiggy.test.api.application.use_cases.IPollOptionService;
import luiggy.test.api.application.use_cases.IPollWritingService;
import luiggy.test.api.domain.entities.Poll;
import luiggy.test.api.domain.repositories.IPollRepository;
import luiggy.test.api.domain.repositories.IPollVoteRepository;
import luiggy.test.api.infrastructure.dtos.requests.CreatePollDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPollOption;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PollService implements IPollWritingService {

    private final ModelMapper modelMapper;
    private final IPollRepository pollRepository;
    private final IPollVoteRepository voteRepository;
    private final IPollOptionService pollOptionService;

    @Override
    public FetchedPoll createPoll(CreatePollDto createPollDto) {
        Poll newPoll = modelMapper.map(createPollDto, Poll.class);
        Poll createdPoll = pollRepository.save(newPoll);
        FetchedPoll createdPollDto = modelMapper.map(createdPoll, FetchedPoll.class);
        List<FetchedPollOption> pollOptions = pollOptionService.saveMany(createPollDto.getOptions(), createdPollDto.getId());
        createdPollDto.setOptions(pollOptions);

        return createdPollDto;
    }

    /*@Override
    public List<FetchedPoll> getAll() {
        System.out.println(pollRepository.getAll());
        return List.of();
    }*/
}
