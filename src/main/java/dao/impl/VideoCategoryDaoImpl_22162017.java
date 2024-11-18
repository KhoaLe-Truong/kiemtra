package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection_22162017;
import dao.IVideoCategoryDao_22162017;
import model.CategoryVideoCount_22162017;
import model.Category_22162017;
import model.Videos_22162017;

public class VideoCategoryDaoImpl_22162017 extends DBConnection_22162017 implements IVideoCategoryDao_22162017 {

    @Override
    public List<Videos_22162017> getVideosByCategory(int categoryId) {
        List<Videos_22162017> videos = new ArrayList<>();
        String query = "SELECT v.videoId, v.title, v.poster, v.views, v.description, v.active, " +
                       "v.category_CategoryId, c.categoryName " +
                       "FROM Videos v " +
                       "JOIN Category c ON v.category_CategoryId = c.categoryId " +
                       "WHERE v.category_CategoryId = ?";

        try (Connection connection = getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setInt(1, categoryId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Videos_22162017 video = new Videos_22162017();
                    video.setVideoId(rs.getString("videoId"));
                    video.setTitle(rs.getString("title"));
                    video.setPoster(rs.getString("poster"));
                    video.setViews(rs.getInt("views"));
                    video.setDescription(rs.getString("description"));
                    video.setActive(rs.getBoolean("active"));

                    // Gán thông tin danh mục cho video
                    Category_22162017 category = new Category_22162017();
                    category.setCategoryId(rs.getInt("category_CategoryId"));
                    category.setCategoryName(rs.getString("categoryName"));
                    video.setCategory(category);

                    videos.add(video);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    @Override
    public List<CategoryVideoCount_22162017> getVideoCountByCategory() {
        List<CategoryVideoCount_22162017> videoCounts = new ArrayList<>();
        String query = "SELECT c.categoryName AS category_name, COUNT(v.videoId) AS video_count " +
                       "FROM Category c " +
                       "LEFT JOIN Videos v ON c.categoryId = v.category_CategoryId " +
                       "GROUP BY c.categoryName";

        try (Connection conn = getConnection(); 
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                String categoryName = rs.getString("category_name");
                int videoCount = rs.getInt("video_count");
                videoCounts.add(new CategoryVideoCount_22162017(categoryName, videoCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videoCounts;
    }

    @Override
    public List<Category_22162017> getAllCategories() {
        List<Category_22162017> categories = new ArrayList<>();
        String query = "SELECT categoryId, categoryName FROM Category";

        try (Connection conn = getConnection(); 
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category_22162017 category = new Category_22162017();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
