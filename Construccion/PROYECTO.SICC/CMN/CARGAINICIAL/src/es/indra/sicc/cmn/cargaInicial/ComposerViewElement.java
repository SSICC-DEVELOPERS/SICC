package es.indra.sicc.cmn.cargaInicial;

import es.indra.sicc.util.DTOBelcorp;
import java.io.Serializable;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Contiene la definición de la carga de un combo</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class ComposerViewElement implements Serializable{
	private String IDBusiness;    //La operación de negocio que proporciona los datos
	private DTOBelcorp DTOE;	  //El dto de entrada al MON
	private byte posOID; 		  //La posición del OID en el RecordSet (por defecto 0)
	private byte posDesc;		  //La posición de la descripción en el RecordSet (por defecto 1)
	
	/**
	 * El constructor inicializa los parametros opcionales
	 */
	public ComposerViewElement(){
		posOID = 0;
		posDesc = 1;
	}
	
	/**
	 * @return 
	 */
	public DTOBelcorp getDTOE() {
		return DTOE;
	}

	/**
	 * @return 
	 */
	public String getIDBusiness() {
		return IDBusiness;
	}

	/**
	 * @return
	 */
	public byte getPosDesc() {
		return posDesc;
	}

	/**
	 * @return
	 */
	public byte getPosOID() {
		return posOID;
	}

	/**
	 * @param 
	 */
	public void setDTOE(DTOBelcorp belcorp) {
		DTOE = belcorp;
	}

	/**
	 * @param string
	 */
	public void setIDBusiness(String string) {
		IDBusiness = string;
	}

	/**
	 * @param b
	 */
	public void setPosDesc(byte b) {
		posDesc = b;
	}

	/**
	 * @param b
	 */
	public void setPosOID(byte b) {
		posOID = b;
	}

}
