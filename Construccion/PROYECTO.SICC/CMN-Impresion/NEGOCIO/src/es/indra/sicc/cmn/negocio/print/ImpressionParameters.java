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

package es.indra.sicc.cmn.negocio.print;

public class ImpressionParameters  {

	String atributo_1;
	String atributo_2;
	String atributo_3;
	String atributo_4;
	//String printerName;

	public ImpressionParameters() {
	}

	public String getAtributo_1() {
		return atributo_1;
	}

	public void setAtributo_1(String newAtributo_1) {
		atributo_1 = newAtributo_1;
	}

	public String getAtributo_2() {
		return atributo_2;
	}

	public void setAtributo_2(String newAtributo_2) {
		atributo_2 = newAtributo_2;
	}

	public String getAtributo_3() {
		return atributo_3;
	}

	public void setAtributo_3(String newAtributo_3) {
		atributo_3 = newAtributo_3;
	}

	public String getAtributo_4() {
		return atributo_4;
	}

	public void setAtributo_4(String newAtributo_4) {
		atributo_4 = newAtributo_4;
	}
/*    MODIFICADO POR BELC300015445
	public String getPrinterName() {
		return printerName;
	}

	  
      public void setPrinterName(String newPrinterName) {
		printerName = newPrinterName;
	}
    */
}