/**    
 * �ļ�����ClientProcess.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package ClientProcess;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import DataCache.DataReMailing;
import DataConfig.NetConfig;
import JCommonUnit.IDUnit;
import ServerProcess.ServerDataTransfer;


/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ClientProcess    
 * ��������    �����ͻ�������
 * ��������������+����
 * ���ݣ� 1byte+1byte+data;
 *  0������1����
 *  1ֻ��Ͷ�ݼ���
 *  2 ����׼ȷͶ��
 *  3 �����Ŭ��Ͷ��
 *  
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����3:29:32    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����3:29:32    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ClientProcess {
    String id="33333";
public void processData(String src,byte[]data,Object objSocket)
{
    id=IDUnit.getID();
     ByteBuffer buf=ByteBuffer .wrap(data);
     buf.flip();
     int len=buf.getInt();
     byte[]dst=new byte[len];//��������
     buf.get(dst);
     String fwName=new String(dst);
     int dlen=buf.limit()-buf.position();
    byte[]clientData=new byte[dlen];
    buf.get(clientData);
    byte rsp=clientData[0];//�����Ҳ��Ҫ����
    byte qos=clientData[1];
    byte[]head=addHead();
    byte[] allData=new byte[head.length+clientData.length];
    System.arraycopy(head, 0, allData, 0, head.length);
    System.arraycopy(clientData, 0, allData, head.length, clientData.length);
    
    if(rsp==1)
    {
        DataCache.DataCache.hashSocket.put(id, objSocket);
    }
    if(qos>1)
    {
      ArrayList<DataReMailing>  list=DataCache.DataCache.fwData.getOrDefault(fwName, null);
       if(list==null)
       {
           list=new  ArrayList<DataReMailing>();
           DataReMailing rem=new DataReMailing();
           rem.id=id;
           rem.count=1;
           rem.data=allData;
           rem.lastSend=System.currentTimeMillis();
           rem.qos=qos;
       }
    }
    ServerDataTransfer server=new ServerDataTransfer();
    server.processData(src, fwName, allData);
}
private byte[]  addHead()
{
  
    String ip=NetConfig.getInstance().ControlRspMultCastIP;
    String host=NetConfig.getInstance().ControlRspUDPIP;
    int port=NetConfig.getInstance().ControlRspMultCastPort;
    int uport=NetConfig.getInstance().ControlRspUDPPort;
   
    StringBuffer buf=new StringBuffer();
    buf.append(id);
    buf.append("#");
    buf.append(ip);
    buf.append("#");
    buf.append(port);
    buf.append("#");
    buf.append(host);
    buf.append("#");
    buf.append(uport);
    String hostInfo=buf.toString();
    byte[]data=null;
   try {
    data=hostInfo.getBytes("utf-8");
} catch (UnsupportedEncodingException e) {
  
    e.printStackTrace();
}
    
    return data;
    
}
}