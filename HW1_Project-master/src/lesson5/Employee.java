package lesson5;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String email;
    private String telephone;
    private double salary;
    private int age;

    public Employee(String surname, String name, String patronymic, String position, String email, String telephone, double salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Данные сотрудника:");
        System.out.println(surname + " " + name + " " + patronymic);
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + position);
        System.out.println("Телефон: " + telephone);
        System.out.println("E-mail: " + email);
        System.out.println("Заработанаая плата: " + salary + "\n");

    }

    public int getAge() {
        return age;
    }
}
