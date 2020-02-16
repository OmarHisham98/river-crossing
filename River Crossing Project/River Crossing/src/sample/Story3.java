package sample;

import java.util.ArrayList;
import java.util.List;

public class Story3 implements ICrossingStrategy {
    String label = "weight";
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        int totalWeight = 0;
        for (int i = 0; i < boatRiders.size(); i++) {
            if (boatRiders.get(i).getClass().equals(Farmer.class) || boatRiders.get(i).getClass().equals(Child.class)) {
                for (ICrosser crosser : boatRiders) {
                    totalWeight += crosser.getWeight();
                }
                if (totalWeight <= 100)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {

        Farmer farmer1 = new Farmer(100);
        farmer1.setLabelToBeShown(label);
        Farmer farmer2 = new Farmer(100);
        farmer2.setLabelToBeShown(label);
        Child child1 = new Child(50);
        child1.setLabelToBeShown(label);
        Child child2 = new Child(50);
        child2.setLabelToBeShown(label);
        List<ICrosser> members = new ArrayList<>();
        members.add(farmer1);
        members.add(farmer2);
        members.add(child1);
        members.add(child2);
        return members;
    }

    @Override
    public String[] getInstructions() {

        String[] instructions = new String[2];
        instructions[0]="1. Raft can hold one Farmer or two Children.";
        instructions[1]="2. Everyone can row the raft.";
        return instructions;
    }
}