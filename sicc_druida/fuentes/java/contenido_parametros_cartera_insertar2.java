
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_cartera_insertar2  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_cartera_insertar2" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar parámetros de cartera" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(2)).setAttribute("name","txtCodConfiguracion" );
      ((Element)v.get(2)).setAttribute("required","true" );
      ((Element)v.get(2)).setAttribute("cod","1474" );
      ((Element)v.get(2)).setAttribute("group","grupo1" );
      ((Element)v.get(2)).setAttribute("format","t" );
      ((Element)v.get(2)).setAttribute("chars","a-z1-9\\-\\+\\[\\]\\\\" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","cbNivelRiesgo" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","928" );
      ((Element)v.get(3)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbGrupoSolicitud" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","888" );
      ((Element)v.get(4)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","txtDiasDeudaVencidaPermitida" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","1479" );
      ((Element)v.get(5)).setAttribute("group","grupo2" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtFechaVigenciaDesde" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("format","F" );
      ((Element)v.get(6)).setAttribute("cod","1480" );
      ((Element)v.get(6)).setAttribute("group","grupo3" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtFechaVigenciaHasta" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("format","F" );
      ((Element)v.get(7)).setAttribute("cod","1481" );
      ((Element)v.get(7)).setAttribute("group","grupo3" );
      ((Element)v.get(1)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbIndicadorValidacion" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1482" );
      ((Element)v.get(8)).setAttribute("group","grupo3" );
      ((Element)v.get(1)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtPorcentaje" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2769" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999.99" );
      ((Element)v.get(9)).setAttribute("group","grupo3" );
      ((Element)v.get(1)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtMontoMaximoPermitido" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1484" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","9999999999.99" );
      ((Element)v.get(10)).setAttribute("group","grupo4" );
      ((Element)v.get(1)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPorcentajeMaximoPermitido" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1486" );
      ((Element)v.get(11)).setAttribute("format","n" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999.99" );
      ((Element)v.get(11)).setAttribute("group","grupo5" );
      ((Element)v.get(1)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNDiasAdicionales" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1485" );
      ((Element)v.get(12)).setAttribute("group","grupo5" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(1)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:1   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Elemento padre:13 / Elemento actual: 14   */
      v.add(doc.createTextNode("\r   \r\r  var varNoLimpiarSICC = true;\r\r        function onLoadPag(){\r            configurarMenuSecundario(\"frmInsertarCartera\");\r            btnProxy(4, '0');             \r           \r            if(get('frmInsertarCartera.casoDeUso') == 'insertar'){\r               accion('frmInsertarCartera.txtDiasDeudaVencidaPermitida','.disabled=true');\r               accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=true');\r               accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=true');\r               accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=true');\r               accion('frmInsertarCartera.txtPorcentaje','.disabled=true');\r               accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=true');\r               accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=true');\r               accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=true');\r               focaliza('frmInsertarCartera.txtCodConfiguracion');\r            }\r\r            if((get('frmInsertarCartera.casoDeUso') == 'consultarDetalle') || (get('frmInsertarCartera.casoDeUso') == 'consultarEliminar')){            \r               procesoConsultar();\r            }\r\r            if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){\r               procesoModificar();\r               focaliza('frmInsertarCartera.DiasDeudaVencida');\r            }\r    \r\r            if (get('frmInsertarCartera.casoDeUso') == 'copiar'){\r               procesoCopiar();\r            }\r\r            \r        }\r\r        function procesoConsultar(){\r              set('frmInsertarCartera.txtCodConfiguracion', get('frmInsertarCartera.hidCodConf'));\r              accion(\"frmInsertarCartera.txtCodConfiguracion\", \".disabled=true\");\r\r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidNivelRiesgo');\r              set('frmInsertarCartera.cbNivelRiesgo',iSeleccionado);\r              accion(\"frmInsertarCartera.cbNivelRiesgo\", \".disabled=true\");\r\r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidGrupoSolicitud');\r              set('frmInsertarCartera.cbGrupoSolicitud',iSeleccionado);\r              accion(\"frmInsertarCartera.cbGrupoSolicitud\", \".disabled=true\");\r \r              \r              if(get('frmInsertarCartera.hidIndDiasDeuda') == 'true'){\r                 set('frmInsertarCartera.DiasDeudaVencida', 'S');\r              }\r              accion(\"frmInsertarCartera.DiasDeudaVencida\", \".disabled=true\");\r\r              set('frmInsertarCartera.txtDiasDeudaVencidaPermitida', get('frmInsertarCartera.hidDiasDeuda'))\r              accion(\"frmInsertarCartera.txtDiasDeudaVencidaPermitida\", \".disabled=true\");\r\r              if(get('frmInsertarCartera.hidIndLineaCredito') == 'true'){\r                 set('frmInsertarCartera.LineaCredito', 'S');\r              }\r              accion(\"frmInsertarCartera.LineaCredito\", \".disabled=true\");\r              \r              set('frmInsertarCartera.txtFechaVigenciaDesde', get('frmInsertarCartera.hidFechaDesde'));\r              accion(\"frmInsertarCartera.txtFechaVigenciaDesde\", \".disabled=true\");\r              set('frmInsertarCartera.txtFechaVigenciaHasta', get('frmInsertarCartera.hidFechaHasta'));\r              accion(\"frmInsertarCartera.txtFechaVigenciaHasta\", \".disabled=true\");\r\r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidIndValidacion');\r              set('frmInsertarCartera.cbIndicadorValidacion',iSeleccionado);\r              accion(\"frmInsertarCartera.cbIndicadorValidacion\", \".disabled=true\");\r\r              set('frmInsertarCartera.txtPorcentaje', get('frmInsertarCartera.hidPorcValidacion'));\r              accion(\"frmInsertarCartera.txtPorcentaje\", \".disabled=true\");\r\r              if(get('frmInsertarCartera.hidIndMontoMax') == 'true'){\r                 set('frmInsertarCartera.MontoMaximo', 'S');\r              }\r              accion(\"frmInsertarCartera.MontoMaximo\", \".disabled=true\");\r\r              set('frmInsertarCartera.txtMontoMaximoPermitido', get('frmInsertarCartera.hidMontoMax'));\r              accion(\"frmInsertarCartera.txtMontoMaximoPermitido\", \".disabled=true\");\r\r              if(get('frmInsertarCartera.hidIndPorcMax') == 'true'){\r                 set('frmInsertarCartera.PorcentajeMaximo', 'S');\r              }\r              accion(\"frmInsertarCartera.PorcentajeMaximo\", \".disabled=true\");\r\r              set('frmInsertarCartera.txtPorcentajeMaximoPermitido', get('frmInsertarCartera.hidPorcMaxPerm'));\r              accion(\"frmInsertarCartera.txtPorcentajeMaximoPermitido\", \".disabled=true\");\r\r              set('frmInsertarCartera.txtNDiasAdicionales', get('frmInsertarCartera.hidDiasAdici'));\r              accion(\"frmInsertarCartera.txtNDiasAdicionales\", \".disabled=true\");\r        }\r\r        function procesoCopiar(){\r           var codigo = get('frmInsertarCartera.hidCodConf');\r           focaliza('frmInsertarCartera.txtCodConfiguracion');\r           set('frmInsertarCartera.txtCodConfiguracion', get('frmInsertarCartera.hidCodConf'));\r               \r           iSeleccionado = new Array(); \r           iSeleccionado[0] = get('frmInsertarCartera.hidNivelRiesgo');\r           set('frmInsertarCartera.cbNivelRiesgo',iSeleccionado);\r\r           iSeleccionado = new Array(); \r           iSeleccionado[0] = get('frmInsertarCartera.hidGrupoSolicitud');\r           set('frmInsertarCartera.cbGrupoSolicitud',iSeleccionado);\r              \r           if(get('frmInsertarCartera.hidIndDiasDeuda') == 'true'){\r              set('frmInsertarCartera.DiasDeudaVencida', 'S');\r				  accion(\"frmInsertarCartera.txtDiasDeudaVencidaPermitida\", \".disabled=false\");\r           }else accion(\"frmInsertarCartera.txtDiasDeudaVencidaPermitida\", \".disabled=true\");\r\r				  \r\r           set('frmInsertarCartera.txtDiasDeudaVencidaPermitida', get('frmInsertarCartera.hidDiasDeuda'))\r\r           if(get('frmInsertarCartera.hidIndLineaCredito') == 'true'){\r              set('frmInsertarCartera.LineaCredito', 'S');\r              accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=false');\r				  accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=false');\r				  accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=false');\r				  accion('frmInsertarCartera.txtPorcentaje','.disabled=false');\r			  }else {\r				  accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=true');\r				  accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=true');\r				  accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=true');\r				  accion('frmInsertarCartera.txtPorcentaje','.disabled=true');			  \r			  }\r							\r           set('frmInsertarCartera.txtFechaVigenciaDesde', get('frmInsertarCartera.hidFechaDesde'));\r           set('frmInsertarCartera.txtFechaVigenciaHasta', get('frmInsertarCartera.hidFechaHasta'));\r              \r           iSeleccionado = new Array(); \r           iSeleccionado[0] = get('frmInsertarCartera.hidIndValidacion');\r           set('frmInsertarCartera.cbIndicadorValidacion',iSeleccionado);\r           \r           set('frmInsertarCartera.txtPorcentaje', get('frmInsertarCartera.hidPorcValidacion'));\r\r           if(get('frmInsertarCartera.hidIndMontoMax') == 'true'){\r              set('frmInsertarCartera.MontoMaximo', 'S');\r              accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=false');\r           }else accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=true');\r              \r           set('frmInsertarCartera.txtMontoMaximoPermitido', get('frmInsertarCartera.hidMontoMax'));\r     \r           if(get('frmInsertarCartera.hidIndPorcMax') == 'true'){\r              set('frmInsertarCartera.PorcentajeMaximo', 'S');\r				  accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=false');\r				  accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=false');\r           }else{\r				  accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=true');\r				  accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=true');			  \r			  }\r              \r           set('frmInsertarCartera.txtPorcentajeMaximoPermitido', get('frmInsertarCartera.hidPorcMaxPerm'));\r           set('frmInsertarCartera.txtNDiasAdicionales', get('frmInsertarCartera.hidDiasAdici'));\r           set('frmInsertarCartera.casoDeUso', 'insertar');\r              \r        }  \r\r        function procesoModificar(){        \r              set('frmInsertarCartera.txtCodConfiguracion', get('frmInsertarCartera.hidCodConf'));\r              accion(\"frmInsertarCartera.txtCodConfiguracion\", \".disabled=true\");\r\r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidNivelRiesgo');\r              set('frmInsertarCartera.cbNivelRiesgo',iSeleccionado);\r              accion(\"frmInsertarCartera.cbNivelRiesgo\", \".disabled=true\");\r\r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidGrupoSolicitud');\r              set('frmInsertarCartera.cbGrupoSolicitud',iSeleccionado);\r              accion(\"frmInsertarCartera.cbGrupoSolicitud\", \".disabled=true\");\r               \r              if(get('frmInsertarCartera.hidIndDiasDeuda') == 'true'){\r                 set('frmInsertarCartera.DiasDeudaVencida', 'S');\r                 accion('frmInsertarCartera.txtDiasDeudaVencidaPermitida','.disabled=false');\r              }else{\r                 set('frmInsertarCartera.DiasDeudaVencida', 'N');\r                 accion('frmInsertarCartera.txtDiasDeudaVencidaPermitida','.disabled=true');\r              }\r              \r              set('frmInsertarCartera.txtDiasDeudaVencidaPermitida', get('frmInsertarCartera.hidDiasDeuda'))\r\r              if(get('frmInsertarCartera.hidIndLineaCredito') == 'true'){\r                 set('frmInsertarCartera.LineaCredito', 'S');\r                 accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=false');\r                 accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=false');\r                 accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=false');\r                 accion('frmInsertarCartera.txtPorcentaje','.disabled=false');\r              }else{\r                 set('frmInsertarCartera.LineaCredito', 'N');\r                 accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=true');\r                 accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=true');\r                 accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=true');\r                 accion('frmInsertarCartera.txtPorcentaje','.disabled=true');\r              }\r                            \r              set('frmInsertarCartera.txtFechaVigenciaDesde', get('frmInsertarCartera.hidFechaDesde'));\r              set('frmInsertarCartera.txtFechaVigenciaHasta', get('frmInsertarCartera.hidFechaHasta'));\r              \r              iSeleccionado = new Array(); \r              iSeleccionado[0] = get('frmInsertarCartera.hidIndValidacion');\r              set('frmInsertarCartera.cbIndicadorValidacion',iSeleccionado);\r\r              set('frmInsertarCartera.txtPorcentaje', get('frmInsertarCartera.hidPorcValidacion'));\r\r              if(get('frmInsertarCartera.hidIndMontoMax') == 'true'){\r                 set('frmInsertarCartera.MontoMaximo', 'S');\r                 accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=false');\r              }else{\r                 set('frmInsertarCartera.MontoMaximo', 'N');\r                 accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=true');\r              }\r\r              set('frmInsertarCartera.txtMontoMaximoPermitido', get('frmInsertarCartera.hidMontoMax'));\r\r              if(get('frmInsertarCartera.hidIndPorcMax') == 'true'){\r                 set('frmInsertarCartera.PorcentajeMaximo', 'S');\r                 accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=false');\r                 accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=false');\r              }else{\r                 set('frmInsertarCartera.PorcentajeMaximo', 'N');\r                 accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=true');\r                 accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=true');\r              }\r              \r              set('frmInsertarCartera.txtPorcentajeMaximoPermitido', get('frmInsertarCartera.hidPorcMaxPerm'));\r              set('frmInsertarCartera.txtNDiasAdicionales', get('frmInsertarCartera.hidDiasAdici'));\r\r              focaliza('frmInsertarCartera.DiasDeudaVencida');\r        }\r        \r        function fVolver(){\r           this.close();\r        }\r        \r\r        function validacionGeneral(){\r           \r\r           if(get('frmInsertarCartera.LineaCredito') == 'S'){\r              grupos += ',grupo3'\r           }\r\r           if(get('frmInsertarCartera.MontoMaximo') == 'S'){\r              grupos += ',grupo4'\r           }\r\r           if(get('frmInsertarCartera.PorcentajeMaximo') == 'S'){\r              grupos += ',grupo5'\r           }\r     \r		       if(!sicc_validaciones_generales(grupos)){\r              return false;\r           }else{\r              return true;\r           }\r        }\r        \r        function validaFechas(){\r				if (get('frmInsertarCartera.txtFechaVigenciaDesde')!= ''  && get('frmInsertarCartera.txtFechaVigenciaHasta') != ''){\r				\r				  if( EsFechaValida(get('frmInsertarCartera.txtFechaVigenciaDesde'), get('frmInsertarCartera.txtFechaVigenciaHasta'), 'frmInsertarCartera') == 0){\r					  return true;\r				  }else if ( EsFechaValida(get('frmInsertarCartera.txtFechaVigenciaDesde'), get('frmInsertarCartera.txtFechaVigenciaHasta'), 'frmInsertarCartera') == 1){\r							  GestionarMensaje('947',null,null,null);\r							  focaliza('frmInsertarCartera.txtFechaVigenciaDesde');\r							  return false;\r						 }else if( EsFechaValida(get('frmInsertarCartera.txtFechaVigenciaDesde'), get('frmInsertarCartera.txtFechaVigenciaHasta'), 'frmInsertarCartera') == 2 ){\r							  GestionarMensaje('947',null,null,null);\r							  focaliza('frmInsertarCartera.txtFechaVigenciaHasta');\r							  return false;\r						 }else if( EsFechaValida(get('frmInsertarCartera.txtFechaVigenciaDesde'), get('frmInsertarCartera.txtFechaVigenciaHasta'), 'frmInsertarCartera') == 3 ){\r							  GestionarMensaje(\"1007\");\r							  focaliza('frmInsertarCartera.txtFechaVigenciaDesde');\r							  return false;\r						 }\r\r			  }else{\r					return true;\r			  }\r        }\r\r        \r        function fGuardar(){\r          \r            var grupos = 'grupo1'; \r\r            if(!sicc_validaciones_generales('grupo1')){\r                  return;   \r\r            }\r\r            if(get('frmInsertarCartera.DiasDeudaVencida') == 'S'){\r               grupos += ',grupo2';\r\r               if(!sicc_validaciones_generales(grupos)){\r                  return;                     \r               }else{\r                  if(!validarDiasDeuda()){\r                     return;\r                  }\r               }\r            }\r\r            if(get('frmInsertarCartera.LineaCredito') == 'S'){\r              						if (get('frmInsertarCartera.txtFechaVigenciaDesde')!= '')	 {\r							grupos += ',grupo3';\r					}\r               if(!sicc_validaciones_generales(grupos)){\r                  return;                     \r               }else{\r                  if (!validaFechas()){\r                     return;\r                  }\r                \r                }\r            }\r\r            if(get('frmInsertarCartera.MontoMaximo') == 'S'){\r               grupos += ',grupo4';\r\r               if(!sicc_validaciones_generales(grupos)){\r                  return;                     \r               }\r            }\r\r            if(get('frmInsertarCartera.PorcentajeMaximo') == 'S'){\r               grupos += ',grupo5';\r\r               if(!sicc_validaciones_generales(grupos)){\r                  return;                     \r               }else{\r               \r                  if(!validarDiasAdici()){\r                     return;                  \r                  }\r               }\r            }\r            \r            set('frmInsertarCartera.conectorAction','LPParametrosCAR');\r            set('frmInsertarCartera.accion','GuardarCodigo'); \r            eval('frmInsertarCartera').oculto = 'S';\r            enviaSICC('frmInsertarCartera', '', '', 'N');           \r                  \r        }\r\r        function guardoOk(){\r              set('frmInsertarCartera.conectorAction','LPParametrosCAR');\r              set('frmInsertarCartera.accion','asignaCodigo'); \r              eval('frmInsertarCartera').oculto = 'N';\r              enviaSICC('frmInsertarCartera', '', '', 'N');\r        }\r\r        function noGuardo(){\r\r        }\r\r        function validarPorcentaje(){\r          var porcentajeValidado = fValidarFloat(get(\"frmInsertarCartera.txtPorcentaje\"), 3, 2, false, 0, 999999999999999, false);\r         \r          if(porcentajeValidado != 'OK'){\r             cdos_mostrarAlert(porcentajeValidado);\r             focaliza(\"frmInsertarCartera.txtPorcentaje\");\r             return false;\r          }else{\r             return true;\r          }\r        }\r\r        function validarDiasDeuda(){\r           var dias = get('frmInsertarCartera.txtDiasDeudaVencidaPermitida');\r           if(fValidarNumero(dias, 200, 0, 9999999)!='OK'){\r              GestionarMensaje('1393'); \r              focaliza('frmInsertarCartera.txtDiasDeudaVencidaPermitida');\r              return false;\r           }else{\r              return true;\r           }\r        }\r\r        function validarCamposPorcentaje(){\r          var porcentajeMaximoValidado = fValidarFloat(get(\"frmInsertarCartera.txtPorcentajeMaximoPermitido\"), 3, 2, false, 0, 999, false);\r         \r          if(porcentajeMaximoValidado != 'OK'){\r             cdos_mostrarAlert(porcentajeMaximoValidado);\r             focaliza(\"frmInsertarCartera.txtPorcentajeMaximoPermitido\");\r             return false;\r          }else {\r             return true;\r          }\r        }\r\r        function validarDiasAdici(){\r          var diasAdici = get('frmInsertarCartera.txtNDiasAdicionales');\r          if(fValidarNumero(diasAdici, 200, 0, 9999999)!='OK'){\r              GestionarMensaje('1393'); \r              focaliza('frmInsertarCartera.txtNDiasAdicionales');\r              return false;\r           }else{\r              return true;\r           }\r           \r\r        }\r   \r        function muestraError(){\r            \r        }\r\r        function habilitaDeudaVencida(){\r            if( get('frmInsertarCartera.DiasDeudaVencida')=='S') {\r                accion('frmInsertarCartera.txtDiasDeudaVencidaPermitida','.disabled=false');\r            }else{\r                accion('frmInsertarCartera.txtDiasDeudaVencidaPermitida','.disabled=true');\r                set('frmInsertarCartera.txtDiasDeudaVencidaPermitida', '');\r            }\r        }\r\r        \r        function habilitaLineaCredito(){\r            if(get('frmInsertarCartera.LineaCredito')=='S'){\r                accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=false');\r                accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=false');\r                accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=false'); \r                accion('frmInsertarCartera.txtPorcentaje','.disabled=false');\r            }else{\r                accion('frmInsertarCartera.txtFechaVigenciaDesde','.disabled=true');\r                accion('frmInsertarCartera.txtFechaVigenciaHasta','.disabled=true');\r                accion('frmInsertarCartera.cbIndicadorValidacion','.disabled=true'); \r                accion('frmInsertarCartera.txtPorcentaje','.disabled=true');\r                set('frmInsertarCartera.txtFechaVigenciaDesde','');\r                set('frmInsertarCartera.txtFechaVigenciaHasta','');\r                set('frmInsertarCartera.cbIndicadorValidacion','');\r                set('frmInsertarCartera.txtPorcentaje', '');\r                \r            }\r        }\r\r        function habilitaMontoMax(){\r            if(get('frmInsertarCartera.MontoMaximo')=='S'){\r                accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=false');\r            }else{\r                accion('frmInsertarCartera.txtMontoMaximoPermitido','.disabled=true');\r                set('frmInsertarCartera.txtMontoMaximoPermitido', '');\r            }\r        }\r\r        function habilitaPorcentajeMax(){\r            if(get('frmInsertarCartera.PorcentajeMaximo')=='S'){\r                accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=false');\r                accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=false');\r            }else{\r                accion('frmInsertarCartera.txtPorcentajeMaximoPermitido','.disabled=true');\r                accion('frmInsertarCartera.txtNDiasAdicionales','.disabled=true');\r                set('frmInsertarCartera.txtPorcentajeMaximoPermitido', '');\r                set('frmInsertarCartera.txtNDiasAdicionales', '');\r            }\r        }\r\r        function pasoAUnidades(){\r          set('frmInsertarCartera.conectorAction','LPParametrosCAR');\r          set('frmInsertarCartera.accion','asignaCodigo');\r          set('frmInsertarCartera.foco','false');\r          enviaSICC('frmInsertarCartera', '', '', 'N');\r        }\r\r        function pasoAUnidadesFoco(){\r          set('frmInsertarCartera.conectorAction','LPParametrosCAR');\r          set('frmInsertarCartera.accion','asignaCodigo');  \r          set('frmInsertarCartera.foco','true');          \r          enviaSICC('frmInsertarCartera', '', '', 'N');\r        }        \r\r        function fLimpiar(){\r           var casoDeUso = get('frmInsertarCartera.casoDeUso');\r\r           if(casoDeUso == 'consultarModificar'){\r              procesoModificar();          \r           }\r\r           if(casoDeUso == 'insertar'){\r              limpiarInsertar();\r           }\r        }\r\r        function limpiarInsertar(){\r      \r           set('frmInsertarCartera.txtCodConfiguracion', '');\r           set('frmInsertarCartera.cbNivelRiesgo', '');\r           set('frmInsertarCartera.cbGrupoSolicitud', '');\r           set('frmInsertarCartera.DiasDeudaVencida', 'N');\r           set('frmInsertarCartera.txtDiasDeudaVencidaPermitida', '')\r           accion(\"frmInsertarCartera.txtDiasDeudaVencidaPermitida\", \".disabled=true\");\r\r           set('frmInsertarCartera.LineaCredito', 'N');\r           set('frmInsertarCartera.txtFechaVigenciaDesde', '');\r           accion(\"frmInsertarCartera.txtFechaVigenciaDesde\", \".disabled=true\");\r           set('frmInsertarCartera.txtFechaVigenciaHasta', '');\r           accion(\"frmInsertarCartera.txtFechaVigenciaHasta\", \".disabled=true\");\r           set('frmInsertarCartera.cbIndicadorValidacion','');\r           accion(\"frmInsertarCartera.cbIndicadorValidacion\", \".disabled=true\");\r           set('frmInsertarCartera.txtPorcentaje', '');\r           accion(\"frmInsertarCartera.txtPorcentaje\", \".disabled=true\");\r\r           set('frmInsertarCartera.MontoMaximo', 'N');\r           set('frmInsertarCartera.txtMontoMaximoPermitido', '');\r           accion(\"frmInsertarCartera.txtMontoMaximoPermitido\", \".disabled=true\");\r\r           set('frmInsertarCartera.PorcentajeMaximo', 'N');\r           set('frmInsertarCartera.txtPorcentajeMaximoPermitido', '');\r           accion(\"frmInsertarCartera.txtPorcentajeMaximoPermitido\", \".disabled=true\");\r           set('frmInsertarCartera.txtNDiasAdicionales', '');\r           accion(\"frmInsertarCartera.txtNDiasAdicionales\", \".disabled=true\");\r           focaliza('frmInsertarCartera.txtCodConfiguracion');\r         }\r\r        \r         function focalizaUltimoCheck(){\r            if(get('frmInsertarCartera.casoDeUso') == 'insertar'){\r                   focaliza('frmInsertarCartera.txtCodConfiguracion');\r             \r            }\r\r            if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){\r               focaliza('frmInsertarCartera.DiasDeudaVencida');\r            }\r         }\r\r         function focalizaUltimoCheck2(){\r            if(get('frmInsertarCartera.casoDeUso') == 'insertar'){\r                 if(get('frmInsertarCartera.PorcentajeMaximo')=='N'){                   \r                   focaliza('frmInsertarCartera.txtCodConfiguracion');\r                 }else{\r                   focaliza('frmInsertarCartera.txtPorcentajeMaximoPermitido');\r                 }\r             \r            }\r\r            if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){\r               if(get('frmInsertarCartera.PorcentajeMaximo')=='N'){   \r                   focaliza('frmInsertarCartera.DiasDeudaVencida');\r               }else{\r                   focaliza('frmInsertarCartera.txtPorcentajeMaximoPermitido');\r               }\r            }\r         }\r\r         function focaliza1(){         \r            if(get('frmInsertarCartera.casoDeUso') == 'insertar'){\r               if(get('frmInsertarCartera.PorcentajeMaximo') == 'N'){\r                  pasoAUnidadesFoco();\r                                 }else{\r                  focaliza('frmInsertarCartera.txtNDiasAdicionales');\r               }\r            }\r         }\r\r         function focalizacion2(){\r            if(get('frmInsertarCartera.casoDeUso') == 'insertar'){\r               focaliza('frmInsertarCartera.cbGrupoSolicitud');\r            }\r\r            if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){\r               pasoAUnidadesFoco();\r            }\r         }\r\r         function poneManito(nombre) {          \r          var nombre = document.getElementById(nombre);\r          nombre.style.cursor = \"hand\";\r         }\r\r  \r"));
      ((Element)v.get(13)).appendChild((Text)v.get(14));

      /* Termina nodo Texto:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(15)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(16)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(17)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(18)).setAttribute("nombre","frmInsertarCartera" );
      ((Element)v.get(0)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","accion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidCodConf" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidNivelRiesgo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidGrupoSolicitud" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidIndDiasDeuda" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidDiasDeuda" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidIndLineaCredito" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidFechaDesde" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidFechaHasta" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidIndValidacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidPorcValidacion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidIndMontoMax" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidMontoMax" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidIndPorcMax" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidPorcMaxPerm" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("nombre","hidDiasAdici" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidOid" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oid" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidAsignaciones" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","indCopia" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(43)).setAttribute("valor","d/m/YYYY" );
      ((Element)v.get(18)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","marcaDefecto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","canalDefecto" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","foco" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(47)).setAttribute("nombre","capa" );
      ((Element)v.get(18)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("height","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("class","menu4" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","12" );
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","12" );
      ((Element)v.get(51)).setAttribute("height","35" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","92" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","75" );
      ((Element)v.get(57)).setAttribute("border","1" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellpadding","1" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).setAttribute("align","left" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("id","unidades" );
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("onmouseover","poneManito('unidades');" );
      ((Element)v.get(59)).setAttribute("onclick","pasoAUnidades();" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblUnidades" );
      ((Element)v.get(60)).setAttribute("ancho","150" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(60)).setAttribute("cod","0043" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:61 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","20" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","75" );
      ((Element)v.get(64)).setAttribute("border","1" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","1" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).setAttribute("align","left" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblCodigoConf" );
      ((Element)v.get(67)).setAttribute("ancho","120" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(67)).setAttribute("cod","00402" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","16" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(49)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","12" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:70 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","750" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("height","1" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:71   */

      /* Empieza nodo:78 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(83)).setAttribute("class","legend" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","legend" );
      ((Element)v.get(84)).setAttribute("cod","00202" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("colspan","4" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblCodConfiguracion" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","1474" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblNivelRiesgo" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","928" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblGrupoSolicitud" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","888" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:89   */

      /* Empieza nodo:104 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(108)).setAttribute("nombre","txtCodConfiguracion" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).setAttribute("max","3" );
      ((Element)v.get(108)).setAttribute("tipo","" );
      ((Element)v.get(108)).setAttribute("onchange","" );
      ((Element)v.get(108)).setAttribute("req","S" );
      ((Element)v.get(108)).setAttribute("size","18" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("validacion","" );
      ((Element)v.get(108)).setAttribute("onshtab","focaliza1();" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(112)).setAttribute("nombre","cbNivelRiesgo" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("size","1" );
      ((Element)v.get(112)).setAttribute("multiple","N" );
      ((Element)v.get(112)).setAttribute("req","S" );
      ((Element)v.get(112)).setAttribute("valorinicial","" );
      ((Element)v.get(112)).setAttribute("textoinicial","" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(117)).setAttribute("nombre","cbGrupoSolicitud" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("size","1" );
      ((Element)v.get(117)).setAttribute("multiple","N" );
      ((Element)v.get(117)).setAttribute("req","S" );
      ((Element)v.get(117)).setAttribute("valorinicial","" );
      ((Element)v.get(117)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:119 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:104   */

      /* Empieza nodo:121 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:85   */

      /* Empieza nodo:124 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

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

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblTipoValidacion" );
      ((Element)v.get(132)).setAttribute("ancho","90" );
      ((Element)v.get(132)).setAttribute("alto","25" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","1477" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","23" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(136)).setAttribute("nombre","DiasDeudaVencida" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("onclick","habilitaDeudaVencida()" );
      ((Element)v.get(136)).setAttribute("check","N" );
      ((Element)v.get(136)).setAttribute("onshtab","focalizacion2();" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblDiasDeudaVencida" );
      ((Element)v.get(140)).setAttribute("ancho","120" );
      ((Element)v.get(140)).setAttribute("alto","25" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","1478" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblDiasDeudaVencidaPermitida" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("cod","1479" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:128   */

      /* Empieza nodo:147 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(163)).setAttribute("nombre","txtDiasDeudaVencidaPermitida" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("max","3" );
      ((Element)v.get(163)).setAttribute("tipo","" );
      ((Element)v.get(163)).setAttribute("onchange","" );
      ((Element)v.get(163)).setAttribute("req","S" );
      ((Element)v.get(163)).setAttribute("size","4" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("validacion","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:147   */

      /* Empieza nodo:166 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(124)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","4" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:124   */

      /* Empieza nodo:169 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(169)).setAttribute("border","0" );
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("cellspacing","0" );
      ((Element)v.get(169)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","90" );
      ((Element)v.get(174)).setAttribute("height","17" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(178)).setAttribute("nombre","LineaCredito" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("onclick","habilitaLineaCredito()" );
      ((Element)v.get(178)).setAttribute("check","N" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblLineaCredito" );
      ((Element)v.get(182)).setAttribute("ancho","120" );
      ((Element)v.get(182)).setAttribute("alto","25" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","910" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblFechaVigenciaDesde" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("cod","1480" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(170)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblFechaVigenciaHasta" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("cod","1481" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblIndicadorValidacion" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("cod","1482" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblPorcentajeValidacion" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("cod","2769" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(170)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:170   */

      /* Empieza nodo:201 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(217)).setAttribute("nombre","txtFechaVigenciaDesde" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("max","10" );
      ((Element)v.get(217)).setAttribute("tipo","" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("req","N" );
      ((Element)v.get(217)).setAttribute("size","12" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(221)).setAttribute("nombre","txtFechaVigenciaHasta" );
      ((Element)v.get(221)).setAttribute("id","datosCampos" );
      ((Element)v.get(221)).setAttribute("max","10" );
      ((Element)v.get(221)).setAttribute("tipo","" );
      ((Element)v.get(221)).setAttribute("onchange","" );
      ((Element)v.get(221)).setAttribute("req","N" );
      ((Element)v.get(221)).setAttribute("size","12" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("validacion","" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(201)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(225)).setAttribute("nombre","cbIndicadorValidacion" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("size","1" );
      ((Element)v.get(225)).setAttribute("multiple","N" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(225)).setAttribute("valorinicial","" );
      ((Element)v.get(225)).setAttribute("textoinicial","" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:227 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(229)).setAttribute("class","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(230)).setAttribute("nombre","txtPorcentaje" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("max","6" );
      ((Element)v.get(230)).setAttribute("tipo","" );
      ((Element)v.get(230)).setAttribute("onchange","" );
      ((Element)v.get(230)).setAttribute("req","N" );
      ((Element)v.get(230)).setAttribute("size","8" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("validacion","" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Elemento padre:229 / Elemento actual: 231   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(229)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:229   */

      /* Empieza nodo:232 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:201   */

      /* Empieza nodo:234 / Elemento padre: 169   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(169)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("colspan","4" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:169   */

      /* Empieza nodo:237 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(237)).setAttribute("border","0" );
      ((Element)v.get(237)).setAttribute("align","center" );
      ((Element)v.get(237)).setAttribute("cellspacing","0" );
      ((Element)v.get(237)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","90" );
      ((Element)v.get(242)).setAttribute("height","17" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(246)).setAttribute("nombre","MontoMaximo" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("onclick","habilitaMontoMax()" );
      ((Element)v.get(246)).setAttribute("check","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblMontoMaximo" );
      ((Element)v.get(250)).setAttribute("ancho","120" );
      ((Element)v.get(250)).setAttribute("alto","25" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","1483" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","25" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lblMontoMaximoPermitido" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("cod","1484" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 238   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","100%" );
      ((Element)v.get(238)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:238   */

      /* Empieza nodo:257 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(257)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(257)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(257)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(273)).setAttribute("nombre","txtMontoMaximoPermitido" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("max","16" );
      ((Element)v.get(273)).setAttribute("tipo","" );
      ((Element)v.get(273)).setAttribute("onchange","" );
      ((Element)v.get(273)).setAttribute("req","S" );
      ((Element)v.get(273)).setAttribute("size","16" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(273)).setAttribute("validacion","" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","100%" );
      ((Element)v.get(257)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:257   */

      /* Empieza nodo:276 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("colspan","4" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:237   */

      /* Empieza nodo:279 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(279)).setAttribute("width","100%" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(279)).setAttribute("border","0" );
      ((Element)v.get(279)).setAttribute("align","center" );
      ((Element)v.get(279)).setAttribute("cellspacing","0" );
      ((Element)v.get(279)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","90" );
      ((Element)v.get(284)).setAttribute("height","17" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","25" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(288)).setAttribute("nombre","PorcentajeMaximo" );
      ((Element)v.get(288)).setAttribute("id","datosCampos" );
      ((Element)v.get(288)).setAttribute("onclick","habilitaPorcentajeMax()" );
      ((Element)v.get(288)).setAttribute("check","N" );
      ((Element)v.get(288)).setAttribute("ontab","focalizaUltimoCheck2();" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblPorcentajeMaximo" );
      ((Element)v.get(292)).setAttribute("ancho","120" );
      ((Element)v.get(292)).setAttribute("alto","25" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","1487" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblPorcentajeMaximoPermitido" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosCampos" );
      ((Element)v.get(296)).setAttribute("cod","1486" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblNDiasAdicionales" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("cod","1485" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(280)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:280   */

      /* Empieza nodo:303 / Elemento padre: 279   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(279)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).setAttribute("class","datosCampos" );
      ((Element)v.get(303)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(319)).setAttribute("nombre","txtPorcentajeMaximoPermitido" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("max","6" );
      ((Element)v.get(319)).setAttribute("tipo","" );
      ((Element)v.get(319)).setAttribute("onchange","" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("size","8" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("validacion","" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Elemento padre:318 / Elemento actual: 320   */
      v.add(doc.createTextNode("%\r                   	\r                   	"));
      ((Element)v.get(318)).appendChild((Text)v.get(320));

      /* Termina nodo Texto:320   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(318)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:318   */

      /* Empieza nodo:323 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","25" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(303)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(326)).setAttribute("nombre","txtNDiasAdicionales" );
      ((Element)v.get(326)).setAttribute("id","datosCampos" );
      ((Element)v.get(326)).setAttribute("max","3" );
      ((Element)v.get(326)).setAttribute("tipo","" );
      ((Element)v.get(326)).setAttribute("onchange","" );
      ((Element)v.get(326)).setAttribute("req","S" );
      ((Element)v.get(326)).setAttribute("size","3" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("validacion","" );
      ((Element)v.get(326)).setAttribute("ontab","focalizaUltimoCheck();" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:303   */

      /* Empieza nodo:329 / Elemento padre: 279   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(279)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("colspan","4" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:279   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:332 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:78   */

      /* Empieza nodo:334 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(335)).setAttribute("align","center" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","12" );
      ((Element)v.get(336)).setAttribute("height","12" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","756" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:334   */
      /* Termina nodo:70   */
      /* Termina nodo:47   */
      /* Termina nodo:18   */


   }

}
