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

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.logicanegocio.intsys.ISAPBPS;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;

public class LPPedidosDia extends LPSICCBase {
         
    private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;

    public LPPedidosDia() {
        super();
    }
          
    public void inicio() throws Exception {
    }
          
    public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

        try {

            traza("*** LPPedidosDia: Entrada ***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion", "", true);


            if (this.accion.equals("")) {
				pagina("contenido_informacion_enviar_pedido_procesar");
				this.inicializar();
            } else if (this.accion.equals("enviar")) {
            	pagina("salidaGenerica");
                this.enviar();
            }

            traza("*** Salida -  LPPedidosDia- ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void inicializar() throws Exception {
        traza("*** Entrada -  LPPedidosDia- inicializar ***");

		this.asignarLote();
		this.asignarMarcaCanalPorDefecto();		
		this.cargarCombos();           
        this.asignarIdiomaPais(); 
		this.generarHiddenFormatoFecha();
        getConfiguracionMenu("LPPedidosDia", "");

        traza("*** Salida -  LPPedidosDia- inicializar ***");
    }


    private void enviar() throws Exception {
        traza("*** Entrada -  LPPedidosDia- enviar  ***");

		/*
- Creamos un DTOEnviarPedidosSAP que rellenamos con los campos recogidos de la pantalla (además del pais y el idioma) 

- Llamamos al ConectorEnviarPedidosMarca con el dto creado y el idBusiness "INTEnviarPedidosMarcaBatch" 
- Llamamos al ConectorVentaProducto con el dto creado y el idBusiness "INTEnviarVentaDiaProductoBatch" */
		
		
		
		es.indra.sicc.dtos.intsys.DTOEnviarPedidosSAP  dtoEnvia = new es.indra.sicc.dtos.intsys.DTOEnviarPedidosSAP();
		dtoEnvia.setOidPais(this.pais);
        dtoEnvia.setOidIdioma(this.idioma);

		String parametro = conectorParametroLimpia("txtFecha", "", true);
		if (!parametro.equals(""))
			dtoEnvia.setFechaFacturacion(UtilidadesBelcorp.getDatefromSICCStringFormat(parametro, UtilidadesSession.getFormatoFecha(this)));
        dtoEnvia.setDescripcionLote(conectorParametro("txtDescripcion"));
        parametro = conectorParametroLimpia("areatxtObservaciones", "", true);
		if (!parametro.equals(""))
		    dtoEnvia.setObservaciones(parametro);
        dtoEnvia.setNumeroLote(new Long(conectorParametro("lote")));
		dtoEnvia.setOidPeriodo(new Long(conectorParametro("cbPeriodo")));

        MareBusinessID idBusiness = new MareBusinessID("INTEnviarPedidosMarcaBatch");

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoEnvia);
        paramEntrada.add(idBusiness);

        DruidaConector conector = conectar("ConectorEnviarPedidosMarca", paramEntrada);

        idBusiness = new MareBusinessID("INTEnviarVentaDiaProductoBatch");

        paramEntrada = new Vector();
        paramEntrada.add(dtoEnvia);
        paramEntrada.add(idBusiness);

        conector = conectar("ConectorVentaProducto", paramEntrada);		
        asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()"); //agregado por incidencia SiCC-20070355

        traza("*** Salida -  LPPedidosDia- enviar  ***");
    }


 
    private void cargarCombos() throws Exception {
        traza("*** Entrada -  LPPedidosDia- cargarCombos ***");
        
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

        traza("*** Salida -  LPPedidosDia- cargarCombos ***");
    }
    



    private void asignarIdiomaPais() throws Exception {
        asignar("VAR", "idioma", this.idioma.toString());
        asignar("VAR", "pais", this.pais.toString());    
    }

    private void asignarLote() throws Exception {
        traza("*** Entrada -  LPPedidosDia- asignarLote ***");
		
		es.indra.sicc.util.DTOString dtoS = new es.indra.sicc.util.DTOString();
		
		dtoS.setCadena(ISAPBPS.COD_INTERFAZ_SAB12); // COD_INTERFAZ_SAB12);
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

			//prueba
			asignar("VAR", "lote", "1");
			asignar("LABELC", "lblvalorLote", "1"); 
		}

        traza("*** Salida -  LPPedidosDia- asignarLote ***");
		
    }
    
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