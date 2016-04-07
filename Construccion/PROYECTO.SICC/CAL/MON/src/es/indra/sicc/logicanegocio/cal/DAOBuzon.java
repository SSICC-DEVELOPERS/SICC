package es.indra.sicc.logicanegocio.cal;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.logicanegocio.cal.ConstantesCAL;
import java.math.BigDecimal;

public class DAOBuzon  {

  public DAOBuzon() {  }

  /**
   * Metodo: obtenerCabeceraBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: 
   */

  public RecordSet obtenerCabeceraBuzon (DTOBusqueda dtoe) throws MareException {
  
    UtilidadesLog.info("DAOBuzon.obtenerCabeceraBuzon (DTOBusqueda dtoe): Entrada");
  
  
  
    /*Accede a la entidad CabeceraBuzon filtrando por: 
      - pais = DTOE.pais 
      - codBuzon = DTOE.codBuzon 
      - descripcion = DTOE.descripBuzon 

      Accede a la entidad DetalleBuzon (si alguno de los criterios que se
      detallan son distintos de null) filtrando por: 
      - oidCabecera = CabeceraBuzon.oid //para hacer la join con CabeceraBuzon 
      - codActividad = DTOE.secActividad 
      - descripcionActividad = DTOE.descripActividad 
      - fechaHoraCreacion >= DTOE.fechaActividadDesde 
      - fechaHoraCreacion <= DTOE.fechaActividadHasta 

      Accede a la entidad Contacto y ClientesDatosBasicos
      (si el cliente que se pasa argumento en el DTOE es distinto de null): 
      - ClientesDatosBasicos.pais = DTOE.pais 
      - ClientesDatosBasicos.codCliente = DTOE.codCliente 
      - ClientesDatosBasicos.oid = Contacto.oidCliente 
      - Contacto.oid = DetalleBuzon.oidContacto //para hacer la join con DetalleBuzon 

      No se debe filtrar por aquellos atributos del DTOE que estén nulos. 
      Si todos los atributos del DTOE son nulos, excepto el país, se
      accede únicamente a la entidad CabeceraBuzon y se recuperan todas
      las cabeceras para el pais que nos pasan como argumento) 

      y obtiene: 
      CabeceraBuzon.oid 
      CabeceraBuzon.codBuzon 
      CabeceraBuzon.descripcion 
      CabeceraBuzon.id_usuario 

      ordenar esta consulta por el CabeceraBuzon.codBuzon */

      StringBuffer query = new StringBuffer();

      StringBuffer querySelect = new StringBuffer();
      StringBuffer queryFrom = new StringBuffer();
      StringBuffer queryWhere = new StringBuffer();      
      StringBuffer queryOrder = new StringBuffer();      
      
      RecordSet rs;

      //Armando SELECT
      querySelect.append(" SELECT distinct c.OID_CABE_BUZO,c.COD_BUZO, c.VAL_DESC_CABE_BUZO, c.COD_USUA ");

      //Armando FROM
      queryFrom.append(" FROM CAL_CABEC_BUZON c ");

      //Armando WHERE
      queryWhere.append(" WHERE c.PAIS_OID_PAIS = " + dtoe.getOidPais());

      if(dtoe.getCodBuzon()!=null && !dtoe.getCodBuzon().equals("")) {
        queryWhere.append(" AND c.COD_BUZO like '" + dtoe.getCodBuzon() + "'");  
      }

      if(dtoe.getDescripBuzon()!=null && !dtoe.getDescripBuzon().equals("")) {
        queryWhere.append(" AND c.VAL_DESC_CABE_BUZO like '" + dtoe.getDescripBuzon() + "'");  
      }

      boolean detalle = false;
      
      //Se añade FROM y WHERE para la tabla CAL_DETAL_BUZON
      if( (dtoe.getSecActividad()!=null) || (dtoe.getDescripActividad()!=null && !dtoe.getDescripActividad().equals("")  ) 
      || (dtoe.getFechaActividadDesde()!=null) || (dtoe.getFechaActividadHasta()!=null) ) {
        detalle = true;
      
        queryFrom.append(" ,CAL_DETAL_BUZON d ");
        

        queryWhere.append(" AND d.CABU_OID_CABE_BUZO = c.OID_CABE_BUZO ");   

        if(dtoe.getSecActividad()!=null) {
          queryWhere.append(" AND d.COD_ACTI = " + dtoe.getSecActividad());  
        }
        if(dtoe.getDescripActividad()!=null && !dtoe.getDescripActividad().equals("")) {
          queryWhere.append(" AND d.VAL_DESC_ACTI like '" + dtoe.getDescripActividad() + "'");  
        }
        if(dtoe.getFechaActividadDesde()!=null) {
          queryWhere.append(" AND d.FEC_HORA_CREA >= TO_DATE( '" + dtoe.getFechaActividadDesde() + "','YYYY-MM-DD') ");  
         
        }
        if(dtoe.getFechaActividadHasta()!=null) {
          queryWhere.append(" AND d.FEC_HORA_CREA <= TO_DATE( '" + dtoe.getFechaActividadHasta() + "','YYYY-MM-DD') ");  
        }       
      }

      //Se añade FROM y WHERE para las tablas CAL_CONTA Y MAE_CLIEN
      if(dtoe.getCodCliente()!=null && !dtoe.getCodCliente().equals("")) {
        if (!detalle) {
          queryFrom.append(" ,CAL_DETAL_BUZON d ");  
        }       

        queryFrom.append(" ,CAL_CONTA o, MAE_CLIEN m ");

        queryWhere.append(" AND m.PAIS_OID_PAIS = " + dtoe.getOidPais());      

        queryWhere.append(" AND c.OID_CABE_BUZO = d.CABU_OID_CABE_BUZO ");

        if(dtoe.getCodCliente()!=null && !dtoe.getCodCliente().equals("")) {
          queryWhere.append(" AND m.COD_CLIE = '" + dtoe.getCodCliente() + "'");  
        }
               
        queryWhere.append(" AND m.OID_CLIE = o.CLIE_OID_CLIE ");
        queryWhere.append(" AND o.OID_CONT = d.CONT_OID_CONT ");        
      }

      //Armando ORDER
      queryOrder.append(" ORDER BY c.COD_BUZO ");

      query.append(querySelect.toString());
      query.append(queryFrom.toString());
      query.append(queryWhere.toString());
      query.append(queryOrder.toString());

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (rs.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }    
      
        UtilidadesLog.info("DAOBuzon.obtenerCabeceraBuzon (DTOBusqueda dtoe): Salida");
      
      return rs;
  }

  /**
   * Metodo: obtenerDetalleBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 22/12/2004
   * Descripcion: 
   */  

  public RecordSet obtenerDetalleBuzon(DTOBusqueda dtoe) throws MareException {
  
    UtilidadesLog.info("DAOBuzon.obtenerDetalleBuzon(DTOBusqueda dtoe): Entrada");
  
  
    /*Accede a la entidad DetalleBuzon filtrando por: 
      - oidCabecera = DTOE.oidCabecera 
      - codActividad = DTOE.secActividad 
      - descripcionActividad = DTOE.descripActividad 
      - fechaHoraCreacion >= DTOE.fechaActividadDesde 
      - fechaHoraCreacion <= DTOE.fechaActividadHasta 
      - oidEstatusActividad = ConstantesCAL.NO_PROCESADO 

      Accede a la entidad TipoGestionDelCliente para obtener el
      codigo de gestión, filtrando por:: 
      - DetalleBuzon.oidGestion (+) = TipoGestionDelCliente.oid 
      //es un outer-join porque el oidGestion del DetalleBuzon puede ser nulo 

      Accede a la entidad Contacto y ClientesDatosBasicos filtrando por:: 
      - ClientesDatosBasicos.pais = DTOE.pais 
      - ClientesDatosBasicos.codCliente = DTOE.codCliente 
      - ClientesDatosBasicos.oid = Contacto.oidCliente 
      - Contacto.oid = DetalleBuzon.oidContacto //para hacer la join con DetalleBuzon 

      No se debe filtrar por aquellos atributos del DTOE que estén nulos. 

      y obtiene: 
      DetalleBuzon.oid 
      DetalleBuzon.codActividad 
      DetalleBuzon.descripcionActividad 
      ClientesDatosBasicos.codigoCliente 
      DetalleBuzon.oidContacto 
      Contacto.codContacto 
      DetalleBuzon.oidGestion 
      TipoGestionDelCliente.codGestion 
      DetalleBuzon.observaciones 

      //Además esta consulta tiene que retornarse de forma paginada
      por lo cual se debe retornar ordenada por: DetalleBuzon.oid y
      se debe restringir la consulta al número de registros
      indicados en el tamaño de página 

      Por tanto habra que tener en cuenta las siguientes consideraciones: 
      1.- oid del registro encontrado > DTOE.indicadorSituacion 
      2.- ROWNUM <= DTOE.tamanioPagina */

      StringBuffer query = new StringBuffer();    
      
      RecordSet rs;

      query.append(" SELECT d.OID_DETA_BUZO as oid, d.COD_ACTI, d.VAL_DESC_ACTI, m.COD_CLIE, ");     
      query.append(" c.COD_CONT,  b.val_i18n cod_gest, d.VAL_OBSE,  ");

   		// DBLG500000882 - cdos gPineda 13/07/2005 
      query.append(" d.FEC_HORA_CREA, d.COD_USUA, ");

      query.append(" d.CONT_OID_CONT, d.TGCL_OID_TIPO_GEST_CLIE ");

      query.append(" FROM CAL_DETAL_BUZON d, MAE_CLIEN m, CAL_CONTA c, CAL_TIPO_GESTI_CLIEN g,"); 
      query.append(" gen_i18n_sicc b ");
      
      query.append(" WHERE d.ESAC_OID_ESTA_ACTI_CONT = " + ConstantesCAL.NO_PROCESADO);

      if(dtoe.getOidCabecera()!=null) {
        query.append(" AND d.CABU_OID_CABE_BUZO = " + dtoe.getOidCabecera());  
      }

      if(dtoe.getSecActividad()!=null) {
        query.append(" AND d.COD_ACTI = " + dtoe.getSecActividad());  
      }

      if(dtoe.getDescripActividad()!=null) {
        query.append(" AND d.VAL_DESC_ACTI = '" + dtoe.getDescripActividad() + "'");  
      }

      if(dtoe.getFechaActividadDesde()!=null) {
        query.append(" AND d.FEC_HORA_CREA >= '" + dtoe.getFechaActividadDesde() + "'");  
      }

      if(dtoe.getFechaActividadHasta()!=null) {
        query.append(" AND d.FEC_HORA_CREA <= '" + dtoe.getFechaActividadHasta() + "'");  
      }    
      
      query.append(" AND d.TGCL_OID_TIPO_GEST_CLIE = g.OID_TIPO_GEST_CLIE (+) ");

      if(dtoe.getOidPais()!=null) {
        query.append(" AND m.PAIS_OID_PAIS = " + dtoe.getOidPais());  
      }

      if(dtoe.getCodCliente()!=null) {
        query.append(" AND m.COD_CLIE = '" + dtoe.getCodCliente() + "'");  
      }      
      
      
      query.append(" AND b.VAL_OID(+) = g.oid_tipo_gest_clie ");
      query.append(" AND b.attr_num_atri(+) = 1" );
      query.append(" AND b.attr_enti(+) = 'CAL_TIPO_GESTI_CLIEN'");
      query.append(" AND b.idio_oid_idio(+) = " + dtoe.getOidIdioma());
      
      query.append(" AND m.OID_CLIE = c.CLIE_OID_CLIE ");
      query.append(" AND c.OID_CONT = d.CONT_OID_CONT ");      

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoe));
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (rs.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }    
      
        UtilidadesLog.info("DAOBuzon.obtenerDetalleBuzon(DTOBusqueda dtoe): Salida");
      
      
      return rs;            
  }

  /**
   * Metodo: obtenerContactosPorCliente
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: 
   */

   public RecordSet obtenerContactosPorCliente(DTOCliente dtoe) throws MareException {
   
        UtilidadesLog.info("DAOBuzon.obtenerDetalleBuzon(DTOBusqueda dtoe): Entrada");
   
   
    /*Accede a la entidad Contacto y ClientesDatosBasicos : 
      - ClientesDatosBasicos.pais = DTOE.pais 
      - ClientesDatosBasicos.codCliente = DTOE.codCliente 
      - ClientesDatosBasicos.oid = Contacto.oidCliente 
      - Contacto.fechaHoraCierre sea igual a null 

      y obtiene de la entidad Contacto: 
      - Contacto.oid 
      - Contacto.codContacto */

      StringBuffer query = new StringBuffer();
      RecordSet rs;
    
      query.append(" SELECT c.OID_CONT, c.COD_CONT ");
      query.append(" FROM CAL_CONTA c, MAE_CLIEN m ");      
      query.append(" WHERE m.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" AND m.COD_CLIE = '" + dtoe.getCodCliente() + "' ");
      query.append(" AND m.OID_CLIE = c.CLIE_OID_CLIE ");
      query.append(" AND c.FEC_HORA_CIER is null ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (rs.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }    
      
        UtilidadesLog.info("DAOBuzon.obtenerDetalleBuzon(DTOBusqueda dtoe): Salida");
      
      
      return rs;                
   }

   /**
   * Metodo: obtenerCodBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo obtiene el oid de la cabecera y el codigo de buzon filtrando por pais
   */

   public RecordSet obtenerCodBuzon (DTOBelcorp dtoe) throws MareException {
   
    UtilidadesLog.info("DAOBuzon.obtenerCodBuzon (DTOBelcorp dtoe): Entrada");
   
   
    /*Acceder a la entidad CabeceraBuzon filtrando por: 
      - pais = DTOE.pais 

      Obtener: 
      - oid 
      - codBuzon */

      StringBuffer query = new StringBuffer();
      RecordSet rs;
    
      query.append(" SELECT OID_CABE_BUZO, COD_BUZO ");
      query.append(" FROM CAL_CABEC_BUZON ");
      query.append(" WHERE PAIS_OID_PAIS = " +  dtoe.getOidPais());      
      query.append(" ORDER BY COD_BUZO ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (rs.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }    
      
        UtilidadesLog.info("DAOBuzon.obtenerCodBuzon (DTOBelcorp dtoe): Salida");
      
      
      return rs;     
   }

   /**
   * Metodo: obtenerGestiones
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo obtiene todos los registros de la tabla CAL_TIPO_GESTI_CLIEN
   * El DTOBelcorp se recibe como parametro por si llegara a necesitarse en el futuro (Segun DT)
   */

   public RecordSet obtenerGestiones (DTOBelcorp dtoe) throws MareException {
   
        UtilidadesLog.info("DAOBuzon.obtenerGestiones (DTOBelcorp dtoe): Entrada");
   
   
    /*Acceder a la entidad: TipoGestionDelCliente 
      Obtener: 
      - oid 
      - descripcion */

      StringBuffer query = new StringBuffer();
      RecordSet rs;
    
      query.append(" SELECT OID_TIPO_GEST_CLIE, b.VAL_I18N ");
      query.append(" FROM CAL_TIPO_GESTI_CLIEN a, GEN_I18N_SICC b ");      
      query.append(" WHERE VAL_OID = OID_TIPO_GEST_CLIE ");
      query.append(" and b.ATTR_NUM_ATRI = 1 ");     
      query.append(" and b.ATTR_ENTI = 'CAL_TIPO_GESTI_CLIEN' "); 
      query.append(" AND b.IDIO_OID_IDIO =  " + dtoe.getOidIdioma());
 
    
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if (rs.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }    
      
        UtilidadesLog.info("DAOBuzon.obtenerGestiones (DTOBelcorp dtoe): Salida");
      
      return rs;          
   }  
   
    /**
   * Metodo: obtenerCabeceraBuzonCombo
   * Autor: mdolce
   * Fecha: 16/03/2005
   * Descripcion: obtiene las cabeceras y su descripcion filtrando por pais
   * recibe un dto belcorp con el pais
   */
  
   public DTOSalida obtenerCabeceraBuzonCombo(DTOBelcorp dto) throws MareException{
   
        UtilidadesLog.info("DAOBuzon.obtenerCabeceraBuzonCombo(DTOBelcorp dto): Entrada");
   
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();
     

     try {
           bs = BelcorpService.getInstance();
	
           
           query.append(" select ccb.OID_CABE_BUZO, ccb.VAL_DESC_CABE_BUZO ");
           query.append(" from cal_cabec_buzon ccb ");
           query.append(" where ccb.PAIS_OID_PAIS = " + dto.getOidPais());
           query.append(" order by 2 ");
           
           resultado = bs.dbService.executeStaticQuery(query.toString());
           
          
		 }
     catch(Exception e) {
          UtilidadesLog.error(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        

        UtilidadesLog.info("DAOBuzon.obtenerCabeceraBuzonCombo(DTOBelcorp dto): Salida");

     return dtoS;
  }
  
      /**
   * Metodo: obtenerNumeroSecuencialUltimoDetalle
   * Autor: mamontie
   * Fecha: 29/09/2005
   * Descripcion: retorna el ultimo numero secuencial asignado a un detalle dentro de un buzon
   * recibe un Long con el oidBuzon
   * Incidencia 17052
   */
  
   public Long obtenerNumeroSecuencialUltimoDetalle(Long oidBuzon) throws MareException{
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();
     

     try {
           bs = BelcorpService.getInstance();
	
           query.append(" SELECT MAX(COD_ACTI) ");
           query.append(" FROM CAL_DETAL_BUZON ");
           query.append(" WHERE CABU_OID_CABE_BUZO = " + oidBuzon );           
           UtilidadesLog.log(" antes de ejecutar la query " + query.toString() );
           resultado = bs.dbService.executeStaticQuery(query.toString());     
           UtilidadesLog.log(" despues de ejecutar la query " );
		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }
     UtilidadesLog.log("oid " + resultado );
     BigDecimal oid = null;
     if(resultado.esVacio() || resultado == null ||  (resultado.getRowCount()) == 0){ 
        return new Long(1);
     }else{
        oid = (BigDecimal)resultado.getValueAt(0,0);
        UtilidadesLog.log("oid del else" + resultado );
        if(oid == null){
          return new Long(1);
        }else {
          return new Long(oid.longValue()+1);
        }
        
     }
     
     
     
  }
  
}