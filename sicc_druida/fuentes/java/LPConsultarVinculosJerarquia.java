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

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.seg.DTOEBuscarVinculosJerarquia;
import es.indra.sicc.dtos.seg.DTOEVinculoJerarquia;

import LPSICCBase;

/**
 * Sistema:           Belcorp
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LPConsultarVinculosJerarquia
 * Fecha:             15/03/2004
 * Observaciones:     
 * @version           1.0
 * @autor             Viviana Bongiovanni
 */

public class LPConsultarVinculosJerarquia extends LPSICCBase {

	public LPConsultarVinculosJerarquia() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_vinculo_jerarquia_consultar");
	}

	public void ejecucion() throws Exception {

    setTrazaFichero();

	  try{
      // Rastreo
      rastreo();

		  conectorAction("LPMantenimientoVinculosJerarquia");
		  conectorActionParametro("accion","consultar");
		  conectorActionParametro("casoDeUso","consultar");

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }

	}

/*  private void pruebaLoca() 
  {
      DTOMarcasPorTipoAbono dtom = new DTOMarcasPorTipoAbono();
      //dtom.setIpCliente("2");
      dtom.setObservaciones("1");

      DTOFiltroPMC dto2 = new DTOFiltroPMC();
      dto2.setIpCliente("2");
  }*/


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
