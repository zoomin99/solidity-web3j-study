package com.inha.voting.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class Hello extends Contract {
    public static final String BINARY = "0x608060405234801561000f575f80fd5b506107638061001d5f395ff3fe608060405234801561000f575f80fd5b506004361061004a575f3560e01c8063191347df1461004e57806319ff1d211461006a578063b8c9e4ed14610088578063c15bae84146100a6575b5f80fd5b6100686004803603810190610063919061037a565b6100c4565b005b6100726100d6565b60405161007f919061043b565b60405180910390f35b610090610113565b60405161009d919061043b565b60405180910390f35b6100ae6101a2565b6040516100bb919061043b565b60405180910390f35b805f90816100d2919061065e565b5050565b60606040518060400160405280600581526020017f68656c6c6f000000000000000000000000000000000000000000000000000000815250905090565b60605f805461012190610488565b80601f016020809104026020016040519081016040528092919081815260200182805461014d90610488565b80156101985780601f1061016f57610100808354040283529160200191610198565b820191905f5260205f20905b81548152906001019060200180831161017b57829003601f168201915b5050505050905090565b5f80546101ae90610488565b80601f01602080910402602001604051908101604052809291908181526020018280546101da90610488565b80156102255780601f106101fc57610100808354040283529160200191610225565b820191905f5260205f20905b81548152906001019060200180831161020857829003601f168201915b505050505081565b5f604051905090565b5f80fd5b5f80fd5b5f80fd5b5f80fd5b5f601f19601f8301169050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b61028c82610246565b810181811067ffffffffffffffff821117156102ab576102aa610256565b5b80604052505050565b5f6102bd61022d565b90506102c98282610283565b919050565b5f67ffffffffffffffff8211156102e8576102e7610256565b5b6102f182610246565b9050602081019050919050565b828183375f83830152505050565b5f61031e610319846102ce565b6102b4565b90508281526020810184848401111561033a57610339610242565b5b6103458482856102fe565b509392505050565b5f82601f8301126103615761036061023e565b5b813561037184826020860161030c565b91505092915050565b5f6020828403121561038f5761038e610236565b5b5f82013567ffffffffffffffff8111156103ac576103ab61023a565b5b6103b88482850161034d565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b5f5b838110156103f85780820151818401526020810190506103dd565b5f8484015250505050565b5f61040d826103c1565b61041781856103cb565b93506104278185602086016103db565b61043081610246565b840191505092915050565b5f6020820190508181035f8301526104538184610403565b905092915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f600282049050600182168061049f57607f821691505b6020821081036104b2576104b161045b565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f600883026105147fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff826104d9565b61051e86836104d9565b95508019841693508086168417925050509392505050565b5f819050919050565b5f819050919050565b5f61056261055d61055884610536565b61053f565b610536565b9050919050565b5f819050919050565b61057b83610548565b61058f61058782610569565b8484546104e5565b825550505050565b5f90565b6105a3610597565b6105ae818484610572565b505050565b5b818110156105d1576105c65f8261059b565b6001810190506105b4565b5050565b601f821115610616576105e7816104b8565b6105f0846104ca565b810160208510156105ff578190505b61061361060b856104ca565b8301826105b3565b50505b505050565b5f82821c905092915050565b5f6106365f198460080261061b565b1980831691505092915050565b5f61064e8383610627565b9150826002028217905092915050565b610667826103c1565b67ffffffffffffffff8111156106805761067f610256565b5b61068a8254610488565b6106958282856105d5565b5f60209050601f8311600181146106c6575f84156106b4578287015190505b6106be8582610643565b865550610725565b601f1984166106d4866104b8565b5f5b828110156106fb578489015182556001820191506020850194506020810190506106d6565b868310156107185784890151610714601f891682610627565b8355505b6001600288020188555050505b50505050505056fea264697066735822122092ac39b92a79828da72eff0f5465abe9ddd0183566cf2b8d50493b7a9b7bbcff64736f6c63430008140033";

    public static final String FUNC_STR = "str";

    public static final String FUNC_HELLO = "hello";

    public static final String FUNC_SETSTR = "setStr";

    public static final String FUNC_GETSTR = "getStr";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Hello(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Hello(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Hello(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Hello(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> str() {
        final Function function = new Function(FUNC_STR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> hello() {
        final Function function = new Function(FUNC_HELLO,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setStr(String newStr) {
        final Function function = new Function(
                FUNC_SETSTR,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(newStr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getStr() {
        final Function function = new Function(FUNC_GETSTR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Hello load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hello(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Hello load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Hello(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Hello load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Hello(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Hello load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Hello(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Hello> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Hello.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Hello> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Hello.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Hello> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Hello.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Hello> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Hello.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
