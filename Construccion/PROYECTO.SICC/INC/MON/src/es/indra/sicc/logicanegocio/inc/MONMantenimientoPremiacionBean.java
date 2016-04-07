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
 * Autor : Igor Dedough
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos;
import es.indra.sicc.dtos.inc.DTOElegirPremiosRec;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOBuscarClientesConcurso;
import es.indra.sicc.util.DTODate;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoPremiacionBean implements SessionBean {
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
        this.sessionContext = ctx;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 24 may 2005
     * @author Igor Dedough
     */
    public DTOSalida buscarConcursosPremiosRec(DTOElegirPremiosRec dtoe)
            throws MareException {
        return (new DAOMantenimientoPremiacion()).buscarConcursosPremiosRec(dtoe);
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 24 may 2005
     * @author Igor Dedough
     */
    public DTOSalida buscarNivelesPremiacion(DTOElegirPremiosRec dtoe)
            throws MareException {
        return (new DAOMantenimientoPremiacion()).buscarNivelesPremiacion(dtoe);
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @version 1.00 24 may 2005
     * @author Igor Dedough
     */

    /*-Hacer un clienteRecomendante = findByPK(dto.get(oidClienteRecomendante))
     * en la entidad ClientesRecomendantes
      -> Si clienteRecomendante == null
      Hacer un create en la entidad Clientes Recomendantes seteando los campos
      necesarios con los datos recibidos en el dto
      fin si
      -> Guardar un registro en la entidad ClientesRecomendados con los datos
      recibidos en el dto y con el oidRecomendante correspondiente
      al que existe o en su defecto al que acabamos de crear.
     */
    public void guardarPremio(DTOElegirPremiosRec dtoe)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoPremiacionBean.guardarPremio(DTOElegirPremiosRec dtoe):Entrada");
        UtilidadesLog.debug("Entro guardarPremio(DTOElegirPremiosRec dtoe) " + dtoe);
        ClienteRecomendanteLocalHome clienteRecomendanteLH = this.getClienteRecomendanteLocalHome();
        ClienteRecomendadoLocalHome clienteRecomendadoLH = this.getClienteRecomendadoLocalHome();
        ConcursoParametrosGeneralesLocalHome concParamGenLH = this.getConcursoParametrosGeneralesLocalHome();

        ClienteRecomendanteLocal clienteRecomendanteL = null;
        ConcursoParametrosGeneralesLocal concParamGenL = null;
        ClienteRecomendadoLocal clienteRecomendadoL = null;
        try { 
            clienteRecomendanteL = clienteRecomendanteLH.findByUK(dtoe.getOidClienteRecomendante(), dtoe.getOidConcurso());
            UtilidadesLog.debug("encontre clienteRecomendanteL " + clienteRecomendanteL.getOid()); 
                                                                                           
        } catch (NoResultException fe) {
            try {
                UtilidadesLog.debug("no encontre clienteRecomendanteL ");
                UtilidadesLog.debug(fe);
                clienteRecomendanteL = clienteRecomendanteLH.create(dtoe.getOidClienteRecomendante(), dtoe.getOidConcurso());
                UtilidadesLog.debug("cree clienteRecomendanteL " + clienteRecomendanteL.getOid());                                                                         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                sessionContext.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            }                                                                        
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        try {
            concParamGenL = concParamGenLH.findByPrimaryKey(dtoe.getOidConcurso());
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        try {
            MONPeriodosHome periodosH = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos periodos = periodosH.create();
            DTOPeriodo dtoPeriodo = periodos.obtienePeriodoActual(concParamGenL.getPais(), concParamGenL.getMarca(), concParamGenL.getCanal(), dtoe.getOidPeriodoVinculo() );

            if (dtoPeriodo != null) {
                Long lnOidPeriodoVinculo = dtoPeriodo.getOid();

                if (lnOidPeriodoVinculo != null) {
                    try {
                        clienteRecomendadoL = clienteRecomendadoLH.findByUK(clienteRecomendanteL.getOid(),
                                                                             dtoe.getOidClienteRecomendada());
                        //jrivas 18/8/2006 DBLG50001117
                        clienteRecomendadoL.setEfectiva(Boolean.FALSE);
                        
                        UtilidadesLog.debug("encontre clienteRecomendadoL " + clienteRecomendadoL.getOid());                                                                              

                    } catch (NoResultException fe) {
                        try {
                            UtilidadesLog.debug("no encontre clienteRecomendadoL ");                        
                            UtilidadesLog.debug(fe);
                            clienteRecomendadoL = clienteRecomendadoLH.create(dtoe.getOidClienteRecomendada(), 
                                                                                lnOidPeriodoVinculo, 
                                                                                clienteRecomendanteL.getOid());
                            UtilidadesLog.debug("cree clienteRecomendadoL " + clienteRecomendadoL.getOid());
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            sessionContext.setRollbackOnly();
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                        }                                                                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

                    }                                                                             
                    clienteRecomendadoL.setNivel(dtoe.getOidNivelPremiacion());                                                                          
                    clienteRecomendadoL.setNumeroPremio(dtoe.getNumeroPremio());
                    clienteRecomendadoLH.merge(clienteRecomendadoL);
                }
            }
        UtilidadesLog.info("MONMantenimientoPremiacionBean.guardarPremio(DTOElegirPremiosRec dtoe):Salida");
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 17 jun 2005
     * @author Cristian Valenzuela
     */
    public DTOCabeceraPremElegidos buscarCabeceraDetallePremElectivos(DTOCabeceraPremElegidos dtoe)
            throws MareException {

        UtilidadesLog.info("MONMantenimientoPremiacionBean.buscarCabeceraDetallePremElectivos(DTOCabeceraPremElegidos dtoe):Entrada");

        DTOSalida dtoSalida = this.cargarEleccionPremios(dtoe);
        dtoe.setRsDetallePremiosElectivos(dtoSalida.getResultado());
        UtilidadesLog.info("MONMantenimientoPremiacionBean.buscarCabeceraDetallePremElectivos(DTOCabeceraPremElegidos dtoe):Salida");

        return dtoe;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @version 1.00 24 jun 2005
     * @author Cristian Valenzuela
     */
    public void guardarPremiosElegidos(DTOCabeceraPremElegidos dtoe)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoPremiacionBean.guardarPremiosElegidos(DTOCabeceraPremElegidos dtoe):Entrada");

        try {
            (new DAOMantenimientoPremiacion()).salvarPremiosElegidos(dtoe);
        } catch (CreateException cEx) {
            UtilidadesLog.error("ERROR ", cEx);
            this.sessionContext.setRollbackOnly();

            String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError));
        }
        UtilidadesLog.info("MONMantenimientoPremiacionBean.guardarPremiosElegidos(DTOCabeceraPremElegidos dtoe):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 17 jun 2005
     * @author Cristian Valenzuela
     */
    public DTOSalida cargarEleccionPremios(DTOCabeceraPremElegidos dtoe)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoPremiacionBean.cargarEleccionPremios(DTOCabeceraPremElegidos dtoe):Entrada");

        DTOSalida dtoSalida = new DTOSalida();
        DAOMantenimientoPremiacion dao = new DAOMantenimientoPremiacion();
        ParametrosGeneralesPremiacionLocalHome pgplh;
        ParametrosGeneralesPremiacionLocal pgpl;
        BelcorpService bs = BelcorpService.getInstance();

        try {
            pgplh = this.getParametrosGeneralesPremiacionLocalHome();
            UtilidadesLog.debug("*** pgplh " + pgplh);
            pgpl = pgplh.findByUK(dtoe.getOidConcurso());
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if (pgpl != null) {
            DTOElegirPremiosRec dtoPremio = new DTOElegirPremiosRec();
            dtoPremio.setOidConcurso(dtoe.getOidConcurso());
            dtoPremio.setOidIdioma(dtoe.getOidIdioma());
            dtoPremio.setOidPais(dtoe.getOidPais());

            UtilidadesLog.debug("*** pgpl.getTipoPremiacion() " + pgpl.getTipoPremiacion());

            if (pgpl.getTipoPremiacion().longValue() == ConstantesINC.OID_TIPO_PREM_BOLSA.longValue()) {
                dtoSalida = dao.buscarNivelesPremiacion(dtoPremio);
            } else {
                dtoSalida = dao.cargarNivelesPremiacion(dtoe);
            }
        } else {
            LogAPP.error("INC-0020 No se ha encontrado el concurso");
        }
        UtilidadesLog.info("MONMantenimientoPremiacionBean.cargarEleccionPremios(DTOCabeceraPremElegidos dtoe):Salida");
        return dtoSalida;
    }
    
  /**
   * Sistema:     Belcorp
   * Modulo:      INC
   * Fecha:       23/12/2005
   * @version     1.0
   * @autor       Viviana Bongiovanni
   */
  
  public DTOSalida obtenerConcursos(DTODate dtoe) throws MareException {  
      UtilidadesLog.info("MONMantenimientoPremiacion.obtenerConcursos(DTOPaginado dtoe):Entrada");
      DAOMantenimientoPremiacion dao = new DAOMantenimientoPremiacion();
      RecordSet rs = dao.obtenerConcursos(dtoe);
      DTOSalida dtos = new DTOSalida();
      dtos.setResultado(rs);
      UtilidadesLog.info("MONMantenimientoPremiacion.obtenerConcursos(DTOPaginado dtoe):Salida");
      return dtos;
  }
  
  
   /**
   * Sistema:     Belcorp
   * Modulo:      INC
   * Fecha:       26/12/2005
   * @version     2.0
   * @autor       Viviana Bongiovanni
   * Modificado:  Cristian Valenzuela
   * Incidencia:  22634
   * Fecha:       21/2/2006
   */
  public DTOSalida obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe) 
      throws MareException {  
      UtilidadesLog.info("MONMantenimientoPremiacion.obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe):Entrada");              
      
      if(dtoe.getOidCliente()==null) {
        try {
          ClienteDatosBasicosLocalHome cdblh = this.getClienteDatosBasicosLocalHome();
          ClienteDatosBasicosLocal cdbl = cdblh.findByCodigoYPais(dtoe.getOidPais(), dtoe.getCodCliente());
          dtoe.setOidCliente(cdbl.getOid());
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                UtilidadesLog.error("ERROR ", nre);
                throw new MareException(null, null, 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + 
                ErroresDeNegocio.INC_0053));       
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

            }  
            
      }      
        
      DAOMantenimientoPremiacion dao = new DAOMantenimientoPremiacion();
      RecordSet rs = dao.obtenerClientesPorConcurso(dtoe);
      DTOSalida dtos = new DTOSalida();
      dtos.setResultado(rs);
      UtilidadesLog.info("MONMantenimientoPremiacion.obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe):Salida");
      return dtos;
  }


    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome(){
           return new ClienteDatosBasicosLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private ClienteRecomendanteLocalHome getClienteRecomendanteLocalHome() {
            return new ClienteRecomendanteLocalHome();
    }

    private ClienteRecomendadoLocalHome getClienteRecomendadoLocalHome() {
            return new ClienteRecomendadoLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }



}
