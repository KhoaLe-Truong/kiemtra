package dao.impl;

import model.Videos_22162017;
import model.Category_22162017;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.DBConnection_22162017;
import dao.IVideoDao_22162017;

public class VideoDao_22162017 extends DBConnection_22162017 implements IVideoDao_22162017{
    private Connection conn;

    public VideoDao_22162017(Connection conn) {
        this.conn = conn;
    }

    // Phương thức tìm video theo videoId
    public Videos_22162017 findVideoById(String id) {
        Videos_22162017 video = null;
        String sql = "SELECT v.videoId, v.title, v.poster, v.views, v.description, v.active, " +
                "c.categoryId, c.categoryName " +
                "FROM videos v " +
                "JOIN category c ON v.category_CategoryId = c.categoryId " +
                "WHERE v.videoId = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                video = new Videos_22162017();
                video.setVideoId(rs.getString("videoId"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));

                // Tạo đối tượng Category và thiết lập các giá trị
                Category_22162017 category = new Category_22162017();
                category.setCategoryId(Integer.parseInt(rs.getString("categoryId")));
                category.setCategoryName(rs.getString("categoryName"));
                video.setCategory(category);  // Gán Category vào video
                System.out.println("Category: " + category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(video);
        return video;
    }
}
