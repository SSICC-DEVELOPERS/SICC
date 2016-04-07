
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorDTConsultarDetalleFormaPago  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","DRUIDATRANSACTION" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("NOMBRE","LPDTConsultarDetalleFormaPago" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Conector transaccional para carga la lista de registros de Forma de Pago Detalle en función de la Forma de Pago de Cabecera seleccionada" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","oid" );
      ((Element)v.get(2)).setAttribute("TIPO","LONG" );
      ((Element)v.get(2)).setAttribute("LONGITUD","10" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */


   }

}
