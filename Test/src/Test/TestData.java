/**    
 * �ļ�����TestData.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import DBAcess.BerkeleyDB;
import DBAcess.SqliteDB;

/**    
 *     
 * ��Ŀ���ƣ�Test    
 * �����ƣ�TestData    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����3:10:45    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����3:10:45    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class TestData {

    /**    
       
     * main(������һ�仰�����������������)    
       
     * TODO(����������������������� �C ��ѡ)    
       
     * TODO(�����������������ִ������ �C ��ѡ)    
       
     * TODO(�����������������ʹ�÷��� �C ��ѡ)    
       
     * TODO(�����������������ע������ �C ��ѡ)    
       
     * @param   name    
       
     * @param  @return    �趨�ļ�    
       
     * @return String    DOM����    
       
     * @Exception �쳣����    
       
     * @since  CodingExample��Ver(���뷶���鿴) 1.1    
       
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