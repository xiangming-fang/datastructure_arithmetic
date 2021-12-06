package indi.xm.jy.bit;

// 位图是真的骚呀
public class BitMap {

    // 位图数组
    int[] bitMap;

    // range表示要表示多少个数
    // eg：10亿，20亿
    public BitMap(int range){
        // 为什么要加一
        // 因为 range >> 5 是向下取整的，这样的话，会保存不了range位的信息
        bitMap = new int[(range >> 5) + 1];
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

    // arr 用来存储排序之后的元素
    // 位图排序的思想就是桶排序
    // 但是位图排序的内容要大于0，并且不能重复
    public void bitMapSort(int[] arr){
        int index = 0;
        for (int i = 0; i < bitMap.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((bitMap[i] & ( 1 << j)) != 0) {
                    arr[index++] = (i << 5) + j;
                }
            }
        }
    }
}
