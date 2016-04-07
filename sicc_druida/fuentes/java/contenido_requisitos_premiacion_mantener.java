
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_requisitos_premiacion_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_requisitos_premiacion_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
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
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag() {\r         configurarMenuSecundario(\"formulario\");\r         \r		  	\r         \r		 		 		 		 recargaCombo('formulario.cbValidaDeuda', 'INCValidaDeuda','es.indra.sicc.util.DTOBelcorp',[['oidIdioma','1']],'recargaLineas(datos)');		 	\r		 setearValoresCamposPantalla();	\r		 onChangePasarPedidoPeriodoPremiacion();\r         onChangePagoTiempo();	\r		 \r\r  var opcionMenu = get(\"formulario.opcionMenu\"); \r\r         if(opcionMenu==\"Consultar Concurso\") {\r                  document.getElementById(\"txtMontoMinConcurso\").disabled = true;\r                  document.getElementById(\"txtNumPedidos\").disabled = true;\r                  document.getElementById(\"txtCuotaMinIngreso\").disabled = true;\r                  document.getElementById(\"ckPasarPedido\").disabled = true;\r                  document.getElementById(\"txtMontoMinPedido\").disabled = true;\r                  document.getElementById(\"ckPagoTiempo\").disabled = true;\r                  document.getElementById(\"txtDiasGracia\").disabled = true;\r                  document.getElementById(\"cbPeriodoDesde\").disabled = true;\r                  document.getElementById(\"cbPeriodoHasta\").disabled = true; \r				  				  document.getElementById(\"cbValidaDeuda\").disabled = true;  \r				  document.getElementById(\"txtNumeroPedidoEspera\").disabled = true;  \r				  document.getElementById(\"cbPromedioMaximoAsignacion\").disabled = true;  \r                                            btnProxy(1, 0);\r                  btnProxy(2, 1);\r             btnProxy(3, 0);\r                  btnProxy(5, 0);\r             btnProxy(7, 0);\r                  btnProxy(8, 0);\r             btnProxy(9, 0);    \r         }	\r         else if(opcionMenu==\"Modificar Concurso\") {\r                  btnProxy(2,'1');\r                  btnProxy(3,'0');\r                  btnProxy(7,'0');\r                  btnProxy(8,'0');\r                  btnProxy(9,'0');				  \r				  \r\r         }\r         else {\r                  focoMontoConcurso();\r         }\r\r         finCargaPagina = true;\r}\rfunction recargaLineas(datos){\r	 var opcionMenu = get(\"formulario.opcionMenu\"); \r    seteo = cargaArray(datos);\r	var validaDeud =	get(\"formulario.validaDeuda\");\r    var validaDeudaDescrip =  get('formulario.validaDeudaDescrip');\r	if(opcionMenu==\"Consultar Concurso\") {\r	   	   	   set_combo(\"formulario.cbValidaDeuda\", [[validaDeud,validaDeudaDescrip]]);\r	}  else if(opcionMenu==\"Modificar Concurso\") {\r	   	   	   var arrayValidaDeuda = new Array();\r       arrayValidaDeuda[0] = validaDeud;\r	   set_combo('formulario.cbValidaDeuda', seteo);\r       set(\"formulario.cbValidaDeuda\", arrayValidaDeuda);\r	}\r	if(opcionMenu!=\"Consultar Concurso\" && opcionMenu!=\"Modificar Concurso\"){\r		  if(validaDeud == \"\" && validaDeudaDescrip == \"\"){	\r			set_combo('formulario.cbValidaDeuda', seteo);\r          } else{\r				 var arrayValidaDeuda = new Array();\r				 arrayValidaDeuda[0] = validaDeud;\r				 set_combo('formulario.cbValidaDeuda', seteo);\r				 set(\"formulario.cbValidaDeuda\", arrayValidaDeuda);\r		  }\r	}\r}\rfunction cargaArray(datos){\r     var seteo = new Array(datos.length + 1);\r    seteo[0] = ['' , 'No Se Valida Deuda'];\r    for(i = 0; i < datos.length; i++){\r      seteo[i+1] = [ datos[i][0], datos[i][1] ]\r    }\r    return seteo;\r}\r\r\rfunction fVolver() {\r         window.close();\r}\r\rfunction setearValoresCamposPantalla() {\r         var oidRequisitosPremiacion = get(\"formulario.oidRequisitosPremiacion\");\r         var montoMinimoConcurso = get(\"formulario.montoMinimoConcurso\");\r         var numeroPedidos = get(\"formulario.numeroPedidos\");\r         var cuotaMinimaIngreso = get(\"formulario.cuotaMinimaIngreso\");\r         var pasarPedidosPeriodoPremiacion = get(\"formulario.pasarPedidosPeriodoPremiacion\");\r         var montoMinimoPedido = get(\"formulario.montoMinimoPedido\");\r         var pagoTiempo = get(\"formulario.pagoTiempo\");\r         var diasGracia = get(\"formulario.diasGracia\");\r         var periodoDesde = get(\"formulario.periodoDesde\");\r         var periodoHasta = get(\"formulario.periodoHasta\");\r		 var validaDeud =	get(\"formulario.validaDeuda\");\r		 var validaDeudaDescrip =  get('formulario.validaDeudaDescrip');\r		 var numPerEspera = get(\"formulario.numPerioEspera\");\r		 var perioMaximo =  get(\"formulario.perioMax\");\r		 var perioMaxDes =    get(\"formulario.perioMaxDes\");		 \r		 \r         set(\"formulario.oidRequisitosPremiacion\", oidRequisitosPremiacion);\r         set(\"formulario.txtMontoMinConcurso\", montoMinimoConcurso);\r         set(\"formulario.txtNumPedidos\", numeroPedidos);\r         set(\"formulario.txtCuotaMinIngreso\", cuotaMinimaIngreso);\r		\r         if(pasarPedidosPeriodoPremiacion==\"true\") set(\"formulario.ckPasarPedido\", \"S\");\r         if(pasarPedidosPeriodoPremiacion==\"false\") set(\"formulario.ckPasarPedido\", \"N\");\r         \r         set(\"formulario.txtMontoMinPedido\", montoMinimoPedido);\r\r         if(pagoTiempo==\"true\") set(\"formulario.ckPagoTiempo\", \"S\");\r         if(pagoTiempo==\"false\") set(\"formulario.ckPagoTiempo\", \"N\");\r\r         set(\"formulario.txtDiasGracia\", diasGracia);\r\r         var arraySeteoDesde = new Array();\r         arraySeteoDesde[0] = periodoDesde;\r         set(\"formulario.cbPeriodoDesde\", arraySeteoDesde);\r\r         var arraySeteoHasta = new Array();\r         arraySeteoHasta[0] = periodoHasta;\r         set(\"formulario.cbPeriodoHasta\", arraySeteoHasta);\r		 var arrayValidaDeuda = new Array();\r		 arrayValidaDeuda[0] = validaDeud; 	\r\r		 		 if(numPerEspera != \"\"){\r			set(\"formulario.txtNumeroPedidoEspera\", numPerEspera);\r		 }else{\r			set(\"formulario.txtNumeroPedidoEspera\", '1');\r		 }\r		 \r		 set_combo(\"formulario.cbPromedioMaximoAsignacion\", [[perioMaximo, perioMaxDes]])\r\r		 if(validaDeud == \"\"){\r			document.getElementById(\"txtNumeroPedidoEspera\").disabled = true;\r			document.getElementById(\"cbPromedioMaximoAsignacion\").disabled = true;\r		 }else{			\r			document.getElementById(\"txtNumeroPedidoEspera\").disabled = false;\r			document.getElementById(\"cbPromedioMaximoAsignacion\").disabled = false;	\r		}\r		\r		 \r\r}	\r\rfunction fLimpiar() {\r         onLoadPag();\r}\r\rfunction focoMontoConcurso() {\r         focaliza(\"formulario.txtMontoMinConcurso\");\r}\r\rfunction focoBotonCursos() {\r         focalizaBotonHTML('botonContenido','btnCursosExigidos');	\r}\r\rfunction fGuardar() {\r         accionGuardar();\r}\r\rfunction accionGuardar() {\r                  if(get('formulario.ckPagoTiempo')==\"S\") {\r                  if(!sicc_validaciones_generales('grupoCamposObligatorios')) {\r                           return;\r                  }	\r         }\r\r         if(!sicc_validaciones_generales('grupoCamposNumericos')) {\r                  return;\r         }\r\r         tomarValoresCamposPantalla();\r         eval(\"formulario\").oculto= \"S\";\r         set(\"formulario.conectorAction\", \"LPMantenerRequisitosPremiacion\");\r         set(\"formulario.accion\", \"guardar\");\r         enviaSICC('formulario', '', '', 'N');\r}\r\rfunction tomarValoresCamposPantalla() {\r         var oidRequisitosPremiacion = get(\"formulario.oidRequisitosPremiacion\");\r         var montoMinimoConcurso = get(\"formulario.txtMontoMinConcurso\");\r         var numeroPedidos = get(\"formulario.txtNumPedidos\");\r         var cuotaMinimaIngreso = get(\"formulario.txtCuotaMinIngreso\");\r         var pasarPedidosPeriodoPremiacion = get(\"formulario.ckPasarPedido\");\r         var montoMinimoPedido = get(\"formulario.txtMontoMinPedido\");\r         var pagoTiempo = get(\"formulario.ckPagoTiempo\");\r         var diasGracia = get(\"formulario.txtDiasGracia\");\r         var periodoDesde = get(\"formulario.cbPeriodoDesde\");\r         var periodoHasta = get(\"formulario.cbPeriodoHasta\");\r         var listaProductosExigidosPremiacion = get(\"formulario.listaProductosExigidosPremiacion\");\r         var lstCursosExigidosPremiacion = get(\"formulario.lstCursosExigidosPremiacion\");\r         var datosObligatorios = comprobarDatosObligatorios();\r		 		 var validarDeuda = get('formulario.cbValidaDeuda');\r		 var validaDeudaDescrip =  get('formulario.cbValidaDeuda','T');\r		 var numPerioEspe = get('formulario.txtNumeroPedidoEspera');\r		 		 var perioMax = get('formulario.cbPromedioMaximoAsignacion');\r 		 var perioMaxDes = get('formulario.cbPromedioMaximoAsignacion','T');\r		 \r		\r         var opcionMenu = get(\"formulario.opcionMenu\");\r\r         set(\"formulario.oidRequisitosPremiacion\", oidRequisitosPremiacion);\r         set(\"formulario.montoMinimoConcurso\", montoMinimoConcurso);\r         set(\"formulario.numeroPedidos\", numeroPedidos);\r         set(\"formulario.cuotaMinimaIngreso\", cuotaMinimaIngreso);\r         set(\"formulario.pasarPedidosPeriodoPremiacion\", pasarPedidosPeriodoPremiacion);\r         set(\"formulario.montoMinimoPedido\", montoMinimoPedido);\r         set(\"formulario.pagoTiempo\", pagoTiempo);\r         set(\"formulario.diasGracia\", diasGracia);\r         set(\"formulario.periodoDesde\", periodoDesde);\r         set(\"formulario.periodoHasta\", periodoHasta);\r         set(\"formulario.listaProductosExigidosPremiacion\", listaProductosExigidosPremiacion);\r         set(\"formulario.lstCursosExigidosPremiacion\", lstCursosExigidosPremiacion);\r         set(\"formulario.datosObligatorios\", datosObligatorios);\r		 		 set(\"formulario.validaDeuda\", validarDeuda);\r		 set(\"formulario.validaDeudaDescrip\", validaDeudaDescrip);\r		 if(numPerioEspe != \"\"){\r						set(\"formulario.numPerioEspera\", numPerioEspe);\r			\r		 }else{\r			set(\"formulario.numPerioEspera\", '1');\r		 }\r		 set(\"formulario.perioMax\", perioMax);\r		 set(\"formulario.perioMaxDes\", perioMaxDes);\r		 \r				\r         set(\"formulario.opcionMenu\", opcionMenu);\r}\r\rfunction onClickPestanyaPaginaRequisitosPremiacion(valor, form, nombreLP) {\r	if(get(\"formulario.opcionMenu\")!=\"Consultar Concurso\") {\r	              if(get('formulario.ckPagoTiempo')==\"S\") {\r                  if(!sicc_validaciones_generales('grupoCamposObligatorios')) {\r                           return;\r                  }	\r         }\r\r         if(!sicc_validaciones_generales('grupoCamposNumericos')) {\r                  return;\r         }\r\r         tomarValoresCamposPantalla();	\r         onClickPestanyaHabilitada(valor, form, nombreLP);\r	}\r	else {\r	    tomarValoresCamposPantalla();	\r        onClickPestanyaHabilitada(valor, form, nombreLP);\r	}    \r}\r\rfunction comprobarDatosObligatorios() {\r         if(get('formulario.ckPagoTiempo')==\"S\") {\r                  if((get(\"formulario.cbPeriodoDesde\")!=\"\") && (get(\"formulario.cbPeriodoHasta\")!=\"\")) {	\r                           return true;\r                  }	\r                  else {\r                           return false;\r                  }	\r         }\r         else {\r                  return true;\r         }		\r}\r\rfunction onChangePasarPedidoPeriodoPremiacion() {\r         var valor = get(\"formulario.ckPasarPedido\");\r         if(valor==\"S\") {\r                  document.getElementById(\"txtMontoMinPedido\").disabled = false;\r                  document.all[\"btnProductoExigidoPremiacion\"].style.visibility='';\r         }\r         else {\r                  set(\"formulario.txtMontoMinPedido\", \"\");\r                  document.getElementById(\"txtMontoMinPedido\").disabled = true;\r                  document.all[\"btnProductoExigidoPremiacion\"].style.visibility='hidden';\r         }\r}\r\rfunction onChangePagoTiempo() {\r         var valor = get(\"formulario.ckPagoTiempo\");\r         if(valor==\"S\") {\r                  document.getElementById(\"txtDiasGracia\").disabled = false;\r                  document.getElementById(\"cbPeriodoDesde\").disabled = false;\r                  document.getElementById(\"cbPeriodoHasta\").disabled = false;		\r         }\r         else {\r                  var arraySeteo = new Array();\r                  set(\"formulario.cbPeriodoDesde\", arraySeteo);\r                  set(\"formulario.cbPeriodoHasta\", arraySeteo);\r                  set(\"formulario.txtDiasGracia\", \"\");\r\r                  document.getElementById(\"txtDiasGracia\").disabled = true;\r                  document.getElementById(\"cbPeriodoDesde\").disabled = true;\r                  document.getElementById(\"cbPeriodoHasta\").disabled = true;		\r         }\r}\r\rfunction reInicio() {\r         eval(\"formulario\").oculto= \"N\";\r         focoMontoConcurso();\r}\r\rfunction errorEnAlmacenar() {\r         focoMontoConcurso();\r}\r\rfunction onClickCursosExigidosPremiacion() {\r                  var opcionMenu = get('formulario.opcionMenu');\r                  var parametros = new Object();\r                  parametros.opcionMenu = opcionMenu;\r\r                  var lstCursosExigidosPremiacion = mostrarModalSICC(\"LPMantenerRequisitosPremiacion\", \"cargar cursos exigidos premiacion\", parametros,800,600);\r\r                  if(lstCursosExigidosPremiacion != undefined){\r                           set(\"formulario.lstCursosExigidosPremiacion\", lstCursosExigidosPremiacion);\r                           eval(\"formulario\").oculto= \"S\";\r                           set(\"formulario.conectorAction\", \"LPMantenerRequisitosPremiacion\");\r                           set(\"formulario.accion\", \"almacenar cursos exigidos premiacion\");\r                           enviaSICC('formulario', '', '', 'N');\r                  }		\r}\r\rfunction onClickProductoExigidoPremiacion() {\r                  var opcionMenu = get('formulario.opcionMenu');\r                  var parametros = new Object();\r                  parametros.opcionMenu = opcionMenu;\r\r                  var listaProductosExigidosPremiacion = mostrarModalSICC(\"LPMantenerRequisitosPremiacion\", \"cargar productos exigidos premiacion\", parametros,800,600);\r\r                  if(listaProductosExigidosPremiacion != undefined){			\r                           set(\"formulario.listaProductosExigidosPremiacion\", listaProductosExigidosPremiacion);	\r                           eval(\"formulario\").oculto= \"S\";\r                           set(\"formulario.conectorAction\", \"LPMantenerRequisitosPremiacion\");\r                           set(\"formulario.accion\", \"almacenar productos exigidos premiacion\");\r                           enviaSICC('formulario', '', '', 'N');\r                  }	\r}\r\rfunction onChangeCbValidaDeuda(){\r	var aux = get('formulario.cbValidaDeuda', \"T\");\r	var opcionMenu = get('formulario.opcionMenu');\r	if(aux == \"No Se Valida Deuda\"){\r			 document.getElementById(\"txtNumeroPedidoEspera\").disabled = true;\r             document.getElementById(\"cbPromedioMaximoAsignacion\").disabled = true;\r			 set('formulario.txtNumeroPedidoEspera', '1');\r			 set('formulario.cbPromedioMaximoAsignacion', [\"\",\"\"]);\r	}else{			  \r			  	\r             var numeroEspera = get('formulario.txtNumeroPedidoEspera');			 \r			 set('formulario.numPerioEspera',numeroEspera);\r   		     document.getElementById(\"txtNumeroPedidoEspera\").disabled = false;\r             document.getElementById(\"cbPromedioMaximoAsignacion\").disabled = false;	\r			 eval(\"formulario\").oculto= \"S\";\r			 set(\"formulario.conectorAction\", \"LPMantenerRequisitosPremiacion\");\r			 set(\"formulario.accion\", \"periodoMaximo\");\r			 set(\"formulario.opcionMenu\",opcionMenu );\r             enviaSICC('formulario', '', '', 'N');\r	}\r}\r function onChangeObtenerPeriodoMaximo(){\r			 var opcionMenu = get('formulario.opcionMenu');  	\r             var numeroEspera = get('formulario.txtNumeroPedidoEspera');			 \r			 set('formulario.numPerioEspera',numeroEspera);\r			 if(!sicc_validaciones_generales('grupoCamposNumericos')) {\r                  return;\r			 }\r			 eval(\"formulario\").oculto= \"S\";\r			 set(\"formulario.conectorAction\", \"LPMantenerRequisitosPremiacion\");\r			 set(\"formulario.accion\", \"periodoMaximo\");\r			 set(\"formulario.opcionMenu\",opcionMenu );\r             enviaSICC('formulario', '', '', 'N');\r			 \r			\r }\r function fCargaComboMaximoPeriodo(oid, des){\r		if(oid != \"\"){	\r		    set('formulario.oidPerioMX', oid);\r			set('formulario.desPeroMX', des);\r			set_combo('formulario.cbPromedioMaximoAsignacion', [[oid,des]]);		\r		}else{\r			set_combo('formulario.cbPromedioMaximoAsignacion', [[\"\",\"\"]]);		\r		}\r }\r function fBuscarPeriodoErro(){\r	set_combo('formulario.cbPromedioMaximoAsignacion', [[\"\",\"\"]]);		\r }\r\r \r\r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtMontoMinConcurso" );
      ((Element)v.get(9)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","1858" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","9999999.99" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(10)).setAttribute("group","grupoCamposObligatorios" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1175" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(11)).setAttribute("group","grupoCamposObligatorios" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1176" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNumPedidos" );
      ((Element)v.get(12)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","210" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","9999" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtCuotaMinIngreso" );
      ((Element)v.get(13)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","2611" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999999" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtMontoMinPedido" );
      ((Element)v.get(14)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1703" );
      ((Element)v.get(14)).setAttribute("format","n" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","99999999999.99" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtDiasGracia" );
      ((Element)v.get(15)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","1645" );
      ((Element)v.get(15)).setAttribute("format","e" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","9999" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtNumeroPedidoEspera" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","3454" );
      ((Element)v.get(16)).setAttribute("format","e" );
      ((Element)v.get(16)).setAttribute("min","1" );
      ((Element)v.get(16)).setAttribute("max","18" );
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
      ((Element)v.get(18)).setAttribute("nombre","accion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varPais" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidRequisitosPremiacion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","montoMinimoConcurso" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","numeroPedidos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","cuotaMinimaIngreso" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","pasarPedidosPeriodoPremiacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","montoMinimoPedido" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","pagoTiempo" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","diasGracia" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","periodoDesde" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","periodoHasta" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","validaDeuda" );
      ((Element)v.get(37)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(17)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","numPerioEspera" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","perioMax" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","perioMaxDes" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","validaDeudaDescrip" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hPeriodoDeDespacho" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hBaseCalculo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hNumPerioEvaluar" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hPerioHastaGral" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","oidPerioMX" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","desPeroMX" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","listaProductosExigidosPremiacion" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","lstCursosExigidosPremiacion" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(57)).setAttribute("nombre","capa1" );
      ((Element)v.get(17)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("height","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("class","menu4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","30" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Elemento padre:62 / Elemento actual: 63   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(62)).appendChild((Text)v.get(63));

      /* Termina nodo Texto:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","10" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","92" );
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","75" );
      ((Element)v.get(67)).setAttribute("border","1" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellpadding","1" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(67)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(1, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(67)).setAttribute("onmouseover","activarPuntero('formulario', 1, 'lblParametrosGenerales');" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(70)).setAttribute("cod","00393" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:71 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","10" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","20" );
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","75" );
      ((Element)v.get(74)).setAttribute("border","1" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellpadding","1" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(74)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(5, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(74)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
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
      ((Element)v.get(77)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(77)).setAttribute("cod","0094" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:78 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","10" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","20" );
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","75" );
      ((Element)v.get(81)).setAttribute("border","1" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellpadding","1" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(81)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(6, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(81)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
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
      ((Element)v.get(84)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(84)).setAttribute("cod","00394" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:85 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","20" );
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","75" );
      ((Element)v.get(88)).setAttribute("border","1" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellpadding","1" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(88)).setAttribute("bgcolor","#496A9A" );
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
      ((Element)v.get(91)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(91)).setAttribute("cod","00395" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:92 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","10" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","10" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","20" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","75" );
      ((Element)v.get(95)).setAttribute("border","1" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellpadding","1" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(95)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(4, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(95)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblObtencionPuntos');" );
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
      ((Element)v.get(98)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(98)).setAttribute("cod","00396" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:99 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","10" );
      ((Element)v.get(99)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","10" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","20" );
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","75" );
      ((Element)v.get(102)).setAttribute("border","1" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellpadding","1" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(102)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(8, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(102)).setAttribute("onmouseover","activarPuntero('formulario', 8, 'lblDespachoPremios');" );
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
      ((Element)v.get(105)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(105)).setAttribute("cod","00397" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:106 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","16" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:108 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("height","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("class","menu4" );
      ((Element)v.get(57)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("height","30" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","10" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","70" );
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(116)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","75" );
      ((Element)v.get(117)).setAttribute("border","1" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("cellpadding","1" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(117)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(3, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(117)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblAmbitoGeografico');" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(120)).setAttribute("cod","2801" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:121 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","10" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","70" );
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","75" );
      ((Element)v.get(124)).setAttribute("border","1" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellpadding","1" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(124)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(9, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(124)).setAttribute("onmouseover","activarPuntero('formulario', 9, 'lblCalificacion');" );
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
      ((Element)v.get(127)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(127)).setAttribute("cod","00398" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:128 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","20" );
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","75" );
      ((Element)v.get(131)).setAttribute("border","1" );
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("cellpadding","1" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(131)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(10, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(131)).setAttribute("onmouseover","activarPuntero('formulario', 10, 'lblGerentes');" );
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
      ((Element)v.get(134)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(134)).setAttribute("cod","00399" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","10" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","20" );
      ((Element)v.get(137)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","75" );
      ((Element)v.get(138)).setAttribute("border","1" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cellpadding","1" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(138)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(11, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(138)).setAttribute("onmouseover","activarPuntero('formulario', 11, 'lblConsultoras');" );
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
      ((Element)v.get(141)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(141)).setAttribute("cod","00401" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:142 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","10" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","10" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","20" );
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(145)).setAttribute("width","75" );
      ((Element)v.get(145)).setAttribute("border","1" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("cellpadding","1" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(145)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(2, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(145)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblProgramaNuevas');" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(148)).setAttribute("cod","00590" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:149 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","10" );
      ((Element)v.get(149)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","10" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","20" );
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","75" );
      ((Element)v.get(152)).setAttribute("border","1" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("cellpadding","1" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(152)).setAttribute("onclick","onClickPestanyaPaginaRequisitosPremiacion(12, 'formulario', 'LPMantenerRequisitosPremiacion');" );
      ((Element)v.get(152)).setAttribute("onmouseover","activarPuntero('formulario', 12, 'lblMultinivel');" );
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
      ((Element)v.get(155)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(155)).setAttribute("cod","00400" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:156 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","16" );
      ((Element)v.get(156)).setAttribute("class","menu5texto" );
      ((Element)v.get(109)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:158 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","750" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","1" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */

      /* Empieza nodo:166 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(171)).setAttribute("class","legend" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblRequisitosPremiacion" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","legend" );
      ((Element)v.get(172)).setAttribute("cod","00360" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("table"));
      ((Element)v.get(176)).setAttribute("width","690" );
      ((Element)v.get(176)).setAttribute("border","0" );
      ((Element)v.get(176)).setAttribute("align","left" );
      ((Element)v.get(176)).setAttribute("cellspacing","0" );
      ((Element)v.get(176)).setAttribute("cellpadding","0" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("colspan","4" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblMontoMinConcurso" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","1858" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(188)).setAttribute("nombre","lblNumPedidos" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","210" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblCuotaMinIngreso" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","2611" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:180   */

      /* Empieza nodo:195 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(199)).setAttribute("nombre","txtMontoMinConcurso" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("max","12" );
      ((Element)v.get(199)).setAttribute("tipo","" );
      ((Element)v.get(199)).setAttribute("onchange","" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(199)).setAttribute("size","15" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("validacion","" );
      ((Element)v.get(199)).setAttribute("onshtab","focoBotonCursos();" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(203)).setAttribute("nombre","txtNumPedidos" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("max","5" );
      ((Element)v.get(203)).setAttribute("tipo","" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("size","6" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(207)).setAttribute("nombre","txtCuotaMinIngreso" );
      ((Element)v.get(207)).setAttribute("id","datosCampos" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(207)).setAttribute("max","7" );
      ((Element)v.get(207)).setAttribute("tipo","" );
      ((Element)v.get(207)).setAttribute("onchange","" );
      ((Element)v.get(207)).setAttribute("req","N" );
      ((Element)v.get(207)).setAttribute("size","9" );
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("validacion","" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:195   */

      /* Empieza nodo:210 / Elemento padre: 176   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(176)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","4" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:213 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("table"));
      ((Element)v.get(215)).setAttribute("width","690" );
      ((Element)v.get(215)).setAttribute("border","0" );
      ((Element)v.get(215)).setAttribute("align","left" );
      ((Element)v.get(215)).setAttribute("cellspacing","0" );
      ((Element)v.get(215)).setAttribute("cellpadding","0" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblPasarPedido" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","1860" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblMontoMinPedido" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","1703" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:216   */

      /* Empieza nodo:227 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("valing","bottom" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(231)).setAttribute("nombre","ckPasarPedido" );
      ((Element)v.get(231)).setAttribute("id","datosCampos" );
      ((Element)v.get(231)).setAttribute("onclick","onChangePasarPedidoPeriodoPremiacion();" );
      ((Element)v.get(231)).setAttribute("check","N" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(227)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(235)).setAttribute("nombre","txtMontoMinPedido" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("max","17" );
      ((Element)v.get(235)).setAttribute("tipo","" );
      ((Element)v.get(235)).setAttribute("onchange","" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("size","20" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("validacion","" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(227)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:227   */

      /* Empieza nodo:238 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("colspan","4" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:241 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("table"));
      ((Element)v.get(243)).setAttribute("width","690" );
      ((Element)v.get(243)).setAttribute("border","0" );
      ((Element)v.get(243)).setAttribute("align","left" );
      ((Element)v.get(243)).setAttribute("cellspacing","0" );
      ((Element)v.get(243)).setAttribute("cellpadding","0" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblPagoTiempo" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","1644" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(252)).setAttribute("nombre","lblDiasGracia" );
      ((Element)v.get(252)).setAttribute("alto","13" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(252)).setAttribute("filas","1" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(252)).setAttribute("id","datosTitle" );
      ((Element)v.get(252)).setAttribute("cod","1645" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(256)).setAttribute("alto","13" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(256)).setAttribute("id","datosTitle" );
      ((Element)v.get(256)).setAttribute("cod","1175" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","25" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(260)).setAttribute("cod","1176" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:244   */

      /* Empieza nodo:263 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("valing","bottom" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(267)).setAttribute("nombre","ckPagoTiempo" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("onclick","onChangePagoTiempo();" );
      ((Element)v.get(267)).setAttribute("check","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","25" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(271)).setAttribute("nombre","txtDiasGracia" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("max","5" );
      ((Element)v.get(271)).setAttribute("tipo","" );
      ((Element)v.get(271)).setAttribute("onchange","" );
      ((Element)v.get(271)).setAttribute("req","N" );
      ((Element)v.get(271)).setAttribute("size","6" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("validacion","" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(273)).setAttribute("width","25" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(275)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(275)).setAttribute("id","datosCampos" );
      ((Element)v.get(275)).setAttribute("size","1" );
      ((Element)v.get(275)).setAttribute("multiple","N" );
      ((Element)v.get(275)).setAttribute("req","S" );
      ((Element)v.get(275)).setAttribute("valorinicial","" );
      ((Element)v.get(275)).setAttribute("textoinicial","" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(263)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(280)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(280)).setAttribute("id","datosCampos" );
      ((Element)v.get(280)).setAttribute("size","1" );
      ((Element)v.get(280)).setAttribute("multiple","N" );
      ((Element)v.get(280)).setAttribute("req","S" );
      ((Element)v.get(280)).setAttribute("valorinicial","" );
      ((Element)v.get(280)).setAttribute("textoinicial","" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:282 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:263   */

      /* Empieza nodo:284 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("colspan","4" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:287 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblValidaDeuda" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","3453" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblNumeroPedidoEspera" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(295)).setAttribute("cod","3454" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 287   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblPromedioMaximoAsignacion" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","3455" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:287   */

      /* Empieza nodo:300 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(300));

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
      ((Element)v.get(303)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(304)).setAttribute("nombre","cbValidaDeuda" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("size","1" );
      ((Element)v.get(304)).setAttribute("multiple","N" );
      ((Element)v.get(304)).setAttribute("req","N" );
      ((Element)v.get(304)).setAttribute("valorinicial","" );
      ((Element)v.get(304)).setAttribute("textoinicial","" );
      ((Element)v.get(304)).setAttribute("onchange","onChangeCbValidaDeuda();" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:306 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(309)).setAttribute("nombre","txtNumeroPedidoEspera" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("max","5" );
      ((Element)v.get(309)).setAttribute("tipo","" );
      ((Element)v.get(309)).setAttribute("onchange","onChangeObtenerPeriodoMaximo();" );
      ((Element)v.get(309)).setAttribute("req","N" );
      ((Element)v.get(309)).setAttribute("size","6" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("validacion","" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(300)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(313)).setAttribute("nombre","cbPromedioMaximoAsignacion" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("size","1" );
      ((Element)v.get(313)).setAttribute("multiple","N" );
      ((Element)v.get(313)).setAttribute("req","N" );
      ((Element)v.get(313)).setAttribute("valorinicial","" );
      ((Element)v.get(313)).setAttribute("textoinicial","" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:300   */

      /* Empieza nodo:315 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("colspan","4" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:173   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:318 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:166   */

      /* Empieza nodo:320 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("table"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(325)).setAttribute("border","0" );
      ((Element)v.get(325)).setAttribute("align","center" );
      ((Element)v.get(325)).setAttribute("cellspacing","0" );
      ((Element)v.get(325)).setAttribute("cellpadding","0" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("class","botonera" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(328)).setAttribute("nombre","btnProductoExigidoPremiacion" );
      ((Element)v.get(328)).setAttribute("ID","botonContenido" );
      ((Element)v.get(328)).setAttribute("tipo","html" );
      ((Element)v.get(328)).setAttribute("accion","onClickProductoExigidoPremiacion();" );
      ((Element)v.get(328)).setAttribute("estado","false" );
      ((Element)v.get(328)).setAttribute("cod","1861" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 327   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(329)).setAttribute("nombre","btnCursosExigidos" );
      ((Element)v.get(329)).setAttribute("ID","botonContenido" );
      ((Element)v.get(329)).setAttribute("tipo","html" );
      ((Element)v.get(329)).setAttribute("accion","onClickCursosExigidosPremiacion();" );
      ((Element)v.get(329)).setAttribute("estado","false" );
      ((Element)v.get(329)).setAttribute("cod","00380" );
      ((Element)v.get(329)).setAttribute("ontab","focoMontoConcurso();" );
      ((Element)v.get(327)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:330 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:320   */

      /* Empieza nodo:332 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","12" );
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","12" );
      ((Element)v.get(334)).setAttribute("height","12" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","756" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","12" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","12" );
      ((Element)v.get(338)).setAttribute("height","1" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:332   */
      /* Termina nodo:158   */
      /* Termina nodo:57   */
      /* Termina nodo:17   */


   }

}
