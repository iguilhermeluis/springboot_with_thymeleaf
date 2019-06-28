package com.guilherme.ezentis.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.ezentis.model.Profile;
public interface ProfileRepository  extends JpaRepository<Profile, Integer>{

}
