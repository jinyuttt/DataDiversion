/**    
 * �ļ�����ControlStateListenter.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package NetListener;

import JNetSocket.IRecData;
import SysInfo.ControlDataChange;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlStateListenter    
 * ��������    ���տ�����������
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����2:50:56    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����2:50:56    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlStateListenter implements IRecData {
    ControlDataChange exchange=new ControlDataChange();
    /* (non-Javadoc)    
     * �������� 
     */
    @Override
    public void recviceData(String src, byte[] data) {
        exchange.controlData(src, data);
       
    }

    /* (non-Javadoc)    
     *
     */
    @Override
    public void setServer(Object socket) {
        exchange.objSocket=socket;

    }

}
