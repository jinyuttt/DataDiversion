/**    
 * 文件名：TestData.java    
 *    
 * 版本信息：    
 * 日期：2017年5月27日    
 * Copyright 足下 Corporation 2017     
 * 版权所有    
 *    
 */
package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBAcess.BerkeleyDB;
import DBAcess.SqliteDB;

/**    
 *     
 * 项目名称：Test    
 * 类名称：TestData    
 * 类描述：    
 * 创建人：jinyu    
 * 创建时间：2017年5月27日 上午3:10:45    
 * 修改人：jinyu    
 * 修改时间：2017年5月27日 上午3:10:45    
 * 修改备注：    
 * @version     
 *     
 */
public class TestData {

    /**    
       
     * main(这里用一句话描述这个方法的作用)    
       
     * TODO(这里描述这个方法适用条件 – 可选)    
       
     * TODO(这里描述这个方法的执行流程 – 可选)    
       
     * TODO(这里描述这个方法的使用方法 – 可选)    
       
     * TODO(这里描述这个方法的注意事项 – 可选)    
       
     * @param   name    
       
     * @param  @return    设定文件    
       
     * @return String    DOM对象    
       
     * @Exception 异常对象    
       
     * @since  CodingExample　Ver(编码范例查看) 1.1    
       
    */
    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        SqliteDB sql=new SqliteDB();
//        sql.setDB("test.db");
//       sql.open();
//       //
//       String sss="create table people (name, occupation);";
//      // stat.executeUpdate("create table people (name, occupation);");
//      // PreparedStatement prep = conn.prepareStatement(
//       //  "insert into people values (?, ?);");
//       sql.Update(sss);
//       sss="insert into people VALUES(1,'Gandhi')";
//       sql.Update(sss);
//       sss="select * from people";
//       ResultSet   rs=   sql.query(sss);
//     try {
//        String s=   rs.getString(1);
//        System.out.println(s);
//    } catch (SQLException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
        BerkeleyDB db=new BerkeleyDB();
        db.open();
        String key="key";
        String  v="vvalue";
        
        db.insert(key.getBytes(), v.getBytes());
        byte[] vv=  db.get(key.getBytes());
        System.out.println(new String(vv));
    }

}
