
import org.w3c.dom.*;
import java.util.ArrayList;

public class salidaGenerica_arrayDatos  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","salidaGenerica" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","fInit()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","001" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(2)).setAttribute("nombre","arrayDatos" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r          \r                    function fInit(){\r                              var deb = eval(get(\"frmFormulario.debugWindow\"));\r                              if(deb){\r                                         debugger;\r                              }\r\r                              var cerrar = get(\"frmFormulario.cerrarVentana\")+\"\";\r                              if (cerrar == \"true\" || cerrar == \"1\"){\r                                         cerrar = true;\r                              }else{\r                                         cerrar = false;\r                              }\r                              if(gestionarError()){\r                                         try{\r                                                   if(opener && !opener.closed){\r                                                             opener.focus();\r                                                             var formularioSiccjs = opener.getFormularioSICC();\r                                                             opener.configurarMenuSecundario(formularioSiccjs);\r                                                             var codigo = get(\"frmFormulario.ejecutarError\")+\"\";\r                                                             if(codigo!=null && codigo.split(\" \").join(\"\")!=\"\"){\r                                                                         eval(\"opener.\"+codigo);\r                                                             }\r                                                   }\r                                         }catch(e){\r                                                   ;\r                                         }\r                              }else{\r                                         try{\r                                                   if(opener){\r                                                             if (!opener.closed){\r                                                                         var formularioSiccjs = opener.getFormularioSICC();\r                                                                         opener.configurarMenuSecundario(formularioSiccjs);                                                    \r                                                                         var codigo = get(\"frmFormulario.ejecutar\")+\"\";\r                                                                         if(arrayDatos != null && codigo!=null && codigo.split(\" \").join(\"\")!=\"\"){\r                                                                                  eval(\"opener.\"+ codigo + arrayDatos +\")\");\r                                                                         }else if(codigo!=null && codigo.split(\" \").join(\"\")!=\"\"){\r                                                                                   eval(\"opener.\"+codigo);\r                                                                         }\r                                                                         if(cerrar){\r                                                                                             opener.close();\r                                                                         }\r                                                             }\r                                                   }\r                                         }catch(e){\r                                                   ;\r                                         }\r                              }\r                              window.close();\r                    }\r\r                    function gestionarError(){\r                              if(opener && !opener.closed){\r                                         var sicc_formularioOpener = opener.getFormularioSICC();\r                                         opener.set(sicc_formularioOpener+\".errCodigo\",notNull(get(\"frmFormulario.errCodigo\")));\r                                         opener.set(sicc_formularioOpener+\".errDescripcion\",notNull(get(\"frmFormulario.errDescripcion\")));\r                                         opener.set(sicc_formularioOpener+\".errSeverity\",notNull(get(\"frmFormulario.errSeverity\")));\r                                         try{\r                                                   opener.focus();\r                                         }catch(e){\r                                                   ;\r                                         }\r                                         return opener.fMostrarMensajeError();\r                              }/*esto fue agregado para que ande el caso de uso DescargarGuia de Productos, por JPB*/\r                              else if (get(\"frmFormulario.generarGuiaProducto\")=='true'){\r                                         fMostrarMensajeError();\r                                         set(\"frmFormulario.conectorAction\",\"LPDescargarGP\");\r                                         set(\"frmFormulario.accion\",\"\");\r                                         enviaSICC(\"frmFormulario\");\r                              }/*fin de chanchada*/\r                              return false;\r                    }\r\r                    function notNull(strValor){\r                              if(strValor==null){\r                                         return \"\";\r                              }else{\r                                         return strValor;\r                              }\r                    }\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","cerrarVentana" );
      ((Element)v.get(7)).setAttribute("valor","true" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","ejecutar" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","ejecutarError" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","debugWindow" );
      ((Element)v.get(12)).setAttribute("valor","false" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","generarGuiaProducto" );
      ((Element)v.get(13)).setAttribute("valor","false" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */


   }

}
