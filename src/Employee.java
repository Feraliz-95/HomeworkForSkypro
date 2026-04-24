public class Employee {
    private static int nextId = 1;
    private final int id;
    private String fullName;
    private int department;
    private int salary;
    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = nextId++;
    }

    public void printShortInfo() {
        System.out.println("Name: " + fullName + ", Salary: " + salary);
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    public String toString() {
        return "Имя " + this.fullName + " Зарплата " + this.salary;
    }


}
