package indi.xm.jy.unionfind;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.unionfind
 * @ClassName: UF
 * @Author: albert.fang
 * @Description: 并查集接口
 * @Date: 2021/10/20 18:34
 */
public interface UF {

    /**
     * 判断两个节点是否是连接的
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p,int q);

    /**
     * 将两个点连接起来
     * @param p
     * @param q
     */
    void unionElements(int p,int q);

    /**
     * 并查集中有几个节点
     *
     * @return
     */
    int getSize();
}
