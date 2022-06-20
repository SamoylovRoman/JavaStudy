package lesson5;

public class Main {
    public static void main(String[] args) {

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Самойлов", "Роман", "Валерьевич", "Java-разработчик", "samoilov_r_v@mail.ru", "+79237010107", 150000, 32);
        empArray[1] = new Employee("Иванов", "Петр", "Петрович", "Тестировщик", "ivanov_p_p@mail.ru", "+79237111111", 80000, 45);
        empArray[2] = new Employee("Сергеев", "Сергей", "Сергеевич", "Дизайнер", "sergeev_s_s@mail.ru", "+79130010107", 80000, 27);
        empArray[3] = new Employee("Сидиров", "Петр", "Васильевич", "Android-разработчик", "sidorov_and@mail.ru", "+79237232322", 1100000, 47);
        empArray[4] = new Employee("Савина", "Ольга", "Петровна", "Тестировщик", "savina_test@mail.ru", "+79237212145", 70000, 35);

        System.out.println("Сотрудники старше 40 лет:\n");
        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) {
                empArray[i].printInfo();
            }
        }
    }

}
