import java.util.ArrayList;

public class Building{
    private int x1;
    private int x2;
    private int y;
    public Building(int first, int second, int third){
        x1 = first;
        x2 = second;
        y = third;        
    }

    public int getx1(){
        return x1;
    }

    public int getx2(){
        return x2;
    }

    public int gety(){
        return y;
    }
    
    public Solution getSkyline(int enablelog, int depth){
        Solution solution = new Solution();
            solution.get().add (this.getx1());
            solution.get().add (this.gety());
            solution.get().add (this.getx2());
            solution.get().add (0);
            if (enablelog == 1){
                 String string = "";
                for(int i = 0; i < depth; i++){
                    string = "       " + string;
                }
                System.out.println(string + "skyline de edificio " + this.getx1() + "," + this.getx2() + "," + this.gety() + " = " + solution.get());
            }
            return solution;
    }
}
