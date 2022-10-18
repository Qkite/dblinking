package seoulhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UserDaoHospital {
    public void add(String[] inputs) throws ClassNotFoundException, SQLException {

        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO seoul_hospital(id, category, emergency,name) VALUES(?, ?, ?,?)");

        ps.setString (1, inputs[0]);
        ps.setString(2, inputs[1]);
        ps.setString(3,inputs[2]);
        ps.setString(4,inputs[3]);

        ps.executeUpdate();
        ps.close();
        conn.close();

    }
}
