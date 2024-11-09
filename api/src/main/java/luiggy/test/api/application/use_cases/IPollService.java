package luiggy.test.api.application.use_cases;

import luiggy.test.api.infrastructure.dtos.requests.CreatePollDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;

import java.util.List;

public interface IPollService {

    FetchedPoll createPoll(CreatePollDto createPollDto);

    List<FetchedPoll> getAll();

}
