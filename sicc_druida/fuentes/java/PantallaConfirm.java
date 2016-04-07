
import org.w3c.dom.*;
import java.util.ArrayList;

public class PantallaConfirm  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PantallaConfirm" );
      ((Element)v.get(0)).setAttribute("titulo","SICC Belcorp" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#D8D8D8" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","obtenerParametros();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r	#E1 {color:black;}\r	#botonconfirmF {  font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; font-weight: normal; color: #FFFFFF; background-color: #4A699C; border-color: #D0F7FD #333366 #4A699C #D0F7FD; border-style: outset ; width : 200}\r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r   	\r	  var parametros;\r   \r      function fnAceptar(){\r			window.returnValue = true;\r			window.close();\r      }\r\r      function fnCancelar(){\r      	window.returnValue = false;\r      	window.close();\r      }\r\r		function obtenerParametros(){\r				try{\r					var parametros = window.dialogArguments;\r					lblError.innerHTML = parametros.descripcionMensaje;\r					btnCancelar.focus();\r				}\r				catch(e)\r				{\r				\r				}\r		}\r\r   \r   "));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmPantallaConfirm" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(6)).setAttribute("width","460" );
      ((Element)v.get(6)).setAttribute("border","0" );
      ((Element)v.get(6)).setAttribute("cellspacing","0" );
      ((Element)v.get(6)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).setAttribute("bgcolor","#D8D8D8" );
      ((Element)v.get(6)).setAttribute("align","center" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("td"));
      ((Element)v.get(8)).setAttribute("colspan","3" );
      ((Element)v.get(8)).setAttribute("style","height:23" );
      ((Element)v.get(8)).setAttribute("align","center" );
      ((Element)v.get(8)).setAttribute("valign","bottom" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(9)).setAttribute("width","100%" );
      ((Element)v.get(9)).setAttribute("border","0" );
      ((Element)v.get(9)).setAttribute("cellspacing","0" );
      ((Element)v.get(9)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(12)).setAttribute("width","38" );
      ((Element)v.get(12)).setAttribute("height","23" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("class","titulos" );
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(14)).setAttribute("nombre","lblAlerta" );
      ((Element)v.get(14)).setAttribute("ancho","50" );
      ((Element)v.get(14)).setAttribute("alto","20" );
      ((Element)v.get(14)).setAttribute("filas","1" );
      ((Element)v.get(14)).setAttribute("cod","1042" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:10   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(6)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("colspan","3" );
      ((Element)v.get(16)).setAttribute("style","height:60" );
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(16)).setAttribute("valign","middle" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("div"));
      ((Element)v.get(17)).setAttribute("style","width:455;" );
      ((Element)v.get(17)).setAttribute("id","lblError" );
      ((Element)v.get(17)).setAttribute("class","datosCampos" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","30" );
      ((Element)v.get(19)).setAttribute("height","8" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","8" );
      ((Element)v.get(20)).setAttribute("height","8" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","400" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("class","datosCampos" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(21)).setAttribute("valign","top" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("input"));
      ((Element)v.get(22)).setAttribute("type","button" );
      ((Element)v.get(22)).setAttribute("id","btnAceptar" );
      ((Element)v.get(22)).setAttribute("name","btnAceptar" );
      ((Element)v.get(22)).setAttribute("value","Aceptar" );
      ((Element)v.get(22)).setAttribute("class","botonContenido" );
      ((Element)v.get(22)).setAttribute("onClick","javascript:fnAceptar()" );
      ((Element)v.get(22)).setAttribute("style","width:80" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","30" );
      ((Element)v.get(23)).setAttribute("height","10" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("input"));
      ((Element)v.get(24)).setAttribute("type","button" );
      ((Element)v.get(24)).setAttribute("id","btnCancelar" );
      ((Element)v.get(24)).setAttribute("name","btnCancelar" );
      ((Element)v.get(24)).setAttribute("value","Cancelar" );
      ((Element)v.get(24)).setAttribute("class","botonContenido" );
      ((Element)v.get(24)).setAttribute("onClick","javascript:fnCancelar()" );
      ((Element)v.get(24)).setAttribute("style","width:80" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:21   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","30" );
      ((Element)v.get(25)).setAttribute("height","10" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","8" );
      ((Element)v.get(26)).setAttribute("height","10" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:18   */
      /* Termina nodo:6   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","txtErrorMessage" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:5   */


   }

}
