package indi.xm.jy.array.Arrays.genericity;

/**
 * @author: albert.fang
 * @date: 2020/10/20 12:55
 * @description: 进一步优化：让封装的该数组支持泛型
 */
public class Array2<E> {

    // 数组的实际大小
    private int size;

    // Array类里存储数据的数组引用
    private E[] data;

    // 构造函数指定数组的固定容量初始大小
    public Array2(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array2(){
        this(10);
    }

    // 对数组这种数据结构进行增、删、改、查操作

    // 在数组末尾增加
    public void addLast(E e) throws Exception {
        if (isFull()) {
            throw new Exception("数组已满");
        }
        add(size,e);
    }

    // 在数组头部增加
    public void addFirst(E e) throws Exception {
        if (isFull()) {
            throw new Exception("数组已满");
        }
        add(0,e);
    }

    // 在指定位置插入元素
    public void add(int index,E e) throws Exception {
        if (isFull()){
            throw new Exception("数组已满");
        }
        // 1、将要插入的位置到末尾，所有数据后移一位,注意移动的方式：从右向左
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        // 2、在要插入的位置改变值
        data[index] = e;
        // 3、size 自增
        size ++;
    }

    // 获取指定位置的元素
    public E get(int index) throws Exception {
        if (!indexIsLegal(index)) {
            throw new Exception("指定索引不合法");
        }
        return data[index];
    }

    // 修改指定位置的元素
    public void set(int index ,E e) throws Exception {
        if (!indexIsLegal(index)) {
            throw new Exception("指定索引不合法");
        }
        data[index] = e;
    }

    // 判断数组中是否包含某个元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找元素对应的索引（不考虑一个数组存在多个相同元素情况），不存在返回-1；
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 删除数组末尾元素
    public E removeLast() throws Exception {
        return remove(size - 1);
    }

    // 删除数组头部元素
    public E removeFirst() throws Exception {
        return remove(0);
    }

    // 删除指定下标的元素 （往左移动），并返回删除的元素
    public E remove(int index) throws Exception {
        if (isEmpty()){
            throw new Exception("数组为空，不可删除");
        }
        if (!indexIsLegal(index)) {
            throw new IllegalArgumentException("输入的下标不合法");
        }
        E result = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size --;
        return result;
    }


    // 判断数组存储的元素是否为空
    private boolean isEmpty(){
        return size == 0;
    }

    // 判断数组存储的元素是否达到最大容量（是否已满）
    private boolean isFull(){
        return size == data.length;
    }

    // 判断输入的索引是否合法
    private boolean indexIsLegal(int index){
        return index >= 0 && index < data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
