/**    
 * �ļ�����SqliteDB.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��27��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package DBAcess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**    
 *     
 * ��Ŀ���ƣ�DBAcess    
 * �����ƣ�SqliteDB    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��27�� ����2:53:47    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��27�� ����2:53:47    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class SqliteDB {
    // �õ����� ����������д��Ŀ¼��һ�����������ļ����ݿ�  
    Connection conn; 
    String dbfile=":memory:";
    public void setDB(String file)
    {
        dbfile=file;
    }
    public void close()
    {
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void  open()
    {
        // ��������  
        try {  
            Class.forName("org.sqlite.JDBC");  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            // e.printStackTrace();  
            System.out.println("���ݿ�����δ�ҵ�!");  
        }  
            try {
                String pre="jdbc:sqlite:"+dbfile;
                conn = DriverManager.getConnection(pre,null,null);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
            // �����Զ��ύΪfalse  
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
    }
    public int Update(String sql)
    {
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }  
        try {
         int r=   statement.executeUpdate(sql);
         return r;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return 0;
    }
public ResultSet query(String sql)
{
    Statement stat = null;
    try {
        stat = conn.createStatement();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    ResultSet rs = null;
    try {
        rs = stat.executeQuery(sql);
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } // ��ѯ����
     return rs;
}
}