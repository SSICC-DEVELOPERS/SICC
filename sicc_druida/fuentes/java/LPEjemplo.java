//$Id: LPEjemplo.java,v 1.1 2009/12/03 18:36:42 pecbazalar Exp $

/**
 * Sistema:          Belcorp - SICC
 * Modulo:           MEN - Menu
 * Componente:       LPEliminarUsuarios
 * @version          2.0
 */ 

import java.io.*;


import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import java.util.Vector;
import java.io.*;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException; 

import es.indra.sicc.dtos.men.DTOEntradaBorrarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

public class LPEjemplo extends LPSICCBase {

	String accion           		= null;

	public LPEjemplo() {super();}
	
	public void inicio() throws Exception {
	  pagina("ejemplo");
	}
	
	public void ejecucion() throws Exception {
	setTrazaFichero();
	}	
}