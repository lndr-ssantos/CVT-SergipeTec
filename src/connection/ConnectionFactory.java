package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConnectionFactory {
    // DRIVER MYSQL (DRIVER - URL - USUARIO - SENHA)
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.0.26:3306/cvt?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String USER = "sergipetec";
    private static final String PASS = "Sergipetec@@2010";
    
    
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }               
    } 
    
    // FAZ A 1º SOBRECARGA 
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
        }
        }catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }       
    } 
           
    
    // FAZ A 2º SOBRECARGA
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
        } 
        }catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }       
    }
}