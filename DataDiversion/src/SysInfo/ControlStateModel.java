/**    
 * �ļ�����ControlState.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlState    
 * ��������    ��������Ϣ
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����2:04:44    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����2:04:44    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlStateModel {
public String IP;//��ControlUDPIPһ��
public int port;//ControlUDPPort
public String Name;
public boolean IsMaster;
public boolean IsAction=true;
public String FlageID;
public long FlashTime=0;
}