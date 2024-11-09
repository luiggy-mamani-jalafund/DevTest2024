package luiggy.test.api.infrastructure.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FetchedPoll {

    private UUID id;
    private String name;
    private List<FetchedPollOption> options;

}
