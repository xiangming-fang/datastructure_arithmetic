package indi.xm.jy.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先遍历的应用
 * 1、一个无向图中的联通分量个数
 * 2、联通分量中分别有哪些顶点
 * 3、两个点是否在一个图中可达
 */
public class CC {

    private Graph graph;

    // 记录图的节点是否访问过了,-1 -> 未被访问，其它访问过，具体值代表联通分量的编号
    private int isAccess[];

    // 联通分量个数
    private Integer ccCount = 0;

    // 用来存储联通分量的各个节点
    private List<Integer>[] ccList;

    public CC(Graph graph){
        this.graph = graph;
        isAccess = new int[graph.V()];
        for (Integer i = 0; i < graph.V(); i++) {
            isAccess[i] = -1;
        }
        // 对每个点都进行初始访问，并不是单单只是从0开始，要考虑一个图有多个联通分量的情况
        for (int v = 0; v < graph.V(); v ++){
            if (isAccess[v] == -1){
                dfs(v);
                ccCount++;
            }
        }
    }

    public Integer getCcCount(){
        return ccCount;
    }

    // 图中的各个联通分量分别有哪些节点
    public List<Integer>[] getCcList(){
        ccList = new ArrayList[ccCount];
        for (Integer ccId = 0; ccId < ccCount; ccId++) {
            ccList[ccId] = new ArrayList<>();
            for (Integer v = 0; v < graph.V(); v++) {
                if (isAccess[v] == ccId){
                    ccList[ccId].add(v);
                }
            }
        }
        return ccList;
    }

    // 图中两点是否可达
    public boolean isAccess(int w,int v){
        graph.validVertex(w);
        graph.validVertex(v);
        if (isAccess[w] == isAccess[v]) {
            return true;
        }
        return false;
    }

    private void dfs(int v){
        isAccess[v] = ccCount;
        for (Integer w : graph.hasEdge(v)) {
            if (isAccess[w] == -1) {
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new AdjTreeSet("data_structure/graph2.txt");
        CC graphDFS = new CC(graph);
        System.out.println(graphDFS.getCcCount());
        System.out.println(graphDFS.isAccess(3, 5));
        System.out.println(graphDFS.isAccess(0, 5));
        System.out.println(graphDFS.isAccess(1, 6));
        for (Integer i = 0; i < graphDFS.getCcCount(); i++) {
            System.out.println(graphDFS.getCcList()[i]);
        }
    }
}
