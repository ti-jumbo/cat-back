package com.jumboalimentos.SystemCallAndTask;

import com.jumboalimentos.SystemCallAndTask.entities.TextMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextMessageRepository extends JpaRepository<TextMessage, Long> {
}
