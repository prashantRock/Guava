package com

import com.google.common.base.Objects;
/**
 * Created by prashant on 28/4/17.
 */
 public class HashCodeImplementation {

    public static void hashCodeExample() {
        Student s1 = new Student( 1, "abc");
        Student s2 = new Student( 1, "abc");
        System.out.println("equality for 2 objects ==============>>>>>>> > "+Objects.equal(s1, s2));
        System.out.println("s1 hashcode ==============>>>>>>> > "+s1.hashCode());
        System.out.println("s2 hashcode ==============>>>>>>> > "+s2.hashCode());
    }
}

class Student {
    private int rollNo;
    private String className;

    public Student( int rollNo, String className) {
        this.rollNo = rollNo;
        this.className = className;
    }


//    @Override //In Java
//    public int hashCode() {
//        int result = 1;
//        result = 31 * result + className.hashCode();
//        result = 31 * result + rollNo;
//        return result
//    }

    @Override
    public int hashCode() {
        return Objects.hashCode(className,rollNo);
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Student) || object == null){
            return false;
        }
        Student student = (Student)object;
        return Objects.equal(rollNo, student.rollNo)  && Objects.equal(className, student.className);// class name can be null
    }

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
}