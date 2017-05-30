/**    
 * 文件名：ServerDataTransfer.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package ServerProcess;

import java.util.LinkedList;

import ISocket.ISocketClient;
import SysInfo.FWServer;
import SysInfo.ServerModel;
import SysInfo.SysSocket;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：ServerDataTransfer    
 * 类描述：   服务端交换数据 
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午4:42:19    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午4:42:19    
 * 修改备注：    
 * @version     
 *     
 */
public class ServerDataTransfer {
public void processData(String src,String name,byte[]data)
{
    LinkedList<ServerModel> link = FWServer.FreeServer.getOrDefault(name, null);
    ServerModel server=null;
    if(link==null)
    {
        //启用负载均衡
        
    }
    else
    {
        ServerModel model=link.removeFirst();
        server=model;
    }
    dataTransfer(server,data);
}

/*
 * 与服务端建立连接 
 */
private void   dataTransfer(ServerModel model,byte[]data)
{
    Class<?> cls=SysSocket.clientSocket.getOrDefault(model.ProtocolType, null);
    if(cls!=null)
    {
      try {
            ISocketClient client=  (ISocketClient) cls.newInstance();
            client.sendData(model.ServerIP, model.Port, data);
            client.close();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    }
}
}
