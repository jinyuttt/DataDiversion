/**    
 * �ļ�����DataCache.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package DataCache;


import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�DataCache    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����6:13:51    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����6:13:51    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class DataCache {
    //ID
    public static ConcurrentHashMap<String,Object> hashSocket=new ConcurrentHashMap<String,Object>();
    //��������
    public static ConcurrentHashMap<String,ArrayList<DataReMailing>>  fwData=new ConcurrentHashMap<String,ArrayList<DataReMailing>>();
    
    //ID���ظ�Ͷ�ݻ�ִ����
    public static ConcurrentHashMap<String,byte[]>  rspData=new ConcurrentHashMap<String,byte[]>();

}