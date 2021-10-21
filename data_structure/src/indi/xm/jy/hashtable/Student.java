package indi.xm.jy.hashtable;

import java.util.Objects;

/**
 * @ProjectName: datastructure_arithmetic
 * @Package: indi.xm.jy.hashtable
 * @ClassName: Student
 * @Author: albert.fang
 * @Description: 复合类型 - Student
 * @Date: 2021/10/21 12:03
 */
public class Student {

    private String name;
    private Integer id;

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }


    // 产生hash冲突的时候，用equals方法进行判断
    @Override
    public boolean equals(Object o) {
        // 判断是否是同一个引用
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
