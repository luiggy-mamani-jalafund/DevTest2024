package luiggy.test.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import luiggy.test.api.application.use_cases.IPollOptionService;
import luiggy.test.api.application.use_cases.IPollService;
import luiggy.test.api.infrastructure.dtos.requests.CreatePollDto;
import luiggy.test.api.infrastructure.dtos.requests.VoteOptionDto;
import luiggy.test.api.infrastructure.dtos.responses.FetchedPoll;
import luiggy.test.api.infrastructure.dtos.responses.VoteResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/polls")
@AllArgsConstructor
public class PollController {

    private final IPollService pollService;
    private final IPollOptionService pollOptionService;

    @PostMapping
    public ResponseEntity<FetchedPoll> createPoll(@RequestBody @Valid CreatePollDto createPollDto) {
        return ResponseEntity.ok(pollService.createPoll(createPollDto));
    }

    @GetMapping
    public ResponseEntity<List<FetchedPoll>> getAll() {
        return ResponseEntity.ok(pollService.getAll());
    }

    @PutMapping("{id}/votes")
    public ResponseEntity<VoteResponseDto> vote(@PathVariable("id") UUID pollId, @RequestBody VoteOptionDto voteOptionDto) {
        return ResponseEntity.ok(pollOptionService.vote(pollId, voteOptionDto));
    }


}
