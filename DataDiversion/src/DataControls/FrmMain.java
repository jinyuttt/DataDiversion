package DataControls;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class FrmMain extends JFrame {

    /**    
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）    
     *    
     * @since Ver 1.1    
     */    
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    JSplitPane splitPane;
    private final JLabel lblNewLabel = new JLabel("New label");
    private JPanel panel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // 使得标题栏和对话框跟随外观变化
         JFrame.setDefaultLookAndFeelDecorated(true);
         JDialog.setDefaultLookAndFeelDecorated(true);
            try {
                UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (UnsupportedLookAndFeelException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmMain frame = new FrmMain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmMain() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                splitPane.setDividerLocation(0.4);
            }
        });
        setTitle("\u7CFB\u7EDF\u63A7\u5236\u5668");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 538, 474);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menu = new JMenu("\u7CFB\u7EDF\u64CD\u4F5C");
        menuBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("\u542F\u52A8\u7A0B\u5E8F");
        menu.add(menuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("系统状态", null, panel, null);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
         splitPane = new JSplitPane();
        panel.add(splitPane);
        
        panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "\u63A7\u5236\u5668\u72B6\u6001", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        splitPane.setLeftComponent(panel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "\u670D\u52A1\u72B6\u6001", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        splitPane.setRightComponent(panel_3);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("系统日志", null, panel_1, null);
        
        table = new JTable();
        panel_1.add(table);
        contentPane.add(lblNewLabel, BorderLayout.SOUTH);
    }

}
