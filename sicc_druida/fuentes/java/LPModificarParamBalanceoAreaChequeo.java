/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class LPModificarParamBalanceoAreaChequeo extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;

	public LPModificarParamBalanceoAreaChequeo() {
		super();
	}


	public void inicio() throws Exception {


	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPModificarParamBalanceoAreaChequeo  Entrada");
		conectorAction("LPMantenerParamBalanceoAreaChequeo");
		conectorActionParametro("accion","");
		conectorActionParametro("opcionMenu","modificar");
		traza("LPModificarParamBalanceoAreaChequeo Salida");
	}
}
