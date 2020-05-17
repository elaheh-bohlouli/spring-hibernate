package com.elaheh.spring_hibernate.service.serviceClass;


import com.elaheh.spring_hibernate.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.elaheh.spring_hibernate.exceptions.EmployeeIsNotHeadException;
import com.elaheh.spring_hibernate.model.AskDayOff;
import com.elaheh.spring_hibernate.model.CategoryElements;
import com.elaheh.spring_hibernate.model.Employee;
import com.elaheh.spring_hibernate.repository.AskDayOffRepository;
import com.elaheh.spring_hibernate.repository.CategoryElementRepository;
import com.elaheh.spring_hibernate.service.AskDayOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@Service
public class AskDayOffServiceClass implements AskDayOffService {

    @Autowired
    private AskDayOffRepository askDayOffRepository;
    @Autowired
    private CategoryElementRepository categoryElementRepository;


    @Override
    public void create(AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @Override
    public Optional<AskDayOff> findById(int id) {
        return askDayOffRepository.findById(id);
    }

    @Override
    public List<AskDayOff> findAll() {
        return askDayOffRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        askDayOffRepository.deleteById(id);
    }

    @Override
    public void update(AskDayOff askDayOff) {
        askDayOffRepository.save(askDayOff);
    }

    @Override
    public List<AskDayOff> findAllAskDayOffOneHead(Employee head) throws EmployeeIsNotHeadException {
        List<AskDayOff> askDayOffList = new ArrayList();
        if (!head.getCategoryElements().getRole().equals("head")) {
            throw new EmployeeIsNotHeadException();
        } else {
            Stream<AskDayOff> askDayOffStream = askDayOffRepository.findAll().stream()
                    .filter(askDayOff -> askDayOff.getEmployee().getHead().equals(head));
            askDayOffList.addAll(askDayOffList);
        }
        return askDayOffList;
    }

    @Override
    public void acceptAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOffOneHead(head)) {
            if (askDayOff.getId() != askDayOffId) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElements accepted = (CategoryElements) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("accepted"));
                askDayOff.setCategoryElements(accepted);
            }
        }
        ;
    }

    @Override
    public void rejectAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException {
        for (AskDayOff askDayOff : findAllAskDayOffOneHead(head)) {
            if (askDayOff.getId() != askDayOffId) {
                throw new DoNotMatchThisAskDayOffWithThisHeadException();
            } else {
                CategoryElements accepted = (CategoryElements) categoryElementRepository.findAll().stream()
                        .filter(categoryElements -> categoryElements.getRole().equals("rejected"));
                askDayOff.setCategoryElements(accepted);
            }
        }
        ;
    }
}