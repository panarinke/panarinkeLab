package tech.reliab.course.panarinke.bank.exceptions;

public class ObjectAccessException extends RuntimeException {
    private final String entityName;
    private final String reason;

    /**
     * Ошибка доступа к объекту.
     *
     * @param entityName Объект.
     * @param reason Причина.
     */
    public ObjectAccessException(String entityName, String reason) {
        this.entityName = entityName;
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return "Object access error \"" + entityName + "\", reason " + reason;
    }
}