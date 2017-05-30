/**    
 * 文件名：NetConfig.java    
 *    
 * 版本信息：    
 * 日期：2017年5月27日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package DataConfig;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：NetConfig    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月27日 下午9:31:26    
 * 修改人：jinyu    
 * 修改时间：2017年5月27日 下午9:31:26    
 * 修改备注：    
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
   
//------控制器间--------
public String ControlMultCastIP="224.1.1.1";
public int ControlMultCastPort=5531;
public String ControlUDPIP="host";
public int ControlUDPPort=5532;

//------服务注册-------
public String ControlFWMultCastIP="224.1.1.1";
public int ControlFWMultCastPort=5401;
public String ControlFWUDPIP="host";
public int ControlFWUDPPort=5402;

//-----客户端请求--------
public String ControlCMultCastIP="224.1.1.1";
public int ControlCMultCastPort=5301;
public String ControlCUDPIP="host";
public int ControlCUDPPort=5302;

//---------接收所有回执--------
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

