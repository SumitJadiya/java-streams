package beans;

import lombok.Data;

@Data
public class PersonDTO {

    private final Integer id;
    private final String name;
    private final Integer age;

    public PersonDTO(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static PersonDTO map(Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    }

    @Override
    public String toString() {
        return "PeopleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
