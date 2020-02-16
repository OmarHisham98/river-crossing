package sample;

import java.util.ArrayList;
import java.util.List;

public class Story1 implements ICrossingStrategy {
    String label = "eating rank";
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int i,j;

        for(i=0;i<boatRiders.size();i++) {
            if (boatRiders.get(i).getClass().equals(Farmer.class)) {
                for (i = 0; i < rightBankCrossers.size(); i++) {
                    for (j = 0; j < rightBankCrossers.size(); j++) {
                        if (rightBankCrossers.get(i).getEatingRank() == rightBankCrossers.get(j).getEatingRank() + 1)
                            return false;
                    }
                }
                for (i = 0; i < leftBankCrossers.size(); i++) {
                    for (j = 0; j < leftBankCrossers.size(); j++) {
                        if (leftBankCrossers.get(i).getEatingRank() == leftBankCrossers.get(j).getEatingRank() + 1)
                            return false;

                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        Farmer farmer = new Farmer(100);
        farmer.setLabelToBeShown(label);
        Plant plant = new Plant(0);
        plant.setLabelToBeShown(label);
        Wolf wolf = new Wolf(0);
        wolf.setLabelToBeShown(label);
        Goat goat = new Goat(0);
        goat.setLabelToBeShown(label);
        List<ICrosser> members = new ArrayList<>();
        members.add(farmer);
        members.add(plant);
        members.add(wolf);
        members.add(goat);
        return members;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[2];
        instructions[0]="1. The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself.";
        instructions[1]="2. You can not leave any two crossers on the same bank if they can harm(eat) each other.";
        return instructions;
    }
}
