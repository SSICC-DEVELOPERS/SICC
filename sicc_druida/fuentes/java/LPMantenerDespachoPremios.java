
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
 * Componente:        LPMantenerDespachoPremios
 * Fecha:             14/06/2005
 * Observaciones:     
 * @version           1.00 06 may 2005
 * @author            Sergio Saavedra
 * ult. modif.:       
 */
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTODespachoPremios;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;

public class  LPMantenerDespachoPremios extends LPIncentivos {

	private String oidDespachoPremios = null;
	private String pais = null;
    private String idioma = null;
    private String datosObligatorios = null;

    public LPMantenerDespachoPremios() { super(); }

	public void inicio() throws Exception {       

		pagina("contenido_despacho_premios_mantener");    
		this.obtenerFlagsPestanyas();          
		this.getFormatosValidaciones();
	}
  
	public void ejecucion() throws Exception {  

		setTrazaFichero();
		traza("********* Entre a LPMantenerDespachoPremios");
		
		accion = conectorParametroLimpia("accion", "", true);
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		datosObligatorios = conectorParametroLimpia("datosObligatorios", "", true);

		traza("********* accion " + accion);
		traza("********* opcionMenu " + opcionMenu);
		traza("********* datosObligatorios " + datosObligatorios);

		pais = UtilidadesSession.getPais(this).toString();
		idioma = UtilidadesSession.getIdioma(this).toString();    

		try {          
		  getConfiguracionMenu("LPMantenerDespachoPremios" , "");		  

		  if (accion.equals("")) { 
			  this.cargarPantalla();
		  }
		  else if (accion.equals("almacenar")) {
			  almacenar(); 
			  redirigir();
		  }
		  else if (accion.equals("guardar")){           
			  almacenar(); 
			  guardar();            
		  }
		  else if (accion.equals("redirigir")){
			  redirigir();              
		  }
				

		  if(opcionMenu.equals("Crear concurso")){
			  asignarAtributoPagina("cod", "0491");             
		  }else if(opcionMenu.equals("Consultar Concurso")){
			  asignarAtributoPagina("cod", "0493");
		  }else if(opcionMenu.equals("Modificar Concurso")){
			  asignarAtributoPagina("cod", "0486");
		  }
		
		  
		}
		catch ( Exception e )  {
			traza("Exception en LPMantenerDespachoPremios: " + e);
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}

	private void setearVariablesDePantalla() throws Exception {

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	}

	public void  cargarPantalla() throws Exception {

		traza("************* Entro a dentro cargarPantalla");
		this.cargarFlagsPestanyas();

		DTOConcurso dto = new DTOConcurso();
		dto = this.getConcurso();

		if (dto.getIndDespachoPremios().booleanValue()){
			if(dto.getDespachoPremios().getOidDespachoPremios()!=null) {
				asignarAtributo("VAR", "oidDespachoPremios", "valor", dto.getDespachoPremios().getOidDespachoPremios().toString());
			}else {
				asignarAtributo("VAR", "oidDespachoPremios", "valor", "");
			}
				
			//1° Seteo checkbox proceso automatico
			if (dto.getDespachoPremios().getIndComunicacionProcesoAutomatico().booleanValue()){
				asignarAtributo("VAR", "hckComunicacionProcesoAutomatico", "valor", "S");
			} else {
				asignarAtributo("VAR", "hckComunicacionProcesoAutomatico", "valor", "N");
			} 
				//2° Seteo checkbox proceso manual
			if (dto.getDespachoPremios().getIndComunicacionProcesoManual().booleanValue()){ 
				asignarAtributo("VAR", "hckComunicacionProcesoManual", "valor", "S");
			} else {
				asignarAtributo("VAR", "hckComunicacionProcesoManual", "valor", "N"); 
			} 
				//3° Seteo mensaje automatico
			if (dto.getDespachoPremios().getMensajeDespachoAutomatico()!=null){ 
				asignarAtributo("VAR", "htxtMensajesProcesoAutomatico", "valor",dto.getDespachoPremios().getMensajeDespachoAutomatico());
			} else {
				asignarAtributo("VAR", "htxtMensajesProcesoAutomatico", "valor", "");
			}
				//4° Seteo mensaje manual
			if (dto.getDespachoPremios().getMensajeDespachoManual()!=null){ 
				asignarAtributo("VAR", "htxtMensajesProcesoManual", "valor",dto.getDespachoPremios().getMensajeDespachoManual());
			} else {
				asignarAtributo("VAR", "htxtMensajesProcesoManual", "valor", "");
			}

		}else{
			asignarAtributo("VAR", "oidDespachoPremios", "valor", "");
			asignarAtributo("VAR", "hckComunicacionProcesoAutomatico", "valor", "N");
			asignarAtributo("VAR", "hckComunicacionProcesoManual", "valor", "N");
			asignarAtributo("VAR", "htxtMensajesProcesoAutomatico", "valor", "");
			asignarAtributo("VAR", "htxtMensajesProcesoManual", "valor", "");
		}

		setearVariablesDePantalla();

	}

	public void almacenar() throws Exception {

		traza("************ Entro a almacenar");
		DTOConcurso dto = new DTOConcurso();
		dto = this.getConcurso();

		dto.setIndObligDespachoPremios(new Boolean(datosObligatorios));

		String auxMPA = conectorParametroLimpia("htxtMensajesProcesoAutomatico", "", true);
		String auxMPM = conectorParametroLimpia("htxtMensajesProcesoManual", "", true);
		oidDespachoPremios = conectorParametroLimpia("oidDespachoPremios", "", true);

		traza("************ auxMPA " + auxMPA);
		traza("************ auxMPM " + auxMPM);
		traza("************ oidDespachoPremios " + oidDespachoPremios);
			
		if (dto.getDespachoPremios() == null) { 
			dto.setDespachoPremios( new DTODespachoPremios() );
		}
		
		Long oidIdioma = UtilidadesSession.getIdioma(this);
		Long oidPais = UtilidadesSession.getPais(this);    
		dto.getDespachoPremios().setOidIdioma(oidIdioma);
		dto.getDespachoPremios().setOidPais(oidPais);    
		  
		if (!oidDespachoPremios.equals("")) {
			dto.getDespachoPremios().setOidDespachoPremios(new Long(oidDespachoPremios));
		} else {
			dto.getDespachoPremios().setOidDespachoPremios(null); 
		}

		String auxCPA = conectorParametroLimpia("hckComunicacionProcesoAutomatico", " ", true);
		String auxCPM = conectorParametroLimpia("hckComunicacionProcesoManual", " ", true);
		traza("************ auxCPA " + auxCPA);
		traza("************ auxCPM " + auxCPM);

		if (auxCPA.equals("S")) {
			dto.getDespachoPremios().setIndComunicacionProcesoAutomatico(new Boolean(true));   
		} else {
			dto.getDespachoPremios().setIndComunicacionProcesoAutomatico(new Boolean(false));   
		}

		if (auxCPM.equals("S")) {
			dto.getDespachoPremios().setIndComunicacionProcesoManual(new Boolean(true));      
		} else {
			dto.getDespachoPremios().setIndComunicacionProcesoManual(new Boolean(false));   
		}	
		dto.getDespachoPremios().setMensajeDespachoAutomatico(auxMPA);
		dto.getDespachoPremios().setMensajeDespachoManual(auxMPM);

		dto.setIndDespachoPremios(new Boolean(true));
		this.setConcurso(dto);

	}

}