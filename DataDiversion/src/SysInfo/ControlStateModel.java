/**    
 * 文件名：ControlState.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package SysInfo;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：ControlState    
 * 类描述：    控制器信息
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 上午2:04:44    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 上午2:04:44    
 * 修改备注：    
 * @version     
 *     
 */
public class ControlStateModel {
public String IP;//与ControlUDPIP一致
public int port;//ControlUDPPort
public String Name;
public boolean IsMaster;
public boolean IsAction=true;
public String FlageID;
public long FlashTime=0;
}
