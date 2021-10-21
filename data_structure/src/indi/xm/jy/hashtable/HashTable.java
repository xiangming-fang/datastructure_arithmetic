package indi.xm.jy.hashtable;


import java.util.TreeMap;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.hashtable
 * @ClassName: HashTable
 * @Author: albert.fang
 * @Description: 实现自己的哈希表
 * @Date: 2021/10/21 13:02
 */
public class HashTable<K,V> {

    // hashtable
    private TreeMap<K,V>[] hashtable;

    // 大整数的这个M素数取模
    // 数组大小
    private int M;

    private int size;

    // 平均每一个位置的元素大于容忍上限，进行扩容
    private static final int upperTol = 10;

    // 平均每一个位置的元素小于容忍下限，进行缩容
    private static final int lowerTol = 2;

    // 初始容量
    private static final int initCapacity = 7;

    public HashTable(int M){
        this.M = initCapacity;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(97);
    }

    // 哈希函数
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        // 通过hash函数，将key 转成 数组的索引
        int index = hash(key);
        // 如果key对应的index位置的treemap
        TreeMap<K, V> map = hashtable[index];
        // treemap 已经包含这个key了，那么替换value
        if (map.containsKey(key)) {
            map.put(key,value);
        }
        // 不包含直接加入
        else {
            map.put(key,value);
            size ++;

            // size/m >= upperTol
            if (size >= upperTol * M){
                resize(2 * M);
            }
        }
    }

    public V remove(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        V res = null;
        if (map.containsKey(key)){
            res = map.remove(key);
            size --;

            // size/m < lowerTol
            // 注意边界处理，不管怎么缩容，不能小于initCapacity
            if (size < lowerTol * M && M / 2 >= initCapacity){
                resize(2 * M);
            }
        }
        return res;
    }

    public void set(K key,V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)){
            // 压根没有这个key，你怎么修改哦
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        map.put(key,value);
    }

    public boolean contains(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        return map.containsKey(key);
    }

    public V get(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)){
            // 压根没有这个key，你怎么获取哦
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        return map.get(key);
    }

    private void resize(int newM){

        TreeMap<K,V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        // 保存一份 oldM 用于遍历
        int oldM = M;
        // 为了重新计算hash
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            // 遍历map中所有元素
            for (K k : map.keySet()) {
                newHashTable[hash(k)].put(k,map.get(k));
            }
        }

        this.hashtable = newHashTable;
    }

}
