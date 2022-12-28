package Projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLAcess {
    public void testeConexao() {
        try{
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://database-projecto-1.cay7nfvgkhss.eu-west-2.rds.amazonaws.com:3306/QsTrabalho","admin","projecto2022");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Docente");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  " +rs.getString(3) +"  "+rs.getInt(4) + "  "  + rs.getInt(5) );
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}


