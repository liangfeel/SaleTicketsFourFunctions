
package com.thread;

import java.io.IOException;

import com.file.WriteLog;

/** 
 * <Description> <br> 
 *  
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月11日 <br>
 * @since V1.0<br>
 * @see com.thread <br>
 */

public class TestThread {

    /**
     * Description: 测试售票员售票<br> 
     *  
     * @author zhangliang<br>
     * @taskId <br>
     * @param args <br>
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        /*定义四个售票员*/
        SaleTickets ticketSeller1 = new SaleTickets("售票员1");
        SaleTickets ticketSeller2 = new SaleTickets("售票员2");
        SaleTickets ticketSeller3 = new SaleTickets("售票员3");
        SaleTickets ticketSeller4 = new SaleTickets("售票员4");
        //售票员开始工作
        ticketSeller1.start();
        ticketSeller2.start();
        ticketSeller3.start();
        ticketSeller4.start();
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"Thread方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
