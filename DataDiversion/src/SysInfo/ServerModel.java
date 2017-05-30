/**    
 * �ļ�����ServerModel.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ServerModel    
 * ��������    ������Ϣ
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����1:24:41    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����1:24:41    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class ServerModel {
    /*
     * �����ַ
     */
public String ServerIP;
/*
 * ��������
 */
public String ServerName;
/*
 * ����˿�
 */
public int Port;
/*
 * ����ͨѶЭ��
 */
public String ProtocolType;

/*
 * ����ϵͳ������ID
 */
public String FlageId;

/*
 * ����
 */
public boolean  IsAction;

/*
 * �Ƿ���ͬһ��������Ϣ 
 * 
 */
public boolean equals(Object obj)
{
    if(this == obj)  
        return true;  
     if((obj == null) || (obj.getClass() != this.getClass()))  
        return false;  
      ServerModel objValue = (ServerModel)obj;  
      if(objValue.ServerIP==this.ServerIP&&objValue.Port==this.Port)
      {
          return true;
      }
      else
      {
          return false;
      }
    
}
public String toString()
{
    StringBuffer buffer=new StringBuffer();
    buffer.append(ServerName);
    buffer.append("#");
    buffer.append(ProtocolType);
    buffer.append("#");
    buffer.append(ServerIP);
    buffer.append("#");
    buffer.append(Port);
    buffer.append("#");
    buffer.append(FlageId);
    return buffer.toString();
}
public boolean AnysModel(String buf)
{
    boolean issucess=false;
    if(buf!=null&&buf.length()>0)
    {
        String[] value=buf.split("#");
       if(value.length==5)
       {
           ServerName=value[0];
           ProtocolType=value[0];
           ServerIP=value[0];
           Port=Integer.parseInt(value[0]);
           FlageId=value[0];
           issucess=true;
       }
    }
    return issucess;
}
}