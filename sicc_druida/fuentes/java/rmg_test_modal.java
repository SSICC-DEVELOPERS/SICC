
import org.w3c.dom.*;
import java.util.ArrayList;

public class rmg_test_modal  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","rmg_test_modal" );
      ((Element)v.get(0)).setAttribute("cod","0136" );
      ((Element)v.get(0)).setAttribute("titulo","rmg_test_modal" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","rmg_test_modal" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","rmg_test_modal.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(2)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(3)).setAttribute("nombre","accion" );
      ((Element)v.get(3)).setAttribute("valor","" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 2   */
      v.add(doc.createElement("table"));
      ((Element)v.get(4)).setAttribute("width","100%" );
      ((Element)v.get(4)).setAttribute("border","0" );
      ((Element)v.get(4)).setAttribute("cellspacing","0" );
      ((Element)v.get(4)).setAttribute("cellpadding","0" );
      ((Element)v.get(2)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(7)).setAttribute("src","b.gif" );
      ((Element)v.get(7)).setAttribute("width","12" );
      ((Element)v.get(7)).setAttribute("height","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(8)).setAttribute("width","776" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(9)).setAttribute("nombre","btnBuscarProductoPrincipal" );
      ((Element)v.get(9)).setAttribute("ID","botonContenido" );
      ((Element)v.get(9)).setAttribute("tipo","html" );
      ((Element)v.get(9)).setAttribute("accion","javascript:alert('testing...');" );
      ((Element)v.get(9)).setAttribute("estado","false" );
      ((Element)v.get(9)).setAttribute("cod","431" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(5)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(11)).setAttribute("src","b.gif" );
      ((Element)v.get(11)).setAttribute("width","12" );
      ((Element)v.get(11)).setAttribute("height","12" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:10   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */
      /* Termina nodo:2   */


   }

}
