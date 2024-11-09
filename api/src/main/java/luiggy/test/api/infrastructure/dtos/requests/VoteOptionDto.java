package luiggy.test.api.infrastructure.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteOptionDto {

    private UUID optionId;
    private String voterEmail;

}
