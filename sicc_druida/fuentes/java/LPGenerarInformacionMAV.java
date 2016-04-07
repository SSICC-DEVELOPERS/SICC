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

import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mav.DTOLineaCombo;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

/**
 * Sistema:       Belcorp
 * Modulo:        MAV
 * Submódulo:     Generar Informacion MAV
 * Componente:    LPGenerarInformacionMAV
 * Fecha:             01/10/2004
 * Observaciones:     
 * @version       1.0
 * @autor         Luis Ramos
 */

public class LPGenerarInformacionMAV extends LPSICCBase {

	public LPGenerarInformacionMAV() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_informacion_MAV_generar");
	}


	public void ejecucion() throws Exception {

        setTrazaFichero();
        rastreo();
        getConfiguracionMenu("LPGenerarInformacionMAV","");

        try{
            String mAccion = conectorParametroLimpia( "accion", "", true );
            traza("Accion: "+mAccion);

            asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());    
            asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());    

            if (mAccion.equals("")) {
                this.cargarPagina();

            } else if (mAccion.equals("aceptar")) {
                this.aceptar();

            } else if (mAccion.equals("recuperarTipoClienteActividad")) {
                this.recuperarTipoClienteActividad();
            }	  

        }catch (Exception ex){
            logStackTrace(ex); 
            this.lanzarPaginaError(ex);
        }

	}


    /**
     * 
     */
	private void cargarPagina() throws Exception {
		cargaInicialCombos();
	}


    /**
     * Recupera el tipo de cliente para una actividad seleccionada.
     */
	private void recuperarTipoClienteActividad() throws Exception {
		traza("recuperarTipoClienteActividad()");
		pagina("salidaGenerica");
		//-> Tomar el valor del combo "actividad" de la pantalla 
		String actividad = conectorParametroLimpia( "hActividad", "", true );

		//-> Crear objeto DTOOID pais e idioma de la sesión y con el oid de actividad obtenido en la iteración anterior 
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOID.setOidPais(UtilidadesSession.getPais(this));
        dtoOID.setOid(new Long(actividad));
		//-> Crear idBusiness = "MAVRecuperarTipoClienteActividad" 
        MareBusinessID businessID = new MareBusinessID("MAVRecuperarTipoClienteActividad");

		//-> Asignar conector "ConectorRecuperarTipoClienteActividad" 
        Vector parametros = new Vector();
        parametros.addElement(dtoOID);     
        parametros.addElement(businessID);
        traza("Antes ConectorRecuperarTipoClienteActividad: " + dtoOID);
        DruidaConector conector = conectar( "ConectorRecuperarTipoClienteActividad" , parametros);
        traza("Despues ConectorRecuperarTipoClienteActividad"); 

		//-> Recuperar DTOLineaCombo de respuesta 
        DTOLineaCombo dtoLineaCombo = (DTOLineaCombo)conector.objeto("dtoLineaCombo");
        traza("oidTipoCliente: " + dtoLineaCombo.getOid());
        traza("descripcionTipoCliente: " + dtoLineaCombo.getDescripcion());

		//-> Mapear DTOLineaCombo.oid en la variable "oidTipoCliente" de pantalla y DTOLineaCombo.descripcion en el Label "tipoCliente" 
        String setearTipoClienteJS = "setearTipoCliente('" + dtoLineaCombo.getOid().toString() + "', '" + dtoLineaCombo.getDescripcion() + "'); ";
        asignarAtributo("VAR", "ejecutar", "valor", setearTipoClienteJS);
    }   


    /**
     * Genera informacion MAV.
     */
	private void aceptar() throws Exception {
        traza("aceptar");
        pagina("salidaGenerica");
        String marca = conectorParametroLimpia( "hMarca", "", true );
        String canal = conectorParametroLimpia( "hCanal", "", true );
        String periodo = conectorParametroLimpia( "hPeriodo", "", true );
        String actividad = conectorParametroLimpia( "hActividad", "", true );
        String tipoCliente = conectorParametroLimpia( "hOidTipoCliente", "", true );
        traza("tipoCliente: " + tipoCliente);

        MareDTO dtoO = new MareDTO();
        dtoO.setProperty("oidIdioma", UtilidadesSession.getIdioma(this));
        dtoO.setProperty("oidPais", UtilidadesSession.getPais(this));
        dtoO.setProperty("oidMarca", new Long(marca));
        dtoO.setProperty("oidCanal", new Long(canal));
        dtoO.setProperty("oidPeriodo", new Long(periodo));
        dtoO.setProperty("ipCliente", UtilidadesBelcorp.getIPCliente(this));
        dtoO.setProperty("programa", "LPGenerarInformacionMAV");
        if (!actividad.equals("")) {
            dtoO.setProperty("oidActividad", new Long(actividad));
        } else {
            dtoO.setProperty("oidActividad", null);
        }
        if (!tipoCliente.equals("")) {
            dtoO.setProperty("oidTipoCliente", new Long(tipoCliente));
        } else {
            dtoO.setProperty("oidTipoCliente", null);
        }
        MareBusinessID bizId = new MareBusinessID("MAVGenerarInformacionMAV");

        Vector params = new Vector();
        params.addElement(dtoO);     
        params.addElement(bizId);

        traza( "Antes conector: " + dtoO);
        DruidaConector dc  =	conectar( "ConectorGenerarInformacionMAV" , params );
		asignarAtributo("VAR","ejecutar","valor","generado()");
		traza( "dc "); 
	}

    
    private void cargaInicialCombos() throws Exception{
        traza("Inicio cargaInicialCombos");
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		traza("resultados: "+resultados.getXML());
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        
	    traza("Fin cargaInicialCombos");
	}


	private ComposerViewElementList crearParametrosEntrada() throws Exception {
      ComposerViewElementList lista = new ComposerViewElementList(); 

      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
    
      //Primer combo
      ComposerViewElement ci1 = new ComposerViewElement();
      ci1.setIDBusiness("SEGConsultaMarcas");
      ci1.setDTOE(dtoBel);
      ci1.setPosOID((byte)0);
      ci1.setPosDesc((byte)1);

      lista.addViewElement(ci1);

      //Segundo combo
      ComposerViewElement ci2 = new ComposerViewElement();
      ci2.setIDBusiness("SEGConsultaCanales");
      ci2.setDTOE(dtoBel);
      ci2.setPosOID((byte)0);
      ci2.setPosDesc((byte)1);

      lista.addViewElement(ci2);

      return lista;
	}


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}


	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}

}
