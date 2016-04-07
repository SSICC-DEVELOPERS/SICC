
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_metas_ventas_proyectadas_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_metas_venta_proyectada_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0549" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener Metas Venta Proyectada" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r \r\rfunction configurarIconos() {\r	var opcionMenu = get('formulario.opcionMenu');      \r\r    if(opcionMenu == \"Consultar Concurso\") {\r		btnProxy(1, 0);\r        btnProxy(2, 1);\r        btnProxy(3, 0);\r        btnProxy(4, 0);\r        btnProxy(5, 0);\r        btnProxy(6, 1);\r        btnProxy(7, 0);\r        btnProxy(8, 0);\r        btnProxy(9, 0);\r        btnProxy(10, 1);\r    }\r    else if(opcionMenu == \"Modificar Concurso\") {\r		btnProxy(1, 0);\r		btnProxy(2, 1);\r	    btnProxy(3, 0);\r        btnProxy(4, 0);\r        btnProxy(5, 1);\r        btnProxy(6, 1);\r        btnProxy(7, 0);\r        btnProxy(8, 0);\r        btnProxy(9, 0);\r        btnProxy(10, 1);\r    }\r}\r\rfunction onLoadPag(){\r	configurarMenuSecundario(\"formulario\");           \r	DrdEnsanchaConMargenDcho('listado1',12);\r	ocultarLista();\r	eval (ON_RSZ);  \r	gestionarBotonModificar();\r	configurarIconos();\r   \r    if (get('formulario.errDescripcion')!='') {\r		var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));\r        ocultarLista();\r        window.close();\r    }\r\r    var opcionMenu = get('formulario.opcionMenu');      \r	if(opcionMenu != \"Consultar Concurso\") {\r		focaliza('formulario.cbUnidadAdmin');\r    }\r}\r\rfunction fLimpiar() {\r           onLoadPag();\r}\r\rfunction onChangeCbUA(){\r                    set(\"formulario.hCbUniAdmin\",get(\"formulario.cbUnidadAdmin\"));\r          var arrVacio = new Array();\r          arrVacio[0] = [\"\",\"\"];\r          set_combo(\"formulario.cbPeriodo\", arrVacio);\r          set_combo(\"formulario.cbCliente\", arrVacio);\r          ocultarLista();\r          eval('formulario').oculto=\"S\"; \r          set('formulario.conectorAction','LPMantenerParametrosCalificacion');\r          set('formulario.accion', 'recargarCombosMetasVentaProyectada');\r          enviaSICC('formulario');\r}\r\rfunction vuelvoDeRecargaDeCombos(sPeriodos, sClientes, listaMtas){\r		  configurarIconos();\r	      set(\"formulario.hListaMetasProyectada\",listaMtas);		  \r	      set_combo(\"formulario.cbPeriodo\", parseaCombo(sPeriodos));\r          set_combo(\"formulario.cbCliente\", parseaCombo(sClientes));\r\r          var arrVacio = new Array();\r          arrVacio[0] = [\"\",\"\"];\r          var opcionMenu = get('formulario.opcionMenu');\r\r          if(listaMtas==\"\"){\r                                        if(opcionMenu != \"Consultar Concurso\") {\r\r                              if(get('formulario.cbUnidadAdmin')==get('formulario.hconst_oid_reg')){\r\r                                         GestionarMensaje('INC-0038');                              } else if(get('formulario.cbUnidadAdmin')==get('formulario.hconst_oid_sub')){\r\r                                         GestionarMensaje('INC-0039');                              } else{\r\r                                         GestionarMensaje('INC-0040');                              }\r                    } else {\r                                         if(get('formulario.cbUnidadAdmin')==get('formulario.hconst_oid_reg')){\r\r                                                   GestionarMensaje('INC-0041');                                         } else if(get('formulario.cbUnidadAdmin')==get('formulario.hconst_oid_sub')){\r\r                                                   GestionarMensaje('INC-0042');                                         } else{\r                                                   GestionarMensaje('INC-0043');                                         }\r                    }\r                                        set_combo(\"formulario.cbPeriodo\", arrVacio);\r                    set_combo(\"formulario.cbCliente\", arrVacio);\r                    ocultarLista();\r          }\r}\r\rfunction parseaCombo(str){	\r	var arr = new Array();	\r	var arrVacio = new Array();\r	arrVacio[0] = \"\";\r	arrVacio[1] = \"\";\r	arr[0] = arrVacio;\r\r    var filas = str.split('|');\r\r	for(var i=0; i<filas.length; i++) {\r		var campos = filas[i];\r		var campo = campos.split(\",\");\r		arrIn = new Array();\r        arrIn[0] = campo[0];\r        arrIn[1] = campo[1];                        \r        arr[i+1] = arrIn;      		\r	}\r\r    return arr;\r}  \r  \rfunction gestionarBotonModificar(){\r    if(get('formulario.hMostrarBtnModificar')!='S'){\r           deshabilitarHabilitarBoton('botonContenido', 'btnModificar', 'D');\r           }\r}\r  \rfunction ocultarLista(){  \r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"btnAceptarDiv\"].style.visibility='hidden';\r \r    document.all[\"btnModificarDiv\"].style.visibility='hidden';\r}\r\rfunction mostrarLista(){  \r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"btnAceptarDiv\"].style.visibility='';\r\r    document.all[\"btnModificarDiv\"].style.visibility='';\r}\r\rfunction onChangeCliente(){\r  set('formulario.cbPeriodo','');\r}\r\rfunction onChangePeriodo(){\r  set('formulario.cbCliente','');\r}\r\rfunction accionBuscar(){\r    var listaMetasProyectada = get(\"formulario.hListaMetasProyectada\");\r        var aux = new Array();\r    listado1.setDatos(aux);\r\r    if (listaMetasProyectada != \"\"){\r           var oidCliente = get(\"formulario.cbCliente\");\r           var oidPeriodo = get(\"formulario.cbPeriodo\");\r      \r                      var datos = listaMetasProyectada.split('|');\r    \r           for (var i = 0; i < datos.length; i++){\r                var sLine = datos[i];\r                var aLine = sLine.split(',');                \r                var aListado = new Array();\r           \r                aListado[0] = aLine[18];                  aListado[1] = aLine[19];                  aListado[2] = aLine[2];   \r				aListado[3] = aLine[9];   \r                aListado[4] = aLine[11];                  aListado[5] = aLine[5];                   aListado[6] = aLine[6];                   aListado[7] = aLine[4];                   aListado[8] = aLine[13];                  aListado[9] = aLine[16];                  aListado[10] = aLine[1];                   aListado[11] = aLine[10];                 aListado[12] = aLine[0];                  aListado[13] = aLine[15];                 aListado[14] = aLine[22];                 aListado[15] = aLine[25];                 aListado[16] = aLine[24];                 aListado[17] = aLine[23];                 aListado[18] = aLine[7];                  aListado[19] = aLine[8];                  aListado[20] = aLine[20]; 				aListado[21] = aLine[3];  				aListado[22] = aLine[12]; 				aListado[23] = aLine[14]; 				aListado[24] = aLine[17]; 				aListado[25] = aLine[21]; 				aListado[26] = aLine[26];                 \r                if (oidCliente != '' && oidCliente == aListado[1]){\r                    listado1.insertar(aListado);\r                }\r                \r                if (oidPeriodo != '' && oidPeriodo == aListado[20]){\r                    listado1.insertar(aListado);\r                }\r                \r                if (oidCliente == '' && oidPeriodo == ''){\r                    listado1.insertar(aListado);\r                }                \r           }           \r		   mostrarLista(); \r		   configurarVisibilidadColumnas();\r		   configurarVisibilidadClientePeriodo();\r    }\r}\r\rfunction configurarVisibilidadClientePeriodo() {\r	if(get(\"formulario.cbCliente\")!='' && get(\"formulario.cbPeriodo\")=='') {\r				listado1.alternaVerColumna(1,false);\r				listado1.alternaVerColumna(2,true);\r	}\r\r	if(get(\"formulario.cbCliente\")=='' && get(\"formulario.cbPeriodo\")!='') {\r				listado1.alternaVerColumna(1,true);\r				listado1.alternaVerColumna(2,false);\r	}		\r\r	if(get(\"formulario.cbCliente\")=='' && get(\"formulario.cbPeriodo\")=='') {\r				listado1.alternaVerColumna(1,true);\r				listado1.alternaVerColumna(2,true);\r	}\r} \r\rfunction configurarVisibilidadColumnas() {			\r	if(get('formulario.hEstadoActivas')==\"false\") \r		listado1.alternaVerColumna(3,false);\r\r	if(get('formulario.hEstadoIngreso')==\"false\") \r		listado1.alternaVerColumna(4,false);\r\r	if(get('formulario.hEstadoReingreso')==\"false\") \r		listado1.alternaVerColumna(5,false);\r\r	if(get('formulario.hEstadoEgresos')==\"false\") \r		listado1.alternaVerColumna(6,false);\r\r	if(get('formulario.hEstadoEntregadas')==\"false\") \r		listado1.alternaVerColumna(7,false);\r\r	if(get('formulario.hEstadoRecibidas')==\"false\") \r		listado1.alternaVerColumna(8,false);\r	\r	if(get('formulario.hEstadoCapitalizacion')==\"false\") \r		listado1.alternaVerColumna(9,false);\r\r	if(get('formulario.hEstadoActivasFinales')==\"false\") \r		listado1.alternaVerColumna(10,false);\r\r	if(get('formulario.hEstadoActividad')==\"false\") \r		listado1.alternaVerColumna(11,false);\r\r	if(get('formulario.hEstadoNumeroPedidos')==\"false\") \r		listado1.alternaVerColumna(12,false);\r\r	if(get('formulario.hEstadoPrecioPromedioUnitario')==\"false\") \r		listado1.alternaVerColumna(13,false);\r\r	if(get('formulario.hEstadoPromedioVentaPedido')==\"false\") \r		listado1.alternaVerColumna(14,false);\r\r	if(get('formulario.hEstadoPromedioUnidadesPedido')==\"false\") \r		listado1.alternaVerColumna(15,false);\r\r	if(get('formulario.hEstadoPromedioOrdenesPedido')==\"false\") \r		listado1.alternaVerColumna(16,false);\r\r	if(get('formulario.hEstadoRetencion')==\"false\") \r		listado1.alternaVerColumna(17,false);\r\r	if(get('formulario.hEstadoVentaEstadisticable')==\"false\") 	\r		listado1.alternaVerColumna(18,false);\r}\r\rfunction accionAceptar(){\r				    window.close(); \r}\r\rfunction obtenerRegistrosListaOcultaNoSeleccionados(){\r    var arLista = obtenerListaMetasVentaProyectadaOculta();\r    var sReturn = '';\r    var sRegistro = '';\r    var sOid = '';\r    \r    for (var a = 0; a < arLista.length; a++){\r           sRegistro = arLista[a];\r           sOid = sRegistro.substring(0, sRegistro.indexOf(','));\r\r           if (!existeOidEnLista(sOid)){\r                if (sReturn == ''){\r                      sReturn += sRegistro;\r                } else {\r                      sReturn += '|' + sRegistro;\r                }\r           }\r    }\r\r    return sReturn;\r}\r\rfunction existeOidEnLista(oid){\r    var codigosLista = listado1.codigos();\r    \r    for (var a = 0; a < codigosLista.length; a++){\r           if (codigosLista[a] == oid){\r                return true;\r           }\r    }\r\r    return false;\r}\r\rfunction obtenerListaMetasVentaProyectadaOculta(){\r    var listaMetasProyectada = get(\"formulario.hListaMetasProyectada\");\r\r        var datos = listaMetasProyectada.split('|');\r    \r    return datos;\r}\r\rfunction accionModificar(){ \r		   var codigos = listado1.codSeleccionados();\r           var valorSeteado = mipgndo.lista.codSeleccionados();\r\r           if (listado1.numSelecc()!= 1) {\r                      GestionarMensaje('1022',null,null,null);\r                      return false;\r           }\r\r           if (valorSeteado != ''){\r                      var obj = new Object();\r                      obj.seleccion = valorSeteado[0];\r                      var sel = valorSeteado;                    \r					  var oid = listado1.extraeDato(codigos,0);                      \r                      var cliente = listado1.extraeDato(codigos,1);           \r                      var activas = listado1.extraeDato(codigos,3);           \r                      var ingresos = listado1.extraeDato(codigos,4);                    \r                      var reingresos = listado1.extraeDato(codigos,5);      \r                      var egresos = listado1.extraeDato(codigos,6);           \r                      var entregadas = listado1.extraeDato(codigos,7);      \r                      var recibidas = listado1.extraeDato(codigos,8);                   \r                      var capitalizacion = listado1.extraeDato(codigos,9);\r                      var actFinales = listado1.extraeDato(codigos,10);      \r					  var actividad = listado1.extraeDato(codigos, 11);          \r                      var pedidos = listado1.extraeDato(codigos,12);                    \r                      var precioPromUnitario = listado1.extraeDato(codigos,13);     \r                      var promedioVtaPedido = listado1.extraeDato(codigos,14);      \r                      var promUnidadesPedido = listado1.extraeDato(codigos,15);     \r                      var promOrdenesPedido = listado1.extraeDato(codigos,16);\r                      var retencion = listado1.extraeDato(codigos,17);                      \r                      var ventasEstadisticab = listado1.extraeDato(codigos,18);\r\r                      obj.accion = 'cargar modificar metas venta proyectada';\r                      obj.opcionMenu = get('formulario.opcionMenu');\r\r                      obj.oid = oid;\r                      obj.cliente = cliente;\r                      obj.activas = activas;\r                      obj.ingresos = ingresos;\r                      obj.reingresos = reingresos;\r                      obj.egresos = egresos;           \r                      obj.entregadas = entregadas;\r                      obj.recibidas = recibidas;\r                      obj.capitalizacion = capitalizacion;            \r                      obj.actFinales = actFinales;\r                      obj.actividad = actividad;\r                      obj.pedidos = pedidos;\r                      obj.precioPromUnitario = precioPromUnitario;\r                      obj.promedioVtaPedido = promedioVtaPedido; \r                      obj.promUnidadesPedido = promUnidadesPedido;\r                      obj.promOrdenesPedido = promOrdenesPedido;\r                      obj.retencion = retencion;\r                      obj.ventasEstadisticab = ventasEstadisticab;       \r					  \r                      var obj = mostrarModalSICC('LPMantenerParametrosCalificacion', 'cargar modificar metas venta proyectada', obj, 600, 300);\r\r           if (obj != null){\r                var cod = listado1.codSeleccionados();\r\r                listado1.insertaDato(cod, 3, obj.activas);\r                listado1.insertaDato(cod, 4, obj.ingresos);\r                listado1.insertaDato(cod, 5, obj.reingresos);\r                listado1.insertaDato(cod, 6, obj.egresos);\r                listado1.insertaDato(cod, 7, obj.entregadas);\r                listado1.insertaDato(cod, 8, obj.recibidas);\r                listado1.insertaDato(cod, 9, obj.capitalizacion);\r                listado1.insertaDato(cod, 10, obj.actFinales);\r                listado1.insertaDato(cod, 11, obj.actividad);\r                listado1.insertaDato(cod, 12, obj.pedidos);\r                listado1.insertaDato(cod, 13, obj.precioPromUnitario);\r                listado1.insertaDato(cod, 14, obj.promedioVtaPedido);\r                listado1.insertaDato(cod, 15, obj.promUnidadesPedido);\r                listado1.insertaDato(cod, 16, obj.promOrdenesPedido);\r                listado1.insertaDato(cod, 17, obj.retencion);\r                listado1.insertaDato(cod, 18, obj.ventasEstadisticab); \r\r												var datos = listado1.datos; \r				var datoTemp;\r				var sDatoTemp = '';\r\r				var datosCompletos = \"\";\r				var oidFilaModificada = \"\";\r\r																\r				var filaMarcada = listado1.filaSelecc;				\r			    var fila = new Array();\r\r				var temp0 = datos[filaMarcada][0];\r				oidFilaModificada = datos[filaMarcada][0];\r				if(temp0==\"\") temp0 = \" \";\r				fila[0] = temp0;\r\r				var temp1 = datos[filaMarcada][1];\r				if(temp1==\"\") temp1 = \" \";\r				fila[1] = temp1;\r\r				var temp2 = datos[filaMarcada][2];\r				if(temp2==\"\") temp2 = \" \";\r				fila[2] = temp2;\r\r				var temp3 = datos[filaMarcada][3];\r				if(temp3==\"\") temp3 = \" \";\r				fila[3] = temp3;\r\r				var temp4 = datos[filaMarcada][4];\r				if(temp4==\"\") temp4 = \" \";\r				fila[4] = temp4;\r\r				var temp5 = datos[filaMarcada][5];\r				if(temp5==\"\") temp5 = \" \";\r				fila[5] = temp5;\r\r				var temp6 = datos[filaMarcada][6];\r				if(temp6==\"\") temp6 = \" \";\r				fila[6] = temp6;\r\r				var temp7 = datos[filaMarcada][7];\r				if(temp7==\"\") temp7 = \" \";\r				fila[7] = temp7;\r\r				var temp8 = datos[filaMarcada][8];\r				if(temp8==\"\") temp8 = \" \";\r				fila[8] = temp8;\r\r				var temp9 = datos[filaMarcada][9];\r				if(temp9==\"\") temp9 = \" \";\r				fila[9] = temp9;\r\r				var temp10 = datos[filaMarcada][10];\r				if(temp10==\"\") temp10 = \" \";\r				fila[10] = temp10;\r\r				var temp11 = datos[filaMarcada][11];\r				if(temp11==\"\") temp11 = \" \";\r				fila[11] = temp11\r\r				var temp12 = datos[filaMarcada][12];\r				if(temp12==\"\") temp12 = \" \";\r				fila[12] = temp12;\r\r				var temp13 = datos[filaMarcada][13];\r				if(temp13==\"\") temp13 = \" \";\r				fila[13] = temp13;\r\r			    var temp14 = datos[filaMarcada][14];\r				if(temp14==\"\") temp14 = \" \";\r				fila[14] = temp14;\r\r				var temp15 = datos[filaMarcada][15];\r				if(temp15==\"\") temp15 = \" \";\r				fila[15] = temp15;\r\r				var temp16 = datos[filaMarcada][16];\r				if(temp16==\"\") temp16 = \" \";\r				fila[16] = temp16;\r\r				var temp17 = datos[filaMarcada][17];\r				if(temp17==\"\") temp17 = \" \";\r				fila[17] = temp17;\r\r				var temp18 = datos[filaMarcada][18];\r				if(temp18==\"\") temp18 = \" \";\r				fila[18] = temp18;\r\r				var temp19 = datos[filaMarcada][19];\r				if(temp19==\"\") temp19 = \" \";\r				fila[19] = temp19;\r\r								var temp20 = datos[filaMarcada][20];\r				if(temp20==\"\") temp20 = \" \";\r				fila[20] = temp20;\r\r				var temp21 = datos[filaMarcada][21];\r				if(temp21==\"\") temp21 = \" \";\r				fila[21] = temp21;\r\r				var temp22 = datos[filaMarcada][22];\r				if(temp22==\"\") temp22 = \" \";\r				fila[22] = temp22;\r\r				var temp23 = datos[filaMarcada][23];\r				if(temp23==\"\") temp23 = \" \";\r				fila[23] = temp23;\r \r			    var temp24 = datos[filaMarcada][24];\r				if(temp24==\"\") temp24 = \" \";\r				fila[24] = temp24;\r\r				var temp25 = datos[filaMarcada][25];\r				if(temp25==\"\") temp25 = \" \";\r				fila[25] = temp25;\r\r				var temp26 = datos[filaMarcada][26];\r				if(temp26==\"\") temp26 = \" \";\r				fila[26] = temp26;\r				\r				datosCompletos = datosCompletos + fila;		  \r\r				eval('formulario').oculto=\"S\"; \r				set('formulario.conectorAction','LPMantenerParametrosCalificacion');\r				set('formulario.accion', 'actualizarSesionDtos');\r				set('formulario.oidFilaModificada', oidFilaModificada);				\r				set('formulario.valorActualizar', datosCompletos);\r				set(\"formulario.hCbUniAdmin\",get(\"formulario.cbUnidadAdmin\"));\r				enviaSICC('formulario');\r				                }\r           } else {\r           GestionarMensaje('4', null, null, null);\r      }\r}\r\rfunction despuesActualizarSesionDtos() {\r	configurarIconos();\r	eval('formulario').oculto=\"N\"; \r}\r \rfunction muestraLista( ultima, rowset){\r    var tamano = rowset.length;\r    \r    if (tamano > 0) {\r           mostrarLista();\r           return true;\r    } else {\r           ocultarLista();\r           btnProxy(4,0);                      \r           return false;\r    }\r    focaliza(\"formulario.cbCliente\");   \r}\r\rfunction focalizaTab(){\r    focaliza(\"formulario.cbCliente\");\r}\r\rfunction tabBtn(){\r    focalizaBotonHTML('botonContenido','btnBuscar');    \r}\r\r\rfunction setTabFocus(campo){\r           if (campo == 'cbCliente'){\r                      focaliza('formulario.cbPeriodo')\r           }\r		   else if (campo == 'cbPeriodo'){\r                      focalizaBotonHTML('botonContenido', 'btnBuscar2');\r           }\r		   else if (campo == 'btnBuscar2'){\r                      if (document.all[\"btnAceptarDiv\"].style.visibility == ''){\r                                  focalizaBotonHTML('botonContenido', 'btnAceptar');\r                      } else {\r                                  focaliza('formulario.cbUnidadAdmin');\r                      }\r           }\r		   else if (campo == 'btnAceptar'){\r                      if (document.all[\"btnModificarDiv\"].style.visibility == ''){\r                                  focalizaBotonHTML('botonContenido', 'btnModificar');\r                      } else {\r                                  focaliza('formulario.cbCliente');\r                      }\r           }\r		   else if (campo == 'btnModificar'){\r                      focaliza('formulario.cbUnidadAdmin');\r           }\r}\r\rfunction setSHTabFocus(campo){\r           if (campo == 'btnModificar'){\r                      focalizaBotonHTML('botonContenido', 'btnAceptar');\r           }\r		   else if (campo == 'btnAceptar'){\r                      focalizaBotonHTML('botonContenido', 'btnBuscar2');\r           }\r		   else if (campo == 'btnBuscar2'){\r                      focaliza('formulario.cbPeriodo')\r           }\r		   else if (campo == 'cbPeriodo'){\r                      focaliza('formulario.cbCliente');\r           }\r		   else if (campo == 'cbCliente'){\r                      focaliza('formulario.cbUnidadAdmin');\r           }\r}\r\rfunction fVolver(){\r	window.close();\r}\r\rfunction OnTabComboUnidad(){\r	focaliza(\"formulario.cbCliente\");\r}\r\rfunction OnShtabComboUnidad() {\r	if (document.all[\"btnModificarDiv\"].style.visibility == ''){\r		focalizaBotonHTML('botonContenido', 'btnModificar');\r	}\r	else {\r		focalizaBotonHTML('botonContenido', 'btnBuscar2');\r	}	\r}\r\r   \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hEstadoActivas" );
      ((Element)v.get(11)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hEstadoIngreso" );
      ((Element)v.get(12)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hEstadoReingreso" );
      ((Element)v.get(13)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hEstadoEgresos" );
      ((Element)v.get(14)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hEstadoEntregadas" );
      ((Element)v.get(15)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hEstadoRecibidas" );
      ((Element)v.get(16)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hEstadoCapitalizacion" );
      ((Element)v.get(17)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hEstadoActivasFinales" );
      ((Element)v.get(18)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hEstadoActividad" );
      ((Element)v.get(19)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hEstadoNumeroPedidos" );
      ((Element)v.get(20)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hEstadoPrecioPromedioUnitario" );
      ((Element)v.get(21)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hEstadoPromedioVentaPedido" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hEstadoPromedioUnidadesPedido" );
      ((Element)v.get(23)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hEstadoPromedioOrdenesPedido" );
      ((Element)v.get(24)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hEstadoRetencion" );
      ((Element)v.get(25)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hEstadoVentaEstadisticable" );
      ((Element)v.get(26)).setAttribute("valor","N" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hCbUniAdmin" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hconst_oid_reg" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hconst_oid_sub" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hconst_oid_zon" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hMostrarBtnModificar" );
      ((Element)v.get(31)).setAttribute("valor","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hListaMetasProyectada" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hlistaVarVta" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","valorActualizar" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidFilaModificada" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(36)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(36)).setAttribute("x","0" );
      ((Element)v.get(36)).setAttribute("y","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","750" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("height","1" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:38   */

      /* Empieza nodo:45 / Elemento padre: 37   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(50)).setAttribute("class","legend" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","legend" );
      ((Element)v.get(51)).setAttribute("cod","0075" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","400" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","left" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","3" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblUnidadAdmin" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","1194" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblCliente" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","1471" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","276" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:59   */

      /* Empieza nodo:74 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbUnidadAdmin" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("ontab","OnTabComboUnidad();" );
      ((Element)v.get(78)).setAttribute("onshtab","OnShtabComboUnidad();" );
      ((Element)v.get(78)).setAttribute("onchange","onChangeCbUA()" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbCliente" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).setAttribute("ontab","setTabFocus('cbCliente')" );
      ((Element)v.get(83)).setAttribute("onshtab","setSHTabFocus('cbCliente')" );
      ((Element)v.get(83)).setAttribute("onchange","onChangeCliente()" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("ontab","setTabFocus('cbPeriodo')" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).setAttribute("onshtab","setSHTabFocus('cbPeriodo')" );
      ((Element)v.get(88)).setAttribute("onchange","onChangePeriodo()" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:90 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:74   */

      /* Empieza nodo:92 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("colspan","3" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","7" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:95 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:45   */

      /* Empieza nodo:97 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(102)).setAttribute("border","0" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("cellpadding","0" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("align","left" );
      ((Element)v.get(104)).setAttribute("class","botonera" );
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","btnBuscar2" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("tipo","html" );
      ((Element)v.get(105)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("cod","1" );
      ((Element)v.get(105)).setAttribute("ontab","setTabFocus('btnBuscar2')" );
      ((Element)v.get(105)).setAttribute("onshtab","setSHTabFocus('btnBuscar2')" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","12" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:97   */

      /* Empieza nodo:108 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","756" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","1" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:108   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:115 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(115)).setAttribute("nombre","listado1" );
      ((Element)v.get(115)).setAttribute("ancho","404" );
      ((Element)v.get(115)).setAttribute("alto","317" );
      ((Element)v.get(115)).setAttribute("x","12" );
      ((Element)v.get(115)).setAttribute("y","122" );
      ((Element)v.get(115)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(115)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(116)).setAttribute("precarga","S" );
      ((Element)v.get(116)).setAttribute("conROver","S" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(117)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(117)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(117)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(117)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(118)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(118)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(118)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(118)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(119)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(119)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:116   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(121)).setAttribute("borde","1" );
      ((Element)v.get(121)).setAttribute("horizDatos","1" );
      ((Element)v.get(121)).setAttribute("horizCabecera","1" );
      ((Element)v.get(121)).setAttribute("vertical","0" );
      ((Element)v.get(121)).setAttribute("horizTitulo","1" );
      ((Element)v.get(121)).setAttribute("horizBase","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 120   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(122)).setAttribute("borde","#999999" );
      ((Element)v.get(122)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(122)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(122)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(122)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(122)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(122)).setAttribute("horizBase","#999999" );
      ((Element)v.get(120)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:120   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(123)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(123)).setAttribute("alto","22" );
      ((Element)v.get(123)).setAttribute("imgFondo","" );
      ((Element)v.get(123)).setAttribute("cod","00135" );
      ((Element)v.get(123)).setAttribute("ID","datosTitle" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 115   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(124)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(124)).setAttribute("alto","22" );
      ((Element)v.get(124)).setAttribute("imgFondo","" );
      ((Element)v.get(115)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 115   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(125)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(125)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(125)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(125)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(125)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(125)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(115)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","60" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(126)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","80" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","150" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(129)).setAttribute("ancho","150" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","150" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","150" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","150" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","150" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","150" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("ancho","150" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","150" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","150" );
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","150" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","150" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","150" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","150" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","150" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","150" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","150" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(125)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","60" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","60" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).setAttribute("oculta","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(125)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","60" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","60" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","60" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(149)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","60" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(150)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","60" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(151)).setAttribute("oculta","S" );
      ((Element)v.get(125)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:125   */

      /* Empieza nodo:152 / Elemento padre: 115   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(152)).setAttribute("alto","20" );
      ((Element)v.get(152)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(152)).setAttribute("imgFondo","" );
      ((Element)v.get(152)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(115)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("cod","1471" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Elemento padre:153 / Elemento actual: 154   */
      v.add(doc.createTextNode("oidCliente"));
      ((Element)v.get(153)).appendChild((Text)v.get(154));

      /* Termina nodo Texto:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("cod","1471" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Elemento padre:155 / Elemento actual: 156   */
      v.add(doc.createTextNode("Cliente"));
      ((Element)v.get(155)).appendChild((Text)v.get(156));

      /* Termina nodo Texto:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","276" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Periodo"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","1706" );
      ((Element)v.get(152)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Activas"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","1707" );
      ((Element)v.get(152)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("Ingresos"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","1708" );
      ((Element)v.get(152)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("Reingresos"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","1753" );
      ((Element)v.get(152)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Egresos"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","1754" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(152)).appendChild((Element)v.get(167));

      /* Elemento padre:167 / Elemento actual: 168   */
      v.add(doc.createTextNode("Entregadas"));
      ((Element)v.get(167)).appendChild((Text)v.get(168));

      /* Termina nodo Texto:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","1755" );
      ((Element)v.get(152)).appendChild((Element)v.get(169));

      /* Elemento padre:169 / Elemento actual: 170   */
      v.add(doc.createTextNode("Recibidas"));
      ((Element)v.get(169)).appendChild((Text)v.get(170));

      /* Termina nodo Texto:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","1756" );
      ((Element)v.get(152)).appendChild((Element)v.get(171));

      /* Elemento padre:171 / Elemento actual: 172   */
      v.add(doc.createTextNode("Capitalización"));
      ((Element)v.get(171)).appendChild((Text)v.get(172));

      /* Termina nodo Texto:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","1757" );
      ((Element)v.get(152)).appendChild((Element)v.get(173));

      /* Elemento padre:173 / Elemento actual: 174   */
      v.add(doc.createTextNode("Activas finales"));
      ((Element)v.get(173)).appendChild((Text)v.get(174));

      /* Termina nodo Texto:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","173" );
      ((Element)v.get(152)).appendChild((Element)v.get(175));

      /* Elemento padre:175 / Elemento actual: 176   */
      v.add(doc.createTextNode("Actividad"));
      ((Element)v.get(175)).appendChild((Text)v.get(176));

      /* Termina nodo Texto:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","210" );
      ((Element)v.get(152)).appendChild((Element)v.get(177));

      /* Elemento padre:177 / Elemento actual: 178   */
      v.add(doc.createTextNode("Nº pedidos"));
      ((Element)v.get(177)).appendChild((Text)v.get(178));

      /* Termina nodo Texto:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","1758" );
      ((Element)v.get(152)).appendChild((Element)v.get(179));

      /* Elemento padre:179 / Elemento actual: 180   */
      v.add(doc.createTextNode("Precio promedio unitario"));
      ((Element)v.get(179)).appendChild((Text)v.get(180));

      /* Termina nodo Texto:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","1759" );
      ((Element)v.get(152)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("Promedio venta pedido"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","1760" );
      ((Element)v.get(152)).appendChild((Element)v.get(183));

      /* Elemento padre:183 / Elemento actual: 184   */
      v.add(doc.createTextNode("Promedio unidades pedido"));
      ((Element)v.get(183)).appendChild((Text)v.get(184));

      /* Termina nodo Texto:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","1761" );
      ((Element)v.get(152)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("Promedio ordenes pedido"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","1762" );
      ((Element)v.get(152)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("Retención"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","1763" );
      ((Element)v.get(152)).appendChild((Element)v.get(189));

      /* Elemento padre:189 / Elemento actual: 190   */
      v.add(doc.createTextNode("Ventas estadisticables"));
      ((Element)v.get(189)).appendChild((Text)v.get(190));

      /* Termina nodo Texto:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","1471" );
      ((Element)v.get(152)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("oidPeriodo"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(193)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("impCapitalizacion"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(195));

      /* Elemento padre:195 / Elemento actual: 196   */
      v.add(doc.createTextNode("numClientes"));
      ((Element)v.get(195)).appendChild((Text)v.get(196));

      /* Termina nodo Texto:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("colFondo","" );
      ((Element)v.get(197)).setAttribute("ID","EstCab" );
      ((Element)v.get(197)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(197));

      /* Elemento padre:197 / Elemento actual: 198   */
      v.add(doc.createTextNode("numOrdenes"));
      ((Element)v.get(197)).appendChild((Text)v.get(198));

      /* Termina nodo Texto:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("colFondo","" );
      ((Element)v.get(199)).setAttribute("ID","EstCab" );
      ((Element)v.get(199)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(199));

      /* Elemento padre:199 / Elemento actual: 200   */
      v.add(doc.createTextNode("numUnidadesVendidas"));
      ((Element)v.get(199)).appendChild((Text)v.get(200));

      /* Termina nodo Texto:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("colFondo","" );
      ((Element)v.get(201)).setAttribute("ID","EstCab" );
      ((Element)v.get(201)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(201));

      /* Elemento padre:201 / Elemento actual: 202   */
      v.add(doc.createTextNode("oidUA"));
      ((Element)v.get(201)).appendChild((Text)v.get(202));

      /* Termina nodo Texto:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("colFondo","" );
      ((Element)v.get(203)).setAttribute("ID","EstCab" );
      ((Element)v.get(203)).setAttribute("cod","" );
      ((Element)v.get(152)).appendChild((Element)v.get(203));

      /* Elemento padre:203 / Elemento actual: 204   */
      v.add(doc.createTextNode("retencion"));
      ((Element)v.get(203)).appendChild((Text)v.get(204));

      /* Termina nodo Texto:204   */
      /* Termina nodo:203   */
      /* Termina nodo:152   */

      /* Empieza nodo:205 / Elemento padre: 115   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(205)).setAttribute("alto","22" );
      ((Element)v.get(205)).setAttribute("accion","" );
      ((Element)v.get(205)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(205)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(205)).setAttribute("maxSel","-1" );
      ((Element)v.get(205)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(205)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(205)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(205)).setAttribute("onLoad","" );
      ((Element)v.get(205)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(115)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("tipo","texto" );
      ((Element)v.get(206)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("tipo","texto" );
      ((Element)v.get(207)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("tipo","texto" );
      ((Element)v.get(208)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(205)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("tipo","texto" );
      ((Element)v.get(218)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("tipo","texto" );
      ((Element)v.get(219)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("tipo","texto" );
      ((Element)v.get(220)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("tipo","texto" );
      ((Element)v.get(221)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("tipo","texto" );
      ((Element)v.get(222)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("tipo","texto" );
      ((Element)v.get(223)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("tipo","texto" );
      ((Element)v.get(224)).setAttribute("ID","EstDat2" );
      ((Element)v.get(205)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("tipo","texto" );
      ((Element)v.get(225)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("tipo","texto" );
      ((Element)v.get(226)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("tipo","texto" );
      ((Element)v.get(227)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("tipo","texto" );
      ((Element)v.get(228)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 205   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(205)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:205   */

      /* Empieza nodo:232 / Elemento padre: 115   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(115)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 115   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(233)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(233)).setAttribute("ancho","404" );
      ((Element)v.get(233)).setAttribute("sep","$" );
      ((Element)v.get(233)).setAttribute("x","12" );
      ((Element)v.get(233)).setAttribute("class","botonera" );
      ((Element)v.get(233)).setAttribute("y","416" );
      ((Element)v.get(233)).setAttribute("control","|" );
      ((Element)v.get(233)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(233)).setAttribute("rowset","" );
      ((Element)v.get(233)).setAttribute("cargainicial","N" );
      ((Element)v.get(233)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(115)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(234)).setAttribute("nombre","ret1" );
      ((Element)v.get(234)).setAttribute("x","37" );
      ((Element)v.get(234)).setAttribute("y","420" );
      ((Element)v.get(234)).setAttribute("ID","botonContenido" );
      ((Element)v.get(234)).setAttribute("img","retroceder_on" );
      ((Element)v.get(234)).setAttribute("tipo","0" );
      ((Element)v.get(234)).setAttribute("estado","false" );
      ((Element)v.get(234)).setAttribute("alt","" );
      ((Element)v.get(234)).setAttribute("codigo","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(234)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(235)).setAttribute("nombre","ava1" );
      ((Element)v.get(235)).setAttribute("x","52" );
      ((Element)v.get(235)).setAttribute("y","420" );
      ((Element)v.get(235)).setAttribute("ID","botonContenido" );
      ((Element)v.get(235)).setAttribute("img","avanzar_on" );
      ((Element)v.get(235)).setAttribute("tipo","0" );
      ((Element)v.get(235)).setAttribute("estado","false" );
      ((Element)v.get(235)).setAttribute("alt","" );
      ((Element)v.get(235)).setAttribute("codigo","" );
      ((Element)v.get(235)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:233   */
      /* Termina nodo:115   */

      /* Empieza nodo:236 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(236)).setAttribute("nombre","primera1" );
      ((Element)v.get(236)).setAttribute("x","20" );
      ((Element)v.get(236)).setAttribute("y","420" );
      ((Element)v.get(236)).setAttribute("ID","botonContenido" );
      ((Element)v.get(236)).setAttribute("img","primera_on" );
      ((Element)v.get(236)).setAttribute("tipo","-2" );
      ((Element)v.get(236)).setAttribute("estado","false" );
      ((Element)v.get(236)).setAttribute("alt","" );
      ((Element)v.get(236)).setAttribute("codigo","" );
      ((Element)v.get(236)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(237)).setAttribute("nombre","separa" );
      ((Element)v.get(237)).setAttribute("x","59" );
      ((Element)v.get(237)).setAttribute("y","416" );
      ((Element)v.get(237)).setAttribute("ID","botonContenido" );
      ((Element)v.get(237)).setAttribute("img","separa_base" );
      ((Element)v.get(237)).setAttribute("tipo","0" );
      ((Element)v.get(237)).setAttribute("estado","false" );
      ((Element)v.get(237)).setAttribute("alt","" );
      ((Element)v.get(237)).setAttribute("codigo","" );
      ((Element)v.get(237)).setAttribute("accion","" );
      ((Element)v.get(4)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(238)).setAttribute("x","13" );
      ((Element)v.get(238)).setAttribute("y","417" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("tipo","html" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("cod","12" );
      ((Element)v.get(238)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(238)).setAttribute("ontab","setTabFocus('btnAceptar')" );
      ((Element)v.get(238)).setAttribute("onshtab","setSHTabFocus('btnAceptar')" );
      ((Element)v.get(4)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(239)).setAttribute("x","71" );
      ((Element)v.get(239)).setAttribute("y","417" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("tipo","html" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("cod","2" );
      ((Element)v.get(239)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(239)).setAttribute("ontab","setTabFocus('btnModificar')" );
      ((Element)v.get(239)).setAttribute("onshtab","setSHTabFocus('btnModificar')" );
      ((Element)v.get(4)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(240)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(240)).setAttribute("alto","12" );
      ((Element)v.get(240)).setAttribute("ancho","100%" );
      ((Element)v.get(240)).setAttribute("colorf","" );
      ((Element)v.get(240)).setAttribute("borde","0" );
      ((Element)v.get(240)).setAttribute("imagenf","" );
      ((Element)v.get(240)).setAttribute("repeat","" );
      ((Element)v.get(240)).setAttribute("padding","" );
      ((Element)v.get(240)).setAttribute("visibilidad","visible" );
      ((Element)v.get(240)).setAttribute("contravsb","" );
      ((Element)v.get(240)).setAttribute("x","0" );
      ((Element)v.get(240)).setAttribute("y","439" );
      ((Element)v.get(240)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:4   */


   }

}
