package Model.Operations;


public class Check {

    public static int isNull(String s) {
        // Esta función comprueba si el string es nulo o vacío
        if (s == null) { // Verificamos primero si s es null, porque 
            //si hcemos trim a un null dara un error
            return -1;
        }
        s = s.trim(); // Ahora aplicamos trim() solo si s no es null
        if (s.length() == 0) { // Luego verificamos si está vacío
            return -1;
        } else {
            return 0;
        }
    }
    
    public static int minLenght(String s){
        //esta funcion comprueba si el string no esta vacio
        // y si ademas es mas largo que 3 caracteres

        //en java no hace falta poner los "::", si quiero llamar a un metodo seria 
        //Check.isnull(s)
        
        if(Check.isNull(s)==0){
            if(s.length()<3){
                return -3;
            } else {
                return 0;
            }
        }else{
            return-1;
        }

    }

    public static int maxLenght(String s){
        //esta funcion comprueba si el string no esta vacio
        // y si ademas es mas largo que 10 caracteres
        //en java no hace falta poner los "::", si quiero llamar a un metodo seria
        if(Check.isNull(s)==0){
            
            
            if(s.length()>10){
                return -7;
            } else {
                return 0;
            }
        }else{
            return -1;
        }
        
    }
    

    public static int minMaxLength(String s){
        //esta funcion comprueba si el length es mayor de 3 y menos de 15

        if(Check.isNull(s)==0){
            if(s.length()<3){
                return -3;
            } else if (s.length()>15){
                return -7;
            } 
        }
        return 0;

    }


    
/*
 * public static void isDate(int s){
        //esta funcion comprueba si el objeto localdate no esta vacio
        // y si ademas es una fecha valida
        if(Check.isNull(s)==0){
        LocalDate date= LocalDate.now();
        //aqui tengo que llamar l setter introdciendole la varaiable datatimeformatter
        }
    
    }
 * 
 */
    public static int range( int e){
        //esta funcion coprueba si el numero es nulo o positivo
        if(e<0){
            return -6;
        }else {
                return 0;
            }
    }
        
    public static int validate(Double price){
        //esta funcion comprueba si el int es nulo o positivo
        if(price<0){
            return -6;
        }else {
            return 0;
        }
    }

    public static int checkIsbn(String isbn){
        //aqui pasamos los numeros del isbn cmo strings i los comprobamos
        if()
    }
    

    public static String getErrorMessage(int  e){
        //esta funcion retorna el mensajito personalizado como a mi me gusta
        return switch (e) {
            case 0 -> "";
            case -1 -> "No puede ser null";
            case -2 -> "No puede estar vacio";
            case -3 -> "Has introducido pocos caracteres";
            case -4 -> "Formato de fecha incorrecto";
            case -5 -> "El campo introducido es demasiado corto";
            case -6 -> "Has introducido un numero negativo";
            case -7 -> "Has introducido demasiados caracteres";
            case -8 -> "Isbn no valido, introduce una cifra de 13 dígitos válido";
            case -9 -> "DNI no válido";
            case -10 -> "Formato de email incorrecto";
            case -11 -> "Formato de Software incorrecto";
            default -> "No reconocible";
        }; //case -12: return;;
        //case -13: return;
    }


}
