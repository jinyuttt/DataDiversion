/**    
 * �ļ�����ControlSys.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

import java.util.concurrent.ConcurrentHashMap;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlSys    
 * �������� ��������Ϣ�洢
 * key  FlageID
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����2:54:07    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����2:54:07    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlSys {
    public static ConcurrentHashMap<String,ControlStateModel> Control=new ConcurrentHashMap<String,ControlStateModel>();
}