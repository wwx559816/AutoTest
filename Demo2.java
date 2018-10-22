import java.io.*;

public class Demo2 {

    private  static  int num=1;

    public static void main(String[] args) throws Exception {
        // source 文件夹
        File start = new File("C:\\Users\\Administrator\\Desktop\\test");
        // target 文件夹
        File end = new File("C:\\Users\\Administrator\\Desktop\\copy");

        if(!end.exists()){
            end.mkdir();
        }
        copyFolder(start,end);
    }
    private static void copyFolder(File start, File end) throws Exception {
        if(start.isDirectory()){
            File[] f = start.listFiles();
            for(File file : f){
                copyFolder(file,end);
            }
        }else {
            File newfile = new File(end, ""+num++);
            copyfile(start, newfile);
        }
    }
    private static void copyfile(File start, File newfile) throws Exception{
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(start));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(newfile));

        //获取数据
        byte[] by = new byte[1024];
        int len = 0;
        while((len = bi.read(by)) != -1){
            bo.write(by,0,len);
        }
        bi.close();
        bo.close();
    }
}
