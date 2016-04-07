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
 * @fecha  23/02/2007
 * Notas: C.U. Recepcionar Estimados de Ventas Proyectada Activación Manual
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
import es.indra.sicc.util.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;


public class LPRecepcionarEstimadosVentaProyectada extends LPSICCBase {
    
    private Long pais = null;
    private Long idioma = null;
    private String accion = null;
    
    public LPRecepcionarEstimadosVentaProyectada() {
    }
    
    public void inicio() throws Exception  {
    }
    
    public void ejecucion() throws Exception {
        
        setTrazaFichero();
        traza(" LPRecepcionarEstimadosVentaProyectada.ejecucion(): Entrada ");
        
        try {
            pagina("contenido_estimados_MAV_activacion_recepcionar");

			traza("     - this.getFormatosValidaciones()...");
            this.getFormatosValidaciones();

			getConfiguracionMenu("LPRecepcionarEstimadosVentaProyectada", "");
            asignarAtributoPagina("cod","01014");
                    
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            
            traza("     pais = " + pais);
            traza("     idioma = " + idioma);
            
            asignarAtributo("VAR", "pais", "valor", pais.toString());
            asignarAtributo("VAR", "idioma", "valor", idioma.toString());
            
            accion = conectorParametroLimpia("accion","", true);
            traza("     accion = " + accion);
            
            if( accion != null && accion.equals("") ){  
                cargarDatosIniciales();    
            
			} else {
				
				if( accion.equals("recepcionar") ){
					recepcionar();
				}

			}


        
        } catch (Exception e) {
            traza("     pinchó! ... " + e);
            logStackTrace(e);
            lanzarPaginaError(e);
        }
        
        traza(" LPRecepcionarEstimadosVentaProyectada.ejecucion(): Salida ");
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
    
    
    public void cargarDatosIniciales() throws Exception {
        traza(" LPRecepcionarEstimadosVentaProyectada.cargarDatosIniciales(): Entrada ");
        

        
        DTOString dtoe = new DTOString();
		dtoe.setOidIdioma(idioma);
		dtoe.setOidPais(pais);
		dtoe.setCadena(IGestorInterfaces.COD_INTERFAZ_SAB18);
			
		MareBusinessID mareBusinessID = new MareBusinessID("INTCargaInicialInterfaz");
		Vector params = new Vector();		
		params.add(dtoe);
		params.add(mareBusinessID);

		try {
            traza("antes del conector");
            DruidaConector dc =	conectar("ConectorObjeto", params);
            traza("despues del conector");
            
            //DTOINT dtos= (DTOINT)dc.objeto("DTOSalida");
            DTOCargaInicialInterfaz dtos= (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
    
            String numeroDeLote = dtos.getNumeroLote().toString();
            traza("     numeroDeLote = " + numeroDeLote);
            String descripcion = dtos.getDescripcion();
            traza("     descripcion = " + descripcion);
    
            asignar("CTEXTO", "Descripcion", descripcion);            		
            asignar("LABELC", "lblvalorLote", numeroDeLote);	
            asignar("VAR", "hNumeroLote", numeroDeLote);
            asignar("VAR", "casoUso", "LPRecepcionarEstimadosVentaProyectada");
        
        } catch (Exception e) {
            
            traza("     pinchó: cargarDatosIniciales() ... " + e);
            logStackTrace(e);
            lanzarPaginaError(e);
        
        }


		traza(" LPRecepcionarEstimadosVentaProyectada.cargarDatosIniciales(): Salida ");
		
    }
    
	
	public void recepcionar() throws Exception {
		traza(" LPRecepcionarEstimadosVentaProyectada.recepcionar(): Entrada ");
		
		DTOINT dtoInt = new DTOINT();

		dtoInt.setNumeroLote(new Long(conectorParametroLimpia("hNumeroLote", "", true)));		
		dtoInt.setOidIdioma(idioma);
		dtoInt.setOidPais(pais);
		
		traza("*** Antes de valObserv *** " );
		String valObserv = conectorParametro("areatxtObservaciones");
		String valDescLote = conectorParametro("Descripcion");
		
        traza("*** valObserv *** " + valObserv);
		dtoInt.setObservaciones(valObserv);
		traza("*** valDescLote *** " + valDescLote);
	    dtoInt.setDescripcionLote(valDescLote);

		MareBusinessID mareBusinessID=new MareBusinessID("INTRecepcionarEstimadosVentasProyectadasBatch");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoInt);
		paramEntrada.add(mareBusinessID);	
		
		traza("Antes de conectar...");
		conectar("ConectorRecepcionarEstimadosVentasProyectadasBatch", paramEntrada);
		traza("Después de conectar...");
        
        pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
        
		traza(" LPRecepcionarEstimadosVentaProyectada.recepcionar(): Salida ");

	}

    
    
}
