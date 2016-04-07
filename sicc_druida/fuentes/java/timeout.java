
import org.w3c.dom.*;
import java.util.ArrayList;

public class timeout  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","timeout" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Caduco la sesión" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Caduco la sesión" );
      ((Element)v.get(0)).setAttribute("onload","goToHome();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r     \r	function goToHome() {\r		getAbsoluteTop().location.href=document.all.tags(\"INPUT\")[\"destino\"].value;\r	}\r\r	function getAbsoluteTop(){\r		var oWin = window;\r		if(opener){\r			oWin = opener;\r			window.close();\r		}\r		if(oWin.dialogArguments){\r			while (oWin.dialogArguments && oWin.dialogArguments.opener){\r				var oWinTmp = oWin.dialogArguments.opener;\r				oWin.close();\r				oWin = oWinTmp;\r			}\r		}\r		return oWin.top;\r	}\r\r   \r  "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(3)).setAttribute("nombre","frm" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(4)).setAttribute("nombre","destino" );
      ((Element)v.get(4)).setAttribute("valor","" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("P"));
      ((Element)v.get(3)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r	Si Ud. no es redirigido automáticamente, haga clic "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("a"));
      ((Element)v.get(7)).setAttribute("href","#" );
      ((Element)v.get(7)).setAttribute("onclick","goToHome()" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Elemento padre:7 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r	aquí"));
      ((Element)v.get(7)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */
      /* Termina nodo:7   */

      /* Elemento padre:5 / Elemento actual: 9   */
      v.add(doc.createTextNode(".\r	"));
      ((Element)v.get(5)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */
      /* Termina nodo:5   */
      /* Termina nodo:3   */


   }

}
