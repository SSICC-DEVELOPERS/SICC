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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.DAOPrinterSystem;
import es.indra.sicc.cmn.negocio.print.PrinterConfiguration;
import es.indra.sicc.cmn.negocio.print.PrinterSender;
import es.indra.sicc.cmn.negocio.print.SpoolManager;
import es.indra.sicc.cmn.negocio.print.SpoolManagerHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class PrinterQueues  {
	public Long idQueue;
	public PrinterSender printer;
	public Long bufferSize=null;
	public boolean secuenceFlag; //Nos han dicho que usemos tipos primitivos
	public String serverID;
  public SessionContext ctx = null;
	// Eliminado por la BELC300011627
	// private Long documentType;
     //*****************MODIFICADO POR BELC300018607 26/05/2005************************
    public Long technology= null;


	public PrinterQueues() {
	}
	// Incidencia BELC300010832
	 public  PrinterQueues(Long  idQueue, PrinterConfiguration config, String serverID){
		 //Es el contructor de la clase PrinterQueue. 
		//1.- Hay que rellenar los siguientes atributos de la clase: 
		//idQueue, secuenceFlag, printer, serverID, documentType. 
		this.idQueue = idQueue;
		this.serverID = serverID;
		// en config esta las demas propiedades
		this.secuenceFlag = config.isSecuenceFlag();
		// Eliminado por la BELC300011627
		// this.documentType = config.getDocumentType();
        this.bufferSize=config.getBufferSize();
		this.printer = config.getPrintType();//BELC300011836
         //*****************MODIFICADO POR BELC300018607 26/05/2005************************
         this.technology= config.getTecnologiaImpresion();
	}

	public SessionContext getCtx(){
    return this.ctx;
  }
  
  public void setCtx(SessionContext ctx){
    this.ctx = ctx;
  }

  
	public void flush(RecordSet documentos) throws MareException{
		// Modificado por incidencia BELC300010820
		/*
		ENTRADAS: documentos: RecordSet
		SALIDAS: 
		RESUMEN:  El objetivo de este método es imprimir todos los documentos que queden en esa cola.
		*/
        UtilidadesLog.info("PrinterQueues.flush(): Entrada");
		//1.- Llamo al método printDocument(TRUE, documentos).
		this.printDocuments(documentos);
		
        UtilidadesLog.info("PrinterQueues.flush(): Salida");
	}


	protected void printDocuments(RecordSet documentos) throws MareException{//se le pasa boolean

		/*Documentation
		ENTRADA: completo: boolean, documentos RecordSet 
		SALIDA: 
		RESUMEN: El objetivo de este método es mandar a imprimir una serie de documentos. 
		*/
        
/*
        INCIDENCIA BELC300013117
        ENTRADA: documentos RecordSet 
        SALIDA:
        RESUMEN: El objetivo de este método es mandar a imprimir una serie de documentos.
                 
        1. - por cada registro del RecordSet documentos hago una llamada al método print() de la instancia
        almacenada en el atributo printer, pasandole como parámetro el contenido de la posicion
        "BUFFER" del registro.
        2.- creo una instancia del objeto DAOPrinterSystem y llamo a su método updatePrinterDocuments()
        pasandole el RecordSet
 */
        byte[] documentoFinal= null;
        UtilidadesLog.info("PrinterQueues.printDocuments(): Entrada");
        UtilidadesLog.debug("*** Metodo DATOS DE ENTRADA  documentos =  "+documentos);
        
        //UtilidadesLog.debug(documentos);
		//1.- Si completo==FALSE entonces. 
		//if(completo == false){ //incidencia BELC300013117  me quitan el parametro de entrada, por lo que he de quitar esta comprobacion
			if(!documentos.esVacio()){
				for(int i=0; i<documentos.getRowCount();i++){
				//- por cada registro del RecordSet documentos hago una llamada al 
				// método print() de la instancia almacenada en el atributo printer, 
				// pasandole como parámetro el contenido de la posicion "BUFFER" del registro. 
                 // Recogemos el valor mediante el entity IMPPrintableDocument debido a que 
                // la clase RecordSet no lo recoge correctamente por ser un dato de tipo
                // Blob.
                        IMPPrintableDocumentLocal local = null;
                         try{
                             IMPPrintableDocumentLocalHome home = new IMPPrintableDocumentLocalHome();
                             local = home.findByPrimaryKey(new Long(((BigDecimal)documentos.getValueAt(i,"OID_DOCU_IMPR")).longValue()));
                            
                             byte[] arrayBytes = local.getBuffer();
            //*****************MODIFICADO POR BELC300018607 26/05/2005************************
                             String cadenaBytes="";
                             if (arrayBytes !=null)
                                cadenaBytes= new String(arrayBytes);
                             /*setValueAt aValue nuevo valor de la celda.rowIndex fila de la celda. columnIndex columna de la celda.
                             * */
                             //documentos.setValueAt(cadenaBytes,i,3);//3 es el campo VAL_BUFF
                            UtilidadesLog.debug("La posicion 5 tiene: "+documentos.getColumnName(5));
                            documentos.setValueAt(cadenaBytes,i,5);
                    
                             //this.printer.print(arrayBytes); LLamada Antigua
                             
                        } catch (NoResultException e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("Error: " + e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        } catch (PersistenceException e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("Error: " + e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                     /*      
                            RecordSet no recoge correctamente los valores BLOB
                            this.printer.print(blob.getBytes());
                            //Creamos una variable de tipo BLOB y le asignamos el valor del campo
                            //VAL_BUFF
                             oracle.sql.BLOB blob = null;
                             blob=((oracle.sql.BLOB)documentos.getValueAt(i,"VAL_BUFF"));
                             //convertimos a byte[] y mandamos a imprimir
                             byte[] array = blob.getBytes();                 
                             this.printer.print(blob.getBytes());
                     */        
                    
                }
            //*****************MODIFICADO POR BELC300018607 26/05/2005************************
                FactoriaFormateadores factoria= new FactoriaFormateadores();
                documentoFinal = factoria.formater(this.technology,documentos);//cambia esto..
                this.printer.print(documentoFinal); 
            //*****************MODIFICADO POR BELC300018607 26/05/2005************************
              //- creo una instancia del objeto DAOPrinterSystem y llamo a su 
              //método updatePrinterDocuments() pasandole el RecordSet 
              DAOPrinterSystem dao = new DAOPrinterSystem();
              dao.updatePrinterDocuments(documentos);
                
                /*//añadido por incidencia 19633
                UtilidadesLog.debug("Entra cambios incidencia 19633");
                if (this.secuenceFlag)
                {
                    if (documentos.getValueAt(documentos.getRowCount()-1,"NUM_SECU")!=null)
                    {
                        UtilidadesLog.debug("Tamaño documentos es: "+documentos.getRowCount());
                        UtilidadesLog.debug("Documentos es: "+documentos);
                        Long oidCola=new Long(((BigDecimal)documentos.getValueAt(0,"GCOL_OID_COLA")).longValue());
                        UtilidadesLog.debug("El oid de la cola es: "+oidCola);
                        Long ultimaSecuencia=new Long(((BigDecimal)documentos.getValueAt(documentos.getRowCount()-1,"NUM_SECU")).longValue());
                        UtilidadesLog.debug("La ultima secuencia es: "+ultimaSecuencia);
                        dao.updatePrinterQueues(oidCola, ultimaSecuencia);
                    }else
                    {
                        //lanzamos una exception
                        UtilidadesLog.error("La cola esta preparada para la secuenciación pero los documentos no poseen número de secuencia");
                        throw new MareException("La cola esta preparada para la secuenciación pero los documentos no poseen número de secuencia");
                    }
                }*/
                
			}
		//}incidencia BELC300013117
        UtilidadesLog.info("PrinterQueues.printDocuments(): Salida");
	}
    public Long addPrintableDocument(DTODocumento  docuentoImprimible) throws MareException{
        UtilidadesLog.info("PrinterQueues.addPrintableDocument(): Entrada");
        //Si this.secuenceFlag es true y getNumSecuencia==null lanzamos excepcion
         RecordSet rs=null;
         Long clave = null;
        if (this.secuenceFlag && docuentoImprimible.getNumSecuencia()==null) 
        {
            //lanzamos una exception
            UtilidadesLog.error("La cola esta preparada para secuenciar y el documento añadido no tiene numero de secuencia");
            throw new MareException("La cola esta preparada para secuenciar y el documento añadido no tiene numero de secuencia");
        }
        IMPPrintableDocumentLocal local=null;
		//RESUMEN: Este método inserta un PrintableDocument en la cola
		Long numSecuencia=((docuentoImprimible.getNumSecuencia()!=null)?new Long(docuentoImprimible.getNumSecuencia().intValue()):null);
       
		try{
            //1.-Creamos una instancia del objeto DAOPrinterSystem.
            //DAOPrinterSystem daoPrinter = new DAOPrinterSystem();
        
            //2.- Llamamos al metodo del dao 
            //addDocument(numSecuencia:Long, buffer: byte[] , ghostDoc: boolean), 
            //pasandole los parámetros: DTODocumento.numSecuencia, DTODocumento.documento y FALSE.
            //Este método nos devuelve un Long que será la clave de la inserción.
            //Long clave=daoPrinter.addDocument(this.idQueue,numSecuencia,docuentoImprimible.getDocumentoByte(),Boolean.FALSE.booleanValue());
            
            //por la incidencia BELC300011898, se modifican el punto 1 y 2 para llamar al ejb en vez de al dao.
            
            PrinterSystemEJBLocalHome printerSystemEJBLocalHome = getPrinterSystemEJBLocalHome();
            PrinterSystemEJBLocal printerSystemEJBLocal = printerSystemEJBLocalHome.create();
            clave = printerSystemEJBLocal.addDocument(this.idQueue,numSecuencia,docuentoImprimible.getDocumentoByte(),Boolean.FALSE.booleanValue());            
            /*if (docuentoImprimible.getOidTipoDocumentoLegal()!=null){
                actualizarSecuenciaDocumentoImpresion(clave, docuentoImprimible.getOidConsolidado() , docuentoImprimible.getOidTipoDocumentoLegal(), docuentoImprimible.getSpool());
            }*/
            UtilidadesLog.debug("*** Metodo PrinterQueues.addPrintableDocument: clave  "+clave);
            UtilidadesLog.debug("Clave "+clave);
            
            //JPB COMENTAR DESDE AQUI EN ADELANTEEEEEEEEEEEEE
            /*rs=printerSystemEJBLocal.validatePrint(this);
            UtilidadesLog.debug("El recordset que recibo es: "+rs);
            if (rs!=null){
                if (!rs.esVacio())
                {
                    DAOPrinterSystem dao = new DAOPrinterSystem();
                    if (this.secuenceFlag)
                    {
                        //prueba transaccionalidad
                        UtilidadesLog.debug("Entra prueba transaccionalidad");
                        if (rs.getValueAt(rs.getRowCount()-1,"NUM_SECU")!=null)
                        {
                            UtilidadesLog.debug("Tamaño documentos es: "+rs.getRowCount());
                            UtilidadesLog.debug("Documentos es: "+rs);
                            Long oidCola=new Long(((BigDecimal)rs.getValueAt(0,"GCOL_OID_COLA")).longValue());
                            UtilidadesLog.debug("El oid de la cola es: "+oidCola);
                            Long ultimaSecuencia=new Long(((BigDecimal)rs.getValueAt(rs.getRowCount()-1,"NUM_SECU")).longValue());
                            UtilidadesLog.debug("La ultima secuencia es: "+ultimaSecuencia);
                            dao.updatePrinterQueues(oidCola, ultimaSecuencia);
                        }else
                        {
                            //lanzamos una exception
                            UtilidadesLog.error("La cola esta preparada para la secuenciación pero los documentos no poseen número de secuencia");
                            throw new MareException("La cola esta preparada para la secuenciación pero los documentos no poseen número de secuencia");
                        }
                    }
                }
            }*/
            
            UtilidadesLog.debug("Despues de llamar a printerSystemEJBLocal");
           
            //ELiminado por La incidencia BEL11659 el hacer el create de PrintableDocument (punto 3)
                   
                    //	4.- Llamamos al método validatePrintConditions() 
                    //this.validatePrintConditions();
		}catch(Exception e){
            UtilidadesLog.debug("La excepcion es: "+e.getMessage());
			throw new MareException("PrinterQueues.addPrintableDocument",e);
		}
        UtilidadesLog.info("PrinterQueues.addPrintableDocument(): Salida");
        return clave;
	}
    
        
    //por incidencia 19633 devuelve un recordset
	public RecordSet validatePrintConditions()throws MareException{
        UtilidadesLog.info("PrinterQueues.validatePrintConditions(): Entrada");
		//RESUMEN: El objetivo de este método es chequear si se cumplen las condiciones 
		//para poder mandar imprimir
        
    
		//1.- Llamamos al método getExclusiveAccess().
		this.getExclusiveAccess();

		//2..- Creo una instancia de DAOPrinterSystem y llamo a su método 
		//checkActivo(idQueue). Si nos devuelve TRUE entonces 
		DAOPrinterSystem daoPrinterSystem = new DAOPrinterSystem();
		Boolean esActivo = null;
         UtilidadesLog.debug("***  PrinterQueues.validatePrintConditions: ANTES de esActivo=daoPrinterSystem.checkActive(idQueue) *** ");
		esActivo = daoPrinterSystem.checkActive(idQueue);
        UtilidadesLog.debug("***  PrinterQueues.validatePrintConditions: DESPUES de esActivo=daoPrinterSystem.checkActive(idQueue) *** ");
        UtilidadesLog.debug("***  PrinterQueues.validatePrintConditions:  *** esActivo= " +esActivo);
        UtilidadesLog.debug("***  PrinterQueues.validatePrintConditions:  *** this.secuenceFlag = " +this.secuenceFlag);
        //RecordSet rs=null;
        Boolean llamaPrintDocuments=new Boolean(false);
        RecordSet resultadoCheck = null;
		if(esActivo.booleanValue()){

			//2.1.- Miro el flag de secuenciacion 
			//-Si es FALSE entonces: 
            UtilidadesLog.debug("El indicador secuenceFlag es: "+this.secuenceFlag);
			if(this.secuenceFlag == false){

				//-Llamo al método checkBuffer(), si el recordSet que nos devuelve 
				//no está vacío llamo al método printDocuments pasandole el RecordSet
				//resultadoCheck = this.checkBuffer(this.bufferSize);
                UtilidadesLog.debug("***  PQ.validatePrintConditions DESPUES de  resultadoCheck = this.checkBuffer()");
                UtilidadesLog.debug("***  PQ.validatePrintConditions resultadoCheck = " +resultadoCheck );
                UtilidadesLog.debug("***  PQ.validatePrintConditions resultadoCheck.getRowCount() = " +resultadoCheck.getRowCount());
                
				if(!resultadoCheck.esVacio()){
					this.printDocuments(resultadoCheck);//de momento el boolena que se le pasa se pone a false
                    //añadido por incidencia 19633
                    llamaPrintDocuments=new Boolean(true);
				}
			}else //añadido por incidencia 19633
            {
                //- Si es TRUE
                //Llamo al método checkBufferSequence(idQueue, bufferSize), 
                //si el recordSet que nos devuelve
                //tiene un tamaño == bufferSize entonces llamo al método printDocuments 
                //pasandole los registros
                //del RecordSet que tengan su campo GCOL_OID_COLA (indicador de documento fantasma) a
                //false.
                UtilidadesLog.debug("***  PrinterQueues.validatePrintConditions. El indicador secuenceFlag es TRUE");
                resultadoCheck = daoPrinterSystem.checkBufferSequence (this.idQueue, this.bufferSize);
                if (!resultadoCheck.esVacio()) 
                {
                    UtilidadesLog.debug("Resultado Check no es vacio");
                    UtilidadesLog.debug("El buffer es: "+this.bufferSize);
                     UtilidadesLog.debug("Tamaño recordset es: "+resultadoCheck.getRowCount());
        
                    if (new Long(resultadoCheck.getRowCount()).longValue()==this.bufferSize.longValue()){
                        //JPB TOCAR ACA
                        this.printDocuments(resultadoCheck);
                        llamaPrintDocuments=new Boolean(true);
                    }
                }
            }
			//3.- Llamo al método freeExclusiveAccess
			this.freeExclusiveAccess();
		}
        
        //Añadido por incidencia 19633
        //4.- Si se llega a invocar al método printDocument, 
        //devolvemos el RecordSet que le pasamos, si no, devolvemos NULL
        if (llamaPrintDocuments.booleanValue())
        {
            UtilidadesLog.debug("*** Metodo PrinterQueues.validatePrintConditions: Salida *** ");
        }else
        {
            UtilidadesLog.debug("*** Metodo PrinterQueues.validatePrintConditions: Salida *** ");
            resultadoCheck = null;
        }
		
        UtilidadesLog.info("PrinterQueues.validatePrintConditions(): Salida");
        return resultadoCheck;
	}

	
	public void getExclusiveAccess() throws MareException {

/*
        UtilidadesLog.info("PrinterQueues.getExclusiveAccess(): Entrada");
		//1.- nos declaramos una variable local fin y la inicializamos a FALSE. 
		boolean fin = false;
		boolean valor = true ;
		//2.- Mientras fin==FALSE hacer: 
        //Thread hilo = new Thread();
    
		while(fin == false){
			//-Se llama a traves del local interface del SpoolManager al método 
			//getExclusiveAcces(serverID, idQueue). 
			SpoolManager spool = this.getSpoolManager();
			try{
				valor = spool.getExclusiveAccess(this.serverID,this.idQueue);
			}catch(RemoteException re){
				UtilidadesLog.error("*** Error en getExclusiveAccess",re);
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
			}
			//- Si nos devuelve TRUE, entonces fin==TRUE. 
			if(valor == true){
				fin = true;
			}else 
            {
                try 
                {
                     Thread.sleep(1000);
                }catch(InterruptedException IE)
                {
                    UtilidadesLog.error("*** Error en getExclusiveAccess",IE);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(IE, UtilidadesError.armarCodigoError(codigoError));	
                }
               
            }
            
		}
        UtilidadesLog.info("PrinterQueues.getExclusiveAccess(): Salida");*/
	}


	public void freeExclusiveAccess() throws MareException{
        UtilidadesLog.info("PrinterQueues.freeExclusiveAccess(): Entrada");
		/*Documentation
		ENTRADA: 
		SALIDA: 
		RESUMEN: Libero el acceso a la cola 
		*/
		//1.- Se llama a traves del local interface del SpoolManager al método 
		//freeExclusiveAcces(serverID, idQueue).
		/*SpoolManager spool = this.getSpoolManager();
		try{
			spool.freeExclusiveAccess(this.serverID,this.idQueue);
		}catch(RemoteException re){
				UtilidadesLog.error("*** Error en freeExclusiveAccess",re);
				String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
				throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
			}*/
        UtilidadesLog.info("PrinterQueues.freeExclusiveAccess(): Salida");
	}

		
		
	private SpoolManager getSpoolManager() throws MareException {
        UtilidadesLog.info("PrinterQueues.getSpoolManager(): Entrada");
      SpoolManager spoolManager=null;
      
      SpoolManagerHome spoolManagerHome=null;
      try{
        spoolManagerHome = (SpoolManagerHome)this.ctx.getEJBHome();
        spoolManager = spoolManagerHome.create();
      
      }catch(RemoteException re){
         throw new MareException("Se ha producido una remoteException en PrinterQueues GetSpoolManager",re);
      }catch(CreateException ce){
         throw new MareException("Se ha producido una CreateException en PrinterQueues GetSpoolManager",ce);
      }
        UtilidadesLog.info("PrinterQueues.getSpoolManager(): Salida");
      return spoolManager;
  }	
    
	private PrinterSystemEJBLocalHome getPrinterSystemEJBLocalHome() throws MareException {
        UtilidadesLog.info("PrinterQueues.getPrinterSystemEJBLocalHome(): Entrada");
		PrinterSystemEJBLocalHome printerSystemEJBLocalHome = (PrinterSystemEJBLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/PrinterSystemEJB");
        UtilidadesLog.info("PrinterQueues.getPrinterSystemEJBLocalHome(): Salida");
		return printerSystemEJBLocalHome;
	}

	private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private void logStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out,e);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }
}