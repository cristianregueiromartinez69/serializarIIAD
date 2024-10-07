package serializacion2;

import javax.swing.JOptionPane;
import java.io.*;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        //array con los atributos de la clase producto
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        int[] prezo = {3, 4, 5};
        
        //pedimos al usuario que introduzca la rutaq
        String ruta = JOptionPane.showInputDialog("Introduce la ruta del archivo: ");
        File file = new File(ruta);
        boolean marca = false;
        
        //mientras sea falso, crea el archivo o si existe rompe
        while(marca == false){
            try{
                if(file.createNewFile()){
                    marca = true;
                }
                else if(file.exists()){
                    marca = true;
                }
            }catch(IOException e){
                 ruta = JOptionPane.showInputDialog("Vuelve a introducir la ruta: ");
                
            }
        }
        
        //llamamos a los metodos y escribimos y leemos los objetos
        MetodosSerializarObjetos mos = new MetodosSerializarObjetos();
        mos.writeObject(cod, desc, prezo, ruta);
        mos.readObject(cod, desc, prezo, ruta);
        

    }

}

