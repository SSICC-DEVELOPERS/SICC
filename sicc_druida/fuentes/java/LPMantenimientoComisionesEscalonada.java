import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesCobranza;
import es.indra.sicc.dtos.com.DTOComisionesEscalonada;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoComisionesEscalonada extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String idPestanyaDest;

	//Guardan los tramos de comisiones creados en la ventana modal.
	//String con el formato: xx,xx,xx,xx|xx,xx,xx,xx|xx,xx,xx,xx|...
	private String sTramosComisionesCapital;
	private String hDiasTrasFacturacionCapital;

	private String sTipoComision;

	public LPMantenimientoComisionesEscalonada() { super(); }

	public void inicio() throws Exception {	
		this.pagina("contenido_comisiones_escalonada_insertar");
	}  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
  		traza("************ Entre a LPMantenimientoComisionesEscalonada");

		accion = conectorParametroLimpia("accion", "", true);    
	    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		titulo = conectorParametroLimpia("titulo", "", true);
		oidTipoPlantilla = conectorParametroLimpia("oidTipoPlantilla", "", true);
		estadoVentana = conectorParametroLimpia("estadoVentana", "", true);

		traza("************ accion:" + accion);
		traza("************ opcionMenu:" + opcionMenu);
		traza("************ titulo:" + titulo);
		traza("************ oidTipoPlantilla:" + oidTipoPlantilla);
		traza("************ estadoVentana:" + estadoVentana);

		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);

		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);

		//Recuperar los tramos de comisiones
		sTramosComisionesCapital = conectorParametroLimpia("hTramosComisionesCapital", "", true);
		traza("sTramosComisionesCapital: " + sTramosComisionesCapital);

	    hDiasTrasFacturacionCapital = conectorParametroLimpia("hDiasTrasFacturacionCapital", "", true);
		traza("hDiasTrasFacturacionCapital: " + hDiasTrasFacturacionCapital);

		//asignar constantes a pagina
		String sTipoParticipanteCapital = ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL.toString();
		traza("sTipoParticipanteCapital: " + sTipoParticipanteCapital);
		asignarAtributo("VAR", "TIPO_PARTICIPANTE_CAPITAL", "valor", sTipoParticipanteCapital);

		try {			  
			if(accion.equals(""))  {
				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();

			    asignarAtributo("VAR", "titulo", "valor", titulo);
				asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
				asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);

				idPestanya = ConstantesCOMPestanyas.PESTANYA_ESCALONADA;
				cargarPantalla();
			}
			else if(accion.equals("almacenar")) {
				if(!opcionMenu.equals("consultar")) {
					almacenar();
				}

				idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
		        redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {           
				almacenar();
				try {
					this.guardar();          
					if(opcionMenu.equals("insertar")) {
						this.setComision(null);          
						this.conectorAction("LPInsertarComisiones");
					}
					else{
					  asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
					}
				}
				catch(Exception e) {
				  asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
				  throw e;
				}
			}
			
			cargarMenuSecundario();
		}
		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		}
	}

	public void cargarPantalla() throws Exception {
		traza("-- Entro a cargar pantalla --");
		
	    DTOComisiones dtoCom = this.getComision();
		traza("opcionMenu: " + opcionMenu);

		if(this.opcionMenu != null){
			if(this.opcionMenu.equalsIgnoreCase("modificar") || this.opcionMenu.equalsIgnoreCase("consultar") || 
			this.opcionMenu.equalsIgnoreCase("insertar")  ){          
				
				DTOComisiones dtoc = this.getComision();
				traza("************ Llamando a verificarDatosComision");
				verificarDatosComision();

		        if(dtoc == null){
					return;
				}

		        traza("DTOComisiones de sesion: " + dtoc);

				/////////////////////////////////
				//Mapear los datos de la pantalla
				/////////////////////////////////
				cargarMarcoCobranza(dtoc);
        
				if(this.opcionMenu.equals("modificar")){
					dtoc = this.getComision();
          
					if(dtoc != null && dtoc.getOidEstado() != null &&  
						dtoc.getOidEstado().equals(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA)){
						this.asignarAtributo("VAR", "hHabilitarEstadoSolicitudAutorizada", "valor", "S");
					}
					else{
						this.asignarAtributo("VAR", "hHabilitarEstadoSolicitudAutorizada", "valor", "N");
					}
          
				}
				else if(this.opcionMenu.equals("consultar")){
					//se deshabilita el boton calcularMetas y todos los campos
					this.asignarAtributo("VAR", "hDeshabilitarTodo", "valor", "S");
					this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
          
				}
			}
		}
	}

	private void cargarMarcoCobranza(DTOComisiones dtoc) throws Exception {
		traza("cargarMarcoCobranza");
		ArrayList alComisionesCobranzas = dtoc.getComisionesCobranza();
		Iterator i = null;
		DTOComisionesCobranza dtoCCAux = null;
		DTOComisionesCobranza dtoCCCapital = null;
			
		if(alComisionesCobranzas != null && !alComisionesCobranzas.isEmpty()){    
			traza("entra a alComisionesCobranzas");    
		    i = alComisionesCobranzas.iterator();
      
		    while(i.hasNext()){
				dtoCCAux = (DTOComisionesCobranza)i.next();
        
		        if(dtoCCAux != null){
					traza(dtoCCAux);
        
			        if(dtoCCAux.getOidTipoParticipante() != null && dtoCCAux.getOidTipoParticipante().equals(
					    ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL)){ //CAPITAL
						dtoCCCapital = dtoCCAux;
						if(dtoCCCapital.getDiasTrasFacturacion()!=null) {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionCapital", "valor", dtoCCCapital.getDiasTrasFacturacion().toString());
						}
						else {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionCapital", "valor", "");
						}
					}
				}
	      }//while
		}
    
		traza("dtoCCCapital: " + dtoCCCapital);

	    ArrayList alComisionesCobranzasEscalonada = null; 
		if( dtoCCCapital != null ){
			alComisionesCobranzasEscalonada = dtoCCCapital.getComisionesEscalonada();
		}
		traza("alComisionesCobranzasEscalonada: " + alComisionesCobranzasEscalonada);
		
		String sComisionesCobranzasEscalonada = obtenerStringCobranzaEscalonada(alComisionesCobranzasEscalonada);

		traza("sComisionesCobranzasEscalonada: " + sComisionesCobranzasEscalonada);
		asignarAtributo("VAR", "hTramosComisionesCapital", "valor", sComisionesCobranzasEscalonada);
	}

	private String obtenerStringCobranzaEscalonada(ArrayList al) throws Exception{
		DTOComisionesEscalonada dtoCCTP = null;
	    Iterator it = null;
    
		if(al != null && al.size() > 0){
	        it = al.iterator();
		    StringBuffer sbComisionesEscalonada = new StringBuffer();
      
		    while(it.hasNext()){
			    dtoCCTP = (DTOComisionesEscalonada)it.next();
        
				if(dtoCCTP != null){          
					String oid = dtoCCTP.getOid() != null ? dtoCCTP.getOid().toString() : "";
					String nivel = dtoCCTP.getNivel() != null ? dtoCCTP.getNivel().toString() : "";
					String numDiasComision = dtoCCTP.getDiasComision() != null ? dtoCCTP.getDiasComision().toString() : "";
					String numDiasRecuperacion = dtoCCTP.getDiasRecuperacion() != null ? dtoCCTP.getDiasRecuperacion().toString() : "";
					
					String porcentajeRecuperacionInicial;
					String porcentajeRecuperacionFinal;
					String porcentajeComision;
					String bono;
	
					if(dtoCCTP.getPorcentajeRecuperacionInicial() != null) {
						porcentajeRecuperacionInicial =  UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeRecuperacionInicial().toString(), 
															this.FORMATO_DEFAULT, this);
					}
					else {
						porcentajeRecuperacionInicial = "";
					}
					
					if(dtoCCTP.getPorcentajeRecuperacionFinal() != null) {
						porcentajeRecuperacionFinal =  UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeRecuperacionFinal().toString(), 
															this.FORMATO_DEFAULT, this);
					}
					else {
						porcentajeRecuperacionFinal = "";
					}
					if(dtoCCTP.getPorcentajeComision() != null) {
						porcentajeComision =  UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeComision().toString(), 
															this.FORMATO_DEFAULT, this);
					}
					else {
						porcentajeComision = "";
					}
					
					if(dtoCCTP.getBono() != null) {
						bono = UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getBono().toString(), 
						this.FORMATO_DEFAULT, this);
					}
					else {
						bono = "";
					}		
	
					if(sbComisionesEscalonada.toString().length() > 0){
						sbComisionesEscalonada.append("|");
					}
	
					sbComisionesEscalonada.append(nivel); 
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(nivel);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(numDiasRecuperacion);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(numDiasComision);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(porcentajeRecuperacionInicial);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(porcentajeRecuperacionFinal);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(porcentajeComision);
					sbComisionesEscalonada.append("#");
					sbComisionesEscalonada.append(bono);
				}
		    }
		  
		    return sbComisionesEscalonada.toString();

		} else {
    		return "";
    	}
	}
	
	public void almacenar() throws Exception {
		traza("*********** Entre a almacenar");
		pagina("salidaGenerica");          

	    DTOComisiones dtoc = this.getComision();

		if(dtoc == null){
		  dtoc = new DTOComisiones();
	    }
    
		traza("*** Entro por cobranza");
	    dtoc = this.levantarMarcoCobranza(dtoc);

		//Otros campos
		dtoc.setIndVentaCobranza(ConstantesCOM.COMISION_COBRANZAS);
	    dtoc.setComisionesVentas(null);
		dtoc.setComisionesVentaHistorica(null);
		traza("***** dtoc.getComisionesCobranza() " + dtoc.getComisionesCobranza());

	    traza("*********** Salio de almacenar");
	}

	private DTOComisiones levantarMarcoCobranza(DTOComisiones dtoc) throws Exception {  
		traza("********* Entre a levantarMarcoCobranza");

		DTOComisionesCobranza dtoCCCapital = null;
		ArrayList alDTOCC = dtoc.getComisionesCobranza();
		ArrayList vDtocctpCapital = new ArrayList();

		DTOComisionesEscalonada dtocctp = null;

		traza("***** sTramosComisionesCapital: " + sTramosComisionesCapital);
		traza("***** hDiasTrasFacturacionCapital: " + hDiasTrasFacturacionCapital);

		StringTokenizer strTokenCapital = new StringTokenizer(sTramosComisionesCapital, "|");
		StringTokenizer strTokenTemp = null;
		
		//while para capital
		while(strTokenCapital.hasMoreTokens()){
		  String linea = strTokenCapital.nextToken();
		  traza("***** linea antes de replace: " + linea);
		  linea = UtilidadesBelcorp.replace(linea, ",,", ", ,");
		  traza("***** linea después de replace: " + linea);
		  
		  strTokenTemp = new StringTokenizer(linea, ",");
		  String oid = strTokenTemp.nextToken();
		  String nivel = strTokenTemp.nextToken();
		  String diasRecuperacion = strTokenTemp.nextToken();		  
		  String diasComision = strTokenTemp.nextToken();
		  String porcentajeRecuperacionInicial = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  String porcentajeRecuperacionFinal = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  String porcentajeComision;
		  String bono;

		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeComision = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeComision = "";
		  }

		  if(strTokenTemp.hasMoreTokens()){
			  bono = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  bono = "";
		  }
		  
		  traza("***** CAPITAL");
		  traza("***** nivel: " + nivel);
		  traza("***** diasComision: " + diasComision);
		  traza("***** diasRecuperacion: " +diasRecuperacion);
		  traza("***** porcentajeRecuperacionInicial: " + porcentajeRecuperacionInicial);
		  traza("***** porcentajeRecuperacionFinal: " + porcentajeRecuperacionFinal);
		  traza("***** porcentajeComision: " + porcentajeComision);
		  traza("***** bono: " + bono);

		  dtocctp = new DTOComisionesEscalonada();
		  dtocctp.setOid(null);
		  dtocctp.setOidComisionesCobranzas(null);
		  dtocctp.setNivel(new Integer(nivel));
		  dtocctp.setDiasRecuperacion(new Integer(diasRecuperacion));
		  dtocctp.setDiasComision(new Integer(diasComision));
		  dtocctp.setPorcentajeRecuperacionInicial(new BigDecimal(porcentajeRecuperacionInicial));
		  dtocctp.setPorcentajeRecuperacionFinal(new BigDecimal(porcentajeRecuperacionFinal));
		  dtocctp.setPorcentajeComision(porcentajeComision.equals("")?null:new BigDecimal(porcentajeComision));
		  dtocctp.setBono(bono.equals("")?null:new BigDecimal(bono));
		  
		  vDtocctpCapital.add(dtocctp);
		}

	  
		if(vDtocctpCapital != null && vDtocctpCapital.size() > 0){
		  dtoCCCapital = new DTOComisionesCobranza();
		  if(!hDiasTrasFacturacionCapital.equals("")) {
	 		  dtoCCCapital.setDiasTrasFacturacion(new Integer(hDiasTrasFacturacionCapital));
		  }
		  dtoCCCapital.setOidTipoParticipante(ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL);
		  dtoCCCapital.setComisionesEscalonada(vDtocctpCapital);
		}
	  
	  
		ArrayList alDTOC = new ArrayList();
		
		if(dtoCCCapital != null){
		  alDTOC.add(dtoCCCapital);
		  traza("***** agrego dtoCCCapital");
		}

		dtoc.setComisionesCobranza(alDTOC);
	  
		return dtoc;
	}

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);
	  	traza("************ opcionMenu " + opcionMenu);
	  	traza("************ titulo " + titulo);

		if( opcionMenu != null && opcionMenu.equalsIgnoreCase("insertar") ){
			getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","insertar");
		}
		else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("modificar")){
			getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","modificar");
			asignarAtributoPagina("cod","0520");
		}
		else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("consultar")){
			getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","consultar");
			if(titulo.equals("EliminarComisiones")) {
				asignarAtributoPagina("cod","0558");         
			}
			else if(titulo.equals("ConsultarComisiones")) {
				asignarAtributoPagina("cod","0510");         
			}
		}
	}
	
}
