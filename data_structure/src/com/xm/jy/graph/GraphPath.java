package com.xm.jy.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 图的深度优先遍历
 */
public class GraphPath {

    private Graph graph;

    // 单源点
    private int s;

    // 记录相应节点的父亲节点是哪个
    private int parents[];


    // 单点（s）路径
    public GraphPath(Graph graph,int s){
        this.graph = graph;
        this.s = s;
        parents = new int[graph.V()];
        for (Integer i = 0; i < graph.V(); i++) {
            parents[i] = -1;
        }
        dfs(s,s);
    }

    // 记录点v上一个节点是parent
    // 也就是路径parent -> v
    private void dfs(int v,int parent){
        parents[v] = parent;
        for (Integer w : graph.hasEdge(v)) {
            if (parents[w] == -1){
                dfs(w,v);
            }
        }
    }

    // 单源点s是否可以到大点w
    private boolean isConnected(int t){
        return parents[t] != -1;
    }

    // 单源点s到达目标节点w的路径
    // 0(s) -> 4 -> 2(t)
    public String path(int t){
        if (!isConnected(t)) {
            return "";
        }
        ArrayList<Integer> result = new ArrayList();
        while (parents[t] != s){
            result.add(parents[t]);
            t = parents[t];
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (Integer w : result) {
            sb.append(w).append(" -> ");
        }
//        return sb.substring(0,sb.length() - 4);
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new AdjTreeSet("data_structure/graph3.txt");
        GraphPath graphPath = new GraphPath(graph,0);
        System.out.println(graphPath.path(4));
    }
}
