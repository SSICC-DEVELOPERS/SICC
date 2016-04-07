
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_flete_buscar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_flete_buscar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Buscar flete" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Buscar flete" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ConstantesJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r     \r      \rfunction onLoadPag(){\r		configurarMenuSecundario(\"frmBuscar\");\r\r	    DrdEnsanchaConMargenDcho('listado1',12);\r		ocultarLista();	   \r	    eval (ON_RSZ);  \r\r		var zonaUbigeo = get(\"frmBuscar.hVisibleZona\");		\r		var acc =  get(\"frmBuscar.accion\");\r\r		if (acc ==\"muestraModificacion\"){\r			btnProxy(1,'0');\r			btnProxy(2,'0');\r			btnProxy(3,'1');\r		}\r		if (acc ==\"muestraBorrado\"){\r			btnProxy(4,'0');			\r		}\r\r		if (zonaUbigeo == \"S\"){	\r			accion(\"frmBuscar.cbZona\",\".disabled=false\");\r			accion(\"frmBuscar.txtUbigeo\",\".disabled=true\");\r\r		}else{\r				accion(\"frmBuscar.cbZona\",\".disabled=true\");\r				accion(\"frmBuscar.txtUbigeo\",\".disabled=false\");		\r		}\r\r		focaliza(\"frmBuscar.cbMarca\");\r		accion(\"frmBuscar.cbZona\",\".disabled=true\");\r		if (get(\"frmBuscar.errDescripcion\")!='') {\r		     var wnd = fMostrarMensajeError(get(\"frmBuscar.errCodigo\"), get(\"frmBuscar.errDescripcion\"));\r			 ocultarLista();\r	    }		\r\r}\r\r\rfunction fBorrar(){\r	 if (listado1.numSelecc()== 0) {\r       GestionarMensaje('1021',null,null,null);\r       return false;\r     } else{\r			eliminarFilas(listado1.codSeleccionados(),\"PEDeliminaFlete\", mipgndo);\r			}\r}\r\rfunction mostrarLista(){\r\r	var acc =  get(\"frmBuscar.accion\");\r	\r	document.all[\"Cplistado1\"].style.visibility='';\r	document.all[\"CpLin1listado1\"].style.visibility='';\r	document.all[\"CpLin2listado1\"].style.visibility='';\r	document.all[\"CpLin3listado1\"].style.visibility='';\r	document.all[\"CpLin4listado1\"].style.visibility='';\r	document.all[\"primera1Div\"].style.visibility='';\r	document.all[\"ret1Div\"].style.visibility='';\r	document.all[\"ava1Div\"].style.visibility='';\r	document.all[\"separaDiv\"].style.visibility='';\r\r	if (acc == 'muestraBorrado') {\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r	    document.all[\"DetalleDiv\"].style.visibility='hidden';\r	}\r	\r	if (acc == 'muestraConsulta') {\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r	    document.all[\"DetalleDiv\"].style.visibility='';\r	}\r\r	if (acc == 'muestraBorrado') {\r		document.all[\"ModificarDiv\"].style.visibility='hidden';\r	    document.all[\"DetalleDiv\"].style.visibility='';\r	}\r\r	if (acc == 'muestraModificacion') {\r		document.all[\"ModificarDiv\"].style.visibility='';\r	    document.all[\"DetalleDiv\"].style.visibility='hidden';\r	}\r}\r\r\r\rfunction muestraLista(ultima, rowset) {\r\r         var tamanio = rowset.length;\r\r         if (tamanio > 0) {\r			mostrarLista();\r			if(get('frmBuscar.casoDeUso') == 'elimina'){\r				btnProxy(4, 1);\r				mipgndo.lista.maxSel = -1;\r			}else{\r				btnProxy(4, 0);\r				mipgndo.lista.maxSel = 1;\r			}\r			return true;\r		 } else {\r			ocultarLista();\r			btnProxy(4, 0);\r			return false;\r		 }\r    }\r\r\r\rfunction ocultarLista(){\r\r		document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r	    document.all[\"DetalleDiv\"].style.visibility='hidden';\r}\r\r\rfunction accionConsultar(){\r	valorSeteado = listado1.codSeleccionados();\r	codigos = listado1.codSeleccionados();\r\r	if( valorSeteado != '' ){ 	\r			if( valorSeteado.length == 1 ){\r\r				var obj = new Object();\r				obj.seleccion = valorSeteado[0];\r				var sel = valorSeteado;\r			\r				var	datoMarca = listado1.extraeDato(codigos,0);\r				var datoCanal = listado1.extraeDato(codigos,1);\r				var datoZona = listado1.extraeDato(codigos,2);\r				var datoDespacho = listado1.extraeDato(codigos,3);\r				var tipoCliente = listado1.extraeDato(codigos,9);\r				var subTipoCliente = listado1.extraeDato(codigos,10);\r				var tipoClasi = listado1.extraeDato(codigos,11);\r				var clasi = listado1.extraeDato(codigos,12);\r				\r				obj.accion = 'detalle';\r				obj.marcaDescr = datoMarca;\r				obj.canalDescr = datoCanal;\r				obj.zonaDescr = datoZona;\r				obj.despachoDescr = datoDespacho;\r				obj.tipoClienteDescr = tipoCliente;\r				obj.subTipoClienteDescr = subTipoCliente;\r				obj.tipoClasiDescr = tipoClasi;\r				obj.clasiDescr = clasi;				\r				\r				var winModal = mostrarModalSICC('LPMantieneFlete', 'detalle', obj, null, null);\r\r			} else {\r						GestionarMensaje('8',null,null,null);\r			 }\r		}		else{\r				GestionarMensaje('4', null, null, null);\r	   }		\r}\rfunction buscar(){\r		ocultarLista();\r		var acc =  get(\"frmBuscar.accion\");\r\r		if (acc ==\"muestraBorrado\"){\r			btnProxy(4,'1');\r		}	\r		var pais = get(\"frmBuscar.hPais\");\r		var idioma = get(\"frmBuscar.hIdioma\");\r		var zona = get(\"frmBuscar.cbZona\");\r				\r		var arr = new Array();\r		\r		arr[arr.length] = new Array(\"oidPais\", pais);\r		arr[arr.length] = new Array(\"oidIdioma\", idioma);\r		arr[arr.length] = new Array(\"ubigeo\", get(\"frmBuscar.txtUbigeo\"));\r		arr[arr.length] = new Array(\"oidMarca\", get(\"frmBuscar.cbMarca\"));\r		arr[arr.length] = new Array(\"oidCanal\", get(\"frmBuscar.cbCanal\"));\r	\r		if (zona == \"0\"){\r			arr[arr.length] = new Array(\"zona\", \"\");\r		}else{\r			arr[arr.length] = new Array(\"zona\", get(\"frmBuscar.cbZona\"));\r		}\r		\r		arr[arr.length] = new Array(\"oidTipoDespacho\", get(\"frmBuscar.cbTipoDespacho\"));\r\r		arr[arr.length] = new Array(\"tamanioPagina\", 10);\r		arr[arr.length] = new Array(\"indicadorSituacion\", 0);\r		configurarPaginado(mipgndo, \"PEDconsultaFlete\", \"ConectorBuscarFlete\", \"es.indra.sicc.dtos.ped.DTOFlete\",arr);\r}\r\r\rfunction MarcaOnChange(){\r	var zonaUbigeo = get(\"frmBuscar.hVisibleZona\");\r	var pais = get(\"frmBuscar.hPais\");\r	var canal = get(\"frmBuscar.cbCanal\");\r	var marca = get(\"frmBuscar.cbMarca\");\r\r	if (zonaUbigeo == \"S\"){\r			accion(\"frmBuscar.cbZona\",\".disabled=false\");\r			accion(\"frmBuscar.txtUbigeo\",\".disabled=true\");\r\r			var arr = new Array();\r			arr[arr.length] = new Array(\"oidPais\", pais+\"\");\r			arr[arr.length] = new Array(\"oidMarca\", get(\"frmBuscar.cbMarca\")+\"\");\r			arr[arr.length] = new Array(\"oidCanal\", get(\"frmBuscar.cbCanal\")+\"\");\r\r\r		    			if((canal !='')){\r			        recargaCombo('frmBuscar.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr, 'setearSubtipo(datos)');\r		    }\r			else{\r					var aCombo = new Array(new Array(\"\",\"\"));\r					set_combo(\"frmBuscar.cbZona\",aCombo,[]);\r			}\r	}\r     else{\r				accion(\"frmBuscar.cbZona\",\".disabled=true\");\r				accion(\"frmBuscar.txtUbigeo\",\".disabled=false\");	\r	}\r}\r\rfunction setearSubtipo(datos){\r 	seteo = cargaArray(datos);\r\r    set_combo('frmBuscar.cbZona',datos, []);				   \r    set('frmBuscar.cbZona', [get('frmBuscar.zona')]); \r    accion('frmBuscar.cbZona', '.disabled=false');\r}\r\rfunction CanalOnChange(){\r var pais = get(\"frmBuscar.hPais\");\r var marca = get(\"frmBuscar.cbMarca\");\r var canal = get(\"frmBuscar.cbCanal\");\r \r var zonaUbigeo = get(\"frmBuscar.hVisibleZona\");\r\r 	if (zonaUbigeo == \"S\"){\r			accion(\"frmBuscar.cbZona\",\".disabled=false\");\r			accion(\"frmBuscar.txtUbigeo\",\".disabled=true\");\r			\r		    var arr = new Array();\r		    arr[arr.length] = new Array(\"oidPais\", pais +\"\");\r		    arr[arr.length] = new Array(\"oidMarca\", get(\"frmBuscar.cbMarca\")+\"\");\r		    arr[arr.length] = new Array(\"oidCanal\", get(\"frmBuscar.cbCanal\")+\"\");\r	   \r			if ((marca != '') && (canal !='')){\r					recargaCombo('frmBuscar.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',arr);\r		   }\r		   else{\r					var aCombo = new Array(new Array(\"\",\"\"));\r					set_combo(\"frmBuscar.cbZona\",aCombo,[]);\r			}\r\r				 \r	}else{\r			accion(\"frmBuscar.cbZona\",\".disabled=true\");\r			accion(\"frmBuscar.txtUbigeo\",\".disabled=false\");\r	}\r\r}\r\rfunction tabCanal(){\r	focaliza(\"frmBuscar.cbCanal\");\r}\r\rfunction tabBtn(){\r	focalizaBotonHTML('botonContenido','btnBuscar');	\r}\r\rfunction cargaArray(datos){\r		var seteo = new Array(datos.length + 1);\r		seteo[0] = ['' , '']\r		for(i = 0; i < datos.length; i++){\r			seteo[i+1] = [ datos[i][0], datos[i][1] ]\r		}\r		return seteo;\r}\r\rfunction focalizaTab(){\r\r	if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r			focaliza(\"frmBuscar.cbMarca\");\r	}else{\r			if(get('frmBuscar.casoDeUso') == 'modifica' ){\r				focalizaBotonHTML_XY('Modificar');\r			}else{\r				focalizaBotonHTML_XY('Detalle');\r			}\r\r		}\r	\r}\r\rfunction focalizaShTab(){  \r		if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r			focalizaBotonHTML('botonContenido','btnBuscar');\r		}else{\r		    if(get('frmBuscar.casoDeUso') == 'modifica' ){\r				focalizaBotonHTML_XY('Modificar');\r			}else{\r				focalizaBotonHTML_XY('Detalle');\r			}\r\r		}\r}\r\r\rfunction onClickModificar(){\r	var codigos = listado1.codSeleccionados();\r	var valorSeteado = mipgndo.lista.codSeleccionados();\r\r	if (listado1.numSelecc()!= 1) {\r		GestionarMensaje('1022',null,null,null);\r		return false;\r	}\r\r	if( valorSeteado != '' ){\r\r				var obj = new Object();\r				obj.seleccion = valorSeteado[0];\r				var sel = valorSeteado;\r				var	datoMarca = listado1.extraeDato(codigos,0);\r				var datoCanal = listado1.extraeDato(codigos,1);\r				var datoZona = listado1.extraeDato(codigos,2);\r				set(\"frmBuscar.OIDZona\",datoZona);\r				var datoDespacho = listado1.extraeDato(codigos,3);\r				var tipoCliente = listado1.extraeDato(codigos,9);\r				var subTipoCliente = listado1.extraeDato(codigos,10);\r				var tipoClasi = listado1.extraeDato(codigos,11);\r				var clasi = listado1.extraeDato(codigos,12);\r\r				var oidMarca = listado1.extraeDato(codigos,14);\r				var oidCanal = listado1.extraeDato(codigos,13);	\r\r				var oidZona = listado1.extraeDato(codigos,19);\r				var oidDesp = listado1.extraeDato(codigos,15);\r				var oidTipoClien = listado1.extraeDato(codigos,16);\r				var oidSubTipoClien = listado1.extraeDato(codigos,17);\r				var oidTipoClas = listado1.extraeDato(codigos,18);\r				var oidClas = listado1.extraeDato(codigos,20);	\r\r				obj.accion = 'modificar';\r				obj.marcaDescr = datoMarca;\r				obj.canalDescr = datoCanal;\r				obj.zonaDescr = datoZona;\r				obj.despachoDescr = datoDespacho;\r				obj.tipoClienteDescr = tipoCliente;\r				obj.subTipoClienteDescr = subTipoCliente;\r				obj.tipoClasiDescr = tipoClasi;\r				obj.clasiDescr = clasi;		\r\r				var retorno = mostrarModalSICC('LPMantieneFlete', 'modificar', obj, null, null);\r				if( retorno != null && retorno == true ){\r					buscar();\r				}\r	}else{\r					GestionarMensaje('4', null, null, null);\r	}\r}\r\r\rfunction fLimpiar(){\r	var zonaUbigeo = get(\"frmBuscar.hVisibleZona\")\r	set(\"frmBuscar.cbMarca\",new Array(''));\r	set(\"frmBuscar.cbCanal\",new Array(''));\r    set_combo(\"frmBuscar.cbZona\",new Array(\"\",\"\"), []);\r	set(\"frmBuscar.txtUbigueo\", \"\");\r	focaliza(\"frmBuscar.cbMarca\");\r}\r\r\r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmBuscar" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","seleccion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","OIDMarca" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","OIDCanal" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","OIDZona" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","OIDUbigeo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","OIDDespacho" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","OIDTipoCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","OIDSubTipoCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","OIDTipoClasificacion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","OIDClasificacion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidLst" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","marca" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","canal" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","zona" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","marcaDescr" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","canalDescr" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","zonaDescr" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","despachoDescr" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","tipoClienteDescr" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","subTipoClienteDescr" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","tipoClasiDescr" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","clasiDescr" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hVisibleZona" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hTxtUbigeo" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(39)).setAttribute("nombre","capa" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCritBusqueda" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("cod","0075" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","622" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","left" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("colspan","4" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","6" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","7" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:62   */

      /* Empieza nodo:73 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(77)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(77)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).setAttribute("size","1" );
      ((Element)v.get(77)).setAttribute("multiple","N" );
      ((Element)v.get(77)).setAttribute("req","N" );
      ((Element)v.get(77)).setAttribute("valorinicial","" );
      ((Element)v.get(77)).setAttribute("textoinicial","" );
      ((Element)v.get(77)).setAttribute("onchange","MarcaOnChange();" );
      ((Element)v.get(77)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:79 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(82)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(82)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).setAttribute("size","1" );
      ((Element)v.get(82)).setAttribute("multiple","N" );
      ((Element)v.get(82)).setAttribute("req","N" );
      ((Element)v.get(82)).setAttribute("valorinicial","" );
      ((Element)v.get(82)).setAttribute("textoinicial","" );
      ((Element)v.get(82)).setAttribute("onchange","CanalOnChange();" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:73   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:86 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","622" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("colspan","4" );
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

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","1000" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:92   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(103)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("size","1" );
      ((Element)v.get(103)).setAttribute("multiple","N" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("valorinicial","" );
      ((Element)v.get(103)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:99   */

      /* Empieza nodo:107 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:110 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","622" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblZona" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","143" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblUbigeo" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosTitle" );
      ((Element)v.get(121)).setAttribute("cod","135" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:113   */

      /* Empieza nodo:124 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(128)).setAttribute("nombre","cbZona" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("size","1" );
      ((Element)v.get(128)).setAttribute("multiple","N" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("valorinicial","0" );
      ((Element)v.get(128)).setAttribute("textoinicial","" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(133)).setAttribute("nombre","txtUbigeo" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("max","60" );
      ((Element)v.get(133)).setAttribute("tipo","" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("req","N" );
      ((Element)v.get(133)).setAttribute("size","60" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:124   */

      /* Empieza nodo:136 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("colspan","4" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:55   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:139 / Elemento padre: 48   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:48   */

      /* Empieza nodo:141 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("table"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(146)).setAttribute("border","0" );
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("cellpadding","0" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("class","botonera" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("tipo","html" );
      ((Element)v.get(149)).setAttribute("accion","buscar();" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("cod","1" );
      ((Element)v.get(149)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:150 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:141   */

      /* Empieza nodo:152 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(154)).setAttribute("height","12" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","756" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("height","1" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:152   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:159 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(159)).setAttribute("nombre","listado1" );
      ((Element)v.get(159)).setAttribute("ancho","625" );
      ((Element)v.get(159)).setAttribute("alto","317" );
      ((Element)v.get(159)).setAttribute("x","12" );
      ((Element)v.get(159)).setAttribute("y","202" );
      ((Element)v.get(159)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(159)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(160)).setAttribute("precarga","S" );
      ((Element)v.get(160)).setAttribute("conROver","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(161)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(161)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(161)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(161)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 160   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(162)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(162)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(162)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(162)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(163)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(163)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:160   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(165)).setAttribute("borde","1" );
      ((Element)v.get(165)).setAttribute("horizDatos","1" );
      ((Element)v.get(165)).setAttribute("horizCabecera","1" );
      ((Element)v.get(165)).setAttribute("vertical","1" );
      ((Element)v.get(165)).setAttribute("horizTitulo","1" );
      ((Element)v.get(165)).setAttribute("horizBase","1" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(166)).setAttribute("borde","#999999" );
      ((Element)v.get(166)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(166)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(166)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(166)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(166)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(166)).setAttribute("horizBase","#999999" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:164   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(167)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(167)).setAttribute("alto","22" );
      ((Element)v.get(167)).setAttribute("imgFondo","" );
      ((Element)v.get(167)).setAttribute("cod","00135" );
      ((Element)v.get(167)).setAttribute("ID","datosTitle" );
      ((Element)v.get(159)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(168)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("alto","22" );
      ((Element)v.get(168)).setAttribute("imgFondo","" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 159   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(169)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(169)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(169)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(169)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(169)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(169)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(159)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","60" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","60" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","130" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","100" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","85" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","85" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","85" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","85" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","100" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","120" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","120" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","120" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","120" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:169   */

      /* Empieza nodo:183 / Elemento padre: 159   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(183)).setAttribute("alto","20" );
      ((Element)v.get(183)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(183)).setAttribute("imgFondo","" );
      ((Element)v.get(183)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(159)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","6" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","7" );
      ((Element)v.get(183)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","2415" );
      ((Element)v.get(183)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","1000" );
      ((Element)v.get(183)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("cod","1414" );
      ((Element)v.get(183)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","1415" );
      ((Element)v.get(183)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","2177" );
      ((Element)v.get(183)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","2178" );
      ((Element)v.get(183)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","1418" );
      ((Element)v.get(183)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","1869" );
      ((Element)v.get(183)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","595" );
      ((Element)v.get(183)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","756" );
      ((Element)v.get(183)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","550" );
      ((Element)v.get(183)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:183   */

      /* Empieza nodo:197 / Elemento padre: 159   */
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
      ((Element)v.get(159)).appendChild((Element)v.get(197));

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

      /* Empieza nodo:205 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("tipo","texto" );
      ((Element)v.get(205)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","texto" );
      ((Element)v.get(208)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:197   */

      /* Empieza nodo:211 / Elemento padre: 159   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(159)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(212)).setAttribute("ID","1" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(213)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(213)).setAttribute("TIPO","STRING" );
      ((Element)v.get(213)).setAttribute("VALOR","COD0" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(214)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(214)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(215)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(216)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(216)).setAttribute("TIPO","STRING" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(216)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(217)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(217)).setAttribute("TIPO","STRING" );
      ((Element)v.get(217)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(218)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(218)).setAttribute("TIPO","STRING" );
      ((Element)v.get(218)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(219)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(219)).setAttribute("TIPO","STRING" );
      ((Element)v.get(219)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(220)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(220)).setAttribute("TIPO","STRING" );
      ((Element)v.get(220)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(221)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(221)).setAttribute("TIPO","STRING" );
      ((Element)v.get(221)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(222)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(222)).setAttribute("TIPO","STRING" );
      ((Element)v.get(222)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(223)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(223)).setAttribute("TIPO","STRING" );
      ((Element)v.get(223)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(224)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(224)).setAttribute("TIPO","STRING" );
      ((Element)v.get(224)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(225)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(225)).setAttribute("TIPO","STRING" );
      ((Element)v.get(225)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 212   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(226)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(226)).setAttribute("TIPO","STRING" );
      ((Element)v.get(226)).setAttribute("VALOR","" );
      ((Element)v.get(212)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:212   */

      /* Empieza nodo:227 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).setAttribute("ID","2" );
      ((Element)v.get(211)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(228)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(228)).setAttribute("TIPO","STRING" );
      ((Element)v.get(228)).setAttribute("VALOR","COD1" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(230)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(230)).setAttribute("TIPO","STRING" );
      ((Element)v.get(230)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(233)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(233)).setAttribute("TIPO","STRING" );
      ((Element)v.get(233)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(234)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(234)).setAttribute("TIPO","STRING" );
      ((Element)v.get(234)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 227   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(236)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(236)).setAttribute("TIPO","STRING" );
      ((Element)v.get(236)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(237)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(237)).setAttribute("TIPO","STRING" );
      ((Element)v.get(237)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(238)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(238)).setAttribute("TIPO","STRING" );
      ((Element)v.get(238)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(239)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(239)).setAttribute("TIPO","STRING" );
      ((Element)v.get(239)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(240)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(240)).setAttribute("TIPO","STRING" );
      ((Element)v.get(240)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(241)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(241)).setAttribute("TIPO","STRING" );
      ((Element)v.get(241)).setAttribute("VALOR","" );
      ((Element)v.get(227)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:227   */

      /* Empieza nodo:242 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(242)).setAttribute("ID","3" );
      ((Element)v.get(211)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(243)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(243)).setAttribute("VALOR","COD2" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(244)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(244)).setAttribute("TIPO","STRING" );
      ((Element)v.get(244)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(245)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(245)).setAttribute("TIPO","STRING" );
      ((Element)v.get(245)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(246)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(246)).setAttribute("TIPO","STRING" );
      ((Element)v.get(246)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(247)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(247)).setAttribute("TIPO","STRING" );
      ((Element)v.get(247)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(248)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(248)).setAttribute("TIPO","STRING" );
      ((Element)v.get(248)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(249)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(249)).setAttribute("TIPO","STRING" );
      ((Element)v.get(249)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(250)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(250)).setAttribute("TIPO","STRING" );
      ((Element)v.get(250)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(251)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(251)).setAttribute("TIPO","STRING" );
      ((Element)v.get(251)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(252)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(252)).setAttribute("TIPO","STRING" );
      ((Element)v.get(252)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(253)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(253)).setAttribute("TIPO","STRING" );
      ((Element)v.get(253)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(254)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(254)).setAttribute("TIPO","STRING" );
      ((Element)v.get(254)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(255)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(255)).setAttribute("TIPO","STRING" );
      ((Element)v.get(255)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 242   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(256)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(256)).setAttribute("TIPO","STRING" );
      ((Element)v.get(256)).setAttribute("VALOR","" );
      ((Element)v.get(242)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:242   */

      /* Empieza nodo:257 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(257)).setAttribute("ID","1" );
      ((Element)v.get(211)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(258)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(258)).setAttribute("TIPO","STRING" );
      ((Element)v.get(258)).setAttribute("VALOR","COD3" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(259)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(259)).setAttribute("TIPO","STRING" );
      ((Element)v.get(259)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(262)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(262)).setAttribute("TIPO","STRING" );
      ((Element)v.get(262)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(263)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(263)).setAttribute("TIPO","STRING" );
      ((Element)v.get(263)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(264)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(264)).setAttribute("TIPO","STRING" );
      ((Element)v.get(264)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(265)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(265)).setAttribute("TIPO","STRING" );
      ((Element)v.get(265)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(266)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(266)).setAttribute("TIPO","STRING" );
      ((Element)v.get(266)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(267)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(267)).setAttribute("TIPO","STRING" );
      ((Element)v.get(267)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(268)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(268)).setAttribute("TIPO","STRING" );
      ((Element)v.get(268)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(269)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(269)).setAttribute("TIPO","STRING" );
      ((Element)v.get(269)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(270)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(270)).setAttribute("TIPO","STRING" );
      ((Element)v.get(270)).setAttribute("VALOR","" );
      ((Element)v.get(257)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 257   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(271)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(271)).setAttribute("TIPO","STRING" );
      ((Element)v.get(271)).setAttribute("VALOR","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(257)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:257   */

      /* Empieza nodo:272 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(272)).setAttribute("ID","2" );
      ((Element)v.get(211)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(273)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(273)).setAttribute("TIPO","STRING" );
      ((Element)v.get(273)).setAttribute("VALOR","COD4" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(274)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(274)).setAttribute("TIPO","STRING" );
      ((Element)v.get(274)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(275)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(275)).setAttribute("TIPO","STRING" );
      ((Element)v.get(275)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(276)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(276)).setAttribute("TIPO","STRING" );
      ((Element)v.get(276)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(277)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(277)).setAttribute("TIPO","STRING" );
      ((Element)v.get(277)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(278)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(278)).setAttribute("TIPO","STRING" );
      ((Element)v.get(278)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(279)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(279)).setAttribute("TIPO","STRING" );
      ((Element)v.get(279)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(280)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(280)).setAttribute("TIPO","STRING" );
      ((Element)v.get(280)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(281)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(281)).setAttribute("TIPO","STRING" );
      ((Element)v.get(281)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(282)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(282)).setAttribute("TIPO","STRING" );
      ((Element)v.get(282)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(283)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(283)).setAttribute("TIPO","STRING" );
      ((Element)v.get(283)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(284)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(284)).setAttribute("TIPO","STRING" );
      ((Element)v.get(284)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(285)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(285)).setAttribute("TIPO","STRING" );
      ((Element)v.get(285)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 272   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(286)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(286)).setAttribute("TIPO","STRING" );
      ((Element)v.get(286)).setAttribute("VALOR","" );
      ((Element)v.get(272)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:272   */

      /* Empieza nodo:287 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(287)).setAttribute("ID","3" );
      ((Element)v.get(211)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(288)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(288)).setAttribute("TIPO","STRING" );
      ((Element)v.get(288)).setAttribute("VALOR","COD5" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(289)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(289)).setAttribute("TIPO","STRING" );
      ((Element)v.get(289)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(290)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(290)).setAttribute("TIPO","STRING" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(290)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(291)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(291)).setAttribute("TIPO","STRING" );
      ((Element)v.get(291)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(292)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(292)).setAttribute("TIPO","STRING" );
      ((Element)v.get(292)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(293)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(293)).setAttribute("TIPO","STRING" );
      ((Element)v.get(293)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(294)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(294)).setAttribute("TIPO","STRING" );
      ((Element)v.get(294)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(295)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(295)).setAttribute("TIPO","STRING" );
      ((Element)v.get(295)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(296)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(296)).setAttribute("TIPO","STRING" );
      ((Element)v.get(296)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(297)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(297)).setAttribute("TIPO","STRING" );
      ((Element)v.get(297)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(298)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(298)).setAttribute("TIPO","STRING" );
      ((Element)v.get(298)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(299)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(299)).setAttribute("TIPO","STRING" );
      ((Element)v.get(299)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(300)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(300)).setAttribute("TIPO","STRING" );
      ((Element)v.get(300)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 287   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(301)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(301)).setAttribute("TIPO","STRING" );
      ((Element)v.get(301)).setAttribute("VALOR","" );
      ((Element)v.get(287)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:287   */

      /* Empieza nodo:302 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(302)).setAttribute("ID","3" );
      ((Element)v.get(211)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(303)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(303)).setAttribute("TIPO","STRING" );
      ((Element)v.get(303)).setAttribute("VALOR","COD6" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(304)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(304)).setAttribute("TIPO","STRING" );
      ((Element)v.get(304)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(305)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(305)).setAttribute("TIPO","STRING" );
      ((Element)v.get(305)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(306)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(306)).setAttribute("TIPO","STRING" );
      ((Element)v.get(306)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(307)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(307)).setAttribute("TIPO","STRING" );
      ((Element)v.get(307)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(308)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(308)).setAttribute("TIPO","STRING" );
      ((Element)v.get(308)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 302   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(309)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(309)).setAttribute("TIPO","STRING" );
      ((Element)v.get(309)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(310)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(310)).setAttribute("TIPO","STRING" );
      ((Element)v.get(310)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(311)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(311)).setAttribute("TIPO","STRING" );
      ((Element)v.get(311)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(312)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(312)).setAttribute("TIPO","STRING" );
      ((Element)v.get(312)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(313)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(313)).setAttribute("TIPO","STRING" );
      ((Element)v.get(313)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(314)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(314)).setAttribute("TIPO","STRING" );
      ((Element)v.get(314)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(315)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(315)).setAttribute("TIPO","STRING" );
      ((Element)v.get(315)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 302   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(316)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(316)).setAttribute("TIPO","STRING" );
      ((Element)v.get(316)).setAttribute("VALOR","" );
      ((Element)v.get(302)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:302   */

      /* Empieza nodo:317 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(317)).setAttribute("ID","1" );
      ((Element)v.get(211)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(318)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(318)).setAttribute("TIPO","STRING" );
      ((Element)v.get(318)).setAttribute("VALOR","COD0" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(319)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(319)).setAttribute("TIPO","STRING" );
      ((Element)v.get(319)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(320)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(320)).setAttribute("TIPO","STRING" );
      ((Element)v.get(320)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(321)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(321)).setAttribute("TIPO","STRING" );
      ((Element)v.get(321)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(322)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(322)).setAttribute("TIPO","STRING" );
      ((Element)v.get(322)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(323)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(323)).setAttribute("TIPO","STRING" );
      ((Element)v.get(323)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(324)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(324)).setAttribute("TIPO","STRING" );
      ((Element)v.get(324)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(325)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(325)).setAttribute("TIPO","STRING" );
      ((Element)v.get(325)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(326)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(326)).setAttribute("TIPO","STRING" );
      ((Element)v.get(326)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(327)).setAttribute("NOMBRE","dato4" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(327)).setAttribute("TIPO","STRING" );
      ((Element)v.get(327)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(328)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(328)).setAttribute("TIPO","STRING" );
      ((Element)v.get(328)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(329)).setAttribute("TIPO","STRING" );
      ((Element)v.get(329)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */

      /* Empieza nodo:330 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(330)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(330)).setAttribute("TIPO","STRING" );
      ((Element)v.get(330)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 317   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(331)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(331)).setAttribute("TIPO","STRING" );
      ((Element)v.get(331)).setAttribute("VALOR","" );
      ((Element)v.get(317)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:317   */

      /* Empieza nodo:332 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(332)).setAttribute("ID","2" );
      ((Element)v.get(211)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(333)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(333)).setAttribute("TIPO","STRING" );
      ((Element)v.get(333)).setAttribute("VALOR","COD1" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(334)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(334)).setAttribute("TIPO","STRING" );
      ((Element)v.get(334)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(335)).setAttribute("TIPO","STRING" );
      ((Element)v.get(335)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(336)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(336)).setAttribute("TIPO","STRING" );
      ((Element)v.get(336)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(337)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(337)).setAttribute("TIPO","STRING" );
      ((Element)v.get(337)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(338)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(338)).setAttribute("TIPO","STRING" );
      ((Element)v.get(338)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(339)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(339)).setAttribute("TIPO","STRING" );
      ((Element)v.get(339)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(340)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(340)).setAttribute("TIPO","STRING" );
      ((Element)v.get(340)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(341)).setAttribute("TIPO","STRING" );
      ((Element)v.get(341)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(342)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(342)).setAttribute("TIPO","STRING" );
      ((Element)v.get(342)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(343)).setAttribute("TIPO","STRING" );
      ((Element)v.get(343)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(344)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(344)).setAttribute("TIPO","STRING" );
      ((Element)v.get(344)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(345)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(345)).setAttribute("TIPO","STRING" );
      ((Element)v.get(345)).setAttribute("VALOR","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(332)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 332   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(346)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(346)).setAttribute("TIPO","STRING" );
      ((Element)v.get(346)).setAttribute("VALOR","" );
      ((Element)v.get(332)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:332   */

      /* Empieza nodo:347 / Elemento padre: 211   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(347)).setAttribute("ID","3" );
      ((Element)v.get(211)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(348)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(348)).setAttribute("TIPO","STRING" );
      ((Element)v.get(348)).setAttribute("VALOR","COD2" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(349)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(349)).setAttribute("TIPO","STRING" );
      ((Element)v.get(349)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(350)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(350)).setAttribute("TIPO","STRING" );
      ((Element)v.get(350)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(351)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(351)).setAttribute("TIPO","STRING" );
      ((Element)v.get(351)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(352)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(352)).setAttribute("TIPO","STRING" );
      ((Element)v.get(352)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(353)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(353)).setAttribute("TIPO","STRING" );
      ((Element)v.get(353)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(354)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(354)).setAttribute("TIPO","STRING" );
      ((Element)v.get(354)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(355)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(355)).setAttribute("TIPO","STRING" );
      ((Element)v.get(355)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(356)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(356)).setAttribute("TIPO","STRING" );
      ((Element)v.get(356)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(357)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(357)).setAttribute("TIPO","STRING" );
      ((Element)v.get(357)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(358)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(358)).setAttribute("TIPO","STRING" );
      ((Element)v.get(358)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(359)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(359)).setAttribute("TIPO","STRING" );
      ((Element)v.get(359)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(360)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(360)).setAttribute("TIPO","STRING" );
      ((Element)v.get(360)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 347   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(361)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(361)).setAttribute("TIPO","STRING" );
      ((Element)v.get(361)).setAttribute("VALOR","" );
      ((Element)v.get(347)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:347   */
      /* Termina nodo:211   */

      /* Empieza nodo:362 / Elemento padre: 159   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(362)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(362)).setAttribute("ancho","625" );
      ((Element)v.get(362)).setAttribute("sep","$" );
      ((Element)v.get(362)).setAttribute("x","12" );
      ((Element)v.get(362)).setAttribute("class","botonera" );
      ((Element)v.get(362)).setAttribute("y","496" );
      ((Element)v.get(362)).setAttribute("control","|" );
      ((Element)v.get(362)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(362)).setAttribute("rowset","" );
      ((Element)v.get(362)).setAttribute("cargainicial","N" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(362)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(159)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(363)).setAttribute("nombre","ret1" );
      ((Element)v.get(363)).setAttribute("x","37" );
      ((Element)v.get(363)).setAttribute("y","500" );
      ((Element)v.get(363)).setAttribute("ID","botonContenido" );
      ((Element)v.get(363)).setAttribute("img","retroceder_on" );
      ((Element)v.get(363)).setAttribute("tipo","0" );
      ((Element)v.get(363)).setAttribute("estado","false" );
      ((Element)v.get(363)).setAttribute("alt","" );
      ((Element)v.get(363)).setAttribute("codigo","" );
      ((Element)v.get(363)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 362   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(364)).setAttribute("nombre","ava1" );
      ((Element)v.get(364)).setAttribute("x","52" );
      ((Element)v.get(364)).setAttribute("y","500" );
      ((Element)v.get(364)).setAttribute("ID","botonContenido" );
      ((Element)v.get(364)).setAttribute("img","avanzar_on" );
      ((Element)v.get(364)).setAttribute("tipo","0" );
      ((Element)v.get(364)).setAttribute("estado","false" );
      ((Element)v.get(364)).setAttribute("alt","" );
      ((Element)v.get(364)).setAttribute("codigo","" );
      ((Element)v.get(364)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(362)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:362   */
      /* Termina nodo:159   */

      /* Empieza nodo:365 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(365)).setAttribute("nombre","primera1" );
      ((Element)v.get(365)).setAttribute("x","20" );
      ((Element)v.get(365)).setAttribute("y","500" );
      ((Element)v.get(365)).setAttribute("ID","botonContenido" );
      ((Element)v.get(365)).setAttribute("img","primera_on" );
      ((Element)v.get(365)).setAttribute("tipo","-2" );
      ((Element)v.get(365)).setAttribute("estado","false" );
      ((Element)v.get(365)).setAttribute("alt","" );
      ((Element)v.get(365)).setAttribute("codigo","" );
      ((Element)v.get(365)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(366)).setAttribute("nombre","separa" );
      ((Element)v.get(366)).setAttribute("x","59" );
      ((Element)v.get(366)).setAttribute("y","496" );
      ((Element)v.get(366)).setAttribute("ID","botonContenido" );
      ((Element)v.get(366)).setAttribute("img","separa_base" );
      ((Element)v.get(366)).setAttribute("tipo","0" );
      ((Element)v.get(366)).setAttribute("estado","false" );
      ((Element)v.get(366)).setAttribute("alt","" );
      ((Element)v.get(366)).setAttribute("codigo","" );
      ((Element)v.get(366)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(367)).setAttribute("nombre","Modificar" );
      ((Element)v.get(367)).setAttribute("x","80" );
      ((Element)v.get(367)).setAttribute("y","497" );
      ((Element)v.get(367)).setAttribute("ID","botonContenido" );
      ((Element)v.get(367)).setAttribute("tipo","html" );
      ((Element)v.get(367)).setAttribute("estado","false" );
      ((Element)v.get(367)).setAttribute("cod","2" );
      ((Element)v.get(367)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(367)).setAttribute("ontab","focaliza('frmBuscar.cbMarca');" );
      ((Element)v.get(367)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(368)).setAttribute("nombre","Detalle" );
      ((Element)v.get(368)).setAttribute("x","80" );
      ((Element)v.get(368)).setAttribute("y","497" );
      ((Element)v.get(368)).setAttribute("ID","botonContenido" );
      ((Element)v.get(368)).setAttribute("tipo","html" );
      ((Element)v.get(368)).setAttribute("estado","false" );
      ((Element)v.get(368)).setAttribute("cod","3" );
      ((Element)v.get(368)).setAttribute("accion","accionConsultar();" );
      ((Element)v.get(368)).setAttribute("ontab","focaliza('frmBuscar.cbMarca');" );
      ((Element)v.get(368)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(369)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(369)).setAttribute("alto","12" );
      ((Element)v.get(369)).setAttribute("ancho","50" );
      ((Element)v.get(369)).setAttribute("colorf","" );
      ((Element)v.get(369)).setAttribute("borde","0" );
      ((Element)v.get(369)).setAttribute("imagenf","" );
      ((Element)v.get(369)).setAttribute("repeat","" );
      ((Element)v.get(369)).setAttribute("padding","" );
      ((Element)v.get(369)).setAttribute("visibilidad","visible" );
      ((Element)v.get(369)).setAttribute("contravsb","" );
      ((Element)v.get(369)).setAttribute("x","0" );
      ((Element)v.get(369)).setAttribute("y","519" );
      ((Element)v.get(369)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:8   */


   }

}
