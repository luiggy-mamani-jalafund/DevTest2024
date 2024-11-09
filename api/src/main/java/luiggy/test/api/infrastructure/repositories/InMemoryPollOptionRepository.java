package luiggy.test.api.infrastructure.repositories;

import luiggy.test.api.domain.entities.PollOption;
import luiggy.test.api.domain.repositories.IPollOptionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPollOptionRepository implements IPollOptionRepository {

    private HashMap<UUID, PollOption> data;

    public InMemoryPollOptionRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public Optional<PollOption> getById(UUID id) {
        return Optional.of(data.get(id));
    }

    @Override
    public PollOption save(PollOption pollOption) {
        if (data.containsKey((pollOption.getId()))) {
            throw new RuntimeException("the poll options already exists");
        }

        pollOption.setId(UUID.randomUUID());
        data.put(pollOption.getId(), pollOption);

        return pollOption;
    }

    @Override
    public List<PollOption> saveMany(List<PollOption> pollOption) {
        List<PollOption> createdPollOptions = new ArrayList<>();

        for (PollOption option : pollOption) {
            createdPollOptions.add(save(option));
        }

        return createdPollOptions;
    }

    @Override
    public List<PollOption> getAllByPollId(UUID id) {
        return data.values()
                .stream()
                .filter(pollOption -> pollOption.getPollId().equals(id))
                .toList();
    }
}
