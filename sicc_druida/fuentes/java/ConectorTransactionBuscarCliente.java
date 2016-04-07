
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorTransactionBuscarCliente  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("NOMBRE","DTBuscarCliente" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Conector para realizar la paginacion de la busqueda de cliente" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("TRAMADO"));
      ((Element)v.get(1)).setAttribute("CAMPO_FINAL","HAY_MAS" );
      ((Element)v.get(1)).setAttribute("VALOR_FINAL","false" );
      ((Element)v.get(1)).setAttribute("CAMPO_PADRE","WRAPPER" );
      ((Element)v.get(1)).setAttribute("NUMERO_TRAMAS","1" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("TRAMA"));
      ((Element)v.get(2)).setAttribute("CAMPO_ENTRADA","oidE" );
      ((Element)v.get(2)).setAttribute("CAMPO_SALIDA","OIDPAG" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(4)).setAttribute("NOMBRE","oidE" );
      ((Element)v.get(4)).setAttribute("TIPO","STRING" );
      ((Element)v.get(4)).setAttribute("LONGITUD","15" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(5)).setAttribute("NOMBRE","parametros" );
      ((Element)v.get(5)).setAttribute("TIPO","STRING" );
      ((Element)v.get(5)).setAttribute("LONGITUD","1000" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:3   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */


   }

}
