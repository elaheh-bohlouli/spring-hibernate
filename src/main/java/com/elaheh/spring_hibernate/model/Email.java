package com.elaheh.spring_hibernate.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_Email")
public class Email extends Entities {

    @Column(name = "c_text")
    private String text;


    @ManyToOne
    @JoinColumn(name = "c_employee")
    private Employee employee;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mm_email_employee",
            joinColumns = {@JoinColumn(name = "c_mail")},
            inverseJoinColumns = {@JoinColumn(name = "c_employee")})
    private Set<Employee> receivers;

    @ManyToOne
    @JoinColumn(name="c_categoryElements")
    private CategoryElements categoryElements;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Employee> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Employee> receivers) {
        this.receivers = receivers;
    }

    public CategoryElements getCategoryElements() {
        return categoryElements;
    }

    public void setCategoryElements(CategoryElements categoryElements) {
        this.categoryElements = categoryElements;
    }
}
