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
import java.util.Date;
import java.sql.Timestamp;
import es.indra.sicc.util.UtilidadesFecha;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.ape.DTOBuscarCaja;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTODatosCajaCabecera;
import es.indra.sicc.dtos.ape.DTODatosCajaDetalle;
import es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.ape.DTOBuscarProducto;

import es.indra.sicc.util.DTOColeccion;

public class LPChequearCajas extends LPSICCBase {

  Long pais = null;
  Long idioma = null;
        
  public LPChequearCajas() {      
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
          this.cargarPagina();
          
        } else if(accion.equals("buscarCaja")){ 
          this.buscarCaja(); 
          
        } else if(accion.equals("chequearUnidades")){
          this.chequearUnidades(); 
          
        } else if(accion.equals("agregarSobrante")){
          this.agregarSobrante(); 
          
        } else if(accion.equals("actualizarCaja")){
          this.actualizarCaja(); 
        }
          
    } catch (Exception e){   
          traza(e);      
          this.lanzarPaginaError(e);
    }
    getConfiguracionMenu();
  }
  
  private void actualizarCaja() throws Exception{  
    pagina("salidaGenerica");
 
    try {            
          String numCaja = conectorParametroLimpia("hCaja", "", true); 
          String oidEtiqueta = conectorParametroLimpia("hOidEtiqueta", "", true); 
          String oidListaPicadoCabecera = conectorParametroLimpia("hOidListaPicadoCabecera", "", true); 
          String oidTipoCajaEmbalaje = conectorParametroLimpia("hOidTipoCajaEmbalaje", "", true);
          String horaInicioChequeo = conectorParametroLimpia("hHoraInicioChequeo", "", true);
          String horaFinChequeo = conectorParametroLimpia("hHoraFinChequeo", "", true);
          // vbongiov -- Cambio APE-012 -- 20/05/2008
          String numConsolidado = conectorParametroLimpia("hNumConsolidado", "", true);
          
          String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);
         
          DTODatosCajaCabecera dtoDatosCajaCabecera  = new DTODatosCajaCabecera();
          DTODatosCajaDetalle dtoDatosCajaDetalle = null;
          ArrayList detalles= new ArrayList();
          
          dtoDatosCajaCabecera.setNumeroCaja(Long.valueOf(numCaja));
          dtoDatosCajaCabecera.setOidEtiqueta(Long.valueOf(oidEtiqueta));
          dtoDatosCajaCabecera.setOidListaPicadoCabecera(Long.valueOf(oidListaPicadoCabecera));
          dtoDatosCajaCabecera.setOidTipoCajaEmbalaje(oidTipoCajaEmbalaje.equals("")?null:Long.valueOf(oidTipoCajaEmbalaje));
          
          dtoDatosCajaCabecera.setUsuarioChequeador(UtilidadesSession.getIdUsuario(this));
          
          traza("fecha inicio: " + horaInicioChequeo);
          Timestamp fechaInicio = UtilidadesFecha.convertirATimestamp(horaInicioChequeo, "dd/MM/yyyy hh:mm:ss");          
          dtoDatosCajaCabecera.setHoraInicioChequeo(fechaInicio);
          
          traza("fecha fin: " + horaFinChequeo);
          Timestamp fechaFin = UtilidadesFecha.convertirATimestamp(horaFinChequeo, "dd/MM/yyyy hh:mm:ss");          
          dtoDatosCajaCabecera.setHoraFinChequeo(fechaFin);   
          
          // vbongiov -- Cambio APE-012 -- 20/05/2008
          dtoDatosCajaCabecera.setNumeroConsolidado(Long.valueOf(numConsolidado));
          
          // Detalles
          StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
          StringTokenizer stkRegDetalle = null;
          String oidListaPicadoDetalle = null;
          String oidProducto = null;
          String oidMapaCDDetalle = null;
          String cantChequeada = null;
          String oidCodigoErrorChequeo = null;
          
          traza("listaDetalles: " + listaDetalles);
          
          while (stkListaDetalles.hasMoreTokens()) {
             stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"#");             
             dtoDatosCajaDetalle = new DTODatosCajaDetalle();
          
             oidListaPicadoDetalle = stkRegDetalle.nextToken();   
             dtoDatosCajaDetalle.setOidListaPicadoDetalle(oidListaPicadoDetalle.equals("BLANCO")?null:Long.valueOf(oidListaPicadoDetalle));
             
             oidProducto = stkRegDetalle.nextToken();   
             dtoDatosCajaDetalle.setOidProducto(oidProducto.equals("BLANCO")?null:Long.valueOf(oidProducto));
             
             oidMapaCDDetalle = stkRegDetalle.nextToken();   
             dtoDatosCajaDetalle.setOidMapaCDDetalle(oidMapaCDDetalle.equals("BLANCO")?null:Long.valueOf(oidMapaCDDetalle));
             
             cantChequeada = stkRegDetalle.nextToken();   
             dtoDatosCajaDetalle.setCantidadChequeada(Long.valueOf(cantChequeada));
             
             oidCodigoErrorChequeo = stkRegDetalle.nextToken();   
             dtoDatosCajaDetalle.setOidCodigoErrorChequeo(oidCodigoErrorChequeo.equals("BLANCO")?null:Long.valueOf(oidCodigoErrorChequeo));         
             
             detalles.add(dtoDatosCajaDetalle);
          }
          
          dtoDatosCajaCabecera.setDetalles(detalles);
          
          traza("dtoDatosCajaCabecera: " + dtoDatosCajaCabecera);          
          
          MareBusinessID id = new MareBusinessID("APEActualizarCaja");              
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoDatosCajaCabecera);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorActualizarCaja", paramEntrada);
          traza("*************** Despues de conectar");
          
          asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
          
    } catch(Exception e) {
        traza("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", "focalizaFC();");
        throw e;
    }
    
  }
  
  
   private void agregarSobrante() throws Exception{  
    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);

         // BELC400000722 - dmorello, 12/09/2007
         String oidPeriodo = conectorParametroLimpia("hOidPeriodo", "", true);
         traza("oidPeriodo" + oidPeriodo);
        
    pagina("contenido_agregar_sobrante");  
      
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","accion","valor", accion);
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));

         // BELC400000722 - dmorello, 12/09/2007
    asignarAtributo("VAR","hOidPeriodo","valor", oidPeriodo);
  }
  
   private void chequearUnidades() throws Exception{  
    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);
        
    pagina("contenido_cajas_producto_actualizar");  
      
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","accion","valor", accion);
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    String descProd = conectorParametroLimpia("descProd", "", true);
    String cantidadRequerida = conectorParametroLimpia("cantidadRequerida", "", true);
    
    asignarAtributo("VAR","hDescProd","valor", descProd);
    asignarAtributo("VAR","hUnidadesListaPicado","valor", cantidadRequerida);
    
    asignarAtributo("VAR","OID_ERROR_FALTANTE_FACTURADO","valor", ConstantesAPE.OID_ERROR_FALTANTE_FACTURADO.toString());
    asignarAtributo("VAR","COD_ERROR_FALTANTE_FACTURADO","valor", ConstantesAPE.COD_ERROR_FALTANTE_FACTURADO);
    asignarAtributo("VAR","OID_ERROR_FALTANTE_CANTIDAD","valor", ConstantesAPE.OID_ERROR_FALTANTE_CANTIDAD.toString());
    asignarAtributo("VAR","COD_ERROR_FALTANTE_CANTIDAD","valor", ConstantesAPE.COD_ERROR_FALTANTE_CANTIDAD);
    asignarAtributo("VAR","OID_ERROR_SOBRANTE_CANTIDAD","valor", ConstantesAPE.OID_ERROR_SOBRANTE_CANTIDAD.toString());
    asignarAtributo("VAR","COD_ERROR_SOBRANTE_CANTIDAD","valor", ConstantesAPE.COD_ERROR_SOBRANTE_CANTIDAD);
   
  }
  
  private void buscarCaja() throws Exception{  
    String accion = conectorParametroLimpia("accion", "", true);
    traza("accion: " + accion);
        
    pagina("contenido_cajas_chequear");  
      
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","accion","valor", accion);
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    asignarAtributo("VAR","OID_ERROR_SOBRANTE_NO_FACTURADO","valor", ConstantesAPE.OID_ERROR_SOBRANTE_NO_FACTURADO.toString());
    asignarAtributo("VAR","COD_ERROR_SOBRANTE_NO_FACTURADO","valor", ConstantesAPE.COD_ERROR_SOBRANTE_NO_FACTURADO);
    
    // Buscar           
    String numCaja = conectorParametroLimpia("txtNroCaja", "", true);
    String numConsolidado = conectorParametroLimpia("txtNroConsolidado", "", true);
    String anio = conectorParametroLimpia("hAnio", "", true);
	String codigoVisualChequeo = conectorParametroLimpia("cbOrdenVisualChuqueo", "", true);
	String ordenVisualChequeo =  conectorParametroLimpia("RBOreden", "", true);
	traza("777777777777codigoVisualChequeo: " + codigoVisualChequeo);
	traza("777777777777ordenVisualChequeo:  " + ordenVisualChequeo);
    
    asignarAtributo("CTEXTO","txtNroCaja","valor", numCaja);  
    asignarAtributo("CTEXTO","txtNroConsolidado","valor", numConsolidado);  
	//agregado por cambio 20090839
    asignarAtributo("VAR","codigoOrden","valor", codigoVisualChequeo);
	asignarAtributo("VAR","radioButton","valor", ordenVisualChequeo);
	DTOBelcorp dto = new DTOBelcorp();
	dto.setOidIdioma(this.idioma);
    dto.setOidPais(this.pais);
	ComposerViewElementList list = new ComposerViewElementList();
	ComposerViewElement element = new ComposerViewElement(); 
	element.setIDBusiness("APECodigoVisualizacionChequeo");
    element.setDTOE(dto);
    list.addViewElement(element);
	ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
    ccv.ejecucion();
    DruidaConector dc = ccv.getConector();
	asignar("COMBO", "cbOrdenVisualChuqueo", dc, "APECodigoVisualizacionChequeo");

    
    DTOBuscarCaja dtoBuscarCaja = new DTOBuscarCaja();    
    dtoBuscarCaja.setNumeroCaja(Long.valueOf(numCaja));
    dtoBuscarCaja.setNumeroConsolidado(Long.valueOf(anio.substring(2) + numConsolidado));  
    dtoBuscarCaja.setOidIdioma(idioma);  	
	dtoBuscarCaja.setOidPais(this.pais);

	// vbongiov -- Cambio SICC 20090839 -- 13/11/2009 
	if(!codigoVisualChequeo.equals("")){
		dtoBuscarCaja.setOidOrdenVisual(new Long(codigoVisualChequeo));
	}

	if(!ordenVisualChequeo.equals("")){
		dtoBuscarCaja.setOrdenVisualChequeo(new String(ordenVisualChequeo));
	}
    
    traza("dtoBuscarCaja: " + dtoBuscarCaja);
    
    MareBusinessID id = new MareBusinessID("APEObtenerCajaChequear");              
    Vector paramEntrada = new Vector();
 
    paramEntrada.add(dtoBuscarCaja);
    paramEntrada.add(id);
    traza("*************** Antes de conectar");
    DruidaConector con = conectar("ConectorObtenerCajaChequear", paramEntrada);
    traza("*************** Despues de conectar");
    
    DTODatosCajaCabecera dtoDatosCajaCabecera = (DTODatosCajaCabecera)con.objeto("DTODatosCajaCabecera"); 
    
    // Muestra los datos 
    if(dtoDatosCajaCabecera.getDetalles().size()==0){
         // Muestra mensaje no hay datos
         asignarAtributo("VAR","hBuscarCajaDatos","valor", "N");
         
    } else {
         // Muestra cabecera y detalles
         asignarAtributo("VAR","hBuscarCajaDatos","valor", "S");
         
         // Cabecera
         asignarAtributo("VAR","hNumConsolidado","valor", dtoDatosCajaCabecera.getNumeroConsolidado().toString());
         asignarAtributo("VAR","hTurnoChequeo","valor", dtoDatosCajaCabecera.getTurnoChequeo().toString());
         asignarAtributo("VAR","hEstadoPed","valor", dtoDatosCajaCabecera.getEstadoPedido());
         asignarAtributo("VAR","hEstadoCaj","valor", dtoDatosCajaCabecera.getEstadoCaja());
         asignarAtributo("VAR","hTipoChequeo","valor", dtoDatosCajaCabecera.getTipoChequeo()!=null?dtoDatosCajaCabecera.getTipoChequeo():"");
         asignarAtributo("VAR","hOrigenChequeo","valor", dtoDatosCajaCabecera.getOrigenChequeo()!=null?dtoDatosCajaCabecera.getOrigenChequeo():"");
         asignarAtributo("VAR","hCaja","valor", dtoDatosCajaCabecera.getNumeroCaja().toString());
         asignarAtributo("VAR","hTotalCaja","valor", dtoDatosCajaCabecera.getTotalCajas().toString());
         asignarAtributo("VAR","hTotalProd","valor", dtoDatosCajaCabecera.getTotalProductos().toString());
         asignarAtributo("VAR","hNumUnidCaj","valor", dtoDatosCajaCabecera.getUnidadesCaja().toString());
         asignarAtributo("VAR","hUnidPicadas","valor", dtoDatosCajaCabecera.getUnidadesPicadas().toString());
         
         asignarAtributo("VAR","hOidListaPicadoCabecera","valor", dtoDatosCajaCabecera.getOidListaPicadoCabecera().toString());
         asignarAtributo("VAR","hOidTipoCajaEmbalaje","valor", dtoDatosCajaCabecera.getOidTipoCajaEmbalaje()!=null?dtoDatosCajaCabecera.getOidTipoCajaEmbalaje().toString():"");
         asignarAtributo("VAR","hOidEtiqueta","valor", dtoDatosCajaCabecera.getOidEtiqueta().toString());

                  // BELC400000722 - dmorello, 12/09/2007
                  asignarAtributo("VAR", "hOidPeriodo", "valor", dtoDatosCajaCabecera.getOidPeriodo().toString());
         
         // Armo Detalle
         ArrayList detalles = dtoDatosCajaCabecera.getDetalles();
         DTODatosCajaDetalle dtoDatosCajaDetalle = null;
         
         RecordSet rs = new RecordSet();           
         rs.addColumn("oid");
         rs.addColumn("secuencia");
         rs.addColumn("descProd");
         rs.addColumn("anaquel");
         rs.addColumn("cantRequerida"); 
         rs.addColumn("cantchequeada"); 
         rs.addColumn("diferencia"); 
         rs.addColumn("codError");
         rs.addColumn("OidError"); 
         rs.addColumn("oidMapaCDDetalle"); 
         rs.addColumn("oidProducto"); 
         rs.addColumn("oidListaPicadoDetalle"); 
         
         int cant = detalles.size();
      
         for(int i=0; i<cant; i++){
            dtoDatosCajaDetalle = (DTODatosCajaDetalle) detalles.get(i);
         
            rs.addRow(new Object[] {
                 Integer.toString(i), 
                 dtoDatosCajaDetalle.getSecuencia(), 
                 dtoDatosCajaDetalle.getDescripcionProducto(), 
                 dtoDatosCajaDetalle.getNumeroAnaquel(), 
                 dtoDatosCajaDetalle.getCantidadRequerida(), 
                 "",
                 "",
                 "",
                 "",
                 "",
                 "",
                 dtoDatosCajaDetalle.getOidListaPicadoDetalle()}); 
         }
         
         traza("rs: " + rs);
         
         asignar("LISTADOA", "listado1", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");      
         
    }    
  }
  
  private void cargarPagina() throws Exception{
    pagina("contenido_cajas_chequear");  
    DTOBelcorp dto = new DTOBelcorp();
	dto.setOidIdioma(this.idioma);
    dto.setOidPais(this.pais);
	ComposerViewElementList list = new ComposerViewElementList();
	ComposerViewElement element = new ComposerViewElement(); 
	element.setIDBusiness("APECodigoVisualizacionChequeo");
    element.setDTOE(dto);
    list.addViewElement(element);
	ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
    ccv.ejecucion();
    DruidaConector dc = ccv.getConector();
	asignar("COMBO", "cbOrdenVisualChuqueo", dc, "APECodigoVisualizacionChequeo");

	 //centro de configuracion x defaul 
	cargarCentroDistribucionDefault();	
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
  }

  /**
 * Recupera el centro de distribucion por default
 * @throws Exception 
 */
private void cargarCentroDistribucionDefault() throws Exception {

	String codigoVisualChequeo = "";
    String ordenVisualChequeo= "";
    
    DTOConfiguracionCentroDistribucion dtoP = new DTOConfiguracionCentroDistribucion();
    dtoP.setOidPais(pais);
    dtoP.setOidIdioma(idioma);
    
    MareBusinessID businessID = new MareBusinessID("APEBuscarCentroDistribucion");
    
    Vector para = new Vector(); 
    para.add(dtoP);
    para.add(businessID);
    
    traza("7777777777 Antes de conectar");
    DruidaConector dc =	conectar("ConectorBuscarCentroDistribucion", para);
   traza("777777777 Despues de conectar");

    DTOSalida dtoSalida = (DTOSalida)dc.objeto("dtoSalida.resultado");
    RecordSet rs = dtoSalida.getResultado(); 							
    traza("rs: " + rs);
    
    int numFilas =rs.getRowCount();
    traza("num filas " + numFilas);
    int i=0;
    while(i<numFilas){
    	String valorDefecto   =  (String)rs.getValueAt(i,"VAL_DEFE");
    	if(valorDefecto!=null && "S".equals(valorDefecto.toUpperCase())){
    		ordenVisualChequeo =  "A".equals((String)rs.getValueAt(0,"VAL_ORDE_VISU_CHEQ"))?"A":"D";//A O D
    		codigoVisualChequeo = (String)rs.getValueAt(0,"OID_ORDE_VISU_CHEQ");
    		break;
    	}
         i++;  
    }
    
    			  
    
    traza("77777777codigoVisualChequeo: " + codigoVisualChequeo);
    traza("77777777ordenVisualChequeo: " + ordenVisualChequeo);
	
	asignarAtributo("VAR","codigoOrden","valor", codigoVisualChequeo);
	asignarAtributo("VAR","radioButton","valor", ordenVisualChequeo);
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