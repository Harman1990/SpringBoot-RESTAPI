package com.harmanLabs.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	
	private static Integer usersCount=0;
	
	static {
		
		users.add(new User(++usersCount,"Harman",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Daman",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Manni",LocalDate.now().minusYears(20)));
		
	}
	
	
	public List<User> findAll(){
		
		return users;
	}


	public User findOne(Integer id) {

		Predicate<? super User> predicate= user -> user.getId().equals(id);
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteByID(Integer id) {

		Predicate<? super User> predicate= user -> user.getId().equals(id);
		
		 users.removeIf(predicate);
	}


	public User save(User user) {
		// TODO Auto-generated method stub
		
		user.setId(++usersCount);
		users.add(user);
		
		return user;
		
		
	}
	
	
}
