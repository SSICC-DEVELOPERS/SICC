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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOCriteriosBusquedaLiquidacionCom;
import es.indra.sicc.dtos.cob.DTOEscalaLiquidacion;
import es.indra.sicc.dtos.cob.DTOSimulacionComisiones;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;



import java.rmi.RemoteException;

import java.text.SimpleDateFormat;
import javax.ejb.CreateException;
import javax.ejb.SessionContext;




public class DAOCobranzaExterna {
    private SessionContext session;
  
    public DAOCobranzaExterna(){
    }
  
    public DAOCobranzaExterna(SessionContext session){
        this.session = session;
    }
  
	private BelcorpService getBelcorpService() throws MareException{

        try {
            BelcorpService bs = BelcorpService.getInstance();
            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }	
		
	}
  
    public DTOSalida listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada) throws MareException{
    
        UtilidadesLog.info("DAOCobranzaExterna.listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada): Entrada");
    
        /*
        Proceso: 
        -> Crear un DTOUsuariosPerfil "dtoUsuario" 
        -> Crear un Long "oidUsuario" 
        -> Crear un int "perfil" */

        DTOUsuariosPerfil dtoUsuario = new DTOUsuariosPerfil();
        Long oidUsuario = null;
        int perfil;

        /*
        -> Cargar el "dtoUsuario" con pais, idioma y userLogin con 
        los datos que vienen en el "dtoEntrada", excepto el del oidUsuario. */
        dtoUsuario.setLoginUsuario(dtoEntrada.getUserLogin());
        dtoUsuario.setOidPais(dtoEntrada.getOidPais());
        dtoUsuario.setOidIdioma(dtoEntrada.getOidIdioma());

        //-> oidUsuario = Llamar al método privado recuperarUsuario(dtoUsuario) 
        oidUsuario = recuperarUsuario(dtoUsuario);

        //-> perfil = llamar al método privado recuperarPerfil(oidUsuario) 
        perfil = recuperarPerfil(oidUsuario);
         DTOSalida dtoSalida=null;

        //(1) Si (dtoEntrada.usuarioCobranza == null) entonces 
        if (dtoEntrada.getUsuarioCobranza() == null)  {
            //(2) Si (perfil == ConstantesCOB.TIPO_USUARIO_COB_JEFE) entonces 
            if (perfil == ConstantesCOB.TIPO_USUARIO_COB_JEFE )  {
                dtoSalida = obtenerDatosUsuario(dtoEntrada, oidUsuario, perfil);
            } else if ( perfil == ConstantesCOB.TIPO_USUARIO_COB_SUPERVISOR )  {
                dtoSalida = obtenerDatosUsuario(dtoEntrada, oidUsuario, perfil);                    
            } else if (perfil == ConstantesCOB.TIPO_USUARIO_COB_GESTOR)  {
                dtoSalida = obtenerDatosUsuario(dtoEntrada, oidUsuario, perfil);    
            }
        } else {
            //(1) Si no 
            dtoSalida = obtenerDatosUsuario(dtoEntrada, oidUsuario, 4);    
        }
        
        
        /*Nota1: En todas las consultas se recupera una sumatoria de los campos ImporteDeudaCancelada e ImporteDeudaAsignada, agrupando por usuario, etapa, periodo y método de liquidación. 
        
        Nota2: Si el atributo "agruparPorCliente" del dto de entrada vale "true", se agrupará por cliente y se obtendrá el oid de cliente. 
        
        Nota3: Si el atributo "clientes : Long[]" es distinto de NULL se filtrará por todos los clientes que vienen informados en el parámetro, y no se filtrará ni agrupará por el usuario de cobranzas. 
        
        -> Se retorna el DTOSalida 
        //NOTA 2 y 3 fueron eliminadas
         */     
       
        UtilidadesLog.info("DAOCobranzaExterna.listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada): Salida");
       
        return dtoSalida;
    
    }
  
    public DTOEscalaLiquidacion obtenerEscalaLiquidacion (DTOSimulacionComisiones dto) throws MareException {

        UtilidadesLog.info("DAOCobranzaExterna.obtenerEscalaLiquidacion (DTOSimulacionComisiones dto): Entrada");

      /* DAOCobranzaExterna.obtenerEscalaLiquidacion(dto : DTOSimulacionComisiones) : DTOEscalaLiquidacion 
      Entrada: 
      - dto : DTOSimulacionComisiones 
      Proceso: 
      -> Crear variable llamada "resultado" de tipo DTOEscalaLiquidacion 
      -> resultado.porcentajeDeudaCancelada = "MONCobranzaExterna.calcularPorcentajeDeudaCancelada(dto : DTOSimulacionComisiones) : Float" 
      -> Crear variable llamada "importeDeudaCancelada" de tipo BigDecimal 
      -> Hacer consulta JDBC sobre la tabla COB_ESCAL_LIQUI con las siguientes condiciones 
      -> IMP_RANG_DESD_IMPO <= dto.importeDeudaCancelada < IMP_RANG_HAST_IMPO 
      -> VAL_RANG_DESD_PORC <= resultado.porcentajeDeudaCancelada < VAL_RANG_HAST_PORC 
      -> MELC_OID_METO_LIQU_COBR = dto.oidMetodoLiquidacion 
      -> Obtener los campos OID_ESCA_LIQU_COBR, NUM_ORDE_ESCA, IMP_RANG_DESD_IMPO, IMP_RANG_HAST_IMPO, VAL_RANG_DESD_PORC, VAL_RANG_HAST_PORC, IMP_COMI_PORC, IMP_COMI_IMPO, VAL_OBSE y MELC_OID_METO_LIQU_COBR 
      -> Mapear los valores del registro encontrado en el dto "respuesta" 
      -> Devolver "respuesta" */ 

    
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        DTOEscalaLiquidacion resultado = null;
        
        try{
        //-> Crear variable llamada "resultado" de tipo DTOEscalaLiquidacion 
            resultado = new DTOEscalaLiquidacion();
            
            MONCobranzaExternaHome mCEcternaHome = (MONCobranzaExternaHome) UtilidadesEJB.getHome("MONCobranzaExterna", MONCobranzaExternaHome.class);
            MONCobranzaExterna mCExterna = mCEcternaHome.create();
            
            //-> resultado.porcentajeDeudaCancelada = "MONCobranzaExterna.calcularPorcentajeDeudaCancelada(dto : DTOSimulacionComisiones) : Float" 
            Float porDeudaCanelada = mCExterna.calcularPorcentajeDeudaCancelada(dto);
            resultado.setPorcentajeDeudaCancelada(porDeudaCanelada);
            
            //-> Crear variable llamada "importeDeudaCancelada" de tipo BigDecimal 
            BigDecimal importeDeudaCancelada = null;
            
		       //Agregado por Hugo Mansi 12/12/2005
            if (porDeudaCanelada == null || porDeudaCanelada.equals(new Float(0)))
              resultado.setPorcentajeDeudaCancelada(new Float (0));
            else
              resultado.setPorcentajeDeudaCancelada(porDeudaCanelada);

            try  {
                //  Se agrego lor NVL - Modificado por HRCS - Fecha 30/03/2007 - Incidencia Sicc20070181
                query.append("SELECT SUM(NVL(IMP_COMI_IMPO,0)) IMP_COMI_IMPO, ");
				query.append("       SUM(NVL(IMP_COMI_PORC,0)) IMP_COMI_PORC ");
                query.append("FROM cob_escal_liqui   ");
                query.append("WHERE melc_oid_meto_liqu_cobr = "  + dto.getOidMetodoLiquidacion());
                query.append("     AND ((imp_rang_desd_impo <=  " + dto.getImporteDeuCancelada());
                query.append("     AND imp_rang_hast_impo >=  " + dto.getImporteDeuCancelada() + ")");
                query.append("     OR (val_rang_desd_porc <=  " + resultado.getPorcentajeDeudaCancelada());
                query.append("     AND val_rang_hast_porc >=  " + resultado.getPorcentajeDeudaCancelada() + "))");                
                
                respuesta = bs.dbService.executeStaticQuery(query.toString());

            } catch (Exception ex)  {
                throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            } 
            if (!respuesta.esVacio()){
              UtilidadesLog.debug("El recordset NO es vacio" + respuesta);    
              /*resultado.setOidEscala(objectToLong(respuesta.getValueAt(0,"OID_ESCA_LIQU_COBR")));
              resultado.setNumeroOrden(objectToInteger(respuesta.getValueAt(0,"NUM_ORDE_ESCA")));
              resultado.setImporteRangoDesde((BigDecimal)respuesta.getValueAt(0,"IMP_RANG_DESD_IMPO"));
              resultado.setImporteRangoHasta((BigDecimal)respuesta.getValueAt(0,"IMP_RANG_HAST_IMPO"));
              resultado.setPorcentajeRangoDesde(objectToFloat(respuesta.getValueAt(0,"VAL_RANG_DESD_PORC")));
              resultado.setPorcentajeRangoHasta(objectToFloat(respuesta.getValueAt(0,"VAL_RANG_HAST_PORC")));*/
              resultado.setComisionPorcentaje(objectToFloat(respuesta.getValueAt(0,"IMP_COMI_PORC")));
              resultado.setComisionImporte(objectToFloat(respuesta.getValueAt(0,"IMP_COMI_IMPO")));
              /*resultado.setObservaciones((String)respuesta.getValueAt(0,"VAL_OBSE"));
              resultado.setMetodoLiquidacion(objectToLong(respuesta.getValueAt(0,"MELC_OID_METO_LIQU_COBR")));*/
            }
            else{
              UtilidadesLog.debug("El recordset SI es vacio" + respuesta);     
              resultado = null;
            
            }
        } catch (RemoteException re) {
            UtilidadesLog.error(re);
            
            throw new MareException(re,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCobranzaExterna.obtenerEscalaLiquidacion (DTOSimulacionComisiones dto): Salida");
        
        return resultado;
    }
  
  public Long recuperarUsuario (DTOUsuariosPerfil dtoEntrada) throws MareException {
  
    UtilidadesLog.info("DAOCobranzaExterna.recuperarUsuario (DTOUsuariosPerfil dtoEntrada): Entrada");
  
    /*Esta consulta busca el oid del usuario de cobranzas logueado
    -> Se recibe dtoEntrada 
    ->Crear Long "usuario" 
    ->Hacer una consulta JDBC 
    SELECT cobusu.oid_usua_cobr OID 
    FROM principals p, users u, cob_usuar_cobra cobusu 
    WHERE p.idprincipal = u.iduser 
    AND u.iduser = cobusu.user_oid_usua_cobr 
    AND p.NAME = dtoEntrada.get (NAME) 
    AND cobusu.PAIS_OID_PAIS = dtoEntrada.get(pais) 
    ->asigno el resultado de la consulta a "usuario" 
    ->devuelvo "usuario" */
    
    
    RecordSet respuesta;
    StringBuffer query = new StringBuffer();
    
    BelcorpService bs = getBelcorpService();
		   
		try{

      query.append("  SELECT cobusu.oid_usua_cobr OID   ");
      query.append("    FROM principals p, users u, COB_USUAR_COBRA cobusu   ");
      query.append("   WHERE p.idprincipal = u.iduser   ");
      query.append("     AND u.iduser = cobusu.user_oid_usua_cobr   ");
      query.append("     AND p.NAME =  '" + dtoEntrada.getLoginUsuario() + "'");
      query.append("     AND cobusu.pais_oid_pais = " + dtoEntrada.getOidPais());     
			respuesta = bs.dbService.executeStaticQuery(query.toString());

    } catch (Exception e) {
        throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }

    Long usuario = new Long(((BigDecimal)respuesta.getValueAt(0,0)).longValue());
    
        UtilidadesLog.info("DAOCobranzaExterna.recuperarUsuario (DTOUsuariosPerfil dtoEntrada): Salida");
    
		return usuario;
  }
  
  public int recuperarPerfil (Long oidUsuario) throws MareException {
  
        UtilidadesLog.info("DAOCobranzaExterna.recuperarPerfil (Long oidUsuario): Entrada");
  
    /*    
    Recibimos un oidUsuario 
    Crear int "perfil" 
    Realizar la siguiente consulta JDBC. 
    SELECT cobUsu.IND_USUA_SUPE supervisor, 
    cobUsu.IND_JEFE_COBR jefe 
    FROM cob_usuar_cobra cobusu 
    WHERE cobUsu.OID_USUA_COBR = oidUsuario 
    
    De la consulta realizada hacer lo siguinete 
    Si supervisor = true 
    entonces perfil = 1 
    sino SI jefe = true 
    entonces perfil = 2 
    sino 
    entonces perfil = 0 
    */
    RecordSet respuesta;
    int perfil;
    Boolean supervisor = null;
    Boolean jefe = null;
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
		   
		try{

      query.append("  SELECT cobusu.ind_usua_supe supervisor, cobusu.ind_jefe_cobr jefe   ");
      query.append("    FROM COB_USUAR_COBRA cobusu   ");
      query.append("   WHERE cobusu.oid_usua_cobr =  " + oidUsuario);
			respuesta = bs.dbService.executeStaticQuery(query.toString());

    } catch (Exception e) {
        throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }

    supervisor = objectToBoolean(respuesta.getValueAt(0,0));
    jefe = objectToBoolean(respuesta.getValueAt(0,1));
    
    if (supervisor != null && supervisor.booleanValue()) {
        perfil = 1;
    } else if (jefe != null && jefe.booleanValue()) {
        perfil = 2;
    } else 
        perfil = 0;

        UtilidadesLog.info("DAOCobranzaExterna.recuperarPerfil (Long oidUsuario): Salida");

    return perfil;
  }
  
    /**
     * @author pperanzola
     * @date 21/03/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
  public RecordSet obtenerUsuariosCOB (DTOBelcorp dto) throws MareException{
  
        UtilidadesLog.info("DAOCobranzaExterna.obtenerUsuariosCOB (DTOBelcorp dto): Entrada");
  
      StringBuffer qry  = new StringBuffer();
      BelcorpService bs = null;
      RecordSet rs = null;
      
      qry.append("   SELECT cobusu.oid_usua_cobr OID, p.NAME   ");
      qry.append("     FROM principals p, users u, cob_usuar_cobra cobusu   ");
      qry.append("    WHERE p.idprincipal = u.iduser   ");
      qry.append("      AND u.iduser = cobusu.user_oid_usua_cobr   ");
      qry.append("      AND cobusu.pais_oid_pais = " + dto.getOidPais());
      qry.append("      ORDER BY UPPER(p.NAME)   ");
   
      try  {
          bs = BelcorpService.getInstance();
          rs = bs.dbService.executeStaticQuery(qry.toString());
      } catch (Exception ex) 
      {
          throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
       
        UtilidadesLog.info("DAOCobranzaExterna.obtenerUsuariosCOB (DTOBelcorp dto): Salida");
        
      return rs;  
  } 
  
  /**
     * @author pperanzola
     * @date 21/03/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
  public RecordSet obtenerGruposUsuariosCOB (DTOBelcorp dto) throws MareException {
  
        UtilidadesLog.info("DAOCobranzaExterna.obtenerGruposUsuariosCOB (DTOBelcorp dto): Entrada");
  
  
        DTOSalida dtoS = null;
        RecordSet rs = null;
        StringBuffer qry = new StringBuffer ();
        BelcorpService bs = getBelcorpService();
        
        qry.append(" SELECT ");
            qry.append(" cguc.oid_grup_usua_cobr,  ");
            qry.append(" cguc.val_desc ");
        qry.append(" FROM ");
            qry.append(" COB_GRUPO_USUAR_COBRA cguc ");
        qry.append(" WHERE ");
            qry.append(" cguc.PAIS_OID_PAIS = " + dto.getOidPais());
        
        try 
        {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(qry.toString());
        } catch (Exception ex) 
        {
            throw new MareException (ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs.esVacio()){
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("DAOCobranzaExterna.obtenerGruposUsuariosCOB (DTOBelcorp dto): Salida");
        
        return rs;
  }
  
   /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       22/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public void actualizarAsignacionesCobranzas (DTOSimulacionComisiones dto) throws MareException {
             
        UtilidadesLog.info("DAOCobranzaExterna.actualizarAsignacionesCobranzas (DTOSimulacionComisiones dto): Entrada");

        BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" UPDATE COB_ASIGN_COBRA asig ");
            buf.append(" SET asig.HICC_OID_HIST_COMI_COBR = " + dto.getOidLiquidacion());
            buf.append(" WHERE asig.OID_ASIG_COBR IN (SELECT asig2.OID_ASIG_COBR ");
            buf.append(" FROM COB_ASIGN_COBRA asig2, COB_CRONO_COBRA cro ");
            buf.append(" WHERE asig2.CRCO_OID_CRON_COBR = cro.OID_CRON_COBR ");
            buf.append(" AND cro.ETDE_OID_ETAP_DEUD = ").append(dto.getOidEtapa());
            buf.append(" AND cro.PERD_OID_PERI = ").append(dto.getOidPeriodo());            
            buf.append(" AND cro.USCO_OID_USUA_COBR = ").append( dto.getOidUsuario() );
            //gacevedo segun incidencia SiCC 20070223 (23/04/2007)
            String fecha = fs.format((java.util.Date) dto.getFechaCalculo()).toString();
            buf.append(" AND ASIG2.FEC_ASIG = TO_DATE('").append(fecha).append("','DD/MM/YYYY') ").append( " ) ");
            //fin de modificacion SiCC 20070223
            int updateValue = bs.dbService.executeUpdate(buf.toString());
            UtilidadesLog.debug("updateValue: " + updateValue);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCobranzaExterna.actualizarAsignacionesCobranzas (DTOSimulacionComisiones dto): Salida");
  }
  
    private DTOSalida obtenerDatosUsuario(DTOCriteriosBusquedaLiquidacionCom dto, Long usuario, int perfil) throws MareException {
    
        UtilidadesLog.info("DAOCobranzaExterna.obtenerDatosUsuario(DTOCriteriosBusquedaLiquidacionCom dto, Long usuario, int perfil): Entrada");
    
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        
        BelcorpService bs = getBelcorpService();
               
                /*-> Con el oidUsuario, se realiza una consulta JDBC recuperando todas la deudas 
                correspondientes a todos los usuarios de cobranza cruzando las entidades "Cronograma de cobranzas" 
                y "Asignacion de Cobranzas" y con la entidad "Usuarios Cobranzas" recuperando las columnas: 
                usuario cobranza, cód. etapa, Marca, Canal, cód. periodo, Importe deuda asignada, Importe deuda cancelada, 
                Fecha asignación, Método liquidación por defecto, Liquidación, Liquidación grupo usuarios, base escala, 
                oidUsuario, oidEtapa, oidPeriodo, oidLiquidacion, oidBaseEscala. 
                En este mismo orden y cumpliendo con los criterios que vienen en el dtoEntrada: 
                (pais, marca, canal, periodo, fechaAsignacion) 
                y ademas que en la entiddad "Asignacion de cobranzas" 
                el "estado" = ConstantesCOB.OID_ESTADO_ETAPA_POSTERIOR || 
                "estado" = ConstantesCOB.OID_ESTADO_ETAPA_CANCELADA_CG || 
                "estado" = ConstantesCOB.OID_ESTADO_ETAPA_CANCELADA_SG 
                y idLiquidacion = null, 
                -> Se cruza con la entidad "Usuarios a Etapa de Cobranza Detalle" 
                y se recupera el valor del atributo Método de liquidacion por defecto (COB_METOD_LIQUI) 
                si no tiene metodod e liquidacion se toma de el método de liquiadacion de la entidad "Etapas deuda". 
                Se obtiene la liquidacion y la Liquidacion a grupo de usuarios, 
                se obtiene la base escala cruzando con la entidad Base Escala. 
                -> Se asigna el resultado de la consulta al dtoSalida */                    
  
        //Agregado por Hugo Mansi 23/11/2005
        //Incidencia Perú
        //Recuperamos el idUser del usuario logueado
        DTOUsuariosPerfil dtoUP = new DTOUsuariosPerfil();
        dtoUP.setLoginUsuario(dto.getUserLogin());
        dtoUP.setOidPais(dto.getOidPais());
        
        DTOSalida usuarioMasID = this.recuperarUsuarioMasID(dtoUP);
        RecordSet rs = usuarioMasID.getResultado();
        Long idUser = new Long (((BigDecimal) rs.getValueAt(0,1)).longValue());
        
        
        try{
            query.append(" SELECT ROWNUM OID, A.* from ( ");
            query.append(" SELECT   p.NAME, ced.cod_etap_deud, m.des_marc, ");
            query.append(" pq_apl_aux.Valor_Gen_I18n_Sicc (").append(dto.getOidIdioma()).
                        append(", crap.cana_oid_cana, 'SEG_CANAL') AS canal, ");
            //query.append("          (SELECT v.val_i18n ");
            //query.append("             FROM v_gen_i18n_sicc v ");
            //query.append("            WHERE v.val_oid = crap.cana_oid_cana ");
            //query.append("              AND v.idio_oid_idio = " + dto.getOidIdioma());
            //query.append("              AND v.attr_num_atri = 1 ");
            //query.append("              AND v.attr_enti = 'SEG_CANAL') AS canal, ");
            query.append("          pc.cod_peri, SUM (cac.imp_deud_asig), SUM (cac.imp_deud_canc), ");
            query.append("          cac.fec_asig, NVL (cml.cod_meto_liqu, cml2.cod_meto_liqu), ");
            query.append("          NVL (cml.ind_liqu, cml2.ind_liqu), ");
            query.append("          NVL (cml.ind_liqu_grup_usua, cml2.ind_liqu_grup_usua), ");
            query.append(" pq_apl_aux.Valor_Gen_I18n_Sicc (").append(dto.getOidIdioma()).
                    append(", NVL (cbe.oid_base_esca, cbe2.oid_base_esca), 'COB_BASE_ESCAL') AS baseescala, ");
            //query.append("          (SELECT v.val_i18n ");
            //query.append("             FROM v_gen_i18n_sicc v ");
            //query.append("            WHERE v.val_oid = NVL (cbe.oid_base_esca, cbe2.oid_base_esca) ");
            //query.append("              AND v.idio_oid_idio = " + dto.getOidIdioma());
            //query.append("              AND v.attr_num_atri = 1 ");
            //query.append("              AND v.attr_enti = 'COB_BASE_ESCAL') AS baseescala, ");
            query.append("          ccc.usco_oid_usua_cobr, ccc.etde_oid_etap_deud, ccc.perd_oid_peri, ");
            query.append("          NVL (cml.oid_meto_liqu_cobr, cml2.oid_meto_liqu_cobr), ");
            query.append("          NVL (cml.baes_oid_base_esca, cml2.baes_oid_base_esca), ");
            query.append("          crap.val_nomb_peri, null cod_clie, ced.val_desc, null OID_CLIE, null  oidCLiente");
            query.append("     FROM cob_asign_cobra cac, ");
            query.append("          cob_crono_cobra ccc, ");
            query.append("          cob_etapa_deuda ced, ");
            query.append("          cob_metod_liqui cml, ");
            query.append("          cra_perio crap, ");
            query.append("          principals p, ");
            query.append("          cob_usuar_cobra cuc, ");
            query.append("          cob_usuar_etapa_cobra_detal cuecd, ");
            query.append("          cob_usuar_etapa_cobra_cabec cuecc, ");
            query.append("          cob_base_escal cbe, ");
            query.append("          cob_metod_liqui cml2, ");
            query.append("          cob_base_escal cbe2, ");
            query.append("          seg_marca m, ");
            query.append("          seg_perio_corpo pc ");
            //query.append("          ,ccc_movim_cuent_corri cmc, ");
            //query.append("          mae_clien cli ");
            query.append("    WHERE cac.crco_oid_cron_cobr = ccc.oid_cron_cobr ");
            query.append("      AND ced.oid_etap_deud = ccc.etde_oid_etap_deud ");
            query.append("      AND crap.oid_peri = ccc.perd_oid_peri ");
            query.append("      AND p.idprincipal = cuc.user_oid_usua_cobr ");
            query.append("      AND ccc.usco_oid_usua_cobr = cuc.oid_usua_cobr ");
            query.append("      AND cuecc.oid_usua_etap_cobr = cuecd.uecc_oid_usua_etap_cobr ");
            query.append("      AND cuecc.etde_oid_etap_deud = ced.oid_etap_deud ");
            query.append("      AND cuc.oid_usua_cobr = cuecc.usco_oid_usua_cobr ");
            query.append("      AND cml.oid_meto_liqu_cobr(+) = cuecd.melc_oid_meto_liqu_cobr ");
            query.append("      AND cml.baes_oid_base_esca = cbe.oid_base_esca(+) ");
            query.append("      AND cml2.oid_meto_liqu_cobr(+) = ced.melc_oid_meto_liqu_cobr ");
            query.append("      AND cml2.baes_oid_base_esca = cbe2.oid_base_esca(+) ");
            query.append("      AND NVL (cml.cod_meto_liqu, cml2.cod_meto_liqu) IS NOT NULL ");
            query.append("      AND cac.hicc_oid_hist_comi_cobr IS NULL ");
            query.append("      AND cac.pais_oid_pais = " + dto.getOidPais());
            
            // C-COB-005 - gPineda - 12/02/2007
            if (perfil == ConstantesCOB.TIPO_USUARIO_COB_JEFE){
              // No se filtra
              //query.append("      AND (cuc.USER_OID_USUA_RESP = " + idUser + " OR cuc.USER_OID_USUA_COBR = " + idUser + " ) ");
            }else if (perfil == ConstantesCOB.TIPO_USUARIO_COB_SUPERVISOR)  {
                 // Solo debe filtrar a su grupo, y a si mismo (quien debe tener la FK referenciandose a si mismo)
                 //query.append("      AND (cuc.USER_OID_USUA_SUPE = " + idUser + " OR cuc.USER_OID_USUA_COBR = " + idUser + " ) ");
                 query.append("      AND (cuc.USER_OID_USUA_SUPE = " + idUser + " ) ");
               } else if (perfil == ConstantesCOB.TIPO_USUARIO_COB_GESTOR)  {
                        // Solo a si mismo
                        query.append("      AND cuc.USER_OID_USUA_COBR = " + idUser);
               }
            //Se quita por incidencia Perú, Hugo Mansi 23/11/2005
            /*else {
              query.append("      AND cuc.OID_USUA_COBR =  " + dto.getUsuarioCobranza());  
            }*/
            if (dto.getUsuarioCobranza()!= null) 
              query.append("      AND cuc.OID_USUA_COBR =  " + dto.getUsuarioCobranza());  
            
            if(dto.getMarca()!=null)
                query.append("      AND crap.marc_oid_marc = " + dto.getMarca());
                
            if(dto.getCanal()!=null)    
                query.append("      AND crap.cana_oid_cana = " + dto.getCanal());
            
            if(dto.getPeriodo()!=null)
                query.append("      AND crap.oid_peri = " + dto.getPeriodo());
            
            // vbongiov -- 19/01/2009    
            if(dto.getEtapa()!=null) 
               query.append("      AND ced.oid_etap_deud = " + dto.getEtapa());
                
            if (dto.getFechaAsignacionString() != null) {
              query.append("      AND cac.FEC_ASIG = TO_DATE('" + dto.getFechaAsignacionString() + "','" + dto.getFormatoFecha() + "')");
            }
            query.append("      AND m.oid_marc = crap.marc_oid_marc ");
            query.append("      AND pc.oid_peri = crap.peri_oid_peri ");
            //query.append("      AND cmc.oid_movi_cc = cac.mvcc_oid_movi_cc ");
            //query.append("      AND cmc.clie_oid_clie = cli.oid_clie ");
            // Agregado por SICC20070371 - Rafael Romero - 06/08/2007
            query.append("      AND (ccc.zsgv_oid_subg_vent = cuecd.zsgv_oid_subg_vent OR (ccc.zsgv_oid_subg_vent IS NULL AND cuecd.zsgv_oid_subg_vent IS NULL)) ");
            query.append("      AND (ccc.zorg_oid_regi      = cuecd.zorg_oid_regi      OR (ccc.zorg_oid_regi      IS NULL AND cuecd.zorg_oid_regi      IS NULL)) ");
            query.append("      AND (ccc.zscc_oid_secc      = cuecd.zscc_oid_secc      OR (ccc.zscc_oid_secc      IS NULL AND cuecd.zscc_oid_secc      IS NULL)) ");
            query.append("      AND (ccc.zzon_oid_zona      = cuecd.zzon_oid_zona      OR (ccc.zzon_oid_zona      IS NULL AND cuecd.zzon_oid_zona      IS NULL)) ");
            query.append("      AND (ccc.terr_oid_terr      = cuecd.terr_oid_terr      OR (ccc.terr_oid_terr      IS NULL AND cuecd.terr_oid_terr      IS NULL)) ");
            // Fin agregado SICC20070371
            query.append(" GROUP BY p.NAME, ");
            query.append("          crap.cana_oid_cana, ");
            query.append("          ced.cod_etap_deud, ");
            query.append("          m.des_marc, ");
            query.append("          crap.val_nomb_peri, ");
            query.append("          pc.cod_peri, ");
            query.append("          cac.fec_asig, ");
            query.append("          cml.cod_meto_liqu, ");
            query.append("          cml2.cod_meto_liqu, ");
            query.append("          cml.ind_liqu, ");
            query.append("          cml2.ind_liqu, ");
            query.append("          cml.ind_liqu_grup_usua, ");
            query.append("          cml2.ind_liqu_grup_usua, ");
            query.append("          cbe.oid_base_esca, ");
            query.append("          cbe2.oid_base_esca, ");
            query.append("          ccc.usco_oid_usua_cobr, ");
            query.append("          ccc.etde_oid_etap_deud, ");
            query.append("          ced.val_desc, ");
            query.append("          ccc.perd_oid_peri, ");
            query.append("          cml.oid_meto_liqu_cobr, ");
            query.append("          cml2.oid_meto_liqu_cobr, ");
            query.append("          cml.baes_oid_base_esca, ");
            query.append("          cml2.baes_oid_base_esca )A ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
    
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        
        ///---Agregado por inc 20967
        ///--- Paola Cabrera 23/09/2005
         if( respuesta.esVacio() ){
            UtilidadesLog.debug(" No hay registros, se lanza la MareException");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }     
                
        ///---FIN Agregado por inc 20967
        ///--- Paola Cabrera 23/09/2005
        
        UtilidadesLog.debug("resultado: " + respuesta);

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(respuesta);
        
        UtilidadesLog.info("DAOCobranzaExterna.obtenerDatosUsuario(DTOCriteriosBusquedaLiquidacionCom dto, Long usuario, int perfil): Salida");
        
        return dtoSalida;
    }
    
    private Boolean objectToBoolean(Object rango) {
        if (rango != null)  {
            long valor = ((BigDecimal)rango).longValue();
            if (valor == 1){
                return new Boolean(true);
            } else {
                return new Boolean(false);        
            }
        }else
            return null;
    }

    private Long objectToLong(Object rango) {
        if (rango != null)  {
            return new Long(((BigDecimal)rango).longValue());
        }else
            return null;
    }


    private Integer objectToInteger(Object rango) {
        if (rango != null)  {
            return new Integer(((BigDecimal)rango).intValue());
        }else
            return null;
    }


    private Float objectToFloat(Object rango) {
        if (rango != null)  {
            return new Float(((BigDecimal)rango).floatValue());
        }else
            return null;
    }

    private Double objectToDouble(Object rango) {
        if (rango != null)  {
            return new Double(((BigDecimal)rango).doubleValue());
        }else
            return null;
    }
    
    public Long obtenerEtapaAnterior(Long etapa) throws MareException {
    
        UtilidadesLog.info("DAOCobranzaExterna.obtenerEtapaAnterior(Long etapa): Entrada");
    
        StringBuffer query  = new StringBuffer();
        BelcorpService bs = null;
        RecordSet rs = null;
        
        query.append("   SELECT ed.oid_etap_deud    ");
        query.append("     FROM cob_etapa_deuda ed, cob_etapa_deuda ed2    ");
        query.append("    WHERE ed.val_edad_fina < ed2.val_edad_inic    ");
        query.append("      AND ed.val_edad_fina =    ");
        query.append("             (SELECT MAX (ed3.val_edad_fina)    ");
        query.append("                FROM cob_etapa_deuda ed3    ");
        query.append("               WHERE ed3.val_edad_fina < ed2.val_edad_inic    ");
        query.append("                 AND ed2.oid_etap_deud = " + etapa + ")    ");
        query.append("      AND ed2.pais_oid_pais = ed.pais_oid_pais    ");
        query.append("      AND ed2.oid_etap_deud = " + etapa);
 
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException (ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs.esVacio()){
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB + ErroresDeNegocio.COB_009));
        }
        
        UtilidadesLog.info("DAOCobranzaExterna.obtenerEtapaAnterior(Long etapa): Salida");
        
        return new Long(((BigDecimal) rs.getValueAt(0,0)).longValue());
    }
  
public static void main(String[] args) throws Exception{
  
  DTOCriteriosBusquedaLiquidacionCom dtoEntrada  = new DTOCriteriosBusquedaLiquidacionCom();
  dtoEntrada.setCanal(new Long(1));
  dtoEntrada.setMarca(new Long(1));  
  dtoEntrada.setEtapa(new Long(1));  
  dtoEntrada.setPeriodo(new Long(57));    
  dtoEntrada.setOidPais(new Long(1));    
  dtoEntrada.setOidIdioma(new Long(1));    
  dtoEntrada.setUsuarioCobranza(new Long(10));        
  dtoEntrada.setFechaAsignacion(new java.sql.Date(System.currentTimeMillis()));
  dtoEntrada.setFormatoFecha("yyyy/MM/dd");
  DAOCobranzaExterna f = new DAOCobranzaExterna();
  f.obtenerDatosUsuario(dtoEntrada, new Long(8), 4);
}

   //Creado por Hugo Mansi
   //Fecha 23/11/2005
   //Se recupera ademas del oid el Id del usuario de cobranzas.
   //Recibe un DTOUsuariosPerfil con el pais y el login del usuario
   //Retorna un DTOSalida con un recordset que contiene oid uaurioCobranzas y idUser
   public DTOSalida recuperarUsuarioMasID (DTOUsuariosPerfil dto) throws MareException {
  
    UtilidadesLog.info("DAOCobranzaExterna.recuperarUsuarioMasID (DTOUsuariosPerfil  dto): Entrada");
  
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
      stringBuffer.append(" SELECT cobusu.oid_usua_cobr OID, u.iduser ");
      stringBuffer.append(" FROM principals p, users u, cob_usuar_cobra cobusu ");
      stringBuffer.append(" WHERE p.idprincipal = u.iduser ");
      stringBuffer.append(" AND u.iduser = cobusu.user_oid_usua_cobr  ");
      stringBuffer.append(" AND p.NAME = '" + dto.getLoginUsuario() + "' ");
      stringBuffer.append(" AND cobusu.PAIS_OID_PAIS = " + dto.getOidPais());
   
      //ejecutamos la consulta
      try {
          rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      
      
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOCobranzaExterna.recuperarUsuarioMasID (DTOUsuariosPerfil  dto): Salida");
      return dtoSalida;
      
   
   }
   
   
  
}