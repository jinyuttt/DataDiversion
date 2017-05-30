/**    
 * 文件名：ControlHeart.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
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
 * 项目名称：DataDiversion    
 * 类名称：ControlHeart    
 * 类描述：    发送定时心跳
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 上午11:42:38    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 上午11:42:38    
 * 修改备注：    
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
    // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
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
     * 发送心跳
     */
    private void SendHeart()
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
        mclient.sendData(sIP, port, data);//通过组播发送控制器
       if(link.size()>0)
       {
           for(SysComModel model:link)
           {
               //发送给其它控制器
               client.sendData(model.UDPIP, model.UDPPort, data);
           }
       }
    }
}
