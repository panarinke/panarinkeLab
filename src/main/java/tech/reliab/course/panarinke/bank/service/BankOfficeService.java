package tech.reliab.course.panarinke.bank.service;

import tech.reliab.course.panarinke.bank.entity.Bank;
import tech.reliab.course.panarinke.bank.entity.BankOffice;
import tech.reliab.course.panarinke.bank.entity.auxiliary.Address;

public interface BankOfficeService {
    void create(String name, Address address, Bank bank);
    BankOffice getBankOffice(int id);
    void update(int id, Bank bank, BankOffice bankOffice);
    void delete(int id, Bank bank);
}
