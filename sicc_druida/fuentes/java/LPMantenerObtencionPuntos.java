import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOObtencionPuntos;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.util.UtilidadesBelcorp;

public class LPMantenerObtencionPuntos extends LPIncentivos{ 
  private String pais = null;
  private Long lPais = null;   
  private String idioma = null;

  private String datosObligatorios = null;
  private String estadoAGeo = null;
  private String estadoCali = null;
  private String estadoGerente = null;
  private String estadoConsultora= null;
  private String programaNuevas= null;
  private String estadoMultinivel= null;  

  private String factorConversion = null;  
  private String puntosAsig = null;  
  private String indComunic = null;  
  private String txtMensaj = null;  
  private String indPuntajeAcu = null;  
  private String indActividad = null;  
  private String indConstancia = null;  
  private String oidObtencion = null;
  
  //sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
  private String numPeriodosSinPedido = null;
  
  public LPMantenerObtencionPuntos() { super(); }

  public void inicio() throws Exception {        
    this.obtenerFlagsPestanyas();
    pagina("contenido_obtencion_puntos_mantener");    
    this.cargarFlagsPestanyas();    
    this.getFormatosValidaciones();
  }  
  
  //metodo que se ejecuta la incializar la pantalla
  public void ejecucion() throws Exception {
    setTrazaFichero();

	traza("************* Entre a LPMantenerObtencionPuntos");
    
    accion = conectorParametroLimpia("accion", "", true);
	opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
    datosObligatorios = conectorParametroLimpia("datosObligatorios", "", true);    

    traza("************* accion " + accion);
	traza("************* opcionMenu " + opcionMenu);
	traza("************* datosObligatorios " + datosObligatorios);
        
    pais = UtilidadesSession.getPais(this).toString();     
	lPais = UtilidadesSession.getPais(this);
    idioma = UtilidadesSession.getIdioma(this).toString();    
	
    estadoAGeo = conectorParametroLimpia("hIndEstadoAmbitoGeografico", "", true);
    estadoCali = conectorParametroLimpia("hIndEstadoCalificion", "", true);
    estadoGerente = conectorParametroLimpia("hIndEstadoGerentes", "", true);
    estadoConsultora = conectorParametroLimpia("hIndEstadoConsultoras", "", true);
    programaNuevas = conectorParametroLimpia("hIndEstadoProgramaNuevas", "", true);
    estadoMultinivel = conectorParametroLimpia("hIndEstadoMultinivel", "", true);
   
    try {    	    
	    asignarAtributo("VAR","hPais","valor",pais);
        asignarAtributo("VAR","hIdioma","valor",idioma);         
        asignarAtributo("VAR", "hIndEstadoAmbitoGeografico", "valor", estadoAGeo);         
    
        if (accion.equals("")){ 
            this.cargarPantalla();
        }
		else{        
			if (accion.equals("almacenar")){                                      
				// Modificado por ssantana 19/5/2005                      
                this.almacenar();                 
                this.redirigir();
            } 
            if (accion.equals("guardar")){           
                this.almacenar(); 
                this.guardar();            
            }
            if(accion.equals("redirigir")){
                this.redirigir();
            }    
      }  
        
      getConfiguracionMenu("LPMantenerObtencionPuntos" , ""); 
        
      if(opcionMenu.equals("Crear concurso")){
            asignarAtributoPagina("cod", "0491");             
      }
	  else if(opcionMenu.equals("Consultar Concurso")){
            asignarAtributoPagina("cod", "0493");
      }
	  else if(opcionMenu.equals("Modificar Concurso")){
            asignarAtributoPagina("cod", "0486");
      }        
  }
  catch (Exception e){
        traza("Exception en LPMantenerObtencionPuntos");
        e.printStackTrace();     
        lanzarPaginaError(e);
  }    
}
  
	public void cargarPantalla() throws Exception{    
		traza("*********** Entre a cargarPantalla");
		DTOConcurso dto = this.getConcurso(); 
   
	    Boolean checkComunicacion = Boolean.FALSE;
		Boolean txtMen = Boolean.FALSE;
		Boolean checkActividad = Boolean.FALSE;
		Boolean checkAcumulativo = Boolean.FALSE;
		Boolean checkConstancia = Boolean.FALSE;
		Boolean campos = Boolean.FALSE;
	  
		String oidObtencion = null;   
		String txtPuntosAsignar = null;
		String txtFactorConversion = null;
		String txtMensaje = null;
		String chkComuncacion = null;
		
		// sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
		String txtNumPeriodosSinPedido = null;
   
		if(dto.getIndObtencionPuntos()!=null) {      
			if(dto.getIndObtencionPuntos().booleanValue() == true) {      				
				if(dto.getObtencionPuntos().getFactorConversion()!=null) {
					txtFactorConversion =
  				    UtilidadesBelcorp.formateaNumeroSICC(dto.getObtencionPuntos().getFactorConversion().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					txtFactorConversion = "";
				}

				if(dto.getObtencionPuntos().getPuntosAsignar()!=null) {
					txtPuntosAsignar = UtilidadesBelcorp.formateaNumeroSICC(dto.getObtencionPuntos().getPuntosAsignar().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					txtPuntosAsignar = "";
				}
				
			    chkComuncacion = dto.getObtencionPuntos().getIndComunicacion().toString();

				traza("********** txtFactorConversion " + txtFactorConversion);
				traza("********** txtPuntosAsignar " + txtPuntosAsignar);
				traza("********** chkComuncacion " + chkComuncacion);

				//- Si el indicador es uno se selecciona el check
				if (chkComuncacion.equals("1")) checkComunicacion = Boolean.TRUE;

				if (dto.getObtencionPuntos().getIndComunicacion().intValue() == ConstantesINC.IND_ACTIVO.intValue()){ 
					chkComuncacion = ConstantesINC.IND_ACTIVO.toString(); //se selecciona el check box
					txtMensaje = dto.getObtencionPuntos().getMensaje();  
				}
				else{
					//--no esta activo , deshabilitar txtMensaje       
					txtMen = Boolean.TRUE;
				}
     
				String chkPuntajeEsAcumulativo = dto.getObtencionPuntos().getIndPuntajeAcumulativo().toString();
        
				if (chkPuntajeEsAcumulativo.equals("1")) checkAcumulativo = Boolean.TRUE;
     
				String chkActividad = dto.getObtencionPuntos().getIndActividad().toString();     
				if (chkActividad.equals("1")){
					checkActividad = Boolean.TRUE;
				}
     
				String chkConstancia = dto.getObtencionPuntos().getIndConstancia().toString();
				if (chkConstancia.equals("1")){
					checkConstancia = Boolean.TRUE;   
				}     
		 
				if (dto.getObtencionPuntos().getOidObtencionPuntos() != null)
					oidObtencion = dto.getObtencionPuntos().getOidObtencionPuntos().toString();
				
				// sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
				if(dto.getObtencionPuntos().getNumPeriodosSinPedido()!=null) {
					txtNumPeriodosSinPedido = UtilidadesBelcorp.formateaNumeroSICC(dto.getObtencionPuntos().getNumPeriodosSinPedido().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					txtNumPeriodosSinPedido = "";
				}
				traza("********** txtNumPeriodosSinPedido " + txtNumPeriodosSinPedido);
				
			}
		}			
		else {
            //--no habia informacion - inserccion
            oidObtencion = null;
            txtMen = Boolean.TRUE;
            checkAcumulativo =Boolean.TRUE;
            checkActividad = Boolean.TRUE;        
		}
		// Modificado por ssantana, 19/05/2005 
		// Se cambia lo que se envía a las variables ocultas de la pantalla.       
		if (txtFactorConversion!=null) 
          asignarAtributo("VAR", "factorConversion", "valor", txtFactorConversion);   

		if (txtPuntosAsignar !=null)
			asignarAtributo("VAR", "puntosAsig", "valor", txtPuntosAsignar);
  
		if (checkComunicacion !=null){
			if (checkComunicacion.booleanValue())
				asignarAtributo("VAR", "indComunic", "valor", "S");
			else
				asignarAtributo("VAR", "indComunic", "valor", "N");
		}
   
		if (txtMensaje !=null){
			asignarAtributo("VAR", "valorMensaje", "valor", txtMensaje.toString());
		}
   
		if(txtMen !=null)
			asignarAtributo("VAR", "txtMensaj", "valor", txtMen.toString());
	
		if(checkAcumulativo !=null){
			if (checkAcumulativo.booleanValue())
				asignarAtributo("VAR", "indPuntajeAcu", "valor", "S");
		  else
      			asignarAtributo("VAR", "indPuntajeAcu", "valor", "N");
		}	
  
		if(checkActividad !=null){
			if (checkActividad.booleanValue())
				asignarAtributo("VAR", "indActividad", "valor", "S");
			else
			    asignarAtributo("VAR", "indActividad", "valor", "N");
		}	
  
		if(checkConstancia !=null){
			//asignarAtributo("VAR", "indConstancia", "valor", checkConstancia.toString());
			if (checkConstancia.booleanValue())
				asignarAtributo("VAR", "indConstancia", "valor", "S");
			else
				asignarAtributo("VAR", "indConstancia", "valor", "N");
		}
   
		if(oidObtencion !=null)
			asignarAtributo("VAR", "oidObtencion", "valor", oidObtencion);
		
		// sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
		if (txtNumPeriodosSinPedido !=null)
			asignarAtributo("VAR", "numPeriodosSinPedido", "valor", txtNumPeriodosSinPedido);
  
	    //  opcionMenu = "Consultar Obtencion";
		//--Se asigna a la pag. opcionMenu y accion
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
 
		//--Incidencia --
		//if (opcionMenu.equals("Consultar Obtencion")){
		if (opcionMenu.equals("Consultar Concurso")){
			//-- Se deben deshabilitar todos los campos
			campos = Boolean.TRUE;      
			asignarAtributo("VAR", "campos", "valor", campos.toString());
		}   
	} 
 
	public void almacenar() throws Exception {  
		traza("*************** Entre a almacenar");

		factorConversion = conectorParametroNumero("factorConversion",this.FORMATO_DEFAULT);
		puntosAsig = conectorParametroNumero("puntosAsig",this.FORMATO_DEFAULT);
		indComunic = conectorParametroLimpia("indComunic", "", true); 
		txtMensaj = conectorParametroLimpia("txtMensaj", "", true); 		
		indPuntajeAcu = conectorParametroLimpia("indPuntajeAcu", "", true); 		
		indActividad = conectorParametroLimpia("indActividad", "", true);		
		indConstancia = conectorParametroLimpia("indConstancia", "", true);		
		oidObtencion = conectorParametroLimpia("oidObtencion", "", true);

		traza("*************** factorConversion: " + factorConversion);
		traza("*************** puntosAsig: " + puntosAsig);    
		traza("*************** indComunic: " + indComunic);
		traza("*************** txtMensaj: " + txtMensaj);    
		traza("*************** indPuntajeAcu: " + indPuntajeAcu);
		traza("*************** indActividad: " + indActividad);
		traza("*************** indConstancia: " + indConstancia);
		traza("*************** oidObtencion: " + oidObtencion);
		traza("*************** datosObligatorios: " + datosObligatorios);
		 
		// sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
		numPeriodosSinPedido = conectorParametroNumero("numPeriodosSinPedido",this.FORMATO_DEFAULT);
		traza("*************** numPeriodosSinPedido: " + numPeriodosSinPedido);
		
		DTOConcurso dto = this.getConcurso();
		dto.setIndObtencionPuntos(new Boolean(true));
		dto.setIndObligObtencionPuntos(new Boolean(datosObligatorios));

		//1° Creo el DTOObtencionPuntos
		DTOObtencionPuntos dtoObtencionPuntos = new DTOObtencionPuntos();

		//2° Seteo Factor conversion (requiere formato)
		if(factorConversion.equals("")) dtoObtencionPuntos.setFactorConversion(null);
		else dtoObtencionPuntos.setFactorConversion(new BigDecimal(factorConversion));
		
		//3° Seteo Puntos a asignar (requiere formato)
		if(puntosAsig.equals("")) dtoObtencionPuntos.setPuntosAsignar(null);
		else dtoObtencionPuntos.setPuntosAsignar(new Integer(puntosAsig));
		
		//4° Seteo Indicador de comunicacion
		if(indComunic.equals("S")) dtoObtencionPuntos.setIndComunicacion(new Integer(1));
		else dtoObtencionPuntos.setIndComunicacion(new Integer(0));
		
		//5° Seteo Mensaje		
		dtoObtencionPuntos.setMensaje(txtMensaj);
		
		//6° Seteo Puntaje acumulativo
		if(indPuntajeAcu.equals("S")) dtoObtencionPuntos.setIndPuntajeAcumulativo(new Integer(1));
		else dtoObtencionPuntos.setIndPuntajeAcumulativo(new Integer(0));
		
		//7° Seteo Actividad
		if(indActividad.equals("S")) dtoObtencionPuntos.setIndActividad(new Integer(1));
		else dtoObtencionPuntos.setIndActividad(new Integer(0));
		
		//8° Seteo Constancia
		if(indConstancia.equals("S")) dtoObtencionPuntos.setIndConstancia(new Integer(1));
		else dtoObtencionPuntos.setIndConstancia(new Integer(0));
		
		//9° Seteo oid
		if(oidObtencion.equals("")) dtoObtencionPuntos.setOidObtencionPuntos(null);
		else dtoObtencionPuntos.setOidObtencionPuntos(new Long(oidObtencion));

		// sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
		if(numPeriodosSinPedido.equals("")) dtoObtencionPuntos.setNumPeriodosSinPedido(null);
		else dtoObtencionPuntos.setNumPeriodosSinPedido(new Integer(numPeriodosSinPedido));
		
		//10° Seteo oid de pais de sesion
		dtoObtencionPuntos.setOidPais(lPais);
		
		//11° Seteo el DTOObtencionPuntos en el DTOConcurso
		dto.setObtencionPuntos(dtoObtencionPuntos);

		//12° Pongo el DTOConcurso en sesion
		this.setConcurso(dto);    
	 } 
}
