
## toncoin-sdk

toncoin java sdk, supports generating Wallet V3 (r2) addresses and offline transaction signatures.

### usage

Example: 

```java
public static void main(String[] args) {
    byte[] seed = Hex.decode("1091a79e7d50246479ef1ae489b33e6aba7077f64463376597fd8e3fe838d660");
    KeyPair keyPair = KeyPair.fromSecretSeed(seed);
    String publicKey = Hex.toHexString(keyPair.getPublicKey());

    long seqno = 0L;
    BigDecimal value = BigDecimal.valueOf(0.01);
    long amount = value.multiply(BigDecimal.valueOf(Math.pow(10, 9))).longValue();
    // to address
    String to = "EQC9n2Gvzo3DqokN6w8sSK_lAO7iWH8sYjewkENqN8q_BS4H";
    Boolean bounced = false;
    to = new Address(to).toAddressString(true, true, bounced, false);
    Address toAddress = new Address(to);

    WalletContract contract = new WalletV3ContractR2(publicKey);
    contract.setDate(new Date());   // Set the transaction time, the default is 10min valid
    JSONObject object = contract.createTransferMessage(seed, toAddress, amount, seqno, "Comment", 3, false);
    Cell message = object.getObject("message", Cell.class);
    byte[] bytes = message.toBoc(false, true, false, 0);
    System.out.println(Base64.toBase64String(bytes));
}
```

## rpc 

**Query address information**

    curl -X POST -H "Content-Type: application/json" -d '{"jsonrpc":"2.0","id":1, "method":"getWalletInformation", "params":{"address":"EQDnghGSSsQAiT7CXEZivwYVLQzQKRXTNahSETgw0qpxn7kA"}}'  https://toncenter.com/api/v2/jsonRPC

**broadcast transaction** 
    
    curl -X POST -H "Content-Type: application/json" -d '{"jsonrpc":"2.0","id":1, "method":"sendBoc", "params":{"boc":"te6cckEBAgEAswAB34gBzwQjJJWIARJ9hLiMxX4MKloZoFIrpmtQpCJwYaVU4z4C1jXmAOqnbuNk7jasxZGdaT/w9pHFnGPXjqgsXSP14qqj2cPKnv3PlLxQ7/IXE3JosNnIaU7VFyz1qAcF6EAQGU1NGLsRDD4wAAAACBwBAHxCAF7PsNfnRuHVRIb1h5YkV/KAd3EsP5YxG9hIIbUb5V+CnMS0AAAAAAAAAAAAAAAAAAAAAAAAQ29tbWVudDDSr1w="}}'  https://toncenter.com/api/v2/jsonRPC

**block explorer**

    https://tonwhales.com/explorer/address/EQDnghGSSsQAiT7CXEZivwYVLQzQKRXTNahSETgw0qpxn7kA


## notice

Some address verification may fail, low probability. 


