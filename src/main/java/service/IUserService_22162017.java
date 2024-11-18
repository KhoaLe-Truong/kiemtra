package service;

import java.util.List;

import model.Users_22162017;

public interface IUserService_22162017 {
 
    Users_22162017 findByUserName(String username) ;
    void insert(Users_22162017 user);
    void update(Users_22162017 user);
    void delete(int userId);
    long count() ;
    List<Users_22162017> findAll(int page, int pageSize);
	void delete(String username);

}
