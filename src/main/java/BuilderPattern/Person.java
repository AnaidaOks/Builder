package BuilderPattern;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.lastName + " " + this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public boolean hasAge() {
        return this.age == 0;
    }

    public boolean hasAddress() {
        return this.address == null || this.address.isEmpty() ;
    }

    public void happyBirthDay() {
        age += 1;
    }

    public void setAddress(String adr) {
        this.address = adr;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + ", Surname: " + lastName + (hasAge() ? ", age: " + age : "") +
        (hasAddress() ? ", address: " + address : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.lastName).setAge(this.age).setAddress(this.address);
    }
}
