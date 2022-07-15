package core;
import util.Util;

import java.util.ArrayList;

public class Block {

    private int blockID;
    private String previousBlockHash;
    private int nonce;
    // private String data; // 블록에 있는 데이터가 문자열이라고 가정
    private ArrayList<Transaction> transactionList;

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

/*
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
*/

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
        this.blockID = blockID;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
        this.transactionList = transactionList;
        /*this.data = data;*/
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    public void getInformation() {
        System.out.println("-------------------------");
        System.out.println("블록 번호: " + getBlockID());
        System.out.println("이전 해시: " + getPreviousBlockHash());
        System.out.println("채굴 변수 값: " + getNonce());
        /*System.out.println("블록 데이터: " + getData());*/
        System.out.println("트랜잭션 개수: " + transactionList.size() + "개");
        for(int i = 0; i < transactionList.size(); i++) {
            System.out.println(transactionList.get(i).getInformation());
        }
        System.out.println("블록 해시: " + getBlockHash());
        System.out.println("-------------------------");
    }


    public String getBlockHash() {  // 현재 블록을 해시로 표현
        String transactionInformations = "";
        for(int i = 0; i < transactionList.size(); i++) {  // 해당 블록에 포함되어 있는 모든 트랜잭션 값을 포
            // 트랜잭션 정보가 조금이라도 변경되는 경우 해시 값 전체가 변경됨
            transactionInformations += transactionList.get(i).getInformation();
        }
        return Util.getHash(nonce + transactionInformations + previousBlockHash);
    }

    public void mine() {
        while (true) {
            if (getBlockHash().substring(0, 4).equals("0000")) {
                System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
                break;
            }
            nonce++;
        }
    }
}
