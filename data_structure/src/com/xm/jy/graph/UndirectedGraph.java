package com.xm.jy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2021/4/15 10:02
 * @description: 邻接矩阵表示 —— 无向无权图
 */
public class UndirectedGraph {

    private int V;

    private int E;

    // 邻接矩阵，图的表示
    private int[][] graph;

    public UndirectedGraph(String pathname){
        File file = new File(pathname);
        try(Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            graph = new int[V][V];
            E = scanner.nextInt();
            for (int i = 0; i < E; i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
         }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        System.out.printf("%d %d\n",V,E);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.printf("%d ",graph[i][j]);
            }
            System.out.print("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph("data_structure/graph.txt");
        System.out.println(undirectedGraph.toString());
    }
}
