
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_tipo_solicitud_proceso_buscar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_tipo_solicitud_proceso_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0623" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar tipo de solicitud por proceso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r     \rvar varNoLimpiarSICC = true;\r  function cbTipoPosicionOnChange(){\r		if(get('frmModificarB.cbTipoPosicion')!=''){\r			accion('frmModificarB.cbSubtipoPosicion','.disabled=false');\r			recargaCombo('frmModificarB.cbSubtipoPosicion', 'PEDconsultaSubtiposTipo', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmModificarB.cbTipoPosicion')));\r		}else{\r		   set_combo('frmModificarB.cbSubtipoPosicion', ['','']);\r		   accion('frmModificarB.cbSubtipoPosicion','.disabled=true');\r		} \r  }\r\r   function fBorrar(){\r		var seleccion = mipgndo.lista.codSeleccionados();\r		if( seleccion != '' ){\r			eliminarFilas(seleccion, 'PEDeliminaTipoSolicitudProceso', mipgndo);\r            focaliza('frmModificarB.cbCodOperacion');\r		}else{\r			GestionarMensaje('4', null, null, null);\r		    focaliza('frmModificarB.cbCodOperacion');\r		}\r	}\r\r\r  function onClickModificar(){\r		var valorSeteado = mipgndo.lista.codSeleccionados();\r		set('frmModificarB.accion', 'modificar');\r\r		if( valorSeteado != '' ){\r			var obj = new Object();\r			obj.seleccion = valorSeteado;\r			obj.accion = 'modificar';\r\r			var winModal = mostrarModalSICC('LPMantieneTiposSolicitudProceso', 'modificar', obj, null, null);\r            if (winModal != null && winModal == true){\r              onClickBuscar();\r\r			} \r\r		}else{\r			GestionarMensaje('4', null, null, null);\r		    focaliza('frmModificarB.cbCodOperacion');\r		}\r	}\r  \r\r  function makeParameter(nombre, oid){\r              var array = new Array();\r              var i=0;\r              array[i] = new Array('oidPais','1');\r              i++;\r              array[i] = new Array('oidIdioma','1');\r              i++;\r              array[i] = new Array(nombre,oid);\r              return array;\r          } \r\r     function ocultarLista(){\r\r\r		document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r	    document.all[\"DetalleDiv\"].style.visibility='hidden';\r	    set('frmModificarB.flag','false')\r    }\r\r	function onLoadPag(){\r       if( get('frmModificarB.accion') == 'muestraBorrado' ){\r			mipgndo.lista.maxSel = -1;\r		}else{\r    			mipgndo.lista.maxSel = 1;\r		}\r		accion('frmModificarB.cbSubtipoPosicion','.disabled=true');\r		focaliza('frmModificarB.cbCodOperacion');\r        configurarMenuSecundario('frmModificarB');\r        ocultarLista();\r        cargaCombosIndicadores();\r        fMostrarMensajeError();\r	 }\r\r    function muestraLista(ultima, rowset, error ){\r		var tamano = rowset.length;\r		if (tamano > 0) {\r			mostrarLista();\r			if(get('frmModificarB.accion') == 'muestraBorrado'){\r\r				btnProxy(4, 1);\r			}else{\r\r				btnProxy(4, 0);\r			}\r			return true;\r		} else {\r\r			ocultarLista();\r			btnProxy(4, 0);\r			focaliza('frmModificarB.cbCodOperacion');\r			return false;\r		}\r	}\r\r	function mostrarLista(){\r		DrdEnsanchaConMargenDcho('listado1',12);\r	    \r	    document.all[\"Cplistado1\"].style.visibility='visible';\r	    document.all[\"CpLin1listado1\"].style.visibility='visible';\r	    document.all[\"CpLin2listado1\"].style.visibility='visible';\r	    document.all[\"CpLin3listado1\"].style.visibility='visible';\r	    document.all[\"CpLin4listado1\"].style.visibility='visible';\r\r	    document.all[\"primera1Div\"].style.visibility='visible';\r	    document.all[\"ret1Div\"].style.visibility='visible';\r	    document.all[\"ava1Div\"].style.visibility='visible';\r	    document.all[\"separaDiv\"].style.visibility='visible';\r	    document.all[\"ModificarDiv\"].style.visibility='visible';\r	    document.all[\"DetalleDiv\"].style.visibility='hidden';\r     \r		if( get('frmModificarB.accion') == 'modificar' ){\r			document.all[\"ModificarDiv\"].style.visibility='visible';\r			document.all[\"DetalleDiv\"].style.visibility='hidden';\r		}\r		if( get('frmModificarB.accion') == 'muestraConsulta' || get('frmModificarB.accion') == 'muestraBorrado' ){\r			document.all[\"DetalleDiv\"].style.visibility='visible';\r			document.all[\"ModificarDiv\"].style.visibility='hidden';\r		}\r		eval (ON_RSZ);  \r	}	\r\r	function onClickBuscar(){\r		ocultarLista();\r	    if (get('frmModificarB.accion')== 'muestraConsulta'){\r      \r          set('frmModificarB.Modificar', '.estado=false');\r      \r          set('frmModificarB.Detalle', '.estado=true');\r		}\r\r        if (get('frmModificarB.accion')== 'modificar'){\r      \r          set('frmModificarB.Modificar', '.estado=true');\r      \r          set('frmModificarB.Detalle', '.estado=false');\r		}\r\r        if (get('frmModificarB.accion')== 'muestraBorrado'){\r               set('frmModificarB.Modificar', '.estado=true');\r          set('frmModificarB.Detalle', '.estado=false');\r       \r		}\r\r		\r        		configurarPaginado(mipgndo, \"PEDconsultaTipoSolicitudProceso\", \"ConectorBuscarTiposSolicitudProceso\", \r						\"es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso\", armarArray() );\r         \r        set('frmModificarB.flag','true');\r	   focaliza('frmModificarB.cbCodOperacion');\r	}\r\r\r    function onClickDetalle(){\r		var valorSeteado = mipgndo.lista.codSeleccionados();\r         if( valorSeteado != '' ){\r           if( valorSeteado.length == 1 ){\r				var obj = new Object();\r				obj.seleccion = valorSeteado[0];\r				obj.accion = 'muestraDetalle';\r				var winModal = mostrarModalSICC('LPMantieneTiposSolicitudProceso', 'muestraDetalle', obj, null, null);\r           } else {\r                  GestionarMensaje('8',null,null,null);\r           }\r         }else{\r           GestionarMensaje('4', null, null, null);\r        }		\r    }\r\r\r    function ontabBuscar(){\r   \r\r       if (get('frmModificarB.accion')== 'muestraModificacion' || get('frmModificarB.accion')== 'modificar'){\r\r         if (get('frmModificarB.flag') == 'true'){\r\r            focalizaBotonHTML('Modificar','botonContenido');\r	     }else{\r\r            focaliza('frmModificarB.cbCodOperacion');\r		 }\r        }else{\r\r           if (get('frmModificarB.flag') == 'false'){\r\r              focaliza('frmModificarB.cbCodOperacion');\r             \r	       }else{\r              focalizaBotonHTML('Detalle','botonContenido');\r              \r		   }\r     	}\r      }\r\r    function onshtabCodOperacion(){\r       if (get('frmModificarB.accion')== 'muestraModificacion'){\r         if (get('frmModificarB.flag') == 'true'){\r            focalizaBotonHTML('Modificar','botonContenido');\r	     }else{\r            focalizaBotonHTML('btnBuscar','botonContenido');\r		 }\r        }else{\r           if (get('frmModificarB.flag') == 'false'){\r              focalizaBotonHTML('btnBuscar','botonContenido');\r            \r 	       }else{\r              focalizaBotonHTML('Detalle','botonContenido'); \r		   }\r     	}\r      }\r\r\r	\r    function onshtabBuscar(){\r   	  focaliza('frmModificarB.txtCodProducto');\r	}\r\r    function ontabModificar(){\r   	  focaliza('frmModificarB.cbCodOperacion');\r	}\r\r    function onshtabModificar(){\r      focalizaBotonHTML('btnBuscar','botonContenido');\r	}\r\r\r	function onshtabDetalle(){\r      focalizaBotonHTML('btnBuscar','botonContenido');\r	}\r	\r	function ontabDetalle(){\r   	  focaliza('frmModificarB.cbCodOperacion');\r	}\r    \r    function armarArray(){\r		var hh = new Array();\r		var i=0;\r \r		hh[i] = new Array('oidIdioma', get('frmModificarB.idioma'));\r		i++;\r		hh[i] = new Array('oidPais', get('frmModificarB.pais'));\r		i++;\r		 \r		if( get('frmModificarB.cbSubtipoPosicion') != '' ){\r			hh[i] = new Array('subtipoPosicion', get('frmModificarB.cbSubtipoPosicion'));\r			i++\r		}\r		if( get('frmModificarB.cbTipoPosicion') != '' ){\r			hh[i] = new Array('tipoPosicion', get('frmModificarB.cbTipoPosicion'));\r			i++\r		}\r		if( get('frmModificarB.cbCodOperacion') != '' ){\r			hh[i] = new Array('operacion', get('frmModificarB.cbCodOperacion'));\r			i++\r		}\r		if( get('frmModificarB.txtCodProducto') != '' ){\r			hh[i] = new Array('producto', get('frmModificarB.txtCodProducto'));\r			i++\r		}\r		if( get('frmModificarB.cbTipoSolicitud') != '' ){\r			hh[i] = new Array('tipoSolicitud', get('frmModificarB.cbTipoSolicitud'));\r			i++\r		}\r        if( get('frmModificarB.cbProducto') != '' ){\r			hh[i] = new Array('indProducto', convertirBool (get('frmModificarB.cbProducto')));\r			i++\r        \r		}\r\r		if( get('frmModificarB.txtDescripcion') != '' ){\r			hh[i] = new Array('descripcion', get('frmModificarB.txtDescripcion'));\r			i++\r		}\r	\r		return hh;\r	}\r\r    function convertirBool (valor){\r      if (valor =='00')\r       return true;\r	  else \r	    return false;\r    }\r\r\r\r\r    function cargaCombosIndicadores(){\r		var si = GestionarMensaje('84', null, null, null);\r		var no = GestionarMensaje('86', null, null, null);\r		var carga = new Array(3);\r		carga[0] = ['', ''];\r		carga[1] = ['01', no];\r		carga[2] = ['00', si];\r		set_combo('frmModificarB.cbProducto', carga);\r		\r	}\r\r\r  function fLimpiar(){\r      set('frmModificarB.cbCodOperacion',new Array());\r      set('frmModificarB.txtDescripcion','');  \r      set('frmModificarB.cbTipoSolicitud',new Array(''));\r      set('frmModificarB.cbTipoPosicion',new Array(''));\r      set_combo('frmModificarB.cbSubtipoPosicion', ['','']);\r      accion('frmModificarB.cbSubtipoPosicion','.disabled=true');			\r      set('frmModificarB.txtCodProducto','');\r      set('frmModificarB.cbProducto',new Array(''));\r      focaliza('frmModificarB.cbCodOperacion' );\r  }\r\r  \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","ConstantesJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCodOperacion" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","2171" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","9" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoSolicitud" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","415" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoPosicion" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","1426" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbSubtipoPosicion" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","2175" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","337" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbProducto" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","337" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:7   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","frmModificarB" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","seleccion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","pais" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidSeleccionado" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidCodOperacion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidTipoSubposicion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidTipoPosicion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidTxtProducto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidTipoSolicitud" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidChkProducto" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidVarOid" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidTxtDescripcion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","flag" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(34)).setAttribute("nombre","capa" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","750" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:43 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(48)).setAttribute("class","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("cod","0075" );
      ((Element)v.get(49)).setAttribute("id","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","619" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","left" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("colspan","4" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblCodOperacion" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","2171" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","9" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","415" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:57   */

      /* Empieza nodo:72 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbCodOperacion" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(76)).setAttribute("onshtab","onshtabCodOperacion();" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(81)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("max","40" );
      ((Element)v.get(81)).setAttribute("tipo","" );
      ((Element)v.get(81)).setAttribute("onchange","" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(81)).setAttribute("size","40" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("validacion","" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","cbTipoSolicitud" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:72   */

      /* Empieza nodo:89 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("colspan","4" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:92 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","619" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblTipoPosicion" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","1426" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblSubtipoPosicion" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","2175" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:95   */

      /* Empieza nodo:106 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("nombre","cbTipoPosicion" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("req","N" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(110)).setAttribute("onchange","cbTipoPosicionOnChange()" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(115)).setAttribute("nombre","cbSubtipoPosicion" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("size","1" );
      ((Element)v.get(115)).setAttribute("multiple","N" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(115)).setAttribute("valorinicial","" );
      ((Element)v.get(115)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:106   */

      /* Empieza nodo:119 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("colspan","4" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:122 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","619" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblProducto" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","574" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","337" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:125   */

      /* Empieza nodo:136 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(140)).setAttribute("nombre","cbProducto" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("size","1" );
      ((Element)v.get(140)).setAttribute("multiple","N" );
      ((Element)v.get(140)).setAttribute("req","N" );
      ((Element)v.get(140)).setAttribute("valorinicial","" );
      ((Element)v.get(140)).setAttribute("textoinicial","" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(145)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("max","20" );
      ((Element)v.get(145)).setAttribute("tipo","" );
      ((Element)v.get(145)).setAttribute("onchange","" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(145)).setAttribute("size","27" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("validacion","" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:136   */

      /* Empieza nodo:148 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","4" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:50   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:151 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:43   */

      /* Empieza nodo:153 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("class","botonera" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","btnBuscar" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("tipo","html" );
      ((Element)v.get(161)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("cod","1" );
      ((Element)v.get(161)).setAttribute("ontab","ontabBuscar();" );
      ((Element)v.get(161)).setAttribute("onshtab","onshtabBuscar();" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:162 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:153   */

      /* Empieza nodo:164 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(166)).setAttribute("height","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","756" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","1" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:164   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:171 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(171)).setAttribute("nombre","listado1" );
      ((Element)v.get(171)).setAttribute("ancho","622" );
      ((Element)v.get(171)).setAttribute("alto","317" );
      ((Element)v.get(171)).setAttribute("x","12" );
      ((Element)v.get(171)).setAttribute("y","203" );
      ((Element)v.get(171)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(171)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(172)).setAttribute("precarga","S" );
      ((Element)v.get(172)).setAttribute("conROver","S" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(173)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(173)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(173)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(173)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(174)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(174)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(174)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(174)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(175)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(175)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:172   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(177)).setAttribute("borde","1" );
      ((Element)v.get(177)).setAttribute("horizDatos","1" );
      ((Element)v.get(177)).setAttribute("horizCabecera","1" );
      ((Element)v.get(177)).setAttribute("vertical","1" );
      ((Element)v.get(177)).setAttribute("horizTitulo","1" );
      ((Element)v.get(177)).setAttribute("horizBase","1" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(178)).setAttribute("borde","#999999" );
      ((Element)v.get(178)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(178)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(178)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(178)).setAttribute("horizBase","#999999" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 171   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(179)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(179)).setAttribute("alto","22" );
      ((Element)v.get(179)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).setAttribute("cod","00135" );
      ((Element)v.get(179)).setAttribute("ID","datosTitle" );
      ((Element)v.get(171)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(180)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(180)).setAttribute("alto","22" );
      ((Element)v.get(180)).setAttribute("imgFondo","" );
      ((Element)v.get(171)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 171   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(181)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(181)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(181)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(181)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(181)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(181)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(171)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","100" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","100" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","100" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","100" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","100" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:181   */

      /* Empieza nodo:189 / Elemento padre: 171   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(189)).setAttribute("alto","20" );
      ((Element)v.get(189)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(189)).setAttribute("imgFondo","" );
      ((Element)v.get(189)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(171)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","2171" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","9" );
      ((Element)v.get(189)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","415" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","1426" );
      ((Element)v.get(189)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","2175" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","574" );
      ((Element)v.get(189)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(196)).setAttribute("colFondo","" );
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","337" );
      ((Element)v.get(189)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:189   */

      /* Empieza nodo:197 / Elemento padre: 171   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(197)).setAttribute("alto","22" );
      ((Element)v.get(197)).setAttribute("accion","" );
      ((Element)v.get(197)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(197)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(197)).setAttribute("maxSel","-1" );
      ((Element)v.get(197)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(197)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(197)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(197)).setAttribute("onLoad","" );
      ((Element)v.get(197)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(171)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("tipo","texto" );
      ((Element)v.get(201)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("tipo","texto" );
      ((Element)v.get(202)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("tipo","texto" );
      ((Element)v.get(203)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("tipo","texto" );
      ((Element)v.get(204)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:197   */

      /* Empieza nodo:205 / Elemento padre: 171   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 171   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(206)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(206)).setAttribute("ancho","622" );
      ((Element)v.get(206)).setAttribute("sep","$" );
      ((Element)v.get(206)).setAttribute("x","12" );
      ((Element)v.get(206)).setAttribute("class","botonera" );
      ((Element)v.get(206)).setAttribute("y","497" );
      ((Element)v.get(206)).setAttribute("control","|" );
      ((Element)v.get(206)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(206)).setAttribute("rowset","" );
      ((Element)v.get(206)).setAttribute("cargainicial","N" );
      ((Element)v.get(206)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(171)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","ret1" );
      ((Element)v.get(207)).setAttribute("x","37" );
      ((Element)v.get(207)).setAttribute("y","501" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("img","retroceder_on" );
      ((Element)v.get(207)).setAttribute("tipo","0" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("alt","" );
      ((Element)v.get(207)).setAttribute("codigo","" );
      ((Element)v.get(207)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(208)).setAttribute("nombre","ava1" );
      ((Element)v.get(208)).setAttribute("x","52" );
      ((Element)v.get(208)).setAttribute("y","501" );
      ((Element)v.get(208)).setAttribute("ID","botonContenido" );
      ((Element)v.get(208)).setAttribute("img","avanzar_on" );
      ((Element)v.get(208)).setAttribute("tipo","0" );
      ((Element)v.get(208)).setAttribute("estado","false" );
      ((Element)v.get(208)).setAttribute("alt","" );
      ((Element)v.get(208)).setAttribute("codigo","" );
      ((Element)v.get(208)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(206)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:206   */
      /* Termina nodo:171   */

      /* Empieza nodo:209 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(209)).setAttribute("nombre","primera1" );
      ((Element)v.get(209)).setAttribute("x","20" );
      ((Element)v.get(209)).setAttribute("y","501" );
      ((Element)v.get(209)).setAttribute("ID","botonContenido" );
      ((Element)v.get(209)).setAttribute("img","primera_on" );
      ((Element)v.get(209)).setAttribute("tipo","-2" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(209)).setAttribute("estado","false" );
      ((Element)v.get(209)).setAttribute("alt","" );
      ((Element)v.get(209)).setAttribute("codigo","" );
      ((Element)v.get(209)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(15)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(210)).setAttribute("nombre","separa" );
      ((Element)v.get(210)).setAttribute("x","59" );
      ((Element)v.get(210)).setAttribute("y","497" );
      ((Element)v.get(210)).setAttribute("ID","botonContenido" );
      ((Element)v.get(210)).setAttribute("img","separa_base" );
      ((Element)v.get(210)).setAttribute("tipo","0" );
      ((Element)v.get(210)).setAttribute("estado","false" );
      ((Element)v.get(210)).setAttribute("alt","" );
      ((Element)v.get(210)).setAttribute("codigo","" );
      ((Element)v.get(210)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(211)).setAttribute("nombre","Modificar" );
      ((Element)v.get(211)).setAttribute("x","80" );
      ((Element)v.get(211)).setAttribute("y","498" );
      ((Element)v.get(211)).setAttribute("ID","botonContenido" );
      ((Element)v.get(211)).setAttribute("tipo","html" );
      ((Element)v.get(211)).setAttribute("estado","false" );
      ((Element)v.get(211)).setAttribute("cod","2" );
      ((Element)v.get(211)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(211)).setAttribute("ontab","ontabModificar();" );
      ((Element)v.get(211)).setAttribute("onshtab","onshtabModificar();" );
      ((Element)v.get(15)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","Detalle" );
      ((Element)v.get(212)).setAttribute("x","80" );
      ((Element)v.get(212)).setAttribute("y","498" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("tipo","html" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("cod","3" );
      ((Element)v.get(212)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(212)).setAttribute("ontab","ontabDetalle();" );
      ((Element)v.get(212)).setAttribute("onshtab","onshtabDetalle();" );
      ((Element)v.get(15)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(213)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(213)).setAttribute("alto","12" );
      ((Element)v.get(213)).setAttribute("ancho","50" );
      ((Element)v.get(213)).setAttribute("colorf","" );
      ((Element)v.get(213)).setAttribute("borde","0" );
      ((Element)v.get(213)).setAttribute("imagenf","" );
      ((Element)v.get(213)).setAttribute("repeat","" );
      ((Element)v.get(213)).setAttribute("padding","" );
      ((Element)v.get(213)).setAttribute("visibilidad","visible" );
      ((Element)v.get(213)).setAttribute("contravsb","" );
      ((Element)v.get(213)).setAttribute("x","0" );
      ((Element)v.get(213)).setAttribute("y","520" );
      ((Element)v.get(213)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:15   */


   }

}
