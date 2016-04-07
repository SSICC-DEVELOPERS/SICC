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

import es.indra.sicc.dtos.inc.DTOConcurso;

import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;


public abstract class LPIncentivosRanking extends LPSICCBase{ 

    DTOConcurso dtoConcurso;

    protected String accion;
    protected String opcionMenu;

    //Flags para estados de pestanyas
    protected String sIndEstadoParametrosGerentes;
    protected String sIndEstadoParametrosConsultoras;
    protected String sIndEstadoVariablesVenta;

    protected String idPestanyaDest;
    protected Integer nIdPestanyaDest;

    private MareBusinessID IDBusiness;
    private Vector params;

    private static final String CTE_DTO_CACHE = "cteDTOCache";

	public LPIncentivosRanking() { super(); }
  
	public abstract void inicio() throws Exception;
  
	public abstract void ejecucion() throws Exception;

	public DTOConcurso getConcurso() throws Exception {
		DTOConcurso concurso = null;
    
		traza("entra a getConcurso");
    
		try {
			traza("this.getSessionCache(): " + this.getSessionCache());

			concurso = (DTOConcurso)this.getSessionCache().get(LPIncentivosRanking.CTE_DTO_CACHE);
		} catch (Exception e){
			traza("no encontre el DTO en sesion");
		}
    
		traza("termina getConcurso " + concurso);
    
		return concurso;
	}
  
	public void setConcurso(DTOConcurso dto){
		this.getSessionCache().put(LPIncentivosRanking.CTE_DTO_CACHE, dto);
	}

  /**
   * 
   * @throws java.lang.Exception
   * @param idPestanyaDest
   * @author Marcelo J. Maidana -- 14/06/2005
   */
	public void redirigir() throws Exception {
    
		traza("entro a redirigir");

        this.idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);

		traza("idPestanyaDest: " + idPestanyaDest);

    
        if(idPestanyaDest == null){
            return;
        }

        try{
            nIdPestanyaDest = new Integer(idPestanyaDest);
            traza("nIdPestanyaDest: " + nIdPestanyaDest.toString() );
        }catch(NumberFormatException nfe){
            return;
        }
        
        if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_DATOS_GENERALES_RANKING)){
            this.invocarPestanya("LPMantenerConcursosRanking", "cargar");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PRODUCTOS_RANKING)){
            this.invocarPestanya("LPMantenerProductosRanking", "");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PREMIOS_RANKING)){

			traza("entro por premios");

            this.invocarPestanya("LPMantenerPremiosRanking", "");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_ALCANCE_GEOGRAFICO_RANKING)){
            this.invocarPestanya("LPMantenerAlcanceGeograficoRanking", "");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PARAMETROS_GERENTES_RANKING)){
            this.invocarPestanya("LPMantenerParametrosGerentesRanking", "");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PARAMETROS_CONSULTORAS_RANKING)){
            this.invocarPestanya("LPMantenerParametrosConsultorasRanking", "");
        } else if (this.nIdPestanyaDest.equals(ConstantesINC.PESTANYA_VARIABLES_VENTA_RANKING)){
            this.invocarPestanya("LPMantenerVariablesCalculoRanking", "");
        };
        
        traza("LPIncentivosRanking.redirigir - termino");
        
    }

	public abstract void almacenar() throws Exception;

	public abstract void cargarPantalla() throws Exception;

    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 15/06/2005
     */
	public void guardar() throws Exception{
    
        traza("LPIncentivosRanking.guardar - entro");
    
        try {
            this.pagina("salidaGenerica");
        
        
            //Se comprueba que se han insertado datos en todas las pestañas habilitadas 
            //y que todos los datos obligatorios de las pestañas están rellenos, 
            //si todo es correcto se guardan todos los datos del concurso 
            //Y si los datos mínimos para activar el concurso están rellenos y el 
            //indicador de activación está a true se activará el concurso.
            dtoConcurso = this.getConcurso();
            
            traza("dtoConcurso a grabar: " + dtoConcurso);
        
            //por defecto no podemos Activar 
            boolean indActivar = false;
    
            traza("LPIncentivosRanking.guardar - antes de condicion 1");
    
            if (dtoConcurso.getIndParamGenerales() != null && dtoConcurso.getIndParamGenerales().booleanValue() && dtoConcurso.getIndObligParamGenerales().booleanValue()
                && dtoConcurso.getIndProductosValidos() != null && dtoConcurso.getIndProductosValidos().booleanValue() 
                && dtoConcurso.getIndObligProductos().booleanValue()
                && dtoConcurso.getIndAmbitosGeograficos() != null && dtoConcurso.getIndAmbitosGeograficos().booleanValue() &&  dtoConcurso.getIndObligAmbitosGeograficos().booleanValue()
                && dtoConcurso.getIndPremios() != null && dtoConcurso.getIndPremios().booleanValue() &&  dtoConcurso.getIndObligPremios().booleanValue()){
                
                traza("LPIncentivosRanking.guardar - en condicion 1");
                
                
                indActivar = true;
    
                if (indActivar && dtoConcurso.getParamGenerales() != null 
                        && dtoConcurso.getParamGenerales().getOidDirigidoA() != null 
                        && dtoConcurso.getParamGenerales().getOidDirigidoA().equals(
                        ConstantesINC.OID_DIRIGIDO_A_GERENTE )){
                        
                    traza("dtoConcurso.getIndGerentes().booleanValue():" + dtoConcurso.getIndGerentes().booleanValue());
                    traza("dtoConcurso.getIndObligGerentes().booleanValue():" + dtoConcurso.getIndObligGerentes().booleanValue());
                        
                    indActivar = dtoConcurso.getIndGerentes().booleanValue() 
                        & dtoConcurso.getIndObligGerentes().booleanValue();
                        
                    traza("indActivar:" + indActivar);
                }
                
                if (indActivar && dtoConcurso.getParamGerentes() != null
                        && dtoConcurso.getParamGerentes().getOidFormaCalculo() != null
                        && dtoConcurso.getParamGerentes().getOidFormaCalculo().equals(
                        ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA)){
                       
                    traza("--b--");
                        
                    indActivar = dtoConcurso.getIndVariablesVentaRanking().booleanValue() 
                        & dtoConcurso.getIndObligVariablesVentaRanking().booleanValue();
                }
    
                if (indActivar && dtoConcurso.getParamGenerales() != null 
                        && dtoConcurso.getParamGenerales().getOidDirigidoA() != null 
                        && dtoConcurso.getParamGenerales().getOidDirigidoA().equals(
                        ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
                        
                    traza("--c--");
                        
                    indActivar = dtoConcurso.getIndConsultoras().booleanValue() &
                        dtoConcurso.getIndObligConsultoras().booleanValue();
                }
            }
            
            traza("LPIncentivosRanking.guardar - antes de condicion 2");
            
            //----------------------------------------------------------------------
            if (dtoConcurso.getParamGenerales() != null){
                traza("dtoConcurso.getParamGenerales(): " + dtoConcurso.getParamGenerales().getIndActivo());
            } else {
                traza("dtoConcurso.getParamGenerales(): null");
            }
            //----------------------------------------------------------------------
            
            if (dtoConcurso.getParamGenerales() != null 
                    && dtoConcurso.getParamGenerales().getIndActivo() != null 
                    && dtoConcurso.getParamGenerales().getIndActivo().booleanValue()){
                    
                traza("LPIncentivosRanking.guardar - en condicion 2");
                
                traza("indActivar: " + indActivar);
                
                //Si no se puede activar porque falta algún dato obligatorio o falta 
                //por rellenar alguna pestaña mostrar mensaje de aviso INC-0003: 
                //El concurso no se puede activar. Faltan datos obligatorios. 
                //Para guardar el concurso debe desactivarlo o completar los datos obligatorios.
                if (!indActivar){
                    //Si no se puede activar porque falta algún dato obligatorio o 
                    //falta por rellenar alguna pestaña 
                    //mostrar mensaje de aviso INC-0003: El concurso no se puede activar. 
                    //Faltan datos obligatorios. Para guardar el concurso debe 
                    //desactivarlo o completar los datos obligatorios.
                    throw new MareException(new Exception(), 130003);
                }
				else {
					//INICIO - AGREGADO POR INC 20727
					if(dtoConcurso.getIndClasificacionParticipantes().booleanValue()==true ) {
						this.guardarConcurso();
					}
					else {
						traza("********* Se lanzara un mensaje de error");
					    //ES DIRIGIDO A GERENTES
				        if(dtoConcurso.getParamGenerales().getOidDirigidoA().longValue()==
							ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
					        traza("********* Para gerentes");
					        throw new MareException(new Exception(), 130047);
					    }
						else { //ES DIRIGIDO A CONSULTORAS
   							traza("********* Para consultoras");
							throw new MareException(new Exception(), 130048);
						}
					//FIN - AGREGADO POR INC 20727        
					}				                  
                }
            } else {    //Si no ha activado el concurso, podemos guardar los datos que
                        //existan siempre y cuando sean coherentes (1)
                //Si están todos los datos mínimos, obligatorios, rellenos, se guardan 
                //los datos del concurso.
                if (indActivar){
                    this.guardarConcurso();
                } else { //(2), no están los datos mínimos obligatorios 
                    
                    //Si no se ha activado el concurso y no se puede guardar con todos 
                    //los datos mínimos obligatorios, guardamos si al menos tenemos 
                    //los parámetros generales.
                    if (dtoConcurso.getIndParamGenerales().booleanValue() && dtoConcurso.getIndObligParamGenerales().booleanValue()){
                        this.guardarConcurso();
                    } else {
                        //TODO
                        //mostrar el mensaje INC-0007: No se puede guardar los datos 
                        //de un concurso si no se han definido los parámetros generales.
                        throw new MareException(new Exception(), 130007);
                    }
                }
            }

            this.asignarAtributo("VAR", "ejecutar", "valor", "guardarOK()");
        
        } catch (Exception e){
            this.asignarAtributo("VAR", "ejecutarError", "valor", "guardarKO()");
            throw e;
        }
        
    }

    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private void guardarConcurso() throws Exception {
    
        traza("LPIncentivosRanking.guardarConcurso - entra");
    
        IDBusiness = new MareBusinessID("INCGuardarDatosConcursoRanking");
        params = new Vector();
        params.add(dtoConcurso);
        params.add(IDBusiness);
        
        traza("guardo !!!!!!!!!");
        this.conectar("ConectorGuardarDatosConcursoRanking", params);
        
        //Si no hay ningún error
     /*   this.conectorAction("LPMantenimientoConcursosRanking");
        this.conectorActionParametro("accion", "");
        this.conectorActionParametro("opcionMenu", this.opcionMenu);
        */
        traza("LPIncentivosRanking.guardarConcurso - termina");
    }

    /**
     * 
     * @throws java.lang.Exception
     * @param accion
     * @param lp
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private void invocarPestanya(String lp, String accion) throws Exception {
        traza("Invocar pestanya " + lp + " - accion: " + accion);
        this.conectorAction(lp);
        this.pasarFlagsPestanyas();
        this.conectorActionParametro("accion", accion);
        this.conectorActionParametro("opcionMenu", opcionMenu);
    }

    /**
     * 
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 15/06/2005
     */
    private void pasarFlagsPestanyas() throws Exception {
        this.conectorActionParametro("hIndEstadoParametrosGerentes", sIndEstadoParametrosGerentes);
        this.conectorActionParametro("hIndEstadoParametrosConsultoras", sIndEstadoParametrosConsultoras);
        this.conectorActionParametro("hIndEstadoVariablesVenta", sIndEstadoVariablesVenta);
    }

    /**
     * Se invoca desde las lp hijas, metodo ejecucion
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 16/06/2005
     */
    protected void obtenerFlagsPestanyas() throws Exception {
        sIndEstadoParametrosGerentes 
            = this.conectorParametroLimpia("hIndEstadoParametrosGerentes", "", true);
        sIndEstadoParametrosConsultoras 
            = this.conectorParametroLimpia("hIndEstadoParametrosConsultoras", "", true);
        sIndEstadoVariablesVenta 
            = this.conectorParametroLimpia("hIndEstadoVariablesVenta", "", true);
    }

    /**
     * Se invoca desde las lp hijas, metodo cargarPantalla
     * @throws java.lang.Exception
     * @author Marcelo J. Maidana -- 16/06/2005
     */
    protected void cargarFlagsPestanyas() throws Exception {
        this.asignarAtributo("VAR", "hIndEstadoParametrosGerentes", "valor", 
            sIndEstadoParametrosGerentes != null ? sIndEstadoParametrosGerentes : "N");
        this.asignarAtributo("VAR", "hIndEstadoParametrosConsultoras", "valor", 
            sIndEstadoParametrosConsultoras != null ? sIndEstadoParametrosConsultoras : "N");
        this.asignarAtributo("VAR", "hIndEstadoVariablesVenta", "valor", 
            sIndEstadoVariablesVenta != null ? sIndEstadoVariablesVenta : "N");
    }

}
