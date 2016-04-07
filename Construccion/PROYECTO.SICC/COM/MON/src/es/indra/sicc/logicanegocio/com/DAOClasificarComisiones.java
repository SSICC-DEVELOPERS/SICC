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
 
package es.indra.sicc.logicanegocio.com;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.com.DTOClasificarComisiones;
import es.indra.sicc.dtos.com.DTOComisiones;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import java.math.BigDecimal;


public class DAOClasificarComisiones 
{
    public DAOClasificarComisiones()
    {
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida buscarComisiones(DTOClasificarComisiones dtoEntrada) 
        throws MareException  {
//1. Se recibe un DTOClasificarComisiones con oidPeriodo, oidCanal, oidMarca 
//2. Se realizar una busqueda JDBC, recuperando todos los campos de la tabla 
//COM_COMIS buscando todos los registros que cumplan lo siguiente: 
//-canal y marca sean los llegados por parámetro 
//Y 
//- estado = ConstantesCOM.ESTADO_COMISION_ACTIVA 
//Y 
//-el atributo periodos de espera = 0 

//Ó 

//- canal y marca sean los llegados por parámetro 
//Y 
//- estado = ConstantesCOM.ESTADO_COMISION_ACTIVA 
//Y 
//-el atributo periodos de espera <> 0 
//Y 
//atributo periodo desde <= (periodo recibido como parametro - atributo periodos 
//de espera) <= atributo periodo hasta 

//Notas: 
//1. Si hay varias versiones para la misma comisión, se debe tomar aquella que 
//tenga el periodo entrada vigor < al periodo recibido por parametro 
//2. Se debe tomar para el rango periodo desde, periodo hasta, la fecha de inicio 
//del periodo desde, y la fecha de fin del periodo hasta en donde la fecha de 
//inicio y fin del periodo buscado se encuentre entre esos valores, teniendo en 
//cuenta el valor del campos periodos de espera. 


//3.Se crea un DTOSalida "dtoSalida" 
//4. Se asigna el recordser al dtoSalida 
//5.Se retorna el dtoSalida 

        UtilidadesLog.info("DAOClasificarComisiones.buscarComisiones(DTOClasificarComisiones dtoEntrada): Entrada");

        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
      
        query.append(" SELECT com.*  "); 
        query.append(" FROM (SELECT *  "); 
        query.append(" FROM com_comis  "); 
        query.append(" WHERE (COD_COMI, NUM_VERS) IN (  "); 
        query.append(" SELECT comis.COD_COMI, MAX(comis.NUM_VERS)  "); 
        query.append(" FROM com_comis comis,  "); 
        query.append(" cra_perio pi,  "); 
        query.append(" cra_perio ppp  "); 
        query.append(" WHERE comis.PERD_OID_PERI_VIGO_MODI = pi.oid_peri(+)  "); 
        query.append(" AND comis.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA); 
        query.append(" AND comis.OID_COMI = " + dtoEntrada.getOidComision()); 
        query.append(" AND comis.TPLA_OID_TIPO_PLAN  = " + dtoEntrada.getOidTipoComision()); 
        query.append(" AND ppp.oid_peri(+)= " + dtoEntrada.getOidPeriodo()); 
        query.append(" AND pi.CANA_OID_CANA(+) = " + dtoEntrada.getOidCanal()); 
        query.append(" AND pi.MARC_OID_MARC(+) = " + dtoEntrada.getOidMarca()); 
        query.append(" AND pi.fec_inic <= ppp.fec_inic(+) ");
        query.append(" AND pi.FEC_FINA >= ppp.FEC_FINA(+) "); 
        query.append(" GROUP BY comis.COD_COMI)) com, ");
        query.append(" cra_perio pi, ");
        query.append(" cra_perio pf, ");
        query.append(" cra_perio ppp, ");
        query.append(" (SELECT oidperiodo, q ");
        query.append(" FROM (SELECT ROWNUM q, oidperiodo ");
        query.append(" FROM (SELECT p.oid_peri oidperiodo, p.fec_inic ");
        query.append(" FROM cra_perio pent, ");
        query.append(" cra_perio p, ");
        query.append(" seg_perio_corpo pc ");
        query.append(" WHERE pent.oid_peri = " + dtoEntrada.getOidPeriodo());
        query.append(" AND p.fec_inic <= pent.fec_inic ");
        // dmorello, 29/05/2006: Se corrige el join poniendo p.peri_oid_peri
        //query.append(" AND pc.oid_peri = p.oid_peri ");
        query.append(" AND pc.oid_peri = p.peri_oid_peri ");
        query.append(" AND p.pais_oid_pais = pent.pais_oid_pais ");
        query.append(" AND p.marc_oid_marc = pent.marc_oid_marc ");
        query.append(" AND p.cana_oid_cana = pent.cana_oid_cana ");
        query.append(" ORDER BY p.fec_inic DESC, pc.cod_peri))) oidperiodon ");
        query.append(" WHERE com.perd_oid_peri = pi.oid_peri ");
        query.append(" AND com.perd_oid_peri_hast = pf.oid_peri ");
        query.append(" AND com.OID_COMI = " + dtoEntrada.getOidComision()); 
        query.append(" AND com.TPLA_OID_TIPO_PLAN  = " + dtoEntrada.getOidTipoComision()); 
        query.append(" AND pi.marc_oid_marc = " + dtoEntrada.getOidMarca());
        query.append(" AND pi.cana_oid_cana = " + dtoEntrada.getOidCanal());
        query.append(" AND com.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
        query.append(" AND NVL(com.num_peri_espe,0) != 0 ");
        query.append(" AND ppp.oid_peri = oidperiodon.oidperiodo ");
        query.append(" AND NVL(com.num_peri_espe,0) + 1 = oidperiodon.q ");
        query.append(" AND pi.fec_inic <= ppp.fec_inic ");
        query.append(" AND ppp.fec_fina <= pf.fec_fina ");
        query.append(" UNION ");
        query.append(" SELECT com.* ");
        query.append(" FROM (SELECT * ");
        query.append(" FROM com_comis ");
        query.append(" WHERE (COD_COMI, NUM_VERS) IN ( ");
        query.append(" SELECT comis.COD_COMI, MAX(comis.NUM_VERS) ");
        query.append(" FROM com_comis comis, ");
        query.append(" cra_perio pi, ");
        query.append(" cra_perio ppp ");
        query.append(" WHERE comis.PERD_OID_PERI_VIGO_MODI = pi.oid_peri(+) ");
        query.append(" AND comis.OID_COMI = " + dtoEntrada.getOidComision()); 
        query.append(" AND comis.TPLA_OID_TIPO_PLAN  = " + dtoEntrada.getOidTipoComision()); 
        query.append(" AND comis.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
        query.append(" AND ppp.oid_peri(+)=  " + dtoEntrada.getOidPeriodo());
        query.append(" AND pi.CANA_OID_CANA(+) = " + dtoEntrada.getOidCanal());
        query.append(" AND pi.MARC_OID_MARC(+) = " + dtoEntrada.getOidMarca());
        query.append(" AND pi.fec_inic <= ppp.fec_inic(+) ");
        query.append(" AND pi.FEC_FINA >= ppp.FEC_FINA(+) ");
        query.append(" GROUP BY comis.COD_COMI)) com, ");
        query.append(" cra_perio pi, ");
        query.append(" cra_perio pf, ");
        query.append(" cra_perio ppp ");
        query.append(" WHERE com.perd_oid_peri = pi.oid_peri ");
        query.append(" AND com.perd_oid_peri_hast = pf.oid_peri ");
        query.append(" AND pi.marc_oid_marc = " + dtoEntrada.getOidMarca());
        query.append(" AND pi.cana_oid_cana = " + dtoEntrada.getOidCanal());
        query.append(" AND com.ceco_oid_esta_comi = " + ConstantesCOM.ESTADO_COMISION_ACTIVA );
        query.append(" AND com.OID_COMI = " + dtoEntrada.getOidComision()); 
        query.append(" AND com.TPLA_OID_TIPO_PLAN  = " + dtoEntrada.getOidTipoComision()); 
        query.append(" AND NVL(com.num_peri_espe,0) = 0 ");
        query.append(" AND ppp.oid_peri = " + dtoEntrada.getOidPeriodo());
        query.append(" AND pi.fec_inic <= ppp.fec_inic ");
        query.append(" AND ppp.fec_fina <= pf.fec_fina ");

        UtilidadesLog.info("Query:  " + query.toString()); 

        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {   
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOClasificarComisiones.buscarComisiones(DTOClasificarComisiones dtoEntrada): Salida");
        return dtoS; 
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida recuperarGerentes(DTOComisiones dtoComision) throws MareException
    {
/*Esta consulta recupera todos los clientes que sean gerentes y estén 
 * relacionados con una determinada comision*/ 

//->Crear un DTOSalida "dtoSalida" 
//->Hacer una consulta JDBC de la siguiente manera: 

//->Cruzar la entidad "Comisiones Cliente", "TipoClienteComisionCabecera", "TipoClienteComisionDetalle", "Clasificacion (MAE)", "Cliente Clasificacion (MAE)", "Cliente Tipo Sub Tipo (MAE)", "Cliente Datos Basicos (MAE)" 
//Utilizaremos las entidades de zonificación para determinar si el gerente es gerente, "Zona" (ZON), "Region" (ZON), "Seccion" (ZON), 
//"SubgerenciaVentas" (ZON). Tener en cuenta que un gerente solo puede gerenciar dentro de un mismo nivel de zonificación. 

//Por ejemplo: Un gerente puede gerenciar en varias zonas pero no puede gerenciar en zonas y regiones al mismo tiempo. 

//Recuperando: ClienteDatosBasicos.oidCliente y ClienteDatosAdicionales.codigoEmpleado en donde 
//ClienteDatosBasicos.pais = dto.get(oidPais) y 
//ComisionesClientes.oidComision = dot.get(oidComision) y clienteDatosBasicos.fechaIngreso se encuentre entre 
//ComisionesClientes.fechaAntiguedadDesde y ComisionesClientes.fechaAntiguedadHasta y el oidCliente (MAE) coincida 
//con el oid cliente de una subgerencia, region, zona o seccion 

//-> Encapsular el recordset en el dtoSalida 

//-> Retornar el dtoSalida
        UtilidadesLog.info("DAOClasificarComisiones.recuperarGerentes(DTOComisiones dtoComision): Entrada");

        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        query.append(" ");
        
        query.append("SELECT distinct CLI.OID_CLIE , ");
        query.append(" CDA.COD_EMPL, CCC.VAL_TOPE_MAXI, CCC.VAL_TOPE_MINI ");
        query.append(" FROM  ");
        query.append(" COM_COMIS CC, ");
        query.append(" COM_COMIS_CLIEN CCC, ");
        query.append(" COM_TIPO_CLIEN_COMIS_CABEC TCCC, ");
        query.append(" COM_TIPO_CLIEN_COMIS_DETAL TCCD, ");
        query.append(" MAE_CLASI CLAS, ");
        query.append(" MAE_CLIEN_CLASI CLASI, ");
        query.append(" MAE_CLIEN_TIPO_SUBTI CTS, ");
        query.append(" MAE_CLIEN CLI, ");
        query.append(" MAE_CLIEN_DATOS_ADICI CDA, ");
        query.append(" COM_COMIS_CLIEN CC2 ");
        query.append(" WHERE ");
        query.append(" CCC.comi_oid_comi =  CC.oid_comi ");
        query.append(" AND CCC.tccc_oid_tipo_clie_comi_cabe  = TCCC.oid_tipo_clie_comi_cabe ");
        query.append(" AND TCCC.PAIS_OID_PAIS = " + dtoComision.getOidPais());
        query.append(" AND TCCD.tccc_oid_tipo_clie_comi_cabe = TCCC.oid_tipo_clie_comi_cabe ");
        query.append(" AND CLAS.oid_clas = TCCD.clas_oid_clas ");
        query.append(" AND CLASI.clas_oid_clas = CLAS.oid_clas  ");
        query.append(" AND CLASI.ctsu_oid_clie_tipo_subt = CTS.oid_clie_tipo_subt ");
        query.append(" AND CTS.clie_oid_clie =  CLI.oid_clie ");
        query.append(" AND CLI.oid_clie = CDA.clie_oid_clie ");
        query.append(" AND CLI.OID_CLIE IN ( ");
        //-- - - - - - - - - - - - -  G E R E N T E S  P O R   Z O N I F I C A C I O N - - - - - - - - - - - -   
                query.append(" SELECT oid_clie  ");
                query.append(" FROM   mae_clien, ");
                query.append(" zon_regio regio	   ");
                query.append(" WHERE  regio.CLIE_OID_CLIE = mae_clien.oid_clie ");
                query.append(" AND regio.ind_borr = " + ConstantesCMN.VAL_FALSE);
                query.append(" AND regio.ind_acti = " + ConstantesCMN.VAL_TRUE);
                query.append(" AND regio.PAIS_OID_PAIS = " + dtoComision.getOidPais());
                query.append(" UNION ");
                query.append(" SELECT oid_clie  ");
                query.append(" FROM   mae_clien, ");
                query.append(" zon_secci sexy ");
                query.append(" WHERE  sexy.CLIE_OID_CLIE = mae_clien.oid_clie ");
                query.append(" AND sexy.ind_borr = " + ConstantesCMN.VAL_FALSE);
                query.append(" AND sexy.ind_acti = " + ConstantesCMN.VAL_TRUE);
                
                query.append(" union	    ");
                query.append(" SELECT oid_clie  ");
                query.append(" FROM   mae_clien, ");
                query.append(" zon_zona zona	 ");
                query.append(" WHERE  zona.CLIE_OID_CLIE = mae_clien.oid_clie ");
                query.append(" AND zona.ind_borr = " + ConstantesCMN.VAL_FALSE);
                query.append(" AND zona.ind_acti = " + ConstantesCMN.VAL_TRUE);
                query.append(" AND zona.PAIS_OID_PAIS = " + dtoComision.getOidPais());
                
                query.append(" union ");
                query.append(" SELECT oid_clie  ");
                query.append(" FROM   mae_clien, ");
                query.append(" zon_sub_geren_venta subge	   ");
                query.append(" WHERE  subge.CLIE_OID_CLIE = mae_clien.oid_clie ");
                query.append(" AND subge.ind_borr = " + ConstantesCMN.VAL_FALSE);
                query.append(" AND subge.ind_acti = " + ConstantesCMN.VAL_TRUE);
                query.append(" AND subge.PAIS_OID_PAIS = " + dtoComision.getOidPais());
                query.append(" ) AND ");
        //-- - - - - - - - - - - - -  G E R E N T E S  P O R   Z O N I F I C A C I O N - - - - - - - - - - - - 	   
        query.append(" CLI.PAIS_OID_PAIS = " + dtoComision.getOidPais());
        query.append(" AND CC.OID_COMI = " + dtoComision.getOid());
        
        query.append(" AND CC2.COMI_OID_COMI = CC.OID_COMI  ");
        query.append(" AND CLI.FEC_INGR BETWEEN NVL(CC2.FEC_ANTI_DESD, CLI.FEC_INGR)  AND NVL(CC2.FEC_ANTI_HAST, CLI.FEC_INGR) ");
        
        query.append(" order by CLI.OID_CLIE,  CDA.COD_EMPL ");
        

        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) 
        {   
        UtilidadesLog.error(ex);
        throw new MareException(ex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOClasificarComisiones.recuperarGerentes(DTOComisiones dtoComision): Salida");
        return dtoS;
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public Boolean comprobarComisionesCalculadas(Long oidCliente, Long oidComision, Long oidPeriodo) throws MareException
    {
//-> Se hace una consulta JDBC en la entidad ComisionesCalculadas filtrando por 
//los parametros recibidos, 
//-> Si consulta != vacio 
//retornar true 
//-> sino 
//retornar false 
//-> fin si 
//} 
        UtilidadesLog.info("DAOClasificarComisiones.comprobarComisionesCalculadas(Long oidCliente, Long oidComision, Long oidPeriodo): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        Boolean bRetorno;
        
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        
        query.append("SELECT OID_COMI_CALC ");
        query.append(" FROM COM_COMIS_CALCU ");
        query.append(" WHERE ");
        query.append(" CLIE_OID_CLIE = " + oidCliente );
        query.append(" AND COMI_OID_COMI = " +  oidComision );
        query.append(" AND PERD_OID_PERI = " +  oidPeriodo  );

        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex)  {   
        UtilidadesLog.error(ex);
        throw new MareException(ex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if ( !rs.esVacio() )
        {
            bRetorno = Boolean.TRUE;    
        }
        else
        {
            bRetorno = Boolean.FALSE;
        } 
        UtilidadesLog.info("DAOClasificarComisiones.comprobarComisionesCalculadas(): Salida");
        return bRetorno;        
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida recuperarGerentesComisionados(Long oidPeriodo) throws MareException
    {
//-> Se crea DTOSalida dtoSalida 
//-> Se recibe un DTOClasificarComisiones 
//-> Con los datos recibidos en el dto, hacer una consulta JDBC de la siguiente manera. 
//-> Hacer una consulta JDBC con las entidades "Comisiones Calculadas" filtrando 
//el oidPeriodo recibido por parámetro, recuperando distintos el oidCliente y 
//en donde: estado = ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE 
//-> Se encapsula el resultado del recordset en dtoSalida 
//-> Se retorna dtoSalida    
 
        UtilidadesLog.info("DAOClasificarComisiones.recuperarGerentesComisionados(Long oidPeriodo): Entrada");
        
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;        
        
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }    
        
        query.append("SELECT DISTINCT(CLIE_OID_CLIE) ");
        query.append(" FROM COM_COMIS_CALCU ");
        query.append(" WHERE PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND ESCO_OID_ESTA_COMI_CLIE = " + ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE);

        UtilidadesLog.info("Query:  " + query.toString()); 

        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {  
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOClasificarComisiones.recuperarGerentesComisionados(Long oidPeriodo): Salida");
        return dtoS;
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida comisionesCalculadas(Long oidCliente, Long oidPeriodo) throws MareException
    {
//-> DTOSalida dtoSalida 
//Se hace una consulta JDBC en la entidad "ComisionesCalculadas" 
//accediendo por oidCliente y por periodo y donde 
//comisionCalculada.estado = ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE y 
//comisionCalculada.fechaCalculo = fecha del sistema, recuperando todas los campos 
//de la entidad "ComisionesCalculadas" y se agrega un ultimo campo "TotalImporte" 
//que será la suma de todos los importes de los registros recuperados 
//-> en encapsula el resultado de la consulta en el dtoSalida 
//-> se retorna dtoSalida 
        UtilidadesLog.info("DAOClasificarComisiones.comisionesCalculadas(Long oidCliente, Long oidPeriodo): Entrada");

        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        query.append(" ");

        query.append("SELECT OID_COMI_CALC,  ");
        query.append(" FEC_CALC,  ");
        query.append(" IMP_SCON,  ");
        query.append(" IMP_COMI,  ");
        query.append(" VAL_PORC_COMI, "); 
        query.append(" PERD_OID_PERI,  ");
        query.append(" CLIE_OID_CLIE,  ");
        query.append(" ESCO_OID_ESTA_COMI_CLIE,  ");
        query.append(" FORP_OID_FORMA_PAGO,  ");
        query.append(" TPLA_OID_TIPO_PLAN,  ");
        query.append(" COMI_OID_COMI,  IMP_COMI TOT_IMP_COMI ");
        query.append(" FROM COM_COMIS_CALCU  ");
        query.append(" WHERE ");
        query.append(" CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND ESCO_OID_ESTA_COMI_CLIE = " + ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE);        
        //query.append(" AND FEC_CALC = TO_CHAR(SYSDATE,'DD/MM/YYYY')  ");
        query.append(" AND FEC_CALC = TRUNC(SYSDATE)  ");

        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex)  {   
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        // hacer sumatoria de campos por afuera
        double totalImporte = 0;
        for( int i=0; i<rs.getRowCount(); i++ ){
            totalImporte += ((BigDecimal) rs.getValueAt(i, "IMP_COMI")).doubleValue();
        }

        UtilidadesLog.debug("totalImporte Sumado:  " + totalImporte);       
        for( int i=0; i<rs.getRowCount(); i++ ){        
            String sImporte =  new BigDecimal(totalImporte).toString();
            rs.setValueAt(sImporte.toString(), i, 10); // u 11
        }
        
        dtoS.setResultado(rs);        
        UtilidadesLog.info("DAOClasificarComisiones.comisionesCalculadas(Long oidCliente, Long oidPeriodo): Salida");
        return dtoS;        
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida recuperarAccesos(Long oidComision, Long oidCanal) throws MareException
    {
 
        //-> Efectuar una consulta JDBC en las entidades haciendo Join entre 
        //Comisiones, 
        //ComisionesAcceso, 
        //PlantillasComisionesAcceso, 
        //filtrando por el oidComision recibido por parametro, recuperando de 
        //la entidad PlantillaComisionesAcceso el respectivo oidAcceso 
        //-> Retornar el oidAcceso
        UtilidadesLog.info("DAOClasificarComisiones.recuperarAccesos(Long oidComision, Long oidCanal): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService belcorpService;
        RecordSet rs;
        String codigoError;        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
            UtilidadesError.armarCodigoError(codigoError));
        }
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(" SELECT PCA.acce_oid_acce ");
            stringBuffer.append(" FROM com_plant_comis_acces PCA, ");
            stringBuffer.append(" com_comis COM , ");
            stringBuffer.append(" com_comis_acces CAC  ");
            stringBuffer.append(" WHERE  ");
            stringBuffer.append(" PCA.oid_plan_comi_acce = CAC.plca_oid_plan_comi_acce ");
            stringBuffer.append(" AND COM.oid_comi = CAC.comi_oid_comi ");
            stringBuffer.append(" AND COM.PLCO_OID_PLAN_COMI = PCA.PLCO_OID_PLAN_COMI ");
            stringBuffer.append(" AND COM.OID_COMI = " + oidComision.toString());   
            stringBuffer.append(" AND PCA.CANA_OID_CANA = " + oidCanal.toString());
        
        try {
            rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
            UtilidadesError.armarCodigoError(codigoError));
        }
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOClasificarComisiones.recuperarAccesos(Long oidComision, Long oidCanal): Salida");
        return (dtoSalida);
    }

 /**    
       *@Author: cargain 
       *@Fecha: 10/04/2005
       *@paquete: N034
       *@return: 
       *@param: 
       *@Observaciones: Diseñador tecnico: 
      */
    public DTOSalida obtenerCongelado(Long oidCliente, Long oidPeriodo) throws MareException
    {
//DAOClasificarComisiones.obtenerCongelado(oidCliente : Long, oidPeriodo : Long) : DTOSalida
//-> Crear DTOSalida "dtoSalida"
//-> Se realiza una consulta JDBC sobre la entidad Congelados obteniendo: 
//oidCongelado, importe, indDesconAutom filtrando por oidCliente y que la 
//fecha desde y fecha hasta del periodo recibido por parámetro este comprendida 
//entre la fecha desde y la fecha hasta del congelado.
//-> Encapsular el resultado en el dtoSalida
//-> Retornar dtoSalida
    
        UtilidadesLog.info("DAOClasificarComisiones.obtenerCongelado(Long oidCliente, Long oidPeriodo): Entrada");

        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try
        {   
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException ex)
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT OID_CONG, IMP_CONG, IND_DESC_AUTO ");
        query.append(" FROM COM_CONGE ");
        query.append(" WHERE ");
        query.append(" CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND FEC_DESD <=  ");
        query.append(" (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + oidPeriodo );
        query.append(" ) and (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = " + oidPeriodo + " )" );
        query.append(" <= FEC_HAST ");
      
        try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) 
        {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        
        UtilidadesLog.debug("Resultado: " + rs);
        
        dtoS.setResultado(rs);
        UtilidadesLog.info("DAOClasificarComisiones.obtenerCongelado(Long oidCliente, Long oidPeriodo): Salida");
        return dtoS;
    }
    
     /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       12/05/2005
     * @version     1.0
     * @autor       Viviana Bongiovanni
     */
    public Long obtenerPeriodoNAnterior(Long oidPeriodo, Integer offset) throws MareException{
    
        UtilidadesLog.info("DAOClasificarComisiones.obtenerPeriodoNAnterior(Long oidPeriodo, Integer offset): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex) { 
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
      
        query.append(" SELECT B.oid_peri oid, b.FEC_INIC fechaIni  "); 
        query.append(" FROM cra_perio A, "); 
        query.append(" cra_perio B"); 
        //query.append(" , SEG_PERIO_CORPO C ");
        query.append(" WHERE A.oid_peri = " + oidPeriodo); 
        query.append(" AND B.pais_oid_pais = A.pais_oid_pais "); 
        query.append(" AND B.marc_oid_marc = A.marc_oid_marc "); 
        query.append(" AND B.cana_oid_cana = A.cana_oid_cana "); 
        query.append(" AND B.fec_inic <= A.fec_inic ");
        //Gacevedo. DBLG700000231. el oid_peri de periodo corporativo
        //no es lo mismo que oid_peri de cra_perio. Aunque no se para que esta
        //en el query si no es filtro ni se muestran campos de seg_periodo_corpo
        //query.append(" AND C.OID_PERI=B.PERI_OID_PERI "); 
        query.append(" ORDER BY fechaIni DESC "); 

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
            
        }  catch (Exception ex) {   
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }	
        
        Long nOidPeriodo = Long.valueOf(rs.getValueAt(offset.intValue(), "OID").toString());
        UtilidadesLog.debug("oidPeriodo: " + nOidPeriodo);
        
        UtilidadesLog.info("DAOClasificarComisiones.obtenerPeriodoNAnterior(Long oidPeriodo, Integer offset): Salida");
        return nOidPeriodo; 
    }
}
