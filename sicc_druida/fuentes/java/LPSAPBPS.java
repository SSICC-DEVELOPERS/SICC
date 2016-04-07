/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.logicanegocio.intsys.ISAPBPS;
import es.indra.sicc.dtos.intsys.DTOINTPantallaSAPBPS;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;

public class LPSAPBPS extends LPSICCBase {
         
    private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;

    public LPSAPBPS() {
        super();
    }
          
    public void inicio() throws Exception {
    }
          
    public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

        try {

            traza("*** LPSAPBPS: Entrada ***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion", "", true);


            if (this.accion.equals("CasoUsoFuenteVentaReal") || this.accion.equals("CasoUsoDemandaAnormal")) {
				pagina("contenido_informacion_enviar_fuente_procesar");
				this.inicializar();
            } else if (this.accion.equals("enviarFuenteVentaReal")) {
            	pagina("salidaGenerica");
                this.enviarFuenteVentaReal();
            } else if (this.accion.equals("enviarDemandaAnormal")) {
            	pagina("salidaGenerica");
                this.enviarDemandaAnormal();
            }

            traza("*** Salida -  LPSAPBPS- ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void inicializar() throws Exception {
        traza("*** Entrada -  LPSAPBPS- inicializar ***");

	
	if(this.accion.equals("CasoUsoDemandaAnormal")) {
		traza("*** DENTRO del caso : CasoUsoDemandaAnormal cargamos el titulo  ***");
		asignarAtributo("PAGINA","contenido_informacion_enviar_fuente_procesar", "cod", "0898");
                asignarAtributo("PAGINA","contenido_informacion_enviar_fuente_procesar", "msgle", "Decidir Enviar Demanda Anormal");
		
	}


		this.asignarLote();
		this.asignarMarcaCanalPorDefecto();		
		this.cargarCombos();           
        this.asignarIdiomaPaisCU(); 

        getConfiguracionMenu("LPSAPBPS", "");

        traza("*** Salida -  LPSAPBPS- inicializar ***");
    }


    private void enviarFuenteVentaReal() throws Exception {
        traza("*** Entrada -  LPSAPBPS- enviar  ***");
        /*
        Invocamos al motor plano, con los siguientes parámetros: 
		DTOE: DTOINTPantallaSAPBPS, construído con los datos de pantalla 
		conector: ConectorEnviarFuenteVentaReal 
		IDBusiness: "INTEnviarInterfacesFuenteVentaReal"*/

		DTOINTPantallaSAPBPS  dtoEnvia = new DTOINTPantallaSAPBPS();
		dtoEnvia.setOidPais(this.pais);
        dtoEnvia.setOidIdioma(this.idioma);
        dtoEnvia.setDescripcionLote(conectorParametro("txtDescripcion"));
        String parametro = conectorParametroLimpia("areatxtObservaciones", "", true);
		if (!parametro.equals(""))
		    dtoEnvia.setObservaciones(parametro);
        dtoEnvia.setNumeroLote(new Long(conectorParametro("lote")));
		dtoEnvia.setPeriodo(new Long(conectorParametro("cbPeriodo")));
		dtoEnvia.setMarca(new Long(conectorParametro("cbMarca")));
		dtoEnvia.setCanal(new Long(conectorParametro("cbCanal")));
        traza("*** DTO  ***: " + dtoEnvia);

        MareBusinessID idBusiness = new MareBusinessID("INTEnviarInterfacesFuenteVentaReal");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoEnvia);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorEnviarFuenteVentaReal", paramEntrada);
		  asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()"); //agregado por eamores


        traza("*** Salida -  LPSAPBPS- enviar  ***");
    }

    private void enviarDemandaAnormal() throws Exception {
        traza("*** Entrada -  LPSAPBPS- enviarDemandaAnormal  ***");
        /*
		Invocamos al motor plano, con los siguientes parámetros: 
        DTOE: DTOINTPantallaSAPBPS, construído con los datos de pantalla 
		conector: ConectorEnviarInterfacesDemandaAnormal 
		IDBusiness: "INTEnviarInterfacesDemandaAnormal"
		*/

		DTOINTPantallaSAPBPS  dtoEnvia = new DTOINTPantallaSAPBPS();
		dtoEnvia.setOidPais(this.pais);
        dtoEnvia.setOidIdioma(this.idioma);
        dtoEnvia.setDescripcionLote(conectorParametro("txtDescripcion"));
        String parametro = conectorParametroLimpia("areatxtObservaciones", "", true);
		if (!parametro.equals(""))
		    dtoEnvia.setObservaciones(parametro);
        dtoEnvia.setNumeroLote(new Long(conectorParametro("lote")));
		dtoEnvia.setPeriodo(new Long(conectorParametro("cbPeriodo")));
		dtoEnvia.setMarca(new Long(conectorParametro("cbMarca")));
		dtoEnvia.setCanal(new Long(conectorParametro("cbCanal")));
        traza("*** DTO  ***: " + dtoEnvia);

        MareBusinessID idBusiness = new MareBusinessID("INTEnviarInterfacesDemandaAnormal");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoEnvia);
        paramEntrada.add(idBusiness);

       // DruidaConector conector = conectar("ConectorEnviarInterfacesDemandaAnormal", paramEntrada);
        
        DruidaConector conector = conectar("ConectorEnviarFuenteVentaReal", paramEntrada);
        asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()"); //agregado por incidencia SiCC-20070355

        traza("*** Salida -  LPSAPBPS- enviarDemandaAnormal  ***");
    }

 
    private void cargarCombos() throws Exception {
        traza("*** Entrada -  LPSAPBPS- cargarCombos ***");
        
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;

        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(this.pais);
        dtoBelcorp.setOidIdioma(this.idioma);

        String[] idBussines = new String[2];
        idBussines[0] = "SEGConsultaMarcas";	//1 y 3
        idBussines[1] = "SEGConsultaCanales";	//1 y 3


        for (int i = 0; i < idBussines.length; i++) {
            elem = new ComposerViewElement(); 
            elem.setIDBusiness(idBussines[i]);
            elem.setDTOE(dtoBelcorp);
            listelem.addViewElement(elem);
        }

        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
               
        DruidaConector conConsulta = conector.getConector();
                
        asignar("COMBO", "cbMarca", conConsulta, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", conConsulta, "SEGConsultaCanales");

        traza("*** Salida -  LPSAPBPS- cargarCombos ***");
    }
    



    private void asignarIdiomaPaisCU() throws Exception {
        asignar("VAR", "idioma", this.idioma.toString());
        asignar("VAR", "pais", this.pais.toString());    
        if (this.accion.equals("CasoUsoDemandaAnormal"))
        	asignar("VAR", "accion", "enviarDemandaAnormal"); 
        else   
        	asignar("VAR", "accion", "enviarFuenteVentaReal"); 
    }

    private void asignarLote() throws Exception {
        traza("**** Entrada -  LPSAPBPS- asignarLote ***");

		DTOString dtoS = new DTOString();

		
		if (this.accion.equals("CasoUsoFuenteVentaReal")) {
	        dtoS.setCadena(ISAPBPS.COD_INTERFAZ_SAB27); 
		}else if (this.accion.equals("CasoUsoDemandaAnormal")) {
    	    dtoS.setCadena(ISAPBPS.COD_INTERFAZ_SAB16); 
		}else{
    		dtoS.setCadena(ISAPBPS.COD_INTERFAZ_SAB25); 
		}
		dtoS.setOidIdioma(this.idioma);
		dtoS.setOidPais(this.pais);
		    
		MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
		Vector vec = new Vector();
		vec.add(dtoS);
		vec.add(mid);
		traza("antes de llamar al conector");

		try {			//prueba

		DruidaConector dc = conectar("ConectorObjeto", vec);
		es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz dtocii = (es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
		if (dtocii.getNumeroLote() != null) {
			// se asignan estos valores a campos ocultos de la pagina
			asignar("VAR", "lote", dtocii.getNumeroLote().toString());
			asignar("LABELC", "lblvalorLote", dtocii.getNumeroLote().toString()); 
		}
		if (dtocii.getDescripcion() != null)
			asignar("CTEXTO", "txtDescripcion", dtocii.getDescripcion());

		} catch (Exception e) {
       		traza("*** fallo en interfaz INTCargaInicialInterfaz ***");

			//prueba
			asignar("VAR", "lote", "1");
			asignar("LABELC", "lblvalorLote", "1"); 
		}

        traza("*** Salida -  LPSAPBPS- asignarLote ***");    }
    
    private void asignarMarcaCanalPorDefecto() throws Exception {
		// cada usuario tiene una marca y canal por defecto que deben seleccionarse
		Long marca = UtilidadesSession.getMarcaPorDefecto(this);
		Long canal = UtilidadesSession.getCanalPorDefecto(this);
		
		// se asignan estos valores a campos ocultos de la pagina
		asignar("VAR", "marcaPorDefecto", marca.toString());
		asignar("VAR", "canalPorDefecto", canal.toString()); 
    }
    
    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);		
        traza("Stack Trace: " + baos.toString());
    }
}                                                               