
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_prueba_grupo  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0152" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Grupo" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Grupo" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(2)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(3)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(3)).setAttribute("valor","LPPruebaGrupo" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 2   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","accion" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(2)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 2   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(5)).setAttribute("nombre","rejlistado3" );
      ((Element)v.get(2)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 2   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(6)).setAttribute("nombre","rejlistado4" );
      ((Element)v.get(2)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:2   */


   }

}
