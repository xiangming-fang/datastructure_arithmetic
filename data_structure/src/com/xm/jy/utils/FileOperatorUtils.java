package com.xm.jy.utils;

import java.util.LinkedList;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author: albert.fang
 * @date: 2021/4/21 14:42
 * @description: 文件工具类
 */
public class FileOperatorUtils {

    /**
     * 将一个文件的文字用list承接
     * @param filepath
     * @return
     */
    public static LinkedList<String> getWords(String filepath){
        LinkedList<String> result = new LinkedList<>();
        File file = new File(filepath);
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String words = scanner.nextLine().replace(".","")
                        .replace(",","").replace("\"","")
                        .replace(";","").replace("\n","")
                        .replace("?","").toLowerCase();
                for (String word : words.split(" ")) {
                    result.addFirst(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
