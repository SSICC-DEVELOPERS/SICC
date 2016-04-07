
import org.w3c.dom.*;
import java.util.ArrayList;

public class ddd  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(10)).setAttribute("valor","408" );
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
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidRDCondicionantes" );
      ((Element)v.get(32)).setAttribute("valor","" );
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
      ((Element)v.get(40)).setAttribute("valor","" );
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
      ((Element)v.get(43)).setAttribute("valor","N" );
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
      ((Element)v.get(45)).setAttribute("valor","N" );
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
      ((Element)v.get(51)).setAttribute("valor","" );
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
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidNroGrupos" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidNroPaquetes" );
      ((Element)v.get(56)).setAttribute("valor","" );
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
      ((Element)v.get(231)).setAttribute("valor","" );
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
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(323)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(323)).setAttribute("ancho","680" );
      ((Element)v.get(323)).setAttribute("sep","$" );
      ((Element)v.get(323)).setAttribute("x","12" );
      ((Element)v.get(323)).setAttribute("class","botonera" );
      ((Element)v.get(323)).setAttribute("y","378" );
      ((Element)v.get(323)).setAttribute("control","|" );
      ((Element)v.get(323)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(323)).setAttribute("rowset","" );
      ((Element)v.get(323)).setAttribute("cargainicial","N" );
      ((Element)v.get(277)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(324)).setAttribute("nombre","primera1" );
      ((Element)v.get(324)).setAttribute("x","77" );
      ((Element)v.get(324)).setAttribute("y","382" );
      ((Element)v.get(324)).setAttribute("ID","botonContenido" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(324)).setAttribute("img","primera_on" );
      ((Element)v.get(324)).setAttribute("tipo","0" );
      ((Element)v.get(324)).setAttribute("estado","false" );
      ((Element)v.get(324)).setAttribute("alt","" );
      ((Element)v.get(324)).setAttribute("codigo","" );
      ((Element)v.get(324)).setAttribute("accion","" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 323   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(325)).setAttribute("nombre","ava1" );
      ((Element)v.get(325)).setAttribute("x","109" );
      ((Element)v.get(325)).setAttribute("y","382" );
      ((Element)v.get(325)).setAttribute("ID","botonContenido" );
      ((Element)v.get(325)).setAttribute("img","avanzar_on" );
      ((Element)v.get(325)).setAttribute("tipo","0" );
      ((Element)v.get(325)).setAttribute("estado","false" );
      ((Element)v.get(325)).setAttribute("alt","" );
      ((Element)v.get(325)).setAttribute("codigo","" );
      ((Element)v.get(325)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(323)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(326)).setAttribute("nombre","ret1" );
      ((Element)v.get(326)).setAttribute("x","94" );
      ((Element)v.get(326)).setAttribute("y","382" );
      ((Element)v.get(326)).setAttribute("ID","botonContenido" );
      ((Element)v.get(326)).setAttribute("img","retroceder_on" );
      ((Element)v.get(326)).setAttribute("tipo","0" );
      ((Element)v.get(326)).setAttribute("estado","false" );
      ((Element)v.get(326)).setAttribute("alt","" );
      ((Element)v.get(326)).setAttribute("codigo","" );
      ((Element)v.get(326)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(323)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:323   */

      /* Empieza nodo:327 / Elemento padre: 277   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(327)).setAttribute("ID","dtoSalida" );
      ((Element)v.get(277)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(329)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(329)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(329)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Elemento padre:329 / Elemento actual: 330   */
      v.add(doc.createTextNode("18"));
      ((Element)v.get(329)).appendChild((Text)v.get(330));

      /* Termina nodo Texto:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(331)).setAttribute("NOMBRE","COD_SAP" );
      ((Element)v.get(331)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(331)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Elemento padre:331 / Elemento actual: 332   */
      v.add(doc.createTextNode("PRE-CodProdSAP6"));
      ((Element)v.get(331)).appendChild((Text)v.get(332));

      /* Termina nodo Texto:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(333)).setAttribute("NOMBRE","DES_SAP" );
      ((Element)v.get(333)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(333)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Elemento padre:333 / Elemento actual: 334   */
      v.add(doc.createTextNode("PRE-CodProdSAP6"));
      ((Element)v.get(333)).appendChild((Text)v.get(334));

      /* Termina nodo Texto:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","COD_TIPO_OFER" );
      ((Element)v.get(335)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(335)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(335));

      /* Elemento padre:335 / Elemento actual: 336   */
      v.add(doc.createTextNode("PRE-TipoOferta1"));
      ((Element)v.get(335)).appendChild((Text)v.get(336));

      /* Termina nodo Texto:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(337)).setAttribute("NOMBRE","COD_CICL_VIDA" );
      ((Element)v.get(337)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(337)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Elemento padre:337 / Elemento actual: 338   */
      v.add(doc.createTextNode("PRE-CicloVida1"));
      ((Element)v.get(337)).appendChild((Text)v.get(338));

      /* Termina nodo Texto:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(339)).setAttribute("NOMBRE","VAL_FACT_REPE" );
      ((Element)v.get(339)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(339)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(339));

      /* Elemento padre:339 / Elemento actual: 340   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(339)).appendChild((Text)v.get(340));

      /* Termina nodo Texto:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(341)).setAttribute("NOMBRE","IMP_PREC_CATA" );
      ((Element)v.get(341)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(341)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(341));

      /* Elemento padre:341 / Elemento actual: 342   */
      v.add(doc.createTextNode("25.0"));
      ((Element)v.get(341)).appendChild((Text)v.get(342));

      /* Termina nodo Texto:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(343)).setAttribute("NOMBRE","VAL_ATRI_1" );
      ((Element)v.get(343)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(343)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(343));

      /* Elemento padre:343 / Elemento actual: 344   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createTextNode("M16"));
      ((Element)v.get(343)).appendChild((Text)v.get(344));

      /* Termina nodo Texto:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(345)).setAttribute("NOMBRE","VAL_ATRI_2" );
      ((Element)v.get(345)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(345)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(345));

      /* Elemento padre:345 / Elemento actual: 346   */
      v.add(doc.createTextNode("MA26"));
      ((Element)v.get(345)).appendChild((Text)v.get(346));

      /* Termina nodo Texto:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 328   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(347)).setAttribute("NOMBRE","VAL_ATRI_3" );
      ((Element)v.get(347)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(347)).setAttribute("LONGITUD","50" );
      ((Element)v.get(328)).appendChild((Element)v.get(347));

      /* Elemento padre:347 / Elemento actual: 348   */
      v.add(doc.createTextNode("MaeAtrib36"));
      ((Element)v.get(347)).appendChild((Text)v.get(348));

      /* Termina nodo Texto:348   */
      /* Termina nodo:347   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:277   */

      /* Empieza nodo:349 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(349)).setAttribute("nombre","capaProductoAsociado" );
      ((Element)v.get(349)).setAttribute("alto","30" );
      ((Element)v.get(349)).setAttribute("ancho","100%" );
      ((Element)v.get(349)).setAttribute("colorf","" );
      ((Element)v.get(349)).setAttribute("borde","0" );
      ((Element)v.get(349)).setAttribute("imagenf","" );
      ((Element)v.get(349)).setAttribute("repeat","" );
      ((Element)v.get(349)).setAttribute("padding","" );
      ((Element)v.get(349)).setAttribute("visibilidad","visible" );
      ((Element)v.get(349)).setAttribute("contravsb","" );
      ((Element)v.get(349)).setAttribute("x","0" );
      ((Element)v.get(349)).setAttribute("y","436" );
      ((Element)v.get(349)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("table"));
      ((Element)v.get(350)).setAttribute("width","100%" );
      ((Element)v.get(350)).setAttribute("border","0" );
      ((Element)v.get(350)).setAttribute("align","center" );
      ((Element)v.get(350)).setAttribute("cellspacing","0" );
      ((Element)v.get(350)).setAttribute("cellpadding","0" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("width","12" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","12" );
      ((Element)v.get(353)).setAttribute("height","1" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","750" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","12" );
      ((Element)v.get(351)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","12" );
      ((Element)v.get(357)).setAttribute("height","5" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:351   */

      /* Empieza nodo:358 / Elemento padre: 350   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(350)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("table"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(363)).setAttribute("border","0" );
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("cellspacing","0" );
      ((Element)v.get(363)).setAttribute("cellpadding","0" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(365)).setAttribute("valign","middle" );
      ((Element)v.get(365)).setAttribute("width","4" );
      ((Element)v.get(365)).setAttribute("height","4" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","5" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(367)).setAttribute("valign","middle" );
      ((Element)v.get(367)).setAttribute("height","20" );
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(364)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(368)).setAttribute("nombre","lbltitulo2" );
      ((Element)v.get(368)).setAttribute("ancho","666" );
      ((Element)v.get(368)).setAttribute("alto","13" );
      ((Element)v.get(368)).setAttribute("filas","1" );
      ((Element)v.get(368)).setAttribute("valor","" );
      ((Element)v.get(368)).setAttribute("id","datosTitle" );
      ((Element)v.get(368)).setAttribute("cod","532" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:369 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(358)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(370)).setAttribute("height","12" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:358   */

      /* Empieza nodo:371 / Elemento padre: 350   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(350)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("width","12" );
      ((Element)v.get(372)).setAttribute("align","center" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(373)).setAttribute("height","1" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("width","750" );
      ((Element)v.get(371)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("width","12" );
      ((Element)v.get(371)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(377)).setAttribute("height","5" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:371   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:378 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(378)).setAttribute("nombre","listado2" );
      ((Element)v.get(378)).setAttribute("ancho","677" );
      ((Element)v.get(378)).setAttribute("alto","290" );
      ((Element)v.get(378)).setAttribute("x","12" );
      ((Element)v.get(378)).setAttribute("y","465" );
      ((Element)v.get(378)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(378)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(379)).setAttribute("precarga","S" );
      ((Element)v.get(379)).setAttribute("conROver","S" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(380)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(380)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(380)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(380)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 379   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(381)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(381)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(381)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(381)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(379)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:379   */

      /* Empieza nodo:382 / Elemento padre: 378   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(378)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(383)).setAttribute("borde","1" );
      ((Element)v.get(383)).setAttribute("horizDatos","1" );
      ((Element)v.get(383)).setAttribute("horizCabecera","1" );
      ((Element)v.get(383)).setAttribute("vertical","0" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 382   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(384)).setAttribute("borde","#999999" );
      ((Element)v.get(384)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(384)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(384)).setAttribute("horizDatos","#999999" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(384)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(382)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:382   */

      /* Empieza nodo:385 / Elemento padre: 378   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(385)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(385)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(385)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(385)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(385)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(378)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","60" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
      ((Element)v.get(386)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","60" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("ancho","100" );
      ((Element)v.get(388)).setAttribute("minimizable","S" );
      ((Element)v.get(388)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("ancho","100" );
      ((Element)v.get(389)).setAttribute("minimizable","S" );
      ((Element)v.get(389)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("ancho","130" );
      ((Element)v.get(390)).setAttribute("minimizable","S" );
      ((Element)v.get(390)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("ancho","100" );
      ((Element)v.get(391)).setAttribute("minimizable","S" );
      ((Element)v.get(391)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("ancho","100" );
      ((Element)v.get(392)).setAttribute("minimizable","S" );
      ((Element)v.get(392)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */

      /* Empieza nodo:393 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("ancho","100" );
      ((Element)v.get(393)).setAttribute("minimizable","S" );
      ((Element)v.get(393)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 385   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("ancho","100" );
      ((Element)v.get(394)).setAttribute("minimizable","S" );
      ((Element)v.get(394)).setAttribute("minimizada","N" );
      ((Element)v.get(385)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:385   */

      /* Empieza nodo:395 / Elemento padre: 378   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(395)).setAttribute("alto","20" );
      ((Element)v.get(395)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(395)).setAttribute("imgFondo","" );
      ((Element)v.get(395)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(378)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("colFondo","" );
      ((Element)v.get(396)).setAttribute("ID","EstCab" );
      ((Element)v.get(396)).setAttribute("cod","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("colFondo","" );
      ((Element)v.get(398)).setAttribute("ID","EstCab" );
      ((Element)v.get(398)).setAttribute("cod","9" );
      ((Element)v.get(395)).appendChild((Element)v.get(398));

      /* Elemento padre:398 / Elemento actual: 399   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(398)).appendChild((Text)v.get(399));

      /* Termina nodo Texto:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("colFondo","" );
      ((Element)v.get(400)).setAttribute("ID","EstCab" );
      ((Element)v.get(400)).setAttribute("cod","608" );
      ((Element)v.get(395)).appendChild((Element)v.get(400));

      /* Elemento padre:400 / Elemento actual: 401   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(400)).appendChild((Text)v.get(401));

      /* Termina nodo Texto:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("colFondo","" );
      ((Element)v.get(402)).setAttribute("ID","EstCab" );
      ((Element)v.get(402)).setAttribute("cod","581" );
      ((Element)v.get(395)).appendChild((Element)v.get(402));

      /* Elemento padre:402 / Elemento actual: 403   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(402)).appendChild((Text)v.get(403));

      /* Termina nodo Texto:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("colFondo","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(404)).setAttribute("ID","EstCab" );
      ((Element)v.get(404)).setAttribute("cod","529" );
      ((Element)v.get(395)).appendChild((Element)v.get(404));

      /* Elemento padre:404 / Elemento actual: 405   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(404)).appendChild((Text)v.get(405));

      /* Termina nodo Texto:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("colFondo","" );
      ((Element)v.get(406)).setAttribute("ID","EstCab" );
      ((Element)v.get(406)).setAttribute("cod","530" );
      ((Element)v.get(395)).appendChild((Element)v.get(406));

      /* Elemento padre:406 / Elemento actual: 407   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(406)).appendChild((Text)v.get(407));

      /* Termina nodo Texto:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(408)).setAttribute("colFondo","" );
      ((Element)v.get(408)).setAttribute("ID","EstCab" );
      ((Element)v.get(408)).setAttribute("cod","481" );
      ((Element)v.get(395)).appendChild((Element)v.get(408));

      /* Elemento padre:408 / Elemento actual: 409   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(408)).appendChild((Text)v.get(409));

      /* Termina nodo Texto:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("colFondo","" );
      ((Element)v.get(410)).setAttribute("ID","EstCab" );
      ((Element)v.get(410)).setAttribute("cod","482" );
      ((Element)v.get(395)).appendChild((Element)v.get(410));

      /* Elemento padre:410 / Elemento actual: 411   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(410)).appendChild((Text)v.get(411));

      /* Termina nodo Texto:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("colFondo","" );
      ((Element)v.get(412)).setAttribute("ID","EstCab" );
      ((Element)v.get(412)).setAttribute("cod","483" );
      ((Element)v.get(395)).appendChild((Element)v.get(412));

      /* Elemento padre:412 / Elemento actual: 413   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(412)).appendChild((Text)v.get(413));

      /* Termina nodo Texto:413   */
      /* Termina nodo:412   */
      /* Termina nodo:395   */

      /* Empieza nodo:414 / Elemento padre: 378   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(414)).setAttribute("alto","22" );
      ((Element)v.get(414)).setAttribute("accion","" );
      ((Element)v.get(414)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(414)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(414)).setAttribute("maxSel","-1" );
      ((Element)v.get(414)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(414)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(414)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(414)).setAttribute("onLoad","" );
      ((Element)v.get(414)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(378)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat2" );
      ((Element)v.get(414)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","texto" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
      ((Element)v.get(414)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","texto" );
      ((Element)v.get(418)).setAttribute("ID","EstDat2" );
      ((Element)v.get(414)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat" );
      ((Element)v.get(414)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","texto" );
      ((Element)v.get(420)).setAttribute("ID","EstDat2" );
      ((Element)v.get(414)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("tipo","texto" );
      ((Element)v.get(421)).setAttribute("ID","EstDat" );
      ((Element)v.get(414)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("tipo","texto" );
      ((Element)v.get(422)).setAttribute("ID","EstDat2" );
      ((Element)v.get(414)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("tipo","texto" );
      ((Element)v.get(423)).setAttribute("ID","EstDat" );
      ((Element)v.get(414)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:414   */

      /* Empieza nodo:424 / Elemento padre: 378   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(378)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 378   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(425)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(425)).setAttribute("ancho","680" );
      ((Element)v.get(425)).setAttribute("sep","$" );
      ((Element)v.get(425)).setAttribute("x","12" );
      ((Element)v.get(425)).setAttribute("class","botonera" );
      ((Element)v.get(425)).setAttribute("y","717" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(425)).setAttribute("control","|" );
      ((Element)v.get(425)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(425)).setAttribute("rowset","" );
      ((Element)v.get(425)).setAttribute("cargainicial","N" );
      ((Element)v.get(378)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(426)).setAttribute("nombre","primera2" );
      ((Element)v.get(426)).setAttribute("x","77" );
      ((Element)v.get(426)).setAttribute("y","721" );
      ((Element)v.get(426)).setAttribute("ID","botonContenido" );
      ((Element)v.get(426)).setAttribute("img","primera_on" );
      ((Element)v.get(426)).setAttribute("tipo","0" );
      ((Element)v.get(426)).setAttribute("estado","false" );
      ((Element)v.get(426)).setAttribute("alt","" );
      ((Element)v.get(426)).setAttribute("codigo","" );
      ((Element)v.get(426)).setAttribute("accion","" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 425   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(427)).setAttribute("nombre","ava2" );
      ((Element)v.get(427)).setAttribute("x","109" );
      ((Element)v.get(427)).setAttribute("y","721" );
      ((Element)v.get(427)).setAttribute("ID","botonContenido" );
      ((Element)v.get(427)).setAttribute("img","avanzar_on" );
      ((Element)v.get(427)).setAttribute("tipo","0" );
      ((Element)v.get(427)).setAttribute("estado","false" );
      ((Element)v.get(427)).setAttribute("alt","" );
      ((Element)v.get(427)).setAttribute("codigo","" );
      ((Element)v.get(427)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(425)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(428)).setAttribute("nombre","ret2" );
      ((Element)v.get(428)).setAttribute("x","94" );
      ((Element)v.get(428)).setAttribute("y","721" );
      ((Element)v.get(428)).setAttribute("ID","botonContenido" );
      ((Element)v.get(428)).setAttribute("img","retroceder_on" );
      ((Element)v.get(428)).setAttribute("tipo","0" );
      ((Element)v.get(428)).setAttribute("estado","false" );
      ((Element)v.get(428)).setAttribute("alt","" );
      ((Element)v.get(428)).setAttribute("codigo","" );
      ((Element)v.get(428)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 425   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(429)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(429)).setAttribute("x","13" );
      ((Element)v.get(429)).setAttribute("y","717" );
      ((Element)v.get(429)).setAttribute("ID","botonContenido" );
      ((Element)v.get(429)).setAttribute("tipo","html" );
      ((Element)v.get(429)).setAttribute("estado","false" );
      ((Element)v.get(429)).setAttribute("cod","1" );
      ((Element)v.get(429)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(425)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:425   */
      /* Termina nodo:378   */

      /* Empieza nodo:430 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(430)).setAttribute("nombre","capaDatosGenerales" );
      ((Element)v.get(430)).setAttribute("alto","200" );
      ((Element)v.get(430)).setAttribute("ancho","100%" );
      ((Element)v.get(430)).setAttribute("colorf","" );
      ((Element)v.get(430)).setAttribute("borde","0" );
      ((Element)v.get(430)).setAttribute("imagenf","" );
      ((Element)v.get(430)).setAttribute("repeat","" );
      ((Element)v.get(430)).setAttribute("padding","" );
      ((Element)v.get(430)).setAttribute("visibilidad","visible" );
      ((Element)v.get(430)).setAttribute("contravsb","" );
      ((Element)v.get(430)).setAttribute("x","0" );
      ((Element)v.get(430)).setAttribute("y","762" );
      ((Element)v.get(430)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("table"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(431)).setAttribute("border","0" );
      ((Element)v.get(431)).setAttribute("cellspacing","0" );
      ((Element)v.get(431)).setAttribute("cellpadding","0" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).setAttribute("width","12" );
      ((Element)v.get(433)).setAttribute("align","center" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","12" );
      ((Element)v.get(434)).setAttribute("height","12" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("width","750" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(437)).setAttribute("width","12" );
      ((Element)v.get(432)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","12" );
      ((Element)v.get(438)).setAttribute("height","1" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:432   */

      /* Empieza nodo:439 / Elemento padre: 431   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(431)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(444)).setAttribute("class","legend" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(445)).setAttribute("ancho","120" );
      ((Element)v.get(445)).setAttribute("alto","13" );
      ((Element)v.get(445)).setAttribute("filas","1" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("id","legend" );
      ((Element)v.get(445)).setAttribute("cod","0011" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 443   */
      v.add(doc.createElement("table"));
      ((Element)v.get(446)).setAttribute("width","100%" );
      ((Element)v.get(446)).setAttribute("border","0" );
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(446)).setAttribute("cellspacing","0" );
      ((Element)v.get(446)).setAttribute("cellpadding","0" );
      ((Element)v.get(443)).appendChild((Element)v.get(446));

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
      ((Element)v.get(454)).setAttribute("nombre","lblNumeroGrupos" );
      ((Element)v.get(454)).setAttribute("ancho","60" );
      ((Element)v.get(454)).setAttribute("alto","17" );
      ((Element)v.get(454)).setAttribute("filas","1" );
      ((Element)v.get(454)).setAttribute("valor","" );
      ((Element)v.get(454)).setAttribute("id","datosTitle" );
      ((Element)v.get(454)).setAttribute("cod","533" );
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
      ((Element)v.get(458)).setAttribute("nombre","lblNumeroPaquetes" );
      ((Element)v.get(458)).setAttribute("ancho","75" );
      ((Element)v.get(458)).setAttribute("alto","17" );
      ((Element)v.get(458)).setAttribute("filas","1" );
      ((Element)v.get(458)).setAttribute("valor","" );
      ((Element)v.get(458)).setAttribute("id","datosTitle" );
      ((Element)v.get(458)).setAttribute("cod","534" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","25" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(462)).setAttribute("nombre","lblIndicadorCuadre" );
      ((Element)v.get(462)).setAttribute("ancho","90" );
      ((Element)v.get(462)).setAttribute("alto","17" );
      ((Element)v.get(462)).setAttribute("filas","1" );
      ((Element)v.get(462)).setAttribute("valor","" );
      ((Element)v.get(462)).setAttribute("id","datosTitle" );
      ((Element)v.get(462)).setAttribute("cod","461" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","25" );
      ((Element)v.get(464)).setAttribute("height","8" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(466)).setAttribute("nombre","lblNumeroGruposCondicionantes" );
      ((Element)v.get(466)).setAttribute("ancho","130" );
      ((Element)v.get(466)).setAttribute("alto","17" );
      ((Element)v.get(466)).setAttribute("filas","1" );
      ((Element)v.get(466)).setAttribute("valor","" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("cod","535" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","25" );
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).setAttribute("colspan","2" );
      ((Element)v.get(450)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(470)).setAttribute("nombre","lblCondicionCondicionantes" );
      ((Element)v.get(470)).setAttribute("ancho","90" );
      ((Element)v.get(470)).setAttribute("alto","17" );
      ((Element)v.get(470)).setAttribute("filas","1" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(470)).setAttribute("id","datosTitle" );
      ((Element)v.get(470)).setAttribute("cod","536" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("width","100%" );
      ((Element)v.get(450)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:450   */

      /* Empieza nodo:473 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(475)).setAttribute("src","b.gif" );
      ((Element)v.get(475)).setAttribute("width","8" );
      ((Element)v.get(475)).setAttribute("height","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(476)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(473)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(477)).setAttribute("nombre","txtNumeroGrupos" );
      ((Element)v.get(477)).setAttribute("id","datosCampos" );
      ((Element)v.get(477)).setAttribute("max","6" );
      ((Element)v.get(477)).setAttribute("tipo","" );
      ((Element)v.get(477)).setAttribute("onchange","" );
      ((Element)v.get(477)).setAttribute("req","N" );
      ((Element)v.get(477)).setAttribute("size","6" );
      ((Element)v.get(477)).setAttribute("valor","" );
      ((Element)v.get(477)).setAttribute("validacion","" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","25" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(473)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(481)).setAttribute("nombre","txtNumeroPaquetes" );
      ((Element)v.get(481)).setAttribute("id","datosCampos" );
      ((Element)v.get(481)).setAttribute("max","6" );
      ((Element)v.get(481)).setAttribute("tipo","" );
      ((Element)v.get(481)).setAttribute("onchange","" );
      ((Element)v.get(481)).setAttribute("req","N" );
      ((Element)v.get(481)).setAttribute("size","6" );
      ((Element)v.get(481)).setAttribute("valor","" );
      ((Element)v.get(481)).setAttribute("validacion","" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","25" );
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(473)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(485)).setAttribute("nombre","cbIndicadorCuadre" );
      ((Element)v.get(485)).setAttribute("id","datosCampos" );
      ((Element)v.get(485)).setAttribute("size","1" );
      ((Element)v.get(485)).setAttribute("multiple","N" );
      ((Element)v.get(485)).setAttribute("req","N" );
      ((Element)v.get(485)).setAttribute("valorinicial","" );
      ((Element)v.get(485)).setAttribute("textoinicial","" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(486)).setAttribute("ID","DTOSalida.indicadorcuadre_ROWSET" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:487 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","25" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(473)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(490)).setAttribute("nombre","txtNumeroGruposCondicionantes" );
      ((Element)v.get(490)).setAttribute("id","datosCampos" );
      ((Element)v.get(490)).setAttribute("max","6" );
      ((Element)v.get(490)).setAttribute("tipo","" );
      ((Element)v.get(490)).setAttribute("onchange","" );
      ((Element)v.get(490)).setAttribute("req","N" );
      ((Element)v.get(490)).setAttribute("size","6" );
      ((Element)v.get(490)).setAttribute("valor","" );
      ((Element)v.get(490)).setAttribute("validacion","" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","25" );
      ((Element)v.get(492)).setAttribute("height","8" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("table"));
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("class","datosCampos" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(497)).setAttribute("nombre","rbCondicionCondicionantes" );
      ((Element)v.get(497)).setAttribute("tipo","H" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).setAttribute("req","N" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(498)).setAttribute("valor","S" );
      ((Element)v.get(498)).setAttribute("check","N" );
      ((Element)v.get(498)).setAttribute("onfocus","" );
      ((Element)v.get(498)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Elemento padre:498 / Elemento actual: 499   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(498)).appendChild((Text)v.get(499));

      /* Termina nodo Texto:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(500)).setAttribute("valor","N" );
      ((Element)v.get(500)).setAttribute("onfocus","" );
      ((Element)v.get(500)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Elemento padre:500 / Elemento actual: 501   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createTextNode("O"));
      ((Element)v.get(500)).appendChild((Text)v.get(501));

      /* Termina nodo Texto:501   */
      /* Termina nodo:500   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:502 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","1" );
      ((Element)v.get(473)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","1" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 473   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).setAttribute("width","100%" );
      ((Element)v.get(473)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","1" );
      ((Element)v.get(507)).setAttribute("height","1" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:473   */

      /* Empieza nodo:508 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("colspan","4" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:446   */

      /* Empieza nodo:511 / Elemento padre: 443   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(443)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).setAttribute("colspan","4" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:515 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblNumeroGruposCondicionados" );
      ((Element)v.get(519)).setAttribute("ancho","130" );
      ((Element)v.get(519)).setAttribute("alto","17" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","537" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("colspan","2" );
      ((Element)v.get(515)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(523)).setAttribute("nombre","lblCondicionCondicionados" );
      ((Element)v.get(523)).setAttribute("ancho","90" );
      ((Element)v.get(523)).setAttribute("alto","17" );
      ((Element)v.get(523)).setAttribute("filas","1" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("id","datosTitle" );
      ((Element)v.get(523)).setAttribute("cod","538" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(515)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","25" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("colspan","6" );
      ((Element)v.get(515)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(527)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(527)).setAttribute("ancho","87" );
      ((Element)v.get(527)).setAttribute("alto","17" );
      ((Element)v.get(527)).setAttribute("filas","1" );
      ((Element)v.get(527)).setAttribute("valor","" );
      ((Element)v.get(527)).setAttribute("id","datosTitle" );
      ((Element)v.get(527)).setAttribute("cod","541" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(515)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:515   */

      /* Empieza nodo:530 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(530)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(534)).setAttribute("nombre","txtNumeroGruposCondicionados" );
      ((Element)v.get(534)).setAttribute("id","datosCampos" );
      ((Element)v.get(534)).setAttribute("max","6" );
      ((Element)v.get(534)).setAttribute("tipo","" );
      ((Element)v.get(534)).setAttribute("onchange","" );
      ((Element)v.get(534)).setAttribute("req","N" );
      ((Element)v.get(534)).setAttribute("size","6" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(534)).setAttribute("validacion","" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","25" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("table"));
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("td"));
      ((Element)v.get(540)).setAttribute("class","datosCampos" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(541)).setAttribute("nombre","rbCondicionCondicionados" );
      ((Element)v.get(541)).setAttribute("tipo","H" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).setAttribute("req","N" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(542)).setAttribute("valor","S" );
      ((Element)v.get(542)).setAttribute("check","N" );
      ((Element)v.get(542)).setAttribute("onfocus","" );
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Elemento padre:542 / Elemento actual: 543   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(542)).appendChild((Text)v.get(543));

      /* Termina nodo Texto:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(544)).setAttribute("valor","N" );
      ((Element)v.get(544)).setAttribute("onfocus","" );
      ((Element)v.get(544)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Elemento padre:544 / Elemento actual: 545   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(544)).appendChild((Text)v.get(545));

      /* Termina nodo Texto:545   */
      /* Termina nodo:544   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:546 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","iconorequerido.gif" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","25" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(530)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(551)).setAttribute("nombre","cbFormasPago" );
      ((Element)v.get(551)).setAttribute("id","datosCampos" );
      ((Element)v.get(551)).setAttribute("size","1" );
      ((Element)v.get(551)).setAttribute("multiple","N" );
      ((Element)v.get(551)).setAttribute("req","N" );
      ((Element)v.get(551)).setAttribute("valorinicial","" );
      ((Element)v.get(551)).setAttribute("textoinicial","" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(552)).setAttribute("ID","DTOSalida.formapago_ROWSET" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(554)).setAttribute("NOMBRE","OID_FORM_PAGO" );
      ((Element)v.get(554)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(554)).setAttribute("LONGITUD","50" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Elemento padre:554 / Elemento actual: 555   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(554)).appendChild((Text)v.get(555));

      /* Termina nodo Texto:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(556)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(556)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(556)).setAttribute("LONGITUD","50" );
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Elemento padre:556 / Elemento actual: 557   */
      v.add(doc.createTextNode("Pagaré 30, 60, 90"));
      ((Element)v.get(556)).appendChild((Text)v.get(557));

      /* Termina nodo Texto:557   */
      /* Termina nodo:556   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:558 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","25" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(561)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(561)).setAttribute("texto","" );
      ((Element)v.get(561)).setAttribute("check","S" );
      ((Element)v.get(561)).setAttribute("validacion","" );
      ((Element)v.get(561)).setAttribute("req","N" );
      ((Element)v.get(561)).setAttribute("id","datosCampos" );
      ((Element)v.get(561)).setAttribute("ontab","" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(563)).setAttribute("ancho","110" );
      ((Element)v.get(563)).setAttribute("alto","17" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(563)).setAttribute("id","datosCampos" );
      ((Element)v.get(563)).setAttribute("cod","539" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(567)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(567)).setAttribute("texto","" );
      ((Element)v.get(567)).setAttribute("check","S" );
      ((Element)v.get(567)).setAttribute("validacion","" );
      ((Element)v.get(567)).setAttribute("req","N" );
      ((Element)v.get(567)).setAttribute("id","datosCampos" );
      ((Element)v.get(567)).setAttribute("ontab","" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:568 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(569)).setAttribute("nombre","lblDespachoAutomatico" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(569)).setAttribute("ancho","110" );
      ((Element)v.get(569)).setAttribute("alto","17" );
      ((Element)v.get(569)).setAttribute("filas","1" );
      ((Element)v.get(569)).setAttribute("valor","" );
      ((Element)v.get(569)).setAttribute("id","datosCampos" );
      ((Element)v.get(569)).setAttribute("cod","540" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).setAttribute("width","51" );
      ((Element)v.get(530)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","51" );
      ((Element)v.get(571)).setAttribute("height","1" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(572)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","1" );
      ((Element)v.get(573)).setAttribute("height","1" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:530   */

      /* Empieza nodo:574 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(575)).setAttribute("colspan","4" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:511   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:577 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:439   */

      /* Empieza nodo:579 / Elemento padre: 431   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(431)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("width","12" );
      ((Element)v.get(580)).setAttribute("align","center" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","12" );
      ((Element)v.get(581)).setAttribute("height","12" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:582 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).setAttribute("width","756" );
      ((Element)v.get(579)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(583)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:584 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).setAttribute("width","12" );
      ((Element)v.get(579)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","12" );
      ((Element)v.get(585)).setAttribute("height","1" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:579   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:586 / Elemento padre: 6   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(586)).setAttribute("nombre","rejlistado3" );
      ((Element)v.get(6)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 6   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(587)).setAttribute("nombre","rejlistado4" );
      ((Element)v.get(6)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */

      /* Empieza nodo:588 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(588)).setAttribute("nombre","capaVentaExclusiva" );
      ((Element)v.get(588)).setAttribute("alto","491" );
      ((Element)v.get(588)).setAttribute("ancho","100%" );
      ((Element)v.get(588)).setAttribute("colorf","" );
      ((Element)v.get(588)).setAttribute("borde","0" );
      ((Element)v.get(588)).setAttribute("imagenf","" );
      ((Element)v.get(588)).setAttribute("repeat","" );
      ((Element)v.get(588)).setAttribute("padding","" );
      ((Element)v.get(588)).setAttribute("visibilidad","visible" );
      ((Element)v.get(588)).setAttribute("contravsb","" );
      ((Element)v.get(588)).setAttribute("x","0" );
      ((Element)v.get(588)).setAttribute("y","913" );
      ((Element)v.get(588)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("table"));
      ((Element)v.get(589)).setAttribute("width","100%" );
      ((Element)v.get(589)).setAttribute("border","0" );
      ((Element)v.get(589)).setAttribute("cellspacing","0" );
      ((Element)v.get(589)).setAttribute("cellpadding","0" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","12" );
      ((Element)v.get(592)).setAttribute("height","12" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 590   */
      v.add(doc.createElement("td"));
      ((Element)v.get(593)).setAttribute("width","750" );
      ((Element)v.get(590)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","1" );
      ((Element)v.get(594)).setAttribute("height","1" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 590   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(596)).setAttribute("height","12" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */
      /* Termina nodo:590   */

      /* Empieza nodo:597 / Elemento padre: 589   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(589)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("td"));
      ((Element)v.get(598)).setAttribute("width","12" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","12" );
      ((Element)v.get(599)).setAttribute("height","12" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 597   */
      v.add(doc.createElement("td"));
      ((Element)v.get(597)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(602)).setAttribute("class","legend" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(603)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(603)).setAttribute("ancho","115" );
      ((Element)v.get(603)).setAttribute("alto","13" );
      ((Element)v.get(603)).setAttribute("filas","1" );
      ((Element)v.get(603)).setAttribute("valor","" );
      ((Element)v.get(603)).setAttribute("id","legend" );
      ((Element)v.get(603)).setAttribute("cod","0010" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 601   */
      v.add(doc.createElement("table"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(604)).setAttribute("border","0" );
      ((Element)v.get(604)).setAttribute("align","center" );
      ((Element)v.get(604)).setAttribute("cellspacing","0" );
      ((Element)v.get(604)).setAttribute("cellpadding","0" );
      ((Element)v.get(601)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("colspan","4" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","12" );
      ((Element)v.get(607)).setAttribute("height","12" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:608 / Elemento padre: 604   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(604)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("colspan","7" );
      ((Element)v.get(611)).setAttribute("width","100%" );
      ((Element)v.get(608)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("table"));
      ((Element)v.get(612)).setAttribute("width","100%" );
      ((Element)v.get(612)).setAttribute("border","0" );
      ((Element)v.get(612)).setAttribute("cellspacing","0" );
      ((Element)v.get(612)).setAttribute("cellpadding","0" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("table"));
      ((Element)v.get(616)).setAttribute("width","100%" );
      ((Element)v.get(616)).setAttribute("border","0" );
      ((Element)v.get(616)).setAttribute("align","center" );
      ((Element)v.get(616)).setAttribute("cellspacing","0" );
      ((Element)v.get(616)).setAttribute("cellpadding","0" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("td"));
      ((Element)v.get(618)).setAttribute("colspan","4" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(619)).setAttribute("src","b.gif" );
      ((Element)v.get(619)).setAttribute("width","8" );
      ((Element)v.get(619)).setAttribute("height","8" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:620 / Elemento padre: 616   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(616)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(621)).setAttribute("colspan","4" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(624)).setAttribute("nombre","lblTipoCliente4" );
      ((Element)v.get(624)).setAttribute("ancho","110" );
      ((Element)v.get(624)).setAttribute("alto","17" );
      ((Element)v.get(624)).setAttribute("filas","1" );
      ((Element)v.get(624)).setAttribute("valor","" );
      ((Element)v.get(624)).setAttribute("id","datosTitle" );
      ((Element)v.get(624)).setAttribute("cod","393" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","25" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(628)).setAttribute("nombre","lblSubTipoCliente4" );
      ((Element)v.get(628)).setAttribute("ancho","110" );
      ((Element)v.get(628)).setAttribute("alto","17" );
      ((Element)v.get(628)).setAttribute("filas","1" );
      ((Element)v.get(628)).setAttribute("valor","" );
      ((Element)v.get(628)).setAttribute("id","datosTitle" );
      ((Element)v.get(628)).setAttribute("cod","595" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","25" );
      ((Element)v.get(630)).setAttribute("height","8" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(632)).setAttribute("nombre","lblTipoClasificacionCliente4" );
      ((Element)v.get(632)).setAttribute("ancho","130" );
      ((Element)v.get(632)).setAttribute("alto","17" );
      ((Element)v.get(632)).setAttribute("filas","1" );
      ((Element)v.get(632)).setAttribute("valor","" );
      ((Element)v.get(632)).setAttribute("id","datosTitle" );
      ((Element)v.get(632)).setAttribute("cod","610" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 620   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("width","100%" );
      ((Element)v.get(620)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","8" );
      ((Element)v.get(634)).setAttribute("height","8" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */
      /* Termina nodo:620   */

      /* Empieza nodo:635 / Elemento padre: 616   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(616)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(637)).setAttribute("width","8" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(639)).setAttribute("nombre","ckVentaExclusiva4" );
      ((Element)v.get(639)).setAttribute("texto","" );
      ((Element)v.get(639)).setAttribute("check","N" );
      ((Element)v.get(639)).setAttribute("onclick","che();" );
      ((Element)v.get(639)).setAttribute("validacion","" );
      ((Element)v.get(639)).setAttribute("req","N" );
      ((Element)v.get(639)).setAttribute("id","datosCampos" );
      ((Element)v.get(639)).setAttribute("ontab","" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(641)).setAttribute("nombre","lblVentaExclusiva4" );
      ((Element)v.get(641)).setAttribute("ancho","90" );
      ((Element)v.get(641)).setAttribute("alto","17" );
      ((Element)v.get(641)).setAttribute("filas","1" );
      ((Element)v.get(641)).setAttribute("valor","" );
      ((Element)v.get(641)).setAttribute("id","datosCampos" );
      ((Element)v.get(641)).setAttribute("cod","0010" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","25" );
      ((Element)v.get(643)).setAttribute("height","8" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(635)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(645)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(645)).setAttribute("size","1" );
      ((Element)v.get(645)).setAttribute("multiple","N" );
      ((Element)v.get(645)).setAttribute("req","N" );
      ((Element)v.get(645)).setAttribute("valorinicial","" );
      ((Element)v.get(645)).setAttribute("textoinicial","" );
      ((Element)v.get(645)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(646)).setAttribute("ID","DTOSalida.tipocliente_ROWSET" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(648)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(648)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(648)).setAttribute("LONGITUD","50" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Elemento padre:648 / Elemento actual: 649   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(648)).appendChild((Text)v.get(649));

      /* Termina nodo Texto:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 647   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(650)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(650)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(650)).setAttribute("LONGITUD","50" );
      ((Element)v.get(647)).appendChild((Element)v.get(650));

      /* Elemento padre:650 / Elemento actual: 651   */
      v.add(doc.createTextNode("Administrador"));
      ((Element)v.get(650)).appendChild((Text)v.get(651));

      /* Termina nodo Texto:651   */
      /* Termina nodo:650   */
      /* Termina nodo:647   */

      /* Empieza nodo:652 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(653)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(653)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(653)).setAttribute("LONGITUD","50" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Elemento padre:653 / Elemento actual: 654   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(653)).appendChild((Text)v.get(654));

      /* Termina nodo Texto:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:655 / Elemento padre: 652   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(655)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(655)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(655)).setAttribute("LONGITUD","50" );
      ((Element)v.get(652)).appendChild((Element)v.get(655));

      /* Elemento padre:655 / Elemento actual: 656   */
      v.add(doc.createTextNode("Cliente"));
      ((Element)v.get(655)).appendChild((Text)v.get(656));

      /* Termina nodo Texto:656   */
      /* Termina nodo:655   */
      /* Termina nodo:652   */

      /* Empieza nodo:657 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(658)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(658)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(658)).setAttribute("LONGITUD","50" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Elemento padre:658 / Elemento actual: 659   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(658)).appendChild((Text)v.get(659));

      /* Termina nodo Texto:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 657   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(660)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(660)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(660)).setAttribute("LONGITUD","50" );
      ((Element)v.get(657)).appendChild((Element)v.get(660));

      /* Elemento padre:660 / Elemento actual: 661   */
      v.add(doc.createTextNode("Consultor(a)"));
      ((Element)v.get(660)).appendChild((Text)v.get(661));

      /* Termina nodo Texto:661   */
      /* Termina nodo:660   */
      /* Termina nodo:657   */

      /* Empieza nodo:662 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(663)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(663)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(663)).setAttribute("LONGITUD","50" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Elemento padre:663 / Elemento actual: 664   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(663)).appendChild((Text)v.get(664));

      /* Termina nodo Texto:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 662   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(665)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(665)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(665)).setAttribute("LONGITUD","50" );
      ((Element)v.get(662)).appendChild((Element)v.get(665));

      /* Elemento padre:665 / Elemento actual: 666   */
      v.add(doc.createTextNode("Coordinador"));
      ((Element)v.get(665)).appendChild((Text)v.get(666));

      /* Termina nodo Texto:666   */
      /* Termina nodo:665   */
      /* Termina nodo:662   */

      /* Empieza nodo:667 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(668)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(668)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(668)).setAttribute("LONGITUD","50" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));

      /* Elemento padre:668 / Elemento actual: 669   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(668)).appendChild((Text)v.get(669));

      /* Termina nodo Texto:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 667   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(670)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(670)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(670)).setAttribute("LONGITUD","50" );
      ((Element)v.get(667)).appendChild((Element)v.get(670));

      /* Elemento padre:670 / Elemento actual: 671   */
      v.add(doc.createTextNode("Gerente"));
      ((Element)v.get(670)).appendChild((Text)v.get(671));

      /* Termina nodo Texto:671   */
      /* Termina nodo:670   */
      /* Termina nodo:667   */

      /* Empieza nodo:672 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(673)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(673)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(673)).setAttribute("LONGITUD","50" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Elemento padre:673 / Elemento actual: 674   */
      v.add(doc.createTextNode("12"));
      ((Element)v.get(673)).appendChild((Text)v.get(674));

      /* Termina nodo Texto:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 672   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(675)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(675)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(675)).setAttribute("LONGITUD","50" );
      ((Element)v.get(672)).appendChild((Element)v.get(675));

      /* Elemento padre:675 / Elemento actual: 676   */
      v.add(doc.createTextNode("Gerente de zona"));
      ((Element)v.get(675)).appendChild((Text)v.get(676));

      /* Termina nodo Texto:676   */
      /* Termina nodo:675   */
      /* Termina nodo:672   */

      /* Empieza nodo:677 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(678)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(678)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(678)).setAttribute("LONGITUD","50" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Elemento padre:678 / Elemento actual: 679   */
      v.add(doc.createTextNode("33"));
      ((Element)v.get(678)).appendChild((Text)v.get(679));

      /* Termina nodo Texto:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:680 / Elemento padre: 677   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(680)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(680)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(680)).setAttribute("LONGITUD","50" );
      ((Element)v.get(677)).appendChild((Element)v.get(680));

      /* Elemento padre:680 / Elemento actual: 681   */
      v.add(doc.createTextNode("Instructor"));
      ((Element)v.get(680)).appendChild((Text)v.get(681));

      /* Termina nodo Texto:681   */
      /* Termina nodo:680   */
      /* Termina nodo:677   */

      /* Empieza nodo:682 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(683)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(683)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(683)).setAttribute("LONGITUD","50" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));

      /* Elemento padre:683 / Elemento actual: 684   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(683)).appendChild((Text)v.get(684));

      /* Termina nodo Texto:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 682   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(685)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(685)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(685)).setAttribute("LONGITUD","50" );
      ((Element)v.get(682)).appendChild((Element)v.get(685));

      /* Elemento padre:685 / Elemento actual: 686   */
      v.add(doc.createTextNode("Instructor(a)"));
      ((Element)v.get(685)).appendChild((Text)v.get(686));

      /* Termina nodo Texto:686   */
      /* Termina nodo:685   */
      /* Termina nodo:682   */

      /* Empieza nodo:687 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(688)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(688)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(688)).setAttribute("LONGITUD","50" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Elemento padre:688 / Elemento actual: 689   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(688)).appendChild((Text)v.get(689));

      /* Termina nodo Texto:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(690)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(690)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(690)).setAttribute("LONGITUD","50" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Elemento padre:690 / Elemento actual: 691   */
      v.add(doc.createTextNode("Potencial"));
      ((Element)v.get(690)).appendChild((Text)v.get(691));

      /* Termina nodo Texto:691   */
      /* Termina nodo:690   */
      /* Termina nodo:687   */

      /* Empieza nodo:692 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(693)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(693)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(693)).setAttribute("LONGITUD","50" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));

      /* Elemento padre:693 / Elemento actual: 694   */
      v.add(doc.createTextNode("9"));
      ((Element)v.get(693)).appendChild((Text)v.get(694));

      /* Termina nodo Texto:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 692   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(695)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(695)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(695)).setAttribute("LONGITUD","50" );
      ((Element)v.get(692)).appendChild((Element)v.get(695));

      /* Elemento padre:695 / Elemento actual: 696   */
      v.add(doc.createTextNode("TipoCliente1"));
      ((Element)v.get(695)).appendChild((Text)v.get(696));

      /* Termina nodo Texto:696   */
      /* Termina nodo:695   */
      /* Termina nodo:692   */

      /* Empieza nodo:697 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(698)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(698)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(698)).setAttribute("LONGITUD","50" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));

      /* Elemento padre:698 / Elemento actual: 699   */
      v.add(doc.createTextNode("10"));
      ((Element)v.get(698)).appendChild((Text)v.get(699));

      /* Termina nodo Texto:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:700 / Elemento padre: 697   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(700)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(700)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(700)).setAttribute("LONGITUD","50" );
      ((Element)v.get(697)).appendChild((Element)v.get(700));

      /* Elemento padre:700 / Elemento actual: 701   */
      v.add(doc.createTextNode("TipoCliente2"));
      ((Element)v.get(700)).appendChild((Text)v.get(701));

      /* Termina nodo Texto:701   */
      /* Termina nodo:700   */
      /* Termina nodo:697   */

      /* Empieza nodo:702 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(703)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(703)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(703)).setAttribute("LONGITUD","50" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Elemento padre:703 / Elemento actual: 704   */
      v.add(doc.createTextNode("11"));
      ((Element)v.get(703)).appendChild((Text)v.get(704));

      /* Termina nodo Texto:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 702   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(705)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(705)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(705)).setAttribute("LONGITUD","50" );
      ((Element)v.get(702)).appendChild((Element)v.get(705));

      /* Elemento padre:705 / Elemento actual: 706   */
      v.add(doc.createTextNode("TipoCliente3"));
      ((Element)v.get(705)).appendChild((Text)v.get(706));

      /* Termina nodo Texto:706   */
      /* Termina nodo:705   */
      /* Termina nodo:702   */

      /* Empieza nodo:707 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(708)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(708)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(708)).setAttribute("LONGITUD","50" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));

      /* Elemento padre:708 / Elemento actual: 709   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(708)).appendChild((Text)v.get(709));

      /* Termina nodo Texto:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:710 / Elemento padre: 707   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(710)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(710)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(710)).setAttribute("LONGITUD","50" );
      ((Element)v.get(707)).appendChild((Element)v.get(710));

      /* Elemento padre:710 / Elemento actual: 711   */
      v.add(doc.createTextNode("Transportista"));
      ((Element)v.get(710)).appendChild((Text)v.get(711));

      /* Termina nodo Texto:711   */
      /* Termina nodo:710   */
      /* Termina nodo:707   */

      /* Empieza nodo:712 / Elemento padre: 646   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(646)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(713)).setAttribute("NOMBRE","OID_TIPO_CLIE" );
      ((Element)v.get(713)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(713)).setAttribute("LONGITUD","50" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Elemento padre:713 / Elemento actual: 714   */
      v.add(doc.createTextNode("13"));
      ((Element)v.get(713)).appendChild((Text)v.get(714));

      /* Termina nodo Texto:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:715 / Elemento padre: 712   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(715)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(715)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(715)).setAttribute("LONGITUD","50" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(712)).appendChild((Element)v.get(715));

      /* Elemento padre:715 / Elemento actual: 716   */
      v.add(doc.createTextNode("Vendedor"));
      ((Element)v.get(715)).appendChild((Text)v.get(716));

      /* Termina nodo Texto:716   */
      /* Termina nodo:715   */
      /* Termina nodo:712   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:717 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(718)).setAttribute("src","b.gif" );
      ((Element)v.get(718)).setAttribute("width","25" );
      ((Element)v.get(718)).setAttribute("height","8" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(719)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(635)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(720)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(720)).setAttribute("id","datosCampos" );
      ((Element)v.get(720)).setAttribute("size","1" );
      ((Element)v.get(720)).setAttribute("multiple","N" );
      ((Element)v.get(720)).setAttribute("req","N" );
      ((Element)v.get(720)).setAttribute("valorinicial","" );
      ((Element)v.get(720)).setAttribute("textoinicial","" );
      ((Element)v.get(720)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:722 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(723)).setAttribute("src","b.gif" );
      ((Element)v.get(723)).setAttribute("width","25" );
      ((Element)v.get(723)).setAttribute("height","8" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:724 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(724)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(635)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(725)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(725)).setAttribute("id","datosCampos" );
      ((Element)v.get(725)).setAttribute("size","1" );
      ((Element)v.get(725)).setAttribute("multiple","N" );
      ((Element)v.get(725)).setAttribute("req","N" );
      ((Element)v.get(725)).setAttribute("valorinicial","" );
      ((Element)v.get(725)).setAttribute("textoinicial","" );
      ((Element)v.get(725)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(725)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:727 / Elemento padre: 635   */
      v.add(doc.createElement("td"));
      ((Element)v.get(727)).setAttribute("width","100%" );
      ((Element)v.get(635)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","8" );
      ((Element)v.get(728)).setAttribute("height","8" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:635   */
      /* Termina nodo:616   */

      /* Empieza nodo:729 / Elemento padre: 615   */
      v.add(doc.createElement("table"));
      ((Element)v.get(729)).setAttribute("width","100%" );
      ((Element)v.get(729)).setAttribute("border","0" );
      ((Element)v.get(729)).setAttribute("align","center" );
      ((Element)v.get(729)).setAttribute("cellspacing","0" );
      ((Element)v.get(729)).setAttribute("cellpadding","0" );
      ((Element)v.get(615)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("colspan","4" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","8" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */

      /* Empieza nodo:733 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","8" );
      ((Element)v.get(735)).setAttribute("height","8" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(737)).setAttribute("nombre","lblClasificacionCliente4" );
      ((Element)v.get(737)).setAttribute("ancho","110" );
      ((Element)v.get(737)).setAttribute("alto","17" );
      ((Element)v.get(737)).setAttribute("filas","1" );
      ((Element)v.get(737)).setAttribute("valor","" );
      ((Element)v.get(737)).setAttribute("id","datosTitle" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(737)).setAttribute("cod","611" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */
      /* Termina nodo:736   */

      /* Empieza nodo:738 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(739)).setAttribute("src","b.gif" );
      ((Element)v.get(739)).setAttribute("width","25" );
      ((Element)v.get(739)).setAttribute("height","8" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:740 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(741)).setAttribute("nombre","lblEstatusCliente4" );
      ((Element)v.get(741)).setAttribute("ancho","90" );
      ((Element)v.get(741)).setAttribute("alto","17" );
      ((Element)v.get(741)).setAttribute("filas","1" );
      ((Element)v.get(741)).setAttribute("valor","" );
      ((Element)v.get(741)).setAttribute("id","datosTitle" );
      ((Element)v.get(741)).setAttribute("cod","612" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */
      /* Termina nodo:740   */

      /* Empieza nodo:742 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(743)).setAttribute("src","b.gif" );
      ((Element)v.get(743)).setAttribute("width","25" );
      ((Element)v.get(743)).setAttribute("height","8" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */

      /* Empieza nodo:744 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(745)).setAttribute("nombre","lblEstatus2Cliente4" );
      ((Element)v.get(745)).setAttribute("ancho","130" );
      ((Element)v.get(745)).setAttribute("alto","17" );
      ((Element)v.get(745)).setAttribute("filas","1" );
      ((Element)v.get(745)).setAttribute("valor","" );
      ((Element)v.get(745)).setAttribute("id","datosTitle" );
      ((Element)v.get(745)).setAttribute("cod","613" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */
      /* Termina nodo:744   */

      /* Empieza nodo:746 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(746)).setAttribute("width","257" );
      ((Element)v.get(733)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","257" );
      ((Element)v.get(747)).setAttribute("height","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */

      /* Empieza nodo:748 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(748)).setAttribute("width","100%" );
      ((Element)v.get(733)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(749)).setAttribute("src","b.gif" );
      ((Element)v.get(749)).setAttribute("width","8" );
      ((Element)v.get(749)).setAttribute("height","8" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */
      /* Termina nodo:733   */

      /* Empieza nodo:750 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(752)).setAttribute("src","b.gif" );
      ((Element)v.get(752)).setAttribute("width","8" );
      ((Element)v.get(752)).setAttribute("height","8" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */
      /* Termina nodo:751   */

      /* Empieza nodo:753 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(753)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(750)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(754)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(754)).setAttribute("id","datosCampos" );
      ((Element)v.get(754)).setAttribute("size","1" );
      ((Element)v.get(754)).setAttribute("multiple","N" );
      ((Element)v.get(754)).setAttribute("req","N" );
      ((Element)v.get(754)).setAttribute("valorinicial","" );
      ((Element)v.get(754)).setAttribute("textoinicial","" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:756 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(757)).setAttribute("src","b.gif" );
      ((Element)v.get(757)).setAttribute("width","25" );
      ((Element)v.get(757)).setAttribute("height","8" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:756   */

      /* Empieza nodo:758 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(750)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(759)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(759)).setAttribute("id","datosCampos" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(759)).setAttribute("size","1" );
      ((Element)v.get(759)).setAttribute("multiple","N" );
      ((Element)v.get(759)).setAttribute("req","N" );
      ((Element)v.get(759)).setAttribute("valorinicial","" );
      ((Element)v.get(759)).setAttribute("textoinicial","" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(760)).setAttribute("ID","DTOSalida.estatus_ROWSET" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(762)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(762)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(762)).setAttribute("LONGITUD","50" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));

      /* Elemento padre:762 / Elemento actual: 763   */
      v.add(doc.createTextNode("5"));
      ((Element)v.get(762)).appendChild((Text)v.get(763));

      /* Termina nodo Texto:763   */
      /* Termina nodo:762   */

      /* Empieza nodo:764 / Elemento padre: 761   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(764)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(764)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(764)).setAttribute("LONGITUD","50" );
      ((Element)v.get(761)).appendChild((Element)v.get(764));

      /* Elemento padre:764 / Elemento actual: 765   */
      v.add(doc.createTextNode("Egresada"));
      ((Element)v.get(764)).appendChild((Text)v.get(765));

      /* Termina nodo Texto:765   */
      /* Termina nodo:764   */
      /* Termina nodo:761   */

      /* Empieza nodo:766 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(767)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(767)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(767)).setAttribute("LONGITUD","50" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));

      /* Elemento padre:767 / Elemento actual: 768   */
      v.add(doc.createTextNode("4"));
      ((Element)v.get(767)).appendChild((Text)v.get(768));

      /* Termina nodo Texto:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:769 / Elemento padre: 766   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(769)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(769)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(769)).setAttribute("LONGITUD","50" );
      ((Element)v.get(766)).appendChild((Element)v.get(769));

      /* Elemento padre:769 / Elemento actual: 770   */
      v.add(doc.createTextNode("Egresante"));
      ((Element)v.get(769)).appendChild((Text)v.get(770));

      /* Termina nodo Texto:770   */
      /* Termina nodo:769   */
      /* Termina nodo:766   */

      /* Empieza nodo:771 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(772)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(772)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(772)).setAttribute("LONGITUD","50" );
      ((Element)v.get(771)).appendChild((Element)v.get(772));

      /* Elemento padre:772 / Elemento actual: 773   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(772)).appendChild((Text)v.get(773));

      /* Termina nodo Texto:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:774 / Elemento padre: 771   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(774)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(774)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(774)).setAttribute("LONGITUD","50" );
      ((Element)v.get(771)).appendChild((Element)v.get(774));

      /* Elemento padre:774 / Elemento actual: 775   */
      v.add(doc.createTextNode("Normal"));
      ((Element)v.get(774)).appendChild((Text)v.get(775));

      /* Termina nodo Texto:775   */
      /* Termina nodo:774   */
      /* Termina nodo:771   */

      /* Empieza nodo:776 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(777)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(777)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(777)).setAttribute("LONGITUD","50" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Elemento padre:777 / Elemento actual: 778   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(777)).appendChild((Text)v.get(778));

      /* Termina nodo Texto:778   */
      /* Termina nodo:777   */

      /* Empieza nodo:779 / Elemento padre: 776   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(779)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(779)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(779)).setAttribute("LONGITUD","50" );
      ((Element)v.get(776)).appendChild((Element)v.get(779));

      /* Elemento padre:779 / Elemento actual: 780   */
      v.add(doc.createTextNode("Nueva"));
      ((Element)v.get(779)).appendChild((Text)v.get(780));

      /* Termina nodo Texto:780   */
      /* Termina nodo:779   */
      /* Termina nodo:776   */

      /* Empieza nodo:781 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(782)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(782)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(782)).setAttribute("LONGITUD","50" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));

      /* Elemento padre:782 / Elemento actual: 783   */
      v.add(doc.createTextNode("8"));
      ((Element)v.get(782)).appendChild((Text)v.get(783));

      /* Termina nodo Texto:783   */
      /* Termina nodo:782   */

      /* Empieza nodo:784 / Elemento padre: 781   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(784)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(784)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(784)).setAttribute("LONGITUD","50" );
      ((Element)v.get(781)).appendChild((Element)v.get(784));

      /* Elemento padre:784 / Elemento actual: 785   */
      v.add(doc.createTextNode("Reactivada"));
      ((Element)v.get(784)).appendChild((Text)v.get(785));

      /* Termina nodo Texto:785   */
      /* Termina nodo:784   */
      /* Termina nodo:781   */

      /* Empieza nodo:786 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(760)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(787)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(787)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(787)).setAttribute("LONGITUD","50" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Elemento padre:787 / Elemento actual: 788   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(787)).appendChild((Text)v.get(788));

      /* Termina nodo Texto:788   */
      /* Termina nodo:787   */

      /* Empieza nodo:789 / Elemento padre: 786   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(789)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(789)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(789)).setAttribute("LONGITUD","50" );
      ((Element)v.get(786)).appendChild((Element)v.get(789));

      /* Elemento padre:789 / Elemento actual: 790   */
      v.add(doc.createTextNode("Registrada"));
      ((Element)v.get(789)).appendChild((Text)v.get(790));

      /* Termina nodo Texto:790   */
      /* Termina nodo:789   */
      /* Termina nodo:786   */

      /* Empieza nodo:791 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(792)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(792)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(792)).setAttribute("LONGITUD","50" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));

      /* Elemento padre:792 / Elemento actual: 793   */
      v.add(doc.createTextNode("6"));
      ((Element)v.get(792)).appendChild((Text)v.get(793));

      /* Termina nodo Texto:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 791   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(794)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(794)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(794)).setAttribute("LONGITUD","50" );
      ((Element)v.get(791)).appendChild((Element)v.get(794));

      /* Elemento padre:794 / Elemento actual: 795   */
      v.add(doc.createTextNode("Reingreso"));
      ((Element)v.get(794)).appendChild((Text)v.get(795));

      /* Termina nodo Texto:795   */
      /* Termina nodo:794   */
      /* Termina nodo:791   */

      /* Empieza nodo:796 / Elemento padre: 760   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(760)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(797)).setAttribute("NOMBRE","OID_ESTA_CLIE" );
      ((Element)v.get(797)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(797)).setAttribute("LONGITUD","50" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));

      /* Elemento padre:797 / Elemento actual: 798   */
      v.add(doc.createTextNode("7"));
      ((Element)v.get(797)).appendChild((Text)v.get(798));

      /* Termina nodo Texto:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 796   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(799)).setAttribute("NOMBRE","VAL_I18N" );
      ((Element)v.get(799)).setAttribute("TIPO","OBJECTO" );
      ((Element)v.get(799)).setAttribute("LONGITUD","50" );
      ((Element)v.get(796)).appendChild((Element)v.get(799));

      /* Elemento padre:799 / Elemento actual: 800   */
      v.add(doc.createTextNode("Retirada"));
      ((Element)v.get(799)).appendChild((Text)v.get(800));

      /* Termina nodo Texto:800   */
      /* Termina nodo:799   */
      /* Termina nodo:796   */
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:758   */

      /* Empieza nodo:801 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(802)).setAttribute("src","b.gif" );
      ((Element)v.get(802)).setAttribute("width","25" );
      ((Element)v.get(802)).setAttribute("height","8" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */

      /* Empieza nodo:803 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(803)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(750)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(804)).setAttribute("nombre","txtEstatus2Cliente" );
      ((Element)v.get(804)).setAttribute("id","datosCampos" );
      ((Element)v.get(804)).setAttribute("max","1" );
      ((Element)v.get(804)).setAttribute("tipo","" );
      ((Element)v.get(804)).setAttribute("onchange","" );
      ((Element)v.get(804)).setAttribute("req","N" );
      ((Element)v.get(804)).setAttribute("size","2" );
      ((Element)v.get(804)).setAttribute("valor","" );
      ((Element)v.get(804)).setAttribute("validacion","" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */

      /* Empieza nodo:805 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(750)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(806)).setAttribute("src","b.gif" );
      ((Element)v.get(806)).setAttribute("width","25" );
      ((Element)v.get(806)).setAttribute("height","8" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 750   */
      v.add(doc.createElement("td"));
      ((Element)v.get(807)).setAttribute("width","100%" );
      ((Element)v.get(750)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(808)).setAttribute("src","b.gif" );
      ((Element)v.get(808)).setAttribute("width","8" );
      ((Element)v.get(808)).setAttribute("height","8" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */
      /* Termina nodo:750   */

      /* Empieza nodo:809 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).setAttribute("colspan","4" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(811)).setAttribute("src","b.gif" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(811)).setAttribute("width","8" );
      ((Element)v.get(811)).setAttribute("height","310" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */
      /* Termina nodo:729   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:812 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(813)).setAttribute("src","b.gif" );
      ((Element)v.get(813)).setAttribute("width","12" );
      ((Element)v.get(813)).setAttribute("height","12" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */
      /* Termina nodo:608   */

      /* Empieza nodo:814 / Elemento padre: 604   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(604)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(815)).setAttribute("colspan","3" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(816)).setAttribute("src","b.gif" );
      ((Element)v.get(816)).setAttribute("width","12" );
      ((Element)v.get(816)).setAttribute("height","12" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:604   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:817 / Elemento padre: 597   */
      v.add(doc.createElement("td"));
      ((Element)v.get(597)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(818)).setAttribute("src","b.gif" );
      ((Element)v.get(818)).setAttribute("width","12" );
      ((Element)v.get(818)).setAttribute("height","12" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */
      /* Termina nodo:597   */

      /* Empieza nodo:819 / Elemento padre: 589   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(589)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(821)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).appendChild((Element)v.get(821));
      /* Termina nodo:821   */
      /* Termina nodo:820   */

      /* Empieza nodo:822 / Elemento padre: 819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(822)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("table"));
      ((Element)v.get(824)).setAttribute("width","100%" );
      ((Element)v.get(824)).setAttribute("border","0" );
      ((Element)v.get(824)).setAttribute("align","center" );
      ((Element)v.get(824)).setAttribute("cellspacing","0" );
      ((Element)v.get(824)).setAttribute("cellpadding","0" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(826)).setAttribute("class","botonera" );
      ((Element)v.get(826)).setAttribute("width","100%" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(827)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(827)).setAttribute("ID","botonContenido" );
      ((Element)v.get(827)).setAttribute("tipo","html" );
      ((Element)v.get(827)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(827)).setAttribute("estado","false" );
      ((Element)v.get(827)).setAttribute("cod","404" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */
      /* Termina nodo:825   */
      /* Termina nodo:824   */
      /* Termina nodo:823   */
      /* Termina nodo:822   */

      /* Empieza nodo:828 / Elemento padre: 819   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(829)).setAttribute("src","b.gif" );
      ((Element)v.get(829)).setAttribute("width","12" );
      ((Element)v.get(829)).setAttribute("height","12" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */
      /* Termina nodo:828   */
      /* Termina nodo:819   */

      /* Empieza nodo:830 / Elemento padre: 589   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(589)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).setAttribute("width","12" );
      ((Element)v.get(831)).setAttribute("align","center" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(832)).setAttribute("src","b.gif" );
      ((Element)v.get(832)).setAttribute("width","12" );
      ((Element)v.get(832)).setAttribute("height","12" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */
      /* Termina nodo:831   */

      /* Empieza nodo:833 / Elemento padre: 830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(833)).setAttribute("width","750" );
      ((Element)v.get(830)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(834)).setAttribute("src","b.gif" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */

      /* Empieza nodo:835 / Elemento padre: 830   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).setAttribute("width","12" );
      ((Element)v.get(830)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(836)).setAttribute("src","b.gif" );
      ((Element)v.get(836)).setAttribute("width","12" );
      ((Element)v.get(836)).setAttribute("height","12" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(835)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */
      /* Termina nodo:835   */
      /* Termina nodo:830   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:837 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(837)).setAttribute("nombre","listado5" );
      ((Element)v.get(837)).setAttribute("ancho","637" );
      ((Element)v.get(837)).setAttribute("alto","290" );
      ((Element)v.get(837)).setAttribute("x","32" );
      ((Element)v.get(837)).setAttribute("y","1053" );
      ((Element)v.get(837)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(837)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(838)).setAttribute("precarga","S" );
      ((Element)v.get(838)).setAttribute("conROver","S" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(839)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(839)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(839)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(839)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(838)).appendChild((Element)v.get(839));
      /* Termina nodo:839   */

      /* Empieza nodo:840 / Elemento padre: 838   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(840)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(840)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(840)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(840)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(838)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:838   */

      /* Empieza nodo:841 / Elemento padre: 837   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(837)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(842)).setAttribute("borde","1" );
      ((Element)v.get(842)).setAttribute("horizDatos","1" );
      ((Element)v.get(842)).setAttribute("horizCabecera","1" );
      ((Element)v.get(842)).setAttribute("vertical","0" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */

      /* Empieza nodo:843 / Elemento padre: 841   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(843)).setAttribute("borde","#999999" );
      ((Element)v.get(843)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(843)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(843)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(843)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(841)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:841   */

      /* Empieza nodo:844 / Elemento padre: 837   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(844)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(844)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(844)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(844)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(844)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(837)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(845)).setAttribute("ancho","100" );
      ((Element)v.get(845)).setAttribute("minimizable","S" );
      ((Element)v.get(845)).setAttribute("minimizada","N" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */

      /* Empieza nodo:846 / Elemento padre: 844   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(846)).setAttribute("ancho","100" );
      ((Element)v.get(846)).setAttribute("minimizable","S" );
      ((Element)v.get(846)).setAttribute("minimizada","N" );
      ((Element)v.get(844)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */

      /* Empieza nodo:847 / Elemento padre: 844   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(847)).setAttribute("ancho","100" );
      ((Element)v.get(847)).setAttribute("minimizable","S" );
      ((Element)v.get(847)).setAttribute("minimizada","N" );
      ((Element)v.get(844)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */

      /* Empieza nodo:848 / Elemento padre: 844   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(848)).setAttribute("ancho","100" );
      ((Element)v.get(848)).setAttribute("minimizable","S" );
      ((Element)v.get(848)).setAttribute("minimizada","N" );
      ((Element)v.get(844)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */

      /* Empieza nodo:849 / Elemento padre: 844   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(849)).setAttribute("ancho","100" );
      ((Element)v.get(849)).setAttribute("minimizable","S" );
      ((Element)v.get(849)).setAttribute("minimizada","N" );
      ((Element)v.get(844)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */
      /* Termina nodo:844   */

      /* Empieza nodo:850 / Elemento padre: 837   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(850)).setAttribute("alto","20" );
      ((Element)v.get(850)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(850)).setAttribute("imgFondo","" );
      ((Element)v.get(850)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(837)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(851)).setAttribute("colFondo","" );
      ((Element)v.get(851)).setAttribute("ID","EstCab" );
      ((Element)v.get(851)).setAttribute("cod","393" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */

      /* Empieza nodo:852 / Elemento padre: 850   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(852)).setAttribute("colFondo","" );
      ((Element)v.get(852)).setAttribute("ID","EstCab" );
      ((Element)v.get(852)).setAttribute("cod","595" );
      ((Element)v.get(850)).appendChild((Element)v.get(852));
      /* Termina nodo:852   */

      /* Empieza nodo:853 / Elemento padre: 850   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(853)).setAttribute("colFondo","" );
      ((Element)v.get(853)).setAttribute("ID","EstCab" );
      ((Element)v.get(853)).setAttribute("cod","550" );
      ((Element)v.get(850)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */

      /* Empieza nodo:854 / Elemento padre: 850   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(854)).setAttribute("colFondo","" );
      ((Element)v.get(854)).setAttribute("ID","EstCab" );
      ((Element)v.get(854)).setAttribute("cod","551" );
      ((Element)v.get(850)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */

      /* Empieza nodo:855 / Elemento padre: 850   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(855)).setAttribute("colFondo","" );
      ((Element)v.get(855)).setAttribute("ID","EstCab" );
      ((Element)v.get(855)).setAttribute("cod","552" );
      ((Element)v.get(850)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:850   */

      /* Empieza nodo:856 / Elemento padre: 837   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(856)).setAttribute("alto","22" );
      ((Element)v.get(856)).setAttribute("accion","" );
      ((Element)v.get(856)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(856)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(856)).setAttribute("maxSel","-1" );
      ((Element)v.get(856)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(856)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(856)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(856)).setAttribute("onLoad","" );
      ((Element)v.get(856)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(837)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(857)).setAttribute("tipo","texto" );
      ((Element)v.get(857)).setAttribute("ID","EstDat" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */

      /* Empieza nodo:858 / Elemento padre: 856   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(858)).setAttribute("tipo","texto" );
      ((Element)v.get(858)).setAttribute("ID","EstDat2" );
      ((Element)v.get(856)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */

      /* Empieza nodo:859 / Elemento padre: 856   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(859)).setAttribute("tipo","texto" );
      ((Element)v.get(859)).setAttribute("ID","EstDat" );
      ((Element)v.get(856)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */

      /* Empieza nodo:860 / Elemento padre: 856   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(860)).setAttribute("tipo","texto" );
      ((Element)v.get(860)).setAttribute("ID","EstDat2" );
      ((Element)v.get(856)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */

      /* Empieza nodo:861 / Elemento padre: 856   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(861)).setAttribute("tipo","texto" );
      ((Element)v.get(861)).setAttribute("ID","EstDat" );
      ((Element)v.get(856)).appendChild((Element)v.get(861));
      /* Termina nodo:861   */
      /* Termina nodo:856   */

      /* Empieza nodo:862 / Elemento padre: 837   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(837)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 837   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(863)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(863)).setAttribute("ancho","680" );
      ((Element)v.get(863)).setAttribute("sep","$" );
      ((Element)v.get(863)).setAttribute("x","12" );
      ((Element)v.get(863)).setAttribute("class","botonera" );
      ((Element)v.get(863)).setAttribute("y","2267" );
      ((Element)v.get(863)).setAttribute("control","|" );
      ((Element)v.get(863)).setAttribute("conector","" );
      ((Element)v.get(863)).setAttribute("rowset","" );
      ((Element)v.get(863)).setAttribute("cargainicial","N" );
      ((Element)v.get(837)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(864)).setAttribute("nombre","primera5" );
      ((Element)v.get(864)).setAttribute("x","44" );
      ((Element)v.get(864)).setAttribute("y","2271" );
      ((Element)v.get(864)).setAttribute("ID","botonContenido" );
      ((Element)v.get(864)).setAttribute("img","primera_on" );
      ((Element)v.get(864)).setAttribute("tipo","0" );
      ((Element)v.get(864)).setAttribute("estado","false" );
      ((Element)v.get(864)).setAttribute("alt","" );
      ((Element)v.get(864)).setAttribute("codigo","" );
      ((Element)v.get(864)).setAttribute("accion","" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */

      /* Empieza nodo:865 / Elemento padre: 863   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(865)).setAttribute("nombre","ava5" );
      ((Element)v.get(865)).setAttribute("x","79" );
      ((Element)v.get(865)).setAttribute("y","2271" );
      ((Element)v.get(865)).setAttribute("ID","botonContenido" );
      ((Element)v.get(865)).setAttribute("img","avanzar_on" );
      ((Element)v.get(865)).setAttribute("tipo","0" );
      ((Element)v.get(865)).setAttribute("estado","false" );
      ((Element)v.get(865)).setAttribute("alt","" );
      ((Element)v.get(865)).setAttribute("codigo","" );
      ((Element)v.get(865)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(863)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */

      /* Empieza nodo:866 / Elemento padre: 863   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(866)).setAttribute("nombre","ret5" );
      ((Element)v.get(866)).setAttribute("x","64" );
      ((Element)v.get(866)).setAttribute("y","2271" );
      ((Element)v.get(866)).setAttribute("ID","botonContenido" );
      ((Element)v.get(866)).setAttribute("img","retroceder_on" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(866)).setAttribute("tipo","0" );
      ((Element)v.get(866)).setAttribute("estado","false" );
      ((Element)v.get(866)).setAttribute("alt","" );
      ((Element)v.get(866)).setAttribute("codigo","" );
      ((Element)v.get(866)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(863)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */
      /* Termina nodo:863   */
      /* Termina nodo:837   */

      /* Empieza nodo:867 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(867)).setAttribute("nombre","capaEliminar" );
      ((Element)v.get(867)).setAttribute("alto","50" );
      ((Element)v.get(867)).setAttribute("ancho","100%" );
      ((Element)v.get(867)).setAttribute("colorf","" );
      ((Element)v.get(867)).setAttribute("borde","0" );
      ((Element)v.get(867)).setAttribute("imagenf","" );
      ((Element)v.get(867)).setAttribute("repeat","" );
      ((Element)v.get(867)).setAttribute("padding","" );
      ((Element)v.get(867)).setAttribute("visibilidad","visible" );
      ((Element)v.get(867)).setAttribute("contravsb","" );
      ((Element)v.get(867)).setAttribute("x","0" );
      ((Element)v.get(867)).setAttribute("y","1393" );
      ((Element)v.get(867)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("table"));
      ((Element)v.get(868)).setAttribute("width","100%" );
      ((Element)v.get(868)).setAttribute("border","0" );
      ((Element)v.get(868)).setAttribute("cellspacing","0" );
      ((Element)v.get(868)).setAttribute("cellpadding","0" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));

      /* Empieza nodo:869 / Elemento padre: 868   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(868)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("td"));
      ((Element)v.get(869)).appendChild((Element)v.get(870));

      /* Empieza nodo:871 / Elemento padre: 870   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(871)).setAttribute("src","b.gif" );
      ((Element)v.get(871)).setAttribute("width","12" );
      ((Element)v.get(871)).setAttribute("height","15" );
      ((Element)v.get(870)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:870   */

      /* Empieza nodo:872 / Elemento padre: 869   */
      v.add(doc.createElement("td"));
      ((Element)v.get(872)).setAttribute("width","750" );
      ((Element)v.get(869)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(873)).setAttribute("src","b.gif" );
      ((Element)v.get(873)).setAttribute("width","1" );
      ((Element)v.get(873)).setAttribute("height","1" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */

      /* Empieza nodo:874 / Elemento padre: 869   */
      v.add(doc.createElement("td"));
      ((Element)v.get(869)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(875)).setAttribute("width","12" );
      ((Element)v.get(875)).setAttribute("height","15" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */
      /* Termina nodo:869   */

      /* Empieza nodo:876 / Elemento padre: 868   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(868)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(878)).setAttribute("src","b.gif" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */
      /* Termina nodo:877   */

      /* Empieza nodo:879 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("table"));
      ((Element)v.get(881)).setAttribute("width","100%" );
      ((Element)v.get(881)).setAttribute("border","0" );
      ((Element)v.get(881)).setAttribute("align","center" );
      ((Element)v.get(881)).setAttribute("cellspacing","0" );
      ((Element)v.get(881)).setAttribute("cellpadding","0" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(881)).appendChild((Element)v.get(882));

      /* Empieza nodo:883 / Elemento padre: 882   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).setAttribute("class","botonera" );
      ((Element)v.get(883)).setAttribute("width","100%" );
      ((Element)v.get(883)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(882)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(884)).setAttribute("nombre","btnEliminarOferta" );
      ((Element)v.get(884)).setAttribute("ID","botonContenido" );
      ((Element)v.get(884)).setAttribute("tipo","html" );
      ((Element)v.get(884)).setAttribute("accion","accionEliminarOferta();" );
      ((Element)v.get(884)).setAttribute("estado","false" );
      ((Element)v.get(884)).setAttribute("cod","2244" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */

      /* Empieza nodo:885 / Elemento padre: 883   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(885)).setAttribute("src","b.gif" );
      ((Element)v.get(885)).setAttribute("width","573" );
      ((Element)v.get(885)).setAttribute("height","1" );
      ((Element)v.get(883)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */
      /* Termina nodo:883   */
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:880   */
      /* Termina nodo:879   */

      /* Empieza nodo:886 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(876)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(887)).setAttribute("src","b.gif" );
      ((Element)v.get(887)).setAttribute("width","12" );
      ((Element)v.get(887)).setAttribute("height","12" );
      ((Element)v.get(886)).appendChild((Element)v.get(887));
      /* Termina nodo:887   */
      /* Termina nodo:886   */
      /* Termina nodo:876   */

      /* Empieza nodo:888 / Elemento padre: 868   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(868)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(889)).setAttribute("width","12" );
      ((Element)v.get(889)).setAttribute("align","center" );
      ((Element)v.get(888)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(890)).setAttribute("src","b.gif" );
      ((Element)v.get(890)).setAttribute("width","12" );
      ((Element)v.get(890)).setAttribute("height","12" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */

      /* Empieza nodo:891 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(891)).setAttribute("width","750" );
      ((Element)v.get(888)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(892)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */
      /* Termina nodo:891   */

      /* Empieza nodo:893 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(893)).setAttribute("width","12" );
      ((Element)v.get(888)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(894)).setAttribute("src","b.gif" );
      ((Element)v.get(894)).setAttribute("width","12" );
      ((Element)v.get(894)).setAttribute("height","12" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:893   */
      /* Termina nodo:888   */
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:895 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(895)).setAttribute("nombre","SICC_TOOLBAR_CONFIG" );
      ((Element)v.get(895)).setAttribute("valor","[0154, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1]" );
      ((Element)v.get(6)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */
      /* Termina nodo:6   */

      /* Empieza nodo:896 / Elemento padre: 0   */
      v.add(doc.createElement("HISTORY"));
      ((Element)v.get(0)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("ON"));
      ((Element)v.get(897)).setAttribute("nombre","d3_back" );
      ((Element)v.get(897)).setAttribute("parametros","" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */
      /* Termina nodo:896   */


   }

}
