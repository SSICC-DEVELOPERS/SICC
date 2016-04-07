
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_movimiento_caja_realizar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_movimiento_caja_realizar" );
      ((Element)v.get(0)).setAttribute("cod","0674" );
      ((Element)v.get(0)).setAttribute("titulo","Realizar movimiento de caja" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r\r    configurarMenuSecundario(\"formulario\");\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden'; \r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"btnAnadirDiv\"].style.visibility='';\r    document.all[\"btnModificarDiv\"].style.visibility='';\r    eval (ON_RSZ);  \r\r        listado1.alternaVerColumna(10,null);\r        listado1.alternaVerColumna(11,null);\r        listado1.alternaVerColumna(12,null);\r        listado1.alternaVerColumna(13,null);\r        listado1.alternaVerColumna(14,null);\r\r		fMostrarMensajeError();\r        redireccionar();\r    \r  }\r\r  function redireccionar(){\r\r      var error = get('formulario.errCodigo');\r\r      if(error == '30103'){\r         set('formulario.conectorAction', 'LPInicioBelcorp');\r         enviaSICC('formulario');\r\r      }\r\r   }\r  /** \r   * Método para abrir Añadir\r   * @param void\r   * @return void\r   * @exception n/a \r   * @author enozigli\r   */  \r  function accionAnadir(){\r    \r      var obj = new Object();\r      obj.accion = \"añadir\";\r      obj.oidSubacceso = get('formulario.oidSubacceso');\r      \r      var vWnd = mostrarModalSICC('LPRealizarMovimientoCaja','añadir',obj,775,305);\r      if (vWnd!=null){\r                       \r         var arr = new Array();\r          \r         arr[arr.length] = listado1.generaCodigo();\r         arr[arr.length] = vWnd[0]; \r         arr[arr.length] = vWnd[1]; \r         arr[arr.length] = vWnd[2]; \r         arr[arr.length] = vWnd[3];\r         arr[arr.length] = vWnd[4];\r         arr[arr.length] = vWnd[5];\r         arr[arr.length] = vWnd[6];\r         arr[arr.length] = vWnd[7];\r         arr[arr.length] = vWnd[8];\r         arr[arr.length] = vWnd[9];\r         arr[arr.length] = vWnd[10];\r         arr[arr.length] = vWnd[11];\r         arr[arr.length] = vWnd[12];\r         arr[arr.length] = vWnd[13];\r         arr[arr.length] = vWnd[14];\r\r         listado1.insertar(arr);\r         listado1.repinta();\r         btnProxy(1,'1');\r         btnProxy(4,'1');\r\r         \r          /*  toAdd =  toAdd + \"|\" + dejaEsp(objRes.tipoMovimientoCaja);               \r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.medioPago);            \r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.Moneda);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.importe);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.importeDivisa);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.nroCheque);            \r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.Banco);            \r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.tipoTarjeta);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.nroTarjeta);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.nroValeCompra);\r            \r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.oidTipoMovimientoCaja);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.oidMedioPago);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.oidMoneda);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.oidBanco);\r            toAdd =  toAdd + \"|\" + dejaEsp(objRes.oidTipoTarjeta);\r\r            objRes.tipoMovimientoCaja = \"\";\r            objRes.medioPago = \"\";  \r            objRes.Moneda = \"\";\r            objRes.importe = \"\";\r            objRes.importeDivisa = \"\";\r            objRes.nroCheque = \"\";\r            objRes.Banco = \"\";\r            objRes.tipoTarjeta = \"\";\r            objRes.nroTarjeta = \"\";\r            objRes.nroValeCompra = \"\";\r            objRes.oidTipoMovimientoCaja = \"\";\r            objRes.oidMedioPago = \"\";\r            objRes.oidMoneda = \"\";\r            objRes.oidBanco = \"\";\r            objRes.oidTipoTarjeta = \"\";\r            objRes.resultado = \"\";\r            \r           agregaListaTemporal(toAdd);*/\r      }\r  }\r  function fBorrar(){\r    accionEliminar();\r  }\r  /** \r   * Método para eliminar detalle movimiento caja\r   * @param void\r   * @return void\r   * @exception n/a \r   * @author enozigli\r   */    \r  function accionEliminar(){\r      var codigos = new Array();\r      codigos = listado1.codSeleccionados();\r      var cant = codigos.length;\r      if (cant >= 1){\r                     listado1.eliminarSelecc();\r           if (listado1.datos.length==0){\r                btnProxy(1,'0');\r                btnProxy(4,'0');\r           }\r      }else{\r          var valo = GestionarMensaje('4', null, null, null);\r      }   \r  }\r  /** \r   * Método para modificar un detalle de movimiento caja\r   * @param void\r   * @return void\r   * @exception n/a \r   * @author enozigli\r   */    \r  function accionModificar(){\r      var codigos = new Array();\r      codigos = listado1.codSeleccionados();\r      var cant = codigos.length;\r            if (cant == 1){\r          var obj = new Object();\r          obj.accion = \"modificar\";\r          obj.oidSubacceso = get('formulario.oidSubacceso');                   \r          obj.tipoMovimientoCaja = listado1.extraeDato (codigos[0], 0) ;\r          obj.medioPago = listado1.extraeDato (codigos[0], 1);  \r          obj.Moneda = listado1.extraeDato (codigos[0], 2);\r          obj.importe = listado1.extraeDato (codigos[0], 3);\r          obj.importeDivisa = listado1.extraeDato (codigos[0], 4);\r          obj.nroCheque = listado1.extraeDato (codigos[0], 5);\r          obj.Banco = listado1.extraeDato (codigos[0], 6);\r          obj.tipoTarjeta = listado1.extraeDato (codigos[0], 7);\r          obj.nroTarjeta = listado1.extraeDato (codigos[0], 8);\r          obj.nroValeCompra = listado1.extraeDato (codigos[0], 9);\r          obj.oidTipoMovimientoCaja = listado1.extraeDato (codigos[0], 10);\r          obj.oidMedioPago = listado1.extraeDato (codigos[0], 11);\r          obj.oidMoneda = listado1.extraeDato (codigos[0], 12);\r          obj.oidBanco = listado1.extraeDato (codigos[0], 13);\r          obj.oidTipoTarjeta = listado1.extraeDato (codigos[0], 14);          \r          \r          var vWnd = mostrarModalSICC('LPRealizarMovimientoCaja','modificar',obj,775,305);\r\r          if (vWnd!=null){\r\r             listado1.eliminarSelecc();\r\r             var arr = new Array();\r          \r             arr[arr.length] = listado1.generaCodigo();\r             arr[arr.length] = vWnd[0]; \r             arr[arr.length] = vWnd[1]; \r             arr[arr.length] = vWnd[2]; \r             arr[arr.length] = vWnd[3];\r             arr[arr.length] = vWnd[4];\r             arr[arr.length] = vWnd[5];\r             arr[arr.length] = vWnd[6];\r             arr[arr.length] = vWnd[7];\r             arr[arr.length] = vWnd[8];\r             arr[arr.length] = vWnd[9];\r             arr[arr.length] = vWnd[10];\r             arr[arr.length] = vWnd[11];\r             arr[arr.length] = vWnd[12];\r             arr[arr.length] = vWnd[13];\r             arr[arr.length] = vWnd[14];\r\r             listado1.insertar(arr);\r             listado1.repinta();\r            \r          }          \r      }else{\r          var valo = GestionarMensaje('4', null, null, null);\r      } \r  }\r  /** \r   * Método para guardar el movimiento de caja\r   * @param void\r   * @return void\r   * @exception n/a \r   * @author enozigli\r   */    \r  function accionGuardar(){\r     if (listado1.datos.length > 0){\r                    var listadoSeleccionado = listado1string();\r          set('formulario.listado1STR', listadoSeleccionado);\r          set('formulario.accion', 'guardar');\r          set('formulario.conectorAction', 'LPRealizarMovimientoCaja');\r          enviaSICC('formulario'); \r     }\r  }  \r  function fGuardar(){\r    accionGuardar();\r  } \r\r  function agregaListaTemporal(datos){            \r     var newRow = new Array();\r     newRow = datos.split(\"|\");\r     listado1.insertar(newRow);\r     btnProxy(1,'1');\r     btnProxy(4,'1');\r  }\r  function modificaListaTemporal(datos){\r      listado1.eliminarSelecc();\r       var newRow = new Array();\r       newRow = datos.split(\"|\");\r       listado1.insertar(newRow);       \r  }   \r  function listado1string(){\r	  var toAdd = \"\";\r      var total = \"\";   \r\r      \r      for(var a = 0; a < listado1.datos.length ; a++){                  \r           toAdd = listado1.datos[a][0];\r           toAdd = toAdd + \"|\" + listado1.datos[a][1];\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][2]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][3]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][4]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][5]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][6]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][7]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][8]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][9]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][10]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][11]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][12]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][13]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][14]);\r           toAdd = toAdd + \"|\" + dejaEsp(listado1.datos[a][15]);                         \r           total = total + \"$\" + toAdd;\r      }   \r      return total;\r  }  \r  function dejaEsp(a){\r    if (a.length == 0){\r        return ' ';\r    } else {\r        return a;\r    }\r  }\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","LPRealizarMovimientoCaja" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidAcceso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidSubacceso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidCaja" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","habAniadir" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","habModificar" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","habEliminar" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","listado1STR" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hUsuario" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hNumMovimiento" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hFecha" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("cod","00156" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","630" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","4" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","7" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","10" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","25" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(56)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","datosTitle" );
      ((Element)v.get(56)).setAttribute("cod","122" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:44   */

      /* Empieza nodo:59 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(59));

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
      ((Element)v.get(63)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(67)).setAttribute("nombre","lbldtAcceso" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 59   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lbldtSubacceso" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
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

      /* Empieza nodo:74 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("colspan","4" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:77 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("table"));
      ((Element)v.get(79)).setAttribute("width","630" );
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblCaja" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","1573" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblFecha" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","188" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblNumMovimiento" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","2311" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:80   */

      /* Empieza nodo:95 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(95));

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
      ((Element)v.get(99)).setAttribute("nombre","lbldtCaja" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(103)).setAttribute("nombre","lbldtFecha" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(107)).setAttribute("nombre","lbldtNumMovimiento" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:95   */

      /* Empieza nodo:110 / Elemento padre: 79   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("colspan","4" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:113 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","636" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("align","left" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","169" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:116   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(127)).setAttribute("cols","50" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("msjreq","" );
      ((Element)v.get(127)).setAttribute("nombre","atxtObservaciones" );
      ((Element)v.get(127)).setAttribute("readonly","N" );
      ((Element)v.get(127)).setAttribute("req","N" );
      ((Element)v.get(127)).setAttribute("rows","3" );
      ((Element)v.get(127)).setAttribute("tabindex","2" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("max","100" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:123   */

      /* Empieza nodo:130 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("colspan","4" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:133 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:30   */

      /* Empieza nodo:135 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(137)).setAttribute("height","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","750" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:135   */
      /* Termina nodo:22   */

      /* Empieza nodo:142 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(142)).setAttribute("nombre","listado1" );
      ((Element)v.get(142)).setAttribute("ancho","640" );
      ((Element)v.get(142)).setAttribute("alto","317" );
      ((Element)v.get(142)).setAttribute("x","12" );
      ((Element)v.get(142)).setAttribute("y","189" );
      ((Element)v.get(142)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(142)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(143)).setAttribute("precarga","S" );
      ((Element)v.get(143)).setAttribute("conROver","S" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(144)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(144)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(144)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(144)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 143   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(145)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(145)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(145)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(145)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(143)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(146)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(146)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:143   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(148)).setAttribute("borde","1" );
      ((Element)v.get(148)).setAttribute("horizDatos","1" );
      ((Element)v.get(148)).setAttribute("horizCabecera","1" );
      ((Element)v.get(148)).setAttribute("vertical","1" );
      ((Element)v.get(148)).setAttribute("horizTitulo","1" );
      ((Element)v.get(148)).setAttribute("horizBase","1" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(149)).setAttribute("borde","#999999" );
      ((Element)v.get(149)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(149)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(149)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(149)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(149)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(149)).setAttribute("horizBase","#999999" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(150)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(150)).setAttribute("alto","22" );
      ((Element)v.get(150)).setAttribute("imgFondo","" );
      ((Element)v.get(150)).setAttribute("cod","00133" );
      ((Element)v.get(150)).setAttribute("ID","datosTitle" );
      ((Element)v.get(142)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(151)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(151)).setAttribute("alto","22" );
      ((Element)v.get(151)).setAttribute("imgFondo","" );
      ((Element)v.get(142)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 142   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(152)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(152)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(152)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(152)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(152)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(152)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(142)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","150" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","100" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("ancho","80" );
      ((Element)v.get(155)).setAttribute("minimizable","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(155)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("ancho","80" );
      ((Element)v.get(156)).setAttribute("minimizable","S" );
      ((Element)v.get(156)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","100" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","100" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","80" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","100" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","100" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","100" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(152)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","0" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","S" );
      ((Element)v.get(152)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("ancho","0" );
      ((Element)v.get(164)).setAttribute("minimizable","S" );
      ((Element)v.get(164)).setAttribute("minimizada","S" );
      ((Element)v.get(152)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","0" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","S" );
      ((Element)v.get(152)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","0" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","S" );
      ((Element)v.get(152)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","0" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","S" );
      ((Element)v.get(152)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:152   */

      /* Empieza nodo:168 / Elemento padre: 142   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(168)).setAttribute("alto","20" );
      ((Element)v.get(168)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(168)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(142)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","2312" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","673" );
      ((Element)v.get(168)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","1216" );
      ((Element)v.get(168)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","573" );
      ((Element)v.get(168)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","668" );
      ((Element)v.get(168)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","2305" );
      ((Element)v.get(168)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","617" );
      ((Element)v.get(168)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","1130" );
      ((Element)v.get(168)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","2306" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 168   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","2307" );
      ((Element)v.get(168)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:168   */

      /* Empieza nodo:179 / Elemento padre: 142   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(179)).setAttribute("alto","22" );
      ((Element)v.get(179)).setAttribute("accion","" );
      ((Element)v.get(179)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(179)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(179)).setAttribute("maxSel","-1" );
      ((Element)v.get(179)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(179)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(179)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(179)).setAttribute("onLoad","" );
      ((Element)v.get(179)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(142)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("tipo","texto" );
      ((Element)v.get(183)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat2" );
      ((Element)v.get(179)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat" );
      ((Element)v.get(179)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:179   */

      /* Empieza nodo:195 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 142   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(196)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(196)).setAttribute("ancho","640" );
      ((Element)v.get(196)).setAttribute("sep","$" );
      ((Element)v.get(196)).setAttribute("x","12" );
      ((Element)v.get(196)).setAttribute("class","botonera" );
      ((Element)v.get(196)).setAttribute("y","483" );
      ((Element)v.get(196)).setAttribute("control","|" );
      ((Element)v.get(196)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(196)).setAttribute("rowset","" );
      ((Element)v.get(196)).setAttribute("cargainicial","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(197)).setAttribute("nombre","ret1" );
      ((Element)v.get(197)).setAttribute("x","37" );
      ((Element)v.get(197)).setAttribute("y","487" );
      ((Element)v.get(197)).setAttribute("ID","botonContenido" );
      ((Element)v.get(197)).setAttribute("img","retroceder_on" );
      ((Element)v.get(197)).setAttribute("tipo","0" );
      ((Element)v.get(197)).setAttribute("estado","false" );
      ((Element)v.get(197)).setAttribute("alt","" );
      ((Element)v.get(197)).setAttribute("codigo","" );
      ((Element)v.get(197)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","ava1" );
      ((Element)v.get(198)).setAttribute("x","52" );
      ((Element)v.get(198)).setAttribute("y","487" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("img","avanzar_on" );
      ((Element)v.get(198)).setAttribute("tipo","0" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("alt","" );
      ((Element)v.get(198)).setAttribute("codigo","" );
      ((Element)v.get(198)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:196   */
      /* Termina nodo:142   */

      /* Empieza nodo:199 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","primera1" );
      ((Element)v.get(199)).setAttribute("x","20" );
      ((Element)v.get(199)).setAttribute("y","487" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("img","primera_on" );
      ((Element)v.get(199)).setAttribute("tipo","-2" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("alt","" );
      ((Element)v.get(199)).setAttribute("codigo","" );
      ((Element)v.get(199)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(200)).setAttribute("nombre","separa" );
      ((Element)v.get(200)).setAttribute("x","59" );
      ((Element)v.get(200)).setAttribute("y","483" );
      ((Element)v.get(200)).setAttribute("ID","botonContenido" );
      ((Element)v.get(200)).setAttribute("img","separa_base" );
      ((Element)v.get(200)).setAttribute("tipo","0" );
      ((Element)v.get(200)).setAttribute("estado","false" );
      ((Element)v.get(200)).setAttribute("alt","" );
      ((Element)v.get(200)).setAttribute("codigo","" );
      ((Element)v.get(200)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(201)).setAttribute("x","13" );
      ((Element)v.get(201)).setAttribute("y","484" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("img","" );
      ((Element)v.get(201)).setAttribute("tipo","html" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("cod","404" );
      ((Element)v.get(201)).setAttribute("accion","accionAnadir();" );
      ((Element)v.get(5)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(202)).setAttribute("x","61" );
      ((Element)v.get(202)).setAttribute("y","484" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","" );
      ((Element)v.get(202)).setAttribute("tipo","html" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("cod","2" );
      ((Element)v.get(202)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(5)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(203)).setAttribute("x","127" );
      ((Element)v.get(203)).setAttribute("y","484" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","" );
      ((Element)v.get(203)).setAttribute("tipo","html" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("cod","1254" );
      ((Element)v.get(203)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(5)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(204)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(204)).setAttribute("alto","12" );
      ((Element)v.get(204)).setAttribute("ancho","100%" );
      ((Element)v.get(204)).setAttribute("colorf","" );
      ((Element)v.get(204)).setAttribute("borde","0" );
      ((Element)v.get(204)).setAttribute("imagenf","" );
      ((Element)v.get(204)).setAttribute("repeat","" );
      ((Element)v.get(204)).setAttribute("padding","" );
      ((Element)v.get(204)).setAttribute("visibilidad","visible" );
      ((Element)v.get(204)).setAttribute("contravsb","" );
      ((Element)v.get(204)).setAttribute("x","0" );
      ((Element)v.get(204)).setAttribute("y","506" );
      ((Element)v.get(204)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:5   */


   }

}
