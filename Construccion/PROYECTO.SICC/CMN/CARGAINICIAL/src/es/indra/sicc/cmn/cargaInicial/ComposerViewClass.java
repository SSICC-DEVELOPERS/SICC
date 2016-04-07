package es.indra.sicc.cmn.cargaInicial;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.util.DTOSalida;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Esta clase es la parte del subsistema que se ejecuta en Mare</p>
 * <p>Actúa como business facade, llamando a las operaciones indicadas y crea un 
 *   "composite view" con los resultados de las llamadas</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class ComposerViewClass {
	public static final String BUSINESS_FACADE = "mare.mln.BusinessFacade";
	public static final String MARE_RESULT_NAME = "resultado";

	/** Ejecuta las llamadas a las operaciones de negocio indicadas
	 * @param lista
	 * @return
	 */
	public DTODatosPantalla ejecutar(ComposerViewElementList lista) {
		List resultados = new ArrayList(); //Aqui vamos guardando los recordsets
		
		BusinessFacade fachada = obtenerFachada();
		if (fachada == null) {
			//No podemos hacer las llamadas a los MONs
			return null;
		}

		ComposerViewElement cv = null;
		IMareDTO dto = null;
		MareBusinessID id = null;
		IMareDTO resultadoOperacion = null;
		//Procesamos cada una de las peticiones
		for (int i=0; i<lista.getSize(); i++) {
			cv = lista.getViewElement(i);
			dto = cv.getDTOE();
			id = new MareBusinessID(cv.getIDBusiness());
			try {
				resultadoOperacion = fachada.execute(dto, id);
			} catch (MareException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			resultados.add(resultadoOperacion.getProperty(MARE_RESULT_NAME));
		}
		return adaptarResultados(resultados);
	}
	
	/** Prepara el dto de salida con los resultados de las llamadas
	 * @param resultados
	 * @return
	 */
	protected DTODatosPantalla adaptarResultados(List resultados) {
		if (resultados == null) {
			return new DTODatosPantalla(0);
		}
		
		int numResultados = resultados.size();
		DTODatosPantalla dto = new DTODatosPantalla(numResultados);
		
		RecordSet rs = null;
		Object objeto = null;
		for (int i=0; i<numResultados; i++){
			objeto = resultados.get(i);
			//Obtenemos el recordset que hay en el elemento de la lista (si lo hay)
			if (objeto == null) {
				rs = null;
			} else if (objeto instanceof RecordSet){
				rs = (RecordSet)objeto;
			} else if (objeto instanceof DTOSalida){
				rs = ((DTOSalida)objeto).getResultado();
			} else {
				rs = null;
			}						
			dto.asignarDatos(i, rs);
		}		
		return dto;
	}
	
	/** Obtiene la fachade de Mare, a través de la cuál se llamarán a las operaciones 
	 * de negocio para obtener los datos.
	 * @return
	 */
	protected BusinessFacade obtenerFachada(){
		BusinessFacade bf = null;
		try {
			Context cx= new InitialContext();
			Object objref = cx.lookup(BUSINESS_FACADE);
			BusinessFacadeHome home = (BusinessFacadeHome)PortableRemoteObject.narrow(objref, BusinessFacadeHome.class);
			return home.create();	
		} catch (Exception e){
		}
		return bf;
	}
}
