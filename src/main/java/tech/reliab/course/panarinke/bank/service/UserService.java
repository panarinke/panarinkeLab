package tech.reliab.course.panarinke.bank.service;

import tech.reliab.course.panarinke.bank.entity.Bank;
import tech.reliab.course.panarinke.bank.entity.CreditAccount;
import tech.reliab.course.panarinke.bank.entity.PaymentAccount;
import tech.reliab.course.panarinke.bank.entity.User;
import tech.reliab.course.panarinke.bank.entity.auxiliary.FCs;

import java.util.ArrayList;

public interface UserService {
    User create(FCs fcs, String workPlace, Bank bank);
    User getUser(int id);
    void update(int id, User user);
    void delete(int id);

    void addBank(int id, Bank bank);
    void deleteBank(int id, Bank bank);

    void addCreditAccount(int id, CreditAccount creditAccount);
    void deleteCreditAccount(int id, CreditAccount creditAccount);

    void addPaymentAccount(int id, PaymentAccount paymentAccount);
    void deletePaymentAccount(int id, PaymentAccount paymentAccount);

    ArrayList<User> getUsers();
}
