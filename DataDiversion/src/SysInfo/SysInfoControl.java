/**    
 * 文件名：SysInfoControl.java    
 *    
 * 版本信息：    
 * 日期：2017年5月27日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
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
 * 项目名称：DataDiversion    
 * 类名称：SysInfoControl    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月27日 下午11:55:19    
 * 修改人：jinyu    
 * 修改时间：2017年5月27日 下午11:55:19    
 * 修改备注：    
 * @version     
 *     
 */
public class SysInfoControl {
    
    /*
     * 读取保存的服务
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
