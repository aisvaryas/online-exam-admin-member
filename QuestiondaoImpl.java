import java.sql.PreparedStatement;
import java.sql.ResultSet;

// import com.mysql.cj.protocol.Resultset;

public class Questiondao implements Question{
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

    public void addq(Question q){
        try{
            PreparedStatement ps= con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
            ps.setInt(1,q.id);
            ps.setString(2,q.text);
            ps.setString(3, q.a);
            ps.setString(4, q.b);
            ps.setString(5, q.c);
            ps.setString(6, q.d);
            ps.setString(7, q.answer);

             ps.executeUpdate();
             
             System.out.println("added");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateq(int id,String text){
        try{
            PreparedStatement ps= con.prepareStatement("update member set text=? where id=?");
            ps.setString(1, text);
            ps.setInt(2, id);
            ps.executeUpdate();
             System.out.println("updated");

        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    public void viewq(){
        try{
            PreparedStatement ps =con.prepareStatement("select * from question");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                System.out.println(
                rs.getInt("qid")+ " "+
                rs.getString("qtext")+ " "+
                rs.getString("a")+ " "+
                rs.getString("b")+ " "+
                rs.getString("c")+ " "+
                rs.getString("d"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void qspaper(){
        try{
            PreparedStatement ps = con.prepareStatement("select * from question");
            Resultset rs= ps.executeQuery();
            int score =0;
            int total=0;

            while(rs.next()){
                total++;
                System.out.println(
                rs.getInt("qid")+ " "+
                rs.getString("qtext")+ " "+
                rs.getString("a")+ " "+
                rs.getString("b")+ " "+
                rs.getString("c")+ " "+
                rs.getString("d"));

                System.out.println("enter ans:");
                char ans= sc.next();

                char correct= rs.getString("ans");

                if(Character.toLowerCase(ans)==correct){
                    score++;
                }


            }
            System.out.println("SCore" + score +"/"+total);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }





}