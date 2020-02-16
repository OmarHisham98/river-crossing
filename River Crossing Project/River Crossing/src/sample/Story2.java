package sample;

import java.util.ArrayList;
import java.util.List;

public class Story2 implements ICrossingStrategy {
    String label = "weight";
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int totalWeight = 0;
        for (int i = 0; i < boatRiders.size(); i++) {
            if (boatRiders.get(i).getClass().equals(Farmer.class)){
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
        Farmer farmer1 = new Farmer(90);
        farmer1.setLabelToBeShown(label);
     //   farmer1.setTypeOfLabel(new GetWeight(new Farmer()));
        Farmer farmer2 = new Farmer(80);
        farmer2.setLabelToBeShown(label);
        Farmer farmer3 = new Farmer(60);
        farmer3.setLabelToBeShown(label);
        Farmer farmer4 = new Farmer(40);
        farmer4.setLabelToBeShown(label);
        Rabbit rabbit = new Rabbit(20);
        rabbit.setLabelToBeShown(label);
        List<ICrosser> members = new ArrayList<ICrosser>();
        members.add(farmer1);
        members.add(farmer2);
        members.add(farmer3);
        members.add(farmer4);
        members.add(rabbit);
        return members;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[2];
        instructions[0]="1. The boat cannot bear a load heavier than 100 kg.";
        instructions[1]="2. All farmers can raft, while the animal cannot.";
        return instructions;
    }
}
