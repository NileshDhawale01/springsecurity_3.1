package com.nsd.datasource.repositoryes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsd.datasource.entities.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByName(String name);
}
