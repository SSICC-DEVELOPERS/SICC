import java.math.BigDecimal;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOSalida;

public abstract class LPIncentivos extends LPSICCBase{
  DTOConcurso concurso;
  String cteDTOCache;

  protected String accion;
  protected String opcionMenu;

  //Flags para estados de pestanyas
  protected String sIndEstadoProductos;
  protected String sIndEstadoAmbitoGeografico;
  protected String sIndEstadoCalificion;
  protected String sIndEstadoGerentes;
  protected String sIndEstadoConsultoras;
  protected String sIndEstadoProgramaNuevas;
  protected String sIndEstadoMultinivel;

  protected String idPestanyaDest;
  protected Integer nIdPestanyaDest;

  //sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
  protected String sOidVigenciaConcurso;
  
  public LPIncentivos() { super(); }
  
  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {}
  
  public DTOConcurso getConcurso() throws Exception {
    DTOConcurso concurso = null;    
    traza("*********** Entro LPIncentivos.getConcurso()");
	
    try {
	    concurso = (DTOConcurso)this.getSessionCache().get("cteDTOCache");
    }
	catch(Exception e){
		traza("****** No encontro el DTO en sesion");
    }
    
    traza("****** Termino getConcurso " + concurso);    
    return concurso;
  }
  
  public void setConcurso(DTOConcurso dto){
	this.getSessionCache().put("cteDTOCache", dto);		
  }
  
  /**
   * 
   * @throws java.lang.Exception
   * @param idPestanyaDest
   * @author Marcelo J. Maidana -- 05/05/2005
   */
  public void redirigir() throws Exception {  
    traza("****** Entro a redirigir()");

	if(idPestanyaDest == null){
		return;
	}

	try{
		nIdPestanyaDest = new Integer(idPestanyaDest);
		traza("********* nIdPestanyaDest: " + nIdPestanyaDest.toString());
	}
	catch(NumberFormatException nfe){
		return;
	}

    if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PARAMETROS_GENERALES)){
      traza("pestanya PESTANYA_PARAMETROS_GENERALES");
      this.invocarPestanya("LPMantenerParametrosGenerales", "cargar");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PRODUCTOS)){
      traza("pestanya PESTANYA_PRODUCTOS");
      this.invocarPestanya("LPMantenerProductos", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_PREMIOS)){
      traza("pestanya PESTANYA_PREMIOS");
      this.invocarPestanya("LPMantenerParametrosGeneralesPremiacion", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_REQUISITOS_PREMIACION)){
      traza("pestanya PESTANYA_REQUISITOS_PREMIACION");
      this.invocarPestanya("LPMantenerRequisitosPremiacion", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_OBTENCION_PUNTOS)){
      traza("pestanya PESTANYA_OBTENCION_PUNTOS");
      this.invocarPestanya("LPMantenerObtencionPuntos", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_DESPACHO_PREMIOS)){
      traza("pestanya PESTANYA_DESPACHO_PREMIOS");
      this.invocarPestanya("LPMantenerDespachoPremios", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_AMBITO_GEOGRAFICO)){
      traza("pestanya PESTANYA_AMBITO_GEOGRAFICO");
      this.invocarPestanya("LPMantenerAmbitoGeografico", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_CALIFICACION)){
      traza("pestanya PESTANYA_CALIFICACION");
      this.invocarPestanya("LPMantenerParametrosCalificacion", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_GERENTES)){
      traza("pestanya PESTANYA_GERENTES");
      this.invocarPestanya("LPMantenerParametrosGerentes", "");
    }
	else if(nIdPestanyaDest.equals(ConstantesINC.PESTANYA_CONSULTORAS)){
      traza("pestanya PESTANYA_CONSULTORAS");
      this.invocarPestanya("LPMantenerParametrosConsultoras", "");
    }
	else if(nIdPestanyaDest.equals( ConstantesINC.PESTANYA_PROGRAMA_NUEVAS)){
      traza("pestanya PESTANYA_PROGRAMA_NUEVAS");
      this.invocarPestanya("LPMantenerProgramaNuevas", "");
    }
	else if(nIdPestanyaDest.equals( ConstantesINC.PESTANYA_MULTINIVEL)){
      traza("pestanya PESTANYA_MULTINIVEL");
      this.invocarPestanya("LPMantenerMultinivel", "");
    }
    
    this.pasarFlagsPestanyas();
  }
  
  /**
   * 
   * @throws java.lang.Exception
   * @param accion
   * @param lp
   * @author Marcelo J. Maidana -- 04/05/2005
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
   * @author Marcelo J. Maidana -- 04/05/2005
   */
  private void pasarFlagsPestanyas() throws Exception {
	this.conectorActionParametro("hIndEstadoProductos", sIndEstadoProductos);
    this.conectorActionParametro("hIndEstadoAmbitoGeografico", sIndEstadoAmbitoGeografico);
    this.conectorActionParametro("hIndEstadoCalificion", sIndEstadoCalificion);
    this.conectorActionParametro("hIndEstadoGerentes", sIndEstadoGerentes);
    this.conectorActionParametro("hIndEstadoConsultoras", sIndEstadoConsultoras);
    this.conectorActionParametro("hIndEstadoProgramaNuevas", sIndEstadoProgramaNuevas);
    this.conectorActionParametro("hIndEstadoMultinivel", sIndEstadoMultinivel);
    
    // sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
    this.conectorActionParametro("oidVigenciaConcurso", sOidVigenciaConcurso);
  }
  
  /**
   * 
   * @throws java.lang.Exception
   * @author Marcelo J. Maidana -- 04/05/2005
   */
  //Se invoca desde las lp hijas, metodo ejecucion
  protected void obtenerFlagsPestanyas() throws Exception {
	sIndEstadoProductos = this.conectorParametroLimpia("hIndEstadoProductos", "", true);
    sIndEstadoAmbitoGeografico = this.conectorParametroLimpia("hIndEstadoAmbitoGeografico", "", true);
    sIndEstadoCalificion = this.conectorParametroLimpia("hIndEstadoCalificion", "", true);
    sIndEstadoGerentes = this.conectorParametroLimpia("hIndEstadoGerentes", "", true);
    sIndEstadoConsultoras = this.conectorParametroLimpia("hIndEstadoConsultoras", "", true);
    sIndEstadoProgramaNuevas = this.conectorParametroLimpia("hIndEstadoProgramaNuevas", "", true);
    sIndEstadoMultinivel = this.conectorParametroLimpia("hIndEstadoMultinivel", "", true);
    
    // sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
    sOidVigenciaConcurso = this.conectorParametroLimpia("oidVigenciaConcurso", "", true);

    idPestanyaDest = this.conectorParametroLimpia("idPestanyaDest", "", true);
  }

  /**
   * 
   * @throws java.lang.Exception
   * @author Marcelo J. Maidana -- 04/05/2005
   */
  //Se invoca desde las lp hijas, metodo cargarPantalla
  protected void cargarFlagsPestanyas() throws Exception {
    this.asignarAtributo("VAR", "hIndEstadoProductos", "valor", sIndEstadoProductos!=null?sIndEstadoProductos:"N");
    this.asignarAtributo("VAR", "hIndEstadoAmbitoGeografico", "valor", sIndEstadoAmbitoGeografico!=null?sIndEstadoAmbitoGeografico:"N");
    this.asignarAtributo("VAR", "hIndEstadoCalificion", "valor", sIndEstadoCalificion!=null?sIndEstadoCalificion:"N");
    this.asignarAtributo("VAR", "hIndEstadoGerentes", "valor", sIndEstadoGerentes!=null?sIndEstadoGerentes:"N");
    this.asignarAtributo("VAR", "hIndEstadoConsultoras", "valor", sIndEstadoConsultoras!=null?sIndEstadoConsultoras:"N");
    this.asignarAtributo("VAR", "hIndEstadoProgramaNuevas", "valor", sIndEstadoProgramaNuevas!=null?sIndEstadoProgramaNuevas:"N");
    this.asignarAtributo("VAR", "hIndEstadoMultinivel", "valor", sIndEstadoMultinivel!=null?sIndEstadoMultinivel:"N");
    
    // sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
    this.asignarAtributo("VAR", "oidVigenciaConcurso", "valor", sOidVigenciaConcurso!=null?sOidVigenciaConcurso:"");
  }
  
  public abstract void almacenar() throws Exception;
  
  public abstract void cargarPantalla() throws Exception;
  
  /**
   * @Author: ssantana -- 26/5/2005
   * @throws java.lang.Exception
   */
  public void guardar() throws Exception{
    //  Se comprueba que se han insertado datos en todas las 
    // pestañas habilitadas y que todos los datos obligatorios 
    // de las pestañas están rellenos, si todo es correcto se guardan 
    // todos los datos del concurso.
    //  Y si los datos mínimos para activar el concurso están rellenos y el indicador de activación 
    // está a true se activará el concurso. 
    
    opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
    this.pagina("salidaGenerica");
    
    traza("Entrando a LPIncentivos.guardar()");
    DTOConcurso dtoConcurso = this.getConcurso();
    boolean indActivar = false; // Por defecto no debemos activar
    
    // Booleanos varios que se usan en el método. 
    boolean indParamGenerales = dtoConcurso.getIndParamGenerales() != null 
                                ? dtoConcurso.getIndParamGenerales().booleanValue() : false;
    traza("indParamGenerales ***** " + indParamGenerales);

    boolean indProductosValidos = dtoConcurso.getIndProductosValidos() != null 
                                    ? dtoConcurso.getIndProductosValidos().booleanValue() : false;
    traza("indProductosValidos ***** " + indProductosValidos);

	//jrivas 1/7/2005
	//INC 19617
	boolean indObligProductosValidos = dtoConcurso.getIndObligProductosValidos() != null 
                                    ? dtoConcurso.getIndObligProductosValidos().booleanValue() : false;
    traza("indObligProductosValidos ***** " + indObligProductosValidos);
	
	boolean indPremios = dtoConcurso.getIndPremios() != null 
                            ? dtoConcurso.getIndPremios().booleanValue() : false;
    traza("indPremios ***** " + indPremios);
    
	boolean indReqPremiacion = dtoConcurso.getIndRequisitosPremacion() != null 
                                ? dtoConcurso.getIndRequisitosPremacion().booleanValue() : false;
    traza("indReqPremiacion ***** " + indReqPremiacion);

	boolean indObtencionPuntos = dtoConcurso.getIndObtencionPuntos() != null 
                                    ? dtoConcurso.getIndObtencionPuntos().booleanValue() : false;
	traza("indObtencionPuntos ***** " + indObtencionPuntos);

	boolean indDespachoPremios = dtoConcurso.getIndDespachoPremios() != null 
                                    ? dtoConcurso.getIndDespachoPremios().booleanValue() : false;
	traza("indDespachoPremios ***** " + indDespachoPremios);

	boolean indObligParamGenerales = dtoConcurso.getIndObligParamGenerales() != null 
                                    ? dtoConcurso.getIndObligParamGenerales().booleanValue() : false;
	traza("indObligParamGenerales ***** " + indObligParamGenerales);
	
    boolean indObligProductos = dtoConcurso.getIndObligProductos() != null 
                                ? dtoConcurso.getIndObligProductos().booleanValue() : false;
	traza("indObligProductos ***** " + indObligProductos);

	boolean indObligPremios = dtoConcurso.getIndObligPremios() != null 
                                ? dtoConcurso.getIndObligPremios().booleanValue() : false;
	traza("indObligPremios ***** " + indObligPremios);

	boolean indObligRequisitosPremiacion = dtoConcurso.getIndObligRequisitosPremiacion() != null 
        ? dtoConcurso.getIndObligRequisitosPremiacion().booleanValue() : false;
	traza("indObligRequisitosPremiacion ***** " + indObligRequisitosPremiacion);

	boolean indObligObtencionPuntos = dtoConcurso.getIndObligObtencionPuntos() != null 
        ? dtoConcurso.getIndObligObtencionPuntos().booleanValue() : false;
	traza("indObligObtencionPuntos ***** " + indObligObtencionPuntos);

	boolean indObligDespachoPremios = dtoConcurso.getIndObligDespachoPremios() != null 
        ? dtoConcurso.getIndObligDespachoPremios().booleanValue() : false;
	traza("indObligDespachoPremios ***** " + indObligDespachoPremios);

	boolean indParamGralesActivo = dtoConcurso.getParamGenerales() != null 
        && dtoConcurso.getParamGenerales().getIndActivo() != null 
        ? dtoConcurso.getParamGenerales().getIndActivo().booleanValue() : false;
	traza("indParamGralesActivo ***** " + indParamGralesActivo);

	//jrivas 1/7/2005
	//INC 19617
	boolean indPlantillaProductosValidos = 
		dtoConcurso.getPlantilla() != null 
		&& dtoConcurso.getPlantilla().getIndProductosValidos() != null 
		? dtoConcurso.getPlantilla().getIndProductosValidos().booleanValue() : false;
	traza("indPlantillaProductosValidos ***** " + indPlantillaProductosValidos);	

	boolean constantesINCActivo = false;
    
    if (ConstantesINC.IND_ACTIVO.intValue() != 0){
        constantesINCActivo = true;
    }
    
    if(dtoConcurso.getParamGenerales() == null){
        traza("dtoConcurso.getParamGenerales() es null");
    }else{
        if(dtoConcurso.getParamGenerales().getIndActivo() == null){
            traza("dtoConcurso.getParamGenerales().getIndActivo() es null");
        }else{
            traza("dtoConcurso.getParamGenerales().getIndActivo(): " + dtoConcurso.getParamGenerales().getIndActivo().booleanValue());
        }
    }

    
    traza("1 constantesINCActivo "+ constantesINCActivo);


	//jrivas 1/7/2005
	//INC 19617
	if (indParamGenerales && indPremios && indReqPremiacion &&
         indObtencionPuntos && indDespachoPremios && indObligParamGenerales && 
         indObligPremios && indObligRequisitosPremiacion &&
         indObligObtencionPuntos && indObligDespachoPremios &&
		 ((indProductosValidos && indObligProductosValidos) || indPlantillaProductosValidos) ) {  // If (1)
         
            // Booleans de DTOConcurso. 
            boolean indCalificacion = dtoConcurso.getIndParamCalificacion() != null 
                                    ? dtoConcurso.getIndParamCalificacion().booleanValue() : false;
			traza("indCalificacion ***** " + indCalificacion);

			boolean indObligCalificacion = dtoConcurso.getIndObligCalificacion() != null 
                                    ? dtoConcurso.getIndObligCalificacion().booleanValue() : false;
			traza("indObligCalificacion ***** " + indObligCalificacion);

            boolean indGerentes = dtoConcurso.getIndGerentes() != null 
                                    ? dtoConcurso.getIndGerentes().booleanValue() : false;
			traza("indGerentes ***** " + indGerentes);

            boolean indObligGerentes = dtoConcurso.getIndObligGerentes() != null 
                                    ? dtoConcurso.getIndObligGerentes().booleanValue() : false;
			traza("indObligGerentes ***** " + indObligGerentes);

            boolean indConsultoras = dtoConcurso.getIndConsultoras() != null 
                                    ? dtoConcurso.getIndConsultoras().booleanValue() : false;
			traza("indConsultoras ***** " + indConsultoras);

            boolean indObligConsultoras = dtoConcurso.getIndObligConsultoras() != null 
                                    ? dtoConcurso.getIndObligConsultoras().booleanValue() : false;
			traza("indObligConsultoras ***** " + indObligConsultoras);

            boolean indProgramasNuevas = dtoConcurso.getIndProgramaNuevas() != null 
                                    ? dtoConcurso.getIndProgramaNuevas().booleanValue() : false;
			traza("indProgramasNuevas ***** " + indProgramasNuevas);

            boolean indObligProgramasNuevas = dtoConcurso.getIndObligProgramaNuevas() != null 
                                    ? dtoConcurso.getIndObligProgramaNuevas().booleanValue() : false;
			traza("indObligProgramasNuevas ***** " + indObligProgramasNuevas);

            boolean indMultinivel = dtoConcurso.getIndMultinivel() != null 
                                    ? dtoConcurso.getIndMultinivel().booleanValue() : false;
			traza("indMultinivel ***** " + indMultinivel);

            boolean indObligMultinivel = dtoConcurso.getIndObligMultinivel() != null 
                                    ? dtoConcurso.getIndObligMultinivel().booleanValue() : false;
			traza("indObligMultinivel ***** " + indObligMultinivel);

            boolean indAmbitoGeografico = dtoConcurso.getIndAmbitosGeograficos() != null 
                                    ? dtoConcurso.getIndAmbitosGeograficos().booleanValue() : false;
			traza("indAmbitoGeografico ***** " + indAmbitoGeografico);

            boolean indObligAmbitoGeografico = dtoConcurso.getIndObligAmbitosGeograficos() != null 
                ? dtoConcurso.getIndObligAmbitosGeograficos().booleanValue() : false;
			traza("indObligAmbitoGeografico ***** " + indObligAmbitoGeografico);
            
            // Booleanos de DTOConcurso.Plantilla
            boolean indFaseCalificacionPlantilla = 
                dtoConcurso.getPlantilla() != null && 
                dtoConcurso.getPlantilla().getIndFaseCalificacion() != null 
                ? dtoConcurso.getPlantilla().getIndFaseCalificacion().booleanValue() : false;
			traza("indFaseCalificacionPlantilla ***** " + indFaseCalificacionPlantilla);

            boolean indProgramasNuevasPlantilla = 
                dtoConcurso.getPlantilla() != null 
                && dtoConcurso.getPlantilla().getIndProgramaNuevas() != null 
                ? dtoConcurso.getPlantilla().getIndProgramaNuevas().booleanValue() : false;
			traza("indProgramasNuevasPlantilla ***** " + indProgramasNuevasPlantilla);

            boolean indMultinivelPantilla = 
                dtoConcurso.getPlantilla() != null 
                && dtoConcurso.getPlantilla().getIndMultinivel() != null 
                ? dtoConcurso.getPlantilla().getIndMultinivel().booleanValue() : false;
			traza("indMultinivelPantilla ***** " + indMultinivelPantilla);

            boolean indAmbitoGeograficoPlantilla = 
                dtoConcurso.getPlantilla() != null 
                && dtoConcurso.getPlantilla().getIndAmbitoGeografico() != null 
                ? dtoConcurso.getPlantilla().getIndAmbitoGeografico().booleanValue() : false;
			traza("indAmbitoGeograficoPlantilla ***** " + indAmbitoGeograficoPlantilla);

            Long oidDirigidoA = dtoConcurso.getPlantilla().getOidDirigidoA();

            traza("2");
            indActivar = true;
            if ( (indActivar) && (indFaseCalificacionPlantilla ==  constantesINCActivo)) {
              traza("3" + indActivar);
              indActivar = indCalificacion & indObligCalificacion;
            }
            
            traza("4" + indActivar);
			if ( (indActivar) && 
                 (oidDirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE))) {
		             traza("5" + indActivar);
                     indActivar = indGerentes & indObligGerentes;
            }
            
            traza("6" + indActivar);
            if ( (indActivar) && 
                 (oidDirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)) ) {
		             traza("7" + indActivar);
                     indActivar = indConsultoras & indObligConsultoras;
                 }
                 
            traza("8" + indActivar);
            if ( (indActivar) && (indProgramasNuevasPlantilla == constantesINCActivo) ) {
	            traza("9" + indActivar);
                indActivar = indProgramasNuevas & indObligProgramasNuevas;
            }
            
            traza("10" + indActivar);
            if ( (indActivar) && (indMultinivelPantilla == constantesINCActivo) ) {
	            traza("11" + indActivar);
                indActivar = indMultinivel & indObligMultinivel;
            }
            
            traza("12" + indActivar);
            if ( (indActivar) && (indAmbitoGeograficoPlantilla != constantesINCActivo) ){
	            traza("1" + indActivar);
                indActivar = indAmbitoGeografico & indObligAmbitoGeografico;
            }
           
    } else {// Fin if (1) 
		traza("no entro por ahy");
	}
    
    traza("******** indParamGralesActivo " + indParamGralesActivo );
    if ( indParamGralesActivo == constantesINCActivo) {

		traza("********* indActivar " + indActivar );
        if ( !indActivar ) { 
            traza("********* No se puede activar porque falta algún dato ");
            traza("********* obligatorio o falta por rellenar alguna pestaña");
 			throw new MareException(new Exception(), 130003);
        } 
		else{
			if(dtoConcurso.getParamGenerales().getOidDirigidoA().longValue()==
               ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
				traza("******** Entro por gerentes");
				traza("******** Comienzan validaciones");

				traza("******** 1° - Participantes");
				if((dtoConcurso.getIndClasificacionParticipantes().booleanValue()==true &&
			        dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue()==false) ||
			       (dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue()==true)) {
					traza("******** OK");
				}
				else { 			    
					traza("******** ERR");
					throw new MareException(new Exception(), 130047);									
				}


				if(dtoConcurso.getParamGerentes()!=null &&
				   dtoConcurso.getParamGerentes().getOidFormaCalculo()!=null &&
				   dtoConcurso.getParamGerentes().getOidFormaCalculo().longValue()==
				   ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.longValue()) {

					traza("******** 2° - Variables de venta");
					if(dtoConcurso.getIndVariablesVenta().booleanValue()==true) {
	 					traza("******** OK");
					}
					else {
						traza("******** ERR");
 						throw new MareException(new Exception(), 130051);
					}
				}	
				 
				 if(dtoConcurso.getParamGerentes()!=null &&
					dtoConcurso.getParamGerentes().getOidFormaCalculo()!=null &&					   
					dtoConcurso.getParamGerentes().getOidFormaCalculo().longValue()==
					ConstantesINC.OID_FORMA_CALC_BASE_CALC.longValue()) {	

					if(dtoConcurso.getParamGerentes().getOidBaseCalculo()!=null &&
					    dtoConcurso.getParamGerentes().getOidBaseCalculo().longValue() ==
					    ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.longValue()) {
						 traza("******** 3° - Base de calculo = Recomendadas");		

						if(dtoConcurso.getIndMontoVentaRecomendadas().booleanValue()==true) {
							traza("******** OK");
						}
						else {
							traza("******** ERR");
							throw new MareException(new Exception(), 130049);
						}
					}		
				 }


				 traza("******** Finalizan validaciones");
				 this.guardarConcurso(dtoConcurso);

 			     if (opcionMenu.equals("Modificar Concurso")) {
					this.asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
				 }
				 else {       
					this.conectorAction("LPCrearConcurso");
					this.conectorActionParametro("accion", "");
					this.conectorActionParametro("opcionMenu", opcionMenu);
				 }			  
			}
			else if(dtoConcurso.getParamGenerales().getOidDirigidoA().longValue()==
            ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue()) {
				traza("******** Entro por consultoras");

				traza("******** 1° - Participantes");
				if((dtoConcurso.getIndClasificacionParticipantes().booleanValue()==true &&
			        dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue()==false) ||
			       (dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue()==true)) {
					traza("******** OK");
				}
				else { 			    
					traza("******** ERR");
					throw new MareException(new Exception(), 130048);									
				}

				
				if(dtoConcurso.getParamConsultoras().getOidBaseCalculo()!=null &&
				   dtoConcurso.getParamConsultoras().getOidBaseCalculo().longValue() ==
				   ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.longValue()) {

					traza("******** 2° - Base de calculo = Recomendadas");		
					if(dtoConcurso.getIndMontoVentaRecomendadas().booleanValue()==true) {
						traza("******** OK");
					}
					else {
						traza("******** ERR");
						throw new MareException(new Exception(), 130050);
					}
				}
				traza("777777777777 3° - requisito premiacion");
				//Agregado por cambio 20090929

				if(dtoConcurso.getIndRequisitosPremacion().booleanValue()==true){
					         traza("validaDeuda: "+ dtoConcurso.getRequisitosPremiacion().getOidValiDeuda());
							if (dtoConcurso.getRequisitosPremiacion().getOidValiDeuda() != null)
							{
									
									if(dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax() != null){				  	
																					
													if(dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax() >= dtoConcurso.getParamGenerales().getOidPeriodoDesde()){
														traza("777777777 OK");
													}else{
														traza("777777777 ERR");
														traza("777777 Período Máximo de Asignación de Premios inconsistente. Debe ser mayor o igual al Período Inicial del Concurso 7777 ");
														throw new MareException(new Exception(), 130347);
													}


									 
									//obtenemos la lista de periodos				
									Vector periodos = obtenerPeriodos(dtoConcurso);

				
									Long periodoDespacho = null; 
									Long numeroPeriodoEspera = null;
									Long rta = null;
									Long perioHasta = null;
									Long numPerioEva= null;
								    if(dtoConcurso.getParamGralesPremiacion() != null ){ 							
								
										 if (dtoConcurso.getParamGralesPremiacion().getIndPeriodoDespacho().booleanValue()==true)
										{
												periodoDespacho = dtoConcurso.getParamGralesPremiacion().getOidPeriodo();
												traza("777777periodoDespacho: " + periodoDespacho);
												numeroPeriodoEspera = dtoConcurso.getRequisitosPremiacion().getNumeroPerioEspera();
												traza("7777numeroPeriodoEspera: " + numeroPeriodoEspera);
												//rta = periodoDespacho + numeroPeriodoEspera;
												rta = obtenerPeriodoMaximo(periodos, periodoDespacho, numeroPeriodoEspera);
												
												traza("77777rta: " + rta);
												traza("periodoMaximo: " + dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax());
												if(dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax().equals(rta)){
													traza("777777777777 OK periodoMaximo es igual a periodo despacho + numeroPeriodoEspera");
												}else{
													traza("7777777777 Error");
													traza("error 130348: Período Máximo de Asignación de Premios inconsistente. Debe  ser Período de Despacho + Nro de Períodos de Espera de Pago ");
													throw new MareException(new Exception(), 130348);	
												}
										}	// if indicador Despacho 
										else if (dtoConcurso.getParamGralesPremiacion().getOidPeriodo() == null && dtoConcurso.getPlantilla().getOidBaseCalculo() == 4)
										{	
											if(dtoConcurso.getRequisitosPremiacion() != null){	 
											   if(dtoConcurso.getParamGenerales().getOidPeriodoHasta() != null){	
													perioHasta = dtoConcurso.getParamGenerales().getOidPeriodoHasta();
											   }else{
													perioHasta = new Long(0);
											   }
											   numPerioEva = Long.valueOf(dtoConcurso.getParamConsultoras().getNroPeriodosEvaluar().toString());
											   numeroPeriodoEspera = dtoConcurso.getRequisitosPremiacion().getNumeroPerioEspera();
											   //rta = perioHasta + numPerioEva + numeroPeriodoEspera;
											   rta = obtenerPeriodoMaximo(periodos, perioHasta, numPerioEva + numeroPeriodoEspera);
											   traza("77777777 perioHasta + numPerioEva + numeroPeriodoEspera: " + rta);
											   traza("77777777 periodoMaximo: " + dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax());
											   if(dtoConcurso.getRequisitosPremiacion().getOidPeriodoMax().equals(rta)){
													traza("7777777 OK");
											   }else{
													traza("7777777777 Error");
													traza("Error 130349: Período Máximo de Asignación de Premios inconsistente. Debe  ser Período Hasta + Nro de Períodos a Evaluar + Nro de períodos de Espera de Pago ");
													throw new MareException(new Exception(), 130349);		
											   } // esle error
									   
											}	  
										}
									
							
							}// if parametros premiacion.
						 }	// PERIODO MAXIMO
						 else{
									traza("7777777777 ERROR");
									traza("Error 130350: El periodo que corresponde asignar al “Período Máximo de Asignación de premios” no existe. ");
									throw new MareException(new Exception(), 130350);			
						 }
   
	    				} // VALIDA DEUDA 
					}// INDICADOR REQUISITO PREMIACION.

				 traza("******** Finalizan validaciones");
				 this.guardarConcurso(dtoConcurso);

 			     if (opcionMenu.equals("Modificar Concurso")) {
					this.asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
				 }
				 else {       
					this.conectorAction("LPCrearConcurso");
					this.conectorActionParametro("accion", "");
					this.conectorActionParametro("opcionMenu", opcionMenu);
				 }			  
			}//Se agrega las por cambio 20090929 // ESTO DEBE ESTAR DENTRO DE CONSU
			
	  		  
			 
		}
        
      
    } else {  // No estan los parametros obligatorios mínimos. 
		// dmorello, 09/12/2005
		// Se agrega el siguiente IF que estaba presente en el diseño pero faltaba en el código
		// El código que anteriormente se hallaba en este bloque va contenido dentro del ELSE de este nuevo IF.
		if (indActivar) {
			traza("190");
			this.guardarConcurso(dtoConcurso);
			if (opcionMenu.equals("Modificar Concurso")) {
			   traza("AAAA1");
			   this.asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
			} else {
			   // TODO: Llamar a LP para recarga. 
			   // Si termina todo ok realiza llamada a LPMantenimientoConcursos
			   traza("BBBB1");
			   this.conectorAction("LPCrearConcurso");
			   this.conectorActionParametro("accion", "");
			   this.conectorActionParametro("opcionMenu", opcionMenu);
			}
		} else {
			traza("200");
			if ( indParamGenerales && indObligParamGenerales ) {
				// Si no se ha activado el concurso y no se puede guardar con 
				// todos los datos mínimos obligatorios, guardamos si al menos 
				// tenemos los parámetros generales 
				traza("210");            
				this.guardarConcurso(dtoConcurso);

				// INC 21375
				// Se hará aparecer un cartel que avisa que no se completaron todos los datos obligatorios
				// Como después de este cartel, si estamos en Modificar Concurso, hay que cerrar el cuadro de
				// diálogo, ambas llamadas a funciones JavaScript irán en el mismo String.
				if (opcionMenu.equals("Modificar Concurso")) {
				   traza("AAAA2");
				   // Se llamará a la función JavaScript que muestra el cartel y cierra el diálogo web.
				   this.asignarAtributo("VAR", "ejecutar", "valor", "mostrarAlertaYCerrar()");
				   traza("Ejecutó el JavaScript y sale");
				} else {
				   // TODO: Llamar a LP para recarga. 
				   // Si termina todo ok realiza llamada a LPMantenimientoConcursos
				   traza("BBBB2");
				   // Se llama a la función JavaScript que muestra el cartel y luego ejecuta la LPCrearConcurso
				   // Necesito pasarle como parámetro opcionMenu
				   String js = "mostrarAlerta('" + ((opcionMenu!=null)? opcionMenu : "") + "');";
				   traza("JavaScript a ejecutar: " + js);
				   this.asignarAtributo("VAR", "ejecutar", "valor", js);
				   traza("Ejecutó el JavaScript, continúa cargando la LPCrearConcurso desde la página misma");
				   
				   // Se eliminan estas líneas, ya que se accede a la LP con el JavaScript recién ejecutado

				   //this.conectorAction("LPCrearConcurso");
				   //this.conectorActionParametro("accion", "");
				   //this.conectorActionParametro("opcionMenu", opcionMenu);
				}
				// Fin modificaciones INC 21375
			}
			else {
			  traza("220");
			  //No se puede guardar los datos de un concurso si no se han definido los parámetros generales.         
			  throw new MareException(new Exception(), 130007);
			}
		}
    }    
  }
  
  private void guardarConcurso(DTOConcurso dtoConcurso) throws Exception {  
     traza("******* guardarConcurso");
     Vector vParams = new Vector();
     MareBusinessID bussID = new MareBusinessID("INCGuardarDatosConcurso");
     
     vParams.add(dtoConcurso);
     vParams.add(bussID);
     
     traza("******** Antes de conectar");
     DruidaConector con = this.conectar("ConectorGuardarDatosConcurso", vParams);      
     setConcurso(null);
	 //Agregado por Cristian Valenzuela-24/2/2006
	 //Despues de grabar se limpian dtos de
	 //sesion utilizados en la pestaña Calificacion
     traza("******** Limpiando DTOs en sesion **********");
	 conectorParametroSesion("DTOModalVariablesVentaProyectada", null);
	 conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia", null);
	 conectorParametroSesion("dtoListaMetasAuxiliarRegion", null);
	 conectorParametroSesion("dtoListaMetasAuxiliarZona", null);
	 //FIN-Agregado por Cristian Valenzuela-24/2/2006
     traza("******** Luego de Conectar");    
  }
  
    //Agregado por cambio 20090929
	//Este metodo obtiene la lista de periodos de la aplicacion 
	private Vector obtenerPeriodos(DTOConcurso concurso) throws Exception {
		traza("************ Entre a obtenerPeriodos");

		DTOPeriodo dtoPeriodo = new DTOPeriodo();
		dtoPeriodo.setPais(concurso.getOidPais());
		dtoPeriodo.setMarca(concurso.getParamGenerales().getOidMarca());
		dtoPeriodo.setCanal(concurso.getParamGenerales().getOidCanal());
	
		MareBusinessID businessID = new MareBusinessID("CRAObtienePeriodos");
		Vector parametro = new Vector(); 
		parametro.add(dtoPeriodo);
		parametro.add(businessID);
		traza("********** Antes de conectar");
		DruidaConector resultados = new DruidaConector();
		resultados  = conectar("ConectorObtenerDatosPeriodo", parametro);
		traza("ConectorObtenerDatosPeriodo");
		
        DTOSalida dtoSalida = (DTOSalida)resultados.objeto("rsSalida");
        RecordSet rs = dtoSalida.getResultado(); 
		Vector vec= new Vector();
		if(!rs.esVacio()){
			for(int i = 0; i <rs.getRowCount(); i++){
				DTOPeriodo periodo = new DTOPeriodo();
				periodo.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_PERI")).toString()));
				periodo.setNombre((String)rs.getValueAt(i,"VAL_NOMB_PERI"));
				vec.add(periodo);
			}				
		}
		
		return vec;
	}
	
	//Agregado por cambio 20090929
	private Long obtenerPeriodoMaximo(Vector periodos, Long oidPeriodo, Long numeroPeriodos) throws Exception {
		int k = 0;
		
		//encontramos el periodo Hasta o periodo Despacho
		for (int i = 0;i < periodos.size(); i++ ) {
			DTOPeriodo per = new DTOPeriodo();
			per = (DTOPeriodo)periodos.get(i);
			
			if(per.getOid().longValue() == oidPeriodo.longValue()){
				k=i;
				break;
			}
			
		}
		k = k+numeroPeriodos.intValue();
		
		if(k < periodos.size()) {
			DTOPeriodo per = (DTOPeriodo)periodos.get(k);

			traza("oid: " + per.getOid().toString());
			traza("des: "  + per.getNombre());
			
			return per.getOid();
		}
		
		return 0L;
	}
  
}
