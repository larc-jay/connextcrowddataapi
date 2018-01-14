package com.connextcrowd.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.connextcrowd.entity.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long>{

}
