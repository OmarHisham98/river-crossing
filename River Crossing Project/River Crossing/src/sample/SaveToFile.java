package sample;

public class SaveToFile implements ICommand {
    Save save;
    MoveInfo info;
    public SaveToFile(Save save, MoveInfo info){
        this.save = save;
        this.info = info;
    }

    @Override
    public void execute() {
        //TODO: make saveToFile method without arguments
        save.saveToFile(info);

    }
}
