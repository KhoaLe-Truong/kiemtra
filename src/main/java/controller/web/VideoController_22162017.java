package controller.web;

import model.Videos_22162017;
import service.impl.VideoServiceImpl_22162017;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/video/detail")
public class VideoController_22162017 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VideoServiceImpl_22162017 videoService;

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl_22162017();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy tham số videoId từ request
        String videoIdParam = req.getParameter("videoId");

        // Kiểm tra nếu videoId không hợp lệ
        if (videoIdParam == null || videoIdParam.isEmpty()) {
            req.setAttribute("errorMessage", "Không tìm thấy video.");
            req.getRequestDispatcher("/views/web/error.jsp").forward(req, resp);
            return;
        }

        try {
            int videoId = Integer.parseInt(videoIdParam);

            // Tìm video theo ID
            Videos_22162017 video = videoService.findById(videoId);

            if (video == null) {
                req.setAttribute("errorMessage", "Video không tồn tại.");
                req.getRequestDispatcher("/views/web/error.jsp").forward(req, resp);
                return;
            }

            // Gửi dữ liệu video tới view
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/web/video-detail.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "ID video không hợp lệ.");
            req.getRequestDispatcher("/views/web/error.jsp").forward(req, resp);
        }
    }
}
