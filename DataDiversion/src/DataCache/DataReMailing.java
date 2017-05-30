/**    
 * 文件名：DataReMailing.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package DataCache;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：DataReMailing    
 * 类描述：    数据投递，保存需要重复投递的数据
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午7:21:42    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午7:21:42    
 * 修改备注：    
 * @version     
 *     
 */
public class DataReMailing {
    /*
     * 投递的数据
     */
public byte[] data;

/*
 * 上次发送时间
 */
public long lastSend=0;

/*
 * 投递计数
 * 尽最大努力投递
 */
public int count=0;

public byte qos=0;

public String id="";
}
