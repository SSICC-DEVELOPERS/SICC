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
 /*
    INDRA/CAR/PROY
    $Id: LPBorrarLotesTrabajo.java,v 1.1 2009/12/03 18:41:27 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            CCC
 * Submódulo:         
 * Componente:        LP
 * Fecha:             15/03/2004
 */ 



import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Vector;



public class LPBorrarLotesTrabajo extends LPSICCBase {

   private String accion    	= null;
   private String idioma    	= null;
   private String pais     		= null;  	
   private String formatoFechaPais = null;
   
	
   public LPBorrarLotesTrabajo() {
		super();
	}

	public void inicio() throws Exception {  
		pagina("contenido_lote_trabajo_borrar");
		this.getFormatosValidaciones();
	}
  
  public void ejecucion() throws Exception {
    
    setTrazaFichero();
    accion    				= conectorParametroLimpia("accion","", true);
	idioma     				= UtilidadesSession.getIdioma(this).toString();	
	pais       				= UtilidadesSession.getPais(this).toString();
	formatoFechaPais        = UtilidadesSession.getFormatoFecha(this);
	
    try  {

			rastreo();
			traza("accion :" + accion);
			cargarMenuSecundario();
			asignarAtributo("VAR","hFormatoFechaPais","valor",UtilidadesSession.getFormatoFecha(this));
			asignarAtributo("VAR","accion","valor",accion);
			asignarAtributo("VAR","hPais","valor",pais);
			asignarAtributo("VAR","hIdioma","valor",idioma);

			
		if (accion.equals("")){
				 cargaInicalCombos(); 
		}
	}
	catch ( Exception e )  {
		traza("pincho la lp principal");
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        e.printStackTrace(out);
        traza("EL STACK ES COMO SIGUE : " +  pila.toString());
    	e.printStackTrace(); 
		e.getMessage();
		lanzarPaginaError(e);
    }

  }

  private void cargarMenuSecundario() throws Exception { 
  traza("accion >>>>" + accion);
      if (accion.equals("")) {
        getConfiguracionMenu("LPBorrarLotesTrabajo","");
        asignarAtributoPagina("cod","0346");
      }
 } 

  private void cargaInicalCombos() throws Exception{
		ComposerViewElementList cv = crearParametrosEntrada();
		
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("** 1 ** ");
		conector.ejecucion();
		traza("** 2 ** ");
		DruidaConector resultados = conector.getConector();
		asignar("COMBO", "comboBanco", resultados, "CCCObtieneBancos");

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception{
		ComposerViewElementList lista = new ComposerViewElementList(); 

		//Primer combo
		ComposerViewElement cmb1 = new ComposerViewElement();
		cmb1.setIDBusiness("CCCObtieneBancos");

		DTOBelcorp dto =  new DTOBelcorp();
		traza("** pais ** " + pais);
		traza("** idioma ** " + idioma);
    	dto.setOidPais(new Long(pais));
		dto.setOidIdioma(new Long(idioma));
		
		cmb1.setDTOE(dto);	
		lista.addViewElement(cmb1);
		traza("** 3  *** lista " + lista);
		return lista;

	
	}

}
