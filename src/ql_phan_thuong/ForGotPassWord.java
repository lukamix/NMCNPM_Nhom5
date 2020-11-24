package ql_phan_thuong;


import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class ForGotPassWord extends javax.swing.JFrame {

    public ForGotPassWord()  {       
        try {
            this.accountFile = new FileInputStream("src/ql_phan_thuong/account.txt");
            initComponents();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            Scanner sc = new Scanner(this.accountFile);
            while (sc.hasNextLine()) 
            { 
                this.inputun[this.count] = sc.nextLine(); 
                this.inputpw[this.count] = sc.nextLine();
                this.inputemail[this.count] = sc.nextLine();
                this.count++;
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        QuenMatKhau = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TenDangNhap = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        ResetPassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Luuy1 = new javax.swing.JLabel();
        Luuy2 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        TenDangNhapLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QuenMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        QuenMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        QuenMatKhau.setText("Quên Mật Khẩu");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ql_phan_thuong/line.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ql_phan_thuong/line.png"))); // NOI18N

        TenDangNhap.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TenDangNhap.setForeground(new java.awt.Color(102, 102, 102));
        TenDangNhap.setText("Tên Đăng Nhập");
        TenDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TenDangNhapMouseClicked(evt);
            }
        });

        Email.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        Email.setForeground(new java.awt.Color(102, 102, 102));
        Email.setText("Email");
        Email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmailMouseClicked(evt);
            }
        });

        ResetPassword.setBackground(new java.awt.Color(51, 204, 0));
        ResetPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ResetPassword.setForeground(new java.awt.Color(255, 255, 255));
        ResetPassword.setText("Đặt Lại Mật Khẩu");
        ResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetPasswordActionPerformed(evt);
            }
        });

        Luuy1.setForeground(new java.awt.Color(102, 102, 102));
        Luuy1.setText("Chúng tôi sẽ gửi bạn 1 email chứa mật khẩu của bạn, nếu không nhận được email");

        Luuy2.setForeground(new java.awt.Color(102, 102, 102));
        Luuy2.setText("Bấm vào nút gửi lại email sau 30s (Check kỹ mục spam)");

        EmailLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(51, 204, 0));
        EmailLabel.setText("Email:");

        TenDangNhapLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TenDangNhapLabel.setForeground(new java.awt.Color(51, 204, 0));
        TenDangNhapLabel.setText("Tên Đăng Nhập :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TenDangNhapLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(EmailLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(QuenMatKhau)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TenDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ResetPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Luuy1)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(Luuy2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuenMatKhau))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenDangNhapLabel))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ResetPassword)
                        .addGap(18, 18, 18)
                        .addComponent(Luuy1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Luuy2)
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TenDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TenDangNhapMouseClicked
        if(Email.getText().equals("")){
            Email.setText("Email");
            Email.setFont(tnmrnghieng);
            Email.setForeground(Color.GRAY);
            checkemailclick=false;
        }
        if(!checkdangnhapclick){
            TenDangNhap.setText("");
            TenDangNhap.setFont(tnrmstraight);
            TenDangNhap.setForeground(Color.BLACK);
            checkdangnhapclick=true;
        }
    }//GEN-LAST:event_TenDangNhapMouseClicked

    private void EmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailMouseClicked
        if(TenDangNhap.getText().equals("")){
            TenDangNhap.setText("Tên Đăng Nhập");
            TenDangNhap.setFont(tnmrnghieng);
            TenDangNhap.setForeground(Color.GRAY);
            checkdangnhapclick=false;
        }
        if(!checkemailclick){
        Email.setText("");
        Email.setFont(tnrmstraight);
        Email.setForeground(Color.BLACK);
        checkemailclick=true;
        }
    }//GEN-LAST:event_EmailMouseClicked

    private void ResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetPasswordActionPerformed
        String recepient = Email.getText();
        String account = TenDangNhap.getText();
        if(account.equals("")){
            TenDangNhap.setText("Tên Đăng Nhập");
            TenDangNhap.setFont(tnmrnghieng);
            TenDangNhap.setForeground(Color.GRAY);
            checkdangnhapclick=false;
        }
        if(recepient.equals("")){
            Email.setText("Email");
            Email.setFont(tnmrnghieng);
            Email.setForeground(Color.GRAY);
            checkemailclick=false;
        }
        if(account.equals("Tên Đăng Nhập")||recepient.equals("Email")){
            JOptionPane.showMessageDialog(rootPane, "Vui Lòng Nhập Đầy Đủ Thông Tin !");
        }
        else{
            boolean checkup = false;
            int tick = 0;
            for(int i=0;i<this.count;i++){
                if(this.inputun[i].equals(account)&&this.inputemail[i].equals(recepient)){
                    checkup=true;
                    tick = i;
                    break;
                }
            }
            if(!checkup){
                JOptionPane.showMessageDialog(rootPane,"Thông tin nhập vào không trùng khớp với bất kỳ tài khoản nào !");
            }else{
            properties = new Properties();
            properties.put("mail.smtp.auth","true");
            properties.put("mail.smtp.starttls.enable","true");
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","587");
            
            String myAccountEmail = "nguyenbaduc0205@gmail.com";
            String mypassword = "Khongbiet";
            
            Session session = Session.getInstance(properties, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myAccountEmail,mypassword);
                } 
            });
            
            Message message = prepareMessage(session,myAccountEmail,recepient,inputpw[tick]);
            try {
                Transport.send(message);
            } catch (MessagingException ex) {
                Logger.getLogger(ForGotPassWord.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(rootPane, "Đã gửi 1 mail chứa mật khẩu vào email của bạn !");
            }
        }
    }//GEN-LAST:event_ResetPasswordActionPerformed
    private Message prepareMessage(Session session,String myAccountEmail,String recepient,String password) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password");
            String mail = "Your Password is "+password+"\nĐây là email được gửi tự động từ Phần Mềm Quản Lý Phần Thưởng"
                    +"\nBản Quyền thuộc về A+CNPM .Inc\nCảm ơn bạn đã sử dụng phần mềm của chúng tôi"
                    +"\nĐể biết thêm thông tin chi tiết về sản phẩm , liên hệ : Nguyễn Bá Đức Facebook:facebook.com/Luka.Meoww hoặc email này !"
                    +"\n-Duc-dep-trai-";
            message.setText(mail);
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(ForGotPassWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForGotPassWord().setVisible(true);
            }
        });
    }
    
    boolean checkdangnhapclick = false;
    boolean checkemailclick = false;
    Font tnrmstraight = new Font("Times New Roman", Font.BOLD, 24);
    Font tnmrnghieng = new Font("Times New Roman", Font.ITALIC,24);
    Properties properties ;
    FileInputStream accountFile;
    String inputun[]=new String[1000],inputpw[]=new String[1000],inputemail[] =new String[1000];
    int count = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel Luuy1;
    private javax.swing.JLabel Luuy2;
    private javax.swing.JLabel QuenMatKhau;
    private javax.swing.JButton ResetPassword;
    private javax.swing.JTextField TenDangNhap;
    private javax.swing.JLabel TenDangNhapLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
