
import org.w3c.dom.*;
import java.util.ArrayList;

public class MMGPantallaError  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MMGPantallaError" );
      ((Element)v.get(0)).setAttribute("titulo","Error" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Error" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1)).setAttribute("width","460" );
      ((Element)v.get(1)).setAttribute("border","0" );
      ((Element)v.get(1)).setAttribute("cellspacing","0" );
      ((Element)v.get(1)).setAttribute("cellpadding","0" );
      ((Element)v.get(1)).setAttribute("bgcolor","#D8D8D8" );
      ((Element)v.get(1)).setAttribute("align","center" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(3)).setAttribute("colspan","3" );
      ((Element)v.get(3)).setAttribute("align","center" );
      ((Element)v.get(3)).setAttribute("valign","bottom" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(4)).setAttribute("width","100%" );
      ((Element)v.get(4)).setAttribute("border","0" );
      ((Element)v.get(4)).setAttribute("cellspacing","0" );
      ((Element)v.get(4)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(7)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(7)).setAttribute("width","38" );
      ((Element)v.get(7)).setAttribute("height","23" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(8)).setAttribute("width","100%" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(9)).setAttribute("id","titulos" );
      ((Element)v.get(9)).setAttribute("nombre","tituloErrorLabel" );
      ((Element)v.get(9)).setAttribute("ancho","300" );
      ((Element)v.get(9)).setAttribute("alto","23" );
      ((Element)v.get(9)).setAttribute("filas","1" );
      ((Element)v.get(9)).setAttribute("cod","MMGGlobal.errordialog.title.label" );
      ((Element)v.get(9)).setAttribute("enviaroculto","N" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */
      /* Termina nodo:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:10 / Elemento padre: 1   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(11)).setAttribute("width","30" );
      ((Element)v.get(11)).setAttribute("height","8" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(12)).setAttribute("width","8" );
      ((Element)v.get(12)).setAttribute("height","8" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(13)).setAttribute("width","400" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(14)).setAttribute("id","datosCampos" );
      ((Element)v.get(14)).setAttribute("nombre","mensajeError" );
      ((Element)v.get(14)).setAttribute("ancho","400" );
      ((Element)v.get(14)).setAttribute("alto","64" );
      ((Element)v.get(14)).setAttribute("filas","1" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(14)).setAttribute("enviaroculto","N" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(15)).setAttribute("width","30" );
      ((Element)v.get(15)).setAttribute("height","10" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","8" );
      ((Element)v.get(16)).setAttribute("height","10" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:10   */

      /* Empieza nodo:17 / Elemento padre: 1   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(18)).setAttribute("width","30" );
      ((Element)v.get(18)).setAttribute("height","8" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","8" );
      ((Element)v.get(19)).setAttribute("height","8" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(20)).setAttribute("width","400" );
      ((Element)v.get(20)).setAttribute("class","datosCampos" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(20)).setAttribute("valign","top" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(21)).setAttribute("nombre","botonAceptar" );
      ((Element)v.get(21)).setAttribute("ID","botonContenido" );
      ((Element)v.get(21)).setAttribute("tipo","html" );
      ((Element)v.get(21)).setAttribute("accion","window.close();" );
      ((Element)v.get(21)).setAttribute("estado","true" );
      ((Element)v.get(21)).setAttribute("cod","MMGGlobal.errordialog.aceptbutton.label" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(22)).setAttribute("width","30" );
      ((Element)v.get(22)).setAttribute("height","10" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","8" );
      ((Element)v.get(23)).setAttribute("height","10" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:17   */

      /* Empieza nodo:24 / Elemento padre: 1   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(25)).setAttribute("colspan","3" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","8" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:1   */


   }

}
