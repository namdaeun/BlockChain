package core;

import util.Util;

import java.util.ArrayList;

public class BlockChainStarter {

    public static void main(String[] args) {

        Library seat1 = new Library(1, null, 0, new ArrayList()); // 블록 번호 : 1, nonse : 0
        seat1.mine();
        seat1.getData();
        seat1.getInformation();

        Library seat2 = new Library(2, seat1.getHash(), 0, new ArrayList());
//        seat2.addTransaction(new Transaction("짱구", "짱아", 1.5));
//        seat2.addTransaction(new Transaction("철수", "짱아", 0.7));
        seat2.mine();
        seat2.getData();
        seat2.getInformation();

        Library seat3 = new Library(3, seat2.getHash(), 0, new ArrayList());
//        seat3.addTransaction(new Transaction("유리", "수지", 8.2));
//        seat3.addTransaction(new Transaction("짱아", "짱구", 0.4));
        seat3.mine();
        seat3.getData();
        seat3.getInformation();

        Library seat4 = new Library(4, seat3.getHash(), 0, new ArrayList());
//        seat4.addTransaction(new Transaction("수지", "유리", 0.1));
        seat4.mine();
        seat4.getData();
        seat4.getInformation();
    }

}
 /*       Block block1 = new Block(1, null, 0, "데이터"); // 블록 번호 : 1, nonse : 0
        block1.mine();
        block1.getInformation();

        Block block2 = new Block(2, block1.getBlockHash(), 0, "데이터"); // 블록 번호 : 1, nonse : 0
        block2.mine();
        block2.getInformation();

        Block block3 = new Block(3, block2.getBlockHash(), 0, "데이터"); // 블록 번호 : 1, nonse : 0
        block3.mine();
        block3.getInformation();

        Block block4 = new Block(4, block3.getBlockHash(), 0, "데이터"); // 블록 번호 : 1, nonse : 0
        block4.mine();
        block4.getInformation();
    }*/

