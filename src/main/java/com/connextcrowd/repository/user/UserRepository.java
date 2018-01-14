package com.connextcrowd.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.connextcrowd.entity.Users;


public interface UserRepository extends CrudRepository<Users, Long>{

}
