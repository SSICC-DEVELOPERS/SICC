package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.dto.DTOBuscarMatricesDescuento;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOEMatrizAccesos;
import es.indra.sicc.dtos.dto.DTOEMatrizCanal;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTOEMatrizTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOEMatrizTiposCliente;
import es.indra.sicc.dtos.dto.DTOMatrizDescuento;
import es.indra.sicc.dtos.dto.DTOParametroAcceso;
import es.indra.sicc.dtos.dto.DTOParametroBoolean;
import es.indra.sicc.dtos.dto.DTOParametroCanal;
import es.indra.sicc.dtos.dto.DTOParametroClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroMarca;
import es.indra.sicc.dtos.dto.DTOParametroMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTOParametroNacional;
import es.indra.sicc.dtos.dto.DTOParametroSubacceso;
import es.indra.sicc.dtos.dto.DTOParametroSubtipoCliente;
import es.indra.sicc.dtos.dto.DTOParametroTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOParametroTipoCliente;
import es.indra.sicc.dtos.dto.DTOSCargarPaginaCrearMatrizDTO;
import es.indra.sicc.entidades.dto.CabeceraMatrizDescuentoLocal;
import es.indra.sicc.entidades.dto.CabeceraMatrizDescuentoLocalHome;
import es.indra.sicc.entidades.dto.DetalleMatrizDescuentoLocal;
import es.indra.sicc.entidades.dto.DetalleMatrizDescuentoLocalHome;
import es.indra.sicc.entidades.dto.ParametroAccesoLocalHome;
import es.indra.sicc.entidades.dto.ParametroBooleanLocalHome;
import es.indra.sicc.entidades.dto.ParametroCanalLocalHome;
import es.indra.sicc.entidades.dto.ParametroClasificacionLocalHome;
import es.indra.sicc.entidades.dto.ParametroMarcaLocalHome;
import es.indra.sicc.entidades.dto.ParametroNacionalLocalHome;
import es.indra.sicc.entidades.dto.ParametroSubaccesoLocalHome;
import es.indra.sicc.entidades.dto.ParametroSubtipoClienteLocalHome;
import es.indra.sicc.entidades.dto.ParametroTipoClasificacionLocalHome;
import es.indra.sicc.entidades.dto.ParametroTipoClienteLocalHome;
import es.indra.sicc.logicanegocio.dto.DAOMatrizDescuentos;
import es.indra.sicc.logicanegocio.dto.UtilidadesDTO;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoMatrizDescuentoBean implements SessionBean  {


/**
 *  Esta son las constantes correspondientes a los parametros 
 *  que utiliza la matris de descuentos.
 */

    public final static int CTE_NRO_DTO      = 0;
	public final static int CTE_NOM_DTO      = 1;
	public final static int CTE_IND_CUL      = 2;
	public final static int CTE_MARCA        = 3;
	public final static int CTE_CANAL        = 4;
	public final static int CTE_ACCESO       = 5;
	public final static int CTE_SUBACCESO    = 6;
	public final static int CTE_PERIO_I      = 7;	
	public final static int CTE_PERIO_F      = 8;
	public final static int CTE_TIPO_CLIEN 	 = 9;
	public final static int CTE_PORC_LC 	 = 10;
	public final static int CTE_DTO_CLIEN 	 = 11;
	public final static int CTE_ALCAN_ADM 	 = 12;
	public final static int CTE_PORC_ADM 	 = 13;
	public final static int CTE_BC_MARCA 	 = 14;
	public final static int CTE_BC_UNID_NEGO = 15;
	public final static int CTE_BC_NEGO 	 = 16;
	public final static int CTE_BC_SGENE 	 = 17;
	public final static int CTE_BC_GENE		 = 18;
	public final static int CTE_BC_PRODU 	 = 19;
	public final static int CTE_BA_MARCA 	 = 20;
	public final static int CTE_BA_UNID_NEGO = 21;
	public final static int CTE_BA_NEGO 	 = 22;
	public final static int CTE_BA_SGENE 	 = 23;
	public final static int CTE_BA_GENE		 = 24;
	public final static int CTE_BA_PRODU 	 = 25;
	public final static int CTE_CTRL_MORO	 = 26;	
	public final static int CTE_CTRL_DEV_ANU = 27;	
	public final static int CTE_CTRL_ACUM	 = 28;	
	public final static int CTE_AFECTA_FAC	 = 29;	
	public final static int CTE_AFEC_CTA_CTE = 30;
	public final static int CTE_COMU_PART 	 = 31;	

    private SessionContext ctx;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerMarcasDTOMatrizSeleccionada()
     */
    public DTOSalida obtenerMarcasDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerMarcasDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerMarcasDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerMarcasDTOMatrizSeleccionada(): Salida");
        return result;
    }

    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerAccesosPorCanalDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerAccesosPorCanalDTOMatrizSeleccionada(DTOEMatrizCanal dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerAccesosPorCanalDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerAccesosPorCanalDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerAccesosPorCanalDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerSubaccesosMultiaccesoDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerSubaccesosMultiAccesoDTOMatrizSeleccionada(DTOEMatrizAccesos dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubaccesosMultiAccesoDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerSubaccesosMultiaccesoDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubaccesosMultiAccesoDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerCanalesDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerCanalesDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerCanalesDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerCanalesDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerCanalesDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerTiposClienteDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerTiposClienteDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerTiposClienteDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerTiposClienteDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerTiposClienteDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(DTOEMatrizTiposCliente dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo una  llamada al metodo del DAOMatrizDescuentos.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada()
     * */
    public DTOSalida obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(DTOEMatrizSubtiposCliente dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(): Salida");
        return result;
    }


    /**
     *  Este metodo de acuerdo al DTOOID recupera de la BD la matriz correspondiente
     * */
    public DTODatosMatrizDescuentos consultarMatrizDescuentos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.consultarMatrizDescuentos(): Entrada");
        String codigoError = null;

        CabeceraMatrizDescuentoLocalHome home = null;
        CabeceraMatrizDescuentoLocal local = null;

        ArrayList listaParametros = new ArrayList();

        DTODatosMatrizDescuentos dtoDatosMatrizDescuentos = new DTODatosMatrizDescuentos();
        try  {
            UtilidadesLog.debug("Entro al try");
            home = new CabeceraMatrizDescuentoLocalHome();
            UtilidadesLog.debug("dto.getOid()  " + dto.getOid());
            local = home.findByPrimaryKey(dto.getOid());

            // Se recuperan los datos de la matriz
            UtilidadesLog.debug("Se trata de recuperar los datos de la matriz");
            dtoDatosMatrizDescuentos.setOidCabeceraMatriz(local.getOid());
            UtilidadesLog.debug("local.getOid() : " + local.getOid());
            dtoDatosMatrizDescuentos.setMatrizActiva(UtilidadesDTO.getBoole(local.getInd_matr_acti()));
            UtilidadesLog.debug("local.getEstado() : " + local.getInd_matr_acti());
            dtoDatosMatrizDescuentos.setObservaciones(local.getVal_obse());
            UtilidadesLog.debug("local.getObservaciones() " + local.getVal_obse());
            dtoDatosMatrizDescuentos.setOidPais(local.getPais_oid_pais());
            UtilidadesLog.debug("local.getObservaciones() " + local.getVal_obse());
            dtoDatosMatrizDescuentos.setDescripcion(UtilidadesDTO.recuperarTraducciones("DTO_MATRI_DESCU",local.getOid()));
            UtilidadesLog.debug("Se recuperan todos los parametros de la Matriz");
            // Se recuperan todos los parametros de la Matriz

            String aQuery = "SELECT p.OID_PARA_TIPO_DESC, p.PADT_OID_PARA, p.MDES_OID_TIPO_DESC, p.NUM_MAXI_VALO," +
            "   IND_VISU, p.IND_OBLI, p.IND_MODI, pa.COD_PARA " +
            "   FROM dto_param_tipo_descu p, dto_param pa " +             
            "   WHERE p.PADT_OID_PARA = pa.OID_PARA " + 
            "   AND p.mdes_oid_tipo_desc = " + dto.getOid();

            UtilidadesLog.debug("Voy a asignar el query");
            RecordSet datosParametros = UtilidadesDTO.getQuery(aQuery);
            UtilidadesLog.debug("Antes del For");
            for (int i=0;i< datosParametros.getRowCount();i++)  {
                UtilidadesLog.debug("nro " + i);
                DTOParametroMatrizDescuentos dtoParametroMatrizDescuentos = new DTOParametroMatrizDescuentos();                        
                UtilidadesLog.debug("datosParametros " + datosParametros );                
                UtilidadesLog.debug("datosParametros.getValueAt(i,1) " + datosParametros.getValueAt(i,1));
                //<inicio>modificado por Sapaza, cambiamos para obtener el codigo de parametro en vez del oid parametro
                int codigoParametro = new Integer(datosParametros.getValueAt(i,7).toString()).intValue();                     
                //<fin>
                UtilidadesLog.debug("codigoParametro " + codigoParametro);
                dtoParametroMatrizDescuentos.setOidParametro(new Long(codigoParametro));
                UtilidadesLog.debug("datosParametros.getValueAt(i,0) " + datosParametros.getValueAt(i,0));
                dtoParametroMatrizDescuentos.setOidDetalleMatrizDescuento(UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)));
                UtilidadesLog.debug("datosParametros.getValueAt(i,3) " + datosParametros.getValueAt(i,3));
                if(datosParametros.getValueAt(i,3) != null){
                    dtoParametroMatrizDescuentos.setNumeroMaximoValores(UtilidadesDTO.getInteger(datosParametros.getValueAt(i,3)));        
                }
                UtilidadesLog.debug("datosParametros.getValueAt(i,4) " + datosParametros.getValueAt(i,4));
                dtoParametroMatrizDescuentos.setVisible(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(datosParametros.getValueAt(i,4))));                
                UtilidadesLog.debug("datosParametros.getValueAt(i,5) " + datosParametros.getValueAt(i,5));
                dtoParametroMatrizDescuentos.setObligatorio(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(datosParametros.getValueAt(i,5))));     
                UtilidadesLog.debug("datosParametros.getValueAt(i,6) " + datosParametros.getValueAt(i,6));
                dtoParametroMatrizDescuentos.setModificable(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(datosParametros.getValueAt(i,6))));  
                UtilidadesLog.debug("dtoParametroMatrizDescuentos" + dtoParametroMatrizDescuentos);
                ArrayList valoresPosibles = new ArrayList();
                ArrayList valoresPosibles2 = new ArrayList();
                
                if ((codigoParametro == CTE_NRO_DTO) ||
                   (codigoParametro == CTE_NOM_DTO)){
                   }

                if (codigoParametro == CTE_IND_CUL){


                }
                   
                if (codigoParametro == CTE_MARCA)  {

                    String sQuery = "SELECT OID_VALO_PARA_MARC, MARC_OID_MARC, IND_VALO_DEFE, PTDT_PARA_TIPO_DESC , seg.des_marc, seg.COD_MARC " + 
                    " FROM dto_valor_param_marca m, seg_marca seg " + 
                    " WHERE m.ptdt_para_tipo_desc = " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)) + 
                    " AND seg.oid_marc = m.marc_oid_marc " +
					" ORDER BY seg.des_marc "  ; 
                    UtilidadesLog.debug("Antes de asignar al recordset");
                    RecordSet r = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0;j<r.getRowCount();j++)  {
                        UtilidadesLog.debug("index: " + j);
                        DTOParametroMarca dtoPrmMarca = new DTOParametroMarca();                  
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,4));
                        dtoPrmMarca.setDescripcion((String) r.getValueAt(j,4));
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,0));
                        dtoPrmMarca.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));     
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,1));
                        dtoPrmMarca.setOidMarca(UtilidadesDTO.getLong(r.getValueAt(j,1)));   
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,2));
                        dtoPrmMarca.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,2))));   
                        dtoPrmMarca.setCodigo(r.getValueAt(j,5).toString());
                        UtilidadesLog.debug("dtoPrmMarca" + dtoPrmMarca);
                        valoresPosibles.add(dtoPrmMarca);
                    }

                }
                
                if (codigoParametro == CTE_CANAL)  {                        
                    String sQuery = " SELECT OID_VALO_PARA_CANA, CANA_OID_CANA,PTDT_PARA_TIPO_DESC, IND_VALO_DEFE , v.val_i18n, sc.COD_CANA  "+
                    "  FROM dto_valor_param_canal c , v_gen_i18n_sicc v, SEG_CANAL sc " + 
                    " WHERE c.ptdt_PARA_TIPO_DESC = " +   UtilidadesDTO.getLong(datosParametros.getValueAt(i,0))  +
                    "   AND v.attr_enti = 'SEG_CANAL' " +
                    "   AND v.val_oid = c.cana_oid_cana " +
                    "   AND v.idio_oid_idio =  " + dto.getOidIdioma() +
                    "   AND v.attr_num_atri = 1  " +
                    "   AND sc.OID_CANA = c.CANA_OID_CANA " +
					" ORDER BY v.val_i18n "  ; 

                    RecordSet r = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0;j<r.getRowCount();j++){
                        DTOParametroCanal dtoPrmCanal = new DTOParametroCanal();                    

                        dtoPrmCanal.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r.getValueAt(j,0));                        
                        dtoPrmCanal.setCodigo(r.getValueAt(j,5).toString()); // 
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,2));                        
                        dtoPrmCanal.setOidCanal(UtilidadesDTO.getLong(r.getValueAt(j,1)));      
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r.getValueAt(j,4));                        
                        dtoPrmCanal.setDescripcion((String)r.getValueAt(j,4));
                        dtoPrmCanal.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,3))));   
                        valoresPosibles.add(dtoPrmCanal);
                    }
                }

                if (codigoParametro == CTE_ACCESO)  {
                    String sQuery = " SELECT OID_VALO_PARA_ACCE, ACCE_OID_ACCE, IND_VALO_DEFE ,PTDT_PARA_TIPO_DESC,   sa.COD_ACCE, v.VAL_I18N, sa.CANA_OID_CANA  " + 
                    "  FROM dto_valor_param_acces a, seg_acces sa, v_gen_i18n_sicc v  " + 
                    " WHERE a.ptdt_PARA_TIPO_DESC =  " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)) +
                    "   AND a.ACCE_OID_ACCE = sa.OID_ACCE  " +
                    "   AND v.VAL_OID = a.ACCE_OID_ACCE  " +
                    "   AND v.ATTR_ENTI = 'SEG_ACCES' " +
                    "   AND v.IDIO_OID_IDIO =  " + dto.getOidIdioma() + 
                    "   AND v.ATTR_NUM_ATRI = 1 " +
					" ORDER BY v.val_i18n "  ; 
                    RecordSet r = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0; j<r.getRowCount(); j++)  {
                        DTOParametroAcceso dtoPrmAcceso = new DTOParametroAcceso();                    
                        dtoPrmAcceso.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,1));                        
                        dtoPrmAcceso.setOidAcceso(UtilidadesDTO.getLong(r.getValueAt(j,1)));
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r.getValueAt(j,2));                        
                        dtoPrmAcceso.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,2))));     
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,4));                        
                        dtoPrmAcceso.setCodigoAcceso((String)r.getValueAt(j,4)); 
                        UtilidadesLog.debug("r.getValueAt(j,5)" + r.getValueAt(j,5));                        
                        dtoPrmAcceso.setDescripcion((String)r.getValueAt(j,5));  
                        UtilidadesLog.debug("r.getValueAt(j,6)" + r.getValueAt(j,6));                        
                        dtoPrmAcceso.setOidCanal(UtilidadesDTO.getLong(r.getValueAt(j,6)));    
                        UtilidadesLog.debug("dtoPrmAcceso" + dtoPrmAcceso);                        
                        valoresPosibles.add(dtoPrmAcceso);
                    }
                    
                }


                if (codigoParametro == CTE_SUBACCESO)  {                        
                    String sQuery = " SELECT SBAC_OID_SBAC,SBAC_OID_SBAC,  IND_VALO_DEFE, PTDT_PARA_TIPO_DESC, segsa.acce_oid_acce, segsa.cod_sbac, " + 
                    "        v.val_i18n, sega.cana_oid_cana " + 
                    "   FROM dto_valor_param_subac sa, seg_subac segsa, seg_acces sega, v_gen_i18n_sicc v " +
                    "  WHERE sa.ptdt_PARA_TIPO_DESC = " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0))    + 
                    "    AND segsa.oid_sbac = sa.sbac_oid_sbac " + 
                    "    AND segsa.acce_oid_acce = sega.oid_acce  " + 
                    "    AND v.attr_enti = 'SEG_SUBAC' " +
                    "    AND v.idio_oid_idio = " + dto.getOidIdioma() + 
                    "    AND v.val_oid = sa.sbac_oid_sbac " +
                    "    AND v.attr_num_atri = 1 " +
					" ORDER BY v.val_i18n "  ; 
                    
                    RecordSet r = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0; j<r.getRowCount(); j++)  {                   
                        DTOParametroSubacceso dtoPrmSubacceso = new DTOParametroSubacceso();  
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r.getValueAt(j,0));
                        dtoPrmSubacceso.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0))); 
                        UtilidadesLog.debug("r.getValueAt(j,1)" + r.getValueAt(j,1));
                        dtoPrmSubacceso.setOidSubacceso(UtilidadesDTO.getLong(r.getValueAt(j,1)));
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r.getValueAt(j,2));
                        dtoPrmSubacceso.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,2))));   
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,4));
                        dtoPrmSubacceso.setOidAcceso(UtilidadesDTO.getLong(r.getValueAt(j,4)));    
                        UtilidadesLog.debug("r.getValueAt(j,5)" + r.getValueAt(j,5));
                        dtoPrmSubacceso.setCodigoSubacceso((String)r.getValueAt(j,5)); 
                        
                        dtoPrmSubacceso.setDescripcionSubacceso((String)r.getValueAt(j,6));
                        dtoPrmSubacceso.setOidCanal(UtilidadesDTO.getLong(r.getValueAt(j,7)));     
                        valoresPosibles.add(dtoPrmSubacceso);
                    }
                }


                if (codigoParametro == CTE_TIPO_CLIEN)  {                        
                    String sQuery = "   SELECT OID_VALO_PARA_TIPO_CLIE, PTDT_OID_PARA_TIPO_DESC, TICL_OID_TIPO_CLIE, IND_VALO_DEFE, v.val_i18n  " +
                    "    FROM dto_valor_param_tipo_clien tc, v_gen_i18n_sicc v " +
                    "   WHERE tc.ptdt_oid_para_tipo_desc = " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)) +
                    "     AND tc.ticl_oid_tipo_clie = v.val_oid  " +
                    "     AND v.attr_enti = 'MAE_TIPO_CLIEN' " +
                    "     AND v.attr_num_atri = 1  " +
                    "     AND v.idio_oid_idio = " + dto.getOidIdioma() +
				    " ORDER BY v.val_i18n "  ; 

                    RecordSet r1 = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0; j<r1.getRowCount(); j++)  {
                        DTOParametroTipoCliente dtoPrmCliente = new DTOParametroTipoCliente();
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r1.getValueAt(j,0));
                        dtoPrmCliente.setOid(UtilidadesDTO.getLong(r1.getValueAt(j,0)));    
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r1.getValueAt(j,2));
                        dtoPrmCliente.setOidTipoCliente(UtilidadesDTO.getLong(r1.getValueAt(j,2)));   
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r1.getValueAt(j,3));
                        dtoPrmCliente.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r1.getValueAt(j,3))));     
                        UtilidadesLog.debug("r.getValueAt(j,6)" + r1.getValueAt(j,4));
                        dtoPrmCliente.setDescripcion((String)r1.getValueAt(j,4));
                        valoresPosibles.add(dtoPrmCliente);
                    }

                    sQuery = "  SELECT OID_VALO_PARA_SUBT_CLIE, SBTI_OID_SUBT_CLIE, IND_VALO_DEFE, PTDT_PARA_TIPO_DESC, v.val_i18n, msc.ticl_oid_tipo_clie  " + 
                    "  FROM dto_valor_param_subti_clien stc, v_gen_i18n_sicc v,  " +
                    "       mae_subti_clien msc  "  +
                    " WHERE stc.ptdt_para_tipo_desc = " +  UtilidadesDTO.getLong(datosParametros.getValueAt(i,0))  +
                    "   AND msc.oid_subt_clie = stc.sbti_oid_subt_clie " + 
                    "   AND v.val_oid = stc.sbti_oid_subt_clie   " +
                    "   AND v.idio_oid_idio = " +  dto.getOidIdioma() +
                    "   AND v.attr_enti = 'MAE_SUBTI_CLIEN' " + 
                    "   AND v.attr_num_atri = 1 " + 
					" ORDER BY v.val_i18n "  ; 
                    
                    RecordSet r2 = UtilidadesDTO.getQuery(sQuery);

                    for (int j=0; j<r2.getRowCount(); j++)  {
                        DTOParametroSubtipoCliente dtoPrmSubtiCliente = new DTOParametroSubtipoCliente();
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r2.getValueAt(j,0));
                        dtoPrmSubtiCliente.setOid(UtilidadesDTO.getLong(r2.getValueAt(j,0)));   
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r2.getValueAt(j,1));
                        dtoPrmSubtiCliente.setOidSubtipoCliente(UtilidadesDTO.getLong(r2.getValueAt(j,1)));    
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r2.getValueAt(j,3));
                        dtoPrmSubtiCliente.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r2.getValueAt(j,2))));    
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r2.getValueAt(j,4));
                        dtoPrmSubtiCliente.setDescripcion((String)r2.getValueAt(j,4));
                        UtilidadesLog.debug("r.getValueAt(j,5)" + r2.getValueAt(j,5));
                        dtoPrmSubtiCliente.setOidTipoCliente(UtilidadesDTO.getLong(r2.getValueAt(j,5)));
                        valoresPosibles2.add(dtoPrmSubtiCliente);
                    }
                    
                }

                if (codigoParametro == CTE_PORC_LC)  {
              String sQuery = "SELECT OID_VALO_PARM_TIPO_CLAS, PTDT_OID_PARA_TIPO_DESC, TCCL_OID_TIPO_CLAS, IND_VALOR_DEFECTO, mc.SBTI_OID_SUBT_CLIE   ,v.val_i18n " +
                "    FROM dto_valor_param_TIPO_clasi c, v_gen_i18n_sicc v, mae_TIPO_clasi_CLIEN mc  " +
                " WHERE c.PTDT_OID_PARA_TIPO_DESC = "  + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)) + 
                "   AND c.TCCL_OID_TIPO_CLAS = mc.OID_TIPO_CLAS " +
                "   AND c.TCCL_OID_TIPO_CLAS = v.val_oid " + 
                "   AND v.idio_oid_idio = " + dto.getOidIdioma() +
                "   AND v.attr_enti = 'MAE_TIPO_CLASI_CLIEN' " + 
                "  AND v.attr_num_atri = 1 " + 
				" ORDER BY v.val_i18n "  ; 
                  RecordSet r = UtilidadesDTO.getQuery(sQuery);
                    
                    for (int j=0; j< r.getRowCount(); j++)  {
                        DTOParametroTipoClasificacion dtoPrmTClasificacion = new DTOParametroTipoClasificacion();
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r.getValueAt(j,0));
                        dtoPrmTClasificacion.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,2));
                        dtoPrmTClasificacion.setOidTipoClasificacion(UtilidadesDTO.getLong(r.getValueAt(j,2)));
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r.getValueAt(j,3));
                        dtoPrmTClasificacion.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,3))));
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,4));
                        dtoPrmTClasificacion.setOidSubtipoCliente(UtilidadesDTO.getLong(r.getValueAt(j,4)));
                        UtilidadesLog.debug("r.getValueAt(j,5)" + r.getValueAt(j,5));
                        dtoPrmTClasificacion.setDescripcionTipoClasificacion((String) r.getValueAt(j,5));
                        valoresPosibles.add(dtoPrmTClasificacion);
                    }


                 sQuery = " SELECT OID_VALO_PARA_CLAS, CLAS_OID_CLAS, IND_VALO_DEFE, PTDT_PARA_TIPO_DESC, mc.tccl_oid_tipo_clas, v.val_i18n " + 
                    "    FROM dto_valor_param_clasi c, v_gen_i18n_sicc v, mae_clasi mc  " +
                    " WHERE c.ptdt_PARA_TIPO_DESC = " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0)) + 
                    "   AND c.clas_oid_clas = mc.oid_clas " +
                    "   AND c.clas_oid_clas = v.val_oid " +
                    "   AND v.idio_oid_idio = " + dto.getOidIdioma() +
                    "   AND v.attr_enti = 'MAE_CLASI' " +
                    "   AND v.attr_num_atri = 1 " +
					" ORDER BY v.val_i18n "  ; 

                    r = UtilidadesDTO.getQuery(sQuery);
                    
                    for (int j=0; j< r.getRowCount(); j++)  {
                        DTOParametroClasificacion dtoPrmClasificacion = new DTOParametroClasificacion();
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r.getValueAt(j,0));
                        dtoPrmClasificacion.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));
                        UtilidadesLog.debug("r.getValueAt(j,1)" + r.getValueAt(j,1));
                        dtoPrmClasificacion.setOidClasificacion(UtilidadesDTO.getLong(r.getValueAt(j,1)));
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,2));
                        dtoPrmClasificacion.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,2))));
                        UtilidadesLog.debug("r.getValueAt(j,4)" + r.getValueAt(j,4));
                        dtoPrmClasificacion.setOidTipoClasificacion(UtilidadesDTO.getLong(r.getValueAt(j,4)));
                        UtilidadesLog.debug("r.getValueAt(j,5)" + r.getValueAt(j,5));
                        dtoPrmClasificacion.setDescripcionClasificacion((String) r.getValueAt(j,5));
                        valoresPosibles2.add(dtoPrmClasificacion);
                    }
                
                }

                if (codigoParametro == CTE_ALCAN_ADM)  {               
                    String sQuery = " SELECT OID_VALO_PARA_NNAL, IND_VALO_DEFE, VAL_PARA, PTDT_PARA_TIPO_DESC " + 
					"FROM dto_valor_param_nacio n " +
					" WHERE n.ptdt_PARA_TIPO_DESC = " + UtilidadesDTO.getLong(datosParametros.getValueAt(i,0));
                    RecordSet r = UtilidadesDTO.getQuery(sQuery);


                    for (int j=0; j<r.getRowCount(); j++)  {
                        DTOParametroNacional dtoPrmNacional = new DTOParametroNacional();  
                        UtilidadesLog.debug("r.getValueAt(j,6)" + r.getValueAt(j,0));
                        dtoPrmNacional.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));   
                        UtilidadesLog.debug("r.getValueAt(j,)" + r.getValueAt(j,2));
                        dtoPrmNacional.setValor((String) r.getValueAt(j,2));  
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,2));
                        dtoPrmNacional.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,1))));    
                        valoresPosibles.add(dtoPrmNacional);                        
                    }                    
                }

                    if ((codigoParametro == CTE_DTO_CLIEN) ||
                    (codigoParametro == CTE_PORC_ADM) ||
                    (codigoParametro == CTE_BC_MARCA) ||
                    (codigoParametro == CTE_BC_UNID_NEGO) ||
                    (codigoParametro == CTE_BC_NEGO) ||
                    (codigoParametro == CTE_BC_SGENE) ||
                    (codigoParametro == CTE_BC_GENE) ||
                    (codigoParametro == CTE_BC_PRODU) ||
                    (codigoParametro == CTE_BA_MARCA) ||
                    (codigoParametro == CTE_BA_UNID_NEGO) ||
                    (codigoParametro == CTE_BA_NEGO) ||
                    (codigoParametro == CTE_BA_SGENE) ||
                    (codigoParametro == CTE_BA_GENE) ||
                    (codigoParametro == CTE_BA_PRODU)){

                    }

                if  ((codigoParametro == CTE_CTRL_MORO) ||
                    (codigoParametro == CTE_CTRL_DEV_ANU) ||
                    (codigoParametro == CTE_CTRL_ACUM) ||
                    (codigoParametro == CTE_AFECTA_FAC) ||
                    (codigoParametro == CTE_AFEC_CTA_CTE) ||
                    (codigoParametro == CTE_COMU_PART) || 
                    (codigoParametro == CTE_IND_CUL))  {                        

                    String sQuery = " SELECT OID_VALO_PARA_BOOL,IND_VALO_DEFE, VAL_PARA, PTDT_PARA_TIPO_DESC " +
						" FROM dto_valor_param_boole b "+
						"WHERE b.ptdt_PARA_TIPO_DESC = " +  UtilidadesDTO.getLong(datosParametros.getValueAt(i,0));

                    RecordSet r = UtilidadesDTO.getQuery(sQuery);
                    for (int j=0; j<r.getRowCount(); j++)  {
                        DTOParametroBoolean dtoPrmBoolean = new DTOParametroBoolean();
                        UtilidadesLog.debug("r.getValueAt(j,0)" + r.getValueAt(j,0));
                        dtoPrmBoolean.setOid(UtilidadesDTO.getLong(r.getValueAt(j,0)));  
                        UtilidadesLog.debug("r.getValueAt(j,3)" + r.getValueAt(j,2));
                        dtoPrmBoolean.setValor(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,2))));
                        UtilidadesLog.debug("r.getValueAt(j,2)" + r.getValueAt(j,1));
                        dtoPrmBoolean.setValorPorDefecto(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(r.getValueAt(j,1))));
                        valoresPosibles.add(dtoPrmBoolean);
                    }                  
                }    
                UtilidadesLog.debug("valoresPosibles " + valoresPosibles);
               dtoParametroMatrizDescuentos.setListaVariablesPosibles(valoresPosibles);
               dtoParametroMatrizDescuentos.setListaVariablesPosibles2(valoresPosibles2);               
               listaParametros.add(dtoParametroMatrizDescuentos);
            }
        } catch (NoResultException ex)  {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex,UtilidadesError.armarCodigoError(codigoError));                
        }
        dtoDatosMatrizDescuentos.setListaParametros(listaParametros);  
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.consultarMatrizDescuentos(): Salida");
        return dtoDatosMatrizDescuentos;
    }
    


    /**
     *  Crea una matriz nueva de a cuerdo a todos los datos contenidos en el 
     *  DTODatosMatrizDescuentos que recibe como parametro
     * 
     **/
    public void crearMatrizDescuentos(DTODatosMatrizDescuentos dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.crearMatrizDescuentos(): Entrada");
        CabeceraMatrizDescuentoLocal cabecMatrLocal = null;
        CabeceraMatrizDescuentoLocalHome  cabecMatrHome = null;
        DetalleMatrizDescuentoLocal detMatrizLocal = null;
        DetalleMatrizDescuentoLocalHome detMatrizHome = null;
        Vector listaParametros = null;
        Long oidMatrizDTO = null;
        Boolean vModificable = null;
        Boolean vVisible = null;
        Boolean vObligatorio = null;
        Long oidParam = null;
        String codigoError;
        
        DTOParametroMatrizDescuentos parametroActual = new DTOParametroMatrizDescuentos();

        //<inicio> agregado por Sapaza, para recuperar los oids de los parametros de descuento
        Long oidDTOParam = null;
        Map mapParamDcto = new HashMap();

        DTOSalida dtoParametros = cargarParametrosMatrizDescuento();
        RecordSet rs = dtoParametros.getResultado();
        int lon = rs.getRowCount();
        
        for (int i = 0 ;i < lon ;i++ )  {
            mapParamDcto.put(rs.getValueAt(i,0).toString(),UtilidadesDTO.getLong(rs.getValueAt(i,1)));
        }    
        //<fin>

        if (dto.getOidCabeceraMatriz() != null && !dto.getOidCabeceraMatriz().equals("") ){
            try{
                // Caso modificar   
                cabecMatrHome = new CabeceraMatrizDescuentoLocalHome();
                cabecMatrLocal = cabecMatrHome.findByPrimaryKey(dto.getOidCabeceraMatriz());     
                
                cabecMatrLocal.setVal_obse(dto.getObservaciones());
                cabecMatrLocal.setPais_oid_pais(dto.getOidPais());
                cabecMatrLocal.setInd_matr_acti(UtilidadesDTO.getLong(dto.getMatrizActiva()));
                cabecMatrHome.merge(cabecMatrLocal);

                UtilidadesDTO.insertarTraducciones("DTO_MATRI_DESCU", cabecMatrLocal.getOid() ,dto.getDescripcion(),ctx);

                // Me puedo basar en listaParametros para borrar el detalle o buscar en la base.
                // Voy a buscar en la base para abstraerme del DTO de entrada
                 detMatrizHome = new DetalleMatrizDescuentoLocalHome();
                 // Elimino todos los registros de la tabla de detalle asociados a la matriz en cuestion
//                 Collection detalles = detMatrizHome.findByOidMatriz(  cabecMatrLocal.getOid());
//                 Iterator iter = detalles.iterator();
//                 //UtilidadesLog.debug("Objeto  " + iter.next());
//                 while(iter.hasNext()){
//                    Long detOid = ((DetalleMatrizDescuentoLocal)iter.next()).getOid();
//                    UtilidadesLog.debug("Detalle OID " + detOid );
//                    detMatrizHome.remove(detOid);
//                 }
    
                    // Manejo de detalle de la matriz
                listaParametros = new Vector(dto.getListaParametros());
                 UtilidadesLog.debug(listaParametros);
                 for (int i=0; i< listaParametros.size();i++)  {
                    parametroActual = (DTOParametroMatrizDescuentos)listaParametros.get(i);
                    oidDTOParam =(Long) mapParamDcto.get(parametroActual.getOidParametro().toString());    
                    detMatrizHome.remove(detMatrizHome.findByClaveUnica(oidDTOParam, cabecMatrLocal.getOid() ));
 
                 }
                 



                
                for (int i=0; i< listaParametros.size();i++)  {
                        parametroActual = (DTOParametroMatrizDescuentos) listaParametros.get(i);
                        Long oidDetalle  = parametroActual.getOidDetalleMatrizDescuento();
                        oidMatrizDTO = cabecMatrLocal.getOid();
                        oidParam = parametroActual.getOidParametro();
                        oidDTOParam =(Long) mapParamDcto.get(parametroActual.getOidParametro().toString());    
                        UtilidadesLog.debug("actual modificable: "+parametroActual.getModificable());
                        UtilidadesLog.debug("actual visible: "+parametroActual.getVisible());
                        UtilidadesLog.debug("actual obligatorio: "+parametroActual.getObligatorio());                
                        vModificable = parametroActual.getModificable();
                        vVisible = parametroActual.getVisible();
                        vObligatorio = parametroActual.getObligatorio();

                        
                        // Borro y creo el detalle     
                        UtilidadesLog.debug("parametroActual : " + parametroActual);
                        UtilidadesLog.debug("parametroActual.getOidDetalleMatrizDescuento() : " + parametroActual.getOidDetalleMatrizDescuento());

                        detMatrizLocal = detMatrizHome.create(oidDTOParam,oidMatrizDTO,UtilidadesDTO.getLong(vVisible),UtilidadesDTO.getLong(vObligatorio),UtilidadesDTO.getLong(vModificable));
        
                        UtilidadesLog.debug("se creo el parametro...");
        
                        if (parametroActual.getNumeroMaximoValores() == null)  {
                            detMatrizLocal.setNum_maxi_valo(null);                    
                        }else{
                            detMatrizLocal.setNum_maxi_valo(new Long(parametroActual.getNumeroMaximoValores().toString()));
                        }
                        detMatrizHome.merge(detMatrizLocal);

                        UtilidadesLog.debug("antes de crearValoresParametros");
                        //eliminoValoresParametros(oidParam, parametroActual.getListaValoresPosibles(),parametroActual.getListaValoresPosibles2());
                        UtilidadesLog.debug("Parametro " + oidParam  + "  - Valores Posibles " + parametroActual.getListaValoresPosibles() );
                        crearValoresParametros(oidParam,detMatrizLocal.getOid(),parametroActual.getListaValoresPosibles(),parametroActual.getListaValoresPosibles2());
                }

                
            }catch (PersistenceException ex){
                    UtilidadesLog.error(ex);
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(ex,UtilidadesError.armarCodigoError(codigoError));        
            }catch (MareException me){
                    UtilidadesLog.error(me);
                    ctx.setRollbackOnly();
                    throw me;
            }                 
        }else{

            try{
                cabecMatrHome = new CabeceraMatrizDescuentoLocalHome();
                cabecMatrLocal = cabecMatrHome.create(UtilidadesDTO.getLong(dto.getMatrizActiva()),dto.getOidPais());        
                cabecMatrLocal.setVal_obse(dto.getObservaciones());
                cabecMatrHome.merge(cabecMatrLocal);

                UtilidadesLog.debug("Las descripciones son: " + dto.getDescripcion());
                UtilidadesLog.debug("Lista Parametros: "+dto.getListaParametros());
                UtilidadesDTO.insertarTraducciones("DTO_MATRI_DESCU",cabecMatrLocal.getOid(),dto.getDescripcion(),ctx);
                UtilidadesLog.debug("insertó traducciones");
                listaParametros = new Vector(dto.getListaParametros());
                UtilidadesLog.debug("antes del for");
                for (int i=0; i< listaParametros.size();i++)  {
                    parametroActual = (DTOParametroMatrizDescuentos) listaParametros.get(i);

                    UtilidadesLog.debug("parametro actual: "+ parametroActual.getOidParametro());
                    oidMatrizDTO = cabecMatrLocal.getOid();
                    oidParam = parametroActual.getOidParametro();
                    oidDTOParam =(Long) mapParamDcto.get(parametroActual.getOidParametro().toString());    
                    UtilidadesLog.debug("actual modificable: "+parametroActual.getModificable());
                    UtilidadesLog.debug("actual visible: "+parametroActual.getVisible());
                    UtilidadesLog.debug("actual obligatorio: "+parametroActual.getObligatorio());                
                    vModificable = parametroActual.getModificable();
                    vVisible = parametroActual.getVisible();
                    vObligatorio = parametroActual.getObligatorio();

                    detMatrizHome = new DetalleMatrizDescuentoLocalHome();
                    detMatrizLocal = detMatrizHome.create(oidDTOParam,oidMatrizDTO,UtilidadesDTO.getLong(vVisible),UtilidadesDTO.getLong(vObligatorio),UtilidadesDTO.getLong(vModificable));
                                    
                    UtilidadesLog.debug("se creo el parametro...");
                    if (parametroActual.getNumeroMaximoValores() == null)  {
                        detMatrizLocal.setNum_maxi_valo(null);                    
                    }else{
                        detMatrizLocal.setNum_maxi_valo(new Long(parametroActual.getNumeroMaximoValores().toString()));
                    }
                    detMatrizHome.merge(detMatrizLocal);
                
                    UtilidadesLog.debug("antes de crearValoresParametros");
                    crearValoresParametros(oidParam,detMatrizLocal.getOid(),parametroActual.getListaValoresPosibles(),parametroActual.getListaValoresPosibles2());
                }
            
            }catch (PersistenceException ex){
                    UtilidadesLog.error(ex);
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(ex,UtilidadesError.armarCodigoError(codigoError));        
                    
            }catch (MareException me){
                    UtilidadesLog.error(me);
                    ctx.setRollbackOnly();
                    throw me;
            }
        }
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.crearMatrizDescuentos(): Salida");
    }

// -------------------------------------------------------------------------------------------------------


    /**
     * Elimina una matriz de descuentos por cada oid de entrada.
     * Elimina en cascada todos los registros relacionados de la entidad "DetalleMatrizDescuento".
     */
    public void eliminarMatrizDescuentos(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.eliminarMatrizDescuentos(): Entrada");
        CabeceraMatrizDescuentoLocal cabecMatrLocal = null;
        CabeceraMatrizDescuentoLocalHome  cabecMatrHome = null;
        Long[] vOids = null;

        try  {
            cabecMatrHome = new CabeceraMatrizDescuentoLocalHome();

            vOids = dto.getOids();

            //(1)Para cada oid del dto de entrada
            for (int i=0; i<vOids.length; i++)  {
                //-> Hacer un "remove", deberán borrarse en cascada todos los registros relacionados de la
                //entidad "DetalleMatrizDescuento" y a su vez todos los registros relacionados en cada entidad de
                //valores posibles de parámetros. (Cascada provisto por BBDD)
                UtilidadesDTO.eliminarTraducciones("DTO_MATRI_DESCU",new Long(1),vOids[i]);
                cabecMatrLocal = cabecMatrHome.findByPrimaryKey(vOids[i]);
                cabecMatrHome.remove(cabecMatrLocal);            
            }            
        } catch (NoResultException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex)  {
            // -> Controlar si al borrar el registro no puede borrarse por que está relacionado con un descuento
            // (error de integridad)
            // (2)Si la matriz está relacionada entonces
            // -> Lanzar MareException con código de error "DTO-0020"
            UtilidadesLog.debug(" RemoveException --> MATRIZ_DE_DESCUENTO_EN_USO ");
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            /*El container no le da pelota a este manejo de exepcion, entonces lo manejo en parte cliente.*/
            throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_DTO , "",
                            ErroresDeNegocio.MATRIZ_DE_DESCUENTO_EN_USO));
        } catch (Exception ex)  {
            UtilidadesLog.debug(" EXCEPTION --> MATRIZ_DE_DESCUENTO_EN_USO ");
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            /*El container no le da pelota a este manejo de exepcion, entonces lo manejo en parte cliente.*/
            throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_DTO , "",
                            ErroresDeNegocio.MATRIZ_DE_DESCUENTO_EN_USO));
        }
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.eliminarMatrizDescuentos(): Salida");
    }


    public void copiarMatrizDescuentos(DTOMatrizDescuento dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.eliminarMatrizDescuentos(): Entrada");

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(dto.getOidCabeceraMatriz());
        dtoOid.setOidIdioma(dto.getOidIdioma());
        
        DTODatosMatrizDescuentos dtoConsulta = consultarMatrizDescuentos(dtoOid);
        //Actualizo la descripcion.
        dtoConsulta.setDescripcion(dto.getDescripcion());
        dtoConsulta.setOidIdioma(dto.getOidIdioma());
        //Creo la copia.
        dtoConsulta.setOidCabeceraMatriz(null);
        this.crearMatrizDescuentos(dtoConsulta);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.eliminarMatrizDescuentos(): Salida");
    }


    public DTOSalida buscarMatricesDescuento(DTOBuscarMatricesDescuento dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.buscarMatricesDescuento(): Entrada");

        /*
        Entrada: DTOBuscarMatricesDescuento 
        Proceso: 
        -> Se realiza consulta JDBC sobre la tabla DTO_MATRI_DESCU, tomando los atributos del dto de 
        entrada para filtrar, y recuperando la descripción en el idioma del usuario activo de la 
        tabla GEN_I18N_SICC. Se recuperan los campos: OID_TIPO_DESC (oid de cabecera de matriz), 
        VAL_OBSE (Observaciones), IND_MATR_ACTI (Indicador de matriz activa) y la descripción internacionalizada.
    
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 
    
        -> Devolver RecordSet obtenido en DTOSalida.
         * */

        String sQuery = " SELECT dtom.oid_tipo_desc OID, v.val_i18n, dtom.val_obse, dtom.ind_matr_acti " +
        "   FROM dto_matri_descu dtom, v_gen_i18n_sicc v  " +
        "   WHERE v.attr_enti = 'DTO_MATRI_DESCU' " +
        "     AND v.val_oid = dtom.oid_tipo_desc " +
        "     AND v.attr_num_atri = 1  " +
        "     AND v.idio_oid_idio = " + dto.getOidIdioma(); 
        
        if (dto.getMatrizActiva() != null)  {            
            sQuery += "   AND dtom.ind_matr_acti = " + UtilidadesDTO.getLong(dto.getMatrizActiva());
        }

        if (dto.getDescripcionMatriz() != null)  {
            sQuery += "     AND v.val_i18n LIKE '" + dto.getDescripcionMatriz() + "'  " ;
        }
        
        sQuery += "  order by 1 " ;        

    

        String sql = UtilidadesPaginacion.armarQueryPaginacion(sQuery,dto);

        RecordSet r = UtilidadesDTO.getQuery(sql);
        if( r.esVacio() ){
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
        }
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(r);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.buscarMatricesDescuento(): Salida");
        return dtoSalida;
    }


    public DTOSalida cargarParametrosMatrizDescuento() throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.cargarParametrosMatrizDescuento(): Entrada");
        DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
        DTOSalida result = dao.obtenerDatosParametros();
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.cargarParametrosMatrizDescuento(): Salida");
        return result;
    }

    public DTOSalida compruebaDescuentosAsociados(Integer oidCabeceraMatriz) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.compruebaDescuentosAsociados(): Entrada");
        String sQuery = " SELECT  *  " +
        "    FROM dto_param_tipo_descu dtop  " +
        "   WHERE dtop.mdes_oid_tipo_desc = " + oidCabeceraMatriz +
        " ORDER BY dtop.oid_para_tipo_desc ";

        RecordSet r = UtilidadesDTO.getQuery(sQuery);

        DTOSalida output = new DTOSalida();
        output.setResultado(r);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.compruebaDescuentosAsociados(): Salida");
        return output;
    }


    private void crearValoresParametros(Long oidParam, Long oidDetalleMatriz, ArrayList valoresPosibles, ArrayList valoresPosibles2) throws MareException, PersistenceException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.crearValoresParametros(): Entrada");
        ParametroMarcaLocalHome paramMarcaLocalHome;
        ParametroCanalLocalHome paramCanalLocalHome;
        ParametroAccesoLocalHome paramAccesoLocalHome;
        ParametroSubaccesoLocalHome paramSubaccesoLocalHome;
        ParametroSubtipoClienteLocalHome paramSubtipoClienteLocalHome;
        ParametroTipoClienteLocalHome paramTipoClienteLocalHome;
        ParametroClasificacionLocalHome paramClasificacionLocalHome;
        ParametroTipoClasificacionLocalHome paramTipoClasificacionLocalHome;
        ParametroBooleanLocalHome paramBooleanLocalHome;
        ParametroNacionalLocalHome paramNacionalLocalHome;

        UtilidadesLog.debug("antes de if");

        if ( (oidParam.intValue() == CTE_NRO_DTO)  || //Numero de descuento
             (oidParam.intValue() == CTE_NOM_DTO) )
        {            

        }

        // FALTAN EL 0,1,2         
        if ( oidParam.intValue() == 2){
            paramBooleanLocalHome = new ParametroBooleanLocalHome();
            for (int j=0; j<valoresPosibles.size();j++)  {
                Long oidBoole = ((DTOParametroBoolean)valoresPosibles.get(j)).getOid();
                UtilidadesLog.debug("oidBoole" + oidBoole);
                Boolean valorDefe = ((DTOParametroBoolean)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                Boolean valor = ((DTOParametroBoolean)valoresPosibles.get(j)).getValor();
                UtilidadesLog.debug("valor " + valor);
                paramBooleanLocalHome.create(UtilidadesDTO.getLong(valorDefe),UtilidadesDTO.getLong(valor), oidDetalleMatriz);                               
            }
        }
    
        
        if ( oidParam.intValue() == 3){   //Marca

            UtilidadesLog.debug("Duplicando valores de Marca");

            paramMarcaLocalHome = new ParametroMarcaLocalHome();
            for (int j=0; j<valoresPosibles.size();j++)  {
                Long oidMarca = ((DTOParametroMarca)valoresPosibles.get(j)).getOidMarca();
                UtilidadesLog.debug("oidMarca" + oidMarca);
                Boolean valorDefe = ((DTOParametroMarca)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                paramMarcaLocalHome.create(oidMarca,UtilidadesDTO.getLong(valorDefe), oidDetalleMatriz);                               }
        }
        if ( oidParam.intValue() == 4)  { //Canal
        
            UtilidadesLog.debug("Duplicando valores de Canal");
            
            paramCanalLocalHome = new ParametroCanalLocalHome();
            for (int j=0; j<valoresPosibles.size();j++)  {
                Long oidCanal = ((DTOParametroCanal)valoresPosibles.get(j)).getOidCanal();
                UtilidadesLog.debug("oidCanal" + oidCanal);
                Boolean valorDefe = ((DTOParametroCanal)valoresPosibles.get(j)).getValorPorDefecto();
                paramCanalLocalHome.create(oidCanal,oidDetalleMatriz, UtilidadesDTO.getLong(valorDefe));                
            }
        }

        if (oidParam.intValue() == 5)  { //Acceso

            UtilidadesLog.debug("Duplicando valores de Acceso");
            
            paramAccesoLocalHome = new ParametroAccesoLocalHome();
            for (int j=0; j<valoresPosibles.size(); j++)  {
                Long oidAcceso = ((DTOParametroAcceso)valoresPosibles.get(j)).getOidAcceso();
                UtilidadesLog.debug("oidAcceso" + oidAcceso);
                Boolean valorDefe = ((DTOParametroAcceso)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                paramAccesoLocalHome.create(oidAcceso, UtilidadesDTO.getLong(valorDefe), oidDetalleMatriz);                
            }
        }
        
        if (oidParam.intValue() == 6)  {  //Subacceso

            UtilidadesLog.debug("Duplicando valores de Subacceso");
                        
            paramSubaccesoLocalHome = new ParametroSubaccesoLocalHome();
            for (int j=0;j<valoresPosibles.size(); j++)  {
                Long oidSubacceso = ((DTOParametroSubacceso)valoresPosibles.get(j)).getOidSubacceso();            
                UtilidadesLog.debug("oidSubacceso" + oidSubacceso);
                Boolean valorDefe = ((DTOParametroSubacceso)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                paramSubaccesoLocalHome.create(oidSubacceso,UtilidadesDTO.getLong(valorDefe),oidDetalleMatriz);                
            }    
        }
        

        if (oidParam.intValue() == 9)  {  // Tipo Cliente y Subtipo Cliente

            UtilidadesLog.debug("Duplicando valores de Tipos y Subtipos");
        
            paramTipoClienteLocalHome = new ParametroTipoClienteLocalHome();
            for (int j=0; j<valoresPosibles.size(); j++)  {
                UtilidadesLog.debug("tipo cliente: "+j);
                Long oidTipoCliente = ((DTOParametroTipoCliente)valoresPosibles.get(j)).getOidTipoCliente();
                UtilidadesLog.debug("oidTipoCliente" + oidTipoCliente);
                Boolean valorDefe = ((DTOParametroTipoCliente)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("antes de create tipoCliente  -  - valorDefe " + valorDefe  );
                paramTipoClienteLocalHome.create(oidDetalleMatriz,oidTipoCliente,UtilidadesDTO.getLong(valorDefe));
                UtilidadesLog.debug("despues de create tipoCliente" );                
            }
            UtilidadesLog.debug("fuera del for");
            paramSubtipoClienteLocalHome = new ParametroSubtipoClienteLocalHome();
            for (int j=0; j<valoresPosibles2.size(); j++)  {
                UtilidadesLog.debug("subtipo cliente: "+j);            
                Long oidSubtipoCliente = ((DTOParametroSubtipoCliente)valoresPosibles2.get(j)).getOidSubtipoCliente();
                UtilidadesLog.debug("oidSubtipoCliente" + oidSubtipoCliente);
                Boolean valorDefe = ((DTOParametroSubtipoCliente)valoresPosibles2.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                UtilidadesLog.debug("antes de create subtipoCliente");                
                paramSubtipoClienteLocalHome.create(oidSubtipoCliente ,UtilidadesDTO.getLong(valorDefe),oidDetalleMatriz);                    
                UtilidadesLog.debug("despues de create subtipoCliente");                
            }
        }
        


        if (oidParam.intValue() == 10)  {  //Clasificacion

            UtilidadesLog.debug("Duplicando valores de Clasificacion");
        
            paramTipoClasificacionLocalHome = new ParametroTipoClasificacionLocalHome();
            for (int j=0;j<valoresPosibles.size(); j++)  {
                Long oidTipoClasificacion = ((DTOParametroTipoClasificacion) valoresPosibles.get(j)).getOidTipoClasificacion();            
                UtilidadesLog.debug("oidTipoClasificacion" + oidTipoClasificacion);
                Boolean valorDefe = ((DTOParametroTipoClasificacion)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                UtilidadesLog.debug("antes create clasificacion");
                paramTipoClasificacionLocalHome.create(oidDetalleMatriz, oidTipoClasificacion,UtilidadesDTO.getLong(valorDefe));
                UtilidadesLog.debug("despues create clasificacion");
            } 
                        UtilidadesLog.debug("Duplicando valores de Clasificacion");
        
            paramClasificacionLocalHome = new ParametroClasificacionLocalHome();
            for (int j=0;j<valoresPosibles2.size(); j++)  {
                Long oidClasificacion = ((DTOParametroClasificacion)valoresPosibles2.get(j)).getOidClasificacion();            
                UtilidadesLog.debug("oidClasificacion" + oidClasificacion);
                Boolean valorDefe = ((DTOParametroClasificacion)valoresPosibles2.get(j)).getValorPorDefecto();
                 UtilidadesLog.debug("valorDefe" + valorDefe);
                UtilidadesLog.debug("antes create clasificacion");
                paramClasificacionLocalHome.create(oidClasificacion,UtilidadesDTO.getLong(valorDefe), oidDetalleMatriz);
                UtilidadesLog.debug("despues create clasificacion");
            }
        }


        if (oidParam.intValue() == 12)  {   //Nacional

            UtilidadesLog.debug("Duplicando valores de Nacional");
        
            paramNacionalLocalHome = new ParametroNacionalLocalHome();
            for (int j=0;j<valoresPosibles.size(); j++)  {
                Long oid = ((DTOParametroNacional)valoresPosibles.get(j)).getOid();            
               UtilidadesLog.debug("oid" + oid);
                String valor = new String(((DTOParametroNacional)valoresPosibles.get(j)).getValor());
                UtilidadesLog.debug("valor" + valor);
                Boolean valorDefe = ((DTOParametroNacional)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                paramNacionalLocalHome.create(UtilidadesDTO.getLong(valorDefe), valor, oidDetalleMatriz);
            }    
        }

        if ((oidParam.intValue() == 7) ||
            (oidParam.intValue() == 8) ||
            (oidParam.intValue() == 11) ||
            (oidParam.intValue() == 13) ||
            (oidParam.intValue() == 14) ||
            (oidParam.intValue() == 15) ||
            (oidParam.intValue() == 16) ||
            (oidParam.intValue() == 17) ||
            (oidParam.intValue() == 18) ||
            (oidParam.intValue() == 19) ||
            (oidParam.intValue() == 20) ||
            (oidParam.intValue() == 21) ||
            (oidParam.intValue() == 22) ||
            (oidParam.intValue() == 23) ||
            (oidParam.intValue() == 24) ||
            (oidParam.intValue() == 25))  {

        }


        if ((oidParam.intValue() == 26) ||
            (oidParam.intValue() == 27) ||
            (oidParam.intValue() == 28) ||
            (oidParam.intValue() == 29) ||
            (oidParam.intValue() == 30) ||
            (oidParam.intValue() == 31))  {

            UtilidadesLog.debug("Duplicando valores de Boolean");
            
            paramBooleanLocalHome = new ParametroBooleanLocalHome();
             for (int j=0;j<valoresPosibles.size(); j++)  {
                Long oid = ((DTOParametroBoolean)valoresPosibles.get(j)).getOid();
                UtilidadesLog.debug("oid" + oid);
                Boolean valorDefe =((DTOParametroBoolean)valoresPosibles.get(j)).getValorPorDefecto();
                UtilidadesLog.debug("valorDefe" + valorDefe);
                Boolean valor = ((DTOParametroBoolean)valoresPosibles.get(j)).getValor();
                UtilidadesLog.debug("valor" + valor);
                paramBooleanLocalHome.create(UtilidadesDTO.getLong(valorDefe), UtilidadesDTO.getLong(valor), oidDetalleMatriz);
             }
        }            
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.crearValoresParametros(): Salida");
    }


    public DTOSCargarPaginaCrearMatrizDTO cargarPaginaCrearMatrizDescuento(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.cargarPaginaCrearMatrizDescuento(): Entrada");
        DTOSCargarPaginaCrearMatrizDTO result = null;
        try  {
                DAOMatrizDescuentos dao = new DAOMatrizDescuentos();
                result = dao.cargarPaginaCrearMatrizDescuento(dto);
    
        } catch (Exception ex)  {
            UtilidadesLog.error(ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.cargarPaginaCrearMatrizDescuento(): Salida");
        return result;
    }


    public DTOSalida obtenerSubaccesosDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubaccesosDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos daoMD = new DAOMatrizDescuentos();
        DTOSalida dtoSalida = daoMD.obtenerSubaccesosDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubaccesosDTOMatrizSeleccionada(): Salida");
        return dtoSalida;
    }


    public DTOSalida obtenerSubtiposClienteDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubtiposClienteDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos daoMD = new DAOMatrizDescuentos();        
        DTOSalida dtoSalida = daoMD.obtenerSubtiposClienteDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerSubtiposClienteDTOMatrizSeleccionada(): Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(DTOEMatrizTipoClasificacion dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(): Entrada");
        DAOMatrizDescuentos daoMD = new DAOMatrizDescuentos();            
        DTOSalida dtoSalida = daoMD.obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(): Salida");
        return dtoSalida;
    }


    public DTOSalida obtenerNumerosDescuentos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerNumerosDescuentos(): Entrada");
        DAOMatrizDescuentos daoMD = new DAOMatrizDescuentos();
        DTOSalida dtoSalida = daoMD.obtenerNumerosDescuentos(dto);
        UtilidadesLog.info("MONMantenimientoMatrizDescuentoBean.obtenerNumerosDescuentos(): Salida");
        return dtoSalida;
    }


}

