/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: Viviana Bongiovanni
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.ape.DTOInsertarListaAFP;
import es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica;
import es.indra.sicc.util.DTOColeccion;

public class LPMantenimientoParametrosArmado extends LPSICCBase {

  Long pais = null;
  Long idioma = null;
       
  public LPMantenimientoParametrosArmado() {      
       super();
  }

  public void inicio() throws Exception { 
  }

  public void ejecucion() throws Exception {
    try {      
       setTrazaFichero();
       String accion = conectorParametroLimpia("accion", "", true);
       traza("accion: " + accion);
       
       pais = UtilidadesSession.getPais(this);
       idioma = UtilidadesSession.getIdioma(this);
       
       if(accion.equals("")) { 
         this.inicializar();
         
       } else if(accion.equals("guardar")){ 
         this.guardar(); 
         
       } else if(accion.equals("modificar") || accion.equals("detalle")){
         this.cargarPGInsertarParametrosArmado(); 
         
       } 
         
    } catch (Exception e){   
         traza(e);      
         this.lanzarPaginaError(e);
    }
    getConfiguracionMenu();
  }
  
  
  private void guardar() throws Exception{
      pagina("salidaGenerica");
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      String ejecutarOK = null;
      String ejecutarError = null;
      
      if(opcionMenu.equals("InsertarParametrosArmado")) {            
           ejecutarOK = "fLimpiar();";
           ejecutarError = "focalizaCD();";
      } else if(opcionMenu.equals("ModificarParametrosArmado")) { 
           ejecutarOK = "cerrarModal();";
           ejecutarError = "focalizaRegion();";
      }
      
      try {
           String hOidCabeceraListaAFP = conectorParametroLimpia("hOidCabeceraListaAFP", "", true);    
           String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
           String cbMarca = conectorParametroLimpia("cbMarca", "", true);
           String cbCanal = conectorParametroLimpia("cbCanal", "", true);
           String txtAgrupEsp = conectorParametroLimpia("txtAgrupacioEspecifica", "", true);
           
           String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);
           
           DTOInsertarListaAFP dtoInsertarListaAFP = new DTOInsertarListaAFP();
           DTOColeccion dtoColeccion = new DTOColeccion();
           ArrayList detalles= new ArrayList();
           
           traza("Detalles");
           // Arma el detalle
           if(!listaDetalles.equals("")) {
             traza("listaDetalles: " + listaDetalles);
                
             StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
             StringTokenizer stkRegDetalle = null;
             DTOAgrupacionEspecifica dtoAgrupacionEspecifica  = null;
             String oidRegion = null;
             String oidZona = null;
             String oidSeccion = null;
             int linea = 1;
                      
             while (stkListaDetalles.hasMoreTokens()) {
                stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"-");
                dtoAgrupacionEspecifica = new DTOAgrupacionEspecifica();
                
                dtoAgrupacionEspecifica.setOidCentroDistribucion(Long.valueOf(cbCentroDistribucion));
                dtoAgrupacionEspecifica.setAgrupacionEspecifica(Long.valueOf(txtAgrupEsp));
                dtoAgrupacionEspecifica.setOidMarca(Long.valueOf(cbMarca));
                dtoAgrupacionEspecifica.setOidCanal(Long.valueOf(cbCanal));
                dtoAgrupacionEspecifica.setNumeroLinea(new Long(linea));
                              
                oidRegion = stkRegDetalle.nextToken();
                dtoAgrupacionEspecifica.setOidRegion(Long.valueOf(oidRegion));
                
                oidZona = stkRegDetalle.nextToken();
                dtoAgrupacionEspecifica.setOidZona(oidZona.equals("0")?null:Long.valueOf(oidZona));
              
                oidSeccion = stkRegDetalle.nextToken();
                dtoAgrupacionEspecifica.setOidSeccion(oidSeccion.equals("0")?null:Long.valueOf(oidSeccion));
                
                traza("dtoAgrupacionEspecifica: " + dtoAgrupacionEspecifica);
                             
                detalles.add(dtoAgrupacionEspecifica);
                
                linea++;
             }
           }   
           
           
           dtoInsertarListaAFP.setOidCabeceraListaAFP(hOidCabeceraListaAFP.equals("")?null:Long.valueOf(hOidCabeceraListaAFP));
           dtoColeccion.setLista(detalles);
           dtoInsertarListaAFP.setColeccion(dtoColeccion);
           
           traza("dtoInsertarListaAFP: " + dtoInsertarListaAFP);
           
           // Guardar                
           MareBusinessID id = new MareBusinessID("APEInsertarParametrosArmado");             
           Vector paramEntrada = new Vector();
       
           paramEntrada.add(dtoInsertarListaAFP);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorInsertarParametrosArmado", paramEntrada);
           traza("*************** Despues de conectar");
           
           asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
         throw e;
      }
  }
    
    
  private void inicializar() throws Exception{

    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);
    
    if(opcionMenu.equals("InsertarParametrosArmado")) {
      pagina("contenido_parametros_armado_insertar1");  
      
      cargarPGInsertarParametrosArmado();
      
    } else {
      pagina("contenido_parametros_armado_modificar");
      
      // Titulo de la pagina
      if(opcionMenu.equals("ModificarParametrosArmado")) {
         asignarAtributoPagina("cod", "ApeParamLineaArmado.update.label");
      } else if(opcionMenu.equals("ConsultarParametrosArmado")) {
         asignarAtributoPagina("cod", "ApeParamLineaArmado.query.label");
      } else if(opcionMenu.equals("EliminarParametrosArmado")) {
         asignarAtributoPagina("cod", "ApeParamLineaArmado.remove.label");
      }
      
      cargarPGConsultarParametrosArmado();
    }
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
  }


  private void cargarPGConsultarParametrosArmado() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    
    // Titulo de la pagina
    if(opcionMenu.equals("ModificarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.update.label");
    } else if(opcionMenu.equals("ConsultarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.query.label");
    } else if(opcionMenu.equals("EliminarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.remove.label");
    }
    
    ComposerViewElementList cv = crearParametrosEntradaBusqueda();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
         
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
  }
    
  private void cargarPGInsertarParametrosArmado() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    String accion = conectorParametroLimpia("accion", "", true);
    
    if(accion.equals("modificar") || accion.equals("detalle")){
        pagina("contenido_parametros_armado_insertar1");  
    }
    
    asignarAtributo("VAR","accion","valor", accion);  
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    // Titulo de la pagina
    if(opcionMenu.equals("InsertarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.create.label");
    } else if(opcionMenu.equals("ModificarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.update.label");
    } else if(opcionMenu.equals("ConsultarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.query.label");
    } else if(opcionMenu.equals("EliminarParametrosArmado")) {
       asignarAtributoPagina("cod", "ApeParamLineaArmado.remove.label");
    }
    
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
         
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
    asignar("COMBO","cbMarca",resultados,"SEGObtenerMarcasSinFiltro");   
    asignar("COMBO","cbCanal",resultados,"SEGObtenerCanalesSinFiltro");   
    
    if(opcionMenu.equals("InsertarParametrosArmado")) {
        // Valores de defecto
        DTOBelcorp dtoBel = new DTOBelcorp();      
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);
          
        MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
        Vector params = new Vector();		
        params.addElement(dtoBel);
        params.addElement(mareBusinessID);
     
        traza("antes del conector");
        DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
        traza("despues del conector");
        
        DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
        
        asignarAtributo("VAR", "hCbCentroDistribucion", "valor", obtenerCDDef(dtoSalida));
    }
    
    if(accion.equals("modificar") || accion.equals("detalle")){
        String hOidCabeceraListaAFP = conectorParametroLimpia("oidCabeceraListaAFP", "", true);    
        String cbCentroDistribucionModif = conectorParametroLimpia("oidCentroDistribucionModif", "", true);    
        String cbMarcaModif = conectorParametroLimpia("oidMarcaModif", "", true);
        String cbCanalModif = conectorParametroLimpia("oidCanalModif", "", true);
        String txtAgrupEspModif = conectorParametroLimpia("txtAgrupacioEspecificaModif", "", true);
      
        asignarAtributo("VAR", "hOidCabeceraListaAFP", "valor", hOidCabeceraListaAFP);
        asignarAtributo("VAR", "hCbCentroDistribucionModif", "valor", cbCentroDistribucionModif);
        asignarAtributo("VAR", "hTxtAgrupacioEspecificaModif", "valor", txtAgrupEspModif);
        asignarAtributo("VAR", "hCbMarcaModif", "valor", cbMarcaModif);
        asignarAtributo("VAR", "hCbCanalMoidf", "valor", cbCanalModif);
    }
  }
  
  private String obtenerCDDef(DTOSalida dtoSalida) throws Exception{
    RecordSet valoresDef = dtoSalida.getResultado();
    String CDDef = "";
    int cant = valoresDef.getRowCount();
    
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
          traza("CDDef :" + valoresDef.getValueAt(i,"OID"));
          return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    traza("No hay CD por defecto");
    return "";
  }
  
  private ComposerViewElementList crearParametrosEntradaBusqueda() throws Exception{
      traza("metodo ComposerViewElementList");
      
      ComposerViewElementList lista = new ComposerViewElementList();
      //Combo Codigo configuracion
      ComposerViewElement descripcionesCD = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
           
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
           
      lista.addViewElement(descripcionesCD);
      
      return lista;
    }
   
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      
      ComposerViewElementList lista = new ComposerViewElementList();
      //Combo Codigo configuracion
      ComposerViewElement descripcionesCD = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
           
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
           
      lista.addViewElement(descripcionesCD);
      
      //Combo Marca
      ComposerViewElement descripcionesMarca = new ComposerViewElement();
  
      DTOUnidadAdministrativa dtoUnidAdm = new DTOUnidadAdministrativa();
      dtoUnidAdm.setOidPais(pais);
      dtoUnidAdm.setOidIdioma(idioma);
           
      descripcionesMarca.setIDBusiness("SEGObtenerMarcasSinFiltro");
      descripcionesMarca.setDTOE(dtoUnidAdm);
           
      lista.addViewElement(descripcionesMarca);
      
      //Combo Canal
      ComposerViewElement descripcionesCanal = new ComposerViewElement();
      
      descripcionesCanal.setIDBusiness("SEGObtenerCanalesSinFiltro");
      descripcionesCanal.setDTOE(dtoUnidAdm);
           
      lista.addViewElement(descripcionesCanal);
      
      return lista;
    }
    
    /*
    private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
      StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();
      
      if ( columns == null ){
         columns = new Vector();
      }
  
      Vector columsDesc = datos.getColumnIdentifiers();          
      
      DruidaConector conectorValoresPosibles = new DruidaConector();
      
      XMLDocument xmlDoc  = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");                    
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID",rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);
      
      for (int i=0; i < sizeRows; i++){
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);
  
         Element e_campo0   = docDestino.createElement("CAMPO");
  
         for(int j=0; j < sizeColums; j++){
           if( columns.contains(columsDesc.elementAt(j))){
             Element e_campo2   = docDestino.createElement("CAMPO");
             
             if(j == 0){
                e_campo0.setAttribute("NOMBRE","oculto");
             }else{
                e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
             }
             e_campo2.setAttribute("TIPO","OBJECTO");
             e_campo2.setAttribute("LONGITUD","50");
             Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
             e_campo2.appendChild(txt0);
             e_row.appendChild(e_campo2);
           }
         }
      }
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      return conectorValoresPosibles;
         }
         
         */
}

