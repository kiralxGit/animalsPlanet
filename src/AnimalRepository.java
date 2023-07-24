import pets.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository implements Repository{
    private List<Animal> repository = new ArrayList<>();
    private Counter counter;
    public AnimalRepository(){
        List<Animal> repo = new ArrayList<>();
        counter = Counter.startCounter();
    }
    @Override
    public void add(Animal animal){
        repository.add(animal);
        try{
           counter.add();
        }
        catch (Exception e){
            e.getMessage();
        }
        System.out.println("Добавлено!\n");
    }
    public Integer getSize(){
        return counter.getSize();
    }
    public void printAllAnimals() {
        if (counter.getSize() < 1) System.out.println("Нет животных!");
        for (int i = 0; i < repository.size(); i++) {
            System.out.println(i + 1 + ". " + repository.get(i));
        }
        System.out.println("---");
    }
    public void removeAnimal(int i){
        repository.remove(i);
        counter.remove();
        System.out.println("Удалено!\n");
    }
    public void getCommandsAnimal (int i){
        List<String> commands = repository.get(i).getCommands();
        for (int k = 0; k < commands.size(); k++) {
            System.out.println(k + 1 + ". " + commands.get(k));
        }
        System.out.println("---");
    }
}
