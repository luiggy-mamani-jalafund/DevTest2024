package luiggy.test.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import luiggy.test.api.application.use_cases.IPollService;
import luiggy.test.api.infrastructure.dtos.requests.CreatePollDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polls")
@AllArgsConstructor
public class PollController {

    private IPollService pollService;

    @PostMapping
    public ResponseEntity<FetchedPoll> createPoll(@RequestBody @Valid CreatePollDto createPollDto) {
        return ResponseEntity.ok(pollService.createPoll(createPollDto));
    }

    @GetMapping
    public ResponseEntity<List<FetchedPoll>> getAll() {
        return ResponseEntity.ok(pollService.getAll());
    }


}
