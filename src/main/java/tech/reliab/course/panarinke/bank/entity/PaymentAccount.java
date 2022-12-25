package tech.reliab.course.panarinke.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@Builder
public class PaymentAccount implements Entity, Serializable {
    /** Id платёжного счета */
    private long id;

    /** Пользователь, за которым закреплен этот платежный счет */
    private User user;

    /** Банк, в котором открыт этот счет */
    private Bank bank;

    /** Сумма, которая лежит в данный момент на счету */
    private int moneyAmount;

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", bank=" + bank.getId() +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    @Override
    public String getSimpleName() {
        return "PaymentAccount";
    }
}
