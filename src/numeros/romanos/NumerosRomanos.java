/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros.romanos;

import java.util.Scanner;


/**
 *
 * @author Fabián
 */
public class NumerosRomanos {

    /**
     */
   

    public static int millares = 0, centenas = 0, decenas = 0, unidades = 0;
       public static String [][] romanos={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
             {"","X","XX","XXX","XL","L","LX","LXX","LXX","XC"},
             {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
             {"","M","MM","MMM","Mv","v","vM","vMM","vMMM","Mx"}};//los diferentes numeros
       private static Scanner scan;

       public static void main(String[] args) {


          System.out.println("deme el numero");
          scan = new Scanner(System.in);
          String numero = scan.nextLine();
          NumerosRomanos.convertir(numero);//pedicion de datos de entrada
       }

       private static void convertir(String numero) {
          try{ //intenta convertir entero a romano
             NumerosRomanos.obtenerNotDesarrollada(Integer.valueOf(numero));
             System.out.println(NumerosRomanos.obtenerRomano());
          }catch (NumberFormatException e){
             try{ //intenta convertir romano a entero
                System.out.println(NumerosRomanos.obtenerArabigo(numero.trim()));
             }
             catch(Exception e1){

                System.out.println("Numero invalido");
             }
          }
          catch(Exception e){
             System.out.println("Numero invalido");
        //un try cach por si marca error
          }

       }

       public static void obtenerNotDesarrollada(int numero) {
          millares = (int)numero / 1000;
          centenas = (int)numero % 1000 / 100;
          decenas = (int)numero % 1000 % 100 / 10;
          unidades = (int)numero % 1000 % 100 % 10;
       }
//para obtener de entero a romano
       public static String obtenerRomano(){
          return romanos[3][millares]+""+
                romanos[2][centenas]+""+
                romanos[1][decenas]+""+
                romanos[0][unidades]+"";
       }
//especificacion del numero romano
       private static String obtenerArabigo(String numero) {
          int size = numero.length();
          String arabigo = "";
          for (int i = 3; i>-1; i--){
             for(int j = size; j>-1; j--){
                int valor = -1;
                valor = escanear(numero.substring(0,j),i);
                if (valor > -1){
                   arabigo = arabigo + valor;
                   numero = numero.substring(j,size);
                   size = numero.length();
                   break;
                }//calculando el tamaño del numero
             }
          }
          return arabigo;
       }

       private static int escanear(String cadena, int orden) {
          for (int j = 9; j>-1; j-- ){
             if(romanos[orden][j].equals(cadena)){
                return j;
             }
          }
          return -1;
       }
    }
