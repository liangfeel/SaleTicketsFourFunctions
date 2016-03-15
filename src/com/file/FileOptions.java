package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** 
 * <Description> <br> 
 *  
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月14日 <br>
 * @since V1.0<br>
 * @see com.file <br>
 */

public class FileOptions {
    
    private String fileName;
    
    
    /** 
     * @param filename 
     */ 
    public FileOptions(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * 
     * Description: 获取文件大小，默认单位是字节<br> 
     *  
     * @author zhangliang<br>
     * @taskId <br>
     * @return 字节数<br>
     */
    public long getFileSize(){
        File file = new File(this.fileName);
        if(file.exists() && file.isFile()){
            return file.length();
        }else{
            return -1;
        }
    }
    
    public int getFileNumberOfRows() throws IOException{
        File file = new File(this.fileName);
        if(file.exists() && file.isFile()){
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int rows =0;
            while(bufferedReader.readLine() != null){
                rows++;
            }
            return rows;
        }else{
            return -1;
        }
    }

}
