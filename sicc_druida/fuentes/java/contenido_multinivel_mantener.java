
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_multinivel_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_multinivel_mantener" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
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
      v.add(doc.createTextNode("\r   \r\rfunction onLoadPag(){   \r      configurarMenuSecundario(\"formulario\");\r   btnProxy(2, 0);    \r   cargaDatos();\r      \r    var campos = get(\"formulario.deshaCampos\");  \r    if(campos == \"si\"){\r         deshabilitaCamposA();\r    }   \r    \r    var camposCK = get(\"formulario.deshaCamposCheck\");    \r    if(camposCK == \"si\"){\r         deshabilitaCamposB();\r    }    \r    \r    var act = get(\"formulario.ckActividad\");    \r    if (act ==\"S\"){     \r         accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=false\");\r         accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=false\");    \r    }    \r    \r    var camposCKP = get(\"formulario.deshaCamposCheckPago\");     \r    if(camposCKP == \"si\"){\r         habilitaCamposC(); \r    }\r         else{           \r         deshabilitaCamposC();\r         }	\r  \r         var menu = get(\"formulario.opcionMenu\");  \r\r         if (menu == \"Modificar Concurso\"){\r                  btnProxy(2,'1');\r                  btnProxy(3,'0');\r                  btnProxy(7,'0');\r                  btnProxy(8,'0');\r                  btnProxy(9,'0');\r         }\r\r         if (menu == \"Consultar Concurso\"){\r      deshabilitaCamposD();      \r      btnProxy(1, 0);\r      btnProxy(2, 1);\r      btnProxy(3, 0);\r      btnProxy(5, 0);      \r      btnProxy(7, 0);\r      btnProxy(8, 0);\r      btnProxy(9, 0);\r         }\r         else{  \r                  onChangeActividad();\r                  onChangePagoTiempo();\r                  focaliza(\"formulario.cbPeriodoDesde\");\r         }\r\r         finCargaPagina = true;              \r }\r\r function fVolver() {\r         window.close();\r}\r \rfunction habilitaCamposC(){\r         accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=false\");\r    accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=false\");\r    accion(\"formulario.txtDiasGracia\", \".disabled=false\");\r}\r \rfunction cargaDatos(){      \r                 set(\"formulario.cbPeriodoDesde\", new Array( get(\"formulario.TempcbPeriodoDesde\") ));\r\r                 set(\"formulario.cbPeriodoHasta\", new Array(get(\"formulario.TempcbPeriodoHasta\")));\r\r                 set(\"formulario.txtPeriodoEsperaParaCalculo\", get(\"formulario.TemptxtPeriodoEsperaParaCalculo\"));\r\r                 set(\"formulario.txtPeriodoEsperaSobreCalculo\", get(\"formulario.TemptxtPeriodoEsperaSobreCalculo\"));\r\r                 set(\"formulario.txtNumMinRecomendadas\", get(\"formulario.TemptxtNumMinRecomendadas\"));      \r\r                 set(\"formulario.txtMontoMinRed\", get(\"formulario.TemptxtMontoMinRed\"));\r\r                 set(\"formulario.txtPedidoMinRed\", get(\"formulario.TemptxtPedidoMinRed\"));\r\r                 set(\"formulario.txtUnidadesMinRed\", get(\"formulario.TemptxtUnidadesMinRed\"));\r\r                 set(\"formulario.txtMontoMinMadre\", get(\"formulario.TemptxtMontoMinMadre\"));   \r           \r                 set(\"formulario.txtPedidoMinMadre\", get(\"formulario.TemptxtPedidoMinMadre\"));\r\r                 set(\"formulario.txtUnidadesMinMadre\", get(\"formulario.TemptxtUnidadesMinMadre\"));    \r           \r                 set(\"formulario.txtMontoMinPedidoHijas\",get(\"formulario.TemptxtMontoMinPedidoHijas\"));\r\r                 set(\"formulario.txtPedidoMinHijas\", get(\"formulario.TemptxtPedidoMinHijas\"));   \r           \r                      set(\"formulario.txtUnidadesMinPedidoHijas\",get(\"formulario.TemptxtUnidadesMinPedidoHijas\"));      \r\r                      set(\"formulario.cbCalculoPremio\", new Array(get(\"formulario.TempcbCalculoPremio\")) );\r\r                      set(\"formulario.txtPorcentajePremioSobreVenta\", get(\"formulario.TemptxtPorcentajePremioSobreVenta\"));\r\r                 set(\"formulario.txtPorcentajePremioSobreCobranza\", get(\"formulario.TemptxtPorcentajePremioSobreCobranza\"));\r\r                      var actividad = get(\"formulario.TempckActividad\");\r      if(actividad == \"true\"){\r           set(\"formulario.ckActividad\", \"S\");\r      }\r\r                      set(\"formulario.txtMontoMinPedidoHijas1\",get(\"formulario.TemptxtMontoMinPedidoHijas1\"));      \r\r                 set(\"formulario.txtUnidadesMinPedidoHijas1\",get(\"formulario.TemptxtUnidadesMinPedidoHijas1\"));      \r\r                      var pago = get(\"formulario.TempckPagoTiempo\");\r      if(pago == \"true\"){\r           set(\"formulario.ckPagoTiempo\", \"S\");\r      }\r\r                 set(\"formulario.cbPeriodoDesdePagoTiempo\", new Array(get(\"formulario.TempcbPeriodoDesdePagoTiempo\")) );\r\r                      set(\"formulario.cbPeriodoHastaPagoTiempo\", new Array(get(\"formulario.TempcbPeriodoHastaPagoTiempo\")) );\r\r                 set(\"formulario.txtDiasGracia\", get(\"formulario.TemptxtDiasGracia\"));           \r\r                      set(\"formulario.oid\", get(\"formulario.oid\"));           \r}\r\rfunction deshabilitaCamposA(){  \r             accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=true\");\r    accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=true\");\r    accion(\"formulario.txtDiasGracia\", \".disabled=true\");  \r} \r\rfunction deshabilitaCamposB(){\r    accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=false\");\r    accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=false\");  \r}\r\rfunction deshabilitaCamposC(){\r         accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=true\");\r         accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=true\");\r         accion(\"formulario.txtDiasGracia\", \".disabled=true\");\r}  \r \rfunction deshabilitaCamposD(){\r    accion(\"formulario.cbPeriodoDesde\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoHasta\", \".disabled=true\");\r    accion(\"formulario.txtPeriodoEsperaParaCalculo\", \".disabled=true\");\r    accion(\"formulario.txtPeriodoEsperaSobreCalculo\", \".disabled=true\");\r    accion(\"formulario.txtNumMinRecomendadas\", \".disabled=true\");     \r    accion(\"formulario.txtMontoMinRed\", \".disabled=true\");\r    accion(\"formulario.txtPedidoMinRed\", \".disabled=true\");\r    accion(\"formulario.txtUnidadesMinRed\", \".disabled=true\");\r    accion(\"formulario.txtMontoMinMadre\", \".disabled=true\");\r    accion(\"formulario.txtPedidoMinMadre\", \".disabled=true\");  \r    accion(\"formulario.txtUnidadesMinMadre\", \".disabled=true\");\r    accion(\"formulario.txtMontoMinPedidoHijas\", \".disabled=true\");\r    accion(\"formulario.txtPedidoMinHijas\", \".disabled=true\");\r    accion(\"formulario.txtUnidadesMinPedidoHijas\", \".disabled=true\");\r    accion(\"formulario.cbCalculoPremio\", \".disabled=true\");  \r    accion(\"formulario.txtPorcentajePremioSobreVenta\", \".disabled=true\");\r    accion(\"formulario.txtPorcentajePremioSobreCobranza\", \".disabled=true\");\r    accion(\"formulario.ckActividad\", \".disabled=true\");\r    accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=true\");\r    accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=true\");  \r    accion(\"formulario.ckPagoTiempo\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=true\");\r    accion(\"formulario.txtDiasGracia\", \".disabled=true\");\r}\r  \rfunction focalizaShTab(){\r         focaliza(\"formulario.txtDiasGracia\");  \r}\r  \rfunction  focalizaTab(){\r         focaliza(\"formulario.cbPeriodoDesde\");\r}  \r  \rfunction onChangeActividad(){      \r         var uno = get(\"formulario.ckActividad\");  \r         if(uno == \"S\"){\r                  accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=false\");\r         accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=false\");\r    }\r         else{            \r             var monMinPedHijas = get(\"formulario.txtMontoMinPedidoHijas1\");\r         \r         if (monMinPedHijas != \"\"){\r                      set(\"formulario.txtMontoMinPedidoHijas1\", \"\");             \r         }            \r                  \r                  accion(\"formulario.txtMontoMinPedidoHijas1\", \".disabled=true\");\r\r      var monUMinPedHijas = get(\"formulario.txtUnidadesMinPedidoHijas1\");\r             \r         if (monUMinPedHijas !=\"\"){\r                           set(\"formulario.txtUnidadesMinPedidoHijas1\", \"\");    \r         }                   \r         \r         accion(\"formulario.txtUnidadesMinPedidoHijas1\", \".disabled=true\"); \r    }\r} \r  \rfunction onChangePagoTiempo(){        \r         var dos = get(\"formulario.ckPagoTiempo\");      \r    if (dos == \"S\"){                \r             accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=false\");\r         accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=false\");\r         accion(\"formulario.txtDiasGracia\", \".disabled=false\");      \r    }\r         else{ 	\r                  var arr = new Array();\r\r                  var cbPeriodoDesdePagoTiempo = get(\"formulario.cbPeriodoDesdePagoTiempo\");\r                  var cbPeriodoHastaPagoTiempo = get(\"formulario.cbPeriodoHastaPagoTiempo\");\r                  \r                  if(cbPeriodoDesdePagoTiempo != \"\"){\r                  \r                           set(\"formulario.cbPeriodoDesdePagoTiempo\", arr);\r                  }\r\r                  if(cbPeriodoHastaPagoTiempo != \"\"){\r                  \r                           set(\"formulario.cbPeriodoHastaPagoTiempo\", arr);\r                  }\r\r                           set(\"formulario.txtDiasGracia\", \"\");	\r                    accion(\"formulario.cbPeriodoDesdePagoTiempo\", \".disabled=true\");\r         accion(\"formulario.cbPeriodoHastaPagoTiempo\", \".disabled=true\");           \r         accion(\"formulario.txtDiasGracia\", \".disabled=true\");           \r         set(\"formulario.deshaCamposCheckPago\", \"si\");\r    }    \r}  \r  \rfunction comprobarDatosObligatorios(){\r                  if((get(\"formulario.cbPeriodoDesde\")!=\"\") && \r            (get(\"formulario.cbPeriodoHasta\")!=\"\") &&\r            (get(\"formulario.txtPeriodoEsperaParaCalculo\")!=\"\") && \r            (get(\"formulario.txtPeriodoEsperaSobreCalculo\")!=\"\") &&\r            (get(\"formulario.txtNumMinRecomendadas\")!=\"\") && \r            (get(\"formulario.cbCalculoPremio\")!=\"\")) {	\r\r                        if(get(\"formulario.ckPagoTiempo\")==\"S\") {\r\r                                                      if((get(\"formulario.cbPeriodoDesdePagoTiempo\")!=\"\") && \r                                  (get(\"formulario.txtDiasGracia\")!=\"\")) {\r\r                                                                        if(get(\"formulario.ckActividad\")==\"S\") {\r\r                                                                                                                                       if((get(\"formulario.txtMontoMinPedidoHijas1\")!=\"\") && 		     (get(\"formulario.txtUnidadesMinPedidoHijas1\")!=\"\")) {\r                                                      return true;\r                                             }\r                                                                                                                                       else {\r                                                      return false;\r                                             }\r                                    }\r                                                                        else {\r                                             return true;\r                                    }\r                           }\r                                                                                 else {\r                                    return false;\r                           }\r            }\r                        else {\r                                                      if(get(\"formulario.ckActividad\")==\"S\") {\r\r                                                                                                            if((get(\"formulario.txtMontoMinPedidoHijas1\")!=\"\") && 		     (get(\"formulario.txtUnidadesMinPedidoHijas1\")!=\"\")) {\r                                                      return true;\r                                    }\r                                                                                                            else {\r                                             return false;\r                                    }\r                           }\r                                                      else {\r                                    return true;\r                           }	\r            }\r         }	\r                  else {\r                  return false;\r         }\r} \r  \rfunction fGuardar(){ \r                  var ckActividad =  get(\"formulario.ckActividad\");\r         var ckPagoTiempo = get(\"formulario.ckPagoTiempo\");    \r\r                  if(!sicc_validaciones_generales('validaNumeros')) {\r                  return;\r         }	\r\r         if(!sicc_validaciones_generales('validaTexto')){\r                  return;	\r         }\r\r         if (ckActividad == \"S\"){     \r                           if(!sicc_validaciones_generales('segunActividad')) {\r                                             return;\r                           }	 \r          }  \r\r         if (ckPagoTiempo == \"S\"){     \r                           if(!sicc_validaciones_generales('segunPagoTiempo')) {\r                                             return;\r                           }	 \r          }  	\r         \r                           tomarValoresCamposPantalla();\r\r                  eval(\"formulario\").oculto= \"S\";\r    set(\"formulario.conectorAction\",\"LPMantenerMultinivel\");\r    set(\"formulario.accion\",\"guardar\");         \r    enviaSICC('formulario','','','N');   \r} \r \rfunction fLimpiar(){\r                  onLoadPag();\r}\r\rfunction onClickPestanyaPaginaMultinivel(valor, form, nombreLP) {\r            var ckActividad =  get(\"formulario.ckActividad\");\r         var ckPagoTiempo = get(\"formulario.ckPagoTiempo\");      \r\r                  if(!sicc_validaciones_generales('validaNumeros')) {\r                  return;\r         }\r\r                  if(!sicc_validaciones_generales('validaTexto')){\r                  return;	\r         }\r\r         if (ckActividad == \"S\"){     \r                           if(!sicc_validaciones_generales('segunActividad')) {\r                                             return;\r                           }	 \r          }  \r\r         if (ckPagoTiempo == \"S\"){     \r                           if(!sicc_validaciones_generales('segunPagoTiempo')) {\r                                             return;\r                           }	 \r          }  	\r\r                           tomarValoresCamposPantalla();	\r         onClickPestanyaHabilitada(valor, form, nombreLP);\r}\r\rfunction tomarValoresCamposPantalla() {\r                  var TempcbPeriodoDesde = get(\"formulario.cbPeriodoDesde\");\r         var TempcbPeriodoHasta = get(\"formulario.cbPeriodoHasta\");\r         var TemptxtPeriodoEsperaParaCalculo = get(\"formulario.txtPeriodoEsperaParaCalculo\");\r         var TemptxtPeriodoEsperaSobreCalculo = get(\"formulario.txtPeriodoEsperaSobreCalculo\");\r         var TemptxtNumMinRecomendadas = get(\"formulario.txtNumMinRecomendadas\");\r         var TemptxtMontoMinRed = get(\"formulario.txtMontoMinRed\");\r         var TemptxtPedidoMinRed = get(\"formulario.txtPedidoMinRed\");\r         var TemptxtUnidadesMinRed = get(\"formulario.txtUnidadesMinRed\");\r         var TemptxtMontoMinMadre = get(\"formulario.txtMontoMinMadre\");\r         var TemptxtPedidoMinMadre = get(\"formulario.txtPedidoMinMadre\");\r         var TemptxtUnidadesMinMadre = get(\"formulario.txtUnidadesMinMadre\");\r         var TemptxtMontoMinPedidoHijas = get(\"formulario.txtMontoMinPedidoHijas\");\r         var TemptxtPedidoMinHijas = get(\"formulario.txtPedidoMinHijas\");\r         var TemptxtUnidadesMinPedidoHijas = get(\"formulario.txtUnidadesMinPedidoHijas\");\r         var TempcbCalculoPremio = get(\"formulario.cbCalculoPremio\");\r         var TemptxtPorcentajePremioSobreVenta = get(\"formulario.txtPorcentajePremioSobreVenta\");\r         var TemptxtPorcentajePremioSobreCobranza = get(\"formulario.txtPorcentajePremioSobreCobranza\");\r         var TempckActividad = get(\"formulario.ckActividad\");\r         var TemptxtMontoMinPedidoHijas1 = get(\"formulario.txtMontoMinPedidoHijas1\");\r         var TemptxtUnidadesMinPedidoHijas1 = get(\"formulario.txtUnidadesMinPedidoHijas1\");\r         var TempckPagoTiempo = get(\"formulario.ckPagoTiempo\");\r         var TempcbPeriodoDesdePagoTiempo = get(\"formulario.cbPeriodoDesdePagoTiempo\");\r         var TempcbPeriodoHastaPagoTiempo = get(\"formulario.cbPeriodoHastaPagoTiempo\");\r         var TemptxtDiasGracia = get(\"formulario.txtDiasGracia\");\r         \r         var datosObligatorios = comprobarDatosObligatorios();\r         var opcionMenu = get(\"formulario.opcionMenu\");\r\r         set(\"formulario.TempcbPeriodoDesde\", TempcbPeriodoDesde);\r         set(\"formulario.TempcbPeriodoHasta\", TempcbPeriodoHasta);\r         set(\"formulario.TemptxtPeriodoEsperaParaCalculo\", TemptxtPeriodoEsperaParaCalculo);\r         set(\"formulario.TemptxtPeriodoEsperaSobreCalculo\", TemptxtPeriodoEsperaSobreCalculo);\r         set(\"formulario.TemptxtNumMinRecomendadas\", TemptxtNumMinRecomendadas);\r         set(\"formulario.TemptxtMontoMinRed\", TemptxtMontoMinRed);\r         set(\"formulario.TemptxtPedidoMinRed\", TemptxtPedidoMinRed);\r         set(\"formulario.TemptxtUnidadesMinRed\", TemptxtUnidadesMinRed);\r         set(\"formulario.TemptxtMontoMinMadre\", TemptxtMontoMinMadre);\r         set(\"formulario.TemptxtPedidoMinMadre\", TemptxtPedidoMinMadre);\r         set(\"formulario.TemptxtUnidadesMinMadre\", TemptxtUnidadesMinMadre);\r         set(\"formulario.TemptxtMontoMinPedidoHijas\", TemptxtMontoMinPedidoHijas);\r         set(\"formulario.TemptxtPedidoMinHijas\", TemptxtPedidoMinHijas);\r         set(\"formulario.TemptxtUnidadesMinPedidoHijas\", TemptxtUnidadesMinPedidoHijas);\r         set(\"formulario.TempcbCalculoPremio\", TempcbCalculoPremio);\r         set(\"formulario.TemptxtPorcentajePremioSobreVenta\", TemptxtPorcentajePremioSobreVenta);\r         set(\"formulario.TemptxtPorcentajePremioSobreCobranza\", TemptxtPorcentajePremioSobreCobranza);\r         set(\"formulario.TempckActividad\", TempckActividad);\r         set(\"formulario.TemptxtMontoMinPedidoHijas1\", TemptxtMontoMinPedidoHijas1);\r         set(\"formulario.TemptxtUnidadesMinPedidoHijas1\", TemptxtUnidadesMinPedidoHijas1);\r         set(\"formulario.TempckPagoTiempo\", TempckPagoTiempo);\r         set(\"formulario.TempcbPeriodoDesdePagoTiempo\", TempcbPeriodoDesdePagoTiempo);\r         set(\"formulario.TempcbPeriodoHastaPagoTiempo\", TempcbPeriodoHastaPagoTiempo);\r         set(\"formulario.TemptxtDiasGracia\", TemptxtDiasGracia);\r\r         set(\"formulario.datosObligatorios\", datosObligatorios);\r         set(\"formulario.opcionMenu\", opcionMenu);\r}\r\rfunction onShTabPeriodoDesde() {\r         if(get(\"formulario.ckPagoTiempo\")==\"S\") {\r                  focaliza(\"formulario.txtDiasGracia\");\r         }\r         else {\r                  focaliza(\"formulario.ckPagoTiempo\");\r         }\r}\r\rfunction OntabPagoTiempo() {\r         if(document.getElementById(\"cbPeriodoDesdePagoTiempo\").disabled == true) {\r                  focaliza(\"formulario.cbPeriodoDesde\");\r         }\r         else {\r                  focaliza(\"formulario.cbPeriodoDesdePagoTiempo\");\r         }	\r}\r \r \r\r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1175" );
      ((Element)v.get(9)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1176" );
      ((Element)v.get(10)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPeriodoEsperaParaCalculo" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("cod","1764" );
      ((Element)v.get(11)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPeriodoEsperaSobreCalculo" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","999" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("cod","1765" );
      ((Element)v.get(12)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumMinRecomendadas" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999999" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("cod","1766" );
      ((Element)v.get(13)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtMontoMinRed" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("format","n" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","9999999.99" );
      ((Element)v.get(14)).setAttribute("cod","1768" );
      ((Element)v.get(14)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtPedidoMinRed" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("format","e" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","9999" );
      ((Element)v.get(15)).setAttribute("cod","1769" );
      ((Element)v.get(15)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtUnidadesMinRed" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("format","e" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","9999" );
      ((Element)v.get(16)).setAttribute("cod","1770" );
      ((Element)v.get(16)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtMontoMinMadre" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("format","n" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","9999999.99" );
      ((Element)v.get(17)).setAttribute("cod","1771" );
      ((Element)v.get(17)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtPedidoMinMadre" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("format","e" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","9999" );
      ((Element)v.get(18)).setAttribute("cod","1772" );
      ((Element)v.get(18)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtUnidadesMinMadre" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("format","e" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","9999" );
      ((Element)v.get(19)).setAttribute("cod","1773" );
      ((Element)v.get(19)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtMontoMinPedidoHijas" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("format","n" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","9999999.99" );
      ((Element)v.get(20)).setAttribute("cod","2610" );
      ((Element)v.get(20)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","txtPedidoMinHijas" );
      ((Element)v.get(21)).setAttribute("required","false" );
      ((Element)v.get(21)).setAttribute("format","e" );
      ((Element)v.get(21)).setAttribute("min","0" );
      ((Element)v.get(21)).setAttribute("max","9999" );
      ((Element)v.get(21)).setAttribute("cod","1775" );
      ((Element)v.get(21)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","txtUnidadesMinPedidoHijas" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("format","e" );
      ((Element)v.get(22)).setAttribute("min","0" );
      ((Element)v.get(22)).setAttribute("max","9999" );
      ((Element)v.get(22)).setAttribute("cod","1776" );
      ((Element)v.get(22)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbCalculoPremio" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","1799" );
      ((Element)v.get(23)).setAttribute("group","validaTexto" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","txtPorcentajePremioSobreVenta" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("format","n" );
      ((Element)v.get(24)).setAttribute("min","0" );
      ((Element)v.get(24)).setAttribute("max","999.99" );
      ((Element)v.get(24)).setAttribute("cod","1845" );
      ((Element)v.get(24)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","txtPorcentajePremioSobreCobranza" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("format","n" );
      ((Element)v.get(25)).setAttribute("min","0" );
      ((Element)v.get(25)).setAttribute("max","999.99" );
      ((Element)v.get(25)).setAttribute("cod","2583" );
      ((Element)v.get(25)).setAttribute("group","validaNumeros" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","txtMontoMinPedidoHijas1" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("format","n" );
      ((Element)v.get(26)).setAttribute("min","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(26)).setAttribute("max","9999999.99" );
      ((Element)v.get(26)).setAttribute("cod","1807" );
      ((Element)v.get(26)).setAttribute("group","segunActividad" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","txtUnidadesMinPedidoHijas1" );
      ((Element)v.get(27)).setAttribute("required","true" );
      ((Element)v.get(27)).setAttribute("format","e" );
      ((Element)v.get(27)).setAttribute("min","0" );
      ((Element)v.get(27)).setAttribute("max","9999" );
      ((Element)v.get(27)).setAttribute("cod","1808" );
      ((Element)v.get(27)).setAttribute("group","segunActividad" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbPeriodoDesdePagoTiempo" );
      ((Element)v.get(28)).setAttribute("required","true" );
      ((Element)v.get(28)).setAttribute("cod","1809" );
      ((Element)v.get(28)).setAttribute("group","segunPagoTiempo" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","txtDiasGracia" );
      ((Element)v.get(29)).setAttribute("required","true" );
      ((Element)v.get(29)).setAttribute("format","e" );
      ((Element)v.get(29)).setAttribute("min","0" );
      ((Element)v.get(29)).setAttribute("max","999" );
      ((Element)v.get(29)).setAttribute("cod","1645" );
      ((Element)v.get(29)).setAttribute("group","segunPagoTiempo" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:8   */

      /* Empieza nodo:30 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(30)).setAttribute("nombre","formulario" );
      ((Element)v.get(30)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","TempcbPeriodoDesde" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","TempcbPeriodoHasta" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","TemptxtPeriodoEsperaParaCalculo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","TemptxtPeriodoEsperaSobreCalculo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","TemptxtNumMinRecomendadas" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","TemptxtMontoMinRed" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","TemptxtPedidoMinRed" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","TemptxtUnidadesMinRed" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","TemptxtMontoMinMadre" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","TemptxtPedidoMinMadre" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","TemptxtUnidadesMinMadre" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","TemptxtMontoMinPedidoHijas" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","TemptxtPedidoMinHijas" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","TemptxtUnidadesMinPedidoHijas" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","TempcbCalculoPremio" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","TemptxtPorcentajePremioSobreVenta" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","TemptxtPorcentajePremioSobreCobranza" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","TempckActividad" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","TemptxtMontoMinPedidoHijas1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","TemptxtUnidadesMinPedidoHijas1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","TempckPagoTiempo" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","TempcbPeriodoDesdePagoTiempo" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","TempcbPeriodoHastaPagoTiempo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","TemptxtDiasGracia" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","accion" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hPais" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","campos" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","deshaCampos" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","deshaCamposCheck" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","deshaCamposCheckPago" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 30   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","deshaCamposEditables" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hdatosObligatorios" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","oid" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hOidPerDesde" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hOidCbPeriodoHasta" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hTxtPeriodosParaCalculo" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hTxtPeriodosSobreCalculo" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hTxtNumerominimoRecomendadas" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hTxtMontoMinimoRed" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hTxtPedidosMinimosRed" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hTxtUnidadesMinimasRed" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hTxtMontoMinimoMadre" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hTxtPedidosMinimosMadre" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hTxtUnidadesMinimasMadre" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hTxtMontoMinimoPedidoPorHijas" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hTxtMontoMinimoPedidoHijas" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hTxtPedidosMinimosHijas" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hTxtUnidadesMinimasHijas" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hTxtUnidadesMinimasPedidosHijas" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hOidCalculoPremio" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hTxtPorcentajeSobreVenta" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hTxtPorcentajeSobreCobranza" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hChkActividad" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hChkPagoTiempo" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hOidPeriodoATiempoDesde" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hOidPeriodoATiempoHasta" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hTxtDiasGracia" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","txtMminPedHijas" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hUnidadesPedidoHijas" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hPedMinHijas" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hMontoPedidoHijas" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("height","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("class","menu4" );
      ((Element)v.get(30)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","30" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","92" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","75" );
      ((Element)v.get(116)).setAttribute("border","1" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellpadding","1" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(116)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(116)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(1,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(119)).setAttribute("cod","00393" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:120 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","20" );
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","75" );
      ((Element)v.get(123)).setAttribute("border","1" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","1" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(123)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(123)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(5,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(126)).setAttribute("cod","0094" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:127 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","10" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(129)).setAttribute("width","20" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","75" );
      ((Element)v.get(130)).setAttribute("border","1" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cellpadding","1" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(130)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(130)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(6,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(133)).setAttribute("cod","00394" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","10" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","20" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","75" );
      ((Element)v.get(137)).setAttribute("border","1" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellpadding","1" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(137)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(137)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(7,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(140)).setAttribute("cod","00395" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:141 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","20" );
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","75" );
      ((Element)v.get(144)).setAttribute("border","1" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cellpadding","1" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(144)).setAttribute("bgcolor","" );
      ((Element)v.get(144)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(144)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(4,'formulario','LPMantenerMultinivel');" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(147)).setAttribute("cod","00396" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:148 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","10" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","10" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","20" );
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("table"));
      ((Element)v.get(151)).setAttribute("width","75" );
      ((Element)v.get(151)).setAttribute("border","1" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("cellpadding","1" );
      ((Element)v.get(151)).setAttribute("cellspacing","0" );
      ((Element)v.get(151)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(151)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(151)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(8,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(154)).setAttribute("cod","00397" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:155 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","16" );
      ((Element)v.get(155)).setAttribute("class","menu5texto" );
      ((Element)v.get(108)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:157 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(157)).setAttribute("height","100%" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("class","menu4" );
      ((Element)v.get(30)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(159)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","30" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(161)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(163)).setAttribute("width","10" );
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(163)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","10" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","70" );
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(166)).setAttribute("width","75" );
      ((Element)v.get(166)).setAttribute("border","1" );
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("cellpadding","1" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(166)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblAmbitoGeografico');" );
      ((Element)v.get(166)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(3,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(169)).setAttribute("cod","2801" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:170 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","10" );
      ((Element)v.get(170)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(170)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","10" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","70" );
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","75" );
      ((Element)v.get(173)).setAttribute("border","1" );
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("cellpadding","1" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(173)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(173)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(9,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(176)).setAttribute("cod","00398" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:177 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","10" );
      ((Element)v.get(177)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","10" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","20" );
      ((Element)v.get(179)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).setAttribute("class","menu5texto" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(158)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("table"));
      ((Element)v.get(180)).setAttribute("width","75" );
      ((Element)v.get(180)).setAttribute("border","1" );
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("cellpadding","1" );
      ((Element)v.get(180)).setAttribute("cellspacing","0" );
      ((Element)v.get(180)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(180)).setAttribute("onmouseover","activarPuntero('formulario',10,'lblGerentes');" );
      ((Element)v.get(180)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(10,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(183)).setAttribute("cod","00399" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:184 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("width","10" );
      ((Element)v.get(184)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","10" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","20" );
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","75" );
      ((Element)v.get(187)).setAttribute("border","1" );
      ((Element)v.get(187)).setAttribute("align","center" );
      ((Element)v.get(187)).setAttribute("cellpadding","1" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(187)).setAttribute("onmouseover","activarPuntero('formulario',11,'lblConsultoras');" );
      ((Element)v.get(187)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(11,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(190)).setAttribute("cod","00401" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:191 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","10" );
      ((Element)v.get(191)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","10" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","20" );
      ((Element)v.get(193)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(193)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("table"));
      ((Element)v.get(194)).setAttribute("width","75" );
      ((Element)v.get(194)).setAttribute("border","1" );
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("cellpadding","1" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(194)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(194)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblProgramaNuevas');" );
      ((Element)v.get(194)).setAttribute("onclick","onClickPestanyaPaginaMultinivel(2,'formulario','LPMantenerMultinivel');" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).setAttribute("align","center" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(197)).setAttribute("cod","00590" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:198 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("width","10" );
      ((Element)v.get(198)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","10" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","20" );
      ((Element)v.get(200)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(200)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","75" );
      ((Element)v.get(201)).setAttribute("border","1" );
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("cellpadding","1" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(201)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(201)).setAttribute("onmouseover","" );
      ((Element)v.get(201)).setAttribute("onclick","" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(204)).setAttribute("alto","13" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("valor","" );
      ((Element)v.get(204)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(204)).setAttribute("cod","00400" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:205 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","16" );
      ((Element)v.get(205)).setAttribute("class","menu5texto" );
      ((Element)v.get(158)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:207 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(209)).setAttribute("align","center" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("height","12" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","750" );
      ((Element)v.get(208)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("width","12" );
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(214)).setAttribute("height","1" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:208   */

      /* Empieza nodo:215 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(220)).setAttribute("class","legend" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblParametrosMultinivel" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","legend" );
      ((Element)v.get(221)).setAttribute("cod","00332" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("table"));
      ((Element)v.get(225)).setAttribute("width","575" );
      ((Element)v.get(225)).setAttribute("border","0" );
      ((Element)v.get(225)).setAttribute("align","left" );
      ((Element)v.get(225)).setAttribute("cellspacing","0" );
      ((Element)v.get(225)).setAttribute("cellpadding","0" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

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

      /* Empieza nodo:229 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","1175" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("id","datosTitle" );
      ((Element)v.get(237)).setAttribute("cod","1176" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblPeriodoEsperaParaCalculo" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","1764" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblPeriodoEsperaSobreCalculo" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","1765" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","100%" );
      ((Element)v.get(229)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:229   */

      /* Empieza nodo:248 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(252)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("size","1" );
      ((Element)v.get(252)).setAttribute("multiple","N" );
      ((Element)v.get(252)).setAttribute("req","S" );
      ((Element)v.get(252)).setAttribute("valorinicial","" );
      ((Element)v.get(252)).setAttribute("textoinicial","" );
      ((Element)v.get(252)).setAttribute("onshtab","onShTabPeriodoDesde();" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:254 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(248)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(257)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("size","1" );
      ((Element)v.get(257)).setAttribute("multiple","N" );
      ((Element)v.get(257)).setAttribute("req","S" );
      ((Element)v.get(257)).setAttribute("valorinicial","" );
      ((Element)v.get(257)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(248)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(262)).setAttribute("nombre","txtPeriodoEsperaParaCalculo" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).setAttribute("max","3" );
      ((Element)v.get(262)).setAttribute("tipo","" );
      ((Element)v.get(262)).setAttribute("onchange","" );
      ((Element)v.get(262)).setAttribute("req","S" );
      ((Element)v.get(262)).setAttribute("size","3" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("validacion","" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","25" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(248)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(266)).setAttribute("nombre","txtPeriodoEsperaSobreCalculo" );
      ((Element)v.get(266)).setAttribute("id","datosCampos" );
      ((Element)v.get(266)).setAttribute("max","3" );
      ((Element)v.get(266)).setAttribute("tipo","" );
      ((Element)v.get(266)).setAttribute("onchange","" );
      ((Element)v.get(266)).setAttribute("req","S" );
      ((Element)v.get(266)).setAttribute("size","3" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("validacion","" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(248)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:248   */

      /* Empieza nodo:269 / Elemento padre: 225   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(225)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("colspan","4" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:272 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("table"));
      ((Element)v.get(274)).setAttribute("width","575" );
      ((Element)v.get(274)).setAttribute("border","0" );
      ((Element)v.get(274)).setAttribute("align","left" );
      ((Element)v.get(274)).setAttribute("cellspacing","0" );
      ((Element)v.get(274)).setAttribute("cellpadding","0" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblNumMinRecomendadas" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","1766" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblMontoMinRed" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","1768" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblPedidoMinRed" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("id","datosTitle" );
      ((Element)v.get(287)).setAttribute("cod","1769" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblUnidadesMinRed" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","1770" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(275)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:275   */

      /* Empieza nodo:294 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(294));

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
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(298)).setAttribute("nombre","txtNumMinRecomendadas" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("max","7" );
      ((Element)v.get(298)).setAttribute("tipo","" );
      ((Element)v.get(298)).setAttribute("onchange","" );
      ((Element)v.get(298)).setAttribute("req","S" );
      ((Element)v.get(298)).setAttribute("size","9" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("validacion","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 294   */
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
      ((Element)v.get(301)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(294)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(302)).setAttribute("nombre","txtMontoMinRed" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("max","12" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(302)).setAttribute("tipo","" );
      ((Element)v.get(302)).setAttribute("onchange","" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("size","15" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("validacion","" );
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
      ((Element)v.get(305)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(294)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(306)).setAttribute("nombre","txtPedidoMinRed" );
      ((Element)v.get(306)).setAttribute("id","datosCampos" );
      ((Element)v.get(306)).setAttribute("max","5" );
      ((Element)v.get(306)).setAttribute("tipo","" );
      ((Element)v.get(306)).setAttribute("onchange","" );
      ((Element)v.get(306)).setAttribute("req","N" );
      ((Element)v.get(306)).setAttribute("size","7" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("validacion","" );
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
      ((Element)v.get(309)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(294)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(310)).setAttribute("nombre","txtUnidadesMinRed" );
      ((Element)v.get(310)).setAttribute("id","datosCampos" );
      ((Element)v.get(310)).setAttribute("max","5" );
      ((Element)v.get(310)).setAttribute("tipo","" );
      ((Element)v.get(310)).setAttribute("onchange","" );
      ((Element)v.get(310)).setAttribute("req","N" );
      ((Element)v.get(310)).setAttribute("size","7" );
      ((Element)v.get(310)).setAttribute("valor","" );
      ((Element)v.get(310)).setAttribute("validacion","" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:294   */

      /* Empieza nodo:313 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("colspan","4" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:316 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("table"));
      ((Element)v.get(318)).setAttribute("width","575" );
      ((Element)v.get(318)).setAttribute("border","0" );
      ((Element)v.get(318)).setAttribute("align","left" );
      ((Element)v.get(318)).setAttribute("cellspacing","0" );
      ((Element)v.get(318)).setAttribute("cellpadding","0" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(323)).setAttribute("nombre","lblMontoMinMadre" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","1771" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblPedidoMinMadre" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","1772" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","25" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblUnidadesMinMadre" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("valor","" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("cod","1773" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:319   */

      /* Empieza nodo:334 / Elemento padre: 318   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(318)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(338)).setAttribute("nombre","txtMontoMinMadre" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(338)).setAttribute("max","12" );
      ((Element)v.get(338)).setAttribute("tipo","" );
      ((Element)v.get(338)).setAttribute("onchange","" );
      ((Element)v.get(338)).setAttribute("req","N" );
      ((Element)v.get(338)).setAttribute("size","15" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("validacion","" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(342)).setAttribute("nombre","txtPedidoMinMadre" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("max","5" );
      ((Element)v.get(342)).setAttribute("tipo","" );
      ((Element)v.get(342)).setAttribute("onchange","" );
      ((Element)v.get(342)).setAttribute("req","N" );
      ((Element)v.get(342)).setAttribute("size","7" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(346)).setAttribute("nombre","txtUnidadesMinMadre" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(346)).setAttribute("max","5" );
      ((Element)v.get(346)).setAttribute("tipo","" );
      ((Element)v.get(346)).setAttribute("onchange","" );
      ((Element)v.get(346)).setAttribute("req","N" );
      ((Element)v.get(346)).setAttribute("size","7" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("validacion","" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:334   */

      /* Empieza nodo:349 / Elemento padre: 318   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(318)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("colspan","4" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:352 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("width","575" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblMontoMinPedidoHijas" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","2610" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblPedidoMinHijas" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("valor","" );
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","1775" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","25" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(367)).setAttribute("nombre","lblUnidadesMinPedidoHijas" );
      ((Element)v.get(367)).setAttribute("alto","13" );
      ((Element)v.get(367)).setAttribute("filas","1" );
      ((Element)v.get(367)).setAttribute("valor","" );
      ((Element)v.get(367)).setAttribute("id","datosTitle" );
      ((Element)v.get(367)).setAttribute("cod","1776" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(355)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:355   */

      /* Empieza nodo:370 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(374)).setAttribute("nombre","txtMontoMinPedidoHijas" );
      ((Element)v.get(374)).setAttribute("id","datosCampos" );
      ((Element)v.get(374)).setAttribute("max","12" );
      ((Element)v.get(374)).setAttribute("tipo","" );
      ((Element)v.get(374)).setAttribute("onchange","" );
      ((Element)v.get(374)).setAttribute("req","N" );
      ((Element)v.get(374)).setAttribute("size","15" );
      ((Element)v.get(374)).setAttribute("valor","" );
      ((Element)v.get(374)).setAttribute("validacion","" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","25" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(378)).setAttribute("nombre","txtPedidoMinHijas" );
      ((Element)v.get(378)).setAttribute("id","datosCampos" );
      ((Element)v.get(378)).setAttribute("max","4" );
      ((Element)v.get(378)).setAttribute("tipo","" );
      ((Element)v.get(378)).setAttribute("onchange","" );
      ((Element)v.get(378)).setAttribute("req","N" );
      ((Element)v.get(378)).setAttribute("size","6" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("validacion","" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(370)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(382)).setAttribute("nombre","txtUnidadesMinPedidoHijas" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("max","4" );
      ((Element)v.get(382)).setAttribute("tipo","" );
      ((Element)v.get(382)).setAttribute("onchange","" );
      ((Element)v.get(382)).setAttribute("req","N" );
      ((Element)v.get(382)).setAttribute("size","6" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("validacion","" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 370   */
      v.add(doc.createElement("td"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(370)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:370   */

      /* Empieza nodo:385 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("colspan","4" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:388 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("table"));
      ((Element)v.get(390)).setAttribute("width","575" );
      ((Element)v.get(390)).setAttribute("border","0" );
      ((Element)v.get(390)).setAttribute("align","left" );
      ((Element)v.get(390)).setAttribute("cellspacing","0" );
      ((Element)v.get(390)).setAttribute("cellpadding","0" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblCalculoPremio" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","1799" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("colspan","3" );
      ((Element)v.get(391)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblPorcentajePremioSobreVenta" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","1845" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("colspan","3" );
      ((Element)v.get(391)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(403)).setAttribute("nombre","lblPorcentajePremioSobreCobranza" );
      ((Element)v.get(403)).setAttribute("alto","13" );
      ((Element)v.get(403)).setAttribute("filas","1" );
      ((Element)v.get(403)).setAttribute("valor","" );
      ((Element)v.get(403)).setAttribute("id","datosTitle" );
      ((Element)v.get(403)).setAttribute("cod","2583" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(391)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:391   */

      /* Empieza nodo:406 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(410)).setAttribute("nombre","cbCalculoPremio" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("size","1" );
      ((Element)v.get(410)).setAttribute("multiple","N" );
      ((Element)v.get(410)).setAttribute("req","S" );
      ((Element)v.get(410)).setAttribute("valorinicial","" );
      ((Element)v.get(410)).setAttribute("textoinicial","" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(415)).setAttribute("nombre","txtPorcentajePremioSobreVenta" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("max","6" );
      ((Element)v.get(415)).setAttribute("tipo","" );
      ((Element)v.get(415)).setAttribute("onchange","" );
      ((Element)v.get(415)).setAttribute("req","N" );
      ((Element)v.get(415)).setAttribute("size","8" );
      ((Element)v.get(415)).setAttribute("valor","" );
      ((Element)v.get(415)).setAttribute("validacion","" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("class","datosCampos" );
      ((Element)v.get(406)).appendChild((Element)v.get(416));

      /* Elemento padre:416 / Elemento actual: 417   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(416)).appendChild((Text)v.get(417));

      /* Termina nodo Texto:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","80" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","25" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(423)).setAttribute("nombre","txtPorcentajePremioSobreCobranza" );
      ((Element)v.get(423)).setAttribute("id","datosCampos" );
      ((Element)v.get(423)).setAttribute("max","6" );
      ((Element)v.get(423)).setAttribute("tipo","" );
      ((Element)v.get(423)).setAttribute("onchange","" );
      ((Element)v.get(423)).setAttribute("req","N" );
      ((Element)v.get(423)).setAttribute("size","8" );
      ((Element)v.get(423)).setAttribute("valor","" );
      ((Element)v.get(423)).setAttribute("validacion","" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("class","datosCampos" );
      ((Element)v.get(406)).appendChild((Element)v.get(424));

      /* Elemento padre:424 / Elemento actual: 425   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(424)).appendChild((Text)v.get(425));

      /* Termina nodo Texto:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","100" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 406   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:406   */

      /* Empieza nodo:430 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("colspan","4" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:222   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:433 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:215   */

      /* Empieza nodo:435 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).setAttribute("colspan","4" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","12" );
      ((Element)v.get(437)).setAttribute("height","15" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(443)).setAttribute("class","legend" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(444)).setAttribute("nombre","lblDatosAdicionales" );
      ((Element)v.get(444)).setAttribute("alto","13" );
      ((Element)v.get(444)).setAttribute("filas","1" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(444)).setAttribute("id","legend" );
      ((Element)v.get(444)).setAttribute("cod","0052" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 442   */
      v.add(doc.createElement("table"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(445)).setAttribute("border","0" );
      ((Element)v.get(445)).setAttribute("align","center" );
      ((Element)v.get(445)).setAttribute("cellspacing","0" );
      ((Element)v.get(445)).setAttribute("cellpadding","0" );
      ((Element)v.get(442)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("table"));
      ((Element)v.get(448)).setAttribute("width","575" );
      ((Element)v.get(448)).setAttribute("border","0" );
      ((Element)v.get(448)).setAttribute("align","left" );
      ((Element)v.get(448)).setAttribute("cellspacing","0" );
      ((Element)v.get(448)).setAttribute("cellpadding","0" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("colspan","4" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:452 / Elemento padre: 448   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(448)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(456)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(456)).setAttribute("alto","13" );
      ((Element)v.get(456)).setAttribute("filas","1" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(456)).setAttribute("id","datosTitle" );
      ((Element)v.get(456)).setAttribute("cod","173" );
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
      ((Element)v.get(452)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(460)).setAttribute("nombre","lblMontoMinPedidoHijas1" );
      ((Element)v.get(460)).setAttribute("alto","13" );
      ((Element)v.get(460)).setAttribute("filas","1" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(460)).setAttribute("id","datosTitle" );
      ((Element)v.get(460)).setAttribute("cod","1807" );
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
      ((Element)v.get(452)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(464)).setAttribute("nombre","lblUnidadesMinPedidoHijas1" );
      ((Element)v.get(464)).setAttribute("alto","13" );
      ((Element)v.get(464)).setAttribute("filas","1" );
      ((Element)v.get(464)).setAttribute("valor","" );
      ((Element)v.get(464)).setAttribute("id","datosTitle" );
      ((Element)v.get(464)).setAttribute("cod","1808" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","100%" );
      ((Element)v.get(452)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","112" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:452   */

      /* Empieza nodo:467 / Elemento padre: 448   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(448)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("valign","bottom" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(471)).setAttribute("nombre","ckActividad" );
      ((Element)v.get(471)).setAttribute("id","datosCampos" );
      ((Element)v.get(471)).setAttribute("onclick","onChangeActividad();" );
      ((Element)v.get(471)).setAttribute("check","N" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","25" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(467)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(475)).setAttribute("nombre","txtMontoMinPedidoHijas1" );
      ((Element)v.get(475)).setAttribute("id","datosCampos" );
      ((Element)v.get(475)).setAttribute("max","12" );
      ((Element)v.get(475)).setAttribute("tipo","" );
      ((Element)v.get(475)).setAttribute("onchange","" );
      ((Element)v.get(475)).setAttribute("req","S" );
      ((Element)v.get(475)).setAttribute("size","15" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(475)).setAttribute("valor","" );
      ((Element)v.get(475)).setAttribute("validacion","" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","25" );
      ((Element)v.get(477)).setAttribute("height","8" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(467)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(479)).setAttribute("nombre","txtUnidadesMinPedidoHijas1" );
      ((Element)v.get(479)).setAttribute("id","datosCampos" );
      ((Element)v.get(479)).setAttribute("max","5" );
      ((Element)v.get(479)).setAttribute("tipo","" );
      ((Element)v.get(479)).setAttribute("onchange","" );
      ((Element)v.get(479)).setAttribute("req","S" );
      ((Element)v.get(479)).setAttribute("size","7" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(479)).setAttribute("validacion","" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("width","100%" );
      ((Element)v.get(467)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","112" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:467   */

      /* Empieza nodo:482 / Elemento padre: 448   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(448)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).setAttribute("colspan","4" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:485 / Elemento padre: 445   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(445)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("table"));
      ((Element)v.get(487)).setAttribute("width","575" );
      ((Element)v.get(487)).setAttribute("border","0" );
      ((Element)v.get(487)).setAttribute("align","left" );
      ((Element)v.get(487)).setAttribute("cellspacing","0" );
      ((Element)v.get(487)).setAttribute("cellpadding","0" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(492)).setAttribute("nombre","lblPagoTiempo" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("cod","1644" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","25" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblPeridoDesdePagoTiempo" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","1809" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(488)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblPeriodoHastaPagoTiempo" );
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("id","datosTitle" );
      ((Element)v.get(500)).setAttribute("cod","1810" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblDiasGracia" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","1645" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 488   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("width","100%" );
      ((Element)v.get(488)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","112" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:488   */

      /* Empieza nodo:507 / Elemento padre: 487   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(487)).appendChild((Element)v.get(507));

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
      ((Element)v.get(510)).setAttribute("valign","bottom" );
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(511)).setAttribute("nombre","ckPagoTiempo" );
      ((Element)v.get(511)).setAttribute("id","datosCampos" );
      ((Element)v.get(511)).setAttribute("onclick","onChangePagoTiempo();" );
      ((Element)v.get(511)).setAttribute("check","N" );
      ((Element)v.get(511)).setAttribute("ontab","OntabPagoTiempo();" );
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
      ((Element)v.get(515)).setAttribute("nombre","cbPeriodoDesdePagoTiempo" );
      ((Element)v.get(515)).setAttribute("id","datosCampos" );
      ((Element)v.get(515)).setAttribute("size","1" );
      ((Element)v.get(515)).setAttribute("multiple","N" );
      ((Element)v.get(515)).setAttribute("req","S" );
      ((Element)v.get(515)).setAttribute("valorinicial","" );
      ((Element)v.get(515)).setAttribute("textoinicial","" );
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
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(519)).setAttribute("valign","bottom" );
      ((Element)v.get(507)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(520)).setAttribute("nombre","cbPeriodoHastaPagoTiempo" );
      ((Element)v.get(520)).setAttribute("id","datosCampos" );
      ((Element)v.get(520)).setAttribute("size","1" );
      ((Element)v.get(520)).setAttribute("multiple","N" );
      ((Element)v.get(520)).setAttribute("req","N" );
      ((Element)v.get(520)).setAttribute("valorinicial","" );
      ((Element)v.get(520)).setAttribute("textoinicial","" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:522 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","25" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(524)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(525)).setAttribute("nombre","txtDiasGracia" );
      ((Element)v.get(525)).setAttribute("id","datosCampos" );
      ((Element)v.get(525)).setAttribute("max","3" );
      ((Element)v.get(525)).setAttribute("tipo","" );
      ((Element)v.get(525)).setAttribute("onchange","" );
      ((Element)v.get(525)).setAttribute("req","S" );
      ((Element)v.get(525)).setAttribute("size","5" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("validacion","" );
      ((Element)v.get(525)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("width","100%" );
      ((Element)v.get(507)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","112" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:507   */

      /* Empieza nodo:528 / Elemento padre: 487   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(487)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("colspan","4" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:445   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:531 / Elemento padre: 438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:438   */

      /* Empieza nodo:533 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).setAttribute("width","12" );
      ((Element)v.get(534)).setAttribute("align","center" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","12" );
      ((Element)v.get(535)).setAttribute("height","12" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("width","756" );
      ((Element)v.get(533)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(533)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(539)).setAttribute("height","1" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:533   */
      /* Termina nodo:207   */
      /* Termina nodo:30   */


   }

}
