package indi.xm.jy.uf;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.uf
 * @ClassName: UnionFindTest
 * @Author: albert.fang
 * @Description: 并查集
 * @Date: 2021/12/17 15:49
 */
public class UnionFindTest {

    @Test
    public void ufTest(){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        ans.add(4);
        ans.add(5);
        ans.add(6);
        ans.add(7);
        UnionFind<Integer> uf = new UnionFind<Integer>(ans);

        System.out.println(uf.isSameSet(1, 2));
        uf.union(1,2);
        System.out.println(uf.isSameSet(1, 2));

    }

}
