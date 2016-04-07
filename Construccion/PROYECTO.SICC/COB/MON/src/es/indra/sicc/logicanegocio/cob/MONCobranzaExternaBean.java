package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.cob.DTOCriteriosBusquedaLiquidacionCom;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOSimulacionLiquidacion;
import es.indra.sicc.dtos.cob.DTOSimulacionComisiones;
import es.indra.sicc.dtos.cob.DTOEscalaLiquidacion;
import java.math.BigDecimal;
import java.sql.Date;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOUsuariosYGruposCOB;
import es.indra.sicc.entidades.cob.HistoricoComisionesCobranzaLocalHome;
import es.indra.sicc.entidades.cob.HistoricoComisionesCobranzaLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.util.COBEjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

public class MONCobranzaExternaBean implements SessionBean 
{
  private SessionContext sessionContext;
  
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
    this.sessionContext= ctx;
  }
  
  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       19/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada) throws MareException {
  
    UtilidadesLog.info("MONCobranzaExternaBean.listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada): Entrada");
  
    DAOCobranzaExterna dao = new DAOCobranzaExterna();
    
    dtoEntrada.setUserLogin(sessionContext.getCallerPrincipal().getName());
		DTOSalida dtoSalida = dao.listadoDeudasUsuario(dtoEntrada);
    
        UtilidadesLog.info("MONCobranzaExternaBean.listadoDeudasUsuario(DTOCriteriosBusquedaLiquidacionCom dtoEntrada): Salida");
    
		return dtoSalida;  
  }

  public DTOSimulacionLiquidacion simulacionLiquidacion(DTOSimulacionLiquidacion dto) throws MareException {
  
    UtilidadesLog.info("MONCobranzaExternaBean.simulacionLiquidacion(DTOSimulacionLiquidacion dto): Entrada");
  
      UtilidadesLog.debug("Valores simulacion: " + dto);
      try {
          // Simulaciones de comisiones
          DTOSimulacionComisiones[] dtoSimulacionComisionesArr = dto.getLiquidaciones();
          DTOSimulacionComisiones dtoSimulacionComisiones = null;
          DTOEscalaLiquidacion dtoEscalaLiquidacion = null;
          
          DAOCobranzaExterna daoCobranzaExterna= new DAOCobranzaExterna(sessionContext);
          
          DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
          dtoNumeroSolicitud.setOperacion("COB095");
          dtoNumeroSolicitud.setOidPais(dto.getOidPais());
          for(int i=0;i< dtoSimulacionComisionesArr.length; i++){
              dtoSimulacionComisiones = (DTOSimulacionComisiones)dtoSimulacionComisionesArr[i];
              
              // Escala de liquidación
              dtoEscalaLiquidacion = daoCobranzaExterna.obtenerEscalaLiquidacion(dtoSimulacionComisiones);
            
              UtilidadesLog.debug("dtoEscalaLiquidacion: " + dtoEscalaLiquidacion);             
              
              // Calculo de Comisión
              BigDecimal comisionPorcentaje;
              BigDecimal comisionImporte;
              
              if (dtoEscalaLiquidacion != null){
                //  Se agregaron validacion de nulos, Modificado por HRCS - Fecha 30/03/2007 - Incidencia Sicc20070181
                if (dtoEscalaLiquidacion.getComisionPorcentaje()!=null) {
                    UtilidadesLog.debug("Entro por NO NULL [comisionPorcentaje]");
                    comisionPorcentaje = new BigDecimal(dtoEscalaLiquidacion.getComisionPorcentaje().floatValue());
                }
                else    {
                    UtilidadesLog.debug("Entro por NULL [comisionPorcentaje]");
                    comisionPorcentaje = new BigDecimal(new Long (0).toString());    
                }
                if (dtoEscalaLiquidacion.getComisionImporte()!=null)    {
                    UtilidadesLog.debug("Entro por NO NULL [comisionImporte]");
                    comisionImporte = new BigDecimal(dtoEscalaLiquidacion.getComisionImporte().floatValue());
                }
                else    {
                    UtilidadesLog.debug("Entro por NULL [comisionImporte]");
                    comisionImporte = new BigDecimal(new Long (0).toString());    
                }
              }else{
                UtilidadesLog.debug("Entro por NULL ");
                comisionPorcentaje = new BigDecimal(new Long (0).toString());
                comisionImporte = new BigDecimal(new Long (0).toString());
              }
              
              UtilidadesLog.debug("comisionPorcentaje = " + comisionPorcentaje.toString());             
              UtilidadesLog.debug("comisionImporte = " + comisionImporte.toString());             
              
              BigDecimal comisionCalculada = comisionImporte.add((dtoSimulacionComisiones.getImporteDeuCancelada().multiply(comisionPorcentaje)).divide(new BigDecimal(100) , 2, BigDecimal.ROUND_HALF_UP));
              UtilidadesLog.debug("comisionCalculada = " + comisionCalculada.toString());
            
              dtoSimulacionComisiones.setComisionCalculada(comisionCalculada);        
              Date fechaCalculo = new Date(System.currentTimeMillis());
              if(!dto.getSimulacion().booleanValue()){
                  MONProcesosPEDHome monProcesosPEDHome = PEDEjbLocators.getMONProcesosPEDHome();
                  MONProcesosPED monProcesos = monProcesosPEDHome.create();
                  HistoricoComisionesCobranzaLocalHome  histComHome = this.getHistoricoComisionesCobranzaLocalHome();       
                  HistoricoComisionesCobranzaLocal histComCob = null;
                  // Genero Nro de documento
                  String idLiquidacion = monProcesos.generaNumeroDocumento(dtoNumeroSolicitud);
                  UtilidadesLog.debug("generaNumeroDocumento: " + idLiquidacion);
                  // Inserto en HistoricoComisionesCobranza
                  histComCob = histComHome.create(new Long(idLiquidacion), dtoSimulacionComisiones.getOidPeriodo(), dtoSimulacionComisiones.getOidUsuario(), dtoSimulacionComisiones.getOidMetodoLiquidacion(),dtoSimulacionComisiones.getOidEtapa());
                  histComCob.setImporteDeudaAsignada(dtoSimulacionComisiones.getImporteDeuAsignada());
                  histComCob.setImporteDeudaRecuperada(dtoSimulacionComisiones.getImporteDeuCancelada());
                  histComCob.setImporteComisionCalculada(comisionCalculada);
                  histComCob.setFechaCalculoComision(fechaCalculo);
                  
                  histComHome.merge(histComCob);
                  
                  dtoSimulacionComisiones.setIdLiquidacion(idLiquidacion);
                  dtoSimulacionComisiones.setOidLiquidacion(histComCob.getOid());
                  
                  daoCobranzaExterna.actualizarAsignacionesCobranzas(dtoSimulacionComisiones);                  
              }
              //esto debe hacerse aqui. ya que le fecha traida de pantalla y usada en el update
              //de arriba es la fecha de asignacion
              dtoSimulacionComisiones.setFechaCalculo(fechaCalculo);   
          }
      } catch(PersistenceException e) {
           sessionContext.setRollbackOnly();
           e.printStackTrace();
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      
        UtilidadesLog.debug("salida: " + dto);
      
        UtilidadesLog.info("MONCobranzaExternaBean.simulacionLiquidacion(DTOSimulacionLiquidacion dto): Salida");
      
      return dto;
  }

    public Float calcularPorcentajeDeudaCancelada(DTOSimulacionComisiones dto) throws MareException {
    
        UtilidadesLog.info("MONCobranzaExternaBean.calcularPorcentajeDeudaCancelada(DTOSimulacionComisiones dto): Entrada");
    
        /*   ** MONCobranzaExterna.calcularPorcentajeDeudaCancelada(dto : DTOSimulacionComisiones) : Float */ 
        /*Entrada: 
        - dto : DTOSimulacionComisiones 
        Proceso: 
        -> Crear variable llamada "respuesta" de tipo Float 
        (1) Si (dto.oidBaseEscala == ConstantesCOB.OID_VALOR_ENT_ETAPA_ANT) entonces 
        // Calcular porcentaje de deuda por etapa anterior 
        -> Crear variable llamada "importeDeudaAsignada" de tipo BigDecimal 
        -> Llamar al método "MONCobranzaExterna.calcularImporteDeudaAsignadaEtapaAnterior(dto : DTOSimulacionComisiones) : BigDecimal" 
        -> importeDeudaAsignada = respuesta a la llamada anterior 
        (2) Si (importeDeudaAsignada == 0) entonces 
        -> respuesta = dto.importeDeudaCancelada / importeDeudaAsignada * 100 
        (2) Si no entonces 
        -> respuesta = 0 
        (2) Fin Si 
        (1) Si no Si (dto.oidBaseEscala == ConstantesCOB.OID_VALOR_NOMINAL_VIVO) entonces 
        -> respuesta = dto.importeDeudaCancelada / dto.importeDeudaAsignada * 100 
        (1) Fin Si 
        -> Devolver respuesta */
        Float respuesta = null;
        
        UtilidadesLog.debug("-GA- oidBaseEscala: "+dto.getOidBaseEscala());
        
        if (dto.getOidBaseEscala().intValue() == ConstantesCOB.OID_VALOR_ENT_ETAPA_ANT.intValue())  {
            UtilidadesLog.debug("-GA- calcularPorcentajeDeudaCancelada: OID_VALOR_ENT_ETAPA_ANT");
            // Calcular porcentaje de deuda por etapa anterior 
            BigDecimal importeDeudaAsignada = calcularImporteDeudaAsignadaEtapaAnterior(dto);
            if (importeDeudaAsignada.intValue() != 0){
                respuesta = new Float((dto.getImporteDeuCancelada().doubleValue() / importeDeudaAsignada.doubleValue()) * 100);
            } else{            
                respuesta = new Float(0);
            }
        } else if (dto.getOidBaseEscala().intValue() == ConstantesCOB.OID_VALOR_NOMINAL_VIVO.intValue()){
            UtilidadesLog.debug("-GA- calcularPorcentajeDeudaCancelada: OID_VALOR_NOMINAL_VIVO");
            respuesta = new Float((dto.getImporteDeuCancelada().doubleValue() / dto.getImporteDeuAsignada().doubleValue()) * 100);
        }
        UtilidadesLog.info("MONCobranzaExternaBean.calcularPorcentajeDeudaCancelada(DTOSimulacionComisiones dto): Salida");
        return respuesta;
    }

  public BigDecimal calcularImporteDeudaAsignadaEtapaAnterior(DTOSimulacionComisiones dto) throws MareException {
  
    UtilidadesLog.info("MONCobranzaExternaBean.calcularImporteDeudaAsignadaEtapaAnterior(DTOSimulacionComisiones dto): Entrada");
  
    /*// Obtener el desglose por Clientes 
    -> Crear un objeto DTOCriteriosBusquedaLiquidacionCom tomando los atributos del dto de entrada */
    DTOCriteriosBusquedaLiquidacionCom dtoCriterioBusqueda = new DTOCriteriosBusquedaLiquidacionCom();
    //estos son los únicos valores que tienen en comun los DTO
    dtoCriterioBusqueda.setEtapa(dto.getOidEtapa());
    dtoCriterioBusqueda.setPeriodo(dto.getOidPeriodo());
    dtoCriterioBusqueda.setOidIdioma(dto.getOidIdioma());
    dtoCriterioBusqueda.setOidPais(dto.getOidPais());
    dtoCriterioBusqueda.setUserLogin(sessionContext.getCallerPrincipal().getName());    
        

    /*-> Asignar al atributo "agruparPorCliente" el valor "True" y tomar el dto como parámetro para la llamada siguiente: 
    -> Llamar al método "DAOCobranzaExterna.listadoDeudasUsuario(dtoEntrada : DTOCriteriosBusquedaLiquidacionCom) : DTOSalida" 
    -> Obtener asignaciones de clientes obtenidos en la etapa anterior 
    -> Tomar del recordSet los oid de cliente y crear una variable llamada "clientes" de tipo Long[] con todos ellos 
    -> Tomar el DTOCriteriosBusquedaLiquidacionCom creado antes y asignar "clientes" al atributo "clientes" del dto  dtoCriterioBusqueda
    */

    dtoCriterioBusqueda.setAgruparPorCliente(new Boolean(true));
    DAOCobranzaExterna daoCobranza = new DAOCobranzaExterna();
    DTOSalida dtoSalida = null;
    try{
        dtoSalida = daoCobranza.listadoDeudasUsuario(dtoCriterioBusqueda);
        UtilidadesLog.debug("DTO:" + dtoSalida);
    }catch(Exception ex){
        throw new MareException(ex);
    }
    
    RecordSet rsSalida = dtoSalida.getResultado();
    
    if (rsSalida.esVacio()){
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    int cantidad = rsSalida.getRowCount();
    Long[] clientes = new Long[cantidad];
    int i;
    for (i=0; i < cantidad; i ++ ){
        clientes [i] =  new Long (((BigDecimal)rsSalida.getValueAt(i,"OID")).toString());
    }
    dtoCriterioBusqueda.setClientes(clientes);
    
    /* -> 1. Llamar al método "MONCobranzaExterna.obtenerEtapaAnterior(etapa : Long) : Long" 
       -> Tomar el DTOCriteriosBusquedaLiquidacionCom creado antes y asignar la etapa obtenida al atributo "etapa" 
       -> Tomar el DTOCriteriosBusquedaLiquidacionCom creado antes y asignar NULL al atributo "usuarioCobranza" 
       -> Tomar este dto modificado como parámetro para la llamada siguiente: 
       -> Llamar al método "DAOCobranzaExterna.listadoDeudasUsuario(dtoEntrada : DTOCriteriosBusquedaLiquidacionCom) : DTOSalida" 
       -> Crear variable llamada "importeDeudaAsignada" de tipo BigDecimal 
       -> Recorrer el RecordSet obtenido y acumular en "importeDeudaAsignada" el importe de cada registro 
       -------------------------------------------------------------------------------------------------
       -> Nota 1: el punto 1. anterior se modifico segun incidencia y el metodo obtenerEtapaAnterior
       fue colocado en el DAOCobranzaExterna
    */
    
    dtoCriterioBusqueda.setEtapa(daoCobranza.obtenerEtapaAnterior(dtoCriterioBusqueda.getEtapa()));
    dtoCriterioBusqueda.setUsuarioCobranza(null);  
    try{
        dtoSalida = daoCobranza.listadoDeudasUsuario(dtoCriterioBusqueda);
    }catch(Exception ex){
        throw new MareException(ex);
    }   
    rsSalida = dtoSalida.getResultado();
    if (rsSalida.esVacio()){
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } 
    BigDecimal importeDeudaAsignada = new BigDecimal(0);
    cantidad = rsSalida.getRowCount();
    BigDecimal impDeudaAsig = null;
    for (i=0; i < cantidad; i ++ ){
        impDeudaAsig = rsSalida.getValueAt(i,"SUM(CAC.IMP_DEUD_ASIG)")!=null
                                    ?((BigDecimal) rsSalida.getValueAt(i,"SUM(CAC.IMP_DEUD_ASIG)"))
                                    :new BigDecimal(0);
                                    
        importeDeudaAsignada = importeDeudaAsignada.add(impDeudaAsig);
    }
    
    // Setea para la simulacion el Importe Deuda Asignada Etapa Anterior
    dto.setImporteDeuAsignadaEtapaAnt(importeDeudaAsignada);

    UtilidadesLog.info("MONCobranzaExternaBean.calcularImporteDeudaAsignadaEtapaAnterior(DTOSimulacionComisiones dto): Salida");

    //-> Devolver "importeDeudaAsignada" 
    return importeDeudaAsignada;
  }

  public Long obtenerEtapaAnterior(Long etapa) throws MareException
  {
    return null;
  }

  public DTOUsuariosYGruposCOB cargarUsuariosYGruposCOB(DTOBelcorp dto) throws MareException {
  
        UtilidadesLog.info("MONCobranzaExternaBean.cargarUsuariosYGruposCOB(DTOBelcorp dto): Entrada");
  
        DAOCobranzaExterna daoCobranza = new DAOCobranzaExterna();
        DTOUsuariosYGruposCOB dtoUsuarios = new DTOUsuariosYGruposCOB();
        dtoUsuarios.setGrupos(daoCobranza.obtenerGruposUsuariosCOB(dto));
        dtoUsuarios.setUsuarios(daoCobranza.obtenerUsuariosCOB(dto));
        
        UtilidadesLog.info("MONCobranzaExternaBean.cargarUsuariosYGruposCOB(DTOBelcorp dto): Salida");
        
        return dtoUsuarios;
    }

  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }

    private HistoricoComisionesCobranzaLocalHome getHistoricoComisionesCobranzaLocalHome() 
     {
       return new HistoricoComisionesCobranzaLocalHome();
     }

    public DTOSalida obtenerGruposUsuariosCOB(DTOBelcorp dto) throws MareException{
  
    UtilidadesLog.info("MONCobranzaExternaBean.obtenerGruposUsuariosCOB(DTOBelcorp dto): Entrada");
  
    DAOCobranzaExterna dao = new DAOCobranzaExterna();
    DTOSalida dtoSalida = new DTOSalida();
    dtoSalida.setResultado(dao.obtenerGruposUsuariosCOB(dto));
    
    UtilidadesLog.info("MONCobranzaExternaBean.obtenerGruposUsuariosCOB(DTOBelcorp dto): Salida");
    
  	return dtoSalida;  
   
  }

 
}