import java.util.List;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];// Массив на 10 сотрудников
    private int capacity;
    private int size;

    public EmployeeBook() {

    }


    // Метод для получения списка всех сотрудников (вывод в консоль)
    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return false;
            }
        }
        System.out.println("Ошибка: хранилище сотрудников переполнено!");
        return false;
    }

    public double calculateAverageSalary() {
        double sum = 0.0;
        int count = 0;

        for (Employee emp : employees) {
            if (emp == null) break; // Прерываем цикл при первом null

            sum += emp.getSalary();
            count++;
        }

        return count == 0 ? 0.0 : sum / count; // Защита от деления на ноль
    }

    public void printTaxes(String taxScheme) {
        System.out.println("=== Налоги по схеме " + taxScheme + " ===");

        if (employees == null) {
            System.out.println("Массив сотрудников не инициализирован.");
            return;
        }

        boolean hasEmployees = false;

        for (Employee employee : employees) {
            // Останавливаемся на первом null
            if (employee == null) {
                break;
            }

            hasEmployees = true;
            Double salary = (double) employee.getSalary();
            double tax = 0.0;

            if (salary != null) {
                tax = calculateTaxForSalary(salary, taxScheme);
            }

            System.out.printf("Сотрудник %s (зарплата: %.2f): налог = %.2f%n",
                    employee.getFullName(),
                    salary != null ? salary : 0.0,
                    tax);
        }

        if (!hasEmployees) {
            System.out.println("Сотрудники не найдены.");
        }
        System.out.println(); // Пустая строка для разделения вывода
    }


    private double calculateTaxForSalary(double salary, String taxScheme) {
        switch (taxScheme) {
            case "PROPORTIONAL":
                return salary * 0.13; // 13% для всех

            case "PROGRESSIVE":
                if (salary <= 150) {
                    return salary * 0.13; // 13% до 150
                } else if (salary <= 350) {
                    return salary * 0.17; // 17% до 350
                } else {
                    return salary * 0.21; // 21% выше 350
                }

            default:
                System.out.println("Неизвестная схема расчёта налогов: " + taxScheme);
        }
        return salary;
    }


    public static void adjustSalary(List<Employee> employees, int department, double percentage) {
        if (percentage == 0) {
            System.out.println("Процент изменения равен нулю, зарплаты не изменятся.");
            return;
        }

        for (Employee emp : employees) {
            // Пропускаем сотрудников не из нужного отдела
            if (emp.getDepartment() != department) {
                continue;
            }

            double oldSalary = emp.getSalary();
            double newSalary = oldSalary * (1 + percentage / 100);

            // Пропускаем сотрудников, у которых зарплата не изменится
            if (oldSalary == newSalary) {
                continue;
            }

            emp.setSalary((int) newSalary);
            System.out.println("Зарплата сотрудника " + emp.getFullName() + " изменена с " + oldSalary + " на " + newSalary);
        }
    }

    public static boolean isEmployeeInArray(Employee employeeToFind, Employee[] employees) {
        for (Employee employee : employees) {
            if (employee.equals(employeeToFind)) {
                return true; // Сотрудник найден
            }
        }
        return false; // Сотрудник не найден
    }



    public EmployeeBook(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0; // Количество добавленных сотрудников
    }

    // Метод добавления нового сотрудника
    public boolean addEmployee1(Employee employee) {
        if (size >= capacity) {
            // Нет свободных мест
            return false;
        }

        // Поиск свободного места
        for (int i = 0; i < capacity; i++) {
            if (employees[i] == null) { // Если находим свободное место (null)
                employees[i] = employee; // Сохраняем сотрудника
                size++; // Увеличиваем счётчик
                return true; // Успех
            }
        }

        // Если не нашли свободное место
        return false;
    }
    public Employee getEmployeeById(int id) {
        if (id < 0 || id >= capacity || employees[id] == null) {
            return null; // Возвращаем null, если id недействителен или нет сотрудника
        }
        return employees[id]; // Возвращаем сотрудника по id
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) { // Проверяем, что ячейка не пустая
                System.out.println(employee);
            }
        }
    }
}





























































