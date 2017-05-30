/**    
 * �ļ�����ReadConfig.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
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
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�ReadConfig    
 * ��������   ��ȡ������Ϣ
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����8:57:55    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����8:57:55    
 * �޸ı�ע��    
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
    ///�������Ե�b.properties�ļ�
      FileOutputStream oFile = null;
    try {
        oFile = new FileOutputStream("req.properties", true);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }//true��ʾ׷�Ӵ�
    //*------������֮��----
    //������֮��Ĳ�ѯ�鲥
      prop.setProperty("ControlMultCastIP", "224.1.1.1");
      prop.setProperty("ControlMultCastPort", "5531");
      //������֮��Ĳ�ѯUDP
      prop.setProperty("ControlUDPIP", "host");
      prop.setProperty("ControlUDPPort", "5532");
      //*------�����������֮��----
      //���շ���ע��ĵ�ַ
      //�鲥
      prop.setProperty("ControlFWMultCastIP", "224.1.1.1");
      prop.setProperty("ControlFWMultCastPort", "5401");
      //UDP
      prop.setProperty("ControlFWUDPIP", "host");
      prop.setProperty("ControlFWUDPPort", "5402");
      //*------��������ͻ���֮��----
      //���տͻ�������Ͷ������
      prop.setProperty("ControlCMultCastIP", "224.1.1.1");
      prop.setProperty("ControlCMultCastPort", "5301");
      //UDP
      prop.setProperty("ControlCUDPIP", "host");
      prop.setProperty("ControlCUDPPort", "5302");
      
      //*------���������ջ�ִ��Ϣ----
      //���տͻ�������Ͷ������
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
    ///�������Ե�b.properties�ļ�
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