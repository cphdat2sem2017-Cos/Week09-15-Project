package data;

import data.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.entity.User;
import service.exceptions.PolygonException;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 8, 2016
 */
public class UserMapper {

    public static List<User> getUsers() throws PolygonException {
        List<User> users = new ArrayList();
        try {
            Connection conn = DB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                users.add(new User(username, password));
            }
        } catch (SQLException ex) {
            throw new PolygonException("Some problem with getUsers");
        }
        return users;
    }

    public static User getUser(int id) throws PolygonException {
        User user = null;
        try {
            PreparedStatement pstmt = DB.getConnection().prepareStatement("SELECT * FROM user WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(username, password);
            } else {
                throw new PolygonException("No user found with id: "+id);
            }
        } catch (SQLException ex) {
            throw new PolygonException("Problem in getUser method: "+ex.getMessage());
        }
        return user;
    }
    public static void main(String[] args) {
        try {
            getUser(100000);
        } catch (PolygonException ex) {
            ex.printStackTrace();
        }
    }
}
