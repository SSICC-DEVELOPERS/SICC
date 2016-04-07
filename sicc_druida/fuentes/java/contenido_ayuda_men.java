
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ayuda_men  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PantallaAyudaMenu" );
      ((Element)v.get(0)).setAttribute("titulo","Ayuda" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#D8D8D8" );
      ((Element)v.get(0)).setAttribute("msgle","Help" );
      ((Element)v.get(0)).setAttribute("onload","fnErrores();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r   \r   \r	  function obtenerParametros()\r	  {\r		return true;\r	  }\r\r      function volver(){\r			window.returnValue = 0;\r			window.close();\r      }\r\r	  function impresion()\r	  {\r			fImprimir();\r			return true;\r	  }\r\r       function fnErrores()\r	   {\r			var codigo = get(\"frmPantallaAyuda.errCodigo\");\r			var descripcion = get(\"frmPantallaAyuda.errDescripcion\");\r			var txtDescripcion = descripcion;\r\r			if (codigo!=null && descripcion!=null)\r			{\r				if ( codigo=='' && descripcion!='')\r				{\r		 			var errNum = descripcion.split(\"_\");					 \r					txtDescripcion = GestionarMensaje(errNum[1],null,null,null);	\r				}\r				\r				if ( descripcion!='' ) {								\r					alert(txtDescripcion);\r					window.returnValue = 0;\r					window.close();\r				}\r			}\r		}\r\r   \r   "));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmPantallaAyuda" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(8)).setAttribute("width","100%" );
      ((Element)v.get(8)).setAttribute("height","23" );
      ((Element)v.get(8)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(8)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).setAttribute("cellspacing","0" );
      ((Element)v.get(8)).setAttribute("border","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(11)).setAttribute("src","flechaTitle.jpg" );
      ((Element)v.get(11)).setAttribute("width","38" );
      ((Element)v.get(11)).setAttribute("height","23" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).setAttribute("class","titulos" );
      ((Element)v.get(12)).setAttribute("width","100%" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));

      /* Elemento padre:12 / Elemento actual: 13   */
      v.add(doc.createTextNode("Ayuda"));
      ((Element)v.get(12)).appendChild((Text)v.get(13));

      /* Termina nodo Texto:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(15)).setAttribute("src","drcha_title.gif" );
      ((Element)v.get(15)).setAttribute("width","42" );
      ((Element)v.get(15)).setAttribute("height","23" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("BR"));
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("SCROLL"));
      ((Element)v.get(17)).setAttribute("nombre","miscroll" );
      ((Element)v.get(17)).setAttribute("x","10" );
      ((Element)v.get(17)).setAttribute("y","38" );
      ((Element)v.get(17)).setAttribute("ancho","425" );
      ((Element)v.get(17)).setAttribute("alto","250" );
      ((Element)v.get(17)).setAttribute("colorf","" );
      ((Element)v.get(17)).setAttribute("visible","hidden" );
      ((Element)v.get(17)).setAttribute("incx","0" );
      ((Element)v.get(17)).setAttribute("incy","10" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(18)).setAttribute("bgcolor","#D8D8D8" );
      ((Element)v.get(18)).setAttribute("align","left" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","30" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","8" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("height","8" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","435" );
      ((Element)v.get(22)).setAttribute("valign","top" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(23)).setAttribute("nombre","lblcontenido" );
      ((Element)v.get(23)).setAttribute("alto","100%" );
      ((Element)v.get(23)).setAttribute("ancho","400" );
      ((Element)v.get(23)).setAttribute("id","datosCamposLeft" );
      ((Element)v.get(23)).setAttribute("texto","" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(23)).setAttribute("filas","1" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:19   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","30" );
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
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:4   */


   }

}
