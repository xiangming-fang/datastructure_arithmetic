package indi.xm.jy.bit;

public class BitOperator {

    public static void main(String[] args) {
        // 0111 1111 1111 1111 1111 1111 1111 1111
        // 左移一位，舍弃左边一位，右边补0
        // 1111 1111 1111 1111 1111 1111 1111 1110
        // 得到一个负数，负数转成原码读取，-1
        // 1111 1111 1111 1111 1111 1111 1111 1101
        // 再取反，负数取反的时候，符号位是不取反的
        // 1000 0000 0000 0000 0000 0000 0000 0010
        // 所以最后得到的答案是-2.
        System.out.println(Integer.MAX_VALUE << 1);

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 1 - 1);

        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);

        System.out.println(Integer.MIN_VALUE << 1);
    }
}
