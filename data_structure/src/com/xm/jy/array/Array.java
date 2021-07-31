package com.xm.jy.array;


/**
 * @ProjectName: datastructure_arithmetic
 * @Package: com.xm.jy.array.Arrays
 * @ClassName: Array
 * @Author: albert.fang
 * @Description: 动态数组
 * 1、支持泛型
 * 2、curd
 * 3、动态扩容 resize
 * @Date: 2021/7/29 16:38
 */
public class Array<E> {

    private int size;

    private E[] data;

    public Array(int capacity){
        if (capacity < 0){
            throw new IndexOutOfBoundsException("初始化数组容量异常：" + capacity);
        }
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    // 在指定下标出新增元素，插入位置到结束整体后移
    public void add(int index,E e){
        rangeCheckForAdd(index);
        resize(size + 1);
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size ++;
    }

    // 直接在末尾添加
    public void addLast(E e){
        add(size,e);
    }

    // 移除指定下标元素，将该下标右边元素整体左移
    public E remove(int index){
        rangeCheck(index);
        E e = data[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        // 让gc回收该空间
        data[size - 1] = null;
        resize(size - 1);
        size --;
        return e;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    // 变更指定下标的元素值
    public E set(int index,E e){
        rangeCheck(index);
        data[index] = e;
        return e;
    }

    public E setLast(E e){
        return set(size - 1,e);
    }

    public E setFirst(E e){
        return set(0,e);
    }

    // 返回指定下标的元素
    public E get(int index){
        rangeCheck(index);
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    // 返回动态数组，到底存储了几个元素
    public int getSize(){
        return size;
    }

    // 改变动态数组的大小
    // nowSize = data.size ++ 或者 data.size --
    private void resize(int nowSize){
        int newLength;
        E[] oldData = (E[])new Object[data.length];
        System.arraycopy(data,0,oldData,0,data.length);
        // 扩容50%
        if (nowSize > data.length){
            newLength = data.length + (data.length >> 1);
            if (newLength < nowSize){
                data = (E[])new Object[nowSize];
            }
            else{
                data = (E[])new Object[newLength];
            }
            System.arraycopy(oldData, 0, data, 0, oldData.length);
        }
        // 缩容50%
        else if (nowSize <= (data.length >> 1)){
            newLength = data.length >> 1;
            data = (E[])new Object[newLength];
            System.arraycopy(oldData,0,data,0, data.length);
        }
    }

    // rangeCheckForAdd
    private void rangeCheckForAdd(int index){
        if (index < 0 || index > getSize()){
            throw new IndexOutOfBoundsException(index + "下标越界");
        }
    }

    // rangeCheck
    private void rangeCheck(int index){
        if (index < 0 || index >= getSize()){
            throw new IndexOutOfBoundsException(index + "下标越界");
        }
    }

}
