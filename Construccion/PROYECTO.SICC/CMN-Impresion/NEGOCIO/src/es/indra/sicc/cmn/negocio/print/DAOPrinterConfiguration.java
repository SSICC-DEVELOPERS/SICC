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
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.print.ClassRecover;
import es.indra.sicc.cmn.negocio.print.ImpressionParameters;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Vector;


public class DAOPrinterConfiguration {
    public DAOPrinterConfiguration() {
    }

	// BELC300011627
    public Vector recoverConfiguration(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterConfiguration.recoverConfiguration(): Entrada");

        StringBuffer consulta = new StringBuffer("");
        StringBuffer consulta2 = new StringBuffer("");

        //Diseño
        //	1.- Accederemos a la tabla ImpresoraVirtual y recuperamos todos los registros. 


        consulta.append(" select f.*, c.OID_COLA from fac_impre_virtu f, gen_colas c where");
        consulta.append(" f.OID_IMPR = c.IMVI_OID_IMPR ");
        consulta.append(" and c.GSPO_OID_SPOOL = "+idSpool);
        Vector salida = new Vector();
        Vector parametros = new Vector();
        String codigoError = null;

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        PrinterConfiguration pc;

        //2.- Creamos un Vector salida. 
        //3.- Por cada uno de esos registros creamos una instancia 
        //del objeto PrinterConfiguration y rellenamos sus atributos a partir de ese registro
        //de la siguiente manera: 
        //- Los atributos: 
        //printerType, bufferSize, secuenceFlag, specificConf 
        //los rellenaremos con los datos del registro. 
        if (rs != null) {
            if (!rs.esVacio()) {
                for (int i = 0; i < rs.getRowCount(); i++) { //BEL 11123
                    pc = new PrinterConfiguration();
					 if (rs.getValueAt(i, "OID_IMPR") != null) {
                        pc.setIdImpresoraVirtual(new Long(
                                ((BigDecimal) rs.getValueAt(i, "OID_IMPR")).intValue()));
                         Long oidTecnologia=this.recoverTechnology( new Long(((BigDecimal) rs.getValueAt(i, "OID_IMPR")).intValue()));
                         pc.setTecnologiaImpresion(oidTecnologia);
                    }
                    
                    if (rs.getValueAt(i, "TIIM_OID_TIPO") != null) {
                        pc.setBufferSize(new Long(
                                ((BigDecimal) rs.getValueAt(i, "VAL_TAMA_BUFF")).intValue()));
                    }

                    if (rs.getValueAt(i, "NUM_SECU") != null) {
                        if (((BigDecimal) rs.getValueAt(i, "NUM_SECU")).intValue() == 1) {
                            //pc.setSecuenceFlag(Boolean.TRUE.booleanValue());
                            pc.setSecuenceFlag(Boolean.FALSE.booleanValue());
                        } else {
                            pc.setSecuenceFlag(Boolean.FALSE.booleanValue());
                        }
                    }

                    ImpressionParameters ip = new ImpressionParameters();
                    ip.setAtributo_1((String) rs.getValueAt(i, "VAL_ATR1"));
                    ip.setAtributo_2((String)rs.getValueAt(i, "VAL_ATR2"));
                    ip.setAtributo_3((String)rs.getValueAt(i, "VAL_ATR3"));
                    ip.setAtributo_4((String)rs.getValueAt(i, "VAL_ATR4"));
					//ip.setPrinterName((String)rs.getValueAt(i, "DES_IMPR"));
					pc.setImpressionParameters(ip);
                    
                    pc.setIdQueue(new Long(rs.getValueAt(i, "OID_COLA").toString()));

                    if (rs.getValueAt(i, "TIIM_OID_TIPO") != null) {
                         parametros = new Vector();
						consulta2=new StringBuffer("");
                        consulta2.append(
                            " SELECT VAL_NOMB_PRIN_SEND  FROM FAC_TIPO_IMPRE WHERE OID_TIPO= ? ");
							//sacamos el tipo de recordsetAnterior
                        Long tipo = new Long(((BigDecimal) rs.getValueAt(i,
                                    "TIIM_OID_TIPO")).intValue());
                        parametros.add(tipo);
                        bs = UtilidadesEJB.getBelcorpService();

                        RecordSet rs2 = null;

                        try {
                            rs2 = bs.dbService.executePreparedQuery(consulta2.toString(),
                                    parametros);
                        } catch (Exception e) {
                            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                            UtilidadesLog.error(e);
                            this.logSql("recoverConfiguration. SQL: ",
                                consulta2.toString(), parametros);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(codigoError));
                        }

                        if (rs2 != null) {
                            if (!rs2.esVacio()) {
                                if (rs2.getValueAt(0, "VAL_NOMB_PRIN_SEND") != null) {
                                    String clase = (String) rs2.getValueAt(0,
                                            "VAL_NOMB_PRIN_SEND");

                                    //saco un string que es el nombre de la clase que implementa la interfac printerSender
                                    Object obj = new Object();
									//Class obj=null;
									StringBuffer claseTotal=new StringBuffer("es.indra.sicc.cmn.negocio.print.");
									claseTotal.append(clase);
									
                                    try {
                                        obj = ClassRecover.recoverInstanceForName(claseTotal.toString());
                                   

                                    //estas dos clases son las que pueden iplematar esa interfaz
                                    if (obj instanceof FilePrint) {
                                        FilePrint fprint = new FilePrint(ip);
										pc.setPrintType((PrinterSender)fprint);
                                        //recibe un array de Bytes? de dond lo saco??
                                    } else if (obj instanceof LPRPrint) {
                                        LPRPrint lprint =new LPRPrint(ip);
                                        pc.setPrintType((PrinterSender)lprint);
                                    }
								} catch (Exception me) {
                                     throw new MareException("\nEn DAOPrinerconfiguration salto un excepcion\n",
                                        me);
                                }
 
                                }//rs2.getValue2
                            }//rs2.esVacio
                        }//rs2!=mull

                        
                    }                                      
                    //meto el objeto en el vector.				
                    salida.add(pc);
                }
                 //for
            }
             //if
        }
        
        UtilidadesLog.info("DAOPrinterConfiguration.recoverConfiguration(): Salida");

        return salida;
    }

    public Vector recoverConfigurationEtiquetas(Long idSpool) throws MareException {
        UtilidadesLog.info("DAOPrinterConfiguration.recoverConfigurationEtiquetas(Long idSpool): Entrada");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT impr.*, cola.oid_cola, ");
        consulta.append("        asign.teim_oid_tecn, tipo.val_nomb_prin_send ");
        consulta.append("   FROM fac_impre_virtu impr, ");
        consulta.append("        fac_tipo_impre tipo, ");
        consulta.append("        ape_asign_impre asign, ");
        consulta.append("        gen_colas cola ");
        consulta.append("  WHERE impr.oid_impr = cola.imvi_oid_impr ");
        consulta.append("    AND impr.tiim_oid_tipo = tipo.oid_tipo ");
        consulta.append("    AND cola.gspo_oid_spool = ").append(idSpool);
        consulta.append("    AND impr.oid_impr = asign.imvi_oid_impr ");

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        PrinterConfiguration pc;
        Vector salida = new Vector();

        if (rs != null && !rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) { //BEL 11123
                pc = new PrinterConfiguration();
                
                pc.setIdImpresoraVirtual(new Long(((BigDecimal)rs.getValueAt(i, "OID_IMPR")).longValue()));
                pc.setTecnologiaImpresion(new Long(((BigDecimal)rs.getValueAt(i, "TEIM_OID_TECN")).longValue()));
                pc.setBufferSize(new Long(((BigDecimal) rs.getValueAt(i, "VAL_TAMA_BUFF")).intValue()));
                
                //if (((BigDecimal) rs.getValueAt(i, "NUM_SECU")).intValue() == 1) {
                    pc.setSecuenceFlag(false);
                //} else {
                //    pc.setSecuenceFlag(false);
                //}
                
                ImpressionParameters ip = new ImpressionParameters();
                ip.setAtributo_1((String) rs.getValueAt(i, "VAL_ATR1"));
                ip.setAtributo_2((String)rs.getValueAt(i, "VAL_ATR2"));
                ip.setAtributo_3((String)rs.getValueAt(i, "VAL_ATR3"));
                ip.setAtributo_4((String)rs.getValueAt(i, "VAL_ATR4"));
                pc.setImpressionParameters(ip);
                
                pc.setIdQueue(new Long(rs.getValueAt(i, "OID_COLA").toString()));
                
                if (rs.getValueAt(i, "VAL_NOMB_PRIN_SEND") != null) {
                    try {
                        String clase = "es.indra.sicc.cmn.negocio.print." + rs.getValueAt(i,"VAL_NOMB_PRIN_SEND").toString();
                        PrinterSender ps = null;

                        Class printClass = Class.forName(clase);
                        if (printClass == FilePrint.class) {
                            ps = new FilePrint(ip);
                        } else if (printClass == LPRPrint.class) {
                            ps = new LPRPrint(ip);
                        }
                        pc.setPrintType(ps);
                        
                    } catch (Exception me) {
                        throw new MareException("\nEn DAOPrinerconfiguration salto un excepcion\n", me);
                    }
                }                                      
                salida.add(pc);
            }
        }
        
        UtilidadesLog.info("DAOPrinterConfiguration.recoverConfigurationEtiquetas(Long idSpool): Salida");
        return salida;
    }
    
	 //metodo
     
      //*****************MODIFICADO POR BELC300018607 26/05/2005************************
     public Long recoverTechnology(Long oidImpresora) throws MareException {
		UtilidadesLog.info("DAOPrinterConfiguration.recoverTechnology(): Entrada");
		UtilidadesLog.debug(" oidImpresora " + oidImpresora);

         StringBuffer consulta= new StringBuffer();
         Vector parametros=new Vector();
        
         consulta.append(" SELECT C.TEIM_OID_TECN, ");
         consulta.append(" COUNT (C.TEIM_OID_TECN) AS NUMERO_DOC_CON_ESA_TECNOLOGIA  ");
         consulta.append(" FROM  ");
         consulta.append(" FAC_IMPRE_VIRTU A,  ");
         consulta.append(" FAC_ASIGN_IMPRE B,  ");
         consulta.append(" FAC_FORMU C  ");
         consulta.append(" WHERE A.OID_IMPR= ?  ");
         parametros.add(oidImpresora);
         consulta.append(" AND B.IMVI_OID_IMPR=A.OID_IMPR  ");
         consulta.append(" AND B.FORS_OID_FORM=C.OID_FORM  ");
         consulta.append(" GROUP BY C.TEIM_OID_TECN  ");
         consulta.append(" ORDER BY NUMERO_DOC_CON_ESA_TECNOLOGIA DESC  ");

        String codigoError = null;

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(e);
            this.logSql("recoverTechnology. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        Long oidTecnología=null;
        if(rs!= null){
            if(rs.getRowCount()>1){
                 UtilidadesLog.debug("La impresora virtual esta mal configurada, ya que tiene asociadas documentos con tecnologias de impresion diferentes ");
            }
             if(!rs.esVacio()){
                if (rs.getValueAt(0, 0) != null) {
                      oidTecnología = new Long(((BigDecimal) (rs.getValueAt(0, 0))).longValue());
            }
         }else{
            UtilidadesLog.debug(" recoverTechnology No hay ningun documento asociado ,  ");
         }
        }
        
        //"La impresora virtual esta mal configurada, ya que tiene asociadas documentos con tecnologias de impresion diferentes" 
		UtilidadesLog.info("DAOPrinterConfiguration.recoverTechnology(): Salida");
        return oidTecnología;
  }


  public boolean recoverMultiSpoolEnable() throws MareException {
        UtilidadesLog.info("DAOPrinterConfiguration.recoverMultiSpoolEnable(): Entrada");
  
       // ****** Añadido por incidencia 06/06/2006  BELC300018925  ******
        MareMGC mgc = new MareMGC();
        mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String multiSpoolEnable = (String) mgc.getProperty("application.multiSpoolEnable");        		
        UtilidadesLog.debug("*** multiSpoolEnable = "+multiSpoolEnable);
        // *******************
        boolean retorno;
        if(multiSpoolEnable.equals("1")){
            retorno = Boolean.TRUE.booleanValue();
        }else{
             retorno = Boolean.FALSE.booleanValue();
        }
        
	UtilidadesLog.info("DAOPrinterConfiguration.recoverMultiSpoolEnable(): Salida");
    return retorno;
  }
  //Operation boolean <<NEW>> recoverMultiSpoolEnable (), 
  
  
  

    private void logStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
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
}
 //calse
