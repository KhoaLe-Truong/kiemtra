package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection_22162017;
import dao.IUserDao_22162017;
import model.Users_22162017;

public class UserDaoImpl_22162017 extends DBConnection_22162017 implements IUserDao_22162017 {
    @Override
    public List<Users_22162017> findAll(int page, int pageSize) {
        String query = "SELECT * FROM Users ORDER BY username LIMIT ? OFFSET ?";
        int offset = page * pageSize; // Adjusted for page starting at 0

        List<Users_22162017> list = new ArrayList<>();
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Users_22162017 user = extractUser(rs);
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Users_22162017> findAll() {
        String query = "SELECT * FROM Users";
        List<Users_22162017> list = new ArrayList<>();
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Users_22162017 user = extractUser(rs);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Users_22162017 user) {
        String query = "INSERT INTO Users(username, password, phone, fullname, email, admin, active, images) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            setPreparedStatement(ps, user);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users_22162017 user) {
        String query = "UPDATE Users SET password = ?, phone = ?, fullname = ?, email = ?, admin = ?, active = ?, images = ? WHERE username = ?";
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            setPreparedStatement(ps, user);
            ps.setString(8, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        String deleteSharesQuery = "DELETE FROM Shares WHERE user_username = ?";
        String deleteUserQuery = "DELETE FROM Users WHERE username = ?";
        try (Connection conn = super.getConnection();
             PreparedStatement psShares = conn.prepareStatement(deleteSharesQuery);
             PreparedStatement psUser = conn.prepareStatement(deleteUserQuery)) {

            psShares.setString(1, username);
            psShares.executeUpdate();

            psUser.setString(1, username);
            psUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long count() {
        String query = "SELECT COUNT(*) FROM Users";
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Users_22162017 findByUserName(String username) {
        String query = "SELECT * FROM Users WHERE username = ?";
        try (Connection conn = super.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Users_22162017 extractUser(ResultSet rs) throws SQLException {
        Users_22162017 user = new Users_22162017();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));
        user.setFullname(rs.getString("fullname"));
        user.setEmail(rs.getString("email"));
        user.setAdmin(rs.getBoolean("admin"));
        user.setActive(rs.getBoolean("active"));
        user.setImages(rs.getString("images"));
        return user;
    }

    private void setPreparedStatement(PreparedStatement ps, Users_22162017 user) throws SQLException {
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getPhone());
        ps.setString(3, user.getFullname());
        ps.setString(4, user.getEmail());
        ps.setBoolean(5, user.getAdmin());
        ps.setBoolean(6, user.getActive());
        ps.setString(7, user.getImages());
    }
}
