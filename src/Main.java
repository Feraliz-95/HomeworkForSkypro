import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Employee employee1 = new Employee("Кравчук Владислав Виталиевич", 3, 50);
        System.out.println("employee1.getFullName() = " + employee1.getFullName());
        System.out.println("employee1.getDepartment() = " + employee1.getDepartment());
        System.out.println("employee1.getSalary() = " + employee1.getSalary());
        Employee employee2 = new Employee("Логина Екатерина Олеговна", 4, 150);
        System.out.println("employee2.getFullName() = " + employee2.getFullName());
        System.out.println("employee2.getDepartment() = " + employee2.getDepartment());
        System.out.println("employee2.getSalary() = " + employee2.getSalary());
        Employee employee3 = new Employee("Горин Алексей Викторович", 1, 300);
        System.out.println("employee3.getFullName() = " + employee3.getFullName());
        System.out.println("employee3.getDepartment() = " + employee3.getDepartment());
        System.out.println("employee3.getSalary() = " + employee3.getSalary());
        Employee employee4 = new Employee("Филкин Борис Андреевич", 5, 450);
        System.out.println("employee4.getFullName() = " + employee4.getFullName());
        System.out.println("employee4.getDepartment() = " + employee4.getDepartment());
        System.out.println("employee4.getSalary() = " + employee4.getSalary());
        Employee employee5 = new Employee("Карпова Виктория Александровна", 2, 200);
        System.out.println("employee5.getFullName() = " + employee5.getFullName());
        System.out.println("employee5.getDepartment() = " + employee5.getDepartment());
        System.out.println("employee5.getSalary() = " + employee5.getSalary());

        System.out.println(employee5.equals(employee4));

        employee1.printShortInfo();
        employee2.printShortInfo();
        employee3.printShortInfo();
        employee4.printShortInfo();
        employee5.printShortInfo();


        EmployeeBook book = new EmployeeBook();
        book.addEmployee(new Employee("Кравчук Владислав Виталиевич", 3, 50));
        book.addEmployee(new Employee("Логина Екатерина Олеговна", 4, 150));
        book.addEmployee(new Employee("Горин Алексей Викторович", 1, 300));
        book.addEmployee(new Employee("Филкин Борис Андреевич", 5, 450));
        book.addEmployee(new Employee("Карпова Виктория Александровна", 2, 200));
        double average = book.calculateAverageSalary();
        System.out.printf("Средняя зарплата: %.2f руб.%n", average);


        // Выводим налоги по пропорциональной схеме
        book.printTaxes("PROPORTIONAL");

        // Выводим налоги по прогрессивной схеме
        book.printTaxes("PROGRESSIVE");



        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Кравчук Владислав Виталиевич", 3, 50));
        employees.add(new Employee("Логина Екатерина Олеговна", 5, 150));
        employees.add(new Employee("Горин Алексей Викторович", 1, 300));
        employees.add(new Employee("Филкин Борис Андреевич", 5, 450));
        employees.add(new Employee("Карпова Виктория Александровна", 2, 200));

        int department = 5;// Номер отдела (1-5)
        double percentage = 10.0; // Процент индексации
        System.out.println("До индексации:");
        employees.forEach(System.out::println);
        EmployeeBook.adjustSalary(employees, department, percentage);
        System.out.println("\nПосле индексации:");
        employees.forEach(System.out::println);

        double salaryThreshold = 150;
        // Поиск первого сотрудника
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getDepartment() == department && employee.getSalary() > salaryThreshold) {
                System.out.println("Первый сотрудник в отделе " + department + " с зарплатой больше " + salaryThreshold + ":");
                employee.printShortInfo();
                System.out.println("Порядковый номер в списке: " + (i + 1)); // Для отображения порядкового номера
                break; // Выход из цикла после нахождения первого подходящего сотрудника
            }
        }
        double wage = 400;               //  порог зарплаты
        int employeeNumber = 2;        //  количество сотрудников для вывода
        int count = 0;                // Счетчик для подсчета выведенных сотрудников
        int index = 0;                // Индекс для прохода по списку сотрудников

        while (index < employees.size()) {
            Employee employee = employees.get(index);
            if (employee.getSalary() < wage) {
                employee.printShortInfo();  // Вывод информации о сотруднике
                count++;  // Увеличиваем счетчик
            }
            index++;  // Увеличиваем индекс для следующего сотрудника
            if (count >= employeeNumber) {  // Если достигли необходимого количества сотрудников
                break;  // Выходим из цикла
            }
        }
        // Если сотрудников не найдено
        if (count == 0) {
            System.out.println("Сотрудники с зарплатой меньше " + wage + " не найдены.");
        }

        Employee[] employees1 = {
                new Employee("Кравчук Владислав Виталиевич", 3, 50),
                new Employee("Логина Екатерина Олеговна", 5, 150),
                new Employee("Горин Алексей Викторович", 1, 300),
                new Employee("Филкин Борис Андреевич", 5, 450),
                new Employee("Карпова Виктория Александровна", 2, 200)
        };

        Employee targetEmployee = new Employee("Кравчук Владислав Виталиевич", 3, 200);
        boolean exists = EmployeeBook.isEmployeeInArray(targetEmployee, employees1);
        System.out.println("Сотрудник с зарплатой " + targetEmployee.getSalary() + " " + (exists ? "найден." : "не найден."));


        EmployeeBook employeeBook = new EmployeeBook(5);
        Employee emp1 = new Employee("Кравчук Владислав Виталиевич", 3, 50);
        Employee emp2 = new Employee("Логина Екатерина Олеговна", 5, 150);
        Employee emp3 = new Employee("Горин Алексей Викторович", 1, 300);
        Employee emp4 = new Employee("Филкин Борис Андреевич", 5, 450);
        Employee emp5 = new Employee("Карпова Виктория Александровна", 2, 200);
        Employee emp6 = new Employee("Киров Михаил Евгеньевич", 5, 350);




        System.out.println("Добавление 1: " + employeeBook.addEmployee(emp1)); // true
        System.out.println("Добавление 2: " + employeeBook.addEmployee(emp2)); // true
        System.out.println("Добавление 3: " + employeeBook.addEmployee(emp3)); // true
        System.out.println("Добавление 4: " + employeeBook.addEmployee(emp4)); // true
        System.out.println("Добавление 5: " + employeeBook.addEmployee(emp5)); // true
        System.out.println("Добавление 6: " + employeeBook.addEmployee(emp6)); // false, превышает лимит



        System.out.println("Список сотрудников:");
        employeeBook.printEmployees(); // Выводим список сотрудников


        int idToGet = 0; // Здесь мы используем id , чтобы получить третьего сотрудника (индексация с нуля)
        Employee foundEmployee = employeeBook.getEmployeeById(idToGet);
        if (foundEmployee != null) {
            System.out.println("Сотрудник с id " + idToGet + ": " + foundEmployee);
        } else {
            System.out.println("Сотрудник с id " + idToGet + " не найден.");
        }
        Employee worker = new Employee("Кравчук Владислав Виталиевич", 3, 50);
        Employee worker1 = new Employee("Логина Екатерина Олеговна", 5, 150);
        Employee worker2 = new Employee("Горин Алексей Викторович", 1, 300);
        Employee worker3 = new Employee("Филкин Борис Андреевич", 5, 450);
        Employee worker4 = new Employee("Карпова Виктория Александровна", 2, 200);
        Employee worker5 = new Employee("Киров Михаил Евгеньевич", 5, 350);
        Employee worker6 = new Employee("Михайлов Стас Никитович", 4, 90);
        Employee worker7 = new Employee("Ильиных Валерия Семеновна", 2, 120);
        Employee worker8 = new Employee("Смирнов Борис Владимирович", 1, 230);
        Employee worker9 = new Employee("Романов Петр Сергеевич", 3, 250);
        Employee worker10 = new Employee("Максимов Леонид Валериевич", 2, 340);
        System.out.println("Результаты добавления сотрудников:");
        System.out.println("Добавление 1: " + employeeBook.addEmployee(worker));
        System.out.println("Добавление 2: " + employeeBook.addEmployee(worker1));
        System.out.println("Добавление 3: " + employeeBook.addEmployee(worker2));
        System.out.println("Добавление 4: " + employeeBook.addEmployee(worker3));
        System.out.println("Добавление 5: " + employeeBook.addEmployee(worker4));
        System.out.println("Добавление 6: " + employeeBook.addEmployee(worker5));
        System.out.println("Добавление 7: " + employeeBook.addEmployee(worker6));
        System.out.println("Добавление 8: " + employeeBook.addEmployee(worker7));
        System.out.println("Добавление 9: " + employeeBook.addEmployee(worker8));
        System.out.println("Добавление 10: " + employeeBook.addEmployee(worker9));
        System.out.println("Добавление 11: " + employeeBook.addEmployee(worker10));





    }

}


























































