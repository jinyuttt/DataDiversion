/**    
 * �ļ�����DataRspTimer.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��30��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
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
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�DataRspTimer    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��30�� ����11:53:40    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��30�� ����11:53:40    
 * �޸ı�ע��    
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
    // �ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊ��ʱִ�еļ��ʱ��  
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
     * ����Ͷ�ݵ�����
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
                       //�����Ŭ��
                       list.remove(i);
                   }
                }
            }
        }
      
    
    }
    
    /*
     * ���ͻ�ִ������
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