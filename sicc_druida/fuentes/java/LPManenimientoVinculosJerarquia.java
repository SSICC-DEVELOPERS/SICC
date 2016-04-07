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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBelcorp;

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
import es.indra.sicc.util.UtilidadesSession;

/**
 * Sistema:           Belcorp 
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LPManenimientoVinculosJerarquia
 * Fecha:             15/03/2004
 * Observaciones:     
 * @version           1.0
 * @autor             Viviana Bongiovanni
 */

public class LPManenimientoVinculosJerarquia extends LPSICCBase {

	public LPManenimientoVinculosJerarquia() {
		super();
	}

	public void inicio() throws Exception {

		String sCasoDeUso = conectorParametroLimpia("casoDeUso","",true);    


		if (sCasoDeUso.equals("insertar")){	
			pagina("contenido_vinculo_jerarquia_insertar");
      asignarAtributoPagina("cod", "0639");
		} else if (sCasoDeUso.equals("consultar")){	
			pagina("contenido_vinculo_jerarquia_consultar");
			this.asignarAtributoPagina("cod","0640");
		} else if (sCasoDeUso.equals("eliminar")){	
			pagina("contenido_vinculo_jerarquia_consultar");
			this.asignarAtributoPagina("cod","0641");
		}
		
	}

	public void ejecucion() throws Exception {
	
      setTrazaFichero();

    traza("estoy en la ejecucion......mantenimiento");

	  try{
      // Rastreo
      rastreo();

		  // Carga los combos
		  DTOBelcorp dtoBelcorp = new DTOBelcorp();

		  dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
		  dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));

		  traza("dtoBelcorp: " + dtoBelcorp);

		  ComposerViewElementList lista = new ComposerViewElementList(); 

		  // Marca
		  ComposerViewElement ci1 = new ComposerViewElement();
		  ci1.setIDBusiness("SEGConsultaMarcas");
		  ci1.setDTOE(dtoBelcorp);

		  // Canal
		  ComposerViewElement ci2 = new ComposerViewElement();
		  ci2.setIDBusiness("SEGConsultaCanales");
		  ci2.setDTOE(dtoBelcorp);
/*
		  // Empresa
		  ComposerViewElement ci3 = new ComposerViewElement();
		  ci3.setIDBusiness("SEGObtenerEmpresasPorPais");
		  ci3.setDTOE(dtoBelcorp);
		  */

/*
		  //Refefinimos la posición de las columnas porque el resultado de 
		  // la operación de negocio no es estándar
			ci2.setPosOID((byte)2);
			ci2.setPosDesc((byte)0);
*/			
		  lista.addViewElement(ci1);
		  lista.addViewElement(ci2);
		  //lista.addViewElement(ci3);


		  //Utilizamos el subsistema
		  ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		  traza("Antes Carga Combos");
		  conector.ejecucion();
		  DruidaConector resultados = conector.getConector();
		  traza("Despues Carga Combos");
		
		  //Cargamos los combos con los resultados
		  asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		  asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
		 // asignar("COMBO", "cbEmpresa", resultados, "SEGObtenerEmpresasPorPais");


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
