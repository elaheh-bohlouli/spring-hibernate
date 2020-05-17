package com.elaheh.spring_hibernate.service.serviceClass;

import com.elaheh.spring_hibernate.model.Email;
import com.elaheh.spring_hibernate.repository.EmailRepository;
import com.elaheh.spring_hibernate.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceClass implements EmailService {


    @Autowired
    private EmailRepository emailRepository;


    @Override
    public void create(Email email) {
        emailRepository.save(email);
    }

    @Override
    public Optional<Email> findById(int id) {
        return emailRepository.findById(id);
    }


    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        emailRepository.deleteById(id);
    }

}

