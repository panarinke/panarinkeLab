package tech.reliab.course.panarinke.bank.entity.auxiliary;

public class FCs {
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