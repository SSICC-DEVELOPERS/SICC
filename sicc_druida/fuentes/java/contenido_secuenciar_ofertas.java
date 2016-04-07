
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_secuenciar_ofertas  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0183" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","pedirAceptacion();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r\r  \r    function pedirAceptacion(){\r        var mensaje;\r        var respuesta;\r        if (get('frmContenido.cerrar') == 'secuenciarOfertasAceptar'){          	if (get('frmContenido.errCodigo') != ''){                 fMostrarMensajeError();\r            }\r            if(get('frmContenido.cerrar2')=='consultarOrdenOfertas'){\r                window.returnValue = true;\r                window.close();			                return true;\r            }else{\r                llamarAlmenu();\r            }   \r        }\r        if (get('frmContenido.cerrar') == 'AsignarCodigoVenta'){            if(get('frmContenido.cerrar2')=='consultarOrdenOfertas'){\r          	    window.returnValue = true;\r                window.close();\r                return true;\r	          }else{\r          	    llamarAlmenu();\r\r            }\r        }\r        if  ((get('frmContenido.errCodigo')) == '50006'){             mensaje = get('frmContenido.errDescripcion');\r            respuesta = prompt (mensaje,\"\");\r            if ((respuesta != '') & (respuesta != null)){\r                if (get('frmContenido.origen') == '' ){\r                    set('frmContenido.accion','secuenciarOfertasAceptar');\r                    enviaSICC('frmContenido');\r                }else{\r                    window.returnValue = 1;\r                    window.close();\r                    return true;\r                }\r            }else{\r                if((get('frmContenido.origen')) == 'consultarOrdenOfertas'){\r                    window.close();\r                    return true;\r                }else{\r                    llamarAlmenu();\r                }\r          	}\r        }else{\r            if((get('frmContenido.errCodigo')) == '50007'){           	              	        if (get('frmContenido.origen') == '' ){	\r                        set('frmContenido.accion','secuenciarOfertasAceptar');\r                        set('frmContenido.cerrar','secuenciarOfertasAceptar2');\r                        enviaSICC('frmContenido');\r                		}else {\r                        window.returnValue = 1;\r                        window.close();\r                        return true;\r                    }\r                                                                            }else{	\r                fMostrarMensajeError();\r                set('frmContenido.conectorAction','LPSeleccionarMF');\r                enviaSICC('frmContenido');\r            }\r        }\r    }\r\r    function llamarAlmenu(){\r        var formulario = 'frmContenido';\r        set(formulario+\".conectorAction\",\"LPSeleccionarMF\");\r        set(formulario+\".accion\",\"ElegirMatriz\");\r        enviaSICC(formulario);\r    }\r\r   \r \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","cerrar" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","cerrar2" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","LPSecuenciarOfertas" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","ofertasOrdenadas" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","origen" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(13)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(13)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(13)).setAttribute("borde","0" );
      ((Element)v.get(13)).setAttribute("imagenf","" );
      ((Element)v.get(13)).setAttribute("repeat","" );
      ((Element)v.get(13)).setAttribute("padding","" );
      ((Element)v.get(13)).setAttribute("visibilidad","" );
      ((Element)v.get(13)).setAttribute("contravsb","" );
      ((Element)v.get(13)).setAttribute("x","0" );
      ((Element)v.get(13)).setAttribute("y","0" );
      ((Element)v.get(13)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:4   */


   }

}
