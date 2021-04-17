package com.xm.jy.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的深度优先遍历
 */
public class GraphDFS {

    private Graph graph;

    // 记录图的节点是否访问过了
    private boolean isAccess[];

    // 深度先序遍历结果
    private List preOrder = new ArrayList<Integer>();

    // 深度后序遍历结果
    private List postOrder = new ArrayList<Integer>();

    public GraphDFS(Graph graph){
        this.graph = graph;
        isAccess = new boolean[graph.V()];
        // 对每个点都进行初始访问，并不是单单只是从0开始，要考虑一个图有多个联通分量的情况
        for (int v = 0; v < graph.V(); v ++){
            if (!isAccess[v]){
                dfs(v);
            }
        }
    }

    private void dfs(int v){
        isAccess[v] = true;
        preOrder.add(v);
        for (Integer w : graph.hasEdge(v)) {
            if (!isAccess[w]){
                dfs(w);
            }
        }
        postOrder.add(v);
    }

    public static void main(String[] args) {
        Graph graph = new AdjTreeSet("data_structure/graph2.txt");
        GraphDFS graphDFS = new GraphDFS(graph);
        System.out.println(graphDFS.preOrder);
        System.out.println(graphDFS.postOrder);
    }
}
