package sample;

public class LoadFromFile implements ICommand {
    Save load;

    public LoadFromFile(Save load){
        this.load = load;
    }

    @Override
    public void execute() {
        //TODO: make saveToFile method without arguments
        load.loadFromFile();

    }
}
