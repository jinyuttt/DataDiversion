/**    
 * �ļ�����FWListenter.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package NetListener;

import ControlProcess.FwDataProcess;
import JNetSocket.IRecData;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�FWListenter    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����1:12:23    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����1:12:23    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class FWListenter implements IRecData {

    /* (non-Javadoc)    
     * @see JNetSocket.IRecData#recviceData(java.lang.String, byte[])    
     */
    @Override
    public void recviceData(String src, byte[] data) {
        FwDataProcess pro=new FwDataProcess();
        pro.processFW(src, data);

    }

    /* (non-Javadoc)    
     * @see JNetSocket.IRecData#setServer(java.lang.Object)    
     */
    @Override
    public void setServer(Object socket) {
        // TODO Auto-generated method stub

    }

}