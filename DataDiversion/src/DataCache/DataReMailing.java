/**    
 * �ļ�����DataReMailing.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package DataCache;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�DataReMailing    
 * ��������    ����Ͷ�ݣ�������Ҫ�ظ�Ͷ�ݵ�����
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����7:21:42    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����7:21:42    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class DataReMailing {
    /*
     * Ͷ�ݵ�����
     */
public byte[] data;

/*
 * �ϴη���ʱ��
 */
public long lastSend=0;

/*
 * Ͷ�ݼ���
 * �����Ŭ��Ͷ��
 */
public int count=0;

public byte qos=0;

public String id="";
}