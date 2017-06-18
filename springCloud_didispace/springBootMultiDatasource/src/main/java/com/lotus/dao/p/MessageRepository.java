package com.lotus.dao.p;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.lotus.entity.p.MessageEntity;

@Service("MessageRepositoryPrimary")
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}