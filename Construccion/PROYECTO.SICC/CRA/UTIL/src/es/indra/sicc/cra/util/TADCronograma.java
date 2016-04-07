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

package es.indra.sicc.cra.util;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.ConstantesCRA;

import es.indra.sicc.util.UtilidadesLog;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import java.text.SimpleDateFormat;

import java.sql.Date;
import java.math.BigDecimal;

import java.io.Serializable;

public class TADCronograma implements Serializable {
  

  private DTOCronograma cronograma;
  private Integer idVistaUltimo;

  public TADCronograma(DTOCronograma dto) {
      cronograma = dto; 
      //idVistaUltimo = new Integer(0);
      idVistaUltimo = new Integer(obtenerMaxIdVista());
  }

  public TADCronograma(DTOCronograma dto, boolean esZonas) {
      cronograma = dto; 
      //idVistaUltimo = new Integer(0);
      idVistaUltimo = new Integer(obtenerMaxIdVista());
      cronograma.setEsZonas(new Boolean(esZonas));
  }

  public DTOCronograma getCronograma() {
    return cronograma;
  }

  public void setCronograma(DTOCronograma newCronograma) {
    cronograma = newCronograma;
  }

  public Integer getIdVistaUltimo() {
    return idVistaUltimo;
  }

  public void setIdVistaUltimo(Integer newIdVistaUltimo) {
    idVistaUltimo = newIdVistaUltimo;
  }

  /** Obtiene los grupos de zonas/zonas de un cronograma. **/
  public Vector obtieneGrupos() {
      return cronograma.getGrupos();
  }

  /** Obtiene los grupos de zonas/zonas de un cronograma en forma de RecordSet [oid, descripcion] **/
  public RecordSet obtieneGruposRecordSet() {
      RecordSet resultado = new RecordSet(); 
      resultado.addColumn("oid");
      resultado.addColumn("descripcion");
      Vector v = cronograma.getGrupos();
      for (int i = 0; i < v.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) v.get(i);
          Vector fila = new Vector();
          fila.add(dtoG.getOid());
          fila.add(dtoG.getTextoGrupo());
          resultado.addRow(fila);
      }
      return resultado;

  }

  /** Obtiene el grupo/zona deseado de un cronograma. **/
  public DTOGrupoCronograma obtieneGrupo (Long grupo) { 
      DTOGrupoCronograma dtoRes = null;
      try {
          Vector v = cronograma.getGrupos();
          if (v != null) {
              for (int i = 0; i < v.size(); i++) {
                  DTOGrupoCronograma dtoG = (DTOGrupoCronograma) v.get(i);
                  if (dtoG.getOid().compareTo(grupo) == 0) {
                      dtoRes = dtoG;
                      break;
                  }
              }
          }
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          dtoRes = null;
      }
      return dtoRes;
 
  }

  /** Obtiene la actividad de un grupo/zona perteneciente al cronograma. 
   *  Incidencia 5635:
   *  Ahora devuelve un array de DTOActividadGrupo ya que hay varias actividades con ese código de actividad 
   *  en el grupo.
   *  Obtiene las actividades de un grupo/zona perteneciente al cronograma.**/
  public Vector obtieneActividadGrupo (Long grupo, Integer idVista) { 
      Vector vecRes = new Vector();
      try {
          DTOGrupoCronograma grupoCrono = obtieneGrupo(grupo); 
          Vector vAct = grupoCrono.getActividades();
          for (int i = 0; i < vAct.size(); i++) {
              DTOActividadGrupo dtoA = (DTOActividadGrupo) vAct.get(i);
              //if (dtoA.getActividad().compareTo(actividad) == 0) {
              if (dtoA.getIdVista().compareTo(idVista) == 0) {
                  vecRes.add(dtoA);
              }
          }
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          vecRes = null;
      }
      return vecRes;
 
  }

  /** Inserta un grupo de zonas en el cronograma. **/
  public void insertaGrupo (DTOGrupoCronograma dto) {
      if (cronograma.getGrupos() == null) 
          cronograma.setGrupos(new Vector());

      cronograma.getGrupos().add(dto);
  }

  /** Inserta una actividad en un grupo de zonas/zona del cronograma. Si no existiera el grupo de zonas/zona 
   * lo crea con la información de la actividad. **/
  public Integer insertaActividadGrupo (Long grupo, DTOActividadGrupo dto) {
      try {
          DTOGrupoCronograma grupoCrono = obtieneGrupo(grupo); 
          DTOActividadGrupo actividad = copiarDTOActividad(dto);
          if (grupoCrono == null) {
              grupoCrono = new DTOGrupoCronograma();
              grupoCrono.setTipoFacturacion(actividad.getTipoFacturacion());
              grupoCrono.setOid(actividad.getGrupo());
              grupoCrono.setTextoGrupo(actividad.getTextoGrupo());

              insertaGrupo(grupoCrono);
          }
          //Si es llamado del obtiene entonces no tiene que generar IdVista. Inc. 5635
          if (actividad.getIdVista() == null)
              actividad.setIdVista(generaIdVista());
          if (grupoCrono.getActividades() == null) 
              grupoCrono.setActividades(new Vector());
          grupoCrono.getActividades().add(actividad);
          return actividad.getIdVista();

      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          return null;
      }
      

  }

  /** Devuelve el último id de vista generado +1. **/
  private Integer generaIdVista() {
        int idV = idVistaUltimo.intValue();
        idV++;
        idVistaUltimo = new Integer(idV); 
        return idVistaUltimo;
  }

  /** Devuelve una actividad identificada por su id de vista (único por cada actividad del cronograma) del cronograma. **/
  public DTOActividadGrupo obtieneActividadGrupo (Integer idVista) {
      DTOActividadGrupo dtoRes = null;
      try {
          Vector grupos = obtieneGrupos();
          boolean encontre = false;
          for (int i = 0; i < grupos.size() && !encontre; i++) {
              DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
              //actividades = obtieneActividadesGrupo(grupo.oid)
              Vector acts = dtoG.getActividades();
              for (int j = 0; j < acts.size() && !encontre; j++) {
                  DTOActividadGrupo dtoA = (DTOActividadGrupo) acts.get(j);
                  if (dtoA.getIdVista().compareTo(idVista) == 0) {
                      dtoA.setGrupo(dtoG.getOid());
                      dtoRes = dtoA;
                      encontre = true;
                  }
              }
          }
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          dtoRes = null;
      }
      return dtoRes;
  }

  /** Devuelve todas las actividades de un grupo de zonas/zona del cronograma. 
   *  Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividadesGrupo (Long grupo) {
      DTOGrupoCronograma dtoGrupo = obtieneGrupo(grupo);
      if (dtoGrupo == null)
          return null;
          
      return dtoGrupo.getActividades();
  }

  /** Obtiene todas las actividades del cronograma. 
   *  Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividades () {
      UtilidadesLog.info("TADCronograma.obtieneActividades ():Entrada");
      Vector actividades = new Vector(); 
      Vector grupos = obtieneGrupos(); 
      if (grupos != null) {
          for (int i = 0; i < grupos.size(); i++) {
              DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
              if (dtoG.getActividades() != null)
                  actividades.addAll(dtoG.getActividades());
          }
      }
      UtilidadesLog.info("TADCronograma.obtieneActividades ():Salida");
      return actividades;   
  }

  /** Obtiene todas las actividades distintas del cronograma. **/
  public RecordSet obtieneActividadesVista() {
      Vector grupos = obtieneGrupos(); 
      Vector actividades = new Vector(); 
      for (int i = 0; i < grupos.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
          Vector acts = dtoG.getActividades();
          if (acts != null) {
              for (int j = 0; j < acts.size(); j++) {
                  DTOActividadGrupo dtoA = (DTOActividadGrupo) acts.get(j);
                  if (!perteneceAct(dtoA, actividades))
                      actividades.add(dtoA);
              }
          }
      }

      RecordSet resultado = new RecordSet(); 
      resultado.addColumn("oid");
      resultado.addColumn("descripcion");
      for (int i = 0; i < actividades.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);
          Vector fila = new Vector();
          //Incidencia 10038
          //fila.add(dtoA.getIdVista());
          fila.add(dtoA.getActividad());
          fila.add(dtoA.getTextoActividad());
          resultado.addRow(fila);
      }
      return resultado;
  }

  /** Devuelve la actividad origen de una actividad de un grupo de zonas del cronograma. **/
  //public DTOActividadGrupo referenciaGrupo (Long grupo, Long actividad) {
  public DTOActividadGrupo referenciaGrupo (Long grupo, Integer idVista) {
      //VER Incidencia 5635
      Vector vec = obtieneActividadGrupo(grupo,idVista); 
      DTOActividadGrupo dtoActividad = (DTOActividadGrupo) vec.get(0); 
      vec = obtieneActividadGrupo(grupo,dtoActividad.getActividadOrigen()); 
      DTOActividadGrupo dtoRes = (DTOActividadGrupo) vec.get(0); 
      //DTOActividadGrupo dtoActividad = obtieneActividadGrupo(grupo,actividad); 
      //return obtieneActividadGrupo(grupo,dtoActividad.getActividadOrigen()); 
      return dtoRes;
  }

  /** Devuelve las actividades referenciadas por una actividad de un grupo de zona del cronograma. 
      Retorna: DTOActividadGrupo[] **/
  //Inc. 5635
  //public Vector referenciadasGrupo (Long grupo, Long actividad) {
  public Vector referenciadasGrupo (Long grupo, Integer vistaActividad) {
      try {
          Vector vRef = new Vector();
          DTOGrupoCronograma dtoGrupo = obtieneGrupo(grupo); 
          Vector acts = dtoGrupo.getActividades();
          for (int i = 0; i < acts.size(); i++) {
              DTOActividadGrupo dtoA = (DTOActividadGrupo) acts.get(i);
              if (dtoA.getActividadOrigen() != null && (dtoA.getActividadOrigen().compareTo(vistaActividad) == 0)) 
                  vRef.add(dtoA);
          }
          return vRef;
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          return null;
      }
  }

  /** Obtiene las actividades del grupo pasado parámetro, cuyo oid no esté en la colección actividades. **/
  public void obtieneDistintasActividades (DTOGrupoCronograma grupo, Vector actividades) {
      Vector actividadesGrupo = obtieneActividadesGrupo(grupo.getOid());
      for (int i = 0; i < actividadesGrupo.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) actividadesGrupo.get(i);
          if (!perteneceActOid(dtoA, actividadesGrupo)) 
              actividadesGrupo.add(dtoA);
      }
  }


  /** Devuelve una actividad de un determinado día del periodo de un grupo de zonas del cronograma.
      Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividadesGrupoDia (Long grupo, Date diaPeriodo) {
      try {
          Vector actividades = new Vector();
          DTOGrupoCronograma dtoGrupo = obtieneGrupo(grupo); 
          Vector acts = dtoGrupo.getActividades();
          //Pongo hora en 0 para comparar solo el dia
          Calendar cPerio = new GregorianCalendar();
          cPerio.setTime(diaPeriodo);
          cPerio.set(Calendar.HOUR_OF_DAY,0);
          cPerio.set(Calendar.MINUTE,0);
          cPerio.set(Calendar.SECOND,0);
          if (acts != null) {
              for (int i = 0; i < acts.size(); i++) {
                  DTOActividadGrupo dtoA = (DTOActividadGrupo) acts.get(i);
                  if (this.actividadConFechaPrevista(dtoA)) {
                      Calendar cPrev = new GregorianCalendar();
                      cPrev.setTime(dtoA.getFechaPrevista());
                      cPrev.set(Calendar.HOUR_OF_DAY,0);
                      cPrev.set(Calendar.MINUTE,0);
                      cPrev.set(Calendar.SECOND,0);
                      if (cPrev.getTime().compareTo(cPerio.getTime()) == 0)
                          actividades.add(dtoA);
                  }
              }
          }
          return actividades;
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          return null;
      }
    
  }

  /**
   * Retorna true si la actividad tiene definida la fecha prevista.
   */
  private boolean actividadConFechaPrevista(DTOActividadGrupo dtoA) {
      boolean cumple = false;
      if (dtoA.getFechaPrevista() != null) {
          if (this.esZonas()) {
            // es fase dos
            if ( dtoA.getTipoActividad().intValue() != ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
                cumple = true;
            } else {
                // si no esta pendiente de definir la actividad origen de otro periodo
                if (dtoA.getIndPendienteOrigen() == null) {
                    cumple = true;
                } else if ( ! dtoA.getIndPendienteOrigen().booleanValue() ) {
                    cumple = true;
                }
            }
          } else {
            // es fase uno
            if (dtoA.getTipoActividad().intValue() != ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue()) {
                cumple = true;
            }  
          }
      }
      return cumple;
  }

  /** Obtiene los días de periodo que tiene la matriz de días. **/
  public Integer obtieneDiasCronograma() {
      return cronograma.getDiasPeriodo();
  }

  /** Obtiene los días de periodo que tiene la matriz de días. **/
  public Date obtieneInicioPeriodo() {
      return cronograma.getFechaIniPeriodo();
  }

  /** Establece la fecha de inicio de periodo para el cronograma así como la fecha de fin de periodo 
   * y el número de días que tiene el periodo. **/
  public void estableceDiasPeriodo (Date fechaIni, Date fechaFin) {
      cronograma.setFechaIniPeriodo(fechaIni);
      cronograma.setFechaFinPeriodo(fechaFin);
      Long dif = new Long((fechaFin.getTime() - fechaIni.getTime())  / 1000 / 60 / 60 / 24);
      cronograma.setDiasPeriodo(new Integer(dif.intValue()+1));
  }

  /** Modifica el desplazamiento de una actividad así como las fechas previstas de las actividades que la referencian. **/
  //VER Incidencia 5635
  public void modificaFechaActividad (Long grupo, Integer idVista, Integer desplazamiento) {
      UtilidadesLog.info("TADCronograma.modificaFechaActividad (Long grupo, Integer idVista, Integer desplazamiento):Entrada");
      DTOActividadGrupo dtoA = obtieneActividadGrupo(idVista);
      Integer desp = new Integer(desplazamiento.intValue() - dtoA.getFecha0().intValue()); 

      Calendar c = new GregorianCalendar();
      c.setTime(dtoA.getFechaPrevista());
      c.add(Calendar.DATE, desp.intValue());
      dtoA.setFechaPrevista(new Timestamp( c.getTime().getTime()));

      dtoA.setFecha0(new Long(desplazamiento.intValue()));

      //mueveReferenciadas(grupo, dtoA.getActividad(), desp); 
      mueveReferenciadas(grupo, dtoA.getIdVista(), desp); 
      UtilidadesLog.info("TADCronograma.modificaFechaActividad (Long grupo, Integer idVista, Integer desplazamiento):Salida");
  }

  /** Modifica la fecha de ejecución de una actividad así como las fechas previstas de las actividades que la referencian. **/
  //VER Incidencia 5635
  public void modificaFechaActividad (Long grupo, Integer idVista, Timestamp fechaHora) {
      UtilidadesLog.info("TADCronograma.modificaFechaActividad (Long grupo, Integer idVista, Date fechaHora):Entrada");
      DTOActividadGrupo dtoA = obtieneActividadGrupo(idVista);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date fechaPrev = Date.valueOf(sdf.format(dtoA.getFechaPrevista()));
      Date fechaNue = Date.valueOf(sdf.format(fechaHora));
      
      //Long desp = new Long((fechaHora.getTime() - dtoA.getFechaPrevista().getTime())  / 1000 / 60 / 60 / 24);
      Long desp = new Long((fechaNue.getTime() - fechaPrev.getTime())  / 1000 / 60 / 60 / 24);
      dtoA.setFechaPrevista(fechaHora);
      dtoA.setFecha0(new Long(dtoA.getFecha0().intValue() + desp.intValue()));

      //mueveReferenciadas(grupo, dtoA.getActividad(), new Integer(desp.intValue())); 
      mueveReferenciadas(grupo, dtoA.getIdVista(), new Integer(desp.intValue())); 

      if ( dtoA.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
            UtilidadesLog.debug("Ahora con Origen");
            dtoA.setIndPendienteOrigen(Boolean.FALSE);
      }    

      UtilidadesLog.info("TADCronograma.modificaFechaActividad (Long grupo, Integer idVista, Date fechaHora):Salida");
  }

  /** Mueve las actividades referenciadas a una actividad (identificada por grupo y oid actividad) en cronograma. 
   * Esta operación se hace moviendo el día de desplazamiento en el que se realiza cada actividad referenciada 
   * tanto como indique el parámetro desplazamiento.  **/
  //Inc. 5635
  //private void mueveReferenciadas (Long grupo, Long actividad, Integer desplazamiento) {
  private void mueveReferenciadas (Long grupo, Integer idVista, Integer desplazamiento) {
      //Vector actividades = referenciadasGrupo(grupo, actividad); 
      UtilidadesLog.info("TADCronograma.mueveReferenciadas (Long grupo, Integer idVista, Integer desplazamiento):Entrada");
      Vector actividades = referenciadasGrupo(grupo, idVista); 
      if (actividades != null) {
          for (int i = 0; i < actividades.size(); i++) {
              DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);

              Calendar c = new GregorianCalendar();
              c.setTime(dtoA.getFechaPrevista());
              c.add(Calendar.DATE, desplazamiento.intValue());
              dtoA.setFechaPrevista(new Timestamp(c.getTime().getTime()));

              //mueveReferenciadas(grupo, dtoA.getActividad(), desplazamiento); 
              mueveReferenciadas(grupo, dtoA.getIdVista(), desplazamiento); 
          }
      }
      UtilidadesLog.info("TADCronograma.mueveReferenciadas (Long grupo, Integer idVista, Integer desplazamiento):Salida");
  }

  /** Indica si el cronograma es por zonas o por grupos de zonas. **/
  public boolean esZonas() {
      boolean res = false;
      if (cronograma.getEsZonas() != null && cronograma.getEsZonas().booleanValue())
          res = true;

      return res;
  }

  /** Obtiene las actividades fuera de periodo del cronograma.
      Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividadesFueraPeriodo() {
      Vector oidGrupos = new Vector();
      Vector grupos = obtieneGrupos(); 
      for (int i = 0; i < grupos.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
          oidGrupos.add(dtoG.getOid());
      }
      return obtieneActividadesFueraPeriodo(oidGrupos);
  }

  /** Obtiene las actividades fuera de periodo del cronograma.
      Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividadesFueraPeriodo(Vector grupos) {
      Vector actividadesFuera = new Vector();
      for (int i = 0; i < grupos.size(); i++) {
          Vector actividadesFueraGrupo = obtieneActividadesFueraPeriodo((Long) grupos.get(i)); 
          actividadesFuera.addAll(actividadesFueraGrupo);
      }
      return actividadesFuera;
  }

  /** Obtiene las actividades fuera de periodo del cronograma.
      Retorna: DTOActividadGrupo[] **/
  public Vector obtieneActividadesFueraPeriodo(Long grupo) {
      Vector actividadesFuera = new Vector();
      Vector actividades = obtieneActividadesGrupo(grupo);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < actividades.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);
          //No se debe tener en cuenta la hora para la comparacion
          Date fechaPrev = Date.valueOf(sdf.format(dtoA.getFechaPrevista()));
          Date fechaIni = Date.valueOf(sdf.format(cronograma.getFechaIniPeriodo()));
          Date fechaFin = Date.valueOf(sdf.format(cronograma.getFechaFinPeriodo()));
          //if (dtoA.getFechaPrevista().compareTo(cronograma.getFechaIniPeriodo()) < 0 ||
          //    dtoA.getFechaPrevista().compareTo(cronograma.getFechaFinPeriodo()) > 0 )
          //        actividadesFuera.add(dtoA);
          if (fechaPrev.compareTo(fechaIni) < 0 ||
              fechaPrev.compareTo(fechaFin) > 0 )
                  actividadesFuera.add(dtoA);
      }
      return actividadesFuera;
  }


  /** 
   * Obtiene las actividades con referencia a otro periodo del cronograma. 
   * Retorna: DTOActividadGrupo[].
   **/
  public Vector obtieneActividadesReferenciaOtroPeriodo() {
      UtilidadesLog.info("TADCronograma.obtieneActividadesReferenciaOtroPeriodo():Entrada");
      Vector oidGrupos = new Vector();
      Vector grupos = obtieneGrupos(); 
      for (int i = 0; i < grupos.size(); i++) {
          DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
          oidGrupos.add(dtoG.getOid());
      }
      UtilidadesLog.info("TADCronograma.obtieneActividadesReferenciaOtroPeriodo():Salida");
      return obtieneActividadesReferenciaOtroPeriodo(oidGrupos);
  }


  /** 
   * Obtiene las actividades con referencia a otro periodo del cronograma. 
   * Retorna: DTOActividadGrupo[].
   **/
  public Vector obtieneActividadesReferenciaOtroPeriodo(Vector grupos) {
      UtilidadesLog.info("TADCronograma.obtieneActividadesReferenciaOtroPeriodo(Vector grupos):Entrada");
      Vector actividadesRefeOtroPeri = new Vector();
      for (int i = 0; i < grupos.size(); i++) {
          Vector activsRefeOtroPeriGrupo = obtieneActividadesReferenciaOtroPeriodo((Long) grupos.get(i)); 
          actividadesRefeOtroPeri.addAll(activsRefeOtroPeriGrupo);
      }
      UtilidadesLog.info("TADCronograma.obtieneActividadesReferenciaOtroPeriodo(Vector grupos):Salida");
      return actividadesRefeOtroPeri;
  }


  /**
   * Obtiene las actividades con referencia a otro periodo del cronograma. 
   * Retorna: DTOActividadGrupo[]
   **/
  public Vector obtieneActividadesReferenciaOtroPeriodo(Long grupo) {
      Vector actividadesRefOtroPeri = new Vector();
      Vector actividades = obtieneActividadesGrupo(grupo);
      for (int i = 0; i < actividades.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) actividades.get(i);
          if (this.esZonas()) {
              // en fase dos
              if ( dtoA.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() &&
                        ( (dtoA.getIndPendienteOrigen() != null) && dtoA.getIndPendienteOrigen().booleanValue() ) ) {
                    actividadesRefOtroPeri.add(dtoA);
              }
          } else {
              // en fase uno
              if ( dtoA.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue() ) {
                    actividadesRefOtroPeri.add(dtoA);
              }
          }
      }
      return actividadesRefOtroPeri;
  }


  /** Toma n registros y los transforma en un Cronograma. **/
  public DTOCronograma obtieneCronogramaPorRecordSet (RecordSet registros) {
      UtilidadesLog.info("TADCronograma.obtieneCronogramaPorRecordSet (RecordSet registros):Entrada");
      //El parámetro "registros" es un RecordSet con n registros con los siguientes campos: 
      //[oid, periodo, seccion, actividad, tipodias, fechaini, fechamedia, fechafin, zona, tipofac, actividadorigen, 
      // fecha0, codigo, fechainiperiodo, fechafinperiodo, textozona, textoactividad, indfija] 

      if (!registros.esVacio()) {
          cronograma.setFechaIniPeriodo((Date) registros.getValueAt(0,"FECHAINIPERIODO"));
          cronograma.setFechaFinPeriodo((Date) registros.getValueAt(0,"FECHAFINPERIODO"));
          Long dias = new Long((cronograma.getFechaFinPeriodo().getTime() - 
                                                   cronograma.getFechaIniPeriodo().getTime())
                                                   / 1000 / 60 / 60 / 24);
          cronograma.setDiasPeriodo(new Integer(dias.intValue()+1));

          for (int i = 0; i < registros.getRowCount(); i++) {
              DTOGrupoCronograma dtoGrupo = new DTOGrupoCronograma(); 
              dtoGrupo.setOid(new Long( ((BigDecimal) registros.getValueAt(i, "ZONA")).toString()));
              dtoGrupo.setTipoFacturacion(new Long( ((BigDecimal) registros.getValueAt(i, "TIPOFAC")).toString()));
              dtoGrupo.setTextoGrupo((String) registros.getValueAt(i, "TEXTOZONA"));

              if (obtieneGrupo(dtoGrupo.getOid()) == null)   
                  insertaGrupo(dtoGrupo);         

              DTOActividadGrupo dtoActividad = new DTOActividadGrupo(); 
              if (registros.getValueAt(i, "FECHA0") != null)
                  dtoActividad.setFecha0(new Long(((BigDecimal) registros.getValueAt(i,"FECHA0")).toString()));
              if (registros.getValueAt(i, "FECHAFIN") != null)
                  dtoActividad.setFechaFinal((Date) registros.getValueAt(i,"FECHAFIN"));
              if (registros.getValueAt(i, "FECHAMEDIA") != null)
                  dtoActividad.setFechaMedia(new Integer(((BigDecimal) registros.getValueAt(i,"FECHAMEDIA")).toString()));
              if (registros.getValueAt(i, "FECHAINI") != null) {
                  Date fecha = (Date) registros.getValueAt(i,"FECHAINI");

                  String horaIni = (String) registros.getValueAt(i,"HORAINI");
                  StringTokenizer stkHora = new StringTokenizer(horaIni,":");
                  String sHora = (String) stkHora.nextToken();
                  String sMin = (String) stkHora.nextToken();
                  String sSeg = (String) stkHora.nextToken();
        
                  Calendar c = new GregorianCalendar();
                  c.setTime(fecha);
                  c.set(Calendar.HOUR_OF_DAY, new Integer(sHora).intValue());
                  c.set(Calendar.MINUTE, new Integer(sMin).intValue());
                  c.set(Calendar.SECOND, new Integer(sSeg).intValue());
                  
                  //dtoActividad.setFechaPrevista((Date) registros.getValueAt(i,"FECHAINI"));
                  dtoActividad.setFechaPrevista(new Timestamp(c.getTime().getTime()));
              }
              if (registros.getValueAt(i,"OID") !=null ) 
                  dtoActividad.setOid(new Long(((BigDecimal) registros.getValueAt(i,"OID")).toString()));
              if (registros.getValueAt(i,"TIPODIAS") !=null ) {
                  if (((BigDecimal) registros.getValueAt(i,"TIPODIAS")).toString() == "1")
                      dtoActividad.setTipoDias(new Boolean(true));
                  else
                      dtoActividad.setTipoDias(new Boolean(false));
              }
              if (registros.getValueAt(i,"ACTIVIDAD") !=null ) 
                  dtoActividad.setActividad(new Long(((BigDecimal) registros.getValueAt(i,"ACTIVIDAD")).toString()));
              if (registros.getValueAt(i,"ACTIVIDADORIGEN") !=null ) {
                  //Inc. 5635
                  dtoActividad.setActividadOrigen(new Integer(((BigDecimal) registros.getValueAt(i,"ACTIVIDADORIGEN")).toString()));
                  //dtoActividad.setActividadOrigen(new Long(((BigDecimal) registros.getValueAt(i,"ACTIVIDADORIGEN")).toString()));
              }
              if (registros.getValueAt(i,"CODVISTA") !=null ) 
                  dtoActividad.setIdVista(new Integer(((BigDecimal) registros.getValueAt(i,"CODVISTA")).toString()));
                  
              Long zona = new Long(((BigDecimal) registros.getValueAt(i,"ZONA")).toString());     
              dtoActividad.setGrupo(zona);
              if (registros.getValueAt(i,"PERIODO") !=null ) 
                  dtoActividad.setPeriodo(new Long(((BigDecimal) registros.getValueAt(i,"PERIODO")).toString()));
              if (registros.getValueAt(i,"TIPOFAC") !=null ) 
                  dtoActividad.setTipoFacturacion(new Long(((BigDecimal) registros.getValueAt(i,"TIPOFAC")).toString()));
              if (registros.getValueAt(i, "FECHAINIPERIODO") != null)
                  dtoActividad.setFechaIniPeriodo((Date) registros.getValueAt(i,"FECHAINIPERIODO"));
              if (registros.getValueAt(i, "FECHAFINPERIODO") != null)
                  dtoActividad.setFechaFinPeriodo((Date) registros.getValueAt(i,"FECHAFINPERIODO"));
              if (registros.getValueAt(i, "TEXTOZONA") != null)
                  dtoActividad.setTextoGrupo((String) registros.getValueAt(i,"TEXTOZONA"));
              if (registros.getValueAt(i, "TEXTOACTIVIDAD") != null)
                  dtoActividad.setTextoActividad((String) registros.getValueAt(i,"TEXTOACTIVIDAD"));
              if (registros.getValueAt(i, "CODIGO") != null)
                  dtoActividad.setCodigo((String) registros.getValueAt(i,"CODIGO"));
              if (registros.getValueAt(i,"INDFIJA") !=null ) {
                  if (((BigDecimal) registros.getValueAt(i,"INDFIJA")).toString().equals("1"))
                      dtoActividad.setIndFija(new Boolean(true));
                  else
                      dtoActividad.setIndFija(new Boolean(false));
              }
              if (registros.getValueAt(i,"NUM_DIAS_DESP") !=null ) {
                  dtoActividad.setDiasDesplazamiento(new Integer(((BigDecimal) registros.getValueAt(i,"NUM_DIAS_DESP")).toString()));
              }                
              if (registros.getValueAt(i,"IND_PEND_ORIG") !=null ) {
                  if (((BigDecimal) registros.getValueAt(i,"IND_PEND_ORIG")).toString().equals("1"))
                      dtoActividad.setIndPendienteOrigen(new Boolean(true));
                  else
                      dtoActividad.setIndPendienteOrigen(new Boolean(false));
              }
              if (registros.getValueAt(i,"PERD_OID_PERI_REFE") !=null ) {
                  dtoActividad.setPeriodoReferencia(new Long(((BigDecimal) registros.getValueAt(i,"PERD_OID_PERI_REFE")).toString()));
              }                
              if (registros.getValueAt(i,"COD_TIPO_ACTI") !=null ) {
                  dtoActividad.setTipoActividad(new Integer(((BigDecimal) registros.getValueAt(i,"COD_TIPO_ACTI")).toString()));
              }                

              if (registros.getValueAt(i,"VAL_NOMB_PERI_REFE") !=null ) {
                  dtoActividad.setNombrePeriodoReferencia((String)registros.getValueAt(i,"VAL_NOMB_PERI_REFE"));
              }                
              if (registros.getValueAt(i,"COD_ACTIV_ORIG") !=null ) {
                  dtoActividad.setCodigoActividadOrigen((String) registros.getValueAt(i,"COD_ACTIV_ORIG"));
              }                
              if (registros.getValueAt(i,"NOMB_ACTIV_ORIG") !=null ) {
                  dtoActividad.setNombreActividadOrigen((String) registros.getValueAt(i,"NOMB_ACTIV_ORIG"));
              }                

              insertaActividadGrupo(zona,dtoActividad);
          }
      }
      UtilidadesLog.info("TADCronograma.obtieneCronogramaPorRecordSet (RecordSet registros):Salida");
      return cronograma;
  }

  /** Elimina la actividad identificada por su id de vista y devuelve el oid de la actividad eliminada. **/
  public Long eliminaActividad (Integer idVista) {
      DTOActividadGrupo actividad = obtieneActividadGrupo(idVista); 
      Long oid = actividad.getActividad();
      DTOGrupoCronograma grupo = obtieneGrupo(actividad.getGrupo()); 
      if (grupo.getActividades() != null) {
          grupo.getActividades().remove(actividad);
          if (grupo.getBorradas() == null)
              grupo.setBorradas(new Vector());
          if (actividad.getOid() != null)  //Porque solo se borrarán las que estan en BBDD
              grupo.getBorradas().add(actividad.getOid());
      }
      return oid;
  }

  /** Inserta las actividades asociadas a otra en un grupo. **/
  public void insertaAsociadas(DTOGrupoCronograma dto) {
      UtilidadesLog.info("TADCronograma.insertaAsociadas(DTOGrupoCronograma dto):Entrada");
      Vector v = dto.getActividades();
      for (int i = 0; i < v.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) v.get(i);
          //Vector vAG = obtieneActividadGrupo(dto.getOid(), dtoA.getActividad());
          //Inc. 5635
          Vector vAG = obtieneActividadGrupo(dto.getOid(), dtoA.getIdVista());
          if (vAG == null || vAG.size() == 0)
              insertaActividadGrupo(dto.getOid(), dtoA);
      }
      UtilidadesLog.info("TADCronograma.insertaAsociadas(DTOGrupoCronograma dto):Salida");
  }

  /* Verifica si pertenece una actividad a un DTOActividadGrupo[] por atributo actividad */
  private boolean perteneceAct(DTOActividadGrupo act, Vector v) {
      boolean encontre = false;
      for (int i = 0; i < v.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) v.get(i);
          if (dtoA.getActividad().compareTo(act.getActividad()) == 0) {
              encontre = true;
              break;
          }
      }

      return encontre;
  }

  /* Verifica si pertenece una actividad a un DTOActividadGrupo[] por atributo oid */
  private boolean perteneceActOid(DTOActividadGrupo act, Vector v) {
      boolean encontre = false;
      for (int i = 0; i < v.size(); i++) {
          DTOActividadGrupo dtoA = (DTOActividadGrupo) v.get(i);
          if (dtoA.getOid().compareTo(act.getOid()) == 0) {
              encontre = true;
              break;
          }
      }
      return encontre;
  }

  private int obtenerMaxIdVista() {
      UtilidadesLog.info("TADCronograma.obtenerMaxIdVista():Entrada");
      Vector vG = cronograma.getGrupos();
      int maxId = 0;
      if (vG != null) {
          for (int i = 0; i < vG.size(); i++) {
              DTOGrupoCronograma dtoG = (DTOGrupoCronograma) vG.get(i);
              Vector vA = dtoG.getActividades();
              for (int j = 0; j < vA.size(); j++) {
                  DTOActividadGrupo dtoA = (DTOActividadGrupo) vA.get(j);
                  if (dtoA.getIdVista() != null && dtoA.getIdVista().intValue() > maxId) 
                      maxId = dtoA.getIdVista().intValue();
              }
          }
      }
        UtilidadesLog.info("TADCronograma.obtenerMaxIdVista():Salida");
      return maxId + 1;
  }

  private DTOActividadGrupo copiarDTOActividad(DTOActividadGrupo dto) {
      DTOActividadGrupo dtoRes = new DTOActividadGrupo();
      dtoRes.setActividad(dto.getActividad());
      dtoRes.setActividadOrigen(dto.getActividadOrigen());
      dtoRes.setCodigo(dto.getCodigo());
      dtoRes.setFecha0(dto.getFecha0());
      dtoRes.setFechaFinal(dto.getFechaFinal());
      dtoRes.setFechaFinPeriodo(dto.getFechaFinPeriodo());
      dtoRes.setFechaIniPeriodo(dto.getFechaIniPeriodo());
      dtoRes.setFechaMedia(dto.getFechaMedia());
      dtoRes.setFechaPrevista(dto.getFechaPrevista());
      dtoRes.setGrupo(dto.getGrupo());
      dtoRes.setIdVista(dto.getIdVista());
      dtoRes.setIndFija(dto.getIndFija());
      dtoRes.setOid(dto.getOid());
      dtoRes.setPeriodo(dto.getPeriodo());
      dtoRes.setTextoActividad(dto.getTextoActividad());
      dtoRes.setTextoGrupo(dto.getTextoGrupo());
      dtoRes.setTipoDias(dto.getTipoDias());
      dtoRes.setTipoFacturacion(dto.getTipoFacturacion());
      dtoRes.setPeriodoReferencia(dto.getPeriodoReferencia());
      dtoRes.setDiasDesplazamiento(dto.getDiasDesplazamiento());
      dtoRes.setIndPendienteOrigen(dto.getIndPendienteOrigen());
      dtoRes.setNombrePeriodoReferencia(dto.getNombrePeriodoReferencia());
      dtoRes.setCodigoActividadOrigen(dto.getCodigoActividadOrigen());
      dtoRes.setNombreActividadOrigen(dto.getNombreActividadOrigen());
      dtoRes.setTipoActividad(dto.getTipoActividad());
      dtoRes.setIdVistaOrigenOtroPeriodo(dto.getIdVistaOrigenOtroPeriodo());

      dtoRes.setIpCliente(dto.getIpCliente());
      dtoRes.setOidIdioma(dto.getOidIdioma());
      dtoRes.setOidPais(dto.getOidPais());
      dtoRes.setPrograma(dto.getPrograma());
      return dtoRes;
  }
  
}