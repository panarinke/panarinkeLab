package tech.reliab.course.panarinke.bank.service;

import tech.reliab.course.panarinke.bank.entity.Bank;
import tech.reliab.course.panarinke.bank.entity.PaymentAccount;
import tech.reliab.course.panarinke.bank.entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface PaymentAccountService {
    PaymentAccount create(User user, Bank bank);
    PaymentAccount getPaymentAccount(int id);
    void update(int userId, int id, PaymentAccount paymentAccount, User user);
    void delete(int userId, int id, PaymentAccount paymentAccount, User user);
    void writeToFile(ArrayList<PaymentAccount> paymentAccounts, String fileName) throws IOException;
    ArrayList<PaymentAccount> readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
