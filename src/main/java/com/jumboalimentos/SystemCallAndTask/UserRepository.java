package com.jumboalimentos.SystemCallAndTask;

import com.jumboalimentos.SystemCallAndTask.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndAccessKey(String email, String accessKey);
}
