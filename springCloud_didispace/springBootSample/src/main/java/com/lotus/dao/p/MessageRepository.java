package com.lotus.dao.p;

import com.lotus.entity.p.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("MessageRepositoryPrimary")
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}