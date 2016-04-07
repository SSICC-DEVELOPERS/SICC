
import org.w3c.dom.*;
import java.util.ArrayList;

public class FicheroGP  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("FICHERO"));
      ((Element)v.get(0)).setAttribute("nombre","GuiaProductos" );
      ((Element)v.get(0)).setAttribute("extension","xls" );
      ((Element)v.get(0)).setAttribute("contenido","text/plain" );
      ((Element)v.get(0)).setAttribute("separador",";" );
      ((Element)v.get(0)).setAttribute("descargable","SI" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */


   }

}
