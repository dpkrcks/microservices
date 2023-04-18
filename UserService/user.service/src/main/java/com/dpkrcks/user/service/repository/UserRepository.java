package com.dpkrcks.user.service.repository;

import com.dpkrcks.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User , String> {

    //JPA Repository to interact with the entity.

}
