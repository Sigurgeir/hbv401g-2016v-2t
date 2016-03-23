import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;

public class Database {
  private String serverName;
  private int port;
  private String db;
  private String username;
  private String password;

  public Database(String s, int p, String d, String user, String pass) {
    serverName = s;
    port = p;
    db = d;
    username = user;
    password = pass;
  }

  Connection connect() {
    Connection c = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager.getConnection("jdbc:postgresql://"+this.serverName+":"+this.port+"/"+this.db,this.username, this.password);
      c.setAutoCommit(false);
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return c;
  }

   List<List<String>> query(String q) {
    Statement stmt = null;
    List<List<String>> result = new ArrayList<>();
    Connection c = this.connect();

    try {
      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(q);

      ResultSetMetaData metadata = rs.getMetaData();
      int numcols = metadata.getColumnCount();

      while (rs.next()) {
        List<String> row = new ArrayList<>(numcols);
        int i = 1;
        while (i <= numcols) {
          row.add(rs.getString(i++));
        }
        result.add(row);
      }
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (c != null) c.close();

    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

    return result;
  }

  void update(String opt, String sql) {
    if (opt.equals("insert") | opt.equals("Insert"))
    {
      Connection c = this.connect();
      Statement stmt = null;
      try {
        stmt = c.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();
        c.close();
      } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
      }
        System.out.println("Records created successfully");
    } else if (opt.equals("update") | opt.equals("Update")) {
        try {
          Connection c = this.connect();
          Statement stmt = null;
          stmt = c.createStatement();
          stmt.executeUpdate(sql);
          c.commit();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
         }
         System.out.println("Operation done successfully");
     }
  }
}
