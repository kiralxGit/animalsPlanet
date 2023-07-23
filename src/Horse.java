import java.util.List;

public class Horse extends BagageAnimal {
    private String name;
    private Integer birthDate;
    private List<String> commands;
    public Dog(String name, Integer birthDate){
        this.name = name;
        this.birthDate = birthDate;
        this.commands.add("Say neigh");
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
