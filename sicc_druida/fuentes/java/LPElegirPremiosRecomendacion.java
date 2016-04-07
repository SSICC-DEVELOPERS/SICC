/** 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Sistema:           Belcorp
 * Modulo:            INC
 * Submódulo:         ###
 * Componente:        LPElegirPremiosRecomendacion
 * Fecha:             20/04/2005
 * Observaciones:     
 * @version           1.00 20 abr 2005
 * @author            Igor Dedoukh
 * ult. modif.:       
 */
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.inc.DTOElegirPremiosRec;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Vector;

public class LPElegirPremiosRecomendacion extends LPSICCBase {	
	// -------- common ---------------
    private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;
    private String opcionMenu = null;
    private String oidConcursoParametrosGenerales = null;

	// -------------------------------	
    private String oid = null;
    private String numeronivel = null;
    private String numeropremio = null;
    private String tipopremio = null;
    private String costepuntos = null;
    private String oid_para_gral = null;
    private String perd_oid_peri_desd = null;
    private String num_conc = null;
    private String num_vers = null;
    private String cantidadinicial = null;
    private String cantidadfinal = null;
    private String puntosservicio = null;
    private String nivelelegido = null;
    private String oid_para_nive_prem = null;	
    private String oidClienteRecomendado = null;
    private String oidClienteRecomendante = null;
    private String oidPeriodoContacto = null; 

	public LPElegirPremiosRecomendacion() {

	    super();
	}

    public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {
        
	    setTrazaFichero();
	    try	{ 
            // descomentar en integracion, en conf.3316 de construcción no funcione
		    //this.rastreo();
		    traza("*********** Entre a LPElegirPremiosRecomendacion"); 
		    accion = conectorParametroLimpia("accion", "", true);
   		    traza("************ accion:" + accion); 
		    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);

            oidConcursoParametrosGenerales 
            = conectorParametroLimpia("oidConcursoParametrosGenerales", "", true);

			traza("oidConcursoParametrosGenerales: " + oidConcursoParametrosGenerales);
			//traza(" getIdioma ");
            

            // descomentar en integracion, en conf.3316 de construcción no funcione
            lIdioma = UtilidadesSession.getIdioma(this);
            lPais = UtilidadesSession.getPais(this);
            // son recibidos del caso de uso "Insertar Clientes" de MAE
            /* De acuerdo de logica entendida de dt - este caso se carga solamente 
               desde caso Insertar Clientes por que de ahi lo pasa "recomendado" y
               "recomendante" nesesarios para realizar acciones, y no se puede
               llamarse aparte, por ke no va a tener los mencionados. 
               El nombre "recomendado" y no "recomendada es por que en dt de 
               Insertar Cliente esta como "recomendado" y asi se sigiue.
            
               Se asignan desde Insertar Cliente:
               if ((recomendado != null) && (recomendante != null)) {
                traza("Entro recomendante y rrecomendado");
                conectorAction("LPElegirPremiosRecomendacion");
                conectorActionParametro("accion", "");
                conectorActionParametro("hidRecomendado", "recomendado");
                conectorActionParametro("hidRecomendante", "recomendante");
               } */
            
            // descomentar en integracion 
            oidClienteRecomendado  = conectorParametroLimpia("hidRecomendado", "", true);
			traza("oidClienteRecomendado: " + oidClienteRecomendado);
			
            oidClienteRecomendante = conectorParametroLimpia("hidRecomendante", "", true);
			traza("oidClienteRecomendante: " + oidClienteRecomendante);

            oidPeriodoContacto     = conectorParametroLimpia("hidPeriodoContacto", "", true);
			traza("oidPeriodoContacto: " + oidPeriodoContacto);
            
            if ("".equals(accion)) {
                buscarConcursosPremiosRec();
            } else if ("buscarPremios".equals(accion)) {
                buscarNivelesPremios();
            } else if ("guardarPremio".equals(accion)) {
                traza("caso guardarPremio");
                oid = conectorParametroLimpia("hidOid_para_gral", "", true);
				traza("oid: " + oid);
				numeropremio = conectorParametroLimpia("hidNumeropremio", "", true);
				traza("numeropremio: " + numeropremio);
                oid_para_nive_prem 
                    = conectorParametroLimpia("hidOid_para_nive_prem", "", true);
                
                guardarPremio();			
			}

			cargarMenuSecundario(); 

		} catch ( Exception e )	{ 
		    traza("Exception en LPElegirPremiosRecomendacion");
		    ByteArrayOutputStream pila = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(pila);
		    e.printStackTrace(out);
		    traza("EL STACK ES COMO SIGUE : " +  pila.toString());
	        e.printStackTrace();
		    e.getMessage();
		    lanzarPaginaError(e);
	    }    
	}

	private void cargarMenuSecundario() throws Exception {     
        traza("Start cargarMenuSecundario, acccion="+accion);
		if (accion.equals("")) {
			getConfiguracionMenu("LPElegirPremiosRecomendacion","");    
		}	
		else if (accion.equals("buscarPremios")) {
			getConfiguracionMenu("LPElegirPremiosRecomendacion","buscarPremios");		
		}
        traza("End cargarMenuSecundario, accion="+accion);
	}
    
    /**
        Asignar página "Contenido_premios_recomendación_elegir" 
        -> Se crea el idBusiness = INCBuscarConcursosPremiosRec 
        -> Se arma DTOElegirPremiosRec con pais e idioma de sesión y los atributos
        
        recomendante y recomendada 
        recibidos del caso de uso "Insertar Clientes" de MAE 
        
        -> Se invoca al conector ConectorBuscarConcursosPremiosRec 
        pasandole el idBusiness y el DTOElegirPremiosRec 

        -> Se asignan a los hidden correspondientes los valores 
        de recomendada y recomendantes recibidos
        
        -> Se recibe DTOS del tipo DTOSalida 
        -> Se asigna a la lista editable resultadosBusqueda 
        
        Nota: Las columnas a mostrar en la lista son: País, 
        Nº concurso, Versión, Nombre concurso, Marca, Canal, 
        Periodo desde, Periodo hasta y el oidParmetrosConcurso va oculto 
     */

    public void buscarConcursosPremiosRec() throws Exception {
        try{    
            traza("Start, buscarConcursosPremiosRec"); 
            
            pagina("contenido_premios_recomendacion_elegir");
            
            asignarAtributo("VAR", "oidPais", "valor",   UtilidadesSession.getPais(this).toString());
            asignarAtributo("VAR", "oidIdioma", "valor", UtilidadesSession.getIdioma(this).toString()); 
            
            // recibidos del caso de uso "Insertar Clientes" de MAE
            if (oidClienteRecomendante != null) {
                asignarAtributo("VAR", "hidRecomendante", "valor", oidClienteRecomendante.toString());
            }

            if (oidClienteRecomendado != null) {
                asignarAtributo("VAR", "hidRecomendado", "valor", oidClienteRecomendado.toString());
            }        
    
            if (oidPeriodoContacto != null){
                asignarAtributo("VAR", "hidPeriodoContacto",  "valor", oidPeriodoContacto.toString()); 
            }
            
            traza("End buscarConcursosPremiosRec");        
        
        }catch (Exception e){
            traza(e.getStackTrace());
        }        
    }

    /**Creamos un DTOElegirPremiosReco "dtoPremiosRec" 
    con los atributos recibidos de la pantalla llamante 
        -> Llamamos al ConectorBuscarNivelesPremiacion 
        con el idBussines="INCBuscarNivelesPremiacion" y el dtoPremiosRec 
        -> Asignar la pagina "contenido_nivel_premiacion_elegir" 
        -> Seteamos los hidden de la pagina con los datos correspondientes. 
        -> Se asigna a la lista editable resultadosBusqueda 
        Nota: Las columnas a mostrar en la lista son: Nº Nivel, 
        Nº Premio, Tipo Premio, ocultas las demas devueltas por el recordset 
    */

    public void buscarNivelesPremios() throws Exception {

    try{
            pagina("contenido_nivel_premiacion_elegir");
    
            traza("Start buscarNivelesPremios");
        
            asignarAtributo("VAR", "hidRecomendante", "valor", oidClienteRecomendante.toString());
            asignarAtributo("VAR", "hidRecomendado", "valor", oidClienteRecomendado.toString());
            asignarAtributo("VAR", "hidPeriodoContacto",  "valor", oidPeriodoContacto.toString());
            
            if (oidConcursoParametrosGenerales != null && oidConcursoParametrosGenerales.length() > 0) {
                asignarAtributo("VAR", "hidOidConcursoParametrosGenerales",  "valor", oidConcursoParametrosGenerales);
            }       
            asignarAtributo("VAR", "oidPais", "valor",   UtilidadesSession.getPais(this).toString());
            asignarAtributo("VAR", "oidIdioma", "valor", UtilidadesSession.getIdioma(this).toString());  
                            
            traza("End   buscarNivelesPremios");                        

        }catch (Exception e){
            traza(e.getStackTrace());
        }                        
    }


    /**Se crea el idBusiness = INCGuardarPremioRec 
        -> Se arma DTOElegirPremiosRec con pais e idioma de sesión 
        y los atributos recibidos desde la ventana llamante 
        -> Se invoca al conector ConectorGuardarPremio pasandole 
        el idBusiness y el DTOElegirPremiosRec 
    */    
    public void guardarPremio() throws Exception {
 
        traza("entro GuardarPremio");
        DTOElegirPremiosRec dtoe = new DTOElegirPremiosRec();
        dtoe.setOidPais(lPais);
        dtoe.setOidIdioma(lIdioma);
        
        /*if (num_conc != null && num_conc.length() > 0) {
            dtoe.setNumeroConcurso(num_conc);    
        }*/
        
        if (numeropremio != null && numeropremio.length() > 0) {
            dtoe.setNumeroPremio(new Integer(numeropremio));
        }

        if (oidClienteRecomendado != null 
            && oidClienteRecomendado.length() > 0) {
           dtoe.setOidClienteRecomendada(Long.valueOf(oidClienteRecomendado));
        }
        
        if (oidClienteRecomendante != null 
            && oidClienteRecomendante.length() > 0) {
           dtoe.setOidClienteRecomendante(Long.valueOf(oidClienteRecomendante));
        }

        if (oidPeriodoContacto != null 
            && oidPeriodoContacto.length() > 0) {        
            dtoe.setOidPeriodoVinculo(Long.valueOf(oidPeriodoContacto));
            }
        
        if (oid != null && oid.length() > 0) {
           dtoe.setOidConcurso(Long.valueOf(oid));
        }
        
        if (oid_para_nive_prem != null && oid_para_nive_prem.length() > 0) {
           dtoe.setOidNivelPremiacion(Long.valueOf(oid_para_nive_prem));
        }                         
        
        /*if (num_vers != null && num_vers.length() > 0) {
            dtoe.setVersion(new Integer(num_vers));
        }*/
        Vector params = new Vector();
        traza("DTOElegirPremiosRec: " + dtoe);
	    params.add(dtoe);
	    params.add(new MareBusinessID("INCGuardarPremioRec"));
	    traza("# conectar ->  ConectorGuardarPremio ");
	    conectar("ConectorGuardarPremio", params);

        pagina("salidaGenerica");
        asignarAtributo("VAR", "ejecutar", "valor", "cerrar()");
    }

	//------------------------- UTILITIES --------------------------------------
    private Date toDate(String sFecha) throws Exception {
        
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        return this.toDate(sFecha, formatoFecha);
    }

    private Date toDate(String sFecha, String formatoFecha) throws Exception {
        
        formatoFecha = formatoFecha.replace('m', 'M');	
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
        java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);
        String fechaRes = miFecha.format(fecha);
        fecha = miFecha.parse(fechaRes);     	  	  
        return new java.sql.Date(fecha.getTime());
    }

	private String dateToString(Date dFecha) throws Exception {

        String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');
        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        return miFecha.format(dFecha);		  	  	  
    }
}