package people;

import java.util.ArrayList;
import java.util.List;

public record Person(String firstName, String lastName, List<Pet> pets) {
    public Person(String firstName, String lastName) {
        this(firstName, lastName, new ArrayList<>());
    }

    public Person addPet(PetType petType, String name, int age) {
        addPet(new Pet(petType, name, age));
        return this;
    }

    private Person addPet(Pet p) {
        pets.add(p);
        return this;
    }
}
