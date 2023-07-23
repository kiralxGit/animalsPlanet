import java.util.ArrayList;
import java.util.List;

public class AnimalRepository implements Repository{
    private Integer count;
    private List<Animal> repository;
    public AnimalRepository(){
        this.count = 0;
        List<Animal> repo = new ArrayList<>();
    }
    @Override
    public void add(Animal animal){
        repository.add(animal);
        count++;
    }
    @Override
    public void printAllAnimals(){
        System.out.println(repository);
    }
    public Animal removeAnimal(Integer i){
        repository.remove(i);
    }

}
