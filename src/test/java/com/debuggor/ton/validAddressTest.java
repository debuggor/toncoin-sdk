package com.debuggor.ton;

/**
 * @Author:debuggor
 * @Date:2020-05-08 22:12
 */
public class validAddressTest {

    public static void main(String[] args) {
        System.out.println(Address.validAddress("EQC7LzQRKFN6_dtbcLiZGetLThfgr8PbnT1OlLCqgB6Fb1g4"));
        System.out.println(Address.validAddress("0:bb2f341128537afddb5b70b89919eb4b4e17e0afc3db9d3d4e94b0aa801e856f"));
        System.out.println(Address.validAddress("EQC7LzQRKFN6_dtbcLiZGetLThfgr8PbnT1OlLCqgB6Fb1g45"));
        System.out.println(Address.validAddress("abcdefgh"));
        System.out.println(Address.validAddress("12312312"));
    }

}
