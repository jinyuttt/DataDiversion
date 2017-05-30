/**    
 * �ļ�����ServerDataTransfer.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
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
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ServerDataTransfer    
 * ��������   ����˽������� 
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����4:42:19    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����4:42:19    
 * �޸ı�ע��    
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
        //���ø��ؾ���
        
    }
    else
    {
        ServerModel model=link.removeFirst();
        server=model;
    }
    dataTransfer(server,data);
}

/*
 * �����˽������� 
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