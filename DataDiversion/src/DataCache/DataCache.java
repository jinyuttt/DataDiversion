/**    
 * 文件名：DataCache.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package DataCache;


import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：DataCache    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午6:13:51    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午6:13:51    
 * 修改备注：    
 * @version     
 *     
 */
public class DataCache {
    //ID
    public static ConcurrentHashMap<String,Object> hashSocket=new ConcurrentHashMap<String,Object>();
    //服务名称
    public static ConcurrentHashMap<String,ArrayList<DataReMailing>>  fwData=new ConcurrentHashMap<String,ArrayList<DataReMailing>>();
    
    //ID，重复投递回执数据
    public static ConcurrentHashMap<String,byte[]>  rspData=new ConcurrentHashMap<String,byte[]>();

}
