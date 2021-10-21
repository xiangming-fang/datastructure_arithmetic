package indi.xm.jy.test;

import indi.xm.jy.hashtable.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.test
 * @ClassName: HashTest
 * @Author: albert.fang
 * @Description: 哈希表测试
 * @Date: 2021/10/21 11:59
 */
public class HashTest {

    /**
     * java 中的哈希函数 - hashcode
     */
    @Test
    public void testJavaHashCode(){

        // 键为整型
        int a = 54;
        System.out.println(((Integer)a).hashCode());
        int b = -54;
        System.out.println(((Integer)b).hashCode());

        // 键为浮点类型
        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        // 键为String类型
        String str = "方翔鸣";
        System.out.println(str.hashCode());

        // 键为复合类型
        Student student = new Student("fxm", 123);
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student,Integer> scores = new HashMap<>();
        scores.put(student,100);

        Student student2 = new Student("fxm", 123);
        System.out.println(student2.hashCode());
    }


    @Test
    public void testDelSymbol(){
//        System.out.println( -7 & 0x7FFFFFFF );
        int i = Integer.MAX_VALUE - 8;

    }
}
