package controller.admin;

import java.io.IOException;
import java.util.List;

import model.Users_22162017;
import service.IUserService_22162017;
import service.impl.UserServiceImpl_22162017;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
    "/admin/users", 
    "/admin/user/add", 
    "/admin/user/insert", 
    "/admin/user/edit", 
    "/admin/user/update",
    "/admin/user/delete"
})
public class UserController_22162017 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final IUserService_22162017 userSer = new UserServiceImpl_22162017();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            if (url.contains("users")) {
                handleUserList(req, resp);
            } else if (url.contains("add")) {
                req.getRequestDispatcher("/views/admin/users-add.jsp").forward(req, resp);
            } else if (url.contains("edit")) {
                handleEditUser(req, resp);
            } else if (url.contains("delete")) {
                handleDeleteUser(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred: " + e.getMessage());
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            if (url.contains("insert")) {
                handleInsertUser(req, resp);
            } else if (url.contains("update")) {
                handleUpdateUser(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred: " + e.getMessage());
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
        }
    }

    private void handleUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        String pageStr = req.getParameter("page");
        if (pageStr != null && !pageStr.isEmpty()) {
            try {
                page = Integer.parseInt(pageStr);
                if (page < 0) page = 0;
            } catch (NumberFormatException e) {
                page = 0;
            }
        }
        int pageSize = 6;
        long totalUsers = userSer.count();
        int totalPages = (int) Math.max(1, Math.ceil((double) totalUsers / pageSize));
        if (page >= totalPages) {
            page = totalPages - 1;
        }
        List<Users_22162017> list = userSer.findAll(page, pageSize);

        req.setAttribute("listUser", list);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("/views/admin/users-list.jsp").forward(req, resp);
    }

    private void handleEditUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if (username != null && !username.isEmpty()) {
            Users_22162017 user = userSer.findByUserName(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/admin/users-edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        }
    }

    private void handleDeleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        if (username != null && !username.isEmpty()) {
            userSer.delete(username);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }

    private void handleInsertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
            Boolean active = Boolean.parseBoolean(req.getParameter("active"));
            String images = req.getParameter("images");

            Users_22162017 user = new Users_22162017();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setAdmin(admin);
            user.setActive(active);
            user.setImages(images);

            userSer.insert(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        } catch (Exception e) {
            req.setAttribute("error", "Failed to add user: " + e.getMessage());
            req.getRequestDispatcher("/views/admin/users-add.jsp").forward(req, resp);
        }
    }

    private void handleUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
            Boolean active = Boolean.parseBoolean(req.getParameter("active"));
            String images = req.getParameter("images");

            Users_22162017 user = new Users_22162017();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setAdmin(admin);
            user.setActive(active);
            user.setImages(images);

            userSer.update(user);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        } catch (Exception e) {
            req.setAttribute("error", "Failed to update user: " + e.getMessage());
            req.getRequestDispatcher("/views/admin/users-edit.jsp").forward(req, resp);
        }
    }
}
