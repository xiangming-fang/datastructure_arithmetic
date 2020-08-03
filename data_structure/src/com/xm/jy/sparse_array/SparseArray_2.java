package com.xm.jy.sparse_array;

import java.io.*;

/**
 * @author: albert.fang
 * @date: 2020/7/31 13:53
 * @description: 稀疏数组：将稀疏数组从磁盘读取到项目中（反序列化）
 */
public class SparseArray_2 implements Serializable{
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("E:\\IdeaProjects\\datastructure_arithmetic\\data_structure\\src\\com\\xm\\jy\\sparse_array\\array.txt");
            try {
                ObjectInputStream ois = new ObjectInputStream(is);
                int[][] readSparseArray = (int[][]) ois.readObject();
                // 打印从文件读取到的稀疏数组
                System.out.println("打印从文件读取到的稀疏数组");
                for (int[] ints : readSparseArray) {
                    for (int anInt : ints) {
                        System.out.print(anInt + "  ");
                    }
                    System.out.println();
                }
                // 将稀疏数组转成原数组
                int[][] original = new int[readSparseArray[0][0]][readSparseArray[0][1]];
                for (int i = 1; i < readSparseArray.length; i++) {
                    original[readSparseArray[i][0]][readSparseArray[i][1]] = readSparseArray[i][2];
                }
                // 打印原数组
                System.out.println("打印原数组");
                for (int[] ints : original) {
                    for (int anInt : ints) {
                        System.out.print(anInt + "  ");
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
