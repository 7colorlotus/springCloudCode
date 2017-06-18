package com.lotus.dao.s;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.lotus.entity.s.MessageEntity;

@Service("MessageRepositorySecond")
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}