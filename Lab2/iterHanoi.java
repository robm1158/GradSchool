package Lab2;

java.lang.Math;

public class iterHanoi{
    private stackInt source,desto,spare;
    //private int

    public iterHanoi(int size) {
        stackInt source = new stackInt(size);
        stackInt desto = new stackInt(size);
        stackInt spare = new stackInt(size);
        //initialize with bigger rods on first
        for (int iter = size; iter >= 1;iter--){
            source.push(iter);
        }

    }
public void moveDisk(){
    
}

    //public void moveDisk(char toRod, char fromRod, int disk){
      //  System.out.println("Move the disk "+disk + " from "+fromRod+" to "+toRod); 
    //}

    public void solve(int num){
        // We know this to be true so I will use this to my advantage

        int totalMoves = (int)(Math.pow(2, num) - 1);


    }




}