/*
 * Created on 19-may-04
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.sicc.cmn.negocio.batch.util;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.util.UtilidadesLog;

/**
 * @author fcuenca
 *
 */
public class StartUp {

	public static void main(String[] args) throws MareException {
		UtilidadesLog.debug("Recuperando el subsistema Batch de anteriores caidas...");
		
		MONBatch mon = new MONBatch();
		int procesosRecuperados;
		if (args.length != 1) {
		  procesosRecuperados = mon.recuperarCaida();
		} else {
			procesosRecuperados = mon.recuperarCaida(args[0]);
		}
		
		if (procesosRecuperados != 0)
		  UtilidadesLog.debug("  " + procesosRecuperados + " procesos recuperados.");
		else
		  UtilidadesLog.debug("No hay procesos para recuperar.");
	}
}
