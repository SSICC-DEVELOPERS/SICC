package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.LogAPP;
import java.math.BigDecimal;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.inc.VersionesConcursoLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.ClienteGerenteLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocalHome;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.DescalificacionesLocalHome;
import es.indra.sicc.entidades.inc.ExigenciasCumplidasLocalHome;
import es.indra.sicc.entidades.inc.PremiosElegidosLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoMensajeLocalHome;
import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocalHome;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import java.util.Collection;
import java.util.Iterator;
import es.indra.sicc.entidades.inc.ClienteGerenteLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocal;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.DescalificacionesLocal;
import es.indra.sicc.entidades.inc.ExigenciasCumplidasLocal;
import es.indra.sicc.entidades.inc.PremiosElegidosLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoMensajeLocal;
import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.entidades.inc.VersionesConcursoLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocalHome;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONActivacionConcursosBean implements SessionBean 
{

  private SessionContext ctx;

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
    this.ctx = ctx;
  }

   /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 29/09/2008
     *     - El metodo pasa a ser privado
     *     - Se agregan trazas en el log de la aplicacion
     *     - Se setea oidPeriodo con periodo recibido al llamar a
     *       DAOActivacionCerradoConcursos.obtenerConcursosActivar
     * @author: ssantana, 24/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param MareDTO dtoe
     */
    private void activarConcursos(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursos" + 
                           "(MareDTO dtoe):Entrada");
        
        UtilidadesLog.debug("*** MareDTO: " + dtoe);
        
        DTOBuscarConcursos dtoBuscar = null;
        DTOVersion dtoVersion = null;
        DAOActivacionCerradoConcursos daoActivacion = new DAOActivacionCerradoConcursos();
        ArrayList arrayConcursosActivar = null;
        Long oidPais = null;
        Long oidMarca = null;
        Long oidCanal = null;
        Long oidPeriodo = null;
        String nombrePeriodo = null;
        RecordSet rResultado = null;
        MONPeriodos monPeriodos = null;
        SimpleDateFormat sdf = null;
        boolean invocadoDesdeCRA = false;
        
        String user = null;
        if (dtoe.containsKey("USER_PROPERTY")){
            user = (String)dtoe.getProperty("USER_PROPERTY");
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_PAIS)){
            oidPais = (Long) dtoe.getProperty(ConstantesCRA.DATO_PAIS);
        }

        if (dtoe.containsKey(ConstantesCRA.DATO_MARCA)){
            oidMarca = (Long) dtoe.getProperty(ConstantesCRA.DATO_MARCA);
        }

        if (dtoe.containsKey(ConstantesCRA.DATO_CANAL)){
            oidCanal = (Long) dtoe.getProperty(ConstantesCRA.DATO_CANAL);
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_PERIODO)) {
            oidPeriodo = (Long) dtoe.getProperty(ConstantesCRA.DATO_PERIODO);
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_MODULO)) {
            Long modulo = (Long) dtoe.getProperty(ConstantesCRA.DATO_MODULO);
            // Si (modulo == ConstantesSEG.MODULO_CRA)
            if (Long.parseLong(ConstantesSEG.MODULO_CRA) == modulo.longValue()) {
                invocadoDesdeCRA = true;
            }
        }
        
        try {
            monPeriodos = this.getMONPeriodosHome().create();
            DTOOID dtoOidPeri = new DTOOID();
            dtoOidPeri.setOid(oidPeriodo);
            DTOPeriodo dtoPeri = monPeriodos.obtenerPeriodo(dtoOidPeri);
            if (dtoPeri != null) {
                nombrePeriodo = dtoPeri.getNombre();
            } else {
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException("", UtilidadesError.armarCodigoError(error));
            }
        } catch (NamingException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        dtoBuscar = new DTOBuscarConcursos();
        dtoBuscar.setOidCanal(oidCanal);
        dtoBuscar.setOidMarca(oidMarca);
        dtoBuscar.setOidPais(oidPais);
        dtoBuscar.setIndActivo(Boolean.TRUE);
        dtoBuscar.setOidVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_NO_VIGENTE);
        dtoBuscar.setOidPeriodo(oidPeriodo);
        
        UtilidadesLog.debug("*** Llamando a obtenerConcursosActivar con: " + dtoBuscar);                   
        rResultado = daoActivacion.obtenerConcursosActivar(dtoBuscar);
        
        UtilidadesLog.debug("*** Llamando a obtenerArrayDTOVersion con: " + rResultado);                   
        arrayConcursosActivar = this.obtenerArrayDTOVersion(rResultado);
        
        int cantRegistros = arrayConcursosActivar.size();
        UtilidadesLog.debug("*** cantRegistros: " + cantRegistros);                   
        
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        for (int i=0; i<cantRegistros; i++) {
            dtoVersion = (DTOVersion) arrayConcursosActivar.get(i);

            if (! invocadoDesdeCRA) {
                LogAPP.info("Nombre del concurso: " + dtoVersion.getNumeroConcurso()
                    + " - " + sdf.format(new Date(System.currentTimeMillis()))
                    + " - " + nombrePeriodo);
                UtilidadesLog.debug("*** Llamando a activar con: " + dtoVersion);                   
            }

            this.activar(dtoVersion);

            if (! invocadoDesdeCRA) {
                LogAPP.info("Nombre del concurso: " + dtoVersion.getNumeroConcurso()
                    + " - " + sdf.format(new Date(System.currentTimeMillis()))
                    + " - " + nombrePeriodo);
            }
        }
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        daoActivacion.guardarHistoricoActivacionCerrado("A", oidPeriodo, user, rResultado);       
        
        //jrivas 06/02/2007 Luego de Activar los concursos se limpia la Factoria
        //para que se cargue la primera vez que se necesite.
        FactoriaConcurso.refrescarConcursos();
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        daoActivacion.actualizarUltimaActualizacionConcurso();    
        
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursos" + 
                           "(MareDTO dtoe):Salida");
    }
    
    public void lanzarActivacionConcursosBatch(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.lanzarActivacionConcursosBatch(MareDTO dtoe): Entrada");
        
        MareBusinessID id = new MareBusinessID("INCActivarConcursosBatch");
        DTOBatch dtoB = new DTOBatch(new String("Activacion de concursos"), id, dtoe, ctx.getCallerPrincipal().getName());
        
        try {
            BatchUtil.executeMLN(dtoB, "INCPROCESOSBATCH");
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONActivacionConcursosBean.lanzarActivacionConcursosBatch(MareDTO dtoe): Salida");
    }
    
    public void activarConcursosQuartz(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursosQuartz(MareDTO dtoe): Entrada");
        this.activarConcursos(dtoe);
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursosQuartz(MareDTO dtoe): Salida");
    }

    public DTOSalidaBatch activarConcursosBatch(DTOBatch dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursosBatch(DTOBatch dtoe): Entrada");
        MareDTO mareDTO = (MareDTO)dtoe.getDTOOnline();
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        mareDTO.setProperty("USER_PROPERTY", dtoe.getUser());;
        
        UtilidadesLog.debug("mareDTO: " + mareDTO);
        this.activarConcursos(mareDTO);
        UtilidadesLog.info("MONActivacionConcursosBean.activarConcursosBatch(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0, "Activar concursos finalizado");
    }


    /**
     * @author: ssantana, 24/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOVersion dtoe 
     */
    private void activar(DTOVersion dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.activar" + 
                           "(DTOVersion dtoe):Entrada");
        try {
            VersionesConcursoLocal versionesConcursoL = null;
            VersionesConcursoLocal versiConcuOrigenL = null;
            VersionesConcursoLocalHome versionesConcursoLH = this.getVersionesConcursoLocalHome();
            ConcursoParametrosGeneralesLocal concuParamGralL = null;
            ConcursoParametrosGeneralesLocalHome concuParamGralLH = this.getConcursoParametrosGeneralesLocalHome();
        
            UtilidadesLog.debug("*** Llamando a findByConcurso con:" + dtoe.getOidConcurso());    
            Collection col = versionesConcursoLH.findByConcurso(dtoe.getOidConcurso());
            Iterator it = col.iterator();
            Long oidEstado = null;
            Long oidConcursoOrigen = null;
            
            while (it.hasNext()) {
                versionesConcursoL = (VersionesConcursoLocal) it.next();
                versionesConcursoL.setVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_VIGENTE);
                oidEstado = versionesConcursoL.getEstadoConcurso();
                /** Si es Aprobado, se cierra el Concurso Origen */
                
                UtilidadesLog.debug("*** oidEstado " + oidEstado);    
                if (oidEstado.equals(ConstantesINC.OID_ESTADO_APROBADO)) {
                   oidConcursoOrigen = versionesConcursoL.getConcursoOrigen();                   
                   UtilidadesLog.debug("*** Llamando a  findByConcurso con:" + oidConcursoOrigen);    
                   Collection colVersionOrigen = versionesConcursoLH.findByConcurso(oidConcursoOrigen);
                   Iterator itVersionOrigen = colVersionOrigen.iterator();
                   
                   while (itVersionOrigen.hasNext()) {
                       versiConcuOrigenL = (VersionesConcursoLocal) itVersionOrigen.next();
                       versiConcuOrigenL.setVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_CERRADO_VERSIO);
                       versionesConcursoLH.merge(versiConcuOrigenL);
                   }
                   
                   /** Pongo inactivo el Concurso Origen */
                   concuParamGralL = concuParamGralLH.findByPrimaryKey(oidConcursoOrigen);
                   concuParamGralL.setActivo(Boolean.FALSE); 
                   concuParamGralLH.merge(concuParamGralL);
                   
                   UtilidadesLog.debug("*** Llamando a actualizarEntidades con: " + dtoe);    
                   this.actualizarEntidades(dtoe);
                }
                
                versionesConcursoLH.merge(versionesConcursoL);
            }
        }
        catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONActivacionConcursosBean.activar" + 
                           "(DTOVersion dtoe):Salida");
    }
    
    /**
     * @author: ssantana, 24/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOVersion dtoe
     */
        private void actualizarEntidades(DTOVersion dtoe) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.actualizarEntidades" + 
                           "(DTOVersion dtoe):Entrada");
                           
        try {
            Long oidConcursoOrigen = dtoe.getOidConcursoOrigen();
            Long oidConcurso = dtoe.getOidConcurso();
            
            UtilidadesLog.debug("*** oidConcursoOrigen:" + oidConcursoOrigen);
            UtilidadesLog.debug("*** oidConcurso:" + oidConcurso);
            
            Collection col = null;
            Iterator it = null;
            
            //Obtencion de interfaces
            
            CandidataGanadoraLocal candidataL = null;
            CandidataGanadoraLocalHome candidataLH = 
            this.getCandidataGanadoraLocalHome();
    
            ClienteGerenteLocal clienteGerenteL = null;
            ClienteGerenteLocalHome clienteGerenteLH = 
            this.getClienteGerenteLocalHome();

            ClienteRecomendanteLocal clienteRecomendanteL = null;
            ClienteRecomendanteLocalHome clienteRecomendanteLH = 
            this.getClienteRecomendanteLocalHome();
    
            PedidosConcursoRecomendadaLocal pedidosConcursoL = null;
            PedidosConcursoRecomendadaLocalHome pedidosConcursoLH = 
            this.getPedidosConcursoRecomendadaLocalHome();
    
            ClienteRecomendanteMultinivelLocal clienteRecomendanteMNvlL = null;
            ClienteRecomendanteMultinivelLocalHome clienteRecomendanteMNvlLH = 
            this.getClienteRecomendanteMultinivelLocalHome();

            CuentaCorrientePuntosLocal cuentaCorrienteL = null;
            CuentaCorrientePuntosLocalHome cuentaCorrienteLH = 
            this.getCuentaCorrientePuntosLocalHome();

            DescalificacionesLocal descalificacionL = null;
            DescalificacionesLocalHome descalificacionLH = 
            this.getDescalificacionesLocalHome();    
    
            ExigenciasCumplidasLocal exigenciasCumplidasL = null;
            ExigenciasCumplidasLocalHome exigenciasCumplidasLH = 
            this.getExigenciasCumplidasLocalHome();
            
            PremiosElegidosLocal premiosElegidosL = null;
            PremiosElegidosLocalHome premiosElegidosLH = 
            this.getPremiosElegidosLocalHome();
    
            SolicitudConcursoPuntajeLocal solicitudConcursoPL = null;
            SolicitudConcursoPuntajeLocalHome solicitudConcursoPLH = 
            this.getSolicitudConcursoPuntajeLocalHome();
            
            SolicitudConcursoRecomendadasLocal solicitudConcursoRecomL = null;
            SolicitudConcursoRecomendadasLocalHome solicitudConcursoRecomLH = 
            this.getSolicitudConcursoRecomendadasLocalHome();
    
            SolicitudConcursoMensajeLocal solicitudConcursoMensajeL = null;
            SolicitudConcursoMensajeLocalHome solicitudConcursoMensajeLH = 
            this.getSolicitudConcursoMensajeLocalHome() ;

            PuntajeProductosExigidosLocal puntajeProductosExigL = null;
            PuntajeProductosExigidosLocalHome puntajeProductosExigLH = 
            this.getPuntajeProductosExigidosLocalHome();           

            //actualizacion de entidades                                                    
            UtilidadesLog.debug("* Candidata *");
            col = candidataLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                candidataL = (CandidataGanadoraLocal) it.next();
                UtilidadesLog.debug("* Actualizo Candidata *");
                candidataL.setConcurso(oidConcurso);
                candidataLH.merge(candidataL);
            }
            
            UtilidadesLog.debug("* ClientesGerente *");
            col = clienteGerenteLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator(); 
            while (it.hasNext()) {
                clienteGerenteL = (ClienteGerenteLocal) it.next();
                UtilidadesLog.debug("* Actualizo ClientesGerente *");
                clienteGerenteL.setConcurso(oidConcurso);
                clienteGerenteLH.merge(clienteGerenteL);
            }
            
            UtilidadesLog.debug("* ClienteRecomendante *");
            col = clienteRecomendanteLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                clienteRecomendanteL = (ClienteRecomendanteLocal) it.next();
                UtilidadesLog.debug("* Actualizo ClienteRecomendante *");
                clienteRecomendanteL.setConcurso(oidConcurso);
                clienteRecomendanteLH.merge(clienteRecomendanteL);
            }
            
            UtilidadesLog.debug("* PedidosConcursoRecomendada *");
            col = pedidosConcursoLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                pedidosConcursoL = (PedidosConcursoRecomendadaLocal) it.next();
                UtilidadesLog.debug("* Actualizo PedidosConcursoRecomendada *");
                pedidosConcursoL.setConcurso(oidConcurso);
                pedidosConcursoLH.merge(pedidosConcursoL);
            }
            
            UtilidadesLog.debug("* ClienteRecomendanteMultinivel *");
            col = clienteRecomendanteMNvlLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                clienteRecomendanteMNvlL = (ClienteRecomendanteMultinivelLocal) it.next();
                UtilidadesLog.debug("* Actualizo ClienteRecomendanteMultinivel *");
                clienteRecomendanteMNvlL.setConcurso(oidConcurso);
                clienteRecomendanteMNvlLH.merge(clienteRecomendanteMNvlL);
            }
            
            UtilidadesLog.debug("* CuentaCorrientePuntos *");
            col = cuentaCorrienteLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                cuentaCorrienteL = (CuentaCorrientePuntosLocal) it.next();
                UtilidadesLog.debug("* Actualizo CuentaCorrientePuntos *");
                cuentaCorrienteL.setConcurso(oidConcurso);
                cuentaCorrienteLH.merge(cuentaCorrienteL);
            }
            
            UtilidadesLog.debug("* Descalificaciones *");
            col = descalificacionLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                descalificacionL = (DescalificacionesLocal) it.next();
                descalificacionL.setConcurso(oidConcurso);
                descalificacionLH.merge(descalificacionL);
            }
            
            UtilidadesLog.debug("* ExigenciasCumplidas *");
            col = exigenciasCumplidasLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                exigenciasCumplidasL = (ExigenciasCumplidasLocal) it.next();
                UtilidadesLog.debug("* Actualizo ExigenciasCumplidas *");
                exigenciasCumplidasL.setConcurso(oidConcurso);
                exigenciasCumplidasLH.merge(exigenciasCumplidasL);
            }
            
            UtilidadesLog.debug("* PremiosElegidos *");
            col = premiosElegidosLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                premiosElegidosL = (PremiosElegidosLocal) it.next();
                UtilidadesLog.debug("* Actualizo PremiosElegidos *");
                premiosElegidosL.setConcurso(oidConcurso);
                premiosElegidosLH.merge(premiosElegidosL);
            }
            
            UtilidadesLog.debug("* SolicitudConcursoPuntaje *");
            col = solicitudConcursoPLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                solicitudConcursoPL = (SolicitudConcursoPuntajeLocal) it.next();
                UtilidadesLog.debug("* Actualizo SolicitudConcursoPuntaje *");
                solicitudConcursoPL.setConcurso(oidConcurso);
                solicitudConcursoPLH.merge(solicitudConcursoPL);
            }
            
            UtilidadesLog.debug("* SolicitudConcursoRecomendadasLocal *");
            col = solicitudConcursoRecomLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                solicitudConcursoRecomL = (SolicitudConcursoRecomendadasLocal) it.next();
                UtilidadesLog.debug("* Actualizo SolicitudConcursoRecomendadasLocal *");
                solicitudConcursoRecomL.setConcurso(oidConcurso);
                solicitudConcursoRecomLH.merge(solicitudConcursoRecomL);
            }
            
            UtilidadesLog.debug("* SolicitudConcursoMensajeLocal *");
            col = solicitudConcursoMensajeLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                solicitudConcursoMensajeL = (SolicitudConcursoMensajeLocal) it.next();
                UtilidadesLog.debug("* Actualizo SolicitudConcursoMensajeLocal *");
                solicitudConcursoMensajeL.setConcurso(oidConcurso);                                                        
                solicitudConcursoMensajeLH.merge(solicitudConcursoMensajeL);
            }
            
            UtilidadesLog.debug("* PuntajeProductosExigidosLocal *");
            col = puntajeProductosExigLH.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                puntajeProductosExigL = (PuntajeProductosExigidosLocal) it.next();
                UtilidadesLog.debug("* Actualizo PuntajeProductosExigidosLocal *");
                puntajeProductosExigL.setConcurso(oidConcurso);
                puntajeProductosExigLH.merge(puntajeProductosExigL);
            }
            
            UtilidadesLog.debug("* SolicictudCabecera *");
            StringBuffer sqlQuery = new StringBuffer("");
            sqlQuery.append(" UPDATE ped_solic_cabec "); 
            sqlQuery.append(" SET ped_solic_cabec.copa_oid_para_gene = " + oidConcurso );
            sqlQuery.append(" WHERE ped_solic_cabec.copa_oid_para_gene = " + oidConcursoOrigen );
            
            BelcorpService bs = BelcorpService.getInstance();
            UtilidadesLog.debug("* Actualizo SolicictudCabecera *");
            bs.dbService.executeUpdate(sqlQuery.toString());
            
            //Agregado por cvalenzu - BELC300024450            
            //22/11/2006
            //Comentario: Se agrega la actualizacion de otras tablas
            //para que ciertos registros queden apuntando al concurso correcto
            
            DAOActivacionCerradoConcursos dao = new DAOActivacionCerradoConcursos();
            
            //1)- Calculo Productos Exigidos
            UtilidadesLog.debug("* Calculo Productos Exigidos *");
            
            RecordSet rs;        
            String codigoError;
            StringBuffer query = new StringBuffer();
            
            query.append(" SELECT IPE.OID_PROD_EXIG AS OIDNUEVO,  ");
            query.append(" IPE.PRE2_OID_PROD_EXIG AS OIDANTERIOR ");
            query.append(" FROM INC_CALCU_PRODU_EXIGI ICPE,  ");
            query.append(" INC_PRODU_EXIGI IPE, ");
            query.append(" INC_PRODU IP ");
            query.append(" WHERE IP.COPA_OID_PARA_GRAL = " + oidConcursoOrigen);
            query.append(" AND IP.OID_PROD = IPE.PRDU_OID_PROD ");
            query.append(" AND IPE.OID_PROD_EXIG = ICPE.PRE2_OID_PROD_EXIG ");            

            try {
                bs = BelcorpService.getInstance();
                rs = bs.dbService.executeStaticQuery(query.toString());            
            }
            catch (MareMiiServiceNotFoundException e) {
              codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
              UtilidadesLog.error("ERROR ", e); 
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
            catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } 

            if ((rs != null) && !rs.esVacio()) {            
              int cant = rs.getRowCount();                
              for(int i=0; i<cant; i++) {  
                BigDecimal oidProdExigAnt = (BigDecimal) rs.getValueAt(i, "OIDANTERIOR");
                BigDecimal oidProdExigNue = (BigDecimal) rs.getValueAt(i, "OIDNUEVO");
                
                UtilidadesLog.debug("* oidProdExigAnt " + oidProdExigAnt);
                UtilidadesLog.debug("* oidProdExigNue " + oidProdExigNue);
                        
                if(oidProdExigAnt!=null) {
                  UtilidadesLog.debug("* Actualizo Calculo Productos Exigidos *");
                  dao.actualizarEntidad("INC_CALCU_PRODU_EXIGI", "PRE2_OID_PROD_EXIG",
                  new Long(oidProdExigAnt.longValue()),new Long(oidProdExigNue.longValue()));
                }
              }                                                     
            }         
            
            //2)- Ganadoras y 3)- Cliente Recomendado
            
            // gPineda - 22/11/2006            
            ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = 
            this.getParametrosGeneralesPremiacionLocalHome();
            
            ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionAnterior = 
            parametrosGeneralesPremiacionLH.findByUK( dtoe.getOidConcursoOrigen() );
            
            ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionNueva = 
            parametrosGeneralesPremiacionLH.findByUK( dtoe.getOidConcurso() );
            
            ParametrosNivelPremiacionLocalHome parametrosNivelPremiacionLH = this.getParametrosNivelPremiacionLocalHome();
            
            ParametrosNivelPremiacionLocal parametrosNivelPremiacionAnterior = null;
            ParametrosNivelPremiacionLocal parametrosNivelPremiacionNuevo = null;
            
            col = parametrosNivelPremiacionLH.findByParametroGeneralPremiacion(parametrosGeneralesPremiacionAnterior.getOid());
            it = col.iterator();
            while (it.hasNext()) {
              parametrosNivelPremiacionAnterior = (ParametrosNivelPremiacionLocal)it.next();
              
              parametrosNivelPremiacionNuevo = 
              parametrosNivelPremiacionLH.findByUK( parametrosNivelPremiacionAnterior.getNumeroNivel(),
                                                          parametrosGeneralesPremiacionNueva.getOid() );
              
              UtilidadesLog.debug("* Ganadoras *");              
              dao.actualizarEntidad("INC_GANAD", "PANP_OID_PARA_NIVE_PREM",
                                            parametrosNivelPremiacionAnterior.getOid(),parametrosNivelPremiacionNuevo.getOid());
              
              UtilidadesLog.debug("* Cliente Recomendado *");              
              dao.actualizarEntidad("INC_CLIEN_RECDO", "PANP_OID_PARA_NIVE_PREM",
                                            parametrosNivelPremiacionAnterior.getOid(),parametrosNivelPremiacionNuevo.getOid());              
            }        
            
            //4)- Resultado Venta Proyectada Zona
            MetasVentaProyectadaZonaLocal mvpzlAnterior = null;
            MetasVentaProyectadaZonaLocal mvpzlNuevo = null;
            
            MetasVentaProyectadaZonaLocalHome mvpzlh = this.getMetasVentaProyectadaZonaLocalHome();
            col = mvpzlh.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                mvpzlAnterior = (MetasVentaProyectadaZonaLocal)it.next();
                
                mvpzlNuevo = mvpzlh.findByUk(mvpzlAnterior.getPeriodoCalculado(),
                                            mvpzlAnterior.getCliente(), mvpzlAnterior.getConcurso(),
                                            mvpzlAnterior.getZona());                
                
                UtilidadesLog.debug("* Resultado Venta Proyectada Zona *");     
                dao.actualizarEntidad("INC_RESUL_VENTA_PROYE_ZONA", "MVPZ_OID_META_VENT_PROY_ZONA",
                                                mvpzlAnterior.getOid(), mvpzlNuevo.getOid());                    
            }
            
            //5)- Resultado Venta Proyectada Region
            MetasVentaProyectadaRegionLocal mvprlAnterior = null;
            MetasVentaProyectadaRegionLocal mvprlNuevo = null;
            
            MetasVentaProyectadaRegionLocalHome mvprlh = this.getMetasVentaProyectadaRegionLocalHome();
            col = mvprlh.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                mvprlAnterior = (MetasVentaProyectadaRegionLocal)it.next();
                
                mvprlNuevo = mvprlh.findByUk(mvprlAnterior.getPeriodoCalculado(),
                                            mvprlAnterior.getCliente(), mvprlAnterior.getConcurso(),
                                            mvprlAnterior.getRegion());
                
                UtilidadesLog.debug("* Resultado Venta Proyectada Region *");     
                dao.actualizarEntidad("INC_RESUL_VENTA_PROYE_REGION", "MVPR_OID_META_VENT_PROY_REGI",
                                            mvprlAnterior.getOid(), mvprlNuevo.getOid()); 
            }            
            
            //6)- Resultado Venta Proyectada Subgerencia
            MetasVentaProyectadaSubgerenciaVentaLocal mvpsvlAnterior = null;
            MetasVentaProyectadaSubgerenciaVentaLocal mvpsvlNuevo = null;
            
            MetasVentaProyectadaSubgerenciaVentaLocalHome mvpsvl = this.getMetasVentaProyectadaSubgerenciaVentaLocalHome();    
            col = mvpsvl.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                mvpsvlAnterior = (MetasVentaProyectadaSubgerenciaVentaLocal)it.next();
                
                mvpsvlNuevo = mvpsvl.findByUk(mvpsvlAnterior.getPeriodoCalculado(),
                                            mvpsvlAnterior.getCliente(), mvpsvlAnterior.getConcurso(),
                                            mvpsvlAnterior.getSubgerencia());
                
                UtilidadesLog.debug("* Resultado Venta Proyectada Subgerencia *");     
                dao.actualizarEntidad("INC_RESUL_VENTA_PROYE_SUBGE", "MVPS_OID_META_VENT_PROY_SUBG",
                                                mvpsvlAnterior.getOid(), mvpsvlNuevo.getOid());             
            }      
            
            //7)- Cliente gerente recomendado                  
            ClienteGerenteLocal cglAnterior = null;
            ClienteGerenteLocal cglNuevo = null;
            
            ClienteGerenteLocalHome cglh = this.getClienteGerenteLocalHome();
            col = cglh.findByConcurso(oidConcursoOrigen);
            it = col.iterator();
            while (it.hasNext()) {
                cglAnterior = (ClienteGerenteLocal)it.next();
                
                cglNuevo = cglh.findByGerenteConcurso(cglAnterior.getGerente(), cglAnterior.getConcurso());
                
                UtilidadesLog.debug("* Cliente gerente recomendado *");     
                dao.actualizarEntidad("INC_CLIEN_GEREN_RECOM", "CLGE_OID_CLIE_GERE", cglAnterior.getOid(), cglNuevo.getOid());              
            }       
            
            //FIN - Agregado por cvalenzu - BELC300024450
            
            UtilidadesLog.info("MONActivacionConcursosBean.actualizarEntidades" + 
            "(DTOVersion dtoe):Salida");            
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }
    }
    
    
    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 22/09/2008 - Se setea num de concurso a cada DTOVersion
     * 
     * @author: ssantana, 24/05/2006
     * @throws java.lang.Exception
     * @return ArrayList
     * @param RecordSet r
     */
    private ArrayList obtenerArrayDTOVersion(RecordSet r) throws MareException {
        UtilidadesLog.info("MONActivacionConcursosBean.obtenerArrayDTOVersion" + 
                           "(RecordSet r):Entrada");
                           
        ArrayList aList = new ArrayList();
        DTOVersion dtoVersionConcursoActivar = null;
        int cantRegistros = r.getRowCount();
        
        for (int i=0; i<cantRegistros; i++) {
            dtoVersionConcursoActivar = new DTOVersion();
            Long oidConcurso = null;
            Long oidConcursoOrigen = null;
            Long oidEstado = null;
            String numeroConcurso = null;
            
            oidConcurso = (Long) this.retornaValor(r.getValueAt(i,0), "L");
            oidEstado = (Long) this.retornaValor(r.getValueAt(i,1), "L");
            oidConcursoOrigen = (Long) this.retornaValor(r.getValueAt(i,2), "L");
            numeroConcurso = (String) r.getValueAt(i, "NUMEROCONCURSO");
            
            dtoVersionConcursoActivar.setOidConcurso(oidConcurso);
            dtoVersionConcursoActivar.setOidConcursoOrigen(oidConcursoOrigen);
            dtoVersionConcursoActivar.setOidEstado(oidEstado);
            dtoVersionConcursoActivar.setNumeroConcurso(numeroConcurso);
            
            aList.add(dtoVersionConcursoActivar);
        }

        UtilidadesLog.info("MONActivacionConcursosBean.obtenerArrayDTOVersion" + 
                           "(RecordSet r):Salida");
        return aList;
    }
    
    /**
     * @author: ssantana, 24/05/2006
     * @return Object
     * @param String tipoDato
     * @param Object o
     */
    private Object retornaValor(Object o, String tipoDato) {
        Object oRetorno = null;
        if (o != null) {
            if (tipoDato.equals("I") ) {
                oRetorno = Integer.valueOf(o.toString());
            }
            
            if (tipoDato.equals("L") ) {
                oRetorno = Long.valueOf(o.toString());
            }
       }
       return oRetorno;
    }


    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    private VersionesConcursoLocalHome getVersionesConcursoLocalHome() {
            return new VersionesConcursoLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    private ClienteGerenteLocalHome getClienteGerenteLocalHome() {
            return new ClienteGerenteLocalHome();
    }

    private ClienteRecomendanteLocalHome getClienteRecomendanteLocalHome() {
            return new ClienteRecomendanteLocalHome();
    }

    private PedidosConcursoRecomendadaLocalHome getPedidosConcursoRecomendadaLocalHome() {
            return new PedidosConcursoRecomendadaLocalHome();
    }

    private ClienteRecomendanteMultinivelLocalHome getClienteRecomendanteMultinivelLocalHome() {
            return new ClienteRecomendanteMultinivelLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    private DescalificacionesLocalHome getDescalificacionesLocalHome() {
            return new DescalificacionesLocalHome();
    }

    private ExigenciasCumplidasLocalHome getExigenciasCumplidasLocalHome() {
            return new ExigenciasCumplidasLocalHome();
    }

    private PremiosElegidosLocalHome getPremiosElegidosLocalHome() {
            return new PremiosElegidosLocalHome();
    }

    private SolicitudConcursoPuntajeLocalHome getSolicitudConcursoPuntajeLocalHome() {
            return new SolicitudConcursoPuntajeLocalHome();
    }

    private SolicitudConcursoRecomendadasLocalHome getSolicitudConcursoRecomendadasLocalHome() {
            return new SolicitudConcursoRecomendadasLocalHome();
    }

    private SolicitudConcursoMensajeLocalHome getSolicitudConcursoMensajeLocalHome() {
            return new SolicitudConcursoMensajeLocalHome();
    }

    private PuntajeProductosExigidosLocalHome getPuntajeProductosExigidosLocalHome() {
            return new PuntajeProductosExigidosLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private ParametrosNivelPremiacionLocalHome getParametrosNivelPremiacionLocalHome() {
            return new ParametrosNivelPremiacionLocalHome();
    }

    private MetasVentaProyectadaZonaLocalHome getMetasVentaProyectadaZonaLocalHome() {
            return new MetasVentaProyectadaZonaLocalHome();
    }

    private MetasVentaProyectadaRegionLocalHome getMetasVentaProyectadaRegionLocalHome() {
            return new MetasVentaProyectadaRegionLocalHome();
    }

    private MetasVentaProyectadaSubgerenciaVentaLocalHome getMetasVentaProyectadaSubgerenciaVentaLocalHome() {
            return new MetasVentaProyectadaSubgerenciaVentaLocalHome();
    }


}