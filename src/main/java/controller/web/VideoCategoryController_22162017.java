package controller.web;

import service.impl.VideoCategoryServiceImpl_22162017;
import model.CategoryVideoCount_22162017;
import model.Category_22162017;
import model.Videos_22162017;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/videos/category")
public class VideoCategoryController_22162017 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VideoCategoryServiceImpl_22162017 videoService;

    @Override
    public void init() throws ServletException {
        videoService = new VideoCategoryServiceImpl_22162017();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy danh sách tất cả categories
        List<Category_22162017> categories = videoService.getAllCategories();
        req.setAttribute("categories", categories);

        // Lấy tham số categoryId từ request
        String categoryIdParam = req.getParameter("category_CategoryId");

        // Xử lý giá trị categoryId (kiểm tra null, rỗng, không hợp lệ)
        int categoryId = 1; // Giá trị mặc định
        try {
            if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
                categoryId = Integer.parseInt(categoryIdParam);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "ID danh mục không hợp lệ!");
        }

        // Lấy danh sách video theo category
        List<Videos_22162017> videos = videoService.getVideosByCategory(categoryId);
        req.setAttribute("videos", videos);

        // Kiểm tra nếu không có video nào trong danh mục
        if (videos == null || videos.isEmpty()) {
            req.setAttribute("noVideosMessage", "Không có video nào trong danh mục này.");
        }

        // Lấy số lượng video theo từng danh mục
        List<CategoryVideoCount_22162017> videoCounts = videoService.getVideoCountByCategory();
        req.setAttribute("videoCounts", videoCounts);

        // Chuyển tiếp request và response tới trang JSP
        req.getRequestDispatcher("/views/web/videos-category.jsp").forward(req, resp);
    }
}
