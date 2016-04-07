
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_consultoras_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_consultoras_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0491" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r \r\rvar vConstantesPestInc = new Array();           \r\rfunction fLimpiar() {\r          onLoadPag();\r}\r      \rfunction onLoadPag() {  \r          configurarMenuSecundario('formulario');\r    set(\"formulario.ckReingresos\", get(\"formulario.tempCKReingresos\"));\r\r    if (get('formulario.oidPlantillaBaseCalculo') != ''){\r              marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidPlantillaBaseCalculo'));              \r              onChangeBaseCalculo();\r                    accion(\"formulario.cbBaseCalculo\",\".disabled=true\");\r             \r          if (  get('formulario.oidPlantillaBaseCalculo') == get('formulario.oidBC_Recomendada')){\r                              marcaSeleccionDelUsuario('formulario.cbEfectividad', get('formulario.hidEfectividad'));\r              document.getElementById(\"capa1\").style.visibility='visible';\r\r                                                        accion('formulario.cbConcursoPuntajeRecomendada', '.disabled=true');			\r\r          }\r          else{\r                              document.getElementById(\"capa1\").style.visibility='hidden';\r          }\r    }\r    else\r              document.getElementById(\"capa1\").style.visibility='hidden';\r\r    if (get('formulario.ocultaParticipante') == '1'){\r                    deshabilitarHabilitarBoton('botonContenido','btnParticipantes','D');\r    }\r           \r    \r    if (get('formulario.hidIndConsultoras') == '1'){           if (get('formulario.oidBaseCalculo') !=''){\r                         marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidBaseCalculo'));\r\r                              if (  get('formulario.oidBaseCalculo') == get('formulario.oidBC_Recomendada')){\r                                         marcaSeleccionDelUsuario('formulario.cbEfectividad', get('formulario.hidEfectividad'));\r                    marcaSeleccionDelUsuario('formulario.cbPeriodoInicialEvaluacion', \r                    get('formulario.hidPeriodoInicialEval'));\r\r                                                                            if(get('formulario.indGenerarPuntajeARecomendadas')==\"S\"){\r                                             accion('formulario.cbConcursoPuntajeRecomendada', '.disabled=false');\r                                                      marcaSeleccionDelUsuario('formulario.cbConcursoPuntajeRecomendada', get('formulario.hidOidConcursoPuntajeRecomendada'));\r                                      } else{\r                                                      accion('formulario.cbConcursoPuntajeRecomendada', '.disabled=true');\r                                      }\r\r                                        document.getElementById(\"capa1\").style.visibility='visible';     \r              }\r              else\r                                         document.getElementById(\"capa1\").style.visibility='hidden';\r          }\r     }\r\r	 if ( get('formulario.opcionMenu') == 'Consultar Concurso'){\r                    deshabilitaCampos();\r          btnProxy(1, 0);\r          btnProxy(2, 1);\r          btnProxy(3, 0);\r          btnProxy(5, 0);      \r          btnProxy(7, 0);\r          btnProxy(8, 0);\r          btnProxy(9, 0);\r    }\r    else if(get('formulario.opcionMenu') == 'Modificar Concurso') {\r              btnProxy(2,'1');\r          btnProxy(3,'0');\r          btnProxy(7,'0');\r          btnProxy(8,'0');\r                    btnProxy(9,'0');\r    }\r\r     var vConst = get('formulario.hidConstantesPestINC');\r     vConstantesPestInc = vConst.split(\"|\");           \r\r                if(get(\"formulario.oidTipoVenta\")!=\"\") {\r                    marcaSeleccionDelUsuario('formulario.cbTipoVenta', get(\"formulario.oidTipoVenta\"));\r           }     \r\r     focaliza('formulario.txtMontoMinimo');\r     finCargaPagina = true;\r}    \r\rfunction fVolver() {\r          window.close();\r}\r\rfunction accionExitosa(){\r          eval('formulario').oculto=\"N\";\r}\r    \r    function onClickEstatusVenta (){\r           var obj = new Object();\r           obj.opcionMenu = get('formulario.opcionMenu');\r           \r           var whnd = mostrarModalSICC('LPMantenerParametrosConsultoras','cargar estatus venta',obj,null,510);\r           if (whnd != null){\r                set('formulario.hidIngresoEVTA','1');\r                set ('formulario.hidLstEstatusVta',whnd[0]);\r                set('formulario.conectorAction', 'LPMantenerParametrosConsultoras');\r                eval('formulario').oculto=\"S\"; \r                set('formulario.accion', 'almacenar estatus venta');\r                enviaSICC('formulario');\r           }\r    }\r    \r    function onClickMontoVentaRecomendada () {           \r           var obj = new Object();\r           obj.opcionMenu = get('formulario.opcionMenu');\r           var whnd = mostrarModalSICC('LPMantenerParametrosConsultoras','cargar monto venta recomendadas',obj,null,260);\r           if (whnd != null){\r                set('formulario.hidIngresoMVR','1');\r                set('formulario.hidLstMVR', whnd[0]) ;\r                                                                    set('formulario.hidCargoAlMenosUno', whnd[1]) ;\r\r                set('formulario.conectorAction', 'LPMantenerParametrosConsultoras');\r                eval('formulario').oculto=\"S\"; \r                set('formulario.accion', 'almacenar monto venta recomendadas');\r                enviaSICC('formulario');\r           }\r    }\r    \r    function onClickParticipante() {                      \r           var obj = new Object();\r           obj.opcionMenu = get('formulario.opcionMenu');\r           var whnd = mostrarModalSICC('LPMantenerParametrosConsultoras','cargar clasificacion participantes',obj);\r           if (whnd != null) {                     \r                set('formulario.hidIngresoPAR','1');\r                set('formulario.hidLstClasConsul', whnd[0] );\r                set('formulario.hidListaClasif', whnd[1] );\r                \r                set('formulario.conectorAction', 'LPMantenerParametrosConsultoras');\r                eval('formulario').oculto=\"S\"; \r                set('formulario.accion', 'almacenar Clasificacion Participantes');\r                enviaSICC('formulario', null, null, 'N');              }\r    }\r    \r          function onChangeBaseCalculo () {\r                    var vBC = get('formulario.cbBaseCalculo','V');\r\r          if (vBC == get('formulario.oidBC_Recomendada')) {\r                    document.getElementById(\"capa1\").style.visibility='visible';              \r              accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r          }\r          else{\r                              document.getElementById(\"capa1\").style.visibility='hidden';\r              limpiaCapaRecomendados();\r\r              if(vBC == get('formulario.oidBC_Monto')) {\r                                         var valor = new Array();\r                    set(\"formulario.cbTipoVenta\", valor);\r                    accion(\"formulario.cbTipoVenta\",\".disabled=false\");\r              }\r              else {\r                    accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r              }              \r          }\r    }\r    \r    function limpiaCapaRecomendados(){\r           set('formulario.RecomendacionEfectiva', 'N');\r           set('formulario.cbEfectividad','');\r           \r           set('formulario.cbPeriodoInicialEvaluacion', '');\r           set('formulario.txtNumPeriodosEvaluar','');\r           set('formulario.txtNumMinPedidos','');\r           set('formulario.txtNumMinPedidosRecomendadas','');\r                      set('formulario.indPremioCampEfect', 'N');\r                    onChangeRecomendacionEfectiva();\r\r                                        set('formulario.indGenerarPuntajeARecomendadas', 'N');\r                    onChangeGenerarPuntaj();\r\r    }\r    \r    function onChangeRecomendacionEfectiva(){\r           if(get(\"formulario.RecomendacionEfectiva\")==\"S\")\r                accion('formulario.cbEfectividad','.disabled=false');\r           else\r                accion('formulario.cbEfectividad','.disabled=true');\r    }\r           \r          function accionGuardar(){\r                                        \r                    if(!sicc_validaciones_generales('datosAdicionalesObligatorios') || !sicc_validaciones_generales('datosAdicionales')) {\r                     return;\r          }\r\r                    if(get('formulario.cbBaseCalculo') == get('formulario.oidBC_Monto')) {\r                     if(!sicc_validaciones_generales('datosAdicionalesObligatoriosTipoVenta')) {\r                              return;\r                     }     \r                    }              \r\r\r          if(get_visibilidad('capa1')) {\r                                                          if(!sicc_validaciones_generales('recomendadas')) {\r                                         return;\r              }\r\r\r                                                         if(get('formulario.indGenerarPuntajeARecomendadas')==\"S\"){\r                                    if(!sicc_validaciones_generales(\"recomendadas1\")){\r                                             return;\r                                    }\r                             }\r          }\r\r          tomaValoresPantalla();\r           \r          set('formulario.conectorAction', 'LPMantenerParametrosConsultoras');\r          eval('formulario').oculto=\"S\"; \r          set('formulario.accion', 'guardar');\r          enviaSICC('formulario','','','N');\r    }\r    \r           function tomaValoresPantalla(){\r                                 set('formulario.oidParamConsultoras',get('formulario.oidParamConsultoras'));\r\r                                            var vDatosOblig = comprobarDatosObligatorios();\r           set('formulario.datosObligatorios', vDatosOblig);\r\r                                 set('formulario.hidMontoMinimoPedido',get('formulario.txtMontoMinimo'));\r           set('formulario.hidUnidadesMinimasPedido',get('formulario.txtUnidadesMinimas'));\r           set('formulario.hidReingresosPierdenPuntaje',get('formulario.ckReingresos'));\r           set('formulario.oidBaseCalculo', get('formulario.cbBaseCalculo','V'));\r                      set('formulario.oidTipoVenta', get('formulario.cbTipoVenta','V'));\r                      \r                                 set('formulario.hidRecomendacionEfectiva',get('formulario.RecomendacionEfectiva'));\r           set('formulario.hidEfectividad',get('formulario.cbEfectividad','V'));\r           set('formulario.hidPeriodoInicialEval',get('formulario.cbPeriodoInicialEvaluacion','V'));\r           set('formulario.hidNroPeriodosEvaluar',get('formulario.txtNumPeriodosEvaluar'));\r           set('formulario.hidNroMinimoPedidos',get('formulario.txtNumMinPedidos'));\r           set('formulario.hidNroMinPedidosReco',get('formulario.txtNumMinPedidosRecomendadas'));  \r                      set('formulario.hidIndPremioCampEfect',get('formulario.indPremioCampEfect'));  \r\r                                        set('formulario.hidIndGenerarPuntajeARecomendadas',get('formulario.indGenerarPuntajeARecomendadas')); \r                    set('formulario.hidOidConcursoPuntajeRecomendada',get('formulario.cbConcursoPuntajeRecomendada')); \r\r                      set('formulario.accion',get('formulario.accion'));\r           set('formulario.opcionMenu',get('formulario.opcionMenu'));      \r           \r           /*if (get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Recomendada')){\r                if( get('formulario.hidLstMVR') == ''){\r                      GestionarMensaje('1499');\r                      return false;\r                }\r           }*/\r    }\r    \rfunction comprobarDatosObligatorios() {\r                     if(get('formulario.cbBaseCalculo') == '') {\r                              return false;\r           }\r           else {\r                                 if(get('formulario.cbBaseCalculo') == get('formulario.oidBC_Monto')) {\r                                          if(get('formulario.cbTipoVenta') == '') {\r                                                    return false;\r                                          }   \r                                          else {\r                                                   return true;\r                                          }\r                                 }                     \r                                 else {\r                              return true;\r                                 }\r           }\r}\r\rfunction onClickPestanyaConsultoras(valor) {\r                                 \r                     if(!sicc_validaciones_generales('datosAdicionalesObligatorios') || !sicc_validaciones_generales('datosAdicionales')) {\r                      return;\r           }\r\r                     if(get('formulario.cbBaseCalculo') == get('formulario.oidBC_Monto')) {\r                                if(!sicc_validaciones_generales('datosAdicionalesObligatoriosTipoVenta')) {\r                                return;\r                                }    \r                     }\r\r           if(document.getElementById(\"capa1\").style.visibility=='visible') {\r                                                                  if(!sicc_validaciones_generales('recomendadas')) {\r                                  return;\r                      }\r           }\r\r           tomaValoresPantalla();\r           onClickPestanyaHabilitada(valor, 'formulario', 'LPMantenerParametrosConsultoras');\r}\r    \r    function deshabilitaCampos(){\r                      document.getElementById(\"txtMontoMinimo\").disabled = true;\r                      document.getElementById(\"txtUnidadesMinimas\").disabled = true;\r                      document.getElementById(\"ckReingresos\").disabled = true;\r                      document.getElementById(\"cbBaseCalculo\").disabled = true;\r                      document.getElementById(\"cbTipoVenta\").disabled = true;\r                      document.getElementById(\"RecomendacionEfectiva\").disabled = true;\r                      document.getElementById(\"cbEfectividad\").disabled = true;\r                      document.getElementById(\"cbPeriodoInicialEvaluacion\").disabled = true;\r                      document.getElementById(\"txtNumPeriodosEvaluar\").disabled = true;\r                      document.getElementById(\"txtNumMinPedidos\").disabled = true;\r                      document.getElementById(\"txtNumMinPedidosRecomendadas\").disabled = true;\r                      document.getElementById(\"indPremioCampEfect\").disabled = true;\r                                                                                          document.getElementById(\"indGenerarPuntajeARecomendadas\").disabled = true;\r                                             document.getElementById(\"cbConcursoPuntajeRecomendada\").disabled = true;\r    }\r    \r    function marcaSeleccionDelUsuario(pControl, datos){\r                      datos = datos.split(\",\");\r                      var comb = pControl;\r                      set(comb, datos);\r           }\r    \r    function fGuardar() {\r           accionGuardar();\r    }\r    \r    function onTabParticipante(){\r           if( document.getElementById(\"capa1\").style.visibility == 'hidden')\r                focaliza('formulario.txtMontoMinimo');\r           else\r                focaliza('formulario.RecomendacionEfectiva');\r    }\r    \r    function onShTabMontoMinimo() {\r           if( document.getElementById(\"capa1\").style.visibility == 'hidden')\r                focalizaBotonHTML('botonContenido','btnParticipantes');\r           else\r                focalizaBotonHTML('botonContenido','btnMontoVentas');\r    }\r\r\rfunction onChangeGenerarPuntaj() {\r      if(get('formulario.indGenerarPuntajeARecomendadas')==\"S\") {\r            accion('formulario.cbConcursoPuntajeRecomendada', '.disabled=false');  \r      } else {\r            set('formulario.cbConcursoPuntajeRecomendada', '');            \r            accion('formulario.cbConcursoPuntajeRecomendada', '.disabled=true'); \r      }\r  }\r\r\r    \r \r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtMontoMinimo" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","1703" );
      ((Element)v.get(9)).setAttribute("group","datosAdicionales" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999999999999.99" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtUnidadesMinimas" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","1704" );
      ((Element)v.get(10)).setAttribute("group","datosAdicionales" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbBaseCalculo" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1181" );
      ((Element)v.get(11)).setAttribute("group","datosAdicionalesObligatorios" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbTipoVenta" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1622" );
      ((Element)v.get(12)).setAttribute("group","datosAdicionalesObligatoriosTipoVenta" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumPeriodosEvaluar" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","1675" );
      ((Element)v.get(13)).setAttribute("group","recomendadas" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","99" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtNumMinPedidos" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1676" );
      ((Element)v.get(14)).setAttribute("group","recomendadas" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","99" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtNumMinPedidosRecomendadas" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","2423" );
      ((Element)v.get(15)).setAttribute("group","recomendadas" );
      ((Element)v.get(15)).setAttribute("format","e" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","99" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbConcursoPuntajeRecomendada" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","3363" );
      ((Element)v.get(16)).setAttribute("group","recomendadas1" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:8   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(17)).setAttribute("nombre","formulario" );
      ((Element)v.get(17)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","tempCKReingresos" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","accion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidTipoVenta" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidPlantillaBaseCalculo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","ocultaParticipante" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidParamConsultoras" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidParamConsultoras" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidRecomendacionEfectiva" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidEfectividad" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidPeriodoInicialEval" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidNroPeriodosEvaluar" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidNroMinimoPedidos" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidNroMinPedidosReco" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidMontoMinimoPedido" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidUnidadesMinimasPedido" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidReingresosPierdenPuntaje" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidIndPremioCampEfect" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidIndConsultoras" );
      ((Element)v.get(42)).setAttribute("valor","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidLstMVR" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidCargoAlMenosUno" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","oidBC_Recomendada" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","oidBC_Calculo_Monto" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","oidBC_Tipo_Vta_Catalogo" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","oidBC_Monto" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hidIngresoEVTA" );
      ((Element)v.get(49)).setAttribute("valor","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hidIngresoPAR" );
      ((Element)v.get(50)).setAttribute("valor","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hidIngresoMVR" );
      ((Element)v.get(51)).setAttribute("valor","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidConstantesPestINC" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hidLstClasConsul" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 17   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hidListaClasif" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hidLstEstatusVta" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hidIndGenerarPuntajeARecomendadas" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hidOidConcursoPuntajeRecomendada" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("height","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("class","menu4" );
      ((Element)v.get(17)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","30" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Elemento padre:69 / Elemento actual: 70   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(69)).appendChild((Text)v.get(70));

      /* Termina nodo Texto:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","10" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","92" );
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","75" );
      ((Element)v.get(74)).setAttribute("border","1" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellpadding","1" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(74)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(74)).setAttribute("onclick","onClickPestanyaConsultoras(1);" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(77)).setAttribute("cod","00393" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:78 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","10" );
      ((Element)v.get(79)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","20" );
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","75" );
      ((Element)v.get(81)).setAttribute("border","1" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellpadding","1" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(81)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(81)).setAttribute("onclick","onClickPestanyaConsultoras(5);" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(84)).setAttribute("cod","0094" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:85 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","20" );
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","75" );
      ((Element)v.get(88)).setAttribute("border","1" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellpadding","1" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(88)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(88)).setAttribute("onclick","onClickPestanyaConsultoras(6);" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(91)).setAttribute("cod","00394" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:92 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","10" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","10" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","20" );
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","75" );
      ((Element)v.get(95)).setAttribute("border","1" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellpadding","1" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(95)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(95)).setAttribute("onclick","onClickPestanyaConsultoras(7);" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(98)).setAttribute("cod","00395" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:99 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","10" );
      ((Element)v.get(99)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","10" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","20" );
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","75" );
      ((Element)v.get(102)).setAttribute("border","1" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellpadding","1" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(102)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(102)).setAttribute("onclick","onClickPestanyaConsultoras(4);" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(105)).setAttribute("cod","00396" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:106 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","10" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","10" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","20" );
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","75" );
      ((Element)v.get(109)).setAttribute("border","1" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellpadding","1" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(109)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(109)).setAttribute("onclick","onClickPestanyaConsultoras(8);" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","menu5textonegrita" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(112)).setAttribute("cod","00397" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:113 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","16" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(66)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:115 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(115)).setAttribute("height","100%" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("class","menu4" );
      ((Element)v.get(17)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(118)).setAttribute("height","30" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","10" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","70" );
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","75" );
      ((Element)v.get(124)).setAttribute("border","1" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellpadding","1" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(124)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblAmbitoGeografico');" );
      ((Element)v.get(124)).setAttribute("onclick","onClickPestanyaConsultoras(3);" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(127)).setAttribute("cod","2801" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:128 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","70" );
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(130)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","75" );
      ((Element)v.get(131)).setAttribute("border","1" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellpadding","1" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(131)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(131)).setAttribute("onclick","onClickPestanyaConsultoras(9);" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(134)).setAttribute("cod","00398" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","10" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","20" );
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","75" );
      ((Element)v.get(138)).setAttribute("border","1" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellpadding","1" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(138)).setAttribute("onmouseover","activarPuntero('formulario',10,'lblGerentes');" );
      ((Element)v.get(138)).setAttribute("onclick","onClickPestanyaConsultoras(10);" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(141)).setAttribute("cod","00399" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:142 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","10" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","20" );
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("width","75" );
      ((Element)v.get(145)).setAttribute("border","1" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("cellpadding","1" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(145)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(145)).setAttribute("onmouseover","" );
      ((Element)v.get(145)).setAttribute("onclick","" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(148)).setAttribute("cod","00401" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:149 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","10" );
      ((Element)v.get(149)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","10" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","20" );
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","75" );
      ((Element)v.get(152)).setAttribute("border","1" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("cellpadding","1" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(152)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(152)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblProgramaNuevas');" );
      ((Element)v.get(152)).setAttribute("onclick","onClickPestanyaConsultoras(2);" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(155)).setAttribute("cod","00590" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:156 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","10" );
      ((Element)v.get(156)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","10" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","20" );
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(158)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","75" );
      ((Element)v.get(159)).setAttribute("border","1" );
      ((Element)v.get(159)).setAttribute("align","center" );
      ((Element)v.get(159)).setAttribute("cellpadding","1" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(159)).setAttribute("onmouseover","activarPuntero('formulario',12,'lblMultinivel');" );
      ((Element)v.get(159)).setAttribute("onclick","onClickPestanyaConsultoras(12);" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(162)).setAttribute("cod","00400" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:163 / Elemento padre: 116   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","16" );
      ((Element)v.get(163)).setAttribute("class","menu5texto" );
      ((Element)v.get(116)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:165 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","750" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","12" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("height","1" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:166   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(178)).setAttribute("class","legend" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblDatosAdicionales" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","legend" );
      ((Element)v.get(179)).setAttribute("cod","0052" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(180)).setAttribute("border","0" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("table"));
      ((Element)v.get(183)).setAttribute("width","661" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("colspan","4" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 183   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblMontoMinimo" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","1703" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblUnidadesMinimas" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","1704" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblReingresos" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","1750" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","1181" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:187   */

      /* Empieza nodo:206 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("valign","bottom" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","txtMontoMinimo" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("max","12" );
      ((Element)v.get(210)).setAttribute("tipo","" );
      ((Element)v.get(210)).setAttribute("onchange","" );
      ((Element)v.get(210)).setAttribute("req","N" );
      ((Element)v.get(210)).setAttribute("size","16" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(210)).setAttribute("onshtab","onShTabMontoMinimo();" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("valign","bottom" );
      ((Element)v.get(206)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(214)).setAttribute("nombre","txtUnidadesMinimas" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("max","3" );
      ((Element)v.get(214)).setAttribute("tipo","" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("req","N" );
      ((Element)v.get(214)).setAttribute("size","3" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("valign","bottom" );
      ((Element)v.get(206)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(218)).setAttribute("nombre","ckReingresos" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("onclick","" );
      ((Element)v.get(218)).setAttribute("check","N" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(206)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("size","1" );
      ((Element)v.get(222)).setAttribute("multiple","N" );
      ((Element)v.get(222)).setAttribute("req","S" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("onchange","onChangeBaseCalculo();" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:206   */

      /* Empieza nodo:226 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("colspan","4" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:229 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(180)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("table"));
      ((Element)v.get(231)).setAttribute("width","661" );
      ((Element)v.get(231)).setAttribute("border","0" );
      ((Element)v.get(231)).setAttribute("align","left" );
      ((Element)v.get(231)).setAttribute("cellspacing","0" );
      ((Element)v.get(231)).setAttribute("cellpadding","0" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(236)).setAttribute("alto","13" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("id","datosTitle" );
      ((Element)v.get(236)).setAttribute("cod","1622" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:232   */

      /* Empieza nodo:239 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(239));

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
      ((Element)v.get(242)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(243)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(243)).setAttribute("size","1" );
      ((Element)v.get(243)).setAttribute("multiple","N" );
      ((Element)v.get(243)).setAttribute("req","S" );
      ((Element)v.get(243)).setAttribute("valorinicial","" );
      ((Element)v.get(243)).setAttribute("textoinicial","" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(239)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:239   */

      /* Empieza nodo:247 / Elemento padre: 231   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(231)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("colspan","4" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:180   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:250 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:173   */

      /* Empieza nodo:252 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("table"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(257)).setAttribute("border","0" );
      ((Element)v.get(257)).setAttribute("align","center" );
      ((Element)v.get(257)).setAttribute("cellspacing","0" );
      ((Element)v.get(257)).setAttribute("cellpadding","0" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("class","botonera" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(260)).setAttribute("nombre","btnEstatusVenta" );
      ((Element)v.get(260)).setAttribute("ID","botonContenido" );
      ((Element)v.get(260)).setAttribute("tipo","html" );
      ((Element)v.get(260)).setAttribute("accion","onClickEstatusVenta();" );
      ((Element)v.get(260)).setAttribute("estado","false" );
      ((Element)v.get(260)).setAttribute("cod","1701" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(261)).setAttribute("nombre","btnParticipantes" );
      ((Element)v.get(261)).setAttribute("ID","botonContenido" );
      ((Element)v.get(261)).setAttribute("tipo","html" );
      ((Element)v.get(261)).setAttribute("accion","onClickParticipante();" );
      ((Element)v.get(261)).setAttribute("estado","false" );
      ((Element)v.get(261)).setAttribute("cod","745" );
      ((Element)v.get(261)).setAttribute("ontab","onTabParticipante();" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:262 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:252   */

      /* Empieza nodo:264 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","12" );
      ((Element)v.get(265)).setAttribute("align","center" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("height","12" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","756" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("width","12" );
      ((Element)v.get(264)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(270)).setAttribute("height","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:264   */
      /* Termina nodo:165   */

      /* Empieza nodo:271 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(271)).setAttribute("nombre","capa1" );
      ((Element)v.get(271)).setAttribute("alto","160" );
      ((Element)v.get(271)).setAttribute("ancho","100%" );
      ((Element)v.get(271)).setAttribute("colorf","" );
      ((Element)v.get(271)).setAttribute("borde","0" );
      ((Element)v.get(271)).setAttribute("imagenf","" );
      ((Element)v.get(271)).setAttribute("repeat","" );
      ((Element)v.get(271)).setAttribute("padding","" );
      ((Element)v.get(271)).setAttribute("visibilidad","" );
      ((Element)v.get(271)).setAttribute("contravsb","" );
      ((Element)v.get(271)).setAttribute("x","0" );
      ((Element)v.get(271)).setAttribute("y","210" );
      ((Element)v.get(271)).setAttribute("zindex","" );
      ((Element)v.get(17)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("table"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(272)).setAttribute("border","0" );
      ((Element)v.get(272)).setAttribute("cellspacing","0" );
      ((Element)v.get(272)).setAttribute("cellpadding","0" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("height","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","750" );
      ((Element)v.get(273)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("width","12" );
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(279)).setAttribute("height","1" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:273   */

      /* Empieza nodo:280 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(285)).setAttribute("class","legend" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblRecomendadas" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("id","legend" );
      ((Element)v.get(286)).setAttribute("cod","00289" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(287)).setAttribute("border","0" );
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("cellspacing","0" );
      ((Element)v.get(287)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("table"));
      ((Element)v.get(290)).setAttribute("width","661" );
      ((Element)v.get(290)).setAttribute("border","0" );
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(290)).setAttribute("cellspacing","0" );
      ((Element)v.get(290)).setAttribute("cellpadding","0" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("colspan","4" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:294 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lblRecomendacionEfectiva" );
      ((Element)v.get(298)).setAttribute("alto","13" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("id","datosTitle" );
      ((Element)v.get(298)).setAttribute("cod","1672" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 294   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblEfectividad" );
      ((Element)v.get(302)).setAttribute("alto","13" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("id","datosTitle" );
      ((Element)v.get(302)).setAttribute("cod","1673" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lblPeriodoInicialEvaluacion" );
      ((Element)v.get(306)).setAttribute("alto","13" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("id","datosTitle" );
      ((Element)v.get(306)).setAttribute("cod","1674" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","25" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lblNumPeriodosEvaluar" );
      ((Element)v.get(310)).setAttribute("alto","13" );
      ((Element)v.get(310)).setAttribute("filas","1" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(310)).setAttribute("id","datosTitle" );
      ((Element)v.get(310)).setAttribute("cod","1675" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","25" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblNMinPedidos" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","1676" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:294   */

      /* Empieza nodo:317 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(321)).setAttribute("nombre","RecomendacionEfectiva" );
      ((Element)v.get(321)).setAttribute("id","datosCampos" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(321)).setAttribute("onclick","onChangeRecomendacionEfectiva();" );
      ((Element)v.get(321)).setAttribute("check","N" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(317)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(325)).setAttribute("nombre","cbEfectividad" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("size","1" );
      ((Element)v.get(325)).setAttribute("multiple","N" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("valorinicial","" );
      ((Element)v.get(325)).setAttribute("textoinicial","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","25" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(317)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(330)).setAttribute("nombre","cbPeriodoInicialEvaluacion" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(330)).setAttribute("size","1" );
      ((Element)v.get(330)).setAttribute("multiple","N" );
      ((Element)v.get(330)).setAttribute("req","N" );
      ((Element)v.get(330)).setAttribute("valorinicial","" );
      ((Element)v.get(330)).setAttribute("textoinicial","" );
      ((Element)v.get(330)).setAttribute("disabled","true" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","25" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(335)).setAttribute("nombre","txtNumPeriodosEvaluar" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("max","2" );
      ((Element)v.get(335)).setAttribute("tipo","" );
      ((Element)v.get(335)).setAttribute("onchange","" );
      ((Element)v.get(335)).setAttribute("req","N" );
      ((Element)v.get(335)).setAttribute("size","2" );
      ((Element)v.get(335)).setAttribute("valor","" );
      ((Element)v.get(335)).setAttribute("validacion","" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","25" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(339)).setAttribute("nombre","txtNumMinPedidos" );
      ((Element)v.get(339)).setAttribute("id","datosCampos" );
      ((Element)v.get(339)).setAttribute("max","2" );
      ((Element)v.get(339)).setAttribute("tipo","" );
      ((Element)v.get(339)).setAttribute("onchange","" );
      ((Element)v.get(339)).setAttribute("req","N" );
      ((Element)v.get(339)).setAttribute("size","2" );
      ((Element)v.get(339)).setAttribute("valor","" );
      ((Element)v.get(339)).setAttribute("validacion","" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 317   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("width","100%" );
      ((Element)v.get(317)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:317   */

      /* Empieza nodo:342 / Elemento padre: 290   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(290)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("colspan","4" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:345 / Elemento padre: 287   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(287)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("table"));
      ((Element)v.get(347)).setAttribute("width","661" );
      ((Element)v.get(347)).setAttribute("border","0" );
      ((Element)v.get(347)).setAttribute("align","left" );
      ((Element)v.get(347)).setAttribute("cellspacing","0" );
      ((Element)v.get(347)).setAttribute("cellpadding","0" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(352)).setAttribute("nombre","lblNumMinPedidosRecomendadas" );
      ((Element)v.get(352)).setAttribute("alto","13" );
      ((Element)v.get(352)).setAttribute("filas","1" );
      ((Element)v.get(352)).setAttribute("valor","" );
      ((Element)v.get(352)).setAttribute("id","datosTitle" );
      ((Element)v.get(352)).setAttribute("cod","2423" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(356)).setAttribute("nombre","lblIndPremioCampEfect" );
      ((Element)v.get(356)).setAttribute("alto","13" );
      ((Element)v.get(356)).setAttribute("filas","1" );
      ((Element)v.get(356)).setAttribute("valor","" );
      ((Element)v.get(356)).setAttribute("id","datosTitle" );
      ((Element)v.get(356)).setAttribute("cod","3317" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblGenerarPuntajeARecomendadas" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(360)).setAttribute("id","datosTitle" );
      ((Element)v.get(360)).setAttribute("cod","3362" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(364)).setAttribute("nombre","lblConcursoPuntajeRecomendada" );
      ((Element)v.get(364)).setAttribute("alto","13" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(364)).setAttribute("filas","1" );
      ((Element)v.get(364)).setAttribute("valor","" );
      ((Element)v.get(364)).setAttribute("id","datosTitle" );
      ((Element)v.get(364)).setAttribute("cod","3363" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).setAttribute("width","100%" );
      ((Element)v.get(348)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:348   */

      /* Empieza nodo:367 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(371)).setAttribute("nombre","txtNumMinPedidosRecomendadas" );
      ((Element)v.get(371)).setAttribute("id","datosCampos" );
      ((Element)v.get(371)).setAttribute("max","2" );
      ((Element)v.get(371)).setAttribute("tipo","" );
      ((Element)v.get(371)).setAttribute("onchange","" );
      ((Element)v.get(371)).setAttribute("req","N" );
      ((Element)v.get(371)).setAttribute("size","2" );
      ((Element)v.get(371)).setAttribute("valor","" );
      ((Element)v.get(371)).setAttribute("validacion","" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(375)).setAttribute("nombre","indPremioCampEfect" );
      ((Element)v.get(375)).setAttribute("id","datosCampos" );
      ((Element)v.get(375)).setAttribute("onclick","" );
      ((Element)v.get(375)).setAttribute("check","N" );
      ((Element)v.get(375)).setAttribute("req","N" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(379)).setAttribute("nombre","indGenerarPuntajeARecomendadas" );
      ((Element)v.get(379)).setAttribute("id","datosCampos" );
      ((Element)v.get(379)).setAttribute("onclick","onChangeGenerarPuntaj();" );
      ((Element)v.get(379)).setAttribute("check","N" );
      ((Element)v.get(379)).setAttribute("req","N" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(367)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(383)).setAttribute("nombre","cbConcursoPuntajeRecomendada" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(383)).setAttribute("size","1" );
      ((Element)v.get(383)).setAttribute("multiple","N" );
      ((Element)v.get(383)).setAttribute("req","N" );
      ((Element)v.get(383)).setAttribute("valorinicial","" );
      ((Element)v.get(383)).setAttribute("textoinicial","" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:385 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("width","100%" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(367)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:367   */

      /* Empieza nodo:387 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("colspan","5" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:287   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:390 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:280   */

      /* Empieza nodo:392 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("table"));
      ((Element)v.get(397)).setAttribute("width","100%" );
      ((Element)v.get(397)).setAttribute("border","0" );
      ((Element)v.get(397)).setAttribute("align","center" );
      ((Element)v.get(397)).setAttribute("cellspacing","0" );
      ((Element)v.get(397)).setAttribute("cellpadding","0" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("class","botonera" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(400)).setAttribute("nombre","btnMontoVentas" );
      ((Element)v.get(400)).setAttribute("ID","botonContenido" );
      ((Element)v.get(400)).setAttribute("tipo","html" );
      ((Element)v.get(400)).setAttribute("accion","onClickMontoVentaRecomendada();" );
      ((Element)v.get(400)).setAttribute("estado","false" );
      ((Element)v.get(400)).setAttribute("cod","1677" );
      ((Element)v.get(400)).setAttribute("ontab","focaliza('formulario.txtMontoMinimo');" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:392   */

      /* Empieza nodo:403 / Elemento padre: 272   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(272)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","12" );
      ((Element)v.get(404)).setAttribute("align","center" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","12" );
      ((Element)v.get(405)).setAttribute("height","12" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("width","756" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("width","12" );
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","12" );
      ((Element)v.get(409)).setAttribute("height","1" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:403   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:17   */


   }

}
