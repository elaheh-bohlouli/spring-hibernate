package com.elaheh.spring_hibernate.repository;

import com.elaheh.spring_hibernate.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository  extends JpaRepository<Email, Integer> {
}
