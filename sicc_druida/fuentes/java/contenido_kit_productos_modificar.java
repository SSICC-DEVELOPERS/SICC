
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_kit_productos_modificar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_kit_productos_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0345" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Kits de Productos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Kits de Productos" );
      ((Element)v.get(0)).setAttribute("onload","Init()" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r	function onLoadPag2()   {\r	\r		DrdEnsanchaConMargenDcho('listado1',12);\r		eval (ON_RSZ);  \r	\r	}\r  function Init()   {\r     \r    DrdEnsanchaConMargenDcho('listado1',12);\r \r     document.all[\"Cplistado1\"].style.visibility='';\r     document.all[\"CpLin1listado1\"].style.visibility='';\r     document.all[\"CpLin2listado1\"].style.visibility='';\r     document.all[\"CpLin3listado1\"].style.visibility='';\r     document.all[\"CpLin4listado1\"].style.visibility='';\r     document.all[\"ava1Div\"].style.visibility='';\r     document.all[\"ret1Div\"].style.visibility='';\r     document.all[\"separa1Div\"].style.visibility='';\r     document.all[\"ModificarDiv\"].style.visibility='hidden';\r     document.all[\"DetalleDiv\"].style.visibility='';\r\r    eval (ON_RSZ);  \r      \r    document.all[\"Cplistado1\"].style.visibility='hidden'; \r    document.all[\"CpLin1listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin2listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin3listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin4listado1\"].style.visibility='hidden'; \r    document.all[\"primera1Div\"].style.visibility='hidden'; \r    document.all[\"ret1Div\"].style.visibility='hidden'; \r    document.all[\"ava1Div\"].style.visibility='hidden';\r	document.all[\"separa1Div\"].style.visibility='hidden';\r    document.all[\"ModificarDiv\"].style.visibility='hidden';\r    document.all[\"DetalleDiv\"].style.visibility='hidden';\r        \r    configurarMenuSecundario(\"frmKitProductos\");\r    focaliza(\"frmKitProductos.txtCodigoSap\");\r\r    if((get('frmKitProductos.casoDeUso')=='vuelveModificar')||(get('frmKitProductos.casoDeUso')=='vuelveEliminar')){\r	    \r		   set('frmKitProductos.txtCodigoSap',get('frmKitProductos.hCodigoSap'));\r		   set('frmKitProductos.txtCodigoAntiguo',get('frmKitProductos.hCodigoAntiguo'));\r		   set('frmKitProductos.txtDescripcionCorta',get('frmKitProductos.hDescripcionCorta'));	\r       set('frmKitProductos.txtDescripcionSap',get('frmKitProductos.hDescripcionSAP'));	\r         \r		   if( get('frmKitProductos.casoDeUso')=='vuelveEliminar' ) {\r			   set('frmKitProductos.casoDeUso','eliminar');\r			   btnProxy(4, '1');\r		   }else \r         if( get('frmKitProductos.casoDeUso')=='vuelveModificar' ){\r			     set('frmKitProductos.casoDeUso','modificar');\r		     }\r	 }\r	 listado1.maxSel = 1;\r   }\r\r\rfunction deselectBugLISTAEDITABLE(list){\r   for(var x = 0; x < list.datos.length; x++)\r        list.deselecciona (x); \r}\r   \rfunction buscar(){	\r    	deselectBugLISTAEDITABLE(listado1);\r\r    configurarPaginado(mipgndo,\"MAEBuscarKit\",\"ConectorBusquedaKits\",\"es.indra.sicc.dtos.mae.DTOBusquedaKit\", [[\"codSAP\",get(\"frmKitProductos.txtCodigoSap\")],[\"codAntiguo\",get(\"frmKitProductos.txtCodigoAntiguo\")],[\"descCorta\",get(\"frmKitProductos.txtDescripcionCorta\")],[\"descSAP\",get(\"frmKitProductos.txtDescripcionSAP\")]]);\r\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r\r    document.all[\"Cplistado1\"].style.visibility=''; \r    document.all[\"CpLin1listado1\"].style.visibility=''; \r    document.all[\"CpLin2listado1\"].style.visibility=''; \r    document.all[\"CpLin3listado1\"].style.visibility=''; \r    document.all[\"CpLin4listado1\"].style.visibility=''; \r\r/*    set('frmKitProductos.conectorAction','LPBusquedaKit');\r		set(\"frmKitProductos.accion\", \"buscar\");\r		enviaSICC('frmKitProductos');*/\r     \r     if(get('frmKitProductos.casoDeUso')=='modificar') {\r		    document.all[\"DetalleDiv\"].style.visibility='hidden';	\r		    document.all[\"ModificarDiv\"].style.visibility='';\r		 }else {\r	 	    document.all[\"DetalleDiv\"].style.visibility='';	\r	 	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r     }\r   }  \r\r  function fLimpiar(){\r   \r     set(\"frmKitProductos.txtCodigoSap\", \"\");\r     set(\"frmKitProductos.txtCodigoAntiguo\", \"\");\r     set(\"frmKitProductos.txtDescripcionCorta\", \"\");\r     set(\"frmKitProductos.txtDescripcionSAP\", \"\");\r     focaliza(\"frmKitProductos.txtCodigoSap\");\r  }\r\r\r\rfunction modificar(){\r   if (listado1.numSelecc()== 1){		    \r        var arrAux = new Array();\r        arrAux = listado1.codSeleccionados();\r        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r        var obj = new Object();\r        obj.oid = listado1.datos[posicion][0];\r        obj.casoDeUso=\"Modificar\";\r        obj.accion = \"\";\r        var dlg = mostrarModalSICC('LPModificarKit','',obj,800,700);		\r		if(dlg == \"update\") {\r		    			buscar(); \r		}\r   }else{\r        GestionarMensaje('50');\r   }   	\r}\r\rfunction verDetalle(){   \r   if((get('frmKitProductos.casoDeUso').toString()==\"consultar\")){\r	    if (listado1.numSelecc()== 1){		\r		     var arrAux = new Array();\r		     arrAux = listado1.codSeleccionados();\r		     var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r		     var obj = new Object();\r             		     obj.oid=listado1.datos[posicion][0];           \r		     obj.casoDeUso = \"Consultar\";\r		     mostrarModalSICC('LPModificarKit','',obj,800,700);			 			\r  	    }else{\r		     GestionarMensaje('4');\r	    }\r   }  \r}\r\r\rfunction checkTable(){\r   if(document.all[\"Cplistado1\"].style.visibility == 'hidden') {\r     focalizaBotonHTML('botonContenido','btnBuscar');\r   } else {\r     if(get('frmKitProductos.casoDeUso').toString() == \"consultar\")     \r	   focalizaBotonHTML('botonContenido','Detalle');\r	 else\r	   focalizaBotonHTML('botonContenido','Modificar');\r   }\r}\r\rfunction checkTable2(){\r   if(document.all[\"Cplistado1\"].style.visibility == 'hidden') {\r     _foc('txtCodigoSap');\r   } else {\r     if(get('frmKitProductos.casoDeUso').toString() == \"consultar\")     \r	   focalizaBotonHTML('botonContenido','Detalle');\r	 else\r	   focalizaBotonHTML('botonContenido','Modificar');\r   }\r}\r/*-------------------------------------------------------------------------------------------------------*/\rfunction ocultaCapas(){\r   DrdEnsanchaConMargenDcho('listado1',12);\r \r    \r    document.all[\"Cplistado1\"].style.visibility='hidden'; \r    document.all[\"CpLin1listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin2listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin3listado1\"].style.visibility='hidden'; \r    document.all[\"CpLin4listado1\"].style.visibility='hidden'; \r    document.all[\"primera1Div\"].style.visibility='hidden'; \r    document.all[\"ret1Div\"].style.visibility='hidden'; \r    document.all[\"ava1Div\"].style.visibility='hidden';\r	document.all[\"separa1Div\"].style.visibility='hidden';\r    document.all[\"ModificarDiv\"].style.visibility='hidden';\r    document.all[\"DetalleDiv\"].style.visibility='hidden';\r }\r\r\rfunction muestraCapas(){\r     document.all[\"Cplistado1\"].style.visibility='';\r     document.all[\"CpLin1listado1\"].style.visibility='';\r     document.all[\"CpLin2listado1\"].style.visibility='';\r     document.all[\"CpLin3listado1\"].style.visibility='';\r     document.all[\"CpLin4listado1\"].style.visibility='';\r     document.all[\"ava1Div\"].style.visibility='';\r     document.all[\"ret1Div\"].style.visibility='';\r     document.all[\"separa1Div\"].style.visibility='';\r\r\r}\r\r\r\r          function muestraLista( ultima, rowset){\r                    var tamano = rowset.length;\r                    if (tamano > 0) {\r\r                    var casoDeUso = get(\"frmKitProductos.casoDeUso\");\r                    if (casoDeUso == 'consultar') {\r\r                              document.all[\"DetalleDiv\"].style.visibility='';         \r                              document.all[\"ModificarDiv\"].style.visibility='hidden';\r\r                    } else {\r                              if (casoDeUso == 'modificar') {\r                                        document.all[\"DetalleDiv\"].style.visibility='hidden';          \r                                         document.all[\"ModificarDiv\"].style.visibility='';\r                              } else if( casoDeUso == 'eliminar' ){\r                                        document.all[\"DetalleDiv\"].style.visibility='hidden';        \r                                         document.all[\"ModificarDiv\"].style.visibility='hidden';\r                              }else {\r                                         document.all[\"DetalleDiv\"].style.visibility='hidden';          \r                                         document.all[\"ModificarDiv\"].style.visibility='hidden';\r                              }\r                    }\r\r                              muestraCapas();\r                              eval (ON_RSZ);\r\r							focaliza(\"frmKitProductos.txtCodigoSap\");\r                              return true;\r                    } else {\r                      ocultaCapas();\r                    \r			        focaliza(\"frmKitProductos.txtCodigoSap\");\r                                            return false;\r                     }\r          }\r\r/*-----------------------------------------------------------------------------------------------------*/\r\r\r\r\r\r\r\r\rfunction obtenerPosicionListaEditable(clave, lista){\r      this.posicion = 0;\r      if (lista.codSeleccionados().length > 0){\r         for(var k=0;k<lista.datos.length;k++) {\r               if (lista.datos[k][0] == clave) {\r                  posicion=k;\r                  break;\r               }\r		}         \r	    return posicion;\r	  }\r   }\r\rfunction _foc(id) { focaliza('frmKitProductos.' + id); }\r\r   \r   \r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmKitProductos" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hOidProducto" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hCodigoSap" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hCodigoAntiguo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hDescripcionCorta" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hDescripcionSap" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","750" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:20   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(32)).setAttribute("class","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","lblCriteriosbusqueda" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("id","legend" );
      ((Element)v.get(33)).setAttribute("cod","0075" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","469" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("colspan","4" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblCodigoSap" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","585" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCodigoAntiguo" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","1059" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:41   */

      /* Empieza nodo:52 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(56)).setAttribute("nombre","txtCodigoSap" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("max","20" );
      ((Element)v.get(56)).setAttribute("tipo","" );
      ((Element)v.get(56)).setAttribute("onchange","" );
      ((Element)v.get(56)).setAttribute("req","N" );
      ((Element)v.get(56)).setAttribute("size","20" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("validacion","" );
      ((Element)v.get(56)).setAttribute("onshtab","checkTable()" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(60)).setAttribute("nombre","txtCodigoAntiguo" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("max","18" );
      ((Element)v.get(60)).setAttribute("tipo","" );
      ((Element)v.get(60)).setAttribute("onchange","" );
      ((Element)v.get(60)).setAttribute("req","N" );
      ((Element)v.get(60)).setAttribute("size","18" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:52   */

      /* Empieza nodo:63 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("colspan","4" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:66 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","469" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblDescripcionSAP" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","1068" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","47" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(84)).setAttribute("nombre","txtDescripcionSAP" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("max","40" );
      ((Element)v.get(84)).setAttribute("tipo","" );
      ((Element)v.get(84)).setAttribute("onchange","" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("size","40" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("validacion","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(88)).setAttribute("nombre","txtDescripcionCorta" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("max","40" );
      ((Element)v.get(88)).setAttribute("tipo","" );
      ((Element)v.get(88)).setAttribute("onchange","" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("size","40" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("validacion","" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:80   */

      /* Empieza nodo:91 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:34   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:94 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:27   */

      /* Empieza nodo:96 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("class","botonera" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("tipo","html" );
      ((Element)v.get(104)).setAttribute("accion","buscar();" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("cod","1" );
      ((Element)v.get(104)).setAttribute("ontab","checkTable2()" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:96   */

      /* Empieza nodo:107 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","756" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","1" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */
      /* Termina nodo:19   */

      /* Empieza nodo:114 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(114)).setAttribute("nombre","listado1" );
      ((Element)v.get(114)).setAttribute("ancho","472" );
      ((Element)v.get(114)).setAttribute("alto","317" );
      ((Element)v.get(114)).setAttribute("x","12" );
      ((Element)v.get(114)).setAttribute("y","164" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(114)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(115)).setAttribute("precarga","S" );
      ((Element)v.get(115)).setAttribute("conROver","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(116)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(116)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(116)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(116)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(117)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(117)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(118)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(118)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:115   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(120)).setAttribute("borde","1" );
      ((Element)v.get(120)).setAttribute("horizDatos","1" );
      ((Element)v.get(120)).setAttribute("horizCabecera","1" );
      ((Element)v.get(120)).setAttribute("vertical","1" );
      ((Element)v.get(120)).setAttribute("horizTitulo","1" );
      ((Element)v.get(120)).setAttribute("horizBase","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(121)).setAttribute("borde","#999999" );
      ((Element)v.get(121)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(121)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(121)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(121)).setAttribute("horizBase","#999999" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(122)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(122)).setAttribute("alto","22" );
      ((Element)v.get(122)).setAttribute("imgFondo","" );
      ((Element)v.get(122)).setAttribute("cod","00135" );
      ((Element)v.get(122)).setAttribute("ID","datosTitle" );
      ((Element)v.get(114)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(123)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(123)).setAttribute("alto","22" );
      ((Element)v.get(123)).setAttribute("imgFondo","" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(124)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(124)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(124)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(124)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(124)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(124)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","10" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","20" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","10" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","20" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:124   */

      /* Empieza nodo:129 / Elemento padre: 114   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(129)).setAttribute("alto","20" );
      ((Element)v.get(129)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(129)).setAttribute("imgFondo","" );
      ((Element)v.get(129)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(114)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("cod","585" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
      ((Element)v.get(131)).setAttribute("cod","1059" );
      ((Element)v.get(129)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("colFondo","" );
      ((Element)v.get(132)).setAttribute("ID","EstCab" );
      ((Element)v.get(132)).setAttribute("cod","1068" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 129   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","47" );
      ((Element)v.get(129)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 114   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(134)).setAttribute("alto","22" );
      ((Element)v.get(134)).setAttribute("accion","" );
      ((Element)v.get(134)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(134)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(134)).setAttribute("maxSel","1" );
      ((Element)v.get(134)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(134)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(134)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(134)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(114)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat2" );
      ((Element)v.get(134)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat" );
      ((Element)v.get(134)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat2" );
      ((Element)v.get(134)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:134   */

      /* Empieza nodo:139 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 114   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(140)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(140)).setAttribute("ancho","539" );
      ((Element)v.get(140)).setAttribute("sep","$" );
      ((Element)v.get(140)).setAttribute("x","32" );
      ((Element)v.get(140)).setAttribute("class","botonera" );
      ((Element)v.get(140)).setAttribute("y","458" );
      ((Element)v.get(140)).setAttribute("control","|" );
      ((Element)v.get(140)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(140)).setAttribute("rowset","" );
      ((Element)v.get(140)).setAttribute("cargainicial","N" );
      ((Element)v.get(140)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(114)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","ret1" );
      ((Element)v.get(141)).setAttribute("x","37" );
      ((Element)v.get(141)).setAttribute("y","462" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("img","retroceder_on" );
      ((Element)v.get(141)).setAttribute("tipo","0" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("alt","" );
      ((Element)v.get(141)).setAttribute("codigo","" );
      ((Element)v.get(141)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","ava1" );
      ((Element)v.get(142)).setAttribute("x","52" );
      ((Element)v.get(142)).setAttribute("y","462" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","avanzar_on" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:140   */
      /* Termina nodo:114   */

      /* Empieza nodo:143 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","primera1" );
      ((Element)v.get(143)).setAttribute("x","20" );
      ((Element)v.get(143)).setAttribute("y","462" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","primera_on" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(143)).setAttribute("tipo","-2" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("codigo","" );
      ((Element)v.get(143)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","separa1" );
      ((Element)v.get(144)).setAttribute("x","59" );
      ((Element)v.get(144)).setAttribute("y","458" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","separa_base" );
      ((Element)v.get(144)).setAttribute("tipo","0" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("codigo","" );
      ((Element)v.get(144)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","Modificar" );
      ((Element)v.get(145)).setAttribute("x","80" );
      ((Element)v.get(145)).setAttribute("y","459" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","" );
      ((Element)v.get(145)).setAttribute("tipo","html" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("cod","2" );
      ((Element)v.get(145)).setAttribute("accion","modificar();" );
      ((Element)v.get(145)).setAttribute("ontab","_foc('txtCodigoSap')" );
      ((Element)v.get(145)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(6)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","Detalle" );
      ((Element)v.get(146)).setAttribute("x","80" );
      ((Element)v.get(146)).setAttribute("y","459" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("img","" );
      ((Element)v.get(146)).setAttribute("tipo","html" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("alt","" );
      ((Element)v.get(146)).setAttribute("cod","3" );
      ((Element)v.get(146)).setAttribute("accion","verDetalle();" );
      ((Element)v.get(146)).setAttribute("ontab","_foc('txtCodigoSap')" );
      ((Element)v.get(146)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(6)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(147)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(147)).setAttribute("alto","18" );
      ((Element)v.get(147)).setAttribute("ancho","100" );
      ((Element)v.get(147)).setAttribute("colorf","" );
      ((Element)v.get(147)).setAttribute("borde","0" );
      ((Element)v.get(147)).setAttribute("imagenf","" );
      ((Element)v.get(147)).setAttribute("repeat","" );
      ((Element)v.get(147)).setAttribute("padding","" );
      ((Element)v.get(147)).setAttribute("visibilidad","visible" );
      ((Element)v.get(147)).setAttribute("contravsb","" );
      ((Element)v.get(147)).setAttribute("x","0" );
      ((Element)v.get(147)).setAttribute("y","481" );
      ((Element)v.get(147)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:6   */


   }

}
