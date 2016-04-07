
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_errores_eliminarMF  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_facturacion_copiar" );
      ((Element)v.get(0)).setAttribute("cod","0153" );
      ((Element)v.get(0)).setAttribute("titulo","Copiar Matriz de Facturación" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Copiar Matriz de Facturación" );
      ((Element)v.get(0)).setAttribute("onload","carga();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r  function carga(){\r	var retorno;\r    var flag1;\r	var flag2;\r    var parametro=get(\"frmFormulario.hidParametro\");\r    switch (parametro) {\r      case \"S\": \r                 retorno = GestionarMensaje('1026', null, null, null);\r\r                 if (retorno){\r                   alert(\"entro al if 1 \" + retorno);\r                   flag1= true;\r                     \r                   retorno = GestionarMensaje('1027', null, null, null); \r                   if (retorno){\r                     alert(\"entro al if 2 \" + retorno);\r                     flag2=true;\r                     set(\"frmFormulario.conectorAction\",\"LPEliminarMF\"); \r                     set(\"frmFormulario.flag_1\",flag1); \r                     set(\"frmFormulario.flag_2\",flag2); \r                     set(\"frmFormulario.accion\",\"MatrizYOfertas\"); \r                     set(\"frmFormulario.conexion\",\"true\"); \r                     enviaSICC (\"frmFormulario\");\r                     \r		             \r                    \r                   }\r		           else{\r                     set(\"frmFormulario.conectorAction\",\"LPEliminarMF\"); \r                     set(\"frmFormulario.flag_1\",flag1); \r                     set(\"frmFormulario.flag_2\",flag2); \r                     set(\"frmFormulario.accion\",\"Matriz\"); \r                     set(\"frmFormulario.conexion\",\"true\"); \r                     enviaSICC (\"frmFormulario\");\r                    \r				   }\r\r                 }\r                 else{\r				   alert(\"Eliminar MF  no exitoso\");\r				   \r	             }\r				 break;\r	case \"E\":\r	             retorno = GestionarMensaje('1028', null, null, null); \r	             break;\r      \r    }\r	\r  }\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","hidParametro" );
      ((Element)v.get(7)).setAttribute("valor","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidSeleccion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","flag_1" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","flag_2" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conexion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:5   */


   }

}
