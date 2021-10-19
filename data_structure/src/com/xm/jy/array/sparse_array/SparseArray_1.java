package com.xm.jy.array.sparse_array;

import java.io.*;

/**
 * @author: albert.fang
 * @date: 2020/7/31 13:46
 * @description: 稀疏数组：将稀疏数组存入磁盘（序列化）
 */
public class SparseArray_1 implements Serializable {
    public static void main(String[] args) {
        int[][] original1 = new int[11][11];
        original1[2][2] = 1;
        original1[3][3] = 2;
        // 将原数组转化成稀疏数组，需要得到元素组里有几个值
        int sum = 0;
        // 打印原数组
        for (int[] ints : original1) {
            for (int anInt : ints) {
                if (anInt != 0){
                    sum ++;
                }
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        // 创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = original1.length;
        sparseArray[0][1] = original1[0].length;
        sparseArray[0][2] = sum;
        for (int i = 0; i < original1.length; i++) {
            for (int j = 0; j < original1[i].length; j++) {
                if (original1[i][j] != 0){
                    sparseArray[sum][0] = i;
                    sparseArray[sum][1] = j;
                    sparseArray[sum][2] = original1[i][j];
                    sum--;
                }
            }
        }
        System.out.println("打印稀疏数组");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        // 将稀疏数组序列化到磁盘文件
        try {
            OutputStream ops = new FileOutputStream("src\\com\\xm\\jy\\array\\sparse_array\\array.txt");
            ObjectOutputStream oos = new ObjectOutputStream(ops);
            oos.writeObject(sparseArray);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
