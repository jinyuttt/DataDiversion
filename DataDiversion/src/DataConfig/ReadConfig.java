/**    
 * 文件名：ReadConfig.java    
 *    
 * 版本信息：    
 * 日期：2017年5月27日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package DataConfig;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**    
 *     
 * 项目名称：DataDiversion    
 * 类名称：ReadConfig    
 * 类描述：   读取配置信息
 * 创建人：jinyu    
 * 创建时间：2017年5月27日 下午8:57:55    
 * 修改人：jinyu    
 * 修改时间：2017年5月27日 下午8:57:55    
 * 修改备注：    
 * @version     
 *     
 */
public class ReadConfig {
public HashMap<String,String> Read()
{
    HashMap<String,String> hashMap=new HashMap<String,String>();
    Properties prop=new Properties();
    @SuppressWarnings("static-access")
    InputStream is=Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("req.properties");
    if(is==null)
    {
        return hashMap;
    }
    try {
        prop.load(is);
        Iterator<String> it=prop.stringPropertyNames().iterator();
              while(it.hasNext()){
             String key=it.next();
             hashMap.put(key, prop.getProperty(key));
        }
      is.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return hashMap;
}
private void write()
{
    Properties prop = new Properties();   
    ///保存属性到b.properties文件
      FileOutputStream oFile = null;
    try {
        oFile = new FileOutputStream("req.properties", true);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }//true表示追加打开
    //*------控制器之间----
    //控制器之间的查询组播
      prop.setProperty("ControlMultCastIP", "224.1.1.1");
      prop.setProperty("ControlMultCastPort", "5531");
      //控制器之间的查询UDP
      prop.setProperty("ControlUDPIP", "host");
      prop.setProperty("ControlUDPPort", "5532");
      //*------控制器与服务之间----
      //接收服务注册的地址
      //组播
      prop.setProperty("ControlFWMultCastIP", "224.1.1.1");
      prop.setProperty("ControlFWMultCastPort", "5401");
      //UDP
      prop.setProperty("ControlFWUDPIP", "host");
      prop.setProperty("ControlFWUDPPort", "5402");
      //*------控制器与客户端之间----
      //接收客户端请求及投递数据
      prop.setProperty("ControlCMultCastIP", "224.1.1.1");
      prop.setProperty("ControlCMultCastPort", "5301");
      //UDP
      prop.setProperty("ControlCUDPIP", "host");
      prop.setProperty("ControlCUDPPort", "5302");
      
      //*------控制器接收回执信息----
      //接收客户端请求及投递数据
      prop.setProperty("ControlRspMultCastIP", "224.1.1.1");
      prop.setProperty("ControlRspMultCastPort", "5201");
      //UDP
      prop.setProperty("ControlRspUDPIP", "host");
      prop.setProperty("ControlRspUDPPort", "5202");
      
     try {
        prop.store(oFile, "The New properties file");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     try {
        oFile.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public void write(HashMap<String,String> hash)
{
    Properties prop = new Properties();   
    ///保存属性到b.properties文件
      FileOutputStream oFile = null;
    try {
        oFile = new FileOutputStream("req.properties", false);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    for(Entry<String, String> entry:hash.entrySet())
    {
        prop.setProperty(entry.getKey(), entry.getValue());
    }
    try {
        prop.store(oFile, "The New properties file");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     try {
        oFile.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
