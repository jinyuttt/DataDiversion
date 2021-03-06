/**    
 * 文件名：RspProcess.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package ControlProcess;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import DataCache.DataReMailing;
import ISocket.ISocketClient;
import JCommonUnit.IDUnit;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：RspProcess    
 * 类描述：   处理回执的数据 
  * 数据协议：来源+服务名称长度+服务名称+id长度+id+类型+data
  * 来源：0 服务端 1 客户端 2 控制器
 * 类型：0 接收确认 1业务返回数据
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午8:05:03    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午8:05:03    
 * 修改备注：    
 * @version     
 *     
 */
public class RspProcess {
public void processData(String src,byte[]data)
{
    //服务名称长度+服务名称+id长度+id+类型+data
    ByteBuffer buf=ByteBuffer.wrap(data);
    byte srcType=buf.get();
    int nameLen=buf.getInt();
    byte[]fwName=new byte[nameLen];
    buf.get(fwName);
    int idlen=buf.getInt();
    byte[]idbyte=new byte[idlen];
    buf.get(idbyte);
    String id=new String(idbyte);
    String name=new String(fwName);
    byte type=buf.get();
    if(type==0)
    {
        if(srcType==0)
        {
           //服务端投递回执
       ArrayList<DataReMailing> list=DataCache.DataCache.fwData.getOrDefault(name, null);
       if(list!=null)
       {
             for(int i=0;i<list.size();i++)  
             {
                 if(list.get(i).id.equals(id))
                 {
                     list.remove(i);
                     break;
                 }
             }
       }
       buf.clear();
        }
        else
        {
            //客户端或者控制器收到数据回执
            DataCache.DataCache.rspData.remove(id);
        }
       
    }
    else
    {
        //数据返回
        //如果是客户端
        //回执投递
        String idy=IDUnit.getID();
        byte[]head=null;
        try {
           head=idy.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] ywdata=new byte[buf.limit()-buf.position()];
        buf.get(ywdata);
        byte[]allData=new byte[head.length+ywdata.length];
        System.arraycopy(head, 0, allData, 0, head.length);
        System.arraycopy(ywdata, 0, allData,head.length, ywdata.length);
        //取出返回数据返回
        Object obj=DataCache.DataCache.hashSocket.remove(id);
        ISocketClient clientcall=(ISocketClient) obj;
        clientcall.sendData(allData);
        //放入回执投递中
        DataCache.DataCache.rspData.put(idy, allData);
        DataCache.DataCache.hashSocket.put(idy, obj);
        //回执地址转移
    }
}
}
