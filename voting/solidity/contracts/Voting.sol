// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract Voting {
    struct Candidate {
        string name;
        uint8 votes;
    }

    Candidate[] public candidateList;

    constructor() {}

    function addCandidate(string memory candidateName) public {
        require(!candidateExists(candidateName), "Candidate already exists");
        candidateList.push(Candidate(candidateName, 0));
    }

    function voteForCandidate(string memory candidate) public {
        require(candidateExists(candidate), "Candidate does not exist");
        for (uint256 i = 0; i < candidateList.length; i++) {
            if (keccak256(bytes(candidateList[i].name)) == keccak256(bytes(candidate))) {
                candidateList[i].votes += 1;
                break;
            }
        }
    }

    function totalVotes(string memory candidate) public view returns (uint8) {
        require(candidateExists(candidate), "Candidate does not exist");
        for (uint256 i = 0; i < candidateList.length; i++) {
            if (keccak256(bytes(candidateList[i].name)) == keccak256(bytes(candidate))) {
                return candidateList[i].votes;
            }
        }
        return 0;
    }

    function candidateExists(string memory candidate) private view returns (bool) {
        for (uint256 i = 0; i < candidateList.length; i++) {
            if (keccak256(bytes(candidateList[i].name)) == keccak256(bytes(candidate))) {
                return true;
            }
        }
        return false;
    }
    
    function getCandidateList() public view returns (Candidate[] memory) {
        return candidateList;
    }
}