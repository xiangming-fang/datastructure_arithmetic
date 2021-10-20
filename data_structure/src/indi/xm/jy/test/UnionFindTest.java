package indi.xm.jy.test;

import indi.xm.jy.unionfind.QuickFind;
import indi.xm.jy.unionfind.QuickUnion;
import org.junit.Test;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.test
 * @ClassName: UnionFindTest
 * @Author: albert.fang
 * @Description: 并查集测试
 * @Date: 2021/10/20 18:47
 */
public class UnionFindTest {

    @Test
    public void testQuickFind(){
        QuickFind unionFind = new QuickFind(10);
        System.out.println(unionFind.isConnected(0, 1));
        System.out.println(unionFind.isConnected(0, 2));
        unionFind.unionElements(1,2);
        unionFind.unionElements(0,2);
        System.out.println(unionFind.isConnected(0, 1));
        System.out.println(unionFind.isConnected(0, 2));
    }

    @Test
    public void testQuickUnion(){
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.println(quickUnion.isConnected(0, 1));
        System.out.println(quickUnion.isConnected(0, 2));
        quickUnion.unionElements(1,2);
        quickUnion.unionElements(0,2);
        System.out.println(quickUnion.isConnected(0, 1));
        System.out.println(quickUnion.isConnected(0, 2));
    }
}
