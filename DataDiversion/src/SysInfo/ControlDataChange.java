/**    
 * �ļ�����ControlDataChange.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

import ClientProcess.ClientProcess;
import ControlProcess.CommandProcess;
import ControlProcess.FwDataProcess;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ControlDataChange    
 * ��������    �����������������
 * 0 ���� 1�ͻ�����������ת��  2 ������Ϣ���� 3 ָ��
 * Э���ʽ������+byte[]
 * ��������Э��:�������Ƴ���+data;
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����3:14:53    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����3:14:53    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ControlDataChange {
    public Object objSocket=null;
public void  controlData(String src,byte[]data)
{
    byte type=data[0];
    byte[]srcData=new byte[data.length-1];
    System.arraycopy(data, 1, srcData, 0, srcData.length);
    switch(type)
    {
    case   0:
             procesHeart(src,srcData);
         break;
    case 1:
        processClient(src,srcData);
        break;
    case 2:
        processFW(src,srcData);
        break;
    case 3:
        processControl(src,srcData);
        break;
        
    }
  
}
private void procesHeart(String src,byte[]data)
{
    String info=new String(data);
    String[] args=info.split("#");
    ControlStateModel model=new ControlStateModel();      
   model.IP=args[0];
   model.port=Integer.parseInt(args[1]);
   model.Name=args[2];
   model.FlageID=args[3];
   model.IsMaster=Boolean.parseBoolean(args[4]);
   model.FlashTime=System.currentTimeMillis();
   model.IsAction=true;
   ControlSys.Control.put(model.FlageID, model);
   if(model.IP=="host"||model.IP.isEmpty())
   {
        String[] addr=src.split(":");
        model.IP=addr[0];
   }
   ControlSys.Control.put(model.FlageID, model);
}
private void processClient(String src,byte[]data)
{
    //�����˷�������
    ClientProcess client=new ClientProcess();
    client.processData(src, data,this.objSocket);
}
private void processControl(String src,byte[]data)
{
    CommandProcess cmd=new CommandProcess();
    cmd.process(src, data);
}
private void processFW(String src,byte[]data)
{
    FwDataProcess  pro=new FwDataProcess();
    pro.processFW(src, data);
}
}