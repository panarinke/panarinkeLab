package tech.reliab.course.panarinke.bank.exceptions;

import tech.reliab.course.panarinke.bank.enums.CrudOperations;

public class CrudOperationException extends RuntimeException {
    private final CrudOperations operation;
    private final String entityName;

    /**
     * Ошибка при выполнении метода.
     *
     * @param entityName Сущность.
     * @param operation  CRUD операция.
     */
    public CrudOperationException(String entityName, CrudOperations operation) {
        this.entityName = entityName;
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return "Error operation: \"" + operation.toString() + "\" for " + entityName;
    }
}
