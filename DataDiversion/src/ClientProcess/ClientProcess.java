/**    
 * 文件名：ClientProcess.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
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
 * 项目名称：DataDiversion    
 * 类名称：ClientProcess    
 * 类描述：    处理客户端请求
 * 描述：服务名称+数据
 * 数据： 1byte+1byte+data;
 *  0不返回1返回
 *  1只需投递即可
 *  2 必须准确投递
 *  3 尽最大努力投递
 *  
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午3:29:32    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午3:29:32    
 * 修改备注：    
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
     byte[]dst=new byte[len];//服务名称
     buf.get(dst);
     String fwName=new String(dst);
     int dlen=buf.limit()-buf.position();
    byte[]clientData=new byte[dlen];
    buf.get(clientData);
    byte rsp=clientData[0];//服务端也需要解析
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
