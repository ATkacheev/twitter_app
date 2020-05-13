package com.example.letscode.demoletscode.repository;

import com.example.letscode.demoletscode.domain.Message;
import com.example.letscode.demoletscode.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepo extends CrudRepository<Message, Long> {
    Page<Message> findByTag(String tag, Pageable pageable);
    Page<Message> findAll(Pageable pageable);
    Page<Message> findByAuthor(User user, Pageable pageable);
}
