/**    
 * �ļ�����ControlListener.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package NetListener;

import DataConfig.NetConfig;
import JNetSocket.MulticastServerSocket;
import JNetSocket.UDPServerSocket;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlListener    
 * ��������    ��������
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����2:08:17    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����2:08:17    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlListener {
    ControlStateListenter listenter=new ControlStateListenter();
    FWListenter listenterFW=new FWListenter();
    ClientListenter listenterReq=new ClientListenter();
    RspListener listenterRsp=new RspListener();
    /*
     * �����������
     */
public void controlStart()
{
    //�����鲥
    String sIP=NetConfig.getInstance().ControlMultCastIP;
    int port=NetConfig.getInstance().ControlMultCastPort;;
    String host=NetConfig.getInstance().ControlUDPIP;
    int uport=NetConfig.getInstance().ControlUDPPort;
    MulticastServerSocket server=new MulticastServerSocket();
    server.InitServer(listenter, sIP, port);
    //����UDP
    UDPServerSocket userver=new UDPServerSocket();
    if(host=="host")
    {
        host="";
    }
    userver.InitServer(listenter, host, uport);
}

/*
 * ע��������
 */
public void   registerFW()
{
    //�����鲥
    String sIP=NetConfig.getInstance().ControlFWMultCastIP;
    int port=NetConfig.getInstance().ControlFWMultCastPort;;
    String host=NetConfig.getInstance().ControlFWUDPIP;
    int uport=NetConfig.getInstance().ControlFWUDPPort;
    MulticastServerSocket server=new MulticastServerSocket();
    server.InitServer(listenterFW, sIP, port);
    //����UDP
    UDPServerSocket userver=new UDPServerSocket();
    if(host=="host")
    {
        host="";
    }
    userver.InitServer(listenterFW, host, uport);
}

/*
 * �ͻ����������
 */
public void clientRequest()
{
    //�����鲥
    String sIP=NetConfig.getInstance().ControlCMultCastIP;
    int port=NetConfig.getInstance().ControlCMultCastPort;;
    String host=NetConfig.getInstance().ControlCUDPIP;
    int uport=NetConfig.getInstance().ControlCUDPPort;
    MulticastServerSocket server=new MulticastServerSocket();
    server.InitServer(listenterReq, sIP, port);
    //����UDP
    UDPServerSocket userver=new UDPServerSocket();
    if(host=="host")
    {
        host="";
    }
    userver.InitServer(listenterReq, host, uport);
}

/*
 * �����ִ����
 */
public void rspCall()
{
  //�����鲥
    String sIP=NetConfig.getInstance().ControlRspMultCastIP;
    int port=NetConfig.getInstance().ControlRspMultCastPort;;
    String host=NetConfig.getInstance().ControlRspUDPIP;
    int uport=NetConfig.getInstance().ControlRspUDPPort;
    MulticastServerSocket server=new MulticastServerSocket();
    server.InitServer(listenterRsp, sIP, port);
    //����UDP
    UDPServerSocket userver=new UDPServerSocket();
    if(host=="host")
    {
        host="";
    }
    userver.InitServer(listenterRsp, host, uport);
}
}