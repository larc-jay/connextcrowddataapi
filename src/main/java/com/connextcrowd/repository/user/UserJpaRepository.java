package com.connextcrowd.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.connextcrowd.entity.Users;

public interface UserJpaRepository extends JpaRepository<Users, Long> {
	@Query("select u from users u where u.username = ? AND password = ?")
	public Users userLogin(@Param("username") String username, @Param("password") String password);

}
