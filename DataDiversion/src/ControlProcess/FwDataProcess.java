/**    
 * �ļ�����FwDataProcess.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package ControlProcess;

import java.util.LinkedList;

import SysInfo.FWServer;
import SysInfo.ServerModel;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�FwDataProcess    
 * ��������    ����������Ϣ
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����3:37:01    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����3:37:01    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class FwDataProcess {
public void processFW(String src,byte[]data)
{
    ServerModel model=new ServerModel();
     String fw=new String(data);
     model.AnysModel(fw);
     LinkedList<ServerModel> value=FWServer.FWInfo.getOrDefault(model.ServerName, null);
     if(value==null)
     {
         value=new LinkedList<ServerModel>();
         value.add(model);
         FWServer.FWInfo.put(model.ServerName, value);
     }
     else
     {
         //���û��������
         boolean isFind=false;
         for(ServerModel m:value)
         {
             if(m.equals(model))
             {
                 isFind=true;
                 break;
             }
         }
         if(!isFind)
         {
             value.add(model);
         }
     }
     
}
}