package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import model.Users_22162017;
import model.Videos_22162017;

public class DBConnection_22162017 {
    private static final String URL = "jdbc:mysql://localhost:3306/ltwct2"; // Đảm bảo URL đúng
    private static final String USER = "root";
    private static final String PASSWORD = "Khoa081104@";

    // Tải driver JDBC MySQL một lần khi lớp này được nạp
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy MySQL JDBC Driver!");
            e.printStackTrace();
        }
    }

    // Phương thức kết nối cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Phương thức kiểm tra kết nối
    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Kết nối cơ sở dữ liệu thành công!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Không thể kết nối tới cơ sở dữ liệu. Lỗi: " + e.getMessage());
        }
        return false;
    }

    // Phương thức main để kiểm tra kết nối
    public static void main(String[] args) {
        testConnection();
    }

	public List<Videos_22162017> getVideosByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users_22162017> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
