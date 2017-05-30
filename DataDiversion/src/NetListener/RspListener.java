/**    
 * �ļ�����RspListener.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package NetListener;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import ControlProcess.RspProcess;
import DataCache.DataReMailing;
import JNetSocket.IRecData;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�RspListener    
 * ��������    ��ִ����
 * ����Э�飺�������Ƴ���+��������+id����+id+����+data
 * ���ͣ�0 ����ȷ�� 1ҵ�񷵻�����
 * ���ⷵ������Ҳ����ȷ��
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����1:30:22    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����1:30:22    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class RspListener implements IRecData{

    @Override
    public void recviceData(String src, byte[] data) {
        RspProcess pro=new RspProcess();
        pro.processData(src, data);
    }

    @Override
    public void setServer(Object socket) {
        
    }

}
