/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;
import es.indra.sicc.dtos.seg.DTOSubacceso;


public class LPReasignarNumeroDocumentoContable extends LPSICCBase {
	private String accion = "";
	private String casoDeUso = "";

	private Long idioma;
	private Long pais;   
	private Long subaccesoDefecto = null;    
	private Long accesoDefecto = null;    
	private Long canalDefecto = null;    

	public LPReasignarNumeroDocumentoContable() {
      	super();
    }


    public void inicio() throws Exception {
		pagina("contenido_documento_contable_reasignar");
    }
 
  	public void ejecucion() throws Exception {
    	setTrazaFichero();
    	try  {
	   		rastreo();
	   		traza("Caso de Uso = ReasignarNumeroDocumentoContable");
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			asignar("VAR", "idioma", idioma.toString());
	        asignar("VAR", "pais", pais.toString()); 
			DTOBelcorp dtoBelcorp = new DTOBelcorp();
			MareBusinessID idNegocio = new MareBusinessID("SEGObtenerValoresDefectoAccesoSub");
			Vector paramsEntrada = new Vector();
            paramsEntrada.add(dtoBelcorp);
            paramsEntrada.add(idNegocio);
			traza("Antes de Con");
            DruidaConector conector = conectar("ConectorSubaccesoDefecto", paramsEntrada);			
			traza("desp de Con");
			DTOSubacceso salida = (DTOSubacceso)conector.objeto("DTOSubacceso");
			
			this.subaccesoDefecto = new Long(salida.getOidSubacceso().toString());
			traza("subacceso = " + this.subaccesoDefecto);
			this.accesoDefecto = new Long(salida.getOidAcceso().toString());
			traza("acceso = " + this.accesoDefecto);
			this.canalDefecto = new Long(salida.getOidCanal().toString());
			traza("canal = " + this.canalDefecto);

            this.accion = conectorParametroLimpia("accion","",true);
          	this.casoDeUso = conectorParametroLimpia("casoDeUso","",true);
           	asignar("VAR", "accion", this.accion);
           	asignar("VAR", "casoDeUso", this.casoDeUso);
			asignar("VAR", "subaccesoDefecto", this.subaccesoDefecto.toString());
			asignar("VAR", "accesoDefecto", this.accesoDefecto.toString());
			asignar("VAR", "canalDefecto", this.canalDefecto.toString());
           	getConfiguracionMenu("LPReasignarNumeroDocumentoContable","");
       		if (accion.equals("")) {
				inicializar();
       		} else if (accion.equals("asignar")) {
       			asignar();
       		} else if (accion.equals("confirmar")) {
       			confirmar();
       		}             

			//Se Modifica por Cambios FAC-001 Ajustes a Asignacion de Numero Legal a Documento Contable
	   		//conectorAction("LPRangosNumeracionATratar");             
	   		//conectorActionParametro("casoDeUso", "regenerar");
				
    	} catch ( Exception e )  {
    		e.printStackTrace();     
    		lanzarPaginaError(e);
    	}
  	}
	
	 private void inicializar() throws Exception {		
   		asignarAtributo("PAGINA","contenido_documento_contable_reasignar", "cod", "0540");
   		asignarAtributo("PAGINA","contenido_documento_contable_reasignar", "msgle", "Reasignar Número de Documento Contable");
		obtenerDatosIniciales();
	 }

	 private void obtenerDatosIniciales() throws Exception{
       traza("***Entrada - LPReasignarNumeroDocumentoContable - obtenerDatosIniciales***");
                  
       try{
                            		
          //Creamos DTOBelcorp
		  DTOBelcorp dto = new DTOBelcorp();
          dto.setOidPais(pais);
          dto.setOidIdioma(idioma);
                          
          //Creamos lista composerView
          ComposerViewElementList listElement = new ComposerViewElementList();
                             		
          //Carga canales
          ComposerViewElement elem1=new ComposerViewElement();
          elem1.setIDBusiness("SEGConsultaCanales");
          elem1.setDTOE(dto);
          elem1.setPosOID((byte)0);
          elem1.setPosDesc((byte)1);
          listElement.addViewElement(elem1);
          traza("elemento añadido");
                 
          //Carga los tipos de documento
          ComposerViewElement elem2 = new ComposerViewElement();
          elem2.setIDBusiness("FACObtenerTiposDocumentoLegal");
          elem2.setDTOE(dto);
          elem2.setPosOID((byte)0);
          elem2.setPosDesc((byte)1);
                 	
                 	
          listElement.addViewElement(elem2);
          traza("elemento añadido");
                           
          //Llamar al subsistema GestorCargaPantalla
          ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
          traza("conector creado");
          conector.ejecucion();
          traza("ejecutado");
          DruidaConector conConsultar = conector.getConector();
          traza("Obtener conConsultar");
         
        
          asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales"); 
          asignar("COMBO","cbTipoDocumentoContable", conConsultar,"FACObtenerTiposDocumentoLegal");
      
      }catch ( Exception e )  {
	  	  logStackTrace(e);
          lanzarPaginaError(e);
      }		

      traza("***Salida - LPReasignarNumeroDocumentoContable - obtenerDatosIniciales***");
    }

	protected void logStackTrace(Throwable e) throws Exception {
           traza("Se produjo la excepcion: " + e.getMessage());
    
           ByteArrayOutputStream baos = new ByteArrayOutputStream();
           PrintStream ps = new PrintStream(baos);
           e.printStackTrace(ps);
                            
           traza("Stack Trace: " + baos.toString());
   	}

	private void asignar() throws Exception {
		traza("***Entrada - LPReasignarNumeroDocumentoContable - Asignar***");
		try	{
			pagina("salidaGenerica");
			DTOFACReasignarNumeroDocContable dtoFacReasignar = new DTOFACReasignarNumeroDocContable();
			dtoFacReasignar.setOidPais(pais);
			dtoFacReasignar.setOidIdioma(idioma);
			Long oidTipoDocContable = new Long(conectorParametroLimpia("cbTipoDocumentoContable", "", true));
			dtoFacReasignar.setOidTipoDocContable(oidTipoDocContable);
			Long oidCanal = new Long(conectorParametroLimpia("cbCanal", "", true));
			dtoFacReasignar.setOidCanal(oidCanal);
			Long oidAcceso = new Long(conectorParametroLimpia("cbAcceso", "", true));
			dtoFacReasignar.setOidAcceso(oidAcceso);
			Long oidSubAcceso = new Long(conectorParametroLimpia("cbSubacceso", "", true));
			dtoFacReasignar.setOidSubAcceso(oidSubAcceso);
			Long ejercicio = new Long(conectorParametroLimpia("textEjercicio", "", true));
			dtoFacReasignar.setEjercicio(ejercicio);
			Long rangoDocIntDesde = new Long(conectorParametroLimpia("textRangoDesdeDocInterno", "", true));
			dtoFacReasignar.setRangoDocInternoDesde(rangoDocIntDesde);
			Long rangoDocIntHasta = new Long(conectorParametroLimpia("textRangoHastaDocInterno", "", true));
			dtoFacReasignar.setRangoDocInternoHasta(rangoDocIntHasta);
			String serieDocLegal = conectorParametroLimpia("textSerieDocLegal", "", true);
			dtoFacReasignar.setSerieDocLegal(serieDocLegal);
			Long rangoDocLegDesde = new Long(conectorParametroLimpia("textRangoDesdeDocLegal", "", true));
			dtoFacReasignar.setRangoDocLegalDesde(rangoDocLegDesde);
	        MareBusinessID idNegocio = new MareBusinessID("FACAsignarNumeroDocumentoContable");
		    Vector paramsEntrada = new Vector();
		    paramsEntrada.add(dtoFacReasignar);
            paramsEntrada.add(idNegocio);
            traza("Antes del Conector");                                             
            DruidaConector conector = conectar("ConectorReasignarNumeroDocContable", paramsEntrada);
			traza("Despues del Conector");

			DTOFACReasignarNumeroDocContable salida = (DTOFACReasignarNumeroDocContable)conector.objeto("DTOFACReasignarNumeroDocContable");
			traza("Asignacion del Conector");
			traza("Devuelve " + salida.getRangoDocLegalHasta().toString());
			
			//	Agregado por HRCS - Fecha 30/05/2007 - Cambio Sicc20070258
			if (salida.getCantidadDocumentosNoImpresos()!=null )
				traza("Cant.Docs.No Impresos: " + salida.getCantidadDocumentosNoImpresos().toString());
			if (salida.getNumeroRegistrosNoNulos()!=null )
				traza("Num.Reg.Doc. Legal No Nulos: " + salida.getNumeroRegistrosNoNulos().toString());

			asignarAtributo("VAR", "ejecutar", "valor", "cargarRangoHasta(" + salida.getRangoDocLegalHasta().toString() +","
				                                                            + salida.getCantidadDocumentosNoImpresos().toString() +","
																			+ salida.getNumeroRegistrosNoNulos().toString() +")");
			asignarAtributo("CTEXTO",  "textRangoHastaDocLegal","valor", salida.getRangoDocLegalHasta().toString());

		} catch ( Exception e )  {
	  	  logStackTrace(e);
          lanzarPaginaError(e);
		}
		traza("***Salida - LPReasignarNumeroDocumentoContable - Asignar***");
	}
  
	private void confirmar() throws Exception {
		traza("***Entrada - LPReasignarNumeroDocumentoContable - Confirmar***");
		try		{
			pagina("salidaGenerica");
			DTOFACReasignarNumeroDocContable dtoFacReasignar = new DTOFACReasignarNumeroDocContable();
			dtoFacReasignar.setOidPais(pais);
			dtoFacReasignar.setOidIdioma(idioma);
			Long oidTipoDocContable = new Long(conectorParametroLimpia("cbTipoDocumentoContable", "", true));
			dtoFacReasignar.setOidTipoDocContable(oidTipoDocContable);
			Long oidCanal = new Long(conectorParametroLimpia("cbCanal", "", true));
			dtoFacReasignar.setOidCanal(oidCanal);
			Long oidAcceso = new Long(conectorParametroLimpia("cbAcceso", "", true));
			dtoFacReasignar.setOidAcceso(oidAcceso);
			Long oidSubAcceso = new Long(conectorParametroLimpia("cbSubacceso", "", true));
			dtoFacReasignar.setOidSubAcceso(oidSubAcceso);
			Long ejercicio = new Long(conectorParametroLimpia("textEjercicio", "", true));
			dtoFacReasignar.setEjercicio(ejercicio);
			Long rangoDocIntDesde = new Long(conectorParametroLimpia("textRangoDesdeDocInterno", "", true));
			dtoFacReasignar.setRangoDocInternoDesde(rangoDocIntDesde);
			Long rangoDocIntHasta = new Long(conectorParametroLimpia("textRangoHastaDocInterno", "", true));
			dtoFacReasignar.setRangoDocInternoHasta(rangoDocIntHasta);
			String serieDocLegal = conectorParametroLimpia("textSerieDocLegal", "", true);
			dtoFacReasignar.setSerieDocLegal(serieDocLegal);
			Long rangoDocLegDesde = new Long(conectorParametroLimpia("textRangoDesdeDocLegal", "", true));
			dtoFacReasignar.setRangoDocLegalDesde(rangoDocLegDesde);
			Long rangoDocLegHasta = new Long(conectorParametroLimpia("textRangoHastaDocLegal", "", true));
			dtoFacReasignar.setRangoDocLegalHasta(rangoDocLegHasta);

	        MareBusinessID idNegocio = new MareBusinessID("FACConfirmarNumeroDocumentoContable");
		    Vector paramsEntrada = new Vector();
		    paramsEntrada.add(dtoFacReasignar);
            paramsEntrada.add(idNegocio);
            traza("Antes del Conector");                                             
            DruidaConector conector = conectar("ConectorReasignarNumeroDocContable", paramsEntrada);
			//inicializar();
		} catch ( Exception e )  {
	  	  logStackTrace(e);
          lanzarPaginaError(e);
		}	
		traza("***Salida - LPReasignarNumeroDocumentoContable - Confirmar***");
	}
	
}