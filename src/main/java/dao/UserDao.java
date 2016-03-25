package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao implements Dao<User> {

	public User findById(String id) {
		return new User();
	}

	public List<User> findAll() {
		return new ArrayList<User>();
	}

	public void save(User e) {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(User e) {
		// TODO Auto-generated method stub
		return false;
	}

}
