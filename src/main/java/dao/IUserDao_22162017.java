package dao;

import java.util.List;

import model.CategoryVideoCount_22162017;
import model.Users_22162017;

public interface IUserDao_22162017 {
	
	    Users_22162017 findByUserName(String username); 
	    void insert(Users_22162017 user) ;
	    void update(Users_22162017 user) ;
	    void delete(String userId);
	    long count() ;
	    List<Users_22162017> findAll(int page, int pageSize);
		
		
	
}
