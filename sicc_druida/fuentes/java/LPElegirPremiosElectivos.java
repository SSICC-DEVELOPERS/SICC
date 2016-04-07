import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos;
import es.indra.sicc.dtos.inc.DTODetallePremElegidos;
import es.indra.sicc.dtos.inc.DTOBuscarClientesConcurso;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.car.DTOPaginado;

// 18/08/2006 - [1] pperanzola - se modifica por performance

public class LPElegirPremiosElectivos extends LPSICCBase {
	//[1] private String sPais = null;     
	//[1] private String sIdioma = null;
	//[1] private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   
	private String accion = null;

	public LPElegirPremiosElectivos() { super(); }

	public void inicio() throws Exception { }  
    
	
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
	  	traza("LPElegirPremiosElectivos.ejecucion() - Entrada");
		accion = conectorParametroLimpia("accion", "", true);	
		
		// [1] sPais = UtilidadesSession.getPais(this).toString(); se comenta porque no se usa
		// [1] sIdioma = UtilidadesSession.getIdioma(this).toString();
		// [1] sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);

 		traza("/accion:" + accion);

		
		try {			  
			if(accion.length() < 1)  {	
				inicializar();	
			}			
			else if(accion.equals("recuperarDatosCabeceraDetalle")) {        
				recuperarDatosCabeceraDetalle();
			}
			else if(accion.equals("guardarPremiosElegidos")) {        
				guardarPremiosElegidos();
			}

			getConfiguracionMenu("LPElegirPremiosElectivos","");   
		  	traza("LPElegirPremiosElectivos.ejecucion() - Salida");
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
	/*	
		23/08/2006 - [1] - pperanzola : se modifica para performance
	*/
	public void inicializar() throws Exception {
		//traza("LPElegirPremiosElectivos.inicializar() - Entrada");
		pagina("contenido_premios_electivos_elegir");
		getFormatosValidaciones();

		//Inicio de carga de variables ocultas
		asignarAtributo("VAR", "varPais", "valor", lPais.toString());          
		asignarAtributo("VAR", "varIdioma", "valor", lIdioma.toString());          
		asignarAtributo("VAR", "hFormatoDef", "valor", (new Integer(this.FORMATO_DEFAULT)).toString());

		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
		if (separadorDecimales.equals(",")) {
			separadorMiles = ".";
		}		
		
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_NumeroDecimales", UtilidadesSession.getFormatoNumerico(this));
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);

		asignarAtributo("VAR", "hLongCliente", "valor", 
		this.obtenerLongitudCodigoCliente().toString());

		//asignarAtributo("VAR", "hiOidConcursoAnterior", "valor", "");
		//[1] asignarAtributo("VAR", "hiOidConcurso", "valor", "");

		//Fin de carga de variables ocultas

		//Inicio de carga de combo concurso		
		
		
		DTODate dto = new DTODate();
		dto.setOidIdioma(lIdioma);
		dto.setOidPais(lPais);	
		dto.setFecha(new java.util.Date());

		MareBusinessID businessID = new MareBusinessID("INCObtenerConcursoPorCliente");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);			
	
		
		DruidaConector con = conectar("ConectorObtenerClientesPorConcurso", parametros);
		
	
		DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");	
		
		RecordSet rs = dtoSalida.getResultado();
		
		asignar("COMBO", "cbNumeroConcurso", 
		UtilidadesBelcorp.generarConector("DTOSalida", rs, rs.getColumnIdentifiers()));
		

		//Inicio de carga de variable oculta con los datos de cocursos		
		asignarAtributo("VAR", "hiLstConcursos", "valor", 
		transformarRecordSetToString(rs));
		
		//Fin de carga de variable oculta con los datos de cocursos
		
	}

	private String transformarRecordSetToString(RecordSet rs) throws Exception  {
		traza("LPElegirPremiosElectivos.transformarRecordSetToString() - Entrada");
		String cadena = "";
		
		for(int i=0; i<rs.getRowCount() ;i++){
 			String oidTemp = rs.getValueAt(i,"OID").toString();
			String numTemp = rs.getValueAt(i,"NUMEROCONCURSO").toString();
			String verTemp = rs.getValueAt(i,"VERSION").toString();
			String nomTemp = rs.getValueAt(i,"NOMBRECONCURSO").toString();
			
			if(i==0) {
				cadena = cadena + oidTemp + "," + numTemp + "," + 
				verTemp + "," + nomTemp;
			}
			else {				
				cadena = cadena + "|" + oidTemp + "," + numTemp + "," + 
				verTemp + "," + nomTemp;
			}					
		}
		
		//traza("*************** cadena " + cadena);
		traza("LPElegirPremiosElectivos.transformarRecordSetToString() - Salida");
		return cadena;
	}

	//Metodo modificado por Cristian Valenzuela - 17/2/2006
	//Incidencia 22634
	private void recuperarDatosCabeceraDetalle() throws Exception {
		traza("LPElegirPremiosElectivos.recuperarDatosCabeceraDetalle() - Entrada");
		pagina("salidaGenerica");

		RecordSet resultado = null;

		String hiCodCliente = conectorParametroLimpia("hiCodCliente", "", true);
		String hiOidConcurso = conectorParametroLimpia("hiOidConcurso", "", true);
		String hiNumConcurso = conectorParametroLimpia("hiNumConcurso", "", true);
		String hiVersionConcurso = conectorParametroLimpia("hiVersionConcurso", "", true);		
		String hiOidCliente = conectorParametroLimpia("hiOidCliente", "", true);				

		//traza("************************** hiCodCliente " + hiCodCliente);
		//traza("************************** hiOidConcurso " + hiOidConcurso);
		//traza("************************** hiNumConcurso " + hiNumConcurso);
		//traza("************************** hiVersionConcurso " + hiVersionConcurso);		
		//traza("************************** hiOidCliente " + hiOidCliente);				

		if(!hiCodCliente.equals("")) {
			if(!hiNumConcurso.equals("")) {							
				DTOBuscarClientesConcurso dto = new DTOBuscarClientesConcurso();			
				dto.setOidPais(lPais);
				dto.setOidIdioma(lIdioma);
				dto.setOidConcurso(new Long(hiOidConcurso));
				dto.setNumeroConcurso(hiNumConcurso);

				if(hiVersionConcurso.length() > 0) {
					dto.setVersionConcurso(new Integer(hiVersionConcurso));
				}				
	
				if(hiOidCliente.length() > 0) {					
					dto.setOidCliente(new Long(hiOidCliente));
				}	

				dto.setCodCliente(hiCodCliente);
				MareBusinessID businessID = new MareBusinessID("INCObtenerClientesPorConcurso");
				Vector parametros = new Vector();
				parametros.add(dto);
				parametros.add(businessID);			
	
				try {
					//traza("******************* Antes de conectar");
					DruidaConector con = conectar("ConectorObtenerClientesPorConcurso", parametros);
					//traza("******************* Despues de conectar");

					DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");	
					//traza("************** dtoSalida " + dtoSalida);		
				
					if(dtoSalida.getResultado().getRowCount()<1) {
						asignarAtributo("VAR", "ejecutar", "valor", "errorAceptar()");  
					}
					else {
						resultado = dtoSalida.getResultado();
					}
				}
				catch(Exception e) {
					asignarAtributo("VAR", "ejecutarError", "valor", "clienteInexistente()");  
					throw e;
				}   				
			}
		}

		if(resultado!=null) {
			BigDecimal bdSaldoCliente = (BigDecimal)resultado.getValueAt(0, "SALDO_CLIENTE");
			BigDecimal bdSaldoEnCurso = (BigDecimal)resultado.getValueAt(0, "SALDO_CLIENTE");
			BigDecimal bdOidCliente = (BigDecimal)resultado.getValueAt(0, "OID");

			hiOidCliente = bdOidCliente.toString();

			String hiSaldoCliente = "";
			/*[1]  se comenta porque no se usa
			String hiSaldoEnCurso = "";
			if(bdSaldoEnCurso!=null) {
				hiSaldoEnCurso = bdSaldoEnCurso.toString();
			}
						
			*/
			if(bdSaldoCliente!=null) {
				hiSaldoCliente = bdSaldoCliente.toString();
			}
			

			//traza("********* hiOidConcurso " + hiOidConcurso);
			//traza("********* hiOidCliente " + hiOidCliente);
			//traza("********* hiSaldoCliente " + hiSaldoCliente);

			DTOCabeceraPremElegidos dtoCab = new DTOCabeceraPremElegidos();

			dtoCab.setOidPais(lPais);
			dtoCab.setOidIdioma(lIdioma);

			if(hiOidConcurso.length() > 0) dtoCab.setOidConcurso(new Long(hiOidConcurso));
			if(hiOidCliente.length() > 0) dtoCab.setOidCliente(new Long(hiOidCliente));
			if(hiSaldoCliente.length() > 0) dtoCab.setSaldoCliente(new Double(hiSaldoCliente));

			MareBusinessID businessID = new MareBusinessID("INCBusquedaCabeceraPremElectivos");

			Vector parametros = new Vector();
			parametros.add(dtoCab);
			parametros.add(businessID);
			
			try {
				//traza("******************* Antes de conectar");
				DruidaConector con = conectar("ConectorBusquedaCabeceraPremElectivos", parametros);
				//traza("******************* Despues de conectar");

				DTOCabeceraPremElegidos dtoCatRet = (DTOCabeceraPremElegidos)con.objeto("DTOSalida");	
				//traza("*** dtoCatRet " + dtoCatRet);

				String saldoCliente;
				String saldoCurso;
				
				if(dtoCatRet.getSaldoCliente()!=null) {
					saldoCliente = UtilidadesBelcorp.formateaNumeroSICC(dtoCatRet.getSaldoCliente().toString(), 
						this.FORMATO_DEFAULT, this);
					
					saldoCurso = saldoCliente; /* [1] saldoCurso = UtilidadesBelcorp.formateaNumeroSICC(dtoCatRet.getSaldoCliente().toString(), 
						this.FORMATO_DEFAULT, this);
					*/
				}
				else { 
					saldoCliente = "";
					saldoCurso = "";
				}

				//traza("*** saldoCliente " + saldoCliente);
				//traza("*** saldoCurso " + saldoCurso);

				RecordSet rs = dtoCatRet.getRsDetallePremiosElectivos();
				String datosLista = new String();

				for(int i=0; i<rs.getRowCount(); i++) {
					StringBuffer strFila = new StringBuffer();

					BigDecimal oid  = (BigDecimal)rs.getValueAt(i, 0);
					BigDecimal numeronivel  = (BigDecimal)rs.getValueAt(i, 1);
					BigDecimal numeropremio  = (BigDecimal)rs.getValueAt(i, 2);
					String tipopremio  = (String)rs.getValueAt(i, 3);
					BigDecimal costepuntos  = (BigDecimal)rs.getValueAt(i, 4);	
					BigDecimal oidNivel  = (BigDecimal)rs.getValueAt(i, 13);				
				
					if(oid!=null){
						strFila.append(oid.toString());
					} else {
						strFila.append(" ");
					}

					strFila.append("$");

					if(numeronivel!=null){
						strFila.append(numeronivel.toString());
					} else {
						strFila.append(" ");
					}
					
					strFila.append("$");

					if(numeropremio!=null){
						strFila.append(numeropremio.toString());
					} else {
						strFila.append(" ");
					}
					
					strFila.append("$");

					if(tipopremio!=null){
						strFila.append(tipopremio);
					} else {
						strFila.append(" ");
					}
					
					strFila.append("$");

					if(costepuntos!=null){
						strFila.append(costepuntos.toString());
					} else {
						strFila.append(" ");
					}
					
					strFila.append("$");

					if(oidNivel!=null) {
						strFila.append(oidNivel.toString());
					} else {
						strFila.append(" ");
					}

					if(i==0) {
						datosLista = datosLista + strFila.toString();
					} else {
						datosLista = datosLista + "|" + strFila.toString();
					}
				}

				//traza("********* datosLista " + datosLista);
				//traza("LPElegirPremiosElectivos.recuperarDatosCabeceraDetalle() - Salida");
				asignarAtributo("VAR","ejecutar","valor","recuperarOK('" + saldoCliente +
																   "','" + saldoCurso +
																   "','" + datosLista + 
																   "','" + hiOidCliente + "')");
			}	
			catch(Exception e) {
				traza("LPElegirPremiosElectivos.recuperarDatosCabeceraDetalle() - Salida");
				asignarAtributo("VAR", "ejecutarError", "valor", "recuperarERR()");  
				throw e;
			}  
		}
	}

	private void guardarPremiosElegidos() throws Exception {		
		traza("LPElegirPremiosElectivos.guardarPremiosElegidos() - Entrada");
		pagina("salidaGenerica");

		String hiOidCliente = conectorParametroLimpia("hiOidCliente", "", true);    
		 String hiOidConcurso = conectorParametroLimpia("hiOidConcurso", "", true);

		//traza("********* hiOidCliente " + hiOidCliente);
		//traza("********* hiOidConcurso " + hiOidConcurso);
		
		DTOCabeceraPremElegidos dtoCab = new DTOCabeceraPremElegidos();
		dtoCab.setOidCliente( new Long(hiOidCliente));
		dtoCab.setOidConcurso( new Long(hiOidConcurso));

		String datosDeLista = conectorParametroLimpia("datosDeLista", "", true);		
		//traza("************* datosDeLista " + datosDeLista);

		ArrayList arrElegidos = new ArrayList();

		int inicio = 1;
		int fin = datosDeLista.length()-1;
			
		datosDeLista = datosDeLista.substring(inicio, fin);
		//traza("** DESPUES ** datosDeLista " + datosDeLista);

		StringTokenizer stFilas = new StringTokenizer(datosDeLista,"|");
		  
		while(stFilas.hasMoreTokens()) {
			String elemento = stFilas.nextToken();
			StringTokenizer stCampos = new StringTokenizer(elemento,",");

			DTODetallePremElegidos dtoDetalle = new DTODetallePremElegidos();		
			
			int i=0;

		    while(stCampos.hasMoreTokens()) {
				String valor = stCampos.nextToken();
				//traza("******* valor " + valor);
				//traza("******* i " + i);
				if(!valor.equals(" ")) {
					if(i==0) {
						dtoDetalle.setOidNivelPremiacion(new Long(valor));
					}else if(i==1) {
						dtoDetalle.setNumeroPremio(new Integer(valor));
					}
				}

				//traza("************ dtoDetalle: " + dtoDetalle);			
				i++;
			}
			arrElegidos.add(dtoDetalle);
		}

		dtoCab.setPremiosElegidos(arrElegidos);

		MareBusinessID businessID = new MareBusinessID("INCGuardarPremiosElegidos");
		Vector parametros = new Vector();
		parametros.add(dtoCab);
		parametros.add(businessID);
		
		try {      
			//traza("******************* Antes de conectar");			
			DruidaConector con = conectar("ConectorGuardarPremiosElegidos", parametros);
			//traza("******************* Despues de conectar");
			//traza("LPElegirPremiosElectivos.guardarPremiosElegidos() - Salida");
			asignarAtributo("VAR","ejecutar","valor","graboOK();");
		}
		catch(Exception e) {
			//traza("LPElegirPremiosElectivos.guardarPremiosElegidos() - Salida");
			asignarAtributo("VAR", "ejecutarError", "valor", "graboERR()");          
			throw e;
		}		
	}	
}