package indi.xm.jy.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2021/4/15 10:02
 * @description: 无向无权图：邻接矩阵 表示
 */
public class AdjMatrix implements Graph {

    private int V;

    private int E;

    // 邻接矩阵，图的表示
    private int[][] graph;

    public AdjMatrix(String pathname){
        createGraph(pathname);
    }

    @Override
    public void validVertex(int w){
        if (w < 0 || w >= V) {
            throw new IllegalArgumentException("vertex " + w +"is invalid");
        }
    }

    @Override
    public void createGraph(String pathname) {
        File file = new File(pathname);
        try(Scanner scanner = new Scanner(file)){
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("vertex must gather zero");
            graph = new int[V][V];
            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("Edge must gather zero");
            for (int i = 0; i < E; i++){
                int a = scanner.nextInt();
                validVertex(a);
                int b = scanner.nextInt();
                validVertex(b);
                if (a == b) throw new IllegalArgumentException("self loop exist");
                if (graph[a][b] == 1) throw new IllegalArgumentException("occur parallel edge");
                graph[a][b] = 1;
                graph[b][a] = 1;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> hasEdge(int w){
        validVertex(w);
        List<Integer> result = new ArrayList<>();
        for (int i = 0;i < V ; i++){
            if (graph[w][i] == 1) result.add(i);
        }
        return result;
    }

    @Override
    public Integer degree(int w){
        return hasEdge(w).size();
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

    @Override
    public Integer V(){
        return V;
    }

    @Override
    public Integer E(){
        return E;
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("data_structure/graph.txt");
        System.out.println(adjMatrix.toString());
        System.out.println(adjMatrix.hasEdge(2));
        System.out.println(adjMatrix.degree(2));
    }
}
