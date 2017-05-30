/**    
 * �ļ�����ClientListenter.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package NetListener;

import ClientProcess.ClientProcess;
import JNetSocket.IRecData;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ClientListenter    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����1:20:23    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����1:20:23    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ClientListenter implements IRecData {
    Object objSocket=null;
    /* (non-Javadoc)    
     * 
     */
    @Override
    public void recviceData(String src, byte[] data) {
        ClientProcess pro=new ClientProcess();
        pro.processData(src, data, objSocket);
    }

    /* (non-Javadoc)    
     * @see JNetSocket.IRecData#setServer(java.lang.Object)    
     */
    @Override
    public void setServer(Object socket) {
        objSocket=socket;
    }

}