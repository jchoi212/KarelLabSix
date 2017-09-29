
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    int[] rowBeepers = new int [9];
    int[] sortingBeepers = new int [9];
    public int lowest;
    public int rowNumber = 0;
    public int beepersInRow = 0;
    public int sortingValue = 0;
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        moveToStart();
        collectAll();
        reposition();
        backToStart();
        sortArray();
        placeRows();
        printArray();
        printSorted();
        System.out.println();
        System.out.print(lowest);
    }
    public void moveToStart() {
        move();
        turnLeft();
        while (frontIsClear()) {
            move();
        }  
        turnLeft();
        turnLeft();
    }
    public void collectAll() {
        while(rowBeepers[7] <=1){
            collectRow();
            reposition();
        }
    }
    public void collectRow() {
        while (nextToABeeper()) {
            pickBeeper();
            move();
            beepersInRow +=1;
        }
        rowBeepers[rowNumber] = beepersInRow;
        beepersInRow = 0;
        rowNumber +=1;
    }
    public void reposition() {
        while (!facingSouth()) {
            turnLeft();
        }
        while (frontIsClear()) {
            move();
            
        }
        if (!frontIsClear()) {
            turnLeft();
        }
        move();
        turnLeft();
    }
    public void backToStart() {
        while(!facingWest()) {
            turnLeft();
        }
        while (frontIsClear()) {
          move();   
        }
        if (!frontIsClear()) {
            while (!facingNorth()) {
             turnLeft();   
            }
        }
    }
    public void sortArray() {
        for (int index = 0; index < rowBeepers.length ; index++){
           sortingBeepers[sortingValue] = rowBeepers[sortingValue];
           while (sortingBeepers[sortingValue] <= rowBeepers[sortingValue+1]) {
               sortingValue +=1; 
               sortingBeepers[sortingValue] = rowBeepers[sortingValue];
               
               
            }
        }
    }
    public void placeRows() {
        
    }
    public void printArray() {
        System.out.println();
        for (int values : rowBeepers) {
            System.out.print(values+" , ");
        }
        System.out.println();
    }
    public void printSorted() {
        System.out.println();
        for (int values : sortingBeepers) {
            System.out.print(values+" , ");
        }
        System.out.println();
    }
}

