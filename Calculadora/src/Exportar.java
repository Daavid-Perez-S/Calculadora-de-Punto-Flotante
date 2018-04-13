import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/*Librerías para trabajar con archivos Excel*/
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Exportar {
      
      final private String rutaArchivo;
      final private File archivoXLS;
      private Workbook libro;
      private FileOutputStream archivo;
      private Sheet hoja;
      
      int numeroFila;
      int numeroCelda;
      /*La clase Row nos permitirá crear las filas*/
      Row fila;
      
      public Exportar(String nombreArchivo){
        /*La ruta donde se creará el archivo*/
        rutaArchivo = System.getProperty("user.dir")+"/"+nombreArchivo+".xls";
        /*Se crea el objeto de tipo File con la ruta del archivo*/
        archivoXLS = new File(rutaArchivo);
      }
      
      public void crearArchivo() throws IOException{
            
        /*Si el archivo existe se elimina*/
        if(archivoXLS.exists())
              archivoXLS.delete();
        /*Se crea el archivo*/
        archivoXLS.createNewFile();
        
        /*Se crea el libro de excel usando el objeto de tipo Workbook*/
        libro = new HSSFWorkbook();
        /*Se inicializa el flujo de datos con el archivo xls*/
        archivo = new FileOutputStream(archivoXLS);
      }
      
      public void crearNuevaHoja(String nombreHoja){
        
            /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
            hoja = libro.createSheet(nombreHoja);
            fila= hoja.createRow(0);;
            numeroFila= 0;
            numeroCelda= 0;
      }
      
      public void insertarDatoEnFila(Object texto, int numeroFilita){
            
            if(numeroFilita > numeroFila){
                  fila = hoja.createRow(numeroFilita);
                  numeroFila++;
                  numeroCelda=0;
                  insertarDato(texto.toString());
            }
            else{
                  insertarDato(texto.toString());
            }
      }
      
      private void insertarDato(String texto){
            
            /*Creamos la celda a partir de la fila actual*/
            Cell celda = fila.createCell(numeroCelda);
            celda.setCellValue(texto);
            numeroCelda++;
      }
      
        public void finalizarArchivo() throws IOException{
              
        /*Escribimos en el libro*/
        libro.write(archivo);
        /*Cerramos el flujo de datos*/
        archivo.close();
        /*Y abrimos el archivo con la clase Desktop*/
        Desktop.getDesktop().open(archivoXLS);
        }
    }