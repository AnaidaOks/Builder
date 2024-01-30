package BuilderPattern;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    public PersonBuilder(){}

    public PersonBuilder setName(String name) {
        this.firstName = name;
        return  this;
    }

    public PersonBuilder setSurname(String surname) {
        this.lastName = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Неверно указан возраст");
        } else {
            this.age = age;
        }

        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (nullOrEmpty(this.firstName) || nullOrEmpty(this.lastName)) {
            throw new IllegalStateException("Не указаны обязательные поля для создания объекта человека");
        } else {
            Person person = new Person(this.firstName, this.lastName, this.age);
            if (!nullOrEmpty(this.address)) {
                person.setAddress(address);
            }
            return person;
        }
    }

    public static boolean nullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
