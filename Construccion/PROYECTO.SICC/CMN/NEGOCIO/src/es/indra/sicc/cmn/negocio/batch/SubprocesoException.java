/*
 * Created on 19-may-04
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.sicc.cmn.negocio.batch;

import java.util.List;

import es.indra.mare.common.exception.MareException;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class SubprocesoException extends MareException {

  private List procesos;
   
  public SubprocesoException (List procesos) {
  	super("Algun/algunos subprocesos no terminaron correctamente, consultar lista.");
  	this.procesos = procesos;
  }
  
  public List getSubprocesosErroneos () {
  	return procesos;
  }
}
