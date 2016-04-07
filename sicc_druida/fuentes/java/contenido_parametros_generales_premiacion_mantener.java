
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_generales_premiacion_mantener  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_generales_premiacion_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(4)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r     \r      \r  varNoLimpiarSICC='S'; \r  \r  function onLoadPag() {\r      configurarMenuSecundario('formulario');\r    \r      if(!fMostrarMensajeError()) {\r      \r            cargarPantallaPlantilla();\r            \r                        if(get('formulario.hCbTipoSeleccion')!=\"\") {\r                  cargarPantalla();           \r            }\r                \r            if(get('formulario.opcionMenu')==\"Consultar Concurso\"){  \r                  deshabilitarPantalla();\r                  btnProxy(1,0);\r                  btnProxy(2,1);\r                  btnProxy(3,0);\r                  btnProxy(4,0);\r                  btnProxy(5,0);\r                  btnProxy(7,0);\r                  btnProxy(8,0);\r                  btnProxy(9,0);\r                  \r            }\r			else if(get('formulario.opcionMenu')==\"Modificar Concurso\" || \r                         get('formulario.opcionMenu')==\"nueva version\"){  \r                  btnProxy(1,1);\r                  btnProxy(2,1);\r                  btnProxy(3,0);\r                  btnProxy(4,0);\r                  btnProxy(5,1);\r                  btnProxy(7,0);\r                  btnProxy(8,0);\r                  btnProxy(9,0);\r                  \r                                    if(get('formulario.opcionMenu')==\"nueva version\"){ \r                      document.getElementById('tblPestanyas1').style.display='none';\r                      document.getElementById('tblPestanyas2').style.display='none';\r                  }\r                  \r                  focaliza(\"formulario.cbTipoSeleccion\");\r                  \r            } else {\r                  focaliza(\"formulario.cbTipoSeleccion\");\r            }\r            \r      } \r      \r      finCargaPagina = true;\r\r}\r\rfunction accionBuscarProducto(){  \r	  	  var obj = new Object();\r	  obj.casoDeUso= 'buscarProducto' \r	  obj.accion = '';\r	  obj.oidMarcaCorporativa = get('formulario.hOidMarca');\r	  var retorno = mostrarModalSICC('LPBuscarProductosDTO', '', obj, null, null);\r	  \r	  if(retorno!=null) {          \r		  		  productosString = retorno[0];      \r		  productosString = productosString.substring(1,productosString.length);\r		  \r		  productos = productosString.split('$');\r		  		  \r		  		  if(productos.length==1 ){\r				producto = productos[0].split('|');\r				set('formulario.txtCodProducto', producto[1]); \r				set('formulario.oidProducto', producto[0]); \r		  } else {\r				set('formulario.txtCodProducto', ''); \r				set('formulario.oidProducto', ''); \r				GestionarMensaje('1497');\r		  }\r	  }\r  }\r\rfunction onChangeCodProducto(){  \r	set('formulario.oidProducto', ''); \r}\r  \r  function cargarPantalla() {\r            iSeleccionado = new Array(); \r      \r      iSeleccionado[0] = get('formulario.hCbTipoSeleccion');\r      set('formulario.cbTipoSeleccion', iSeleccionado);\r      \r      iSeleccionado[0] = get('formulario.hCbPeriodo');\r	  	  if( get( 'formulario.ckPeriodoDespacho') == \"S\" ){\r		accion('formulario.cbPeriodo', '.disabled=false');\r		set('formulario.cbPeriodo', iSeleccionado);\r		accion('formulario.txtNumPeriodoObtencion', '.disabled=false');\r	  }\r      \r      iSeleccionado[0] = get('formulario.hCbTipoEleccion');\r      set('formulario.cbTipoEleccion', iSeleccionado);\r      \r            if(get('formulario.ckComunicacion')==\"N\")\r            accion('formulario.txtMensaje', '.disabled=true');\r            \r            if(get('formulario.cbTipoSeleccion')== get('formulario.OID_TIPO_PREM_NIVELES'))           \r            visibilidad('capa3','V');\r\r	  onChangePremiosElectivos();\r\r      	  if(get('formulario.cbTipoSeleccion')== get('formulario.OID_TIPO_PREMIACION_SORTEO')) {   \r            visibilidad('capa2','O');\r			visibilidad('capa3','O');\r			visibilidad('capa4','V');\r	  }\r  }\r  \r  function cargarPantallaPlantilla() {\r            if(get('formulario.hIndPremiosAcumuPorNiveles')==get('formulario.IND_INACTIVO'))\r            accion('formulario.ckPremiosAcumulativosNiveles', '.disabled=true');\r            \r      if(get('formulario.hIndNivelesRotativos')==get('formulario.IND_INACTIVO'))\r            accion('formulario.ckNivelesRotativos', '.disabled=true');    \r            \r      if(get('formulario.hIndPremiosElectivos')==get('formulario.IND_INACTIVO')) {\r            accion('formulario.ckPremioElectivo', '.disabled=true');         \r            accion('formulario.cbTipoEleccion', '.disabled=true');         \r      }\r	  else {\r            accion('formulario.cbTipoEleccion', '.disabled=true');         \r      }\r      \r      if(get('formulario.ckComunicacion')==\"N\")\r            accion('formulario.txtMensaje', '.disabled=true');    \r            \r            visibilidad('capa3','O');\r\r	  	  visibilidad('capa4','O');\r  }\r\r  function cargarPantallaPlantilla2() {\r            if(get('formulario.hIndPremiosAcumuPorNiveles')==get('formulario.IND_INACTIVO'))\r            accion('formulario.ckPremiosAcumulativosNiveles', '.disabled=true');\r            \r      if(get('formulario.hIndNivelesRotativos')==get('formulario.IND_INACTIVO'))\r            accion('formulario.ckNivelesRotativos', '.disabled=true');    \r      \r      if(get('formulario.ckComunicacion')==\"N\")\r            accion('formulario.txtMensaje', '.disabled=true');    \r            \r            visibilidad('capa3','O');\r  }\r  \r  \r  function deshabilitarPantalla() {\r  \r      accion('formulario.cbTipoSeleccion', '.disabled=true');    \r      accion('formulario.txtNumNiveles', '.disabled=true');    \r      accion('formulario.ckPeriodoDespacho', '.disabled=true');    \r      accion('formulario.cbPeriodo', '.disabled=true');    \r      accion('formulario.txtNumPeriodoObtencion', '.disabled=true');    \r      accion('formulario.ckComunicacion', '.disabled=true');    \r      accion('formulario.txtMensaje', '.disabled=true');    \r      accion('formulario.ckPremiosAcumulativosNiveles', '.disabled=true');    \r      accion('formulario.ckNivelesRotativos', '.disabled=true');    \r      accion('formulario.txtNumRotaciones', '.disabled=true');    \r      accion('formulario.ckAccesoNivelPremioSuperior', '.disabled=true');    \r      accion('formulario.ckPremioElectivo', '.disabled=true');    \r      accion('formulario.cbTipoEleccion', '.disabled=true');    \r\r      	  accion('formulario.txtCantidadNumerosAOtorgar', '.disabled=true');    \r	  accion('formulario.txtCodProducto', '.disabled=true');    \r	  deshabilitarHabilitarBoton('botonContenido','btnBuscar','D')\r      \r      deshabilitarHabilitarBoton('botonContenido','btnAceptar','D')\r  }\r  \r  \r  function onChangePremiosElectivos() {\r  \r      if(get('formulario.ckPremioElectivo')==\"S\") {\r           accion('formulario.cbTipoEleccion', '.disabled=false'); \r		   var iSeleccionado = new Array(); \r		   iSeleccionado[0] = get('formulario.hCbTipoEleccion');\r		   set('formulario.cbTipoEleccion', iSeleccionado);\r           \r      } else if(get('formulario.ckPremioElectivo')==\"N\") {\r          \r                      cantidadPremiosArticulos = get('formulario.cantidadPremiosArticulos');\r           cantidadPremiosElectivos = cantidadPremiosArticulos.split(\"|\");\r           cambioOK = \"S\";\r          \r           for(var i=0; i<cantidadPremiosElectivos.length; i++) {\r              if(Number(cantidadPremiosElectivos[i]) > 1) {\r                    cambioOK = \"N\";                   \r              }\r           }\r                      \r           if(cambioOK==\"S\") {\r                set('formulario.cbTipoEleccion', '');\r                accion('formulario.cbTipoEleccion', '.disabled=true'); \r           } else {\r                GestionarMensaje(\"1560\");\r                set('formulario.ckPremioElectivo', 'S');\r           }\r      }\r  }\r  \r  function onChangePeriodoDespacho() {\r      if(get('formulario.ckPeriodoDespacho')==\"S\") {\r           accion('formulario.cbPeriodo', '.disabled=false');    \r           accion('formulario.txtNumPeriodoObtencion', '.disabled=false'); \r      } else {\r           set('formulario.cbPeriodo', '');\r           set('formulario.txtNumPeriodoObtencion', '');\r           accion('formulario.cbPeriodo', '.disabled=true');    \r           accion('formulario.txtNumPeriodoObtencion', '.disabled=true'); \r      }\r  }\r  \r  \r  function onChangeComunicacion() {\r      if(get('formulario.ckComunicacion')==\"S\") {\r           accion('formulario.txtMensaje', '.disabled=false');  \r      } else {\r           set('formulario.txtMensaje', '');           \r           accion('formulario.txtMensaje', '.disabled=true'); \r      }\r  }\r  \r      function accionAceptar() {      \r      onChangeTipo = true;\r      borraNiveles = false;\r      \r            if(get('formulario.hCbTipoSeleccion')!=\"\" && 								     get('formulario.hCbTipoSeleccion')!=get('formulario.cbTipoSeleccion')) {\r            onChangeTipo = GestionarMensaje('1580');\r                         \r            if(onChangeTipo){\r                  borraNiveles = true;\r            }\r      }\r      \r      if(onChangeTipo){\r            set('formulario.hCbTipoSeleccion', get('formulario.cbTipoSeleccion'));   \r\r			if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREMIACION_SORTEO')){      \r			\r				  visibilidad('capa2','O');\r				  visibilidad('capa3','O');\r				  visibilidad('capa4','V');\r            \r            } else if(get('formulario.hCbTipoSeleccion')!= get('formulario.OID_TIPO_PREM_NIVELES')){                      \r                  set('formulario.ckPremiosAcumulativosNiveles', 'N');    \r				  set('formulario.txtHastaNivel', '');    \r                  set('formulario.ckNivelesRotativos', 'N');    \r                  set('formulario.txtNumRotaciones', '');    \r                  set('formulario.ckAccesoNivelPremioSuperior', 'N');    \r                  visibilidad('capa3','O');\r            }\r			else {\r                                    cargarPantallaPlantilla2();\r				  \r                  if(get('formulario.hIndFaseCalificacion')==\"S\" && get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREM_NIVELES')) {\r                      set('formulario.ckAccesoNivelPremioSuperior', \"S\");\r                  }\r				  else {\r                      set('formulario.ckAccesoNivelPremioSuperior', \"N\");\r                  }\r                      \r                  set('formulario.txtNumRotaciones', '1');                                 \r                  visibilidad('capa3','V');\r				  onChangeChkPremios();\r            }\r            \r            if(borraNiveles){\r                                    set('formulario.conectorAction', 'LPMantenerParametrosGeneralesPremiacion');\r                  set('formulario.accion', 'eliminar niveles');\r                  eval('formulario').oculto = 'S';\r                  enviaSICC('formulario', null, null, 'N');\r            }            \r      }\r	  else {\r                        iSeleccionado = new Array(); \r            iSeleccionado[0] = get('formulario.hCbTipoSeleccion');            \r            set('formulario.cbTipoSeleccion', iSeleccionado);\r      }\r  }\r  \r      function comprobarDatosObligatorios (){\r    var datosObligatorios = true;\r    \r    if(get('formulario.hCbTipoSeleccion')== '')\r          datosObligatorios = false;\r          \r        if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREM_NIVELES')){ \r    \r          if(get('formulario.txtNumRotaciones')=='')\r              datosObligatorios = false;\r              \r                    if(get('formulario.ckPremioElectivo')==\"S\" ){\r				if(get('formulario.cbTipoEleccion')=='') {\r					datosObligatorios = false;          \r				}		  \r		  }	\r\r        } else if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREMIACION_SORTEO')){ \r\r		if(get('formulario.txtCantidadNumerosAOtorgar')=='' && get('formulario.txtCodProducto')==''){\r			datosObligatorios = false;  \r		}		\r	}\r    \r    return datosObligatorios;              \r  }\r\rfunction onClickPestanyaPremiacion(valor) {\r	        if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREM_NIVELES')){ \r		if(!sicc_validaciones_generales(\"Obligatorios\")){\r			return;\r        }\r\r                if(get('formulario.ckPremioElectivo')==\"S\"){\r			if(!sicc_validaciones_generales(\"Obligatorios2\")){\r				return;\r            }\r        }\r\r        } else if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREMIACION_SORTEO')){ \r\r		if(!sicc_validaciones_generales(\"gSorteo\")){\r				return;\r        }\r	}\r\r	if(!sicc_validaciones_generales(\"cambioPestania\")){\r		return;\r    }\r\r    onClickPestanyaHabilitada(valor, 'formulario', 'LPMantenerParametrosGeneralesPremiacion');\r}  \r\rfunction fGuardar(){\r	        if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREM_NIVELES')){ 		if(!sicc_validaciones_generales(\"Obligatorios\")){\r			return;\r        }\r\r                if(get('formulario.ckPremioElectivo')==\"S\"){\r			if(!sicc_validaciones_generales(\"Obligatorios2\")){\r				return;\r            }\r        }\r\r        } else if(get('formulario.hCbTipoSeleccion')== get('formulario.OID_TIPO_PREMIACION_SORTEO')){ \r\r		if(!sicc_validaciones_generales(\"gSorteo\")){\r				return;\r        }\r	}\r\r    if(sicc_validaciones_generales(\"gAlmacenar\")){\r		if(get('formulario.opcionMenu')!= 'nueva version'){\r			eval('formulario').oculto = 'S';\r            set('formulario.conectorAction', 'LPMantenerParametrosGeneralesPremiacion');\r            set('formulario.accion', 'guardar');\r            set('formulario.datosObligatorios', comprobarDatosObligatorios());\r            enviaSICC('formulario','','','N');\r         }\r		 else {\r			eval('formulario').oculto = 'S';\r            set('formulario.conectorAction', 'LPMantenerParametrosGeneralesPremiacion');\r            set('formulario.accion', 'almacenar');\r            set('formulario.datosObligatorios', comprobarDatosObligatorios());\r            enviaSICC('formulario','','','N');\r         }\r    }\r}  \r  \r  function accionDefinirNiveles(){   \r  \r    if(sicc_validaciones_generales(\"gDefinir\")){\r                                          set('formulario.hCbTipoSeleccion', get('formulario.cbTipoSeleccion'));   \r                      var obj = new Object();\r          obj.opcionMenu = get('formulario.opcionMenu')\r          obj.accion = 'cargar mantener nivel';\r          obj.numeroNiveles = get('formulario.txtNumNiveles');\r          obj.hIndPremiosElectivosPremios = get('formulario.ckPremioElectivo');     \r          obj.hCbTipoSeleccion = get('formulario.hCbTipoSeleccion');\r          \r          var retorno = mostrarModalSICC('LPMantenerParametrosGeneralesPremiacion', 'cargar mantener nivel', obj, '795', '595');\r                      \r                    if(retorno!=null){\r              set('formulario.cantidadPremiosArticulos',retorno[0]);\r          }          \r              \r          focaliza(\"formulario.cbTipoSeleccion\");                     \r    }\r          }\r  \r  function fLimpiar(){\r      if(get('formulario.opcionMenu')==\"Crear concurso\"){\r      \r            if(GestionarMensaje('1580')){\r                  set('formulario.cbTipoSeleccion', '');    \r                  set('formulario.hCbTipoSeleccion', '');    \r                  set('formulario.txtNumNiveles', '');    \r                  set('formulario.ckPeriodoDespacho', 'N');    \r                  set('formulario.cbPeriodo', '');    \r                  set('formulario.txtNumPeriodoObtencion', '');    \r                  set('formulario.ckComunicacion', 'N');    \r                  set('formulario.txtMensaje', '');    \r                  set('formulario.ckPremiosAcumulativosNiveles', 'N');    \r                  set('formulario.ckNivelesRotativos', 'N');    \r                  set('formulario.txtNumRotaciones', '1');    \r                  set('formulario.ckAccesoNivelPremioSuperior', 'N');    \r                  set('formulario.ckPremioElectivo', 'N');    \r                  set('formulario.cbTipoEleccion', '');   \r\r				  				  set('formulario.txtCantidadNumerosAOtorgar', ''); \r				  set('formulario.txtCodProducto', ''); \r				  set('formulario.oidProducto', ''); \r                  \r                  cargarPantallaPlantilla();\r                  \r                                    set('formulario.conectorAction', 'LPMantenerParametrosGeneralesPremiacion');\r                  set('formulario.accion', 'eliminar niveles');\r                  eval('formulario').oculto = 'S';\r                  enviaSICC('formulario', null, null, 'N');\r            }\r            \r      } else {\r            set('formulario.conectorAction', 'LPMantenerParametrosGeneralesPremiacion');\r            set('formulario.accion', '');\r            enviaSICC('formulario','','','N');\r      }\r  }\r  \r  function fVolver(){\r    close();\r  }\r  \r  function cerrarModal(){\r    close();\r  }\r  \r  function terminaEliminarNiveles(){\r    focaliza('formulario.cbTipoSeleccion');\r    eval('formulario').oculto = 'N';\r  }\r  \r  function focalizaTab(campo){\r     if(campo==1) {\r            if(get_visibilidad('capa3')){\r                  if(get('formulario.hIndPremiosAcumuPorNiveles')==get('formulario.IND_INACTIVO')) {\r                      if(get('formulario.hIndNivelesRotativos')==get('formulario.IND_INACTIVO')) {\r                            focaliza(\"formulario.txtNumRotaciones\");\r                      } else {\r                            focaliza(\"formulario.ckNivelesRotativos\");\r                      }\r                  } else {\r                      focaliza(\"formulario.ckPremiosAcumulativosNiveles\");\r                  }\r            } else {\r                  focaliza(\"formulario.cbTipoSeleccion\");\r            }\r     } else if(campo==2) {\r          if(get('formulario.hIndPremiosElectivos')==get('formulario.IND_INACTIVO')) {\r              focaliza(\"formulario.cbTipoSeleccion\");\r          } else {\r              focaliza(\"formulario.ckPremioElectivo\");\r          }\r     } else if(campo==3) {\r          if(get('formulario.ckPremioElectivo')==\"S\") {\r              focaliza(\"formulario.cbTipoEleccion\");\r          } else {\r              focaliza(\"formulario.cbTipoSeleccion\");\r          }\r     } else if(campo==4) {\r          focaliza(\"formulario.cbTipoSeleccion\");\r     }      \r     \r  }\r  \r  \r  function focalizaShTab(){  \r  \r      if(!get_visibilidad('capa3')){\r            focalizaBotonHTML('botonContenido','btnDefinirNiveles');\r      \r	  	  } else if(get_visibilidad('capa4')){\r			focalizaBotonHTML('botonContenido','btnBuscar');     \r\r      } else {      \r            if(get('formulario.hIndPremiosElectivos')==get('formulario.IND_INACTIVO')) {\r                  focaliza(\"formulario.ckAccesoNivelPremioSuperior\");\r            }\r			else {\r		  		 focaliza(\"formulario.ckAccesoNivelPremioSuperior\");\r                  /*if(get('formulario.ckPremioElectivo')==\"S\") {\r                      focaliza(\"formulario.cbTipoEleccion\");\r                  } else {\r                      focaliza(\"formulario.ckPremioElectivo\");\r                  }*/\r            }      \r      }\r  }\r\r  function focalizaTipoPremTab(){  \r	 if(get_visibilidad('capa4')){\r		focaliza(\"formulario.txtCantidadNumerosAOtorgar\");\r	 } else {\r		focaliza(\"formulario.txtNumNiveles\");\r	 }\r  }\r\r function focalizaBuscarTab(){\r	focaliza(\"formulario.cbTipoSeleccion\");\r }\r\r\r	function onTabAccesoNivelPremio() {\r		focaliza(\"formulario.cbTipoSeleccion\");\r	}\r\r	function onTabTipoEleccion() {\r		focalizaBotonHTML('botonContenido','btnDefinirNiveles');\r	}\r\r	function onChangeChkPremios() {\r		if(get('formulario.ckPremiosAcumulativosNiveles')==\"S\") {\r			document.getElementById(\"lblHastaNivel\").style.display='inline';\r			document.getElementById(\"txtHastaNivel\").style.display='inline';\r	\r			if(get('formulario.txtNumNiveles')!=\"\") {\r				var numNiveles = parseInt(get('formulario.txtNumNiveles'), 10);\r				numNiveles = numNiveles + 1;\r				set('formulario.txtHastaNivel', numNiveles);				\r			}			\r		}\r		else {\r	 		set('formulario.txtHastaNivel', '');\r			document.getElementById(\"lblHastaNivel\").style.display='none';\r			document.getElementById(\"txtHastaNivel\").style.display='none';\r		}\r	}          \r  \r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNumNiveles" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("group","gAlmacenar" );
      ((Element)v.get(8)).setAttribute("cod","1818" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNumPeriodoObtencion" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","99" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("group","gAlmacenar" );
      ((Element)v.get(9)).setAttribute("cod","1800" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtHastaNivel" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(10)).setAttribute("group","gAlmacenar" );
      ((Element)v.get(10)).setAttribute("cod","1821" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNumRotaciones" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("group","gAlmacenar" );
      ((Element)v.get(11)).setAttribute("cod","1822" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNumRotaciones" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","999" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("group","Obligatorios" );
      ((Element)v.get(12)).setAttribute("cod","1822" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoEleccion" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("group","Obligatorios2" );
      ((Element)v.get(13)).setAttribute("cod","1825" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtNumNiveles" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","999" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("group","gDefinir" );
      ((Element)v.get(14)).setAttribute("cod","1818" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbTipoSeleccion" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("group","gDefinir" );
      ((Element)v.get(15)).setAttribute("cod","2450" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtCantidadNumerosAOtorgar" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","99999" );
      ((Element)v.get(16)).setAttribute("format","e" );
      ((Element)v.get(16)).setAttribute("group","gSorteo" );
      ((Element)v.get(16)).setAttribute("cod","3451" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("group","gSorteo" );
      ((Element)v.get(17)).setAttribute("cod","337" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtNumNiveles" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","999" );
      ((Element)v.get(18)).setAttribute("format","e" );
      ((Element)v.get(18)).setAttribute("group","cambioPestania" );
      ((Element)v.get(18)).setAttribute("cod","1818" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtNumPeriodoObtencion" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","99" );
      ((Element)v.get(19)).setAttribute("format","e" );
      ((Element)v.get(19)).setAttribute("group","cambioPestania" );
      ((Element)v.get(19)).setAttribute("cod","1800" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtHastaNivel" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","999" );
      ((Element)v.get(20)).setAttribute("format","e" );
      ((Element)v.get(20)).setAttribute("group","cambioPestania" );
      ((Element)v.get(20)).setAttribute("cod","1821" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(21)).setAttribute("nombre","formulario" );
      ((Element)v.get(21)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","accion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hPais" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 21   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","oidParamGralesPremiacion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","IND_INACTIVO" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","IND_ACTIVO" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","OID_TIPO_PREM_NIVELES" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hIndPremiosAcumuPorNiveles" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIndNivelesRotativos" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hIndFaseCalificacion" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndPremiosElectivos" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hIndSorteo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hCbTipoSeleccion" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hCbPeriodo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hCbTipoEleccion" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","OID_TIPO_PREMIACION_SORTEO" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hOidMarca" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","oidProducto" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","niveles" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","cantidadPremiosArticulos" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("height","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("class","menu4" );
      ((Element)v.get(55)).setAttribute("id","tblPestanyas1" );
      ((Element)v.get(21)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("height","30" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","92" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","75" );
      ((Element)v.get(64)).setAttribute("border","1" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","1" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(64)).setAttribute("onclick","onClickPestanyaPremiacion(1);" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(67)).setAttribute("cod","00393" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","20" );
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","75" );
      ((Element)v.get(71)).setAttribute("border","1" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellpadding","1" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(71)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(71)).setAttribute("onclick","onClickPestanyaPremiacion(5);" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(74)).setAttribute("cod","0094" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:75 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","10" );
      ((Element)v.get(75)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","10" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","20" );
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","75" );
      ((Element)v.get(78)).setAttribute("border","1" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cellpadding","1" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(78)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(81)).setAttribute("cod","00394" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:82 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","10" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","20" );
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","75" );
      ((Element)v.get(85)).setAttribute("border","1" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellpadding","1" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(85)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(85)).setAttribute("onclick","onClickPestanyaPremiacion(7);" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","menu5textonegrita" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(88)).setAttribute("cod","00395" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:89 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","10" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","20" );
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("table"));
      ((Element)v.get(92)).setAttribute("width","75" );
      ((Element)v.get(92)).setAttribute("border","1" );
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(92)).setAttribute("cellpadding","1" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(92)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(92)).setAttribute("onclick","onClickPestanyaPremiacion(4);" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(95)).setAttribute("cod","00396" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:96 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","20" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","75" );
      ((Element)v.get(99)).setAttribute("border","1" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","1" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(99)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(99)).setAttribute("onclick","onClickPestanyaPremiacion(8);" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(102)).setAttribute("cod","00397" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","16" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:105 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(105)).setAttribute("height","100%" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(105)).setAttribute("border","0" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","0" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("class","menu4" );
      ((Element)v.get(105)).setAttribute("id","tblPestanyas2" );
      ((Element)v.get(21)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("height","30" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","10" );
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","10" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","70" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","75" );
      ((Element)v.get(114)).setAttribute("border","1" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellpadding","1" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(114)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblAmbitoGeografico');" );
      ((Element)v.get(114)).setAttribute("onclick","onClickPestanyaPremiacion(3);" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(117)).setAttribute("cod","2801" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:118 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","10" );
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","10" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","70" );
      ((Element)v.get(120)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","75" );
      ((Element)v.get(121)).setAttribute("border","1" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cellpadding","1" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(121)).setAttribute("onmouseover","activarPuntero('formulario', 9, 'lblCalificacion');" );
      ((Element)v.get(121)).setAttribute("onclick","onClickPestanyaPremiacion(9);" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(124)).setAttribute("cod","00398" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:125 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","10" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","20" );
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","75" );
      ((Element)v.get(128)).setAttribute("border","1" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(128)).setAttribute("cellpadding","1" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(128)).setAttribute("onmouseover","activarPuntero('formulario', 10, 'lblGerentes');" );
      ((Element)v.get(128)).setAttribute("onclick","onClickPestanyaPremiacion(10);" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(131)).setAttribute("cod","00399" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:132 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","10" );
      ((Element)v.get(132)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","10" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","20" );
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("table"));
      ((Element)v.get(135)).setAttribute("width","75" );
      ((Element)v.get(135)).setAttribute("border","1" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cellpadding","1" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(135)).setAttribute("onmouseover","activarPuntero('formulario', 11, 'lblConsultoras');" );
      ((Element)v.get(135)).setAttribute("onclick","onClickPestanyaPremiacion(11);" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(138)).setAttribute("cod","00401" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:139 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","10" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","20" );
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","75" );
      ((Element)v.get(142)).setAttribute("border","1" );
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("cellpadding","1" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(142)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(142)).setAttribute("onclick","onClickPestanyaPremiacion(2);" );
      ((Element)v.get(142)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblProgramaNuevas');" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(145)).setAttribute("cod","00590" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:146 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","10" );
      ((Element)v.get(146)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","10" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","20" );
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","75" );
      ((Element)v.get(149)).setAttribute("border","1" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cellpadding","1" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(149)).setAttribute("onclick","onClickPestanyaPremiacion(12);" );
      ((Element)v.get(149)).setAttribute("onmouseover","activarPuntero('formulario', 12, 'lblMultinivel');" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(152)).setAttribute("cod","00400" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:153 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","16" );
      ((Element)v.get(153)).setAttribute("class","menu5texto" );
      ((Element)v.get(106)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:155 / Elemento padre: 21   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(155)).setAttribute("nombre","capa1" );
      ((Element)v.get(21)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","100%" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","750" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","1" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:157   */

      /* Empieza nodo:164 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(169)).setAttribute("class","legend" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblDatosSeleccion" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","legend" );
      ((Element)v.get(170)).setAttribute("cod","00263" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("table"));
      ((Element)v.get(174)).setAttribute("width","585" );
      ((Element)v.get(174)).setAttribute("border","0" );
      ((Element)v.get(174)).setAttribute("align","left" );
      ((Element)v.get(174)).setAttribute("cellspacing","0" );
      ((Element)v.get(174)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("colspan","4" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblTipoPremiacion" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","2450" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:178   */

      /* Empieza nodo:185 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(189)).setAttribute("nombre","cbTipoSeleccion" );
      ((Element)v.get(189)).setAttribute("id","datosCampos" );
      ((Element)v.get(189)).setAttribute("size","1" );
      ((Element)v.get(189)).setAttribute("multiple","N" );
      ((Element)v.get(189)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(189)).setAttribute("req","S" );
      ((Element)v.get(189)).setAttribute("ontab","focalizaTipoPremTab();" );
      ((Element)v.get(189)).setAttribute("valorinicial","" );
      ((Element)v.get(189)).setAttribute("textoinicial","" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:191 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(185)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:185   */

      /* Empieza nodo:193 / Elemento padre: 174   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("colspan","4" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:196 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:164   */

      /* Empieza nodo:198 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("table"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("align","center" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("class","botonera" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("accion","accionAceptar()" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:207 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:198   */

      /* Empieza nodo:209 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","12" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","756" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(215)).setAttribute("height","1" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:216 / Elemento padre: 21   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(216)).setAttribute("nombre","capa2" );
      ((Element)v.get(216)).setAttribute("alto","150" );
      ((Element)v.get(216)).setAttribute("ancho","100%" );
      ((Element)v.get(216)).setAttribute("colorf","" );
      ((Element)v.get(216)).setAttribute("borde","0" );
      ((Element)v.get(216)).setAttribute("imagenf","" );
      ((Element)v.get(216)).setAttribute("repeat","" );
      ((Element)v.get(216)).setAttribute("padding","" );
      ((Element)v.get(216)).setAttribute("visibilidad","visible" );
      ((Element)v.get(216)).setAttribute("contravsb","" );
      ((Element)v.get(216)).setAttribute("x","0" );
      ((Element)v.get(216)).setAttribute("y","165" );
      ((Element)v.get(216)).setAttribute("zindex","" );
      ((Element)v.get(21)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("width","12" );
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("height","12" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","750" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","1" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */

      /* Empieza nodo:225 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(230)).setAttribute("class","legend" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblParametrosPremiacion" );
      ((Element)v.get(231)).setAttribute("alto","13" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(231)).setAttribute("id","legend" );
      ((Element)v.get(231)).setAttribute("cod","00342" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("table"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","585" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("colspan","4" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblNumNiveles" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","1818" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblPeriodoDespacho" );
      ((Element)v.get(247)).setAttribute("alto","13" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(247)).setAttribute("cod","1843" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","25" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lblPeriodo" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(251)).setAttribute("alto","13" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("id","datosTitle" );
      ((Element)v.get(251)).setAttribute("cod","276" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","25" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(255)).setAttribute("nombre","lblNumPeriodoObtencion" );
      ((Element)v.get(255)).setAttribute("alto","13" );
      ((Element)v.get(255)).setAttribute("filas","1" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("id","datosTitle" );
      ((Element)v.get(255)).setAttribute("cod","1800" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(259)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(259)).setAttribute("alto","13" );
      ((Element)v.get(259)).setAttribute("filas","1" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).setAttribute("cod","1812" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","531" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(239)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:239   */

      /* Empieza nodo:266 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(270)).setAttribute("nombre","txtNumNiveles" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("max","3" );
      ((Element)v.get(270)).setAttribute("tipo","" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","3" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("valign","bottom" );
      ((Element)v.get(266)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(274)).setAttribute("nombre","ckPeriodoDespacho" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(274)).setAttribute("onclick","onChangePeriodoDespacho()" );
      ((Element)v.get(274)).setAttribute("check","N" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(266)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(278)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("size","1" );
      ((Element)v.get(278)).setAttribute("multiple","N" );
      ((Element)v.get(278)).setAttribute("req","N" );
      ((Element)v.get(278)).setAttribute("valorinicial","" );
      ((Element)v.get(278)).setAttribute("textoinicial","" );
      ((Element)v.get(278)).setAttribute("disabled","S" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(283)).setAttribute("nombre","txtNumPeriodoObtencion" );
      ((Element)v.get(283)).setAttribute("id","datosCampos" );
      ((Element)v.get(283)).setAttribute("max","2" );
      ((Element)v.get(283)).setAttribute("tipo","" );
      ((Element)v.get(283)).setAttribute("onchange","" );
      ((Element)v.get(283)).setAttribute("req","N" );
      ((Element)v.get(283)).setAttribute("size","2" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("validacion","" );
      ((Element)v.get(283)).setAttribute("disabled","S" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(287)).setAttribute("nombre","ckComunicacion" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("onclick","onChangeComunicacion()" );
      ((Element)v.get(287)).setAttribute("check","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("valign","bottom" );
      ((Element)v.get(266)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(291)).setAttribute("nombre","txtMensaje" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(291)).setAttribute("max","5" );
      ((Element)v.get(291)).setAttribute("tipo","" );
      ((Element)v.get(291)).setAttribute("onchange","" );
      ((Element)v.get(291)).setAttribute("req","N" );
      ((Element)v.get(291)).setAttribute("size","5" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("validacion","" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:266   */

      /* Empieza nodo:294 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).setAttribute("colspan","4" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:297 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("table"));
      ((Element)v.get(299)).setAttribute("width","585" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("align","left" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblPremioElectivo" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","1942" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblTipoEleccion" );
      ((Element)v.get(308)).setAttribute("alto","13" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("valor","" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","1825" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:300   */

      /* Empieza nodo:311 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("valign","bottom" );
      ((Element)v.get(311)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(315)).setAttribute("nombre","ckPremioElectivo" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(315)).setAttribute("id","datosCampos" );
      ((Element)v.get(315)).setAttribute("ontab","focalizaTab(3);" );
      ((Element)v.get(315)).setAttribute("onclick","onChangePremiosElectivos()" );
      ((Element)v.get(315)).setAttribute("check","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(311)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(319)).setAttribute("nombre","cbTipoEleccion" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("size","1" );
      ((Element)v.get(319)).setAttribute("ontab","onTabTipoEleccion();" );
      ((Element)v.get(319)).setAttribute("multiple","N" );
      ((Element)v.get(319)).setAttribute("req","S" );
      ((Element)v.get(319)).setAttribute("valorinicial","" );
      ((Element)v.get(319)).setAttribute("textoinicial","" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:311   */

      /* Empieza nodo:323 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("colspan","4" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:326 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:225   */

      /* Empieza nodo:328 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("table"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(333)).setAttribute("border","0" );
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(333)).setAttribute("cellspacing","0" );
      ((Element)v.get(333)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("class","botonera" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(336)).setAttribute("nombre","btnDefinirNiveles" );
      ((Element)v.get(336)).setAttribute("ID","botonContenido" );
      ((Element)v.get(336)).setAttribute("tipo","html" );
      ((Element)v.get(336)).setAttribute("accion","accionDefinirNiveles()" );
      ((Element)v.get(336)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(336)).setAttribute("estado","false" );
      ((Element)v.get(336)).setAttribute("cod","1801" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","12" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:328   */

      /* Empieza nodo:339 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(217)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("align","center" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","12" );
      ((Element)v.get(341)).setAttribute("height","12" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("width","756" );
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","12" );
      ((Element)v.get(345)).setAttribute("height","1" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:339   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:346 / Elemento padre: 21   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(346)).setAttribute("nombre","capa3" );
      ((Element)v.get(346)).setAttribute("alto","110" );
      ((Element)v.get(346)).setAttribute("ancho","100%" );
      ((Element)v.get(346)).setAttribute("colorf","" );
      ((Element)v.get(346)).setAttribute("borde","0" );
      ((Element)v.get(346)).setAttribute("imagenf","" );
      ((Element)v.get(346)).setAttribute("repeat","" );
      ((Element)v.get(346)).setAttribute("padding","" );
      ((Element)v.get(346)).setAttribute("visibilidad","visible" );
      ((Element)v.get(346)).setAttribute("contravsb","" );
      ((Element)v.get(346)).setAttribute("x","0" );
      ((Element)v.get(346)).setAttribute("y","310" );
      ((Element)v.get(346)).setAttribute("zindex","" );
      ((Element)v.get(21)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("table"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(347)).setAttribute("border","0" );
      ((Element)v.get(347)).setAttribute("cellspacing","0" );
      ((Element)v.get(347)).setAttribute("cellpadding","0" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","12" );
      ((Element)v.get(349)).setAttribute("align","center" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","12" );
      ((Element)v.get(350)).setAttribute("height","12" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","750" );
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("width","12" );
      ((Element)v.get(348)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(354)).setAttribute("height","1" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:348   */

      /* Empieza nodo:355 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(360)).setAttribute("class","legend" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblParemetrosPremiacionPorNiveles" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","" );
      ((Element)v.get(361)).setAttribute("id","legend" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(361)).setAttribute("cod","00620" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 359   */
      v.add(doc.createElement("table"));
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(362)).setAttribute("border","0" );
      ((Element)v.get(362)).setAttribute("align","center" );
      ((Element)v.get(362)).setAttribute("cellspacing","0" );
      ((Element)v.get(362)).setAttribute("cellpadding","0" );
      ((Element)v.get(359)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("table"));
      ((Element)v.get(365)).setAttribute("width","585" );
      ((Element)v.get(365)).setAttribute("border","0" );
      ((Element)v.get(365)).setAttribute("align","left" );
      ((Element)v.get(365)).setAttribute("cellspacing","0" );
      ((Element)v.get(365)).setAttribute("cellpadding","0" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("colspan","4" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:369 / Elemento padre: 365   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(365)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(373)).setAttribute("nombre","lblPremiosAcumulativosNiveles" );
      ((Element)v.get(373)).setAttribute("alto","13" );
      ((Element)v.get(373)).setAttribute("filas","1" );
      ((Element)v.get(373)).setAttribute("valor","" );
      ((Element)v.get(373)).setAttribute("id","datosTitle" );
      ((Element)v.get(373)).setAttribute("cod","1820" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","25" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(377)).setAttribute("nombre","lblHastaNivel" );
      ((Element)v.get(377)).setAttribute("alto","13" );
      ((Element)v.get(377)).setAttribute("filas","1" );
      ((Element)v.get(377)).setAttribute("valor","" );
      ((Element)v.get(377)).setAttribute("id","datosTitle" );
      ((Element)v.get(377)).setAttribute("cod","1821" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","25" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(381)).setAttribute("nombre","lblNivelesRotativos" );
      ((Element)v.get(381)).setAttribute("alto","13" );
      ((Element)v.get(381)).setAttribute("filas","1" );
      ((Element)v.get(381)).setAttribute("valor","" );
      ((Element)v.get(381)).setAttribute("id","datosTitle" );
      ((Element)v.get(381)).setAttribute("cod","1822" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","25" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 369   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblNumRotaciones" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("id","datosTitle" );
      ((Element)v.get(385)).setAttribute("cod","1824" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","25" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblAccesoNivelPremioSuperior" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(389)).setAttribute("id","datosTitle" );
      ((Element)v.get(389)).setAttribute("cod","1827" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("width","100%" );
      ((Element)v.get(369)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","8" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:369   */

      /* Empieza nodo:392 / Elemento padre: 365   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(365)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("valign","bottom" );
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(396)).setAttribute("nombre","ckPremiosAcumulativosNiveles" );
      ((Element)v.get(396)).setAttribute("id","datosCampos" );
      ((Element)v.get(396)).setAttribute("onclick","onChangeChkPremios();" );
      ((Element)v.get(396)).setAttribute("check","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","25" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(400)).setAttribute("nombre","txtHastaNivel" );
      ((Element)v.get(400)).setAttribute("id","datosCampos" );
      ((Element)v.get(400)).setAttribute("max","3" );
      ((Element)v.get(400)).setAttribute("tipo","" );
      ((Element)v.get(400)).setAttribute("onchange","" );
      ((Element)v.get(400)).setAttribute("req","N" );
      ((Element)v.get(400)).setAttribute("size","4" );
      ((Element)v.get(400)).setAttribute("valor","" );
      ((Element)v.get(400)).setAttribute("validacion","" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","25" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(404)).setAttribute("nombre","ckNivelesRotativos" );
      ((Element)v.get(404)).setAttribute("id","datosCampos" );
      ((Element)v.get(404)).setAttribute("onclick","" );
      ((Element)v.get(404)).setAttribute("check","N" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","25" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(408)).setAttribute("nombre","txtNumRotaciones" );
      ((Element)v.get(408)).setAttribute("id","datosCampos" );
      ((Element)v.get(408)).setAttribute("max","2" );
      ((Element)v.get(408)).setAttribute("tipo","" );
      ((Element)v.get(408)).setAttribute("onchange","" );
      ((Element)v.get(408)).setAttribute("req","S" );
      ((Element)v.get(408)).setAttribute("size","2" );
      ((Element)v.get(408)).setAttribute("valor","" );
      ((Element)v.get(408)).setAttribute("validacion","" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","25" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(412)).setAttribute("nombre","ckAccesoNivelPremioSuperior" );
      ((Element)v.get(412)).setAttribute("id","datosCampos" );
      ((Element)v.get(412)).setAttribute("ontab","onTabAccesoNivelPremio();" );
      ((Element)v.get(412)).setAttribute("onclick","" );
      ((Element)v.get(412)).setAttribute("check","N" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(392)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:392   */

      /* Empieza nodo:415 / Elemento padre: 365   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(365)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("colspan","4" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:418 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:355   */

      /* Empieza nodo:420 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).setAttribute("width","12" );
      ((Element)v.get(421)).setAttribute("align","center" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","12" );
      ((Element)v.get(422)).setAttribute("height","12" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("width","756" );
      ((Element)v.get(420)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 420   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("width","12" );
      ((Element)v.get(420)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(426)).setAttribute("height","1" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:420   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:427 / Elemento padre: 21   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(427)).setAttribute("nombre","capa4" );
      ((Element)v.get(427)).setAttribute("alto","150" );
      ((Element)v.get(427)).setAttribute("ancho","100%" );
      ((Element)v.get(427)).setAttribute("colorf","" );
      ((Element)v.get(427)).setAttribute("borde","0" );
      ((Element)v.get(427)).setAttribute("imagenf","" );
      ((Element)v.get(427)).setAttribute("repeat","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(427)).setAttribute("padding","" );
      ((Element)v.get(427)).setAttribute("visibilidad","visible" );
      ((Element)v.get(427)).setAttribute("contravsb","" );
      ((Element)v.get(427)).setAttribute("x","0" );
      ((Element)v.get(427)).setAttribute("y","165" );
      ((Element)v.get(427)).setAttribute("zindex","" );
      ((Element)v.get(21)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("table"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(428)).setAttribute("border","0" );
      ((Element)v.get(428)).setAttribute("cellspacing","0" );
      ((Element)v.get(428)).setAttribute("cellpadding","0" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("width","12" );
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).setAttribute("width","750" );
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("width","12" );
      ((Element)v.get(429)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","12" );
      ((Element)v.get(435)).setAttribute("height","1" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:429   */

      /* Empieza nodo:436 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(441)).setAttribute("class","legend" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblParemetrosPremiacionPorSorteo" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("filas","1" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(442)).setAttribute("id","legend" );
      ((Element)v.get(442)).setAttribute("cod","3450" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 440   */
      v.add(doc.createElement("table"));
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(443)).setAttribute("border","0" );
      ((Element)v.get(443)).setAttribute("align","center" );
      ((Element)v.get(443)).setAttribute("cellspacing","0" );
      ((Element)v.get(443)).setAttribute("cellpadding","0" );
      ((Element)v.get(440)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("table"));
      ((Element)v.get(446)).setAttribute("width","585" );
      ((Element)v.get(446)).setAttribute("border","0" );
      ((Element)v.get(446)).setAttribute("align","left" );
      ((Element)v.get(446)).setAttribute("cellspacing","0" );
      ((Element)v.get(446)).setAttribute("cellpadding","0" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("colspan","4" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(454)).setAttribute("nombre","lblCantidadNúmerosAOtorgar" );
      ((Element)v.get(454)).setAttribute("alto","13" );
      ((Element)v.get(454)).setAttribute("filas","1" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(454)).setAttribute("id","datosTitle" );
      ((Element)v.get(454)).setAttribute("cod","3451" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","25" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(458)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(458)).setAttribute("alto","13" );
      ((Element)v.get(458)).setAttribute("filas","1" );
      ((Element)v.get(458)).setAttribute("valor","" );
      ((Element)v.get(458)).setAttribute("id","datosTitle" );
      ((Element)v.get(458)).setAttribute("cod","337" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("width","100%" );
      ((Element)v.get(450)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:450   */

      /* Empieza nodo:461 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(465)).setAttribute("nombre","txtCantidadNumerosAOtorgar" );
      ((Element)v.get(465)).setAttribute("id","datosCampos" );
      ((Element)v.get(465)).setAttribute("max","5" );
      ((Element)v.get(465)).setAttribute("tipo","" );
      ((Element)v.get(465)).setAttribute("onchange","" );
      ((Element)v.get(465)).setAttribute("req","S" );
      ((Element)v.get(465)).setAttribute("size","5" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(465)).setAttribute("validacion","" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","25" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(461)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(469)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).setAttribute("max","20" );
      ((Element)v.get(469)).setAttribute("tipo","" );
      ((Element)v.get(469)).setAttribute("onchange","onChangeCodProducto()" );
      ((Element)v.get(469)).setAttribute("req","S" );
      ((Element)v.get(469)).setAttribute("size","26" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(469)).setAttribute("validacion","" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(471)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(471)).setAttribute("ID","botonContenido" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(471)).setAttribute("tipo","html" );
      ((Element)v.get(471)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(471)).setAttribute("ontab","focalizaBuscarTab();" );
      ((Element)v.get(471)).setAttribute("estado","false" );
      ((Element)v.get(471)).setAttribute("cod","1" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","8" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:461   */

      /* Empieza nodo:474 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("colspan","4" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:477 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:436   */

      /* Empieza nodo:479 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("align","center" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","12" );
      ((Element)v.get(481)).setAttribute("height","12" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).setAttribute("width","756" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("width","12" );
      ((Element)v.get(479)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","12" );
      ((Element)v.get(485)).setAttribute("height","1" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:479   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:21   */


   }

}
