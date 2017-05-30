/**    
 * 文件名：FWListenter.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package NetListener;

import ControlProcess.FwDataProcess;
import JNetSocket.IRecData;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：FWListenter    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午1:12:23    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午1:12:23    
 * 修改备注：    
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
