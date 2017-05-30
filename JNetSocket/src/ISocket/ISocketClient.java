/**    
 * �ļ�����ISocketClient.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package ISocket;

import java.net.SocketAddress;

/**    
 *     
 * ��Ŀ���ƣ�JNetSocket    
 * �����ƣ�ISocketClient    
 * ��������    �ͻ���ͨѶ
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����4:56:11    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����4:56:11    
 * �޸ı�ע��    
 * @version     
 *     
 */
public interface ISocketClient {
    public void sendData(String sIP,int sPort,byte[]data);
    public void sendData(SocketAddress local,String sIP,int sPort,byte[]data);
    //��Ҫ�����ݻش�
    public void sendData(byte[]data);
    public void setSocket(Object socket,String[] args);
    public void close();
    public byte[]  getCallBackData();
}