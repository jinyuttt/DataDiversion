/**    
 * �ļ�����IDUnit.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package JCommonUnit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**    
 *     
 * ��Ŀ���ƣ�JCommon    
 * �����ƣ�IDUnit    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����11:03:09    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����11:03:09    
 * �޸ı�ע��    
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