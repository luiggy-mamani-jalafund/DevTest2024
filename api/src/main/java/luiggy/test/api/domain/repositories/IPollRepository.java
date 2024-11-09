package luiggy.test.api.domain.repositories;

import luiggy.test.api.domain.entities.Poll;

import java.util.List;

public interface IPollRepository {

    Poll save(Poll newPoll);

    List<Poll> getAll();

}
