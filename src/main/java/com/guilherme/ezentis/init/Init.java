package com.guilherme.ezentis.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.guilherme.ezentis.model.Profile;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.ProfileRepository;
import com.guilherme.ezentis.repository.UserRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ProfileRepository proRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		Profile pf1 = new Profile(); 
		pf1.setName("admin");
		pf1.setId(1);
		
		Profile pf2 = new Profile(); 
		pf2.setName("collaborator");
		pf2.setId(2);
		
		User user1 = new User();
		
		proRepo.saveAll(Arrays.asList(pf1, pf2));
		
		
	}

}
