package tech.reliab.course.panarinke.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.panarinke.bank.entity.auxiliary.FCs;

import java.util.Date;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class Employee implements Entity, Serializable {
    /** Id сотрудника */
    private long id;

    /** ФИО */
    private FCs fcs;

    /** Дата рождения */
    private Date birthday;

    /** Должность */
    private String post;

    /** В каком банке работает */
    private Bank bank;

    /** Работает ли в банковском офисе или удаленно? */
    private boolean isRemotely;

    /** Банковский офис, в котором работает */
    private BankOffice office;

    /** Может ли выдавать кредиты? */
    private boolean creditAvailable;

    /** Размер зарплаты */
    private int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fcs=" + fcs +
                ", birthday=" + birthday +
                ", post='" + post + '\'' +
                ", bank=" + bank +
                ", isRemotely=" + isRemotely +
                ", office=" + office +
                ", creditAvailable=" + creditAvailable +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "Employee";
    }
}
