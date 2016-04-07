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

import es.indra.sicc.dtos.ape.DTOCopiaOrdenAnaqueles;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabecera;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

public class LPCopiarOrdenAnaqueles extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
        
    public LPCopiarOrdenAnaqueles() {	 
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
          
        } else if(accion.equals("copiar")){ 
          this.copiar();           
        } 
        
      } catch (Exception e){   
          traza(e);      
          this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }
    
    
    private void copiar() throws Exception{
      pagina("salidaGenerica");
      
      try {         
           anyadeHiddensI18N(false, "APE_ORDEN_ANAQU_CABEC", null, new Integer(1),
                            "formulario", "txtOrdenAnaquelDestino", false);
      
           String cbCentroDistribucion = conectorParametroLimpia("cbCentroDistribucion", "", true);    
           String cbMapaZonasOrigen = conectorParametroLimpia("cbMapaZonasOrigen", "", true);
           String cbMapaZonasDestino = conectorParametroLimpia("cbMapaZonasDestino", "", true);
           String cbMapaCentroDistOrigen = conectorParametroLimpia("cbMapaCentroDistOrigen", "", true);
           String cbMapaCentroDistDestino = conectorParametroLimpia("cbMapaCentroDistDestino", "", true);
           String cbOrdenAnaquel = conectorParametroLimpia("cbOrdenAnaquel", "", true);
           //String descOrdenAnaquel = conectorParametroLimpia("hDescOrdenAnaquel", "", true);
           String txtOrdenAnaquelDestino = conectorParametroLimpia("txtOrdenAnaquelDestino", "", true);
              
           // Origen
           DTOCopiaOrdenAnaqueles dtoCopiaOrdenAnaqueles = new DTOCopiaOrdenAnaqueles();
           
           DTOOrdenAnaquelesCabecera dtoOrdenAnaquelesCabOrigen = new DTOOrdenAnaquelesCabecera();
           dtoOrdenAnaquelesCabOrigen.setOid(Long.valueOf(cbOrdenAnaquel));
           //dtoOrdenAnaquelesCabOrigen.setCodigoMapaOrden(Long.valueOf(descOrdenAnaquel));
          
           DTOMapaZonasCabecera dtoMapaZonasCabeceraOrigen = new DTOMapaZonasCabecera();      
           dtoMapaZonasCabeceraOrigen.setOid(Long.valueOf(cbMapaZonasOrigen));
           
           dtoOrdenAnaquelesCabOrigen.setMapaZonaCabecera(dtoMapaZonasCabeceraOrigen);
           
           dtoOrdenAnaquelesCabOrigen.setOidIdioma(idioma);
           
           dtoCopiaOrdenAnaqueles.setOrdenAnaquelOrigen(dtoOrdenAnaquelesCabOrigen);
           
           // Destino
           DTOOrdenAnaquelesCabecera dtoOrdenAnaquelesCabDestino = new DTOOrdenAnaquelesCabecera();
            
           traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
           dtoOrdenAnaquelesCabDestino.setDescripcionOrdenAnaqueles(recuperaTraduccionesI18N(new Integer(1)));
            
           DTOMapaZonasCabecera dtoMapaZonasCabeceraDestino = new DTOMapaZonasCabecera();      
           dtoMapaZonasCabeceraDestino.setOid(Long.valueOf(cbMapaZonasDestino));
           
           dtoOrdenAnaquelesCabDestino.setMapaZonaCabecera(dtoMapaZonasCabeceraDestino);
           
           dtoOrdenAnaquelesCabDestino.setValorDefecto(Boolean.FALSE);
           dtoOrdenAnaquelesCabDestino.setOidIdioma(idioma);
           
           dtoCopiaOrdenAnaqueles.setOrdenAnaquelDestino(dtoOrdenAnaquelesCabDestino);
            
           traza("copiar: " + dtoCopiaOrdenAnaqueles);
           
           MareBusinessID id = new MareBusinessID("APECopiarOrdenAnaqueles");             
           Vector paramEntrada = new Vector();
         
           paramEntrada.add(dtoCopiaOrdenAnaqueles);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorCopiarOrdenAnaqueles", paramEntrada);
           traza("*************** Despues de conectar");
                
           asignarAtributo("VAR", "ejecutar", "valor", "ejecutarOK();");
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
         throw e;
      }
   }
    
    private void inicializar() throws Exception{
    
      pagina("contenido_orden_anaquel_copiar");      
      asignarAtributoPagina("cod", "01012");    
      // Validaciones
      getFormatosValidaciones();
      
      asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
      asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
      
      anyadeHiddensI18N(true, "APE_ORDEN_ANAQU_CABEC", null, new Integer(1), 
                                "formulario", "txtOrdenAnaquelDestino", false); 
      
      traza("antes de ComposerViewElementList  ");
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      traza("antes del conector.ejecucion");
      conector.ejecucion();
      traza("despues del conector");
      DruidaConector resultados = conector.getConector();
          
      asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");   
      
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
      asignarAtributo("VAR", "hCbMapaZonaDef", "valor", aplanarMapaZonaDef(dtoSalida));
     
   }
  
   private String aplanarMapaZonaDef(DTOSalida dtoSalida) throws Exception{ 
    traza("entro a aplanarMapaZonaDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String mapaZonaDef = "";
    int cant = valoresDef.getRowCount();
        
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.MAPA_ZONA)){
          mapaZonaDef = mapaZonaDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!mapaZonaDef.equals("")){
        return mapaZonaDef.substring(1);
    } else {
        traza("No hay mapa zona por defecto");
        return "";
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
}
