import java.util.ArrayList;

public class City{
    private ArrayList <Building> buildings = new ArrayList <Building>();
    public City(){
    }
    
    public void add(Building b){
        this.get().add(b);
    }
    
    public int size(){
        return this.buildings.size();
    }
    
    public ArrayList <Building> get(){
        return this.buildings;
    }
    
    public ArrayList <Integer> toArray(){
        ArrayList <Integer> arraylist = new ArrayList <Integer>();
        for (int i = 0; i < this.size(); i++){
            arraylist.add (this.get().get(i).getx1());
            arraylist.add (this.get().get(i).getx2());
            arraylist.add (this.get().get(i).gety());            
        }
        return arraylist;
    }
    
    public Solution getSkyline(int enablelog, int depth){
        if (this.size() == 1){
            depth++;
            return this.get().get(0).getSkyline(enablelog, depth);
        } else{
            depth++;
            City city1 = new City();
            City city2 = new City();
            int half = this.size()/2;
            for (int i = 0; i < this.size(); i++){
                if (i < half){
                    city1.add(this.get().get(i));
                } else{
                    city2.add(this.get().get(i));
                }
            }
            if (enablelog == 1){
                String string = "";
                for(int i = 0; i < depth; i++){
                    string = "       " + string;
                }
                System.out.println(string + "ciudad " + this.toArray() + " partida en " + city1.toArray() + " y " + city2.toArray());
            }
            return city1.getSkyline(enablelog, depth).combine(city2.getSkyline(enablelog, depth), enablelog, depth);
        }
    }

    
}
