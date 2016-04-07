package es.indra.sicc.cmn.cargaInicial;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Es el DTO de salida de la parte del subsistema que se ejecuta en Mare</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class DTODatosPantalla extends MareDTO {
	private RecordSet[] datos; //El conjunto de resultados de las llamadas
	
	/**Constructor
	 * @param size El número de combos que se van a cargar
	 */
	public DTODatosPantalla(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("Se debe especificar un tamaño positivo mayor que 0");
		}
		datos = new RecordSet[size];
	}
	
	/** Se establecen los datos del combo indicado por index
	 * @param index
	 * @param datos
	 */
	public void asignarDatos(int index, RecordSet datos) {
		this.datos[index] = datos;		
	}
	
	/** Devuelve los datos de un combo
	 * @param index
	 * @return El RecordSet del combo indicado
	 */
	public RecordSet obtenerDatos(int index) {
		return datos[index];
	}
	
	/** Devuelve el número de combos que se esperan cargar
	 * @return
	 */
	public int obtenerNumeroElementos() {
		if (datos == null) {
			return 0;
		}
		return datos.length;
	}
}
