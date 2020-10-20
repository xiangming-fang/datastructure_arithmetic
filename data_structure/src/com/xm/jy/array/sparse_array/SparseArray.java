package com.xm.jy.array.sparse_array;

/**
 * @author: albert.fang
 * @date: 2020/7/31 13:09
 * @description: 稀疏数组：一个二维数据里有好多相同的数据，这时候可以用另外一个二维数组来表示这个数组。
 * 该二维数组叫做稀疏数组，稀疏数组里的元素比之前的要少，用三列存储，第一列表示原先的行数，第二列表示原先的列数，第三列表示原先数组总共有多少值
 */
public class SparseArray {
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
        // 再将稀疏数组转成原数组
        int[][] original2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            original2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 将原数组重新打印
        System.out.println("打印原数组");
        for (int[] ints : original2) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
}
