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
public class VoteResponseDto {

    private UUID id;
    private UUID pollId;
    private UUID optionId;
    private String voterEmail;

}
