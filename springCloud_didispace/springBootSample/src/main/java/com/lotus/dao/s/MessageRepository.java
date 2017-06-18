package com.lotus.dao.s;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lotus.entity.s.MessageEntity;
import org.springframework.stereotype.Service;

@Service("MessageRepositorySecond")
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}