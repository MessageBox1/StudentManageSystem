package com.cowain.TestMethod;

import com.cowain.pojo.Student;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fxw
 */
public class TestMethod {
    private static String studentDelete;
    private static String[] studentMessage = new String[8];
    private static String[] newStudentMessage = new String[8];
    private static Scanner scanner = new Scanner(System.in);

    public static void Test1() throws IOException {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(1, 20080010, "丁勇", "男", "机械", 78, 63, 73);
        Student student2 = new Student(2, 20080010, "丁勇", "男", "机械", 78, 63, 73);
        Student student3 = new Student(3, 20080010, "丁勇", "男", "机械", 78, 63, 73);
        Collections.addAll(studentList, student1, student2, student3);
        writeFile(studentList);
    }

    //显示
    public static void showStudentMessage() throws Exception {

        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt"));

        //创建ArrayList集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //调用字符缓冲输入流对象的方法读数据
        String line;
        while ((line = br.readLine()) != null) {

            String[] strArray = line.split(",");

            //创建学生对象
            Student student = new Student();
            //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
            student.setStudentSno(Integer.parseInt(strArray[0]));
            student.setStudentID(Integer.parseInt(strArray[1]));
            student.setStudentName(strArray[2]);
            student.setStudentSex(strArray[3]);
            student.setStudentClass(strArray[4]);
            student.setEnglish(Integer.parseInt(strArray[5]));
            student.setMath(Integer.parseInt(strArray[6]));
            student.setComputer(Integer.parseInt(strArray[7]));

            array.add(student);
        }
        //释放资源
        br.close();
        //遍历集合
        System.out.println("编号 学号 姓名 性别 系名 英语 数学 计算机 ");
        for (Student student : array) {
            System.out.println(student.getStudentSno() + " " + student.getStudentID() + " " +
                    student.getStudentName() + " " + student.getStudentSex() + " " +
                    student.getStudentClass() + " " + student.getEnglish() + " " +
                    student.getMath() + " " + student.getComputer());
        }
    }

    public static void insertStudent(Student student1) throws IOException {
        List<Student> studentList = new ArrayList<>();
        Collections.addAll(studentList, student1);
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt", true));
        for (Student student : studentList) {
            StringBuilder sb = new StringBuilder();
            sb.append(student.getStudentSno()).append(",").append(student.getStudentID()).append(",").append(student.getStudentName()).append(",")
                    .append(student.getStudentSex()).append(",").append(student.getStudentClass()).append(",")
                    .append(student.getEnglish()).append(",").append(student.getMath()).append(",").append(student.getComputer());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static List<Student> LoadMessage()  {
        return LoadFine();
    }

    public static boolean deleteStudent(int num) {
        try {
            //创建字符缓冲输入流对象
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt"));

            ArrayList<Student> array = new ArrayList<Student>();

            //调用字符缓冲输入流对象的方法读数据
            String line;
            while ((line = br.readLine()) != null) {

                String[] strArray = line.split(",");
                //创建学生对象
                Student student = new Student();
                //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
                student.setStudentSno(Integer.parseInt(strArray[0]));
                student.setStudentID(Integer.parseInt(strArray[1]));
                student.setStudentName(strArray[2]);
                student.setStudentSex(strArray[3]);
                student.setStudentClass(strArray[4]);
                student.setEnglish(Integer.parseInt(strArray[5]));
                student.setMath(Integer.parseInt(strArray[6]));
                student.setComputer(Integer.parseInt(strArray[7]));
                array.add(student);
            }
            br.close();
            System.out.println("");
            for (Student student : array) {
                if (num == (student.getStudentSno())) {
                    array.remove(student);
                    BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt", false));
                    bw.write("");//执行删除操作，写入空内容覆盖之前的内容
                    bw.close();
                    break;
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt"));
            for (Student student : array) {
                StringBuilder sb = new StringBuilder();
                sb.append(student.getStudentSno()).append(",").append(student.getStudentID()).append(",").append(student.getStudentName()).append(",")
                        .append(student.getStudentSex()).append(",").append(student.getStudentClass()).append(",")
                        .append(student.getEnglish()).append(",").append(student.getMath()).append(",").append(student.getComputer());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            }
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Student> studentListSort() {
        List<Student> studentArrayList = LoadFine();
        Collections.sort(studentArrayList);
        return studentArrayList;
    }
    public static void writeFile(List<Student> array){
        BufferedWriter bw =null;
        try {
            bw= new BufferedWriter(new FileWriter("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt"));
            for (Student student : array) {
                StringBuilder sb = new StringBuilder();
                sb.append(student.getStudentSno()).append(",").append(student.getStudentID()).append(",").append(student.getStudentName()).append(",")
                        .append(student.getStudentSex()).append(",").append(student.getStudentClass()).append(",")
                        .append(student.getEnglish()).append(",").append(student.getMath()).append(",").append(student.getComputer());
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            if (bw!=null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static List<Student> LoadFine(){
        //创建字符缓冲输入流对象
        BufferedReader br=null;
        ArrayList<Student> array = new ArrayList<Student>();
        try {
            br= new BufferedReader(new FileReader("C:\\Users\\。\\Desktop\\C#学习\\studentMessage.txt"));
            //调用字符缓冲输入流对象的方法读数据
            String line;
            while ((line = br.readLine()) != null) {

                String[] strArray = line.split(",");

                //创建学生对象
                Student student = new Student();
                //把字符串数组中的每一个元素取出来对应的赋值给学生对象的成员变量值
                student.setStudentSno(Integer.parseInt(strArray[0]));
                student.setStudentID(Integer.parseInt(strArray[1]));
                student.setStudentName(strArray[2]);
                student.setStudentSex(strArray[3]);
                student.setStudentClass(strArray[4]);
                student.setEnglish(Integer.parseInt(strArray[5]));
                student.setMath(Integer.parseInt(strArray[6]));
                student.setComputer(Integer.parseInt(strArray[7]));

                array.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br!=null)
            {
                //释放资源
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return array;
    }
}
