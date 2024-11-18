package service.impl;

import dao.IUserDao_22162017;
import dao.impl.UserDaoImpl_22162017;
import model.Users_22162017;
import service.IUserService_22162017;
import model.Users_22162017;

import java.util.List;

public class UserServiceImpl_22162017 implements IUserService_22162017 {
	// Khởi tạo IUserDao để truy cập dữ liệu người dùng
	private IUserDao_22162017 usersDao = new UserDaoImpl_22162017();


	@Override
	public Users_22162017 findByUserName(String username) {
		// Tìm người dùng theo tên đăng nhập
		return usersDao.findByUserName(username);
	}

	@Override
	public void insert(Users_22162017 user)  {
		// Thêm người dùng vào cơ sở dữ liệu
		usersDao.insert(user);
	}

	@Override
	public void update(Users_22162017 user)  {
		// Cập nhật thông tin người dùng trong cơ sở dữ liệu
		usersDao.update(user);
	}

	@Override
	public void delete(String username) {
		// Xóa người dùng khỏi cơ sở dữ liệu
		usersDao.delete(username);
	}

	@Override
	public long count() {
		// Đếm số lượng người dùng trong cơ sở dữ liệu
		return usersDao.count();
	}

	public List<Users_22162017> findAll(int page, int pageSize)  {
		// Trả về danh sách người dùng theo phân trang
		return usersDao.findAll(page, pageSize);
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		
	}

	public List<Users_22162017> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
