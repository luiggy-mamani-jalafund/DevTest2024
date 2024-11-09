package luiggy.test.api.application.use_cases;

import luiggy.test.api.infrastructure.dtos.requests.VoteOptionDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPollOption;
import luiggy.test.api.infrastructure.dtos.responses.VoteResponseDto;

import java.util.List;
import java.util.UUID;

public interface IPollOptionService {

    VoteResponseDto vote(UUID pollId, VoteOptionDto voteOptionDto);

    List<FetchedPollOption> saveMany(List<String> options, UUID pollId);

    List<FetchedPollOption> getAllByPollId(UUID pollId);

}
