/**    
 * 文件名：RspListener.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
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
 * 项目名称：DataDiversion    
 * 类名称：RspListener    
 * 类描述：    回执接收
 * 数据协议：服务名称长度+服务名称+id长度+id+类型+data
 * 类型：0 接收确认 1业务返回数据
 * 另外返回数据也必须确认
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午1:30:22    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午1:30:22    
 * 修改备注：    
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
