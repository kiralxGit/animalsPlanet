import pets.Animal;

public interface Repository {
    void add(Animal animal);
    void printAllAnimals();
    void removeAnimal(int i);

}
