package oodj.assignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminMenu extends JFrame {
    
    private JButton register;
    private JButton delete;
    private JButton view;
    private JButton topup;
    private JButton exit;
    
    
    public AdminMenu(){
        initializeUI();
        Login login = new Login();
        login.setVisible(false);   
    }
 
    private void initializeComponents(){
        register = new JButton("Register");
        delete = new JButton("Delete User");
        view = new JButton("View User");  
        topup = new JButton("Top Up Credit");
        exit = new JButton("Logout");
    
        register.setVisible(true);
        delete.setVisible(true);
        view.setVisible(true);
        topup.setVisible(true);
        exit.setVisible(true);
    }
    
    private void addComponentsToFrame(){
        setLayout(new FlowLayout());
        add(register);
        add(delete);
        add(view);
        add(topup);
        add(exit);
    }
    
    private void addActionListeners(){
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registration r = new Registration();
                r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.setVisible(true);
                
                dispose(); //close the current UI
            }
        });
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
//                Delete del = new Delete();
//                del.readCustomersToArray();
                
            }    
        });
        
        view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //System.out.println("View");
                ViewUsers view = new ViewUsers();
                view.setVisible(true);
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();               
            }    
        });
        
        topup.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                TopUp tp = new TopUp();
                tp.setVisible(true);
                tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }    
        });
        
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login log = new Login();
                log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                log.setVisible(true);
            }    
        });        
    }
    
    private void initializeUI() {
        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 100);
        initializeComponents();
        addComponentsToFrame();
        addActionListeners();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }
}       

    


