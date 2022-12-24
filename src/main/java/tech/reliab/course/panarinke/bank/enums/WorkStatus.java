package tech.reliab.course.panarinke.bank.enums;

import java.util.Random;

public enum WorkStatus {
    WORKING("Work"),
    NOT_WORKING("Not work"),
    NO_MONEY("No money");

    private String status;

    WorkStatus(String status) {
        this.status = status;
    }

    public static WorkStatus getRandomStatus() {
        Random random = new Random();

        WorkStatus[] values = values();
        return values[random.nextInt(values.length)];
    }
}
