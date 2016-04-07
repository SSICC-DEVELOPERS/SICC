/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Veg
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.cmn.negocio.print;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;

public class LPRPrint  implements PrinterSender{

	private LPRConfiguration configuration;

	public LPRPrint() {
	}

	public LPRPrint(ImpressionParameters parametros) {
		// modificado por incidencia BELC300010903
		/*
		ENTRADA: parametros: ImpressionParameters
		SALIDA:
		RESUMEN: Es el constructor de la clase. Crea un objeto de tipo LPRConfiguration y rellena sus atributos
		*/
		//1.- Creo un objeto de tipo LPRConfiguration y rellenos sus atributos ip y port y name usando los atributos atributo_3
		//, atributo_4 y printerName respectivamente del objeto ImpresionParameters que se nos pasa por cabecera
		this.configuration=new LPRConfiguration();
		//this.configuration.setIp(parametros.getAtributo_3());  BELC300015445
		//this.configuration.setPort(parametros.getAtributo_4());BELC300015445
		//this.configuration.setName(parametros.getPrinterName());BELC300015445
        
        
        this.configuration.setIp(parametros.getAtributo_1()); //BELC300015445
		this.configuration.setPort(parametros.getAtributo_2());
		this.configuration.setName(parametros.getAtributo_3());
			
	}

	public void print (byte[] buffer) throws MareException {

		/*Documentation
		ENTRADA: buffer : byte[] 
		SALIDA: 
		RESUMEN: Ejecuta el comando LPR necesario para mandar la información a la impresora. 
		*/
        UtilidadesLog.info("LPRPrint.print(): Entrada");
		
		//1.- Creo una instancia de tipo Impresor, pasandole como parámetros 'ip' y 'port'
		//del atributo configuration 
		Impresor impresor = new Impresor(this.configuration.getIp(),new Integer(this.configuration.getPort()),this.configuration.getName());
		//2.- Llamo al método imprimir() de la instancia creada. 
		//--Deberemos capturar excepciones de esta llamada.
 
    // hsanchez elimina el caracter de fin de página
    //byte[] bufferFinal = new byte[buffer.length + 1];
    //for (int i = 0; i < buffer.length; i++){
    //  bufferFinal[i] = buffer[i];    
    //}
    //bufferFinal[buffer.length] = '\f'; 

    UtilidadesLog.debug("Esto es lo que hay en el buffer para imprimir: "+new String(buffer));
    try{
			impresor.imprimir(buffer);
		}catch(Exception e){
			// Incidencia 10901
			UtilidadesLog.error("Exception en LPRPrint.print="+e.getMessage());
		}
        UtilidadesLog.info("LPRPrint.print(): Salida");
		
	}
}