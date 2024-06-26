public class ConvertidorDeMoneda {
    Double convertirMoneda(Double cantidad, Moneda monedaOriginal, String claveMonedaNueva){
        return  cantidad * monedaOriginal.conversion_rates().get(claveMonedaNueva);
    }

}
