package com.practice.poc.SingletonDesignPattern;

public class LazySingletonNotThreadsafeProof {

    private static LazySingletonNotThreadsafeProof singletonObj;

    private LazySingletonNotThreadsafeProof(){

    }

    //1st way
    public static LazySingletonNotThreadsafeProof getSingletonObj() {
        if(singletonObj == null){
            singletonObj = new LazySingletonNotThreadsafeProof();
        }
        return singletonObj;
    }

    //2nd way
    public static synchronized LazySingletonNotThreadsafeProof getSingletonObj2() {
        if(singletonObj == null){
            singletonObj = new LazySingletonNotThreadsafeProof();
        }
        return singletonObj;
    }

    //3rd way
    //private static volatile LazySingletonNotThreadsafeProof singletonObj; this should be volatile in case of double check
    public static LazySingletonNotThreadsafeProof getSingletonObj3() {
        if(singletonObj == null){
            synchronized (LazySingletonNotThreadsafeProof.class) {
                if(singletonObj == null) {
                    singletonObj = new LazySingletonNotThreadsafeProof();
                }
            }
        }
        return singletonObj;
    }
}
