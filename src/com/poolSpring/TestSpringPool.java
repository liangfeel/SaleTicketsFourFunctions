package com.poolSpring;

import java.io.IOException;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.file.WriteLog;
import com.runnable.SaleTicketsRunnable;
import com.thread.SaleTickets;

/** 
 * <Description> <br> 
 *  
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.poolSpring <br>
 */

public class TestSpringPool {
    public static void main(String[] args) {
        TaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        //SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        //定义四个售票员
        Thread ticketsSeller1 = new SaleTickets("售票员1");
        Thread ticketsSeller2 = new SaleTickets("售票员2");
        Thread ticketsSeller3 = new SaleTickets("售票员3");
        Thread ticketsSeller4 = new SaleTickets("售票员4");
        
        simpleAsyncTaskExecutor.execute(ticketsSeller1);
        simpleAsyncTaskExecutor.execute(ticketsSeller2);
        simpleAsyncTaskExecutor.execute(ticketsSeller3);
        simpleAsyncTaskExecutor.execute(ticketsSeller4);
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"SimpleAsyncTaskExecutor方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
