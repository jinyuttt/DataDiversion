/**    
 * 文件名：FWServer.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package SysInfo;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：FWServer    
 * 类描述：    存储服务信息
 * key：服务名称
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 上午1:22:47    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 上午1:22:47    
 * 修改备注：    
 * @version     
 *     
 */
public class FWServer {
    //空闲服务
    public static ConcurrentHashMap<String,LinkedList<ServerModel>> FreeServer=new ConcurrentHashMap<String,LinkedList<ServerModel>>();
    
    //所有服务
    public static ConcurrentHashMap<String,LinkedList<ServerModel>> FWInfo=new ConcurrentHashMap<String,LinkedList<ServerModel>>();
}
