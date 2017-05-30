/**    
 * 文件名：ControlStateListenter.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package NetListener;

import JNetSocket.IRecData;
import SysInfo.ControlDataChange;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：ControlStateListenter    
 * 类描述：    接收控制器的数据
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 上午2:50:56    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 上午2:50:56    
 * 修改备注：    
 * @version     
 *     
 */
public class ControlStateListenter implements IRecData {
    ControlDataChange exchange=new ControlDataChange();
    /* (non-Javadoc)    
     * 接收数据 
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
