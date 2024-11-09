package luiggy.test.api.application.use_cases;

import luiggy.test.api.infrastructure.dtos.responses.FetchedPollOption;

import java.util.List;
import java.util.UUID;

public interface IPollOptionService {

    List<FetchedPollOption> saveMany(List<String> options, UUID pollId);

    List<FetchedPollOption> getAllByPollId(UUID pollId);

}
