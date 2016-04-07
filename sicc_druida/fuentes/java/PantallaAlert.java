
import org.w3c.dom.*;
import java.util.ArrayList;

public class PantallaAlert  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PantallafrmAlert" );
      ((Element)v.get(0)).setAttribute("titulo","SICC Belcorp" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#D8D8D8" );
      ((Element)v.get(0)).setAttribute("msgle","Error" );
      ((Element)v.get(0)).setAttribute("onload","obtenerParametros();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r	\r	  var parametros;\r   \r      function frmAlertAceptar(){\r      	window.returnValue = 1;\r      	window.close();\r      }\r\r		function obtenerParametros(){\r				try{\r					var parametros = window.dialogArguments;\r					lblError.innerHTML = parametros.descripcionMensaje;\r					btnCancelar.focus();\r				}\r				catch(e)\r				{\r				\r				}\r		}\r	\r   \r   "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frmAlert" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("table"));
      ((Element)v.get(4)).setAttribute("width","460" );
      ((Element)v.get(4)).setAttribute("border","0" );
      ((Element)v.get(4)).setAttribute("cellspacing","0" );
      ((Element)v.get(4)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).setAttribute("bgcolor","#D8D8D8" );
      ((Element)v.get(4)).setAttribute("align","center" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("td"));
      ((Element)v.get(6)).setAttribute("colspan","3" );
      ((Element)v.get(6)).setAttribute("style","height:23" );
      ((Element)v.get(6)).setAttribute("align","center" );
      ((Element)v.get(6)).setAttribute("valign","bottom" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(7)).setAttribute("width","100%" );
      ((Element)v.get(7)).setAttribute("border","0" );
      ((Element)v.get(7)).setAttribute("cellspacing","0" );
      ((Element)v.get(7)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(10)).setAttribute("width","38" );
      ((Element)v.get(10)).setAttribute("height","23" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("class","titulos" );
      ((Element)v.get(11)).setAttribute("width","100%" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(12)).setAttribute("nombre","lblErr" );
      ((Element)v.get(12)).setAttribute("ancho","60" );
      ((Element)v.get(12)).setAttribute("alto","20" );
      ((Element)v.get(12)).setAttribute("filas","1" );
      ((Element)v.get(12)).setAttribute("cod","1043" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:8   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(4)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("td"));
      ((Element)v.get(14)).setAttribute("colspan","3" );
      ((Element)v.get(14)).setAttribute("style","height:60" );
      ((Element)v.get(14)).setAttribute("align","center" );
      ((Element)v.get(14)).setAttribute("valign","middle" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("div"));
      ((Element)v.get(15)).setAttribute("style","width:455;" );
      ((Element)v.get(15)).setAttribute("id","lblError" );
      ((Element)v.get(15)).setAttribute("class","datosCampos" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","30" );
      ((Element)v.get(17)).setAttribute("height","8" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","8" );
      ((Element)v.get(18)).setAttribute("height","8" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","400" );
      ((Element)v.get(19)).setAttribute("class","datosCampos" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(19)).setAttribute("valign","top" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("input"));
      ((Element)v.get(20)).setAttribute("type","button" );
      ((Element)v.get(20)).setAttribute("id","btnCancelar" );
      ((Element)v.get(20)).setAttribute("name","btnCancelar" );
      ((Element)v.get(20)).setAttribute("value","Aceptar" );
      ((Element)v.get(20)).setAttribute("class","botonContenido" );
      ((Element)v.get(20)).setAttribute("onClick","frmAlertAceptar()" );
      ((Element)v.get(20)).setAttribute("style","width:80" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","30" );
      ((Element)v.get(21)).setAttribute("height","10" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","8" );
      ((Element)v.get(22)).setAttribute("height","10" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */
      /* Termina nodo:4   */

      /* Empieza nodo:23 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","txtErrorMessage" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:3   */


   }

}
