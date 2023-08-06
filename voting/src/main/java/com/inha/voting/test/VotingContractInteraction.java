package com.inha.voting.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import javax.annotation.PostConstruct;

@Service
public class VotingContractInteraction {

    // Infura RPC 엔드포인트 URL
    @Value("${infura.api-url}")
    private String rpcEndpointUrl;
    @Value("${metamask.wallet.private-key}")
    private String walletPrivateKey;

    @Value("${metamask.contract-address}")
    private String contractAddress;

    @Value("${metamask.wallet-address}")
    private String walletAddress;
    private Credentials credentials;
    private Web3j web3j;

    @PostConstruct
    public void initialize() {
        credentials = Credentials.create(walletPrivateKey);
        web3j = Web3j.build(new HttpService(rpcEndpointUrl));
    }

    public void testSmartContractConnection() {
        String result = null;
        try {
            /*
            EthGetBalance ethGetBalance = null;
            ethGetBalance = web3j.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger wei = ethGetBalance.getBalance();
            result = Convert.fromWei(wei.toString() , Convert.Unit.ETHER).toString();
            System.out.println("result = " + result);
            */

            /*
            String address = credentials.getAddress();
            String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);
            String privateKeyHex = credentials.getEcKeyPair().getPrivateKey().toString(16);

            System.out.println("Address: " + address);
            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKeyHex);
            */

            Hello helloContract = Hello.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);

            result = helloContract.hello().send();

            System.out.println("result = " + result);
        } catch (Exception e) {
            // 에러 처리
            e.printStackTrace();
        }
    }

    public void testSet(String str) {
        String result = null;
        try {
            Hello helloContract = Hello.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);

            helloContract.setStr(str).send();
        } catch (Exception e) {
            // 에러 처리
            e.printStackTrace();
        }
    }

    public void testGet() {
        String result2 = null;
        try {
            Hello helloContract = Hello.load(contractAddress, web3j, credentials, Contract.GAS_PRICE, Contract.GAS_LIMIT);

            result2 = helloContract.getStr().send();

            System.out.println("result2 = " + result2);
        } catch (Exception e) {
            // 에러 처리
            e.printStackTrace();
        }
    }

}
