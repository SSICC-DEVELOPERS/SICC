
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaTransaction;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOIDs;
import java.io.*;


/** 
 * <p>Title: SICC</p>
 * <p>Description: Esta clase se utiliza para la eliminacion de registros
 *  mediante el subsitema de eliminacion.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class DTEliminacion extends DruidaTransactionComun {	
	
	public static final String SEPARADOR_OIDS = ",";
	public static final String CONECTOR_ELIMINACION = "ConectorEliminar";
	//public static boolean borrado = false;	
		
	/* 
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception {
		String parametros = (String) getEntrada("parametros");
		String idBusiness = (String) getEntrada("idBusiness");
		
		String mensajeResultado = "";
			
		DTOOIDs oids = new DTOOIDs();
		oids.setOids(obtenerOIDs(parametros));

		try {
			realizarEliminacion(idBusiness, CONECTOR_ELIMINACION, oids);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			traza("------\r\n" + sw.toString() + "------\r\n");
			e.printStackTrace();
			mensajeResultado = obtenerMensajeError(e);
		}
	
		//Devolvemos el resultado de la operación		
		DruidaConector conector = crearConectorResultado(mensajeResultado);
		setConector(conector);		
	}
	
	/** Realiza la llamada a servidor para realizar la operacion con los parametros indicado
	 * @param idBusiness
	 * @param conector
	 * @param dto
	 * @throws Exception
	 */
	private void realizarEliminacion(String idBusiness, String conector, DTOOIDs dto)
		throws Exception{
		Vector vParametros = new Vector();
		vParametros.add(dto);
		vParametros.add(new MareBusinessID(idBusiness));    
		conectar(conector, vParametros);
		//borrado = true;
	}

	/** Devuelve la lista de oids que viene en la cadena de parametros
	 * @param parametros
	 * @return
	 */
	private Long[] obtenerOIDs(String parametros) {
		Long[] resultado = null;
		StringTokenizer st = new StringTokenizer(parametros, SEPARADOR_OIDS);
		
    	int numElem = st.countTokens();
		resultado = new Long[numElem];
		String cadena = null;
		for (int i=0; i<numElem; i++) {
			try {
				cadena = st.nextToken();
				resultado[i] = Long.valueOf(cadena);				
			} catch (NumberFormatException e) {
				System.err.println("El oid: " + cadena 
						+ " no se puede eliminar porque no es un número");
			}
		}
		return resultado;
	}

 }//fin clase