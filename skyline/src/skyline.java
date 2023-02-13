import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class skyline{
    public static void main (String[] args) throws IOException {
        City mycity = new City();
        int enablelog = 0;
        switch (args.length){
            case 1:
                if (args[0].equals("-h")){
                    //imprimir ayuda
                    displayHelp();
                } else{
                    //ejecutar
                    mycity = converttoCity (args[0]);
                    //resultados por pantalla
                    System.out.println (mycity.getSkyline(enablelog, 0).get());
                }
                break;
            case 2:
                if(args[0].equals ("-t")){
                    //habilitar traza
                    enablelog = 1;
                    //ejecutar
                    mycity = converttoCity (args[1]);
                    //resultados por pantalla
                    System.out.println (mycity.getSkyline(enablelog, 0).get());
                } else{
                    //ejecutar
                    mycity = converttoCity (args[0]);
                    //resultados por archivo
                    createOutputFile(mycity.getSkyline(enablelog, 0), args[1]);
                }
                break;
            case 3:
                //habilitar traza
                enablelog = 1;
                //ejecutar
                mycity = converttoCity (args[1]);
                //resultados por archivo
                createOutputFile(mycity.getSkyline(enablelog, 0), args[2]);
                break;
            default:
                break;
        }
    }
    
    static void displayHelp(){
        System.out.println ("SINTAXIS: skyline [-h][-t] [fichero entrada] [fichero salida]");
        System.out.println ("el parámetro [-h] debe ser único");
        System.out.println ("el parámetro [fichero entrada] es necesario para ejecutar el programa");
        System.out.println ("los campos deben respetar el orden establecido más arriba");
        System.out.println ("El formato de ruta de fichero es Unidad:\\\\Directorio\\\\Subdirectorio\\\\archivo.txt");
        System.out.println ("-t Traza cada llamada recursiva y sus parámetros");
        System.out.println ("-h Muestra esta ayuda");
        System.out.println ("[fichero entrada] Ruta del archivo .txt entrada edificios de la ciudad");
        System.out.println ("[fichero salida] Ruta del archivo .txt salida skyline de la ciudad");
    }
    
    static City converttoCity (String path) throws IOException{
        City city = new City();
        BufferedReader reader = new BufferedReader (new FileReader(path));
        String line;
        
        while ((line = reader.readLine()) != null){
            String values[] = line.split (",");
            int a = Integer.parseInt (values[0]);
            int b = Integer.parseInt (values[1]);
            int c = Integer.parseInt (values[2]);
            Building building = new Building (a, b, c);
            city.add (building);
        }
        return city;
    }
    
    static void createOutputFile (Solution solution, String arg) throws IOException{
        File test = new File (arg);
        if (test.exists()){
            System.out.println ("El archivo de salida ya existe y no se puede sobreescribir");
        }else{
            FileWriter file = new FileWriter(arg);
            PrintWriter writer = new PrintWriter (file);
            writer.println(solution.get());
            file.close();
            System.out.println ("Archivo de salida creado con éxito");
        }
    }
}
