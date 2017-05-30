/**    
 * �ļ�����NetConfig.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package DataConfig;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�NetConfig    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����9:31:26    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����9:31:26    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class NetConfig {
    private static NetConfig instance;  
 private NetConfig (){}   
    public static NetConfig getInstance() {  
   if (instance == null) {  
        instance = new NetConfig();  
     }  
  return instance;  
  } 
   
//------��������--------
public String ControlMultCastIP="224.1.1.1";
public int ControlMultCastPort=5531;
public String ControlUDPIP="host";
public int ControlUDPPort=5532;

//------����ע��-------
public String ControlFWMultCastIP="224.1.1.1";
public int ControlFWMultCastPort=5401;
public String ControlFWUDPIP="host";
public int ControlFWUDPPort=5402;

//-----�ͻ�������--------
public String ControlCMultCastIP="224.1.1.1";
public int ControlCMultCastPort=5301;
public String ControlCUDPIP="host";
public int ControlCUDPPort=5302;

//---------�������л�ִ--------
public String ControlRspMultCastIP="224.1.1.1";
public int ControlRspMultCastPort=5201;
public String ControlRspUDPIP="host";
public int ControlRspUDPPort=5202;

public void Init()
{
    ReadConfig rd=new ReadConfig();
    HashMap<String,String> hash=rd.Read();
    if(hash.size()>0)
    {
        Iterator<Entry<String, String>> iter = hash.entrySet().iterator();
       
        while (iter.hasNext()) {
           Entry<String, String> entry = iter.next();
           String key=entry.getKey().toString();
           String value=entry.getValue();
           try {
            Field d= this.getClass().getField(key);
            if(key.contains("Port"))
            {
                
                    try {
                        d.setInt(this, Integer.parseInt(value));
                    } catch (NumberFormatException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
            else
            {
                try {
                    d.set(this, value);
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
    this.write();
}
private void write()
{
    Field[] ds= this.getClass().getFields();
    HashMap<String,String> hash=new HashMap<String,String>();
   for(Field d:ds)
   {
       String key=   d.getName();
       String value="";
       try {
           value=String.valueOf(d.get(this));
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       hash.put(key, value);
   }
   ReadConfig rd=new ReadConfig();
   rd.write(hash);
}
}
