/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_phan_thuong;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Arrays;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import javax.swing.JOptionPane;

public class TrungThu {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Google sheet";
    private static String SPREADSHEET_ID = "1jzUZlUmLuYL7JqUsq80hGmnzYwVevtDaNIUExvZwax4";
    
    
    public TrungThu(){
    
    }
    private static Credential authorize() throws IOException, GeneralSecurityException{
        InputStream in = new FileInputStream("src/ql_phan_thuong/credentials.txt");
        if(in == null){
            throw new FileNotFoundException("Resource not found:");
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes).setDataStoreFactory(
                        new FileDataStoreFactory(new java.io.File("token")))
                .setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return credential;
    }
    
    public static Sheets getSheetService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), 
                JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
    }
    
    private static boolean checkExistEntity(String entity, String column, String table){
        
        try{
            final String url = "jdbc:mysql://localhost/homework1_db";
            final String user = "root";
            final String password = "";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM " + table;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if((rs.getString(column)).equals(entity)){
                    return true;
                }
            }
            
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(rootPane, e);
            
        }
        return false;
        
    }
    private static boolean checkSK(String sk, String nam){
        try{
            final String url = "jdbc:mysql://localhost/homework1_db";
            final String user = "root";
            final String password = "";
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM Event WHERE Name = ? AND Year = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, sk);
            pst.setString(2, nam);
            rs = pst.executeQuery();
            if(rs != null){
                
                return true;
            }
            
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(rootPane, e);
            
        }
        
        return false;
    }
    
    public static void TruyCapSheet() throws IOException, GeneralSecurityException{
        InputStream in = new FileInputStream("src/ql_phan_thuong/TrungThu_Update.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        int a = Integer.parseInt(line);
        a = a+1;
        line = String.valueOf(a);
        //System.out.println(line);
        sheetsService = getSheetService();
        String range = "Sheet1!A"+line+":Q";
        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        List<List<Object>> values = response.getValues();
        if(values == null || values.isEmpty()){
            System.out.println("No Data Found");
        }
        else{
            for(List row : values){
                try{
                    String Nam = (String) row.get(1);
                    String HoTen = (String) row.get(3);
                    String Tuoi = (String) row.get(12);
                    String GioiTinh = (String) row.get(13);
                    String ConOng = (String) row.get(2);
                    String ConBa = (String) row.get(10);
                    String Truong = (String) row.get(7);
                    String DiaChi = (String) row.get(11);
                    String Qua = (String) row.get(14);
                    String SoLuong = (String) row.get(15);
                    String GiaTri = (String) row.get(16);
                    final String url = "jdbc:mysql://localhost/homework1_db";
                    final String user = "root";
                    final String password = "";
                    Connection con = null;
                    PreparedStatement pst = null;
                    ResultSet rs = null;
                con = DriverManager.getConnection(url, user, password);
                String insert = "";
                String update = "";
                
                if(!(checkSK("Trung thu", Nam))){
                    insert = "INSERT INTO Event(`Name`, `Year`) VALUES (?, ?)";
                    pst = con.prepareStatement(insert);
                    pst.setString(1, "Trung thu");
                    pst.setString(2, Nam);
                    pst.executeUpdate();
                    
                    insert = "INSERT INTO GIFT(`Gift_Name`, `Cost`) VALUES (?, ?)";
                    pst = con.prepareStatement(insert);
                    pst.setString(1, Qua);
                    pst.setString(2, GiaTri);
                    pst.executeUpdate();
                    
                    String select = "SELECT * FROM Event WHERE Event.Year = ?";
                    pst = con.prepareStatement(select);
                    pst.setString(1, Nam);
                    rs = pst.executeQuery();
                    
                    insert = "INSERT INTO Family(`Father`, `Mother`, `Address`, `ID_E`)"
                            + "VALUES (?, ?, ?, ?)";
                    pst = con.prepareStatement(insert);
                    pst.setString(1, ConOng);
                    pst.setString(2, ConBa);
                    pst.setString(3, DiaChi);
                    while(rs.next()){
                        int idEv = rs.getInt("ID");
                        pst.setString(4, Integer.toString(idEv));
                    }
                    pst.executeUpdate();
                    
                    insert = "INSERT INTO Achievement(`Achievement_Name`) VALUES (?)";
                    pst = con.prepareStatement(insert);
                    pst.setString(1, "Dịp đặc biệt");
                    pst.executeUpdate();
                    
                    insert = "INSERT INTO Recipient(`Name`, `Age`, `Sex`, `School`, `ID_Family`) "
                            + "VALUES (?, ?, ?, ?, ?)";
                    //String sex = GioiTinh.getSelectedItem().toString().trim();
                    pst = con.prepareStatement(insert);
                    pst.setString(1, HoTen);
                    pst.setString(2, Tuoi);
                    pst.setString(3, GioiTinh);
                    pst.setString(4, Truong);
                    // select id_family to insert
                    String sel = "SELECT * FROM Family "
                            + "WHERE Father like ? AND Mother like ?";
                    PreparedStatement pst2 = con.prepareStatement(sel);
                    pst2.setString(1, ConOng);
                    pst2.setString(2, ConBa);
                    ResultSet idRes = pst2.executeQuery();
                    while(idRes.next()){
                        int idFamily = idRes.getInt("ID");
                        pst.setString(5, Integer.toString(idFamily));
                    }
                    pst.executeUpdate();
                    
                    // add row to Receive_Gift table
                    // get id of recipient
                    String selectID = "SELECT * FROM Recipient, Family "
                            + "WHERE Recipient.ID_Family = Family.ID";
                    pst = con.prepareStatement(selectID);
                    rs = pst.executeQuery();
                    int idRecipient = -1;
                    while (rs.next()){
                        if (rs.getString("Name").equals(HoTen) 
                                && (rs.getString("Father").equals(ConOng)) 
                                && (rs.getString("Mother").equals(ConBa)) 
                                && (rs.getString("Address").equals(DiaChi))){
                            idRecipient = rs.getInt("ID");
                        }
                    }
                    int idEvent = -1;
                    int idGift = -1;
                    int idAchievement = -1;
                    // get id of Gift
                    selectID = "SELECT * FROM Gift "
                            + "WHERE Gift.Gift_Name = ?";
                    pst = con.prepareStatement(selectID);
                    pst.setString(1, Qua);
                    rs = pst.executeQuery();
                    while(rs.next()){
                        idGift = rs.getInt("ID");
                    }
                    // get id of Event 
                    selectID = "SELECT * FROM Event "
                            + "WHERE Event.Name = ?";
                    pst = con.prepareStatement(selectID);
                    pst.setString(1, "Trung thu");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        idEvent = rs.getInt("ID");
                    }
                    // get id of Achievement
                    selectID = "SELECT * FROM Achievement "
                            + "WHERE Achievement.Achievement_Name = ?";
                    pst = con.prepareStatement(selectID);
                    pst.setString(1, "Dịp đặc biệt");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        idAchievement = rs.getInt("ID");
                    }

                    insert = "INSERT INTO Receive_Gift"
                            + "(`ID_Recipient`, `ID_Gift`, `ID_Event`, `ID_Achievement`, `Quantity`) "
                            + "VALUES (?, ?, ?, ?, ?)";
                    pst = con.prepareStatement(insert);
                    pst.setString(1, Integer.toString(idRecipient));
                    pst.setString(2, Integer.toString(idGift));
                    pst.setString(3, Integer.toString(idEvent));
                    pst.setString(4, Integer.toString(idAchievement));
                    pst.setString(5, SoLuong);
                    pst.executeUpdate();
                    
                    //JOptionPane.showMessageDialog(rootPane, "Đã Lưu !");
                }
                else{
                    //String sex = GioiTinh.getSelectedItem().toString().trim();
                    if(checkExistEntity(ConOng, "Father", "Family")){
                        if(checkExistEntity(ConBa, "Mother", "Family")){
                            if(checkExistEntity(HoTen, "Name", "Recipient")){
                                String selectID = "SELECT * FROM Family, Recipient, Event "
                                        +"WHERE Family.Father = ? AND Family.Mother = ? "
                                        +"AND Family.ID = Recipient.ID_Family AND Recipient.Name = ? "
                                        +"AND Family.ID_E = Event.ID AND Event.Year = ? AND Event.Name = ? ";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, ConOng);
                                pst.setString(2, ConBa);
                                pst.setString(3, HoTen);
                                pst.setString(4, Nam);
                                pst.setString(5, "Trung thu");
                                rs = pst.executeQuery();
                                int idEv = 0, idF = 0;
                                while(rs.next()){
                                    int idEv1 = rs.getInt("ID_E");
                                    int idRep1 = rs.getInt("ID");
                                    idEv = idEv1;
                                    idF = idRep1;
                                }
                                selectID = "SELECT * FROM Recipient WHERE Recipient.ID_Family = ? AND Recipient.Name = ?";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, Integer.toString(idF));
                                pst.setString(2, HoTen);
                                rs = pst.executeQuery();
                                int idRep = 0;
                                while(rs.next()){
                                    int idRep1 = rs.getInt("ID");
                                    idRep = idRep1;
                                }
                                
                                selectID = "SELECT * FROM Receive_Gift WHERE Receive_Gift.ID_Recipient = ? AND Receive_Gift.ID_Event = ?";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, Integer.toString(idRep));
                                pst.setString(2, Integer.toString(idEv));
                                rs = pst.executeQuery();
                                int idG = 0;
                                while(rs.next()){
                                    idG = rs.getInt("ID_Gift");
                                }
                                
                                update = "UPDATE Receive_Gift SET Quantity = ? WHERE ID_Recipient = ? AND ID_Event = ?";
                                pst = con.prepareStatement(update);
                                //int sl = (int) SoLuong;
                                pst.setString(1, SoLuong);
                                pst.setString(2, Integer.toString(idRep));
                                pst.setString(3, Integer.toString(idEv));
                                pst.executeUpdate();
                                
                                update = "UPDATE Gift SET Gift_Name = ?, Cost = ? WHERE ID = ?";
                                pst = con.prepareStatement(update);
                                pst.setString(1, Qua);
                                pst.setString(2, GiaTri);
                                pst.setString(3, Integer.toString(idG));
                                pst.executeUpdate();
                                
                                update = "UPDATE Family SET Address = ? WHERE ID = ? AND ID_E = ?";
                                pst = con.prepareStatement(update);
                                pst.setString(1, DiaChi);
                                pst.setString(2, Integer.toString(idF));
                                pst.setString(3, Integer.toString(idEv));
                                pst.executeUpdate();
                                
                                update = "UPDATE Recipient SET Age = ?, Sex = ?, School = ? WHERE ID = ? AND ID_Family = ?";
                                pst = con.prepareStatement(update);
                                pst.setString(1, Tuoi);
                                pst.setString(2, GioiTinh);
                                pst.setString(3, Truong);
                                pst.setString(4, Integer.toString(idRep));
                                pst.setString(5, Integer.toString(idF));
                                pst.executeUpdate();
                                
                                //JOptionPane.showMessageDialog(rootPane, "Đã Lưu !");
                                //System.out.println(idRep);
                                //int idEv = rs.getInt("ID_E");
                                
                            }
                            else{
                                String selectID = "SELECT * FROM Family, Event "
                                        +"WHERE Family.Father = ? AND Family.Mother = ? "
                                        +"AND Family.ID_E = Event.ID AND Event.Year = ? AND Event.Name = ? ";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, ConOng);
                                pst.setString(2, ConBa);
                                pst.setString(3, Nam);
                                pst.setString(4, "Trung thu");
                                rs = pst.executeQuery();
                                int idF = 0, idEv = 0;
                                while(rs.next()){
                                    idF = rs.getInt("ID");
                                    idEv = rs.getInt("ID_E");
                                }
                                
                                insert = "INSERT INTO GIFT(`Gift_Name`, `Cost`) VALUES (?, ?)";
                                pst = con.prepareStatement(insert);
                                pst.setString(1, Qua);
                                pst.setString(2, GiaTri);
                                pst.executeUpdate();
                                
                                insert = "INSERT INTO Achievement(`Achievement_Name`) VALUES (?)";
                                pst = con.prepareStatement(insert);
                                pst.setString(1, "Dịp đặc biệt");
                                pst.executeUpdate();
                                
                                insert = "INSERT INTO Recipient(`Name`, `Age`, `Sex`, `School`, `ID_Family`) "
                                        + "VALUES (?, ?, ?, ?, ?)";
                                pst = con.prepareStatement(insert);
                                pst.setString(1, HoTen);
                                pst.setString(2, Tuoi);
                                pst.setString(3, GioiTinh);
                                pst.setString(4, Truong);
                                pst.setString(5, Integer.toString(idF));
                                pst.executeUpdate();
                                
                                // add row to Receive_Gift table
                                // get id of recipient
                                selectID = "SELECT * FROM Recipient "
                                            + "WHERE Recipient.ID_Family = ?";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, Integer.toString(idF));
                                rs = pst.executeQuery();
                                int idRecipient = -1;
                                while (rs.next()){
                                    idRecipient = rs.getInt("ID");
                                }
                                int idEvent = idEv;
                                int idGift = -1;
                                int idAchievement = -1;
                                // get id of Gift
                                selectID = "SELECT * FROM Gift "
                                            + "WHERE Gift.Gift_Name = ?";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, Qua);
                                rs = pst.executeQuery();
                                while(rs.next()){
                                    idGift = rs.getInt("ID");
                                }
                                
                                // get id of Achievement
                                selectID = "SELECT * FROM Achievement "
                                    + "WHERE Achievement.Achievement_Name = ?";
                                pst = con.prepareStatement(selectID);
                                pst.setString(1, "Dịp đặc biệt");
                                rs = pst.executeQuery();
                                while(rs.next()){
                                    idAchievement = rs.getInt("ID");
                                }

                                insert = "INSERT INTO Receive_Gift"
                                    + "(`ID_Recipient`, `ID_Gift`, `ID_Event`, `ID_Achievement`, `Quantity`) "
                                    + "VALUES (?, ?, ?, ?, ?)";
                                pst = con.prepareStatement(insert);
                                pst.setString(1, Integer.toString(idRecipient));
                                pst.setString(2, Integer.toString(idGift));
                                pst.setString(3, Integer.toString(idEvent));
                                pst.setString(4, Integer.toString(idAchievement));
                                pst.setString(5, SoLuong);
                                pst.executeUpdate();
                    
                                //JOptionPane.showMessageDialog(rootPane, "Đã Lưu !");

                            }
                        }  
                    }
                    else if(checkExistEntity(ConOng, "Father", "Family") == false
                            ||checkExistEntity(ConBa, "Mother", "Family") == false){
                        
                        String select = "SELECT * FROM Event WHERE Event.Name = ? AND Event.Year = ?";
                        pst = con.prepareStatement(select);
                        pst.setString(1, "Trung thu");
                        pst.setString(2, Nam);
                        rs = pst.executeQuery();
                        int idEv = 0;
                        while(rs.next()){
                            idEv = rs.getInt("ID");
                        }
                        
                        insert = "INSERT INTO GIFT(`Gift_Name`, `Cost`) VALUES (?, ?)";
                        pst = con.prepareStatement(insert);
                        pst.setString(1, Qua);
                        pst.setString(2, GiaTri);
                        pst.executeUpdate();
                        
                        insert = "INSERT INTO Family(`Father`, `Mother`, `Address`, `ID_E`)"
                            + "VALUES (?, ?, ?, ?)";
                        pst = con.prepareStatement(insert);
                        pst.setString(1, ConOng);
                        pst.setString(2, ConBa);
                        pst.setString(3, DiaChi);
                        pst.setString(4, Integer.toString(idEv));
                        pst.executeUpdate();
                        
                        insert = "INSERT INTO Achievement(`Achievement_Name`) VALUES (?)";
                        pst = con.prepareStatement(insert);
                        pst.setString(1, "Dịp đặc biệt");
                        pst.executeUpdate();
                        
                        insert = "INSERT INTO Recipient(`Name`, `Age`, `Sex`, `School`, `ID_Family`) "
                            + "VALUES (?, ?, ?, ?, ?)";
                        pst = con.prepareStatement(insert);
                        pst.setString(1, HoTen);
                        pst.setString(2, Tuoi);
                        pst.setString(3, GioiTinh);
                        pst.setString(4, Truong);
                        // select id_family to insert
                        String sel = "SELECT * FROM Family "
                                + "WHERE Father like ? AND Mother like ? AND ID_E = ?";
                        PreparedStatement pst2 = con.prepareStatement(sel);
                        pst2.setString(1, ConOng);
                        pst2.setString(2, ConBa);
                        pst2.setString(3, Integer.toString(idEv));
                        ResultSet idRes = pst2.executeQuery();
                        while(idRes.next()){
                            int idFamily = idRes.getInt("ID");
                            pst.setString(5, Integer.toString(idFamily));
                        }
                        pst.executeUpdate();
                        
                        // add row to Receive_Gift table
                        // get id of recipient
                        String selectID = "SELECT * FROM Recipient, Family "
                                + "WHERE Recipient.ID_Family = Family.ID";
                        pst = con.prepareStatement(selectID);
                        rs = pst.executeQuery();
                        int idRecipient = -1;
                        while (rs.next()){
                            if (rs.getString("Name").equals(HoTen) 
                                    && (rs.getString("Father").equals(ConOng)) 
                                    && (rs.getString("Mother").equals(ConBa)) 
                                    && (rs.getString("Address").equals(DiaChi))){
                                idRecipient = rs.getInt("ID");
                            }
                        }
                        int idEvent = idEv;
                        int idGift = -1;
                        int idAchievement = -1;
                        // get id of Gift
                        selectID = "SELECT * FROM Gift "
                                + "WHERE Gift.Gift_Name = ?";
                        pst = con.prepareStatement(selectID);
                        pst.setString(1, Qua);
                        rs = pst.executeQuery();
                        while(rs.next()){
                            idGift = rs.getInt("ID");
                        }
                        
                        // get id of Achievement
                        selectID = "SELECT * FROM Achievement "
                              + "WHERE Achievement.Achievement_Name = ?";
                        pst = con.prepareStatement(selectID);
                        pst.setString(1, "Dịp đặc biệt");
                        rs = pst.executeQuery();
                        while(rs.next()){
                            idAchievement = rs.getInt("ID");
                        }

                        insert = "INSERT INTO Receive_Gift"
                               + "(`ID_Recipient`, `ID_Gift`, `ID_Event`, `ID_Achievement`, `Quantity`) "
                               + "VALUES (?, ?, ?, ?, ?)";
                        pst = con.prepareStatement(insert);
                        pst.setString(1, Integer.toString(idRecipient));
                        pst.setString(2, Integer.toString(idGift));
                        pst.setString(3, Integer.toString(idEvent));
                        pst.setString(4, Integer.toString(idAchievement));
                        pst.setString(5, SoLuong);
                        pst.executeUpdate();
                        
                        //JOptionPane.showMessageDialog(rootPane, "Đã Lưu !");
                    }   
                }
            }
            catch(Exception ex){
    //            JOptionPane.showMessageDialog(rootPane, ex);
                ex.printStackTrace();
            }
                
                
            }
            //C?p nh?t l?i v? trí b?t ??u update
            int b = Integer.parseInt(line) + values.size() - 1;
            line = String.valueOf(b);
            File ab = new File("src/ql_phan_thuong/TrungThu_Update.txt");
            FileWriter fw = new FileWriter(ab);
            //System.out.println(line);
            fw.write(line+"\n");
            fw.close();
            
        }
    }
}
