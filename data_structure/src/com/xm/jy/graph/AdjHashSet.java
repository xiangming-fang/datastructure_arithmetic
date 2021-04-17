package com.xm.jy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2021/4/16 22:34
 * @description: 无向无权图：邻接表(HashSet 哈希表)
 */
public class AdjHashSet implements Graph {
    private int V;

    private int E;

    private HashSet<Integer>[] graph;

    public AdjHashSet(String pathname){
        createGraph(pathname);
    }

    @Override
    public void validVertex(int w){
        if (w < 0 || w >= V) throw new IllegalArgumentException("vertex " + w + " is invalid");
    }

    @Override
    public void createGraph(String pathname) {
        File file = new File(pathname);
        try (Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V is must gather zero");
            graph = new HashSet[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new HashSet<>();
            }
            E = scanner.nextInt();
            if (E < 0 ) throw new IllegalArgumentException("E is must gather zero");
            for (int i = 0;i < E;i++){
                int a = scanner.nextInt();
                validVertex(a);
                int b = scanner.nextInt();
                validVertex(b);
                if (a == b) throw new IllegalArgumentException("self loop exist");
                if (graph[a].contains(b)) throw new IllegalArgumentException("occur parallel edge");
                graph[a].add(b);
                graph[b].add(a);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Integer> hasEdge(int w){
        validVertex(w);
        return graph[w];
    }

    @Override
    public Integer degree(int w){
        validVertex(w);
        return graph[w].size();
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

    @Override
    public Integer V(){
        return V;
    }

    @Override
    public Integer E(){
        return E;
    }

    public static void main(String[] args) {
        AdjHashSet adjHash = new AdjHashSet("data_structure/graph.txt");
        System.out.println(adjHash.toString());
        System.out.println(adjHash.hasEdge(2));
        System.out.println(adjHash.degree(2));
    }


}
