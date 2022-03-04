package com.debuggor.ton;

import static net.i2p.crypto.eddsa.Utils.hexToBytes;

/**
 * @Author: debuggor
 * @DATE: 2021/10/29 17:03
 */
public class WalletV3ContractR2 extends WalletV3Contract {

    public WalletV3ContractR2(String pubkey) {
        super(pubkey);
        byte[] cellDes = hexToBytes("B5EE9C724101010100710000DEFF0020DD2082014C97BA218201339CBAB19F71B0ED44D0D31FD31F31D70BFFE304E0A4F2608308D71820D31FD31FD31FF82313BBF263ED44D0D31FD31FD3FFD15132BAF2A15144BAF2A204F901541055F910F2A3F8009320D74A96D307D402FB00E8D101A4C8CB1FCB1FCBFFC9ED5410BD6DAD");
        code = Cell.deserializeBoc(cellDes).get(0);
        if (walletId == 0) {
            this.walletId = 698983191 + workchain;
        }
    }

    public WalletV3ContractR2() {
        byte[] cellDes = hexToBytes("B5EE9C724101010100710000DEFF0020DD2082014C97BA218201339CBAB19F71B0ED44D0D31FD31F31D70BFFE304E0A4F2608308D71820D31FD31FD31FF82313BBF263ED44D0D31FD31FD3FFD15132BAF2A15144BAF2A204F901541055F910F2A3F8009320D74A96D307D402FB00E8D101A4C8CB1FCB1FCBFFC9ED5410BD6DAD");
        code = Cell.deserializeBoc(cellDes).get(0);
        if (walletId == 0) {
            this.walletId = 698983191 + workchain;
        }
    }


}
