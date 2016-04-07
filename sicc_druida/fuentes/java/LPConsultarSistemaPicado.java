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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

public class LPConsultarSistemaPicado extends LPSICCBase {
	
	private String accion = null;
	private String opcionMenu = null;
	private Long pais = null;
	private Long idioma = null;

	public LPConsultarSistemaPicado() {
		super();
	}


	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

		try  {	
			traza("LPConsultarSistemaPicado Entrada");

			pagina("contenido_sistema_picado_consultar");
			getConfiguracionMenu("LPConsultarSistemaPicado", "consultar");
			asignarAtributoPagina("cod", "ApeConsultarSistemaPicado");
			asignar("VAR", "hPais", UtilidadesSession.getPais(this).toString());
			asignar("VAR","hIdioma",UtilidadesSession.getIdioma(this).toString());

			traza("LPConsultarSistemaPicado Salida");			
		}catch ( Exception e )  {
			traza("entro en catch LPConsultarSistemaPicado");			
			e.printStackTrace();
		}		
	}
}