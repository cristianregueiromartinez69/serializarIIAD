package serializacion2;

import java.io.*;

public class MetodosSerializarObjetos {

    public void writeObject(String[] cod, String[] desc, int[] prezo, String path) {

        try {

            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));

            for (int i = 0; i < 3; i++) {

                Product product = new Product(cod[i], desc[i], prezo[i]);
                ous.writeObject(product);
            }

            ous.close();
        } catch (IOException e) {
            System.out.println("No se pudo escribir el archivo");
        }

    }

    public void readObject(String[] cod, String[] desc, int[] prezo, String path) {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Product product;
            while (true) {
                try {
                    product = (Product) ois.readObject();
                    System.out.println(product);
                } catch (EOFException eof) {
                    break; 
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo");
        }

    }

}
