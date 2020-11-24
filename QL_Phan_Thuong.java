package ql_phan_thuong;

import java.io.IOException;
import javax.swing.JFrame;


public class QL_Phan_Thuong {
     
    public static void main(String[] args) throws IOException {
        Login login = new Login();
        login.setVisible(true);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
