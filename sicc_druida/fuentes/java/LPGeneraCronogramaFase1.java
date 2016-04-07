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

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:      Cronograma
 * Componente:    LPGeneraCronogramaFase1 
 * Fecha:             02/06/2004
 * Observaciones:     
 * @version        1.0
 * @autor           Luis Ramos
 */

public class LPGeneraCronogramaFase1 extends LPSICCBase {

	public LPGeneraCronogramaFase1() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_cronograma1_generar");
	}

	public void ejecucion() throws Exception {

    setTrazaFichero();
	  rastreo();

	  try{
			String mAccion = conectorParametroLimpia( "accion", "", true );

      if (mAccion.equals("")) {

          conectorAction("LPMantieneCronograma");
          conectorActionParametro("accion","muestraCronogramaFase1");
          //conectorActionParametro("casoDeUso","eliminar");
      }

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }

		  getConfiguracionMenu();

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
