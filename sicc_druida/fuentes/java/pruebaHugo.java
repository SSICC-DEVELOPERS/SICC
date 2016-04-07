
import org.w3c.dom.*;
import java.util.ArrayList;

public class pruebaHugo  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         

      getXML4590(doc);
         

      getXML4680(doc);
         

      getXML4770(doc);
         

      getXML4860(doc);
         

      getXML4950(doc);
         

      getXML5040(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ofertas_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0154" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode(" \r   \r\r  function onLoadPag(){\r     configurarMenuSecundario(\"frmFormulario\");     \r     showError();  \r     che();    \r 	 posicionaRadioButtons();  \r\r     alert(get('frmFormulario.hidCKDespachoCompleto'));\r     alert(get('frmFormulario.hidCKDespachoAutomatico'));\r     \r     if(get('frmFormulario.hidCKDespachoCompleto')!=\"\"){\r        alert('voy a setear');                                                                   \r        set('frmFormulario.ckDespachoCompleto', get('frmFormulario.hidCKDespachoCompleto'));\r     }else{set('frmFormulario.ckDespachoCompleto', 'N');}\r     \r	 if(get('frmFormulario.hidCKDespachoAutomatico')!=\"\"){\r        set('frmFormulario.ckDespachoAutomatico', get('frmFormulario.hidCKDespachoAutomatico'));\r     }	 \r	 posicionaCombos();  \r    \r     \r	if ((get('frmFormulario.casoDeUso')=='consultar')){		\r        deshabilitaTodo();\r	}else{\r        configuraPantalla();\r        if(get('frmFormulario.hDeshabilitaTodo') == 'S'){	   \r            deshabilitaTodo();\r        }\r    }    \r    if (!(get('frmFormulario.casoDeUso')=='modificar')){        \r		accion('frmFormulario.cbTipoCliente','.disabled=true');\r		accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r		accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r		accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r		accion('frmFormulario.cbEstatusCliente','.disabled=true');\r		accion('frmFormulario.txtEstatus2Cliente','.disabled=true');\r    }\r\r	if(get('frmFormulario.hNombreListas')!=\"\"&& get('frmFormulario.hNombreListas')!=null){\r		metodoListaEditable();	\r	}\r     \r     DrdEnsanchaConMargenDcho('listado1',12);\r     DrdEnsanchaConMargenDcho('listado2',12);     \r     DrdEnsanchaConMargenDcho('listado5',36);\r\r     document.all[\"primera1Div\"].style.visibility='hidden';\r     document.all[\"ret1Div\"].style.visibility='hidden';\r     document.all[\"ava1Div\"].style.visibility='hidden';\r     document.all[\"primera2Div\"].style.visibility='hidden';\r     document.all[\"ret2Div\"].style.visibility='hidden';\r     document.all[\"ava2Div\"].style.visibility='hidden';\r             \r     document.all[\"primera5Div\"].style.visibility='hidden';\r     document.all[\"ret5Div\"].style.visibility='hidden';\r     document.all[\"ava5Div\"].style.visibility='hidden';\r     eval (ON_RSZ);  \r     \r   }\r\r   function metodoListaEditable(){   \r\r        var arrayNomListas = get('frmFormulario.hNombreListas').split(\"|\"); \r        for ( i = 0 ; i < arrayNomListas.length; i++) {            \r            DrdEnsanchaConMargenDcho(arrayNomListas[i],12); \r			document.all[arrayNomListas[i]+\"_pri1Div\"].style.visibility='hidden';\r			document.all[arrayNomListas[i]+\"_ret1Div\"].style.visibility='hidden';\r			document.all[arrayNomListas[i]+\"_ava1Div\"].style.visibility='hidden';	\r			\r        }\r	  \r   }\r\r   function showError(){\r        if( get('frmFormulario.casoDeUso')=='consultar' ){\r			fMostrarMensajeError();\r			window.close();	\r			set(('frmFormulario.casoDeUso'),'consultar');\r		}else{\r				if (get('frmFormulario.errCodigo') != ''){\r					fMostrarMensajeError();\r					set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r					set(\"frmFormulario.accion\", \"vuelveError\");\r					enviaSICC(\"frmFormulario\");\r				}\r				else if (get('frmFormulario.hValorError') == 'PRE0014'){\r				   GestionarMensaje('PRE0014'); \r				}\r                else if (get('frmFormulario.hValorError') == 'PRE0011'){\r				   GestionarMensaje('PRE0011'); \r                   deshabilitaTodo();\r				}\r                \r		}\r   \r   }\r   function fBorrar(){\r              if (listado2.numSelecc()>0){\r                  accionEliminarProductos();              \r              } else if (listado5.numSelecc()>0){\r                  accionEliminarVentaExclusiva();\r              } else {\r                  GestionarMensaje(4);\r              }\r           }\r\r	function accionEliminarOferta()\r	{\r	  set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r      set(\"frmFormulario.accion\", \"EliminarOferta\");\r      enviaSICC(\"frmFormulario\");\r	}\r   \r	function accionBuscarProducto()\r	{\r	  set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r      set(\"frmFormulario.accion\", \"BuscarProducto\");\r      enviaSICC(\"frmFormulario\");\r	}\r\r	function accionEliminarProductos()\r	{\r      if (listado2.numSelecc()>0){\r          if(GestionarMensaje(\"5\")){\r              set('frmFormulario.accion','eliminarProductos');\r              set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r              set('frmFormulario.elemSelecc',listado2.codSeleccionados());\r              enviaSICC('frmFormulario');\r          }\r      }\r	}\r\r	function accionModificarGrupo(codigo)\r	{\r    /*\r      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r      set(\"frmFormulario.accion\", \"modificarGrupo\");\r      enviaSICC(\"frmFormulario\");\r    */\r    set(\"frmFormulario.hidNroGrupo\", codigo);            \r    set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r    set(\"frmFormulario.accion\", \"ModificarGrupo\");\r    enviaSICC(\"frmFormulario\");\r	}\r\r	function accionAniadirGrupo()\r	{\r\r      if( get('frmFormulario.txtNumeroGrupos')<get('frmFormulario.maxGrupo')  ){\r            set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r            set(\"frmFormulario.accion\", \"AnadirGrupo\");\r            enviaSICC(\"frmFormulario\");\r      }else{\r            GestionarMensaje(\"712\");            \r      }      \r	}\r\r	function accionAniadirCondicion()\r	{\r      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r      set(\"frmFormulario.accion\", \"AnadirCondicion\");\r      enviaSICC(\"frmFormulario\");\r	}\r\r	function accionModificarCondicion(codigo)\r	{\r\r      set(\"frmFormulario.hidNroCondicion\", codigo);            \r      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r      set(\"frmFormulario.accion\", \"ModificarCondicion\");\r      enviaSICC(\"frmFormulario\");\r \r	}\r\r	function accionEliminarCondicion(boton)\r	{   \r\r        set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r        if (get('frmFormulario.nroPromociones') == 1){\r			GestionarMensaje(\"185\");\r			return;\r		}else {\r			set(\"frmFormulario.accion\", \"EliminarCondicion\");\r		    set(\"frmFormulario.hOidCondicion\", eval(boton).codigo);\r			enviaSICC(\"frmFormulario\");\r		}\r	}\r\r    function accionEliminarGrupo(boton)\r	{   \r\r        if (get('frmFormulario.hidNroGrupos') == 1){\r	      \r		  if (get('frmFormulario.hidNroPaquetes' ) == 1 ){\r		    GestionarMensaje(\"184\");\r			return;\r		  } else \r		  {\r		    if (get('frmFormulario.hidNroCondicionantes' ) == 1|| get('frmFormulario.hidNroCondicionantes' ) == 1){\r		      GestionarMensaje(\"183\");\r			  return;\r		    }\r			else{\r			  GestionarMensaje(\"183a\");\r			  return;\r			}\r	      }	   \r		}	   \r		else\r		{\r		  set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r          set(\"frmFormulario.accion\", \"EliminarGrupo\");\r          set(\"frmFormulario.hidNroGrupo\", eval(boton).codigo);\r          enviaSICC(\"frmFormulario\");\r	    }\r	}\r\r\r	function accionAniadirVentaExclusiva(){ \r      if (fValidarCOMBO(\"frmFormulario.cbTipoCliente\")&&\r          fValidarCOMBO(\"frmFormulario.cbSubTipoCliente\")&&\r          fValidarCOMBO(\"frmFormulario.cbTipoClasificacionCliente\")&&\r          fValidarCOMBO(\"frmFormulario.cbClasificacionCliente\")&&\r          fValidarCOMBO(\"frmFormulario.cbEstatusCliente\")&&          \r          fValidarCTEXT(\"frmFormulario.txtEstatus2Cliente\")){\r            set('frmFormulario.hDesTipoCliente',get('frmFormulario.cbTipoCliente','T'));\r            set('frmFormulario.hDesSubtipoCliente',get('frmFormulario.cbSubTipoCliente','T'));\r            set('frmFormulario.hDesTipoClasificacion',get('frmFormulario.cbTipoClasificacionCliente','T'));\r            set('frmFormulario.hDesClasificacion',get('frmFormulario.cbClasificacionCliente','T'));\r            set('frmFormulario.hDesEstatusCliente',get('frmFormulario.cbEstatusCliente','T'));\r			set('frmFormulario.txtEstatus2',get('frmFormulario.txtEstatus2Cliente'));\r\r            set(\"frmFormulario.conectorAction\", 'LPModificarOferta');      \r            set('frmFormulario.accion','aniadirVentaExclusiva');\r            enviaSICC('frmFormulario');\r      }        \r	}\r\r	function accionEliminarVentaExclusiva(){\r      if (listado5.numSelecc()>0){\r          if(GestionarMensaje(\"5\")){\r              set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r              set(\"frmFormulario.accion\", \"eliminarVentaExclusiva\");\r              set('frmFormulario.frmFormulario',listado5.codSeleccionados());\r              enviaSICC('frmFormulario');\r          }\r      } \r  }\r\r	function che(){\r           if ((get('frmFormulario.ckVentaExclusiva4')=='S')){   \r                deshabilitarHabilitarBoton('botonContenido','btnAnadir5','A')\r                accion('frmFormulario.cbTipoCliente','.disabled=false');\r                accion('frmFormulario.cbSubTipoCliente','.disabled=false');\r                accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');\r                accion('frmFormulario.cbClasificacionCliente','.disabled=false');\r                accion('frmFormulario.cbEstatusCliente','.disabled=false');\r                accion('frmFormulario.txtEstatus2Cliente','.disabled=false');\r            }\r            else if ((get('frmFormulario.ckVentaExclusiva4')=='N')){\r                accion('frmFormulario.cbTipoCliente','.disabled=true');\r                accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r                accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r                accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r                accion('frmFormulario.cbEstatusCliente','.disabled=true');\r                accion('frmFormulario.txtEstatus2Cliente','.disabled=true');                \r                deshabilitarHabilitarBoton('botonContenido','btnAnadir5','D')\r            }\r    }\r	\r	function deshabilitaTodo()\r	{   \r		visibilidad('capaEliminar','O');\r		visibilidad('btnAnadir5','O');\r		accion('frmFormulario.cbArgumentoVenta','.disabled=true');\r		accion('frmFormulario.txtNumeroOrden','.disabled=true');		\r		accion('frmFormulario.txtNumeroGrupos','.disabled=true');\r		accion('frmFormulario.txtNumeroPaquetes','.disabled=true');\r		accion('frmFormulario.cbIndicadorCuadre','.disabled=true');\r		accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');\r		\r		accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');		\r        document.all.rbCondicionCondicionantes[0].disabled=true;\r        document.all.rbCondicionCondicionantes[1].disabled=true;\r        document.all.rbCondicionCondicionados[0].disabled=true; \r        document.all.rbCondicionCondicionados[1].disabled=true;  \r        \r		accion('frmFormulario.cbFormasPago','.disabled=true');\r		accion('frmFormulario.ckDespachoCompleto','.disabled=true');\r		accion('frmFormulario.ckDespachoAutomatico','.disabled=true');		\r		accion('frmFormulario.ckVentaExclusiva4','.disabled=true');\r		accion('frmFormulario.cbTipoCliente','.disabled=true');\r		accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r		accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r		accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r		accion('frmFormulario.cbEstatusCliente','.disabled=true');\r		accion('frmFormulario.txtEstatus2Cliente','.disabled=true');	\r        }\r        \r		  function tipoClienteOnChange(){\r             accion('frmFormulario.cbSubTipoCliente','.disabled=false');\r             recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', \r                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoCliente')));\r                           \r                        set('frmFormulario.cbTipoClasificacionCliente','');\r            accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r\r            set('frmFormulario.cbClasificacionCliente','');\r            accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r           }\r           \r           function subtipoClienteOnChange(){\r              accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');\r              recargaCombo('frmFormulario.cbTipoClasificacionCliente', 'MAEobtenerTipoClasificacion', \r                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')));\r           }\r           \r           function tipoClasificacionOnChange(){\r              accion('frmFormulario.cbClasificacionCliente','.disabled=false');\r              recargaCombo('frmFormulario.cbClasificacionCliente', 'MAEobtenerClasificacionesPorTipo', \r                           'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoClasificacionCliente')));\r           }\r\r           \r           \r           function posicionaCombos(){\r		        array = new Array();\r                array[0] = get('frmFormulario.hFormaPago');\r                set('frmFormulario.cbFormasPago',array);\r                array = new Array();\r                array[0] = get('frmFormulario.hIndCuadre');\r                set('frmFormulario.cbIndicadorCuadre',array);\r                array = new Array();\r                array[0] = get('frmFormulario.hidOidArgVenta');\r                set('frmFormulario.cbArgumentoVenta',array);\r                if (!get('frmFormulario.hValorError') == 'PRE0011'){\r                    focaliza('frmFormulario.cbArgumentoVenta','');\r                }\r             \r                \r           }\r\r           function posicionaRadioButtons(){\r               set('frmFormulario.rbCondicionCondicionantes', get('frmFormulario.hidRDCondicionantes')); \r	  	       set('frmFormulario.rbCondicionCondicionados', get('frmFormulario.hidRDCondicionados'));		\r           }\r           \r           function configuraPantalla(){\r              accion('frmFormulario.txtNumeroGrupos','.disabled=true');\r              accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');\r              accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');\r              accion('frmFormulario.txtNumeroPaquetes','.disabled=true');\r\r     \r              if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='N'){\r                  accion('frmFormulario.cbIndicadorCuadre','.disabled=true');  \r              }\r              \r              if (get('frmFormulario.btnBPAsoc')=='true'){\r                  document.all[\"Buscar2Div\"].style.visibility='visible'\r              }else{\r                  document.all[\"Buscar2Div\"].style.visibility='hidden'\r              }\r			                \r                           if (get('frmFormulario.hidECondicionada')=='N'){\r                  accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');  \r                  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');\r                  document.all.rbCondicionCondicionantes[0].disabled=true;\r                  document.all.rbCondicionCondicionantes[1].disabled=true;\r                  document.all.rbCondicionCondicionados[0].disabled=true; \r                  document.all.rbCondicionCondicionados[1].disabled=true;  \r              }else{\r                  accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=false');  \r                  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=false');\r                  document.all.rbCondicionCondicionantes[0].disabled=false;\r                  document.all.rbCondicionCondicionantes[1].disabled=false;\r                  document.all.rbCondicionCondicionados[0].disabled=false; \r                  document.all.rbCondicionCondicionados[1].disabled=false;\r              }\r\r                          if (get('frmFormulario.hidEstrategiaVS')=='N'){\r                  document.all.rbCondicionCondicionantes[0].disabled=true;\r                  document.all.rbCondicionCondicionantes[1].disabled=true;\r                  document.all.rbCondicionCondicionados[0].disabled=true; \r                  document.all.rbCondicionCondicionados[1].disabled=true;\r              }else{\r                  document.all.rbCondicionCondicionantes[0].disabled=false;\r                  document.all.rbCondicionCondicionantes[1].disabled=false;\r                  document.all.rbCondicionCondicionados[0].disabled=false; \r                  document.all.rbCondicionCondicionados[1].disabled=false;\r              }\r\r             if (get('frmFormulario.hidHabiDesAutomatico')=='N'){\r                  accion('frmFormulario.ckDespachoAutomatico','.disabled=true');\r             }\r              \r/*\r              \r              accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r              accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r              accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r           */}\r\r        \r           function fGuardar(){\r           \r				if (fValidarCOMBO('frmFormulario.cbArgumentoVenta')){\r                    set('frmFormulario.hidOidArgumentoVenta', get('frmFormulario.cbArgumentoVenta'));\r                }    \r                else{\r                     GestionarMensaje('709');\r                     focaliza('frmFormulario.cbArgumentoVenta','');\r                }\r\r                                \r                if ( ( get('frmFormulario.txtNumeroOrden')!=\"\" )  ){\r                    if(esNumero(get('frmFormulario.txtNumeroOrden'))=='OK'){\r                        set('frmFormulario.hidNroOrden', get('frmFormulario.txtNumeroOrden'));                    \r                    }else{                    \r                        GestionarMensaje('1533');\r                        focaliza('frmFormulario.txtNumeroOrden');\r                        return;\r                    }\r                }else{                    \r                    GestionarMensaje('1533');\r                    focaliza('frmFormulario.txtNumeroOrden');\r                    return;\r                }\r           \r                if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='S'){\r                    if (fValidarCOMBO(\"frmFormulario.cbIndicadorCuadre\")){\r                        set('frmFormulario.hidOidIndicadorCuadre',get('frmFormulario.cbIndicadorCuadre'));\r                    }else{\r                        GestionarMensaje('1532');\r                    }\r                }\r                  \r                if( get('frmFormulario.hidECondicionada')=='S' ){\r                \r                    if( get(frmFormulario.rbCondicionCondicionantes)!=\"\" ){\r                        set('frmFormulario.hidRDCondicionantes',get('frmFormulario.rbCondicionCondicionantes'));\r\r                    }else{\r                        GestionarMensaje('721');\r                        return;\r                     }\r                \r\r                    if( get('frmFormulario.rbCondicionCondicionados')!=\"\" ){\r                        set('frmFormulario.hidRDCondicionados',get('frmFormulario.rbCondicionCondicionados'));\r\r                     }else{\r						  GestionarMensaje('722');\r	                      return;\r                        }\r                    					\r					if( get('frmFormulario.txtNumeroGruposCondicionantes')!=\"\" && (get('frmFormulario.hidECondicionada')=='S') ){\r                        set('frmFormulario.hidGruposCnantes',get('frmFormulario.txtNumeroGruposCondicionantes'));\r\r                    }else{\r                               }\r\r                    if( get('frmFormulario.txtNumeroGruposCondicionados')!=\"\" ){\r                        set('frmFormulario.hidGruposCnados',get('frmFormulario.txtNumeroGruposCondicionados'));\r\r                    }else{\r                                 }\r			\r                }\r           \r                if (get('frmFormulario.hidEstrategiaVS')=='S'){\r                    		            if (get('frmFormulario.rbCondicionCondicionantes')==\"\"){\r                         GestionarMensaje('721');\r                         return;\r                    }else{\r		                 set('frmFormulario.hidRBCondicionCondicionantes', get('frmFormulario.rbCondicionCondicionantes'));                       \r                    }\r                    if (get('frmFormulario.rbCondicionCondicionados')==\"\"){\r                       GestionarMensaje('722');\r                       return;\r                    }else{					\r                        set('frmFormulario.hidRBCondicionCondicionados', get('frmFormulario.rbCondicionCondicionados'));\r                    }\r                }\r\r               if (get('frmFormulario.hidHabiDesCompleto')=='S'){\r                     set(set('frmFormulario.hidCKDespachoCompleto'), get('frmFormulario.ckDespachoCompleto'));\r                }\r\r                if (get('frmFormulario.hidHabiDesAutomatico')=='S'){\r                    set('frmFormulario.hidCKDespachoAutomatico', get('frmFormulario.ckDespachoAutomatico'));\r                }\r\r                if (get('frmFormulario.ckVentaExclusiva4')=='S'){                    if (listado3.datos.length<1){\r                        GestionarMensaje('2524');\r                        return;\r                    }\r                }\r				\r                set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                set(\"frmFormulario.accion\", \"Guardar\");\r                enviaSICC(\"frmFormulario\");\r           }\r\r\r\r           \r           function recargaCombo(combo, idBusiness, dto, parametros) {\r                asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',\r                  formarCadena(idBusiness, dto, parametros)]]);\r           }\r           function formarCadena(idBusiness , dto, parametros) {\r                var cadena = idBusiness + \"|\" + dto + \"|\"; \r                for(i=0;i<parametros.length;i++) {\r                    cadena += parametros[i][0] + \"=\" + parametros[i][1];\r                    if (i!= parametros.length-1) {\r                        cadena += \"&\";\r                     }\r                }\r               return cadena;\r          }\r          \r          function makeParameter(nombre, oid){\r              var array = new Array();\r              var i=0;\r              array[i] = new Array('oidPais','1');\r              i++;\r              array[i] = new Array('oidIdioma','1');\r              i++;\r              array[i] = new Array(nombre,oid)\r              return array;\r          }\r\r        function fLimpiar(){\r            /*set(\"frmFormulario.hidNroCondicion\", '1');            \r              set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r              set(\"frmFormulario.accion\", \"ModificarCondicion\");\r              enviaSICC(\"frmFormulario\");\r            */\r        }\r	\r\r\r\r		function fVolver(){\r			window.close();\r			set('frmFormulario.casoDeUso','consultar');\r		}\r\r\r   \r"));
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
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
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
      ((Element)v.get(10)).setAttribute("nombre","oidOferta" );
      ((Element)v.get(10)).setAttribute("valor","378" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","cadenaLineaPromocion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","cadenaProductosGrupo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","cadenaVentaExclusiva" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","cadenaProductoPrincipal" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","deshabilitar" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidOidCabeceraMF" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","btnBPAsoc" );
      ((Element)v.get(17)).setAttribute("valor","false" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hDesTipoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hDesSubtipoCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hDesTipoClasificacion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hDesClasificacion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hDesEstatusCliente" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","txtEstatus2" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidOidArgVenta" );
      ((Element)v.get(24)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hIndCuadre" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hFormaPago" );
      ((Element)v.get(26)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidCKDespachoAutomatico" );
      ((Element)v.get(27)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidCKDespachoCompleto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidGruposCnantes" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidGruposCnados" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidRDCondicionados" );
      ((Element)v.get(31)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidRDCondicionantes" );
      ((Element)v.get(32)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidOidIndicadorCuadre" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidNroOrden" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidOidArgumentoVenta" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidDespachoCompleto" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidDespachoAutomatico" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hOidCondicion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidOidGrupo" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hNombreListas" );
      ((Element)v.get(40)).setAttribute("valor","listado30|listado41" );
      ((Element)v.get(6)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hDeshabilitaTodo" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hValorError" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidHabilitaIndicadorCuadre" );
      ((Element)v.get(43)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidECondicionada" );
      ((Element)v.get(44)).setAttribute("valor","N" );
      ((Element)v.get(6)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidEstrategiaVS" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidHabiDesAutomatico" );
      ((Element)v.get(46)).setAttribute("valor","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidHabiDesCompleto" );
      ((Element)v.get(47)).setAttribute("valor","N" );
      ((Element)v.get(6)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","LPRegreso" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidNroGrupo" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidNroCondicion" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","maxGrupo" );
      ((Element)v.get(51)).setAttribute("valor","4" );
      ((Element)v.get(6)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","maxGruposCondicionantes" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","maxGruposCondicionados" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","nroPromociones" );
      ((Element)v.get(54)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidNroGrupos" );
      ((Element)v.get(55)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidNroPaquetes" );
      ((Element)v.get(56)).setAttribute("valor","1" );
      ((Element)v.get(6)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidNroCondicionados" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidNroCondicionantes" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("height","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","750" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","1" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:60   */

      /* Empieza nodo:67 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(72)).setAttribute("class","legend" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblDatosOferta" );
      ((Element)v.get(73)).setAttribute("ancho","120" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","legend" );
      ((Element)v.get(73)).setAttribute("cod","00113" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(82)).setAttribute("ancho","60" );
      ((Element)v.get(82)).setAttribute("alto","17" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","10" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(86)).setAttribute("ancho","75" );
      ((Element)v.get(86)).setAttribute("alto","17" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","122" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(90)).setAttribute("ancho","90" );
      ((Element)v.get(90)).setAttribute("alto","17" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","528" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblNumeroOrden" );
      ((Element)v.get(94)).setAttribute("ancho","75" );
      ((Element)v.get(94)).setAttribute("alto","17" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","486" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:78   */

      /* Empieza nodo:97 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblAccesoXX" );
      ((Element)v.get(101)).setAttribute("ancho","200" );
      ((Element)v.get(101)).setAttribute("alto","17" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","BelCenter" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblSubaccesoXX" );
      ((Element)v.get(105)).setAttribute("ancho","200" );
      ((Element)v.get(105)).setAttribute("alto","17" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","Local Wilson VD BL" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","cbArgumentoVenta" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("size","1" );
      ((Element)v.get(109)).setAttribute("multiple","N" );
      ((Element)v.get(109)).setAttribute("req","N" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(110)).setAttribute("ID","DTOSalida.argumentosventa_ROWSET" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(112)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(112)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(112)).setAttribute("LONGITUD","50" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(114)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(114)).setAttribute("LONGITUD","50" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(116)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(116)).setAttribute("LONGITUD","50" );
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Elemento padre:116 / Elemento actual: 117   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(116)).appendChild((Text)v.get(117));

      /* Termina nodo Texto:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(118)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(118)).setAttribute("LONGITUD","50" );
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("1234"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */
      /* Termina nodo:111   */

      /* Empieza nodo:120 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(121)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(121)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(121)).setAttribute("LONGITUD","50" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(123)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(123)).setAttribute("LONGITUD","50" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(125)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(125)).setAttribute("LONGITUD","50" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Elemento padre:125 / Elemento actual: 126   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(125)).appendChild((Text)v.get(126));

      /* Termina nodo Texto:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 120   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(127)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(127)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(127)).setAttribute("LONGITUD","50" );
      ((Element)v.get(120)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode("1235"));
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */
      /* Termina nodo:120   */

      /* Empieza nodo:129 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(130)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(130)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(130)).setAttribute("LONGITUD","50" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Elemento padre:130 / Elemento actual: 131   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(130)).appendChild((Text)v.get(131));

      /* Termina nodo Texto:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(132)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(132)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(132)).setAttribute("LONGITUD","50" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(134)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(134)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(134)).setAttribute("LONGITUD","50" );
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(136)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(136)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(136)).setAttribute("LONGITUD","50" );
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("1236"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */
      /* Termina nodo:129   */

      /* Empieza nodo:138 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(139)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(139)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(139)).setAttribute("LONGITUD","50" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Elemento padre:139 / Elemento actual: 140   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(139)).appendChild((Text)v.get(140));

      /* Termina nodo Texto:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(141)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(141)).setAttribute("LONGITUD","50" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Elemento padre:141 / Elemento actual: 142   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(141)).appendChild((Text)v.get(142));

      /* Termina nodo Texto:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(143)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(143)).setAttribute("LONGITUD","50" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Elemento padre:143 / Elemento actual: 144   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(143)).appendChild((Text)v.get(144));

      /* Termina nodo Texto:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 138   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(145)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(145)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(145)).setAttribute("LONGITUD","50" );
      ((Element)v.get(138)).appendChild((Element)v.get(145));

      /* Elemento padre:145 / Elemento actual: 146   */
      v.add(doc.createTextNode("1237"));
      ((Element)v.get(145)).appendChild((Text)v.get(146));

      /* Termina nodo Texto:146   */
      /* Termina nodo:145   */
      /* Termina nodo:138   */

      /* Empieza nodo:147 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(148)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(148)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(148)).setAttribute("LONGITUD","50" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(150)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(150)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(150)).setAttribute("LONGITUD","50" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(152)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(152)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(152)).setAttribute("LONGITUD","50" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 147   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(154)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(154)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(154)).setAttribute("LONGITUD","50" );
      ((Element)v.get(147)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("1238"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */
      /* Termina nodo:147   */

      /* Empieza nodo:156 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(157)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(157)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(157)).setAttribute("LONGITUD","50" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(159)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(159)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(159)).setAttribute("LONGITUD","50" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(161)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(161)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(161)).setAttribute("LONGITUD","50" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(163)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(163)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(163)).setAttribute("LONGITUD","50" );
      ((Element)v.get(156)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("1239"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */
      /* Termina nodo:156   */

      /* Empieza nodo:165 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(166)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(166)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(166)).setAttribute("LONGITUD","50" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Elemento padre:166 / Elemento actual: 167   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(166)).appendChild((Text)v.get(167));

      /* Termina nodo Texto:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(168)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(168)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(168)).setAttribute("LONGITUD","50" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Elemento padre:168 / Elemento actual: 169   */
      v.add(doc.createTextNode("PRE-ArgVent1"));
      ((Element)v.get(168)).appendChild((Text)v.get(169));

      /* Termina nodo Texto:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(170)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(170)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(170)).setAttribute("LONGITUD","50" );
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Elemento padre:170 / Elemento actual: 171   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(170)).appendChild((Text)v.get(171));

      /* Termina nodo Texto:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 165   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(172)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(172)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(172)).setAttribute("LONGITUD","50" );
      ((Element)v.get(165)).appendChild((Element)v.get(172));

      /* Elemento padre:172 / Elemento actual: 173   */
      v.add(doc.createTextNode("1240"));
      ((Element)v.get(172)).appendChild((Text)v.get(173));

      /* Termina nodo Texto:173   */
      /* Termina nodo:172   */
      /* Termina nodo:165   */

      /* Empieza nodo:174 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(175)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(175)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(175)).setAttribute("LONGITUD","50" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Elemento padre:175 / Elemento actual: 176   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(175)).appendChild((Text)v.get(176));

      /* Termina nodo Texto:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(177)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(177)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(177)).setAttribute("LONGITUD","50" );
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Elemento padre:177 / Elemento actual: 178   */
      v.add(doc.createTextNode("PRE-ArgVent2"));
      ((Element)v.get(177)).appendChild((Text)v.get(178));

      /* Termina nodo Texto:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(179)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(179)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(179)).setAttribute("LONGITUD","50" );
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Elemento padre:179 / Elemento actual: 180   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(179)).appendChild((Text)v.get(180));

      /* Termina nodo Texto:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(181)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(181)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(181)).setAttribute("LONGITUD","50" );
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("1241"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */
      /* Termina nodo:174   */

      /* Empieza nodo:183 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(184)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(184)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(184)).setAttribute("LONGITUD","50" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("9"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(186)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(186)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(186)).setAttribute("LONGITUD","50" );
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("PRE-ArgVent3"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(188)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(188)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(188)).setAttribute("LONGITUD","50" );
      ((Element)v.get(183)).appendChild((Element)v.get(188));

      /* Elemento padre:188 / Elemento actual: 189   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(188)).appendChild((Text)v.get(189));

      /* Termina nodo Texto:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(190)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(190)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(190)).setAttribute("LONGITUD","50" );
      ((Element)v.get(183)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("1242"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */
      /* Termina nodo:183   */

      /* Empieza nodo:192 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(193)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(193)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(193)).setAttribute("LONGITUD","50" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("10"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(195)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(195)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(195)).setAttribute("LONGITUD","50" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Elemento padre:195 / Elemento actual: 196   */
      v.add(doc.createTextNode("PRE-ArgVent4"));
      ((Element)v.get(195)).appendChild((Text)v.get(196));

      /* Termina nodo Texto:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(197)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(197)).setAttribute("LONGITUD","50" );
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Elemento padre:197 / Elemento actual: 198   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(197)).appendChild((Text)v.get(198));

      /* Termina nodo Texto:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 192   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(199)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(199)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(199)).setAttribute("LONGITUD","50" );
      ((Element)v.get(192)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("1243"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */
      /* Termina nodo:192   */

      /* Empieza nodo:201 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(202)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(202)).setAttribute("LONGITUD","50" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Elemento padre:202 / Elemento actual: 203   */
      v.add(doc.createTextNode("11"));
      ((Element)v.get(202)).appendChild((Text)v.get(203));

      /* Termina nodo Texto:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(204)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(204)).setAttribute("LONGITUD","50" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("PRE-ArgVent5"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(206)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(206)).setAttribute("LONGITUD","50" );
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(208)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(208)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(208)).setAttribute("LONGITUD","50" );
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("1244"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */
      /* Termina nodo:201   */

      /* Empieza nodo:210 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(211)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(211)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(211)).setAttribute("LONGITUD","50" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Elemento padre:211 / Elemento actual: 212   */
      v.add(doc.createTextNode("12"));
      ((Element)v.get(211)).appendChild((Text)v.get(212));

      /* Termina nodo Texto:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(213)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(213)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(213)).setAttribute("LONGITUD","50" );
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Elemento padre:213 / Elemento actual: 214   */
      v.add(doc.createTextNode("PRE-ArgVent6"));
      ((Element)v.get(213)).appendChild((Text)v.get(214));

      /* Termina nodo Texto:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(215)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(215)).setAttribute("LONGITUD","50" );
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Elemento padre:215 / Elemento actual: 216   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(215)).appendChild((Text)v.get(216));

      /* Termina nodo Texto:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(217)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(217)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(217)).setAttribute("LONGITUD","50" );
      ((Element)v.get(210)).appendChild((Element)v.get(217));

      /* Elemento padre:217 / Elemento actual: 218   */
      v.add(doc.createTextNode("1245"));
      ((Element)v.get(217)).appendChild((Text)v.get(218));

      /* Termina nodo Texto:218   */
      /* Termina nodo:217   */
      /* Termina nodo:210   */

      /* Empieza nodo:219 / Elemento padre: 110   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(110)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(220)).setAttribute("NOMBRE","OID_ARGU_VENT" );
      ((Element)v.get(220)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(220)).setAttribute("LONGITUD","50" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Elemento padre:220 / Elemento actual: 221   */
      v.add(doc.createTextNode("13"));
      ((Element)v.get(220)).appendChild((Text)v.get(221));

      /* Termina nodo Texto:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(222)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(222)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(222)).setAttribute("LONGITUD","50" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Elemento padre:222 / Elemento actual: 223   */
      v.add(doc.createTextNode("PRE-ArgVent7"));
      ((Element)v.get(222)).appendChild((Text)v.get(223));

      /* Termina nodo Texto:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(224)).setAttribute("NOMBRE","TIES_OID_TIPO_ESTR" );
      ((Element)v.get(224)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(224)).setAttribute("LONGITUD","50" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Elemento padre:224 / Elemento actual: 225   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(224)).appendChild((Text)v.get(225));

      /* Termina nodo Texto:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 219   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(226)).setAttribute("NOMBRE","COD_ARGU_VENT" );
      ((Element)v.get(226)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(226)).setAttribute("LONGITUD","50" );
      ((Element)v.get(219)).appendChild((Element)v.get(226));

      /* Elemento padre:226 / Elemento actual: 227   */
      v.add(doc.createTextNode("1246"));
      ((Element)v.get(226)).appendChild((Text)v.get(227));

      /* Termina nodo Texto:227   */
      /* Termina nodo:226   */
      /* Termina nodo:219   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:228 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","25" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(231)).setAttribute("nombre","txtNumeroOrden" );
      ((Element)v.get(231)).setAttribute("id","datosCampos" );
      ((Element)v.get(231)).setAttribute("max","6" );
      ((Element)v.get(231)).setAttribute("tipo","" );
      ((Element)v.get(231)).setAttribute("onchange","" );
      ((Element)v.get(231)).setAttribute("req","N" );
      ((Element)v.get(231)).setAttribute("size","6" );
      ((Element)v.get(231)).setAttribute("valor","14" );
      ((Element)v.get(231)).setAttribute("validacion","" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("width","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","1" );
      ((Element)v.get(235)).setAttribute("height","1" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:97   */

      /* Empieza nodo:236 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(236));

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
      /* Termina nodo:74   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:239 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:67   */

      /* Empieza nodo:241 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(242)).setAttribute("align","center" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("height","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","756" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 241   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","12" );
      ((Element)v.get(247)).setAttribute("height","1" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:241   */
      /* Termina nodo:59   */

      /* Empieza nodo:248 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(248)).setAttribute("nombre","capaProductoPrincipal" );
      ((Element)v.get(248)).setAttribute("alto","30" );
      ((Element)v.get(248)).setAttribute("ancho","100%" );
      ((Element)v.get(248)).setAttribute("colorf","" );
      ((Element)v.get(248)).setAttribute("borde","0" );
      ((Element)v.get(248)).setAttribute("imagenf","" );
      ((Element)v.get(248)).setAttribute("repeat","" );
      ((Element)v.get(248)).setAttribute("padding","" );
      ((Element)v.get(248)).setAttribute("visibilidad","visible" );
      ((Element)v.get(248)).setAttribute("contravsb","" );
      ((Element)v.get(248)).setAttribute("x","0" );
      ((Element)v.get(248)).setAttribute("y","98" );
      ((Element)v.get(248)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("table"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("align","center" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","1" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","750" );
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","5" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:250   */

      /* Empieza nodo:257 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("align","center" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(264)).setAttribute("valign","middle" );
      ((Element)v.get(264)).setAttribute("width","4" );
      ((Element)v.get(264)).setAttribute("height","4" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","5" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(266)).setAttribute("valign","middle" );
      ((Element)v.get(266)).setAttribute("height","20" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lbltitulo1" );
      ((Element)v.get(267)).setAttribute("ancho","666" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","579" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:268 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","12" );
      ((Element)v.get(269)).setAttribute("height","12" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:257   */

      /* Empieza nodo:270 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("height","1" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","750" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","5" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:270   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:277 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(277)).setAttribute("nombre","listado1" );
      ((Element)v.get(277)).setAttribute("ancho","677" );
      ((Element)v.get(277)).setAttribute("alto","290" );
      ((Element)v.get(277)).setAttribute("x","12" );
      ((Element)v.get(277)).setAttribute("y","127" );
      ((Element)v.get(277)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(277)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(278)).setAttribute("precarga","S" );
      ((Element)v.get(278)).setAttribute("conROver","S" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(279)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(279)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(279)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(279)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(280)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(280)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(280)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(280)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 277   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(277)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(282)).setAttribute("borde","1" );
      ((Element)v.get(282)).setAttribute("horizDatos","1" );
      ((Element)v.get(282)).setAttribute("horizCabecera","1" );
      ((Element)v.get(282)).setAttribute("vertical","0" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(283)).setAttribute("borde","#999999" );
      ((Element)v.get(283)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(283)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(283)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(283)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:281   */

      /* Empieza nodo:284 / Elemento padre: 277   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(284)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(284)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(284)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(284)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(284)).setAttribute("AnchoMinimizadas","20" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(277)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","100" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","60" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","100" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","100" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","120" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","100" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","100" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","100" );
      ((Element)v.get(292)).setAttribute("minimizable","S" );
      ((Element)v.get(292)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 284   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","100" );
      ((Element)v.get(293)).setAttribute("minimizable","S" );
      ((Element)v.get(293)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:284   */

      /* Empieza nodo:294 / Elemento padre: 277   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(294)).setAttribute("alto","20" );
      ((Element)v.get(294)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(294)).setAttribute("imgFondo","" );
      ((Element)v.get(294)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(277)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Elemento padre:295 / Elemento actual: 296   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(295)).appendChild((Text)v.get(296));

      /* Termina nodo Texto:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","9" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Elemento padre:297 / Elemento actual: 298   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(297)).appendChild((Text)v.get(298));

      /* Termina nodo Texto:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("colFondo","" );
      ((Element)v.get(299)).setAttribute("ID","EstCab" );
      ((Element)v.get(299)).setAttribute("cod","608" );
      ((Element)v.get(294)).appendChild((Element)v.get(299));

      /* Elemento padre:299 / Elemento actual: 300   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(299)).appendChild((Text)v.get(300));

      /* Termina nodo Texto:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("colFondo","" );
      ((Element)v.get(301)).setAttribute("ID","EstCab" );
      ((Element)v.get(301)).setAttribute("cod","581" );
      ((Element)v.get(294)).appendChild((Element)v.get(301));

      /* Elemento padre:301 / Elemento actual: 302   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(301)).appendChild((Text)v.get(302));

      /* Termina nodo Texto:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("colFondo","" );
      ((Element)v.get(303)).setAttribute("ID","EstCab" );
      ((Element)v.get(303)).setAttribute("cod","529" );
      ((Element)v.get(294)).appendChild((Element)v.get(303));

      /* Elemento padre:303 / Elemento actual: 304   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(303)).appendChild((Text)v.get(304));

      /* Termina nodo Texto:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("colFondo","" );
      ((Element)v.get(305)).setAttribute("ID","EstCab" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(305)).setAttribute("cod","530" );
      ((Element)v.get(294)).appendChild((Element)v.get(305));

      /* Elemento padre:305 / Elemento actual: 306   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(305)).appendChild((Text)v.get(306));

      /* Termina nodo Texto:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("colFondo","" );
      ((Element)v.get(307)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).setAttribute("cod","481" );
      ((Element)v.get(294)).appendChild((Element)v.get(307));

      /* Elemento padre:307 / Elemento actual: 308   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(307)).appendChild((Text)v.get(308));

      /* Termina nodo Texto:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("colFondo","" );
      ((Element)v.get(309)).setAttribute("ID","EstCab" );
      ((Element)v.get(309)).setAttribute("cod","482" );
      ((Element)v.get(294)).appendChild((Element)v.get(309));

      /* Elemento padre:309 / Elemento actual: 310   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(309)).appendChild((Text)v.get(310));

      /* Termina nodo Texto:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 294   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","483" );
      ((Element)v.get(294)).appendChild((Element)v.get(311));

      /* Elemento padre:311 / Elemento actual: 312   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(311)).appendChild((Text)v.get(312));

      /* Termina nodo Texto:312   */
      /* Termina nodo:311   */
      /* Termina nodo:294   */

      /* Empieza nodo:313 / Elemento padre: 277   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(313)).setAttribute("alto","22" );
      ((Element)v.get(313)).setAttribute("accion","" );
      ((Element)v.get(313)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(313)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(313)).setAttribute("maxSel","-1" );
      ((Element)v.get(313)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(313)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(313)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(313)).setAttribute("onLoad","" );
      ((Element)v.get(313)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(277)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("tipo","texto" );
      ((Element)v.get(314)).setAttribute("ID","EstDat" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("tipo","texto" );
      ((Element)v.get(315)).setAttribute("ID","EstDat2" );
      ((Element)v.get(313)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("tipo","texto" );
      ((Element)v.get(316)).setAttribute("ID","EstDat" );
      ((Element)v.get(313)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat2" );
      ((Element)v.get(313)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(313)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat2" );
      ((Element)v.get(313)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(313)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat2" );
      ((Element)v.get(313)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 313   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat" );
      ((Element)v.get(313)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:313   */

      /* Empieza nodo:323 / Elemento padre: 277   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(277)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 277   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(324)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(324)).setAttribute("ancho","680" );
      ((Element)v.get(324)).setAttribute("sep","$" );
      ((Element)v.get(324)).setAttribute("x","12" );
      ((Element)v.get(324)).setAttribute("class","botonera" );
      ((Element)v.get(324)).setAttribute("y","378" );
      ((Element)v.get(324)).setAttribute("control","|" );
      ((Element)v.get(324)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(324)).setAttribute("rowset","" );
      ((Element)v.get(324)).setAttribute("cargainicial","N" );
      ((Element)v.get(277)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(325)).setAttribute("nombre","primera1" );
      ((Element)v.get(325)).setAttribute("x","77" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(325)).setAttribute("y","382" );
      ((Element)v.get(325)).setAttribute("ID","botonContenido" );
      ((Element)v.get(325)).setAttribute("img","primera_on" );
      ((Element)v.get(325)).setAttribute("tipo","0" );
      ((Element)v.get(325)).setAttribute("estado","false" );
      ((Element)v.get(325)).setAttribute("alt","" );
      ((Element)v.get(325)).setAttribute("codigo","" );
      ((Element)v.get(325)).setAttribute("accion","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 324   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(326)).setAttribute("nombre","ava1" );
      ((Element)v.get(326)).setAttribute("x","109" );
      ((Element)v.get(326)).setAttribute("y","382" );
      ((Element)v.get(326)).setAttribute("ID","botonContenido" );
      ((Element)v.get(326)).setAttribute("img","avanzar_on" );
      ((Element)v.get(326)).setAttribute("tipo","0" );
      ((Element)v.get(326)).setAttribute("estado","false" );
      ((Element)v.get(326)).setAttribute("alt","" );
      ((Element)v.get(326)).setAttribute("codigo","" );
      ((Element)v.get(326)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(324)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(327)).setAttribute("nombre","ret1" );
      ((Element)v.get(327)).setAttribute("x","94" );
      ((Element)v.get(327)).setAttribute("y","382" );
      ((Element)v.get(327)).setAttribute("ID","botonContenido" );
      ((Element)v.get(327)).setAttribute("img","retroceder_on" );
      ((Element)v.get(327)).setAttribute("tipo","0" );
      ((Element)v.get(327)).setAttribute("estado","false" );
      ((Element)v.get(327)).setAttribute("alt","" );
      ((Element)v.get(327)).setAttribute("codigo","" );
      ((Element)v.get(327)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(324)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:324   */
      /* Termina nodo:277   */

      /* Empieza nodo:328 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(328)).setAttribute("nombre","capaProductoAsociado" );
      ((Element)v.get(328)).setAttribute("alto","30" );
      ((Element)v.get(328)).setAttribute("ancho","100%" );
      ((Element)v.get(328)).setAttribute("colorf","" );
      ((Element)v.get(328)).setAttribute("borde","0" );
      ((Element)v.get(328)).setAttribute("imagenf","" );
      ((Element)v.get(328)).setAttribute("repeat","" );
      ((Element)v.get(328)).setAttribute("padding","" );
      ((Element)v.get(328)).setAttribute("visibilidad","visible" );
      ((Element)v.get(328)).setAttribute("contravsb","" );
      ((Element)v.get(328)).setAttribute("x","0" );
      ((Element)v.get(328)).setAttribute("y","436" );
      ((Element)v.get(328)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("table"));
      ((Element)v.get(329)).setAttribute("width","100%" );
      ((Element)v.get(329)).setAttribute("border","0" );
      ((Element)v.get(329)).setAttribute("align","center" );
      ((Element)v.get(329)).setAttribute("cellspacing","0" );
      ((Element)v.get(329)).setAttribute("cellpadding","0" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("align","center" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","12" );
      ((Element)v.get(332)).setAttribute("height","1" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","750" );
      ((Element)v.get(330)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","12" );
      ((Element)v.get(336)).setAttribute("height","5" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:330   */

      /* Empieza nodo:337 / Elemento padre: 329   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(329)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("fieldset"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("table"));
      ((Element)v.get(342)).setAttribute("width","100%" );
      ((Element)v.get(342)).setAttribute("border","0" );
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(342)).setAttribute("cellspacing","0" );
      ((Element)v.get(342)).setAttribute("cellpadding","0" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(344)).setAttribute("valign","middle" );
      ((Element)v.get(344)).setAttribute("width","4" );
      ((Element)v.get(344)).setAttribute("height","4" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","5" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(346)).setAttribute("valign","middle" );
      ((Element)v.get(346)).setAttribute("height","20" );
      ((Element)v.get(346)).setAttribute("width","100%" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lbltitulo2" );
      ((Element)v.get(347)).setAttribute("ancho","666" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("id","datosTitle" );
      ((Element)v.get(347)).setAttribute("cod","532" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:348 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","12" );
      ((Element)v.get(337)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","12" );
      ((Element)v.get(349)).setAttribute("height","12" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:337   */

      /* Empieza nodo:350 / Elemento padre: 329   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(329)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","12" );
      ((Element)v.get(351)).setAttribute("align","center" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","12" );
      ((Element)v.get(352)).setAttribute("height","1" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("width","750" );
      ((Element)v.get(350)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 350   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("width","12" );
      ((Element)v.get(350)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","12" );
      ((Element)v.get(356)).setAttribute("height","5" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:350   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:357 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(357)).setAttribute("nombre","listado2" );
      ((Element)v.get(357)).setAttribute("ancho","677" );
      ((Element)v.get(357)).setAttribute("alto","290" );
      ((Element)v.get(357)).setAttribute("x","12" );
      ((Element)v.get(357)).setAttribute("y","465" );
      ((Element)v.get(357)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(357)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(358)).setAttribute("precarga","S" );
      ((Element)v.get(358)).setAttribute("conROver","S" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(359)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(359)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(359)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(359)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 358   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(360)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(360)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(360)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(360)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:358   */

      /* Empieza nodo:361 / Elemento padre: 357   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(357)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(362)).setAttribute("borde","1" );
      ((Element)v.get(362)).setAttribute("horizDatos","1" );
      ((Element)v.get(362)).setAttribute("horizCabecera","1" );
      ((Element)v.get(362)).setAttribute("vertical","0" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 361   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(363)).setAttribute("borde","#999999" );
      ((Element)v.get(363)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(363)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(363)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(363)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(361)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 357   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(364)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(364)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(364)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(364)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(364)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(357)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("ancho","60" );
      ((Element)v.get(365)).setAttribute("minimizable","S" );
      ((Element)v.get(365)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("ancho","60" );
      ((Element)v.get(366)).setAttribute("minimizable","S" );
      ((Element)v.get(366)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("ancho","100" );
      ((Element)v.get(367)).setAttribute("minimizable","S" );
      ((Element)v.get(367)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("ancho","100" );
      ((Element)v.get(368)).setAttribute("minimizable","S" );
      ((Element)v.get(368)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("ancho","130" );
      ((Element)v.get(369)).setAttribute("minimizable","S" );
      ((Element)v.get(369)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("ancho","100" );
      ((Element)v.get(370)).setAttribute("minimizable","S" );
      ((Element)v.get(370)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","100" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","100" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 364   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","100" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","N" );
      ((Element)v.get(364)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:364   */

      /* Empieza nodo:374 / Elemento padre: 357   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(374)).setAttribute("alto","20" );
      ((Element)v.get(374)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(374)).setAttribute("imgFondo","" );
      ((Element)v.get(374)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(357)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(375)).setAttribute("cod","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Elemento padre:375 / Elemento actual: 376   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(375)).appendChild((Text)v.get(376));

      /* Termina nodo Texto:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(377)).setAttribute("cod","9" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Elemento padre:377 / Elemento actual: 378   */
      v.add(doc.createTextNode("Descripción"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(377)).appendChild((Text)v.get(378));

      /* Termina nodo Texto:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("colFondo","" );
      ((Element)v.get(379)).setAttribute("ID","EstCab" );
      ((Element)v.get(379)).setAttribute("cod","608" );
      ((Element)v.get(374)).appendChild((Element)v.get(379));

      /* Elemento padre:379 / Elemento actual: 380   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(379)).appendChild((Text)v.get(380));

      /* Termina nodo Texto:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("colFondo","" );
      ((Element)v.get(381)).setAttribute("ID","EstCab" );
      ((Element)v.get(381)).setAttribute("cod","581" );
      ((Element)v.get(374)).appendChild((Element)v.get(381));

      /* Elemento padre:381 / Elemento actual: 382   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(381)).appendChild((Text)v.get(382));

      /* Termina nodo Texto:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("colFondo","" );
      ((Element)v.get(383)).setAttribute("ID","EstCab" );
      ((Element)v.get(383)).setAttribute("cod","529" );
      ((Element)v.get(374)).appendChild((Element)v.get(383));

      /* Elemento padre:383 / Elemento actual: 384   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(383)).appendChild((Text)v.get(384));

      /* Termina nodo Texto:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("colFondo","" );
      ((Element)v.get(385)).setAttribute("ID","EstCab" );
      ((Element)v.get(385)).setAttribute("cod","530" );
      ((Element)v.get(374)).appendChild((Element)v.get(385));

      /* Elemento padre:385 / Elemento actual: 386   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(385)).appendChild((Text)v.get(386));

      /* Termina nodo Texto:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("colFondo","" );
      ((Element)v.get(387)).setAttribute("ID","EstCab" );
      ((Element)v.get(387)).setAttribute("cod","481" );
      ((Element)v.get(374)).appendChild((Element)v.get(387));

      /* Elemento padre:387 / Elemento actual: 388   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(387)).appendChild((Text)v.get(388));

      /* Termina nodo Texto:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("colFondo","" );
      ((Element)v.get(389)).setAttribute("ID","EstCab" );
      ((Element)v.get(389)).setAttribute("cod","482" );
      ((Element)v.get(374)).appendChild((Element)v.get(389));

      /* Elemento padre:389 / Elemento actual: 390   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(389)).appendChild((Text)v.get(390));

      /* Termina nodo Texto:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("colFondo","" );
      ((Element)v.get(391)).setAttribute("ID","EstCab" );
      ((Element)v.get(391)).setAttribute("cod","483" );
      ((Element)v.get(374)).appendChild((Element)v.get(391));

      /* Elemento padre:391 / Elemento actual: 392   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(391)).appendChild((Text)v.get(392));

      /* Termina nodo Texto:392   */
      /* Termina nodo:391   */
      /* Termina nodo:374   */

      /* Empieza nodo:393 / Elemento padre: 357   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(393)).setAttribute("alto","22" );
      ((Element)v.get(393)).setAttribute("accion","" );
      ((Element)v.get(393)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(393)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(393)).setAttribute("maxSel","-1" );
      ((Element)v.get(393)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(393)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(393)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(393)).setAttribute("onLoad","" );
      ((Element)v.get(393)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(357)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("tipo","texto" );
      ((Element)v.get(394)).setAttribute("ID","EstDat" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("tipo","texto" );
      ((Element)v.get(395)).setAttribute("ID","EstDat2" );
      ((Element)v.get(393)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("tipo","texto" );
      ((Element)v.get(396)).setAttribute("ID","EstDat" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */

      /* Empieza nodo:397 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("tipo","texto" );
      ((Element)v.get(397)).setAttribute("ID","EstDat2" );
      ((Element)v.get(393)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("tipo","texto" );
      ((Element)v.get(398)).setAttribute("ID","EstDat" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("tipo","texto" );
      ((Element)v.get(399)).setAttribute("ID","EstDat2" );
      ((Element)v.get(393)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("tipo","texto" );
      ((Element)v.get(400)).setAttribute("ID","EstDat" );
      ((Element)v.get(393)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 393   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("tipo","texto" );
      ((Element)v.get(401)).setAttribute("ID","EstDat2" );
      ((Element)v.get(393)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 393   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("tipo","texto" );
      ((Element)v.get(402)).setAttribute("ID","EstDat" );
      ((Element)v.get(393)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:393   */

      /* Empieza nodo:403 / Elemento padre: 357   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(357)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 357   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(404)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(404)).setAttribute("ancho","680" );
      ((Element)v.get(404)).setAttribute("sep","$" );
      ((Element)v.get(404)).setAttribute("x","12" );
      ((Element)v.get(404)).setAttribute("class","botonera" );
      ((Element)v.get(404)).setAttribute("y","717" );
      ((Element)v.get(404)).setAttribute("control","|" );
      ((Element)v.get(404)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(404)).setAttribute("rowset","" );
      ((Element)v.get(404)).setAttribute("cargainicial","N" );
      ((Element)v.get(357)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(405)).setAttribute("nombre","primera2" );
      ((Element)v.get(405)).setAttribute("x","77" );
      ((Element)v.get(405)).setAttribute("y","721" );
      ((Element)v.get(405)).setAttribute("ID","botonContenido" );
      ((Element)v.get(405)).setAttribute("img","primera_on" );
      ((Element)v.get(405)).setAttribute("tipo","0" );
      ((Element)v.get(405)).setAttribute("estado","false" );
      ((Element)v.get(405)).setAttribute("alt","" );
      ((Element)v.get(405)).setAttribute("codigo","" );
      ((Element)v.get(405)).setAttribute("accion","" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 404   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(406)).setAttribute("nombre","ava2" );
      ((Element)v.get(406)).setAttribute("x","109" );
      ((Element)v.get(406)).setAttribute("y","721" );
      ((Element)v.get(406)).setAttribute("ID","botonContenido" );
      ((Element)v.get(406)).setAttribute("img","avanzar_on" );
      ((Element)v.get(406)).setAttribute("tipo","0" );
      ((Element)v.get(406)).setAttribute("estado","false" );
      ((Element)v.get(406)).setAttribute("alt","" );
      ((Element)v.get(406)).setAttribute("codigo","" );
      ((Element)v.get(406)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(404)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 404   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(407)).setAttribute("nombre","ret2" );
      ((Element)v.get(407)).setAttribute("x","94" );
      ((Element)v.get(407)).setAttribute("y","721" );
      ((Element)v.get(407)).setAttribute("ID","botonContenido" );
      ((Element)v.get(407)).setAttribute("img","retroceder_on" );
      ((Element)v.get(407)).setAttribute("tipo","0" );
      ((Element)v.get(407)).setAttribute("estado","false" );
      ((Element)v.get(407)).setAttribute("alt","" );
      ((Element)v.get(407)).setAttribute("codigo","" );
      ((Element)v.get(407)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(404)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 404   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(408)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(408)).setAttribute("x","13" );
      ((Element)v.get(408)).setAttribute("y","717" );
      ((Element)v.get(408)).setAttribute("ID","botonContenido" );
      ((Element)v.get(408)).setAttribute("tipo","html" );
      ((Element)v.get(408)).setAttribute("estado","false" );
      ((Element)v.get(408)).setAttribute("cod","1" );
      ((Element)v.get(408)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(404)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:404   */
      /* Termina nodo:357   */

      /* Empieza nodo:409 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(409)).setAttribute("nombre","capaDatosGenerales" );
      ((Element)v.get(409)).setAttribute("alto","200" );
      ((Element)v.get(409)).setAttribute("ancho","100%" );
      ((Element)v.get(409)).setAttribute("colorf","" );
      ((Element)v.get(409)).setAttribute("borde","0" );
      ((Element)v.get(409)).setAttribute("imagenf","" );
      ((Element)v.get(409)).setAttribute("repeat","" );
      ((Element)v.get(409)).setAttribute("padding","" );
      ((Element)v.get(409)).setAttribute("visibilidad","visible" );
      ((Element)v.get(409)).setAttribute("contravsb","" );
      ((Element)v.get(409)).setAttribute("x","0" );
      ((Element)v.get(409)).setAttribute("y","762" );
      ((Element)v.get(409)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("table"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(410)).setAttribute("border","0" );
      ((Element)v.get(410)).setAttribute("cellspacing","0" );
      ((Element)v.get(410)).setAttribute("cellpadding","0" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).setAttribute("width","12" );
      ((Element)v.get(412)).setAttribute("align","center" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","12" );
      ((Element)v.get(413)).setAttribute("height","12" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("width","750" );
      ((Element)v.get(411)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(411)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","12" );
      ((Element)v.get(417)).setAttribute("height","1" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:411   */

      /* Empieza nodo:418 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 418   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(423)).setAttribute("class","legend" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(424)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(424)).setAttribute("ancho","120" );
      ((Element)v.get(424)).setAttribute("alto","13" );
      ((Element)v.get(424)).setAttribute("filas","1" );
      ((Element)v.get(424)).setAttribute("valor","" );
      ((Element)v.get(424)).setAttribute("id","legend" );
      ((Element)v.get(424)).setAttribute("cod","0011" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("table"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(425)).setAttribute("border","0" );
      ((Element)v.get(425)).setAttribute("align","center" );
      ((Element)v.get(425)).setAttribute("cellspacing","0" );
      ((Element)v.get(425)).setAttribute("cellpadding","0" );
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).setAttribute("colspan","4" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:429 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(433)).setAttribute("nombre","lblNumeroGrupos" );
      ((Element)v.get(433)).setAttribute("ancho","60" );
      ((Element)v.get(433)).setAttribute("alto","17" );
      ((Element)v.get(433)).setAttribute("filas","1" );
      ((Element)v.get(433)).setAttribute("valor","" );
      ((Element)v.get(433)).setAttribute("id","datosTitle" );
      ((Element)v.get(433)).setAttribute("cod","533" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","25" );
      ((Element)v.get(435)).setAttribute("height","8" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(437)).setAttribute("nombre","lblNumeroPaquetes" );
      ((Element)v.get(437)).setAttribute("ancho","75" );
      ((Element)v.get(437)).setAttribute("alto","17" );
      ((Element)v.get(437)).setAttribute("filas","1" );
      ((Element)v.get(437)).setAttribute("valor","" );
      ((Element)v.get(437)).setAttribute("id","datosTitle" );
      ((Element)v.get(437)).setAttribute("cod","534" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","25" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblIndicadorCuadre" );
      ((Element)v.get(441)).setAttribute("ancho","90" );
      ((Element)v.get(441)).setAttribute("alto","17" );
      ((Element)v.get(441)).setAttribute("filas","1" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(441)).setAttribute("id","datosTitle" );
      ((Element)v.get(441)).setAttribute("cod","461" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","25" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblNumeroGruposCondicionantes" );
      ((Element)v.get(445)).setAttribute("ancho","130" );
      ((Element)v.get(445)).setAttribute("alto","17" );
      ((Element)v.get(445)).setAttribute("filas","1" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("id","datosTitle" );
      ((Element)v.get(445)).setAttribute("cod","535" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("colspan","2" );
      ((Element)v.get(429)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(449)).setAttribute("nombre","lblCondicionCondicionantes" );
      ((Element)v.get(449)).setAttribute("ancho","90" );
      ((Element)v.get(449)).setAttribute("alto","17" );
      ((Element)v.get(449)).setAttribute("filas","1" );
      ((Element)v.get(449)).setAttribute("valor","" );
      ((Element)v.get(449)).setAttribute("id","datosTitle" );
      ((Element)v.get(449)).setAttribute("cod","536" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("width","100%" );
      ((Element)v.get(429)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:429   */

      /* Empieza nodo:452 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(452)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(456)).setAttribute("nombre","txtNumeroGrupos" );
      ((Element)v.get(456)).setAttribute("id","datosCampos" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(456)).setAttribute("max","6" );
      ((Element)v.get(456)).setAttribute("tipo","" );
      ((Element)v.get(456)).setAttribute("onchange","" );
      ((Element)v.get(456)).setAttribute("req","N" );
      ((Element)v.get(456)).setAttribute("size","6" );
      ((Element)v.get(456)).setAttribute("valor","1" );
      ((Element)v.get(456)).setAttribute("validacion","" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","25" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(452)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(460)).setAttribute("nombre","txtNumeroPaquetes" );
      ((Element)v.get(460)).setAttribute("id","datosCampos" );
      ((Element)v.get(460)).setAttribute("max","6" );
      ((Element)v.get(460)).setAttribute("tipo","" );
      ((Element)v.get(460)).setAttribute("onchange","" );
      ((Element)v.get(460)).setAttribute("req","N" );
      ((Element)v.get(460)).setAttribute("size","6" );
      ((Element)v.get(460)).setAttribute("valor","1" );
      ((Element)v.get(460)).setAttribute("validacion","" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","25" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(452)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(464)).setAttribute("nombre","cbIndicadorCuadre" );
      ((Element)v.get(464)).setAttribute("id","datosCampos" );
      ((Element)v.get(464)).setAttribute("size","1" );
      ((Element)v.get(464)).setAttribute("multiple","N" );
      ((Element)v.get(464)).setAttribute("req","N" );
      ((Element)v.get(464)).setAttribute("valorinicial","" );
      ((Element)v.get(464)).setAttribute("textoinicial","" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(465)).setAttribute("ID","DTOSalida.indicadorcuadre_ROWSET" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(467)).setAttribute("NOMBRE","INDC_OID_INDI_CUAD" );
      ((Element)v.get(467)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(467)).setAttribute("LONGITUD","50" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Elemento padre:467 / Elemento actual: 468   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(467)).appendChild((Text)v.get(468));

      /* Termina nodo Texto:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(469)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(469)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(469)).setAttribute("LONGITUD","50" );
      ((Element)v.get(466)).appendChild((Element)v.get(469));

      /* Elemento padre:469 / Elemento actual: 470   */
      v.add(doc.createTextNode("Cuadre al factor múltiplo"));
      ((Element)v.get(469)).appendChild((Text)v.get(470));

      /* Termina nodo Texto:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(471)).setAttribute("NOMBRE","OID_IND_CUAD_TIPO_ESTR" );
      ((Element)v.get(471)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(471)).setAttribute("LONGITUD","50" );
      ((Element)v.get(466)).appendChild((Element)v.get(471));

      /* Elemento padre:471 / Elemento actual: 472   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(471)).appendChild((Text)v.get(472));

      /* Termina nodo Texto:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 466   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(473)).setAttribute("NOMBRE","IND_OFER_MONO_GRUP" );
      ((Element)v.get(473)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(473)).setAttribute("LONGITUD","50" );
      ((Element)v.get(466)).appendChild((Element)v.get(473));

      /* Elemento padre:473 / Elemento actual: 474   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(473)).appendChild((Text)v.get(474));

      /* Termina nodo Texto:474   */
      /* Termina nodo:473   */
      /* Termina nodo:466   */

      /* Empieza nodo:475 / Elemento padre: 465   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(476)).setAttribute("NOMBRE","INDC_OID_INDI_CUAD" );
      ((Element)v.get(476)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(476)).setAttribute("LONGITUD","50" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Elemento padre:476 / Elemento actual: 477   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(476)).appendChild((Text)v.get(477));

      /* Termina nodo Texto:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 475   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(478)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(478)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(478)).setAttribute("LONGITUD","50" );
      ((Element)v.get(475)).appendChild((Element)v.get(478));

      /* Elemento padre:478 / Elemento actual: 479   */
      v.add(doc.createTextNode("Cuadre al mayor por unidades"));
      ((Element)v.get(478)).appendChild((Text)v.get(479));

      /* Termina nodo Texto:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 475   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(480)).setAttribute("NOMBRE","OID_IND_CUAD_TIPO_ESTR" );
      ((Element)v.get(480)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(480)).setAttribute("LONGITUD","50" );
      ((Element)v.get(475)).appendChild((Element)v.get(480));

      /* Elemento padre:480 / Elemento actual: 481   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(480)).appendChild((Text)v.get(481));

      /* Termina nodo Texto:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 475   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(482)).setAttribute("NOMBRE","IND_OFER_MONO_GRUP" );
      ((Element)v.get(482)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(482)).setAttribute("LONGITUD","50" );
      ((Element)v.get(475)).appendChild((Element)v.get(482));

      /* Elemento padre:482 / Elemento actual: 483   */
      v.add(doc.createTextNode("0"));
      ((Element)v.get(482)).appendChild((Text)v.get(483));

      /* Termina nodo Texto:483   */
      /* Termina nodo:482   */
      /* Termina nodo:475   */

      /* Empieza nodo:484 / Elemento padre: 465   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(465)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(485)).setAttribute("NOMBRE","INDC_OID_INDI_CUAD" );
      ((Element)v.get(485)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(485)).setAttribute("LONGITUD","50" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Elemento padre:485 / Elemento actual: 486   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(485)).appendChild((Text)v.get(486));

      /* Termina nodo Texto:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(487)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(487)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(487)).setAttribute("LONGITUD","50" );
      ((Element)v.get(484)).appendChild((Element)v.get(487));

      /* Elemento padre:487 / Elemento actual: 488   */
      v.add(doc.createTextNode("Cuadre al menor por unidades"));
      ((Element)v.get(487)).appendChild((Text)v.get(488));

      /* Termina nodo Texto:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(489)).setAttribute("NOMBRE","OID_IND_CUAD_TIPO_ESTR" );
      ((Element)v.get(489)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(489)).setAttribute("LONGITUD","50" );
      ((Element)v.get(484)).appendChild((Element)v.get(489));

      /* Elemento padre:489 / Elemento actual: 490   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(489)).appendChild((Text)v.get(490));

      /* Termina nodo Texto:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 484   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(491)).setAttribute("NOMBRE","IND_OFER_MONO_GRUP" );
      ((Element)v.get(491)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(491)).setAttribute("LONGITUD","50" );
      ((Element)v.get(484)).appendChild((Element)v.get(491));

      /* Elemento padre:491 / Elemento actual: 492   */
      v.add(doc.createTextNode("0"));
      ((Element)v.get(491)).appendChild((Text)v.get(492));

      /* Termina nodo Texto:492   */
      /* Termina nodo:491   */
      /* Termina nodo:484   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:493 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","25" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(452)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(496)).setAttribute("nombre","txtNumeroGruposCondicionantes" );
      ((Element)v.get(496)).setAttribute("id","datosCampos" );
      ((Element)v.get(496)).setAttribute("max","6" );
      ((Element)v.get(496)).setAttribute("tipo","" );
      ((Element)v.get(496)).setAttribute("onchange","" );
      ((Element)v.get(496)).setAttribute("req","N" );
      ((Element)v.get(496)).setAttribute("size","6" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("validacion","" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("table"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("class","datosCampos" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(503)).setAttribute("nombre","rbCondicionCondicionantes" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(503)).setAttribute("tipo","H" );
      ((Element)v.get(503)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).setAttribute("req","N" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(504)).setAttribute("valor","S" );
      ((Element)v.get(504)).setAttribute("check","N" );
      ((Element)v.get(504)).setAttribute("onfocus","" );
      ((Element)v.get(504)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Elemento padre:504 / Elemento actual: 505   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(504)).appendChild((Text)v.get(505));

      /* Termina nodo Texto:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(506)).setAttribute("valor","N" );
      ((Element)v.get(506)).setAttribute("onfocus","" );
      ((Element)v.get(506)).setAttribute("id","datosCampos" );
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Elemento padre:506 / Elemento actual: 507   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(506)).appendChild((Text)v.get(507));

      /* Termina nodo Texto:507   */
      /* Termina nodo:506   */
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:508 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(510)).setAttribute("width","1" );
      ((Element)v.get(452)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","1" );
      ((Element)v.get(511)).setAttribute("height","8" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("width","100%" );
      ((Element)v.get(452)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","1" );
      ((Element)v.get(513)).setAttribute("height","1" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:452   */

      /* Empieza nodo:514 / Elemento padre: 425   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(425)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).setAttribute("colspan","4" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:425   */

      /* Empieza nodo:517 / Elemento padre: 422   */
      v.add(doc.createElement("table"));
      ((Element)v.get(517)).setAttribute("width","100%" );
      ((Element)v.get(517)).setAttribute("border","0" );
      ((Element)v.get(517)).setAttribute("align","center" );
      ((Element)v.get(517)).setAttribute("cellspacing","0" );
      ((Element)v.get(517)).setAttribute("cellpadding","0" );
      ((Element)v.get(422)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).setAttribute("colspan","4" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:521 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblNumeroGruposCondicionados" );
      ((Element)v.get(525)).setAttribute("ancho","130" );
      ((Element)v.get(525)).setAttribute("alto","17" );
      ((Element)v.get(525)).setAttribute("filas","1" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("id","datosTitle" );
      ((Element)v.get(525)).setAttribute("cod","537" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","25" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("colspan","2" );
      ((Element)v.get(521)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(529)).setAttribute("nombre","lblCondicionCondicionados" );
      ((Element)v.get(529)).setAttribute("ancho","90" );
      ((Element)v.get(529)).setAttribute("alto","17" );
      ((Element)v.get(529)).setAttribute("filas","1" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(529)).setAttribute("id","datosTitle" );
      ((Element)v.get(529)).setAttribute("cod","538" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","25" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).setAttribute("colspan","6" );
      ((Element)v.get(521)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(533)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(533)).setAttribute("ancho","87" );
      ((Element)v.get(533)).setAttribute("alto","17" );
      ((Element)v.get(533)).setAttribute("filas","1" );
      ((Element)v.get(533)).setAttribute("valor","" );
      ((Element)v.get(533)).setAttribute("id","datosTitle" );
      ((Element)v.get(533)).setAttribute("cod","541" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(521)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:521   */

      /* Empieza nodo:536 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","8" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(539)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(536)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(540)).setAttribute("nombre","txtNumeroGruposCondicionados" );
      ((Element)v.get(540)).setAttribute("id","datosCampos" );
      ((Element)v.get(540)).setAttribute("max","6" );
      ((Element)v.get(540)).setAttribute("tipo","" );
      ((Element)v.get(540)).setAttribute("onchange","" );
      ((Element)v.get(540)).setAttribute("req","N" );
      ((Element)v.get(540)).setAttribute("size","6" );
      ((Element)v.get(540)).setAttribute("valor","" );
      ((Element)v.get(540)).setAttribute("validacion","" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","25" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("table"));
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("td"));
      ((Element)v.get(546)).setAttribute("class","datosCampos" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(547)).setAttribute("nombre","rbCondicionCondicionados" );
      ((Element)v.get(547)).setAttribute("tipo","H" );
      ((Element)v.get(547)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).setAttribute("req","N" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(548)).setAttribute("valor","S" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(548)).setAttribute("check","N" );
      ((Element)v.get(548)).setAttribute("onfocus","" );
      ((Element)v.get(548)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Elemento padre:548 / Elemento actual: 549   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(548)).appendChild((Text)v.get(549));

      /* Termina nodo Texto:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 547   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(550)).setAttribute("valor","N" );
      ((Element)v.get(550)).setAttribute("onfocus","" );
      ((Element)v.get(550)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).appendChild((Element)v.get(550));

      /* Elemento padre:550 / Elemento actual: 551   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(550)).appendChild((Text)v.get(551));

      /* Termina nodo Texto:551   */
      /* Termina nodo:550   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:552 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:554 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).setAttribute("width","25" );
      ((Element)v.get(555)).setAttribute("height","8" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(536)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(557)).setAttribute("nombre","cbFormasPago" );
      ((Element)v.get(557)).setAttribute("id","datosCampos" );
      ((Element)v.get(557)).setAttribute("size","1" );
      ((Element)v.get(557)).setAttribute("multiple","N" );
      ((Element)v.get(557)).setAttribute("req","N" );
      ((Element)v.get(557)).setAttribute("valorinicial","" );
      ((Element)v.get(557)).setAttribute("textoinicial","" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(558)).setAttribute("ID","DTOSalida.formapago_ROWSET" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(560)).setAttribute("NOMBRE","OID_FORM_PAGO" );
      ((Element)v.get(560)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(560)).setAttribute("LONGITUD","50" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Elemento padre:560 / Elemento actual: 561   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(560)).appendChild((Text)v.get(561));

      /* Termina nodo Texto:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 559   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(562)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(562)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(562)).setAttribute("LONGITUD","50" );
      ((Element)v.get(559)).appendChild((Element)v.get(562));

      /* Elemento padre:562 / Elemento actual: 563   */
      v.add(doc.createTextNode("Pagaré 30, 60, 90"));
      ((Element)v.get(562)).appendChild((Text)v.get(563));

      /* Termina nodo Texto:563   */
      /* Termina nodo:562   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:564 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(567)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(567)).setAttribute("texto","" );
      ((Element)v.get(567)).setAttribute("check","S" );
      ((Element)v.get(567)).setAttribute("validacion","" );
      ((Element)v.get(567)).setAttribute("req","N" );
      ((Element)v.get(567)).setAttribute("id","datosCampos" );
      ((Element)v.get(567)).setAttribute("ontab","" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(569)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(569)).setAttribute("ancho","110" );
      ((Element)v.get(569)).setAttribute("alto","17" );
      ((Element)v.get(569)).setAttribute("filas","1" );
      ((Element)v.get(569)).setAttribute("valor","" );
      ((Element)v.get(569)).setAttribute("id","datosCampos" );
      ((Element)v.get(569)).setAttribute("cod","539" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","25" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(571)).setAttribute("height","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(573)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(573)).setAttribute("texto","" );
      ((Element)v.get(573)).setAttribute("check","S" );
      ((Element)v.get(573)).setAttribute("validacion","" );
      ((Element)v.get(573)).setAttribute("req","N" );
      ((Element)v.get(573)).setAttribute("id","datosCampos" );
      ((Element)v.get(573)).setAttribute("ontab","" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(575)).setAttribute("ancho","110" );
      ((Element)v.get(575)).setAttribute("alto","17" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(575)).setAttribute("id","datosCampos" );
      ((Element)v.get(575)).setAttribute("cod","540" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","51" );
      ((Element)v.get(536)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","51" );
      ((Element)v.get(577)).setAttribute("height","1" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 536   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(536)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","1" );
      ((Element)v.get(579)).setAttribute("height","1" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:536   */

      /* Empieza nodo:580 / Elemento padre: 517   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(517)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).setAttribute("colspan","4" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","8" );
      ((Element)v.get(582)).setAttribute("height","8" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:517   */
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:583 / Elemento padre: 418   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:418   */

      /* Empieza nodo:585 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).setAttribute("width","12" );
      ((Element)v.get(586)).setAttribute("align","center" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","12" );
      ((Element)v.get(587)).setAttribute("height","12" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).setAttribute("width","756" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("width","12" );
      ((Element)v.get(585)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","12" );
      ((Element)v.get(591)).setAttribute("height","1" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:585   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:592 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(592)).setAttribute("nombre","capaVentaExclusiva" );
      ((Element)v.get(592)).setAttribute("alto","491" );
      ((Element)v.get(592)).setAttribute("ancho","100%" );
      ((Element)v.get(592)).setAttribute("colorf","" );
      ((Element)v.get(592)).setAttribute("borde","0" );
      ((Element)v.get(592)).setAttribute("imagenf","" );
      ((Element)v.get(592)).setAttribute("repeat","" );
      ((Element)v.get(592)).setAttribute("padding","" );
      ((Element)v.get(592)).setAttribute("visibilidad","visible" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(592)).setAttribute("contravsb","" );
      ((Element)v.get(592)).setAttribute("x","0" );
      ((Element)v.get(592)).setAttribute("y","1865" );
      ((Element)v.get(592)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("table"));
      ((Element)v.get(593)).setAttribute("width","100%" );
      ((Element)v.get(593)).setAttribute("border","0" );
      ((Element)v.get(593)).setAttribute("cellspacing","0" );
      ((Element)v.get(593)).setAttribute("cellpadding","0" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(596)).setAttribute("height","12" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(597)).setAttribute("width","750" );
      ((Element)v.get(594)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","1" );
      ((Element)v.get(598)).setAttribute("height","1" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 594   */
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","12" );
      ((Element)v.get(600)).setAttribute("height","12" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:594   */

      /* Empieza nodo:601 / Elemento padre: 593   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(593)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("width","12" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","12" );
      ((Element)v.get(603)).setAttribute("height","12" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(606)).setAttribute("class","legend" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(607)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(607)).setAttribute("ancho","115" );
      ((Element)v.get(607)).setAttribute("alto","13" );
      ((Element)v.get(607)).setAttribute("filas","1" );
      ((Element)v.get(607)).setAttribute("valor","" );
      ((Element)v.get(607)).setAttribute("id","legend" );
      ((Element)v.get(607)).setAttribute("cod","0010" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 605   */
      v.add(doc.createElement("table"));
      ((Element)v.get(608)).setAttribute("width","100%" );
      ((Element)v.get(608)).setAttribute("border","0" );
      ((Element)v.get(608)).setAttribute("align","center" );
      ((Element)v.get(608)).setAttribute("cellspacing","0" );
      ((Element)v.get(608)).setAttribute("cellpadding","0" );
      ((Element)v.get(605)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("td"));
      ((Element)v.get(610)).setAttribute("colspan","4" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","12" );
      ((Element)v.get(611)).setAttribute("height","12" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:612 / Elemento padre: 608   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(608)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","8" );
      ((Element)v.get(614)).setAttribute("height","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(615)).setAttribute("colspan","7" );
      ((Element)v.get(615)).setAttribute("width","100%" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(612)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("table"));
      ((Element)v.get(616)).setAttribute("width","100%" );
      ((Element)v.get(616)).setAttribute("border","0" );
      ((Element)v.get(616)).setAttribute("cellspacing","0" );
      ((Element)v.get(616)).setAttribute("cellpadding","0" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("table"));
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(620)).setAttribute("border","0" );
      ((Element)v.get(620)).setAttribute("align","center" );
      ((Element)v.get(620)).setAttribute("cellspacing","0" );
      ((Element)v.get(620)).setAttribute("cellpadding","0" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).setAttribute("colspan","4" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","8" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:624 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).setAttribute("colspan","4" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(628)).setAttribute("nombre","lblTipoCliente4" );
      ((Element)v.get(628)).setAttribute("ancho","110" );
      ((Element)v.get(628)).setAttribute("alto","17" );
      ((Element)v.get(628)).setAttribute("filas","1" );
      ((Element)v.get(628)).setAttribute("valor","" );
      ((Element)v.get(628)).setAttribute("id","datosTitle" );
      ((Element)v.get(628)).setAttribute("cod","393" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","25" );
      ((Element)v.get(630)).setAttribute("height","8" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(632)).setAttribute("nombre","lblSubTipoCliente4" );
      ((Element)v.get(632)).setAttribute("ancho","110" );
      ((Element)v.get(632)).setAttribute("alto","17" );
      ((Element)v.get(632)).setAttribute("filas","1" );
      ((Element)v.get(632)).setAttribute("valor","" );
      ((Element)v.get(632)).setAttribute("id","datosTitle" );
      ((Element)v.get(632)).setAttribute("cod","595" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","25" );
      ((Element)v.get(634)).setAttribute("height","8" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(636)).setAttribute("nombre","lblTipoClasificacionCliente4" );
      ((Element)v.get(636)).setAttribute("ancho","130" );
      ((Element)v.get(636)).setAttribute("alto","17" );
      ((Element)v.get(636)).setAttribute("filas","1" );
      ((Element)v.get(636)).setAttribute("valor","" );
      ((Element)v.get(636)).setAttribute("id","datosTitle" );
      ((Element)v.get(636)).setAttribute("cod","610" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:637 / Elemento padre: 624   */
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("width","100%" );
      ((Element)v.get(624)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","8" );
      ((Element)v.get(638)).setAttribute("height","8" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:624   */

      /* Empieza nodo:639 / Elemento padre: 620   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(620)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","8" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(643)).setAttribute("nombre","ckVentaExclusiva4" );
      ((Element)v.get(643)).setAttribute("texto","" );
      ((Element)v.get(643)).setAttribute("check","N" );
      ((Element)v.get(643)).setAttribute("onclick","che();" );
      ((Element)v.get(643)).setAttribute("validacion","" );
      ((Element)v.get(643)).setAttribute("req","N" );
      ((Element)v.get(643)).setAttribute("id","datosCampos" );
      ((Element)v.get(643)).setAttribute("ontab","" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(645)).setAttribute("nombre","lblVentaExclusiva4" );
      ((Element)v.get(645)).setAttribute("ancho","90" );
      ((Element)v.get(645)).setAttribute("alto","17" );
      ((Element)v.get(645)).setAttribute("filas","1" );
      ((Element)v.get(645)).setAttribute("valor","" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(645)).setAttribute("cod","0010" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:646 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(647)).setAttribute("src","b.gif" );
      ((Element)v.get(647)).setAttribute("width","25" );
      ((Element)v.get(647)).setAttribute("height","8" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(648)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(639)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(649)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(649)).setAttribute("id","datosCampos" );
      ((Element)v.get(649)).setAttribute("size","1" );
      ((Element)v.get(649)).setAttribute("multiple","N" );
      ((Element)v.get(649)).setAttribute("req","N" );
      ((Element)v.get(649)).setAttribute("valorinicial","" );
      ((Element)v.get(649)).setAttribute("textoinicial","" );
      ((Element)v.get(649)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(650)).setAttribute("ID","DTOSalida.tipocliente_ROWSET" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(652)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(652)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(652)).setAttribute("LONGITUD","50" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));

      /* Elemento padre:652 / Elemento actual: 653   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(652)).appendChild((Text)v.get(653));

      /* Termina nodo Texto:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 651   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(654)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(654)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(654)).setAttribute("LONGITUD","50" );
      ((Element)v.get(651)).appendChild((Element)v.get(654));

      /* Elemento padre:654 / Elemento actual: 655   */
      v.add(doc.createTextNode("Administrador"));
      ((Element)v.get(654)).appendChild((Text)v.get(655));

      /* Termina nodo Texto:655   */
      /* Termina nodo:654   */
      /* Termina nodo:651   */

      /* Empieza nodo:656 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(657)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(657)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(657)).setAttribute("LONGITUD","50" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));

      /* Elemento padre:657 / Elemento actual: 658   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(657)).appendChild((Text)v.get(658));

      /* Termina nodo Texto:658   */
      /* Termina nodo:657   */

      /* Empieza nodo:659 / Elemento padre: 656   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(659)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(659)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(659)).setAttribute("LONGITUD","50" );
      ((Element)v.get(656)).appendChild((Element)v.get(659));

      /* Elemento padre:659 / Elemento actual: 660   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createTextNode("Cliente"));
      ((Element)v.get(659)).appendChild((Text)v.get(660));

      /* Termina nodo Texto:660   */
      /* Termina nodo:659   */
      /* Termina nodo:656   */

      /* Empieza nodo:661 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(662)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(662)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(662)).setAttribute("LONGITUD","50" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Elemento padre:662 / Elemento actual: 663   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(662)).appendChild((Text)v.get(663));

      /* Termina nodo Texto:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:664 / Elemento padre: 661   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(664)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(664)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(664)).setAttribute("LONGITUD","50" );
      ((Element)v.get(661)).appendChild((Element)v.get(664));

      /* Elemento padre:664 / Elemento actual: 665   */
      v.add(doc.createTextNode("Consultor(a)"));
      ((Element)v.get(664)).appendChild((Text)v.get(665));

      /* Termina nodo Texto:665   */
      /* Termina nodo:664   */
      /* Termina nodo:661   */

      /* Empieza nodo:666 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(667)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(667)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(667)).setAttribute("LONGITUD","50" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));

      /* Elemento padre:667 / Elemento actual: 668   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(667)).appendChild((Text)v.get(668));

      /* Termina nodo Texto:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 666   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(669)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(669)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(669)).setAttribute("LONGITUD","50" );
      ((Element)v.get(666)).appendChild((Element)v.get(669));

      /* Elemento padre:669 / Elemento actual: 670   */
      v.add(doc.createTextNode("Coordinador"));
      ((Element)v.get(669)).appendChild((Text)v.get(670));

      /* Termina nodo Texto:670   */
      /* Termina nodo:669   */
      /* Termina nodo:666   */

      /* Empieza nodo:671 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(672)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(672)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(672)).setAttribute("LONGITUD","50" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));

      /* Elemento padre:672 / Elemento actual: 673   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(672)).appendChild((Text)v.get(673));

      /* Termina nodo Texto:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 671   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(674)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(674)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(674)).setAttribute("LONGITUD","50" );
      ((Element)v.get(671)).appendChild((Element)v.get(674));

      /* Elemento padre:674 / Elemento actual: 675   */
      v.add(doc.createTextNode("Gerente"));
      ((Element)v.get(674)).appendChild((Text)v.get(675));

      /* Termina nodo Texto:675   */
      /* Termina nodo:674   */
      /* Termina nodo:671   */

      /* Empieza nodo:676 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(677)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(677)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(677)).setAttribute("LONGITUD","50" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Elemento padre:677 / Elemento actual: 678   */
      v.add(doc.createTextNode("12"));
      ((Element)v.get(677)).appendChild((Text)v.get(678));

      /* Termina nodo Texto:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 676   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(679)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(679)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(679)).setAttribute("LONGITUD","50" );
      ((Element)v.get(676)).appendChild((Element)v.get(679));

      /* Elemento padre:679 / Elemento actual: 680   */
      v.add(doc.createTextNode("Gerente de zona"));
      ((Element)v.get(679)).appendChild((Text)v.get(680));

      /* Termina nodo Texto:680   */
      /* Termina nodo:679   */
      /* Termina nodo:676   */

      /* Empieza nodo:681 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(682)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(682)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(682)).setAttribute("LONGITUD","50" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Elemento padre:682 / Elemento actual: 683   */
      v.add(doc.createTextNode("33"));
      ((Element)v.get(682)).appendChild((Text)v.get(683));

      /* Termina nodo Texto:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 681   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(684)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(684)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(684)).setAttribute("LONGITUD","50" );
      ((Element)v.get(681)).appendChild((Element)v.get(684));

      /* Elemento padre:684 / Elemento actual: 685   */
      v.add(doc.createTextNode("Instructor"));
      ((Element)v.get(684)).appendChild((Text)v.get(685));

      /* Termina nodo Texto:685   */
      /* Termina nodo:684   */
      /* Termina nodo:681   */

      /* Empieza nodo:686 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(687)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(687)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(687)).setAttribute("LONGITUD","50" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Elemento padre:687 / Elemento actual: 688   */
      v.add(doc.createTextNode("5"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(687)).appendChild((Text)v.get(688));

      /* Termina nodo Texto:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 686   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(689)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(689)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(689)).setAttribute("LONGITUD","50" );
      ((Element)v.get(686)).appendChild((Element)v.get(689));

      /* Elemento padre:689 / Elemento actual: 690   */
      v.add(doc.createTextNode("Instructor(a)"));
      ((Element)v.get(689)).appendChild((Text)v.get(690));

      /* Termina nodo Texto:690   */
      /* Termina nodo:689   */
      /* Termina nodo:686   */

      /* Empieza nodo:691 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(692)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(692)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(692)).setAttribute("LONGITUD","50" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Elemento padre:692 / Elemento actual: 693   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(692)).appendChild((Text)v.get(693));

      /* Termina nodo Texto:693   */
      /* Termina nodo:692   */

      /* Empieza nodo:694 / Elemento padre: 691   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(694)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(694)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(694)).setAttribute("LONGITUD","50" );
      ((Element)v.get(691)).appendChild((Element)v.get(694));

      /* Elemento padre:694 / Elemento actual: 695   */
      v.add(doc.createTextNode("Potencial"));
      ((Element)v.get(694)).appendChild((Text)v.get(695));

      /* Termina nodo Texto:695   */
      /* Termina nodo:694   */
      /* Termina nodo:691   */

      /* Empieza nodo:696 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(697)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(697)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(697)).setAttribute("LONGITUD","50" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Elemento padre:697 / Elemento actual: 698   */
      v.add(doc.createTextNode("9"));
      ((Element)v.get(697)).appendChild((Text)v.get(698));

      /* Termina nodo Texto:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:699 / Elemento padre: 696   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(699)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(699)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(699)).setAttribute("LONGITUD","50" );
      ((Element)v.get(696)).appendChild((Element)v.get(699));

      /* Elemento padre:699 / Elemento actual: 700   */
      v.add(doc.createTextNode("TipoCliente1"));
      ((Element)v.get(699)).appendChild((Text)v.get(700));

      /* Termina nodo Texto:700   */
      /* Termina nodo:699   */
      /* Termina nodo:696   */

      /* Empieza nodo:701 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(702)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(702)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(702)).setAttribute("LONGITUD","50" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Elemento padre:702 / Elemento actual: 703   */
      v.add(doc.createTextNode("10"));
      ((Element)v.get(702)).appendChild((Text)v.get(703));

      /* Termina nodo Texto:703   */
      /* Termina nodo:702   */

      /* Empieza nodo:704 / Elemento padre: 701   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(704)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(704)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(704)).setAttribute("LONGITUD","50" );
      ((Element)v.get(701)).appendChild((Element)v.get(704));

      /* Elemento padre:704 / Elemento actual: 705   */
      v.add(doc.createTextNode("TipoCliente2"));
      ((Element)v.get(704)).appendChild((Text)v.get(705));

      /* Termina nodo Texto:705   */
      /* Termina nodo:704   */
      /* Termina nodo:701   */

      /* Empieza nodo:706 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(707)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(707)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(707)).setAttribute("LONGITUD","50" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));

      /* Elemento padre:707 / Elemento actual: 708   */
      v.add(doc.createTextNode("11"));
      ((Element)v.get(707)).appendChild((Text)v.get(708));

      /* Termina nodo Texto:708   */
      /* Termina nodo:707   */

      /* Empieza nodo:709 / Elemento padre: 706   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(709)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(709)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(709)).setAttribute("LONGITUD","50" );
      ((Element)v.get(706)).appendChild((Element)v.get(709));

      /* Elemento padre:709 / Elemento actual: 710   */
      v.add(doc.createTextNode("TipoCliente3"));
      ((Element)v.get(709)).appendChild((Text)v.get(710));

      /* Termina nodo Texto:710   */
      /* Termina nodo:709   */
      /* Termina nodo:706   */

      /* Empieza nodo:711 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(712)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(712)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(712)).setAttribute("LONGITUD","50" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));

      /* Elemento padre:712 / Elemento actual: 713   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(712)).appendChild((Text)v.get(713));

      /* Termina nodo Texto:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:714 / Elemento padre: 711   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(714)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(714)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(714)).setAttribute("LONGITUD","50" );
      ((Element)v.get(711)).appendChild((Element)v.get(714));

      /* Elemento padre:714 / Elemento actual: 715   */
      v.add(doc.createTextNode("Transportista"));
      ((Element)v.get(714)).appendChild((Text)v.get(715));

      /* Termina nodo Texto:715   */
      /* Termina nodo:714   */
      /* Termina nodo:711   */

      /* Empieza nodo:716 / Elemento padre: 650   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(650)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(717)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(717)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(717)).setAttribute("LONGITUD","50" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Elemento padre:717 / Elemento actual: 718   */
      v.add(doc.createTextNode("13"));
      ((Element)v.get(717)).appendChild((Text)v.get(718));

      /* Termina nodo Texto:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 716   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(719)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(719)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(719)).setAttribute("LONGITUD","50" );
      ((Element)v.get(716)).appendChild((Element)v.get(719));

      /* Elemento padre:719 / Elemento actual: 720   */
      v.add(doc.createTextNode("Vendedor"));
      ((Element)v.get(719)).appendChild((Text)v.get(720));

      /* Termina nodo Texto:720   */
      /* Termina nodo:719   */
      /* Termina nodo:716   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:721 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(722)).setAttribute("src","b.gif" );
      ((Element)v.get(722)).setAttribute("width","25" );
      ((Element)v.get(722)).setAttribute("height","8" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:723 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(723)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(639)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(724)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(724)).setAttribute("id","datosCampos" );
      ((Element)v.get(724)).setAttribute("size","1" );
      ((Element)v.get(724)).setAttribute("multiple","N" );
      ((Element)v.get(724)).setAttribute("req","N" );
      ((Element)v.get(724)).setAttribute("valorinicial","" );
      ((Element)v.get(724)).setAttribute("textoinicial","" );
      ((Element)v.get(724)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:726 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(727)).setAttribute("src","b.gif" );
      ((Element)v.get(727)).setAttribute("width","25" );
      ((Element)v.get(727)).setAttribute("height","8" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:726   */

      /* Empieza nodo:728 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(728)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(639)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(729)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(729)).setAttribute("id","datosCampos" );
      ((Element)v.get(729)).setAttribute("size","1" );
      ((Element)v.get(729)).setAttribute("multiple","N" );
      ((Element)v.get(729)).setAttribute("req","N" );
      ((Element)v.get(729)).setAttribute("valorinicial","" );
      ((Element)v.get(729)).setAttribute("textoinicial","" );
      ((Element)v.get(729)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:728   */

      /* Empieza nodo:731 / Elemento padre: 639   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("width","100%" );
      ((Element)v.get(639)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","8" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:639   */
      /* Termina nodo:620   */

      /* Empieza nodo:733 / Elemento padre: 619   */
      v.add(doc.createElement("table"));
      ((Element)v.get(733)).setAttribute("width","100%" );
      ((Element)v.get(733)).setAttribute("border","0" );
      ((Element)v.get(733)).setAttribute("align","center" );
      ((Element)v.get(733)).setAttribute("cellspacing","0" );
      ((Element)v.get(733)).setAttribute("cellpadding","0" );
      ((Element)v.get(619)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("td"));
      ((Element)v.get(735)).setAttribute("colspan","4" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(736)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).setAttribute("width","8" );
      ((Element)v.get(736)).setAttribute("height","8" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:737 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(739)).setAttribute("src","b.gif" );
      ((Element)v.get(739)).setAttribute("width","8" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(739)).setAttribute("height","8" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:740 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(741)).setAttribute("nombre","lblClasificacionCliente4" );
      ((Element)v.get(741)).setAttribute("ancho","110" );
      ((Element)v.get(741)).setAttribute("alto","17" );
      ((Element)v.get(741)).setAttribute("filas","1" );
      ((Element)v.get(741)).setAttribute("valor","" );
      ((Element)v.get(741)).setAttribute("id","datosTitle" );
      ((Element)v.get(741)).setAttribute("cod","611" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */
      /* Termina nodo:740   */

      /* Empieza nodo:742 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(743)).setAttribute("src","b.gif" );
      ((Element)v.get(743)).setAttribute("width","25" );
      ((Element)v.get(743)).setAttribute("height","8" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */

      /* Empieza nodo:744 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(745)).setAttribute("nombre","lblEstatusCliente4" );
      ((Element)v.get(745)).setAttribute("ancho","90" );
      ((Element)v.get(745)).setAttribute("alto","17" );
      ((Element)v.get(745)).setAttribute("filas","1" );
      ((Element)v.get(745)).setAttribute("valor","" );
      ((Element)v.get(745)).setAttribute("id","datosTitle" );
      ((Element)v.get(745)).setAttribute("cod","612" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */
      /* Termina nodo:744   */

      /* Empieza nodo:746 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","25" );
      ((Element)v.get(747)).setAttribute("height","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */

      /* Empieza nodo:748 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(737)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(749)).setAttribute("nombre","lblEstatus2Cliente4" );
      ((Element)v.get(749)).setAttribute("ancho","130" );
      ((Element)v.get(749)).setAttribute("alto","17" );
      ((Element)v.get(749)).setAttribute("filas","1" );
      ((Element)v.get(749)).setAttribute("valor","" );
      ((Element)v.get(749)).setAttribute("id","datosTitle" );
      ((Element)v.get(749)).setAttribute("cod","613" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */

      /* Empieza nodo:750 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).setAttribute("width","257" );
      ((Element)v.get(737)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(751)).setAttribute("src","b.gif" );
      ((Element)v.get(751)).setAttribute("width","257" );
      ((Element)v.get(751)).setAttribute("height","8" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 737   */
      v.add(doc.createElement("td"));
      ((Element)v.get(752)).setAttribute("width","100%" );
      ((Element)v.get(737)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(753)).setAttribute("src","b.gif" );
      ((Element)v.get(753)).setAttribute("width","8" );
      ((Element)v.get(753)).setAttribute("height","8" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:752   */
      /* Termina nodo:737   */

      /* Empieza nodo:754 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(756)).setAttribute("src","b.gif" );
      ((Element)v.get(756)).setAttribute("width","8" );
      ((Element)v.get(756)).setAttribute("height","8" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */
      /* Termina nodo:755   */

      /* Empieza nodo:757 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(757)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(754)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(758)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(758)).setAttribute("id","datosCampos" );
      ((Element)v.get(758)).setAttribute("size","1" );
      ((Element)v.get(758)).setAttribute("multiple","N" );
      ((Element)v.get(758)).setAttribute("req","N" );
      ((Element)v.get(758)).setAttribute("valorinicial","" );
      ((Element)v.get(758)).setAttribute("textoinicial","" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(758)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:757   */

      /* Empieza nodo:760 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(761)).setAttribute("src","b.gif" );
      ((Element)v.get(761)).setAttribute("width","25" );
      ((Element)v.get(761)).setAttribute("height","8" );
      ((Element)v.get(760)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */
      /* Termina nodo:760   */

      /* Empieza nodo:762 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(762)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(754)).appendChild((Element)v.get(762));

      /* Empieza nodo:763 / Elemento padre: 762   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(763)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(763)).setAttribute("id","datosCampos" );
      ((Element)v.get(763)).setAttribute("size","1" );
      ((Element)v.get(763)).setAttribute("multiple","N" );
      ((Element)v.get(763)).setAttribute("req","N" );
      ((Element)v.get(763)).setAttribute("valorinicial","" );
      ((Element)v.get(763)).setAttribute("textoinicial","" );
      ((Element)v.get(762)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(764)).setAttribute("ID","DTOSalida.estatus_ROWSET" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(766)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(766)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(766)).setAttribute("LONGITUD","50" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));

      /* Elemento padre:766 / Elemento actual: 767   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(766)).appendChild((Text)v.get(767));

      /* Termina nodo Texto:767   */
      /* Termina nodo:766   */

      /* Empieza nodo:768 / Elemento padre: 765   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(768)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(768)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(768)).setAttribute("LONGITUD","50" );
      ((Element)v.get(765)).appendChild((Element)v.get(768));

      /* Elemento padre:768 / Elemento actual: 769   */
      v.add(doc.createTextNode("Egresada"));
      ((Element)v.get(768)).appendChild((Text)v.get(769));

      /* Termina nodo Texto:769   */
      /* Termina nodo:768   */
      /* Termina nodo:765   */

      /* Empieza nodo:770 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(771)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(771)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(771)).setAttribute("LONGITUD","50" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));

      /* Elemento padre:771 / Elemento actual: 772   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(771)).appendChild((Text)v.get(772));

      /* Termina nodo Texto:772   */
      /* Termina nodo:771   */

      /* Empieza nodo:773 / Elemento padre: 770   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(773)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(773)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(773)).setAttribute("LONGITUD","50" );
      ((Element)v.get(770)).appendChild((Element)v.get(773));

      /* Elemento padre:773 / Elemento actual: 774   */
      v.add(doc.createTextNode("Egresante"));
      ((Element)v.get(773)).appendChild((Text)v.get(774));

      /* Termina nodo Texto:774   */
      /* Termina nodo:773   */
      /* Termina nodo:770   */

      /* Empieza nodo:775 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(776)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(776)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(776)).setAttribute("LONGITUD","50" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Elemento padre:776 / Elemento actual: 777   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(776)).appendChild((Text)v.get(777));

      /* Termina nodo Texto:777   */
      /* Termina nodo:776   */

      /* Empieza nodo:778 / Elemento padre: 775   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(778)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(778)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(778)).setAttribute("LONGITUD","50" );
      ((Element)v.get(775)).appendChild((Element)v.get(778));

      /* Elemento padre:778 / Elemento actual: 779   */
      v.add(doc.createTextNode("Normal"));
      ((Element)v.get(778)).appendChild((Text)v.get(779));

      /* Termina nodo Texto:779   */
      /* Termina nodo:778   */
      /* Termina nodo:775   */

      /* Empieza nodo:780 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(781)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(781)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(781)).setAttribute("LONGITUD","50" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Elemento padre:781 / Elemento actual: 782   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(781)).appendChild((Text)v.get(782));

      /* Termina nodo Texto:782   */
      /* Termina nodo:781   */

      /* Empieza nodo:783 / Elemento padre: 780   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(783)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(783)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(783)).setAttribute("LONGITUD","50" );
      ((Element)v.get(780)).appendChild((Element)v.get(783));

      /* Elemento padre:783 / Elemento actual: 784   */
      v.add(doc.createTextNode("Nueva"));
      ((Element)v.get(783)).appendChild((Text)v.get(784));

      /* Termina nodo Texto:784   */
      /* Termina nodo:783   */
      /* Termina nodo:780   */

      /* Empieza nodo:785 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(786)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(786)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(786)).setAttribute("LONGITUD","50" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Elemento padre:786 / Elemento actual: 787   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(786)).appendChild((Text)v.get(787));

      /* Termina nodo Texto:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:788 / Elemento padre: 785   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(788)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(788)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(788)).setAttribute("LONGITUD","50" );
      ((Element)v.get(785)).appendChild((Element)v.get(788));

      /* Elemento padre:788 / Elemento actual: 789   */
      v.add(doc.createTextNode("Reactivada"));
      ((Element)v.get(788)).appendChild((Text)v.get(789));

      /* Termina nodo Texto:789   */
      /* Termina nodo:788   */
      /* Termina nodo:785   */

      /* Empieza nodo:790 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(791)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(791)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(791)).setAttribute("LONGITUD","50" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));

      /* Elemento padre:791 / Elemento actual: 792   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(791)).appendChild((Text)v.get(792));

      /* Termina nodo Texto:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 790   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(793)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(793)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(793)).setAttribute("LONGITUD","50" );
      ((Element)v.get(790)).appendChild((Element)v.get(793));

      /* Elemento padre:793 / Elemento actual: 794   */
      v.add(doc.createTextNode("Registrada"));
      ((Element)v.get(793)).appendChild((Text)v.get(794));

      /* Termina nodo Texto:794   */
      /* Termina nodo:793   */
      /* Termina nodo:790   */

      /* Empieza nodo:795 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(796)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(796)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(796)).setAttribute("LONGITUD","50" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Elemento padre:796 / Elemento actual: 797   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(796)).appendChild((Text)v.get(797));

      /* Termina nodo Texto:797   */
      /* Termina nodo:796   */

      /* Empieza nodo:798 / Elemento padre: 795   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(798)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(798)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(798)).setAttribute("LONGITUD","50" );
      ((Element)v.get(795)).appendChild((Element)v.get(798));

      /* Elemento padre:798 / Elemento actual: 799   */
      v.add(doc.createTextNode("Reingreso"));
      ((Element)v.get(798)).appendChild((Text)v.get(799));

      /* Termina nodo Texto:799   */
      /* Termina nodo:798   */
      /* Termina nodo:795   */

      /* Empieza nodo:800 / Elemento padre: 764   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(764)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(801)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(801)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(801)).setAttribute("LONGITUD","50" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));

      /* Elemento padre:801 / Elemento actual: 802   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(801)).appendChild((Text)v.get(802));

      /* Termina nodo Texto:802   */
      /* Termina nodo:801   */

      /* Empieza nodo:803 / Elemento padre: 800   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(803)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(803)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(803)).setAttribute("LONGITUD","50" );
      ((Element)v.get(800)).appendChild((Element)v.get(803));

      /* Elemento padre:803 / Elemento actual: 804   */
      v.add(doc.createTextNode("Retirada"));
      ((Element)v.get(803)).appendChild((Text)v.get(804));

      /* Termina nodo Texto:804   */
      /* Termina nodo:803   */
      /* Termina nodo:800   */
      /* Termina nodo:764   */
      /* Termina nodo:763   */
      /* Termina nodo:762   */

      /* Empieza nodo:805 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(806)).setAttribute("src","b.gif" );
      ((Element)v.get(806)).setAttribute("width","25" );
      ((Element)v.get(806)).setAttribute("height","8" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(754)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(808)).setAttribute("nombre","txtEstatus2Cliente" );
      ((Element)v.get(808)).setAttribute("id","datosCampos" );
      ((Element)v.get(808)).setAttribute("max","1" );
      ((Element)v.get(808)).setAttribute("tipo","" );
      ((Element)v.get(808)).setAttribute("onchange","" );
      ((Element)v.get(808)).setAttribute("req","N" );
      ((Element)v.get(808)).setAttribute("size","2" );
      ((Element)v.get(808)).setAttribute("valor","" );
      ((Element)v.get(808)).setAttribute("validacion","" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:809 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(810)).setAttribute("src","b.gif" );
      ((Element)v.get(810)).setAttribute("width","25" );
      ((Element)v.get(810)).setAttribute("height","8" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */
      /* Termina nodo:809   */

      /* Empieza nodo:811 / Elemento padre: 754   */
      v.add(doc.createElement("td"));
      ((Element)v.get(811)).setAttribute("width","100%" );
      ((Element)v.get(754)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(812)).setAttribute("src","b.gif" );
      ((Element)v.get(812)).setAttribute("width","8" );
      ((Element)v.get(812)).setAttribute("height","8" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */
      /* Termina nodo:811   */
      /* Termina nodo:754   */

      /* Empieza nodo:813 / Elemento padre: 733   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(733)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("td"));
      ((Element)v.get(814)).setAttribute("colspan","4" );
      ((Element)v.get(813)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(815)).setAttribute("src","b.gif" );
      ((Element)v.get(815)).setAttribute("width","8" );
      ((Element)v.get(815)).setAttribute("height","310" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:813   */
      /* Termina nodo:733   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:816 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(817)).setAttribute("src","b.gif" );
      ((Element)v.get(817)).setAttribute("width","12" );
      ((Element)v.get(817)).setAttribute("height","12" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:816   */
      /* Termina nodo:612   */

      /* Empieza nodo:818 / Elemento padre: 608   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(608)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).setAttribute("colspan","3" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).setAttribute("width","12" );
      ((Element)v.get(820)).setAttribute("height","12" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */
      /* Termina nodo:818   */
      /* Termina nodo:608   */
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:821 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","12" );
      ((Element)v.get(822)).setAttribute("height","12" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */
      /* Termina nodo:601   */

      /* Empieza nodo:823 / Elemento padre: 593   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(593)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("td"));
      ((Element)v.get(823)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(825)).setAttribute("src","b.gif" );
      ((Element)v.get(824)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */
      /* Termina nodo:824   */

      /* Empieza nodo:826 / Elemento padre: 823   */
      v.add(doc.createElement("td"));
      ((Element)v.get(823)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(826)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("table"));
      ((Element)v.get(828)).setAttribute("width","100%" );
      ((Element)v.get(828)).setAttribute("border","0" );
      ((Element)v.get(828)).setAttribute("align","center" );
      ((Element)v.get(828)).setAttribute("cellspacing","0" );
      ((Element)v.get(828)).setAttribute("cellpadding","0" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(830)).setAttribute("class","botonera" );
      ((Element)v.get(830)).setAttribute("width","100%" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(831)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(831)).setAttribute("ID","botonContenido" );
      ((Element)v.get(831)).setAttribute("tipo","html" );
      ((Element)v.get(831)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(831)).setAttribute("estado","false" );
      ((Element)v.get(831)).setAttribute("cod","404" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */
      /* Termina nodo:830   */
      /* Termina nodo:829   */
      /* Termina nodo:828   */
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:832 / Elemento padre: 823   */
      v.add(doc.createElement("td"));
      ((Element)v.get(823)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(833)).setAttribute("src","b.gif" );
      ((Element)v.get(833)).setAttribute("width","12" );
      ((Element)v.get(833)).setAttribute("height","12" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */
      /* Termina nodo:823   */

      /* Empieza nodo:834 / Elemento padre: 593   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(593)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).setAttribute("width","12" );
      ((Element)v.get(835)).setAttribute("align","center" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(836)).setAttribute("src","b.gif" );
      ((Element)v.get(836)).setAttribute("width","12" );
      ((Element)v.get(836)).setAttribute("height","12" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */
      /* Termina nodo:835   */

      /* Empieza nodo:837 / Elemento padre: 834   */
      v.add(doc.createElement("td"));
      ((Element)v.get(837)).setAttribute("width","750" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(834)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(838)).setAttribute("src","b.gif" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */

      /* Empieza nodo:839 / Elemento padre: 834   */
      v.add(doc.createElement("td"));
      ((Element)v.get(839)).setAttribute("width","12" );
      ((Element)v.get(834)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(840)).setAttribute("src","b.gif" );
      ((Element)v.get(840)).setAttribute("width","12" );
      ((Element)v.get(840)).setAttribute("height","12" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:839   */
      /* Termina nodo:834   */
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:841 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(841)).setAttribute("nombre","listado5" );
      ((Element)v.get(841)).setAttribute("ancho","637" );
      ((Element)v.get(841)).setAttribute("alto","290" );
      ((Element)v.get(841)).setAttribute("x","32" );
      ((Element)v.get(841)).setAttribute("y","2005" );
      ((Element)v.get(841)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(841)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(842)).setAttribute("precarga","S" );
      ((Element)v.get(842)).setAttribute("conROver","S" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(843)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(843)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(843)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(843)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */

      /* Empieza nodo:844 / Elemento padre: 842   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(844)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(844)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(844)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(844)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(842)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */
      /* Termina nodo:842   */

      /* Empieza nodo:845 / Elemento padre: 841   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(841)).appendChild((Element)v.get(845));

      /* Empieza nodo:846 / Elemento padre: 845   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(846)).setAttribute("borde","1" );
      ((Element)v.get(846)).setAttribute("horizDatos","1" );
      ((Element)v.get(846)).setAttribute("horizCabecera","1" );
      ((Element)v.get(846)).setAttribute("vertical","0" );
      ((Element)v.get(845)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */

      /* Empieza nodo:847 / Elemento padre: 845   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(847)).setAttribute("borde","#999999" );
      ((Element)v.get(847)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(847)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(847)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(847)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(845)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:845   */

      /* Empieza nodo:848 / Elemento padre: 841   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(848)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(848)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(848)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(848)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(848)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(841)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(849)).setAttribute("ancho","100" );
      ((Element)v.get(849)).setAttribute("minimizable","S" );
      ((Element)v.get(849)).setAttribute("minimizada","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */

      /* Empieza nodo:850 / Elemento padre: 848   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(850)).setAttribute("ancho","100" );
      ((Element)v.get(850)).setAttribute("minimizable","S" );
      ((Element)v.get(850)).setAttribute("minimizada","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */

      /* Empieza nodo:851 / Elemento padre: 848   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(851)).setAttribute("ancho","100" );
      ((Element)v.get(851)).setAttribute("minimizable","S" );
      ((Element)v.get(851)).setAttribute("minimizada","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */

      /* Empieza nodo:852 / Elemento padre: 848   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(852)).setAttribute("ancho","100" );
      ((Element)v.get(852)).setAttribute("minimizable","S" );
      ((Element)v.get(852)).setAttribute("minimizada","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(852));
      /* Termina nodo:852   */

      /* Empieza nodo:853 / Elemento padre: 848   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(853)).setAttribute("ancho","100" );
      ((Element)v.get(853)).setAttribute("minimizable","S" );
      ((Element)v.get(853)).setAttribute("minimizada","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:848   */

      /* Empieza nodo:854 / Elemento padre: 841   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(854)).setAttribute("alto","20" );
      ((Element)v.get(854)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(854)).setAttribute("imgFondo","" );
      ((Element)v.get(854)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(841)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
   }

   private void getXML3420(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(855)).setAttribute("colFondo","" );
      ((Element)v.get(855)).setAttribute("ID","EstCab" );
      ((Element)v.get(855)).setAttribute("cod","393" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */

      /* Empieza nodo:856 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(856)).setAttribute("colFondo","" );
      ((Element)v.get(856)).setAttribute("ID","EstCab" );
      ((Element)v.get(856)).setAttribute("cod","595" );
      ((Element)v.get(854)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */

      /* Empieza nodo:857 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(857)).setAttribute("colFondo","" );
      ((Element)v.get(857)).setAttribute("ID","EstCab" );
      ((Element)v.get(857)).setAttribute("cod","550" );
      ((Element)v.get(854)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */

      /* Empieza nodo:858 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(858)).setAttribute("colFondo","" );
      ((Element)v.get(858)).setAttribute("ID","EstCab" );
      ((Element)v.get(858)).setAttribute("cod","551" );
      ((Element)v.get(854)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */

      /* Empieza nodo:859 / Elemento padre: 854   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(859)).setAttribute("colFondo","" );
      ((Element)v.get(859)).setAttribute("ID","EstCab" );
      ((Element)v.get(859)).setAttribute("cod","552" );
      ((Element)v.get(854)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */
      /* Termina nodo:854   */

      /* Empieza nodo:860 / Elemento padre: 841   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(860)).setAttribute("alto","22" );
      ((Element)v.get(860)).setAttribute("accion","" );
      ((Element)v.get(860)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(860)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(860)).setAttribute("maxSel","-1" );
      ((Element)v.get(860)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(860)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(860)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(860)).setAttribute("onLoad","" );
      ((Element)v.get(860)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(841)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(861)).setAttribute("tipo","texto" );
      ((Element)v.get(861)).setAttribute("ID","EstDat" );
      ((Element)v.get(860)).appendChild((Element)v.get(861));
      /* Termina nodo:861   */

      /* Empieza nodo:862 / Elemento padre: 860   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(862)).setAttribute("tipo","texto" );
      ((Element)v.get(862)).setAttribute("ID","EstDat2" );
      ((Element)v.get(860)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 860   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(863)).setAttribute("tipo","texto" );
      ((Element)v.get(863)).setAttribute("ID","EstDat" );
      ((Element)v.get(860)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */

      /* Empieza nodo:864 / Elemento padre: 860   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(864)).setAttribute("tipo","texto" );
      ((Element)v.get(864)).setAttribute("ID","EstDat2" );
      ((Element)v.get(860)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */

      /* Empieza nodo:865 / Elemento padre: 860   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(865)).setAttribute("tipo","texto" );
      ((Element)v.get(865)).setAttribute("ID","EstDat" );
      ((Element)v.get(860)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */
      /* Termina nodo:860   */

      /* Empieza nodo:866 / Elemento padre: 841   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(841)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */

      /* Empieza nodo:867 / Elemento padre: 841   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(867)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(867)).setAttribute("ancho","680" );
      ((Element)v.get(867)).setAttribute("sep","$" );
      ((Element)v.get(867)).setAttribute("x","12" );
      ((Element)v.get(867)).setAttribute("class","botonera" );
      ((Element)v.get(867)).setAttribute("y","2267" );
      ((Element)v.get(867)).setAttribute("control","|" );
      ((Element)v.get(867)).setAttribute("conector","" );
      ((Element)v.get(867)).setAttribute("rowset","" );
      ((Element)v.get(867)).setAttribute("cargainicial","N" );
      ((Element)v.get(841)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(868)).setAttribute("nombre","primera5" );
      ((Element)v.get(868)).setAttribute("x","44" );
      ((Element)v.get(868)).setAttribute("y","2271" );
      ((Element)v.get(868)).setAttribute("ID","botonContenido" );
      ((Element)v.get(868)).setAttribute("img","primera_on" );
      ((Element)v.get(868)).setAttribute("tipo","0" );
      ((Element)v.get(868)).setAttribute("estado","false" );
      ((Element)v.get(868)).setAttribute("alt","" );
      ((Element)v.get(868)).setAttribute("codigo","" );
      ((Element)v.get(868)).setAttribute("accion","" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */

      /* Empieza nodo:869 / Elemento padre: 867   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(869)).setAttribute("nombre","ava5" );
      ((Element)v.get(869)).setAttribute("x","79" );
      ((Element)v.get(869)).setAttribute("y","2271" );
      ((Element)v.get(869)).setAttribute("ID","botonContenido" );
      ((Element)v.get(869)).setAttribute("img","avanzar_on" );
      ((Element)v.get(869)).setAttribute("tipo","0" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(869)).setAttribute("estado","false" );
      ((Element)v.get(869)).setAttribute("alt","" );
      ((Element)v.get(869)).setAttribute("codigo","" );
      ((Element)v.get(869)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(867)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */

      /* Empieza nodo:870 / Elemento padre: 867   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(870)).setAttribute("nombre","ret5" );
      ((Element)v.get(870)).setAttribute("x","64" );
      ((Element)v.get(870)).setAttribute("y","2271" );
      ((Element)v.get(870)).setAttribute("ID","botonContenido" );
      ((Element)v.get(870)).setAttribute("img","retroceder_on" );
      ((Element)v.get(870)).setAttribute("tipo","0" );
      ((Element)v.get(870)).setAttribute("estado","false" );
      ((Element)v.get(870)).setAttribute("alt","" );
      ((Element)v.get(870)).setAttribute("codigo","" );
      ((Element)v.get(870)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(867)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:867   */
      /* Termina nodo:841   */

      /* Empieza nodo:871 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(871)).setAttribute("nombre","capaEliminar" );
      ((Element)v.get(871)).setAttribute("alto","50" );
      ((Element)v.get(871)).setAttribute("ancho","100%" );
      ((Element)v.get(871)).setAttribute("colorf","" );
      ((Element)v.get(871)).setAttribute("borde","0" );
      ((Element)v.get(871)).setAttribute("imagenf","" );
      ((Element)v.get(871)).setAttribute("repeat","" );
      ((Element)v.get(871)).setAttribute("padding","" );
      ((Element)v.get(871)).setAttribute("visibilidad","visible" );
      ((Element)v.get(871)).setAttribute("contravsb","" );
      ((Element)v.get(871)).setAttribute("x","0" );
      ((Element)v.get(871)).setAttribute("y","2345" );
      ((Element)v.get(871)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("table"));
      ((Element)v.get(872)).setAttribute("width","100%" );
      ((Element)v.get(872)).setAttribute("border","0" );
      ((Element)v.get(872)).setAttribute("cellspacing","0" );
      ((Element)v.get(872)).setAttribute("cellpadding","0" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(872)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(875)).setAttribute("width","12" );
      ((Element)v.get(875)).setAttribute("height","15" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */

      /* Empieza nodo:876 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).setAttribute("width","750" );
      ((Element)v.get(873)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(877)).setAttribute("src","b.gif" );
      ((Element)v.get(877)).setAttribute("width","1" );
      ((Element)v.get(877)).setAttribute("height","1" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */
      /* Termina nodo:876   */

      /* Empieza nodo:878 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(879)).setAttribute("src","b.gif" );
      ((Element)v.get(879)).setAttribute("width","12" );
      ((Element)v.get(879)).setAttribute("height","15" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */
      /* Termina nodo:878   */
      /* Termina nodo:873   */

      /* Empieza nodo:880 / Elemento padre: 872   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(872)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(882)).setAttribute("src","b.gif" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */

      /* Empieza nodo:883 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(883)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("table"));
      ((Element)v.get(885)).setAttribute("width","100%" );
      ((Element)v.get(885)).setAttribute("border","0" );
      ((Element)v.get(885)).setAttribute("align","center" );
      ((Element)v.get(885)).setAttribute("cellspacing","0" );
      ((Element)v.get(885)).setAttribute("cellpadding","0" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(885)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("td"));
      ((Element)v.get(887)).setAttribute("class","botonera" );
      ((Element)v.get(887)).setAttribute("width","100%" );
      ((Element)v.get(887)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(886)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(888)).setAttribute("nombre","btnEliminarOferta" );
      ((Element)v.get(888)).setAttribute("ID","botonContenido" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(888)).setAttribute("tipo","html" );
      ((Element)v.get(888)).setAttribute("accion","accionEliminarOferta();" );
      ((Element)v.get(888)).setAttribute("estado","false" );
      ((Element)v.get(888)).setAttribute("cod","2244" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */

      /* Empieza nodo:889 / Elemento padre: 887   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(889)).setAttribute("src","b.gif" );
      ((Element)v.get(889)).setAttribute("width","573" );
      ((Element)v.get(889)).setAttribute("height","1" );
      ((Element)v.get(887)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */
      /* Termina nodo:887   */
      /* Termina nodo:886   */
      /* Termina nodo:885   */
      /* Termina nodo:884   */
      /* Termina nodo:883   */

      /* Empieza nodo:890 / Elemento padre: 880   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).appendChild((Element)v.get(890));

      /* Empieza nodo:891 / Elemento padre: 890   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(891)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).setAttribute("width","12" );
      ((Element)v.get(891)).setAttribute("height","12" );
      ((Element)v.get(890)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */
      /* Termina nodo:890   */
      /* Termina nodo:880   */

      /* Empieza nodo:892 / Elemento padre: 872   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(872)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(893)).setAttribute("width","12" );
      ((Element)v.get(893)).setAttribute("align","center" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(894)).setAttribute("src","b.gif" );
      ((Element)v.get(894)).setAttribute("width","12" );
      ((Element)v.get(894)).setAttribute("height","12" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:893   */

      /* Empieza nodo:895 / Elemento padre: 892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(895)).setAttribute("width","750" );
      ((Element)v.get(892)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(896)).setAttribute("src","b.gif" );
      ((Element)v.get(895)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */
      /* Termina nodo:895   */

      /* Empieza nodo:897 / Elemento padre: 892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(897)).setAttribute("width","12" );
      ((Element)v.get(892)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(898)).setAttribute("src","b.gif" );
      ((Element)v.get(898)).setAttribute("width","12" );
      ((Element)v.get(898)).setAttribute("height","12" );
      ((Element)v.get(897)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */
      /* Termina nodo:897   */
      /* Termina nodo:892   */
      /* Termina nodo:872   */
      /* Termina nodo:871   */

      /* Empieza nodo:899 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(899)).setAttribute("nombre","SICC_TOOLBAR_CONFIG" );
      ((Element)v.get(899)).setAttribute("valor","[0154, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1]" );
      ((Element)v.get(6)).appendChild((Element)v.get(899));
      /* Termina nodo:899   */

      /* Empieza nodo:900 / Elemento padre: 6   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(900)).setAttribute("width","800 px" );
      ((Element)v.get(6)).appendChild((Element)v.get(900));

      /* Empieza nodo:901 / Elemento padre: 900   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(901)).setAttribute("nombre","capaPromocion0" );
      ((Element)v.get(901)).setAttribute("alto","100%" );
      ((Element)v.get(901)).setAttribute("ancho","100%" );
      ((Element)v.get(901)).setAttribute("colorf","" );
      ((Element)v.get(901)).setAttribute("borde","0" );
      ((Element)v.get(901)).setAttribute("imagenf","" );
      ((Element)v.get(901)).setAttribute("repeat","" );
      ((Element)v.get(901)).setAttribute("padding","" );
      ((Element)v.get(901)).setAttribute("visibilidad","visible" );
      ((Element)v.get(901)).setAttribute("contravsb","" );
      ((Element)v.get(901)).setAttribute("x","0" );
      ((Element)v.get(901)).setAttribute("y","913" );
      ((Element)v.get(901)).setAttribute("zindex","" );
      ((Element)v.get(900)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("table"));
      ((Element)v.get(902)).setAttribute("width","100%" );
      ((Element)v.get(902)).setAttribute("border","0" );
      ((Element)v.get(902)).setAttribute("cellspacing","0" );
      ((Element)v.get(902)).setAttribute("cellpadding","0" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(902)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("td"));
      ((Element)v.get(903)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(905)).setAttribute("src","b.gif" );
      ((Element)v.get(905)).setAttribute("width","12" );
      ((Element)v.get(905)).setAttribute("height","12" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));
      /* Termina nodo:905   */
      /* Termina nodo:904   */

      /* Empieza nodo:906 / Elemento padre: 903   */
      v.add(doc.createElement("td"));
      ((Element)v.get(906)).setAttribute("width","100%" );
      ((Element)v.get(903)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(907)).setAttribute("src","b.gif" );
      ((Element)v.get(907)).setAttribute("width","1" );
      ((Element)v.get(907)).setAttribute("height","1" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));
      /* Termina nodo:907   */
      /* Termina nodo:906   */

      /* Empieza nodo:908 / Elemento padre: 903   */
      v.add(doc.createElement("td"));
      ((Element)v.get(903)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(909)).setAttribute("src","b.gif" );
      ((Element)v.get(909)).setAttribute("width","12" );
      ((Element)v.get(909)).setAttribute("height","12" );
      ((Element)v.get(908)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */
      /* Termina nodo:908   */
      /* Termina nodo:903   */

      /* Empieza nodo:910 / Elemento padre: 902   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(902)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).appendChild((Element)v.get(911));

      /* Empieza nodo:912 / Elemento padre: 911   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(912)).setAttribute("src","b.gif" );
      ((Element)v.get(912)).setAttribute("width","12" );
      ((Element)v.get(912)).setAttribute("height","12" );
      ((Element)v.get(911)).appendChild((Element)v.get(912));
      /* Termina nodo:912   */
      /* Termina nodo:911   */

      /* Empieza nodo:913 / Elemento padre: 910   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(913)).appendChild((Element)v.get(914));

      /* Empieza nodo:915 / Elemento padre: 914   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(915)).setAttribute("class","legend" );
      ((Element)v.get(914)).appendChild((Element)v.get(915));

      /* Empieza nodo:916 / Elemento padre: 915   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(916)).setAttribute("nombre","lblPromociones" );
      ((Element)v.get(916)).setAttribute("ancho","105" );
      ((Element)v.get(916)).setAttribute("alto","13" );
      ((Element)v.get(916)).setAttribute("filas","1" );
      ((Element)v.get(916)).setAttribute("valor","" );
      ((Element)v.get(916)).setAttribute("id","legend" );
      ((Element)v.get(916)).setAttribute("cod","00117" );
      ((Element)v.get(915)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */
      /* Termina nodo:915   */

      /* Empieza nodo:917 / Elemento padre: 914   */
      v.add(doc.createElement("table"));
      ((Element)v.get(917)).setAttribute("width","100%" );
      ((Element)v.get(917)).setAttribute("border","0" );
      ((Element)v.get(917)).setAttribute("align","center" );
      ((Element)v.get(917)).setAttribute("cellspacing","0" );
      ((Element)v.get(917)).setAttribute("cellpadding","0" );
      ((Element)v.get(914)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(917)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("td"));
      ((Element)v.get(919)).setAttribute("colspan","4" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));

      /* Empieza nodo:920 / Elemento padre: 919   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(920)).setAttribute("src","b.gif" );
      ((Element)v.get(920)).setAttribute("width","12" );
      ((Element)v.get(920)).setAttribute("height","12" );
      ((Element)v.get(919)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */
      /* Termina nodo:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:921 / Elemento padre: 917   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(917)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("td"));
      ((Element)v.get(921)).appendChild((Element)v.get(922));

      /* Empieza nodo:923 / Elemento padre: 922   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(923)).setAttribute("src","b.gif" );
      ((Element)v.get(923)).setAttribute("width","8" );
      ((Element)v.get(923)).setAttribute("height","8" );
      ((Element)v.get(922)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */
      /* Termina nodo:922   */

      /* Empieza nodo:924 / Elemento padre: 921   */
      v.add(doc.createElement("td"));
      ((Element)v.get(924)).setAttribute("width","100%" );
      ((Element)v.get(921)).appendChild((Element)v.get(924));

      /* Empieza nodo:925 / Elemento padre: 924   */
      v.add(doc.createElement("table"));
      ((Element)v.get(925)).setAttribute("width","100%" );
      ((Element)v.get(925)).setAttribute("border","0" );
      ((Element)v.get(925)).setAttribute("cellspacing","0" );
      ((Element)v.get(925)).setAttribute("cellpadding","0" );
      ((Element)v.get(924)).appendChild((Element)v.get(925));

      /* Empieza nodo:926 / Elemento padre: 925   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(925)).appendChild((Element)v.get(926));

      /* Empieza nodo:927 / Elemento padre: 926   */
      v.add(doc.createElement("td"));
      ((Element)v.get(926)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(927)).appendChild((Element)v.get(928));

      /* Empieza nodo:929 / Elemento padre: 928   */
      v.add(doc.createElement("table"));
      ((Element)v.get(929)).setAttribute("width","100%" );
      ((Element)v.get(929)).setAttribute("border","0" );
      ((Element)v.get(929)).setAttribute("align","center" );
      ((Element)v.get(929)).setAttribute("cellspacing","0" );
      ((Element)v.get(929)).setAttribute("cellpadding","0" );
      ((Element)v.get(928)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(929)).appendChild((Element)v.get(930));

      /* Empieza nodo:931 / Elemento padre: 930   */
      v.add(doc.createElement("td"));
      ((Element)v.get(931)).setAttribute("colspan","3" );
      ((Element)v.get(930)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(932)).setAttribute("src","b.gif" );
      ((Element)v.get(932)).setAttribute("width","8" );
      ((Element)v.get(932)).setAttribute("height","8" );
      ((Element)v.get(931)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */
      /* Termina nodo:931   */
      /* Termina nodo:930   */

      /* Empieza nodo:933 / Elemento padre: 929   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(929)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(933)).appendChild((Element)v.get(934));

      /* Empieza nodo:935 / Elemento padre: 934   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(935)).setAttribute("src","b.gif" );
      ((Element)v.get(935)).setAttribute("width","8" );
      ((Element)v.get(935)).setAttribute("height","8" );
      ((Element)v.get(934)).appendChild((Element)v.get(935));
      /* Termina nodo:935   */
      /* Termina nodo:934   */

      /* Empieza nodo:936 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).appendChild((Element)v.get(936));

      /* Empieza nodo:937 / Elemento padre: 936   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(937)).setAttribute("nombre","lblNumeroCondicion120" );
      ((Element)v.get(937)).setAttribute("ancho","110" );
      ((Element)v.get(937)).setAttribute("alto","17" );
      ((Element)v.get(937)).setAttribute("filas","1" );
      ((Element)v.get(937)).setAttribute("valor","" );
      ((Element)v.get(937)).setAttribute("id","datosTitle" );
      ((Element)v.get(937)).setAttribute("cod","004" );
      ((Element)v.get(936)).appendChild((Element)v.get(937));
      /* Termina nodo:937   */
      /* Termina nodo:936   */

      /* Empieza nodo:938 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).appendChild((Element)v.get(938));

      /* Empieza nodo:939 / Elemento padre: 938   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(939)).setAttribute("src","b.gif" );
      ((Element)v.get(939)).setAttribute("width","25" );
      ((Element)v.get(939)).setAttribute("height","8" );
      ((Element)v.get(938)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */
      /* Termina nodo:938   */

      /* Empieza nodo:940 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).appendChild((Element)v.get(940));

      /* Empieza nodo:941 / Elemento padre: 940   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(941)).setAttribute("nombre","lblIndicadorCuadre120" );
      ((Element)v.get(941)).setAttribute("ancho","110" );
      ((Element)v.get(941)).setAttribute("alto","17" );
      ((Element)v.get(941)).setAttribute("filas","1" );
      ((Element)v.get(941)).setAttribute("valor","" );
      ((Element)v.get(941)).setAttribute("id","datosTitle" );
      ((Element)v.get(941)).setAttribute("cod","005" );
      ((Element)v.get(940)).appendChild((Element)v.get(941));
      /* Termina nodo:941   */
      /* Termina nodo:940   */

      /* Empieza nodo:942 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).appendChild((Element)v.get(942));

      /* Empieza nodo:943 / Elemento padre: 942   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(943)).setAttribute("src","b.gif" );
      ((Element)v.get(943)).setAttribute("width","25" );
      ((Element)v.get(943)).setAttribute("height","8" );
      ((Element)v.get(942)).appendChild((Element)v.get(943));
      /* Termina nodo:943   */
      /* Termina nodo:942   */

      /* Empieza nodo:944 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(933)).appendChild((Element)v.get(944));

      /* Empieza nodo:945 / Elemento padre: 944   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(945)).setAttribute("nombre","lblFactorCuadre120" );
      ((Element)v.get(945)).setAttribute("ancho","130" );
      ((Element)v.get(945)).setAttribute("alto","17" );
      ((Element)v.get(945)).setAttribute("filas","1" );
      ((Element)v.get(945)).setAttribute("valor","" );
      ((Element)v.get(945)).setAttribute("id","datosTitle" );
      ((Element)v.get(945)).setAttribute("cod","006" );
      ((Element)v.get(944)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */
      /* Termina nodo:944   */

      /* Empieza nodo:946 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(946)).setAttribute("width","88" );
      ((Element)v.get(933)).appendChild((Element)v.get(946));

      /* Empieza nodo:947 / Elemento padre: 946   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(947)).setAttribute("src","b.gif" );
      ((Element)v.get(947)).setAttribute("width","236" );
      ((Element)v.get(947)).setAttribute("height","8" );
      ((Element)v.get(946)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */
      /* Termina nodo:946   */

      /* Empieza nodo:948 / Elemento padre: 933   */
      v.add(doc.createElement("td"));
      ((Element)v.get(948)).setAttribute("width","100%" );
      ((Element)v.get(933)).appendChild((Element)v.get(948));

      /* Empieza nodo:949 / Elemento padre: 948   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(949)).setAttribute("src","b.gif" );
      ((Element)v.get(949)).setAttribute("width","8" );
      ((Element)v.get(949)).setAttribute("height","8" );
      ((Element)v.get(948)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */
      /* Termina nodo:948   */
      /* Termina nodo:933   */

      /* Empieza nodo:950 / Elemento padre: 929   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(929)).appendChild((Element)v.get(950));

      /* Empieza nodo:951 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(951));

      /* Empieza nodo:952 / Elemento padre: 951   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(952)).setAttribute("src","b.gif" );
      ((Element)v.get(952)).setAttribute("width","8" );
      ((Element)v.get(952)).setAttribute("height","8" );
      ((Element)v.get(951)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */
      /* Termina nodo:951   */

      /* Empieza nodo:953 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(953));

      /* Empieza nodo:954 / Elemento padre: 953   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(954)).setAttribute("nombre","lblNumeroCondicionXX20" );
      ((Element)v.get(954)).setAttribute("ancho","60" );
      ((Element)v.get(954)).setAttribute("alto","17" );
      ((Element)v.get(954)).setAttribute("filas","1" );
      ((Element)v.get(954)).setAttribute("valor","1" );
      ((Element)v.get(954)).setAttribute("id","datosCampos" );
      ((Element)v.get(953)).appendChild((Element)v.get(954));
      /* Termina nodo:954   */
      /* Termina nodo:953   */

      /* Empieza nodo:955 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(955));

      /* Empieza nodo:956 / Elemento padre: 955   */
   }

   private void getXML3870(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(956)).setAttribute("src","b.gif" );
      ((Element)v.get(956)).setAttribute("width","25" );
      ((Element)v.get(956)).setAttribute("height","8" );
      ((Element)v.get(955)).appendChild((Element)v.get(956));
      /* Termina nodo:956   */
      /* Termina nodo:955   */

      /* Empieza nodo:957 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(957));

      /* Empieza nodo:958 / Elemento padre: 957   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(958)).setAttribute("nombre","lblIndicadorCuadreXX20" );
      ((Element)v.get(958)).setAttribute("ancho","" );
      ((Element)v.get(958)).setAttribute("alto","17" );
      ((Element)v.get(958)).setAttribute("filas","1" );
      ((Element)v.get(958)).setAttribute("valor","Cuadre al mayor por unidades" );
      ((Element)v.get(958)).setAttribute("id","datosCampos" );
      ((Element)v.get(957)).appendChild((Element)v.get(958));
      /* Termina nodo:958   */
      /* Termina nodo:957   */

      /* Empieza nodo:959 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(959));

      /* Empieza nodo:960 / Elemento padre: 959   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(960)).setAttribute("src","b.gif" );
      ((Element)v.get(960)).setAttribute("width","25" );
      ((Element)v.get(960)).setAttribute("height","8" );
      ((Element)v.get(959)).appendChild((Element)v.get(960));
      /* Termina nodo:960   */
      /* Termina nodo:959   */

      /* Empieza nodo:961 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(961));

      /* Empieza nodo:962 / Elemento padre: 961   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(962)).setAttribute("nombre","lblFactorCuadreXX20" );
      ((Element)v.get(962)).setAttribute("ancho","130" );
      ((Element)v.get(962)).setAttribute("alto","17" );
      ((Element)v.get(962)).setAttribute("filas","1" );
      ((Element)v.get(962)).setAttribute("valor","5" );
      ((Element)v.get(962)).setAttribute("id","datosCampos" );
      ((Element)v.get(961)).appendChild((Element)v.get(962));
      /* Termina nodo:962   */
      /* Termina nodo:961   */

      /* Empieza nodo:963 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(963)).setAttribute("width","1" );
      ((Element)v.get(950)).appendChild((Element)v.get(963));

      /* Empieza nodo:964 / Elemento padre: 963   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(964)).setAttribute("src","b.gif" );
      ((Element)v.get(964)).setAttribute("width","8" );
      ((Element)v.get(964)).setAttribute("height","8" );
      ((Element)v.get(963)).appendChild((Element)v.get(964));
      /* Termina nodo:964   */
      /* Termina nodo:963   */

      /* Empieza nodo:965 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(965)).setAttribute("width","100%" );
      ((Element)v.get(950)).appendChild((Element)v.get(965));

      /* Empieza nodo:966 / Elemento padre: 965   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(966)).setAttribute("src","b.gif" );
      ((Element)v.get(966)).setAttribute("width","8" );
      ((Element)v.get(966)).setAttribute("height","8" );
      ((Element)v.get(965)).appendChild((Element)v.get(966));
      /* Termina nodo:966   */
      /* Termina nodo:965   */
      /* Termina nodo:950   */

      /* Empieza nodo:967 / Elemento padre: 929   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(929)).appendChild((Element)v.get(967));

      /* Empieza nodo:968 / Elemento padre: 967   */
      v.add(doc.createElement("td"));
      ((Element)v.get(968)).setAttribute("colspan","4" );
      ((Element)v.get(967)).appendChild((Element)v.get(968));

      /* Empieza nodo:969 / Elemento padre: 968   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(969)).setAttribute("src","b.gif" );
      ((Element)v.get(969)).setAttribute("width","8" );
      ((Element)v.get(969)).setAttribute("height","310" );
      ((Element)v.get(968)).appendChild((Element)v.get(969));
      /* Termina nodo:969   */
      /* Termina nodo:968   */
      /* Termina nodo:967   */
      /* Termina nodo:929   */
      /* Termina nodo:928   */
      /* Termina nodo:927   */
      /* Termina nodo:926   */
      /* Termina nodo:925   */
      /* Termina nodo:924   */

      /* Empieza nodo:970 / Elemento padre: 921   */
      v.add(doc.createElement("td"));
      ((Element)v.get(921)).appendChild((Element)v.get(970));

      /* Empieza nodo:971 / Elemento padre: 970   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(971)).setAttribute("src","b.gif" );
      ((Element)v.get(971)).setAttribute("width","12" );
      ((Element)v.get(971)).setAttribute("height","12" );
      ((Element)v.get(970)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */
      /* Termina nodo:970   */
      /* Termina nodo:921   */

      /* Empieza nodo:972 / Elemento padre: 917   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(917)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(973));

      /* Empieza nodo:974 / Elemento padre: 973   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(974)).setAttribute("src","b.gif" );
      ((Element)v.get(974)).setAttribute("width","0" );
      ((Element)v.get(974)).setAttribute("height","0" );
      ((Element)v.get(973)).appendChild((Element)v.get(974));
      /* Termina nodo:974   */
      /* Termina nodo:973   */

      /* Empieza nodo:975 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(975));

      /* Empieza nodo:976 / Elemento padre: 975   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(975)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("table"));
      ((Element)v.get(977)).setAttribute("width","100%" );
      ((Element)v.get(977)).setAttribute("border","0" );
      ((Element)v.get(977)).setAttribute("align","center" );
      ((Element)v.get(977)).setAttribute("cellspacing","0" );
      ((Element)v.get(977)).setAttribute("cellpadding","0" );
      ((Element)v.get(976)).appendChild((Element)v.get(977));

      /* Empieza nodo:978 / Elemento padre: 977   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(977)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("td"));
      ((Element)v.get(979)).setAttribute("class","botonera" );
      ((Element)v.get(979)).setAttribute("width","100%" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(978)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(980)).setAttribute("nombre","btnEliminar0" );
      ((Element)v.get(980)).setAttribute("ID","botonContenido" );
      ((Element)v.get(980)).setAttribute("tipo","html" );
      ((Element)v.get(980)).setAttribute("accion","accionEliminarCondicion('btnEliminar0');" );
      ((Element)v.get(980)).setAttribute("estado","false" );
      ((Element)v.get(980)).setAttribute("cod","1254" );
      ((Element)v.get(980)).setAttribute("codigo","1" );
      ((Element)v.get(979)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */
      /* Termina nodo:979   */
      /* Termina nodo:978   */
      /* Termina nodo:977   */
      /* Termina nodo:976   */
      /* Termina nodo:975   */

      /* Empieza nodo:981 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(981));

      /* Empieza nodo:982 / Elemento padre: 981   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(982)).setAttribute("src","b.gif" );
      ((Element)v.get(982)).setAttribute("width","12" );
      ((Element)v.get(982)).setAttribute("height","12" );
      ((Element)v.get(981)).appendChild((Element)v.get(982));
      /* Termina nodo:982   */
      /* Termina nodo:981   */
      /* Termina nodo:972   */

      /* Empieza nodo:983 / Elemento padre: 917   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(917)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(984)).setAttribute("colspan","3" );
      ((Element)v.get(983)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(985)).setAttribute("src","b.gif" );
      ((Element)v.get(985)).setAttribute("width","12" );
      ((Element)v.get(985)).setAttribute("height","12" );
      ((Element)v.get(984)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */
      /* Termina nodo:984   */
      /* Termina nodo:983   */
      /* Termina nodo:917   */
      /* Termina nodo:914   */
      /* Termina nodo:913   */

      /* Empieza nodo:986 / Elemento padre: 910   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).appendChild((Element)v.get(986));

      /* Empieza nodo:987 / Elemento padre: 986   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(987)).setAttribute("src","b.gif" );
      ((Element)v.get(987)).setAttribute("width","12" );
      ((Element)v.get(987)).setAttribute("height","12" );
      ((Element)v.get(986)).appendChild((Element)v.get(987));
      /* Termina nodo:987   */
      /* Termina nodo:986   */
      /* Termina nodo:910   */

      /* Empieza nodo:988 / Elemento padre: 902   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(902)).appendChild((Element)v.get(988));

      /* Empieza nodo:989 / Elemento padre: 988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(988)).appendChild((Element)v.get(989));

      /* Empieza nodo:990 / Elemento padre: 989   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(990)).setAttribute("src","b.gif" );
      ((Element)v.get(990)).setAttribute("width","12" );
      ((Element)v.get(990)).setAttribute("height","12" );
      ((Element)v.get(989)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */
      /* Termina nodo:989   */

      /* Empieza nodo:991 / Elemento padre: 988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(988)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(991)).appendChild((Element)v.get(992));

      /* Empieza nodo:993 / Elemento padre: 992   */
      v.add(doc.createElement("table"));
      ((Element)v.get(993)).setAttribute("width","100%" );
      ((Element)v.get(993)).setAttribute("border","0" );
      ((Element)v.get(993)).setAttribute("align","center" );
      ((Element)v.get(993)).setAttribute("cellspacing","0" );
      ((Element)v.get(993)).setAttribute("cellpadding","0" );
      ((Element)v.get(992)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(993)).appendChild((Element)v.get(994));

      /* Empieza nodo:995 / Elemento padre: 994   */
      v.add(doc.createElement("td"));
      ((Element)v.get(994)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(996)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(996)).setAttribute("ID","botonContenido" );
      ((Element)v.get(996)).setAttribute("tipo","html" );
      ((Element)v.get(996)).setAttribute("accion","accionAniadirCondicion();" );
      ((Element)v.get(996)).setAttribute("estado","false" );
      ((Element)v.get(996)).setAttribute("cod","404" );
      ((Element)v.get(995)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */
      /* Termina nodo:995   */
      /* Termina nodo:994   */
      /* Termina nodo:993   */
      /* Termina nodo:992   */
      /* Termina nodo:991   */

      /* Empieza nodo:997 / Elemento padre: 988   */
      v.add(doc.createElement("td"));
      ((Element)v.get(988)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(998)).setAttribute("src","b.gif" );
      ((Element)v.get(998)).setAttribute("width","12" );
      ((Element)v.get(998)).setAttribute("height","12" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */
      /* Termina nodo:988   */

      /* Empieza nodo:999 / Elemento padre: 902   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(902)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1000)).setAttribute("width","12" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));

      /* Empieza nodo:1001 / Elemento padre: 1000   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1001)).setAttribute("src","b.gif" );
      ((Element)v.get(1001)).setAttribute("width","12" );
      ((Element)v.get(1001)).setAttribute("height","12" );
      ((Element)v.get(1000)).appendChild((Element)v.get(1001));
      /* Termina nodo:1001   */
      /* Termina nodo:1000   */

      /* Empieza nodo:1002 / Elemento padre: 999   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1002)).setAttribute("width","100%" );
      ((Element)v.get(999)).appendChild((Element)v.get(1002));

      /* Empieza nodo:1003 / Elemento padre: 1002   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1003)).setAttribute("src","b.gif" );
      ((Element)v.get(1003)).setAttribute("width","0" );
      ((Element)v.get(1003)).setAttribute("height","0" );
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(1002)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */
      /* Termina nodo:1002   */

      /* Empieza nodo:1004 / Elemento padre: 999   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1004)).setAttribute("width","12" );
      ((Element)v.get(999)).appendChild((Element)v.get(1004));

      /* Empieza nodo:1005 / Elemento padre: 1004   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1005)).setAttribute("src","b.gif" );
      ((Element)v.get(1005)).setAttribute("width","12" );
      ((Element)v.get(1005)).setAttribute("height","12" );
      ((Element)v.get(1004)).appendChild((Element)v.get(1005));
      /* Termina nodo:1005   */
      /* Termina nodo:1004   */
      /* Termina nodo:999   */
      /* Termina nodo:902   */
      /* Termina nodo:901   */

      /* Empieza nodo:1006 / Elemento padre: 900   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1006)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(1006)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1006)).setAttribute("y","993" );
      ((Element)v.get(1006)).setAttribute("x","32" );
      ((Element)v.get(1006)).setAttribute("alto","290" );
      ((Element)v.get(1006)).setAttribute("ancho","800" );
      ((Element)v.get(1006)).setAttribute("nombre","listado30" );
      ((Element)v.get(900)).appendChild((Element)v.get(1006));

      /* Empieza nodo:1007 / Elemento padre: 1006   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1007)).setAttribute("conROver","S" );
      ((Element)v.get(1007)).setAttribute("precarga","S" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1008)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1008)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1008)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1008)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));
      /* Termina nodo:1008   */

      /* Empieza nodo:1009 / Elemento padre: 1007   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1009)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1009)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1009)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1009)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1009));
      /* Termina nodo:1009   */
      /* Termina nodo:1007   */

      /* Empieza nodo:1010 / Elemento padre: 1006   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1006)).appendChild((Element)v.get(1010));

      /* Empieza nodo:1011 / Elemento padre: 1010   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1011)).setAttribute("vertical","0" );
      ((Element)v.get(1011)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1011)).setAttribute("horizDatos","1" );
      ((Element)v.get(1011)).setAttribute("borde","1" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1011));
      /* Termina nodo:1011   */

      /* Empieza nodo:1012 / Elemento padre: 1010   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1012)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1012)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(1012)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(1012)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(1012)).setAttribute("borde","#999999" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1012));
      /* Termina nodo:1012   */
      /* Termina nodo:1010   */

      /* Empieza nodo:1013 / Elemento padre: 1006   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1013)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1013)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1013)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1013)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1013)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1014)).setAttribute("minimizada","N" );
      ((Element)v.get(1014)).setAttribute("minimizable","S" );
      ((Element)v.get(1014)).setAttribute("ancho","100" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));
      /* Termina nodo:1014   */

      /* Empieza nodo:1015 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1015)).setAttribute("minimizada","N" );
      ((Element)v.get(1015)).setAttribute("minimizable","S" );
      ((Element)v.get(1015)).setAttribute("ancho","100" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1015));
      /* Termina nodo:1015   */

      /* Empieza nodo:1016 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1016)).setAttribute("minimizada","N" );
      ((Element)v.get(1016)).setAttribute("minimizable","S" );
      ((Element)v.get(1016)).setAttribute("ancho","100" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1016));
      /* Termina nodo:1016   */

      /* Empieza nodo:1017 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1017)).setAttribute("minimizada","N" );
      ((Element)v.get(1017)).setAttribute("minimizable","S" );
      ((Element)v.get(1017)).setAttribute("ancho","100" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1017));
      /* Termina nodo:1017   */

      /* Empieza nodo:1018 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1018)).setAttribute("minimizada","N" );
      ((Element)v.get(1018)).setAttribute("minimizable","S" );
      ((Element)v.get(1018)).setAttribute("ancho","100" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1018));
      /* Termina nodo:1018   */
      /* Termina nodo:1013   */

      /* Empieza nodo:1019 / Elemento padre: 1006   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1019)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1019)).setAttribute("imgFondo","" );
      ((Element)v.get(1019)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1019)).setAttribute("alto","20" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1019));

      /* Empieza nodo:1020 / Elemento padre: 1019   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1020)).setAttribute("cod","516" );
      ((Element)v.get(1020)).setAttribute("align","center" );
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(1020)).setAttribute("ID","EstCab" );
      ((Element)v.get(1020)).setAttribute("colFondo","" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1020));
      /* Termina nodo:1020   */

      /* Empieza nodo:1021 / Elemento padre: 1019   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1021)).setAttribute("cod","593" );
      ((Element)v.get(1021)).setAttribute("align","center" );
      ((Element)v.get(1021)).setAttribute("ID","EstCab" );
      ((Element)v.get(1021)).setAttribute("colFondo","" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1021));
      /* Termina nodo:1021   */

      /* Empieza nodo:1022 / Elemento padre: 1019   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1022)).setAttribute("cod","555" );
      ((Element)v.get(1022)).setAttribute("align","center" );
      ((Element)v.get(1022)).setAttribute("ID","EstCab" );
      ((Element)v.get(1022)).setAttribute("colFondo","" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1022));
      /* Termina nodo:1022   */

      /* Empieza nodo:1023 / Elemento padre: 1019   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1023)).setAttribute("cod","145" );
      ((Element)v.get(1023)).setAttribute("align","center" );
      ((Element)v.get(1023)).setAttribute("ID","EstCab" );
      ((Element)v.get(1023)).setAttribute("colFondo","" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1023));
      /* Termina nodo:1023   */

      /* Empieza nodo:1024 / Elemento padre: 1019   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1024)).setAttribute("cod","553" );
      ((Element)v.get(1024)).setAttribute("align","center" );
      ((Element)v.get(1024)).setAttribute("ID","EstCab" );
      ((Element)v.get(1024)).setAttribute("colFondo","" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1024));
      /* Termina nodo:1024   */
      /* Termina nodo:1019   */

      /* Empieza nodo:1025 / Elemento padre: 1006   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1025)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1025)).setAttribute("onLoad","" );
      ((Element)v.get(1025)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1025)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1025)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1025)).setAttribute("maxSel","-1" );
      ((Element)v.get(1025)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1025)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1025)).setAttribute("accion","" );
      ((Element)v.get(1025)).setAttribute("alto","22" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1025));

      /* Empieza nodo:1026 / Elemento padre: 1025   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1026)).setAttribute("tipo","texto" );
      ((Element)v.get(1026)).setAttribute("ID","EstDat" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1026));
      /* Termina nodo:1026   */

      /* Empieza nodo:1027 / Elemento padre: 1025   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1027)).setAttribute("tipo","texto" );
      ((Element)v.get(1027)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1027));
      /* Termina nodo:1027   */

      /* Empieza nodo:1028 / Elemento padre: 1025   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1028)).setAttribute("tipo","texto" );
      ((Element)v.get(1028)).setAttribute("ID","EstDat" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1028));
      /* Termina nodo:1028   */

      /* Empieza nodo:1029 / Elemento padre: 1025   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1029)).setAttribute("tipo","texto" );
      ((Element)v.get(1029)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1029));
      /* Termina nodo:1029   */

      /* Empieza nodo:1030 / Elemento padre: 1025   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1030)).setAttribute("tipo","texto" );
      ((Element)v.get(1030)).setAttribute("ID","EstDat" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1030));
      /* Termina nodo:1030   */
      /* Termina nodo:1025   */

      /* Empieza nodo:1031 / Elemento padre: 1006   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1006)).appendChild((Element)v.get(1031));

      /* Empieza nodo:1032 / Elemento padre: 1031   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1032)).setAttribute("ID","1" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1032));

      /* Empieza nodo:1033 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1033)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(1033)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1033)).setAttribute("VALOR","50" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1033));
      /* Termina nodo:1033   */

      /* Empieza nodo:1034 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1034)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1034)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1034)).setAttribute("VALOR","PRE-Catalog1" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1034));
      /* Termina nodo:1034   */

      /* Empieza nodo:1035 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1035)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1035)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1035)).setAttribute("VALOR","Rango de páginas" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1035));
      /* Termina nodo:1035   */

      /* Empieza nodo:1036 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1036)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1036)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1036)).setAttribute("VALOR","1" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1036));
      /* Termina nodo:1036   */

      /* Empieza nodo:1037 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1037)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1037)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1037)).setAttribute("VALOR","1" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1037));
      /* Termina nodo:1037   */

      /* Empieza nodo:1038 / Elemento padre: 1032   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(1038)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1038)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1038)).setAttribute("VALOR","N" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1038));
      /* Termina nodo:1038   */
      /* Termina nodo:1032   */
      /* Termina nodo:1031   */

      /* Empieza nodo:1039 / Elemento padre: 1006   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1039)).setAttribute("cargainicial","N" );
      ((Element)v.get(1039)).setAttribute("rowset","" );
      ((Element)v.get(1039)).setAttribute("conector","conector_textarea" );
      ((Element)v.get(1039)).setAttribute("control","|" );
      ((Element)v.get(1039)).setAttribute("y","1291" );
      ((Element)v.get(1039)).setAttribute("class","botonera" );
      ((Element)v.get(1039)).setAttribute("x","32" );
      ((Element)v.get(1039)).setAttribute("sep","$" );
      ((Element)v.get(1039)).setAttribute("ancho","240" );
      ((Element)v.get(1039)).setAttribute("nombre","mipgndo30" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1039));

      /* Empieza nodo:1040 / Elemento padre: 1039   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1040)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(1040)).setAttribute("codigo","" );
      ((Element)v.get(1040)).setAttribute("alt","" );
      ((Element)v.get(1040)).setAttribute("estado","false" );
      ((Element)v.get(1040)).setAttribute("tipo","0" );
      ((Element)v.get(1040)).setAttribute("img","primera_on" );
      ((Element)v.get(1040)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1040)).setAttribute("y","1291" );
      ((Element)v.get(1040)).setAttribute("x","270" );
      ((Element)v.get(1040)).setAttribute("nombre","listado30_pri1" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1040));
      /* Termina nodo:1040   */

      /* Empieza nodo:1041 / Elemento padre: 1039   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1041)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(1041)).setAttribute("codigo","" );
      ((Element)v.get(1041)).setAttribute("alt","" );
      ((Element)v.get(1041)).setAttribute("estado","false" );
      ((Element)v.get(1041)).setAttribute("tipo","0" );
      ((Element)v.get(1041)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1041)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1041)).setAttribute("y","1291" );
      ((Element)v.get(1041)).setAttribute("x","287" );
      ((Element)v.get(1041)).setAttribute("nombre","listado30_ret1" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1041));
      /* Termina nodo:1041   */

      /* Empieza nodo:1042 / Elemento padre: 1039   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1042)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(1042)).setAttribute("codigo","" );
      ((Element)v.get(1042)).setAttribute("alt","" );
      ((Element)v.get(1042)).setAttribute("estado","false" );
      ((Element)v.get(1042)).setAttribute("tipo","0" );
      ((Element)v.get(1042)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1042)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1042)).setAttribute("y","1291" );
      ((Element)v.get(1042)).setAttribute("x","302" );
      ((Element)v.get(1042)).setAttribute("nombre","listado30_ava1" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1042));
      /* Termina nodo:1042   */

      /* Empieza nodo:1043 / Elemento padre: 1039   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1043)).setAttribute("tipo","html" );
      ((Element)v.get(1043)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1043)).setAttribute("nombre","Modificar30" );
      ((Element)v.get(1043)).setAttribute("estado","true" );
      ((Element)v.get(1043)).setAttribute("cod","2" );
      ((Element)v.get(1043)).setAttribute("accion","accionModificarCondicion(1);" );
      ((Element)v.get(1043)).setAttribute("x","33" );
      ((Element)v.get(1043)).setAttribute("y","1245" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1043));
      /* Termina nodo:1043   */
      /* Termina nodo:1039   */
      /* Termina nodo:1006   */
      /* Termina nodo:900   */

      /* Empieza nodo:1044 / Elemento padre: 6   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(6)).appendChild((Element)v.get(1044));

      /* Empieza nodo:1045 / Elemento padre: 1044   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1045)).setAttribute("nombre","capaGrupos" );
      ((Element)v.get(1045)).setAttribute("alto","100%" );
      ((Element)v.get(1045)).setAttribute("ancho","100%" );
      ((Element)v.get(1045)).setAttribute("colorf","" );
      ((Element)v.get(1045)).setAttribute("borde","0" );
      ((Element)v.get(1045)).setAttribute("imagenf","" );
      ((Element)v.get(1045)).setAttribute("repeat","" );
      ((Element)v.get(1045)).setAttribute("padding","" );
      ((Element)v.get(1045)).setAttribute("visibilidad","visible" );
      ((Element)v.get(1045)).setAttribute("contravsb","" );
      ((Element)v.get(1045)).setAttribute("x","0" );
      ((Element)v.get(1045)).setAttribute("y","1370" );
      ((Element)v.get(1045)).setAttribute("zindex","" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1045));

      /* Empieza nodo:1046 / Elemento padre: 1045   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1046)).setAttribute("width","100%" );
      ((Element)v.get(1046)).setAttribute("border","0" );
      ((Element)v.get(1046)).setAttribute("cellspacing","0" );
      ((Element)v.get(1046)).setAttribute("cellpadding","0" );
      ((Element)v.get(1045)).appendChild((Element)v.get(1046));

      /* Empieza nodo:1047 / Elemento padre: 1046   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1046)).appendChild((Element)v.get(1047));

      /* Empieza nodo:1048 / Elemento padre: 1047   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1047)).appendChild((Element)v.get(1048));

      /* Empieza nodo:1049 / Elemento padre: 1048   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(1049)).setAttribute("src","b.gif" );
      ((Element)v.get(1049)).setAttribute("width","12" );
      ((Element)v.get(1049)).setAttribute("height","12" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1049));
      /* Termina nodo:1049   */
      /* Termina nodo:1048   */

      /* Empieza nodo:1050 / Elemento padre: 1047   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1050)).setAttribute("width","100%" );
      ((Element)v.get(1047)).appendChild((Element)v.get(1050));

      /* Empieza nodo:1051 / Elemento padre: 1050   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1051)).setAttribute("src","b.gif" );
      ((Element)v.get(1051)).setAttribute("width","1" );
      ((Element)v.get(1051)).setAttribute("height","1" );
      ((Element)v.get(1050)).appendChild((Element)v.get(1051));
      /* Termina nodo:1051   */
      /* Termina nodo:1050   */

      /* Empieza nodo:1052 / Elemento padre: 1047   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1047)).appendChild((Element)v.get(1052));

      /* Empieza nodo:1053 / Elemento padre: 1052   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1053)).setAttribute("src","b.gif" );
      ((Element)v.get(1053)).setAttribute("width","12" );
      ((Element)v.get(1053)).setAttribute("height","12" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1053));
      /* Termina nodo:1053   */
      /* Termina nodo:1052   */
      /* Termina nodo:1047   */

      /* Empieza nodo:1054 / Elemento padre: 1046   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1046)).appendChild((Element)v.get(1054));

      /* Empieza nodo:1055 / Elemento padre: 1054   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1054)).appendChild((Element)v.get(1055));

      /* Empieza nodo:1056 / Elemento padre: 1055   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1056)).setAttribute("src","b.gif" );
      ((Element)v.get(1056)).setAttribute("width","12" );
      ((Element)v.get(1056)).setAttribute("height","12" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1056));
      /* Termina nodo:1056   */
      /* Termina nodo:1055   */

      /* Empieza nodo:1057 / Elemento padre: 1054   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1054)).appendChild((Element)v.get(1057));

      /* Empieza nodo:1058 / Elemento padre: 1057   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1057)).appendChild((Element)v.get(1058));

      /* Empieza nodo:1059 / Elemento padre: 1058   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(1059)).setAttribute("class","legend" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1059));

      /* Empieza nodo:1060 / Elemento padre: 1059   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1060)).setAttribute("nombre","lblGrupos" );
      ((Element)v.get(1060)).setAttribute("ancho","50" );
      ((Element)v.get(1060)).setAttribute("alto","13" );
      ((Element)v.get(1060)).setAttribute("filas","1" );
      ((Element)v.get(1060)).setAttribute("valor","" );
      ((Element)v.get(1060)).setAttribute("id","legend" );
      ((Element)v.get(1060)).setAttribute("cod","545" );
      ((Element)v.get(1059)).appendChild((Element)v.get(1060));
      /* Termina nodo:1060   */
      /* Termina nodo:1059   */

      /* Empieza nodo:1061 / Elemento padre: 1058   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1061)).setAttribute("width","100%" );
      ((Element)v.get(1061)).setAttribute("border","0" );
      ((Element)v.get(1061)).setAttribute("align","center" );
      ((Element)v.get(1061)).setAttribute("cellspacing","0" );
      ((Element)v.get(1061)).setAttribute("cellpadding","0" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1061));

      /* Empieza nodo:1062 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1062));

      /* Empieza nodo:1063 / Elemento padre: 1062   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1063)).setAttribute("colspan","3" );
      ((Element)v.get(1062)).appendChild((Element)v.get(1063));

      /* Empieza nodo:1064 / Elemento padre: 1063   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1064)).setAttribute("src","b.gif" );
      ((Element)v.get(1064)).setAttribute("width","12" );
      ((Element)v.get(1064)).setAttribute("height","12" );
      ((Element)v.get(1063)).appendChild((Element)v.get(1064));
      /* Termina nodo:1064   */
      /* Termina nodo:1063   */
      /* Termina nodo:1062   */

      /* Empieza nodo:1065 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1065));

      /* Empieza nodo:1066 / Elemento padre: 1065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1065)).appendChild((Element)v.get(1066));

      /* Empieza nodo:1067 / Elemento padre: 1066   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1067)).setAttribute("src","b.gif" );
      ((Element)v.get(1067)).setAttribute("width","8" );
      ((Element)v.get(1067)).setAttribute("height","8" );
      ((Element)v.get(1066)).appendChild((Element)v.get(1067));
      /* Termina nodo:1067   */
      /* Termina nodo:1066   */

      /* Empieza nodo:1068 / Elemento padre: 1065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1068)).setAttribute("width","100%" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1068));

      /* Empieza nodo:1069 / Elemento padre: 1068   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1069)).setAttribute("width","100%" );
      ((Element)v.get(1069)).setAttribute("border","0" );
      ((Element)v.get(1069)).setAttribute("cellspacing","0" );
      ((Element)v.get(1069)).setAttribute("cellpadding","0" );
      ((Element)v.get(1068)).appendChild((Element)v.get(1069));

      /* Empieza nodo:1070 / Elemento padre: 1069   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1069)).appendChild((Element)v.get(1070));

      /* Empieza nodo:1071 / Elemento padre: 1070   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1070)).appendChild((Element)v.get(1071));

      /* Empieza nodo:1072 / Elemento padre: 1071   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1071)).appendChild((Element)v.get(1072));

      /* Empieza nodo:1073 / Elemento padre: 1072   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1073)).setAttribute("width","100%" );
      ((Element)v.get(1073)).setAttribute("border","0" );
      ((Element)v.get(1073)).setAttribute("cellspacing","0" );
      ((Element)v.get(1073)).setAttribute("align","center" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(1073)).setAttribute("cellpadding","0" );
      ((Element)v.get(1072)).appendChild((Element)v.get(1073));

      /* Empieza nodo:1074 / Elemento padre: 1073   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1073)).appendChild((Element)v.get(1074));

      /* Empieza nodo:1075 / Elemento padre: 1074   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1075)).setAttribute("colspan","4" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1075));

      /* Empieza nodo:1076 / Elemento padre: 1075   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1076)).setAttribute("src","b.gif" );
      ((Element)v.get(1076)).setAttribute("width","8" );
      ((Element)v.get(1076)).setAttribute("height","8" );
      ((Element)v.get(1075)).appendChild((Element)v.get(1076));
      /* Termina nodo:1076   */
      /* Termina nodo:1075   */
      /* Termina nodo:1074   */

      /* Empieza nodo:1077 / Elemento padre: 1073   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1073)).appendChild((Element)v.get(1077));

      /* Empieza nodo:1078 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1078));

      /* Empieza nodo:1079 / Elemento padre: 1078   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1079)).setAttribute("src","b.gif" );
      ((Element)v.get(1079)).setAttribute("width","8" );
      ((Element)v.get(1079)).setAttribute("height","8" );
      ((Element)v.get(1078)).appendChild((Element)v.get(1079));
      /* Termina nodo:1079   */
      /* Termina nodo:1078   */

      /* Empieza nodo:1080 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1080));

      /* Empieza nodo:1081 / Elemento padre: 1080   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1081)).setAttribute("nombre","lblNumeroCondicion1231" );
      ((Element)v.get(1081)).setAttribute("ancho","110" );
      ((Element)v.get(1081)).setAttribute("alto","17" );
      ((Element)v.get(1081)).setAttribute("filas","1" );
      ((Element)v.get(1081)).setAttribute("valor","" );
      ((Element)v.get(1081)).setAttribute("id","datosTitle" );
      ((Element)v.get(1081)).setAttribute("cod","533" );
      ((Element)v.get(1080)).appendChild((Element)v.get(1081));
      /* Termina nodo:1081   */
      /* Termina nodo:1080   */

      /* Empieza nodo:1082 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1082));

      /* Empieza nodo:1083 / Elemento padre: 1082   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1083)).setAttribute("src","b.gif" );
      ((Element)v.get(1083)).setAttribute("width","25" );
      ((Element)v.get(1083)).setAttribute("height","8" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1083));
      /* Termina nodo:1083   */
      /* Termina nodo:1082   */

      /* Empieza nodo:1084 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1084));

      /* Empieza nodo:1085 / Elemento padre: 1084   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1085)).setAttribute("nombre","lblIndicadorCuadre1231" );
      ((Element)v.get(1085)).setAttribute("ancho","110" );
      ((Element)v.get(1085)).setAttribute("alto","17" );
      ((Element)v.get(1085)).setAttribute("filas","1" );
      ((Element)v.get(1085)).setAttribute("valor","" );
      ((Element)v.get(1085)).setAttribute("id","datosTitle" );
      ((Element)v.get(1085)).setAttribute("cod","005" );
      ((Element)v.get(1084)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */
      /* Termina nodo:1084   */

      /* Empieza nodo:1086 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1086));

      /* Empieza nodo:1087 / Elemento padre: 1086   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1087)).setAttribute("src","b.gif" );
      ((Element)v.get(1087)).setAttribute("width","25" );
      ((Element)v.get(1087)).setAttribute("height","8" );
      ((Element)v.get(1086)).appendChild((Element)v.get(1087));
      /* Termina nodo:1087   */
      /* Termina nodo:1086   */

      /* Empieza nodo:1088 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1088));

      /* Empieza nodo:1089 / Elemento padre: 1088   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1089)).setAttribute("nombre","lblFactorCuadre1231" );
      ((Element)v.get(1089)).setAttribute("ancho","120" );
      ((Element)v.get(1089)).setAttribute("alto","17" );
      ((Element)v.get(1089)).setAttribute("filas","1" );
      ((Element)v.get(1089)).setAttribute("valor","" );
      ((Element)v.get(1089)).setAttribute("id","datosTitle" );
      ((Element)v.get(1089)).setAttribute("cod","006" );
      ((Element)v.get(1088)).appendChild((Element)v.get(1089));
      /* Termina nodo:1089   */
      /* Termina nodo:1088   */

      /* Empieza nodo:1090 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1090));

      /* Empieza nodo:1091 / Elemento padre: 1090   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1091)).setAttribute("src","b.gif" );
      ((Element)v.get(1091)).setAttribute("width","25" );
      ((Element)v.get(1091)).setAttribute("height","8" );
      ((Element)v.get(1090)).appendChild((Element)v.get(1091));
      /* Termina nodo:1091   */
      /* Termina nodo:1090   */

      /* Empieza nodo:1092 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1077)).appendChild((Element)v.get(1092));

      /* Empieza nodo:1093 / Elemento padre: 1092   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1093)).setAttribute("nombre","lblTipoGrupo11" );
      ((Element)v.get(1093)).setAttribute("ancho","130" );
      ((Element)v.get(1093)).setAttribute("alto","17" );
      ((Element)v.get(1093)).setAttribute("filas","1" );
      ((Element)v.get(1093)).setAttribute("valor","" );
      ((Element)v.get(1093)).setAttribute("id","datosTitle" );
      ((Element)v.get(1093)).setAttribute("cod","479" );
      ((Element)v.get(1092)).appendChild((Element)v.get(1093));
      /* Termina nodo:1093   */
      /* Termina nodo:1092   */

      /* Empieza nodo:1094 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1094)).setAttribute("width","88" );
      ((Element)v.get(1077)).appendChild((Element)v.get(1094));

      /* Empieza nodo:1095 / Elemento padre: 1094   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(1095)).setAttribute("src","b.gif" );
      ((Element)v.get(1095)).setAttribute("width","81" );
      ((Element)v.get(1095)).setAttribute("height","8" );
      ((Element)v.get(1094)).appendChild((Element)v.get(1095));
      /* Termina nodo:1095   */
      /* Termina nodo:1094   */

      /* Empieza nodo:1096 / Elemento padre: 1077   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1096)).setAttribute("width","100%" );
      ((Element)v.get(1077)).appendChild((Element)v.get(1096));

      /* Empieza nodo:1097 / Elemento padre: 1096   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1097)).setAttribute("src","b.gif" );
      ((Element)v.get(1097)).setAttribute("width","8" );
      ((Element)v.get(1097)).setAttribute("height","8" );
      ((Element)v.get(1096)).appendChild((Element)v.get(1097));
      /* Termina nodo:1097   */
      /* Termina nodo:1096   */
      /* Termina nodo:1077   */

      /* Empieza nodo:1098 / Elemento padre: 1073   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1073)).appendChild((Element)v.get(1098));

      /* Empieza nodo:1099 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1099));

      /* Empieza nodo:1100 / Elemento padre: 1099   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1100)).setAttribute("src","b.gif" );
      ((Element)v.get(1100)).setAttribute("width","8" );
      ((Element)v.get(1100)).setAttribute("height","8" );
      ((Element)v.get(1099)).appendChild((Element)v.get(1100));
      /* Termina nodo:1100   */
      /* Termina nodo:1099   */

      /* Empieza nodo:1101 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1101));

      /* Empieza nodo:1102 / Elemento padre: 1101   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(1102)).setAttribute("nombre","lblNumeroCondicionXX231" );
      ((Element)v.get(1102)).setAttribute("ancho","60" );
      ((Element)v.get(1102)).setAttribute("alto","17" );
      ((Element)v.get(1102)).setAttribute("filas","1" );
      ((Element)v.get(1102)).setAttribute("valor","1" );
      ((Element)v.get(1102)).setAttribute("id","datosCampos" );
      ((Element)v.get(1101)).appendChild((Element)v.get(1102));
      /* Termina nodo:1102   */
      /* Termina nodo:1101   */

      /* Empieza nodo:1103 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1103));

      /* Empieza nodo:1104 / Elemento padre: 1103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1104)).setAttribute("src","b.gif" );
      ((Element)v.get(1104)).setAttribute("width","25" );
      ((Element)v.get(1104)).setAttribute("height","8" );
      ((Element)v.get(1103)).appendChild((Element)v.get(1104));
      /* Termina nodo:1104   */
      /* Termina nodo:1103   */

      /* Empieza nodo:1105 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1105));

      /* Empieza nodo:1106 / Elemento padre: 1105   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(1106)).setAttribute("nombre","lblIndicadorCuadreXX231" );
      ((Element)v.get(1106)).setAttribute("ancho","" );
      ((Element)v.get(1106)).setAttribute("alto","17" );
      ((Element)v.get(1106)).setAttribute("filas","1" );
      ((Element)v.get(1106)).setAttribute("valor","Cuadre al factor múltiplo" );
      ((Element)v.get(1106)).setAttribute("id","datosCampos" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1106));
      /* Termina nodo:1106   */
      /* Termina nodo:1105   */

      /* Empieza nodo:1107 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1107));

      /* Empieza nodo:1108 / Elemento padre: 1107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1108)).setAttribute("src","b.gif" );
      ((Element)v.get(1108)).setAttribute("width","25" );
      ((Element)v.get(1108)).setAttribute("height","8" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1108));
      /* Termina nodo:1108   */
      /* Termina nodo:1107   */

      /* Empieza nodo:1109 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1109));

      /* Empieza nodo:1110 / Elemento padre: 1109   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(1110)).setAttribute("nombre","lblFactorCuadreXX231" );
      ((Element)v.get(1110)).setAttribute("ancho","130" );
      ((Element)v.get(1110)).setAttribute("alto","17" );
      ((Element)v.get(1110)).setAttribute("filas","1" );
      ((Element)v.get(1110)).setAttribute("valor","" );
      ((Element)v.get(1110)).setAttribute("id","datosCampos" );
      ((Element)v.get(1109)).appendChild((Element)v.get(1110));
      /* Termina nodo:1110   */
      /* Termina nodo:1109   */

      /* Empieza nodo:1111 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1111));

      /* Empieza nodo:1112 / Elemento padre: 1111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1112)).setAttribute("src","b.gif" );
      ((Element)v.get(1112)).setAttribute("width","25" );
      ((Element)v.get(1112)).setAttribute("height","8" );
      ((Element)v.get(1111)).appendChild((Element)v.get(1112));
      /* Termina nodo:1112   */
      /* Termina nodo:1111   */

      /* Empieza nodo:1113 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1098)).appendChild((Element)v.get(1113));

      /* Empieza nodo:1114 / Elemento padre: 1113   */
      v.add(doc.createElement("LABEL"));
      ((Element)v.get(1114)).setAttribute("nombre","lblTipoGrupoXX11" );
      ((Element)v.get(1114)).setAttribute("ancho","130" );
      ((Element)v.get(1114)).setAttribute("alto","17" );
      ((Element)v.get(1114)).setAttribute("filas","1" );
      ((Element)v.get(1114)).setAttribute("valor","Grupo" );
      ((Element)v.get(1114)).setAttribute("id","datosCampos" );
      ((Element)v.get(1113)).appendChild((Element)v.get(1114));
      /* Termina nodo:1114   */
      /* Termina nodo:1113   */

      /* Empieza nodo:1115 / Elemento padre: 1098   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1115)).setAttribute("width","1" );
      ((Element)v.get(1098)).appendChild((Element)v.get(1115));

      /* Empieza nodo:1116 / Elemento padre: 1115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1116)).setAttribute("src","b.gif" );
      ((Element)v.get(1116)).setAttribute("width","8" );
      ((Element)v.get(1116)).setAttribute("height","8" );
      ((Element)v.get(1115)).appendChild((Element)v.get(1116));
      /* Termina nodo:1116   */
      /* Termina nodo:1115   */

      /* Empieza nodo:1117 / Elemento padre: 1098   */
   }

   private void getXML4590(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1117)).setAttribute("width","100%" );
      ((Element)v.get(1098)).appendChild((Element)v.get(1117));

      /* Empieza nodo:1118 / Elemento padre: 1117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1118)).setAttribute("src","b.gif" );
      ((Element)v.get(1118)).setAttribute("width","8" );
      ((Element)v.get(1118)).setAttribute("height","8" );
      ((Element)v.get(1117)).appendChild((Element)v.get(1118));
      /* Termina nodo:1118   */
      /* Termina nodo:1117   */
      /* Termina nodo:1098   */

      /* Empieza nodo:1119 / Elemento padre: 1073   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1073)).appendChild((Element)v.get(1119));

      /* Empieza nodo:1120 / Elemento padre: 1119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1120)).setAttribute("colspan","4" );
      ((Element)v.get(1119)).appendChild((Element)v.get(1120));

      /* Empieza nodo:1121 / Elemento padre: 1120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1121)).setAttribute("src","b.gif" );
      ((Element)v.get(1121)).setAttribute("width","8" );
      ((Element)v.get(1121)).setAttribute("height","310" );
      ((Element)v.get(1120)).appendChild((Element)v.get(1121));
      /* Termina nodo:1121   */
      /* Termina nodo:1120   */
      /* Termina nodo:1119   */
      /* Termina nodo:1073   */
      /* Termina nodo:1072   */
      /* Termina nodo:1071   */
      /* Termina nodo:1070   */
      /* Termina nodo:1069   */
      /* Termina nodo:1068   */

      /* Empieza nodo:1122 / Elemento padre: 1065   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1065)).appendChild((Element)v.get(1122));

      /* Empieza nodo:1123 / Elemento padre: 1122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1123)).setAttribute("src","b.gif" );
      ((Element)v.get(1123)).setAttribute("width","12" );
      ((Element)v.get(1123)).setAttribute("height","12" );
      ((Element)v.get(1122)).appendChild((Element)v.get(1123));
      /* Termina nodo:1123   */
      /* Termina nodo:1122   */
      /* Termina nodo:1065   */

      /* Empieza nodo:1124 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1124));

      /* Empieza nodo:1125 / Elemento padre: 1124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1124)).appendChild((Element)v.get(1125));

      /* Empieza nodo:1126 / Elemento padre: 1125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1126)).setAttribute("src","b.gif" );
      ((Element)v.get(1126)).setAttribute("width","0" );
      ((Element)v.get(1126)).setAttribute("height","0" );
      ((Element)v.get(1125)).appendChild((Element)v.get(1126));
      /* Termina nodo:1126   */
      /* Termina nodo:1125   */

      /* Empieza nodo:1127 / Elemento padre: 1124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1124)).appendChild((Element)v.get(1127));

      /* Empieza nodo:1128 / Elemento padre: 1127   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1127)).appendChild((Element)v.get(1128));

      /* Empieza nodo:1129 / Elemento padre: 1128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1129)).setAttribute("width","100%" );
      ((Element)v.get(1129)).setAttribute("border","0" );
      ((Element)v.get(1129)).setAttribute("align","center" );
      ((Element)v.get(1129)).setAttribute("cellspacing","0" );
      ((Element)v.get(1129)).setAttribute("cellpadding","0" );
      ((Element)v.get(1128)).appendChild((Element)v.get(1129));

      /* Empieza nodo:1130 / Elemento padre: 1129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1129)).appendChild((Element)v.get(1130));

      /* Empieza nodo:1131 / Elemento padre: 1130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1131)).setAttribute("class","botonera" );
      ((Element)v.get(1131)).setAttribute("width","100%" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1131));

      /* Empieza nodo:1132 / Elemento padre: 1131   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1132)).setAttribute("nombre","btnEliminar1" );
      ((Element)v.get(1132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1132)).setAttribute("tipo","html" );
      ((Element)v.get(1132)).setAttribute("accion","accionEliminarGrupo    ('btnEliminar1');" );
      ((Element)v.get(1132)).setAttribute("estado","false" );
      ((Element)v.get(1132)).setAttribute("cod","1254" );
      ((Element)v.get(1132)).setAttribute("codigo","1" );
      ((Element)v.get(1131)).appendChild((Element)v.get(1132));
      /* Termina nodo:1132   */
      /* Termina nodo:1131   */
      /* Termina nodo:1130   */
      /* Termina nodo:1129   */
      /* Termina nodo:1128   */
      /* Termina nodo:1127   */

      /* Empieza nodo:1133 / Elemento padre: 1124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1124)).appendChild((Element)v.get(1133));

      /* Empieza nodo:1134 / Elemento padre: 1133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1134)).setAttribute("src","b.gif" );
      ((Element)v.get(1134)).setAttribute("width","12" );
      ((Element)v.get(1134)).setAttribute("height","12" );
      ((Element)v.get(1133)).appendChild((Element)v.get(1134));
      /* Termina nodo:1134   */
      /* Termina nodo:1133   */
      /* Termina nodo:1124   */

      /* Empieza nodo:1135 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1135));

      /* Empieza nodo:1136 / Elemento padre: 1135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1136)).setAttribute("colspan","3" );
      ((Element)v.get(1135)).appendChild((Element)v.get(1136));

      /* Empieza nodo:1137 / Elemento padre: 1136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1137)).setAttribute("src","b.gif" );
      ((Element)v.get(1137)).setAttribute("width","12" );
      ((Element)v.get(1137)).setAttribute("height","12" );
      ((Element)v.get(1136)).appendChild((Element)v.get(1137));
      /* Termina nodo:1137   */
      /* Termina nodo:1136   */
      /* Termina nodo:1135   */

      /* Empieza nodo:1138 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1138));

      /* Empieza nodo:1139 / Elemento padre: 1138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1138)).appendChild((Element)v.get(1139));

      /* Empieza nodo:1140 / Elemento padre: 1139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1140)).setAttribute("src","b.gif" );
      ((Element)v.get(1140)).setAttribute("width","12" );
      ((Element)v.get(1140)).setAttribute("height","12" );
      ((Element)v.get(1139)).appendChild((Element)v.get(1140));
      /* Termina nodo:1140   */
      /* Termina nodo:1139   */

      /* Empieza nodo:1141 / Elemento padre: 1138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1138)).appendChild((Element)v.get(1141));
      /* Termina nodo:1141   */

      /* Empieza nodo:1142 / Elemento padre: 1138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1142)).setAttribute("width","100%" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1138)).appendChild((Element)v.get(1142));

      /* Empieza nodo:1143 / Elemento padre: 1142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1143)).setAttribute("src","b.gif" );
      ((Element)v.get(1143)).setAttribute("width","8" );
      ((Element)v.get(1143)).setAttribute("height","8" );
      ((Element)v.get(1142)).appendChild((Element)v.get(1143));
      /* Termina nodo:1143   */
      /* Termina nodo:1142   */
      /* Termina nodo:1138   */

      /* Empieza nodo:1144 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1144));

      /* Empieza nodo:1145 / Elemento padre: 1144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1145));

      /* Empieza nodo:1146 / Elemento padre: 1145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1146)).setAttribute("src","b.gif" );
      ((Element)v.get(1146)).setAttribute("width","8" );
      ((Element)v.get(1146)).setAttribute("height","8" );
      ((Element)v.get(1145)).appendChild((Element)v.get(1146));
      /* Termina nodo:1146   */
      /* Termina nodo:1145   */

      /* Empieza nodo:1147 / Elemento padre: 1144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1144)).appendChild((Element)v.get(1147));

      /* Empieza nodo:1148 / Elemento padre: 1147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1148)).setAttribute("nombre","cbTipoGrupo2" );
      ((Element)v.get(1148)).setAttribute("id","datosCampos" );
      ((Element)v.get(1148)).setAttribute("size","1" );
      ((Element)v.get(1148)).setAttribute("multiple","N" );
      ((Element)v.get(1148)).setAttribute("req","N" );
      ((Element)v.get(1147)).appendChild((Element)v.get(1148));

      /* Empieza nodo:1149 / Elemento padre: 1148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1149));
      /* Termina nodo:1149   */

      /* Empieza nodo:1150 / Elemento padre: 1148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1148)).appendChild((Element)v.get(1150));

      /* Empieza nodo:1151 / Elemento padre: 1150   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1151)).setAttribute("ID","4" );
      ((Element)v.get(1150)).appendChild((Element)v.get(1151));

      /* Empieza nodo:1152 / Elemento padre: 1151   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1152)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(1152)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1152)).setAttribute("VALOR","4" );
      ((Element)v.get(1151)).appendChild((Element)v.get(1152));
      /* Termina nodo:1152   */

      /* Empieza nodo:1153 / Elemento padre: 1151   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1153)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(1153)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1153)).setAttribute("VALOR","Grupos condicionados" );
      ((Element)v.get(1151)).appendChild((Element)v.get(1153));
      /* Termina nodo:1153   */
      /* Termina nodo:1151   */
      /* Termina nodo:1150   */
      /* Termina nodo:1148   */
      /* Termina nodo:1147   */

      /* Empieza nodo:1154 / Elemento padre: 1144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1154)).setAttribute("width","100%" );
      ((Element)v.get(1144)).appendChild((Element)v.get(1154));

      /* Empieza nodo:1155 / Elemento padre: 1154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1155)).setAttribute("src","b.gif" );
      ((Element)v.get(1155)).setAttribute("width","8" );
      ((Element)v.get(1155)).setAttribute("height","8" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1155));
      /* Termina nodo:1155   */
      /* Termina nodo:1154   */
      /* Termina nodo:1144   */

      /* Empieza nodo:1156 / Elemento padre: 1061   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1061)).appendChild((Element)v.get(1156));

      /* Empieza nodo:1157 / Elemento padre: 1156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1157)).setAttribute("colspan","3" );
      ((Element)v.get(1156)).appendChild((Element)v.get(1157));

      /* Empieza nodo:1158 / Elemento padre: 1157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1158)).setAttribute("src","b.gif" );
      ((Element)v.get(1158)).setAttribute("width","12" );
      ((Element)v.get(1158)).setAttribute("height","12" );
      ((Element)v.get(1157)).appendChild((Element)v.get(1158));
      /* Termina nodo:1158   */
      /* Termina nodo:1157   */
      /* Termina nodo:1156   */
      /* Termina nodo:1061   */
      /* Termina nodo:1058   */
      /* Termina nodo:1057   */

      /* Empieza nodo:1159 / Elemento padre: 1054   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1054)).appendChild((Element)v.get(1159));

      /* Empieza nodo:1160 / Elemento padre: 1159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1160)).setAttribute("src","b.gif" );
      ((Element)v.get(1160)).setAttribute("width","12" );
      ((Element)v.get(1160)).setAttribute("height","12" );
      ((Element)v.get(1159)).appendChild((Element)v.get(1160));
      /* Termina nodo:1160   */
      /* Termina nodo:1159   */
      /* Termina nodo:1054   */

      /* Empieza nodo:1161 / Elemento padre: 1046   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1046)).appendChild((Element)v.get(1161));

      /* Empieza nodo:1162 / Elemento padre: 1161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1161)).appendChild((Element)v.get(1162));

      /* Empieza nodo:1163 / Elemento padre: 1162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1163)).setAttribute("src","b.gif" );
      ((Element)v.get(1163)).setAttribute("width","0" );
      ((Element)v.get(1163)).setAttribute("height","0" );
      ((Element)v.get(1162)).appendChild((Element)v.get(1163));
      /* Termina nodo:1163   */
      /* Termina nodo:1162   */

      /* Empieza nodo:1164 / Elemento padre: 1161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1161)).appendChild((Element)v.get(1164));

      /* Empieza nodo:1165 / Elemento padre: 1164   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1164)).appendChild((Element)v.get(1165));

      /* Empieza nodo:1166 / Elemento padre: 1165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1166)).setAttribute("width","100%" );
      ((Element)v.get(1166)).setAttribute("align","center" );
      ((Element)v.get(1166)).setAttribute("border","0" );
      ((Element)v.get(1166)).setAttribute("cellspacing","0" );
      ((Element)v.get(1166)).setAttribute("cellpadding","0" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1166));

      /* Empieza nodo:1167 / Elemento padre: 1166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1166)).appendChild((Element)v.get(1167));

      /* Empieza nodo:1168 / Elemento padre: 1167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1168)).setAttribute("class","botonera" );
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1168)).setAttribute("width","100%" );
      ((Element)v.get(1167)).appendChild((Element)v.get(1168));

      /* Empieza nodo:1169 / Elemento padre: 1168   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1169)).setAttribute("nombre","btnAnadir2" );
      ((Element)v.get(1169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1169)).setAttribute("tipo","html" );
      ((Element)v.get(1169)).setAttribute("accion","accionAniadirGrupo();" );
      ((Element)v.get(1169)).setAttribute("estado","false" );
      ((Element)v.get(1169)).setAttribute("cod","404" );
      ((Element)v.get(1168)).appendChild((Element)v.get(1169));
      /* Termina nodo:1169   */
      /* Termina nodo:1168   */
      /* Termina nodo:1167   */
      /* Termina nodo:1166   */
      /* Termina nodo:1165   */
      /* Termina nodo:1164   */

      /* Empieza nodo:1170 / Elemento padre: 1161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1161)).appendChild((Element)v.get(1170));

      /* Empieza nodo:1171 / Elemento padre: 1170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1171)).setAttribute("src","b.gif" );
      ((Element)v.get(1171)).setAttribute("width","12" );
      ((Element)v.get(1171)).setAttribute("height","12" );
      ((Element)v.get(1170)).appendChild((Element)v.get(1171));
      /* Termina nodo:1171   */
      /* Termina nodo:1170   */
      /* Termina nodo:1161   */

      /* Empieza nodo:1172 / Elemento padre: 1046   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1046)).appendChild((Element)v.get(1172));

      /* Empieza nodo:1173 / Elemento padre: 1172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1173)).setAttribute("width","12" );
      ((Element)v.get(1173)).setAttribute("align","center" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1173));

      /* Empieza nodo:1174 / Elemento padre: 1173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1174)).setAttribute("src","b.gif" );
      ((Element)v.get(1174)).setAttribute("width","12" );
      ((Element)v.get(1174)).setAttribute("height","12" );
      ((Element)v.get(1173)).appendChild((Element)v.get(1174));
      /* Termina nodo:1174   */
      /* Termina nodo:1173   */

      /* Empieza nodo:1175 / Elemento padre: 1172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1175)).setAttribute("width","100%" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1175));

      /* Empieza nodo:1176 / Elemento padre: 1175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1176)).setAttribute("src","b.gif" );
      ((Element)v.get(1176)).setAttribute("width","0" );
      ((Element)v.get(1176)).setAttribute("height","0" );
      ((Element)v.get(1175)).appendChild((Element)v.get(1176));
      /* Termina nodo:1176   */
      /* Termina nodo:1175   */

      /* Empieza nodo:1177 / Elemento padre: 1172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1177)).setAttribute("width","12" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1177));

      /* Empieza nodo:1178 / Elemento padre: 1177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1178)).setAttribute("src","b.gif" );
      ((Element)v.get(1178)).setAttribute("width","12" );
      ((Element)v.get(1178)).setAttribute("height","12" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1178));
      /* Termina nodo:1178   */
      /* Termina nodo:1177   */
      /* Termina nodo:1172   */
      /* Termina nodo:1046   */
      /* Termina nodo:1045   */

      /* Empieza nodo:1179 / Elemento padre: 1044   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1179)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(1179)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1179)).setAttribute("y","1460" );
      ((Element)v.get(1179)).setAttribute("x","32" );
      ((Element)v.get(1179)).setAttribute("alto","290" );
      ((Element)v.get(1179)).setAttribute("ancho","800" );
      ((Element)v.get(1179)).setAttribute("nombre","listado41" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1179));

      /* Empieza nodo:1180 / Elemento padre: 1179   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1180)).setAttribute("conROver","S" );
      ((Element)v.get(1180)).setAttribute("precarga","S" );
      ((Element)v.get(1179)).appendChild((Element)v.get(1180));

      /* Empieza nodo:1181 / Elemento padre: 1180   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1181)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1181)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1181)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1181)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1180)).appendChild((Element)v.get(1181));
      /* Termina nodo:1181   */

      /* Empieza nodo:1182 / Elemento padre: 1180   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1182)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1182)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1182)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1182)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1180)).appendChild((Element)v.get(1182));
      /* Termina nodo:1182   */
      /* Termina nodo:1180   */

      /* Empieza nodo:1183 / Elemento padre: 1179   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1179)).appendChild((Element)v.get(1183));

      /* Empieza nodo:1184 / Elemento padre: 1183   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1184)).setAttribute("vertical","0" );
      ((Element)v.get(1184)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1184)).setAttribute("horizDatos","1" );
      ((Element)v.get(1184)).setAttribute("borde","1" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1184));
      /* Termina nodo:1184   */

      /* Empieza nodo:1185 / Elemento padre: 1183   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1185)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1185)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(1185)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(1185)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(1185)).setAttribute("borde","#999999" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1185));
      /* Termina nodo:1185   */
      /* Termina nodo:1183   */

      /* Empieza nodo:1186 / Elemento padre: 1179   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1186)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1186)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1186)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1186)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1186)).setAttribute("ajustarMinimo","S" );
   }

   private void getXML4860(Document doc) {
      ((Element)v.get(1179)).appendChild((Element)v.get(1186));

      /* Empieza nodo:1187 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1187)).setAttribute("minimizada","N" );
      ((Element)v.get(1187)).setAttribute("minimizable","S" );
      ((Element)v.get(1187)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1187));
      /* Termina nodo:1187   */

      /* Empieza nodo:1188 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1188)).setAttribute("minimizada","N" );
      ((Element)v.get(1188)).setAttribute("minimizable","S" );
      ((Element)v.get(1188)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1188));
      /* Termina nodo:1188   */

      /* Empieza nodo:1189 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1189)).setAttribute("minimizada","N" );
      ((Element)v.get(1189)).setAttribute("minimizable","S" );
      ((Element)v.get(1189)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1189));
      /* Termina nodo:1189   */

      /* Empieza nodo:1190 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1190)).setAttribute("minimizada","N" );
      ((Element)v.get(1190)).setAttribute("minimizable","S" );
      ((Element)v.get(1190)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1190));
      /* Termina nodo:1190   */

      /* Empieza nodo:1191 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1191)).setAttribute("minimizada","N" );
      ((Element)v.get(1191)).setAttribute("minimizable","S" );
      ((Element)v.get(1191)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1191));
      /* Termina nodo:1191   */

      /* Empieza nodo:1192 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1192)).setAttribute("minimizada","N" );
      ((Element)v.get(1192)).setAttribute("minimizable","S" );
      ((Element)v.get(1192)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1192));
      /* Termina nodo:1192   */

      /* Empieza nodo:1193 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1193)).setAttribute("minimizada","N" );
      ((Element)v.get(1193)).setAttribute("minimizable","S" );
      ((Element)v.get(1193)).setAttribute("ancho","100" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1193));
      /* Termina nodo:1193   */
      /* Termina nodo:1186   */

      /* Empieza nodo:1194 / Elemento padre: 1179   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1194)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1194)).setAttribute("imgFondo","" );
      ((Element)v.get(1194)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1194)).setAttribute("alto","20" );
      ((Element)v.get(1179)).appendChild((Element)v.get(1194));

      /* Empieza nodo:1195 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1195)).setAttribute("cod","8" );
      ((Element)v.get(1195)).setAttribute("align","center" );
      ((Element)v.get(1195)).setAttribute("ID","EstCab" );
      ((Element)v.get(1195)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1195));
      /* Termina nodo:1195   */

      /* Empieza nodo:1196 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1196)).setAttribute("cod","9" );
      ((Element)v.get(1196)).setAttribute("align","center" );
      ((Element)v.get(1196)).setAttribute("ID","EstCab" );
      ((Element)v.get(1196)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1196));
      /* Termina nodo:1196   */

      /* Empieza nodo:1197 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1197)).setAttribute("cod","529" );
      ((Element)v.get(1197)).setAttribute("align","center" );
      ((Element)v.get(1197)).setAttribute("ID","EstCab" );
      ((Element)v.get(1197)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1197));
      /* Termina nodo:1197   */

      /* Empieza nodo:1198 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1198)).setAttribute("cod","530" );
      ((Element)v.get(1198)).setAttribute("align","center" );
      ((Element)v.get(1198)).setAttribute("ID","EstCab" );
      ((Element)v.get(1198)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1198));
      /* Termina nodo:1198   */

      /* Empieza nodo:1199 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1199)).setAttribute("cod","481" );
      ((Element)v.get(1199)).setAttribute("align","center" );
      ((Element)v.get(1199)).setAttribute("ID","EstCab" );
      ((Element)v.get(1199)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1199));
      /* Termina nodo:1199   */

      /* Empieza nodo:1200 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1200)).setAttribute("cod","482" );
      ((Element)v.get(1200)).setAttribute("align","center" );
      ((Element)v.get(1200)).setAttribute("ID","EstCab" );
      ((Element)v.get(1200)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1200));
      /* Termina nodo:1200   */

      /* Empieza nodo:1201 / Elemento padre: 1194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1201)).setAttribute("cod","483" );
      ((Element)v.get(1201)).setAttribute("align","center" );
      ((Element)v.get(1201)).setAttribute("ID","EstCab" );
      ((Element)v.get(1201)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1201));
      /* Termina nodo:1201   */
      /* Termina nodo:1194   */

      /* Empieza nodo:1202 / Elemento padre: 1179   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1202)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1202)).setAttribute("onLoad","" );
      ((Element)v.get(1202)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1202)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1202)).setAttribute("msgErrMaxSel","" );
   }

   private void getXML4950(Document doc) {
      ((Element)v.get(1202)).setAttribute("maxSel","-1" );
      ((Element)v.get(1202)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1202)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1202)).setAttribute("accion","" );
      ((Element)v.get(1202)).setAttribute("alto","22" );
      ((Element)v.get(1179)).appendChild((Element)v.get(1202));

      /* Empieza nodo:1203 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1203)).setAttribute("tipo","texto" );
      ((Element)v.get(1203)).setAttribute("ID","EstDat" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1203));
      /* Termina nodo:1203   */

      /* Empieza nodo:1204 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1204)).setAttribute("tipo","texto" );
      ((Element)v.get(1204)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1204));
      /* Termina nodo:1204   */

      /* Empieza nodo:1205 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1205)).setAttribute("tipo","texto" );
      ((Element)v.get(1205)).setAttribute("ID","EstDat" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1205));
      /* Termina nodo:1205   */

      /* Empieza nodo:1206 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1206)).setAttribute("tipo","texto" );
      ((Element)v.get(1206)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1206));
      /* Termina nodo:1206   */

      /* Empieza nodo:1207 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1207)).setAttribute("tipo","texto" );
      ((Element)v.get(1207)).setAttribute("ID","EstDat" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1207));
      /* Termina nodo:1207   */

      /* Empieza nodo:1208 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1208)).setAttribute("tipo","texto" );
      ((Element)v.get(1208)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1208));
      /* Termina nodo:1208   */

      /* Empieza nodo:1209 / Elemento padre: 1202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1209)).setAttribute("tipo","texto" );
      ((Element)v.get(1209)).setAttribute("ID","EstDat" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1209));
      /* Termina nodo:1209   */
      /* Termina nodo:1202   */

      /* Empieza nodo:1210 / Elemento padre: 1179   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1179)).appendChild((Element)v.get(1210));

      /* Empieza nodo:1211 / Elemento padre: 1210   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(1211)).setAttribute("ID","1" );
      ((Element)v.get(1210)).appendChild((Element)v.get(1211));

      /* Empieza nodo:1212 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1212)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(1212)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1212)).setAttribute("VALOR","239" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1212));
      /* Termina nodo:1212   */

      /* Empieza nodo:1213 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1213)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1213)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1213)).setAttribute("VALOR","PRE-CodProdSAP2" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1213));
      /* Termina nodo:1213   */

      /* Empieza nodo:1214 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1214)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1214)).setAttribute("VALOR","PRE-CodProdSAP2" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1214));
      /* Termina nodo:1214   */

      /* Empieza nodo:1215 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1215)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1215)).setAttribute("VALOR","1" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1215));
      /* Termina nodo:1215   */

      /* Empieza nodo:1216 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1216)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1216)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1216)).setAttribute("VALOR","11.0" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1216));
      /* Termina nodo:1216   */

      /* Empieza nodo:1217 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1217)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1217)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1217)).setAttribute("VALOR","M12" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1217));
      /* Termina nodo:1217   */

      /* Empieza nodo:1218 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1218)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1218)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1218)).setAttribute("VALOR","MA22" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1218));
      /* Termina nodo:1218   */

      /* Empieza nodo:1219 / Elemento padre: 1211   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(1219)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(1219)).setAttribute("TIPO","STRING" );
      ((Element)v.get(1219)).setAttribute("VALOR","MaeAtrib32" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1219));
      /* Termina nodo:1219   */
      /* Termina nodo:1211   */
      /* Termina nodo:1210   */

      /* Empieza nodo:1220 / Elemento padre: 1179   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1220)).setAttribute("cargainicial","N" );
      ((Element)v.get(1220)).setAttribute("rowset","" );
      ((Element)v.get(1220)).setAttribute("conector","conector_textarea" );
      ((Element)v.get(1220)).setAttribute("control","|" );
      ((Element)v.get(1220)).setAttribute("y","1758" );
      ((Element)v.get(1220)).setAttribute("class","botonera" );
      ((Element)v.get(1220)).setAttribute("x","32" );
      ((Element)v.get(1220)).setAttribute("sep","$" );
      ((Element)v.get(1220)).setAttribute("ancho","240" );
      ((Element)v.get(1220)).setAttribute("nombre","mipgndo41" );
   }

   private void getXML5040(Document doc) {
      ((Element)v.get(1179)).appendChild((Element)v.get(1220));

      /* Empieza nodo:1221 / Elemento padre: 1220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1221)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(1221)).setAttribute("codigo","" );
      ((Element)v.get(1221)).setAttribute("alt","" );
      ((Element)v.get(1221)).setAttribute("estado","false" );
      ((Element)v.get(1221)).setAttribute("tipo","0" );
      ((Element)v.get(1221)).setAttribute("img","primera_on" );
      ((Element)v.get(1221)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1221)).setAttribute("y","1758" );
      ((Element)v.get(1221)).setAttribute("x","270" );
      ((Element)v.get(1221)).setAttribute("nombre","listado41_pri1" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1221));
      /* Termina nodo:1221   */

      /* Empieza nodo:1222 / Elemento padre: 1220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1222)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(1222)).setAttribute("codigo","" );
      ((Element)v.get(1222)).setAttribute("alt","" );
      ((Element)v.get(1222)).setAttribute("estado","false" );
      ((Element)v.get(1222)).setAttribute("tipo","0" );
      ((Element)v.get(1222)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1222)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1222)).setAttribute("y","1758" );
      ((Element)v.get(1222)).setAttribute("x","287" );
      ((Element)v.get(1222)).setAttribute("nombre","listado41_ret1" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1222));
      /* Termina nodo:1222   */

      /* Empieza nodo:1223 / Elemento padre: 1220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1223)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(1223)).setAttribute("codigo","" );
      ((Element)v.get(1223)).setAttribute("alt","" );
      ((Element)v.get(1223)).setAttribute("estado","false" );
      ((Element)v.get(1223)).setAttribute("tipo","0" );
      ((Element)v.get(1223)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1223)).setAttribute("y","1758" );
      ((Element)v.get(1223)).setAttribute("x","302" );
      ((Element)v.get(1223)).setAttribute("nombre","listado41_ava1" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1223));
      /* Termina nodo:1223   */

      /* Empieza nodo:1224 / Elemento padre: 1220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1224)).setAttribute("tipo","html" );
      ((Element)v.get(1224)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1224)).setAttribute("nombre","Modificar42" );
      ((Element)v.get(1224)).setAttribute("estado","true" );
      ((Element)v.get(1224)).setAttribute("cod","2" );
      ((Element)v.get(1224)).setAttribute("accion","accionModificarGrupo(1);" );
      ((Element)v.get(1224)).setAttribute("x","33" );
      ((Element)v.get(1224)).setAttribute("y","1712" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1224));
      /* Termina nodo:1224   */
      /* Termina nodo:1220   */
      /* Termina nodo:1179   */
      /* Termina nodo:1044   */
      /* Termina nodo:6   */


   }

}
