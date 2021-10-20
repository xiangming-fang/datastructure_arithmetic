package indi.xm.jy.array.Arrays.genericity;

/**
 * @author: albert.fang
 * @date: 2020/10/20 14:21
 * @description: 测试封装泛型的数组
 */
public class Array2Test {
    public static void main(String[] args) throws Exception {
        Array2<String> array2 = new Array2<>();
        array2.addFirst("支持泛型的数组");
        System.out.println(array2);
        array2.addLast("原来泛型这么简单");
        System.out.println(array2);
        array2.addLast("可以可以");
        System.out.println(array2);
        System.out.println(array2.contains("可以可以"));
        array2.add(2,"我想在2号索引位插入值");
        System.out.println(array2);
        array2.removeFirst();
        System.out.println(array2);
        array2.removeLast();
        System.out.println(array2);
    }
}
