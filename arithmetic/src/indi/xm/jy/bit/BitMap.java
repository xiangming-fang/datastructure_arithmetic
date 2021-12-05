package indi.xm.jy.bit;

import java.util.Random;

// 位图是真的骚呀
public class BitMap {

    // 位图数组
    int[] bitMap;

    // range表示要表示多少个数
    // eg：10亿，20亿
    public BitMap(int range){
        bitMap = new int[range >> 5];
    }

    // 往位图中加入数组value
    public void add(int value){
        // 在位图数组的第几个索引
        int index = value >> 5;
        // 在具体位置对应的二进制第几位
        int pos = value % (1 << 5);
        bitMap[index] |= (1 << pos);
    }

    // 判断位图中是否存在数值value
    public boolean contains(int value){
        // 在位图数组的第几个索引
        int index = value >> 5;
        // 在具体位置对应的二进制第几位
        int pos = value % (1 << 5);
        return (bitMap[index] & ( 1 << pos)) != 0;
    }

    // 从位图中删除数值value
    public void remove(int value){
        // 在位图数组的第几个索引
        int index = value >> 5;
        // 在具体位置对应的二进制第几位
        int pos = value % (1 << 5);
        bitMap[index] &= ~( 1 << pos );
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100000000);
        bitMap.add(123);
        bitMap.add(32);
        System.out.println(bitMap.contains(123));
        System.out.println(bitMap.contains(124));
        System.out.println(bitMap.contains(32));
        bitMap.remove(123);
        System.out.println(bitMap.contains(123));
        System.out.println(bitMap.contains(32));
        bitMap.remove(32);
        System.out.println(bitMap.contains(32));
    }
}
