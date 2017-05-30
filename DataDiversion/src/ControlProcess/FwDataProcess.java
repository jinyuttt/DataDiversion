/**    
 * 文件名：FwDataProcess.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package ControlProcess;

import java.util.LinkedList;

import SysInfo.FWServer;
import SysInfo.ServerModel;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：FwDataProcess    
 * 类描述：    交换服务信息
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午3:37:01    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午3:37:01    
 * 修改备注：    
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
         //如果没有则添加
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
