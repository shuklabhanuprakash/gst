package com.gst.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gst.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUserName(String userName);

	
}
