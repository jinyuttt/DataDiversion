/**    
 * 文件名：ControlDataChange.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package SysInfo;

import ClientProcess.ClientProcess;
import ControlProcess.CommandProcess;
import ControlProcess.FwDataProcess;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：ControlDataChange    
 * 类描述：    处理控制器间的数据
 * 0 心跳 1客户端请求数据转移  2 服务信息交换 3 指令
 * 协议格式：类型+byte[]
 * 服务数据协议:服务名称长度+data;
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午3:14:53    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午3:14:53    
 * 修改备注：    
 * @version     
 *     
 */
public class ControlDataChange {
    public Object objSocket=null;
public void  controlData(String src,byte[]data)
{
    byte type=data[0];
    byte[]srcData=new byte[data.length-1];
    System.arraycopy(data, 1, srcData, 0, srcData.length);
    switch(type)
    {
    case   0:
             procesHeart(src,srcData);
         break;
    case 1:
        processClient(src,srcData);
        break;
    case 2:
        processFW(src,srcData);
        break;
    case 3:
        processControl(src,srcData);
        break;
        
    }
  
}
private void procesHeart(String src,byte[]data)
{
    String info=new String(data);
    String[] args=info.split("#");
    ControlStateModel model=new ControlStateModel();      
   model.IP=args[0];
   model.port=Integer.parseInt(args[1]);
   model.Name=args[2];
   model.FlageID=args[3];
   model.IsMaster=Boolean.parseBoolean(args[4]);
   model.FlashTime=System.currentTimeMillis();
   model.IsAction=true;
   ControlSys.Control.put(model.FlageID, model);
   if(model.IP=="host"||model.IP.isEmpty())
   {
        String[] addr=src.split(":");
        model.IP=addr[0];
   }
   ControlSys.Control.put(model.FlageID, model);
}
private void processClient(String src,byte[]data)
{
    //向服务端发送数据
    ClientProcess client=new ClientProcess();
    client.processData(src, data,this.objSocket);
}
private void processControl(String src,byte[]data)
{
    CommandProcess cmd=new CommandProcess();
    cmd.process(src, data);
}
private void processFW(String src,byte[]data)
{
    FwDataProcess  pro=new FwDataProcess();
    pro.processFW(src, data);
}
}
