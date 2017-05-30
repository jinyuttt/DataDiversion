/**    
 * �ļ�����SysInfoControl.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package SysInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import DBAcess.BerkeleyDB;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�SysInfoControl    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����11:55:19    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����11:55:19    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class SysInfoControl {
    
    /*
     * ��ȡ����ķ���
     */
public void ReadServer()
{
    BerkeleyDB db=new BerkeleyDB();
    db.open();
    db.openCursor();
    HashMap<byte[] , byte[]> hash=null;
    do{
          hash=db.getCursor();
          Iterator<Entry<byte[], byte[]>> iter = hash.entrySet().iterator();
          while (iter.hasNext()) {
          Entry<byte[], byte[]> entry =iter.next();
          String key=new String(entry.getKey());
          String value=new String(entry.getValue());
          
          ServerModel model=new ServerModel();
          model.AnysModel(value);
          LinkedList<ServerModel> link=  FWServer.FWInfo.getOrDefault(key, null);
          if(link==null)
          {
              link=new   LinkedList<ServerModel>();
              link.add(model);
              FWServer.FWInfo.put(key, link);
          }
          else
          {
              link.add(model);
          }
        }
    }while(hash.size()>0);
}
}