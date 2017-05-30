/**    
 * �ļ�����ISocketServer.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package ISocket;

import java.net.SocketAddress;

import JNetSocket.IRecData;

/**    
 *     
 * ��Ŀ���ƣ�JNetSocket    
 * �����ƣ�ISocketServer    
 * ��������    �����ͨѶ�ӿ�
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����4:55:12    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����4:55:12    
 * �޸ı�ע��    
 * @version     
 *     
 */
public interface ISocketServer {
    /*
     * ��ʼ��
     */
    public boolean InitServer(IRecData rec,String host,int port);
    
    /*
     * ʹ��socket����
     */
    public void sendData(String host,int port,byte[]data);
    public void sendData(SocketAddress addr,byte[]data);
    public void sendCall(byte[]data);
    public void close();
}
