package tech.reliab.course.panarinke.bank.service;

import tech.reliab.course.panarinke.bank.entity.Bank;
import tech.reliab.course.panarinke.bank.entity.BankOffice;
import tech.reliab.course.panarinke.bank.entity.Employee;
import tech.reliab.course.panarinke.bank.entity.auxiliary.FCs;

public interface EmployeeService {
    Employee create(FCs fcs, String post, Bank bank, BankOffice office);
    Employee getEmployee(int id);
    void update(int id,Employee employee);
    void delete(Employee employee);
}
