
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ofertas_modificar_cambio  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ofertas_modificar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r     \r    \r      function onLoadPag(){\r             configurarMenuSecundario(\"frmFormulario\");     \r             showError();  \r             ckVentaExclusivaOnChange();    \r             posicionaRadioButtons();     \r             if(get('frmFormulario.hidCKDespachoCompleto')!=\"\"){\r                  set('frmFormulario.ckDespachoCompleto', get('frmFormulario.hidCKDespachoCompleto'));\r             }\r             if(get('frmFormulario.hidCKDespachoAutomatico')!=\"\"){\r                  set('frmFormulario.ckDespachoAutomatico', get('frmFormulario.hidCKDespachoAutomatico'));\r             }    \r             if(get('frmFormulario.hidCKRecuperacionObligatoria')!=\"\"){\r                  set('frmFormulario.ckRecObligPedido', get('frmFormulario.hidCKRecuperacionObligatoria'));\r             }              \r             posicionaCombos();   \r             configuraPantalla();\r             if(get('frmFormulario.hDeshabilitaTodo') == 'S'){\r                  deshabilitaTodo();\r             }\r          \r             DrdEnsanchaConMargenDcho('listado1',12);\r             DrdEnsanchaConMargenDcho('listado2',12);     \r             DrdEnsanchaConMargenDcho('listado5',36);\r    \r             eval (ON_RSZ);\r             if (get('frmFormulario.casoDeUso')=='consultar'){\r                  btnProxy(4,0);\r                  btnProxy(2,1);\r             }else{\r                  btnProxy(4,1);\r                  btnProxy(2,0);\r                  focaliza('frmFormulario.cbArgumentoVenta','');                  \r             }\r             btnProxy(7,0);\r             btnProxy(8,0);\r             btnProxy(9,0);\r             ensanchaListaEditables();\r         }\r    \r         function ensanchaListaEditables(){\r             var nombresListas = get('frmFormulario.varNombresListasDinamicas');\r             if (nombresListas!=null && nombresListas != \"\"){\r                  arrayNombres = nombresListas.split(\"|\");\r                  for(i = 0; i < arrayNombres.length; ++i) {\r                      DrdEnsanchaConMargenDcho(arrayNombres[i],40);\r                  }         \r                  eval (ON_RSZ);\r             }\r         }\r    \r        function metodoListaEditable(){\r             var arrayNomListas = get('frmFormulario.hNombreListas').split(\"|\"); \r             for ( i = 0 ; i < arrayNomListas.length; i++) {             \r                  DrdEnsanchaConMargenDcho(arrayNomListas[i],12); \r                                                                   }     \r         }\r    \r         function showError(){\r             if( get('frmFormulario.casoDeUso')=='consultar' ){\r                  fMostrarMensajeError();\r                               }else{\r                  if (get('frmFormulario.errCodigo') != ''){\r                      fMostrarMensajeError();\r                      /*set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                      set(\"frmFormulario.accion\", \"vuelveError\");\r                      enviaSICC(\"frmFormulario\");*/\r                  }else if (get('frmFormulario.hValorError') == 'PRE0014'){\r                      GestionarMensaje('PRE0014'); \r                  } else if (get('frmFormulario.hValorError') == 'PRE0011'){\r                      GestionarMensaje('PRE0011'); \r                      deshabilitaTodo();\r                  }\r                           }\r         }\r         function fBorrar(){\r             accionEliminarOferta();\r         }\r    \r         function accionEliminarOferta(){\r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"EliminarOferta\");\r             enviaSICC(\"frmFormulario\");\r         }\r        \r         function accionBuscarProducto(){\r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"BuscarProducto\");\r             enviaSICC(\"frmFormulario\");\r         }\r    \r         function accionBuscarProductoAsoc(){\r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"BuscarProductoAsoc\");\r             enviaSICC(\"frmFormulario\");\r         }\r    \r         function accionEliminarProductos(){\r             if (listado2.numSelecc()>0){\r                  if(GestionarMensaje(\"5\")){\r                      set('frmFormulario.accion','eliminarProductos');\r                      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                      set('frmFormulario.elemSelecc',listado2.codSeleccionados());\r                      enviaSICC('frmFormulario');\r                  }\r             }\r         }\r    \r         function accionModificarGrupo(codigo){\r             set(\"frmFormulario.hidNroGrupo\", codigo);             \r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"ModificarGrupo\");\r             enviaSICC(\"frmFormulario\");\r         }\r    \r   function accionAniadirGrupo(){\r\r        if (get('frmFormulario.cbTipoGrupo2')=='2'){\r             if((get('frmFormulario.txtNumeroPaquetes')<get('frmFormulario.maxGrupo'))||\r                  (get('frmFormulario.maxGrupo')=='')){\r                    set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                    set(\"frmFormulario.accion\", \"AnadirGrupo\");\r                    enviaSICC(\"frmFormulario\");                  \r             } else {\r                    GestionarMensaje(\"715\");\r             }\r        } else {\r             if((get('frmFormulario.txtNumeroGrupos')<get('frmFormulario.maxGrupo'))||\r                  (get('frmFormulario.maxGrupo')=='')){\r                   if (get('frmFormulario.cbTipoGrupo2')=='4'){\r                       if((get('frmFormulario.txtNumeroGruposCondicionantes')<get('frmFormulario.maxGruposCondicionantes'))||\r                            (get('frmFormulario.maxGruposCondicionantes')=='')){\r                              set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                              set(\"frmFormulario.accion\", \"AnadirGrupo\");\r                              enviaSICC(\"frmFormulario\");\r                       } else {\r                        GestionarMensaje(\"713\");\r                       }\r                   } else if (get('frmFormulario.cbTipoGrupo2')=='3'){\r                       if((get('frmFormulario.txtNumeroGruposCondicionados')<get('frmFormulario.maxGruposCondicionados'))||\r                            (get('frmFormulario.maxGruposCondicionados')=='')){\r                              set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                              set(\"frmFormulario.accion\", \"AnadirGrupo\");\r                              enviaSICC(\"frmFormulario\");                            \r                       } else {\r                        GestionarMensaje(\"714\");\r                       }\r                   } else {         \r                      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                      set(\"frmFormulario.accion\", \"AnadirGrupo\");\r                      enviaSICC(\"frmFormulario\");\r                  }\r             }else{\r                  GestionarMensaje(\"712\");             \r             }\r        }\r    }\r    \r         function accionAniadirCondicion(){\r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"AnadirCondicion\");\r             enviaSICC(\"frmFormulario\");\r         }\r    \r         function accionModificarCondicion(codigo){\r             set(\"frmFormulario.hidNroCondicion\", codigo);             \r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"ModificarCondicion\");\r             enviaSICC(\"frmFormulario\");\r         }\r    \r         function accionEliminarCondicion(boton){\r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                  if (get('frmFormulario.nroPromociones') == 1){\r                      GestionarMensaje(\"185\");\r                      return;\r             }else {\r                  set(\"frmFormulario.accion\", \"EliminarCondicion\");\r                  set(\"frmFormulario.hOidCondicion\", eval(boton).codigo);\r                  enviaSICC(\"frmFormulario\");\r             }\r         }\r    \r         function accionEliminarGrupo(boton){\r             if (get('frmFormulario.hidNroGrupos') == 1){\r                  if (get('frmFormulario.hidECondicionada' ) == 'S' ){\r                      GestionarMensaje(\"183\");\r                      return;\r                  }else{\r                      GestionarMensaje(\"1110\");\r                      return;\r                  }           \r             }else{\r                 if (get('frmFormulario.hidNroPaquetes' ) == 1 ){\r                         GestionarMensaje(\"184\");\r                         return;\r                 }\r                 var ngrp;\r                 if (get('frmFormulario.hidNroPaquetes' ) > 1 ){                 \r                  ngrp = new Number(get('frmFormulario.txtNumeroPaquetes'));\r                  var res = ngrp-new Number('1');\r                  set('frmFormulario.txtNumeroPaquetes',res);   \r                 } else { \r                  ngrp = new Number(get('frmFormulario.txtNumeroGrupos'));\r                  var res = ngrp-new Number('1');\r                  set('frmFormulario.txtNumeroGrupos',res);\r                 }\r             \r                  set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                  set(\"frmFormulario.accion\", \"EliminarGrupo\");\r                  set(\"frmFormulario.hidNroGrupo\", eval(boton).codigo);\r                  enviaSICC(\"frmFormulario\");\r             }\r         }\r    \r         function accionAniadirVentaExclusiva(){ \r             if (sicc_validaciones_generales(\"ventaExclusiva\")){\r                  set('frmFormulario.hDesTipoCliente',get('frmFormulario.cbTipoCliente','T'));\r                  set('frmFormulario.hDesSubtipoCliente',get('frmFormulario.cbSubTipoCliente','T'));\r                  set('frmFormulario.hDesTipoClasificacion',get('frmFormulario.cbTipoClasificacionCliente','T'));\r                  set('frmFormulario.hDesClasificacion',get('frmFormulario.cbClasificacionCliente','T'));\r                  set('frmFormulario.hDesEstatusCliente',get('frmFormulario.cbEstatusCliente','T'));\r                  set('frmFormulario.txtEstatus2',get('frmFormulario.txtEstatus2Cliente'));\r    \r                  set(\"frmFormulario.conectorAction\", 'LPModificarOferta');      \r                  set('frmFormulario.accion','aniadirVentaExclusiva');\r                  enviaSICC('frmFormulario');\r             }         \r         }\r    \r         function accionEliminarVentaExclusiva(){\r             if (listado5.numSelecc()>0){\r                  if(GestionarMensaje(\"5\")){\r                      set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r                      set(\"frmFormulario.accion\", \"eliminarVentaExclusiva\");\r                      set('frmFormulario.elemSelecc',listado5.codSeleccionados());\r                      enviaSICC('frmFormulario');\r                  }\r             } \r         }\r    \r         function ckVentaExclusivaOnChange(){\r             if (listado5.codigos().length >0){\r                  set('frmFormulario.ckVentaExclusiva4','S');\r             }           \r             if ((get('frmFormulario.ckVentaExclusiva4')=='S')){   \r                                    document.all[\"btnAnadir5\"].style.visibility='visible'\r                  accion('frmFormulario.cbTipoCliente','.disabled=false');\r                  accion('frmFormulario.cbSubTipoCliente','.disabled=false');\r                  accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');\r                  accion('frmFormulario.cbClasificacionCliente','.disabled=false');\r                  accion('frmFormulario.cbEstatusCliente','.disabled=false');\r                  accion('frmFormulario.txtEstatus2Cliente','.disabled=false');\r                  document.all[\"Eliminar5Div\"].style.visibility='visible'\r             }else if ((get('frmFormulario.ckVentaExclusiva4')=='N')){             \r                  accion('frmFormulario.cbTipoCliente','.disabled=true');\r                  accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r                  accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r                  accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r                  accion('frmFormulario.cbEstatusCliente','.disabled=true');\r                  accion('frmFormulario.txtEstatus2Cliente','.disabled=true');                  \r                                    document.all[\"btnAnadir5\"].style.visibility='hidden'\r                  document.all[\"Eliminar5Div\"].style.visibility='hidden'             \r             }\r         }\r         \r         function deshabilitaTodo(){   \r             visibilidad('btnAnadir5','O');\r             document.all[\"BuscarDiv\"].style.visibility='hidden';\r             document.all[\"Eliminar5Div\"].style.visibility='hidden';\r             accion('frmFormulario.cbArgumentoVenta','.disabled=true');\r             accion('frmFormulario.txtNumeroOrden','.disabled=true');             \r             accion('frmFormulario.txtNumeroGrupos','.disabled=true');\r             accion('frmFormulario.txtNumeroPaquetes','.disabled=true');\r             accion('frmFormulario.cbIndicadorCuadre','.disabled=true');\r             accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');\r                  \r             accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');                \r             document.all.rbCondicionCondicionantes[0].disabled=true;\r             document.all.rbCondicionCondicionantes[1].disabled=true;\r             document.all.rbCondicionCondicionados[0].disabled=true; \r             document.all.rbCondicionCondicionados[1].disabled=true;  \r             \r             accion('frmFormulario.cbFormasPago','.disabled=true');\r             accion('frmFormulario.ckDespachoCompleto','.disabled=true');\r             accion('frmFormulario.ckDespachoAutomatico','.disabled=true');\r             accion('frmFormulario.ckRecObligPedido','.disabled=true');  \r             accion('frmFormulario.ckVentaExclusiva4','.disabled=true');\r             accion('frmFormulario.cbTipoCliente','.disabled=true');\r             accion('frmFormulario.cbSubTipoCliente','.disabled=true');\r             accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r             accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r             accion('frmFormulario.cbEstatusCliente','.disabled=true');\r             accion('frmFormulario.txtEstatus2Cliente','.disabled=true');         \r         }\r             \r         function tipoClienteOnChange(){\r             accion('frmFormulario.cbSubTipoCliente','.disabled=false');\r             recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', \r             'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoCliente')));\r                                   \r             set('frmFormulario.cbTipoClasificacionCliente','');\r             accion('frmFormulario.cbTipoClasificacionCliente','.disabled=true');\r    \r             set('frmFormulario.cbClasificacionCliente','');\r             accion('frmFormulario.cbClasificacionCliente','.disabled=true');\r         }\r                 \r         function subtipoClienteOnChange(){\r             accion('frmFormulario.cbTipoClasificacionCliente','.disabled=false');\r             recargaCombo('frmFormulario.cbTipoClasificacionCliente', 'MAEobtenerTipoClasificacion', \r             'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')));\r         }\r                 \r         function tipoClasificacionOnChange(){\r             accion('frmFormulario.cbClasificacionCliente','.disabled=false');\r             recargaCombo('frmFormulario.cbClasificacionCliente', 'MAEobtenerClasificacionesPorTipo', \r             'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoClasificacionCliente')));\r         }\r         \r         function posicionaCombos(){\r             array = new Array();\r             array[0] = get('frmFormulario.hFormaPago');\r             set('frmFormulario.cbFormasPago',array);\r             array = new Array();\r             array[0] = get('frmFormulario.hIndCuadre');\r             set('frmFormulario.cbIndicadorCuadre',array);\r             array = new Array();\r             array[0] = get('frmFormulario.hidOidArgVenta');\r             set('frmFormulario.cbArgumentoVenta',array);\r             if (!get('frmFormulario.hValorError') == 'PRE0011'){\r                  focaliza('frmFormulario.cbArgumentoVenta','');\r             }                  \r         }\r    \r         function posicionaRadioButtons(){\r                          set('frmFormulario.rbCondicionCondicionantes', get('frmFormulario.hidRDCondicionantes')); \r             set('frmFormulario.rbCondicionCondicionados', get('frmFormulario.hidRDCondicionados'));              \r         }\r                 \r         function configuraPantalla(){\r             accion('frmFormulario.txtNumeroGrupos','.disabled=true');\r             accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');\r             accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');\r             accion('frmFormulario.txtNumeroPaquetes','.disabled=true');\r    \r          \r             if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='N'){\r                  accion('frmFormulario.cbIndicadorCuadre','.disabled=true');  \r             }\r    \r             if (listado1.codigos().length >0){\r                  document.all[\"BuscarDiv\"].style.visibility='visible'\r             }else{\r                  document.all[\"BuscarDiv\"].style.visibility='hidden'\r             }\r             \r             if (get('frmFormulario.btnBPAsoc')=='true'){\r                  document.all[\"Buscar2Div\"].style.visibility='visible'\r                  document.all[\"Eliminar2Div\"].style.visibility='visible'\r             }else{\r                  document.all[\"Buscar2Div\"].style.visibility='hidden'\r                  document.all[\"Eliminar2Div\"].style.visibility='hidden'\r             }\r    \r                          if (get('frmFormulario.hidECondicionada')=='N'){\r                  /*accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=true');  \r                  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=true');*/\r                                    if (get('frmFormulario.hidEstrategiaVS')=='N'){\r                      document.all.rbCondicionCondicionantes[0].disabled=true;\r                      document.all.rbCondicionCondicionantes[1].disabled=true;\r                      document.all.rbCondicionCondicionados[0].disabled=true; \r                      document.all.rbCondicionCondicionados[1].disabled=true;\r                  }else{\r                      document.all.rbCondicionCondicionantes[0].disabled=false;\r                      document.all.rbCondicionCondicionantes[1].disabled=false;\r                      document.all.rbCondicionCondicionados[0].disabled=true; \r                      document.all.rbCondicionCondicionados[1].disabled=true;\r                  }             \r             }else{\r                  /*accion('frmFormulario.txtNumeroGruposCondicionantes','.disabled=false');  \r                  accion('frmFormulario.txtNumeroGruposCondicionados','.disabled=false');*/\r                  document.all.rbCondicionCondicionantes[0].disabled=false;\r                  document.all.rbCondicionCondicionantes[1].disabled=false;\r                  document.all.rbCondicionCondicionados[0].disabled=false; \r                  document.all.rbCondicionCondicionados[1].disabled=false;\r             }\r    \r\r             if (get('frmFormulario.hidHabiDesAutomatico')=='N'){\r                  accion('frmFormulario.ckDespachoAutomatico','.disabled=true');\r             }\r             if (get('frmFormulario.hidHabiDesCompleto')=='N'){\r                  accion('frmFormulario.ckDespachoCompleto','.disabled=true');\r             }\r             \r         }\r             \r         function fGuardar(){            \r             if (sicc_validaciones_generales(\"guardar\")){\r                  set('frmFormulario.hidOidArgumentoVenta', get('frmFormulario.cbArgumentoVenta'));\r                  set('frmFormulario.hidNroOrden', get('frmFormulario.txtNumeroOrden'));\r                  set('frmFormulario.hFormaPago', get('frmFormulario.cbFormasPago'));\r                  \r                  if (get('frmFormulario.hidHabilitaIndicadorCuadre')=='S'){\r                      if (sicc_validaciones_generales(\"cbIndicadorCuadre\")){\r                           set('frmFormulario.hidOidIndicadorCuadre',get('frmFormulario.cbIndicadorCuadre'));\r                      }else{\r                           return false;\r                      }\r                  }\r                  if( get('frmFormulario.hidECondicionada')=='S' ){                 \r                      if( sicc_validaciones_generales(\"condicionante,condicionado,condicionadatexto\") ){\r                           set('frmFormulario.hidRDCondicionantes',get('frmFormulario.rbCondicionCondicionantes'));\r                           set('frmFormulario.hidRDCondicionados',get('frmFormulario.rbCondicionCondicionados'));\r                           set('frmFormulario.hidGruposCnantes',get('frmFormulario.txtNumeroGruposCondicionantes'));\r                           set('frmFormulario.hidGruposCnados',get('frmFormulario.txtNumeroGruposCondicionados'));\r                      }else{\r                           return false;\r                      }\r                  }             \r                  if (get('frmFormulario.hidEstrategiaVS')=='S'){\r                      if( sicc_validaciones_generales(\"condicionante\") ){\r                           set('frmFormulario.hidRDCondicionantes', get('frmFormulario.rbCondicionCondicionantes'));                          \r                           set('frmFormulario.hidRDCondicionados', get('frmFormulario.rbCondicionCondicionados'));\r                      }else{\r                           return false;\r                      }\r                  }\r             }else{\r                  return false;\r             }\r    \r             if (get('frmFormulario.hidHabiDesCompleto')=='S'){\r                  set('frmFormulario.hidCKDespachoCompleto', get('frmFormulario.ckDespachoCompleto'));\r             }\r    \r             if (get('frmFormulario.hidHabiDesAutomatico')=='S'){\r                  set('frmFormulario.hidCKDespachoAutomatico', get('frmFormulario.ckDespachoAutomatico'));\r             }\r             \r             set('frmFormulario.hidCKRecuperacionObligatoria', get('frmFormulario.ckRecObligPedido'));\r    \r             if (get('frmFormulario.ckVentaExclusiva4')=='S'){                  if (listado5.codigos().length<1){\r                      GestionarMensaje('2524');\r                      return;\r                  }\r             }                     \r             set(\"frmFormulario.conectorAction\", \"LPModificarOferta\");\r             set(\"frmFormulario.accion\", \"Guardar\");\r             enviaSICC(\"frmFormulario\");\r         }\r                 \r         function recargaCombo(combo, idBusiness, dto, parametros) {\r             asignar([['COMBO', combo, 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',\r             formarCadena(idBusiness, dto, parametros)]]);\r         }\r         \r         function formarCadena(idBusiness , dto, parametros) {\r             var cadena = idBusiness + \"|\" + dto + \"|\"; \r             for(i=0;i<parametros.length;i++) {\r                  cadena += parametros[i][0] + \"=\" + parametros[i][1];\r                  if (i!= parametros.length-1) {\r                      cadena += \"&\";\r                  }\r             }\r             return cadena;\r         }\r                \r         function makeParameter(nombre, oid){\r             var array = new Array();\r             var i=0;\r             array[i] = new Array('oidPais','1');\r             i++;\r             array[i] = new Array('oidIdioma','1');\r             i++;\r             array[i] = new Array(nombre,oid)\r             return array;\r         }\r         \r         function fLimpiar(){\r             set(\"frmFormulario.accion\",\"ObtenerOfertaModificacion\");\r             enviaSICC(\"frmFormulario\");\r         }\r         \r         function fVolver(){\r             window.close();\r             set('frmFormulario.casoDeUso','consultar');\r         }\r\r         function tabGenerico(nombreComp, tipotab){        \r             var arr = arrayComponentes();\r             var tabular = false;\r             var nombreFormulario = getFormularioSICC();\r             var j = 0;\r             var k = arr.length;\r             if (tipotab != \"sh\") {\r                  j = j-1;                  \r                  k = k-1;\r             }\r\r             while(j<k){\r                  var t;\r                  if(tipotab == \"sh\"){\r                    k--;\r                    t = k;\r                  } else{\r                    j++;\r                    t = j;                    \r                  }\r                    \r                  var nombre = arr[t][0];\r                  var tipo = arr[t][1];\r                  if (tabular==false){\r                    if (nombreComp==nombre){\r                         tabular=true;\r                         if (tipotab == \"sh\"){\r                           if (k==0) k= arr.length;\r                         } else {\r                           if ((j+1)==arr.length)  j = -1;\r                         }\r                    }                  \r                  } else {\r                    try {\r                      var name = nombreFormulario+\".\"+nombre;\r                      if (tipo==\"BOTONXY\"){\r                          focalizaBotonHTML_XY(nombre);\r                      } else if (tipo==\"BOTON\") {\r                          focalizaBotonHTML(\"botonContenido\",nombre)\r                      } else {\r                          focaliza(name);\r                      }\r                      return;\r                    } catch (e) {\r                      if ((j+1)==arr.length)  j = -1;\r                    }\r                  }\r             }\r           }    \r           function arrayComponentes(){\r                var arr = new Array();\r                                                arr[arr.length]= new Array(\"cbArgumentoVenta\",\"\");\r                arr[arr.length]= new Array(\"txtNumeroOrden\",\"\");\r\r                arr[arr.length]= new Array(\"Buscar\",\"BOTONXY\");\r                arr[arr.length]= new Array(\"Buscar2\",\"BOTONXY\");\r                arr[arr.length]= new Array(\"Eliminar2\",\"BOTONXY\");                \r\r                arr[arr.length]= new Array(\"txtNGrupos\",\"\");\r                arr[arr.length]= new Array(\"txtNPaquetes\",\"\");\r                arr[arr.length]= new Array(\"cbIndicadorCuadre\",\"\");           \r\r                arr[arr.length]= new Array(\"txtNGrupCondicionantes\",\"\");\r                arr[arr.length]= new Array(\"rbCondicionCondicionantes\",\"\");\r                arr[arr.length]= new Array(\"txtNGrupCondicionados\",\"\");\r                arr[arr.length]= new Array(\"rbCondicionCondicionados\",\"\");\r\r                arr[arr.length]= new Array(\"ckDespachoCompleto\",\"\");\r                arr[arr.length]= new Array(\"ckDespachoAutomatico\",\"\");                     \r\r                arr[arr.length]= new Array(\"ckRecObligPedido\",\"\");\r                arr[arr.length]= new Array(\"cbFormasPago\",\"\");\r\r                                var npro = new Number(get('frmFormulario.hidNroPromo'));\r\r                if (npro>0){\r                  for (var i=0; i<npro;i++){                      \r                      arr[arr.length]= new Array(\"Modificar8\"+i,\"BOTONXY\");\r                      arr[arr.length]= new Array(\"btnEliminar8\"+i,\"BOTON\");\r                  }\r                  arr[arr.length]= new Array(\"btnAnadir\",\"BOTON\");\r                }\r                \r                                var ngr = new Number(get('frmFormulario.hidNroGrupos'));\r                var ngrcondos = new Number(get('frmFormulario.hidNroCondicionados'));\r                var ngrcondtes = new Number(get('frmFormulario.hidNroCondicionantes'));\r                var npaq = new Number(get('frmFormulario.hidNroPaquetes'));\r\r                var ntotgr = ngr + npaq;\r                if (ntotgr>0){\r                  for (var i=0; i<ntotgr;i++){                      \r                      arr[arr.length]= new Array(\"Modificar4\"+i,\"BOTONXY\");\r                      arr[arr.length]= new Array(\"btnEliminar\"+i,\"BOTON\");\r                  }\r                  arr[arr.length]= new Array(\"cbTipoGrupo2\",\"\");\r                  arr[arr.length]= new Array(\"btnAnadir2\",\"BOTON\");\r                }\r                \r                arr[arr.length]= new Array(\"ckVentaExclusiva4\",\"\");\r                arr[arr.length]= new Array(\"cbTipoCliente\",\"\");\r                arr[arr.length]= new Array(\"cbSubtipoCliente\",\"\");\r                arr[arr.length]= new Array(\"cbTipoClasificacionCliente\",\"\");\r                arr[arr.length]= new Array(\"cbClasificacionCliente\",\"\");\r                arr[arr.length]= new Array(\"cbEstatusCliente\",\"\");\r                arr[arr.length]= new Array(\"txtEstatus2Cliente\",\"\");\r\r                arr[arr.length]= new Array(\"btnAnadir5\",\"BOTON\");\r\r                arr[arr.length]= new Array(\"Eliminar5\",\"BOTONXY\");              \r                \r                return arr;\r           }    \r      \r    "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(1)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbArgumentoVenta" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","528" );
      ((Element)v.get(4)).setAttribute("group","guardar" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbFormasPago" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","541" );
      ((Element)v.get(5)).setAttribute("group","guardar" );
      ((Element)v.get(3)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtNumeroOrden" );
      ((Element)v.get(6)).setAttribute("required","false" );
      ((Element)v.get(6)).setAttribute("cod","486" );
      ((Element)v.get(6)).setAttribute("format","e" );
      ((Element)v.get(6)).setAttribute("min","0" );
      ((Element)v.get(6)).setAttribute("max","999999" );
      ((Element)v.get(6)).setAttribute("group","guardar" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","rbCondicionCondicionados" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","538" );
      ((Element)v.get(7)).setAttribute("group","condicionado" );
      ((Element)v.get(3)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","rbCondicionCondicionantes" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","536" );
      ((Element)v.get(8)).setAttribute("group","condicionante" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNumeroGruposCondicionantes" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","535" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999999" );
      ((Element)v.get(9)).setAttribute("group","condicionadatexto" );
      ((Element)v.get(3)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNumeroGruposCondicionados" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","537" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999999" );
      ((Element)v.get(10)).setAttribute("group","condicionadatexto" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 3   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","393" );
      ((Element)v.get(11)).setAttribute("group","ventaExclusiva" );
      ((Element)v.get(3)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */
      /* Termina nodo:3   */
      /* Termina nodo:1   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(12)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(13)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(14)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","LPModificarOferta" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidOferta" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","cadenaLineaPromocion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","cadenaProductosGrupo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","cadenaVentaExclusiva" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","cadenaProductoPrincipal" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","deshabilitar" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidOidCabeceraMF" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","btnBPAsoc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hDesTipoCliente" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hDesSubtipoCliente" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hDesTipoClasificacion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDesClasificacion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hDesEstatusCliente" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","txtEstatus2" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidOidArgVenta" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hIndCuadre" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hFormaPago" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidCKDespachoAutomatico" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidCKDespachoCompleto" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidCKRecuperacionObligatoria" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidGruposCnantes" );
      ((Element)v.get(39)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidGruposCnados" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidRDCondicionados" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidRDCondicionantes" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidOidIndicadorCuadre" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidNroOrden" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidOidArgumentoVenta" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidDespachoCompleto" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hidDespachoAutomatico" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hOidCondicion" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidOidGrupo" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hNombreListas" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hDeshabilitaTodo" );
      ((Element)v.get(51)).setAttribute("valor","N" );
      ((Element)v.get(15)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hValorError" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidHabilitaIndicadorCuadre" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidECondicionada" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidEstrategiaVS" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidHabiDesAutomatico" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hidHabiDesCompleto" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","LPRegreso" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidNroGrupo" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidNroCondicion" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","maxGrupo" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(62)).setAttribute("nombre","maxGruposCondicionantes" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","maxGruposCondicionados" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","nroPromociones" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","elemSelecc" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidNroGrupos" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidNroPaquetes" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hidNroCondicionados" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","varNombresListasDinamicas" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hidNroCondicionantes" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","matrizFacturada" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidNroPromo" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","12" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","750" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","1" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(86)).setAttribute("class","legend" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblDatosOferta" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","legend" );
      ((Element)v.get(87)).setAttribute("cod","00113" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","730" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","left" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("colspan","4" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:95 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(95));

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
      ((Element)v.get(99)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","10" );
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
      ((Element)v.get(103)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","122" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblEstrategia" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","478" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:95   */

      /* Empieza nodo:110 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblAccesoXX" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblSubaccesoXX" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lbldtEstrategia" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","1" );
      ((Element)v.get(124)).setAttribute("height","1" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:110   */

      /* Empieza nodo:125 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("colspan","4" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:128 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","730" );
      ((Element)v.get(130)).setAttribute("border","0" );
      ((Element)v.get(130)).setAttribute("align","left" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("cellpadding","0" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","516" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","528" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","25" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblNumeroOrden" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","486" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:131   */

      /* Empieza nodo:146 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lbldtCatalogo" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(154)).setAttribute("nombre","cbArgumentoVenta" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("size","1" );
      ((Element)v.get(154)).setAttribute("multiple","N" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("valorinicial","" );
      ((Element)v.get(154)).setAttribute("textoinicial","" );
      ((Element)v.get(154)).setAttribute("ontab","tabGenerico('cbArgumentoVenta');" );
      ((Element)v.get(154)).setAttribute("onshtab","tabGenerico('cbArgumentoVenta','sh');" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:156 / Elemento padre: 146   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(159)).setAttribute("nombre","txtNumeroOrden" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
      ((Element)v.get(159)).setAttribute("max","6" );
      ((Element)v.get(159)).setAttribute("tipo","" );
      ((Element)v.get(159)).setAttribute("onchange","" );
      ((Element)v.get(159)).setAttribute("req","N" );
      ((Element)v.get(159)).setAttribute("size","7" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(159)).setAttribute("ontab","tabGenerico('txtNumeroOrden');" );
      ((Element)v.get(159)).setAttribute("onshtab","tabGenerico('txtNumeroOrden','sh');" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","1" );
      ((Element)v.get(161)).setAttribute("height","1" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:146   */

      /* Empieza nodo:162 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:88   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:165 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:81   */

      /* Empieza nodo:167 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(169)).setAttribute("height","12" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","756" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","1" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:167   */
      /* Termina nodo:73   */

      /* Empieza nodo:174 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(174)).setAttribute("nombre","listado1" );
      ((Element)v.get(174)).setAttribute("ancho","733" );
      ((Element)v.get(174)).setAttribute("alto","108" );
      ((Element)v.get(174)).setAttribute("x","12" );
      ((Element)v.get(174)).setAttribute("y","132" );
      ((Element)v.get(174)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(174)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(175)).setAttribute("precarga","S" );
      ((Element)v.get(175)).setAttribute("conROver","S" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(176)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(176)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(176)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(176)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 175   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(177)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(177)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(177)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(177)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(178)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(178)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:175   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(180)).setAttribute("borde","1" );
      ((Element)v.get(180)).setAttribute("horizDatos","1" );
      ((Element)v.get(180)).setAttribute("horizCabecera","1" );
      ((Element)v.get(180)).setAttribute("vertical","1" );
      ((Element)v.get(180)).setAttribute("horizTitulo","1" );
      ((Element)v.get(180)).setAttribute("horizBase","1" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(181)).setAttribute("borde","#999999" );
      ((Element)v.get(181)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(181)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(181)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(181)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(181)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(181)).setAttribute("horizBase","#999999" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 174   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(182)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(182)).setAttribute("alto","22" );
      ((Element)v.get(182)).setAttribute("imgFondo","" );
      ((Element)v.get(182)).setAttribute("cod","579" );
      ((Element)v.get(182)).setAttribute("ID","datosTitle" );
      ((Element)v.get(174)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(183)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(183)).setAttribute("alto","22" );
      ((Element)v.get(183)).setAttribute("imgFondo","" );
      ((Element)v.get(174)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 174   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(184)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(184)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(184)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(184)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(184)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(184)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(174)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","100" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","100" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","120" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","100" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","100" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","100" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(193)).setAttribute("ancho","100" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:184   */

      /* Empieza nodo:194 / Elemento padre: 174   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(194)).setAttribute("alto","20" );
      ((Element)v.get(194)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(194)).setAttribute("imgFondo","" );
      ((Element)v.get(194)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(174)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Elemento padre:195 / Elemento actual: 196   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(195)).appendChild((Text)v.get(196));

      /* Termina nodo Texto:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("cod","9" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Elemento padre:197 / Elemento actual: 198   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(197)).appendChild((Text)v.get(198));

      /* Termina nodo Texto:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("cod","608" );
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","581" );
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Elemento padre:201 / Elemento actual: 202   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(201)).appendChild((Text)v.get(202));

      /* Termina nodo Texto:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(203)).setAttribute("cod","529" );
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Elemento padre:203 / Elemento actual: 204   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(203)).appendChild((Text)v.get(204));

      /* Termina nodo Texto:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("colFondo","" );
      ((Element)v.get(205)).setAttribute("ID","EstCab" );
      ((Element)v.get(205)).setAttribute("cod","530" );
      ((Element)v.get(194)).appendChild((Element)v.get(205));

      /* Elemento padre:205 / Elemento actual: 206   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(205)).appendChild((Text)v.get(206));

      /* Termina nodo Texto:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("colFondo","" );
      ((Element)v.get(207)).setAttribute("ID","EstCab" );
      ((Element)v.get(207)).setAttribute("cod","481" );
      ((Element)v.get(194)).appendChild((Element)v.get(207));

      /* Elemento padre:207 / Elemento actual: 208   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(207)).appendChild((Text)v.get(208));

      /* Termina nodo Texto:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("colFondo","" );
      ((Element)v.get(209)).setAttribute("ID","EstCab" );
      ((Element)v.get(209)).setAttribute("cod","482" );
      ((Element)v.get(194)).appendChild((Element)v.get(209));

      /* Elemento padre:209 / Elemento actual: 210   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(209)).appendChild((Text)v.get(210));

      /* Termina nodo Texto:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 194   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("colFondo","" );
      ((Element)v.get(211)).setAttribute("ID","EstCab" );
      ((Element)v.get(211)).setAttribute("cod","483" );
      ((Element)v.get(194)).appendChild((Element)v.get(211));

      /* Elemento padre:211 / Elemento actual: 212   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(211)).appendChild((Text)v.get(212));

      /* Termina nodo Texto:212   */
      /* Termina nodo:211   */
      /* Termina nodo:194   */

      /* Empieza nodo:213 / Elemento padre: 174   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(213)).setAttribute("alto","22" );
      ((Element)v.get(213)).setAttribute("accion","" );
      ((Element)v.get(213)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(213)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(213)).setAttribute("maxSel","-1" );
      ((Element)v.get(213)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(213)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(213)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(213)).setAttribute("onLoad","" );
      ((Element)v.get(213)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(174)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat2" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat2" );
      ((Element)v.get(213)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat" );
      ((Element)v.get(213)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat2" );
      ((Element)v.get(213)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat" );
      ((Element)v.get(213)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat2" );
      ((Element)v.get(213)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat" );
      ((Element)v.get(213)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:213   */

      /* Empieza nodo:223 / Elemento padre: 174   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(174)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 174   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(224)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(224)).setAttribute("ancho","733" );
      ((Element)v.get(224)).setAttribute("sep","$" );
      ((Element)v.get(224)).setAttribute("x","12" );
      ((Element)v.get(224)).setAttribute("class","botonera" );
      ((Element)v.get(224)).setAttribute("y","217" );
      ((Element)v.get(224)).setAttribute("control","|" );
      ((Element)v.get(224)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(224)).setAttribute("rowset","" );
      ((Element)v.get(224)).setAttribute("cargainicial","N" );
      ((Element)v.get(174)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:174   */

      /* Empieza nodo:225 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","separa1" );
      ((Element)v.get(225)).setAttribute("x","59" );
      ((Element)v.get(225)).setAttribute("y","217" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("img","separa_base" );
      ((Element)v.get(225)).setAttribute("tipo","0" );
      ((Element)v.get(225)).setAttribute("estado","false" );
      ((Element)v.get(225)).setAttribute("alt","" );
      ((Element)v.get(225)).setAttribute("codigo","" );
      ((Element)v.get(225)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(226)).setAttribute("nombre","Buscar" );
      ((Element)v.get(226)).setAttribute("x","13" );
      ((Element)v.get(226)).setAttribute("y","218" );
      ((Element)v.get(226)).setAttribute("ID","botonContenido" );
      ((Element)v.get(226)).setAttribute("tipo","html" );
      ((Element)v.get(226)).setAttribute("estado","false" );
      ((Element)v.get(226)).setAttribute("cod","1" );
      ((Element)v.get(226)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(226)).setAttribute("ontab","tabGenerico('Buscar');" );
      ((Element)v.get(226)).setAttribute("onshtab","tabGenerico('Buscar','sh');" );
      ((Element)v.get(15)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(227)).setAttribute("nombre","Modificar" );
      ((Element)v.get(227)).setAttribute("x","65" );
      ((Element)v.get(227)).setAttribute("y","218" );
      ((Element)v.get(227)).setAttribute("ID","botonContenido" );
      ((Element)v.get(227)).setAttribute("tipo","html" );
      ((Element)v.get(227)).setAttribute("estado","false" );
      ((Element)v.get(227)).setAttribute("cod","2" );
      ((Element)v.get(227)).setAttribute("accion","" );
      ((Element)v.get(227)).setAttribute("ontab","tabGenerico('Modificar');" );
      ((Element)v.get(227)).setAttribute("onshtab","tabGenerico('Modificar','sh');" );
      ((Element)v.get(15)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(228)).setAttribute("nombre","listado2" );
      ((Element)v.get(228)).setAttribute("ancho","733" );
      ((Element)v.get(228)).setAttribute("alto","317" );
      ((Element)v.get(228)).setAttribute("x","12" );
      ((Element)v.get(228)).setAttribute("y","264" );
      ((Element)v.get(228)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(228)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(229)).setAttribute("precarga","S" );
      ((Element)v.get(229)).setAttribute("conROver","S" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(230)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(230)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(230)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(230)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 229   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(231)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(231)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(231)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(231)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(232)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(232)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(234)).setAttribute("borde","1" );
      ((Element)v.get(234)).setAttribute("horizDatos","1" );
      ((Element)v.get(234)).setAttribute("horizCabecera","1" );
      ((Element)v.get(234)).setAttribute("vertical","1" );
      ((Element)v.get(234)).setAttribute("horizTitulo","1" );
      ((Element)v.get(234)).setAttribute("horizBase","1" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(235)).setAttribute("borde","#999999" );
      ((Element)v.get(235)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(235)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(235)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(235)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(235)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(235)).setAttribute("horizBase","#999999" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:233   */

      /* Empieza nodo:236 / Elemento padre: 228   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(236)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(236)).setAttribute("alto","22" );
      ((Element)v.get(236)).setAttribute("imgFondo","" );
      ((Element)v.get(236)).setAttribute("cod","532" );
      ((Element)v.get(236)).setAttribute("ID","datosTitle" );
      ((Element)v.get(228)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 228   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(237)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(237)).setAttribute("alto","22" );
      ((Element)v.get(237)).setAttribute("imgFondo","" );
      ((Element)v.get(228)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 228   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(238)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(238)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(238)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(238)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(238)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(238)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(228)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","100" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","100" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","100" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","100" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","120" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","100" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(245)).setAttribute("ancho","100" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","100" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 238   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","100" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(238)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:238   */

      /* Empieza nodo:248 / Elemento padre: 228   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(248)).setAttribute("alto","20" );
      ((Element)v.get(248)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(248)).setAttribute("imgFondo","" );
      ((Element)v.get(248)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(228)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("colFondo","" );
      ((Element)v.get(249)).setAttribute("ID","EstCab" );
      ((Element)v.get(249)).setAttribute("cod","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","9" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","608" );
      ((Element)v.get(248)).appendChild((Element)v.get(253));

      /* Elemento padre:253 / Elemento actual: 254   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(253)).appendChild((Text)v.get(254));

      /* Termina nodo Texto:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","581" );
      ((Element)v.get(248)).appendChild((Element)v.get(255));

      /* Elemento padre:255 / Elemento actual: 256   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(255)).appendChild((Text)v.get(256));

      /* Termina nodo Texto:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","529" );
      ((Element)v.get(248)).appendChild((Element)v.get(257));

      /* Elemento padre:257 / Elemento actual: 258   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(257)).appendChild((Text)v.get(258));

      /* Termina nodo Texto:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","530" );
      ((Element)v.get(248)).appendChild((Element)v.get(259));

      /* Elemento padre:259 / Elemento actual: 260   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(259)).appendChild((Text)v.get(260));

      /* Termina nodo Texto:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","481" );
      ((Element)v.get(248)).appendChild((Element)v.get(261));

      /* Elemento padre:261 / Elemento actual: 262   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(261)).appendChild((Text)v.get(262));

      /* Termina nodo Texto:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","482" );
      ((Element)v.get(248)).appendChild((Element)v.get(263));

      /* Elemento padre:263 / Elemento actual: 264   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(263)).appendChild((Text)v.get(264));

      /* Termina nodo Texto:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","483" );
      ((Element)v.get(248)).appendChild((Element)v.get(265));

      /* Elemento padre:265 / Elemento actual: 266   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(265)).appendChild((Text)v.get(266));

      /* Termina nodo Texto:266   */
      /* Termina nodo:265   */
      /* Termina nodo:248   */

      /* Empieza nodo:267 / Elemento padre: 228   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(267)).setAttribute("alto","22" );
      ((Element)v.get(267)).setAttribute("accion","" );
      ((Element)v.get(267)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(267)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(267)).setAttribute("maxSel","-1" );
      ((Element)v.get(267)).setAttribute("msgErrMaxSel","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(267)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(267)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(267)).setAttribute("onLoad","" );
      ((Element)v.get(267)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(228)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:267   */

      /* Empieza nodo:277 / Elemento padre: 228   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(228)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 228   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(278)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(278)).setAttribute("ancho","733" );
      ((Element)v.get(278)).setAttribute("sep","$" );
      ((Element)v.get(278)).setAttribute("x","12" );
      ((Element)v.get(278)).setAttribute("class","botonera" );
      ((Element)v.get(278)).setAttribute("y","558" );
      ((Element)v.get(278)).setAttribute("control","|" );
      ((Element)v.get(278)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(278)).setAttribute("rowset","" );
      ((Element)v.get(278)).setAttribute("cargainicial","N" );
      ((Element)v.get(228)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:228   */

      /* Empieza nodo:279 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(279)).setAttribute("nombre","separa2" );
      ((Element)v.get(279)).setAttribute("x","59" );
      ((Element)v.get(279)).setAttribute("y","558" );
      ((Element)v.get(279)).setAttribute("ID","botonContenido" );
      ((Element)v.get(279)).setAttribute("img","separa_base" );
      ((Element)v.get(279)).setAttribute("tipo","0" );
      ((Element)v.get(279)).setAttribute("estado","false" );
      ((Element)v.get(279)).setAttribute("alt","" );
      ((Element)v.get(279)).setAttribute("codigo","" );
      ((Element)v.get(279)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(280)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(280)).setAttribute("x","13" );
      ((Element)v.get(280)).setAttribute("y","559" );
      ((Element)v.get(280)).setAttribute("ID","botonContenido" );
      ((Element)v.get(280)).setAttribute("tipo","html" );
      ((Element)v.get(280)).setAttribute("estado","false" );
      ((Element)v.get(280)).setAttribute("cod","1" );
      ((Element)v.get(280)).setAttribute("accion","accionBuscarProductoAsoc();" );
      ((Element)v.get(280)).setAttribute("ontab","tabGenerico('Buscar2');" );
      ((Element)v.get(280)).setAttribute("onshtab","tabGenerico('Buscar2','sh');" );
      ((Element)v.get(15)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(281)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(281)).setAttribute("x","65" );
      ((Element)v.get(281)).setAttribute("y","559" );
      ((Element)v.get(281)).setAttribute("ID","botonContenido" );
      ((Element)v.get(281)).setAttribute("tipo","html" );
      ((Element)v.get(281)).setAttribute("estado","false" );
      ((Element)v.get(281)).setAttribute("cod","1254" );
      ((Element)v.get(281)).setAttribute("accion","accionEliminarProductos();" );
      ((Element)v.get(281)).setAttribute("ontab","tabGenerico('Eliminar2');" );
      ((Element)v.get(281)).setAttribute("onshtab","tabGenerico('Eliminar2','sh');" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(282)).setAttribute("nombre","Modificar2" );
      ((Element)v.get(282)).setAttribute("x","120" );
      ((Element)v.get(282)).setAttribute("y","559" );
      ((Element)v.get(282)).setAttribute("ID","botonContenido" );
      ((Element)v.get(282)).setAttribute("tipo","html" );
      ((Element)v.get(282)).setAttribute("estado","false" );
      ((Element)v.get(282)).setAttribute("cod","2" );
      ((Element)v.get(282)).setAttribute("accion","" );
      ((Element)v.get(282)).setAttribute("ontab","tabGenerico('Modificar2');" );
      ((Element)v.get(282)).setAttribute("onshtab","tabGenerico('Modificar2','sh');" );
      ((Element)v.get(15)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(283)).setAttribute("nombre","capaDatosGenerales" );
      ((Element)v.get(283)).setAttribute("alto","200" );
      ((Element)v.get(283)).setAttribute("ancho","100%" );
      ((Element)v.get(283)).setAttribute("colorf","" );
      ((Element)v.get(283)).setAttribute("borde","0" );
      ((Element)v.get(283)).setAttribute("imagenf","" );
      ((Element)v.get(283)).setAttribute("repeat","" );
      ((Element)v.get(283)).setAttribute("padding","" );
      ((Element)v.get(283)).setAttribute("visibilidad","visible" );
      ((Element)v.get(283)).setAttribute("contravsb","" );
      ((Element)v.get(283)).setAttribute("x","0" );
      ((Element)v.get(283)).setAttribute("y","593" );
      ((Element)v.get(283)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("table"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(284)).setAttribute("border","0" );
      ((Element)v.get(284)).setAttribute("cellspacing","0" );
      ((Element)v.get(284)).setAttribute("cellpadding","0" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(287)).setAttribute("height","12" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("width","750" );
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("width","12" );
      ((Element)v.get(285)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","12" );
      ((Element)v.get(291)).setAttribute("height","1" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:285   */

      /* Empieza nodo:292 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(297)).setAttribute("class","legend" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(298)).setAttribute("alto","13" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("id","legend" );
      ((Element)v.get(298)).setAttribute("cod","0011" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("table"));
      ((Element)v.get(299)).setAttribute("width","100%" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("align","center" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("table"));
      ((Element)v.get(302)).setAttribute("width","730" );
      ((Element)v.get(302)).setAttribute("border","0" );
      ((Element)v.get(302)).setAttribute("align","left" );
      ((Element)v.get(302)).setAttribute("cellspacing","0" );
      ((Element)v.get(302)).setAttribute("cellpadding","0" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("colspan","4" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:306 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lblNumeroGrupos" );
      ((Element)v.get(310)).setAttribute("alto","13" );
      ((Element)v.get(310)).setAttribute("filas","1" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(310)).setAttribute("id","datosTitle" );
      ((Element)v.get(310)).setAttribute("cod","533" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblNumeroPaquetes" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","534" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(318)).setAttribute("nombre","lblIndicadorCuadre" );
      ((Element)v.get(318)).setAttribute("alto","13" );
      ((Element)v.get(318)).setAttribute("filas","1" );
      ((Element)v.get(318)).setAttribute("valor","" );
      ((Element)v.get(318)).setAttribute("id","datosTitle" );
      ((Element)v.get(318)).setAttribute("cod","461" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(306)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:306   */

      /* Empieza nodo:321 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(324)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(325)).setAttribute("nombre","txtNumeroGrupos" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("max","2" );
      ((Element)v.get(325)).setAttribute("tipo","" );
      ((Element)v.get(325)).setAttribute("onchange","" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("size","2" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("validacion","" );
      ((Element)v.get(325)).setAttribute("ontab","tabGenerico('txtNumeroGrupos');" );
      ((Element)v.get(325)).setAttribute("onshtab","tabGenerico('txtNumeroGrupos','sh');" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","25" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(329)).setAttribute("nombre","txtNumeroPaquetes" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("max","2" );
      ((Element)v.get(329)).setAttribute("tipo","" );
      ((Element)v.get(329)).setAttribute("onchange","" );
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("size","2" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("validacion","" );
      ((Element)v.get(329)).setAttribute("ontab","tabGenerico('txtNumeroPaquetes');" );
      ((Element)v.get(329)).setAttribute("onshtab","tabGenerico('txtNumeroPaquetes','sh');" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(333)).setAttribute("nombre","cbIndicadorCuadre" );
      ((Element)v.get(333)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).setAttribute("size","1" );
      ((Element)v.get(333)).setAttribute("multiple","N" );
      ((Element)v.get(333)).setAttribute("req","N" );
      ((Element)v.get(333)).setAttribute("valorinicial","" );
      ((Element)v.get(333)).setAttribute("textoinicial","" );
      ((Element)v.get(333)).setAttribute("ontab","tabGenerico('cbIndicadorCuadre');" );
      ((Element)v.get(333)).setAttribute("onshtab","tabGenerico('cbIndicadorCuadre','sh');" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:335 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:321   */

      /* Empieza nodo:337 / Elemento padre: 302   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(302)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("colspan","4" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:340 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("table"));
      ((Element)v.get(342)).setAttribute("width","730" );
      ((Element)v.get(342)).setAttribute("border","0" );
      ((Element)v.get(342)).setAttribute("align","left" );
      ((Element)v.get(342)).setAttribute("cellspacing","0" );
      ((Element)v.get(342)).setAttribute("cellpadding","0" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("colspan","4" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:346 / Elemento padre: 342   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(342)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lblNumeroGruposCondicionantes" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("id","datosTitle" );
      ((Element)v.get(350)).setAttribute("cod","535" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","25" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(354)).setAttribute("nombre","lblCondicionCondicionantes" );
      ((Element)v.get(354)).setAttribute("alto","13" );
      ((Element)v.get(354)).setAttribute("filas","1" );
      ((Element)v.get(354)).setAttribute("valor","" );
      ((Element)v.get(354)).setAttribute("id","datosTitle" );
      ((Element)v.get(354)).setAttribute("cod","536" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","25" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(358)).setAttribute("nombre","lblNumeroGruposCondicionados" );
      ((Element)v.get(358)).setAttribute("alto","13" );
      ((Element)v.get(358)).setAttribute("filas","1" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("id","datosTitle" );
      ((Element)v.get(358)).setAttribute("cod","537" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","25" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(362)).setAttribute("nombre","lblCondicionCondicionados" );
      ((Element)v.get(362)).setAttribute("alto","13" );
      ((Element)v.get(362)).setAttribute("filas","1" );
      ((Element)v.get(362)).setAttribute("valor","" );
      ((Element)v.get(362)).setAttribute("id","datosTitle" );
      ((Element)v.get(362)).setAttribute("cod","538" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(366)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosTitle" );
      ((Element)v.get(366)).setAttribute("cod","539" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(346)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:346   */

      /* Empieza nodo:369 / Elemento padre: 342   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(342)).appendChild((Element)v.get(369));

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
      ((Element)v.get(372)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(369)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(373)).setAttribute("nombre","txtNumeroGruposCondicionantes" );
      ((Element)v.get(373)).setAttribute("id","datosCampos" );
      ((Element)v.get(373)).setAttribute("max","2" );
      ((Element)v.get(373)).setAttribute("tipo","" );
      ((Element)v.get(373)).setAttribute("onchange","" );
      ((Element)v.get(373)).setAttribute("req","N" );
      ((Element)v.get(373)).setAttribute("size","2" );
      ((Element)v.get(373)).setAttribute("valor","" );
      ((Element)v.get(373)).setAttribute("validacion","" );
      ((Element)v.get(373)).setAttribute("ontab","tabGenerico('txtNumeroGruposCondicionantes');" );
      ((Element)v.get(373)).setAttribute("onshtab","tabGenerico('txtNumeroGruposCondicionantes','sh');" );
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
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(369)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("table"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("class","datosCampos" );
      ((Element)v.get(379)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(380)).setAttribute("nombre","rbCondicionCondicionantes" );
      ((Element)v.get(380)).setAttribute("tipo","H" );
      ((Element)v.get(380)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).setAttribute("req","N" );
      ((Element)v.get(380)).setAttribute("ontab","tabGenerico('rbCondicionCondicionantes');" );
      ((Element)v.get(380)).setAttribute("onshtab","tabGenerico('rbCondicionCondicionantes','sh');" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(381)).setAttribute("valor","S" );
      ((Element)v.get(381)).setAttribute("check","N" );
      ((Element)v.get(381)).setAttribute("onfocus","" );
      ((Element)v.get(381)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Elemento padre:381 / Elemento actual: 382   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(381)).appendChild((Text)v.get(382));

      /* Termina nodo Texto:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 380   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(383)).setAttribute("valor","N" );
      ((Element)v.get(383)).setAttribute("onfocus","" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).appendChild((Element)v.get(383));

      /* Elemento padre:383 / Elemento actual: 384   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(383)).appendChild((Text)v.get(384));

      /* Termina nodo Texto:384   */
      /* Termina nodo:383   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:385 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","25" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(369)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(388)).setAttribute("nombre","txtNumeroGruposCondicionados" );
      ((Element)v.get(388)).setAttribute("id","datosCampos" );
      ((Element)v.get(388)).setAttribute("max","2" );
      ((Element)v.get(388)).setAttribute("tipo","" );
      ((Element)v.get(388)).setAttribute("onchange","" );
      ((Element)v.get(388)).setAttribute("req","N" );
      ((Element)v.get(388)).setAttribute("size","2" );
      ((Element)v.get(388)).setAttribute("valor","" );
      ((Element)v.get(388)).setAttribute("validacion","" );
      ((Element)v.get(388)).setAttribute("ontab","tabGenerico('txtNumeroGruposCondicionados');" );
      ((Element)v.get(388)).setAttribute("onshtab","tabGenerico('txtNumeroGruposCondicionados','sh');" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","25" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(369)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("class","datosCampos" );
      ((Element)v.get(394)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(395)).setAttribute("nombre","rbCondicionCondicionados" );
      ((Element)v.get(395)).setAttribute("tipo","H" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("req","N" );
      ((Element)v.get(395)).setAttribute("ontab","tabGenerico('rbCondicionCondicionados');" );
      ((Element)v.get(395)).setAttribute("onshtab","tabGenerico('rbCondicionCondicionados','sh');" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(396)).setAttribute("valor","S" );
      ((Element)v.get(396)).setAttribute("check","N" );
      ((Element)v.get(396)).setAttribute("onfocus","" );
      ((Element)v.get(396)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 395   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(398)).setAttribute("valor","N" );
      ((Element)v.get(398)).setAttribute("onfocus","" );
      ((Element)v.get(398)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).appendChild((Element)v.get(398));

      /* Elemento padre:398 / Elemento actual: 399   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(398)).appendChild((Text)v.get(399));

      /* Termina nodo Texto:399   */
      /* Termina nodo:398   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:400 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(403)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(403)).setAttribute("texto","" );
      ((Element)v.get(403)).setAttribute("check","N" );
      ((Element)v.get(403)).setAttribute("validacion","" );
      ((Element)v.get(403)).setAttribute("req","N" );
      ((Element)v.get(403)).setAttribute("id","datosCampos" );
      ((Element)v.get(403)).setAttribute("ontab","tabGenerico('ckDespachoCompleto');" );
      ((Element)v.get(403)).setAttribute("onshtab","tabGenerico('ckDespachoCompleto','sh');" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(369)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","1" );
      ((Element)v.get(405)).setAttribute("height","1" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:369   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:406 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("table"));
      ((Element)v.get(408)).setAttribute("width","730" );
      ((Element)v.get(408)).setAttribute("border","0" );
      ((Element)v.get(408)).setAttribute("align","left" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(408)).setAttribute("cellspacing","0" );
      ((Element)v.get(408)).setAttribute("cellpadding","0" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(410)).setAttribute("colspan","4" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("filas","1" );
      ((Element)v.get(416)).setAttribute("valor","" );
      ((Element)v.get(416)).setAttribute("id","datosTitle" );
      ((Element)v.get(416)).setAttribute("cod","540" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","25" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(420)).setAttribute("nombre","lblRecObligPedido" );
      ((Element)v.get(420)).setAttribute("alto","13" );
      ((Element)v.get(420)).setAttribute("filas","1" );
      ((Element)v.get(420)).setAttribute("valor","" );
      ((Element)v.get(420)).setAttribute("id","datosTitle" );
      ((Element)v.get(420)).setAttribute("cod","601" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","25" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("colspan","6" );
      ((Element)v.get(412)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(424)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(424)).setAttribute("alto","13" );
      ((Element)v.get(424)).setAttribute("filas","1" );
      ((Element)v.get(424)).setAttribute("valor","" );
      ((Element)v.get(424)).setAttribute("id","datosTitle" );
      ((Element)v.get(424)).setAttribute("cod","541" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(412)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:412   */

      /* Empieza nodo:427 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(431)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(431)).setAttribute("texto","" );
      ((Element)v.get(431)).setAttribute("check","N" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(431)).setAttribute("validacion","" );
      ((Element)v.get(431)).setAttribute("req","N" );
      ((Element)v.get(431)).setAttribute("id","datosCampos" );
      ((Element)v.get(431)).setAttribute("ontab","tabGenerico('ckDespachoAutomatico');" );
      ((Element)v.get(431)).setAttribute("onshtab","tabGenerico('ckDespachoAutomatico','sh');" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","25" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(435)).setAttribute("nombre","ckRecObligPedido" );
      ((Element)v.get(435)).setAttribute("texto","" );
      ((Element)v.get(435)).setAttribute("check","N" );
      ((Element)v.get(435)).setAttribute("validacion","" );
      ((Element)v.get(435)).setAttribute("req","N" );
      ((Element)v.get(435)).setAttribute("id","datosCampos" );
      ((Element)v.get(435)).setAttribute("ontab","tabGenerico('ckRecObligPedido');" );
      ((Element)v.get(435)).setAttribute("onshtab","tabGenerico('ckRecObligPedido','sh');" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","25" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(427)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(439)).setAttribute("nombre","cbFormasPago" );
      ((Element)v.get(439)).setAttribute("id","datosCampos" );
      ((Element)v.get(439)).setAttribute("size","1" );
      ((Element)v.get(439)).setAttribute("multiple","N" );
      ((Element)v.get(439)).setAttribute("req","N" );
      ((Element)v.get(439)).setAttribute("valorinicial","" );
      ((Element)v.get(439)).setAttribute("textoinicial","" );
      ((Element)v.get(439)).setAttribute("ontab","tabGenerico('cbFormasPago');" );
      ((Element)v.get(439)).setAttribute("onshtab","tabGenerico('cbFormasPago','sh');" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(427)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","1" );
      ((Element)v.get(442)).setAttribute("height","1" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:427   */

      /* Empieza nodo:443 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("colspan","4" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","8" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:299   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:446 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:292   */

      /* Empieza nodo:448 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).setAttribute("width","12" );
      ((Element)v.get(449)).setAttribute("align","center" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","12" );
      ((Element)v.get(450)).setAttribute("height","12" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("width","756" );
      ((Element)v.get(448)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 448   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("width","12" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(448)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","12" );
      ((Element)v.get(454)).setAttribute("height","1" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:448   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:455 / Elemento padre: 15   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(455)).setAttribute("nombre","rejlistado3" );
      ((Element)v.get(15)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 15   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(456)).setAttribute("nombre","rejlistado4" );
      ((Element)v.get(15)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(457)).setAttribute("nombre","capaVentaExclusiva" );
      ((Element)v.get(457)).setAttribute("x","0" );
      ((Element)v.get(457)).setAttribute("y","1711" );
      ((Element)v.get(15)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("table"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(458)).setAttribute("border","0" );
      ((Element)v.get(458)).setAttribute("cellspacing","0" );
      ((Element)v.get(458)).setAttribute("cellpadding","0" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","12" );
      ((Element)v.get(461)).setAttribute("height","12" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("width","750" );
      ((Element)v.get(459)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","1" );
      ((Element)v.get(463)).setAttribute("height","1" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","12" );
      ((Element)v.get(465)).setAttribute("height","12" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:459   */

      /* Empieza nodo:466 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("width","12" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","12" );
      ((Element)v.get(468)).setAttribute("height","12" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(471)).setAttribute("class","legend" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(472)).setAttribute("alto","13" );
      ((Element)v.get(472)).setAttribute("filas","1" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("id","legend" );
      ((Element)v.get(472)).setAttribute("cod","0010" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 470   */
      v.add(doc.createElement("table"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(473)).setAttribute("border","0" );
      ((Element)v.get(473)).setAttribute("align","center" );
      ((Element)v.get(473)).setAttribute("cellspacing","0" );
      ((Element)v.get(473)).setAttribute("cellpadding","0" );
      ((Element)v.get(470)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("colspan","9" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(476)).setAttribute("height","12" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(473)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","12" );
      ((Element)v.get(479)).setAttribute("height","12" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("colspan","7" );
      ((Element)v.get(480)).setAttribute("width","100%" );
      ((Element)v.get(477)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("table"));
      ((Element)v.get(481)).setAttribute("width","100%" );
      ((Element)v.get(481)).setAttribute("border","0" );
      ((Element)v.get(481)).setAttribute("cellspacing","0" );
      ((Element)v.get(481)).setAttribute("cellpadding","0" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("table"));
      ((Element)v.get(485)).setAttribute("width","100%" );
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("align","center" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("table"));
      ((Element)v.get(488)).setAttribute("width","702" );
      ((Element)v.get(488)).setAttribute("border","0" );
      ((Element)v.get(488)).setAttribute("align","left" );
      ((Element)v.get(488)).setAttribute("cellspacing","0" );
      ((Element)v.get(488)).setAttribute("cellpadding","0" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(490)).setAttribute("colspan","4" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","8" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblVentaExclusiva4" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","0010" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblTipoCliente4" );
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("id","datosTitle" );
      ((Element)v.get(500)).setAttribute("cod","393" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(492)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblSubTipoCliente4" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","595" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("width","100%" );
      ((Element)v.get(492)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:492   */

      /* Empieza nodo:507 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(511)).setAttribute("nombre","ckVentaExclusiva4" );
      ((Element)v.get(511)).setAttribute("texto","" );
      ((Element)v.get(511)).setAttribute("check","N" );
      ((Element)v.get(511)).setAttribute("onclick","ckVentaExclusivaOnChange();" );
      ((Element)v.get(511)).setAttribute("validacion","" );
      ((Element)v.get(511)).setAttribute("req","N" );
      ((Element)v.get(511)).setAttribute("id","datosCampos" );
      ((Element)v.get(511)).setAttribute("ontab","tabGenerico('ckVentaExclusiva4','tab');" );
      ((Element)v.get(511)).setAttribute("onshtab","tabGenerico('ckVentaExclusiva4','sh');" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","25" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(515)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(515)).setAttribute("id","datosCampos" );
      ((Element)v.get(515)).setAttribute("size","1" );
      ((Element)v.get(515)).setAttribute("multiple","N" );
      ((Element)v.get(515)).setAttribute("req","N" );
      ((Element)v.get(515)).setAttribute("valorinicial","" );
      ((Element)v.get(515)).setAttribute("textoinicial","" );
      ((Element)v.get(515)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:517 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","25" );
      ((Element)v.get(518)).setAttribute("height","8" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:519 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(520)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(520)).setAttribute("id","datosCampos" );
      ((Element)v.get(520)).setAttribute("size","1" );
      ((Element)v.get(520)).setAttribute("multiple","N" );
      ((Element)v.get(520)).setAttribute("req","N" );
      ((Element)v.get(520)).setAttribute("valorinicial","" );
      ((Element)v.get(520)).setAttribute("textoinicial","" );
      ((Element)v.get(520)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(522)).setAttribute("width","100%" );
      ((Element)v.get(507)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:507   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:524 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("td"));
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("table"));
      ((Element)v.get(526)).setAttribute("width","702" );
      ((Element)v.get(526)).setAttribute("border","0" );
      ((Element)v.get(526)).setAttribute("align","left" );
      ((Element)v.get(526)).setAttribute("cellspacing","0" );
      ((Element)v.get(526)).setAttribute("cellpadding","0" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("colspan","4" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:530 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(530));

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
      ((Element)v.get(530)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(534)).setAttribute("nombre","lblTipoClasificacionCliente4" );
      ((Element)v.get(534)).setAttribute("alto","13" );
      ((Element)v.get(534)).setAttribute("filas","1" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(534)).setAttribute("id","datosTitle" );
      ((Element)v.get(534)).setAttribute("cod","610" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(538)).setAttribute("nombre","lblClasificacionCliente4" );
      ((Element)v.get(538)).setAttribute("alto","13" );
      ((Element)v.get(538)).setAttribute("filas","1" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("id","datosTitle" );
      ((Element)v.get(538)).setAttribute("cod","611" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(539)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:530   */

      /* Empieza nodo:541 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","8" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(545)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(545)).setAttribute("id","datosCampos" );
      ((Element)v.get(545)).setAttribute("size","1" );
      ((Element)v.get(545)).setAttribute("multiple","N" );
      ((Element)v.get(545)).setAttribute("req","N" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(545)).setAttribute("valorinicial","" );
      ((Element)v.get(545)).setAttribute("textoinicial","" );
      ((Element)v.get(545)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:547 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","25" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(541)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(550)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(550)).setAttribute("id","datosCampos" );
      ((Element)v.get(550)).setAttribute("size","1" );
      ((Element)v.get(550)).setAttribute("multiple","N" );
      ((Element)v.get(550)).setAttribute("req","N" );
      ((Element)v.get(550)).setAttribute("valorinicial","" );
      ((Element)v.get(550)).setAttribute("textoinicial","" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:552 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("width","100%" );
      ((Element)v.get(541)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","8" );
      ((Element)v.get(553)).setAttribute("height","8" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:541   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:554 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("table"));
      ((Element)v.get(556)).setAttribute("width","702" );
      ((Element)v.get(556)).setAttribute("border","0" );
      ((Element)v.get(556)).setAttribute("align","left" );
      ((Element)v.get(556)).setAttribute("cellspacing","0" );
      ((Element)v.get(556)).setAttribute("cellpadding","0" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("colspan","4" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:560 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(564)).setAttribute("nombre","lblEstatusCliente4" );
      ((Element)v.get(564)).setAttribute("alto","13" );
      ((Element)v.get(564)).setAttribute("filas","1" );
      ((Element)v.get(564)).setAttribute("valor","" );
      ((Element)v.get(564)).setAttribute("id","datosTitle" );
      ((Element)v.get(564)).setAttribute("cod","612" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","25" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(568)).setAttribute("nombre","lblEstatus2Cliente4" );
      ((Element)v.get(568)).setAttribute("alto","13" );
      ((Element)v.get(568)).setAttribute("filas","1" );
      ((Element)v.get(568)).setAttribute("valor","" );
      ((Element)v.get(568)).setAttribute("id","datosTitle" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(568)).setAttribute("cod","613" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("width","100%" );
      ((Element)v.get(560)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","8" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:560   */

      /* Empieza nodo:571 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(575)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(575)).setAttribute("id","datosCampos" );
      ((Element)v.get(575)).setAttribute("size","1" );
      ((Element)v.get(575)).setAttribute("multiple","N" );
      ((Element)v.get(575)).setAttribute("req","N" );
      ((Element)v.get(575)).setAttribute("valorinicial","" );
      ((Element)v.get(575)).setAttribute("textoinicial","" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:577 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).setAttribute("width","25" );
      ((Element)v.get(578)).setAttribute("height","8" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(571)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(580)).setAttribute("nombre","txtEstatus2Cliente" );
      ((Element)v.get(580)).setAttribute("id","datosCampos" );
      ((Element)v.get(580)).setAttribute("max","1" );
      ((Element)v.get(580)).setAttribute("tipo","" );
      ((Element)v.get(580)).setAttribute("onchange","" );
      ((Element)v.get(580)).setAttribute("req","N" );
      ((Element)v.get(580)).setAttribute("size","2" );
      ((Element)v.get(580)).setAttribute("valor","" );
      ((Element)v.get(580)).setAttribute("validacion","" );
      ((Element)v.get(580)).setAttribute("ontab","tabGenerico('txtEstatus2Cliente');" );
      ((Element)v.get(580)).setAttribute("onshtab","tabGenerico('txtEstatus2Cliente','sh');" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","25" );
      ((Element)v.get(582)).setAttribute("height","8" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).setAttribute("width","100%" );
      ((Element)v.get(571)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:571   */

      /* Empieza nodo:585 / Elemento padre: 556   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(556)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).setAttribute("colspan","4" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:588 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","12" );
      ((Element)v.get(589)).setAttribute("height","12" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:477   */

      /* Empieza nodo:590 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 590   */
      v.add(doc.createElement("td"));
      ((Element)v.get(593)).setAttribute("colspan","7" );
      ((Element)v.get(590)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("table"));
      ((Element)v.get(595)).setAttribute("width","100%" );
      ((Element)v.get(595)).setAttribute("border","0" );
      ((Element)v.get(595)).setAttribute("align","center" );
      ((Element)v.get(595)).setAttribute("cellspacing","0" );
      ((Element)v.get(595)).setAttribute("cellpadding","0" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(597)).setAttribute("class","botonera" );
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(598)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(598)).setAttribute("ID","botonContenido" );
      ((Element)v.get(598)).setAttribute("tipo","html" );
      ((Element)v.get(598)).setAttribute("estado","false" );
      ((Element)v.get(598)).setAttribute("cod","404" );
      ((Element)v.get(598)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(598)).setAttribute("ontab","tabGenerico('btnAnadir5');" );
      ((Element)v.get(598)).setAttribute("onshtab","tabGenerico('btnAnadir5','sh');" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:599 / Elemento padre: 590   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","12" );
      ((Element)v.get(600)).setAttribute("height","12" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:590   */

      /* Empieza nodo:601 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).setAttribute("colspan","9" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","12" );
      ((Element)v.get(603)).setAttribute("height","330" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:473   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:604 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","12" );
      ((Element)v.get(605)).setAttribute("height","12" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:466   */

      /* Empieza nodo:606 / Elemento padre: 458   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(458)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).setAttribute("width","12" );
      ((Element)v.get(607)).setAttribute("align","center" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","12" );
      ((Element)v.get(608)).setAttribute("height","12" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("width","750" );
      ((Element)v.get(606)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("width","12" );
      ((Element)v.get(606)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","12" );
      ((Element)v.get(612)).setAttribute("height","12" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:606   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:613 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(613)).setAttribute("nombre","listado5" );
      ((Element)v.get(613)).setAttribute("ancho","704" );
      ((Element)v.get(613)).setAttribute("alto","295" );
      ((Element)v.get(613)).setAttribute("x","27" );
      ((Element)v.get(613)).setAttribute("y","1928" );
      ((Element)v.get(613)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(613)).setAttribute("msgDebugJS","S" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(614)).setAttribute("precarga","S" );
      ((Element)v.get(614)).setAttribute("conROver","S" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(615)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(615)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(615)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(615)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */

      /* Empieza nodo:616 / Elemento padre: 614   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(616)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(616)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(616)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(616)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */

      /* Empieza nodo:617 / Elemento padre: 614   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(617)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(617)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:614   */

      /* Empieza nodo:618 / Elemento padre: 613   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(613)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(619)).setAttribute("borde","1" );
      ((Element)v.get(619)).setAttribute("horizDatos","1" );
      ((Element)v.get(619)).setAttribute("horizCabecera","1" );
      ((Element)v.get(619)).setAttribute("vertical","1" );
      ((Element)v.get(619)).setAttribute("horizTitulo","1" );
      ((Element)v.get(619)).setAttribute("horizBase","1" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */

      /* Empieza nodo:620 / Elemento padre: 618   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(620)).setAttribute("borde","#999999" );
      ((Element)v.get(620)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(620)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(620)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(620)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(620)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(620)).setAttribute("horizBase","#999999" );
      ((Element)v.get(618)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:618   */

      /* Empieza nodo:621 / Elemento padre: 613   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(621)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(621)).setAttribute("alto","22" );
      ((Element)v.get(621)).setAttribute("imgFondo","" );
      ((Element)v.get(613)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */

      /* Empieza nodo:622 / Elemento padre: 613   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(622)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(622)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(622)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(622)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(622)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(622)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(613)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(623)).setAttribute("ancho","100" );
      ((Element)v.get(623)).setAttribute("minimizable","S" );
      ((Element)v.get(623)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */

      /* Empieza nodo:624 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(624)).setAttribute("ancho","100" );
      ((Element)v.get(624)).setAttribute("minimizable","S" );
      ((Element)v.get(624)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(625)).setAttribute("ancho","150" );
      ((Element)v.get(625)).setAttribute("minimizable","S" );
      ((Element)v.get(625)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */

      /* Empieza nodo:626 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(626)).setAttribute("ancho","130" );
      ((Element)v.get(626)).setAttribute("minimizable","S" );
      ((Element)v.get(626)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */

      /* Empieza nodo:627 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(627)).setAttribute("ancho","100" );
      ((Element)v.get(627)).setAttribute("minimizable","S" );
      ((Element)v.get(627)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */

      /* Empieza nodo:628 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(628)).setAttribute("ancho","100" );
      ((Element)v.get(628)).setAttribute("minimizable","S" );
      ((Element)v.get(628)).setAttribute("minimizada","N" );
      ((Element)v.get(622)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:622   */

      /* Empieza nodo:629 / Elemento padre: 613   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(629)).setAttribute("alto","20" );
      ((Element)v.get(629)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(629)).setAttribute("imgFondo","" );
      ((Element)v.get(629)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(613)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(630)).setAttribute("colFondo","" );
      ((Element)v.get(630)).setAttribute("ID","EstCab" );
      ((Element)v.get(630)).setAttribute("cod","393" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(631)).setAttribute("colFondo","" );
      ((Element)v.get(631)).setAttribute("ID","EstCab" );
      ((Element)v.get(631)).setAttribute("cod","595" );
      ((Element)v.get(629)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */

      /* Empieza nodo:632 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(632)).setAttribute("colFondo","" );
      ((Element)v.get(632)).setAttribute("ID","EstCab" );
      ((Element)v.get(632)).setAttribute("cod","610" );
      ((Element)v.get(629)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(633)).setAttribute("colFondo","" );
      ((Element)v.get(633)).setAttribute("ID","EstCab" );
      ((Element)v.get(633)).setAttribute("cod","611" );
      ((Element)v.get(629)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(634)).setAttribute("colFondo","" );
      ((Element)v.get(634)).setAttribute("ID","EstCab" );
      ((Element)v.get(634)).setAttribute("cod","551" );
      ((Element)v.get(629)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */

      /* Empieza nodo:635 / Elemento padre: 629   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(635)).setAttribute("colFondo","" );
      ((Element)v.get(635)).setAttribute("ID","EstCab" );
      ((Element)v.get(635)).setAttribute("cod","552" );
      ((Element)v.get(629)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:629   */

      /* Empieza nodo:636 / Elemento padre: 613   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(636)).setAttribute("alto","22" );
      ((Element)v.get(636)).setAttribute("accion","" );
      ((Element)v.get(636)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(636)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(636)).setAttribute("maxSel","-1" );
      ((Element)v.get(636)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(636)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(636)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(636)).setAttribute("onLoad","" );
      ((Element)v.get(636)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(613)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(637)).setAttribute("tipo","texto" );
      ((Element)v.get(637)).setAttribute("ID","EstDat" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */

      /* Empieza nodo:638 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(638)).setAttribute("tipo","texto" );
      ((Element)v.get(638)).setAttribute("ID","EstDat2" );
      ((Element)v.get(636)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */

      /* Empieza nodo:639 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(639)).setAttribute("tipo","texto" );
      ((Element)v.get(639)).setAttribute("ID","EstDat" );
      ((Element)v.get(636)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */

      /* Empieza nodo:640 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(640)).setAttribute("tipo","texto" );
      ((Element)v.get(640)).setAttribute("ID","EstDat2" );
      ((Element)v.get(636)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */

      /* Empieza nodo:641 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(641)).setAttribute("tipo","texto" );
      ((Element)v.get(641)).setAttribute("ID","EstDat" );
      ((Element)v.get(636)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 636   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(642)).setAttribute("tipo","texto" );
      ((Element)v.get(642)).setAttribute("ID","EstDat2" );
      ((Element)v.get(636)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:636   */

      /* Empieza nodo:643 / Elemento padre: 613   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(613)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */

      /* Empieza nodo:644 / Elemento padre: 613   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(644)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(644)).setAttribute("ancho","704" );
      ((Element)v.get(644)).setAttribute("sep","$" );
      ((Element)v.get(644)).setAttribute("x","12" );
      ((Element)v.get(644)).setAttribute("class","botonera" );
      ((Element)v.get(644)).setAttribute("y","2200" );
      ((Element)v.get(644)).setAttribute("control","|" );
      ((Element)v.get(644)).setAttribute("conector","" );
      ((Element)v.get(644)).setAttribute("rowset","" );
      ((Element)v.get(644)).setAttribute("cargainicial","N" );
      ((Element)v.get(613)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:613   */

      /* Empieza nodo:645 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(645)).setAttribute("nombre","Eliminar5" );
      ((Element)v.get(645)).setAttribute("x","30" );
      ((Element)v.get(645)).setAttribute("y","2201" );
      ((Element)v.get(645)).setAttribute("ID","botonContenido" );
      ((Element)v.get(645)).setAttribute("tipo","html" );
      ((Element)v.get(645)).setAttribute("estado","false" );
      ((Element)v.get(645)).setAttribute("cod","1254" );
      ((Element)v.get(645)).setAttribute("accion","accionEliminarVentaExclusiva();" );
      ((Element)v.get(645)).setAttribute("ontab","tabGenerico('Eliminar5');" );
      ((Element)v.get(645)).setAttribute("onshtab","tabGenerico('Eliminar5','sh');" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:15   */


   }

}
