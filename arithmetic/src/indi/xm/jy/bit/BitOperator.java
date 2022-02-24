package indi.xm.jy.bit;

import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.bit
 * @ClassName: Move
 * @Author: albert.fang
 * @Description: 移位
 * @Date: 2021/12/6 18:33
 */
public class BitOperator {

    @Test
    public void andTest(){
        System.out.println(1 & 0);
    }

    @Test
    public void orTest(){
        System.out.println(1 | 0);
    }

    @Test
    public void notTest(){
        System.out.println(~110);
    }

    @Test
    public void xorTest(){
        System.out.println( 1 ^ 0 );
    }

    @Test
    public void moveTest(){
        // 负数左移，符号位不动，保持为1，右边补0
        System.out.println(-1 << 2);
        // 正数左移，符号位不动，保持为0，右边补0
        System.out.println(1 << 2);
        // 正数右移，右边移除丢弃
        System.out.println(1 >> 2);
        System.out.println(1 >>> 2);
    }
}
