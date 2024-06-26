import java.util.Scanner;

//trello del proyecto: https://trello.com/b/RU41cvaQ/conversor-de-moneda-challenge-one-java-back-end

//apikey:  3fa25d4595ac1fc0089af8bc
//Example Request: https://v6.exchangerate-api.com/v6/3fa25d4595ac1fc0089af8bc/latest/USD
public class Main {
    public static void main(String[] args) {
        int opcion;
        Double cantidadAConvertir;
        String claveMonedaOriginal="USD";
        String claveMonedaNueva="USD" ;
        Scanner cin = new Scanner(System.in);
        String menuPrincipal = """ 
                    *************************************
                     CONVERSOR DE MONEDAS
                        
                        Convertir de --- a:
                    		1) Dolar -> Peso argentino
                    		2) Peso Argentino -> Dolar
                    		3) Dolar -> Real Brasileño
                    		4) Real Brasileño -> Dolar
                    		5) Dolar -> Peso Colombiano
                    		6) Peso Colombiano -> Dolar
                    		7) Dolar -> Peso Mexicano
                    		8) Peso Mexicano -> Dolar
                    		9) Salir
                    	
                    *************************************
                    Opción:
                    """;



        do{

            System.out.println(menuPrincipal);

            //Aqui se lee la respuesta del usuario
            try{

                opcion = Integer.valueOf(cin.nextLine());
                Boolean opcionValida;

                switch(opcion){
                    case 1:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "ARS";
                        opcionValida = true;
                        break;
                    case 2:
                        claveMonedaOriginal = "ARS";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 3:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "BRL";
                        opcionValida = true;
                        break;
                    case 4:
                        claveMonedaOriginal = "BRL";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 5:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "COP";
                        opcionValida = true;
                        break;
                    case 6:
                        claveMonedaOriginal = "COP";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 7:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "MXN";
                        opcionValida = true;
                        break;
                    case 8:
                        claveMonedaOriginal = "MXN";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 9:
                        System.out.println("Finalizando el programa");
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        opcionValida = false;
                }

                if (opcionValida){
                    System.out.println("Ingresa el valor que deseas convertir");
                    cantidadAConvertir = Double.valueOf(cin.nextLine());

                    // realizar consulta a la API
                    ConsultaApi consultaMoneda = new ConsultaApi();
                    Moneda monedaOriginal = consultaMoneda.buscarMoneda(claveMonedaOriginal);


                    //convertir una canditad
                    ConvertidorDeMoneda convertidorMoneda = new ConvertidorDeMoneda();
                    Double nuevaCantidad = convertidorMoneda.convertirMoneda(cantidadAConvertir, monedaOriginal, claveMonedaNueva);
                    System.out.println("La cantidad que quieres convertir es: " + cantidadAConvertir + " " + claveMonedaOriginal);
                    System.out.println("la nueva cantidad es: " + nuevaCantidad + " " + claveMonedaNueva);
                }
            }catch (Exception e){
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                opcion = 1;
            }



        }while (opcion != 9);
    }



}