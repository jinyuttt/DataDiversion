/**    
 * �ļ�����MulticastServerSocket.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package JNetSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import ISocket.ISocketServer;

/**    
 *     
 * ��Ŀ���ƣ�JNetSocket    
 * �����ƣ�MulticastServerSocket    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����1:22:38    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����1:22:38    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class MulticastServerSocket implements ISocketServer{
    private IRecData recInstance=null;
    SocketAddress sendAddress=null;
    private boolean isRuning=true;
    MulticastSocket msr = null;//�����鲥�׽���  
    public boolean InitServer(IRecData rec,String addr,int port)
    {
        recInstance=rec;
      //����DatagramSocket����  
        InetAddress maddr = null;
        try {
            maddr = InetAddress.getByName(addr);
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            msr = new MulticastSocket(port);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        try {
            msr.setReceiveBufferSize(128);
        } catch (SocketException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            msr.setReuseAddress(true);
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        try {
            msr.joinGroup(maddr);
        } catch (IOException e1) {
            e1.printStackTrace();
        }//��������  
        byte[] buffer = new byte[8192];  
        Thread recData=new Thread(new Runnable(){
            @Override
            public void run() {
               while(isRuning)
               {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);  
                try {
                    msr.receive(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }  
                //�ӷ��������ظ��ͻ�������  
                String clientAddress = dp.getAddress().getHostName(); //��ÿͻ��˵�IP��ַ  
                int clientPort = dp.getPort(); //��ÿͻ��˵Ķ˿ں�  
                if(recInstance!=null)
                {
                    byte[]data=dp.getData();
                    UDPClient client=new UDPClient();
                    //
                    DatagramSocket sockettmp = null;
                    try {
                        sockettmp = new DatagramSocket();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                    String[]args=new String[]{clientAddress, String.valueOf(clientPort)};
                    client.setSocket(sockettmp, args);
                    recInstance.setServer(client);
                    recInstance.recviceData(clientAddress+":"+clientPort, data);
                }
               }
               msr.close();
            }
        });
        recData.setDaemon(true);
        recData.setName("UDPServer");
        recData.start();
        return false;
     
    }
    public void close()
    {
        isRuning=false;
    }
    @Override
    public void sendData(String host, int port, byte[] data) {
      
    }
    @Override
    public void sendData(SocketAddress addr, byte[] data) {
        
    }
    @Override
    public void sendCall(byte[] data) {
        
    }
}