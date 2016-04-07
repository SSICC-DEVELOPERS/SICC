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
 *
 */

package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.UtilidadesLog;
import java.sql.Timestamp;
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;

import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.cra.util.TADCronograma;

import es.indra.sicc.util.DTOBoolean;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.sql.Date;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.entidades.cra.MatrizDiasLocal;
import es.indra.sicc.entidades.cra.MatrizDiasLocalHome;
import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.entidades.cra.ActividadLocalHome;
import es.indra.sicc.entidades.cra.ClasesActividadLocal;
import es.indra.sicc.entidades.cra.ClasesActividadLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.cra.CronogramaGruposZonaLocal;
import es.indra.sicc.entidades.cra.CronogramaGruposZonaLocalHome;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocal;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;

import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import java.util.Iterator;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;



public class CNCronogramaGrupos implements ICNCronograma  {
  private TADCronograma tadCrono;
  private Vector periodos = null;

  public void setTadCrono(TADCronograma newTadCrono) {
	tadCrono = newTadCrono;
  }

  /** Genera el cronograma de fase 1 **/
  public DTOCronograma generaCronograma(DTOCronograma dto) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.generaCronograma(DTOCronograma dto):Entrada");
	  DTOPeriodo periodo;
	  try {
		  MONPeriodosHome mph = this.getMONPeriodosHome();
		  MONPeriodos monPerio = mph.create();
		  DTOPeriodo dtoParam = new DTOPeriodo();
		  dtoParam.setPais(dto.getOidPais());
		  dtoParam.setMarca(dto.getMarca());
		  dtoParam.setCanal(dto.getCanal());
		  dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
		  periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);

	  } catch (RemoteException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch(NamingException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch (CreateException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
	  }

	  dto.setPeriodo(periodo.getOid());
	  DAOCronograma daoCrono = new DAOCronograma();
	  RecordSet rs = daoCrono.obtieneCronogramaGrupoPMCP(dto.getOidPais(), dto.getMarca(), dto.getCanal(), dto.getPeriodo());
	  for (int i = 0; i < rs.getRowCount(); i++) {
		  Long oidCrono = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
		  CronogramaGruposZonaLocal cronoLocal = null;
		  try {
			  CronogramaGruposZonaLocalHome cronoLH = new CronogramaGruposZonaLocalHome();
			  cronoLocal = cronoLH.findByPrimaryKey(oidCrono);
			  cronoLH.remove(cronoLocal);
              
		  } catch(NoResultException e) {
			  UtilidadesLog.debug(e);
			  throw new MareException(e, UtilidadesError.armarCodigoError(
					  CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		  } catch (PersistenceException removeException) {
			  UtilidadesLog.debug(removeException);  
			  throw new MareException(removeException,
				  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
		  }       

	  }

	  DTOMatrizDias dtoMatriz = new DTOMatrizDias();
	  dtoMatriz.setOidPais(dto.getOidPais());
	  dtoMatriz.setMarca(dto.getMarca());
	  dtoMatriz.setCanal(dto.getCanal());
	  dtoMatriz.setOidIdioma(dto.getOidIdioma());
	  dtoMatriz.setGrupos(new Vector());

	  DAOMatrizDias daoM = new DAOMatrizDias();
	  RecordSet rsMatriz = daoM.obtieneMatrizPorPMCG(dtoMatriz);
	  tadCrono = new TADCronograma(dto, false);
	  tadCrono.estableceDiasPeriodo(periodo.getFechaInicio(), periodo.getFechaFin());
	  for (int i = 0; i < rsMatriz.getRowCount(); i++) {
		  Long oidMatriz = new Long(((BigDecimal) rsMatriz.getValueAt(i, "OID")).toString());
		  generaActividadGrupo(oidMatriz, dto.getOidIdioma(), dto.getPeriodo(), dto);
	  }
	  UtilidadesLog.info("CNCronogramaGrupos.generaCronograma(DTOCronograma dto):Salida");
	  return tadCrono.getCronograma();
  }


  private void eliminaCronoSiExiste(DTOCronograma dto) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.eliminaCronoSiExiste(DTOCronograma dto):Entrada");

	  try {
		  MONPeriodosHome mph = this.getMONPeriodosHome();
		  MONPeriodos monPerio = mph.create();
		  DTOPeriodo dtoParam = new DTOPeriodo();
		  dtoParam.setPais(dto.getOidPais());
		  dtoParam.setMarca(dto.getMarca());
		  dtoParam.setCanal(dto.getCanal());
		  dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
		  DTOPeriodo periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);

		  if (periodo.getOid() == null) //No se encontró el período
			  throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		  dto.setPeriodo(periodo.getOid());

	  } catch (RemoteException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch(NamingException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch (CreateException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
	  }

	  DAOCronograma daoCrono = new DAOCronograma();
	  RecordSet rs = daoCrono.obtieneCronogramaGrupoPMCP(dto.getOidPais(), dto.getMarca(), 
																						   dto.getCanal(), dto.getPeriodo());

	  for (int i = 0; i < rs.getRowCount(); i++) {
		  Long oidCrono = new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString());
		  CronogramaGruposZonaLocal cronoLocal = null;
		  try {
			  CronogramaGruposZonaLocalHome cronoLH = new CronogramaGruposZonaLocalHome();
			  cronoLocal = cronoLH.findByPrimaryKey(oidCrono);
			  cronoLH.remove(cronoLocal);
              
		  } catch(NoResultException e) {
			  UtilidadesLog.debug(e);
			  throw new MareException(e, UtilidadesError.armarCodigoError(
					  CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		  } catch (PersistenceException removeException) {
			  UtilidadesLog.debug(removeException);
			  throw new MareException(removeException,
				  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
		  }       

	  }
	  UtilidadesLog.info("CNCronogramaGrupos.eliminaCronoSiExiste(DTOCronograma dto):Salida");
  }


  /** Actualiza el cronograma pasado por parámetro en la base de datos. **/
  public void actualizaCronograma (DTOCronograma dto) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.actualizaCronograma (DTOCronograma dto):Entrada");
	  //Si existe lo tengo que eliminar. Ej. se hizo guardar en la pantalla sin regenerar
	  eliminaCronoSiExiste(dto);
	  tadCrono = new TADCronograma(dto);
	  Vector actividades = tadCrono.obtieneActividades();
	  if (actividades != null) {
		  for (int i = 0; i < actividades.size(); i++) {
			  DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);
			  CronogramaGruposZonaLocal cronoLocal;
			  CronogramaGruposZonaLocalHome cronoGrupoLocalHome = new CronogramaGruposZonaLocalHome();            
			  if (dtoA.getOid() == null) {
				  try {
                                      cronoLocal = cronoGrupoLocalHome.create(dtoA.getPeriodo(),
                                                                                dtoA.getGrupo(), 
                                                                                dtoA.getActividad(),
                                                                                dtoA.getTipoFacturacion(),
                                                                                dtoA.getTipoDias(),
                                                                                dtoA.getFecha0(),
                                                                                dtoA.getFechaPrevista(),
                                                                                dtoA.getIdVista());

				  } catch (EntityExistsException eee) {
					  UtilidadesLog.debug(eee);
					  throw new MareException(eee,
						  UtilidadesError.armarCodigoError(
							  CodigosError.ERROR_DE_CLAVE_DUPLICADA));
				  } catch (PersistenceException pe) {
					  UtilidadesLog.debug(pe);
					  throw new MareException(pe,
						  UtilidadesError.armarCodigoError(
							  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
				  } catch (Exception exception){
					  UtilidadesLog.error(exception);
					  throw new MareException(exception,
						  UtilidadesError.armarCodigoError(
							  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
				  }
			  } else {
				  try {
					  cronoLocal = cronoGrupoLocalHome.findByPrimaryKey(dtoA.getOid());

				  } catch (NoResultException nre) {
						UtilidadesLog.error(nre);
						throw new MareException(nre, UtilidadesError.armarCodigoError(
						CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
				  }      
			  }

			  //Modifica el objeto encontrado o creado con la información 
			  cronoLocal.setFecha0(dtoA.getFecha0());
			  cronoLocal.setFechaFinal(dtoA.getFechaFinal());
			  cronoLocal.setFechaMedia(dtoA.getFechaMedia());
			  cronoLocal.setTipoDias(dtoA.getTipoDias());
			  cronoLocal.setActividad(dtoA.getActividad());
			  cronoLocal.setIdVistaOrigen(dtoA.getActividadOrigen());
			  cronoLocal.setPeriodo(dtoA.getPeriodo());
			  cronoLocal.setGrupoZona(dtoA.getGrupo());
			  cronoLocal.setNumDiasDesplazamiento(dtoA.getDiasDesplazamiento());
			  cronoLocal.setOidPeriodoReferencia(dtoA.getPeriodoReferencia());
		          try {                            
                                cronoGrupoLocalHome.merge(cronoLocal);
		          } catch (PersistenceException pe) {
                              String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                              throw new MareException(pe, UtilidadesError.armarCodigoError(error));
		          }

			  dtoA.setOid(cronoLocal.getOid());
		  }
	  }
	  UtilidadesLog.info("CNCronogramaGrupos.actualizaCronograma (DTOCronograma dto):Salida");
  }

  public DTOBoolean existeCronograma (DTOCronograma dto) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.existeCronograma (DTOCronograma dto):Entrada");
	  try {
		  MONPeriodosHome mph = this.getMONPeriodosHome();
		  MONPeriodos monPerio = mph.create();
		  DTOPeriodo dtoParam = new DTOPeriodo();
		  dtoParam.setPais(dto.getOidPais());
		  dtoParam.setMarca(dto.getMarca());
		  dtoParam.setCanal(dto.getCanal());
		  dtoParam.setCodigoPeriodo(dto.getCodigoPeriodo());
		  DTOPeriodo periodo = monPerio.obtienePeriodosPMCCodigo(dtoParam);

		  if (periodo.getOid() == null) //No se encontró el período
			  throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		  dto.setPeriodo(periodo.getOid());

	  } catch (RemoteException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch(NamingException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	  } catch (CreateException e) {
		  UtilidadesLog.error(e);
		  throw new MareException(e,
			  UtilidadesError.armarCodigoError(
				  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
	  }

	  DAOCronograma daoCrono = new DAOCronograma();
	  RecordSet rs = daoCrono.obtieneCronogramaGrupoPMCP(dto.getOidPais(), dto.getMarca(), 
																						   dto.getCanal(), dto.getPeriodo());
	  DTOBoolean dtoB = new DTOBoolean();
	  if (rs.esVacio())
		  dtoB.setValor(false);
	  else
		  dtoB.setValor(true);
          
	  UtilidadesLog.info("CNCronogramaGrupos.existeCronograma (DTOCronograma dto):Salida");
	  return dtoB;
      
  }
  
  private Integer generaActividadGrupo (Long oidMatriz, Long idioma, Long oidPeriodo, DTOAuditableSICC dtoA) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.generaActividadGrupo (Long oidMatriz, Long idioma, Long oidPeriodo, DTOAuditableSICC dtoA):Entrada");
	  DTOCronograma crono = tadCrono.getCronograma();
	  MatrizDiasLocal matriz;
	  ActividadLocal actividad;
	  ClasesActividadLocal clase;
	  CabeceraGruposZonasLocal grupo;
	  PeriodoLocal periodo;
	  Entidadi18nLocal actividadDescripcion;
	  Entidadi18nLocal grupoDescripcion;
	  //Incidencia 5635
	  Integer idVistaOrigen = null;
	  Integer idVista = null;
	  DTOPeriodo periodoReferencia;
	  DTOActividad actividadOrigen;    
      
	  try {
		  MatrizDiasLocalHome matrizLocalHome = new MatrizDiasLocalHome();
		  matriz = matrizLocalHome.findByPrimaryKey(oidMatriz);
		  ActividadLocalHome actLocalHome = new ActividadLocalHome();
		  actividad = actLocalHome.findByPrimaryKey(matriz.getActividad());

		  //Incidencia 5635
		  if (matriz.getActividadOrigen() != null) {
			  DAOCRA dao = new DAOCRA();
			  Long matrizOrigen = dao.obtieneOrigenCronogramaGrupoZonas(matriz.getOid());
			  idVistaOrigen = generaActividadGrupo(matrizOrigen, idioma, oidPeriodo, dtoA);
		  }
		  // Comprueba si la actividad ya ha sido añadida. En tal caso, devuelve el idVista de la actividad 
		  idVista = existeActividad(matriz.getActividad(), matriz.getGrupoZona());
		  if (idVista != null){
			  UtilidadesLog.info("CNCronogramaGrupos.generaActividadGrupo (Long oidMatriz, Long idioma, Long oidPeriodo, DTOAuditableSICC dtoA):Salida");
			  return idVista;
		  }
          
		  ClasesActividadLocalHome claseLocalHome = new ClasesActividadLocalHome();
		  clase = claseLocalHome.findByPrimaryKey(actividad.getClasificacionActividad());
		  CabeceraGruposZonasLocalHome cabeceraLocalHome = new CabeceraGruposZonasLocalHome();
		  grupo = cabeceraLocalHome.findByPrimaryKey(matriz.getGrupoZona());
		  PeriodoLocalHome perioLocalHome = new PeriodoLocalHome();
		  periodo = perioLocalHome.findByPrimaryKey(oidPeriodo);
		  Entidadi18nLocalHome i18nLocalHome = new Entidadi18nLocalHome();
		  actividadDescripcion = i18nLocalHome.findByEntAtrIdioPK("CRA_ACTIV", new Long(1), idioma, actividad.getOid());
		  grupoDescripcion = i18nLocalHome.findByEntAtrIdioPK("CRA_CABEC_GRUPO_ZONA", new Long(1), idioma, grupo.getOid());
	  } catch (NoResultException nre) {
			UtilidadesLog.debug(nre);
			throw new MareException(nre, UtilidadesError.armarCodigoError(
			CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
	  } catch (Exception exception){
			UtilidadesLog.error(exception);
			throw new MareException(exception,
				UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	  }      

	  DTOActividadGrupo dtoActividad = new DTOActividadGrupo();
	  dtoActividad.setFechaPrevista(new Timestamp( estableceFechaPrevista(matriz, actividad, grupo, periodo.getFechainicio()).getTime()));
	  dtoActividad.setFecha0(matriz.getDias());

	  dtoActividad.setOid(null);
	  dtoActividad.setTipoDias(actividad.getInLaborables() == null ? Boolean.FALSE:actividad.getInLaborables());
	  dtoActividad.setActividad(actividad.getOid());
	  //Incidencia 5635
	  //dtoActividad.setActividadOrigen(matriz.getActividadOrigen());
	  dtoActividad.setActividadOrigen(idVistaOrigen);

	  dtoActividad.setGrupo(grupo.getOid());
	  dtoActividad.setPeriodo(periodo.getOid());
	  dtoActividad.setTipoFacturacion(grupo.getTipoFacturacion());
	  dtoActividad.setFechaIniPeriodo(periodo.getFechainicio());
	  dtoActividad.setFechaFinPeriodo(periodo.getFechaFin());
	  dtoActividad.setTextoGrupo(grupoDescripcion.getDetalle());
	  dtoActividad.setTextoActividad(actividadDescripcion.getDetalle());
	  dtoActividad.setCodigo(actividad.getCodigoActividad());
	  dtoActividad.setTipoActividad(actividad.getTipoActividad());
	  if ( actividad.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
            dtoActividad.setDiasDesplazamiento(new Integer(matriz.getDias().intValue()));
            periodoReferencia = this.obtenerPeriodoReferencia(periodo, matriz.getCampDesplazamiento());
            dtoActividad.setPeriodoReferencia(periodoReferencia.getOid());
            dtoActividad.setNombrePeriodoReferencia(periodoReferencia.getNombre());
            actividadOrigen = this.obtenerDatosActividad(actividad.getOidActividadOrigen());
            dtoActividad.setCodigoActividadOrigen(actividadOrigen.getCodigoActividad());
            dtoActividad.setNombreActividadOrigen(actividadOrigen.getNombreActividad());
	  }  
	  //Incidencia 5635
	  idVista = insertaActividad(dtoActividad, matriz.getDiasIntervalo(), matriz.getDiasFinal(), matriz.getDias());
	  UtilidadesLog.info("CNCronogramaGrupos.generaActividadGrupo (Long oidMatriz, Long idioma, Long oidPeriodo, DTOAuditableSICC dtoA):Salida");
	  return idVista;
  
  }


  /**
   * Indica si el día (parámetro numDias), de una actividad a ejecutar en un grupo, es laborable o no. 
   * Un dia es laborable si no es festivo ni es no laborable.
   * El dia es laborable si no hay ningun registro en la entidad cra_feria para esa actividad y grupo,
   * si aparece en cra_feria es por que es festivo(ind_fest=1) o es no laborable (ind_no_lab=1).
   * @autor gdmarzi
   */
  private boolean diaEsLaborable(Date dia, Long actividad, Long grupo) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.diaEsFestivo (Date dia, Long numDias, Long actividad, Long grupo):Entrada");
	  DAOCRA dao = new DAOCRA();
	  // verifica si el dia mas numero de dias, es laborable para la actividad y grupo.
	  boolean esLaborable = dao.verificaLaborablePorGAF(grupo, actividad, dia);
	  UtilidadesLog.info("CNCronogramaGrupos.diaEsFestivo (Date dia, Long numDias, Long actividad, Long grupo):Salida");   
	  return esLaborable;
  }


  /**
   * Indica si el día obtenido al sumar el día del calentario (parámetro dia) + el número 
   * de días (parámetro numDias), de una actividad a ejecutar en un grupo, es festivo o no. 
   * Un dia es festivo (feriado) cuando esta en la entidad CRA_FERIA con el indicador IND_FEST en 1.
   * @correccion se considera feriado (festivo) solo los dias feriados (IND_FEST en 1 en CRA_FERIA),
   * sin considerar los dias no laborables (sabados y domingos) marcados en CRA_FERIA con el indicador IND_NO_LAB en 1.
   * @autor gdmarzi
   */
  private boolean diaEsFestivo (Date dia, Long numDias, Long actividad, Long grupo) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.diaEsFestivo (Date dia, Long numDias, Long actividad, Long grupo):Entrada");
	  Calendar c = new GregorianCalendar(); 
	  c.setTime(dia);
	  c.add(Calendar.DATE, numDias.intValue());
	  Date diaMasNumDias = new java.sql.Date(c.getTime().getTime());
	  DAOCRA dao = new DAOCRA();
	  // verifica si el dia mas numero de dias, es feriado para la actividad y grupo.
	  boolean esFeriado = dao.verificaFeriadoPorGAF(grupo, actividad, diaMasNumDias);
	  UtilidadesLog.info("CNCronogramaGrupos.diaEsFestivo (Date dia, Long numDias, Long actividad, Long grupo):Salida");   
	  return esFeriado;
  }


  /**
   * Devuelve el siguiente día no festivo a una fecha (dia + numDias) para la actividad procesada en un grupo de zonas.
   * Si el día dado no es festivo lo devuelve, sino busca el siguiente hasta encontrar un dia no festivo.
   * El dia es festivo si el atributo ind_fest es uno en la entidad cra_feria.
   */
  public Date siguienteNoFestivo (Date dia, Long numDias, Long actividad, Long grupo) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.siguienteNoFestivo (Date dia, Long numDias, Long actividad, Long grupo):Entrada");  
	  int sentido;
	  Calendar c = new GregorianCalendar();
	  c.setTime(dia);
	  c.add(Calendar.DATE, numDias.intValue());
	  Date diaNoFestivo = new java.sql.Date(c.getTime().getTime());
	  //verifico si busca el proximo o el anterior dia de acuerdo al calendario.
	  if (numDias.intValue() < 0) {
		sentido = -1;
	  } else {
		sentido = 1;
	  }
	  // mientras el dia sea Festivo.
	  while (this.diaEsFestivo(diaNoFestivo,new Long(0),actividad,grupo)) {
		  c.setTime(diaNoFestivo);
		  c.add(Calendar.DATE, sentido);
		  diaNoFestivo = new java.sql.Date(c.getTime().getTime());
	  }
	UtilidadesLog.info("CNCronogramaGrupos.siguienteNoFestivo (Date dia, Long numDias, Long actividad, Long grupo):Salida");  
	return diaNoFestivo;
  }


  /**
   * Devuelve el siguiente laborable (no es festivo ni es no laborable) a una fecha (dia + numDias) para la actividad procesada en un grupo de zonas.
   * Si el día dado no es laborabel lo devuelve, sino busca el siguiente hasta encontrar un dia laborable.
   * El dia es laborable si no hay ningun registro en la entidad cra_feria para esa actividad y grupo,
   * si aparece en cra_feria es por que es festivo(ind_fest=1) o es no laborable (ind_no_lab=1).
   */
  private Date siguienteLaborable(Date dia, Long numDias, Long actividad, Long grupo) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.siguienteNoFestivo (Date dia, Long numDias, Long actividad, Long grupo):Entrada");  
	  int sentido;
	  Calendar c = new GregorianCalendar();
	  c.setTime(dia);
	  c.add(Calendar.DATE, numDias.intValue());
	  Date diaLaborable = new java.sql.Date(c.getTime().getTime());
	  //verifico si busca el proximo o el anterior dia de acuerdo al calendario.
	  if (numDias.intValue() < 0) {
		sentido = -1;
	  } else {
		sentido = 1;
	  }
	  // mientras el dia no sea Laborable.
	  while ( ! this.diaEsLaborable(diaLaborable,actividad,grupo)) {
		  c.setTime(diaLaborable);
		  c.add(Calendar.DATE, sentido);
		  diaLaborable = new java.sql.Date(c.getTime().getTime());
	  }
	UtilidadesLog.info("CNCronogramaGrupos.siguienteNoFestivo (Date dia, Long numDias, Long actividad, Long grupo):Salida");  
	return diaLaborable;
  }


  /**
   * Devuelve el resultado de sumar n días laborables a un día dado (dia + numDias) en el ámbito de 
   * actividad procesada en un grupo de zonas.  
   */
  private Date siguientesNoFestivos (Date dia, Long numDias, Long actividad, Long grupo) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.siguientesNoFestivos (Date dia, Long numDias, Long actividad, Long grupo):Entrada");  
	  int sentido;
	  //verifico si busca el proximo o el anterior dia de acuerdo al calendario.
	  if (numDias.intValue() < 0) {
		sentido = -1;
	  } else {
		sentido = 1;
	  }
	  Date fecha = dia;
	  for(long i = 0; i < numDias.longValue(); i++) { 
		fecha = this.siguienteNoFestivo(fecha, new Long(sentido), actividad, grupo); 
		//incrementa en 1 fecha 
	  } 
	  UtilidadesLog.info("CNCronogramaGrupos.siguientesNoFestivos (Date dia, Long numDias, Long actividad, Long grupo):Salida");  
	  return fecha;
  }


  /** Obtiene el tipo de facturación de la matriz correspondiente al pais, marca y canal recibidos por parámetro. **/
  public DTOCronograma obtieneTipoFacturacion (DTOCronograma dto) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.obtieneTipoFacturacion (DTOCronograma dto):Entrada");  
	  tadCrono = new TADCronograma(dto); 
	  DAOCronograma daoCrono = new DAOCronograma();
	  RecordSet rs = daoCrono.obtieneTipoFacturacionMatriz(dto.getOidPais(), dto.getMarca(), dto.getCanal(), dto.getOidIdioma());
	  for (int i = 0; i < rs.getRowCount(); i++) {
		  DTOGrupoCronograma dtoG = new DTOGrupoCronograma();
		  dtoG.setActividades(new Vector());
		  dtoG.setOid(new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString()));
		  dtoG.setTipoFacturacion(new Long(((BigDecimal) rs.getValueAt(i, "TIPOFACTURACION")).toString()));
		  dtoG.setTextoGrupo((String) rs.getValueAt(i, "TEXTOGRUPO"));

		  tadCrono.insertaGrupo(dtoG);
	  }
	  UtilidadesLog.info("CNCronogramaGrupos.obtieneTipoFacturacion (DTOCronograma dto):Salida");
	  return tadCrono.getCronograma();
  }


  /**
   * Establece la fecha prevista de una actividad, dependiendo de si tiene actividad origen.
   * Diferencia entre tipo de dias laborables o calendario.
   * - Si tipo de dias es calendario: se verifica que el día en el que se tiene que realizar la actividad
   * (Fecha de la actividad de Origen + número de días) no es festivo,
   * si lo es, se busca el siguiente día No Festivo. (Día del calendario del sistema que no esté en la entidad de feriados.).
   * - Si el tipo de días es Laborables: se debe verificar el numero de días no laborables que existen 
   * en el período de tiempo transcurrido desde el inicio de la actividad de Origen hasta el número de días,
   * y se le suman a la fecha (Fecha inicio actividad + número de días + número de festivos), 
   * validando que no caiga la nueva fecha en festivo.
   * Nota: el atributo inLaborables tiene 1 cuando son dias calendario (continuos) y 0 cuando son dias laborables.
   * @cambio sentido de desplazamiento de actividades respecto del origen.
   * @cambio dias laborables vs dias continuos(calendario) saltando numero de festivos.
   * @autor gdmarzi
   * @cambio CRA-01 la fecha prevista no se establece si el tipo de actividad es con referencia a otra campaña. 
   * @autor gdmarzi
   */
  private Date estableceFechaPrevista(MatrizDiasLocal matriz, ActividadLocal actividad, CabeceraGruposZonasLocal grupo, Date fechaIni) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.estableceFechaPrevista (MatrizDiasLocal matriz, ActividadLocal actividad, CabeceraGruposZonasLocal grupo, Date fechaIni):Entrada");
	  Long nroDiasMasNroFestivos = new Long(0);
	  Date fechaOrigen;
	  Date fechaPrevista;
	  if ( actividad.getTipoActividad().intValue() != ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
          if (matriz.getActividadOrigen() == null) {
              // -> si tipo de dias es calendario (continuos)
              if (actividad.getInLaborables() != null && actividad.getInLaborables().booleanValue()) {
                  // obtiene el siguiente dia no festivo a partir de (Fecha inicio actividad + número de días).
                  fechaPrevista = this.siguienteNoFestivo(fechaIni, matriz.getDias(), actividad.getOid(), grupo.getOid());
              } else {
                  // -> si tipo de dias es laborables
                  // obtiene el siguiente dia Laborable a partir de (Fecha inicio actividad + número de días + número de festivos y no laborables).
                  fechaPrevista = this.fechaLaborablePrevista(fechaIni, matriz.getDias(), actividad.getOid(), grupo.getOid());
              }
          } else {   
              //Debe recuperar la fecha de inicio de la actividad origen 
              MatrizDiasLocal matrizOrigen;
              ActividadLocal actividadOrigen;
              try {
                  MatrizDiasLocalHome matrizLocalHome = new MatrizDiasLocalHome();
                  matrizOrigen = matrizLocalHome.findByActividadGrupo(matriz.getActividadOrigen(), grupo.getOid());
                  ActividadLocalHome actLocalHome = new ActividadLocalHome();
                  actividadOrigen = actLocalHome.findByPrimaryKey(matrizOrigen.getActividad());
              } catch (NoResultException nre) {
                    UtilidadesLog.debug(nre);
                    throw new MareException(nre, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
              } catch (Exception exception){
                    UtilidadesLog.error(exception);
                    throw new MareException(exception,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
              }      
              fechaOrigen = estableceFechaPrevista(matrizOrigen,actividadOrigen,grupo,fechaIni); 
              // -> si tipo de dias es calendario (continuos)
              if (actividad.getInLaborables() != null && actividad.getInLaborables().booleanValue()) {
                  // obtiene el siguiente dia no festivo a partir de (Fecha inicio actividad origen + número de días).
                  fechaPrevista = this.siguienteNoFestivo(fechaOrigen, matriz.getDias(), actividad.getOid(), grupo.getOid());
              } else {
                  // -> si tipo de dias es calendario
                  // obtiene el siguiente dia Laborable a partir de (Fecha inicio actividad origen + número de días + número de festivos y no laborables).
                  fechaPrevista = this.fechaLaborablePrevista(fechaOrigen, matriz.getDias(), actividad.getOid(), grupo.getOid());
              }
              UtilidadesLog.info("CNCronogramaGrupos.estableceFechaPrevista (MatrizDiasLocal matriz, ActividadLocal actividad, CabeceraGruposZonasLocal grupo, Date fechaIni):Salida");
          }
	  } else {
          // Se coloca temporalmente la fecha de incio del periodo            
          fechaPrevista = fechaIni;            
	  } 
	  return fechaPrevista;
  }


  /**
   * Retorna la fecha laborable prevista considerando dias festivos y no laborables que debe saltear.
   * A partir de fehaIni busca la fecha prevista, segun el parametro nroDias, que indica la cantidad de dias
   * laborables que debe desplazarse, en el sentido del signo de nroDias, saltando los dias 
   * no laborables y los dias festivos que se interpongan.
   * @autor gdmarzi
   */
  public Date fechaLaborablePrevista(Date fechaIni, Long nroDias, Long oidActividad, Long oidGrupo) throws MareException {
	  int sentido;
	  int aDesplazar;
	  boolean esLaborable;
	  Date diaLaborable;
	  //verifico si busca el proximo o el anterior dia de acuerdo al calendario.
	  if (nroDias.intValue() < 0) {
		  sentido = -1;
	  } else {
		  sentido = 1;
	  }
	  //dias a desplazar en valor absoluto
	  aDesplazar = nroDias.intValue() * sentido;
	  //establece la fecha de inicio en el calendario
	  Calendar c = new GregorianCalendar();
	  c.setTime(fechaIni);
	  diaLaborable = new java.sql.Date(c.getTime().getTime());
	  //mientras tenga dias por desplazar
	  while (aDesplazar > 0 ) {
		  //establece el siguiente dia en el calendario segun el sentido de desplazamiento
		  c.add(Calendar.DATE, sentido);
		  diaLaborable = new java.sql.Date(c.getTime().getTime());
		  esLaborable = this.diaEsLaborable(diaLaborable, oidActividad, oidGrupo);
		  // si es laborable se deplazo un dia la fecha, sino (es festivo o no laborable) verifico el proximo dia.
		  if (esLaborable)  {
			  aDesplazar = aDesplazar - 1;  
		  }
	  }
	  return diaLaborable;
  }


  /**
   * Inserta una actividad en el cronograma, si diasIntervalo y diasFinal aparecen como distintos de null, 
   * la actividad es repetitiva y habrá que introducir tantas actividades de acuerdo a los valores diasFinal y diasIntervalo.
   * @autor gdmarzi
   **/
  private Integer insertaActividad(DTOActividadGrupo actividad, Long diasIntervalo, Long diasFinal, Long diasDesplazamiento) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.insertaActividad (DTOActividadGrupo actividad, Long diasIntervalo, Long diasFinal):Entrada");
    Date fechaPrevista;
    // Inserto la actividad
    Integer origen = tadCrono.insertaActividadGrupo(actividad.getGrupo(), actividad); 
    // Para la próxima repetición, la actividad origen será la que acabo de insertar  (Inc. 5635)
    actividad.setActividadOrigen(origen);

    // Si es una actividad repetitiva, calculamos la fecha prevista para cada repeticion y la insertamos.
	  if (diasIntervalo != null && diasFinal != null && diasIntervalo.longValue() > 0) {
        // Inserto las repeticiones con desplazamiento segun diasIntervalo
        int numRepeticiones = diasFinal.intValue() / diasIntervalo.intValue(); 
			  for (int i = 0; i < numRepeticiones; i++) {
            // -> si tipo de dias es calendario (continuos)
            if (actividad.getTipoDias() != null && actividad.getTipoDias().booleanValue()) {
                // obtiene el siguiente dia no festivo a partir de (Fecha inicio actividad + número de días).
                fechaPrevista = this.siguienteNoFestivo(new java.sql.Date(actividad.getFechaPrevista().getTime()), diasIntervalo, actividad.getOid(), actividad.getGrupo());
            } else {
                // -> si tipo de dias es laborables
                // obtiene el siguiente dia Laborable a partir de (Fecha inicio actividad + número de días + número de festivos y no laborables).
                fechaPrevista = this.fechaLaborablePrevista(new java.sql.Date(actividad.getFechaPrevista().getTime()), diasIntervalo, actividad.getOid(), actividad.getGrupo());
            }
            actividad.setFechaPrevista(new Timestamp(fechaPrevista.getTime()));
            // Para la próxima repetición, la actividad origen será la que acabo de insertar  (Inc. 5635)
            actividad.setActividadOrigen(tadCrono.insertaActividadGrupo(actividad.getGrupo(), actividad)); 
			  }
	  }
	  UtilidadesLog.info("CNCronogramaGrupos.insertaActividad (DTOActividadGrupo actividad, Long diasIntervalo, Long diasFinal):Salida");
	  return origen;
  }


  public DTOCronograma obtieneCronograma (DTOCronograma dto) throws MareException {
	return dto;
  }

  public void eliminaCronograma (DTOCronograma dto) throws MareException {
	  //Nada
  }


  //Incidencia 5635
  // Comprueba si una actividad existe en el cronograma 
  private Integer existeActividad(Long oidActividad, Long oidGrupoZonas) throws MareException {
	  UtilidadesLog.info("CNCronogramaGrupos.existeActividad(Long oidActividad, Long oidGrupoZonas):Entrada");
	  Vector actividades = tadCrono.obtieneActividadesGrupo(oidGrupoZonas);
	  if (actividades == null){
		  UtilidadesLog.info("CNCronogramaGrupos.existeActividad(Long oidActividad, Long oidGrupoZonas):Salida");
		  return null;
	  }

	  DTOActividadGrupo dtoMenor = null;
	  Timestamp fecha = null;
	  for (int i = 0; i < actividades.size(); i++) {
		  DTOActividadGrupo dtoAG = (DTOActividadGrupo) actividades.get(i);
		  if (dtoAG.getGrupo().equals(oidGrupoZonas) &&
			  dtoAG.getActividad().equals(oidActividad)) {

				  if (fecha == null || dtoAG.getFechaPrevista().compareTo(fecha) < 0) {
					  fecha = dtoAG.getFechaPrevista();
					  dtoMenor = dtoAG;
				  }
		  }
	  }

	  if (dtoMenor == null){
		  UtilidadesLog.info("CNCronogramaGrupos.existeActividad(Long oidActividad, Long oidGrupoZonas):Salida");
		  return null;
	  }else{
		  UtilidadesLog.info("CNCronogramaGrupos.existeActividad(Long oidActividad, Long oidGrupoZonas):Salida"); 
		  return dtoMenor.getIdVista();
	  }

  }


   /**
    * Obtiene todos los periodos del año, segun el periodo referenciado.
    * @autor gdmarzi
    */
   private Vector obtenerPeriodosMismoAnio(PeriodoLocal periodo) throws MareException{
        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodosMismoAnio():Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        Vector periodos = new Vector();
        DTOPeriodo dtoPeriodo;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        query.append(" SELECT peri.OID_PERI, peri.VAL_NOMB_PERI ");
        query.append(" FROM CRA_PERIO peri, SEG_PERIO_CORPO corpo ");
        query.append(" WHERE peri.PERI_OID_PERI = corpo.OID_PERI ");
        query.append(" AND peri.PAIS_OID_PAIS = " + periodo.getOidPais() );
        query.append(" AND peri.MARC_OID_MARC = " + periodo.getOidMarca() );
        query.append(" AND peri.CANA_OID_CANA = " + periodo.getOidCanal() );
        query.append(" AND corpo.VAL_ANIO = ( SELECT pc.VAL_ANIO ");
        query.append("                        FROM CRA_PERIO pe, SEG_PERIO_CORPO pc ");
        query.append("                        WHERE pe.OID_PERI = " + periodo.getOid());
        query.append("                        AND pe.PERI_OID_PERI = pc.OID_PERI ) ");
        query.append(" ORDER BY peri.FEC_INIC ");
        try{
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }


        for (int i = 0; i < rs.getRowCount(); i++) {
            dtoPeriodo = new DTOPeriodo();
            dtoPeriodo.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_PERI")).longValue()));
            dtoPeriodo.setNombre((String)rs.getValueAt(i,"VAL_NOMB_PERI"));
			periodos.addElement(dtoPeriodo);
        }

        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodosMismoAnio():Salida");
        return periodos;
   }


   /**
    * Retorna el periodo de referencia. A partir de un periodo tantos periodos como se indica por parametro.
    * @autor gdmarzi
    */
   private DTOPeriodo obtenerPeriodoReferencia(PeriodoLocal periodo, Integer numCampDesplazamiento) throws MareException{
        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodoReferencia():Entrada");
        DTOPeriodo periodoReferencia;
        Long oidPeriodo;
        boolean encontre = false;
        //Obtiene todos los periodos del año, segun el periodo referenciado.
        if (periodos == null) {
            periodos = this.obtenerPeriodosMismoAnio(periodo);
        }
        Iterator iter = periodos.iterator();
        int ubicacion = 0;
        while (iter.hasNext() && ( ! encontre)) {
            oidPeriodo = ((DTOPeriodo)iter.next()).getOid();
            if (oidPeriodo.longValue() == periodo.getOid().longValue()) {
                encontre = true;
            } else {
                ubicacion = ubicacion + 1;
            }
        }
        int ubicacionReferencia = ubicacion + numCampDesplazamiento.intValue();
        if (ubicacionReferencia < 0) {
            periodoReferencia = (DTOPeriodo)periodos.elementAt(0);
        } else {
            if (ubicacionReferencia >= periodos.size()) {
                periodoReferencia = (DTOPeriodo)periodos.elementAt(periodos.size()-1);
            } else {
                periodoReferencia = (DTOPeriodo)periodos.elementAt(ubicacionReferencia);
            }
        }
        UtilidadesLog.info("CNCronogramaGrupos.obtenerPeriodoReferencia():Salida");
        return periodoReferencia;        
   }


   private DTOActividad obtenerDatosActividad(Long oidActividad) throws MareException {
        UtilidadesLog.info("CNCronogramaGrupos.obtenerActividadOrigen():Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        Vector periodos = new Vector();
        DTOPeriodo dtoPeriodo;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        query.append(" SELECT activ.COD_ACTI, ");
        query.append("   PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + ConstantesSEG.IDIOMA_DEFECTO + ", activ.OID_ACTI, 'CRA_ACTIV') NOMB_ACTIV ");
        query.append(" FROM CRA_ACTIV activ ");  
        query.append(" WHERE activ.OID_ACTI = " + oidActividad);

        try{
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOActividad dtoActividad = new DTOActividad();
        dtoActividad.setCodigoActividad((String)rs.getValueAt(0,"COD_ACTI"));
        dtoActividad.setNombreActividad((String)rs.getValueAt(0,"NOMB_ACTIV"));
        return dtoActividad;
   }  
    
  private MONPeriodosHome getMONPeriodosHome() throws NamingException {
	final InitialContext context = new InitialContext();
	return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
  }



}