package com.debuggor.ton;

import com.alibaba.fastjson.JSONObject;
import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.encoders.Hex;

import java.util.Date;

/**
 * @Author:yong.huang
 * @Date:2020-05-06 20:58
 */
public class SignTxTest {

    public static void main(String[] args) {
        byte[] seed = Hex.decode("1091a79e7d50246479ef1ae489b33e6aba7077f64463376597fd8e3fe838d660");
        KeyPair keyPair = KeyPair.fromSecretSeed(seed);
        String publicKey = Hex.toHexString(keyPair.getPublicKey());

        WalletContract contract = new WalletV3ContractR2(publicKey);
        contract.setDate(new Date());   // 设置交易时间 程序里面默认10min内有效
        String fromAddress = contract.getAddress().toAddressString(true, true, true, false);
        System.out.println(fromAddress);

        Address to = new Address("EQC9n2Gvzo3DqokN6w8sSK_lAO7iWH8sYjewkENqN8q_BS4H");
        JSONObject object = contract.createTransferMessage(seed, to, 100000000L, 13L, "debuggor", 3, false);
        Cell message = object.getObject("message", Cell.class);
        byte[] bytes = message.toBoc(false, true, false, 0);
        System.out.println(Base64.toBase64String(bytes));
    }

}
