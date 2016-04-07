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

/**
 * Sistema:           Belcorp
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LPInsertarVinculosJerarquia 
 * Fecha:             15/03/2004
 * Observaciones:     
 * @version           1.0
 * @autor             Viviana Bongiovanni
 */

public class LPInsertarVinculosJerarquia extends LPSICCBase {

	public LPInsertarVinculosJerarquia() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_vinculo_jerarquia_insertar");
	}

	public void ejecucion() throws Exception {

      setTrazaFichero();
    asignarAtributoPagina("cod", "0639");
	  try{

       // Rastreo
       rastreo();

traza("pase por insertar.........ejecucion(insertar)");

		  conectorAction("LPMantenimientoVinculosJerarquia");
		  conectorActionParametro("accion","insertar");
		  conectorActionParametro("casoDeUso","insertar");

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }

		  //getConfiguracionMenu();

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
