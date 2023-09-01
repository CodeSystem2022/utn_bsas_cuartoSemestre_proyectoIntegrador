package com.utnbuenosaires.backcompubaires.model.repository;

import com.utnbuenosaires.backcompubaires.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
