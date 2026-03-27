import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MemberdaoImpl implements Memberdao{
    Connection con;
    public void connect(){
        try{
            Connection con =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/onlineexam",
                "root",
                "Aisvarya26"
            );

        System.out.println("Connection done");
        }
        catch(Exception e){
            System.out.println(" Error in connection" +e);
        }
    }

    public void reg(Member m){
        try{
            PreparedStatement ps = con.prepareStatement("insert into member values(?,?)");
            ps.setString(1,m.name);
            ps.setString(2,m.email);
            ps.executeUpdate();
            System.out.println("registered");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
