/**    
 * 文件名：IDUnit.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package JCommonUnit;

import java.text.SimpleDateFormat;
import java.util.Date;


/**    
 *     
 * 项目名称：JCommon    
 * 类名称：IDUnit    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午11:03:09    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午11:03:09    
 * 修改备注：    
 * @version     
 *     
 */
public class IDUnit {
private static  int   autoingeger=0;
private static String baseID="";
public synchronized static String getID()
{
    SimpleDateFormat sdf=new SimpleDateFormat("MMddhhmmss");
    Date date = new Date();  
    int flage=(autoingeger++)%100000;
    String tim = sdf.format(date)+baseID+String.valueOf(flage);
    return tim;
 }
public static void InitID()
{
    SimpleDateFormat sdf=new SimpleDateFormat("MMddhhmmss");
    Date date = new Date();  
    baseID = sdf.format(date);
}
}
