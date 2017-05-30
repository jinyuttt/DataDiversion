/**    
 * 文件名：DataRspTimer.java    
 *    
 * 版本信息：    
 * 日期：2017年5月30日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package TimerTask;


import java.util.ArrayList;
import java.util.Iterator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import DataCache.DataReMailing;

import ISocket.ISocketClient;
import JNetSocket.MulticastClient;
import JNetSocket.UDPClient;
import ServerProcess.ServerDataTransfer;


/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：DataRspTimer    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月30日 下午11:53:40    
 * 修改人：jinyu    
 * 修改时间：2017年5月30日 下午11:53:40    
 * 修改备注：    
 * @version     
 *     
 */
public class DataRspTimer {
    //
    MulticastClient mclient=new MulticastClient();
    UDPClient client=new UDPClient();
    //
    ScheduledExecutorService service = Executors  
            .newSingleThreadScheduledExecutor();  
    // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
    public void Start()
    {
        service.scheduleAtFixedRate( new Runnable() {

            @Override
            public void run() {
                sendFwData();
            }
        
        }, 3, 1, TimeUnit.SECONDS);
    }
    public void startRsp()
    {
        service.scheduleAtFixedRate( new Runnable() {

            @Override
            public void run() {
                sendRsp();
            }
        
        }, 3, 1, TimeUnit.SECONDS);
    }
    /*
     * 发送投递的数据
     */
    private void sendFwData()
    {
        Iterator<String> it = DataCache.DataCache.fwData.keySet().iterator();
         while(it.hasNext()){
            String key = it.next();
            ArrayList<DataReMailing>  list=DataCache.DataCache.fwData.getOrDefault(key, null);
            if(list!=null)
            {
                for(int i=0;i<list.size();i++)
                {
                    DataReMailing e=  list.get(i);
                    ServerDataTransfer server=new ServerDataTransfer();
                    server.processData(null, key, e.data);
                    e.lastSend=System.currentTimeMillis();
                    e.count++;
                   if(e.qos==3&&e.count>5)
                   {
                       //尽最大努力
                       list.remove(i);
                   }
                }
            }
        }
      
    
    }
    
    /*
     * 发送回执的数据
     */
    private void  sendRsp()
    {
        Iterator<String> it = DataCache.DataCache.rspData.keySet().iterator();
        while(it.hasNext()){
           String key = it.next();
           byte[]  bytes=DataCache.DataCache.rspData.getOrDefault(key, null);
           if(bytes!=null)
           {
               Object obj=DataCache.DataCache.hashSocket.getOrDefault(key, null);
               if(obj!=null)
               {
                ISocketClient clientcall=(ISocketClient) obj;
                clientcall.sendData(bytes);
               }
           }
       }
     
    }
}
