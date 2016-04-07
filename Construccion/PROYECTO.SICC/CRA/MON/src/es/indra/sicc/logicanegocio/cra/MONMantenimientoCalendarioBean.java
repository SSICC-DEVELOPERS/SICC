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

package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOCalendario;
import es.indra.sicc.dtos.cra.DTOFeriado;
import es.indra.sicc.dtos.cra.DTOSalidaCalendario;
import es.indra.sicc.entidades.cra.CalendarioLocal;
import es.indra.sicc.entidades.cra.CalendarioLocalHome;
import es.indra.sicc.logicanegocio.cra.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Administracion Calendario
 * Componente:        MONMantenimientoCalendario
 * Fecha:             05/11/2003
 * Documentacion:     Este componente se construyó de acuerdo a SICC-DMCO-CRA-201-300
 * Reconstruccion:    Se aplico pl/sql para el manejo de gran numero de movimientos en la BBDD.
 *                    Se baso en la incidencia 8817 y demas incidencias realcionadas.
 *                    
 * @version           1.0
 * @autor             Marcelo Jorge Maidana
 * @version           2.0
 * @autor             CRA Team
 */


public class MONMantenimientoCalendarioBean implements SessionBean {

    private SessionContext ctx;

    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void ejbRemove(){
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;    
    }


    /**
    * Metodo que inserta en BBDD en la tabla CRA_CALEN y en la Tabla CRA_FERIA.
    * Utilizando pl/sql, en CRA_FERIA se insertan los días festivos para el anio pasado por parámetro, 
    * entendiendo como festivos sabados y domingos (segun indSabado e indDomingo),
    * para pais, marca, canal y los grupos de zonas pasados por parametros.
    * 
    * Reconstruccion: se aplica la incidencia 8817 para utilizar pl/sql.
    * Se aplico primero la incidencia 9927 y luego fue reemplazada por la incidencia 10009.
    * 
    * @autor lrgiacos
    * @autor gdmarzi
    */
    public void insertaFeriado(DTOCalendario dto) throws  MareException {
        UtilidadesLog.info("MONMantenimientoCalendarioBean.insertaFeriado(DTOCalendario dto):Entrada");
        BelcorpService belcorpService;      
        String codigoError = null;

        //Datos del dto de Calendario recibido por parámetro
        Integer anyo = dto.getAnyo();
        Vector feriados = dto.getFeriados();
        Long oidCanal = dto.getOidCanal();
        Long oidMarca = dto.getOidMarca();
        Long oidPais = dto.getOidPais();

        // 1.- Comprueba si existe un Calendario (EJB Entity): Calendario.findByUK(oidPais, oidMarca, oidCanal, anyo) 
        CalendarioLocalHome calendatioLocalHome = new CalendarioLocalHome();
        try {
            calendatioLocalHome.findByUK(oidPais, oidMarca, oidCanal, anyo);

            // 2.- Si existiera (el finder retorna un objeto),
            // se devuelve una MareException YA_EXISTE_UN_CALENDARIO_PARA_EL_ANIO_INDICADO 
            UtilidadesLog.debug(ErroresDeNegocio.YA_EXISTE_UN_CALENDARIO_PARA_EL_ANIO_INDICADO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_CRA, "", 
                    ErroresDeNegocio.YA_EXISTE_UN_CALENDARIO_PARA_EL_ANIO_INDICADO ) );
        } catch (NoResultException fex) {
            // 3.- Se crea un objeto en Calendario (EJBEntity) con: 
            try {
                //Create del entity: anyo, oidCanal, oidMarca, oidPais. Sí al reves del find.
                calendatioLocalHome.create(anyo,oidMarca,  oidCanal, oidPais);
            } catch(PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        // 4.- Se crea una variable de tipo String grupoZona que se inicializa a "". 
        String grupoZona = "";
        // 4.1.- Por cada elemento DTOFeriado (feriado) de feriados se hace: 
        for (int i = 0; i < feriados.size(); i++) {
            // en grupoZona quedan todos los oids de grupos de zona concatenados y separados por ","
            DTOFeriado dtoF = (DTOFeriado) feriados.get(i);
            if (!grupoZona.equals("")) {
                grupoZona += ",";
            }
            grupoZona += dtoF.getOidGrupoZona(); 
        }
    
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        CallableStatement callableStatement;
        Connection connection= null;

        // 5.- Se llama al procedimiento empaquetado pr_crear_calendario pasándole como parámetros de entrada
        try {    
            String sCallStament = "BEGIN pq_apl_cra.pr_crear_calendario(?,?,?,?,?,?,?); END;";
			
            connection = belcorpService.dbService.getConnection();
			
            callableStatement = connection.prepareCall(sCallStament);
			
            callableStatement.setInt(1,dto.getAnyo().intValue());
            callableStatement.setLong(2,dto.getOidPais().longValue());
            callableStatement.setLong(3,dto.getOidMarca().longValue());
            callableStatement.setLong(4, dto.getOidCanal().longValue());
            callableStatement.setString(5, grupoZona);
            if (dto.getIndSabado() != null && dto.getIndSabado().booleanValue()) {
              callableStatement.setInt(6,1);         
            } else {
              callableStatement.setInt(6,0);         
            }
            if (dto.getIndDomingo() != null && dto.getIndDomingo().booleanValue()) {
                callableStatement.setInt(7,1);         
            } else {
                callableStatement.setInt(7,0);         
            }

            callableStatement.execute();
        } catch(java.sql.SQLException sqlEx) {
            UtilidadesLog.error(sqlEx);
            throw new MareException(sqlEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } finally{
            try {
                connection.close();
            } catch(Exception ex) {
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("MONMantenimientoCalendarioBean.insertaFeriado(DTOCalendario dto):Salida");
    }




/**
 * Método que actualiza una entrada de la tabla Calendario. 
 * Para ello hace una llamada al método findByPrimaryKey del entity Calendario 
 * pasándole la clave primaria recibida en el parámetro de entrada pais, vinculo, 
 * año y fecha. 
 * Sobre el entity recibido hará la llamada al método set con la 
 * informacion actualizada recibida como parámetro. 
 * Se captura las excepciones FinderException y RemoteException. En caso de que 
 * se produzca una excepción, se crea una instancia de MareException con la 
 * excepción capturada y un código que dependerá de dicha excepción: 
 * - FinderException: error de acceso a BBDD y de lectura en BBDD 
 * - RemoteException: error de acceso a BBDD 
 * - Error de Lectura en Base de Datos: 0000000002 
 * - Error de Escritura en Base de Datos: 0000000001 
 * - Error de Acceso en Base de Datos: 0000000003 
 * - Error peticion de datos no existente: 0000000005 
 * Se lanza la excepción y se finaliza la ejecución del método. 
 * En caso de que no se produzca ninguna excepción no se devuelve nada.
 * @autor lrgiacos
 */

  public void modificaFeriado(DTOCalendario dto) throws  MareException {
      UtilidadesLog.info("MONMantenimientoCalendarioBean.modificaFeriado(DTOCalendario dto):Entrada");
      Vector feriados = dto.getFeriados();
      boolean bEncontrado = false;
      BelcorpService belcorpService;      

      ArrayList grupoZona = new ArrayList();
      ArrayList actividad = new ArrayList();
      ArrayList festivo = new ArrayList();
      ArrayList noLaborables = new ArrayList();

      for (int i = 0; i < feriados.size(); i++) {
          bEncontrado = false;
          DTOFeriado dtoF = (DTOFeriado) feriados.get(i);

          //Recorro grupoZonas
          for (int j = 0; j < grupoZona.size(); j++) {
              Long oidGZ = (Long) grupoZona.get(j);
              if (oidGZ.equals(dtoF.getOidGrupoZona())) {
                  bEncontrado = true;
                  break;
              }
          }
          if (!bEncontrado) {
              grupoZona.add(dtoF.getOidGrupoZona());
          }

          //Recorro actividades
          bEncontrado = false;
          for (int j = 0; j < actividad.size(); j++) {
              Long oidAct = (Long) actividad.get(j);
              if (oidAct.equals(dtoF.getOidActividad())) {
                  bEncontrado = true;
                  break;
              }
          }
          if (!bEncontrado) {
              actividad.add(dtoF.getOidActividad());
          }

          //Recorro festivo
          if (dtoF.getIndicadorFestivo() != null && dtoF.getIndicadorFestivo().booleanValue()) {
              bEncontrado = false;
              for (int j = 0; j < festivo.size(); j++) {
                  Date diaFer = (Date) festivo.get(j);
                  if (diaFer.equals(dtoF.getDiaFeriado()) && 
                          dtoF.getIndicadorFestivo() != null && dtoF.getIndicadorFestivo().booleanValue()) {
                      bEncontrado = true;
                      break;
                  }
              }
              if (!bEncontrado) {
                  festivo.add(dtoF.getDiaFeriado());
              }
          } else {
              //Recorro noLaborable
              bEncontrado = false;
              for (int j = 0; j < noLaborables.size(); j++) {
                  Date diaFer = (Date) noLaborables.get(j);
                  if (diaFer.equals(dtoF.getDiaFeriado()) && 
                          (dtoF.getIndicadorFestivo() == null || !dtoF.getIndicadorFestivo().booleanValue())) {
                      bEncontrado = true;
                      break;
                  }
              }
              if (!bEncontrado) {
                  noLaborables.add(dtoF.getDiaFeriado());
              }
          }
          
      }

      String grpZona = "";
      for (int i = 0; i < grupoZona.size(); i++) {
          Long oidGZ = (Long) grupoZona.get(i);
          if (!grpZona.equals("")) {
              grpZona += ",";
          }
          grpZona += oidGZ; 
      }

      String activ = "";
      for (int i = 0; i < actividad.size(); i++) {
          Long oidAct = (Long) actividad.get(i);
          if (!activ.equals("")) {
              activ += ",";
          }
          activ += oidAct; 
      }

      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      String fest = "";
      for (int i = 0; i < festivo.size(); i++) {
          Date diaFer = (Date) festivo.get(i);
          if (!fest.equals("")) {
              fest += ",";
          }
          fest += sdf.format(diaFer); 
      }

      String noLab = "";
      for (int i = 0; i < noLaborables.size(); i++) {
          Date diaFer = (Date) noLaborables.get(i);
          if (!noLab.equals("")) {
              noLab += ",";
          }
          noLab += sdf.format(diaFer); 
      }

      try {
        belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
        UtilidadesLog.error(serviceNotFoundException);
        ctx.setRollbackOnly();
        throw new MareException(serviceNotFoundException, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      CallableStatement callableStatement;
      Connection connection= null;

      try {    
          String sCallStament = "BEGIN pq_apl_cra.pr_modificar_calendario(?,?,?,?,?); END;";
			
          connection = belcorpService.dbService.getConnection();
			
          callableStatement = connection.prepareCall(sCallStament);
			
          callableStatement.setInt(1,dto.getAnyo().intValue());
          callableStatement.setString(2,grpZona);
          callableStatement.setString(3,activ);
          callableStatement.setString(4, fest);
          callableStatement.setString(5, noLab);

          callableStatement.execute();
      }
      catch(java.sql.SQLException sqlEx) {
          UtilidadesLog.error(sqlEx);
          throw new MareException(sqlEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      catch(Exception ex) {
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      finally{
          try {
            connection.close();
          }
          catch(Exception ex) {
              UtilidadesLog.error(ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
    }
    UtilidadesLog.info("MONMantenimientoCalendarioBean.modificaFeriado(DTOCalendario dto):Salida");

  }


    /**
    * Eliminar el calendario para un pais, marca, canal y anyo.
    * Previamente verifica que exista el calendario y que no tenga un cronograma asociado.
    * Se elimina la entrada en CRA_CALEN y las entradas en CRA_FERIA.
    * @autor gdmarzi
    */
    public void eliminaFeriado(DTOCalendario dto) throws  MareException {
        UtilidadesLog.info("MONMantenimientoCalendarioBean.eliminaFeriado(DTOCalendario dto):Entrada");
        // Datos del dto
        Integer anyo = dto.getAnyo();
        Long oidPais = dto.getOidPais();
        Long oidMarca = dto.getOidMarca();
        Long oidCanal = dto.getOidCanal();

        // 0.- Verifica que el calendario no tenga un cronograma asociado.
        this.verificarCalendarioCronogramaAsociado(oidPais, oidMarca, oidCanal, anyo);
        
        // 1.- Obtiene el Calendario: Calendario.findByUK(oidPais, oidMarca, oidCanal, anyo) 
        CalendarioLocalHome calendarioLocalHome = new CalendarioLocalHome();
        CalendarioLocal calendarioLocal;
        try {
            calendarioLocal = calendarioLocalHome.findByUK(oidPais, oidMarca, oidCanal, anyo);
        } catch (NoResultException fex) {
            // 2.- Si no se obtienen resultados se genera una excepción NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO 
            UtilidadesLog.debug(ErroresDeNegocio.NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_CRA, "", 
                    ErroresDeNegocio.NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO ) );
        }
        // 3.- Se elimina de la entidad (EJB Entity) Calendario el objeto cuyo oid es el obtenido en el paso anterior. 
        try {
            calendarioLocalHome.remove(calendarioLocal);
        } catch (PersistenceException rex) {
            UtilidadesLog.debug(rex);
            ctx.setRollbackOnly();
            throw new MareException(rex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_BORRADO_DE_DATOS));						
        }

        // 4.- Se llama al método DAOCRA.eliminaFeriados(oidPais, oidMarca, oidCanal, anyo) 
        DAOCRA daoCra = new DAOCRA();
        daoCra.eliminaFeriados(oidPais, oidMarca, oidCanal, anyo);        
        UtilidadesLog.info("MONMantenimientoCalendarioBean.eliminaFeriado(DTOCalendario dto):Salida");
    }


    /**
     * Verifica si el calendario posee un cronograma asociado.
     * Si tienen un cronograma asociado lanza una excepción: El Calendario ya tiene un cronograma asociado.
     * @autor gdmarzi
     */
    private void verificarCalendarioCronogramaAsociado(Long oidPais, Long oidMarca, Long oidCanal, Integer anyo) throws MareException {
        UtilidadesLog.info("MONMantenimientoCalendarioBean.verificarCalendarioCronogramaAsociado(Long oidPais, Long oidMarca, Long oidCanal, Integer anyo):Entrada");
        BelcorpService bs;        
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();        

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT count(*) referencias ");
            buf.append(" FROM cra_crono cra, cra_perio periodo, seg_perio_corpo seg ");
            buf.append(" WHERE ");
            buf.append("  periodo.oid_peri = cra.perd_oid_peri AND ");
            buf.append("  seg.oid_peri = periodo.peri_oid_peri AND ");
            buf.append("  periodo.PAIS_OID_PAIS = ? AND ");
            buf.append("  periodo.MARC_OID_MARC = ? AND ");
            buf.append("  periodo.CANA_OID_CANA = ? AND ");
            buf.append("  seg.VAL_ANIO = ? ");
            Vector parametros  = new Vector();
            parametros.add(oidPais);
            parametros.add(oidMarca);
            parametros.add(oidCanal);
            parametros.add(anyo);
            respuesta = bs.dbService.executePreparedQuery(buf.toString(), parametros);
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // Si da 0 sigue el proceso descrito, y si da != 0 lanza una excepción MareException código CRA-0001. 
        Long referenciasCaleCrono =  new Long(((BigDecimal)respuesta.getValueAt(0,"REFERENCIAS")).toString());
        if ( referenciasCaleCrono.longValue() != 0 ) {
            UtilidadesLog.debug(ErroresDeNegocio.CALENARIO_YA_TIENE_CRONOGRAMA_ASOCIADO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_CRA, "", 
                    ErroresDeNegocio.CALENARIO_YA_TIENE_CRONOGRAMA_ASOCIADO ) );
        }
        UtilidadesLog.info("MONMantenimientoCalendarioBean.verificarCalendarioCronogramaAsociado(Long oidPais, Long oidMarca, Long oidCanal, Integer anyo):Salida");
    }


    /**
    * Método que devuelve el siguiente dia no festivo a partir de la fecha de entrada. 
    * Procesa dia a dia a partir de la fecha de entrada y devuelve aquella fecha que 
    * no tiene entrada en la entidad Feriado. 
    */
  public Date buscaDiaNoFestivo(Date fecha) throws  MareException {
    UtilidadesLog.info("MONMantenimientoCalendarioBean.buscaDiaNoFestivo(Date fecha):Entrada");
  
    String codigoError;
    BelcorpService belcorpService;        
    RecordSet respuesta;
    
    try {
            belcorpService = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException, 
                    UtilidadesError.armarCodigoError(codigoError));
    }
    
    try {
          boolean flag = false;
          Calendar cal = Calendar.getInstance();
          cal.setTime(fecha);
          while (!flag) {
            respuesta = new RecordSet();
            StringBuffer query = new StringBuffer();        
            cal.add(Calendar.DATE, 1);
            Date fechaIncrementada = new java.sql.Date(cal.getTime().getTime()); 
                      
            query.append("SELECT * FROM CRA_FERIA");
            query.append(" WHERE FEC_FERI = TO_DATE('"+ fechaIncrementada +"','yyyy-mm-dd')");
    
            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());
    
            if (respuesta.esVacio()) {
              flag = true;
              UtilidadesLog.info("MONMantenimientoCalendarioBean.buscaDiaNoFestivo(Date fecha):Salida");
              return fechaIncrementada;
            }
          }
    } catch (Exception exception) {
        UtilidadesLog.error(exception);
        codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(exception, UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONMantenimientoCalendarioBean.buscaDiaNoFestivo(Date fecha):Salida");
    return null;
  }


/**
 * Método que calcula el número de festivos que hay entre la fecha fechaInicio y la fecha fechaInicio + intervalo. 
 * Para ello realiza una consulta SQL utilizando DBService sobre la tabla Feriado para contar el número de registros que existen en esa tabla para el periodo de tiempo entre fechaInicio y fechaInicio + intervalo, ambas inclusive. 
 * El método devolverá el número devuelto por la consulta.
 */
  public Integer calculaNumeroFestivos(Date fechaInicio, Integer intervalo) throws  MareException {
        UtilidadesLog.info("MONMantenimientoCalendarioBean.calculaNumeroFestivos(Date fechaInicio, Integer intervalo):Entrada");  
        String codigoError;
        BelcorpService belcorpService;        
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();        
        BigDecimal resultado = new BigDecimal("0");
        
        try {
                belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException, 
                        UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaInicio);
            cal.add(Calendar.DATE, intervalo.intValue());            
            Date fechaFin = new java.sql.Date(cal.getTime().getTime()); 
            
            query.append("SELECT COUNT(*) FROM CRA_FERIA WHERE FEC_FERI ");
            query.append("BETWEEN TO_DATE('" + fechaInicio + "', 'yyyy-mm-dd') AND ");
            query.append("TO_DATE('"+ fechaFin +"','yyyy-mm-dd')");            
            
            respuesta = belcorpService.dbService.executeStaticQuery(query.toString());

            if (!respuesta.esVacio()) {
                Vector vector = respuesta.getColumn(respuesta.getColumnPosition("COUNT(*)")); 
                resultado = (BigDecimal) vector.get(0);
            }

        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception, UtilidadesError.armarCodigoError(codigoError));
        }
    UtilidadesLog.info("MONMantenimientoCalendarioBean.calculaNumeroFestivos(Date fechaInicio, Integer intervalo):Salida");  
    return new Integer(resultado.intValue());
  }




    /**
    * Este método recupera todos los feriados que cumplan los datos pasados por 
    * parámetro.
    *
    * @parameter   Integer pais, Integer anio, Integer marca, Integer canal, 
    *              Integer grupoZona, Date fecha
    * @exception   MareException
    * @return     dtoDTOSalidaCalendario
    */
    public DTOSalidaCalendario recuperaFeriado(DTOCalendario dto) throws MareException{
        //Devuelve un DTOSalidaCalendario con todos los feriados de 'anio' y del
        //anio anterior y siguiente a 'anio'. Esto se utiliza para cargar el 
        //Calendario, y se necesitan los feriados de estos tres anios debido a que
        //el calendario debe mostrar todo el anio actual, los meses Noviembre y 
        //Diciembre del anio anterior y los meses Enero y Febrero del anio siguiente.

        //Datos del dto
        UtilidadesLog.info("MONMantenimientoCalendarioBean.recuperaFeriado(DTOCalendario dto):Entrada");  
        Integer anio = null;
        Long oidPais = null;
        Long oidMarca = null;
        Long oidCanal = null;

        anio = dto.getAnyo();
        oidPais = dto.getOidPais();
        oidMarca = dto.getOidMarca();
        oidCanal = dto.getOidCanal();

        String codigoError;
        BelcorpService belcorpService;        
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();        

        boolean first = true;

        try {
                belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(codigoError));
        }

        // 1.- Comprueba si existe un Calendario: Calendario.findByUK(oidPais, oidMarca, oidCanal, anyo)
        try {
            CalendarioLocalHome calendarioHome = new CalendarioLocalHome();
            calendarioHome.findByUK(oidPais, oidMarca, oidCanal, anio);
        } catch (NoResultException fex) {
            // 2.- Si no hubiera resultados se genera una MareException: NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO
            UtilidadesLog.debug(ErroresDeNegocio.NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_CRA, "", 
                    ErroresDeNegocio.NO_EXISTE_CALENDARIO_PARA_ANIO_INDICADO ) );
        }

        // 3.- Construye y ejecuta la query usando DBService:
        try {
            //--- CREAR QUERY ---
            query.append("SELECT * FROM CRA_FERIA WHERE 1=1");
            query.append( " AND (NUM_ANIO >= " + (anio.intValue() - 1) + ") AND (NUM_ANIO <= " + (anio.intValue() + 1) + ")" );
      
            Vector vector = new Vector();

            DTOFeriado feriado = null;
            Vector feriados = dto.getFeriados();
            Enumeration enumFeriados = feriados.elements();
            first = true;
            boolean cerrarParentesisInterno = false;
            boolean cerrarParentesisExterno = false;
            boolean and = false;

            Long oidGrupoZona = null;
            Long oidActividad = null;
      
            Integer anioFeriado = null;

            while( enumFeriados.hasMoreElements() ){
                feriado = (DTOFeriado) enumFeriados.nextElement();
                oidGrupoZona = feriado.getOidGrupoZona();
                oidActividad = feriado.getOidActividad();
                anioFeriado = feriado.getAnio();

                and = false;

                if(first){
                    query.append( " AND (" );
                    cerrarParentesisExterno = true;
                }

                if( oidGrupoZona != null || oidActividad != null || anioFeriado != null ){
                    if (first) {
                        query.append( " (" );
                    } else {
                        query.append( " OR (" );
                    }
                    cerrarParentesisInterno = true;
                }
        
                if (oidGrupoZona != null) {
                    query.append(" CGZO_OID_CABE_GRUP_ZONA = ? ");
                    vector.add(oidGrupoZona.toString());
                    and = true;
                }

                if (oidActividad != null){
                    query.append( ((and) ? " AND" : "") + " CACT_OID_ACTI = ? ");
                    vector.add(oidActividad.toString());
                    and = true;
                }
        
                if( cerrarParentesisInterno ){
                    query.append( ")" );
                    cerrarParentesisInterno = false;
                }
                first = false;
        
            } // while

            if( cerrarParentesisExterno ){
                query.append( " )" );
            }
            respuesta = belcorpService.dbService.executePreparedQuery(query.toString(), vector);

        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * 4.- Se crea y rellena un DTOSalidaCalendario dtoSalidaCalendario (fecha sólo se rellea en el
         * caso de obtener registros en la query anterior):
         * - fecha(respuesta.getColumn(respuesta.getColumnPosition("FEC_FERI")));
         * - indicadorFestivo(respuesta.getColumn(respuesta.getColumnPosition("IND_FEST")));
         * - anno = anio
         */
        DTOSalidaCalendario dtoSalidaCalendario = new DTOSalidaCalendario();
        if ( ! respuesta.esVacio() ) {
            Vector vector = respuesta.getColumn(respuesta.getColumnPosition("FEC_FERI"));
            Vector vectorIndFestivos = respuesta.getColumn(respuesta.getColumnPosition("IND_FEST"));

            UtilidadesLog.debug("Todos los valores: " + respuesta.toString() );
            UtilidadesLog.debug("Vector Fechas: " + vector.toString() );
            UtilidadesLog.debug("Vector Ind. Festivos: " + vectorIndFestivos.toString() );
      
            dtoSalidaCalendario.setFecha(vector);
            dtoSalidaCalendario.setIndicadorFestivo( vectorIndFestivos );
            dtoSalidaCalendario.setAnno(anio);
        } 
        
        UtilidadesLog.info("MONMantenimientoCalendarioBean.recuperaFeriado(DTOCalendario dto):Salida");

        return dtoSalidaCalendario;
    }


  /**
   * Usado para verificar la existencia de un valor determinado en un vector
   */
  private boolean isValueInVector( Long valueToSearch, Vector vector ){

    if( valueToSearch == null || vector == null )
      return false;

    boolean valueExists = false;
    Long longInVector = null;
    long lval = valueToSearch.longValue();
    long lvalVector;
    Enumeration e = vector.elements();

    while( e.hasMoreElements() ){
      longInVector = (Long)e.nextElement();
      lvalVector = longInVector.longValue();

      if( lval == lvalVector ){
        valueExists = true;
        break;
      }
    }
    return valueExists;
  }

  /*
   * Se crean nuevos DTOFeriados solo con los campos 'Grupo zona', 'Anio' y
   * 'Fecha', debido a que el DTOCalendario obtenido se usara para busqueda
   * y se necesita buscar por los campos mencionados, debido a que forman la
   * Unique Key. Este metodo es invocado por 'insertaFeriado()'.
   * */
  private DTOCalendario obtenerDTOConsulta( DTOCalendario dto ){
    UtilidadesLog.info("MONMantenimientoCalendarioBean.obtenerDTOConsulta( DTOCalendario dto ):Entrada");
    DTOCalendario calendarioNew  = new DTOCalendario();
    DTOFeriado dtofNew = null;
    DTOFeriado dtofOld = null;
    
    Vector FeriadosNew = new Vector();
    Vector FeriadosOld = dto.getFeriados();
    Enumeration e = FeriadosOld.elements();

    while( e.hasMoreElements() ){
      dtofOld = (DTOFeriado)e.nextElement();
      dtofNew = new DTOFeriado();
      dtofNew.setOidGrupoZona( dtofOld.getOidGrupoZona() );
      dtofNew.setAnio( dtofOld.getAnio() );
      dtofNew.setDiaFeriado( dtofOld.getDiaFeriado() );
      FeriadosNew.add( dtofNew );
    }
    
    calendarioNew.setFeriados( FeriadosNew );
    UtilidadesLog.info("MONMantenimientoCalendarioBean.obtenerDTOConsulta( DTOCalendario dto ):Salida");
    return calendarioNew;
  }


}
