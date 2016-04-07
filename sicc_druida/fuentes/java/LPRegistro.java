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

//import LPSICCBase;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.sql.Date;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.druida.DruidaConector;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.edu.DTOParticipante;

public abstract class LPRegistro extends LPSICCBase {
	
	private String accion = null;
    private String casoUso = null;   
    private Long idioma;
    private Long pais;   
          
    public LPRegistro() {
    	super();
    }

    public void inicio() throws Exception {
                    
    }

    public void ejecucion() throws Exception {
    	setTrazaFichero();
        try  {         
        	traza("LPRegistro Entrada");
        	
        	traza("LPRegistro Salida");
		}catch ( Exception e )  {
        	e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }              
    }
	
	protected void registro(DTORegistrarAsistencia dtoe) throws Exception {
		//Registra los asistentes a un curso y tramita el pedido del regalo asociado al curso si lo hubiere.
		traza("LPRegistro registro Entrada");
		try{
			traza("Paco (en LPRegistro)- DTORegistrarAsistencia.idioma: " + dtoe.getOidIdioma());
			traza("Paco (en LPRegistro)- DTORegistrarAsistencia.pais: " + dtoe.getOidPais());
			traza("Paco (en LPRegistro) - DTORegistrarAsistencia.operacion: " + dtoe.getOperacion());
			traza("Paco (en LPRegistro) - DTORegistrarAsistencia.oidCurso: " + dtoe.getOidCurso());
			for(int k=0; k< dtoe.getParticipantes().length; k++){
				//tener cuidado, los participntes pueden estar en null
				traza("Paco (en LPRegistro) - DTORegistrarAsistencia dtoP[" + "0" + "].oidParticipante: " + dtoe.getParticipantes()[0].getOidParticipante());
				traza("Paco (en LPRegistro) - DTORegistrarAsistencia dtoP[" + "0" + "].oidCliente: " + dtoe.getParticipantes()[0].getOidCliente());
				traza("Paco (en LPRegistro) - DTORegistrarAsistencia dtoP[" + "0" + "].oidTipoCliente: " + dtoe.getParticipantes()[0].getOidTipoCliente());
				traza("Paco (en LPRegistro) - DTORegistrarAsistencia dtoP[" + "0" + "].FecAsistencia: " + dtoe.getParticipantes()[0].getFecAsistencia());
				
			}		
			 Vector paramConector = new Vector();
			 paramConector.add(dtoe);
             paramConector.add(new MareBusinessID("EDURegistrarAsistencia"));
             traza("Antes de Conectar ConectorRegistrarAsistencia");
             DruidaConector conector = conectar("ConectorRegistrarAsistencia", paramConector);							
             traza("Despues de Conectar ConectorRegistrarAsistencia"); 
		
		}catch ( Exception e )  {
        	e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
        }                  	
		traza("LPRegistro registro Salida");
		
	}          
          
	private void logStackTrace(Throwable e) throws Exception {
    	traza("Se produjo la excepcion: " + e.getMessage());		
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(baos);
    	e.printStackTrace(ps);		
    	traza("Stack Trace: " + baos.toString());
    }
	
}