package com.elaheh.spring_hibernate.service;

import com.elaheh.spring_hibernate.exceptions.DoNotMatchThisAskDayOffWithThisHeadException;
import com.elaheh.spring_hibernate.exceptions.EmployeeIsNotHeadException;
import com.elaheh.spring_hibernate.model.AskDayOff;
import com.elaheh.spring_hibernate.model.Employee;

import java.util.List;
import java.util.Optional;

public interface AskDayOffService {
    void create(AskDayOff askDayOff);
    Optional<AskDayOff> findById(int id);
    List<AskDayOff> findAll();
    void deleteById(int id);
    void update(AskDayOff askDayOff);
    List<AskDayOff> findAllAskDayOffOneHead(Employee head) throws EmployeeIsNotHeadException;
    void acceptAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;
    void rejectAskDayOff(int askDayOffId, Employee head) throws EmployeeIsNotHeadException, DoNotMatchThisAskDayOffWithThisHeadException;

}
