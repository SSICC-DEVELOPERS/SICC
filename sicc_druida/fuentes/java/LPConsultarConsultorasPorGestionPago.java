//$Id: LPConsultarConsultorasPorGestionPago.java,v 1.1 2009/12/03 18:37:05 pecbazalar Exp $ 
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
 * 
 * Autor: Viviana Bongiovanni
 */


import es.indra.sicc.util.*;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.dtos.cob.DTOCompromisoDePago;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Date;
import java.util.Vector;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPConsultarConsultorasPorGestionPago extends LPSICCBase{


	public LPConsultarConsultorasPorGestionPago()  {
	  super();
	}  

	public void inicio() throws Exception {
		pagina("contenido_consultoras_gestionPago_consultar");
	}


	public void ejecucion() throws Exception{

		setTrazaFichero();

		String accion = conectorParametroLimpia("accion", "", true);
		Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);
		
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());

		traza("accion: " + accion);

		try{
			if( accion.equals("")){	
				this.rastreo();
				this.cargarPagina();
			} else if( accion.equals("validarCliente") ){
				this.validarCliente();
			} else if( accion.equals("clienteSeleccionado")){	
				this.rastreo();
				this.clienteSeleccionado();
			}

	 }catch (Exception e){   

	   logStackTrace(e);
	   this.lanzarPaginaError(e);

	 }
     // Configura menu secundario
	 getConfiguracionMenu();

	}//fin ejecucion


    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            e.printStackTrace ();
         }
    }



    private void cargarPagina() throws Exception{
        //traza("metodo cargarPagina()");  
             
	    // Carga incial de combos
        //traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        //traza("antes del conector.ejecucion");
        conector.ejecucion();
        //traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        //traza("antes de asignar los COMBOS");
        asignar("COMBO","cbEstado",resultados,"COBObtenerEstadosAsignacion");        		

        // Longitud del Codigo de cliente
		asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		//traza("LongitudCodigoCliente: " + this.obtenerLongitudCodigoCliente().toString());
    
    }  



    private ComposerViewElementList crearParametrosEntrada() throws Exception{
        //traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOBelcorp dtoBel = new DTOBelcorp();
        //traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

        // Estado
		ComposerViewElement estado = new ComposerViewElement();        
		estado.setIDBusiness("COBObtenerEstadosAsignacion");
		estado.setDTOE(dtoBel);
        
        lista.addViewElement(estado);
		
        return lista;
    }



	private void clienteSeleccionado() throws Exception{
		 //traza("metodo clienteSeleccionado");
		 this.cargarPagina();

         String codigoCliente = conectorParametroLimpia("txtCodigoCliente", "", true);

		 asignarAtributo("CTEXTO", "txtCodigoCliente", "valor", codigoCliente);


	}

	

	private void validarCliente() throws Exception{
		//traza("metodo validarCliente");

		pagina("salidaGenerica");

		try	{
				
			String codigoCliente = conectorParametroLimpia("txtCodigoCliente", "", true);

			// idBusiness= "MAEBusquedaRapidaClientes" 
			MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
			// Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
			// - pais 
			// - idioma 
			// - codigoCliente: Valor introducido en txtCliente 
			DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
			dto.setIndicadorSituacion(new Long(0));
			dto.setTamanioPagina(new Integer(1));
			dto.setOidPais(UtilidadesSession.getPais(this));
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));

			dto.setCodigoCliente(codigoCliente);
			//traza("Código de cliente: " + codigoCliente);

			// Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(idBusiness);
			//traza("Conectando a ConectorBusquedaRapidaCliente... ");
			DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", parametros);
			//traza("Conectó.");

			// Recibe un DTOSalida (con un registro) 
			DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet retorno = dtoRetornado.getResultado();
			//traza("Retornó: ");
			//traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID"));
			//traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));

			String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
			
			String funcion = new String("asignarDatosCliente('" + oidCliente + "')");

			//traza("Funcion a ejecutar: " + funcion);
			
			asignarAtributo("VAR", "ejecutar", "valor", funcion);

		}catch (Exception e){   

		   asignarAtributo("VAR", "ejecutarError", "valor", "errorCliente()");
		   throw e;
		}
	}
  
}
