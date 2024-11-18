package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Users_22162017 {
    public Users_22162017() {
		// TODO Auto-generated constructor stub
	}
	private String username;
    private String password;
    private String phone;
    private String fullname;
    private String email;
    private Boolean admin;
    private Boolean active;
    private String images;
	
}
