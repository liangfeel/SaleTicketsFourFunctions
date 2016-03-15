package com.file;

import java.io.IOException;

/**
 * <Description> <br>
 * 
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月14日 <br>
 * @since V1.0<br>
 * @see com.file <br>
 */

public class TestFileInfo {

    /**
     * Description: <br>
     * 
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String fileName = "saleTickets.log";
        FileOptions fileOptions = new FileOptions(fileName);
        long fileSize = fileOptions.getFileSize();
        if (fileSize == -1) {
            System.out.println("文件不存在");
        }else{
            System.out.println("文件的大小为："+fileSize+"字节");
            System.out.println("文件的大小为："+(fileSize/1024)+"KB");
            System.out.println("文件的大小为："+(((double)fileSize/1024)/1024)+"MB");
        }
        //获取文件行数
        int fileRows = fileOptions.getFileNumberOfRows();
        if (fileRows == -1) {
            System.out.println("文件不存在");
        }else{
            System.out.println("文件的行数为："+fileRows);
        }
        
    }

}
