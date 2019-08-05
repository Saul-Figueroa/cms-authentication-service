package com.revature.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.User;
import com.revature.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository= userRepository;
	}


	@Override
	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	@Transactional
	public User getUserById(long userId) {

		//Optional is a java 8 feature
		Optional<User> result = userRepository.findById(userId);
		User user = null;
		
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("Did not find book id "+userId);
		}
		
		return user;
		
	}

	@Override
	@Transactional
	public void updateUserById(User user) {
		
		
	}

	@Override
	@Transactional
	public void deleteUserById(long userId) {
		userRepository.deleteById(userId);
		
	}
	@Override
	@Transactional
	public User Authenticate(User user) {
		User temp= userRepository.findByEmailReturnStream(user.getEmail());
		if(temp.getPassword().equals(user.getPassword())) {
			return temp;
		}
		else {
			return null;
		}
	}

	

}
