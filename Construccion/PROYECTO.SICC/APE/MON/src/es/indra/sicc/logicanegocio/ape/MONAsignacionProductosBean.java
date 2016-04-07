/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import es.indra.sicc.dtos.ape.DTOCalcularHit;
//import es.indra.sicc.dtos.ape.DTOConsultaOrdenada;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto;
import es.indra.sicc.dtos.ape.DTOValidacionProductoAnaquel;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocal;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocalHome;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelDetalleLocal;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelDetalleLocalHome;
import es.indra.sicc.entidades.ape.EstimadosProductoLocal;
import es.indra.sicc.entidades.ape.EstimadosProductoLocalHome;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionDetalleLocal;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionDetalleLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelDetalle;
import es.indra.sicc.dtos.ape.DTODesasignarProductosAnaqueles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONAsignacionProductosBean implements SessionBean {
    private SessionContext ctx;    
    
    public void ejbCreate(){}
    public void ejbActivate(){}
    public void ejbPassivate(){}
    public void ejbRemove(){}

    public void setSessionContext(SessionContext ctx) {
           this.ctx = ctx;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * @author gpons
     * @since 09-01-2007
     */
    public DTOSalida obtenerProcedencia (DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.debug("MONAsignacionProductosBean.obtenerProcedencia(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOAsignacionProductos().obtenerProcedencia(dtoe);
        UtilidadesLog.debug("MONAsignacionProductosBean.obtenerProcedencia(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoMantenerEstimadosProducto
     * @author gpons
     * @since 09-01-2007
     */
    public DTOSalida consultarEstimadosProducto (DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto) throws MareException {
        UtilidadesLog.debug("MONAsignacionProductosBean.consultarEstimadosProducto(DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto): Entrada");
        DTOSalida dtoSalida = new DAOAsignacionProductos().consultarEstimadosProducto(dtoMantenerEstimadosProducto);
        UtilidadesLog.debug("MONAsignacionProductosBean.consultarEstimadosProducto(DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto): Salida");
        return dtoSalida;
    }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @author gpons
     * @since 09-01-2007
     */
    public void eliminarEstimadosProducto (DTOOIDs dtoe) throws MareException {
        UtilidadesLog.debug("MONAsignacionProductosBean.eliminarEstimadosProducto(DTOOIDs dtoe): Entrada");
        try {
            new DAOAsignacionProductos().eliminarEstimadosProducto(dtoe);
        } catch (MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        UtilidadesLog.debug("MONAsignacionProductosBean.eliminarEstimadosProducto(DTOOIDs dtoe): Salida");
    }    
    
   /**
     * CHANGELOG
     * ---------
     * 
     * dmorello, 27/05/2008 - Incidencia 20080502: Se considera como indicador
     *                        DENTRO de pedido = "C", y fuera de pedido "F" o "B"
     * sbuchelli, 22/02/2010 - RI SICC 20091694  Se considera indicador dentro fuera de caja null ingresarlo por la linea PTL
     * @throws es.indra.mare.common.exception.MareException
     * @author gpons
     * @since 09-01-2007
     */
    public void guardarEstimadosProducto (DTOMantenerEstimadosProducto dtoE) throws MareException {
        UtilidadesLog.debug("MONAsignacionProductosBean.guardarEstimadosProducto(DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto): Entrada");
        UtilidadesLog.debug("DTOMantenerEstimadosProducto: " + dtoE);

        //MaestroProductosLocalHome productoHome = this.getMaestroProductosLocalHome();
        /* BELC400000516 - dmorello, 25/06/2007
         * Se reemplaza entity MaestroProductos por consulta JDBC */
        //MaestroProductosLocal productoLocal = null;
   
        //try {
        //    productoLocal = productoHome.findByUK(dtoE.getOidPais(),dtoE.getCodigoProducto());
        //}
        //catch (FinderException fe) {
          
        //        MareException me = new MareException(null, null, 
        //        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE +
        //        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.CODIGO_SAP_INEXISTENTE));

        //        UtilidadesLog.error("FinderException: " + UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE +
        //                            es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.CODIGO_SAP_INEXISTENTE) + fe.getMessage());
        //        UtilidadesLog.error(fe);
   
        //        throw me;
        //}
        RecordSet rsProducto = new DAOAsignacionProductos().buscarProducto(
                                    dtoE.getOidPais(), dtoE.getCodigoProducto());
        RecordSet rsLineaAFP = new DAOAsignacionProductos().lineaAFP(dtoE);                            
        if (rsProducto == null || rsProducto.esVacio()) {
            ctx.setRollbackOnly();                
            throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
            ErroresDeNegocio.APE_0040));
        }
            
        //Setea oidProducto con el producto encontrado en MAE_PRODU
        //dtoE.setOidProducto(productoLocal.getOid());
        dtoE.setOidProducto(new Long(((BigDecimal)rsProducto.getValueAt(0,"OID_PROD")).longValue()));
        
        /*
         * BELC400000345 - dmorello, 24/04/2007
         * Obtengo el indicador fuera de pedido a partir del indicador
         * dentro de caja o bolsa del producto, y lo asigno al dtoE
         */
        /* BELC400000516 - dmorello, 25/06/2007 */
        
        // vbongiov -- Cambio 20090839 -- 17/11/2009
        // Los valores admitidos eran: B (bolsa), F (fuera de caja o bolsa), C (caja), null (fuera).
        
       String indCajaBolsa = (String)rsProducto.getValueAt(0,"COD_IND_DENT_CAJA");
       int liniaAFP = ((BigDecimal)rsLineaAFP.getValueAt(0,"NUM_LINE_AFP")).intValue();
                
       UtilidadesLog.debug("linea: " + liniaAFP + " indCajaBolsa: " + indCajaBolsa );
        
       if(!((liniaAFP == 1 && (ConstantesMAE.BOLSA.equals(indCajaBolsa) || ConstantesAPE.FUERA.equals(indCajaBolsa))) ||
            (liniaAFP == 0 && (indCajaBolsa == null || ConstantesMAE.CAJA.equals(indCajaBolsa))))){      
       
           ctx.setRollbackOnly();                
           throw new MareException(null, null, 
           UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
           ErroresDeNegocio.APE_0940));   
       }
       
       if (ConstantesMAE.CAJA.equals(indCajaBolsa) || indCajaBolsa == null ) {
            dtoE.setFueraPedido(Boolean.FALSE);
        //} else if (productoLocal.getIndCajaBolsa() == null) {
        /* dmorello, 28/06/2007
         * Para indicar el valor "fuera de pedido" ("F") no se utiliza una constante,
         * ya que en V3 (donde correspondía agregarla) no se agregó, para no tener que
         * modificar lo desplegado en el entorno Productivo.
         */
       } else {
        /* Fin BELC400000516 - dmorello, 25/06/2007 */
            /*
             * NOTA dmorello, 24/04/2007:
             * Según DT, debería compararse el indCajaBolsa con una constante
             * aun no incorporada a MAE que indica "fuera de caja", lo cual
             * equivale a "fuera de pedido". Se esperará a que se cree
             * esta constante antes de colocarla en este IF.
             */
            dtoE.setFueraPedido(Boolean.TRUE);
        }
        /* Fin BELC400000345 dmorello 24/04/2007 */
        
          
        EstimadosProductoLocalHome estimadosProductoLocalHome = new EstimadosProductoLocalHome();
        EstimadosProductoLocal estimadosProductoLocal = null; 
            
        if (dtoE.getOidEstimado()!= null) {
            UtilidadesLog.debug("*** Modificacion");
            try {                  
                estimadosProductoLocal  = estimadosProductoLocalHome.findByPrimaryKey(dtoE.getOidEstimado());
            } catch (NoResultException e) { 
                ctx.setRollbackOnly();
                UtilidadesLog.error("NoResultException: findByPrimaryKey(dtoE.getOidEstimado()");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) { 
                ctx.setRollbackOnly();
                UtilidadesLog.error("PersistenceException: findByPrimaryKey(dtoE.getOidEstimado()");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            estimadosProductoLocal.setNumUnidEsti(dtoE.getUnidadesEstimadas());
            estimadosProductoLocal.setIndFuerPedi(dtoE.getFueraPedido());
            estimadosProductoLocal.setOidProc(dtoE.getOidProcedencia());
            estimadosProductoLocal.setOidLineArma(dtoE.getOidLineaArmado());
            estimadosProductoLocal.setOidPeri(dtoE.getOidPeriodo());
            estimadosProductoLocal.setOidProd(dtoE.getOidProducto());
            
            try {
                estimadosProductoLocalHome.merge(estimadosProductoLocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("PersistenceException: merge", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("*** Modificacion OK");                                                            
        }
        else {
             UtilidadesLog.debug("*** Insercion");
             try {                  
                    estimadosProductoLocal = estimadosProductoLocalHome.findByUK(dtoE.getOidLineaArmado(),
                                                                                 dtoE.getOidPeriodo(), 
                                                                                 dtoE.getOidProcedencia(),
                                                                                 dtoE.getOidProducto(),
                                                                                 dtoE.getFueraPedido());
             }
             catch (NoResultException e) {
                UtilidadesLog.debug("NoResultException: Producto se va a insertar", e);
             }
             catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("PersistenceException: findByUK", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }

             if (estimadosProductoLocal != null){
                //FindByUK OK: Estimado Producto ya existe
                MareException me = new MareException(null, null, 
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE + 
                        es.indra.sicc.logicanegocio.ape.ErroresDeNegocio.APE_0023));
                throw me;
             }
             try {
               UtilidadesLog.debug("*** DTO create: " + dtoE);                                                            
               estimadosProductoLocal = estimadosProductoLocalHome.create(dtoE.getUnidadesEstimadas(),
                                                                          dtoE.getFueraPedido(),
                                                                          dtoE.getOidProcedencia(),
                                                                          dtoE.getOidLineaArmado(),
                                                                          dtoE.getOidPeriodo(),
                                                                          dtoE.getOidProducto());
               UtilidadesLog.debug("***Insercion OK");                                                            
             }
             catch (PersistenceException e){
                    //PersistenceException: Estimado Producto ya existe
                    UtilidadesLog.error("ERROR: CreateException", e);
                    ctx.setRollbackOnly();                
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
                    ErroresDeNegocio.APE_0023));
            }              
        }
      UtilidadesLog.debug("MONAsignacionProductosBean.guardarEstimadosProducto(DTOMantenerEstimadosProducto dtoMantenerEstimadosProducto): Salida");
    }
    
    /**
     * Recupera para la recarga del combo 'Versiones' los numeros de version
     * correspondientes a los registros de APE: AsignacionProductosAnaquelesCabecera
     * en base a los oid de 'Mapa centro distribucion', 'Mapa de zonas' y 'Periodo'
     * @autor eiraola
     * @since 24/01/2007
     */
    public DTOSalida obtenerVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.obtenerVersionesAsignacion(dtoe): Entrada");
        
        DTOSalida dtoSalida = new DAOAsignacionProductos().obtenerVersionesAsignacion(dtoe);
        UtilidadesLog.info("MONAsignacionProductos.obtenerVersionesAsignacion(dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Realiza las validaciones necesarias para la asignacion de un producto a
     * un anaquel que desea realizar el usuario. Utiliza varias consultas sql.
     * Es llamado desde parte cliente por cada fila de cod anaquel y cod producto
     * editada (realmente esto deberá mejorarse a futuro).
     * Debe devolver el mismo dto de entrada pero con los oid cargados si la validacion
     * es OK, y en caso contrario genera un mensaje de error al usuario. 
     * @autor eiraola
     * @since 01/01/2007
     */
    public DTOMantenerAsignacionProductosAnaqueles validarAsignacionProductosAnaqueles(
            DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Entrada");
        
        DAOAsignacionProductos daoAP = new DAOAsignacionProductos();
        
        if (daoAP.validarExistenciaVigenciaAnaquel(dtoe).booleanValue()) {      // (1) Vigencia y existencia del Anaquel
            UtilidadesLog.debug("  (1) Anaquel existe y esta vigente --> OK");
            
            if (daoAP.validarAsignacionAnteriorAnaquel(dtoe).booleanValue()) {  // (2) Que el anaquel no tenga ya asignado otro producto
                UtilidadesLog.debug("  (2) Anaquel no posee ya asignado otro producto --> OK");
                
                if (daoAP.validarExistenciaProducto(dtoe).booleanValue()) {     // (3) Existencia del Producto (y tiene estimacion)
                    UtilidadesLog.debug("  (3) Existe el Producto (y tiene estimacion) --> OK");
                    
                    Long unidEstimadas = daoAP.validacionAFPProductoLinea(dtoe);
                    
                    if (unidEstimadas!=null) {// (4) Que si el producto es de Fuera de Pedido la linea tambien lo sea
                        UtilidadesLog.debug("  (4) Si el Producto fuera FP la linea tambien --> OK");
                        
                        ArrayList detalle = dtoe.getLstValidacionProductoAnaquel();
                        if (detalle.size() > 0) {
                            // Tomamos el primer elemento para validarlo
                            DTOValidacionProductoAnaquel dtoFilaDetalle = (DTOValidacionProductoAnaquel)detalle.get(0);
                            UtilidadesLog.debug(" el detalle a validar es: " + dtoFilaDetalle);
                            
                            // Accedemos a los entity para recuperar los oid correspondientes
                            
                            // Producto
                            MaestroProductosLocalHome productoHome = this.getMaestroProductosLocalHome();
                            MaestroProductosLocal productoLocal = null;
   
                            try {
                                productoLocal = productoHome.findByUK(dtoe.getOidPais(), 
                                                                      dtoe.getCodigoProducto());
                            } catch (FinderException fe) {
                                UtilidadesLog.error("Producto no encontrado ", fe);
                                throw new MareException(fe, 
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE +
                                        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.CODIGO_SAP_INEXISTENTE));
                            }
                            
                            dtoFilaDetalle.setOidProducto(productoLocal.getOid());
                            
                            // Anaquel
                            MapaCentroDistribucionDetalleLocalHome mapaCDDetaHome = new MapaCentroDistribucionDetalleLocalHome();
                            MapaCentroDistribucionDetalleLocal mapaCDDetaLocal = null;
   
                            try {
                                mapaCDDetaLocal = mapaCDDetaHome.findByUK(dtoe.getCodigoAnaquel(), 
                                                                          dtoe.getOidMapaCentroDistribucion());
                            } catch (NoResultException e) {
                                UtilidadesLog.error("MapaCentroDistribucionDetalle no encontrado ", e);
                                ctx.setRollbackOnly();
                                throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                            } catch (PersistenceException e) {
                                UtilidadesLog.error("MapaCentroDistribucionDetalle no encontrado ", e);
                                ctx.setRollbackOnly();
                                throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                            }
                            
                            dtoFilaDetalle.setOidAnaquel(mapaCDDetaLocal.getOid());
                            // vbongiov -- BELC400000594 -- 26/07/2007
                            dtoFilaDetalle.setUnidadesEstimadas(unidEstimadas);
                            
                            detalle.set(0, dtoFilaDetalle);
                            dtoe.setLstValidacionProductoAnaquel(detalle);
                            return dtoe;
                        }
                    } else { // (4) // APE_0029: El anaquel XXX y el producto YYY no son del mismo tipo (fuera / dentro de pedido)
                        ExcepcionParametrizada exPar;
                        int numeroError = UtilidadesError.armarCodigoError(
                                                           ConstantesSEG.MODULO_APE,
                                                           ErroresDeNegocio.APE_0029);
                        exPar = new ExcepcionParametrizada("", numeroError);
                        exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                        exPar.addParameter(dtoe.getCodigoAnaquel());
                        exPar.addParameter(dtoe.getCodigoProducto());
                        UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Salida (4e)");
                        throw exPar;
                    }
                } else { // (3) // APE_0030: El código producto YYY no posee estimados
                    ExcepcionParametrizada exPar;
                    int numeroError = UtilidadesError.armarCodigoError(
                                                       ConstantesSEG.MODULO_APE,
                                                       ErroresDeNegocio.APE_0030);
                    exPar = new ExcepcionParametrizada("", numeroError);
                    exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    exPar.addParameter(dtoe.getCodigoProducto());
                    UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Salida (3e)");
                    throw exPar;
                }
            } else { // (2) // APE_0031: El anaquel XXX posee un producto asociado
                ExcepcionParametrizada exPar;
                int numeroError = UtilidadesError.armarCodigoError(
                                                   ConstantesSEG.MODULO_APE,
                                                   ErroresDeNegocio.APE_0031);
                exPar = new ExcepcionParametrizada("", numeroError);
                exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                exPar.addParameter(dtoe.getCodigoAnaquel());
                UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Salida (2e)");
                throw exPar;
            }
        } else { // (1) // APE_0032: El anaquel XXX no pertenece a la línea de armado o no se encuentra vigente
            ExcepcionParametrizada exPar;
            int numeroError = UtilidadesError.armarCodigoError(
                                               ConstantesSEG.MODULO_APE,
                                               ErroresDeNegocio.APE_0032);
            exPar = new ExcepcionParametrizada("", numeroError);
            exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            exPar.addParameter(dtoe.getCodigoAnaquel());
            UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Salida (1e)");
            throw exPar;
        }
        
        UtilidadesLog.info("MONAsignacionProductos.validarAsignacionProductosAnaqueles(dtoe): Salida");
        return null;
    }

    /**
     * Crea una nueva version de cabecera de asignacion de producto a anaquel
     * (APE_ASIGN_PRODU_ANAQU_CABEC) y devuelve el oid generado. En caso de
     * existencia previa (verificada por UK) informa al usuario.
     * @autor eiraola
     * @since 29/01/2007
     */
    public DTOOID validarNuevaVersionAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.debug("MONAsignacionProductosBean.validarNuevaVersionAsignacion(dtoe): Entrada");
        
        AsignacionProductoAnaquelCabeceraLocalHome apacLH = new AsignacionProductoAnaquelCabeceraLocalHome();
        AsignacionProductoAnaquelCabeceraLocal apacL = null;
        
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(null);
        
        try {
            apacL = apacLH.findByUk(dtoe.getOidMapaCentroDistribucion(), 
                                    dtoe.getVersion(), 
                                    dtoe.getOidPeriodo());
                                    
            UtilidadesLog.debug("... Version invalida (ya existe) --> Imposible crear nueva version");
            // vbongiov -- 4/05/2007 -- Inc BELC400000400 
            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                             UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                              ErroresDeNegocio.APE_0037));
    
            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            ex.addParameter(dtoe.getVersion());
  
            throw ex;   
            
            
        } catch (NoResultException e) {
            UtilidadesLog.debug("... Version valida (no existia) --> Procediendo a crear nueva version");
                        
            try {
                //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera
                apacL = apacLH.create(dtoe.getVersion(),
                                      ConstantesAPE.ACTIVO_FACTURACION_N,
                                      dtoe.getOidPeriodo(),
                                      dtoe.getOidMapaCentroDistribucion(),
                                      dtoe.getOidMapaZona());
                UtilidadesLog.debug("... Version Nueva creada con oid: " + apacL.getOid());
                dtoOid.setOid(apacL.getOid());
            } catch(PersistenceException pe) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("PersistenceException en findByUk: ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
                
        UtilidadesLog.debug("MONAsignacionProductosBean.validarNuevaVersionAsignacion(dtoe): Salida");
        return dtoOid;
    }

    /**
     * Realiza la busqueda de registros para el CU Desasignar productos/anaqueles
     * @autor eiraola
     * @since 31/01/2007
     */
    public DTOSalida consultarAsignacionProductosAnaqueles(DTODesasignarProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.consultarAsignacionProductosAnaqueles(dtoe): Entrada");
        
        DTOSalida dtoSalida = new DAOAsignacionProductos().consultarAsignacionProductosAnaqueles(dtoe);
        UtilidadesLog.info("MONAsignacionProductos.consultarAsignacionProductosAnaqueles(dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Recupera los registros de la Cabecera de Asignaciones de productos a anaqueles.
     * @autor eiraola
     * @since 31/01/2007
     */
    public DTOSalida consultarVersionesAsignacion(DTOMantenerAsignacionProductosAnaqueles dtoe) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.consultarVersionesAsignacion(dtoe): Entrada");
        
        DTOSalida dtoSalida = new DAOAsignacionProductos().consultarVersionesAsignacion(dtoe);
        UtilidadesLog.info("MONAsignacionProductos.consultarVersionesAsignacion(dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Elimina los registros correspondientes a los oid que se pasan por parametro
     * de la entidad APE:AsignacionProductoAnaquelDetalle. Utiliza el metodo del
     * dao que realiza la operacion mediante sentencia SQL.
     * @autor eiraola
     * @since 31/01/2007
     */
    public void eliminarAsignacionProductosAnaqueles(DTOOIDs dtoOids) throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.eliminarAsignacionProductosAnaqueles(DTOOIDs dtoOids): Entrada");
        
        new DAOAsignacionProductos().eliminarAsignacionProductosAnaqueles(dtoOids);
        UtilidadesLog.info("MONAsignacionProductos.eliminarAsignacionProductosAnaqueles(DTOOIDs dtoOids): Salida");
    }

    /**
     * Ingresa detalles de asignacion de productos a anaqueles, insertando los 
     * datos en la entidad APE:AsignacionProductoAnaquelDetalle.
     * se reciben por parámetro.
     * @autor eiraola
     * @since 31/01/2007
     */
     
      /* Modificado por: Cristian Valenzuela
       Incidencia: BELC400000347
       Fecha: 19/04/2007 */
       
    public void guardarAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoe) throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.guardarAsignacionProductosAnaqueles(dtoe): Entrada");
        
        AsignacionProductoAnaquelDetalleLocalHome apadLH = new AsignacionProductoAnaquelDetalleLocalHome();
        AsignacionProductoAnaquelDetalleLocal apadL = null;
        
        Long oidAsignacionProductoAnaquelCabecera = dtoe.getOidAsignacionProductoAnaquel();
        
        DTOValidacionProductoAnaquel filaAsignacion;
        
        ArrayList asignaciones = dtoe.getLstValidacionProductoAnaquel();
        int cantFilas = asignaciones.size();
        UtilidadesLog.debug("Para la APACabe oid " + oidAsignacionProductoAnaquelCabecera 
                            + " se van a insertar " + cantFilas + " detalles (APADeta: prod/anaq)"
                            + " de procedencia Manual (" + ConstantesAPE.OID_PROCEDENCIA_MANUAL + ")" );
        
        for (int i = 0; i < cantFilas; i++) {
            filaAsignacion = (DTOValidacionProductoAnaquel)asignaciones.get(i);
            UtilidadesLog.debug(" ... insertando APAD (oidProd " + filaAsignacion.getOidProducto() 
                                                 + " / oidAnaq " + filaAsignacion.getOidAnaquel() + ")");
            try {
                apadL = apadLH.create(oidAsignacionProductoAnaquelCabecera,
                                      filaAsignacion.getOidProducto(),
                                      ConstantesAPE.OID_PROCEDENCIA_MANUAL);
                apadL.setMapaCentroDistribucionDetalle(filaAsignacion.getOidAnaquel());
                // vbongiov -- BELC400000594 -- 26/07/2007
                apadL.setUnidades(filaAsignacion.getUnidadesEstimadas());
                
                apadLH.merge(apadL);
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
        }
        
        UtilidadesLog.info("MONAsignacionProductos.guardarAsignacionProductosAnaqueles(dtoe): Salida");
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
        MaestroProductosLocalHome home = (MaestroProductosLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos") ;
        return home;
    }

    public DTOSalida calcularHit(DTOCalcularHit dtoE) throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.calcularHit(DTOCalcularHit dtoE): Entrada");
        
        UtilidadesLog.debug("   - SAP601: recibió DTOCalcularHit = " + dtoE);
        DTOSalida dtoS = null;
        dtoS = new DAOAsignacionProductos().calcularHit(dtoE);
        UtilidadesLog.debug("   - SAP601: retorna DTOSalida = " + dtoS);
        
        UtilidadesLog.info("MONAsignacionProductos.calcularHit(DTOCalcularHit dtoE): Salida");
        return dtoS;
    }

    public DTOMantenerEstimadosProducto generarEstimadosProducto(DTOMantenerEstimadosProducto dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONAsignacionProductosBean.generarEstimadosProducto"+
        "(DTOMantenerEstimadosProducto dtoe): Entrada");
        
        UtilidadesLog.debug("******* DTOMantenerEstimadosProducto: " + dtoe);
    
        try {
            Collection estimadosAEliminar = null;
            EstimadosProductoLocalHome eplh = new EstimadosProductoLocalHome();
            estimadosAEliminar = eplh.findByLineaPeriodo(dtoe.getOidLineaArmado(),
            dtoe.getOidLineaArmadoMAV(), dtoe.getOidPeriodo());
           
            //Si el finder trajo datos, se devuelve el control a la pagina
            //preguntadole al usuario si desea sobreescribir
            if(estimadosAEliminar!=null && !estimadosAEliminar.isEmpty()) {
                dtoe.setSobreEscribir(Boolean.TRUE);
            }
            else {
                this.generarEstimadosVentaMAV(dtoe);
            }           
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
       UtilidadesLog.info("MONAsignacionProductosBean.generarEstimadosProducto"+
        "(DTOMantenerEstimadosProducto dtoe): Salida");  
        return dtoe;
    }

    public void eliminarEstimadosVentaMAV(DTOMantenerEstimadosProducto dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONAsignacionProductosBean.eliminarEstimadosVentaMAV"+       
        "(DTOMantenerEstimadosProducto dtoe): Entrada");     
        
        UtilidadesLog.debug("****** DTOMantenerEstimadosProducto " + dtoe);
        
        try {
            EstimadosProductoLocalHome home = new EstimadosProductoLocalHome();
            EstimadosProductoLocal epl = null;
            Boolean mantenerEstimadosManuales = dtoe.getMantenerEstimadosManuales();           
            Collection estimadosAEliminar = dtoe.getEstimadosAEliminar();
            Iterator it = estimadosAEliminar.iterator(); 
            
            while(it.hasNext()) {
                epl = (EstimadosProductoLocal)it.next();
                UtilidadesLog.debug("***  EstimadosProducto.oidProc " + 
                epl.getOidProc().longValue());
                
                if((mantenerEstimadosManuales.booleanValue() == true &&
                epl.getOidProc().longValue() != ConstantesAPE.OID_PROCEDENCIA_MANUAL.longValue()) ||                
                (mantenerEstimadosManuales.booleanValue() == false)) {
                    UtilidadesLog.debug("*** remove en EstimadosProducto");
                    epl = home.findByPrimaryKey(epl.getOid());
                    //home.merge(epl);
                    home.remove(epl);
                }           
            }        
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        
        UtilidadesLog.info("MONAsignacionProductosBean.eliminarEstimadosVentaMAV"+
        "(DTOMantenerEstimadosProducto dtoe): Salida");    
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 27/05/2008: Incidencia 20080502
     *                       Se considera que, para los productos, el indicador
     *                       de "fuera de pedido" (fuera de caja) es "F" o "B".
     */
    public void generarEstimadosVentaMAV(DTOMantenerEstimadosProducto dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONAsignacionProductosBean.generarEstimadosVentaMAV"+
        "(DTOMantenerEstimadosProducto dtoe): Entrada");    
        
        UtilidadesLog.debug("***** DTOMantenerEstimadosProducto " + dtoe);
        
        DAOAsignacionProductos dao = new DAOAsignacionProductos();
        EstimadosProductoLocalHome eplh = new EstimadosProductoLocalHome();
        EstimadosProductoLocal epl = null;            
        RecordSet rs = dao.recuperarEstimadosAGenerar(dtoe);
        UtilidadesLog.debug("***** rs " + rs);
        
        if(rs!=null && !rs.esVacio()) {      
            int cant = rs.getRowCount();
            UtilidadesLog.debug("***** cant " + cant);
                
            for(int i=0; i<cant; i++) {                          
                Long numUnidEsti = null;
                if(rs.getValueAt(i,"UNIDADES")!=null) {
                    numUnidEsti = new Long(((BigDecimal)rs.getValueAt(i,"UNIDADES")).longValue());            
                }
                
                Boolean indFuerPedi = null;
                Object indicador = rs.getValueAt(i,"INDICADOR");
                if("F".equals(indicador) || "B".equals(indicador)) {
                    indFuerPedi = Boolean.TRUE;
                } else {
                    indFuerPedi = Boolean.FALSE;
                }                
                
                Long prceOidProc = ConstantesAPE.OID_PROCEDENCIA_ESTIMADO;            
                Long perdOidPeri = dtoe.getOidPeriodo();
                Long prodOidProd = new Long(((BigDecimal)rs.getValueAt(i,"OID")).longValue());
                Long liarOidLineArma = new Long(((BigDecimal)rs.getValueAt(i,"OIDLINEA")).longValue());
                    
                UtilidadesLog.debug("*** numUnidEsti " + numUnidEsti);
                UtilidadesLog.debug("*** indFuerPedi " + indFuerPedi);
                UtilidadesLog.debug("*** prceOidProc " + prceOidProc);
                UtilidadesLog.debug("*** perdOidPeri " + perdOidPeri);
                UtilidadesLog.debug("*** prodOidProd " + prodOidProd);
                UtilidadesLog.debug("*** liarOidLineArma " + liarOidLineArma);
                
                try {
                    epl = eplh.create(numUnidEsti, indFuerPedi, prceOidProc, liarOidLineArma,
                    perdOidPeri, prodOidProd);                  
                }
                catch (EntityExistsException e) {
                    UtilidadesLog.error("ERROR ", e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                }
                catch (PersistenceException e) {
                    UtilidadesLog.error("ERROR ", e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }            
        }       
        else {
            UtilidadesLog.debug("*** no hay datos, se muestra el mensaje: " + 
            " - No se obtienen registros para la selección - ");
        	throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, 		
            "",ErroresDeNegocio.APE_0052));
        }
    
        UtilidadesLog.info("MONAsignacionProductosBean.generarEstimadosVentaMAV"+
        "(DTOMantenerEstimadosProducto dtoe): Salida");    
    }

    public void sobreEscribirGeneracionEstimadosProducto(DTOMantenerEstimadosProducto dtoe) 
    throws MareException {    
        UtilidadesLog.info("MONAsignacionProductosBean.sobreEscribirGeneracionEstimadosProducto"+
        "(DTOMantenerEstimadosProducto dtoe): Entrada");            
        UtilidadesLog.debug("*********** DTOMantenerEstimadosProducto " + dtoe);
        
        try {
            Collection estimadosAEliminar = null;
            EstimadosProductoLocalHome eplh = new EstimadosProductoLocalHome();
            estimadosAEliminar = eplh.findByLineaPeriodo(dtoe.getOidLineaArmado(),
            dtoe.getOidLineaArmadoMAV(), dtoe.getOidPeriodo());
            
            dtoe.setEstimadosAEliminar(estimadosAEliminar);               
            
            this.eliminarEstimadosVentaMAV(dtoe);
            this.generarEstimadosVentaMAV(dtoe);            
        }        
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }       
       
        UtilidadesLog.info("MONAsignacionProductosBean.sobreEscribirGeneracionEstimadosProducto"+
        "(DTOMantenerEstimadosProducto dtoe): Salida");       
    }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       7/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    
     /* Modificado por: Cristian Valenzuela
       Incidencia: BELC400000347
       Fecha: 19/04/2007 */
  public void insertarAsignacionProductoDetalles(ArrayList detalles) throws MareException {
      UtilidadesLog.info("MONAsignacionProductos.insertarAsignacionProductoDetalles(ArrayList detalles): Entrada");
      try {
          AsignacionProductoAnaquelDetalleLocalHome asigProdDetLH = new AsignacionProductoAnaquelDetalleLocalHome();
          AsignacionProductoAnaquelDetalleLocal asigProdDetL = null;
          DTOAsignacionProductoAnaquelDetalle dtoAsignacionProductoAnaquelDetalle = null;
          
          int cant = detalles.size();
          
          for(int i=0; i< cant; i++){
              dtoAsignacionProductoAnaquelDetalle = (DTOAsignacionProductoAnaquelDetalle)detalles.get(i);
              
              asigProdDetL = asigProdDetLH.create(dtoAsignacionProductoAnaquelDetalle.getOidAsignacionProductoCabecera(),
                                                  dtoAsignacionProductoAnaquelDetalle.getOidProducto(),
                                        new Long(dtoAsignacionProductoAnaquelDetalle.getProcedencia()));
                                                  
              asigProdDetL.setMapaCentroDistribucionDetalle(dtoAsignacionProductoAnaquelDetalle.getOidMapaCDDetalle());
              asigProdDetL.setUnidades(dtoAsignacionProductoAnaquelDetalle.getUnidades());
              asigProdDetL.setAsignacionPTL(dtoAsignacionProductoAnaquelDetalle.getAsignacionPTL());
              asigProdDetL.setSiguienteAsignacion(dtoAsignacionProductoAnaquelDetalle.getSiguienteAsignacion());
              
              asigProdDetLH.merge(asigProdDetL);
          }
      
          UtilidadesLog.info("MONAsignacionProductos.insertarAsignacionProductoDetalles(ArrayList detalles): Salida");
      
      }  catch (PersistenceException e) {
          UtilidadesLog.error("ERROR ", e);
          ctx.setRollbackOnly();
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }  
  }

    /**
     * Crea una nueva version (cabecera) con detalles de asignacion de productos
     * a anaqueles que es la copia de la version seleccionada (con todos sus detalles).
     * @autor eiraola
     * @since 19/02/2007
     */
    public void copiarAsignacionProductosAnaqueles(DTOAsignacionProductoAnaquelCabecera dtoe) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.copiarAsignacionProductosAnaqueles(dtoe): Entrada");
        
        try {
            AsignacionProductoAnaquelCabeceraLocalHome apacLH =  new AsignacionProductoAnaquelCabeceraLocalHome();
            AsignacionProductoAnaquelCabeceraLocal apacL = null;
            
            try {
                apacL = apacLH.findByUk(dtoe.getOidMapaCDCabecera(),
                                        dtoe.getVersion(), 
                                        dtoe.getOidPeriodo());
                
                UtilidadesLog.debug("... 'Version Destino' invalida (ya existe) --> Imposible crear nueva version: " + dtoe.getVersion());
                // Finalizamos el metodo
                ExcepcionParametrizada exPar;
                int numeroError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE,
                                                                   ErroresDeNegocio.APE_0037);
                exPar = new ExcepcionParametrizada("", numeroError);
                exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                exPar.addParameter(dtoe.getVersion());            
                UtilidadesLog.info("MONAsignacionProductos.copiarAsignacionProductosAnaqueles(dtoe): Salida (b)");
                throw exPar;
                
            } catch (NoResultException e) {
                UtilidadesLog.debug("... 'Version Destino' valida (no existia)");
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            DTOAsignacionProductoAnaquelCabecera dtoAsigCabDestino = new DTOAsignacionProductoAnaquelCabecera();
            dtoAsigCabDestino.setOid(null);
            dtoAsigCabDestino.setVersion(dtoe.getVersion());
            dtoAsigCabDestino.setActivoFacturacion(ConstantesAPE.ACTIVO_FACTURACION_N);
            dtoAsigCabDestino.setOidMapaCDCabecera(dtoe.getOidMapaCDCabecera());
            dtoAsigCabDestino.setOidMapaZonaCabecera(dtoe.getOidMapaZonaCabecera());
            dtoAsigCabDestino.setOidPeriodo(dtoe.getOidPeriodo());
            
            // Se inserta la entidad APE:AsignacionProductoAnaquelCabecera 
            Long oidCabeDestino = this.actualizarAsignacionProductoCabecera(dtoAsigCabDestino);
            dtoAsigCabDestino.setOid(oidCabeDestino);
            
            // Se obtienen las entidades APE:AsignacionProductoAnaquelDeatalle origen
            DAOAsignacionProductos daoAP = new DAOAsignacionProductos();
            ArrayList detalles = daoAP.obtenerAsignacionProductoDetalles(dtoe.getOid());
            
            DTOAsignacionProductoAnaquelDetalle dtoDetalle;
            int cantDetalles = detalles.size();
            
            for (int i = 0; i < cantDetalles; i++) {
                dtoDetalle = (DTOAsignacionProductoAnaquelDetalle)detalles.get(i);
                dtoDetalle.setOid(null);
                dtoDetalle.setOidAsignacionProductoCabecera(dtoAsigCabDestino.getOid());
                
                detalles.set(i, dtoDetalle);
            }
            
            this.insertarAsignacionProductoDetalles(detalles);
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
                throw new MareException(e);
        }
        
        UtilidadesLog.info("MONAsignacionProductos.copiarAsignacionProductosAnaqueles(dtoe): Salida (a)");
    }
    
    public Long actualizarAsignacionProductoCabecera(DTOAsignacionProductoAnaquelCabecera dtoE) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.actualizarAsignacionProductoCabecera(dtoE): Entrada");
        
        AsignacionProductoAnaquelCabeceraLocalHome apacLH = new AsignacionProductoAnaquelCabeceraLocalHome();
        AsignacionProductoAnaquelCabeceraLocal apacL = null;
        
        Long oidRetorno = dtoE.getOid();
        
        if (oidRetorno == null) { // es una cabecera de asignacion nueva
            UtilidadesLog.debug("*** Insertando cabecera de asignacion");
            
            try {
                //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera            
                apacL = apacLH.create(dtoE.getVersion(),
                                      dtoE.getActivoFacturacion(),
                                      dtoE.getOidPeriodo(),
                                      dtoE.getOidMapaCDCabecera(),
                                      dtoE.getOidMapaZonaCabecera());
                                      
                oidRetorno = apacL.getOid();
                UtilidadesLog.debug("... 'Version' APAC creada con oid: " + oidRetorno);
                
            } catch (EntityExistsException ex) {
                UtilidadesLog.error(ex);
                ctx.setRollbackOnly();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else { // es una modificacion de una cabecera existente
            UtilidadesLog.debug("*** Actualizando cabecera de asignacion");
            try {
                apacL = apacLH.findByPrimaryKey(oidRetorno);
                UtilidadesLog.debug("... 'Version' APAC a actualizar oid: " + apacL.getOid());
                //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera                
                //apacL.setEstado("M");                                           // Estado es un campo a eliminar
                apacL.setActivoFacturacion(dtoE.getActivoFacturacion());
                apacL.setMapaZonaCabecera(dtoE.getOidMapaZonaCabecera());
                
                try {
                    apacLH.merge(apacL);
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        }
        
        UtilidadesLog.info("MONAsignacionProductos.actualizarAsignacionProductoCabecera(dtoE): Salida");
        return oidRetorno;
    }

    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * 
     * Descripcion: invoca al metodo del DAO para desactivar la version anterior de asignacion de 
     * productos a anaqueles y activa la nueva version 
     */
    public void activarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE) throws MareException {
        UtilidadesLog.info("MONAsignacionProductosBean.activarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Entrada");
        
        DAOAsignacionProductos daoAsigProd = new DAOAsignacionProductos();
        UtilidadesLog.debug("llama a 'desactivar' con ... " + dtoE);
        daoAsigProd.desactivarVersionAsignacionProductosAnaqueles(dtoE);
        
        AsignacionProductoAnaquelCabeceraLocal asigPALocal = null;
        AsignacionProductoAnaquelCabeceraLocalHome asigPALHome = new AsignacionProductoAnaquelCabeceraLocalHome();
        
        try {
            Long oid = dtoE.getOidAsignacionProductoAnaquel();
            UtilidadesLog.debug("antes del finder " + oid);
            asigPALocal = asigPALHome.findByPrimaryKey(oid);
            
            asigPALocal.setActivoFacturacion("S");
            
            try {
                asigPALHome.merge(asigPALocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
        } catch (NoResultException e) {
            
            UtilidadesLog.debug("FinderException.... ");
            ctx.setRollbackOnly();
            e.printStackTrace();
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE ));
        
            
        } catch (PersistenceException e) {
            
            UtilidadesLog.debug("Error: ");
            ctx.setRollbackOnly();
            e.printStackTrace();
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        
        }
        
        UtilidadesLog.info("MONAsignacionProductosBean.activarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Salida");
    }

    /**
     * Recupera una lista de DTOAsignacionProductoAnaquelCabecera con oid y descripcion 
     * de la version activa en cada DTO, de acuerdo a los parametros pasados por parametro.
     * Se utiliza para poder seleccionar por default el combo de Versiones con aquella
     * version que este activa para facturacion.
     * @author eiraola
     * @since 07/Sep/2007
     */
    public Collection obtenerVersionesAsignacionActiva(DTOMantenerAsignacionProductosAnaqueles dtoE) 
            throws MareException {
        UtilidadesLog.info("MONAsignacionProductos.obtenerVersionesAsignacionActiva(...dtoE): Entrada");
        Collection versiones = new ArrayList();
        
        UtilidadesLog.debug(" --- Recibido dtoE: " + dtoE);
        DAOAsignacionProductos daoAP = new DAOAsignacionProductos();
        RecordSet rs = daoAP.obtenerVersionesAsignacionActiva(dtoE);
        
        if (rs != null && !rs.esVacio()) {
            DTOAsignacionProductoAnaquelCabecera dtoAsigProdAnaqCabec = null;
            int cantRegistros = rs.getRowCount();
            
            for (int i = 0; i < cantRegistros; i++) {
                dtoAsigProdAnaqCabec = new DTOAsignacionProductoAnaquelCabecera();
                dtoAsigProdAnaqCabec.setOid(new Long(((BigDecimal)rs.getValueAt(i, "OID_ASIG_PROD_ANAQ_CABE")).longValue()));
                dtoAsigProdAnaqCabec.setVersion((String)rs.getValueAt(i, "VAL_VERS"));
                
                versiones.add(dtoAsigProdAnaqCabec);
            }
        }
        
        UtilidadesLog.info("MONAsignacionProductos.obtenerVersionesAsignacionActiva(...dtoE): Salida");
        return versiones;
    }

  /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   19/11/2007
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Cambio APE-02
   */
  public void desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE) throws MareException {
      UtilidadesLog.info("MONAsignacionProductosBean.desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Entrada");
       
      UtilidadesLog.debug("DTOMantenerAsignacionProductosAnaqueles: " + dtoE);
      
      AsignacionProductoAnaquelCabeceraLocal asigPALocal = null;
      AsignacionProductoAnaquelCabeceraLocalHome asigPALHome = new AsignacionProductoAnaquelCabeceraLocalHome();
      
      try {
          Long oid = dtoE.getOidAsignacionProductoAnaquel();
          UtilidadesLog.debug("antes del finder " + oid);
          asigPALocal = asigPALHome.findByPrimaryKey(oid);
          
          asigPALocal.setActivoFacturacion("N");
          
          try {
              asigPALHome.merge(asigPALocal);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              throw new MareException(e, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
      
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.debug("FinderException.... ");
          e.printStackTrace();
          throw new MareException(e, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE ));
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.debug("Exception ");
          e.printStackTrace();
          throw new MareException(e,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONAsignacionProductosBean.desactivarVersionAsignacionProductosAnaqueles(DTOMantenerAsignacionProductosAnaqueles dtoE): Salida");
  }

    public DTOSalida desProduInter(DTOMantenerEstimadosProducto dtoe) throws MareException {
        UtilidadesLog.info("MONAsignacionProductosBean.desProduInter(DTOMantenerEstimadosProducto dtoe): Entrada ");
        DAOAsignacionProductos dao = new DAOAsignacionProductos();        
        UtilidadesLog.info("MONAsignacionProductosBean.desProduInter(DTOMantenerEstimadosProducto dtoe): Salida ");
        return dao.desProductoInt(dtoe);
    }
}
