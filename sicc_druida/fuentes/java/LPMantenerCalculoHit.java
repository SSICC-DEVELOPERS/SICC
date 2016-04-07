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
 */
 
/**
 * @author SPLATAS
 * @fecha  25/01/2007
 * Notas: C.U. Calcular Hit
 */
import es.indra.druida.DruidaConector; 
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement; 
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;

public class LPMantenerCalculoHit extends LPSICCBase {
    
    private Long pais = null;
    private Long idioma = null;
    private String accion = null;
    private String opcionMenu = null;
    
    public LPMantenerCalculoHit() {
    }
    
    public void inicio() throws Exception  {
    }
    
    public void ejecucion() throws Exception {
        
        setTrazaFichero();
        traza(" LPMantenerCalculoHit.ejecucion(): Entrada ");
        
        try {
            pagina("contenido_hit_calcular");

			traza("     - this.getFormatosValidaciones()...");
            this.getFormatosValidaciones();

			getConfiguracionMenu("LPMantenerCalculoHit", "calcular");
            asignarAtributoPagina("cod","0602");
                    
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            
            traza("     pais = " + pais);
            traza("     idioma = " + idioma);
            
            /*
             * SPLATAS - 17/04/2006 -  Inc.BELC400000377
             * Se carga la fecha del sistema en el textbox 'FechaFacturacion'
             */
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(date); 
            asignarAtributo("VAR", "hFecha", "valor", fecha);
            traza("     fecha = " + fecha);
            
            
            asignarAtributo("VAR", "hPais", "valor", pais.toString());
            asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
            
            accion = conectorParametroLimpia("accion","", true);
            opcionMenu = conectorParametroLimpia("opcionMenu","", true);
            
            traza("     accion = " + accion);
            traza("     opcionMenu = " + opcionMenu);
            
            if( accion != null && accion.equals("") && 
                opcionMenu != null && opcionMenu.equals("calcular") ){  
                cargarCombos();    
            }
        
        } catch (Exception e) {
            traza("     pinchó! ... " + e);
            logStackTrace(e);
            lanzarPaginaError(e);
        }
        
        traza(" LPMantenerCalculoHit.ejecucion(): Salida ");
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
    
    
    public void cargarCombos() throws Exception {
        traza(" LPMantenerCalculoHit.cargarCombos(): Entrada ");
        
        ComposerViewElementList lista = new ComposerViewElementList();
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidIdioma(idioma);
        byte posOid = 0;
        byte posDesc = 1;
                
        // Carga los Centros de Distribución
        ComposerViewElement elemCD = new ComposerViewElement();
        elemCD.setIDBusiness("APEObtenerDescripcionesCD");
        elemCD.setDTOE(dtoe);
        elemCD.setPosOID(posOid);
        elemCD.setPosDesc(posDesc);
        lista.addViewElement(elemCD);        
        
        // Carga las Marcas
        ComposerViewElement elemMarca = new ComposerViewElement();
        elemMarca.setIDBusiness("SEGObtenerMarcasSinFiltro");
        elemMarca.setDTOE(dtoe);
        elemMarca.setPosOID(posOid);
        elemMarca.setPosDesc(posDesc);
        lista.addViewElement(elemMarca);
        
        // Carga los Canales
        ComposerViewElement elemCh = new ComposerViewElement();
        elemCh.setIDBusiness("SEGObtenerCanalesSinFiltro");
        elemCh.setDTOE(dtoe);
        elemCh.setPosOID(posOid);
        elemCh.setPosDesc(posDesc);
        lista.addViewElement(elemCh);
        
        // Recupera los oids de los valores por defecto para cada combo 
        ComposerViewElement elemDef = new ComposerViewElement();
        elemDef.setIDBusiness("APEObtenerValoresDefecto");
        elemDef.setDTOE(dtoe);
        lista.addViewElement(elemDef);
        
        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        conector.ejecucion();
        traza(" Antes de conector");
		DruidaConector resultados = conector.getConector();
        traza(" Despues de conector ");
        
        asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
        
        traza("     resultados = " + resultados.toString());
        
        
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
		
		asignarAtributo("VAR", "hCentDist", "valor", obtenerCDDef(dtoSalida));	

        
        traza(" LPMantenerCalculoHit.cargarCombos(): Salida ");
    }
    
	private String obtenerCDDef(DTOSalida dtoSalida) throws Exception {

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
    
    
    
}
