package com.gst.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.gst.model.User;


public interface UserService extends UserDetailsService{
	List<User> userList();

	User findOne(Integer id);

	User addUser(User user);

	String deleteUser(Long id);
}
