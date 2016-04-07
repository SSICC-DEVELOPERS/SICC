
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_PantallaConfirmacionEG  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_PantallaConfirmacionEG" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Confirma Eliminacion" );
      ((Element)v.get(0)).setAttribute("onload","carga();" );
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
      v.add(doc.createTextNode("\r\r\r      function getPantallaInicio(){\r	 return parent.getPantallaInicio().split(\"=\")[1];\r      }\r\r\rfunction carga()\r{\r	var hayErrores = fnErrores();\r	if (hayErrores == false)\r	{\r		var accion = get(\"frmMain.accion\");\r		if (accion==\"\")\r		{\r										var nRetorno = GestionarMensaje(\"968\",  null, null, null);\r					if ( nRetorno == true )\r					{\r						set(\"frmMain.accion\", \"aceptar\")\r						set(\"frmMain.conectorAction\", \"LPEliminarEG\");\r						enviaSICC(\"frmMain\");\r					} else\r					{\r						set(\"frmMain.accion\", \"volver\");\r												set(\"frmMain.conectorAction\", \"LPEliminarEG\");\r						enviaSICC(\"frmMain\");\r					}\r		 } else if ( accion == \"aceptar\")\r		 {\r					var exito = get(\"frmMain.exito\");\r					if ( exito == \"SI\") \r					{\r												cdos_mostrarAlert(GestionarMensaje(\"989\"));\r					}\r					set(\"frmMain.accion\", \"volver\");\r										set(\"frmMain.conectorAction\", \"LPEliminarEG\");\r					enviaSICC(\"frmMain\");					\r							 } \r	} else  	{\r		set(\"frmMain.accion\", \"volver\");\r		set(\"frmMain.conectorAction\", \"LPEliminarEG\");\r		enviaSICC(\"frmMain\");\r	}\r}\r\r\rfunction fnErrores()\r{\r	var codigo = get(\"frmMain.errCodigo\");\r	var descripcion = get(\"frmMain.errDescripcion\");\r\r	\r	if (codigo != \"\")\r	{\r						var wnd = fMostrarMensajeError(codigo, descripcion);\r			return true;\r	} \r	return false;\r\r}\r\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmMain" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","LPEliminarEG" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","exito" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","nombrePais" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:4   */


   }

}
