package luiggy.test.api.application.use_cases;

import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;

import java.util.List;

public interface IPollReadingService {

    List<FetchedPoll> getAll();

}
