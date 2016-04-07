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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOPreasignarProducto;
import es.indra.sicc.util.DTOBoolean;

public class LPPreasignarProductos extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
        
    public LPPreasignarProductos() {	 
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
        
            pagina("contenido_productos_preasignar");      
            asignarAtributoPagina("cod", "0968");      
      
            // Validaciones
            getFormatosValidaciones();
           
            asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
            asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
            
            this.cargarCombos();
          
        } else if(accion.equals("nuevaVersion")){ 
        
            pagina("contenido_version_asignar");      
            asignarAtributoPagina("cod", "0968");      
      
            // Validaciones
            getFormatosValidaciones();
            
            String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
            String oidMapaCentroDistribucion = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
            String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
            
            asignarAtributo("VAR","oidIdioma","valor", (idioma==null?"":idioma.toString()));
            asignarAtributo("VAR","oidPais","valor",  (pais==null?"":pais.toString()));
            asignarAtributo("VAR","casoDeUso","valor", casoDeUso);
            
            asignarAtributo("VAR","hOidMapaCentroDistribucion","valor", oidMapaCentroDistribucion);
            asignarAtributo("VAR","hOidPeriodo","valor", oidPeriodo);
            
            traza("antes de ComposerViewElementList  ");
            ComposerViewElementList cv = crearParametrosEntrada1();
            ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
            traza("antes del conector.ejecucion");
            conector.ejecucion();
            traza("despues del conector");
            DruidaConector resultados = conector.getConector();
            
            asignar("COMBO","cbMapaZonas",resultados,"APEObtenerMapaZonaPorMapaCD"); 
          
        } else if(accion.equals("validarNuevaVersion")){ 
            this.validarNuevaVersion(); 
          
        } else if(accion.equals("guardar")){ 
            this.guardar();           
            
        } else if(accion.equals("guardarConfirmacion")){ 
            this.guardarConfirmacion();           
        } 
        
      } catch (Exception e){   
          traza(e);      
          this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
   }
   
   private ComposerViewElementList crearParametrosEntrada1() throws Exception{
    
      String oidMapaCentroDistribucion = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
      
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement descripcionesMapasZonas = new ComposerViewElement();
  
      DTOOID dtoOid = new DTOOID();
      traza("antes de asignar al dtobelcorp");
      dtoOid.setOidPais(pais);
      dtoOid.setOidIdioma(idioma);
      dtoOid.setOid(Long.valueOf(oidMapaCentroDistribucion));
           
      descripcionesMapasZonas.setIDBusiness("APEObtenerMapaZonaPorMapaCD");
      descripcionesMapasZonas.setDTOE(dtoOid);
           
      lista.addViewElement(descripcionesMapasZonas);
      
      return lista;
    }
   
   private void guardarConfirmacion() throws Exception{
      pagina("salidaGenerica");
 
      try {  
          String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);
          String cbLinea = conectorParametroLimpia("cbLinea", "", true);
          String cbMapaCentroDistribucion = conectorParametroLimpia("cbMapaCentroDistribucion", "", true);
          String cbMarca = conectorParametroLimpia("cbMarca", "", true);
          String cbCanal = conectorParametroLimpia("cbCanal", "", true);
          String cbPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
          String cbVersionOrigen = conectorParametroLimpia("cbVersion", "", true);
          String cbFuentePeriodoOrigen = conectorParametroLimpia("cbFuentePeriodoOrigen", "", true);
          String cbPeriodoDestino = conectorParametroLimpia("cbPeriodoDestino", "", true);
          String codProcedenciaNoElimina = conectorParametroLimpia("codProcedenciaNoElimina", "", true);
          String cbVersionDestino = conectorParametroLimpia("hVersionDestino", "", true);
		  // vbongiov -- Inc BELC400000619 -- 7/08/2007 
		  String oidAsignacionProductoAnaquelCabDestino = conectorParametroLimpia("cbVersionDestino", "", true);
      
          DTOPreasignarProducto dtoPreasignarProducto = new DTOPreasignarProducto();    
      
          dtoPreasignarProducto.setOidCD(Long.valueOf(cbCentroDistribucion));
          dtoPreasignarProducto.setOidLinea(Long.valueOf(cbLinea));
          dtoPreasignarProducto.setOidMapaCD(Long.valueOf(cbMapaCentroDistribucion));
          dtoPreasignarProducto.setOidMarca(Long.valueOf(cbMarca));
          dtoPreasignarProducto.setOidCanal(Long.valueOf(cbCanal));
          dtoPreasignarProducto.setOidPeriodoOrigen(Long.valueOf(cbPeriodo));
          dtoPreasignarProducto.setVersionOrigen(cbVersionOrigen);
          dtoPreasignarProducto.setCodFuentePeriodoOrigen(cbFuentePeriodoOrigen);
          dtoPreasignarProducto.setOidPeriodoDestino(Long.valueOf(cbPeriodoDestino));
          dtoPreasignarProducto.setVersionDestino(cbVersionDestino);
		  // vbongiov -- Inc BELC400000619 -- 7/08/2007 
		  dtoPreasignarProducto.setOidAsignacionProductoAnaquelCabDestino(Long.valueOf(oidAsignacionProductoAnaquelCabDestino));
          
          dtoPreasignarProducto.setCodProcedenciaNoElimina(codProcedenciaNoElimina);
          
          MareBusinessID id = new MareBusinessID("APEPreasignarProductosElimina");            
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoPreasignarProducto);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorPreasignarProductosElimina", paramEntrada);
          traza("*************** Despues de conectar");
    
          traza("termino ");
          asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
          
      } catch(Exception e) {
          traza("Excepcion: " + e);
          asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
          throw e;
      }
   }
   
      
   private void guardar() throws Exception{
      pagina("salidaGenerica");
 
      try {  
          String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);
          String cbLinea = conectorParametroLimpia("cbLinea", "", true);
          String cbMapaCentroDistribucion = conectorParametroLimpia("cbMapaCentroDistribucion", "", true);
          String cbMarca = conectorParametroLimpia("cbMarca", "", true);
          String cbCanal = conectorParametroLimpia("cbCanal", "", true);
          String cbPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
          String cbVersionOrigen = conectorParametroLimpia("cbVersion", "", true);
          String cbFuentePeriodoOrigen = conectorParametroLimpia("cbFuentePeriodoOrigen", "", true);
          String cbPeriodoDestino = conectorParametroLimpia("cbPeriodoDestino", "", true);
          String cbVersionDestino = conectorParametroLimpia("hVersionDestino", "", true);
		  // vbongiov -- Inc BELC400000619 -- 7/08/2007 
		  String oidAsignacionProductoAnaquelCabDestino = conectorParametroLimpia("cbVersionDestino", "", true);
      
          DTOPreasignarProducto dtoPreasignarProducto = new DTOPreasignarProducto();    
      
          dtoPreasignarProducto.setOidCD(Long.valueOf(cbCentroDistribucion));
          dtoPreasignarProducto.setOidLinea(Long.valueOf(cbLinea));
          dtoPreasignarProducto.setOidMapaCD(Long.valueOf(cbMapaCentroDistribucion));
          dtoPreasignarProducto.setOidMarca(Long.valueOf(cbMarca));
          dtoPreasignarProducto.setOidCanal(Long.valueOf(cbCanal));
          dtoPreasignarProducto.setOidPeriodoOrigen(Long.valueOf(cbPeriodo));
          dtoPreasignarProducto.setVersionOrigen(cbVersionOrigen);
          dtoPreasignarProducto.setCodFuentePeriodoOrigen(cbFuentePeriodoOrigen);
          dtoPreasignarProducto.setOidPeriodoDestino(Long.valueOf(cbPeriodoDestino));
          dtoPreasignarProducto.setVersionDestino(cbVersionDestino);
		  // vbongiov -- Inc BELC400000619 -- 7/08/2007 
		  dtoPreasignarProducto.setOidAsignacionProductoAnaquelCabDestino(Long.valueOf(oidAsignacionProductoAnaquelCabDestino));
          
          MareBusinessID id = new MareBusinessID("APEPreasignarProductosValidacion");            
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoPreasignarProducto);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorPreasignarProductosValidacion", paramEntrada);
          traza("*************** Despues de conectar");
          
          DTOBoolean dtoBoolean = (DTOBoolean)con.objeto("DTOBoolean");  
          
          traza("ejecuto: " + dtoBoolean.getValor());
          
          if(dtoBoolean.getValor()){
              asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
          } else {
              asignarAtributo("VAR", "ejecutar", "valor", "ejecutarConfirmacion();");
          }
          
      } catch(Exception e) {
          traza("Excepcion: " + e);
          asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
          throw e;
      }
   }
  
   private void validarNuevaVersion() throws Exception{
  
      pagina("salidaGenerica");
 
      try {          
          String oidMapaCentroDistribucion = conectorParametroLimpia("hOidMapaCentroDistribucion", "", true);
          String oidMapaZona = conectorParametroLimpia("cbMapaZonas", "", true);
          String oidPeriodo = conectorParametroLimpia("hOidPeriodo", "", true);
          String txtVersion = conectorParametroLimpia("txtVersion", "", true);         
          
          DTOMantenerAsignacionProductosAnaqueles dtoNuevaVersion = new DTOMantenerAsignacionProductosAnaqueles();
          dtoNuevaVersion.setOidMapaCentroDistribucion(Long.valueOf(oidMapaCentroDistribucion));
          dtoNuevaVersion.setOidMapaZona(Long.valueOf(oidMapaZona));
          dtoNuevaVersion.setOidPeriodo(Long.valueOf(oidPeriodo));
          dtoNuevaVersion.setVersion(txtVersion);
          
          MareBusinessID id = new MareBusinessID("APEValidarNuevaVersionAsignacion");            
          Vector paramEntrada = new Vector();
        
          paramEntrada.add(dtoNuevaVersion);
          paramEntrada.add(id);
          traza("*************** Antes de conectar");
          DruidaConector con = conectar("ConectorValidarNuevaVersionAsignacion", paramEntrada);
          traza("*************** Despues de conectar");
          
          DTOOID dtoOid = (DTOOID)con.objeto("DTOOID");  
          
          asignarAtributo("VAR", "ejecutar", "valor", "ejecutarOK('" + dtoOid.getOid() + "','"+ txtVersion +"');");
          
      } catch(Exception e) {
        traza("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", "fLimpiar();");
        throw e;
      }
  }  
    
    
  private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
        
    asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
    asignar("COMBO","cbMarca",resultados,"SEGObtenerMarcasSinFiltro");   
    asignar("COMBO","cbCanal",resultados,"SEGObtenerCanalesSinFiltro");   
    asignar("COMBO","cbFuentePeriodoOrigen",resultados,"APEObtenerFuentesPeriodoPreasignacion");   
    
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
    asignarAtributo("VAR", "hCbLineasCDDef", "valor", aplanarLineasCDDef(dtoSalida));
    
    asignarAtributo("VAR", "COD_PROCEDENCIA_MANUAL", "valor", ConstantesAPE.COD_PROCEDENCIA_MANUAL);
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
  
  private String aplanarLineasCDDef(DTOSalida dtoSalida) throws Exception{ 
    traza("entro a aplanarLineasCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String lineasCDDef = "";
    int cant = valoresDef.getRowCount();
        
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.LINEA_ARMADO)){
          lineasCDDef = lineasCDDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!lineasCDDef.equals("")){
        return lineasCDDef.substring(1);
    } else {
        traza("No hay linea por defecto");
        return "";
    }
  }
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
     
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
      
      //Combo centro configuracion
      ComposerViewElement descripcionesCD = new ComposerViewElement();
          
      descripcionesCD.setIDBusiness("APEObtenerDescripcionesCD");
      descripcionesCD.setDTOE(dtoBel);
          
      lista.addViewElement(descripcionesCD);
      
      //Combo Marcas
      ComposerViewElement marcas = new ComposerViewElement();
          
      marcas.setIDBusiness("SEGObtenerMarcasSinFiltro");
      marcas.setDTOE(dtoBel);
          
      lista.addViewElement(marcas);
      
      //Combo Canales
      ComposerViewElement canales = new ComposerViewElement();
          
      canales.setIDBusiness("SEGObtenerCanalesSinFiltro");
      canales.setDTOE(dtoBel);
          
      lista.addViewElement(canales);
      
      //Combo fuentes Periodo Preasignacion
      ComposerViewElement fuentes = new ComposerViewElement();
          
      fuentes.setIDBusiness("APEObtenerFuentesPeriodoPreasignacion");
      fuentes.setDTOE(dtoBel);
          
      lista.addViewElement(fuentes);
      
      return lista;
  }    
    
}
