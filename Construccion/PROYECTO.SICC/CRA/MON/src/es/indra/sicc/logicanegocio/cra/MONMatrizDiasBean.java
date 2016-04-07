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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.cra.util.TADMatrizDias;
import es.indra.sicc.dtos.cra.DTOActividadMatriz;
import es.indra.sicc.dtos.cra.DTOGrupoMatriz;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.entidades.cra.HistoricoMatrizDiasLocal;
import es.indra.sicc.entidades.cra.HistoricoMatrizDiasLocalHome;
import es.indra.sicc.entidades.cra.MatrizDiasLocal;
import es.indra.sicc.entidades.cra.MatrizDiasLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONMatrizDiasBean implements SessionBean  {
  private SessionContext sessionContext;

  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
  }


    /**
     * Obtiene la matriz de días por país, marca, canal y n grupos de zonas. 
     */
    public DTOMatrizDias obtieneMatriz(DTOMatrizDias dto) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.obtieneMatriz(DTOMatrizDias dto):Entrada");
        // A-. Si es crear 
        if (dto.getEsCrear() != null && dto.getEsCrear().booleanValue()) {
            dto.setDias(new Long(obtieneDiasMatriz(dto.getCanal()).toString()));      
            dto.setGrupos(new Vector());    //vector vacio, NO null gracias.
            UtilidadesLog.info("MONMatrizDiasBean.obtieneMatriz(DTOMatrizDias dto):Salida");
            return dto;
        }

        // B-. Si NO es crear
        Boolean valida = Boolean.FALSE;
        try {
            //1.- Se llama a MONValidacion.validarAccesos
            MONValidacionHome mvh = this.getMONValidacionHome();
            MONValidacion validacion = mvh.create();
            valida = validacion.validarAccesos(dto.getOidPais(), null, dto.getMarca(), dto.getCanal(),null, null, null, null, null, null, null);

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

        if (!valida.booleanValue()){
            UtilidadesLog.debug("CodigosError.ERROR_ASOCIACION_ESTRUCTURAL " + CodigosError.ERROR_ASOCIACION_ESTRUCTURAL);
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }else {
            // 2.- DAOMatrizDias.obtieneMatrizPorPMCG(dto) -> registros 
            DAOMatrizDias daoMD = new DAOMatrizDias();
            RecordSet rs = daoMD.obtieneMatrizPorPMCG(dto);

            // 3.- Si no devuelve ningún resultado lanza la siguiente excepción: GEN-0005 
            if (rs.esVacio()) {
                UtilidadesLog.debug("CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE=" + CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            // 4.- TADMatrizDias tadMatrizDias = new TADMatrizDias(dto.pais, dto.marca, dto.canal); 
            TADMatrizDias tadMatrizDias = new TADMatrizDias(dto.getOidPais(), dto.getMarca(), dto.getCanal()); 

            // 5.- Devuelve el resultado de tadMatrizDias.obtieneMatrizPorRecordSet(registros); 
            UtilidadesLog.info("MONMatrizDiasBean.obtieneMatriz(DTOMatrizDias dto):Salida");
            return tadMatrizDias.obtieneMatrizPorRecordSet(rs);
        }
        
    }


    /**
     * Obtiene las actividades referenciadas de una actividad indicada por el oid del dto.
     * Devuelve ese grupo de referenciadas ya montado en un DTOGrupoMatriz.
     * Nota: Retorna la actividad padre y sus referenciadas.
     * Nota: Verifica no caer en un ciclo.
     */
    public DTOGrupoMatriz obtieneReferenciadas(DTOGrupoMatriz dto) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.obtieneReferenciadas(DTOGrupoMatriz dto):Entrada");
        boolean hayCiclo = false;
        DTOGrupoMatriz dtoSalida = new DTOGrupoMatriz();
        dtoSalida.setGrupoZona(dto.getGrupoZona());
        dtoSalida.setActividades(new Vector());
        dtoSalida.setTextoGrupo(dto.getTextoGrupo());
        dtoSalida.setActividad(dto.getActividad());

        DAOMatrizDias daoMD = new DAOMatrizDias();
        BigDecimal origen = new BigDecimal(dto.getActividad().toString());
        boolean refOtraCamp = false;

        do {
            //verificamos si se genero un ciclo, si es asi se agrega la actividad que lo genera.
            if (incluyeActividad(new Long(origen.toString()), dtoSalida)) {
                hayCiclo = true;                
            }
            if (refOtraCamp) {
               //Si la ultima actividad obtenida referencia otra campaña no obtengo el origen, ya que, ese origen
               //no es una actividad de esta matriz.
              origen = null;
            } else {
              //obtenemos la actividad actual y su referencia (siempre se encuentra)            
              RecordSet registros = daoMD.obtieneActividadReferencia(new Long(origen.toString()),dto.getOidIdioma());
              DTOActividadMatriz dtoActMatrix = new DTOActividadMatriz();
              dtoSalida.getActividades().add(dtoActMatrix);
              dtoActMatrix.setActividad(new Long(((BigDecimal) registros.getValueAt(0, "OID")).toString()));
              origen = (BigDecimal) registros.getValueAt(0,"ORIGEN");
              // la actividad actual puede no tener actividad origen
              if (origen !=null) 
                  dtoActMatrix.setOrigen(new Long(origen.toString()));
              if (registros.getValueAt(0,"DIAS") !=null) 
                  dtoActMatrix.setDia(new Long(((BigDecimal) registros.getValueAt(0,"DIAS")).toString()));
              else dtoActMatrix.setDia(new Long(0));
              dtoActMatrix.setDiasFinal(new Long(0));
              dtoActMatrix.setDiasIntervalo(new Long(0));
              dtoActMatrix.setDiaPeriodo(new Long(0));
              dtoActMatrix.setOid(null);
              dtoActMatrix.setIdVista(null);
              dtoActMatrix.setTextoActividad((String) registros.getValueAt(0,"TEXTOACTIVIDAD"));
              dtoActMatrix.setCodigo((String) registros.getValueAt(0,"CODIGOACTIVIDAD"));
              dtoActMatrix.setClase(new Long(((BigDecimal) registros.getValueAt(0,"CLASEACTIVIDAD")).toString()));            
              if (registros.getValueAt(0,"DESC_TIPO")!=null) {
                dtoActMatrix.setTipoActividad((String) registros.getValueAt(0,"DESC_TIPO"));//desc_tipo
                if (dtoActMatrix.getTipoActividad().equals("Ref. Otra Camp."))
                  refOtraCamp = true;
              }
              if (registros.getValueAt(0,"CAMP_DESPLA")!=null)  
                dtoActMatrix.setCampDesplazamiento(new Integer(((BigDecimal) registros.getValueAt(0,"CAMP_DESPLA")).toString()));//camp_despla
              if (registros.getValueAt(0,"ACTIVIDADORIGEN")!=null)
                dtoActMatrix.setTextoActOrigen((String) registros.getValueAt(0,"ACTIVIDADORIGEN"));//actividadorigen
            }            
        } while ( (origen != null) && (!hayCiclo) );
        UtilidadesLog.debug("Dto Salida en MON: "+dtoSalida);
        UtilidadesLog.info("MONMatrizDiasBean.obtieneReferenciadas(DTOGrupoMatriz dto):Salida");
        return dtoSalida;
    }


    /*
     * Retorna true si la actividad esta en dtoGrupoMatriz.
     */
    private boolean incluyeActividad(Long oidActividad, DTOGrupoMatriz dtoGrupoMatriz) {
        UtilidadesLog.info("MONMatrizDiasBean.incluyeActividad(Long oidActividad, DTOGrupoMatriz dtoGrupoMatriz):Entrada");
        
        boolean incluye = false;
        DTOActividadMatriz dtoActividadMatriz;
        // Se verifica si oidActividad esta entre las actividades de dtoGrupoMatriz.actividades
        Iterator iter = dtoGrupoMatriz.getActividades().iterator();
        while (iter.hasNext() && (! incluye)) {
            dtoActividadMatriz = (DTOActividadMatriz) iter.next();
            if (dtoActividadMatriz.getActividad().equals(oidActividad)) {
                incluye = true;    
            }
        }
        UtilidadesLog.info("MONMatrizDiasBean.incluyeActividad(Long oidActividad, DTOGrupoMatriz dtoGrupoMatriz):Salida");
        return incluye;
    }


    /**
     * Actualiza la matriz de días con la información del dto. 
     */
    public void actualizaMatriz(DTOMatrizDias dto) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.actualizaMatriz(DTOMatrizDias dto):Entrada");
        
        Boolean valida = Boolean.FALSE;
        try {
            MONValidacionHome mvh = this.getMONValidacionHome();
            MONValidacion validacion = mvh.create();

            // 1.- Se llama a MONValidacion.validarAccesos    
            //VER no levanta MARE/UP
            valida = validacion.validarAccesos(dto.getOidPais(), null, dto.getMarca(), dto.getCanal(),null, null, null, null, null, null, null);
            UtilidadesLog.debug("Paso validacion de Accesos: "+ valida);
            //valida = new Boolean(true);

            if ( ! valida.booleanValue()){
                throw new MareException(new MareException(),UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }

            // 2.- Se llama a MONValidacion.validarVinculos
            valida = validacion.validarVinculos(dto.getOidPais(), null, dto.getMarca(), dto.getCanal(),null, null);
          
            if (!valida.booleanValue()){
                throw new MareException(new MareException(),UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS));
            }

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
            sessionContext.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        /* Si las dos validaciones son true */

        // 3.- Por cada elemento grupo del vector dto.grupos hace: actualizaGrupo(grupo); 
        Vector v = dto.getGrupos();
        for (int i = 0; i < v.size(); i++) {
            DTOGrupoMatriz dtoG = (DTOGrupoMatriz) v.get(i);
            dtoG.setIpCliente(dto.getIpCliente());
            dtoG.setPrograma(dto.getPrograma());
            // actualiza el grupo de zonas
            actualizaGrupo(dtoG);
        }
        UtilidadesLog.info("MONMatrizDiasBean.actualizaMatriz(DTOMatrizDias dto):Salida");
    }


    /**
     * Actualiza un grupo de zonas de la matriz de días con la información del dto. 
     */
    private void actualizaGrupo(DTOGrupoMatriz dto) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.actualizaGrupo(DTOGrupoMatriz dto):Entrada");
        

        // 0.- Por cada elemento i-ésimo de dto.borradas se hace pasaAHistorico(dto.borradas[i]) 
        Vector borradas = dto.getBorradas();
        for (int j = 0; j < borradas.size(); j++) {
            DTOActividadMatriz actBorrada = (DTOActividadMatriz) borradas.get(j);
            // si actBorrada fue insertada anteriormente
            if (actBorrada.getOid() != null) {
                this.pasaAHistorico(actBorrada);
            }
        }

        /* Por cada elemento de dto.actividades */
        Vector v = dto.getActividades();
        for (int i = 0; i < v.size(); i++) {
            DTOActividadMatriz act = (DTOActividadMatriz) v.get(i);
            act.setIpCliente(dto.getIpCliente());
            act.setPrograma(dto.getPrograma());

            // 1.- Si (act.oid != null) se hace: pasaAHistorico(act.oid); 
            if (act.getOid() != null) {
                //SI es una una modificacin lo pasa a historico.
                pasaAHistorico(act);
            }
            
            try {
                // 2.- MatrizDias.create() con campos dias, grupoZona, actividad.
                MatrizDiasLocalHome matrizLocalHome = new MatrizDiasLocalHome();            
                MatrizDiasLocal matrizLocal = matrizLocalHome.create(dto.getGrupoZona(),
                                                  act.getActividad(), act.getDia());

                // 3.- Se actualizan los campos diasFinal, diasIntervalo, actividadOrigen.
                matrizLocal.setDiasFinal(act.getDiasFinal());
                matrizLocal.setDiasIntervalo(act.getDiasIntervalo());
                matrizLocal.setActividadOrigen(act.getOrigen());
                matrizLocal.setCampDesplazamiento(act.getCampDesplazamiento());
                matrizLocalHome.merge(matrizLocal);

            } catch (EntityExistsException eee) {
                UtilidadesLog.debug(eee);
                sessionContext.setRollbackOnly();
                  throw new MareException(eee,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (PersistenceException createException) {
                UtilidadesLog.error(createException);
                sessionContext.setRollbackOnly();
                  throw new MareException(createException,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (Exception exception){
                UtilidadesLog.error(exception);
                sessionContext.setRollbackOnly();
                    throw new MareException(exception,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONMatrizDiasBean.actualizaGrupo(DTOGrupoMatriz dto):Salida");
    }


    /**
     * Pasa un registro de la Matriz de días identificado por el oid = oidMatriz
     * al Histórico de Matriz de Días. Posteriormente elimina el registro de Matriz de Días.
     */
    private void pasaAHistorico(DTOActividadMatriz actividadMatriz) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.pasaAHistorico(DTOActividadMatriz actividadMatriz):Entrada");
        Long oidMatriz = actividadMatriz.getOid();
        MatrizDiasLocalHome matrizLH = new MatrizDiasLocalHome();
        MatrizDiasLocal matrizLocal = null;
        try {
            // 1.- Con entity MatrizDias mediante findByPrimaryKey(oidMatriz) encuentra matrizDias; 
            matrizLocal = matrizLH.findByPrimaryKey(oidMatriz);
        } catch(NoResultException e) {
            UtilidadesLog.error(e);
            sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        try {
            // 2.- Hace un create del EJB entity HistoricoMatrizDias
            HistoricoMatrizDiasLocalHome hMDLH = new HistoricoMatrizDiasLocalHome();
            HistoricoMatrizDiasLocal hMDL = hMDLH.create(  
                                                matrizLocal.getGrupoZona(),
                                                matrizLocal.getActividad(),
                                                matrizLocal.getDias(),
                                                new Timestamp(System.currentTimeMillis()));

            hMDL.setDiasFinal(matrizLocal.getDiasFinal());                
            hMDL.setDiasIntervalo(matrizLocal.getDiasIntervalo());
            hMDL.setActividadOrigen(matrizLocal.getActividadOrigen());
            hMDL.setCampDesplazamiento(matrizLocal.getCampDesplazamiento());
            hMDLH.merge(hMDL);

        } catch(EntityExistsException e) {
            UtilidadesLog.debug(e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch(PersistenceException e) {
            UtilidadesLog.error(e);
            sessionContext.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        try {
            // 3.- Posteriormente se elimina matrizDias: matrizDias.remove(); 
            matrizLH.remove(matrizLocal);
        } catch (PersistenceException removeException) {
            UtilidadesLog.debug(removeException);
            sessionContext.setRollbackOnly();
            throw new MareException(removeException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }  
        
        UtilidadesLog.info("MONMatrizDiasBean.pasaAHistorico(DTOActividadMatriz actividadMatriz):Salida");
    }


    /**
     * Obtiene oid y descripción de los grupos de zonas no relacionados con matriz de días
     * y filtrados por país, marca, canal. 
     */
    public DTOSalida obtieneGruposFueraMatriz(DTOMatrizDias dto) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.obtieneGruposFueraMatriz(DTOMatrizDias dto):Entrada");
        DTOSalida dtoS = new DTOSalida();
        DAOMatrizDias daoMD = new DAOMatrizDias();
        RecordSet registros = daoMD.obtieneGruposFueraMatriz(dto);
        dtoS.setResultado(registros);
        UtilidadesLog.info("MONMatrizDiasBean.obtieneGruposFueraMatriz(DTOMatrizDias dto):Salida");
        return dtoS;
    }


    /**
     * Obtiene el número de días de periodo definido en Tipo de periodo de seg,
     * para el canal dado. 
     */
    public Integer obtieneDiasMatriz(Long canal) throws MareException {
        UtilidadesLog.info("MONMatrizDiasBean.obtieneDiasMatriz(Long canal):Entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" c.TIPE_OID_TIPO_PERI ");
        query.append(" FROM SEG_CANAL c ");
        query.append(" WHERE c.OID_CANA = " + canal + " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE=" + CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        Long tipoPeriodo = new Long(((BigDecimal) rs.getValueAt(0,0)).toString());

        query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" t.NUM_DIAS ");
        query.append(" FROM SEG_TIPO_PERIO t ");
        query.append(" WHERE t.OID_TIPO_PERI = " + tipoPeriodo + " ");

        rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE=" +CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMatrizDiasBean.obtieneDiasMatriz(Long canal):Salida");
        return new Integer(((BigDecimal) rs.getValueAt(0,0)).toString());
    }


    private BelcorpService getBelcorpService() {
       try  {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe)  {
            throw new EJBException( "MareMiiServiceNotFoundException: "
                        + mmsnfe.getMessage(), mmsnfe);
        } 
    }

    private MONValidacionHome getMONValidacionHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacion"), MONValidacionHome.class);
      
    }
    
 
}