import java.sql.*;

public class Jdbc_con {
    
        Connection c;
        Statement s;
        public Jdbc_con(){  
            try{  
                Class.forName("com.mysql.cj.jdbc.Driver");  
                c =DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Abir@2004");    
                s =c.createStatement(); 
                System.out.println("Database Connected");
               
              
                
            }catch(Exception e){ 
                System.out.println(e);
            }  
        }  

    }

