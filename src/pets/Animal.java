package pets;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String birthDate;
    private List<String> commands = new ArrayList<>();
    public Animal (String name, String birthDate, String command){
        this.name = name;
        this.birthDate = birthDate;
        this.commands.add(command);
    }
    public String getName(){
        return name;
    }
    public List<String> getCommands(){
        return commands;
    }
    public void addCommand(String command){
        commands.add(command);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name + ", родился: " + birthDate + ", команды: " + commands;
    }
}
