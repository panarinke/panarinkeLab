package tech.reliab.course.panarinke.bank.entity.auxiliary;

import java.io.Serializable;

public class FCs implements Serializable {

    private String name;
    private String lastName;
    private String patronymic;

    public FCs(String name, String lastName, String patronymic) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "FCs{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}