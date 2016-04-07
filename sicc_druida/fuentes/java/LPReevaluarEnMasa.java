/** 
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Cochabamba 2552 8° Piso
 * Capital Federal, Buenos Aires
 * Argentina
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;

import java.util.Vector;
import es.indra.sicc.dtos.car.DTOReevaluarEnMasa;

public class LPReevaluarEnMasa extends LPSICCBase {
   
    String casoDeUso = "";
    String oid = "";
    Long pais = null;
    Long idioma = null;
    private String varProcedencia = "";
         
    public LPReevaluarEnMasa() {	 
        super();
    }

    public void inicio() throws Exception { 
      pagina("contenido_linea_credito_masa_revaluar");    	
    }

    public void ejecucion() throws Exception {
        try {      
        setTrazaFichero();
        traza("entro");
        String accion = conectorParametroLimpia("accion", "", true);
        traza("accion: " + accion);
        getFormatosValidaciones();
        
        if(accion.equals("LineaCredito")) { 
         traza("Linea");
             cargaInicial(ConstantesCAR.TIPO_REEVALUACION_LC);
             asignarAtributoPagina("cod", "0296");
        } else if(accion.equals("NivelRiesgo")) {
             traza("Nivel");
             cargaInicial(ConstantesCAR.TIPO_REEVALUACION_NR);
             asignarAtributoPagina("cod", "0297");
        } else if(accion.equals("Reevaluar")) { 
             this.reevaluar();
        }
      } catch (Exception e){   
        logStackTrace(e);
        this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
    }

    private void reevaluar() throws Exception{
      try {
		pagina("salidaGenerica");

        DTOReevaluarEnMasa dtoe = new DTOReevaluarEnMasa();

        dtoe.setOidPais(UtilidadesSession.getPais(this));
        dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoe.setOidMarca(new Long(conectorParametroLimpia("cbMarca", "", true)));
        dtoe.setOidCanal(new Long(conectorParametroLimpia("cbCanal", "", true)));
        dtoe.setOidClaseSolicitud(new Long(conectorParametroLimpia("cbClaseSolicitud", "", true)));        
        dtoe.setProcedencia(new Long(conectorParametroLimpia("varProcedencia", "", true)));
      	
        String sgvAux = conectorParametroLimpia("cbSubgerenciaVentas", "", true);
        String regAux = conectorParametroLimpia("cbRegion", "", true);
        String zonAux = conectorParametroLimpia("cbZona", "", true);
        
        traza("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        traza("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        traza("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        traza("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                
        dtoe.setOidSubgerencia(!(sgvAux.equals(""))? new Long(sgvAux) : null);
        dtoe.setOidRegion(!(regAux.equals(""))? new Long(regAux) : null);
        dtoe.setOidZona(!(zonAux.equals(""))? new Long(zonAux) : null);
        dtoe.setMensaje(Boolean.TRUE);

        traza("dtoe: " + dtoe);
      
        MareBusinessID id = new MareBusinessID("CARReevaluarEnMasa");
        
        Vector paramEntrada = new Vector();
      
        paramEntrada.add(dtoe);
        paramEntrada.add(id);
        traza("*************** Antes de conectar");
        DruidaConector con = conectar("ConectorReevaluarEnMasa", paramEntrada);
        traza("*************** Despues de conectar");
              
        asignarAtributo("VAR", "ejecutar", "valor", "enviaOk()");
      } catch(Exception e) {
        System.out.println("Excepcion: " + e);
        asignarAtributo("VAR", "ejecutarError", "valor", "focalizaMarca()");
        throw e;
      }
   }
   
  private void cargaInicial(Long procedencia) throws Exception{

    pagina("contenido_linea_credito_masa_revaluar");
  
    Long pais = UtilidadesSession.getPais(this);
    Long idioma = UtilidadesSession.getIdioma(this);
  
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("antes del conector");
    DruidaConector resultados = conector.getConector();
  
    traza(resultados.getXML());
        
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");    
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");    
    asignar("COMBO","cbClaseSolicitud",resultados,"PEDClasesSolicitudOrdenCompra");
     
    asignarAtributo("VAR", "varProcedencia", "valor", procedencia.toString());
    asignarAtributo("VAR", "reevaluacionLC", "valor", ConstantesCAR.TIPO_REEVALUACION_LC.toString());
    asignarAtributo("VAR", "reevaluacionNR", "valor", ConstantesCAR.TIPO_REEVALUACION_NR.toString());
    
    Long marcaDft = UtilidadesSession.getMarcaPorDefecto(this);
    Long canalDft = UtilidadesSession.getCanalPorDefecto(this);
    Long sgv = UtilidadesSession.getSGVPorDefecto(this);
    Long zona = UtilidadesSession.getZonaPorDefecto(this);
    Long region = UtilidadesSession.getRegionPorDefecto(this);
	traza("region por def: " + region);
     
    asignarAtributo("VAR", "hCbMarca", "valor", marcaDft.toString());
    asignarAtributo("VAR", "hCbCanal", "valor", canalDft.toString());
    asignarAtributo("VAR", "hCbSubger", "valor", sgv.toString());
    asignarAtributo("VAR", "hCbZona", "valor", zona.toString());
    asignarAtributo("VAR", "hCbRegion", "valor", region.toString());
  }
  
  private void logStackTrace(Throwable e) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);

    e.printStackTrace(ps);
    try {
      traza("Se produjo la excepcion: " 
        + e.getMessage() 
        + "\n" 
        + "stackTrace = " 
        + os.toString());
    } catch (Exception ex) {
        //traza ("Error en logStackTrace: " + ex.getMessage ());
        e.printStackTrace ();
    }
  }
    
    private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement marca = new ComposerViewElement();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
          
      marca.setIDBusiness("SEGConsultaMarcas");
      marca.setDTOE(dtoBel);
          
      lista.addViewElement(marca);
      
      ComposerViewElement canal = new ComposerViewElement();
      
      canal.setIDBusiness("SEGConsultaCanales");
      canal.setDTOE(dtoBel);
          
      lista.addViewElement(canal);
      
      ComposerViewElement subgerencia = new ComposerViewElement();
      
      subgerencia.setIDBusiness("PEDClasesSolicitudOrdenCompra");
      subgerencia.setDTOE(dtoBel);
          
      lista.addViewElement(subgerencia);
      
      return lista;
    }
}
