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
import es.indra.sicc.dtos.cra.DTOActividadMatriz;
import es.indra.sicc.dtos.cra.DTOGrupoMatriz;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Vector;


public class TADMatrizDias implements Serializable {
  private DTOMatrizDias matrizDias;
  private Integer idVistaUltimo;

  //public TADMatrizDias() {}

    /**
     * Nota: Cuidado con la creacion de la matriz, debe ser solo una vez.
     * Caso contrario perdemos el valor de idVista.
     */
  public TADMatrizDias (Long pais, Long marca, Long canal) {
    matrizDias = new DTOMatrizDias(); 

    matrizDias.setOidPais(pais);
    matrizDias.setMarca(marca); 
    matrizDias.setCanal(canal);
    matrizDias.setGrupos(new Vector());     // vector vacio, NO null.
    matrizDias.setIdVista(new Integer(0));
    idVistaUltimo = new Integer(0);
  }


  /** 
   * Nota: 
   * ===== 
   * Para usar este constructor se aconseja que la matriz que recibe como parámetro haya sido creada 
   * haciendo uso del método TADMatrizDias.obtieneMatrizPorRecordSet existente en esta misma clase. 
   * EN CASO CONTRARIO PUEDE TENER RESULTADOS INESPERADOS
   * 
   **/
  public TADMatrizDias (DTOMatrizDias matriz) {
    matrizDias = matriz;

  }


  public DTOMatrizDias getMatrizDias() {
    return matrizDias;
  }

  public void setMatrizDias(DTOMatrizDias newMatrizDias) {
    matrizDias = newMatrizDias;
  }

  public Integer getIdVistaUltimo() {
    return idVistaUltimo;
  }

  public void setIdVistaUltimo(Integer newIdVistaUltimo) {
    idVistaUltimo = newIdVistaUltimo;
  }


  public DTOMatrizDias obtieneMatrizPorRecordSet (RecordSet registros) {
      //DTOMatrizDias dtoMD = new DTOMatrizDias();
      UtilidadesLog.info("TADMatrizDias.obtieneMatrizPorRecordSet (RecordSet registros):Entrada");
      if (!registros.esVacio()) {
        Long numDias = new Long(((BigDecimal) registros.getValueAt(0,"DIASPERIODO")).toString());
        matrizDias.setDias(numDias);
        for (int i = 0; i < registros.getRowCount(); i++) {
            DTOGrupoMatriz dtoGrupo = new DTOGrupoMatriz(); 
            dtoGrupo.setActividades(new Vector());
            Long grupo = new Long(((BigDecimal) registros.getValueAt(i,"GRUPO")).toString());
            dtoGrupo.setGrupoZona(grupo);
            dtoGrupo.setTextoGrupo((String) registros.getValueAt(i,"TEXTOGRUPO"));
            dtoGrupo = insertaGrupo(dtoGrupo); 

            DTOActividadMatriz dtoActividad = new DTOActividadMatriz(); 
            if (registros.getValueAt(i,"ACTIVIDAD") !=null ) 
                dtoActividad.setActividad(new Long(((BigDecimal) registros.getValueAt(i,"ACTIVIDAD")).toString()));
            if (registros.getValueAt(i,"ACTIVIDADORIGEN") !=null ) 
                dtoActividad.setOrigen(new Long(((BigDecimal) registros.getValueAt(i,"ACTIVIDADORIGEN")).toString()));
            if (registros.getValueAt(i,"DIAS") !=null ) 
                dtoActividad.setDia(new Long(((BigDecimal) registros.getValueAt(i,"DIAS")).toString()));
            if (registros.getValueAt(i,"DIASFIN") !=null ) 
                dtoActividad.setDiasFinal(new Long(((BigDecimal) registros.getValueAt(i,"DIASFIN")).toString()));
            if (registros.getValueAt(i,"DIASINTERVALO") !=null ) 
                dtoActividad.setDiasIntervalo(new Long(((BigDecimal) registros.getValueAt(i,"DIASINTERVALO")).toString()));
            if (registros.getValueAt(i,"OID") !=null ) 
                dtoActividad.setOid(new Long(((BigDecimal) registros.getValueAt(i,"OID")).toString()));
            dtoActividad.setTextoActividad((String) registros.getValueAt(i,"TEXTOACTIVIDAD"));
            dtoActividad.setCodigo((String) registros.getValueAt(i,"CODIGOACTIVIDAD"));
            dtoActividad.setTextoGrupo((String) registros.getValueAt(i,"TEXTOGRUPO"));
            dtoActividad.setClase(new Long(((BigDecimal) registros.getValueAt(i,"CLASEACTIVIDAD")).toString()));
            if (registros.getValueAt(i,"DESC_TIPO")!=null) 
                dtoActividad.setTipoActividad((String) registros.getValueAt(i,"DESC_TIPO"));//desc_tipo
            if (registros.getValueAt(i,"CAMP_DESPLA")!=null)  
                dtoActividad.setCampDesplazamiento(new Integer(((BigDecimal) registros.getValueAt(i,"CAMP_DESPLA")).toString()));//camp_despla
            if (registros.getValueAt(i,"NOMACTIVIDADORIGEN")!=null)
                dtoActividad.setTextoActOrigen((String) registros.getValueAt(i,"NOMACTIVIDADORIGEN"));//actividadorigen            

            insertaActividad(dtoActividad, grupo); 

        }
        
        actualizaDiasActividades(); 

      }
      UtilidadesLog.info("TADMatrizDias.obtieneMatrizPorRecordSet (RecordSet registros):Salida");
      return matrizDias;

    }


    public DTOGrupoMatriz insertaGrupo (DTOGrupoMatriz dto) {
        try {
            DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(dto.getGrupoZona());
            if (dtoGrupo != null){
                return dtoGrupo;
            }else {
                matrizDias.getGrupos().add(dto);
                return dto;
            }
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            return null;
        }

     }

    public DTOGrupoMatriz obtieneGrupoZona (Long id) {
      try {
          DTOGrupoMatriz dtoRes = null;
          Vector vg = matrizDias.getGrupos();
          for (int i = 0; i < vg.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) vg.get(i);
            if (dtoG.getGrupoZona().compareTo(id) == 0) {
                dtoRes = dtoG;
                break;
            }
          }
          return dtoRes;
        
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          return null;
      }

    }


    /**
     * Inserta un nueva actividad a la matriz de días, en el grupo indicado.
     * Si ya existiera el oid de la actividad, devuelve la actividad ya existente, sino la crea. 
     * Nota: Cuidado con la creacion de la matriz, debe ser solo una vez.
     */
    public DTOActividadMatriz insertaActividad (DTOActividadMatriz dto, Long grupo) {
        try {
              DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(grupo);
              Vector vg = dtoGrupo.getActividades();
              for (int i = 0; i < vg.size(); i++) {
                  DTOActividadMatriz dtoA = (DTOActividadMatriz) vg.get(i);
                  if (dtoA.getActividad().compareTo(dto.getActividad()) == 0) {
                      return dtoA;
                  }
              }
              //Si llego aca es porque no lo encontro
              dto.setIdVista(generaIdVista());
              dto.setGrupo(grupo);
              dto.setTextoGrupo(dtoGrupo.getTextoGrupo());
              vg.add(dto);
              return dto;

        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            return null;
        }
    }

    /**
     * Devuelve el último id de vista generado + 1. 
     */
    private Integer generaIdVista() {
        UtilidadesLog.info("TADMatrizDias.generaIdVista():Entrada");
        // tomamoa el ultimo id vista de la matriz actual
        int idVista = getMatrizDias().getIdVista().intValue();
        //incrementamos en uno el idVista
        idVista++;
        idVistaUltimo = new Integer(idVista);
        matrizDias.setIdVista(new Integer(idVista));        
        UtilidadesLog.info("TADMatrizDias.generaIdVista():Salida");
        //retornamos el nuevo idVista
        return idVistaUltimo;
    }


    public void actualizaDiasActividades() {
        UtilidadesLog.info("TADMatrizDias.actualizaDiasActividades():Entrada");
        Vector grupos = obtieneGruposZona(); 
        for (int i = 0; i < grupos.size(); i++) {
            //2.- Por cada elemento grupos[i] de grupos se invoca a actualizaDiasActividadGrupo(grupos[i].grupoZona) para actualizar los días de las actividades de ese grupo.
            actualizaDiasActividadGrupo(((DTOGrupoMatriz) grupos.get(i)).getGrupoZona());
        }
        UtilidadesLog.info("TADMatrizDias.actualizaDiasActividades():Salida");
    }


    public Vector obtieneGruposZona() {
        return matrizDias.getGrupos();
    }


    /**
     * Realiza la actualizacion del día de periodo en el que se realiza
     * cada una de las actividades de un grupo de la matriz de días. 
     */ 
    public void actualizaDiasActividadGrupo (Long grupo) {
        UtilidadesLog.info("TADMatrizDias.actualizaDiasActividadGrupo (Long grupo):Entrada");
        Vector actividades = obtieneActividadesGrupo(grupo);
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);
            dtoA.setDiaPeriodo(obtieneDiaActividad(dtoA.getDia(), grupo, dtoA.getOrigen()));
        }
        UtilidadesLog.info("TADMatrizDias.actualizaDiasActividadGrupo (Long grupo):Salida");
    }


    public Vector obtieneActividadesGrupo (Long grupo) {
        DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(grupo);
        return dtoGrupo.getActividades();
    }


    /**
     * Es un método recursivo para obtener el día del periodo,
     * en el que realiza una actividad de un grupo de zonas de la matriz de días. 
     */
    private Long obtieneDiaActividad ( Long dia, Long grupo, Long actividadOrigen) {
        Long diaAct;
        // A) Si tiene actividaOrigen calcula el diaPeriodo recursivamente
        if (actividadOrigen != null) {
            DTOActividadMatriz actividad = obtieneActividad(grupo, actividadOrigen);
            if (actividad!=null) {//Si es null es porque viene de una actividad de referencia a otra campaña y no fue cargada.
              diaAct = obtieneDiaActividad(new Long(dia.intValue()+actividad.getDia().intValue()), grupo, actividad.getOrigen());
            } else {
              diaAct = dia;
            }
        } else {
            // B) Devuelve dia. (retorna el dia acumulado)
            diaAct = dia;
        }
        return diaAct;
    }


    /**
     * Devuelve una actividad de un grupo de zonas de la matriz de días. 
     */
    public DTOActividadMatriz obtieneActividad (Long grupo, Long actividad) {
        try {
            DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(grupo);
            Vector act = dtoGrupo.getActividades();
            for (int i=0; i < act.size(); i++) {
                DTOActividadMatriz dtoA = (DTOActividadMatriz) act.get(i);
                //Por favor no hagan esto: dtoA.getActividad() == actividad
                if (dtoA.getActividad().equals(actividad)) {
                    //retorna dtoActividad encontrada
                    return dtoA;
                }
            }
            return null;
            
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            return null;
        }
    }


    /**
     * Elimina una actividad identificada por su idVista en la matriz.
     * Si la actividad es referenciada se debe cambiar la referencia
     * de las actividades que la referencia a Inicio de período. 
     * Referencia perfecta en la Incidencia BELC300005157.
     */
    public void eliminaActividad (Integer idVista) {
        DTOActividadMatriz actividadEliminada = null;

        // 1.- DTOActividadMatriz actividad = obtieneActividad(idVista); 
        DTOActividadMatriz actividad = obtieneActividad(idVista);

        // 2.- DTOActividadMatriz[] actividades = referenciadas(actividad.grupo, actividad.actividad); 
        Vector actividades = referenciadas(actividad.getGrupo(), actividad.getActividad());     

        // 3.- Por cada elemento de actividades (que llamamos act[i]) se modifican los siguientes atributos: 
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz act = (DTOActividadMatriz) actividades.get(i);
            // a) act[i].diaPeriodo = actividad.diaPeriodo + act[i].dia; 
            act.setDiaPeriodo(new Long(actividad.getDiaPeriodo().intValue() + act.getDia().intValue()));
            // b) act[i].dia = actividad.diaPeriodo; 
            act.setDia(act.getDiaPeriodo());
            // c) act[i].origen = null; 
            act.setOrigen(null);
        }

        // 4.- DTOActividadMatriz[] actividadesGrupo = obtieneActividadesGrupo(actividad.grupo); 
        Vector actividadesGrupo = obtieneActividadesGrupo(actividad.getGrupo());

        // 5.- Obtiene el elemento de actividadesGrupo cuyo atributo actividad 
        // sea igual a actividad.actividad y lo llamamos actividadEliminada.
        for (int i = 0; i < actividadesGrupo.size(); i++) {
            DTOActividadMatriz act = (DTOActividadMatriz) actividadesGrupo.get(i);
            if (act.getActividad().compareTo(actividad.getActividad()) == 0 ) {
                actividadEliminada = act;
                break;
            }
        }

        // 6.- DTOGrupoMatriz grupo = obtieneGrupoZona(actividad.grupo);
        DTOGrupoMatriz grupo = obtieneGrupoZona(actividad.getGrupo());

        // 7.- Añade a grupo.borradas el Long actividadEliminada.oid
        grupo.getBorradas().add(actividadEliminada);

        // 8.- Elimina el elemento de actividadEliminada de actividadesGrupo.
        for (int i = 0; i < actividadesGrupo.size(); i++) {
            DTOActividadMatriz act = (DTOActividadMatriz) actividadesGrupo.get(i);
            if (act.getActividad().compareTo(actividadEliminada.getActividad()) == 0 ) {
                actividadesGrupo.remove(i);
                break;
            }
        }
     }


    /**
     * Devuelve las actividades referenciadas por una actividad de un grupo de zona de la matriz. 
     */
    public Vector referenciadas (Long grupo, Long actividad) {
        UtilidadesLog.info("TADMatrizDias.referenciadas (Long grupo, Long actividad):Entrada");
        Vector vRes = new Vector();
        // 1.- dtoGrupo = obtieneGrupoZona(grupo); 
        DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(grupo); 
        Vector actividades = dtoGrupo.getActividades();
        // 2.- Busca los DTOActividadMatriz j que cumplan (obtieneActividad(grupo, dtoGrupo.actividades[j].origen).actividad == actividad) y crea el conjunto con dichos elementos que se llamará dtoActividades. 
        for (int j = 0; j < actividades.size(); j++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(j);
            if ((dtoA.getOrigen() != null) && (dtoA.getOrigen().compareTo(actividad) == 0)) {
                vRes.add(dtoA);
            }
        }
        // 3.- Devuelve dtoActividades. 
        UtilidadesLog.info("TADMatrizDias.referenciadas (Long grupo, Long actividad):Salida");
        return vRes;
    }


    public DTOActividadMatriz obtieneActividad (Integer idVista) {
        try {
            Vector grupos = obtieneGruposZona(); 
            DTOActividadMatriz dtoRes = null;
            boolean encontre = false;
            for (int i = 0; i < grupos.size() && !encontre; i++) {
                DTOGrupoMatriz grupo = (DTOGrupoMatriz) grupos.get(i);
                Vector actividades = obtieneActividadesGrupo(grupo.getGrupoZona());
                for (int j = 0; j < actividades.size() && !encontre; j++) {
                    DTOActividadMatriz dtoAct = (DTOActividadMatriz) actividades.get(j);
                    if (dtoAct.getIdVista().compareTo(idVista) == 0) {
                        dtoAct.setGrupo(grupo.getGrupoZona());
                        dtoRes = dtoAct;                    
                        encontre = true;
                    }
                }
            
            }
            return dtoRes;
            
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            return null;
        }
            
    }


    /**
     * Modifica una actividad cuyos datos son los que aparecen en el parámetro en la matriz.
     * Esta modificación se hace con las siguientes restricciones: 
     * - Si esMover es true se mueve el día del periodo en el que se realiza cada actividad referenciada. 
     * - Si esMover es false se mueve el día de desplazamiento en el que se realiza cada actividad referenciada. 
     */
    public void modificaActividad (DTOActividadMatriz actNueva) {
        UtilidadesLog.info("TADMatrizDias.modificaActividad (DTOActividadMatriz actNueva):Entrada");
        // 1.- DTOActividadMatriz actividad = obtieneActividad(actividad); 
        DTOActividadMatriz actividad = obtieneActividad(actNueva.getIdVista()); 
        // 2.- Integer desplazamiento = actNueva.dia - actividad.dia; 
        Integer desplazamiento = new Integer(actNueva.getDia().intValue() - actividad.getDia().intValue()); 
        // 3.- Se modifica el objeto actividad con actNueva del siguiente modo: 
        actividad.setOrigen(actNueva.getOrigen());
        actividad.setDia(actNueva.getDia());
        actividad.setDiasFinal(actNueva.getDiasFinal());
        actividad.setDiasIntervalo(actNueva.getDiasIntervalo());
        actividad.setGrupo(actNueva.getGrupo());
        actividad.setCampDesplazamiento(actNueva.getCampDesplazamiento());
        actividad.setTextoActOrigen(actNueva.getTextoActOrigen());
        // 4.- Si (actNueva.esMover== false) noMueveReferenciadas(actividad.grupo, actividad.actividad, desplazamiento); 
        if (actNueva.getEsMover() != null && !actNueva.getEsMover().booleanValue()) 
            this.noMueveReferenciadas(actividad.getGrupo(), actividad.getActividad(), desplazamiento); 
        // 5.- actualizaDiasActividadGrupo(actividad.grupo); 
        this.actualizaDiasActividadGrupo(actividad.getGrupo()); 
        UtilidadesLog.info("TADMatrizDias.modificaActividad (DTOActividadMatriz actNueva):Salida");
    }


    /**
     * Fija las actividades referenciadas a una actividad (identificada por grupo y oid actividad)
     * en la matriz. Esta operación se hace moviendo el día de desplazamiento
     * en el que se realiza cada actividad referenciada tanto como indique el parámetro desplazamiento. 
     * Esto produce que las actividades referenciadas queden en el mismo día del periodo de la matriz.
     */
    private void noMueveReferenciadas (Long grupo, Long actividad, Integer desplazamiento) {
        UtilidadesLog.info("TADMatrizDias.noMueveReferenciadas (Long grupo, Long actividad, Integer desplazamiento):Entrada");
        // 1.- DTOActividadMatriz[] actividades = referenciadas(actividad.grupo, actividad.actividad); 
        Vector actividades = referenciadas(grupo, actividad); 

        // 2.- Por cada elemento del array actividades que llamamos act[i] se hace: 
        // act[i].dia = act[i].dia - desplazamiento;
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);
            dtoA.setDia(new Long(dtoA.getDia().intValue() - desplazamiento.intValue()));
        }
        UtilidadesLog.info("TADMatrizDias.noMueveReferenciadas (Long grupo, Long actividad, Integer desplazamiento):Salida");
    }


    /**
     * Obtiene las distintas actividades de la matriz de días. 
     */
    public Vector obtieneActividades() {
        // 1.- grupos = obtieneGruposZona(); 
        Vector grupos = obtieneGruposZona();
        // 2.- DTOActividadMatriz[] actividades; 
        Vector actividades = new Vector();
        // 3.- Para todos los grupos se hace obtieneDistintasActividades(grupo[i],actividades); 
        for (int i = 0; i < grupos.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) grupos.get(i);
            obtieneDistintasActividades(dtoG, actividades);
        }
        // 4.- Devuelve actividades;
        return actividades;
    }


    /**
     * Obtiene las actividades del grupo pasado por parámetro, cuyo oid no esté en la colección actividades. 
     */
    public void obtieneDistintasActividades (DTOGrupoMatriz grupo, Vector actividades) {
        // 1.- actividadesGrupo = obtieneActividadesGrupo(grupo); 
        Vector actividadesGrupo = obtieneActividadesGrupo(grupo.getGrupoZona()); 
        // 2.- Añade al array actividades aquellos elementos de actividadesGrupo cuyo atributo oidActividad 
        // no sea igual a ningún atributo oidActividad de ninguno de los elementos del parámetro actividades. 
        for (int i = 0; i < actividadesGrupo.size(); i++) {
            DTOActividadMatriz dtoAG = (DTOActividadMatriz) actividadesGrupo.get(i);
            boolean encontre = false;
            int j = 0;
            while (j < actividades.size() && !encontre) {
                DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(j);
                if (dtoAG.getActividad().compareTo(dtoA.getActividad()) == 0) 
                    encontre = true;
                j++;
            }
            if (!encontre) 
                actividades.add(dtoAG);
        }
    }


    /**
     * Devuelve una actividad de un determinado día de un grupo de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesDia (Long grupo, Long diaPeriodo) {
        try {
            UtilidadesLog.info("grupo a obtener:"+grupo);
            DTOGrupoMatriz dtoGrupo = obtieneGrupoZona(grupo); 
            Vector actividades = new Vector();
            Vector acts = dtoGrupo.getActividades();
            for (int i = 0; i < acts.size(); i++) {
                DTOActividadMatriz dtoA = (DTOActividadMatriz) acts.get(i);
                if (dtoA.getTipoActividad().equals("Ref. Otra Camp.")||(dtoA.getOrigen()!=null&&origenReferencia(acts,dtoA.getOrigen()))) {
                    //En este caso no se incluye ya que la actividad es de otra campaña.
                    UtilidadesLog.info("No se incluye la actividad: " + dtoA.getTextoActividad() + " por pertenecer a otra campaña. Origen:"+dtoA.getTextoActOrigen());
                } else {
                  if (dtoA.getDiaPeriodo().compareTo(diaPeriodo) == 0) 
                      actividades.add(dtoA);
                }
            }
            return actividades;
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            return null;
        }

    }


    /**
     * Obtiene las actividades fuera de periodo de una serie de grupos de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesFueraPeriodo (Vector grupos) {
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesFueraPeriodo (Vector grupos):Entrada");
        Vector actividadesFuera = new Vector();

        for (int i = 0; i < grupos.size(); i++) {
            Vector actividadesFueraGrupo = obtieneActividadesFueraPeriodo((Long) grupos.get(i));
            actividadesFuera.addAll(actividadesFueraGrupo);
        }
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesFueraPeriodo (Vector grupos):Salida");
        return actividadesFuera;
    }


    /**
     * Obtiene las actividades fuera de periodo de un grupo de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesFueraPeriodo (Long grupo) {
        // 1.- Se declara un array vacío DTOActividadMatriz[] actividadesFuera; 
        Vector actividadesFuera = new Vector();
        // 2.- Obtiene los dias de periodo de la matriz
        Long diasPeriodoMatriz = matrizDias.getDias(); 
        // 3.- Obtiene las actividades del grupo: 
        Vector actividades = obtieneActividadesGrupo(grupo); 
        // 4.- Se añaden los elementos de actividades cuyo atributo diaPeriodo sea
        // mayor o igual que diasPeriodoMatriz o que sea menor que 0 al array actividadesFuera
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);
            if (dtoA.getDiaPeriodo() != null && diasPeriodoMatriz != null) {
                if ( (dtoA.getDiaPeriodo().longValue() >= diasPeriodoMatriz.longValue())
                        || (dtoA.getDiaPeriodo().longValue() < 0) ) {
                    if (dtoA.getTipoActividad().equals("Ref. Otra Camp.")||(dtoA.getOrigen()!=null&&origenReferencia(actividades,dtoA.getOrigen()))) {
                      //Inc. 20080662
                    } else {
                      actividadesFuera.add(dtoA);
                    }
                }
            }
        }
        // 5.- Se devuelve actividadesFuera.
        return actividadesFuera;
    }


    /**
     * Obtiene las actividades fuera de periodo de todos los grupos de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesFueraPeriodo() {
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesFueraPeriodo():Entrada");
        Vector grupos = obtieneGruposZona();
        Vector oids = new Vector();
        for (int i = 0; i < grupos.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) grupos.get(i);
            oids.add(dtoG.getGrupoZona());
        }
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesFueraPeriodo():Salida");
        return obtieneActividadesFueraPeriodo(oids);
    }


    public Long obtieneDiasMatriz() {
        return matrizDias.getDias();
    }


    public RecordSet obtieneRecordSetActividadesGrupo (Long grupo) {
        UtilidadesLog.info("TADMatrizDias.obtieneRecordSetActividadesGrupo (Long grupo):Entrada");
        Vector actividades = obtieneActividadesGrupo(grupo); 
        RecordSet resultado = new RecordSet();
        resultado.addColumn("oid");
        resultado.addColumn("descripcion");
        for (int i = 0; i < actividades.size(); i++) {
            Vector registro = new Vector();
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);
            registro.add(dtoA.getActividad());
            registro.add(dtoA.getTextoActividad());
            resultado.addRow(registro);
        }
        UtilidadesLog.info("TADMatrizDias.obtieneRecordSetActividadesGrupo (Long grupo):Salida");
        return resultado;
      
    }

    /*
     * Devuelve todos los grupos de zonas de la matriz de días.
     * Los devuelve encapsuladas en un RecordSet de n registros [oid, descripcion].
     */
    public RecordSet obtieneRecordSetGruposZona() {
        UtilidadesLog.info("TADMatrizDias.obtieneRecordSetGruposZona():Entrada");
        Vector grupos = obtieneGruposZona();
        RecordSet resultado = new RecordSet();
        resultado.addColumn("oid");
        resultado.addColumn("descripcion");
        for (int i = 0; i < grupos.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) grupos.get(i);
            Vector registro = new Vector();
            registro.add(dtoG.getGrupoZona());
            registro.add(dtoG.getTextoGrupo());
            resultado.addRow(registro);
       }
       UtilidadesLog.info("TADMatrizDias.obtieneRecordSetGruposZona():Salida");
        return resultado;
    }

  /**
     * Obtiene las actividades con referencia a otra campaña de una serie de grupos de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesRefOtraCampana (Vector grupos) {
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana (Vector grupos):Entrada");
        Vector actRefOtraCamp = new Vector();

        for (int i = 0; i < grupos.size(); i++) {
            Vector actividadesRefOtCaGrupo = obtieneActividadesRefOtraCampana((Long) grupos.get(i));
            actRefOtraCamp.addAll(actividadesRefOtCaGrupo);
        }
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana (Vector grupos):Salida");
        return actRefOtraCamp;
    }


    /**
     * Obtiene las actividades con referencia a otra campaña de un grupo de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesRefOtraCampana (Long grupo) {
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana (Long grupo):Entrada");
        
        Vector actividadesRefOtCamp = new Vector();        
        // 3.- Obtiene las actividades del grupo: 
        Vector actividades = obtieneActividadesGrupo(grupo); 
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);
            UtilidadesLog.info("Actividad:"+dtoA.getActividad());
            UtilidadesLog.info("Tipo:"+dtoA.getTipoActividad());
            UtilidadesLog.info("Origen:"+dtoA.getOrigen());
            UtilidadesLog.info("Nom Act:"+dtoA.getTextoActividad());
            UtilidadesLog.info("Nom Orig:"+dtoA.getTextoActOrigen());
            if (dtoA.getTipoActividad().equals("Ref. Otra Camp.")){//Referencia a otra campaña
                actividadesRefOtCamp.add(dtoA);
            } else if (dtoA.getOrigen()!=null&&origenReferencia(actividades,dtoA.getOrigen())) {
                actividadesRefOtCamp.add(dtoA);
            }
        }
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana (Long grupo):Salida");
        return actividadesRefOtCamp;
    }


    /**
     * Obtiene las actividades con referencia a otra campaña de todos los grupos de zonas de la matriz de días. 
     */
    public Vector obtieneActividadesRefOtraCampana() {
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana():Entrada");
        Vector grupos = obtieneGruposZona();
        Vector oids = new Vector();
        for (int i = 0; i < grupos.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) grupos.get(i);
            oids.add(dtoG.getGrupoZona());
        }
        UtilidadesLog.info("TADMatrizDias.obtieneActividadesRefOtraCampana():Salida");
        return obtieneActividadesRefOtraCampana(oids);
    }   
    
    /**
     * Corrobora si el origen de una actividad o algun origen anidado Referencia a otra campaña. 
     */
    public boolean origenReferencia(Vector actividades, Long oidOrigen) {
        UtilidadesLog.info("TADMatrizDias.origenReferencia(Vector actividades, Long oidOrigen):Entrada");
        
        for (int i = 0; i < actividades.size(); i++) {
            DTOActividadMatriz dtoA = (DTOActividadMatriz) actividades.get(i);            
            if (dtoA.getActividad().equals(oidOrigen)){
              if (dtoA.getTipoActividad().equals("Ref. Otra Camp.")) {
                return true;
              } else if (dtoA.getOrigen()!=null&&origenReferencia(actividades,dtoA.getOrigen())) {
                return true;
              }
            }
        }
        UtilidadesLog.info("TADMatrizDias.origenReferencia(Vector actividades, Long oidOrigen):Salida");        
        return false;
    }      
}