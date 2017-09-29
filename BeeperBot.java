
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        moveToRow();
        collectRow();
        placeRow();
    }
    public void moveToRow() {
        while (!nextToABeeper()) {
         move();   
         if (nextToABeeper()==true){
             turnLeft();
            }
        }
    }
    public void collectRow() {
        while (nextToABeeper()==true) {
            pickBeeper();
            tempCount += 1;
            for(int index = 0; index < beeperList.length; index++) {
                beeperList[index] = tempCount;
            }
            move();
        }
    }
    public void placeRow() {
        
    }
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
   
}

