package com.runnable;

import java.io.IOException;

import com.file.WriteLog;

/** 
 * <Description> <br> 
 *  
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.runnable <br>
 */

public class TestRunnable {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        SaleTicketsRunnable saleTicketsRunnable = new SaleTicketsRunnable();
        //定义售票员
        Thread ticketsSeller1 = new Thread(saleTicketsRunnable,"售票员1");
        Thread ticketsSeller2 = new Thread(saleTicketsRunnable,"售票员2");
        Thread ticketsSeller3 = new Thread(saleTicketsRunnable,"售票员3");
        Thread ticketsSeller4 = new Thread(saleTicketsRunnable,"售票员4");
        //售票员开始上班
        ticketsSeller1.start();
        ticketsSeller2.start();
        ticketsSeller3.start();
        ticketsSeller4.start();
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"Runnable方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
