package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.entidades.ape.EtiquetasLocal;
import es.indra.sicc.entidades.ape.EtiquetasLocalHome;
import es.indra.sicc.entidades.ape.HistoricoListaPicadoErrorSFLocal;
import es.indra.sicc.entidades.ape.HistoricoListaPicadoErrorSFLocalHome;
import es.indra.sicc.entidades.ape.ListaPicadoDetalleLocal;
import es.indra.sicc.entidades.ape.ListaPicadoDetalleLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.dtos.ape.DTODate;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAORevisionInconsistenciaChequeo {
    public DAORevisionInconsistenciaChequeo()  {  }
    
  /** 
    * Autor: Cristian Valenzuela
    * Fecha: 30/05/2007
    */
    public DTOSalida buscarInconsistenciaChequeo(DTODate dtoe) throws MareException {     
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.buscarInconsistenciaChequeo"+
        "(DTODate dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        String fechaFactu = sdf.format(dtoe.getFecha());
        UtilidadesLog.debug("***** fechaFactu:" + fechaFactu);
        
        // dmorello, 18/09/2007: Modifico forma de obtener campo OID
        //query.append(" SELECT ROWNUM AS OID, ");
        query.append(" SELECT ROW_NUMBER() OVER (ORDER BY val_nume_soli, num_caja) AS OID, ");
        // Fin dmorello 18/09/2007
        query.append(" listaCabecera.OID_LIST_PICA_CABE, ");
        query.append(" solicitudCabecera.VAL_NUME_SOLI, ");
        query.append(" etiqueta.NUM_CAJA, ");
        query.append(" etiqueta.NUM_TOTA_CAJA, ");
        query.append(" etiqueta.NUM_ETIQ ");
        query.append(" FROM APE_ETIQU etiqueta, ");
        query.append(" APE_ESTAD_PEDID estadoPedido, ");
        query.append(" APE_LISTA_PICAD_CABEC listaCabecera, ");
        query.append(" PED_SOLIC_CABEC solicitudCabecera ");
        query.append(" WHERE etiqueta.LPCA_OID_LIST_PICA_CABE = listaCabecera.OID_LIST_PICA_CABE ");
        query.append(" AND etiqueta.ESTP_OID_ESTA_PEDI = estadoPedido.OID_ESTA_PEDI ");
        query.append(" AND listaCabecera.SOCA_OID_SOLI_CABE = solicitudCabecera.OID_SOLI_CABE ");
        query.append(" AND TRUNC(listaCabecera.FEC_FACTU)=TO_DATE( '" + fechaFactu + "', 'dd-MM-yyyy' ) ");
        query.append(" AND estadoPedido.OID_ESTA_PEDI = " + ConstantesAPE.OID_ESTADO_PEDIDO_INCONSISTENTE);
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoe);
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginada);
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (rs.esVacio()) {
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
       
        dtoSalida.setResultado(rs);        
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.buscarInconsistenciaChequeo"+
        "(DTODate dtoe): Salida");      
        return dtoSalida;     
    }
    
  /** 
    * Autor: Cristian Valenzuela
    * Fecha: 4/6/2007
    */
    public DTOSalida revisarCaja(DTOListaPicadoDetalle dtoe) throws MareException {     
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.revisarCaja"+
        "(DTOListaPicadoDetalle dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT listaDetalle.OID_LIST_PICA_DETA, ");
        query.append(" listaDetalle.NUM_CODI_POSI, ");
        // vbongiov -- Inc APE20080516 -- 24/06/2008
        query.append(" i18n.VAL_I18N DES_CORT, ");
        query.append(" listaDetalle.NUM_UNID_PROD, ");
        query.append(" listaDetalle.NUM_UNID_CHEQ, ");
        query.append(" mapaCentroDetalle.NUM_ANAQ, ");
        // vbongiov -- BELC400000664 -- 29/08/2007
        query.append(" ABS(listadetalle.num_unid_prod - listadetalle.num_unid_cheq) UNIDCOMERROR, ");        
        query.append(" listaDetalle.VAL_NOMB_CHEQ, ");
        query.append(" DECODE(listaDetalle.VAL_NOMB_PICA, NULL, 'Generica', ");
        query.append(" listaDetalle.VAL_NOMB_PICA) AS VAL_NOMB_PICA, ");
        query.append(" listaDetalle.VAL_OBSE_REVI, ");
        query.append(" listaDetalle.NUM_CAJA, ");       
        query.append(" listaCabecera.OID_LIST_PICA_CABE ");  
        query.append(" , codigoError.COD_ERRO_CHEQ, ");  // BELC400000735 - dmorello, 14/09/2007
        query.append("  listadetalle.NUM_UNID_VERI "); // Agregado por cambio 20090839
        query.append(" FROM APE_LISTA_PICAD_CABEC listaCabecera, ");
        query.append(" APE_LISTA_PICAD_DETAL listaDetalle, ");
        query.append(" APE_ETIQU etiqueta, ");
        query.append(" APE_MAPA_CENTR_DISTR_DETAL mapaCentroDetalle, ");
        query.append(" MAE_PRODU producto, ");
        query.append(" APE_CODIG_ERROR_CHEQU codigoError ");
        query.append(" , v_gen_i18n_sicc i18n ");  // vbongiov -- Inc APE20080516 -- 24/06/2008
        query.append(" WHERE listaCabecera.OID_LIST_PICA_CABE = " + dtoe.getOidCabecera());
        query.append(" AND listaDetalle.NUM_CAJA = " + dtoe.getNumeroCaja());
        query.append(" AND etiqueta.NUM_ETIQ = " + dtoe.getNumeroEtiqueta());
        query.append(" AND listaCabecera.OID_LIST_PICA_CABE = listaDetalle.LPCA_OID_LIST_PICA_CABE ");
        query.append(" AND listaCabecera.OID_LIST_PICA_CABE = etiqueta.LPCA_OID_LIST_PICA_CABE ");
        query.append(" AND listaDetalle.MCDD_OID_MAPA_CENT_DIST_DETA = mapaCentroDetalle.OID_MAPA_CENT_DIST_DETA ");
        query.append(" AND listaDetalle.PROD_OID_PROD = producto.OID_PROD ");
        query.append(" AND listaDetalle.COEC_OID_CODI_ERRO_CHEQ = codigoError.OID_CODI_ERRO_CHEQ (+) ");
        query.append(" AND listaDetalle.NUM_CAJA = etiqueta.NUM_CAJA ");
        // vbongiov -- Inc APE20080516 -- 24/06/2008
        query.append(" AND producto.OID_PROD  = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1 ");
        query.append(" AND i18n.attr_enti = 'MAE_PRODU' ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        dtoSalida.setResultado(rs);   
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.revisarCaja"+
        "(DTOListaPicadoDetalle dtoe): Salida");
        return dtoSalida;     
    }
    
     /** 
    * Autor: Cristian Valenzuela
    * Fecha: 1/6/2007
    */
    public void actualizaEstadoEtiqueta(DTOListaPicadoDetalle dtoe) throws MareException {     
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.actualizaEstadoEtiqueta"+
        "(DTOListaPicadoDetalle dtoe): Entrada");
        
       try {
            EtiquetasLocalHome etiquetaHome = new EtiquetasLocalHome();
            UtilidadesLog.debug("*** Buscando en Etiquetas con:");
            UtilidadesLog.debug("*** oid cabecera : " + dtoe.getOidCabecera());
            UtilidadesLog.debug("*** numero caja : " + dtoe.getNumeroCaja());
            
            EtiquetasLocal etiquetaLocal = etiquetaHome.findByListaPicCabecCaja(dtoe.getOidCabecera(),
            dtoe.getNumeroCaja());
            
            UtilidadesLog.debug("*** Actualizando Etiquetas.oidEstado a 5 - revisado");
            etiquetaLocal.setOidEstado(ConstantesAPE.OID_ESTADO_PEDIDO_REVISADO);
            
            try {
                etiquetaHome.merge(etiquetaLocal);
            } catch (PersistenceException e) {
                UtilidadesLog.error("Error: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            UtilidadesLog.info("DAORevisionInconsistenciaChequeo.actualizaEstadoEtiqueta"+
            "(DTOListaPicadoDetalle dtoe): Salida");           
       }
       catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 1/6/2007
    */
    public void eliminarDetalle(DTOListaPicadoDetalle dtoe) throws MareException {             
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.eliminarDetalle"+
        "(DTOListaPicadoDetalle dtoe): Entrada");
        
        try {
            UtilidadesLog.debug("*** Borrando de ListaPicadoDetalle con oid: " + 
            dtoe.getOid());
            ListaPicadoDetalleLocalHome listaHome = new ListaPicadoDetalleLocalHome();    
            ListaPicadoDetalleLocal listaLocal = listaHome.findByPrimaryKey(dtoe.getOid());
            try {
                listaHome.remove(listaLocal);       
            } catch (PersistenceException e) {
                UtilidadesLog.error("Exception: ", e);
                throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
            
            UtilidadesLog.info("DAORevisionInconsistenciaChequeo.eliminarDetalle"+
            "(DTOListaPicadoDetalle dtoe): Salida");
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
    }
    
    /** 
    * Autor: Cristian Valenzuela
    * Fecha: 1/6/2007
    */
    public void actualizarDetalle(DTOListaPicadoDetalle dtoe) throws MareException {                 
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.actualizarDetalle"+
        "(DTOListaPicadoDetalle dtoe): Entrada");
        
        try {
            UtilidadesLog.debug("*** Actualizando en ListaPicadoDetalle con oid: " + 
            dtoe.getOid());
            ListaPicadoDetalleLocalHome listaHome = new ListaPicadoDetalleLocalHome();    
            ListaPicadoDetalleLocal listaLocal = listaHome.findByPrimaryKey(dtoe.getOid());
            Long oidError;
            if(dtoe.getUnidadesProducto().equals(dtoe.getUnidadesChequeadas())){
                // si unidades chequeadas son iguales seteo el error a null
                UtilidadesLog.info("rempalazo el codigo error a null");
                listaLocal.setCodigoError(null);
            }else{
               if(dtoe.getCodigoError()!=null) {
                    RecordSet rs = this.oidCodigoError(dtoe);
                    oidError = new Long(((BigDecimal) (rs.getValueAt(0, "OID_CODI_ERRO_CHEQ"))).longValue());
                    // si son distintan mantengo el error 
                    listaLocal.setCodigoError(oidError);
               }
            }            
            
            listaLocal.setObservacionesRevision(dtoe.getObservaciones());            
            //listaLocal.setUnidadesChequeadas(dtoe.getUnidadesChequeadas()); quitado por cambio 20090839
            listaLocal.setUnidadesVerificadas(dtoe.getUnidadesVerificadas());
            
            try {
                listaHome.merge(listaLocal);
            } catch (PersistenceException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            UtilidadesLog.info("DAORevisionInconsistenciaChequeo.actualizarDetalle"+
            "(DTOListaPicadoDetalle dtoe): Salida");            
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }           
    }
    
    /**
     * Inserta en la entidad HistoricoListaPicadoErrorSF un registro igual al
     * que haya en ListaPicadoDetalle, cuyo OID se recibe en el dtoe.
     * Por cambio en CU APE-131
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @author dmorello
     * @since 11-09-2007
     */
    public void guardarHistoricoListaPicadoErrorSF(DTOListaPicadoDetalle dtoe) throws MareException {
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.guardarHistoricoListaPicadoErrorSF(DTOListaPicadoDetalle dtoe): Entrada");
        
        try {
            ListaPicadoDetalleLocalHome listaHome = new ListaPicadoDetalleLocalHome();    
            HistoricoListaPicadoErrorSFLocalHome histHome = new HistoricoListaPicadoErrorSFLocalHome();

            UtilidadesLog.debug("*** Buscando en ListaPicadoDetalle con oid: " + dtoe.getOid());
            ListaPicadoDetalleLocal det = listaHome.findByPrimaryKey(dtoe.getOid());
            
            UtilidadesLog.debug("*** Creando registro en HistoricoListaPicadoErrorSF...");
            HistoricoListaPicadoErrorSFLocal hist;
            try {
                hist = histHome.create(det.getCodigoPosicion(), det.getUnidadesProducto(), det.getValorLinea(),
                                       det.getNumeroCaja(), det.getIndicadorImpresion(), det.getNombrePicador(),
                                       det.getUnidadesPicadas(), det.getUnidadesChequeadas(), det.getNombreChequeador(),
                                       det.getCabecera(), det.getMapaCentroDistribucionDetalle(), det.getTiposCajaEmbalaje(),
                                       det.getProducto(), det.getSistemaPicado(), det.getObservacionesRevision(), det.getCodigoError());
            } catch (PersistenceException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.debug("*** Registro creado! OID: " + hist.getOid());
        }
        catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }           
        
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.guardarHistoricoListaPicadoErrorSF(DTOListaPicadoDetalle dtoe): Salida");
    }
    public RecordSet oidCodigoError(DTOListaPicadoDetalle dtoe) throws MareException{
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.oidCodigoError(DTOListaPicadoDetalle dtoe): Entrada");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        query.append(" select ape_codig_error_chequ.OID_CODI_ERRO_CHEQ ");
        query.append(" from  ape_codig_error_chequ ");
        query.append(" where ape_codig_error_chequ.COD_ERRO_CHEQ = '" + dtoe.getCodigoError()+ "' ");
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);           
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);           
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAORevisionInconsistenciaChequeo.oidCodigoError(DTOListaPicadoDetalle dtoe): Salida");
        return rs;
    }
}