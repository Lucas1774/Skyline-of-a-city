import java.util.ArrayList;
import java.lang.Math;

public class Solution{
    private ArrayList <Integer> coordenates = new ArrayList <Integer>();
    
    public Solution(){
        coordenates = new ArrayList <Integer>();
    }
    public ArrayList <Integer> get(){
        return this.coordenates;
    }
    
    public ArrayList <Integer> getallx(){
        ArrayList <Integer> arraylist = new ArrayList <Integer>();
        for (int i = 0; i < this. get().size(); i++){
            if (i % 2 == 0){
                arraylist. add(this.get().get(i));
            }
        }
        return arraylist;
    }
    
    public ArrayList <Integer> getally(){
        ArrayList <Integer> arraylist = new ArrayList <Integer>();
        for (int i = 0; i < this. get().size(); i++){
            if (i % 2 != 0){
                arraylist. add(this.get().get(i));
            }
        }        
        return arraylist;    
    }
    
    public int size(){
        return this.coordenates.size();
    }
    
    public Solution combine (Solution solution, int enablelog, int depth){
        //número de puntos de inflexión
        int n = this.size() / 2;
        int m = solution.size() / 2;
        ArrayList <Integer> s1x = this.getallx();
        ArrayList <Integer> s1y = this.getally();
        ArrayList <Integer> s2x = solution.getallx();
        ArrayList <Integer> s2y = solution.getally();
        //cursor de puntos
        int i = 0;
        int j = 0;
        //variables temporales
        int x = 0;
        int max = 0;
        //variable switch
        int mode;
        Solution s = new Solution ();
        //mientras que queden a la derecha puntos que puedan modificar la estructura del skyline
        while (i< n || j < m){
            //la x es la del que aún pueda inflexionar. Si ambos pueden, del que lo haga antes
            if( i== n){
                x = s2x.get(j);
                mode = 2;
            } else if (j == m){
                x = s1x.get(i);
                mode = 1;
            } else{
                x = Math.min (s1x.get(i), s2x.get(j));
                if (s1x.get(i) < s2x.get(j)){
                    mode =1;
                } else if (s1x.get(i) > s2x.get(j)){
                    mode =2;
                } else { mode = 3;}
            }
            //si inflexiona antes el primero
            if (mode == 1){
                // si el otro skyline no ha comenzado, este punto de inflexión es relevante
                if (j == 0){
                    s.get().add(x);
                    s.get().add(s1y.get(i));
                } else {
                    max = Math.max( s1y.get (i), s2y.get (j - 1));
                    //solo si la altura cambia
                    if (s.get().size() == 0){
                        s.get().add (x);
                        s.get().add (max);
                    } else if (max != s.get().get(s.size() - 1)){
                        s.get().add (x);
                        s.get().add (max);
                    }
                }
                i++;
                //si inflexion antes el segundo se coge su Y
            } else if (mode == 2){
                // si el otro skyline no ha comenzado, este punto de inflexión es relevante
                if (i == 0){
                    s.get().add(x);
                    s.get().add(s2y.get(j));
                } else {
                    max = Math.max( s2y.get (j), s1y.get (i - 1));
                    //solo si la altura cambia
                    if (s.get().size() == 0){
                        s.get().add (x);
                        s.get().add (max);
                    } else if (max != s.get().get(s.size() - 1)){
                        s.get().add (x);
                        s.get().add (max);
                    }
                }
                j++;
            //si inflexionan a la vez se coge la y del más alto
            } else {
                max = Math.max(s1y.get(i), s2y.get (j));
                //solo si la altura cambia
                if (s.get().size() == 0){
                    s.get().add (x);
                    s.get().add (max);
                } else if (max != s.get().get(s.size() - 1)){
                    s.get().add (x);
                    s.get().add (max);
                }
                i++;
                j++;
            }
        }
        if (enablelog == 1){
            String string = "";
            for(int k = 0; k < depth; k++){
                string = "       " + string;
            }
            System.out.println(string + "combinadas skylines " + this.get() + " y " + solution.get() + ". Skyline resultado = " + s.get());
        }
        return s;
    }
}
