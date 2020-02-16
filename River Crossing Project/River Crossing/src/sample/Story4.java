package sample;

import java.util.ArrayList;
import java.util.List;

public class Story4 implements ICrossingStrategy {
String label = "weight";

    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int i = 0;
        int j = 0;
        int girlsOnBoat;
        int girlsOnRight;
        int countGirlsLeft=0,countBoysRight = 0,countGirlsRight = 0,countBoysLeft=0;
        for(i=0;i<rightBankCrossers.size();i++)
        {
            if(rightBankCrossers.get(i).getClass().equals(Girl.class))
                countGirlsRight++;
            else if(rightBankCrossers.get(i).getClass().equals(Boy.class))
                countBoysRight++;
        }

        //else
        //  {   //countBoys = 0;
        //countGirls=0;
        for(i=0;i<leftBankCrossers.size();i++)
        {
            if(leftBankCrossers.get(i).getClass().equals(Girl.class))
                countGirlsLeft++;
            else if(leftBankCrossers.get(i).getClass().equals(Boy.class))
                countBoysLeft++;
        }
        //   if()
        if(countGirlsLeft>countBoysLeft && countBoysLeft!=0)
            return false;
        if(countGirlsRight>countBoysRight && countBoysRight !=0)
            return false;

        //}
        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        Girl girl1 = new Girl(0);
        girl1.setLabelToBeShown(label);
        Girl girl2 = new Girl(0);
        girl2.setLabelToBeShown(label);
        Girl girl3 = new Girl(0);
        girl3.setLabelToBeShown(label);
        Boy boy1 = new Boy(0);
        boy1.setLabelToBeShown(label);
        Boy boy2 = new Boy(0);
        boy2.setLabelToBeShown(label);
        Boy boy3 = new Boy(0);
        boy3.setLabelToBeShown(label);
        List<ICrosser> members = new ArrayList<ICrosser>();
        members.add(girl1);
        members.add(girl2);
        members.add(girl3);
        members.add(boy1);
        members.add(boy2);
        members.add(boy3);
        return members;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[2];
        instructions[0]="1. The raft can hold a maximum of two people, and everyone can row";
        instructions[1]="2. There can never be more girls than boys together on the same side";
        return instructions;
    }
}