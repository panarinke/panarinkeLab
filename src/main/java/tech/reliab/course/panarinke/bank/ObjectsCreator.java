package tech.reliab.course.panarinke.bank;

import tech.reliab.course.panarinke.bank.entity.BankOffice;
import tech.reliab.course.panarinke.bank.entity.auxiliary.Address;
import tech.reliab.course.panarinke.bank.entity.auxiliary.FCs;
import tech.reliab.course.panarinke.bank.service.*;

import java.time.LocalDate;
import java.util.Random;

public class ObjectsCreator {

    public final BankService bankService;
    public final AtmService atmService;
    public final BankOfficeService bankOfficeService;
    public final UserService userService;
    public final EmployeeService employeeService;
    public final CreditAccountService creditAccountService;
    public final PaymentAccountService paymentAccountService;

    private final Address address;

    public ObjectsCreator(
            BankService bankService,
            AtmService atmService,
            BankOfficeService bankOfficeService,
            UserService userService,
            EmployeeService employeeService,
            CreditAccountService creditAccountService,
            PaymentAccountService paymentAccountService,
            Address address
    ) {
        this.bankService = bankService;
        this.atmService = atmService;
        this.bankOfficeService = bankOfficeService;
        this.userService = userService;
        this.employeeService = employeeService;
        this.paymentAccountService = paymentAccountService;
        this.creditAccountService = creditAccountService;
        this.address = address;

    }

    public void create() {
        var random = new Random();

        int bankCount = random.nextInt(5, 10);

        for (int i = 0; i < bankCount; i++) {
            var bank = this.bankService.createBank("Bank " + i);

            int bankOfficeCount = random.nextInt(5, 20);

            for (int j = 0; j < bankOfficeCount; j++) {
                var bankOffice = this.bankOfficeService.create(
                        "BankOffice" + j,
                        this.address,
                        bank
                );

                var user = userService.create(
                        new FCs("Igor", "Sheplyakov", "Alexandrovich"),
                        "Programmer",
                        bank
                );
                var paymentAccountCount = 4;
                for (int p = 0; p < paymentAccountCount; p++) {
                    var paymentAccount = paymentAccountService.create(
                            user,
                            bank
                    );
                }

                int employeesCount = random.nextInt(5, 10);

                for (int k = 0; k < employeesCount; k++) {
                    this.employeeService.create(
                            new FCs("Test", "Testov", "Testovich"),
                            "Manager",
                            bank,
                            bankOffice
                    );
                }
            }
        }
    }
}