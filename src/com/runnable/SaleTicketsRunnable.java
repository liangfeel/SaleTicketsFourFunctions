package com.runnable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.file.WriteLog;

/** 
 * <Description> <br> 
 *  
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月11日 <br>
 * @since V1.0<br>
 * @see com.runnable <br>
 */

public class SaleTicketsRunnable implements Runnable {
    
    int ticketNums = 100000;
    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br> <br>
     */ 
    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        while (true) {
            synchronized ("锁") {
                if (ticketNums > 0) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String strDate = simpleDateFormat.format(date);
                    String logInfo = Thread.currentThread().getName() + "在" + strDate + "时成功售出一张车票,车票号为：" + ticketNums+"\r\n";
                    System.out.println(logInfo);
                    try {
                        WriteLog.write("saleTickets.log", logInfo);
                        //Thread.sleep(100);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    ticketNums--;
                }
                else {
                    break;
                }
            }

        }   
        
        long endTime=System.currentTimeMillis();
        long result = endTime-beginTime;
        System.out.println(Thread.currentThread().getName()+"耗时："+result+"毫秒"+"\r\n");
        try {
            
            WriteLog.write("saleTickets.log", Thread.currentThread().getName()+"耗时："+result+"毫秒"+"\r\n");
            //WriteLog.write("saleTickets.log", Thread.currentThread().getName()+"耗时："+result+"毫秒,开始时间："+beginTime+",结束时间："+endTime+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
