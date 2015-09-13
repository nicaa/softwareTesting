/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Validator.ValidateUser;
import encryption.Encrypt;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nichlas
 */
public class DBConnect {

    private java.sql.Connection con;
    private String DBURL = "jdbc:mysql://localhost:3306/wslogin";
    private String user = "root";
    private String PW = "1234";
    private Encrypt encrypt = new Encrypt();
    private ValidateUser validate = new ValidateUser();

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DBURL, user, PW);
            System.out.println("DB Connected");
        } catch (Exception e) {
            System.out.println("ERROR IN DB CONNECT");
        }
    }

    public boolean registration(String username,String emailIn, String password ) {
        boolean userDontExist = true;
        try {
            if (validate.validateUsername(username)== false || validate.validateEmail(emailIn)== false || validate.validatePassword(password)== false) {
                
                System.out.println("Error In userValidate");
                return false;
            }
            if(chechIfUserExist(username)){
                System.out.println("User Exist in DB");
                
                return false;
            }else{    
                con = DriverManager.getConnection(DBURL, user, PW);
                String salt = encrypt.getSalt();
                String usern = username;
                String email = emailIn;
                String passw = encrypt.sha256(password + salt);

                String query = "insert into login (username , email ,password , salt)" + " values(?,?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, usern);
                preparedStmt.setString(2, email);
                preparedStmt.setString(3, passw);
                preparedStmt.setString(4, salt);
                preparedStmt.execute();
                con.close();
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in Insert into");
        }
        return userDontExist;
    }

    public boolean login(String username, String password) {
        //Select user from db based on uniqe username
        //get the salt en encrypt password to see if it matches the password givin in parameter.
        //return true if it does and false if no true gives access to app false dont.
        boolean access = false;
        
        String dbUsername = "";
        String dbSalt = "";
        String dbPassword = "";
        
        try {
            con = DriverManager.getConnection(DBURL, user, PW);
            PreparedStatement st = con.prepareStatement("select * from login where username = '" + username + "'");
            ResultSet r1 = st.executeQuery();
            while (r1.next()) {
                dbUsername = r1.getString("username");
                dbSalt = r1.getString("salt");
                dbPassword = r1.getString("password");
            }
            
            String passw = encrypt.sha256(password + dbSalt);
            if (username.equalsIgnoreCase(dbUsername) && passw.equals(dbPassword)) {
                access = true;
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in CheckUserExistMethod");
        }
        
        return access;
    }

    public boolean chechIfUserExist(String username) {
        //Returns True if user is found.
        boolean exist = false;
        try {
            con = DriverManager.getConnection(DBURL, user, PW);
            PreparedStatement st = con.prepareStatement("select username from login where username = '" + username + "'");
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                exist = true;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in CheckUserExistMethod");
        }
        return exist;
    }

    public List getData() {
        List<String> list = new ArrayList<String>();
        try {

            String query = "select * from login;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString(1);
                String username = rs.getString(2);
                String pass = rs.getString(3);
                System.out.println(id + " " + username + " " + pass);
                list.add(id + " " + username + " " + pass);
            }

        } catch (Exception e) {
            System.out.println("ERROR IN GET DATA");
        }
        return list;
    }

}
