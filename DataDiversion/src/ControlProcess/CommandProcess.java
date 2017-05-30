/**    
 * 文件名：CommandProcess.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package ControlProcess;

import SysInfo.ControlStateModel;
import SysInfo.ControlSys;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：CommandProcess    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午3:31:51    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午3:31:51    
 * 修改备注：    
 * @version     
 *     
 */
public class CommandProcess {
    
    /*
     * 处理控制器指令
     */
public void process(String src,byte[]data)
{
    String cmd=new String(data);
    String[]args=cmd.split("#");
    if(args[0]=="0")
    {
        //关闭控制器
        ControlStateModel model=   ControlSys.Control.getOrDefault(args[1], null);
        if(model!=null)
        {
            model.IsAction=false;
        }
        
    }
   
}
}
