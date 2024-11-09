package luiggy.test.api.domain.repositories;

import luiggy.test.api.domain.entities.PollVote;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPollVoteRepository {

    Optional<PollVote> getById(UUID id);

    List<PollVote> getAllByPollOptionId(UUID pollOptionId);

    int countVotesByPollOptionId(UUID pollOptionId);

}
