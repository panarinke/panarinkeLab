package tech.reliab.course.panarinke.bank;


import tech.reliab.course.panarinke.bank.entity.*;
import tech.reliab.course.panarinke.bank.entity.auxiliary.Address;
import tech.reliab.course.panarinke.bank.exceptions.NotFoundException;
import tech.reliab.course.panarinke.bank.exceptions.ObjectAccessException;
import tech.reliab.course.panarinke.bank.service.impl.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Lab4 {

    ObjectsCreator objectsCreator;
    Scanner scanner = new Scanner(System.in);
    Address address = new Address(
            "Russia",
            "Saint Petersburg",
            "Vokzalnaya",
            "33a"
    );

    public void run() {
        objectsCreator = new ObjectsCreator(
                new BankServiceImpl(),
                new AtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new UserServiceImpl(),
                new EmployeeServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl(),
                address
        );

        objectsCreator.create();
        int choose = -1;
        while (choose != 0) {

            System.out.println(
                    """
                            Choose one of the actions:
                            1 - Output payment by id into file
                            2 - Transfer all paymentAccounts from file to bank by id
                            3 - Read info from file
                            0 - Exit
                            """
            );

            choose = scanner.nextInt();

            //C:\Users\yakpa\Test.txt
            switch (choose) {
                case 1 -> outputPaymentByIdToFile();
                case 2 -> transferAllPaymentAccountsFromFileToBankById();
                case 3 -> readFileInfo();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void outputPaymentByIdToFile() {
        System.out.println("Enter the user ID");
        var userid = scanner.nextInt();

        System.out.println("Enter the file path");
        String fileName = scanner.next();

        if (objectsCreator.userService.getUser(userid) == null) {
            throw new NotFoundException(userid, User.class.getSimpleName());
        }

        try {
            var paymentAccounts = objectsCreator.userService.getUser(userid).getPaymentAccounts();
            objectsCreator.paymentAccountService.writeToFile(paymentAccounts, fileName);
        } catch (IOException e) {
            System.out.println("Error input: " + e);
        }
    }

    private void transferAllPaymentAccountsFromFileToBankById() {
        ArrayList<PaymentAccount> paymentAccounts = null;

        System.out.println("Enter the bank ID");
        var bankId = scanner.nextInt();

        System.out.println("Enter the path of the file");
        var fileName = scanner.next();

        System.out.println("Enter the ID of the billing account");
        var paymentAccountId = scanner.nextInt();

        try {
            paymentAccounts = objectsCreator.paymentAccountService.readFromFile(fileName);
            for (var pa : paymentAccounts) {
                System.out.println(pa);
            }
        } catch (IOException e) {
            System.out.println("Input error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("The file has incorrect: " + e);
        }

        var paymentAccount = objectsCreator.paymentAccountService.getPaymentAccount(paymentAccountId);
        if (paymentAccount == null) {
            throw new NotFoundException(paymentAccountId, PaymentAccount.class.getSimpleName());
        }

        if (paymentAccounts != null) {
            objectsCreator.bankService.transferAccounts(paymentAccount, bankId);
        } else {
            throw new ObjectAccessException(PaymentAccount.class.getSimpleName(), "object is null");
        }
    }

    private void readFileInfo() {
        System.out.println("Enter the path of the file");
        var fileName = scanner.next();

        try {
            var paymentAccounts = objectsCreator.paymentAccountService.readFromFile(fileName);
            for (var paymentAccount : paymentAccounts) {
                System.out.println(paymentAccount);
            }
        } catch (IOException e) {
            System.out.println("Input error: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("The file has incorrect: " + e);
        }
    }
}
