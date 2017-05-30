/**    
 * �ļ�����UDPClient.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��26��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package JNetSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import ISocket.ISocketClient;

/**    
 *     
 * ��Ŀ���ƣ�JNetSocket    
 * �����ƣ�UDPClient    
 * ��������    udp�ͻ���
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��26�� ����11:49:16    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��26�� ����11:49:16    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class UDPClient  implements ISocketClient{
    private  DatagramSocket socket =null;  //�����׽���
    private boolean isColse=false;
    private String addr;
    private int port;
    public void sendData(String host,int port,byte[]data)
    {
        InetAddress address = null;
        try {
            socket =new DatagramSocket();
        } catch (SocketException e2) {
            e2.printStackTrace();
        } 
        try {
            address = InetAddress.getByName(host);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }  
        //��������ַ  
        //�������ͷ������ݱ���Ϣ  
        DatagramPacket dataGramPacket = new DatagramPacket(data, data.length, address, port);  
        try {
            socket.setSendBufferSize(128);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            socket.send(dataGramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }  //ͨ���׽��ַ�������  
    }
   
     public void sendData(SocketAddress addr,byte[]data)
    {
        try {
            socket =new DatagramSocket();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }  //�����׽���
        //�������ͷ������ݱ���Ϣ  
        DatagramPacket dataGramPacket = new DatagramPacket(data, data.length,addr);  
        try {
            socket.send(dataGramPacket);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  //ͨ���׽��ַ������� 
    }
  
    public byte[]  getCallBackData()
      {
         if(isColse)
         {
             return null;
         }
         //���շ�������������  
         byte[] backbuf = new byte[1024];  
         DatagramPacket backPacket = new DatagramPacket(backbuf, backbuf.length);  
         try {
            socket.receive(backPacket);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  //���շ�������  
        return backPacket.getData();
   }
    
    public void close()
   {
       isColse=true;
       socket.close();
   }

@Override
  public void sendData(SocketAddress local, String sIP, int sPort, byte[] data) {
    
}

@Override
public void sendData(byte[] data) {
    InetAddress address = null;
    try {
        address = InetAddress.getByName(addr);
    } catch (UnknownHostException e1) {
        e1.printStackTrace();
    }  
    DatagramPacket backPacket = new DatagramPacket(data, data.length, address, port);  
    try {
        this.socket.send(backPacket);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void setSocket(Object socket, String[] args) {
this.socket=(DatagramSocket) socket;
if(args!=null&&args.length==2)
{
this.addr=args[0];
this.port=Integer.parseInt(args[1]);
}
}


  
}