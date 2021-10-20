package indi.xm.jy.unionfind;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.unionfind
 * @ClassName: UnionFind
 * @Author: albert.fang
 * @Description: 并查集：用来解决连接问题的数据结构
 * @Date: 2021/10/20 18:25
 */
public class UnionFind implements UF{

    // 并查集，具体value表示集合id
    private int[] id;

    public UnionFind(int size){
        id = new int[size];
        // 这样表示每一个元素在不同的集合编号里
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    // p、q 表示数组下标
    // value 集合id
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 取出节点p对应的集合id
    // quickFind O(1)
    private int find(int p){
        if (p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    // O(n)
    @Override
    public void unionElements(int p, int q) {
        if (!isConnected(p,q)){
            int res = id[p];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == id[q]) {
                    id[i] = res;
                }
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
