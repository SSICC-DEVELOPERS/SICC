/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

public class DAOReasignacionCartera 
{
  public DAOReasignacionCartera()
  {
  }
  
  /** 
  * Metodo para 
  * @param DTOAsignacionesCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarAsignacionesCobranza(DTOAsignacionesCobranza dto) throws MareException{
  
    UtilidadesLog.info("DAOReasignacionCartera.buscarAsignacionesCobranza(DTOAsignacionesCobranza dto): Entrada");
    
    BigDecimal sumaImportes = new BigDecimal(0);
    long totalImportes = 0;
    long importeHasta = 0;
    long sumaClientes =0;
    long totalClientes = 0;
    StringBuffer oids = new StringBuffer();
     
    int cantFilasRS = 0;
    int cantFilasRS2 = 0;
      
    DTOSalida dtoS = new DTOSalida();
    RecordSet rs = new RecordSet();
    RecordSet rs2 = new RecordSet();
    StringBuffer select = new StringBuffer();
    StringBuffer from = new StringBuffer();
    StringBuffer where = new StringBuffer();
    StringBuffer group = new StringBuffer();
    StringBuffer query = new StringBuffer();
    
    BelcorpService bs;
    try {   
        bs = BelcorpService.getInstance();
    
    } catch(MareMiiServiceNotFoundException ex){   
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      
    }      
      
    select.append(" SELECT "); 
    select.append(" CRON.OID_CRON_COBR OID, USU.NAME CODIGO_USUARIO,  ");
    select.append(" ETAP.COD_ETAP_DEUD CODIGO_ETAPA, TCAB.COD_TIPO_CARG_ABON TIPO_CARGO,  ");
    select.append(" MARCA.DES_MARC, TCANAL.VAL_I18N DES_CANA, PERIODO.VAL_NOMB_PERI PERIODO, SUBGV.DES_SUBG_VENT, ");
    select.append(" REGIO.DES_REGI, ZONA.DES_ZONA, SECC.DES_SECCI, CLI.COD_CLIE,  ");
    select.append(" SUM(NVL(ASIG.IMP_DEUD_ASIG, 0)) DEUDA_ASIG, SUM(NVL(ASIG.IMP_DEUD_CANC, 0)) DEUD_CANCEL, CRON.FEC_ASIG  ");
    from.append(" FROM  ");
    from.append(" COB_ASIGN_COBRA ASIG, COB_CRONO_COBRA CRON, COB_USUAR_COBRA UCOB, "); 
    from.append(" Principals USU, COB_ETAPA_DEUDA ETAP, CCC_MOVIM_CUENT_CORRI CUOTA,CRA_PERIO PERIODO, SEG_MARCA MARCA, ");
    from.append(" ZON_TERRI_ADMIN TERRI_ADMIN, ZON_SECCI SECC, ZON_TERRI TERRI, ZON_ZONA ZONA, ZON_REGIO REGIO, ");
    from.append(" ZON_SUB_GEREN_VENTA SUBGV,GEN_I18N_SICC TCANAL,MAE_CLIEN CLI,CCC_TIPO_CARGO_ABONO TCAB ");
    
    if(dto.getTipoCliente()!=null){ from.append(" , mae_clien_tipo_subti tiposubti ");    }
    
    where.append(" WHERE ASIG.CRCO_OID_CRON_COBR = CRON.OID_CRON_COBR  ");
    where.append(" AND CRON.ETDE_OID_ETAP_DEUD = ETAP.OID_ETAP_DEUD  ");
    where.append(" AND CRON.TCAB_OID_TIPO_CARG_ABON = TCAB.OID_TIPO_CARG_ABON  ");
    where.append(" AND CRON.PERD_OID_PERI = PERIODO.OID_PERI  ");
    where.append(" AND PERIODO.MARC_OID_MARC = MARCA.OID_MARC  ");
      
    // Por incidencia 18661 pperez:
    where.append(" AND CRON.USCO_OID_USUA_COBR = UCOB.OID_USUA_COBR ");
    /*where.append(" AND CRON.USCO_OID_USUA_COBR = UCOB.USER_OID_USUA_COBR ");*/
    where.append(" AND UCOB.USER_OID_USUA_COBR = USU.IDPRINCIPAL  ");
    where.append(" AND ASIG.MVCC_OID_MOVI_CC = CUOTA.OID_MOVI_CC ");
    where.append(" AND CUOTA.CLIE_OID_CLIE = CLI.OID_CLIE  ");
    where.append(" AND CUOTA.MARC_OID_MARC = MARCA.OID_MARC ");
    where.append(" AND CUOTA.perd_oid_peri = PERIODO.oid_peri ");
    where.append(" AND CUOTA.ZTAD_OID_TERR_ADMI = TERRI_ADMIN.OID_TERR_ADMI "); 
    where.append(" AND TERRI_ADMIN.ZSCC_OID_SECC = SECC.OID_SECC "); 
    where.append(" AND TERRI_ADMIN.TERR_OID_TERR = TERRI.OID_TERR ");
    where.append(" AND SECC.ZZON_OID_ZONA = ZONA.OID_ZONA "); 
    where.append(" AND ZONA.ZORG_OID_REGI = REGIO.OID_REGI ");
    where.append(" AND REGIO.ZSGV_OID_SUBG_VENT = SUBGV.OID_SUBG_VENT "); 
    where.append(" AND TCANAL.VAL_OID = PERIODO.CANA_OID_CANA "); 
    where.append(" AND TCANAL.ATTR_ENTI = 'SEG_CANAL'  ");
    where.append(" AND TCANAL.ATTR_NUM_ATRI = 1  ");      
    where.append(" AND TCANAL.IDIO_OID_IDIO = "+dto.getOidIdioma()+"  ");      
    
    /*
    * INC 22282 - dmorello, 06/01/2006
    * El modelo actualmente no indica recuperar una fila
    * si ASIG.ESAS_OID_ESTA_ASIG = ConstantesCOB.OID_ESTA_ASIG_REASIGNADA
    * Por lo tanto, se elimina esta condición.
    */
    //where.append(" AND (ASIG.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA );
    //where.append(" OR  ASIG.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_REASIGNADA + ")");
    where.append(" AND ASIG.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA );
      
    if(dto.getPeriodo()!=null){ where.append(" AND CRON.PERD_OID_PERI = "+dto.getPeriodo()+"  ");  }
    
    if(dto.getUsuarioOrigen()!=null){ 
        where.append(" AND CRON.USCO_OID_USUA_COBR = "+dto.getUsuarioOrigen()+"  ");
    }
    
    if(dto.getEtapaDeuda()!=null){
        where.append(" AND CRON.ETDE_OID_ETAP_DEUD = "+dto.getEtapaDeuda()+"  ");
    }
    
    if(dto.getTipoCliente()!=null){
        where.append(" AND TIPOSUBTI.TICL_OID_TIPO_CLIE = "+dto.getTipoCliente()+"  ");
        where.append(" AND cli.OID_CLIE = tiposubti.CLIE_OID_CLIE ");
    }
    
    if(dto.getSubtipoCliente()!=null){
        where.append(" AND TIPOSUBTI.SBTI_OID_SUBT_CLIE = "+dto.getSubtipoCliente()+"  ");
    }
    
    if(dto.getCodigoCliente()!=null){
        where.append(" AND CLI.COD_CLIE = "+dto.getCodigoCliente()+"  ");
    }
    
    if(dto.getTerritorio()!=null){
        where.append(" AND TERRI.COD_TERR = "+dto.getTerritorio()+"  ");
    }
    
    if(dto.getSeccion()!=null){
        where.append(" AND SECC.OID_SECC = "+dto.getSeccion()+"  ");
    }
    
    if(dto.getZona()!=null){
        where.append(" AND ZONA.OID_ZONA = "+dto.getZona()+"  ");
    }
    
    if(dto.getRegion()!=null){      
        where.append(" AND REGIO.OID_REGI = "+dto.getRegion()+" "); 
    }
    
    if(dto.getSubgerencia()!=null){
        where.append(" AND SUBGV.OID_SUBG_VENT = "+dto.getSubgerencia()+" ");
    }
    
    group.append(" GROUP BY CRON.OID_CRON_COBR, USU.NAME,  ");
    group.append(" ETAP.COD_ETAP_DEUD, TCAB.COD_TIPO_CARG_ABON, MARCA.DES_MARC, TCANAL.VAL_I18N,  ");
    group.append(" PERIODO.VAL_NOMB_PERI, SUBGV.DES_SUBG_VENT, REGIO.DES_REGI, ZONA.DES_ZONA, SECC.DES_SECCI,  ");
    group.append(" CLI.COD_CLIE, CRON.FEC_ASIG  ");      
    
    query.append(select +""+ from +""+ where +""+ group);
    
    try {  
        /*
            if(dto.getPaginado()!=null&&dto.getPaginado().booleanValue()==true) {
                            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
                      } else {
                                rs = bs.dbService.executeStaticQuery(query.toString());
                             }
        */                             
        rs = bs.dbService.executeStaticQuery(query.toString());   
        cantFilasRS = rs.getRowCount();
        UtilidadesLog.debug("cantFilasRS = " + cantFilasRS);
                
        if ( ((dto.getPorcentajeHasta() != null)) || ((dto.getImporteHasta() != null)) || 
             ((dto.getNumeroClientes() != null)) || ((dto.getPorcentajeClientes() != null)) ){
                
            StringBuffer query1 = new StringBuffer(); 
            
            // CU SALDO      
            if ((dto.getPorcentajeHasta() != null) || (dto.getImporteHasta() != null)){ 
                      
                UtilidadesLog.debug(" ######### Entra por % ################" );
                if ((dto.getPorcentajeHasta() != null)){ 
                    int i = 0;            
                        
                    while ((rs.existeFila(i))){
                        if ((rs.getValueAt(i,"DEUDA_ASIG")) != null){
                            totalImportes = totalImportes + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                        }
                        
                        i++;
                    }
                    
                    importeHasta = (totalImportes * dto.getPorcentajeHasta().longValue()) / 100;
                            
                } else {
                    importeHasta = dto.getImporteHasta().longValue();
                    
                }
                
                UtilidadesLog.debug(" #########  importeHasta = " + importeHasta);
                
                /*
                  int i = 0;
                  long sumaTotal = 0;
                  oids.append("(");
                  while ( (rs.existeFila(i)) && (sumaTotal <= importeHasta)){
                         // IF Modificado por Hugo Mansi 23/01/2006 Incidencia Perú
                         if  ( ((rs.getValueAt(i,"DEUDA_ASIG")))!= null && ((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG")).longValue() <= importeHasta && (sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue()) <= importeHasta) {
                            UtilidadesLog.debug("i "+ i + " valor: " + (rs.getValueAt(i,"DEUDA_ASIG")));
                            sumaTotal = sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                         }   
                         if (i!=0){
                              oids.append(",");
                          }
                         oids.append(((BigDecimal)rs.getValueAt(i,0)));
                         
           
                        i++;
                  }
                  UtilidadesLog.debug(" #########  sumaTotal" + sumaTotal);
                  

                  oids.append(")");
                    if (!rs.esVacio()){             
                        if ( (rs.existeFila(0)) && ((((BigDecimal)rs.getValueAt(0,"DEUDA_ASIG"))).longValue()) > importeHasta ){
                           where.append(" and CRON.OID_CRON_COBR in (null)");
                        }else
                            where.append(" and CRON.OID_CRON_COBR in " + oids.toString());
                   }
                */    
                long sumaTotal = 0;
                //cantFilasRS = rs.getRowCount();
                //UtilidadesLog.debug("rs = " + cantFilasRS);                          
                         
                for(int i=0; i < cantFilasRS; i++){
                    UtilidadesLog.debug("Entro al FOR() de seleccion de deudas");
                       
                    if( ((rs.getValueAt(i,"DEUDA_ASIG")))!= null   && 
                        ((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG")).longValue() <= importeHasta   && 
                        (sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue()) <= importeHasta) {
                                
                        UtilidadesLog.debug("i "+ i + " valor: " + (rs.getValueAt(i,"DEUDA_ASIG")));
                        sumaTotal = sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                        UtilidadesLog.debug("sumaTotal = " + sumaTotal);
                        
                        UtilidadesLog.debug("cantFilasRS2 = " + cantFilasRS2);
                        if( cantFilasRS2 < 1){
                            UtilidadesLog.debug("rs2.setColumnIdentifiers !!");
                            rs2.setColumnIdentifiers(rs.getColumnIdentifiers());
                            cantFilasRS2++;
                        }
                        
                        UtilidadesLog.debug("     Se agrega la fila =  " + rs.getRow(i));                        
                        rs2.addRow(rs.getRow(i));
                    }
                    
                 }
                 
                 UtilidadesLog.debug("  rs2 = " + rs2); 
                         
            // CU CLIENTES  
            } else {
                if((dto.getNumeroClientes() != null) || (dto.getPorcentajeClientes() != null)){
                    
                    if ((dto.getPorcentajeClientes() != null)){ 
                        sumaClientes = rs.getRowCount();
                        totalClientes = (sumaClientes * dto.getPorcentajeClientes().longValue()) / 100;
                              
                    } else {
                        totalClientes = dto.getNumeroClientes().longValue();
                    
                    }
                                  
                    UtilidadesLog.debug(" #########  totalClientes" + totalClientes);
                    int i = 0;
                    oids.append("(");
                    
                    while ( (rs.existeFila(i)) && (i <= totalClientes - 1)){
                        if (i!=0){  oids.append(",");  }
                          
                        if (totalClientes != 0){ 
                            oids.append((BigDecimal)rs.getValueAt(i,0));
                            
                        } else {
                            oids.append(" null ");
                        }
                        
                        i++;
                    }                          
                                    
                    oids.append(")");
                    if (!rs.esVacio()){
                        if ((totalClientes >= 0) && (totalClientes < 1)){
                            where.append(" and CRON.OID_CRON_COBR in (null) ");
                                
                        } else {
                            where.append(" and CRON.OID_CRON_COBR in " + oids.toString());
                        }
                    }    
                
                }
                
                query1.append(select +""+ from +""+ where +""+ group);
                
                if(dto.getPaginado() != null  &&  dto.getPaginado().booleanValue() == true) {
                    UtilidadesLog.debug("... hace el 'executeStaticQuery' con 'armarQueryPaginacion'");  
                    rs2 = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query1.toString(),dto));
                    
                } else {
                    UtilidadesLog.debug("... hace el 'executeStaticQuery'");
                    rs2 = bs.dbService.executeStaticQuery(query1.toString());
                }
            
            }// FIN CU CLIENTES
            
            /*query1.append(select +""+ from +""+ where +""+ group);
            if(dto.getPaginado()!=null&&dto.getPaginado().booleanValue()==true) {
                 rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query1.toString(),dto));
            } else {
                 rs = bs.dbService.executeStaticQuery(query1.toString());
            }*/
      
        // CU CONSULTORA      
        } else {
            UtilidadesLog.debug("CU CONSULTORA ....");
            
            //if( dto.getCodigoCliente() != null ){
            
                //cantFilasRS = rs.getRowCount();
                UtilidadesLog.debug("cantFilasRS = " + cantFilasRS);
                rs2.setColumnIdentifiers(rs.getColumnIdentifiers());
                
                for (int i=0 ; i < cantFilasRS ; i++)  {
                    rs2.addRow(rs.getRow(i));
                    UtilidadesLog.debug("Se agregó la fila: " + rs.getRow(i));
                }
                
            //}
            
        }
   
                
            
    } catch (Exception ex){   
        throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }	
    
    UtilidadesLog.debug("rs2 es vacio = " + rs2.esVacio());   
    if( rs2.esVacio() ){
        throw new MareException(new Exception(), 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
    }
       
    UtilidadesLog.debug("        Se agrega al 'dtoS' el siguiente 'rs2' = " + rs2);
    dtoS.setResultado(rs2);
    UtilidadesLog.debug("        'dtoS' = " + dtoS);
    UtilidadesLog.info("DAOReasignacionCartera.buscarAsignacionesCobranza(DTOAsignacionesCobranza dto): Salida");
       
    return dtoS;
    
  }
  
  /** 
  * Metodo para 
  * @param DTOAsignacionesCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarAsignacionesCobranzaIndividuales(DTOAsignacionesCobranza dto) throws MareException{
  
    UtilidadesLog.info("DAOReasignacionCartera.buscarAsignacionesCobranzaIndividuales(DTOAsignacionesCobranza dto): Entrada");
  
    DTOSalida dtoS = new DTOSalida();
    RecordSet rs = new RecordSet();
    RecordSet rs2 = new RecordSet();
      
    StringBuffer select = new StringBuffer();
    StringBuffer from = new StringBuffer();
    StringBuffer where = new StringBuffer();
    StringBuffer group = new StringBuffer();
    StringBuffer query = new StringBuffer();
    StringBuffer oids = new StringBuffer();
    long totalImportes = 0;
    long importeHasta = 0;
    long sumaClientes =0;
    long totalClientes = 0;
    BelcorpService bs;
    
    int cantFilasRS = 0;
    int cantFilasRS2 = 0;
    
    try {   
        bs = BelcorpService.getInstance();
      
    } catch(MareMiiServiceNotFoundException ex){
        throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }      

    select.append(" SELECT ");
    select.append(" ASIG.OID_ASIG_COBR OID_ASIG_COBR, CRON.OID_CRON_COBR OID, USU.NAME CODIGO_USUARIO,  ");
    select.append(" ETAP.COD_ETAP_DEUD CODIGO_ETAPA, TCAB.COD_TIPO_CARG_ABON TIPO_CARGO,  ");
    select.append(" MARCA.DES_MARC, TCANAL.VAL_I18N DES_CANA, PERIODO.VAL_NOMB_PERI PERIODO, SUBGV.DES_SUBG_VENT,  ");
    select.append(" REGIO.DES_REGI, ZONA.DES_ZONA, SECC.DES_SECCI, CUOTA.CLIE_OID_CLIE, CLI.COD_CLIE,  ");
    select.append(" ASIG.IMP_DEUD_ASIG DEUDA_ASIG, ASIG.IMP_DEUD_CANC DEUD_CANCEL, CRON.FEC_ASIG,  asig.TCAB_OID_TIPO_CARG_ABON  ");
    from.append(" FROM  ");
    from.append(" COB_ASIGN_COBRA ASIG, COB_CRONO_COBRA CRON, COB_USUAR_COBRA UCOB, "); 
    from.append(" Principals USU, COB_ETAPA_DEUDA ETAP, CCC_MOVIM_CUENT_CORRI CUOTA,CRA_PERIO PERIODO, SEG_MARCA MARCA, ");
    from.append(" ZON_TERRI_ADMIN TERRI_ADMIN, ZON_SECCI SECC, ZON_TERRI TERRI, ZON_ZONA ZONA, ZON_REGIO REGIO, ");
    from.append(" ZON_SUB_GEREN_VENTA SUBGV,GEN_I18N_SICC TCANAL,MAE_CLIEN CLI,CCC_TIPO_CARGO_ABONO TCAB ");
    
    if(dto.getTipoCliente()!=null){      
        from.append(" , mae_clien_tipo_subti tiposubti ");
    }
      
    where.append(" WHERE ASIG.CRCO_OID_CRON_COBR = CRON.OID_CRON_COBR  ");
    where.append(" AND CRON.ETDE_OID_ETAP_DEUD = ETAP.OID_ETAP_DEUD  ");
    where.append(" AND CRON.TCAB_OID_TIPO_CARG_ABON = TCAB.OID_TIPO_CARG_ABON  ");
    where.append(" AND CRON.PERD_OID_PERI = PERIODO.OID_PERI  ");
    where.append(" AND PERIODO.MARC_OID_MARC = MARCA.OID_MARC  ");
    where.append(" AND CRON.USCO_OID_USUA_COBR = UCOB.OID_USUA_COBR ");
    where.append(" AND UCOB.USER_OID_USUA_COBR = USU.IDPRINCIPAL  ");
    where.append(" AND ASIG.MVCC_OID_MOVI_CC = CUOTA.OID_MOVI_CC ");
    where.append(" AND CUOTA.CLIE_OID_CLIE = CLI.OID_CLIE  ");
    where.append(" AND CUOTA.MARC_OID_MARC = MARCA.OID_MARC ");
    where.append(" AND CUOTA.perd_oid_peri = PERIODO.oid_peri ");
    where.append(" AND CUOTA.ZTAD_OID_TERR_ADMI = TERRI_ADMIN.OID_TERR_ADMI "); 
    where.append(" AND TERRI_ADMIN.ZSCC_OID_SECC = SECC.OID_SECC "); 
    where.append(" AND TERRI_ADMIN.TERR_OID_TERR = TERRI.OID_TERR ");
    where.append(" AND SECC.ZZON_OID_ZONA = ZONA.OID_ZONA "); 
    where.append(" AND ZONA.ZORG_OID_REGI = REGIO.OID_REGI ");
    where.append(" AND REGIO.ZSGV_OID_SUBG_VENT = SUBGV.OID_SUBG_VENT "); 
    where.append(" AND TCANAL.VAL_OID = PERIODO.CANA_OID_CANA "); 
    where.append(" AND TCANAL.ATTR_ENTI = 'SEG_CANAL'  ");
    where.append(" AND TCANAL.ATTR_NUM_ATRI = 1  ");      
    where.append(" AND TCANAL.IDIO_OID_IDIO = "+dto.getOidIdioma()+"  ");      
    where.append(" AND ASIG.ESAS_OID_ESTA_ASIG = "+ConstantesCOB.OID_ESTA_ASIG_ABIERTA+"  ");
    
    if(dto.getPeriodo()!=null){
        where.append(" AND CRON.PERD_OID_PERI = "+dto.getPeriodo()+"  ");
    }
    
    if(dto.getUsuarioOrigen()!=null){
        where.append(" AND CRON.USCO_OID_USUA_COBR = "+dto.getUsuarioOrigen()+"  ");
    }
    
    if(dto.getEtapaDeuda()!=null){
        where.append(" AND CRON.ETDE_OID_ETAP_DEUD = "+dto.getEtapaDeuda()+"  ");
    }
    
    if(dto.getTipoCliente()!=null){
        where.append(" AND TIPOSUBTI.TICL_OID_TIPO_CLIE = "+dto.getTipoCliente()+"  ");
        where.append(" AND cli.OID_CLIE = tiposubti.CLIE_OID_CLIE ");
    }
    
    if(dto.getSubtipoCliente()!=null){
        where.append(" AND TIPOSUBTI.SBTI_OID_SUBT_CLIE = "+dto.getSubtipoCliente()+"  ");
    }
    
    if(dto.getCodigoCliente()!=null){
        where.append(" AND CLI.COD_CLIE = "+dto.getCodigoCliente()+"  ");
    }
    
    if(dto.getTerritorio()!=null){
        where.append(" AND TERRI.COD_TERR = "+dto.getTerritorio()+"  ");
    }
    
    if(dto.getSeccion()!=null){
        where.append(" AND SECC.OID_SECC = "+dto.getSeccion()+"  ");
    }
    
    if(dto.getZona()!=null){
        where.append(" AND ZONA.OID_ZONA = "+dto.getZona()+"  ");
    }
    
    if(dto.getRegion()!=null){      
        where.append(" AND REGIO.OID_REGI = "+dto.getRegion()+" "); 
    }
    
    if(dto.getSubgerencia()!=null){
        where.append(" AND SUBGV.OID_SUBG_VENT = "+dto.getSubgerencia()+" ");
    }
      
    query.append(select +""+ from +""+ where +""+ group);

    try {
        UtilidadesLog.debug(" ################## Individual");  
        
        if(dto.getPaginado() != null  &&  dto.getPaginado().booleanValue()==true) {
            UtilidadesLog.debug("dto.getPaginado() = TRUE");
            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        
        } else {
            UtilidadesLog.debug("dto.getPaginado() = FALSE");
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        UtilidadesLog.debug("RS = " + rs);
        
        cantFilasRS = rs.getRowCount();
        UtilidadesLog.debug("rs.getRowCount() = " + cantFilasRS);        
        
        if ( ((dto.getPorcentajeHasta() != null)) || ((dto.getImporteHasta() != null)) || 
             ((dto.getNumeroClientes() != null)) || ((dto.getPorcentajeClientes() != null))){
        
            StringBuffer query1 = new StringBuffer(); 
            
            // CU SALDO      
            if ((dto.getPorcentajeHasta() != null) || (dto.getImporteHasta() != null)){ 
                UtilidadesLog.debug(" ######### Entra por % ################" );
                if ((dto.getPorcentajeHasta() != null)){ 
                    int i = 0;            
                    while ((rs.existeFila(i))){
                        if ((rs.getValueAt(i,"DEUDA_ASIG")) != null){
                            totalImportes = totalImportes + 
                                    (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                        }
                        
                        i++;
                    }
                    
                    importeHasta = (totalImportes * dto.getPorcentajeHasta().longValue()) / 100;
                          
                } else {
                    importeHasta = dto.getImporteHasta().longValue();
                    
                }
                
                UtilidadesLog.debug(" #########  importeHasta... " + importeHasta);
                
                /*
                int i = 0;
                long sumaTotal = 0;
                oids.append("(");
                
                while ( (rs.existeFila(i)) && (sumaTotal <= importeHasta)){
                    
                    if  ( ((rs.getValueAt(i,"DEUDA_ASIG"))) != null){
                        UtilidadesLog.debug("i "+ i + " valor: " + (rs.getValueAt(i,"DEUDA_ASIG")));
                        sumaTotal = sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                    }   
                                
                    if (i!=0){  oids.append(",");   }
                    
                    oids.append(((BigDecimal)rs.getValueAt(i,0)));
                    
                    i++;
                }
                
                UtilidadesLog.debug(" #########  sumaTotal" + sumaTotal);
                          
                oids.append(")");
                
                if (!rs.esVacio()){             
                    if ( (rs.existeFila(0)) && 
                         ((((BigDecimal)rs.getValueAt(0,"DEUDA_ASIG"))).longValue()) > importeHasta ){
                        
                        where.append(" and CRON.OID_CRON_COBR in (null)");
                    
                    } else {
                        where.append(" and CRON.OID_CRON_COBR in " + oids.toString());
                    }
                }
                */
                long sumaTotal = 0;
                
                UtilidadesLog.debug("cantFilasRS = " + cantFilasRS);                          
                         
                for(int i=0; i < cantFilasRS; i++){
                    UtilidadesLog.debug("Entro al FOR()...");
                       
                    if( ((rs.getValueAt(i,"DEUDA_ASIG")))!= null   && 
                        ((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG")).longValue() <= importeHasta   && 
                        (sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue()) <= importeHasta) {
                                
                        UtilidadesLog.debug("i "+ i + " valor: " + (rs.getValueAt(i,"DEUDA_ASIG")));
                        sumaTotal = sumaTotal + (((BigDecimal)rs.getValueAt(i,"DEUDA_ASIG"))).longValue();
                        UtilidadesLog.debug("Suma Total = " + sumaTotal);
                        
                        UtilidadesLog.debug("Filas de RS2 = " + cantFilasRS2);
                        if( cantFilasRS2 < 1){
                            UtilidadesLog.debug("hace el  rs2.setColumnIdentifiers... ");
                            rs2.setColumnIdentifiers(rs.getColumnIdentifiers());
                            cantFilasRS2++;
                        }
                        
                        rs2.addRow(rs.getRow(i));
                        UtilidadesLog.debug("Se agregó la fila = " + rs.getRow(i));
                    }
                    
                 }
                 UtilidadesLog.debug("rs2 resultante = " + rs2);
                
                              
            // CU CLIENTES
            } else {
                if((dto.getNumeroClientes() != null) || (dto.getPorcentajeClientes() != null)){
                    if ((dto.getPorcentajeClientes() != null)){ 
                        sumaClientes = cantFilasRS;
                        totalClientes = (sumaClientes * dto.getPorcentajeClientes().longValue()) / 100;
                
                    } else {
                        totalClientes = dto.getNumeroClientes().longValue();
                    }
                
                    UtilidadesLog.debug(" #########  totalClientes" + totalClientes);
                    int i = 0;
                    oids.append("(");
                    
                    while ( (rs.existeFila(i)) && (i <= totalClientes)){
                        
                        if (i!=0){  oids.append(",");   }
                        
                        if (totalClientes != 0){
                            oids.append((BigDecimal)rs.getValueAt(i,0));
                        } else 
                            oids.append(" null ");
                    
                        i++;
                    }                          
                  
                    oids.append(")");
                    if (!rs.esVacio()){
                        where.append(" and CRON.OID_CRON_COBR in " + oids.toString());
                    }
                                    
                } else  { // los dos CU restantes....
                            
                    UtilidadesLog.debug(" #########  SIN FILTROS ######### ");
                    
                    if(dto.getPaginado() != null  &&  dto.getPaginado().booleanValue()==true) {
                        rs2 = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
                    
                    } else {
                        rs2 = bs.dbService.executeStaticQuery(query.toString());
                    }
                
                }
             }
           /* UtilidadesLog.debug("**********Entro a cueri simple--*******");
                query1.append(select +""+ from +""+ where +""+ group);
                if(dto.getPaginado() != null  &&  dto.getPaginado().booleanValue()==true) {
                    UtilidadesLog.debug("**********Entro a cueri simple--*******");
                    rs2 = bs.dbService.executeStaticQuery(
                        UtilidadesPaginacion.armarQueryPaginacion(query1.toString(),dto));
                
                } else {
                   
                    rs2 = bs.dbService.executeStaticQuery(query1.toString());
                }*/
        
        // CU CONSULTORA      
        } else {
            UtilidadesLog.debug("CU CONSULTORA ....");
            
           // if( dto.getCodigoCliente() != null ){
            
                UtilidadesLog.debug("cantFilasRS = " + cantFilasRS);
                rs2.setColumnIdentifiers(rs.getColumnIdentifiers());
                
                for (int i=0 ; i < cantFilasRS ; i++)  {
                    rs2.addRow(rs.getRow(i));
                    UtilidadesLog.debug("Se agregó la fila: " + rs.getRow(i));
                }
                
           // }
            
        }
        
    
    } catch (Exception ex){   
        throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }	
    
    UtilidadesLog.debug("Se asigna a 'dtoS' el sig. RS2 = " + rs2);
    dtoS.setResultado(rs2);
       
    UtilidadesLog.info("DAOReasignacionCartera.buscarAsignacionesCobranzaIndividuales(DTOAsignacionesCobranza dto): Salida");
       
    return dtoS;  
  }
  
  /** 
  * Metodo para 
  * @param DTOCronogramaCobranza dto
  * @return Long
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public Long obtenerOIDCronogramaFiltro(DTOCronogramaCobranza dto) throws MareException{
  
    UtilidadesLog.info("DAOReasignacionCartera.obtenerOIDCronogramaFiltro(DTOCronogramaCobranza dto): Entrada");
  
      Long res = null;
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
      
      query.append(" SELECT OID_CRON_COBR ");
      query.append(" FROM COB_CRONO_COBRA cobra ");
      query.append(" WHERE cobra.PAIS_OID_PAIS = "+dto.getOidPais());
      
      if ((dto.getOidZona() != null) && !(dto.getOidZona().equals(""))) 
        query.append(" AND cobra.ZZON_OID_ZONA ="+ dto.getOidZona());
      
      if ((dto.getOidRegion() != null) && !(dto.getOidRegion().equals(""))) 
            query.append("  AND cobra.ZORG_OID_REGI ="+ dto.getOidRegion());
      
      if ((dto.getOidSeccion() != null) && !(dto.getOidSeccion().equals(""))) 
          query.append(" AND cobra.ZSCC_OID_SECC = "+ dto.getOidSeccion());
      
      if ((dto.getOidSubgerenciaVentas() != null) && !(dto.getOidSubgerenciaVentas().equals(""))) 
          query.append(" AND cobra.ZSGV_OID_SUBG_VENT ="+ dto.getOidSubgerenciaVentas());
            
      if ((dto.getOidPeriodo() != null) && !(dto.getOidPeriodo().equals(""))) 
          query.append(" AND cobra.PERD_OID_PERI = "+ dto.getOidPeriodo());
      
      if ((dto.getOidTerritorio() != null) && !(dto.getOidTerritorio().equals(""))) 
           query.append(" AND cobra.TERR_OID_TERR = "+ dto.getOidTerritorio());
      
      if ((dto.getOidTipoCargo() != null) && !(dto.getOidTipoCargo().equals(""))) 
            query.append(" AND cobra.TCAB_OID_TIPO_CARG_ABON = "+ dto.getOidTipoCargo());

      if ((dto.getOidEtapa() != null) && !(dto.getOidEtapa().equals(""))) 
            query.append(" AND cobra.ETDE_OID_ETAP_DEUD = " + dto.getOidEtapa());
      
      if ((dto.getOidUsuarioCobranza() != null) && !(dto.getOidUsuarioCobranza().equals(""))) 
              query.append(" AND cobra.USCO_OID_USUA_COBR = " + dto.getOidUsuarioCobranza());
      
      Long valor = null;
      
       try //UtilidadesPaginacion.armarQueryPaginacion(,dto)
        {   
            rs = bs.dbService.executeStaticQuery(query.toString());
            if ((!rs.esVacio()) && (rs.getValueAt(0, 0) != null)){
                  valor = new Long((((BigDecimal) rs.getValueAt(0, 0))).longValue());
                }
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	

    UtilidadesLog.debug("Retorna 'valor' = " + valor);
    UtilidadesLog.info("DAOReasignacionCartera.obtenerOIDCronogramaFiltro(DTOCronogramaCobranza dto): Salida");
    
    
       return valor;  
  }
  
  
   /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.debug("DAOReasignacionCartera.deepCopy(): Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);

            UtilidadesLog.debug("DAOReasignacionCartera.deepCopy(): Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }

}