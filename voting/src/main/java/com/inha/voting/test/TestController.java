package com.inha.voting.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final VotingContractInteraction votingContractInteraction;

    @GetMapping("/test")
    public void test() {
        votingContractInteraction.testSmartContractConnection();
    }

    @GetMapping("/test2/{str}")
    public void test2(@PathVariable String str) {
        votingContractInteraction.testSet(str);
    }

    @GetMapping("/test2")
    public void test3() {
        votingContractInteraction.testGet();
    }
}
