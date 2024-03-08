package design.patterns.structural.facade.subsystems.email;

import java.util.Map;

public class EmailSystem {

    public void sendEmail(Map<String, String> values) {
        String template = """
                          
                          **************************************
                          |To: $name
                          |from: FacadeSystem
                          |
                          |Muchas gracias por utilizar el servicio en 
                          |linea para realizar sus pagos.
                          |
                          |Hace un momento acabamos de recibir un pago:
                          |
                          |Monto del pago: $amount.
                          |Nuevo Saldo: $newBalance.
                          |Tarjeta terminaci\u00f3n: $cardNumber
                          |Referencia de pago: $reference
                          |Nuevos status: $newStatus
                          |
                          |Gracias por su preferencia.
                          |
                          |Este correo no deber\u00e1 ser contestado ya que 
                          |ha sido enviado por un proceso autom\u00e1tico
                          **************************************""";
        
        for(String str : values.keySet()){
            template = template.replace(str, values.get(str));
        }
        
        System.out.println(template);
    }
    
}
