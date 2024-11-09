package luiggy.test.api.infrastructure.repositories;

import luiggy.test.api.domain.entities.Poll;
import luiggy.test.api.domain.entities.PollOption;
import luiggy.test.api.domain.repositories.IPollRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class InMemoryPollRepository implements IPollRepository  {

    private HashMap<UUID, Poll> data;

    public InMemoryPollRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public Poll save(Poll newPoll) {
        if (data.containsKey(newPoll.getId())) {
            throw new RuntimeException("the poll already exists");
        }

        newPoll.setId(UUID.randomUUID());
        data.put(newPoll.getId(), newPoll);

        return newPoll;
    }

    @Override
    public List<Poll> getAll() {
        return data.values().stream().toList();
    }

}
