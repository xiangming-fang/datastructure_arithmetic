package com.xm.jy.graph;

import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2021/4/16 13:22
 * @description: 无向无权图：邻接表 表示
 */
public class AdjList {
    private int V;

    private int E;

    private LinkedList<Integer>[] graph;

    public AdjList(String pathname){
        File file = new File(pathname);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V is must gather zero");
            graph = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new LinkedList();
            }
            E = scanner.nextInt();
            if (E < 0 ) throw new IllegalArgumentException("E is must gather zero");
            for (int i = 0;i < E;i++){
                int a = scanner.nextInt();
                vaildVertex(a);
                int b = scanner.nextInt();
                vaildVertex(b);
                if (a == b) throw new IllegalArgumentException("self loop exist");
                if (graph[a].contains(b)) throw new IllegalArgumentException("occur parallel edge");
                graph[a].add(b);
                graph[b].add(a);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void vaildVertex(int w){
        if (w < 0 || w >= V) throw new IllegalArgumentException("vertex " + w + " is invalid");
    }

    public List hasEdge(int w){
        vaildVertex(w);
        return graph[w];
    }

    public int degree(int w){
        return hasEdge(w).size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        System.out.printf("V: %d,E: %d\n",V,E);
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": ");
            for (Integer vertex : graph[i]) {
                System.out.print(vertex + " ");
            }
            System.out.print("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjList adjList = new AdjList("data_structure/graph.txt");
        System.out.println(adjList.toString());
        System.out.println(adjList.hasEdge(2));
        System.out.println(adjList.degree(2));
    }


}
