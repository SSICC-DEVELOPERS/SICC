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

/*
    INDRA/CAR/PROY
    $Id: DTCargarFormulariosTipoSolicitud.java,v 1.1 2009/12/03 18:36:24 pecbazalar Exp $
    DESC
*/
import java.util.Vector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.CodigosModulos;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DTCargarFormulariosTipoSolicitud extends DruidaTransactionComun {
    
         // Definicion del constructor
         public DTCargarFormulariosTipoSolicitud(){
                  super();
         }

          // Definicion del metodo ejecucion
         public void ejecucion() throws Exception {
                  DruidaConector conectorTerminal=null;		
         try{
              traza("***Entrada - DTCargarFormulariosTipoSolicitud - ejecucion");

              //Creamos un DTOOID con el parametro oid (además metemos el idioma y el pais). 
			  //Llamamos al ConectorObtenerFormulariosTipoSolicitud pasandole el dto 
			  //y el idBusiness: "FACCargaFormulariosTiposSolicitud"
				
              String oid = (String)getEntrada("oid");
              
              traza("*** oid :"+oid);         
                       
              DTOOID dtoEntrada = new DTOOID();
              //Obtenemos el pais y el idioma de la sesion
              UtilidadesSession sesion = new UtilidadesSession();
              Long pais = sesion.getPais(this); 
              Long idioma = sesion.getIdioma(this);
        	  if(oid != null && !oid.equals("")) {
              	dtoEntrada.setOid(new Long(oid));
              }
              dtoEntrada.setOidPais(pais);
              dtoEntrada.setOidIdioma(idioma);
                            
              traza("***dto creado");            
                            
              //- Se crea idNegocio "FACCargaFormulariosTiposSolicitud" 
              MareBusinessID idBussiness = new MareBusinessID("FACCargaFormulariosTiposSolicitud");
       
              //Almacenamos los parametros de entrada
              Vector paramEntrada = new Vector();
              paramEntrada.addElement(dtoEntrada);
              paramEntrada.addElement(idBussiness);
      
              traza("Llamo a conectar");
       
              //- Se invoca al ConectorObtenerFormulariosTipoSolicitud 
              DruidaConector conector = conectar("ConectorObtenerFormulariosTipoSolicitud", paramEntrada);
       
              traza("Salgo de conectar");
              
              DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
              
              RecordSet rs = dtoSalida.getResultado();
			  Vector cols = rs.getColumnIdentifiers();
			  DruidaConector conectorTemporal = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rs, cols);
       		
              conectorTerminal = conectorTemporal;
          
              }catch(Exception e){
                BelcorpError belcorpError = new BelcorpError();
            	DTOError dtoError = belcorpError.obtenerError(e,  UtilidadesSession.getIdioma_ISO( this ) ,  "");                    
             	traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
             	conectorTerminal=this.crearConectorResultado(dtoError.getDescripcionError());
         }
         traza("***Salida - DTCargarFormulariosTipoSolicitud - ejecucion");
         this.setConector(conectorTerminal);
         }
         protected void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());

         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);
                      
         traza("Stack Trace: " + baos.toString());
    }
}

