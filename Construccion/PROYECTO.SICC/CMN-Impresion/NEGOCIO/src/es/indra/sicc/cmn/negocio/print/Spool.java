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
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.print.DAOPrinterSystem;
import es.indra.sicc.cmn.negocio.print.PrinterQueues;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.UtilidadesLog;

import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionContext;

public class Spool {  
	private Hashtable queque;
	private Long spoolID;
	private boolean active;
	private String serverID;
	SpoolManagerBean spoolManager;
  private SessionContext ctx = null;
  
	public Spool(){
		
	}//constructores
    //CAMBIO por incidencia 11572 	public Spool(Long spoolID, Vector config, String serverID, SpoolManager spoolManager)throws MareException{
    public Spool(Long spoolID, Vector config, String serverID, SpoolManagerBean spoolManager)throws MareException{
        UtilidadesLog.info("Spool.Spool(): Entrada");		
        this.spoolID=spoolID;
        this.active=Boolean.FALSE.booleanValue();
        this.serverID=serverID;
        //Creo una nueva instancia de una HashTable y se la asigno al atributo queues 
        Hashtable ht=new Hashtable();
        this.queque=ht;
        this.spoolManager=spoolManager;
        
        // Cambio por incidencia 11572 y	this.spoolManager=spoolManager;
        this.createQueues(this.spoolID,config ,serverID);
        
        UtilidadesLog.info("Spol.Spool(): Salida");
		}
	
    public SessionContext getCtx(){
      return this.ctx;
    }
  
    public void setCtx(SessionContext ctx){
      this.ctx = ctx;
    }

    public Long addPrintableDocument(DTODocumento documento, Long idSpool)throws MareException{
        UtilidadesLog.info("Spol.addPrintableDocument(): Entrada");
        UtilidadesLog.debug("idSpool= "+ idSpool);
        Long clave = null;
        try{
            //1.- Llamo al método getQueue pasandole el idTipoDocumento. Con esto obtendremos una instancia de un objeto
            //PrinterQueue.
            ///2.- Llamamos al método addPrintableDocuement del objeto recuperado. 
            PrinterQueues pq=this.getQueue(documento.getTipoDocumento());
            pq.setCtx(this.ctx);
            clave = pq.addPrintableDocument(documento);
    
            // por BELC300010802
        }catch(Exception e){
            UtilidadesLog.error("Spool: La excepcion es: ",e);
            UtilidadesLog.error("[][]Excepcion en Spool.addPrintableDocument[][]");
            throw new MareException();
        }
        UtilidadesLog.info("Spol.addPrintableDocument(): Salida");
        return clave;
    }

	
    public void activate() throws MareException{
        UtilidadesLog.info("Spol.activate(): Entrada");
        /*
        1.- Ponemos su atributo active a TRUE. 
        2.- Llamo al método isOpen(idSpool) 
        - Si devuelve FALSE entonces: 
        -Llamo al método flush
        */
        try{
            this.active=Boolean.TRUE.booleanValue();
            boolean estaAbierto=this.isOpen(this.spoolID);
            if(!estaAbierto){
                //this.flush();
                //*************** Cambio por la incidencia 15675 ********************************************************
                DAOPrinterSystem dao=new DAOPrinterSystem(this.ctx);
                dao.desactivateSpool(this.spoolID); //va a la tabla de Spool y lo desactiva pone (campo active= FALSE)
                //******************************************************************************************************
            }//if
        }catch(Exception e){
          UtilidadesLog.error("[][]Excepcion en Spool.activate[][]");
          throw new MareException();
        }
        UtilidadesLog.info("Spol.activate(): Salida");
		}//metodo activate
    
	//se añadio el parametro por incidencia 19633
    /*public void flush() throws MareException{
        UtilidadesLog.info("Spool.flush(): Entrada");
		try{
			DAOPrinterSystem daoActivo= new DAOPrinterSystem();
			RecordSet rs=null;
			if(this.queque!=null){
				if(!this.queque.isEmpty()){
                    Enumeration listaKeys = queque.keys();
					while (listaKeys.hasMoreElements()){
                        Long clave=(Long)listaKeys.nextElement();
                        //rs=daoActivo.checkBuffer(clave,false);
                        //cambio incidencia 19633
                        
                        //rs=daoActivo.checkBuffer(clave,((PrinterQueues)queque.get(clave)).secuenceFlag);
                        while (!(rs=daoActivo.checkBuffer(((PrinterQueues)queque.get(clave)).idQueue,((PrinterQueues)queque.get(clave)).secuenceFlag, ((PrinterQueues)queque.get(clave)).bufferSize)).esVacio()){
                            ((PrinterQueues)queque.get(clave)).flush(rs);
                        }
					}	//while
                    this.desactivate();
				}//is.Empty
			}//!=null
		}catch(Exception e){
				UtilidadesLog.error("[][]Excepcion en Spool.flush[][]",e);
				throw new MareException();
		}	
        UtilidadesLog.info("Spool.activate(): Salida");
	}//flush*/


        /*1.-Me creo una instancia del objeto DAOPrinterSistem daoActivo. 
        2.- Para todas las colas almacenadas en el atributo queue 
        - llamo al método del daoActivo.checkBuffe() pasandole 
        el idQueue de la cola pertinente segun la vuelta del bucle 
        y un FALSE. Nos devuelve un RecordSet 
        - llamo al método flush de la cola pertinente según la vuelta del bucle pasandole el RecordSet recuperado en el paso anterior. 
        3.-Llamo al método desactivate; 
		 * */
	public boolean getActive() throws MareException{
        UtilidadesLog.info("Spol.getActive(): Entrada");
			//1.- Devolver el contenido del atributo active.
        UtilidadesLog.info("Spol.getActive(): Salida");
		 return this.active;
		}//getAvtive


	public boolean isOpen(Long idSpool) throws MareException{
        UtilidadesLog.info("Spol.isOpen(): Entrada");
		/*Operation boolean isOpen (Long idSpool), in Class Spool
			1.-Creo una instancia del objeto DAOPrinterSystem 
			y llamo a su método isSpoolOpen(idSpool : Long). 
		 * */
		 try{
			DAOPrinterSystem dao=new DAOPrinterSystem();
			 boolean estado=dao.isSpoolOpen(idSpool);
            UtilidadesLog.info("Spol.isOpen(): Salida");
			 return estado;
		}catch(Exception e){
				UtilidadesLog.debug("[][]Excepcion en Spool.flush[][]");
				throw new MareException();
		}		 
	}//isOpen
	/*
		 Operation PrinterQueues getQueue (Long key), in Class Spool
		ENTRADA: key: Long 
		SALIDA: PrinterQueues 
		RESUMEN: Obtengo la cola almacenada en el atributo queues con la clave 'key'
	 * */
	
	 
	public PrinterQueues getQueue (Long key) throws MareException {
        UtilidadesLog.info("Spol.getQueue(): Entrada");
		UtilidadesLog.debug("key "+ key);
			PrinterQueues pk=new PrinterQueues();
		try{	
			pk=(PrinterQueues)this.queque.get(key);
		}catch(Exception e){
				UtilidadesLog.error("[][]Excepcion en Spool.getQueue[][]",e);
				throw new MareException();
		}		
        UtilidadesLog.info("Spol.getQueue(): Salida");
		return pk;

	}//a

	/*
	 * Operation  createQueues (Long spoolID, java.util.Vector config , Long  serverID), in Class Spool
		ENTRADA: spoolID : Long ,config : java.util.Vector, serverID: Long 
		RESUMEN: Crea todas las colas de impresión asociadas a ese spool a traves de la
		configuración. 
		1.- Recorro el Vector config que contiene objetos del tipo PrinterConfiguration.
		Por cada uno hacer: 
		- Creeamos una instancia del objeto DAOPrinterSystem daoActivo. 
		- Llamamos al método createQueues
		( lastSequence : Long, 0
		startOwner : java.sql.Timestamp,  la hora del sistema (System.currentTimeMillis)
		owner : String, ????,
		active : boolean,   true,
		idSpool : Long, spoolID
		idType: Long, 
		specificConf : PrinterSpecificConfiguration)el objeto PrinterConfiguration que corresponda a la vuelta del bucle.
		de daoActivo, pasandole los parámetros: ,,  true, spoolID, el objeto PrinterConfiguration que corresponda a la vuelta del bucle.
		Este método nos devolverá un Long que representa la clave primaria del nuevo registro. 
			 * */
	 // INCIDENCIA 11100 
	 public void createQueues  (Long spoolID, Vector config , String  serverID)throws MareException{
        UtilidadesLog.info("Spol.createQueues(): Entrada");
        DAOPrinterSystem daoActivo=null;
        if(config!=null){
            if(!config.isEmpty()){
                for(int i=0;i<config.size();i++){
                    //- Creeamos una instancia del objeto DAOPrinterSystem daoActivo. 
                    //- Llamamos al método createQueues
                    PrinterConfiguration pc=(PrinterConfiguration)config.get(i);
                    daoActivo=new DAOPrinterSystem();
                    Long pk=daoActivo.createQueue(spoolID,pc.getIdImpresoraVirtual()); //BEL 11123
                    PrinterQueues colaImpresion=new PrinterQueues(pk,pc,serverID);
                    // Modificado por la BELC300011627
                    // this.queque.put(pc.getDocumentType(),colaImpresion);
                    UtilidadesLog.debug("**** Metodo Spool.createQueues Informacion de PrinteQueues");
                    UtilidadesLog.debug("Spool  ="+spoolID);
                    UtilidadesLog.debug("PrinteQueues.idQueue ="+colaImpresion.idQueue);
                    UtilidadesLog.debug("PrinteQueues.bufferSize ="+colaImpresion.bufferSize);
                    UtilidadesLog.debug("PrinteQueues.serverID ="+colaImpresion.serverID);                        
                    this.queque.put(pc.getIdImpresoraVirtual(),colaImpresion);
                }//for
                //	- Creo una nueva instancia del Objeto PrinterQueue 
                //pasandole los siguientes parámetros: 
                //el Long devuelto en el paso anteriro y 
                //el objteto PrinterConfiguration que corresponda a la vuelta del bucle. 
                //- Añado la nueva instancia de PrinterQueue al Hash queue (atributo de la clase) 
                //usando como clave el documentType 
			  
      
            }//isEmpty
        }//!=null
			
        UtilidadesLog.info("Spol.createQueues(): Salida");
	}//activateSpool


	public void desactivate() throws MareException{
        UtilidadesLog.info("Spol.desactivate(): Entrada");
		try{
			this.active=Boolean.FALSE.booleanValue();
			//DAOPrinterSystem dao=new DAOPrinterSystem();//hablado con diseño TECNICO el 11/04/2005 me dice que lo cambia en el diseño
			//dao.deleteSpool(this.spoolID);
		    this.spoolManager.nextActivate(this.spoolID);
		}catch(Exception e){
				UtilidadesLog.error("[][]Excepcion en Spool.desactivate[][]",e);
				throw new MareException();
		}	
        UtilidadesLog.info("Spol.desactivate(): Salida");
	}
	/*
	  	Operation  desactivate (), in Class Spool
1.- Ponemos el atributo activa a FALSE. 
2.- Creamos una instancia del DAOPrinterSystem y llamamos a su método deleteSpool (spoolID). 
3.- Llamamos al método nextActivation() de la instancia almacenada en el atributo spoolManager.


		
	 */
}//Spool