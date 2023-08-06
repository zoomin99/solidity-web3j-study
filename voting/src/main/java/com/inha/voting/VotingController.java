package com.inha.voting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/voting")
public class VotingController {

    private final VotingService votingService;

    @GetMapping("/candidate-list")
    public void getCandidateList() {
        votingService.getCandidateList();
    }

    @GetMapping("/add-candidate/{candidateName}")
    public void addCandidate(@PathVariable String candidateName) {
        votingService.addCandidate(candidateName);
    }

    @GetMapping("/{candidateName}")
    public void vote(@PathVariable String candidateName) {
        votingService.vote(candidateName);
    }

    @GetMapping("/total-votes/{candidateName}")
    public void getTotalVotes(@PathVariable String candidateName) {
        votingService.getTotalVotes(candidateName);
    }
}
