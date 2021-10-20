package indi.xm.jy.graph;

public interface Graph {
    // 建图
    void createGraph(String pathname);
    // 顶点有几条边
    Iterable<Integer> hasEdge(int w);
    // 顶点有几个相邻节点
    Integer degree(int w);
    // 顶点的合法性
    void validVertex(int w);
    // 图有几个顶点
    Integer V();
    // 图有几条边
    Integer E();
}
