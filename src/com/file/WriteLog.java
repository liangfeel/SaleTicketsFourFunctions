package com.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <Description> <br>
 * 
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.file <br>
 */

public class WriteLog {
    
    
    public static void write(String fileName, String content) throws IOException{
        File file = new File(fileName);
        //System.out.println(file.getPath());
        if (!file.exists()) { //如果文件不存在，则创建一个
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file,true);
        out.write(content.getBytes("utf-8"));
        out.close();
    }
    

}
