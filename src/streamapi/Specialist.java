package streamapi;

import java.util.Objects;

public class Specialist {
    private String name;
    private int salary;
    private Speciality speciality;

    public Specialist(String name, int salary, Speciality speciality) {
        this.name = name;
        this.salary = salary;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialist that = (Specialist) o;
        return salary == that.salary && Objects.equals(name, that.name) && speciality == that.speciality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, speciality);
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                '}';
    }
}
