/**    
 * �ļ�����FWServer.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�FWServer    
 * ��������    �洢������Ϣ
 * key����������
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����1:22:47    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����1:22:47    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class FWServer {
    //���з���
    public static ConcurrentHashMap<String,LinkedList<ServerModel>> FreeServer=new ConcurrentHashMap<String,LinkedList<ServerModel>>();
    
    //���з���
    public static ConcurrentHashMap<String,LinkedList<ServerModel>> FWInfo=new ConcurrentHashMap<String,LinkedList<ServerModel>>();
}