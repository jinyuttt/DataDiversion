/**    
 * 文件名：SysSocket.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package SysInfo;

import java.util.concurrent.ConcurrentHashMap;


/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：SysSocket    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午4:49:22    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午4:49:22    
 * 修改备注：    
 * @version     
 *     
 */
public class SysSocket {
    public static ConcurrentHashMap<String,Class<?>> clientSocket=new ConcurrentHashMap<String,Class<?>>();
    public static ConcurrentHashMap<String,Class<?>> serverSocket=new ConcurrentHashMap<String,Class<?>>();
}
