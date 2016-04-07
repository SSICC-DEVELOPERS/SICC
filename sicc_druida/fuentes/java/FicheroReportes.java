
import org.w3c.dom.*;
import java.util.ArrayList;

public class FicheroReportes  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("FICHERO"));
      ((Element)v.get(0)).setAttribute("nombre","Reporte" );
      ((Element)v.get(0)).setAttribute("extension","pdf" );
      ((Element)v.get(0)).setAttribute("contenido","application/pdf" );
      ((Element)v.get(0)).setAttribute("separador","TAB" );
      ((Element)v.get(0)).setAttribute("descargable","SI" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1)).setAttribute("ID","salida" );
      ((Element)v.get(1)).setAttribute("NOMBRE","salida" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","salida" );
      ((Element)v.get(3)).setAttribute("TIPO","FICHEROSTREAM" );
      ((Element)v.get(3)).setAttribute("LONGITUD","100" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:2   */
      /* Termina nodo:1   */


   }

}
