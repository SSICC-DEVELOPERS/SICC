/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOSAlcanceTipoClienteDTO;
import es.indra.sicc.dtos.dto.DTOParametroClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroSubtipoCliente;
import es.indra.sicc.dtos.dto.DTOParametroTipoCliente;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento; 
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 * Sistema:              Belcorp - SICC
 * Modulo:                DTO - Descuentos
 * Componente:           LPMantenimientoAlcanceTipoCliente
 * Fecha:                 06/07/2004
 * Dcoumentacion:        
 *                         documentos: SICC-DMCO-DTO-201-324
 * Observaciones:
 * @version              3.0
 * @author                Cintia Verónica Argain
 * 
 * pperanzola - 03/11/2005 - [1] se modifica según DMCO-DTO-BELC300014763
 */
public class LPMantenimientoAlcanceTipoCliente  extends LPDescuentos{//[1] extends LPSICCBase {
    private Long lIdioma         = null;
    private Long lPais           = null;

    private String  sCasoDeUso = null;
    private String  sAccion = null;

         private DTOGlobalDescuento dtoGlobalDesc = null;//[1]

    public DTOOID dtoOidNumeroDescuento = new DTOOID();
    public DTODatosMatrizDescuentos dtoMatrizDescuento = new DTODatosMatrizDescuentos();

    public LPMantenimientoAlcanceTipoCliente() {
    }

    public void inicio() throws Exception {
         pagina("contenido_alcance_tipos_cliente_crear");
    }

    public void ejecucion() throws Exception {
         setTrazaFichero();

         try{
                           ///*[1]
                           if (dtoGlobalDesc == null){
                                             dtoGlobalDesc = getDescuento();
                           }
                           //*/[1]
             //this.rastreo();sCasoDeUso
             sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
                           //-> Tomar valor del parámetro "casoDeUso"              
             sCasoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
             lIdioma = UtilidadesSession.getIdioma(this);
             lPais = UtilidadesSession.getPais(this);
             

             traza(">>>> Acción................" + sAccion);
             traza(">>>> Idioma................" + lIdioma);
             traza(">>>> Pais.................." + lPais);
             traza("Cargando menu.....30-03-2005");
             traza("CU..................." + sCasoDeUso);

                           // seteo las de herencia
                           accion = sAccion;
                           casoDeUso = sCasoDeUso;
                           //
              
             /*.. Guardo la variable casodeuso en una variable del form ...*/
                           traza("SCS 1");
             asignarAtributo("VAR","hidCasoDeUso","valor",sCasoDeUso);
                           traza("SCS 2");
                           // Carga de datos              
                           //Si (casodeuso = "consultar" ó "modificar") entonces 
                           //Acción vacia
             if (sAccion.equals("") ){
                                    cargarPantalla();
             } else if (sAccion.equals("almacenar")) { 
                  this.almacenar(); 
                  redirigir(); 
                                //Acción redirigir
             } else if (sAccion.equals("redirigir")) { 
                  redirigir(); 
                                //Acción guardar
             } else if (sAccion.equals("guardar")) { 
                  this.almacenar(); 
                  guardar(); // Este método se hereda de la LPDescuentos 
                                //Acción añadir              
             } else if (sAccion.equals("aniadir")){
                                    traza("SCS llendo a ñadir....................");
                                this.añadir();
                                //Acción siguiente
             } else if (sAccion.equals("siguiente")) {
                                this.siguiente();
             }// fin else if (sAccion.equals("siguiente")) {

         }catch(Exception ex) {
                            traza("SCS vengo por aca!!....................");
              logStackTrace(ex);
                            cargarPantalla();
              this.lanzarPaginaError(ex);
         }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }

    private void guardarAlcanceTipoCliente() throws Exception {
         //try{
             traza(">>>> INGRESANDO A guardarAlcanceTipoCliente");   
             pagina("salidaGenerica");   /*Envio oculto!*/
                           if (sAccion.equals("siguiente")){
                                    traza("NO SE CERRARA LA VENTANA!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    asignarAtributo("VAR", "cerrarVentana", "valor", "false");             
                           } else {
                                    traza("SI SE CERRARA LA VENTANA!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                    asignarAtributo("VAR", "cerrarVentana", "valor", "true");
                           }
//-> Crear un objeto DTOEAlcanceTipoClienteDTO vacío 
             DTOEAlcanceTipoCliente dtoEAlcanceTipoCli= new DTOEAlcanceTipoCliente();
             dtoEAlcanceTipoCli.setOidIdioma(lIdioma);
             dtoEAlcanceTipoCli.setOidPais(lPais);
             traza("IDIOMA:   "  + lIdioma);
             //String sOidDescuento = conectorParametro("hidOidDescuento");
                           Long sOidDescuento = dtoGlobalDesc.getDatosGralesDto().getOidDescuento();
             traza(">>>> VALOR DE OID DESCUENTO RECUPERADO DE SESION:...." + sOidDescuento);
             dtoEAlcanceTipoCli.setOidDescuento(sOidDescuento);


//- tiposCliente : DTOOIDs 
//- subtiposCliente : DTOOIDs 
//- listaDescuentos : array de DTOEAlcanceClasificacionDTO 

//-> Crear un objeto DTOOIDs con los oid de los tipos de cliente seleccionados en pantalla 

             String sOidTipoCliSeleccionados = 
                           conectorParametro("hidOidTipoClienteSel")==null?"":
                           conectorParametro("hidOidTipoClienteSel");         
             DTOOIDs dtoOidsTipoCliSel   = armarDtooid( sOidTipoCliSeleccionados);
                           traza(">>>>>>> Tipos De Cliente.." + sOidTipoCliSeleccionados);
//-> Asignar objeto DTOOIDs creado al atributo DTOEAlcanceTipoClienteDTO.tiposCliente 
             dtoEAlcanceTipoCli.setTipoCliente(dtoOidsTipoCliSel);

//-> Crear un objeto DTOOIDs con los oid de los subtipos de cliente seleccionados 
//en pantalla, si no hay seleccionado ninguno tomarlos todos 
             String sOidSubTipoCliSel = 
                           conectorParametro("hidOidSubTipoClienteSel")==null?"":
                           conectorParametro("hidOidSubTipoClienteSel");         
             DTOOIDs dtoOidsSubTipoCliSel   = armarDtooid( sOidSubTipoCliSel);
                           traza("Oid SubTipo Cliente Seleccionados ..........:" + sOidSubTipoCliSel);
//traza("dtooids: " + dtoOidsSubTipoCliSel.getOids().toString());
//-> Asignar objeto DTOOIDs creado al atributo DTOEAlcanceTipoClienteDTO.subtiposCliente 

                           traza("dtoOidsSubTipoCliSel, es: " + dtoOidsSubTipoCliSel);
             dtoEAlcanceTipoCli.setSubtipoCliente(dtoOidsSubTipoCliSel);

             String sDescuentos = 
                           conectorParametro("hidDescuentos")==null?"":
                           conectorParametro("hidDescuentos");         
//Para cada línea de la lista de descuentos por tipo de clasificación y clasificación de la pantalla hacer: 
//-> Crear un objeto DTOEAlcanceClasificacionDTO 
//- oidTipoClasificacion 
//- oidClasificacion 
//- porcentajeAdicional 
//-> Meter el dto creado en el atributo DTOEAlcanceTipoCliente.listaDescuentos 
//         dtoEAlcanceTipoCli.
//Fin Para 
                  //ArrayList ListaDescuentos = aplanarDescuentos(sDescuentos);
                           traza("sOidDescuento.toString(), es: " + sOidDescuento.toString());
                           traza("sDescuentos, es: " + sDescuentos);

                  ArrayList ListaDescuentos = 
                           aplanarDescuentos(sOidDescuento.toString(), sDescuentos);
             dtoEAlcanceTipoCli.setListaDescuentos(ListaDescuentos);
//-> Crear idBusiness = "DTOGuardarAlcanceTipoCliente" 
                  MareBusinessID id = new MareBusinessID("DTOGuardarAlcanceTipoCliente");
             Vector paramEntrada = new Vector();
                  paramEntrada.add(dtoEAlcanceTipoCli);
                  paramEntrada.add(id);
//-> Asignar conector "ConectorGuardarAlcanceTipoCliente" con idBusiness y DTOEAlcanceTipoClienteDTO creado. 
                           traza("Llendo al conector. Guardando....: " + paramEntrada);
             DruidaConector conSalida = 
                           conectar("ConectorGuardarAlcanceTipoClienteDTO",paramEntrada);
             asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
             asignarAtributo("VAR","ejecutarError","valor","accionError()");
                           traza("Fin del guardarAlcanceTipoCliente"); 
        // }catch(Exception ex) {
        //     logStackTrace(ex);
        // }

    }

    void recuperaValoresConfiguracionMatrizDescuento() throws Exception {
         traza(">>>> Iniciando recuperaValoresConfiguracionMatrizDescuento");    
         //dtoMatrizDescuento = (DTODatosMatrizDescuentos)conectorParametroSesion("DTODatosMatrizDescuentos");
                  dtoMatrizDescuento = dtoGlobalDesc.getDatosMatriz();
                           
                  //(DTODatosMatrizDescuentos)conectorParametroSesion("DTODatosMatrizDescuentos");
         if (dtoMatrizDescuento == null)
                  {
                           traza("La Matriz no esta en sesión !!! " );
                           return;
                  }
                  Iterator iterador = 
                  dtoMatrizDescuento.getListaParametros().iterator();
         while (iterador.hasNext())
         {
             DTOParametroMatrizDescuentos dtoP = 
                           (DTOParametroMatrizDescuentos)iterador.next();
             String sParam = dtoP.getOidParametro().toString();
             int para = Integer.parseInt(sParam);

             switch (para){
             //------------------------------------------------------------------------------------
             case 9:
             {
                  traza("Cargando tipo de cliente");
                                    traza("sAccion, en recuperaValoresConfiguracionMatrizDescuento, es: " + sAccion);
                  if (sAccion.equals(""))
                  {
                      RecordSet rsTipoCliente = new RecordSet();

                      asignarAtributo("VAR","VisibleTiposClientes","valor",
                                             obtenerValor(dtoP.getVisible()));
                      asignarAtributo("VAR","ObligatorioTiposClientes","valor",
                                             obtenerValor(dtoP.getObligatorio()));
                      asignarAtributo("VAR","ModificableTiposClientes","valor",
                                             obtenerValor(dtoP.getModificable()));
                      if (dtoP.getNumeroMaximoValores()!=null)
                           asignarAtributo("VAR","txtNmaximoTiposClientes","valor",
                                                      dtoP.getNumeroMaximoValores().toString());
                                             
                      ArrayList arrtCliente = dtoP.getListaValoresPosibles();
                      Iterator ittCliente = arrtCliente.iterator();
                      StringBuffer st = new StringBuffer();
                      StringBuffer stClientesSel = new StringBuffer();

//--------- tipo cliente ----------------------
                      rsTipoCliente.addColumn("ID");
                      rsTipoCliente.addColumn("Descripcion");
                      rsTipoCliente.addColumn("porDef");
                      while (ittCliente.hasNext()){
                           DTOParametroTipoCliente dtoTC = 
                                                      (DTOParametroTipoCliente)ittCliente.next();
                                                  traza (">>>> SCS Tipo de Cliente " + dtoTC);
                           st.append(dtoTC.getOidTipoCliente());
                           st.append(",");
                           Vector vect = new Vector();
                           vect.add(dtoTC.getOidTipoCliente());
                           vect.add(dtoTC.getDescripcion());

                           if (dtoTC.getValorPorDefecto().booleanValue()){
                                vect.add("s");
                                stClientesSel.append(dtoTC.getOidTipoCliente());
                                                                //stClientesSel.append(dtoTC.getDescripcion());
                                stClientesSel.append(",");

                                                                traza("Oid Tipo Cliente SELECCIONADO" + dtoTC.getOidTipoCliente());
                                                                traza("Descripcion SELECCIONADO " + dtoTC.getDescripcion());
                           } else   
                                vect.add("n");
                           rsTipoCliente.addRow(vect);
                           }
                           if (rsTipoCliente.getRowCount() > 0) {
                                traza("recordset: "+rsTipoCliente);
                                Vector colIDTipoCliente  = rsTipoCliente.getColumnIdentifiers();
                                int numColTipoCliente             = 
                                                                rsTipoCliente.getColumnCount();
                                DruidaConector tipocliente        = 
                                                                generarConector("DTOSalida.resultado_ROWSET",
                                                                rsTipoCliente,colIDTipoCliente);
                                asignar("COMBO","cbTiposCliente",tipocliente,
                                                                "DTOSalida.resultado_ROWSET");                                                      
                           }

         //--------- subtipo cliente ------------------
                           StringBuffer oids = new StringBuffer();
                           StringBuffer desc = new StringBuffer();
                           StringBuffer tipoCli = new StringBuffer();
                           ArrayList arrSubtipoCliente = dtoP.getListaValoresPosibles2();
                           Iterator itstCliente = arrSubtipoCliente.iterator();

                                traza ("SCS >>>> tamaño de: arrSubtipoCliente :" + arrSubtipoCliente.size()); 

                           while (itstCliente.hasNext()){
                                DTOParametroSubtipoCliente dtoSTC = 
                                                                (DTOParametroSubtipoCliente)itstCliente.next();
                                                                traza (">>>> SubTipo de Cliente" + dtoSTC);
                                oids.append(dtoSTC.getOidSubtipoCliente());
                                desc.append(dtoSTC.getDescripcion());
                                tipoCli.append(dtoSTC.getOidTipoCliente());
                           
                                oids.append(",");
                                desc.append(",");
                                tipoCli.append(",");
                           }
    //--------- subtipo cliente ------------------ 

                           asignarAtributo("VAR", "SubtipoClienteOid", "valor", 
                                                      oids.toString());
                           asignarAtributo("VAR", "SubtipoClienteDesc", "valor", 
                                                      desc.toString());
                           asignarAtributo("VAR", "SubtipoClienteOidPadre", "valor", 
                                                      tipoCli.toString());

                           //if (st.length() >1){
                           if(stClientesSel.length() >1){
                                //StringBuffer subcadena = st;
                                StringBuffer subcadena = stClientesSel;
                                StringBuffer subcadena2 = oids;
                                asignarAtributo("VAR","selTiposClientes","valor",
                                                                subcadena.substring(0,subcadena.length()- 1));
                                asignarAtributo("VAR","selSubtiposClientes","valor",
                                                                         subcadena2.substring(0,subcadena2.length()- 1));
                                                                                  traza("selTiposClientes..:" + 
                                                                                  subcadena.substring(0,subcadena.length()- 1));
                                                                                  traza("selSubtiposClientes..:" + 
                                                                                  subcadena2.substring(0,subcadena2.length()- 1));
                           }
                                         
                  }
             }
             break;

             case 10:
             {
                  traza("Cargando Clasificaciones");
                      RecordSet rsClasificaciones = new RecordSet();
                      RecordSet rsTipoClasificacion = new RecordSet();
                      asignarAtributo("VAR","VisiblePorcentaje","valor",
                                             obtenerValor(dtoP.getVisible()));
                      asignarAtributo("VAR","ObligatorioPorcentaje","valor",
                                             obtenerValor(dtoP.getObligatorio()));
                      asignarAtributo("VAR","ModificablePorcentaje","valor",
                                             obtenerValor(dtoP.getModificable()));
                      
                                             traza("VisiblePorcentaje      " + 
                                             obtenerValor(dtoP.getVisible()));
                                             traza("ObligatorioPorcentaje  " +
                                             obtenerValor(dtoP.getObligatorio()));
                                             traza("ModificablePorcentaje  " + 
                                             obtenerValor(dtoP.getModificable()));

                  if (sAccion.equals("aniadir")) {

                      //--------- Clasificación ------------------
                      ArrayList arrtPorcentaje = dtoP.getListaValoresPosibles();
                      Iterator itPorcentaje = arrtPorcentaje.iterator();
                      StringBuffer oids = new StringBuffer();
                      StringBuffer desc = new StringBuffer();
                      StringBuffer subTipoCli = new StringBuffer();

                      //---------------- tipo clasificacion -----------------------
                      while (itPorcentaje.hasNext()){
                           DTOParametroTipoClasificacion dtotTipoClas = 
                                                      (DTOParametroTipoClasificacion)itPorcentaje.next();
                           traza("dto: "+dtotTipoClas);
                           if ((dtotTipoClas.getOidTipoClasificacion()!= null) && 
                                                                (dtotTipoClas.getDescripcionTipoClasificacion()!=null)) {
                                oids.append(dtotTipoClas.getOidTipoClasificacion());
                                desc.append(dtotTipoClas.getDescripcionTipoClasificacion());
                                subTipoCli.append(dtotTipoClas.getOidSubtipoCliente());

                                oids.append(",");
                                desc.append(",");
                                subTipoCli.append(",");

                                if (dtotTipoClas.getValorPorDefecto().booleanValue()) {
                                                                    traza("Tipo Clasificacion Elegida..............:   " + 
                                                                         dtotTipoClas.getDescripcionTipoClasificacion());
                                    traza("Oid Tipo Clasificacion.............:" +
                                                                         dtotTipoClas.getOidTipoClasificacion());
                                    asignarAtributo("VAR","hidTipoClasificacionSel","valor", 
                                                                         dtotTipoClas.getOidTipoClasificacion().toString());
                                }
                           }
                      }
                      
                      asignarAtributo("VAR", "TipoClasificacionOid", "valor", 
                                             oids.toString());
                      asignarAtributo("VAR", "TipoClasificacionDesc", "valor", 
                                             desc.toString());
                      asignarAtributo("VAR", "TipoClasificacionOidPadre", "valor", 
                                             subTipoCli.toString());
                      
                      //--------------- clasificacion -------------------------
                      oids = new StringBuffer();
                      desc = new StringBuffer();
                      StringBuffer subTipoCla = new StringBuffer();
                      ArrayList arrtPorcentaje2 = dtoP.getListaValoresPosibles2();
                      Iterator itPorcentaje2 = arrtPorcentaje2.iterator();
                      while (itPorcentaje2.hasNext()){
                           DTOParametroClasificacion dtoClas = 
                                                      (DTOParametroClasificacion)itPorcentaje2.next();
                           traza("dto: "+dtoClas);
                           if ((dtoClas.getOidClasificacion()!= null) && 
                                                                (dtoClas.getDescripcionClasificacion()!=null)) {
                                Vector vect = new Vector();
                                oids.append(dtoClas.getOidClasificacion());
                                desc.append(dtoClas.getDescripcionClasificacion());
                                subTipoCla.append(dtoClas.getOidTipoClasificacion());

                                oids.append(",");
                                desc.append(",");
                                subTipoCla.append(",");

                                if (dtoClas.getValorPorDefecto().booleanValue())
                                                                {
                                                                         traza("Clasificacion Elegida..............:   " + 
                                                                         dtoClas.getDescripcionClasificacion());
                                                                         traza("Oid Clasificacion.............:" + 
                                                                         dtoClas.getOidClasificacion());
                                    asignarAtributo("VAR","hidClasificacionSel","valor", 
                                                                                                             dtoClas.getOidClasificacion().toString());
                                }
                                
                           }
                      }
                      asignarAtributo("VAR", "ClasificacionOid", "valor", 
                                             oids.toString());
                      asignarAtributo("VAR", "ClasificacionDesc", "valor", 
                                             desc.toString());
                      asignarAtributo("VAR", "ClasificacionOidPadre", "valor", 
                                             subTipoCla.toString());
                  }
             }
             break;
 
             case 11:
             {
                  traza("Atributo descuento Cliente");
                  asignarAtributo("VAR","VisibleDescuentoCliente",
                                    "valor",obtenerValor(dtoP.getVisible()));
                  asignarAtributo("VAR","ObligatorioDescuentoCliente",
                                    "valor",obtenerValor(dtoP.getObligatorio()));
                  asignarAtributo("VAR","ModificableDescuentoCliente",
                                    "valor",obtenerValor(dtoP.getModificable()));
             }
             break;
         }//End Switch
         }
    }/*End function*/

         String obtenerValor(Boolean bool){
                           if(bool.booleanValue())
                              return "S";
                           else
                                    return "N";
         }

    private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
                  throws DOMException,Exception {
    
                  StringBuffer salida = new StringBuffer();
                  int sizeColums = datos.getColumnCount();
                  int sizeRows = datos.getRowCount();

                  if ( columns == null ){
                           columns = new Vector();
                  }

                  Vector columsDesc = datos.getColumnIdentifiers();		
                  traza("datos de generar conector:" + datos);
                  DruidaConector conectorValoresPosibles = new DruidaConector();				
                  XMLDocument xmlDoc  = new XMLDocument();
                  Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
                  Element e_rows = docDestino.createElement("ROWSET");
                  e_rows.setAttribute("ID",rowsetID);
                  docDestino.getDocumentElement().appendChild(e_rows);
                  
                  for (int i=0; i < sizeRows; i++) {
                           Element e_row = docDestino.createElement("ROW");
                           if (datos.getValueAt(i,2).toString().equals("s")) {
                           e_row.setAttribute("check", "S");
                           }
                           e_rows.appendChild(e_row);

                           for (int j=0; j < sizeColums; j++){
                                    if ( columns.contains(columsDesc.elementAt(j)) ){
                                             Element e_campo2   = docDestino.createElement("CAMPO");
                                             e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                                             e_campo2.setAttribute("TIPO","OBJECTO");
                                             e_campo2.setAttribute("LONGITUD","50");
                                             Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==
                                             null?"":datos.getValueAt(i,j).toString()));
                                             e_campo2.appendChild(txt);
                                             e_row.appendChild(e_campo2);
                                    }
                           }
                  }	
                  conectorValoresPosibles.setXML(docDestino.getDocumentElement());
                  return conectorValoresPosibles;
         }

         private DruidaConector generarConector2(String rowsetID, RecordSet datos,
                  Vector columns)	throws DOMException,Exception{
    
                  StringBuffer salida = new StringBuffer();
                  int sizeColums = datos.getColumnCount();
                  int sizeRows = datos.getRowCount();

                  if ( columns == null ){
                           columns = new Vector();
                  }

                  Vector columsDesc = datos.getColumnIdentifiers();		
                  traza("datos de generar conector:" + datos);
                  DruidaConector conectorValoresPosibles = new DruidaConector();				
                  XMLDocument xmlDoc  = new XMLDocument();
                  Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
                  Element e_rows = docDestino.createElement("ROWSET");
                  e_rows.setAttribute("ID",rowsetID);
                  docDestino.getDocumentElement().appendChild(e_rows);
                  
                  for (int i=0; i < sizeRows; i++)	{
                           Element e_row = docDestino.createElement("ROW");
                           e_rows.appendChild(e_row);

                           for (int j=0; j < sizeColums; j++){
                                    if ( columns.contains(columsDesc.elementAt(j)) ){
                                             Element e_campo2   = docDestino.createElement("CAMPO");
                                             e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                                             e_campo2.setAttribute("TIPO","OBJECTO");
                                             e_campo2.setAttribute("LONGITUD","50");
                                             Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":
                                             datos.getValueAt(i,j).toString()));
                                             e_campo2.appendChild(txt);
                                             e_row.appendChild(e_campo2);
                                    }
                           }
                  }	
                  conectorValoresPosibles.setXML(docDestino.getDocumentElement());
                  return conectorValoresPosibles;
         }

    public DTOOIDs armarDtooid(String sOidSeleccionados)throws Exception{
    
                  DTOOIDs dtoAux =  new DTOOIDs();
                  if (sOidSeleccionados.equals("") || sOidSeleccionados == null)	{
                           dtoAux	= null;
                  }else{
                           Long[] lArrayOidSels = construirLineaSeleccionada 
                           (sOidSeleccionados,"|");

                           dtoAux.setOids(lArrayOidSels);

                           dtoAux.setOidPais(lPais);
                           dtoAux.setOidIdioma(lIdioma);
                  }
                  return dtoAux;
    }

    public Long[] construirLineaSeleccionada (String elementosSeleccionados, 
                  String delim) throws Exception{

         StringTokenizer stk = new StringTokenizer(elementosSeleccionados,delim);
                  Long[] arr = new Long[stk.countTokens()];
                  int cuenta = 0;
         while (stk.hasMoreTokens()) {
                           arr[cuenta] = Long.valueOf(stk.nextToken());
                           cuenta++;
         }
         return arr;
     }
     
     ArrayList aplanarDescuentos(String sOidDescuento, String listado2STR) 
                   throws Exception
     {         
         StringTokenizer stRows = new StringTokenizer(listado2STR, "$");
         int rowCount = stRows.countTokens();
         ArrayList listaDescuentos = new ArrayList ();
         
         for(int cont =  0 ;stRows.hasMoreTokens(); cont++){

         DTOEAlcanceClasificacionDTO dtoAlcClas=  new DTOEAlcanceClasificacionDTO();
         dtoAlcClas.setOidIdioma(lIdioma);
                  dtoAlcClas.setOidPais(lPais);
                  
             StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");

                           if (stCols.hasMoreTokens()) {
                                    if (sOidDescuento != null)
                                    {
                                             dtoAlcClas.setOidDescuento(new Long(sOidDescuento));
                                    }
                  String a = stCols.nextToken();
                                    //dtoAlcClas.setOidDescuento(Long.valueOf(stCols.nextToken()));
                           }

             if (stCols.hasMoreTokens())
                                    dtoAlcClas.setOidTipoClasificacion(Long.valueOf(stCols.nextToken()));

             if (stCols.hasMoreTokens()) {
                                    Long clasificacion = Long.valueOf(stCols.nextToken());
                                    if (clasificacion.longValue() != 0){
                                             dtoAlcClas.setOidClasificacion(clasificacion);
                                    }

                           }
             
             // vbongiov -- cambio DTO-08 -- 26/06/2008
             /*if (stCols.hasMoreTokens())  
             {
                  String pd = this.desFormatearNumero(stCols.nextToken(),
                                    this.FORMATO_DEFAULT);
                  dtoAlcClas.setPorcentajeAdicional(Double.valueOf(pd));
             }*/

             if (stCols.hasMoreTokens())  
             {
                  String pd2 = stCols.nextToken();
                  dtoAlcClas.setDescTipoClasificacion(pd2);
             }

             if (stCols.hasMoreTokens())  
             {
                  String pd1 = stCols.nextToken();
                  dtoAlcClas.setDescClasificacion(pd1);
             }

             traza(dtoAlcClas);
             listaDescuentos.add(dtoAlcClas);
         }
         return  listaDescuentos;
     }
         // /*[1]

                  /*
          * @author ssaavedr
          * @date 09/11/2005
          * Descripción: Este método almacena los datos de la pestaña 'ManteniminetoAlcanceTiposClienteDTO' en el 
          * dtoDescuento (BELC300014763) 
          */
         public void almacenar() throws Exception {
                     traza(">>>> dentro de almacenar....");
                     // Se borran primero los datos existentes para luego cargarlo con la información actual 
                     DTOEAlcanceTipoCliente dtoEAlcanceTipoCli =
                     new DTOEAlcanceTipoCliente();
                     if ((dtoGlobalDesc.getAlcanceTipoCliente() != null))
                     {
                              dtoEAlcanceTipoCli = dtoGlobalDesc.getAlcanceTipoCliente();
                     }

                     //dtoEAlcanceTipoCli.setTipoCliente(new DTOOIDs());
                     //dtoEAlcanceTipoCli.setSubtipoCliente(new DTOOIDs());
                     //dtoEAlcanceTipoCli.setListaDescuentos(new ArrayList());

            //- tiposCliente : DTOOIDs 
            //- subtiposCliente : DTOOIDs 
            //- listaDescuentos : array de DTOEAlcanceClasificacionDTO 

             //-> Crear un objeto DTOOIDs con los oid de los tipos de cliente seleccionados en pantalla 
             //String sOidDescuento = conectorParametro("hidOidDescuento");

                           String sOidDescuento = null;
                           if (dtoGlobalDesc.getDatosGralesDto().getOidDescuento()!=null)
                           {
                                    sOidDescuento = 
                                    dtoGlobalDesc.getDatosGralesDto().getOidDescuento().toString();
                           }
                           
             traza(">>>> VALOR DE OID DESCUENTO RECUPERADO DE SESION:...." + sOidDescuento);

             String sOidTipoCliSeleccionados = 
                           conectorParametro("hidOidTipoClienteSel")==null?"":
                           conectorParametro("hidOidTipoClienteSel");         
             DTOOIDs dtoOidsTipoCliSel   = armarDtooid( sOidTipoCliSeleccionados);
             traza(">>>>>>> Tipos De Cliente.." + sOidTipoCliSeleccionados);

             //-> Asignar objeto DTOOIDs creado al atributo DTOEAlcanceTipoClienteDTO.tiposCliente 

                           //traza(">>>>>>> dtoOidsTipoCliSel mide.." + dtoOidsTipoCliSel.getOids().length);

             dtoEAlcanceTipoCli.setTipoCliente(dtoOidsTipoCliSel);
             traza(">>>>>>> setee TipoCliente....");
                           //-> Crear un objeto DTOOIDs con los oid de los subtipos de cliente seleccionados 
                           //en pantalla, si no hay seleccionado ninguno tomarlos todos 
             String sOidSubTipoCliSel = 
                           conectorParametro("hidOidSubTipoClienteSel")==null?"":
                           conectorParametro("hidOidSubTipoClienteSel");         
             traza(">>>>>>> sOidSubTipoCliSel.." + sOidSubTipoCliSel); 
             DTOOIDs dtoOidsSubTipoCliSel   = armarDtooid( sOidSubTipoCliSel);

                           traza("dtoOidsSubTipoCliSel, quedo ..........:" + dtoOidsSubTipoCliSel);
                           traza("Oid SubTipo Cliente Seleccionados ..........:" + sOidSubTipoCliSel);
                           //traza("dtooids: " + dtoOidsSubTipoCliSel.getOids().toString());
                           //-> Asignar objeto DTOOIDs creado al atributo DTOEAlcanceTipoClienteDTO.subtiposCliente 
             dtoEAlcanceTipoCli.setSubtipoCliente(dtoOidsSubTipoCliSel);

             String sDescuentos = 
                           conectorParametro("hidDescuentos")==null?"":
                           conectorParametro("hidDescuentos");         
                           //Para cada línea de la lista de descuentos por tipo de clasificación y clasificación de la pantalla hacer: 
                           //-> Crear un objeto DTOEAlcanceClasificacionDTO 
                           //- oidTipoClasificacion 
                           //- oidClasificacion 
                           //- porcentajeAdicional 
                           //-> Meter el dto creado en el atributo DTOEAlcanceTipoCliente.listaDescuentos 
                           //         dtoEAlcanceTipoCli.
                           //Fin Para 
                  //ArrayList ListaDescuentos = aplanarDescuentos(sDescuentos);
                           traza("voy a aplanarDescuentos(, con: " + 
                           sOidDescuento + " y con: " + sDescuentos);
                  ArrayList ListaDescuentos = 
                           aplanarDescuentos(sOidDescuento, sDescuentos);
                           traza("ListaDescuentos, quedo ..........:" + ListaDescuentos);
             dtoEAlcanceTipoCli.setListaDescuentos(ListaDescuentos);

                           dtoEAlcanceTipoCli.setOidIdioma(lIdioma);
                           dtoEAlcanceTipoCli.setOidPais(lPais);

                           dtoGlobalDesc.setIndAlcanceTipoCliente(Boolean.TRUE);
                           dtoGlobalDesc.setAlcanceTipoCliente(dtoEAlcanceTipoCli);
         }

         /*
          * @author pperanzola
          * @date 02/11/2005
          */
         public void cargarPantalla() throws Exception{
    
    traza("(en: cargarPantalla(), el dto global, tiene: " + dtoGlobalDesc);

             traza("(en: cargarPantalla())>>>> Acción................" + sAccion);
             traza("(en: cargarPantalla())CU..................." + sCasoDeUso);

         asignarAtributo("VAR","hidCasoDeUso","valor",sCasoDeUso);
                  //Si (casodeuso = "consultar" ó "modificar") entonces 
         //-> Tomar de sesión la variable "DTONumeroDescuento", que es un objeto "DTOOID" con el oid del descuento seleccionado 
              /*-> Se envía en una variable oculta el oid del descuento "oidDescuento" */
    if (sCasoDeUso.equals("consultar")){
         String modvig = (String)conectorParametroSesion("modificarVigente");
         if ("true".equals(modvig)) {
           asignarAtributoPagina("cod","0354");
         } else {
           asignarAtributoPagina("cod","0233");
         }
                  }
                  if (sCasoDeUso.equals("modificar")){
                           asignarAtributoPagina("cod","0354");
                  }
                  if (sCasoDeUso.equals("insertar")){
                           asignarAtributoPagina("cod","0644");    
                  }

         if (sCasoDeUso.equals("consultar") || sCasoDeUso.equals("modificar") || 
                           (sCasoDeUso.equals("insertar") && 
                           dtoGlobalDesc.getIndAlcanceTipoCliente().booleanValue()) ){
                           // Tomar de sesión la variable "DTONumeroDescuento", que es un objeto "DTOOID" con el oid del descuento seleccionado 
                           if (sCasoDeUso.equals("modificar")){ 
                                    getConfiguracionMenu("LPMantenimientoAlcanceTipoCliente","modificar");
                           }else{
                                    getConfiguracionMenu("LPMantenimientoAlcanceTipoCliente","consultar");
                           }
                           
                           recuperaValoresConfiguracionMatrizDescuento();

                           //-> Crear idBusiness = "DTOConsultarAlcanceTipoClienteDTO" 
             //*1 MareBusinessID id = new MareBusinessID("DTOConsultarAlcanceTipoClienteDTO");
                           //-> Asignar conector "ConectorConsultarAlcanceTipoClienteDTO" con idBusiness y dto creado y obtenido respectivamente 
                      //*1 Vector paramEntrada = new Vector();
                           //*1paramEntrada.add(dtoOidNumeroDescuento);
                           //*1paramEntrada.add(id);
                           //*1traza("antes de conectar");
                           //*1DruidaConector conector = conectar("ConectorConsultarAlcanceTipoClienteDTO",paramEntrada);
                           //*1traza("despues de conectar");                                

                           /*................. Recuperar DTOSalida respuesta ................*/
             //*1DTOSAlcanceTipoClienteDTO dtoAlcancetiCli = (DTOSAlcanceTipoClienteDTO) conector.objeto("dtoSalida");
                           DTOEAlcanceTipoCliente dtoAlcancetiCli = dtoGlobalDesc.getAlcanceTipoCliente();

             traza("dto: "+dtoAlcancetiCli);

             if ( (dtoAlcancetiCli!= null) && 
                                    (dtoGlobalDesc.getIndAlcanceTipoCliente().booleanValue()) ){
                                    
                              traza("####### SCS ###########, dentro de IF");

                //RecordSet dtoTiposCliente =   dtoAlcancetiCli.getTiposCliente();
                             /* en lugar de estar todo junto se utilizan un listado de OIDs y un Arraylist como listas paralelas
                              * para tener los oid y las descripciones
                              */
                                ArrayList descTipoCliente = new ArrayList();
                                if (dtoAlcancetiCli.getDescTipoCliente() != null){
                      traza("dtoAlcancetiCli.getDescTipoCliente() != null");
                                             descTipoCliente = dtoAlcancetiCli.getDescTipoCliente();
                                } else {
                                             traza("dtoAlcancetiCli.getDescTipoCliente() == null");
                                    }

                                    traza("####### SCS ###########, pos control de dtoAlcancetiCli.getDescTipoCliente() no nulo");

                           int cantTiposClie = 0;
                                if (dtoAlcancetiCli.getTipoCliente() != null){
                                             
                                             traza("####### SCS ###########, dentro de if");

                                             Long[] dtoTiposCliente = 
                                             dtoAlcancetiCli.getTipoCliente().getOids();

                                             traza("####### SCS ###########, tome oids");

                                             cantTiposClie = dtoTiposCliente.length;
                                             // Agregado para armar un rs y seguir con la estructura que tenia antes de rs


                                                      traza("####### SCS ###########, 1");

                                                      RecordSet rsTiposCliente = new RecordSet();
                                                      int iTipoClie;
                                             
                                                      Vector valoresTipoClie = null;
                                                      rsTiposCliente.addColumn("id");
                                                      rsTiposCliente.addColumn("descripcion");

                                                      traza("####### SCS ###########, 2");

                                                      for (iTipoClie = 0; iTipoClie < cantTiposClie; iTipoClie++){
                                                                valoresTipoClie = new Vector();
                                                                valoresTipoClie.add(dtoTiposCliente[iTipoClie]); //oid
                                                                if ((descTipoCliente!=null) && (descTipoCliente.size()>0)){
                                                                         traza("no vacio...."); 
                                                                         valoresTipoClie.add(descTipoCliente.get(iTipoClie)); //descripcion
                                                                }else{
                                    traza("vacio...."); 
                                                                         valoresTipoClie.add(" "); //descripcion
                                                                }
                                                                rsTiposCliente.addRow(valoresTipoClie);
                                                      }

                                                      traza("####### SCS ###########, 2");
                                                      //rsTiposCliente equivale a lo que antes era dtoTiposCliente

                                                      traza("rsTiposCliente tiene: " + rsTiposCliente);

                                                      if (!rsTiposCliente.esVacio()){
                                                                if (sCasoDeUso.equals("consultar") ){ 
                                                                         traza("####### SCS ###########, 3");
                                                                         Vector vecTC      = 
                                                                         rsTiposCliente.getColumnIdentifiers();
                                                                         int numColtc      = 
                                                                         rsTiposCliente.getColumnCount();
                                                                         DruidaConector tc = 
                                                                         generarConector2("DTOSalida.resultado_ROWSET",
                                                                         rsTiposCliente,vecTC);
                                                                         asignar("COMBO","cbTiposCliente",tc,
                                                                         "DTOSalida.resultado_ROWSET");     
                                                                }
                                                                StringBuffer selTipoCli = new StringBuffer();
                                                                int lon = rsTiposCliente.getRowCount();
                                                                traza("####### SCS ###########, 4");
                                                                for (int i=0;i<  lon;i++ ) {
                                                                         selTipoCli.append(rsTiposCliente.getValueAt(i,0));
                                                                         selTipoCli.append(",");
                                                                }
                                                                traza("####### SCS ###########, 5");
                                                                if (selTipoCli.length() >1){
                                                                         StringBuffer subcadena = selTipoCli;
                                                                         traza("tipos cliente seleccionados: " + selTipoCli.substring(0,subcadena.length()- 1).toString());
                                                                         asignarAtributo("VAR","selTiposClientes","valor",
                                                                         selTipoCli.substring(0,subcadena.length()- 1));
                                                                         //asignarAtributo("VAR","selTiposClientes","valor",selTipoCli.toString());
                                                                }
                                                                traza("####### SCS ###########, 6");
                                                      } // fin if (!dtoTiposCliente.esVacio()){

                                }
                                    
                  traza("####### SCS ###########, 7");                  
                //RecordSet dtoSubTipoCli   =   dtoAlcancetiCli.getSubtiposCliente();
                             /* en lugar de estar todo junto se utilizan un listado de OIDs y un Arraylist como listas paralelas
                              * para tener los oid y las descripciones
                              */
                                int cantSubTipoClie = 0;
                                if (dtoAlcancetiCli.getSubtipoCliente() != null){
                                             traza("####### SCS ###########, 8"); 
                                             ArrayList descSubTipoClie = 
                                             dtoAlcancetiCli.getDescSubTipoCliente();
 
                      Long[] dtoSubTipoCli = 
                                             dtoAlcancetiCli.getSubtipoCliente().getOids();
                                             cantSubTipoClie = dtoSubTipoCli.length;
                                             RecordSet rsSubTipoClie = new RecordSet();
                                             int iSubTipoClie;

                                             traza("####### SCS ###########, 9");
                                    
                                             Vector valoresSubTipoClie = null;
                                             rsSubTipoClie.addColumn("id");
                                             rsSubTipoClie.addColumn("descripcion");

                                             traza("####### SCS ###########, 10");

                                             for (iSubTipoClie = 0; iSubTipoClie < 
                                                      cantSubTipoClie; iSubTipoClie++){
                                                      valoresSubTipoClie = new Vector();
                                                      valoresSubTipoClie.add(dtoSubTipoCli[iSubTipoClie]);

                                                      if ((descSubTipoClie!=null) && (descSubTipoClie.size()>0)) {
                                                                valoresSubTipoClie.add(descSubTipoClie.get(iSubTipoClie));
                                                      }else{
                                                                valoresSubTipoClie.add(" ");
                                                      }
                                                      
                                                      rsSubTipoClie.addRow(valoresSubTipoClie);
                                             }		

                                             traza("rsSubTipoClie tiene: " + rsSubTipoClie);

                                             if (!rsSubTipoClie.esVacio()){
                                                      if (sCasoDeUso.equals("consultar") ) {
                                                                Vector vecSTC = rsSubTipoClie.getColumnIdentifiers();
                                                                int numColstc = rsSubTipoClie.getColumnCount();
                                                                DruidaConector stc = 
                                                                generarConector2("DTOSalida.resultado_ROWSET",rsSubTipoClie,vecSTC);
                                                                asignar("COMBO","cbSubtiposCliente",stc,"DTOSalida.resultado_ROWSET");         
                                                      }

                                                      traza("####### SCS ###########, 11");

                                                      StringBuffer selSTipoCli = new StringBuffer();
                                                      int lon = rsSubTipoClie.getRowCount();
                                                      for (int i=0;i<  lon;i++ ) {
                                                                selSTipoCli.append(rsSubTipoClie.getValueAt(i,0));
                                                                selSTipoCli.append(",");
                                                      }			
                                                      traza("####### SCS ###########, 12");
                                                      if (selSTipoCli.length() >1){
                                                                StringBuffer subcadena = selSTipoCli;
                                                                traza("subtipos cliente seleccionados: " + selSTipoCli.substring(0,subcadena.length()- 1).toString());
                                                                asignarAtributo("VAR","selSubtiposClientes",
                                                                "valor",selSTipoCli.substring(0,subcadena.length()- 1));
                                                      }
                                                      traza("####### SCS ###########, 13");
                                             }// fin if (!dtoSubTipoCli.esVacio()){
                  }
                                    traza("####### SCS ###########, 14");

                //RecordSet dtoAlcanceCli =   dtoAlcancetiCli.getAlcanceClasificacion();
                                if (dtoAlcancetiCli.getListaDescuentos() != null){
                                             traza("####### SCS ###########, 15");
                                             ArrayList listaAlcanceCli =   
                                             dtoAlcancetiCli.getListaDescuentos();
                                             if (listaAlcanceCli != null){
                                                      java.util.Iterator iterador = listaAlcanceCli.iterator();
                                                      DTOEAlcanceClasificacionDTO dtoAlcanceCli = null;
                                                      RecordSet rs = new RecordSet();
                                                      Vector vec = null;
													  int oid = 1;
                                                      traza("####### SCS ###########, 16");
                                                      for (int x=0;x<6 ;x++ ){
                                                                rs.addColumn("id");
                                                      }
                                                      while (iterador.hasNext()){
                                                                vec = new Vector();
                                                                dtoAlcanceCli = (DTOEAlcanceClasificacionDTO)iterador.next();
																// vbongiov -- SiCC 20080709 -- 3/09/2008
                                                                vec.add(new Integer(oid));
                                                                vec.add(dtoAlcanceCli.getOidTipoClasificacion());
                                                                vec.add(dtoAlcanceCli.getDescTipoClasificacion());
                                                                vec.add(dtoAlcanceCli.getOidClasificacion());
                                                                vec.add(dtoAlcanceCli.getDescClasificacion());
                                // vbongiov -- cambio DTO-08 -- 26/06/2008
                                                                //vec.add(dtoAlcanceCli.getPorcentajeAdicional());
                                                                rs.addRow(vec);

																oid++;
                                                      }
                                                      traza("####### SCS ###########, 17");
													  traza("rs: " + rs);

                                                      String listado ="listado1";
                                                      asignar("LISTADOA",listado,
                                                      UtilidadesBelcorp.generarConector("dtoSalida", 
                                                      rs,rs.getColumnIdentifiers()),"dtoSalida");
                                             }// fin if (listaAlcanceCli != null)
                                }
                                    traza("####### SCS ###########, 18");

                           }//fin if (dtoAlcancetiCli!= null){
                                    
                                    traza("####### SCS ###########, 19");

         }//Fin Si if (sCasoDeUso.equals("consultar") || sCasoDeUso.equals("modificar") ){
         else{
                           getConfiguracionMenu("LPMantenimientoAlcanceTipoCliente","");
                  }
    
    
    // Carga de combos de pantalla
                  //Si (casodeuso = "insertar" ó "modificar") entonces
                  //if (sCasoDeUso.equals("insertar") || sCasoDeUso.equals("modificar") ) {
      
      if (sCasoDeUso.equals("insertar") ) {
      //-> Tomar el valor de la variable de sesión "DTODatosMatrizDescuentos", de tipo DTODatosMatrizDescuentos 
                           //-> Tomar el valor del atributo DTODatosMatrizDescuentos.listaParametros[pos] y 
                           //para cada parámetro de la pantalla aplicar los siguientes criterios: 
                           traza("####### SCS ###########, 20");
      
      if (!(dtoGlobalDesc.getIndAlcanceTipoCliente().booleanValue())){
                      recuperaValoresConfiguracionMatrizDescuento();
                                    traza("aca");
                           }
                           //-> Aplicar los valores anteriores a la pantalla. 
         }else{//Si no entonces 
                           //-> Tomar el valor de la variable de sesión "DTODatosMatrizDescuentos", de tipo DTODatosMatrizDescuentos 
                           //-> Cargar los combos con aquellos valores posibles que coincidan con los datos recuperados del descuento
                           //recuperaValoresConfiguracionMatrizDescuento();
                           traza("aca no");                      
                           //-> Deshabilitar todos los campos, permitir sólo la consulta 
                           //-> Deshabilitar los botones "añadir" y "eliminar" 
                           //-> Dejar seleccionado el valor "No" en el RadioButton "Definir cliente" y deshabilitarlo 
      
      }//Fin Si 
         
      
      //************************************************************************
      //jsilva
      //BELC300022001
      String valorDefinirCliente = null;
      if (dtoGlobalDesc.getAlcanceCliente() != null){
         traza("dtoGlobalDesc.getAlcanceCliente() tiene contenido");
         traza("trato de contar lo que tiene dtoGlobalDesc.getAlcanceCliente().getAlcanceCliente()");
         traza("el resultado del .length es: " + dtoGlobalDesc.getAlcanceCliente().getAlcanceCliente().length);
         valorDefinirCliente = "S";
         asignarAtributo("VAR","hidChkDefinirCliente","valor",valorDefinirCliente);
      }else{
         traza("dtoGlobalDesc.getAlcanceCliente() no tiene contenido");
         valorDefinirCliente = "N";
         asignarAtributo("VAR","hidChkDefinirCliente","valor",valorDefinirCliente);
      }
      //************************************************************************
  
  
  }// fin método public void cargarPantalla() throws Exception{
           
                  /*
          * @author ssaavedr
          * @date 09/11/2005
          * Descripción: Este método almacena los datos de la pestaña 'ManteniminetoAlcanceTiposClienteDTO' en el 
          * dtoDescuento (BELC300014763) 
          */  
    public void siguiente() throws Exception{
                   //Este método realiza las acciones necesarias para pasar a la pestaña siguiente (BELC300014763) 
          if(sCasoDeUso.equals("modificar") || sCasoDeUso.equals("insertar")){
                            this.almacenar();
                   }
          String sChkDefCli = conectorParametro("hidChkDefinirCliente");
          traza("sChkDefCli........." + sChkDefCli);
                   String LPSiguiente = new String();
          if (sChkDefCli.equals("S")){
              LPSiguiente = "LPMantenimientoAlcanceCliente";
              conectorAction(LPSiguiente);
              conectorActionParametro("accion","");
                            conectorActionParametro("casoDeUso",sCasoDeUso);
                            traza(">>> Invocando LP....: " + LPSiguiente);
                            traza(">>> con accion vacia y caso de uso....: " + sCasoDeUso);
          }else{//Si no entonces 
                        if (sChkDefCli.equals("N")){
                   LPSiguiente = "LPMantenimientoAlcanceAdministrativo";
                   conectorAction(LPSiguiente);
                   conectorActionParametro("accion","");
                            conectorActionParametro("casoDeUso",sCasoDeUso);
             		 traza(">>> Invocando LP....: " + LPSiguiente);
                      	 traza(">>> con accion vacia y caso de uso....: " + sCasoDeUso);
                            }
          }//Fin si 
         } 
         // */[1]

         //Este método levanta una ventana modal para poder añadir registro a la lista definicionDescuentosAdicionales de 
         //la pantalla ManteniminetoAlcanceTiposClienteDTO (BELC300014763) 
         public void añadir() throws Exception {

                  //-> Asignar página "contenido_alcance_tipos_cliente_detalle" 
         pagina("contenido_alcance_tipos_cliente_detalle");
                                    
                  //Cristian Valenzuela 
                  //10/2/2005
                  //Incidencia Peru PE_T400000176 
                  //Se agrega la funcionalidad para el tag validacion
                  traza(">>> voy a: this.getFormatosValidaciones()");
                  this.getFormatosValidaciones();

                  traza(">>> dentro de accion añadir!!");

         getConfiguracionMenu("LPMantenimientoAlcanceTipoCliente","aniadir");
                  //-> Tomar el valor de la variable de sesión "DTODatosMatrizDescuentos", de tipo DTODatosMatrizDescuentos 
                  //-> Tomar el valor del atributo DTODatosMatrizDescuentos.listaParametros[pos] y 
                  //para cada parámetro de la pantalla aplicar los siguientes criterios: 
                  traza(">>> antes de: recuperaValoresConfiguracionMatrizDescuento()!!");
         recuperaValoresConfiguracionMatrizDescuento();
                  traza(">>> luego de: recuperaValoresConfiguracionMatrizDescuento()!!");
                  //-> Aplicar los valores anteriores a la pantalla. 
                  //-> Tomar de la pantalla llamante los subtipos de cliente seleccionados, si no hubiese ninguno se tomarán todos 
                  //(Se han de tomar los subtipos de cliente seleccionados en el combo multiselección de subtipos de cliente de la pantalla llamante) 
                  traza(">>> voy a tomar: hidSubTipoCliSel");
         String sSubTipoClieSeleccionado = conectorParametro("hidSubTipoCliSel");
                  traza(">>>>> VARIABLE sSubTipoClieSeleccionado SETEADA EN EL FORM ..........:" + sSubTipoClieSeleccionado);

                  /* Se pasan los valores al formulario de detalle*/
         asignarAtributo("VAR","hidSubTipoClienSel","valor",sSubTipoClieSeleccionado);

                  //-> Mostrar en el combo "tipoClasificacion" aquellos tipos que contengan un subtipo seleccionado en la iteración anterior 
                  //-> El combo "clasificacion" mostrará aquellas clasificaciones que tengan como 
                  //tipo de clasificación el tipo de clasificación seleccionado

                  //-> Mostrar la pantalla vacía para el usuario introduzca los datos y pulse el botón "aceptar" 

         }
}