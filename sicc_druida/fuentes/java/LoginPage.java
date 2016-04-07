
import org.w3c.dom.*;
import java.util.ArrayList;

public class LoginPage  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","" );
      ((Element)v.get(0)).setAttribute("titulo","Titulo de la Página" );
      ((Element)v.get(0)).setAttribute("estilos","" );
      ((Element)v.get(0)).setAttribute("colorf","white" );
      ((Element)v.get(0)).setAttribute("msgle","Descripción línea estado" );
      ((Element)v.get(0)).setAttribute("onload","document.location='http://localhost:8000/belcorpweb/inicio_v3/principal.html'" );
      ((Element)v.get(0)).setAttribute("repeat","N" );


   }

}
