package com.cowain.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: fxw
 */
public class test {
private static Scanner scanner=new Scanner(System.in);

    private static String bookDelete;
    private static String[] bookinf = new String[8];
   private static String[] bookinf1 = new String[8];

    public static void main(String[] args) throws IOException {
        deleteBook();
    }
    public static void deleteBook() throws IOException {
        File file = new File("C:\\Users\\。\\Desktop\\C#学习\\array.txt");
        FileInputStream intput = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(intput));
        String tempString;//定义一个字符串，每一次读出该行字符串内容
        List<String> list = new ArrayList<>();//定义一个list字符串集合用来储存每一行的字符串信息
        while ((tempString = reader.readLine()) != null) {
            list.add(tempString);
        }
        //遍历字符串集合
        for (String book : list) {
            bookinf = book.split(",");//将‘,‘作为分隔符，将字符串分隔开存放进入数组中
            System.out.print(bookinf[0] + " ");
        }
        System.out.println("");
        //输入要删除的内容
        System.out.println("请输入要删除的学生的序号：");
        Scanner scanner = new Scanner(System.in);
        bookDelete = scanner.next();


        for (String delBook : list) {
            bookinf1 = delBook.split(",");
            if (bookDelete.equals(bookinf1[1])) {
                list.remove(delBook);//在集合中删除该行
                FileWriter fd = new FileWriter(file, false);
                fd.write("");
                fd.close();
                break;
            }
        }
        for (String user : list) {
            bookinf1 = user.split(",");
            FileWriter fw = new FileWriter(file, true);
            fw.write(bookinf1[0] + "," + bookinf1[1] +
                    "," + bookinf1[2] + "," + bookinf1[3] +
                    "," + bookinf1[4] + "," + bookinf1[5] +
                    "," + bookinf1[6] + "," + bookinf1[7]);
            fw.write(System.getProperty("line.separator"));
            fw.close();
        }
        System.out.println("删除成功！");
    }
}
