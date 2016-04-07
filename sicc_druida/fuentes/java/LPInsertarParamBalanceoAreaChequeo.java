/**
* Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* Espa�a
*
* Privado y Confidencial.
* La informaci�n contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permiti�ndose
* la distribuci�n de este c�digo sin permiso expreso.
*/
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class LPInsertarParamBalanceoAreaChequeo extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;

	public LPInsertarParamBalanceoAreaChequeo() {
		super();
	}


	public void inicio() throws Exception {


	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPInsertarParamBalanceoAreaChequeo  Entrada");
		conectorAction("LPMantenerParamBalanceoAreaChequeo");
		conectorActionParametro("accion","");
		conectorActionParametro("opcionMenu","insertar");
		traza("LPInsertarParamBalanceoAreaChequeo Salida");
	}
}

