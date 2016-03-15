package com.thread;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.file.WriteLog;

/**
 * <Description> <br>
 * 
 * @author zhang.liang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月11日 <br>
 * @since V1.0<br>
 * @see com.thread <br>
 */

public class SaleTickets extends Thread {

    static int ticketNums = 100000; //车票数

    /**
     * @param 线程名称，此处可以当作售票员的名称
     */
    public SaleTickets(String name) {
        super(name);
    }

    /**
     * Description: 执行售票线程<br>
     * 
     * @author zhang.liang<br>
     * @taskId <br>
     *         <br>
     */
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        while (true) {
            synchronized ("锁") { // 锁对象需要唯一共享，否则无效
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
        try {
            WriteLog.write("saleTickets.log", Thread.currentThread().getName()+"耗时："+result+"毫秒"+"\r\n");
            //WriteLog.write("saleTickets.log", Thread.currentThread().getName()+"耗时："+result+"毫秒,开始时间："+beginTime+",结束时间："+endTime+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
