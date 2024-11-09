package luiggy.test.api.infrastructure.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FetchedPollOption {

    private UUID id;
    private String name;
    private int votes;

}
