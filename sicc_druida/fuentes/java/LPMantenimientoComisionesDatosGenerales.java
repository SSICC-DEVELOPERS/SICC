import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesAccesos;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoComisionesDatosGenerales extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String idPestanyaDest;
  
	private String oidPlantilla = null;     
	private String indComparativo = null;     
	private String indTratamientoDif = null;     
	private String oidCanal = null;       //oid del canal
	private String canal = null;          //descripcion del canal
	private String marca = null;  
	private String acceso = null;
	private String periodoDesde = null;
	private String periodoHasta = null;
	private String periodosEspera = null;

	// vbongiov -- Cambio 20090913 -- 5/08/2009
	private String consideraSabDomFer = null;
	private String dsctoImpstoVtaPagos = null;

	private String comisionEscalonada;
	
	private String descMarca = null;
	private String descCanal = null;

	private String oidComision = null;

	private String sDescripcionComision = null;
	private String sOidMarca = null;
	private String sOidAccesos = null;
	private String sOidPeriodoDesde = null;
	private String sOidPeriodoHasta = null;
	private String sNumeroPeriodosEspera = null;

	public LPMantenimientoComisionesDatosGenerales() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
  		traza("************ Entre a LPMantenimientoComisionesDatosGenerales");

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
	  
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);

 		traza("************ sPais :" + sPais );
 		traza("************ sIdioma:" + sIdioma);
 		traza("************ sDescPais:" + sDescPais);
 		traza("************ lIdioma:" + lIdioma);
 		traza("************ lPais:" + lPais);
		
		try {			  
			if(accion.equals(""))  {
				pagina("contenido_comisiones_datosGenerales_insertar");
		        asignarAtributo("VAR", "titulo", "valor", titulo);
		        if (oidTipoPlantilla != null)
		          asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
				 if (estadoVentana != null)
				   asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);

				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();
				idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES;		
        
				oidCanal = conectorParametroLimpia("oidCanal", "", true);
				oidPlantilla = conectorParametroLimpia("oidPlantilla", "", true);
				canal = conectorParametroLimpia("canal", "", true);
				indComparativo = conectorParametroLimpia("varIndComparativo", "", true);
				indTratamientoDif = conectorParametroLimpia("varIndTratamientoDif", "", true);
        
				traza("************ oidPlantilla:" + oidPlantilla);
				traza("************ canal:" + canal);
				traza("************ indComparativo:" + indComparativo);
				traza("************ indTratamientoDif:" + indTratamientoDif);
				traza("************ oidCanal:" + oidCanal);    

				if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) {
					//Si se esta en el caso de uso consultar o modificar
					//se mapea un DTOComisiones a las pestañas
					inicializar();
				}
				else {
					traza("************ Llamando a verificarDatosComision");
					verificarDatosComision();

					//Si se esta en el caso de uso insertar
					//se toman los valores de la primera pantalla de busqueda del insertar
					if((indComparativo.equals("")) && (indTratamientoDif.equals(""))) {
						cargarPantalla(new Long(oidPlantilla), canal, null, null, new Long(oidCanal));                 
					}
					if(!(indComparativo.equals("")) && (indTratamientoDif.equals(""))) {
						cargarPantalla(new Long(oidPlantilla), canal, new Boolean(indComparativo),
						null, new Long(oidCanal));                 
					}
					if((indComparativo.equals("")) && (!indTratamientoDif.equals(""))) {
						cargarPantalla(new Long(oidPlantilla), canal, null,
						new Boolean(indTratamientoDif), new Long(oidCanal));                 
					}
					if((!indComparativo.equals("")) && (!indTratamientoDif.equals(""))) {
						cargarPantalla(new Long(oidPlantilla), canal, new Boolean(indComparativo),
						new Boolean(indTratamientoDif), new Long(oidCanal));                 
					}

			        traza("************ Llamando a anyadeHiddensI18N");
					anyadeHiddensI18N(true, "COM_COMIS", null, new Integer(1), "formulario", "txtDescripcionComision", false);
				}
			}
			else if(accion.equals("cargar")) {     
				traza("Entro por accion cargar");
				pagina("contenido_comisiones_datosGenerales_insertar");
		        if (oidTipoPlantilla != null)
		          asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
		        asignarAtributo("VAR", "titulo", "valor", titulo);
				if (estadoVentana != null)
		          asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);

				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();

		        idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES;
				DTOComisiones dtoComisiones = getComision();
				traza("************* dtoComisiones " + dtoComisiones);

				DTOI18nSICC[] dtosI18ns = dtoComisiones.getAttTraducible();

				//Seteando descripciones internacionalizables
				if(dtosI18ns!=null) {
					Long idiomaSesion = UtilidadesSession.getIdioma(this);
					for(int i=0; i<dtosI18ns.length; i++) {
						DTOI18nSICC i18 = (DTOI18nSICC) dtosI18ns[i];

						Long idiomaDTO = i18.getOidIdioma();
			
						if(idiomaDTO.longValue() == idiomaSesion.longValue()) {
							//Seteando descripcion
							sDescripcionComision = i18.getValorI18n();
						}
					}
					traza("************ sDescripcionComision " + sDescripcionComision);    
					if(sDescripcionComision!=null) {
						asignarAtributo("VAR", "sDescripcionComision", "valor", sDescripcionComision);
					}
				}

				//Seteando oid de marca
				if(dtoComisiones.getOidMarca()!=null) {
					sOidMarca = dtoComisiones.getOidMarca().toString();
					traza("************ sOidMarca " + sOidMarca);   				
					asignarAtributo("VAR", "sOidMarca", "valor", sOidMarca);				
				}				

				//Seteando oids de accesos
				if(dtoComisiones.getComisionesAccesos()!=null) {
					ArrayList oidsAccesos = dtoComisiones.getComisionesAccesos();
					for(int i=0; i<oidsAccesos.size(); i++) {
						DTOComisionesAccesos dtoComisionesAccesos = (DTOComisionesAccesos)oidsAccesos.get(i);
						Long acceso = dtoComisionesAccesos.getOid();

						if(i==0) {
							sOidAccesos = acceso.toString();
						}
						else {
							sOidAccesos = sOidAccesos + "," + acceso.toString();
						}
					}
					traza("************ sOidAccesos " + sOidAccesos);    
					asignarAtributo("VAR", "sOidAccesos", "valor", sOidAccesos);
				}

				//Seteando oid periodo desde
				if(dtoComisiones.getOidPeriodoDesde()!=null) {
					sOidPeriodoDesde = dtoComisiones.getOidPeriodoDesde().toString();
					traza("************ sOidPeriodoDesde " + sOidPeriodoDesde);    
					asignarAtributo("VAR", "sOidPeriodoDesde", "valor", sOidPeriodoDesde);
				}

				//Seteando oid periodo hasta
				if(dtoComisiones.getOidPeriodoHasta()!=null) {
					sOidPeriodoHasta = dtoComisiones.getOidPeriodoHasta().toString();
					traza("************ sOidPeriodoHasta " + sOidPeriodoHasta);    
					asignarAtributo("VAR", "sOidPeriodoHasta", "valor", sOidPeriodoHasta);	  
				}
				
				//Seteando numero periodos espera
				if(dtoComisiones.getPeriodosEspera()!=null) {
					sNumeroPeriodosEspera = dtoComisiones.getPeriodosEspera().toString();
					traza("************ sNumeroPeriodosEspera " + sNumeroPeriodosEspera);    
					asignarAtributo("VAR", "sNumeroPeriodosEspera", "valor", sNumeroPeriodosEspera);	  
				}				

				// vbongiov -- Cambio 20090913 -- 5/08/2009
				asignarAtributo("VAR", "sConsideraSabDomFer", "valor", dtoComisiones.getConsideraSabDomFer().booleanValue()?"S":"N");	  
				asignarAtributo("VAR", "sDsctoImpstoVtaPagos", "valor", dtoComisiones.getDsctoImpstoVtaPagos().booleanValue()?"S":"N");	  

				// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
				asignarAtributo("VAR", "sComisionEscalonada", "valor", 
							dtoComisiones.getComisionEscalonada()!=null && dtoComisiones.getComisionEscalonada().booleanValue()?"S":"N");	  

				Long oidPlantilla = null;
			    String canal = null;
				Boolean indComparativo = null;
				Boolean indTratamientoDif = null;
				Long oidCanal = null;

				if(dtoComisiones.getOidPlantillasComisones()!=null)
					oidPlantilla = dtoComisiones.getOidPlantillasComisones();

				if(dtoComisiones.getDescCanal()!=null)
					canal = dtoComisiones.getDescCanal();

				if(dtoComisiones.getComparativo()!=null)
					indComparativo = dtoComisiones.getComparativo();

				if(dtoComisiones.getTratamientoDiferencial()!=null)
					indTratamientoDif = dtoComisiones.getTratamientoDiferencial();

				if(dtoComisiones.getOidCanal()!=null)
					oidCanal = dtoComisiones.getOidCanal();

				traza("oidPlantilla " + oidPlantilla);
				traza("canal " + canal);
				traza("indComparativo " + indComparativo);
				traza("indTratamientoDif " + indTratamientoDif);
				traza("oidCanal " + oidCanal);

				cargarPantalla(oidPlantilla, canal, indComparativo, indTratamientoDif, oidCanal);
				traza("************ Llamando a anyadeHiddensI18N");
				anyadeHiddensI18N(true, "COM_COMIS", null, new Integer(1), "formulario", "txtDescripcionComision", false); 
 
 				traza("************ Llamando a verificarDatosComision");
				verificarDatosComision();

				/*agregado ciglesias incidencia DBLG700000207 inicio*/
				deshabilitarCampos(dtoComisiones);
				/*agregado ciglesias incidencia DBLG700000207 fin*/

			}
			else if(accion.equals("almacenar")) {           
				if(!opcionMenu.equals("consultar")) {
					almacenar();
				}

				marcaTemp = conectorParametroLimpia("marca", "", true);
				canalTemp = conectorParametroLimpia("canal", "", true);
		        idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);

		        traza("************ marcaTemp " + marcaTemp);
				traza("************ canalTemp " + canalTemp);
				traza("************ idPestanyaDest " + idPestanyaDest);
				redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {
				almacenar();

				try {      
					traza("************ Llamando al guardar");
					this.guardar();

					if(opcionMenu.equals("insertar")) {
						this.setComision(null);
						conectorAction("LPInsertarComisiones");
					}
					else {
					  // 23192 - dmorello, 30/05/2006: Luego de guardar, corresponde cerrar la ventana modal
					  //asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
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
			preservaHiddensI18n(new Integer(1), "COM_COMIS", "formulario", "txtDescripcionComision", false);
			lanzarPaginaError(e);
		} 
	}
  
 public void inicializar() throws Exception {
    traza("************* Entre a inicializar");
	if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) {
		/*
		Si ((opcionMenu == "consultar")||(opcionMenu == "modificar")) entonces 
		Recuperar los datos de la comisión 
		Obtener el oid de comisión de la ventana llamante y crear un DTOOID 
		Crear idBusiness == "COMConsultarComisiones" 
		Asignar conector "ConectorConsultarComisiones" 

		Llamar al método "setComision()" pasando el DTOComisiones recuperado 
		Para el Estado de la comisión "Solicitud Autorizada", únicamente
		aparecerán habilitados para la modificación los siguientes: 
		Pestaña Datos Generales de la Comisión: Período Hasta y Número de períodos de espera 
		Fin Si */

		oidComision = conectorParametroLimpia("oidComision", "", true);
		traza("************ oidComision:" + oidComision);
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(new Long(oidComision));
		dtoOid.setOidIdioma(lIdioma);

		MareBusinessID businessID = new MareBusinessID("COMConsultarComisiones");
		Vector parametros = new Vector();      
      
	    parametros.add(dtoOid);
		parametros.add(businessID);

	    traza("******************* Antes de conectar");
		DruidaConector con = conectar("ConectorConsultarComisiones", parametros);
		traza("******************* Despues de conectar");

		DTOComisiones dtoComisiones = (DTOComisiones)con.objeto("DTOSalida");     
		traza("******************* dtoComisiones " + dtoComisiones);
		traza("******************* Se pone en sesion este DTOComisiones");
		this.setComision(dtoComisiones); 

		traza("************ Llamando a verificarDatosComision");
		verificarDatosComision();

		/* Comentado ciglesias DBLG700000207
		if(dtoComisiones.getOidEstado().equals(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA)) {
			asignarAtributo("VAR", "solicitudAutorizada", "valor", "true");
		}
		*/

		traza("******************* Llamando a cargarPantalla...");

		oidPlantilla = dtoComisiones.getOidPlantillasComisones().toString();

		cargarPantalla(dtoComisiones.getOidPlantillasComisones(),
					   dtoComisiones.getDescCanal(),
					   dtoComisiones.getComparativo(),
					   dtoComisiones.getTratamientoDiferencial(),
			           dtoComisiones.getOidCanal());

		/*agregado ciglesias incidencia DBLG700000207 inicio*/
		deshabilitarCampos(dtoComisiones);
		/*agregado ciglesias incidencia DBLG700000207 fin*/

	} 
 }

 private void deshabilitarCampos(DTOComisiones dtoComisiones) throws Exception {
	if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) {
		if(dtoComisiones.getOidEstado().equals(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA)) {
			asignarAtributo("VAR", "solicitudAutorizada", "valor", "true");
		}
		/*agregado ciglesias incidencia DBLG700000207 inicio*/
		if (opcionMenu.equals("modificar")) {
			
			if (dtoComisiones.getPlantillaDetalle().getComparativo() != null){
				if (!dtoComisiones.getPlantillaDetalle().getComparativo().equals("")){
					asignarAtributo("VAR", "varDeshabilitarComparativo", "valor", "true");
				} else {
					asignarAtributo("VAR", "varDeshabilitarComparativo", "valor", "false");
				}
			}

			if (dtoComisiones.getPlantillaDetalle().getTratamientoDiferencial() != null){
				if (!dtoComisiones.getPlantillaDetalle().getTratamientoDiferencial().equals("")){
					asignarAtributo("VAR", "varDeshabilitarTratDif", "valor", "true");
				} else {
					asignarAtributo("VAR", "varDeshabilitarTratDif", "valor", "false");
				}
			}

			if (dtoComisiones.getOidEstado().equals(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA)) {
				asignarAtributo("VAR", "varDeshabilitarTratDif", "valor", "true");
				asignarAtributo("VAR", "varDeshabilitarComparativo", "valor", "true");
			}

		}
		/*agregado ciglesias incidencia DBLG700000207 fin*/

	}
 }
  
  public void cargarPantalla(Long oidPlantilla, String canal,
  Boolean indComparativo, Boolean indTratamientoDif, Long oidCanal) throws Exception {
      traza("************* Entre a cargarPantalla");
      traza("************* oidPlantilla " + oidPlantilla);
      traza("************* canal " + canal);
      traza("************* indComparativo " + indComparativo);
      traza("************* indTratamientoDif " + indTratamientoDif);
      traza("************* oidCanal " + oidCanal);

      asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);

	  if(canal!=null) {
		asignarAtributo("LABELC", "lbldtCanal", "valor", canal);      
		asignarAtributo("VAR", "descCanal", "valor", canal);
	  }      

      asignarAtributo("VAR", "varOidPlantilla", "valor", oidPlantilla.toString());
	  asignarAtributo("VAR", "varOidCanal", "valor", oidCanal.toString());
      
      if(indComparativo!=null) {
        if(indComparativo.booleanValue()==true) {
          asignarAtributo("VAR", "varIndComparativo", "valor", "true");
        }
        else {
          asignarAtributo("VAR", "varIndComparativo", "valor", "false");
        }
      }
	  else {
		  asignarAtributo("VAR", "varIndComparativo", "valor", "");
	  }
      
      if(indTratamientoDif!=null) {
        if(indTratamientoDif.booleanValue()==true) {
          asignarAtributo("VAR", "varIndTratamientoDif", "valor", "true");
        }
        else {
          asignarAtributo("VAR", "varIndTratamientoDif", "valor", "false");
        }
      }
	  else {
		  asignarAtributo("VAR", "varIndTratamientoDif", "valor", "");
	  }

	  if((opcionMenu.equals("insertar")) || 
		 (opcionMenu.equals("modificar")) || 
		  opcionMenu.equals("consultar")) {

		ComposerViewElementList cv = crearParametrosEntrada(oidPlantilla);
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      
		traza("************ Asignando datos a los combos");    
		asignar("COMBO", "cbMarca", resultados, "COMMarcasPlantilla");
		asignar("COMBO", "cbAcceso", resultados, "COMAccesosPlantilla");
		asignarAtributo("VAR", "varPais", "valor", sPais);
		asignarAtributo("VAR", "varIdioma", "valor", sIdioma);

		obtenerAccesosParaMarcar(oidPlantilla);
	  }
	  
	  
	  if((opcionMenu.equals("consultar")) || (opcionMenu.equals("modificar"))) {
		/*
		Si estamos en el CU de Consulta ó Modificación hacer 
		-> Llamar al método "getComision()" y obtener el DTOComisiones 
		-> Mapear en pantalla los datos necesarios tomándolos del dto
		DTOComisiones obtenido 
		Fin Si 
		*/

		DTOComisiones dtoComisiones = getComision(); 
        traza("************* dtoComisiones " + dtoComisiones);

		if(opcionMenu.equals("modificar")) {
	        traza("************* Entro por modificar");
			this.anyadeHiddensI18N(true,"COM_COMIS",dtoComisiones.getOid(),new Integer(1),"formulario","txtDescripcionComision",false);
		}
		else {
	        traza("************* Entro por consultar");
			this.anyadeHiddensI18N(true,"COM_COMIS",dtoComisiones.getOid(),new Integer(1),"formulario","txtDescripcionComision",true);
		}	  

       traza("************* 1");

		DTOI18nSICC[] dtosI18ns = dtoComisiones.getAttTraducible();

		if(dtosI18ns!=null) {
			Long idiomaSesion = UtilidadesSession.getIdioma(this);
			for(int i=0; i<dtosI18ns.length; i++) {
	  			DTOI18nSICC i18 = (DTOI18nSICC) dtosI18ns[i];

				Long idiomaDTO = i18.getOidIdioma();
	
				if(idiomaDTO.longValue() == idiomaSesion.longValue()) {
					//Seteando descripcion
					sDescripcionComision = i18.getValorI18n();
				}
			}
		}

      traza("************* 2");

		//Seteando oid de marca
		if(dtoComisiones.getOidMarca()!=null) {
			sOidMarca = dtoComisiones.getOidMarca().toString();
		}
		
       traza("************* 3");

		//Seteando oids de accesos
		ArrayList oidsAccesos = dtoComisiones.getComisionesAccesos();
		for(int i=0; i<oidsAccesos.size(); i++) {
			DTOComisionesAccesos dtoComisionesAccesos = (DTOComisionesAccesos)oidsAccesos.get(i);
			Long acceso = dtoComisionesAccesos.getOid();

			if(i==0) {
				sOidAccesos = acceso.toString();
			}
			else {
				sOidAccesos = sOidAccesos + "," + acceso.toString();
			}
		}

       traza("************* 4");
		//Seteando oid periodo desde
		sOidPeriodoDesde = dtoComisiones.getOidPeriodoDesde().toString();

       traza("************* 5");
		//Seteando oid periodo hasta
		sOidPeriodoHasta = dtoComisiones.getOidPeriodoHasta().toString();

       traza("************* 6");
		//Seteando numero periodos espera
		if(dtoComisiones.getPeriodosEspera()!=null) {
			sNumeroPeriodosEspera = dtoComisiones.getPeriodosEspera().toString();
			traza("************ sNumeroPeriodosEspera " + sNumeroPeriodosEspera);    
			asignarAtributo("VAR", "sNumeroPeriodosEspera", "valor", sNumeroPeriodosEspera);	  
		}		

		traza("************ opcionMenu " + opcionMenu);    
		traza("************ sDescripcionComision " + sDescripcionComision);    
		traza("************ sOidMarca " + sOidMarca);    
		traza("************ sOidAccesos " + sOidAccesos);    
		traza("************ sOidPeriodoDesde " + sOidPeriodoDesde);    
		traza("************ sOidPeriodoHasta " + sOidPeriodoHasta);    


		if(sDescripcionComision!=null) {
			asignarAtributo("VAR", "sDescripcionComision", "valor", sDescripcionComision);
		}

		if(sOidMarca!=null) {
			asignarAtributo("VAR", "sOidMarca", "valor", sOidMarca);
		}
  		
 		
  		asignarAtributo("VAR", "sOidAccesos", "valor", sOidAccesos);
  		asignarAtributo("VAR", "sOidPeriodoDesde", "valor", sOidPeriodoDesde);
  		asignarAtributo("VAR", "sOidPeriodoHasta", "valor", sOidPeriodoHasta);	  

		// vbongiov -- Cambio 20090913 -- 5/08/2009
		asignarAtributo("VAR", "sConsideraSabDomFer", "valor", dtoComisiones.getConsideraSabDomFer().booleanValue()?"S":"N");	  
		asignarAtributo("VAR", "sDsctoImpstoVtaPagos", "valor", dtoComisiones.getDsctoImpstoVtaPagos().booleanValue()?"S":"N");	  
		
		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		asignarAtributo("VAR", "sComisionEscalonada", "valor", 
				dtoComisiones.getComisionEscalonada()!=null && dtoComisiones.getComisionEscalonada().booleanValue()?"S":"N");	  

	  }
	}

	private void obtenerAccesosParaMarcar(Long oidPlantilla) throws Exception {
	    traza("******************* Entre a obtenerAccesosParaMarcar");
		DTOOID dtoOid = new DTOOID();
	    dtoOid.setOid(oidPlantilla);
		dtoOid.setOidIdioma(lIdioma);
	    dtoOid.setOidPais(lPais);

		MareBusinessID businessID = new MareBusinessID("COMAccesosPlantilla");
		Vector parametros = new Vector();      
      
	    parametros.add(dtoOid);
		parametros.add(businessID);

	    traza("******************* Antes de conectar");
		DruidaConector con = conectar("ConectorAccesosPlantilla", parametros);
		traza("******************* Despues de conectar");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");     
		RecordSet rs = dtoSalida.getResultado();		
		StringBuffer marcoAccesos = new StringBuffer();

		for (int i = 0 ; i < rs.getRowCount(); i++){
			BigDecimal oid = (BigDecimal)rs.getValueAt(i,0);
			if(i==0) {
				marcoAccesos.append(oid.toString());
			}
			else {
				marcoAccesos.append("," + oid.toString());
			}
		}
		asignarAtributo("VAR", "marcoAccesos", "valor", marcoAccesos.toString());				
	}
  
	private ComposerViewElementList crearParametrosEntrada(Long oidPlantilla) throws Exception{    
        traza("************* Entre a crearParametrosEntrada");
        traza("************* oidPlantilla " + oidPlantilla);
        traza("************* lIdioma " + lIdioma);
        traza("************* lPais " + lPais);

		DTOOID dtoOid = new DTOOID();
	    dtoOid.setOid(oidPlantilla);
		dtoOid.setOidIdioma(lIdioma);
	    dtoOid.setOidPais(lPais);
		
	    ComposerViewElementList lista = new ComposerViewElementList(); 
		
		//Combo accesos
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("COMAccesosPlantilla");
		cve1.setDTOE(dtoOid);
    
	    //Combo marcas
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("COMMarcasPlantilla");
		cve2.setDTOE(dtoOid);
    
		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
    
		return lista;
	}
  
  public void almacenar () throws Exception {
    traza("************* Entre a almacenar");    
    
    pagina("salidaGenerica");
    
    marca = conectorParametroLimpia("marca", "", true);
	descMarca = conectorParametroLimpia("descMarca", "", true);
    oidCanal = conectorParametroLimpia("canal", "", true);
	descCanal = conectorParametroLimpia("descCanal", "", true);
    acceso = conectorParametroLimpia("acceso", "", true);
    periodoDesde = conectorParametroLimpia("periodoDesde", "", true);
    periodoHasta = conectorParametroLimpia("periodoHasta", "", true);
    periodosEspera = conectorParametroLimpia("periodosEspera", "", true);
    indComparativo = conectorParametroLimpia("varIndComparativo", "", true);
    indTratamientoDif = conectorParametroLimpia("varIndTratamientoDif", "", true);
    oidPlantilla = conectorParametroLimpia("varOidPlantilla", "", true);

	// vbongiov -- Cambio 20090913 -- 5/08/2009
	consideraSabDomFer = conectorParametroLimpia("consideraSabDomFer", "", true);
    dsctoImpstoVtaPagos = conectorParametroLimpia("dsctoImpstoVtaPagos", "", true);

    // sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
    comisionEscalonada = conectorParametroLimpia("comisionEscalonada", "", true);        
    
    traza("************* marca " + marca);
	traza("************* descMarca " + descMarca);
    traza("************* oidCanal " + oidCanal);
	traza("************* descCanal " + descCanal);
    traza("************* acceso " + acceso);
    traza("************* periodoDesde " + periodoDesde);
    traza("************* periodoHasta " + periodoHasta);
    traza("************* periodosEspera " + periodosEspera);
    traza("************* indComparativo " + indComparativo);
    traza("************* indTratamientoDif " + indTratamientoDif);
    traza("************* oidPlantilla " + oidPlantilla);
    
    DTOComisiones dtoComisiones = this.getComision(); 
    if(dtoComisiones==null) {
      traza("************* DTOComisiones es null");    
      dtoComisiones = new DTOComisiones();  
    }   

	//0° Primero seteo el tipo de plantilla/comision, que
	//tiene la plantilla que eligio
	if(!oidTipoPlantilla.equals("")) {
		if(oidTipoPlantilla.equals("1")) {
			dtoComisiones.setIndVentaCobranza(new String("V"));
			dtoComisiones.setOidTipoComision(new Long(1));
		}
		else if(oidTipoPlantilla.equals("2")) {
			dtoComisiones.setIndVentaCobranza(new String("C"));
			dtoComisiones.setOidTipoComision(new Long(2));
		}		
	}
    
	//1° a Seteando oid de marca
	if(!marca.equals("")) {
		dtoComisiones.setOidMarca(new Long(marca));
	}

	//1° b Seteando oid de Plantilla
	if(!oidPlantilla.equals("")) {
		dtoComisiones.setOidPlantillasComisones(new Long(oidPlantilla));
	}

	//2° Seteando oid de canal
	if(!oidCanal.equals("")) {
		dtoComisiones.setOidCanal(new Long(oidCanal));
	}

	traza("*********** SETEANDO ACCESOS");
	//3° Seteando oids de accesos
	if(!acceso.equals("")) {
		StringTokenizer stAccesos = new StringTokenizer(acceso,",");
		ArrayList listaAccesos = new ArrayList();
    
		while(stAccesos.hasMoreTokens()) {
			DTOComisionesAccesos dtoComisionesAccesos = new DTOComisionesAccesos();
			String elementoI = stAccesos.nextToken();
	        Long elem = new Long(elementoI);
		    traza("************ elem: " + elem);
			dtoComisionesAccesos.setOid(elem);	
			traza("*********** dtoComisionesAccesos " + dtoComisionesAccesos);
			listaAccesos.add(dtoComisionesAccesos);
		}	
		dtoComisiones.setComisionesAccesos(listaAccesos);
	}

	//4° Seteando oid de periodo desde
	if(!periodoDesde.equals("")) {
		dtoComisiones.setOidPeriodoDesde(new Long(periodoDesde));
	}

	//5° Seteando oid de periodo hasta
	if(!periodoHasta.equals("")) {
		dtoComisiones.setOidPeriodoHasta(new Long(periodoHasta));
	}

  	//6° Seteando cantidad periodos espera
    if(!periodosEspera.equals("")) {
      dtoComisiones.setPeriodosEspera(new Integer(periodosEspera));  
    }	

   	//7° Seteando indicador comparativo
	if(!indComparativo.equals("")) {
		dtoComisiones.setComparativo(new Boolean(indComparativo));
	}

  	//8° Seteando indicador tratamiento diferencial
	if(!indTratamientoDif.equals("")) {
		dtoComisiones.setTratamientoDiferencial(new Boolean(indTratamientoDif));  
	}

	//9° Seteando descripcion de marca
	if(!descMarca.equals("")) {
		dtoComisiones.setDescMarca(new String(descMarca));
	}

	//10° Seteando descripcion de canal
	if(!descCanal.equals("")) {
		dtoComisiones.setDescCanal(new String(descCanal));
	}

	// vbongiov -- Cambio 20090913 -- 5/08/2009
	dtoComisiones.setConsideraSabDomFer(consideraSabDomFer.equals("S")?Boolean.TRUE:Boolean.FALSE);  
	dtoComisiones.setDsctoImpstoVtaPagos(dsctoImpstoVtaPagos.equals("S")?Boolean.TRUE:Boolean.FALSE);  
	
	// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
	dtoComisiones.setComisionEscalonada(comisionEscalonada.equals("S")?Boolean.TRUE:Boolean.FALSE);


	//11° Seteando atributos internacionalizables    
    traza("************* Obteniendo vector");    
    Vector aTradu = this.recuperaTraduccionesI18N(new Integer(1));
	if(aTradu!=null) {
	    traza("************* Despues de obtener el vector");    
		DTOI18nSICC[] dtoI18NSicc = new DTOI18nSICC[aTradu.size()];	

	    for(int i=0; i<aTradu.size(); i++) {
			DTOI18nSICC dtoI18n = (DTOI18nSICC)aTradu.get(i);
			traza("************* i " + i);
			traza("************* dtoI18n " + dtoI18n);
			dtoI18NSicc[i] = dtoI18n;
		}        

		DTOI18nSICC dtoTemp  = dtoI18NSicc[0];

		if(!dtoTemp.getValorI18n().equals("")) {
			traza("************* seteando array");
			dtoComisiones.setAttTraducible(dtoI18NSicc);	
		}
		else {
			traza("************* seteando null");
			dtoComisiones.setAttTraducible(null);	
		}		
	}	

	
	//FIN DE SETEO
	//SE GUARDA EL DTOCOMISIONES EN SESION
    traza("************* Antes de llamar a setComision");    
    this.setComision(dtoComisiones); 
    
    traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
    DTOComisiones dtoTemp = this.getComision(); 
    traza("************* DTOComisiones " + dtoTemp);        
  }

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);
	  	traza("************ opcionMenu " + opcionMenu);

		if (accion.equals("")) {
			if(opcionMenu.equals("insertar")) {
				traza("************ Entro por insertar");
				getConfiguracionMenu("LPMantenimientoComisionesDatosGenerales","");
				asignarAtributoPagina("cod","0515");         
			}
			else if(opcionMenu.equals("consultar")) {
					traza("************ Entro por consultar");
					getConfiguracionMenu("LPMantenimientoComisionesDatosGenerales","consultar");
					if(titulo.equals("EliminarComisiones")) {
						asignarAtributoPagina("cod","0558");         
					}
					else if(titulo.equals("ConsultarComisiones")) {
						asignarAtributoPagina("cod","0510");         
					}
			}			
			else if(opcionMenu.equals("modificar")) {
					traza("************ Entro por modificar");
					getConfiguracionMenu("LPMantenimientoComisionesDatosGenerales","modificar");
					asignarAtributoPagina("cod","0520");         
			}			

		}
	}
}