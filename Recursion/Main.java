public class Main{
    public static void main(String[] args){

        int n=5;
        String palabra="hola";
        int [] arreglo = {9,6,1,8,3};

        System.out.println("factorial = "+factorialIterativo(n));
        System.out.println("fibonacci = "+fibonacci(n));
        System.out.println("secuencia = "+secuencia(n));
        System.out.println("invertir = "+invertir(palabra, palabra.length()));

    }

    public static String find (String n, int i){
        if(i==1){
            return " "+ n.charAt(i-1);
        } else{
            return " "+n.charAt(i-1)+ invertir(n,i-1);
        }
    }

    public static String invertir(String n, int i){
        if(i==1){
            return " "+ n.charAt(i-1);
        } else{
            return " "+n.charAt(i-1)+ invertir(n,i-1);
        }
    }

    public static String secuencia(int n){
        
        if(n==1){
            return " "+1;
        } else{
            return secuencia(n-1)+" "+n;
        }
    }

    public static int factorialIterativo(int n){
        int result=1;
        for(int i=2; i<=n; i++){
            result=result=result*i;
        }
        return result;
    }

    public static int factorialRecursivo(int n){
        if(n==1){
            return 1;

        } else{
            return n*factorialRecursivo(n-1);
        }
        
    }
    public static int fibonacci (int n){
        if(n==1 || n==2){
            return 1;

        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }


}