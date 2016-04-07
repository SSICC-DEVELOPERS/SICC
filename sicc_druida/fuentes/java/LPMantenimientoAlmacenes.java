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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.bel.DTOAlmacen;

public class LPMantenimientoAlmacenes extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
          
    public LPMantenimientoAlmacenes() {      
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
            this.cargarPantalla();
            
          } else if(accion.equals("guardar")){ 
            this.guardar(); 
            
          } else if(accion.equals("modificar")|| accion.equals("detalle") || accion.equals("detalleEliminar")){ 
            this.mostrarDetalle();             
          } 
          
      } catch (Exception e){   
            traza(e);      
            this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }
    

  private void mostrarDetalle() throws Exception{
  
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);

    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);
    
    String oidAlmacen = conectorParametroLimpia("oidAlmacen", "", true);
   
    pagina("contenido_almacen_insertar");      
    
    // Titulo de la pagina
    if(opcionMenu.equals("modificar")) {
      asignarAtributoPagina("cod", "BelAlmac.update.label");
      
      anyadeHiddensI18N(true, "BEL_ALMAC", Long.valueOf(oidAlmacen), new Integer(1),
                                 "formulario", "txtDescripcion", false);
                                 
    } else if(opcionMenu.equals("consultar") && accion.equals("detalle")) {
      asignarAtributoPagina("cod", "BelAlmac.query.label");
      
      anyadeHiddensI18N(true, "BEL_ALMAC", Long.valueOf(oidAlmacen), new Integer(1),
                                 "formulario", "txtDescripcion", true);
                                 
    } else if(opcionMenu.equals("consultar") && accion.equals("detalleEliminar")) {
      asignarAtributoPagina("cod", "BelAlmac.remove.label");
      
      anyadeHiddensI18N(true, "BEL_ALMAC", Long.valueOf(oidAlmacen), new Integer(1),
                                 "formulario", "txtDescripcion", true);
    }
    
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    this.cargarCombos();    
    this.rellenarPantalla();
    
  }
  
  private void rellenarPantalla() throws Exception{
     
      traza("Entra a cargarCabecera");
      String oidAlmacen = conectorParametroLimpia("oidAlmacen", "", true);
      
      // Valores de defecto
      DTOOID dtoe = new DTOOID();      
      dtoe.setOidPais(pais);
      dtoe.setOidIdioma(idioma);
      dtoe.setOid(Long.valueOf(oidAlmacen));
          
      MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerAlmacen");
      Vector params = new Vector();                
      params.addElement(dtoe);
      params.addElement(mareBusinessID);
   
      traza("antes del conector");
      DruidaConector dc  = conectar("ConectorObtenerAlmacen", params);
      traza("despues del conector");
      
      DTOAlmacen dtoAlmacen = (DTOAlmacen)dc.objeto("DTOAlmacen");            
      
      traza("dtoAlmacen.getInfSAP():" + dtoAlmacen.getInfSAP());
      
      asignarAtributo("VAR","oidAlmacen","valor", oidAlmacen);  
      asignarAtributo("CTEXTO","codAlma","valor", dtoAlmacen.getCodAlmacen());  
      asignarAtributo("CTEXTO","txtDescripcion","valor", dtoAlmacen.getDescripcion());  
      
      if(dtoAlmacen.getInfSAP().booleanValue()){
           asignarAtributo("VAR","infSAP_detalle","valor", "S");  
      } else {
           asignarAtributo("VAR","infSAP_detalle","valor", "N");   
      }
      
      asignarAtributo("VAR","oidCentroDistribucion_detalle","valor", dtoAlmacen.getOidCentroDistribucion()!=null?dtoAlmacen.getOidCentroDistribucion().toString():"");         
  }
  
  private void guardar() throws Exception{
      pagina("salidaGenerica");
      
      String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
      String ejecutarOK = null;
      String ejecutarError = null;
      
      if(opcionMenu.equals("insertar")) {             
            ejecutarOK = "fLimpiar();";
            ejecutarError = "focalizaCod();";
      } else if(opcionMenu.equals("modificar")) { 
            ejecutarOK = "cerrarModal();";
            ejecutarError = "focalizaDesc();";
      }
      
      try {            
      
            anyadeHiddensI18N(false, "BEL_ALMAC", null, new Integer(1),
                                    "formulario", "txtDescripcion", false);
      
            String oidAlmacen = conectorParametroLimpia("oidAlmacen", "", true); 
            String codAlm = conectorParametroLimpia("codAlma", "", true); 
            String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
            String indInfoSap = conectorParametroLimpia("indInfoSap", "", true);
                  
            DTOAlmacen dtoAlmacen = new DTOAlmacen();      
            dtoAlmacen.setOid(oidAlmacen.equals("")?null:Long.valueOf(oidAlmacen));
            dtoAlmacen.setCodAlmacen(codAlm);
            dtoAlmacen.setOidCentroDistribucion(cbCentroDistribucion.equals("")?null:Long.valueOf(cbCentroDistribucion));
            dtoAlmacen.setInfSAP(indInfoSap.equals("S")?Boolean.TRUE:Boolean.FALSE);
            dtoAlmacen.setOidPais(pais);
            dtoAlmacen.setOidIdioma(idioma);
            
            traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
            dtoAlmacen.setDescAlmacen(recuperaTraduccionesI18N(new Integer(1)));            
            
            traza("dtoAlmacen: " + dtoAlmacen);
           
            MareBusinessID id = new MareBusinessID("APEGuardarAlmacen");              
            Vector paramEntrada = new Vector();
        
            paramEntrada.add(dtoAlmacen);
            paramEntrada.add(id);
            traza("*************** Antes de conectar");
            DruidaConector con = conectar("ConectorInsertarAlmacen", paramEntrada);            
            traza("*************** Despues de conectar");
            
            asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
            
      } catch(Exception e) {
          traza("Excepcion: " + e);
          asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
          throw e;
      }
  }
    
  private void cargarPantalla() throws Exception{

    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    traza("opcionMenu: " + opcionMenu);
    
    if(opcionMenu.equals("insertar")) {
      pagina("contenido_almacen_insertar");      
      asignarAtributoPagina("cod", "BelAlmac.create.label");
      
      anyadeHiddensI18N(true, "BEL_ALMAC", null, new Integer(1),
                                 "formulario", "txtDescripcion", false);
      
    } else {
      pagina("contenido_almacen_modificar");
      
      // Titulo de la pagina
      if(opcionMenu.equals("insertar")) {
          asignarAtributoPagina("cod", "BelAlmac.create.label");
                                 
      } else if(opcionMenu.equals("modificar")) {
          asignarAtributoPagina("cod", "BelAlmac.update.label");    
                                 
      } else if(opcionMenu.equals("consultar")) {
          asignarAtributoPagina("cod", "BelAlmac.query.label");
          
      } else if(opcionMenu.equals("eliminar")) {
          asignarAtributoPagina("cod", "BelAlmac.remove.label");
      }
    }
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","opcionMenu","valor", opcionMenu);  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    this.cargarCombos();
  }

    
  private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
  
    traza(resultados.getXML());
          
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
  }
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
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
}