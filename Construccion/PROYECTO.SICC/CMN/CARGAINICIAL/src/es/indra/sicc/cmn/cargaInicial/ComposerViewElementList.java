package es.indra.sicc.cmn.cargaInicial;

import java.util.ArrayList;
import java.util.List;

import es.indra.mare.common.dto.MareDTO;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Este dto es la entrada al subsistema de carga inicial</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class ComposerViewElementList extends MareDTO {
	private List list; //La lista de parametros para los combos que queremos cargar
	
	/**
	 * Constructor por defecto
	 */
	public ComposerViewElementList(){
		list = new ArrayList();
	}
	
	/**Añade el elemento que define la carga de un combo
	 * @param elem
	 */
	public void addViewElement(ComposerViewElement elem){
		list.add(elem);
	}
	
	/**Obtiene el elemento indicado, que representa la configuracion de un combo
	 * @param index
	 * @return La configuracion de un combo
	 */
	public ComposerViewElement getViewElement(int index) {
		if (index <0 || index >= list.size()) {
			throw new IllegalArgumentException("El indice especificado no existe"); 
		}
		return (ComposerViewElement)list.get(index);
	}
	
	/**Indica el número de combos que se van a cargar
	 * @return El número de combos
	 */
	public int getSize(){
		return list.size();
	}
}
