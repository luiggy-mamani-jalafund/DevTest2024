package luiggy.test.api.domain.repositories;

import luiggy.test.api.domain.entities.PollOption;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPollOptionRepository {

    Optional<PollOption> getById(UUID id);

    PollOption save(PollOption pollOption);

    List<PollOption> saveMany(List<PollOption> pollOption);

    List<PollOption> getAllByPollId(UUID id);

}
