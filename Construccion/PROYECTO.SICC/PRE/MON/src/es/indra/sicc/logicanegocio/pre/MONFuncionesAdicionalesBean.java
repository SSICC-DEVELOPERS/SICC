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

package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosAlternativos;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosRecuperacion;
import es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosReemplazo;
import es.indra.sicc.dtos.pre.DTOEBuscarProductosVenta;
import es.indra.sicc.dtos.pre.DTOMatrizCodigoRecuperacion;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.entidades.pre.MatrizCodigosAternativosLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosAternativosLocalHome;
import es.indra.sicc.entidades.pre.MatrizCodigosRecuperacionLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosRecuperacionLocalHome;
import es.indra.sicc.entidades.pre.MatrizCodigosReemplazoLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosReemplazoLocalHome;
import es.indra.sicc.logicanegocio.pre.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.PREEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class MONFuncionesAdicionalesBean implements SessionBean {

    public final int RECUPERACION = 0;
    public final int ALTERNATIVOS = 1;
    public final int REEMPLAZO = 2;
    
    SessionContext ctx;  

    public void ejbCreate() {  }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }
    public void setSessionContext(SessionContext ctx) { 
        this.ctx=ctx;
    }

    public DTOSalida cargarRegistroMatrizCodigosAlternativos(DTOProductoVenta productoPrincipal) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosAlternativos(DTOProductoVenta productoPrincipal): Entrada");
        
        StringBuffer buf = new StringBuffer();
        BelcorpService vs = null;
        String codigoError;

        DTOSalida dtoSal = new DTOSalida();

        try {
            vs = BelcorpService.getInstance();
        } catch (Exception ex) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }

        buf.append(" SELECT distinct f.oid_matr_fact, p.val_codi_vent, g.VAL_I18N,  m.num_orde, DECODE(m.ind_mens,1,'S','N') ind_mens");
        buf.append(" FROM pre_matri_codig_alter m, pre_matri_factu f, pre_ofert_detal p, mae_produ pro, V_GEN_I18N_SICC g ");
        buf.append(" WHERE m.MAFA_OID_COD_ALTE = f.oid_matr_fact");
        buf.append(" and m.MAFA_OID_COD_PPAL = " + productoPrincipal.getOidMatrizFacturacion());
        buf.append(" and f.OFDE_OID_DETA_OFER = p.oid_deta_ofer ");
        buf.append(" and p.PROD_OID_PROD = pro.OID_PROD ");
        buf.append(" AND g.VAL_OID = pro.OID_PROD  ");
        buf.append(" AND g.ATTR_NUM_ATRI = 1 ");
        buf.append(" AND g.ATTR_ENTI ='MAE_PRODU'  ");
        buf.append(" AND g.IDIO_OID_IDIO =  " + productoPrincipal.getOidIdioma());
        buf.append(" ORDER BY  m.num_orde ");

        RecordSet r = null;

        try {
            r = vs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex); 
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }

        dtoSal.setResultado(r);

        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosAlternativos(DTOProductoVenta productoPrincipal): Salida");
        return dtoSal;
    }

    private RecordSet runQuery(StringBuffer query) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.runQuery(StringBuffer query): Entrada");
        try {
            UtilidadesLog.info("MONFuncionesAdicionalesBean.runQuery(StringBuffer query): Salida");
            return BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOMatrizCodigoRecuperacion cargarRegistroMatrizCodigosRecuperacion(DTOProductoVenta productoPrincipal) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosRecuperacion(DTOProductoVenta productoPrincipal): Entrada");
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT mr.MAFA_OID_COD_RECU, per.VAL_NOMB_PERI ,do.VAL_CODI_VENT , i.VAL_I18N, IND_RECU_AUTO,IND_MENS, per.OID_PERI ");
        query.append(" from PRE_MATRI_FACTU m, PRE_OFERT_DETAL do, PRE_MATRI_RECUP mr,  PRE_MATRI_FACTU_CABEC c, CRA_PERIO per, MAE_PRODU mae, V_GEN_I18N_SICC i ");
        query.append(" where mr.MAFA_OID_COD_PPAL =  " + productoPrincipal.getOidMatrizFacturacion());
        query.append(" and mr.MAFA_OID_COD_RECU = m.OID_MATR_FACT   ");
        query.append(" and do.OID_DETA_OFER = m.OFDE_OID_DETA_OFER  ");
        query.append(" and mae.OID_PROD = do.PROD_OID_PROD ");
        query.append(" and i.VAL_OID = mae.OID_PROD  ");
        query.append(" and i.ATTR_ENTI = 'MAE_PRODU'  ");
        query.append(" and i.IDIO_OID_IDIO = " + productoPrincipal.getOidIdioma());
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and c.OID_CABE = m.MFCA_OID_CABE ");
        query.append(" and per.OID_PERI = c.PERD_OID_PERI ");

        DTOMatrizCodigoRecuperacion dtoMatriz = new DTOMatrizCodigoRecuperacion();
        dtoMatriz.setProductoRecuperado(this.runQuery(query));
        query = new StringBuffer();

        query.append(" SELECT per.oid_peri, per.val_nomb_peri ");
        query.append("   FROM cra_perio per,  ");
        query.append("        cra_perio per2, ");
        query.append("        pre_matri_factu mf, ");
        query.append("        pre_matri_factu_cabec c ");
        query.append("  WHERE mf.oid_matr_fact = " + productoPrincipal.getOidMatrizFacturacion());
        query.append("    AND mf.mfca_oid_cabe = c.oid_cabe ");
        query.append("    AND per2.oid_peri = c.perd_oid_peri ");
        query.append("    AND per.marc_oid_marc = per2.marc_oid_marc ");
        query.append("    AND per.pais_oid_pais = per2.pais_oid_pais ");
        query.append("    AND per.cana_oid_cana = per2.cana_oid_cana ");
        query.append("    order by 2 ");

        dtoMatriz.setPeriodos(this.runQuery(query));

        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosRecuperacion(DTOProductoVenta productoPrincipal): Salida");
        return dtoMatriz;
    }

    public DTOSalida cargarRegistroMatrizCodigosReemplazo(DTOProductoVenta productoPrincipal) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosReemplazo(DTOProductoVenta productoPrincipal): Entrada");
        
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" PRE_MATRI_FACTU.oid_matr_fact, ");
        query.append(" DetalleOferta.VAL_CODI_VENT, ");
        query.append(" Idioma.VAL_I18N, ");
        query.append(" MatrizReemplazo.IND_REEM_ANTE_CUAD, ");
        query.append(" MatrizReemplazo.IND_MENS ");
        query.append(" FROM ");
        query.append(" PRE_MATRI_REEMP MatrizReemplazo, ");
        query.append(" PRE_OFERT_DETAL DetalleOferta, ");
        query.append(" MAE_PRODU Producto, ");
        query.append(" V_GEN_I18N_SICC Idioma, ");
        query.append(" PRE_MATRI_FACTU ");
        query.append(" WHERE ");
        query.append(" MatrizReemplazo.MAFA_OID_COD_PPAL = " + productoPrincipal.getOidMatrizFacturacion() + " ");
        query.append(" and PRE_MATRI_FACTU.OID_MATR_FACT = MatrizReemplazo.MAFA_OID_COD_REEM ");
        query.append(" and DetalleOferta.OID_DETA_OFER = PRE_MATRI_FACTU.OFDE_OID_DETA_OFER ");
        query.append(" and DetalleOferta.PROD_OID_PROD = Producto.OID_PROD ");
        query.append(" and Idioma.ATTR_ENTI = 'MAE_PRODU' ");
        query.append(" and Idioma.IDIO_OID_IDIO = " + productoPrincipal.getOidIdioma() + " ");
        query.append(" and Idioma.ATTR_NUM_ATRI = 1 ");
        query.append(" and Idioma.VAL_OID = Producto.OID_PROD ");

        RecordSet rs;

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dto = new DTOSalida();
        dto.setResultado(rs);
        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.cargarRegistroMatrizCodigosReemplazo(DTOProductoVenta productoPrincipal): Salida");
        return dto;
    }

    public DTOSalida buscarProductosVenta(DTOEBuscarProductosVenta dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarProductosVenta(DTOEBuscarProductosVenta dto): Entrada");
    
        RecordSet rs = new RecordSet();
        StringBuffer sQuery = new StringBuffer();
        BelcorpService bs = null;
        DTOSalida dtoSalida = new DTOSalida();
        String sCodigoVenta = dto.getCodigoVenta();
        String sDescripcion = dto.getDescripcionProducto();
        Long nIdioma = dto.getOidIdioma();
        Long nTipoProdEstrategia = dto.getTipoProductoEstrategia();
        Long nPeriodo = dto.getOidPeriodo();
        Long nOidCabeceraMF = dto.getOidCabeceraMF();

        if (nPeriodo != null) {
            nOidCabeceraMF = this.obtenerOIDCabecParaPeriodo(nOidCabeceraMF, nPeriodo);
        }

        //UtilidadesLog.debug("DTOEBuscarProductosVenta: " + dto.toString());

        // 1. Arma la query.
        // ********************
        //UtilidadesLog.debug(" **** Armando la Query");
        sQuery.append("SELECT p.oid_matr_fact OID, d.val_codi_vent, g.VAL_I18N, per.oid_peri ");
        sQuery.append("FROM pre_matri_factu p, ");
        sQuery.append("     pre_matri_factu_cabec c, ");
        sQuery.append("     cra_perio per, ");
        sQuery.append("pre_ofert_detal d, ");
        sQuery.append("mae_produ m, ");
        sQuery.append("v_gen_i18n_sicc g");

        sQuery.append(", pre_estra e, ");
        sQuery.append("pre_ofert o ");

        sQuery.append(" WHERE p.OFDE_OID_DETA_OFER = d.OID_DETA_OFER ");
        sQuery.append(" AND p.MFCA_OID_CABE = " + nOidCabeceraMF + " ");
        sQuery.append(" and c.PERD_OID_PERI = per.OID_PERI ");
        sQuery.append(" AND p.mfca_oid_cabe = c.OID_CABE ");

        sQuery.append("AND d.OFER_OID_OFER = o.OID_OFER ");
        sQuery.append("AND o.COES_OID_ESTR = e.OID_ESTR ");

        if (nTipoProdEstrategia != null) {
            // Solamente si estrategia tiene un valor linkea con estas tablas.
            sQuery.append("AND e.TIPR_OID_TIPO_PROD = " + nTipoProdEstrategia.toString() + " ");
            
         //modificado por Sapaza, fecha 04-10-2007, cambio Sicc20070457  
         /*} else {
            sQuery.append("AND e.TIPR_OID_TIPO_PROD = 1 ");*/
        }

        sQuery.append("AND d.PROD_OID_PROD = m.OID_PROD ");
        sQuery.append("AND g.IDIO_OID_IDIO = " + nIdioma.toString() + " ");
        sQuery.append("AND g.ATTR_NUM_ATRI = 1 ");
        sQuery.append("AND g.ATTR_ENTI = 'MAE_PRODU' ");
        sQuery.append("AND g.VAL_OID = m.OID_PROD ");

        if ((sDescripcion != null) && !sDescripcion.equals("")) {
            // Solo si la descripcion no es nula o vacio
            sQuery.append("AND g.VAL_I18N LIKE '" + sDescripcion + "' ");
        }

        if ((sCodigoVenta != null) && !sCodigoVenta.equals("")) {
            // Solo si el Codigo de Venta no es null. o vacio.
            sQuery.append("AND d.VAL_CODI_VENT LIKE '" + sCodigoVenta + "' ");
        }

        // 2. Ejecuta la Query y obtiene un recordSet
        // ******************************************
        try {
            //UtilidadesLog.debug("Obtiene BelcorpService");
            bs = BelcorpService.getInstance();
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        sQuery = new StringBuffer(UtilidadesPaginacion.armarQueryPaginacion(sQuery.toString(), dto));

        try {
            rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (rs.getRowCount() == 0) // No trae registros, tira un Error de Peticion de Datos NoExistente
         {
            //UtilidadesLog.debug("No hay datos en el RecordSet");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        //UtilidadesLog.debug("dtoSalida: " + dtoSalida.toString());

        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarProductosVenta(DTOEBuscarProductosVenta dto): Salida");
        return dtoSalida;
    }

    private void deleteMainProdRecuperacion(MatrizCodigosRecuperacionLocalHome matrizCodigosXXXLocalHome, Long primaryKey) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdRecuperacion(MatrizCodigosRecuperacionLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Entrada");
        
        try {            
            Collection mat = matrizCodigosXXXLocalHome.findByOidPpal(primaryKey);
            Iterator it = mat.iterator();

            while (it.hasNext())
                matrizCodigosXXXLocalHome.remove(((MatrizCodigosRecuperacionLocal) it.next()));                
                
        } catch (NoResultException fe) {
            UtilidadesLog.debug("No se encontraron matrices de recuperacion. OK. Continua el proceso.");
            //no debe tirar por la logica de negocio!!!!  throw new MareException(fe,  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
        } catch (PersistenceException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdRecuperacion(MatrizCodigosRecuperacionLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Salida");
    }

    private void deleteMainProdAlternativos(MatrizCodigosAternativosLocalHome matrizCodigosXXXLocalHome, Long primaryKey) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdAlternativos(MatrizCodigosAternativosLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Entrada");
        
        try {
        
            Collection mat = matrizCodigosXXXLocalHome.findByOidPpal(primaryKey);
            Iterator it = mat.iterator();

            while (it.hasNext())
                matrizCodigosXXXLocalHome.remove(((MatrizCodigosAternativosLocal) it.next()));                
                
        } catch (NoResultException fe) {
            UtilidadesLog.debug("No se encontraron matrices de alternativos. OK.");
            //no debe tirar por la logica de negocio!!!!  throw new MareException(fe,  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
        } catch (PersistenceException fe) {
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdAlternativos(MatrizCodigosAternativosLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Salida");
    }

    private void deleteMainProdReemplazo(MatrizCodigosReemplazoLocalHome matrizCodigosXXXLocalHome, Long primaryKey) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdReemplazo(MatrizCodigosReemplazoLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Entrada");
        
        try {
            
            Collection mat = matrizCodigosXXXLocalHome.findByOidPpal(primaryKey);
            Iterator it = mat.iterator();

            while (it.hasNext())
                matrizCodigosXXXLocalHome.remove(((MatrizCodigosReemplazoLocal) it.next()));
                
        } catch (NoResultException fe) {
             UtilidadesLog.debug("No se encontraron matrices de reemplazos. OK.");
            //no debe tirar por la logica de negocio!!!!  throw new MareException(fe,  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
        } catch (PersistenceException fe) {
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProdReemplazo(MatrizCodigosReemplazoLocalHome matrizCodigosXXXLocalHome, Long primaryKey): Salida");
    }

    private void deleteMainProd(int clase, DTOProductoVenta dtoProdVenta) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProd(int clase, DTOProductoVenta dtoProdVenta): Entrada");
        
        try {
            Object localHome = this.getMatrizCodigosXXXLocalHome(clase);
            Long primKey = dtoProdVenta.getOidMatrizFacturacion();            

            switch (clase) {
              case RECUPERACION: {
                  this.deleteMainProdRecuperacion((MatrizCodigosRecuperacionLocalHome) localHome, primKey);
                  break;
              }  
              case REEMPLAZO: {
                  this.deleteMainProdReemplazo((MatrizCodigosReemplazoLocalHome) localHome, primKey);  
                  break;
              }  
              case ALTERNATIVOS:
                  this.deleteMainProdAlternativos((MatrizCodigosAternativosLocalHome) localHome, primKey);
            }
        } catch (MareException mex) {
            UtilidadesLog.error(mex);
            throw mex;
        } 
        UtilidadesLog.info("MONFuncionesAdicionalesBean.deleteMainProd(int clase, DTOProductoVenta dtoProdVenta): Salida");
    }
    
    private void addAllProds(Long prodPpal, ArrayList lstProd, int clase) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addAllProds(Long prodPpal, ArrayList lstProd, int clase): Entrada");
        /*2.- Por cada producto contenido en el atributo "listaProductos" del dto de entrada,
           hacer una inserción mediante un create sobre la entidad MatrizCodigosRecuperacion. */
        Iterator iterator = lstProd.iterator();

        while (iterator.hasNext())
            this.addProd(prodPpal, (DTOProductoVenta) iterator.next(), clase);
            
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addAllProds(Long prodPpal, ArrayList lstProd, int clase): Salida");
    }

    private void addProd(Long prodPpal, DTOProductoVenta dtoProd, int clase) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProd(Long prodPpal, DTOProductoVenta dtoProd, int clase): Entrada");
        
        switch (clase) {
            case RECUPERACION: {
                this.addProdRec(prodPpal, dtoProd);    
                break;
            }
    
            case REEMPLAZO: {
                this.addProdReemp(prodPpal, dtoProd);    
                break;
            }
    
            case ALTERNATIVOS: {
                this.addProdAlt(prodPpal, dtoProd);    
                break;
            }
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProd(Long prodPpal, DTOProductoVenta dtoProd, int clase): Salida");
    }

    private void addProdRec(Long prodPpal, DTOProductoVenta dtoProd) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdRec(Long prodPpal, DTOProductoVenta dtoProd): Entrada");
        
        /* hacer una inserción mediante un create sobre la entidad MatrizCodigosRecuperacion. */
        try {
            MatrizCodigosRecuperacionLocalHome matrizCodigosRecuperacionLocalHome = new MatrizCodigosRecuperacionLocalHome();
            MatrizCodigosRecuperacionLocal matrizCodigosRecuperacionLocal;
            int largo = 1 ;
            if(dtoProd.getRegiones()!=null){
              largo = dtoProd.getRegiones().size();
            }
            if(dtoProd.getZonas()!=null){
              largo = dtoProd.getZonas().size();
            }
            for(int i=0;i<largo;i++){            
                 matrizCodigosRecuperacionLocal = null;
                 matrizCodigosRecuperacionLocal = matrizCodigosRecuperacionLocalHome.create(prodPpal, dtoProd.getOidMatrizFacturacion(), dtoProd.getIndicadorRecuperadorAut(), dtoProd.getEmiteMensaje());
                 matrizCodigosRecuperacionLocal.setTipoCliente(dtoProd.getTipoCliente());
                 matrizCodigosRecuperacionLocal.setSubTipoCliente(dtoProd.getSubTipoCliente());
                 matrizCodigosRecuperacionLocal.setTipoClasificacion(dtoProd.getTipoClasificacion());
                 matrizCodigosRecuperacionLocal.setClasificacion(dtoProd.getClasificacion());
                 
                 if(dtoProd.getRegiones()!=null){
                   matrizCodigosRecuperacionLocal.setOidRegion((Long)dtoProd.getRegiones().get(i));
                 }
                 if(dtoProd.getZonas()!=null){
                   matrizCodigosRecuperacionLocal.setOidZona((Long)dtoProd.getZonas().get(i));
                 }
                 matrizCodigosRecuperacionLocalHome.merge(matrizCodigosRecuperacionLocal);
            }
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdRec(Long prodPpal, DTOProductoVenta dtoProd): Salida");
    }
    
    private void addProdReemp(Long prodPpal, DTOProductoVenta dtoProd) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdReemp(Long prodPpal, DTOProductoVenta dtoProd): Entrada");
        /* hacer una inserción mediante un create sobre la entidad MatrizCodigosRecuperacion. */
        try {
            MatrizCodigosReemplazoLocalHome matrizCodigosLocalHome = new MatrizCodigosReemplazoLocalHome();
            MatrizCodigosReemplazoLocal matrizCodigosReemplazoLocal;
            int largo = 1 ;
            if(dtoProd.getRegiones()!=null){
              largo = dtoProd.getRegiones().size();
            }
            if(dtoProd.getZonas()!=null){
              largo = dtoProd.getZonas().size();
            }
            for(int i=0;i<largo;i++){
                matrizCodigosReemplazoLocal = null;
                matrizCodigosReemplazoLocal = matrizCodigosLocalHome.create(prodPpal, dtoProd.getOidMatrizFacturacion(), dtoProd.getIndicadorAntesDespuesCuadre(), dtoProd.getEmiteMensaje());
                matrizCodigosReemplazoLocal.setTipoCliente(dtoProd.getTipoCliente());
                matrizCodigosReemplazoLocal.setSubTipoCliente(dtoProd.getSubTipoCliente());
                matrizCodigosReemplazoLocal.setTipoClasificacion(dtoProd.getTipoClasificacion());
                matrizCodigosReemplazoLocal.setClasificacion(dtoProd.getClasificacion());
                
                if(dtoProd.getRegiones()!=null){
                  matrizCodigosReemplazoLocal.setOidRegion((Long)dtoProd.getRegiones().get(i));
                }
                if(dtoProd.getZonas()!=null){
                  matrizCodigosReemplazoLocal.setOidZona((Long)dtoProd.getZonas().get(i));
                }
                matrizCodigosLocalHome.merge(matrizCodigosReemplazoLocal);
            }
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdReemp(Long prodPpal, DTOProductoVenta dtoProd): Salida");
    }
    
    private void addProdAlt(Long prodPpal, DTOProductoVenta dtoProd) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdAlt(Long prodPpal, DTOProductoVenta dtoProd): Entrada");
        /* hacer una inserción mediante un create sobre la entidad MatrizCodigosRecuperacion. */
        try {
            MatrizCodigosAternativosLocalHome matrizCodigosLocalHome = new MatrizCodigosAternativosLocalHome();
            
            matrizCodigosLocalHome.create(prodPpal, dtoProd.getOidMatrizFacturacion(), dtoProd.getNumeroOrden(), dtoProd.getEmiteMensaje());
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.addProdAlt(Long prodPpal, DTOProductoVenta dtoProd): Salida");
    }
    
    public void guardarMatrizCodigosRecuperacion(DTOProductosVenta dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosRecuperacion(DTOProductosVenta dto): Entrada");
        /*1.- Borrar los registros de la tabla PRE_MATRI_RECUP para el producto principal indicado en el dto de entrada        */
        //this.deleteMainProd(RECUPERACION, dto.getProductoPrincipal());

        /*2.- Por cada producto contenido en el atributo "listaProductos" del dto de entrada,
        hacer una inserción mediante un create sobre la entidad MatrizCodigosRecuperacion. */
        this.addAllProds(dto.getProductoPrincipal().getOidMatrizFacturacion(), dto.getListaProductos(), RECUPERACION);
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosRecuperacion(DTOProductosVenta dto): Salida");
    }

    public void guardarMatrizCodigosReemplazo(DTOProductosVenta dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosReemplazo(DTOProductosVenta dto): Entrada");
        //this.deleteMainProd(REEMPLAZO, dto.getProductoPrincipal());
        this.addAllProds(dto.getProductoPrincipal().getOidMatrizFacturacion(), dto.getListaProductos(), REEMPLAZO);
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosReemplazo(DTOProductosVenta dto): Salida");
        
    }

    public void guardarMatrizCodigosAlternativos(DTOProductosVenta dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosAlternativos(DTOProductosVenta dto): Entrada");
        
        //UtilidadesLog.debug("Antes deleteMainProd");
        this.deleteMainProd(ALTERNATIVOS, dto.getProductoPrincipal());
        //UtilidadesLog.debug("Despues deleteMainProd");
        this.addAllProds(dto.getProductoPrincipal().getOidMatrizFacturacion(), dto.getListaProductos(), ALTERNATIVOS);
        //UtilidadesLog.debug("Despies addAllProds");
        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.guardarMatrizCodigosAlternativos(DTOProductosVenta dto): Salida");
    }

    private Object getMatrizCodigosXXXLocalHome(int clase) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.getMatrizCodigosXXXLocalHome(int clase): Entrada");
        
        Object localHome = null;

        switch (clase) {
            case RECUPERACION: {
                localHome = new MatrizCodigosRecuperacionLocalHome();    
                break;
            }    
            case REEMPLAZO: {
                localHome = new MatrizCodigosReemplazoLocalHome();    
                break;
            }    
            case ALTERNATIVOS: {
                localHome = new MatrizCodigosAternativosLocalHome();    
                break;
            }
        }

        UtilidadesLog.info("MONFuncionesAdicionalesBean.getMatrizCodigosXXXLocalHome(int clase): Salida");
        return localHome;
    }

    public void eliminarMatricesCodigosAlternativos(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosAlternativos(DTOOIDs dto): Entrada");
        
        try {
            Long[] oidsArray = dto.getOids();
            MatrizCodigosAternativosLocalHome mcalh = new MatrizCodigosAternativosLocalHome();
            MatrizCodigosAternativosLocal mcal;

            if (mcalh != null) {                

                for (int j = 0; j < oidsArray.length; j++) {
                    try {
                        mcal = mcalh.findByPrimaryKey(oidsArray[j]);
                        mcalh.remove(mcal);
                    } catch (NoResultException e) {
                        UtilidadesLog.debug("La matriz"+oidsArray[j]+" no existe, continua con la siguiente.");
                    }
                }
            }
            
        } catch (PersistenceException exception) {
            UtilidadesLog.error(exception);
            ctx.setRollbackOnly();
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosAlternativos(DTOOIDs dto): Salida");
    }

    public void eliminarMatricesCodigosRecuperacion(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosRecuperacion(DTOOIDs dto): Entrada");
        
        try {
            Long[] oidsArray = dto.getOids();
            MatrizCodigosRecuperacionLocalHome mcrlh = new MatrizCodigosRecuperacionLocalHome();
            MatrizCodigosRecuperacionLocal mcrl; //modif by P.P.

            if (mcrlh != null) {

                for (int j = 0; j < oidsArray.length; j++) {
                    try {
                        mcrl = mcrlh.findByPrimaryKey(oidsArray[j]);
                        mcrlh.remove(mcrl);
                    } catch (NoResultException e) {
                        UtilidadesLog.debug("La matriz"+oidsArray[j]+" no existe, continua con la siguiente.");
                    }
                }
            }
            
        } catch (PersistenceException exception) {
            UtilidadesLog.error(exception);
            ctx.setRollbackOnly();
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosRecuperacion(DTOOIDs dto): Salida");
    }

    public void eliminarMatricesCodigosReemplazo(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosReemplazo(DTOOIDs dto): Entrada");
        try {
            Long[] oidsArray = dto.getOids();
            MatrizCodigosReemplazoLocalHome mcrlh = new MatrizCodigosReemplazoLocalHome();
            MatrizCodigosReemplazoLocal mcrl;

            if (mcrlh != null) {                

                for (int j = 0; j < oidsArray.length; j++) {
                    try{
                        mcrl = mcrlh.findByPrimaryKey(oidsArray[j]);
                        mcrlh.remove(mcrl);
                    } catch (NoResultException e) {
                        UtilidadesLog.debug("La matriz"+oidsArray[j]+" no existe, continua con la siguiente.");
                    }
                }
            }
            
        } catch (PersistenceException exception) {
            UtilidadesLog.error(exception);
            ctx.setRollbackOnly();
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONFuncionesAdicionalesBean.eliminarMatricesCodigosReemplazo(DTOOIDs dto): Salida");
    }


    public DTOSalida buscarMatricesCodigosAlternativos(DTOEBuscarMatrizCodigosAlternativos dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosAlternativos(DTOEBuscarMatrizCodigosAlternativos dto): Entrada");
        
        DTOSalida dtoS = new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            BelcorpService bs = BelcorpService.getInstance();
            buf.append(" SELECT alt.OID_MATR_ATER, det.VAL_CODI_VENT,  i.VAL_I18N, det2.VAL_CODI_VENT,  i2.VAL_I18N,");
            buf.append(" alt.NUM_ORDE, decode(alt.IND_MENS,1,'").append(ConstantesPRE.SI).append("', '").append(ConstantesPRE.NO).append("') ");
            buf.append(" FROM PRE_MATRI_CODIG_ALTER alt, PRE_MATRI_FACTU ma, PRE_OFERT_DETAL det, MAE_PRODU prod, V_GEN_I18N_SICC i, ");
            buf.append(" PRE_MATRI_FACTU ma2, PRE_OFERT_DETAL det2, MAE_PRODU prod2, V_GEN_I18N_SICC i2");
            buf.append(" where alt.MAFA_OID_COD_PPAL = ma.OID_MATR_FACT ");

            if (dto.getOidCabeceraMF() != null) {
                buf.append(" and ma.OID_MATR_FACT = " + dto.getOidCabeceraMF()); // --parametro ");					  
            }

            buf.append(" and ma.OFDE_OID_DETA_OFER = det.OID_DETA_OFER ");

            if ((dto.getCodigoVenta() != null) && (!dto.getCodigoVenta().equals(""))) {
                buf.append(" and det.VAL_CODI_VENT = '" + dto.getCodigoVenta() + "'"); //--parametro  ");
            }

            buf.append(" and det.PROD_OID_PROD = prod.OID_PROD ");
            buf.append(" and prod.OID_PROD = i.VAL_OID ");
            buf.append(" and i.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i.IDIO_OID_IDIO = " + dto.getOidIdioma()); // -- parametro

            if ((dto.getDescripcionProducto() != null) && (!dto.getDescripcionProducto().equals(""))) {
                buf.append(" and i.VAL_I18N = '" + dto.getDescripcionProducto() + "'");
            }

            buf.append(" and alt.MAFA_OID_COD_ALTE = ma2.OID_MATR_FACT ");
            buf.append(" and ma2.OFDE_OID_DETA_OFER = det2.OID_DETA_OFER ");
            buf.append(" and det2.PROD_OID_PROD = prod2.OID_PROD ");
            buf.append(" and prod2.OID_PROD = i2.VAL_OID ");
            buf.append(" and i2.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i2.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i2.IDIO_OID_IDIO = " + dto.getOidIdioma());

            //buf.append(" order by det.VAL_CODI_VENT, alt.NUM_ORDE ");
            buf.append(" order by i.VAL_I18N ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            codigoError = ErroresNegocio.PRE_0048;
            //UtilidadesLog.debug("Error: " + codigoError);
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", codigoError));
        }

        dtoS.setResultado(respuesta);

        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosAlternativos(DTOEBuscarMatrizCodigosAlternativos dto): Salida");
        return dtoS;
    }

    public DTOSalida buscarMatricesCodigosRecuperacion(DTOEBuscarMatrizCodigosRecuperacion dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosRecuperacion(DTOEBuscarMatrizCodigosRecuperacion dto): Entrada");
        
        DTOSalida dtoS = new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            BelcorpService bs = BelcorpService.getInstance();

            buf.append(" SELECT mat.OID_MATR_RECU, det.VAL_CODI_VENT, i.VAL_I18N, per.VAL_NOMB_PERI, det2.VAL_CODI_VENT,  ");
            buf.append(" ZR.DES_REGI, ZZ.DES_ZONA,  ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TICL_OID_TIPO_CLIE, 'MAE_TIPO_CLIEN' )TIPOCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TICL_OID_TIPO_CLIE, 'MAE_SUBTI_CLIEN' )SBTIPOCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TCCL_OID_TIPO_CLAS, 'MAE_TIPO_CLASI_CLIEN' )TIPOCLASCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.CLAS_OID_CLAS, 'MAE_CLASI' )CLASICLIEN , i2.VAL_I18N , ");
            buf.append(" decode(mat.IND_MENS,1,'").append(ConstantesPRE.SI).append("', '").append(ConstantesPRE.NO).append("') ");
            buf.append(" FROM PRE_MATRI_RECUP mat, PRE_MATRI_FACTU ma, PRE_OFERT_DETAL det, MAE_PRODU prod, V_GEN_I18N_SICC i,  ");
            buf.append("         pre_matri_factu_cabec cab, CRA_PERIO per, zon_regio zr, zon_zona zz, ");
            buf.append("         PRE_MATRI_FACTU ma2, PRE_OFERT_DETAL det2, MAE_PRODU prod2, V_GEN_I18N_SICC i2 ");
            buf.append(" where mat.MAFA_OID_COD_PPAL = ma.OID_MATR_FACT ");
            buf.append(" and cab.OID_CABE = ma.MFCA_OID_CABE ");
            buf.append(" and per.OID_PERI = cab.PERD_OID_PERI ");
            // vbongiov -- 13/01/2009
            buf.append(" AND ZR.OID_REGI(+) = mat.ZORG_OID_REGI ");
            buf.append(" AND ZZ.OID_ZONA(+) =   mat.ZZON_OID_ZONA ");

            if (dto.getOidCabeceraMF() != null) {
                buf.append(" and ma.OID_MATR_FACT = " + dto.getOidCabeceraMF()); // --parametro ");					  
            }

            buf.append(" and ma.OFDE_OID_DETA_OFER = det.OID_DETA_OFER ");

            if ((dto.getCodigoVenta() != null) && (!dto.getCodigoVenta().equals(""))) {
                buf.append(" and det.VAL_CODI_VENT = '" + dto.getCodigoVenta() + "'"); //--parametro  ");
            }

            buf.append(" and det.PROD_OID_PROD = prod.OID_PROD ");
            buf.append(" and prod.OID_PROD = i.VAL_OID ");
            buf.append(" and i.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i.IDIO_OID_IDIO = " + dto.getOidIdioma()); // -- parametro
            /*
            if ((dto.getDescripcionProducto() != null) && (!dto.getDescripcionProducto().equals(""))) {
                buf.append(" and i.VAL_I18N = '" + dto.getDescripcionProducto() + "'");
            }
            */
            buf.append(" and mat.MAFA_OID_COD_RECU = ma2.OID_MATR_FACT ");
            buf.append(" and ma2.OFDE_OID_DETA_OFER = det2.OID_DETA_OFER ");
            buf.append(" and det2.PROD_OID_PROD = prod2.OID_PROD ");
            buf.append(" and prod2.OID_PROD = i2.VAL_OID ");
            buf.append(" and i2.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i2.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i2.IDIO_OID_IDIO = " + dto.getOidIdioma()); // -- parametro
            buf.append("  order by det.VAL_CODI_VENT ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0039));
        }

        dtoS.setResultado(respuesta);

        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosRecuperacion(DTOEBuscarMatrizCodigosRecuperacion dto): Salida");
        return dtoS;
    }

    public DTOSalida buscarMatricesCodigosReemplazo(DTOEBuscarMatrizCodigosReemplazo dto) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosReemplazo(DTOEBuscarMatrizCodigosReemplazo dto): Entrada");
        
        DTOSalida dtoS = new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            BelcorpService bs = BelcorpService.getInstance();
            buf.append(" SELECT mat.OID_MATR_REEM, det.VAL_CODI_VENT,  i.VAL_I18N, det2.VAL_CODI_VENT,  i2.VAL_I18N,  ");
            buf.append(" ZR.DES_REGI, ZZ.DES_ZONA,  ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TICL_OID_TIPO_CLIE, 'MAE_TIPO_CLIEN' )TIPOCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TICL_OID_TIPO_CLIE, 'MAE_SUBTI_CLIEN' )SBTIPOCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.TCCL_OID_TIPO_CLAS, 'MAE_TIPO_CLASI_CLIEN' )TIPOCLASCLIEN , ");
            buf.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC(1,mat.CLAS_OID_CLAS, 'MAE_CLASI' )CLASICLIEN , mat.IND_REEM_ANTE_CUAD,");
            buf.append(" decode(mat.IND_MENS,1,'").append(ConstantesPRE.SI).append("', '").append(ConstantesPRE.NO).append("')");
            buf.append(" FROM PRE_MATRI_REEMP mat, PRE_MATRI_FACTU ma, PRE_OFERT_DETAL det, MAE_PRODU prod, V_GEN_I18N_SICC i,  ");
            buf.append("          PRE_MATRI_FACTU ma2, PRE_OFERT_DETAL det2, MAE_PRODU prod2, V_GEN_I18N_SICC i2, zon_regio zr, zon_zona zz ");
            buf.append(" where mat.MAFA_OID_COD_PPAL = ma.OID_MATR_FACT ");
            // vbongiov -- 13/01/2009
            buf.append(" AND ZR.OID_REGI(+) = mat.ZORG_OID_REGI ");
            buf.append(" AND ZZ.OID_ZONA(+) =   mat.ZZON_OID_ZONA ");

            if (dto.getOidCabeceraMF() != null) {
                buf.append(" and ma.OID_MATR_FACT = " + dto.getOidCabeceraMF()); // --parametro ");					  
            }

            buf.append(" and ma.OFDE_OID_DETA_OFER = det.OID_DETA_OFER ");

            if ((dto.getCodigoVenta() != null) && (!dto.getCodigoVenta().equals(""))) {
                buf.append(" and det.VAL_CODI_VENT = '" + dto.getCodigoVenta() + "'"); //--parametro  ");
            }

            buf.append(" and det.PROD_OID_PROD = prod.OID_PROD ");
            buf.append(" and prod.OID_PROD = i.VAL_OID ");
            buf.append(" and i.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i.IDIO_OID_IDIO = " + dto.getOidIdioma()); // -- parametro

            
            if ((dto.getDescripcionProducto() != null) && (!dto.getDescripcionProducto().equals(""))) {
                buf.append(" and i.VAL_I18N = '" + dto.getDescripcionProducto() + "'");
            }

            buf.append(" and mat.MAFA_OID_COD_REEM = ma2.OID_MATR_FACT ");
            buf.append(" and ma2.OFDE_OID_DETA_OFER = det2.OID_DETA_OFER ");
            buf.append(" and det2.PROD_OID_PROD = prod2.OID_PROD ");
            buf.append(" and prod2.OID_PROD = i2.VAL_OID ");
            buf.append(" and i2.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" and i2.ATTR_NUM_ATRI = 1 ");
            buf.append(" and i2.IDIO_OID_IDIO = " + dto.getOidIdioma());
            buf.append(" order by det.VAL_CODI_VENT ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0040));
        }

        dtoS.setResultado(respuesta);
        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.buscarMatricesCodigosReemplazo(DTOEBuscarMatrizCodigosReemplazo dto): Salida");
        return dtoS;
    }

    private Long obtenerOIDCabecParaPeriodo(Long nOidCabeceraMF, Long nPeriodo) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.obtenerOIDCabecParaPeriodo(Long nOidCabeceraMF, Long nPeriodo): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            BelcorpService bs = BelcorpService.getInstance();
            buf.append(" select c2.OID_CABE from pre_matri_factu_cabec c, cra_perio per, pre_matri_factu_cabec c2, cra_perio per2 ");
            buf.append(" where c.PERD_OID_PERI = per.OID_PERI ");
            buf.append(" and c.OID_CABE = " + nOidCabeceraMF);
            buf.append(" and c2.PERD_OID_PERI = per2.OID_PERI ");
            buf.append(" and per2.OID_PERI = " + nPeriodo);
            buf.append(" AND per.marc_oid_marc = per2.marc_oid_marc  ");
            buf.append(" AND per.pais_oid_pais = per2.pais_oid_pais  ");
            buf.append(" AND per.cana_oid_cana = per2.cana_oid_cana  ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONFuncionesAdicionalesBean.obtenerOIDCabecParaPeriodo(Long nOidCabeceraMF, Long nPeriodo): Salida");
        return new Long(respuesta.getValueAt(0, 0).toString());
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException    
    * @return DTOSalida
    * @documentation
    */
    public DTOSalida obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONFuncionesAdicionalesBean.obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE): Entrada");
        
        PREConsultas preConsultas = new PREConsultas();
        UtilidadesLog.info("MONFuncionesAdicionalesBean.obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE): Salida");
        return preConsultas.obtenerTiposOfertaComisionablePorCanal(dtoE);
    }    
    
}
