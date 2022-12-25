package tech.reliab.course.panarinke.bank.exceptions;

import tech.reliab.course.panarinke.bank.enums.BankTransaction;

public class BankTransactionException extends RuntimeException {
    private final BankTransaction transactionType;

    /**
     * Ошибка выполнения транзакции.
     *
     * @param message         Сообщение ошибки.
     * @param transactionType Вид транзакции.
     */
    public BankTransactionException(String message, BankTransaction transactionType) {
        super(message);
        this.transactionType = transactionType;
    }

    @Override
    public String getMessage() {
        return "Bank transaction exception " +
                "\"" + transactionType.toString() + "\". " + super.getMessage();
    }
}