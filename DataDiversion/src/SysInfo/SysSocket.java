/**    
 * �ļ�����SysSocket.java    
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
 * �����ƣ�SysSocket    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����4:49:22    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����4:49:22    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class SysSocket {
    public static ConcurrentHashMap<String,Class<?>> clientSocket=new ConcurrentHashMap<String,Class<?>>();
    public static ConcurrentHashMap<String,Class<?>> serverSocket=new ConcurrentHashMap<String,Class<?>>();
}
