package indi.xm.jy.test;

import indi.xm.jy.unionfind.*;
import org.junit.Test;

import java.util.Random;

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

    @Test
    public void compareUF(){

        // UnionFind1 慢于 UnionFind2
//        int size = 100000;
//        int m = 10000;

        int size = 100000;
        int m = 100000;

//        QuickFind quickFind = new QuickFind(size);
//        System.out.println("QuickFind : " + testUF(quickFind, m) + " s");
//
//        QuickUnion quickUnion = new QuickUnion(size);
//        System.out.println("QuickUnion : " + testUF(quickUnion, m) + " s");
//
//        UnionFind1 uf1 = new UnionFind1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + " s");


    }


    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
