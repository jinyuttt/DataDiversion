/**    
 * �ļ�����ControlHeart.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package TimerTask;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import DataConfig.NetConfig;
import JNetSocket.MulticastClient;
import JNetSocket.UDPClient;
import SysInfo.SelfSysInfo;
import SysInfo.SysComModel;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlHeart    
 * ��������    ���Ͷ�ʱ����
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����11:42:38    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����11:42:38    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlHeart {
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
              SendHeart();
            }
        
        }, 3, 1, TimeUnit.SECONDS);
    }
    
    /*
     * ��������
     */
    public void SendHeart()
    {
        String sIP=NetConfig.getInstance().ControlMultCastIP;
        int port=NetConfig.getInstance().ControlMultCastPort;
        LinkedList<SysComModel> link=SelfSysInfo.Others;
        StringBuffer sbuf=new StringBuffer();
         sbuf.append(SelfSysInfo.SysInfo.IP);
         sbuf.append("#");
         sbuf.append(SelfSysInfo.SysInfo.port);
         sbuf.append("#");
         sbuf.append(SelfSysInfo.SysInfo.Name);
         sbuf.append("#");
         sbuf.append(SelfSysInfo.SysInfo.FlageID);
         sbuf.append("#");
         sbuf.append(SelfSysInfo.SysInfo.IsMaster);
        String info=sbuf.toString();
        byte[] data = null;
        try {
            data = info.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mclient.sendData(sIP, port, data);//ͨ���鲥���Ϳ�����
       if(link.size()>0)
       {
           for(SysComModel model:link)
           {
               //���͸�����������
               client.sendData(model.UDPIP, model.UDPPort, data);
           }
       }
    }
}