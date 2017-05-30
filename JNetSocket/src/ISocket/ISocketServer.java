/**    
 * 文件名：ISocketServer.java    
 *    
 * 版本信息：    
 * 日期：2017年5月28日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package ISocket;

import java.net.SocketAddress;

import JNetSocket.IRecData;

/**    
 *     
 * 项目名称：JNetSocket    
 * 类名称：ISocketServer    
 * 类描述：    服务端通讯接口
 * 创建人：jinyu    
 * 创建时间：2017年5月28日 下午4:55:12    
 * 修改人：jinyu    
 * 修改时间：2017年5月28日 下午4:55:12    
 * 修改备注：    
 * @version     
 *     
 */
public interface ISocketServer {
    /*
     * 初始化
     */
    public boolean InitServer(IRecData rec,String host,int port);
    
    /*
     * 使用socket传送
     */
    public void sendData(String host,int port,byte[]data);
    public void sendData(SocketAddress addr,byte[]data);
    public void sendCall(byte[]data);
    public void close();
}
