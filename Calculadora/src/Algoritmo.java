import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Algoritmo {
    
    // Atributos definidos por default
    private int digitosMantisa;
    private int tipoRedondeo;
    
    // Constructor
    public Algoritmo(int digitosMantisa, int tipoRedondeo){
        this.digitosMantisa= digitosMantisa;
        this.tipoRedondeo= tipoRedondeo;
    }
    
    // BigDecimal es una clase de Math, y por ello un tipo de dato
    
    private BigDecimal convertirRedondearANCS(double numero, int tipoRedondeo, int digitosMantisa){     // NCS: "Notación Científica Significativa
        
        int exponente=0;
        String numeroEnTexto, aux;
        BigDecimal aux2;
        //float numero= (float)numeroUsuario;
        
        if(Math.abs(numero)<1){
                while (Math.abs(numero*10)<1){
                    if(numero==0)
                        break;
                    numero= numero*10;
                    exponente--;
                }
            }else{
                while (Math.abs(numero)>=1){
                    numero= numero/10;
                    exponente++;
                }
            }
        // De esta manera lo convierto a Notación Científica xdxdxdx...
        numeroEnTexto= Double.toString(numero);
        if(numero!=0){
          //System.out.println("1: "+numeroEnTexto);
          aux2= redondear(numeroEnTexto, tipoRedondeo, digitosMantisa);
          
          aux= aux2.toString();
          aux= aux+"E"+exponente;
          //System.out.println("2: "+aux+"\n");
          return convertirABigDecimal(aux);
        }
         else 
            return convertirABigDecimal(numeroEnTexto);
    }
    
    private BigDecimal convertirABigDecimal(String texto){
          
          BigDecimal bigText= new BigDecimal(texto);
          return bigText;
    }
    
    public double obtenerErrorRelativoPorcentual(double numero){
          
          BigDecimal big;
          String numeroEnTexto= Double.toString(Math.abs(numero));
          big= redondear(numeroEnTexto, tipoRedondeo, digitosMantisa);
          numeroEnTexto= big.toString();
          numero= Double.parseDouble(numeroEnTexto);
          
          return numero*100;
    }
    
    public String imprimirEnNCS(double num){     // NCS: "Notación Científica Significativa
        
        int exponente=0;
        String aux;
        BigDecimal aux2;
        float numero= (float)num;
        
        if(Math.abs(numero)<1){
                while (Math.abs(numero*10)<1){
                    if(numero==0)
                        break;
                    numero= numero*10;
                    exponente--;
                }
            }else{
                while (Math.abs(numero)>=1){
                    numero= numero/10;
                    exponente++;
                }
            }
        aux= Float.toString(numero);
        aux2= redondear(aux, tipoRedondeo, digitosMantisa);
        aux= aux2.toString();
        aux= (aux+"E"+exponente);
        return aux;
    }
    
    public String imprimirEnNCSTOTAL(double numero){     // NCS: "Notación Científica Significativa
        
        int exponente=0;
        String aux;
        
        if(Math.abs(numero)<1){
                while (Math.abs(numero*10)<1){
                    if(numero==0)
                        break;
                    numero= numero*10;
                    exponente--;
                }
            }else{
                while (Math.abs(numero)>=1){
                    numero= numero/10;
                    exponente++;
                }
            }
        aux= numero+"E"+exponente;
        return aux;
    }
    
    private BigDecimal redondear(String numeroEnTexto, int tipoRedondeo, int digitosMantisa){
        
        BigDecimal big = new BigDecimal(numeroEnTexto);
        switch(tipoRedondeo){
            case 1:{
                // Este es el Redondeo clásico, el que nos enseñan en las escuelas
                big = big.setScale(digitosMantisa, RoundingMode.HALF_UP);
                break;
            }
            case 2:{
                //Este es el Truncado simple y común
                big = big.setScale(digitosMantisa, RoundingMode.DOWN);
                break;
            }
            case 3:{
                // Este es el Redondeo hacia arriba, siempre hacia ARRIBA
                big = big.setScale(digitosMantisa, RoundingMode.CEILING);
                break;
            }
/*            case 4: {
                //Este es el Redondeo hacia abajo, siempre hacia ABAJO sin importar qué
                big = big.setScale(digitosMantisa, RoundingMode.FLOOR);
                break;
            }     */
        }
        return big;
    }
    
    // En los siguientes métodos quizá parezca algo loco y repetitivo mi forma de convertir datos,
    //   pero no hallé otra manera de hacerlo  :c
    
    public double suma(double a, double b){
        
        BigDecimal semiResultado1, bigA, bigB, semiresultado2;
        String aux;
        double aux2, resultadoxD;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
          //System.out.println("A: "+bigA+"\n");
        bigB= convertirRedondearANCS(b, tipoRedondeo, digitosMantisa);
        // System.out.println("B: "+bigB+"\n");
        semiResultado1= bigA.add(bigB);
        aux= semiResultado1.toString();
        aux2= Double.parseDouble(aux);
        semiresultado2= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiresultado2.toString();
        resultadoxD= Double.parseDouble(aux);
        return resultadoxD;
    }
    public double resta(double a, double b){
        
        BigDecimal semiResultado1, bigA, bigB, semiresultado2;
        String aux;
        double aux2, resultadoxD;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
        bigB= convertirRedondearANCS(b, tipoRedondeo, digitosMantisa);
        semiResultado1= bigA.subtract(bigB);
        aux= semiResultado1.toString();
        aux2= Double.parseDouble(aux);
        semiresultado2= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiresultado2.toString();
        resultadoxD= Double.parseDouble(aux);
        return resultadoxD;
    }
    public double multiplicacion(double a, double b){
        
        BigDecimal semiResultado1, bigA, bigB, semiresultado2;
        String aux;
        double aux2, resultadoxD;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
        bigB= convertirRedondearANCS(b, tipoRedondeo, digitosMantisa);
        semiResultado1= bigA.multiply(bigB);
        aux= semiResultado1.toString();
        aux2= Double.parseDouble(aux);
        semiresultado2= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiresultado2.toString();
        resultadoxD= Double.parseDouble(aux);
        
        return resultadoxD;
    }
    public double division(double a, double b){
        
        BigDecimal semiResultado1= null, bigA, bigB, semiresultado2;
        String aux;
        double aux2, resultadoxD;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
        bigB= convertirRedondearANCS(b, tipoRedondeo, digitosMantisa);
        try{
            semiResultado1= bigA.divide(bigB);
        }catch(java.lang.RuntimeException e){
              System.out.println("[ Se produjo una excepción ]");
            switch(tipoRedondeo){
                  case 1:{
                        semiResultado1= bigA.divide(bigB, digitosMantisa, RoundingMode.HALF_UP);
                        break;
                  }
                  case 2:{
                        semiResultado1= bigA.divide(bigB, digitosMantisa, RoundingMode.DOWN);
                        break;
                  }
                  case 3:{
                        semiResultado1= bigA.divide(bigB, digitosMantisa, RoundingMode.CEILING);
                        break;
                  }
            }
        }
        aux= semiResultado1.toString();
        aux2= Double.parseDouble(aux);
        semiresultado2= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiresultado2.toString();
        resultadoxD= Double.parseDouble(aux);
        
        return resultadoxD;
    }
    
    public double raiz(double a){
        
        BigDecimal semiResultado, bigA;
        String aux;
        double aux2, resultado;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
        aux= bigA.toString();
        aux2= Double.parseDouble(aux);
        aux2= Math.sqrt(aux2);
        semiResultado= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiResultado.toString();
        resultado= Double.parseDouble(aux);
        
        return resultado;
    }
    
    public double potencia(double a, double b){
        
        BigDecimal semiResultado, bigA;
        String aux;
        double aux2, resultado;
        
        bigA= convertirRedondearANCS(a, tipoRedondeo, digitosMantisa);
        aux= bigA.toString();
        aux2= Double.parseDouble(aux);
        aux2= Math.pow(aux2, b);
        semiResultado= convertirRedondearANCS(aux2, tipoRedondeo, digitosMantisa);
        aux= semiResultado.toString();
        resultado= Double.parseDouble(aux);
        
        return resultado;
    }
}