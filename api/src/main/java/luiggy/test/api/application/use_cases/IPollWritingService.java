package luiggy.test.api.application.use_cases;

import luiggy.test.api.infrastructure.dtos.requests.CreatePollDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;

public interface IPollWritingService {

    FetchedPoll createPoll(CreatePollDto createPollDto);

}
