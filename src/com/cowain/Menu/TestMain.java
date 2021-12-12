package com.cowain.Menu;

import com.cowain.TestMethod.TestMethod;
import com.cowain.pojo.Student;

import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fxw
 */
public class TestMain {
    private static Scanner scanner=new Scanner(System.in);
    public static TestMain mainShow=new TestMain();
    private static TestMethod testMethod=new TestMethod();
    private static boolean flag=false;
    public static void main(String[] args) throws Exception {
        endTest();
    }
    public static  void  endTest(){
       while (!flag){
           System.out.println("请输入用户名");
           String username=scanner.next();
           System.out.println("请输入密码");
           String password=scanner.next();
           if ("123".equals(username)&&"123".equals(password)){
               testMain1();
           }
           else if ("321".equals(username)&&"321".equals(password)){
               testMain();
           } else{
               System.out.print("用户或密码错误，请重新输入!退出请按Y");
               System.out.println("退出Y/N");
               String str=scanner.next();
               switch (str)
               {
                   case "Y":
                       System.out.print("已退出当前系统,欢迎下次使用!");
                       flag=true;
                       break;
                   default:
                       break;
               }
           }
       }
    }
    public static void testMain1(){
        while (!flag){
            int choose = mainShow.showMenu1();
            switch (choose){
                case 0:
                    exits();
                    break;
                case 1:
                    queryStudent();
                    break;
                case 2:
                    insertStudent();
                    break;
                case 3:
                    deleteStudent();
                case 4:
                    System.out.println("欢迎来到切换用户界面");
                    endTest();
                    break;
                default:
                    System.out.println("输入有误请重新录入");
                    choose=scanner.nextInt();
                    break;
            }
        }
    }
    public static void testMain(){ while (!flag){
        int choose = mainShow.showMenu();
        switch (choose){
            case 0:
                extis();
                break;
            case 1:
                queryStudent();
                break;
            case 2:
                insertStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                System.out.println("请输入所修改的序号");
                int sno=scanner.nextInt();
                updatetStudent(sno);
                break;
            case 5:
                showStudentMessage();
                break;
            case  6:
                studentList();
                break;
            case 7:
                System.out.println("欢迎来到切换用户界面");
                endTest();
                break;
            default:
                System.out.println("输入有误请重新录入");
                choose=scanner.nextInt();
                break;
        }
    } }
    public int showMenu1(){
        System.out.println("----------欢迎来到学生管理系统------------");
        System.out.println("-------------1.使用查找功能---------------");
        System.out.println("-------------2.使用插入功能---------------");
        System.out.println("-------------3.使用删除功能---------------");
        System.out.println("-------------4.使用切换用户---------------");
        System.out.println("-------------0.使用退出功能---------------");
        System.out.println("请输入你的选项:"+"\n");
        int choose=  scanner.nextInt();
        return  choose;
    }
    public int showMenu(){
        System.out.println("----------欢迎来到学生管理系统------------");
        System.out.println("-------------1.使用查找功能---------------");
        System.out.println("-------------2.使用插入功能---------------");
        System.out.println("-------------3.使用删除功能---------------");
        System.out.println("-------------4.使用修改功能---------------");
        System.out.println("-------------5.使用浏览功能---------------");
        System.out.println("-------------6.使用排序功能---------------");
        System.out.println("-------------7.使用切换用户---------------");
        System.out.println("-------------0.使用退出功能---------------");
        System.out.println("请输入你的选项:"+"\n");
        int choose=  scanner.nextInt();
        return  choose;
    }
    public static boolean  exits(){
        System.out.println("-------------.使用退出功能---------------");
        System.out.println("确定要退出吗？Y/N");
        String select=scanner.next();
        if ("Y".equals(select)){
            return true;
        }
        else{
            return  false;
        }
    }
    public static void showStudentMessage(){
        System.out.println("-------------.使用浏览功能---------------");
        try {
            testMethod.showStudentMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertStudent(){
        System.out.println("-------------.使用插入功能---------------");
        System.out.println("请输入插入学生的序号");
        int studentSno=scanner.nextInt();
        System.out.println("请输入插入学生的学号");
        int studentID=scanner.nextInt();
        System.out.println("请输入插入学生的姓名");
        String studentName=scanner.next();
        System.out.println("请输入插入学生的性别");
        String studentSex=scanner.next();
        System.out.println("请输入插入学生的专业");
        String studentClass=scanner.next();
        System.out.println("请输入插入学生的英语");
        int English=scanner.nextInt();
        System.out.println("请输入插入学生的数学");
        int Math=scanner.nextInt();
        System.out.println("请输入插入学生的计算机");
        int computer=scanner.nextInt();
        Student student=new Student(studentSno,studentID,studentName,studentSex,studentClass,English,Math,computer);
        try {
            testMethod.insertStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void queryStudent(){
        System.out.println("-------------.使用查找功能---------------");
        System.out.println("请输入所所查询的学号:"+"\n");
        int num=scanner.nextInt();
        List<Student> list=null;
        try {
            list = testMethod.LoadMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("编号 学号 姓名 性别 系名 英语 数学 计算机 ");
        for (Student student : list) {
            if (num==student.getStudentSno()){
                System.out.println(student.getStudentSno()+" "+student.getStudentID()+" "+
                        student.getStudentName()+" "+student.getStudentSex()+" "+
                        student.getStudentClass()+" "+student.getEnglish()+" "+
                        student.getMath()+" "+student.getComputer());
            }
        }
    }
    public static void deleteStudent(){
        System.out.println("请输入删除的序号");
        int num=scanner.nextInt();
        boolean flag=  testMethod.deleteStudent(num);
        String message=" ";
        System.out.println(flag == true ? message = "删除成功！" : "删除失败");
    }
    public static void updatetStudent(int num){
        testMethod.deleteStudent(num);
        System.out.println("-------------.使用插入功能---------------");
        System.out.println("请输入所修改学生的序号");
        int studentSno=scanner.nextInt();
        System.out.println("请输入所修改学生的学号");
        int studentID=scanner.nextInt();
        System.out.println("请输入所修改学生的姓名");
        String studentName=scanner.next();
        System.out.println("请输入所修改学生的性别");
        String studentSex=scanner.next();
        System.out.println("请输入所修改学生的专业");
        String studentClass=scanner.next();
        System.out.println("请输入所修改学生的英语");
        int English=scanner.nextInt();
        System.out.println("请输入所修改学生的数学");
        int Math=scanner.nextInt();
        System.out.println("请输入所修改学生的计算机");
        int computer=scanner.nextInt();
        Student student=new Student(studentSno,studentID,studentName,studentSex,studentClass,English,Math,computer);
        try {
            testMethod.insertStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void studentList(){
        List<Student> list = testMethod.studentListSort();
        System.out.println("编号 学号 姓名 性别 系名 英语 数学 计算机 ");
        for (Student student : list) {
            System.out.println(student.getStudentSno() + " " + student.getStudentID() + " " +
                    student.getStudentName() + " " + student.getStudentSex() + " " +
                    student.getStudentClass() + " " + student.getEnglish() + " " +
                    student.getMath() + " " + student.getComputer());
        }
    }
    public  static void extis(){
        System.out.print("确定要退出系统吗？");
        System.out.println("退出Y/N");
        String str=scanner.next();
        switch (str)
        {
            case "Y":
                System.out.print("已退出当前系统,欢迎下次使用!");
                flag=true;
               break;
            default:
                break;
        }
    }
}
