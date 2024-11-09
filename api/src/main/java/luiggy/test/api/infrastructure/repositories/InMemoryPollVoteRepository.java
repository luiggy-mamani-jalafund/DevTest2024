package luiggy.test.api.infrastructure.repositories;

import luiggy.test.api.domain.entities.PollVote;
import luiggy.test.api.domain.repositories.IPollVoteRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryPollVoteRepository implements IPollVoteRepository {

    private HashMap<UUID, PollVote> data;

    public InMemoryPollVoteRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public PollVote save(PollVote pollVote) {
        if (data.containsKey(pollVote.getId())) {
            throw new RuntimeException("the poll vote already exists");
        }

        pollVote.setId(UUID.randomUUID());
        data.put(pollVote.getId(), pollVote);

        return pollVote;
    }

    @Override
    public Optional<PollVote> getById(UUID id) {
        return Optional.of(data.get(id));
    }

    @Override
    public List<PollVote> getAllByPollOptionId(UUID pollOptionId) {
        return data.values()
                .stream()
                .filter(pollVote -> pollVote.getPollOptionId().equals(pollOptionId))
                .toList();
    }

    @Override
    public int countVotesByPollOptionId(UUID pollOptionId) {
        return (int) data.values()
                .stream()
                .filter(pollVote -> pollVote.getPollOptionId().equals(pollOptionId))
                .count();
    }

}
