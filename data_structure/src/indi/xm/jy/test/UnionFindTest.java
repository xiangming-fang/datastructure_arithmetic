package indi.xm.jy.test;

import indi.xm.jy.unionfind.UnionFind;
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
    public void uk(){
        UnionFind unionFind = new UnionFind(10);
        System.out.println(unionFind.isConnected(0, 1));
        System.out.println(unionFind.isConnected(0, 2));
        unionFind.unionElements(1,2);
        unionFind.unionElements(0,2);
        System.out.println(unionFind.isConnected(0, 1));
        System.out.println(unionFind.isConnected(0, 2));
    }
}
