/*
 * Created on 27-oct-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MMGException extends Exception {
	
	/**
	 * El codigo de error asociado a la excepion
	 */
	protected int errorCode;
	
	/**
	 * Campo que representa inforamción extra sobre el error producido.
	 * Usado por ejemplo para indicar qua campo viola una clave única
	 */
	protected String extraInfo;

	public MMGException(int errorCode) {
		super();
		this.errorCode = errorCode;
		this.extraInfo = "";
	}
	
	public MMGException(int errorCode, String extraInfo){
		super();
		this.errorCode = errorCode;
		this.extraInfo = extraInfo;
	}
	
	/**
	 * @return
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return
	 */
	public String getExtraInfo() {
		return extraInfo;
	}

}
