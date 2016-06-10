/**
 * 使用list列出指定目录的全部文件
 * */
import java.io.*;
class ListFiles{
    public static void main(String[] args) {
        String fileName="D:"+File.separator;
        File f=new File(fileName);
        String[] str=f.list();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        
        //使用list返回的是String数组，。而且列出的不是完整路径，如果想列出完整路径的话，需要使用listFiles.他返回的是File的数组
        File f=new File(fileName);
        File[] str=f.listFiles();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
