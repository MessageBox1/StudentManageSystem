package com.cowain.pojo;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author: fxw
 */
public class Student implements Serializable , Comparable<Student> {

    private Integer studentSno;
    private Integer studentID;
    private String studentName;
    private String studentSex;
    private String studentClass;
    private Integer English;
    private Integer Math;
    private Integer Computer;

    public Student() {
    }
    public Student(Integer studentSno, Integer studentID, String studentName, String studentSex,
                   String studentClass, Integer english, Integer math, Integer computer) {
        this.studentSno = studentSno;
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentClass = studentClass;
        English = english;
        Math = math;
        Computer = computer;
    }
        @Override
    public String toString() {
        return  studentSno +
                  studentID +
                    studentName +
                    studentSex  +
                    studentClass +
                    English +
                    Math +
                    Computer;
    }

    public void setStudentSno(Integer studentSno) {
        this.studentSno = studentSno;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setEnglish(Integer english) {
        English = english;
    }

    public void setMath(Integer math) {
        Math = math;
    }

    public void setComputer(Integer computer) {
        Computer = computer;
    }

    public Integer getStudentSno() {
        return studentSno;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public Integer getEnglish() {
        return English;
    }

    public Integer getMath() {
        return Math;
    }

    public Integer getComputer() {
        return Computer;
    }

    @Override
    public int compareTo(Student o) {
        return this.getStudentSno()-o.getStudentSno()==0?this.getStudentID()-o.getStudentID():this.getStudentSno()-o.getStudentSno();
    }
}
