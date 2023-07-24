import java.util.List;

public class Donkey extends BagageAnimal {
    private String name;
    private Integer birthDate;
    private List<String> commands;
    public Dog(String name, Integer birthDate){
        this.name = name;
        this.birthDate = birthDate;
        this.commands.add("Say hee-haw");
    }
    public String getName(){
        return name;
    }
    public Integer getBirthDate(){
        return birthDate;
    }
    public void printCommands(){
        System.out.println(commands);
    }
    public void addCommands(String command){
        commands.add(command);
    }
}
