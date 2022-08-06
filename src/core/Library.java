package core;
import util.Util;

import java.util.ArrayList;

public class Library {

    private int seatID;
    private String previousHash;
    private int nonce;
    private String data; // 블록에 있는 데이터가 문자열이라고 가정
    private ArrayList<Transaction> transactionList;

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public int getID() {
        return seatID;
    }

    public void setID(int seatID) {
        this.seatID = seatID;
    }

    public Library(int seatID, String previousHash, int nonce, ArrayList transactionList) {
        this.seatID = seatID;
        this.previousHash = previousHash;
        this.nonce = nonce;
        this.transactionList = transactionList;
        /*this.data = data;*/
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    public void getInformation() {
        System.out.println("-------------------------");
        System.out.println("도서관 자리 번호: " + getID());
        System.out.println("이전 자리 해시값: " + getPreviousHash());
        System.out.println("채굴 변수 값: " + getNonce());
        System.out.println("자리 데이터: " + getData());
//        System.out.println("등록된 자리 개수: " + transactionList.size() + "개");
//        for(int i = 0; i < transactionList.size(); i++) {
//            System.out.println(transactionList.get(i).getInformation());
//        }
        System.out.println("현재 자리 해시값: " + getHash());
        System.out.println("-------------------------");
    }


    public String getHash() {  // 현재 블록을 해시로 표현
        String transactionInformations = "";
        for(int i = 0; i < transactionList.size(); i++) {  // 해당 블록에 포함되어 있는 모든 트랜잭션 값을 포
            // 트랜잭션 정보가 조금이라도 변경되는 경우 해시 값 전체가 변경됨
            transactionInformations += transactionList.get(i).getInformation();
        }
        return Util.getHash(nonce + transactionInformations + previousHash);
    }

    public void mine() {
        while (true) {
            if (getHash().substring(0, 4).equals("0000")) {
                System.out.println(seatID + "번 자리 예약을 완료했습니다.");
                break;
            }
            nonce++;
        }
    }
}
