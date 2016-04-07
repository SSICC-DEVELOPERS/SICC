/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocalHome;
import es.indra.sicc.entidades.cob.EtapasDeudaLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * 
 * @date 13/05/05
 * @author pperanzola
 * 
 */

public class ExtensionCOBBean implements SessionBean 
{
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
    }
    /**
     * @author pperanzola
     * @date 13/05/05
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * Debemos ver sila etapa que se va a insertar coincide con etapas exclusivas, para ello le pasamos 
       la edadInicio y edadFin de la que vamos a insertar 
       obtenemos la propiedad edadInicio de datos 
       obtenemos la propiedad edadFin de datos 
       Accedemos a la entidad COB_ETAPA_DEUDA 
       filtrando por: 
       IND_EXCL = 1 
       ( VAL_EDAD_INIC < edadInicio AND 
       VAL_EDAD_FINA > edadInicio ) OR 
       ( VAL_EDAD_INIC < edadFiinAND 
       VAL_EDAD_FINA > edadFin) 
        
       obtenemos: 
       OID_ETAP_DEUD 
        
       Si obtenemos algún registro { 
       Lanzamos una MareException con el mensaje COB-012 ("La etapa cruza con otra etapa exclusiva. Revise los datos") 
       } 
     */
    public void validacionEntreExclusivas(MareDTO datos) throws MareException{
        UtilidadesLog.info("ExtensionCOBBean.validacionEntreExclusivas(MareDTO datos): Entrada");
    
        BelcorpService bs;
        StringBuffer query = new StringBuffer("");
        RecordSet rs = null;
        
        Long paramEdadInicio = (Long) datos.getProperty("valEdadInic");
        UtilidadesLog.debug(">>>>>>>>>>>>>valEdadInic:"  + paramEdadInicio);
        Long paramEdadFin = (Long) datos.getProperty("valEdadFina");
        UtilidadesLog.debug(">>>>>>>>>>>>>valEdadFina:" + paramEdadFin);
        Long paramPais = (Long) datos.getProperty("paisOidPais");
        UtilidadesLog.debug(">>>>>>>>>>>>>paisOidPais:" + paramPais);
        
        // splatas - 17/07/2006 - DBLG500000834
        Long oid = (Long) datos.getProperty("id");
        
        UtilidadesLog.debug("\n   Imprimo el DTO... \n" + datos);
        
        query.append(" SELECT oid_etap_deud FROM COB_ETAPA_DEUDA ");
        query.append(" WHERE IND_EXCL = 1 ");
        query.append(" AND  PAIS_OID_PAIS = " + paramPais );
        query.append(" AND (( VAL_EDAD_INIC < " + paramEdadInicio + " AND ");
        query.append("       VAL_EDAD_FINA >= " + paramEdadInicio + " ) ");
        query.append(" OR  ( VAL_EDAD_INIC <= " + paramEdadFin    + " AND");
        query.append("       VAL_EDAD_FINA > " + paramEdadFin    + " )");
        query.append(" OR  ( VAL_EDAD_INIC >= " + paramEdadInicio + " AND ");
        query.append(" VAL_EDAD_FINA <= " + paramEdadFin  + " ))");
        
        // splatas - 17/07/2006 - DBLG500000834
        if( oid != null ){     
            query.append(" AND OID_ETAP_DEUD <>" + oid);
        }
        
        
        try 
        {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException ex) {
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if ((rs != null) && (rs.getRowCount() > 0)){
            throw new MareException(null, null,UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COB
                                                                                 , "", ErroresDeNegocio.COB_012));
        } 

        UtilidadesLog.info("ExtensionCOBBean.validacionEntreExclusivas(MareDTO datos): Salida");
    }

    /**
     * 
     * @date 13/05/05
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * //Debemos ver si la etapa deuda tiene activado el parámetro de balanceo 
        obtenemos la propiedad oidEtapaDeuda de datos 
        Accedemos a la entidad COB_ETAPA_DEUDA 
        filtrando por: 
        OID_ETAP_DEUD = oidEtapaDeuda 
        TBAL_OID_TIPO_BALA <> null 
        
        obtenemos: 
        OID_ETAP_DEUD 
        
        Si obtenemos algún registro { 
        Lanzamos una MareException con el mensaje COB-013 ("Esta etapa no permite balanceo. No pueden asignarse varios usuarios a la misma" ) 
        } 
     */
    public void validacionUsuariosCronogramaCob(MareDTO datos) throws MareException{
    
        UtilidadesLog.info("ExtensionCOBBean.validacionUsuariosCronogramaCob(MareDTO datos): Entrada");
    
        BelcorpService bs;
        StringBuffer query = new StringBuffer("");
        RecordSet rs = null;
        
        Long paramId = (Long) datos.getProperty("id");
        
        query.append(" SELECT  ");
             query.append(" oid_etap_deud  ");
        query.append(" FROM  ");
            query.append(" COB_ETAPA_DEUDA ");
        query.append(" WHERE ");
            query.append(" OID_ETAP_DEUD = " + paramId);
            query.append(" AND TBAL_OID_TIPO_BALA is not null ");
        
        try 
        {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            
        }  catch (MareMiiServiceNotFoundException ex) {
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs != null || !rs.esVacio()){
            throw new MareException(null, null,UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COB
                                                                                 , "", ErroresDeNegocio.COB_013));
        } 
        
        UtilidadesLog.info("ExtensionCOBBean.validacionUsuariosCronogramaCob(MareDTO datos): Salida");
    }
    
    /**
     * 
     * @date 13/05/05
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * //Debemos ver si la etapa deuda tiene activado el parámetro de balanceo 
        obtenemos la propiedad oidPais de datos 
        Accedemos a la entidad COB_ACCIO_COBRA 
       
        filtrando por: 
        PAIS_OID_PAIS = oidPais 
        IND_ACCI_MENS_RECO = 1 
        
        obtenemos: 
        OID_ACCI_COBR 
        
        Si obtenemos algún registro { 
        Lanzamos una MareException con el mensaje COB-014 ("Ya existe una acción previa de tipo mensaje recordatorio. No se permite la definición de mas de una dentro del país" ) 
        } 

     */
    public void validacionRecordatorio(MareDTO datos) throws MareException{
    
        UtilidadesLog.info("ExtensionCOBBean.validacionRecordatorio(MareDTO datos): Entrada");
      
        BelcorpService bs;
        StringBuffer query = new StringBuffer("");
        RecordSet rs = null;
        
        Long paramPais = (Long) datos.getProperty("paisOidPais");
        Long paramAcciMensReco = (Long) datos.getProperty("indAcciMensReco");
        
        if (paramAcciMensReco!= null && paramAcciMensReco.longValue() ==1){
        
            query.append(" SELECT  ");
                 query.append(" OID_ACCI_COBR   ");
            query.append(" FROM  ");
                query.append(" COB_ACCIO_COBRA ");
            query.append(" WHERE ");
                query.append(" PAIS_OID_PAIS = " + paramPais);
                query.append(" AND IND_ACCI_MENS_RECO = 1 ");
            
            try 
            {
                bs = BelcorpService.getInstance();
                rs = bs.dbService.executeStaticQuery(query.toString());
                
            }  catch (MareMiiServiceNotFoundException ex) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            // Cambiado por ssantana, 16/8/2005
            // Se cambia operador de || a &&
            if (rs != null && !rs.esVacio()){
                throw new MareException(null, null,UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COB
                                                                                     , "", ErroresDeNegocio.COB_014));
            } 
        }       
    
        UtilidadesLog.info("ExtensionCOBBean.validacionRecordatorio(MareDTO datos): Salida");
    }


    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * El método comprueba que no exista un registro en la tabla COB_GUION_ARGUM_DETAL con el mismo orden
        de argumento recibido
        Entrada: DTOMare dto 
     */
    public void validacionOrdenArgumento(MareDTO dto) throws MareException{
    
        UtilidadesLog.info("ExtensionCOBBean.validacionOrdenArgumento(MareDTO dto): Entrada");
    
        StringBuffer qry = new StringBuffer("");
        RecordSet rs = null;
        BelcorpService bs;
        Long paramNumOrdeArgu = (Long) dto.getProperty("numOrdeArgu");
        Long paramGacaOidGuioArguCabe = (Long) dto.getProperty("gacaOidGuioArguCabe");
        
        qry.append (" SELECT ");
            qry.append (" * ");
        qry.append (" FROM ");
            qry.append (" COB_GUION_ARGUM_DETAL AD ");
        qry.append (" WHERE ");
        qry.append ("     AD.GACA_OID_GUIO_ARGU_CABE = " + paramGacaOidGuioArguCabe.toString());
        qry.append (" AND AD.NUM_ORDE_ARGU = " + paramNumOrdeArgu.toString());
        try{
                bs = BelcorpService.getInstance();
                rs = bs.dbService.executeStaticQuery(qry.toString());
                
            }  catch (MareMiiServiceNotFoundException ex) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }catch (Exception e) {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        if (rs == null || !rs.esVacio()){
            throw new MareException(null, null,UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COB
                                                                                     , "", ErroresDeNegocio.COB_015));
        }    
        
        UtilidadesLog.info("ExtensionCOBBean.validacionOrdenArgumento(MareDTO dto): Salida");
    }
    
    private EtapasDeudaLocalHome getEtapasDeudaLocalHome()
    {
        return new EtapasDeudaLocalHome();
    }

    private AccionesCobranzaLocalHome getAccionesCobranzaLocalHome()
    {
        return new AccionesCobranzaLocalHome();
    }
}