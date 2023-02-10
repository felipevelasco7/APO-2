public class Seguimiento1 {

    public static void main(String [] args){
        int [] arreglo = new int[] {12, -1, 15, 4, 4 , 14};
        String palabra="hola";
        int number= 4;

        System.out.println("suma de arreglo = "+arraySum(arreglo, arreglo.length));
        System.out.println("invertir = "+invertir(palabra, palabra.length()));
        System.out.println("promedio del arreglo = "+arrayProm(arreglo, arreglo.length));
        index(arreglo, number, 0);
    }

    public static int arraySum (int [] array, int length) {
        if(length==1){
            return array[0];
        } else{
            return array[length-1]+ arraySum(array, length-1);
        }
    }

    public static String invertir(String n, int i){
        if(i==1){
            return " "+ n.charAt(i-1);
        } else{
            return " "+n.charAt(i-1)+ invertir(n,i-1);
        }
    }
    
    public static int arrayProm (int [] array, int i) {
       return arraySum(array, i)/i;
    }

    public static void index (int [] array, int number, int i) {
        if(i!=array.length-1) {
            if(number==array[i]) {
                System.out.println ("La posicion es: "+i);
            }
            else{
                index(array, number, i+1);
            }
        }
    }
    
}
