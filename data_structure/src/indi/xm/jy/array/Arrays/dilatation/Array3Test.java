package indi.xm.jy.array.Arrays.dilatation;

/**
 * @author: albert.fang
 * @date: 2020/10/20 14:37
 * @description: 动态数组的实现测试
 */
public class Array3Test {
    public static void main(String[] args) throws Exception {
        Array3<Integer> array3 = new Array3<>();
        System.out.println(array3.getCapacity());
        array3.addLast(2);
        System.out.println(array3.getCapacity());
        array3.removeLast();
        System.out.println(array3.getCapacity());
        array3.addFirst(34);
        System.out.println(array3.getCapacity());
    }
}
