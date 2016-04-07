import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPEliminaMontoMinimo extends LPSICCBase{


	public LPEliminaMontoMinimo()  {
		super();
	}  

	public void inicio() throws Exception {
					
	}

    public void ejecucion() throws Exception{
		
      try{
			this.rastreo();

			conectorAction("LPMantieneMontoMinimo");
			conectorActionParametro("accion","muestraBorrado");				 
			conectorActionParametro("casoDeUso","elimina");		

		} catch(Exception e){
             lanzarPaginaError(e);
        }
         
	 }
		 
}
