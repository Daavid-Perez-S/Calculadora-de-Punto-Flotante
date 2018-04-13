import java.io.IOException;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) throws IOException {
        
        int cantidadDeDigitosMantisa, tipoDeRedondeo;
        
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.print("\n Cantidad de dígitos para la mantisa: ");
        cantidadDeDigitosMantisa = lecturaTeclado.nextInt();
        do{
            System.out.println(" Ingrese el tipo de redondeo\n");
            System.out.println("\t[1] Redondeo.");
            System.out.println("\t[2] Truncado.");
            System.out.println("\t[3] Redondeo hacia arriba.");
            //System.out.println("\t[4] Redondeo hacia abajo.");
            System.out.print("\n Digite su opcion >> ");
            tipoDeRedondeo = lecturaTeclado.nextInt();
        }while(tipoDeRedondeo < 1 || tipoDeRedondeo > 3);
        lecturaTeclado.nextLine();        // Borrado de búffer por si acaso  :v
        Algoritmo algoritmo = new Algoritmo(cantidadDeDigitosMantisa,tipoDeRedondeo);
        System.out.println("\n--------------------------------\n");
        
        // Aquí va todo tu código
        
    }   
}