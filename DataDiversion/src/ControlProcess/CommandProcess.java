/**    
 * �ļ�����CommandProcess.java    
 *    
 * �汾��Ϣ��    
 * ���ڣ�2017��5��28��    
 * Copyright ���� Corporation 2017     
 * ��Ȩ����    
 *    
 */
package ControlProcess;

import SysInfo.ControlStateModel;
import SysInfo.ControlSys;

/**    
 *     
 * ��Ŀ���ƣ�DataDiversion    
 * �����ƣ�CommandProcess    
 * ��������    
 * �����ˣ�jinyu    
 * ����ʱ�䣺2017��5��28�� ����3:31:51    
 * �޸��ˣ�jinyu    
 * �޸�ʱ�䣺2017��5��28�� ����3:31:51    
 * �޸ı�ע��    
 * @version     
 *     
 */
public class CommandProcess {
    
    /*
     * ����������ָ��
     */
public void process(String src,byte[]data)
{
    String cmd=new String(data);
    String[]args=cmd.split("#");
    if(args[0]=="0")
    {
        //�رտ�����
        ControlStateModel model=   ControlSys.Control.getOrDefault(args[1], null);
        if(model!=null)
        {
            model.IsAction=false;
        }
        
    }
   
}
}