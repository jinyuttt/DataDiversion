/**    
 * �ļ�����RspProcess.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
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
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�RspProcess    
 * ��������   ������ִ������ 
  * ����Э�飺��Դ+�������Ƴ���+��������+id����+id+����+data
  * ��Դ��0 ����� 1 �ͻ��� 2 ������
 * ���ͣ�0 ����ȷ�� 1ҵ�񷵻�����
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����8:05:03    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����8:05:03    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class RspProcess {
public void processData(String src,byte[]data)
{
    //�������Ƴ���+��������+id����+id+����+data
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
           //�����Ͷ�ݻ�ִ
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
            //�ͻ��˻��߿������յ����ݻ�ִ
            DataCache.DataCache.rspData.remove(id);
        }
       
    }
    else
    {
        //���ݷ���
        //����ǿͻ���
        //��ִͶ��
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
        Object obj=DataCache.DataCache.hashSocket.getOrDefault(id, null);
        ISocketClient clientcall=(ISocketClient) obj;
        clientcall.sendData(allData);
        //�����ִͶ����
        DataCache.DataCache.rspData.put(idy, allData);
    }
}
}