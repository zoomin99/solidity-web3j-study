package com.inha.voting;

import com.inha.voting.gas.GasProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingService {

    // Infura RPC 엔드포인트 URL
    @Value("${infura.api-url}")
    private String rpcEndpointUrl;

    //내 지갑의 privateKey
    @Value("${metamask.wallet.private-key}")
    private String walletPrivateKey;

    //배포된 smart contract의 address
    @Value("${metamask.contract-address}")
    private String contractAddress;

    //내 지갑의 address
    @Value("${metamask.wallet-address}")
    private String walletAddress;

    private Credentials credentials;
    private Web3j web3j;
    private Voting votingContract;

    @PostConstruct
    public void initialize() {
        credentials = Credentials.create(walletPrivateKey);
        web3j = Web3j.build(new HttpService(rpcEndpointUrl));
        BigInteger gasPrice = new BigInteger("20000000000");
        BigInteger gasLimit = new BigInteger("500000"); // 500,000 가스
        GasProvider gasProvider = new GasProvider(gasPrice, gasLimit);
        votingContract = Voting.load(contractAddress, web3j, credentials, gasProvider);
    }

    public void getCandidateList() {
        try {
//            List <Voting.Candidate>candidateList = votingContract.getCandidateList().send();
//            List candidateNameList = new ArrayList<>();
//            for(Voting.Candidate candidate : candidateList) {
//                candidateNameList.add(candidate.getCandidateName());
//            }

            List<Voting.Candidate> send = votingContract.getCandidateList().send();
            List<String> candidateNameList = send.stream().map(Voting.Candidate::getCandidateName)
                    .collect(Collectors.toList());
            System.out.println("candidateList = " + candidateNameList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vote(String candidateName) {
        try {
            long beforeTime = System.currentTimeMillis();
            System.out.println("======================================");
            votingContract.voteForCandidate(candidateName).send();
            long afterTime = System.currentTimeMillis();
            System.out.println("======================================");
            long secDiffTime = (afterTime - beforeTime)/1000;
            System.out.println("secDiffTime = " + secDiffTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCandidate(String candidateName) {
        try {
            votingContract.addCandidate(candidateName).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getTotalVotes(String candidateName) {
        try {
            BigInteger totalVotes = votingContract.totalVotes(candidateName).send();
            System.out.println("totalVotes = " + totalVotes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
