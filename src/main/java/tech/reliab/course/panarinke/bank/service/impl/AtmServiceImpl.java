package tech.reliab.course.panarinke.bank.service.impl;

import tech.reliab.course.panarinke.bank.entity.Bank;
import tech.reliab.course.panarinke.bank.entity.BankAtm;
import tech.reliab.course.panarinke.bank.entity.BankOffice;
import tech.reliab.course.panarinke.bank.entity.Employee;
import tech.reliab.course.panarinke.bank.enums.WorkStatus;
import tech.reliab.course.panarinke.bank.service.AtmService;

import java.util.ArrayList;

import java.util.Random;

public class AtmServiceImpl implements AtmService {

    private long id = 0;
    private final ArrayList<BankAtm> bankAtms = new ArrayList<>(0);

    /**
     * @param name     Имя банкомата.
     * @param bank     Банк, которому принадлежит банкомат.
     * @param office   Офис, в котором находится банкомат.
     * @param employee Обслуживающий сотрудник.
     */
    @Override
    public void create(String name, Bank bank, BankOffice office, Employee employee) {
        Random random = new Random();

        BankAtm bankAtm = BankAtm
                .builder()
                .id(id++)
                .name(name)
                .location(office.getAddress())
                .status(WorkStatus.getRandomStatus())
                .bank(bank)
                .servingEmployee(employee)
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .build();

        bankAtms.add(bankAtm);
        bank.getBankATMS().add(bankAtm);
        office.getBankAtms().add(bankAtm);
    }

    /**
     * Возвращает объект банкомата.
     *
     * @param id   Id банкомата.
     * @param bank Банк, которому пренадлежит банкомат.
     * @return Объект банкомата.
     */
    @Override
    public BankAtm getBankAtm(int id, Bank bank) {
        return bank.getBankATMS().get(id);
    }

    /**
     * Обновляет банкомат в банке.
     *
     * @param id      Id банкомата.
     * @param bank    Банк, которому пренадлежит банкомат.
     * @param bankAtm Новый банкомат.
     */
    @Override
    public void update(int id, Bank bank, BankAtm bankAtm) {
        bank.getBankATMS().set(id, bankAtm);
    }

    /**
     * Удаляет объект банкомата.
     *
     * @param id   Id банкомата.
     * @param bank Банк, которому пренадлежит банкомат.
     */
    @Override
    public void delete(int id, Bank bank) {
        bank.getBankATMS().remove(id);
        bankAtms.remove(id);
    }
}
