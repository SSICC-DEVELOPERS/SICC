/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La rmación contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
 
package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarClientesDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentos;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEBuscarDetalleSolicitudDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarProductosDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarSolicitudesClienteDTO;
import es.indra.sicc.dtos.dto.DTOEscalon;
import es.indra.sicc.dtos.dto.DTOListaBasesAplicacionDto;
import es.indra.sicc.dtos.dto.DTOSAlcanceTipoClienteDTO;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.dtos.dto.DTOSBaseCalculoDetalle;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.entidades.dto.BaseAplicacionCabeceraLocal;
import es.indra.sicc.entidades.dto.BaseAplicacionCabeceraLocalHome;
import es.indra.sicc.entidades.dto.DescuentoLocal;
import es.indra.sicc.entidades.dto.DescuentoLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.dto.UtilidadesDTO;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

import javax.persistence.NoResultException;


public class DAODescuento  {

	BelcorpService bs = null;
    
	
	public DAODescuento() throws MareException {
		try {
            UtilidadesLog.debug(" - Obtiene BelcorpService");
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
	}

  /**
   * Metodo: buscarDescuentos
   * Modificado por: Cristian Valenzuela
   * Fecha: 25/2/2005
   * Comentario: Se ha agregado la funcion to_date, para el manejo de las fechas
   */
 public DTOSalida buscarDescuentos(DTOEBuscarDescuentos dto) throws MareException{
        /*
        Entrada: DTOEBuscarDescuentos 
        Proceso: 
        -> Hacer consulta JDBC contra la tabla DTO_DESCU filtrando por los criterios contenidos en el dto de entrada: 
        - pais (oid) 
        - número de descuento (oid) 
        - descripcion (en idioma usuario activo) 
        - marca (oid) 
        - canal (oid) 
        - periodoDesde (oid) 
        - periodoHasta (oid) 
        - activo 
        y se filtrará también que el campo MDES_OID_TIPO_DESC sea distinto de NULL, para obtener los campos PAIS_OID_PAIS, OID_DESC, PERD_OID_PERI y la descripción del periodo internacionalizada, PERD_OID_PERI_LIMI_FIN y la descripción del periodo internacionalizada. En cuanto a los periodos, se trata de obtener descuentos que tengan al menos uno de sus periodos entre el rango señalado por los atributos del dto de entrada. 
        Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 
        
        -> Devolver RecordSet obtenido en objeto DTOSalida
        
         */
        UtilidadesLog.info("DAODescuento.buscarDescuentos(): Entrada");
        StringBuffer consulta = new StringBuffer("");
        
        UtilidadesLog.debug("Pais " + dto.getOidPais());

        consulta.append(" SELECT d.oid_desc oid, ");
        consulta.append(" d.num_desc,  ");
        consulta.append(" i4.val_i18n descu ,   ");
        consulta.append(" p1.VAL_NOMB_PERI periodoDesde, ");
        consulta.append(" p2.VAL_NOMB_PERI periodoHasta,");
        consulta.append(" decode(d.IND_ACTI,0,'No','Si'),  ");
        consulta.append(" i3.VAL_I18N pais ");

        consulta.append(" FROM cra_perio p1,  ");
        consulta.append(" v_gen_i18n_sicc i4,  ");
        consulta.append(" v_gen_i18n_sicc i3,  ");
        consulta.append(" dto_descu d ");
        consulta.append(" left JOIN cra_perio p2 ");
        consulta.append(" ON ");
        consulta.append(" d.PERD_OID_PERI_LIMI_FIN = p2.oid_peri ");
        
        consulta.append(" WHERE ");
        consulta.append(" d.MDES_OID_TIPO_DESC is not NULL " ); 
        consulta.append(" AND i4.attr_enti = 'DTO_DESCU' " );
        consulta.append(" AND i4.ATTR_NUM_ATRI = 1 " );
        consulta.append(" AND i4.VAL_OID = d.OID_DESC " );
        consulta.append(" AND i4.idio_oid_idio = " +dto.getOidIdioma() );
        consulta.append(" AND i3.attr_enti = 'SEG_PAIS' " );
        consulta.append(" AND i3.ATTR_NUM_ATRI = 1 " );
        consulta.append(" AND i3.idio_oid_idio = " + dto.getOidIdioma());
        consulta.append(" AND i3.VAL_OID = d.PAIS_OID_PAIS ");
        consulta.append(" AND d.PERD_OID_PERI = p1.oid_peri ");
        
        if (dto.getOidPais()!= null) {
          consulta.append(" AND d.pais_oid_pais  = " + dto.getOidPais());
        }
        
        Long lIni = dto.getOidPeriodoDesde();
        Long lHasta = dto.getOidPeriodoHasta();

        UtilidadesLog.debug("lIni : " + lIni);
        UtilidadesLog.debug("lHasta : " + lHasta);

        if (lIni != null ) {
            consulta.append(" AND d.PERD_OID_PERI in ( ");
            consulta.append(" SELECT p1.oid_peri ");
            consulta.append(" FROM  cra_perio p1 ");
            consulta.append(" WHERE p1.FEC_INIC >= ( ");
            consulta.append(" select FEC_INIC  ");
            consulta.append(" from cra_perio p2  ");
            consulta.append(" where p2.OID_PERI = " + lIni.toString());
            consulta.append(" AND p2.PAIS_OID_PAIS = " + dto.getOidIdioma()); 
            consulta.append(" )) ");
        }
        
        if(lHasta != null) {
            consulta.append(" AND d.PERD_OID_PERI_LIMI_FIN in   (  ");
            consulta.append(" SELECT p3.oid_peri   ");
            consulta.append(" FROM   cra_perio p3   ");
            consulta.append(" WHERE p3.FEC_FINA <= ( ");
            consulta.append(" select FEC_FINA  ");
            consulta.append(" from cra_perio p4  ");
            consulta.append(" where p4.OID_PERI = "+ lHasta.toString());
            consulta.append(" )) ");
        }
        
        if(dto.getOidDescuento()!= null) {
            consulta.append(" AND d.num_desc = " + dto.getOidDescuento());
        }
        if(dto.getOidMarca()!= null) {
            consulta.append(" AND d.marc_oid_marc = " + dto.getOidMarca());
        }
        if(dto.getOidCanal()!= null) {
            consulta.append(" AND d.cana_oid_cana  = " + dto.getOidCanal());
        }
        if(dto.getActivo()!= null) {
            Long lValor = new Long(0);
             if (dto.getActivo().booleanValue())
                 lValor = new Long(1);
              else        
                lValor = new Long(0);
            
            consulta.append(" AND d.ind_acti = " + lValor);
        }
        if(dto.getDescripcion()!= null) {
            consulta.append(" AND i4.val_i18n like '" + dto.getDescripcion() + "'");
        }
        
        RecordSet r = null;

        UtilidadesLog.debug("sQuery : " + consulta.toString());
       
        try {
            UtilidadesLog.debug(" - Ejecuta la consulta");
			//String sPagin = UtexecutePreparedQueryilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
            String sPagin = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);            
            
            r = bs.dbService.executeStaticQuery(sPagin);
	    } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(r.esVacio())
          throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                

		DTOSalida output = new DTOSalida();
		output.setResultado(r);
        UtilidadesLog.info("DAODescuento.buscarDescuentos(): Salida");

		return output;	
	}


    /**
     * Entrada: DTOEBuscarDescuentosOrdenacion
    Proceso:
    -> Hacer consulta JDBC contra la tabla DTO_DESCU filtrando por los criterios
    contenidos en el dto de entrada:
       - oidMarca
       - oidCanal
    para obtener los campos PAIS_OID_PAIS, OID_DESC, PERD_OID_PERI y la
    descripción del periodo internacionalizada, PERD_OID_PERI_LIMI_FIN y la
    descripción del periodo internacionalizada
    -> Filtrando que la fecha de fin de PERD_OID_PERI_LIMI_FIN sea mayor a la fecha
    actual.
    -> Devolver RecordSet obtenido en objeto DTOSalida
     */
	public DTOSalida buscarDescuentosOrdenacion (DTOEBuscarDescuentosOrdenacion dto)  throws MareException {
        UtilidadesLog.info("DAODescuento.buscarDescuentosOrdenacion(): Entrada");
        String sQuery  = " SELECT " +
        "      d.OID_DESC,      " + 
        "	   d.NUM_DESC_CORR, " +
        "	   d.NUM_DESC,  " +
        "	   i.VAL_I18N descr , " +
        "	   p1.VAL_NOMB_PERI periodoDesde,  " + 
        "    p2.VAL_NOMB_PERI periodoHasta, " +
        "   decode(d.IND_CULM , 0,'No','Si') , " + 
        "   decode(d.IND_ACTI,0,'No','Si') ,  " + 
        "   i4.VAL_I18N " +
        " FROM 	v_gen_i18n_sicc i, " + 
        "		v_gen_i18n_sicc i4, " +
        "		dto_descu d, " +
        "       cra_perio p1," + 
        "  		cra_perio p2";

        Vector varSql = new Vector();
        varSql.addElement(dto.getOidPais()); // PAIS
        varSql.addElement(dto.getOidMarca()); // Marca
        varSql.addElement(dto.getOidCanal()); // Canal

        String[] nombres = new String[varSql.size()];
        Object[] valores = new Object[varSql.size()];
        boolean[] com = new boolean[varSql.size()];

        int i = 0;
        nombres[i++] = " d.pais_oid_pais";
        nombres[i++] = " d.marc_oid_marc";
        nombres[i++] = " d.cana_oid_cana  ";  

        valores = varSql.toArray();
   
        i = 0;
        com[i++] = false;
        com[i++] = false;
        com[i++] = false;
            
        String where = UtilidadesBD.armarSQLWhere(nombres, valores, com);
        if( where.equals("") ){
            where += "WHERE ";
        }else{
            where += "AND   ";
        }

        where +="  i.attr_enti = 'DTO_DESCU' " +
        "	AND i.idio_oid_idio =  " + dto.getOidIdioma() + 
        "	AND i.VAL_OID = d.OID_DESC " +
        "   AND i.ATTR_NUM_ATRI = 1 " +
        "   AND i4.ATTR_ENTI = 'SEG_PAIS' " + 
        "   AND i4.ATTR_NUM_ATRI = 1 " +
        "  	AND i4.idio_oid_idio = " + dto.getOidIdioma() + 
        "	AND i4.VAL_OID = d.pais_oid_pais  " +
        "   and p2.oid_peri(+) = d.PERD_OID_PERI_LIMI_FIN " + 
        // -> Filtrando que la fecha de fin de PERD_OID_PERI_LIMI_FIN sea mayor a la fecha actual.
        "   and p2.fec_fina(+) > trunc(SYSDATE) "+
        "   AND p1.OID_peri = d.PERD_OID_PERI " + 
        "	order by d.NUM_DESC_CORR "; 
        sQuery += where;
        RecordSet r = null;
       
        try {
            r = bs.dbService.executeStaticQuery(sQuery);
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

		DTOSalida output = new DTOSalida();
		output.setResultado(r);
        UtilidadesLog.info("DAODescuento.buscarDescuentosOrdenacion(): Salida");
		return output;	
	}


	/**
     * Retorna DTODescuentoDG, con los datos generales para oidDescuento.
     */
	public DTODescuentoDG obtenerDescuentoDG (DTOOID dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerDescuentoDG(): Entrada");
        /*
        Entrada: DTOOID 
        Proceso: 
        -> Tomar oid de descuento del dto de entrada 
        -> Construir DTODescuentoDG 
        -> Hacer findByPrimaryKey sobre entidad Descuento 
        -> Setear los datos de DTODescuentoDG con los datos de la instancia anterior. 
        -> Buscar el nombre del descuento internacionalizado y setearlo 
        -> Hacer consulta JDBC sobre tabla DTO_DESCU_ACCES filtrando por el oid del descuento, del dto de entrada, para obtener el campo OID_DESC_ACCE. 
        -> Construir DTOOIDs con los registros encontrados y asignarlo al atributo DTODescuentoDG.accesos 
        -> Hacer consulta JDBC sobre tabla DTO_DESCU_SUBAC filtrando por el oid del descuento, del dto de entrada, para obtener el campo OID_DESC_SUBAC. 
        -> Construir DTOOIDs con los registros encontrados y asignarlo al atributo DTODescuentoDG.subaccesos 
        -> Devolver DTODescuentoDG
        */

        Long oid = dto.getOid();
        DTODescuentoDG descDTO = new DTODescuentoDG();
 
        DescuentoLocalHome descHome =  new DescuentoLocalHome();

        DescuentoLocal descBean = null;
        try{
            descBean = descHome.findByPrimaryKey(oid);
        }catch(NoResultException e ) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        DTOOIDs oids = getAccesos(oid);
        descDTO.setAccesos(oids); 
        descDTO.setActivo(UtilidadesDTO.getBoole((descBean.getInd_acti()) ));
        descDTO.setAfectaACuentasCorrientes(UtilidadesDTO.getBoole(descBean.getInd_afec_cc()));
        descDTO.setAfectaAFacturas(UtilidadesDTO.getBoole((descBean.getInd_afec_fact())));
        descDTO.setAprobado(UtilidadesDTO.getBoole((descBean.getInd_apro())));
        descDTO.setComunicacionAParticipantes(UtilidadesDTO.getBoole(descBean.getInd_comu_part()));
        descDTO.setControlAnulaciones(UtilidadesDTO.getBoole(descBean.getInd_ctrl_anul()));
        descDTO.setControlDevoluciones(UtilidadesDTO.getBoole(descBean.getInd_ctrl_devo()));
        descDTO.setCulminacion(UtilidadesDTO.getBoole(descBean.getInd_culm()));
        descDTO.setDescripcion(getDescripcionStr(oid,dto.getOidIdioma())); 
        descDTO.setAttTraducible(getDescripcion(oid,null));
        descDTO.setDescuentoAcumulativo(UtilidadesDTO.getBoole(descBean.getInd_desc_acumu()));
        descDTO.setMorosidad(UtilidadesDTO.getBoole(descBean.getInd_moro()));
        descDTO.setOidCabeceraDTO(descBean.getMdes_oid_tipo_desc());
        descDTO.setOidCanal(descBean.getCana_oid_cana()); // 
        descDTO.setOidDescuento(descBean.getOid());
        descDTO.setOidIdioma(dto.getOidIdioma());
        descDTO.setOidMarca(descBean.getMarc_oid_marc());
        descDTO.setOidPais(dto.getOidPais());
        descDTO.setOidPeriodoDesde(descBean.getPerd_oid_peri());	
        descDTO.setOidPeriodoHasta(descBean.getPerd_oid_peri_limi_fin());
        descDTO.setNacional(UtilidadesDTO.getBoole(descBean.getInd_naci()));
        descDTO.setNumeroDescuento(descBean.getNum_desc());
        //descDTO.setNumeroCorrelativo(descBean.getNum_desc_corr());
        oids = getSubAccesos(oid);	    
        descDTO.setSubaccesos(oids);
        UtilidadesLog.info("DAODescuento.obtenerDescuentoDG(): Salida");

        return descDTO;	
    }	


    /**
     * Retorna DTOSAlcanceTipoClienteDTO para un oidDescuento.
     * Este incluye tiposClientes, subtiposClientes y alcancesClasificacion.
     */
    public DTOSAlcanceTipoClienteDTO obtenerDTOAlcanceTipoCliente (DTOOID dto)  throws MareException{
        Cronometrador.startTransaction("DAODescuento.obtenerDTOAlcanceTipoCliente");  
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceTipoCliente(): Entrada");
        /*
        Version NU 
        -> Hacer consulta JDBC sobre la tabla DTO_DESCU_TIPO_CLIEN, obtener los campos TICL_OID_TIPO_CLIE y haciendo join con la tabla MAE_TIPO_CLIEN obtener la descripción internacionalizada del tipo de cliente, filtrando por el campo DCTO_OID_DESC = oid del dto de entrada 
        -> Asignar el RecordSet obtenido al atributo DTOSAlcanceTipoClienteDTO.tiposCliente 
        -> Hacer consulta JDBC sobre la tabla DTO_DESCU_SUBTI_CLIEN, obtener los campos SBTI_OID_SUBT_CLIE y haciendo join con la tabla MAE_SUBTI_CLIEN obtener la descripción internacionalizada del subtipo de cliente y el campo MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE 
        -> Asignar el RecordSet obtenido al atributo DTOSAlcanceTipoClienteDTO.subtiposCliente 
        -> Hacer consutla JDBC sobre la tabla DTO_ALCAN_DTO_CLASI_CLIEN filtrando por oid del dto de entrada, y obtener la descripción internacionalizada del Tipo de Clasificación, la descripción internazionalizada de la clasificación y el porcentaje de descuento adicional, haciendo las join correspondientes con la tabla MAE_CLASI_CLIEN y MAE_TIPO_CLASI. 
        Devolver DTOSAlcanceTipoClienteDTO construido
         */

        Long oid = dto.getOid();
        DTOSAlcanceTipoClienteDTO atcDTO = new DTOSAlcanceTipoClienteDTO();

        atcDTO.setTiposCliente( getTipoClient(oid, dto.getOidIdioma()));
        atcDTO.setSubtiposCliente(getSubTipoClient(oid,dto.getOidIdioma() ));

        atcDTO.setAlcanceClasificacion(getAlcanceClasif(dto));
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceTipoCliente(): Salida");
        Cronometrador.endTransaction("DAODescuento.obtenerDTOAlcanceTipoCliente");  
        return atcDTO;
	}


    public DTOSAlcanceTipoClienteDTO obtenerDTOAlcanceTipoCliente2 (DTOOID dto)  throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceTipoCliente2(): Entrada");

        Long oid = dto.getOid();
        DTOSAlcanceTipoClienteDTO atcDTO = new DTOSAlcanceTipoClienteDTO();

        String sQuery = "select " + 
        "    	dtc.OID_DESC_TIPO_CLIE, i.VAL_I18N  " + 
        "        from " + 
        "    	DTO_DESCU_TIPO_CLIEN dtc, " + 
        "    	MAE_TIPO_CLIEN mtc, " + 
        "    	GEN_i18n_sicc i " + 
        "        where " + 
        "        dtc.DCTO_OID_DESC = " + oid +  
        "        and dtc.TICL_OID_TIPO_CLIE = mtc.OID_TIPO_CLIE " + 
        "        and i.VAL_OID = dtc.TICL_OID_TIPO_CLIE " + 
        "        and i.ATTR_NUM_ATRI = 1 " + 
        "        and i.IDIO_OID_IDIO = " + dto.getOidIdioma() + 
        "        and i.ATTR_ENTI = 'MAE_TIPO_CLIEN'" ; 
	
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
		
        //atcDTO.setTiposCliente( getTipoClient(oid, dto.getOidIdioma()));
        atcDTO.setTiposCliente(r);   


   		String sQuerry = "select " + 
        "	stc.OID_DESC_SUBT_CLIE, i.VAL_I18N, mst.TICL_OID_TIPO_CLIE  " +
        "   from " + 
        "	DTO_DESCU_SUBTI_CLIEN stc, " + 
        "	MAE_SUBTI_CLIEN mst, " + 
        "	GEN_i18n_sicc i " + 
        "   where " + 
        "   stc.DCTO_OID_DESC = " + oid +
        "   and stc.SBTI_OID_SUBT_CLIE = mst.OID_SUBT_CLIE  " + 
        "   and i.VAL_OID = stc.SBTI_OID_SUBT_CLIE " + 
        "   and i.ATTR_NUM_ATRI = 1 " + 
        "   and i.IDIO_OID_IDIO = " + dto.getOidIdioma() + 
        "   and i.ATTR_ENTI = 'MAE_SUBTI_CLIEN' "; 
	
		RecordSet rs = UtilidadesDTO.getQuery(sQuerry);

        //atcDTO.setSubtiposCliente(getSubTipoClient(oid,dto.getOidIdioma() ));
        atcDTO.setSubtiposCliente(rs);        
        
        // vbongiov -- cambio DTO-08 -- 3/07/2008
        // se reemplaza la obtencion del campo cc.VAL_PORC_ADIC por 0
		String sQueryy = "select OID_ALCA_DTO_CLAS_CLTE, i.VAL_I18N, i2.VAL_I18N, 0 VAL_PORC_ADIC, cc.TCCL_OID_TIPO_CLAS   " + 
        " from DTO_ALCAN_DTO_CLASI_CLIEN cc,  " +
        " v_gen_i18n_sicc i, " + 
        " v_gen_i18n_sicc i2, " +  
        " MAE_CLASI cl " +
        " where DCTO_OID_DESC = " + oid + 
        " and i.ATTR_ENTI(+) = 'MAE_CLASI' " +
        " and i.IDIO_OID_IDIO(+) = " +  dto.getOidIdioma() +
        " and i.VAL_OID(+) = cl.OID_CLAS " + 
        "   AND i.ATTR_NUM_ATRI(+) = 1 " +
        " and i2.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' " +
        "   AND i2.ATTR_NUM_ATRI = 1 " +
        " and i2.IDIO_OID_IDIO =  " + dto.getOidIdioma() + 
        " and i2.VAL_OID = cc.TCCL_OID_TIPO_CLAS " +
        " and cc.CLAS_OID_CLAS = cl.OID_CLAS(+) ";

        RecordSet rsc = UtilidadesDTO.getQuery(sQueryy);
        atcDTO.setAlcanceClasificacion(rsc);
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceTipoCliente2(): Salida");

        return atcDTO;
	}


    /**
     * 
     */
	public DTOSalida obtenerDTOAlcanceCliente (DTOEBuscarAlcanceClienteDTO dto)  throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceCliente(): Entrada");
        /*	Entrada: DTOEBuscarAlcanceClienteDTO (oid de descuento) 
        Proceso: 
        -> Hacer consulta JDBC sobre la tabla DTO_ALCAN_DTO_CLIEN para recuperar los campos OID_ALCA_DTO_CLIE, VAL_PORC_DESC e IMP_FIJO y haciendo join con la tabla MAE_CLIEN recuperar los campos VAL_NOM1 + VAL_NOM2 como Nombre y VAL_APE1 + VAL_APE2 como apellidos, filtrando por el oid de descuento del dto de entrada. Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 

        -> Devolver RecordSet obtenido en objeto DTOSalida 

        */
 
		Long oid = dto.getOidDescuento();
        // vbongiov -- cambio DTO-08 -- 26/06/2008
		String sQuery = "select  OID_ALCA_DTO_CLIE OID, COD_CLIE, mc.VAL_NOM1 || ' ' || mc.VAL_NOM2 nombre, mc.VAL_APE1 ||  ' '  || mc.VAL_APE2 apellido, IMP_FIJO, DCTO_OID_DESC, mc.PAIS_OID_PAIS  " +
			 "		from  	" +
			 "		DTO_ALCAN_DTO_CLIEN ac , " +
             "		MAE_CLIEN mc  " +
			"		where " +
            "       mc.OID_CLIE = ac.CLIE_OID_CLIE AND " +
			"		ac.DCTO_OID_DESC = " + oid ;

        DTOSalida ret = new DTOSalida();
		String sPagin = UtilidadesPaginacion.armarQueryPaginacion(sQuery,new DTOSiccPaginacion());
		ret.setResultado(UtilidadesDTO.getQuery(sPagin));
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceCliente(): Salida");

		return ret;
	}


    /**
     * Retorna los alcances administrativos para un oidDescuento.
     */
	public DTOSalida obtenerDTOAlcanceAdministrativo (DTOOID dto) throws MareException  {
      Cronometrador.startTransaction("DAODescuento.obtenerDTOAlcanceAdministrativo");
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceAdministrativo(): Entrada");
        // -> Hacer consulta JDBC sobre tabla DTO_ALCAN_ADMIN_DESCU para obtener el campo OID_ALCA_ADMI
        // y hacer join para obtener las descripciones internacionalizadas de Subgerencia de Venta, Region y Zona,
        // así como obtener el porcentaje adicional para la combinación. 
        // Aquellos datos que tengan null se mostrarán en blanco,
        // filtrando por el campo DCTO_OID_DESC = oid del dto de entrada. 
		String sQuery =	" SELECT d.oid_alca_admi, " + 
        "       DECODE (sg.DES_SUBG_VENT, NULL, '', sg.DES_SUBG_VENT) DES_SUBG_VENT, " + 
        "       DECODE (r.DES_REGI , NULL, '', r.DES_REGI) DES_REGI, " + 
        "       DECODE (z.DES_ZONA , NULL, '', z.DES_ZONA) DES_ZONA, " +
        "       d.VAL_PORC_ADIC, " +
        "       z.OID_ZONA, r.OID_REGI, sg.OID_SUBG_VENT " + 
        "  FROM dto_alcan_dto_admin d, " + 
        "       zon_zona z , " + 
        "       zon_sub_geren_venta sg, " + 
        "       zon_regio r " +
        " WHERE d.ZSGV_OID_SUBG_VENT = sg.OID_SUBG_VENT " + 
        "   AND d.ZORG_OID_REGI = r.OID_REGI (+) " +
        "   AND d.ZZON_OID_ZONA = z.OID_ZONA (+) " + 
        "   AND d.dcto_oid_desc = " +  dto.getOid();

        // -> Devolver RecordSet obtenido en un objeto DTOSalida
		RecordSet r = UtilidadesDTO.getQuery(sQuery);		
		DTOSalida ret = new DTOSalida();
		ret.setResultado(r);
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceAdministrativo(): Salida");
    Cronometrador.endTransaction("DAODescuento.obtenerDTOAlcanceAdministrativo");
		return ret;
	}


    /**
     * 
     */
	public DTOSalida obtenerDTOProductos(DTOEBuscarProductosDTO dto)  throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerDTOProductos(): Entrada");
        /*
                Entrada: DTOEBuscarProductosDTO 
            Proceso: 
            -> Hacer consulta JDBC sobre la entidad MAE_PRODU para obtener los campos: OID_PROD, COD_SAP y la descripción internacionalizada, filtrando por los campos MARC_OID_MARC, GENE_OID_GENE, NEGO_OID_NEGO, SGEN_OID_SUPE_GENE, UNEG_OID_UNID_NEGO, COD_SAP y descripción en el idioma del usuario activo, que se igualan respectivamente a oidMarca, oidGenerico, oidNegocio, oidSuperGenerico, oidUnidadNegocio, codigoProducto y descripcionProducto. 
            Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 

            1.- oid del registro encontrado > dto.indicadorSituacion 
            2.- ROWNUM <= dto.tamañoPagina 

            -> Devolver RecordSet obtenido en objeto DTOSalida
        */

        String sql = "select OID_PROD OID, COD_SAP , i.VAL_I18N , i.IDIO_OID_IDIO " +
			"	   from " +
			"	   MAE_PRODU p , " +
			"	   v_gen_i18n_sicc i  ";
            UtilidadesLog.debug(dto);
    		Vector varSql = new Vector();
			varSql.add(dto.getOidMarca());
			varSql.add(dto.getOidGenerico());
			varSql.add(dto.getOidNegocio());
			varSql.add(dto.getOidSuperGenerico());
			varSql.add(dto.getOidUnidadNegocio());
            varSql.add(dto.getOidIdioma());
           
            String[] nombres = new String[varSql.size()];
            Object[] valores = new Object[varSql.size()];
            boolean[] com = new boolean[varSql.size()];

            nombres[0]  = "p.MAPR_OID_MARC_PROD";
            nombres[1]  = "p.GENE_OID_GENE";
            nombres[2]  = "p.NEGO_OID_NEGO";
            nombres[3]  = "p.SGEN_OID_SUPE_GENE";
            nombres[4]  = "p.UNEG_OID_UNID_NEGO";
            nombres[5]  = "i.IDIO_OID_IDIO";   

            com[0] = false;
            com[1] = false;
            com[2] = false;
            com[3] = false;
            com[4] = false;
            com[5] = false;
            
            valores = varSql.toArray();
            
            String where = UtilidadesBD.armarSQLWhere(nombres, valores, com);
            if(where.equals("")){
                where += "where p.OID_PROD = i.VAL_OID and i.ATTR_ENTI = 'MAE_PRODU' AND i.ATTR_NUM_ATRI = 1 ";
            }else{
                where += "and  p.OID_PROD = i.VAL_OID and i.ATTR_ENTI = 'MAE_PRODU' AND i.ATTR_NUM_ATRI = 1 ";
            }

            if(dto.getCodigoProducto()!=null){
                where += "and  p.COD_SAP like '" + dto.getCodigoProducto() + "' ";
            }

            if(dto.getDescripcionProducto()!=null){
                where += "and i.VAL_I18N like '" + dto.getDescripcionProducto() + "' ";
            }
           
            sql += where;
            
			DTOSalida ret = new DTOSalida();
            RecordSet rs = new RecordSet();

			rs= UtilidadesDTO.getQuery(UtilidadesPaginacion.armarQueryPaginacion(sql, dto));

            if (rs==null || rs.esVacio()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
            }

            ret.setResultado(rs);
        UtilidadesLog.info("DAODescuento.obtenerDTOProductos(): Salida");
						
		return ret;
	}


    /**
     * Retorna DTOSBaseCalculo para un oidDescuento.
     * La Incidencia 7675 asegura la obtencion de una BaseCalculo para un oidDescuento existente.
     */
	public DTOSBaseCalculo obtenerDTOBaseCalculo (DTOOID dto)  throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseCalculo(): Entrada");
        
        DTOSBaseCalculo bcDTO = new DTOSBaseCalculo();
        RecordSet rs = null;
        Long oid = dto.getOid();
        StringBuffer sb = new StringBuffer();
        if (dto.getOidIdioma() == null) {
            dto.setOidIdioma(new Long(1));
        }

        sb.append(" SELECT   bcc.OID_CABE, bcd.mapr_oid_marc_prod, bcd.uneg_oid_unid_nego, bcd.nego_oid_nego, ");
        sb.append(" bcd.sgen_oid_supe_gene, bcd.gene_oid_gene, bcd.ind_excl_tipo_ofer, ");
        sb.append(" bcd.tofe_oid_tipo_ofer, bcd.civi_oid_cicl_vida, bcd.prod_oid_prod, ");
        sb.append(" mp.des_marc_prod, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.uneg_oid_unid_nego,'MAE_UNIDA_NEGOC') unegocio, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.nego_oid_nego,'MAE_NEGOC') negocio, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.gene_oid_gene,'MAE_GENER') generico, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.sgen_oid_supe_gene,'MAE_SUPER_GENER') supergenerico, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.tofe_oid_tipo_ofer,'PRE_TIPO_OFERT') tipoOferta, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.civi_oid_cicl_vida,'PRE_CICLO_VIDA') cicloVida, ");
        sb.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+", bcd.prod_oid_prod,'MAE_PRODU') produ	  ");
        sb.append(" FROM dto_base_calcu_detal bcd, DTO_BASE_CALCU_CABEC bcc,  ");
        sb.append(" seg_marca_produ mp ");
        sb.append(" WHERE bcc.DCTO_OID_DESC =  "+oid);
        sb.append(" and bcc.OID_CABE = bcd.BCCA_OID_CABE ");
        sb.append(" AND mp.oid_marc_prod(+) = bcd.mapr_oid_marc_prod ");
        sb.append(" ORDER BY mp.des_marc_prod, unegocio, negocio, generico, supergenerico, tipoOferta, cicloVida, produ ");
          
        try{
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);        
            throw new MareException(e);
        }
        ArrayList detalle = new ArrayList();

        for(int i = 0 ; i < rs.getRowCount(); i++ ){
            if(bcDTO.getOidBase() == null &&  rs.getValueAt(i,0)!=null ){
                bcDTO.setOidBase(UtilidadesDTO.getLong(rs.getValueAt(i,0)));
            }
            
            DTOSBaseCalculoDetalle det = new DTOSBaseCalculoDetalle();
            UtilidadesLog.debug(rs);
            
            if(rs.getValueAt(i,1)!=null){
                det.setMarca(UtilidadesDTO.getLong(rs.getValueAt(i,1)));
                det.setDescripcionMarca((String)rs.getValueAt(i,10));
            }

            if(rs.getValueAt(i,2)!=null){
                det.setUnidadNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,1)));
                det.setDescripcionUnidadNegocio((String)rs.getValueAt(i,11));
            }

            if(rs.getValueAt(i,3)!=null){
                det.setNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,2)));
                det.setDescripcionNegocio((String)rs.getValueAt(i,12));
            }

            if(rs.getValueAt(i,4)!=null){
                det.setSupergenerico(UtilidadesDTO.getLong(rs.getValueAt(i,3)));
                det.setDescripcionSupergenerico((String)rs.getValueAt(i,14));
            }

            if(rs.getValueAt(i,5)!=null){
                det.setGenerico(UtilidadesDTO.getLong(rs.getValueAt(i,5)));
                det.setDescripcionGenerico((String)rs.getValueAt(i,13));
            }

            det.setExclusionTipoOferta(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(rs.getValueAt(i,6))));

            if(rs.getValueAt(i,7)!=null){
                det.setTipoOferta(UtilidadesDTO.getLong(rs.getValueAt(i,7)));
                det.setDescripcionTipoOferta((String)rs.getValueAt(i,15));
            }

            if(rs.getValueAt(i,8)!=null){
                det.setCicloVida(UtilidadesDTO.getLong(rs.getValueAt(i,8)));
                det.setDescripcionCicloVida((String)rs.getValueAt(i,16));
            }

            if(rs.getValueAt(i,9)!=null){
                det.setProducto(UtilidadesDTO.getLong(rs.getValueAt(i,9)));
                det.setDescripcionProducto((String)rs.getValueAt(i,17));
            }
    
            detalle.add(det);
        }
        bcDTO.setDetalle(detalle);
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseCalculo(): Salida");
        return bcDTO;
	}


    /**
     * Retorna DTOSBaseAplicacion para un oidBaseAplicacion.
     * La Incidencia 7675 asegura la obtencion de una BaseAplicacion para un oidBaseAplicacion. 
     * Pues este oidBaseAplicacion es obtenido para un oidDescuento existente.
     */
    public DTOSBaseAplicacion obtenerDTOBaseAplicacion (DTOOID dto)  throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseAplicacion(): Entrada");

    	/*
        Entrada: DTOOID (oid de base de aplicación) 
        Proceso: 
        -> Crear objeto DTOSBaseAplicacion 
        - oidDescuento : Long 
        - oidBase : Long <- oid del dto de entrada 
        - detalle : array de DTOSBaseAplicacionDetalle 
        - escalones : array de DTOEscalon 
        -> Hacer findByPrimaryKey sobre la entidad BaseAplicacionCabecera 
        -> Tomar el oid de descuento del entity encontrado y setearlo en el DTOSBaseAplicacion creado en el atributo oidDescuento 
        -> Hacer consulta JDBC sobre la tabla DTO_ESCAL para obtener los campos oid, escalaDesde, escalaHasta y porcentaje, filtrando por el oid de base de aplicación del dto de entrada 
        -> Recorrer el RecordSet obtenido 
        Para cada registro del RecordSet hacer: 
        -> Crear objeto DTOEscalon 
        - oidEscalon : Long 
        - escalaDesce : Integer 
        - escalaHasta : Integer 
        - porcentaje : Descuento 
        -> Meter el dto en el array DTOSBaseAplicacion.escalones 
        Fin Para 
        -> Hacer consulta JDBC sobre la tabla DTO_BASE_APLIC_DETAL para obtener marcaProducto, unidadNegocio, negocio, supergenerico, generico, exclusionTipoOferta, tipoOferta, cicloVida y producto y sus descripciones respectivas internacionalizadas (las que sean internacionalizables) de todas las líneas, filtrando por el oid de base de cálculo obtenido en la consulta anterior. 
        -> Recorrer el RecordSet obtenido 
        Para cada registro del RecordSet hacer: 
        -> Crear objeto DTOSBaseAplicacionDetalle vacío 
        - marca : Long 
        - descripcionMarca : String 
        - unidadNegocio : Long 
        - descripcionUnidadNegocio : String 
        - negocio : Long 
        - descripcionNegocio : String 
        - supergenerico : Long 
        - descripcionSupergenerico : String 
        - generico : Long 
        - descripcionGenerico : String 
        - exclusionTipoOferta : Boolean 
        - tipoOferta : Long 
        - descripcionTipoOferta : Long 
        - cicloVida : Long 
        - descripcionCicloVida : String 
        - producto : Long 
        - descripcionProducto : String 
        -> Meter el dto creado en el array DTOSBaseAplicacion.detalle 
        Fin Si 
        Devolver DTOSBaseAplicacion creado. 
        */
        DTOSBaseAplicacion baDTO = new DTOSBaseAplicacion();
        // Si no viene el idioma, se setea el idioma por defecto
        if (dto.getOidIdioma() == null) {
            dto.setOidIdioma(new Long(1));
        }

        try{  
        
            Long oid = dto.getOid();
            baDTO.setOidBase(oid);
            BaseAplicacionCabeceraLocalHome baclh = new BaseAplicacionCabeceraLocalHome();
            BaseAplicacionCabeceraLocal bacl = baclh.findByPrimaryKey(dto.getOid());
            baDTO.setOidDescuento(bacl.getDcto_oid_desc());
            if(bacl.getNum_unid_obli()!= null)
                baDTO.setNumeroUnidadesObligatorias(new Integer(bacl.getNum_unid_obli().intValue()));

            String sql = "  SELECT  "+
            "  		 e.OID_ESLN,        "+
            "		 e.VAL_DESD,        "+
            "		 e.VAL_HAST,        "+
            "		 e.VAL_PORC_DESC    "+
            "  FROM                     "+
            "  	     DTO_ESCLN e        "+
            "  WHERE                    "+
            "  		 e.BACA_OID_CABE =  " + dto.getOid();

            RecordSet rs = UtilidadesDTO.getQuery(sql);
            ArrayList escalas = new ArrayList();

            for(int i = 0 ; i < rs.getRowCount(); i++ ){
                DTOEscalon esc = new DTOEscalon();
                esc.setOidEscalon(UtilidadesDTO.getLong(rs.getValueAt(i,0 )));
                //esc.setEscalaDesde(new Integer(((BigDecimal)rs.getValueAt(i,1 )).intValue()));
                //esc.setEscalaHasta(new Integer(((BigDecimal)rs.getValueAt(i,2 )).intValue()));
                esc.setEscalaDesde((BigDecimal)rs.getValueAt(i,1 ));
                if(rs.getValueAt(i,2 )!=null)
                    esc.setEscalaHasta((BigDecimal)rs.getValueAt(i,2 ));                
                esc.setPorcentajeDescuento(new Double(((BigDecimal)rs.getValueAt(i,3 )).floatValue()));

                UtilidadesLog.debug("Porcentaje de descuento " + rs.getValueAt(i,3 ).toString());

                escalas.add(esc);
            }
            baDTO.setEscalones(escalas);


            if (baDTO.getOidBase()!= null)
            {
                sql = " select " + 
                "    bad.MAPR_OID_MARC_PROD,    "+  //0
                " 		bad.UNEG_OID_UNID_NEGO, "+  //1
                "		bad.NEGO_OID_NEGO,      "+  //2
                "		bad.SGEN_OID_SUPE_GENE, "+  //3
                "		bad.GENE_OID_GENE,      "+  //4
                "		bad.IND_EXCL_TIPO_OFER, "+  //5
                "		bad.TOFE_OID_TIPO_OFER, "+  //6
                "		bad.CIVI_OID_CICL_VIDA, "+  //7
                "		bad.PROD_OID_PROD,      "+  //8
                "		mp.DES_MARC_PROD,       "+  //9
                "		iun.VAL_I18N,           "+  //10
                "		ine.VAL_I18N,           "+  //11
                "		ig.VAL_I18N,            "+  //12
                "		isg.VAL_I18N,           "+  //13
                "		ito.VAL_I18N,           "+  //14
                "		icv.VAL_I18N, 			" + //15				  
                "		ipr.VAL_I18N 			" + //16				  
                " from                          "+
                " 		DTO_BASE_APLIC_DETAL bad,"+
                "        SEG_MARCA_PRODU mp,    "  + 	   
                "        v_gen_i18n_sicc  iun,    "+
                "        v_gen_i18n_sicc  ine,    "+
                "        v_gen_i18n_sicc  ig,     "+
                " 		v_gen_i18n_sicc  isg,     "+
                " 		v_gen_i18n_sicc  ito,     "+
                " 		v_gen_i18n_sicc  icv,     "+
                " 		v_gen_i18n_sicc  ipr      " +
                " where                         " +
                "  	   bad.BACA_OID_CABE =                     "  + "?" +
                "	   and mp.OID_MARC_PROD(+) = bad.MAPR_OID_MARC_PROD "+
                "	   and iun.VAL_OID(+) = bad.UNEG_OID_UNID_NEGO" +
                " 	   and iun.ATTR_ENTI (+)= 'MAE_UNIDA_NEGOC'    "+
                " 	   and iun.ATTR_NUM_ATRI(+) = 1                "+
                " 	   and iun.IDIO_OID_IDIO (+)=                 " + "?" +
                " 	   and ine.VAL_OID (+)= bad.NEGO_OID_NEGO     "+
                " 	   and ine.ATTR_ENTI (+)= 'MAE_NEGOC'          "+
                " 	   and ine.ATTR_NUM_ATRI (+)= 1                "+
                " 	   and ine.IDIO_OID_IDIO (+)=                 " + "?" +
                " 	   and ig.VAL_OID(+) = bad.GENE_OID_GENE      "+
                " 	   and ig.ATTR_ENTI (+)= 'MAE_GENER'           "+
                " 	   and ig.ATTR_NUM_ATRI (+)= 1                 "+
                " 	   and ig.IDIO_OID_IDIO(+) =                  " + "?" +
                " 	   and isg.VAL_OID (+)= bad.SGEN_OID_SUPE_GENE" + 
                " 	   and isg.ATTR_ENTI (+)= 'MAE_SUPER_GENER'    "+
                " 	   and isg.ATTR_NUM_ATRI (+)= 1                "+
                " 	   and isg.IDIO_OID_IDIO (+)=                 " + "?" +
                " 	   and ito.VAL_OID (+)= bad.TOFE_OID_TIPO_OFER" + 
                " 	   and ito.ATTR_ENTI (+)= 'PRE_TIPO_OFERT'     "  + 
                " 	   and ito.ATTR_NUM_ATRI (+)= 1                "+
                " 	   and ito.IDIO_OID_IDIO(+) =                 " + "?" +
                " 	   and icv.VAL_OID (+)= bad.CIVI_OID_CICL_VIDA" + 
                " 	   and icv.ATTR_ENTI (+)= 'PRE_CICLO_VIDA'     "+
                " 	   and icv.ATTR_NUM_ATRI (+)= 1                "+
                " 	   and icv.IDIO_OID_IDIO (+)=                 " + "?" +
                "      and ipr.VAL_OID(+) = bad.PROD_OID_PROD     " +            
                "      and ipr.ATTR_ENTI(+) = 'MAE_PRODU'          " + 
                " 	   and ipr.ATTR_NUM_ATRI(+) = 1                " + 
                " 	   and ipr.IDIO_OID_IDIO(+) =                  "+ "?" ;

            Vector params = new Vector();
            params.add(baDTO.getOidBase());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());
            params.add(dto.getOidIdioma());

            rs = UtilidadesDTO.getQuery(sql, params);
                ArrayList detalle = new ArrayList();

            for(int i = 0 ; i < rs.getRowCount(); i++ ){
                DTOSBaseAplicacionDetalle det = new DTOSBaseAplicacionDetalle();
                if(rs.getValueAt(i,0)!=null){
                    det.setMarca(UtilidadesDTO.getLong(rs.getValueAt(i,0)));
                    det.setDescripcionMarca((String)rs.getValueAt(i,9));
                }

                if(rs.getValueAt(i,1)!=null){
                    det.setUnidadNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,1)));
                    det.setDescripcionUnidadNegocio((String)rs.getValueAt(i,10));
                }

                if(rs.getValueAt(i,2)!=null){
                    det.setNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,2)));
                    det.setDescripcionNegocio((String)rs.getValueAt(i,11));
                }

                if(rs.getValueAt(i,3)!=null){
                    det.setSupergenerico(UtilidadesDTO.getLong(rs.getValueAt(i,3)));
                    det.setDescripcionSupergenerico((String)rs.getValueAt(i,13));
                }

                if(rs.getValueAt(i,4)!=null){
                    det.setGenerico(UtilidadesDTO.getLong(rs.getValueAt(i,4)));
                    det.setDescripcionGenerico((String)rs.getValueAt(i,12));
                }

                if ((rs.getValueAt(i,5)) == null) {
                    det.setExclusionTipoOferta(Boolean.FALSE);
                } else {
                    det.setExclusionTipoOferta(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(rs.getValueAt(i,5))));
                }

				if(rs.getValueAt(i,6)!=null){
					det.setTipoOferta(UtilidadesDTO.getLong(rs.getValueAt(i,6)));
	                det.setDescripcionTipoOferta((String)rs.getValueAt(i,14));
				}

                det.setCicloVida(UtilidadesDTO.getLong(rs.getValueAt(i,7)));
                det.setDescripcionCicloVida((String)rs.getValueAt(i,15));

                if(rs.getValueAt(i,8)!=null){
                    det.setProducto(UtilidadesDTO.getLong(rs.getValueAt(i,8)));
                    det.setDescripcionProducto((String)rs.getValueAt(i,16));
                }
        
                detalle.add(det);
            }
            baDTO.setDetalle(detalle);
        }
        }catch(NoResultException e){
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseAplicacion(): Salida");

        return baDTO;
	}
    
    public DTOSBaseAplicacion obtenerDTOBaseAplicacionBatch (DTOOID dto)  throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseAplicacionBatch(): Entrada");
        DTOSBaseAplicacion baDTO = new DTOSBaseAplicacion();
        // Si no viene el idioma, se setea el idioma por defecto
        if (dto.getOidIdioma() == null) {
            dto.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
        }

        try{  
        
            Long oid = dto.getOid();
            baDTO.setOidBase(oid);
            BaseAplicacionCabeceraLocalHome baclh = new BaseAplicacionCabeceraLocalHome();
            BaseAplicacionCabeceraLocal bacl = baclh.findByPrimaryKey(dto.getOid());
            baDTO.setOidDescuento(bacl.getDcto_oid_desc());
            if(bacl.getNum_unid_obli()!= null)
                baDTO.setNumeroUnidadesObligatorias(new Integer(bacl.getNum_unid_obli().intValue()));

            String sql = "  SELECT  "+
            "  		 e.OID_ESLN,        "+
            "		 e.VAL_DESD,        "+
            "		 e.VAL_HAST,        "+
            "		 e.VAL_PORC_DESC    "+
            "  FROM                     "+
            "  	     DTO_ESCLN e        "+
            "  WHERE                    "+
            "  		 e.BACA_OID_CABE =  " + dto.getOid();

            RecordSet rs = UtilidadesDTO.getQuery(sql);
            ArrayList escalas = new ArrayList();

            for(int i = 0 ; i < rs.getRowCount(); i++ ){
                DTOEscalon esc = new DTOEscalon();
                esc.setOidEscalon(UtilidadesDTO.getLong(rs.getValueAt(i,0 )));
                //esc.setEscalaDesde(new Integer(((BigDecimal)rs.getValueAt(i,1 )).intValue()));
                //esc.setEscalaHasta(new Integer(((BigDecimal)rs.getValueAt(i,2 )).intValue()));
                esc.setEscalaDesde((BigDecimal)rs.getValueAt(i,1 ));
                if(rs.getValueAt(i,2 )!=null)
                    esc.setEscalaHasta((BigDecimal)rs.getValueAt(i,2 ));                
                esc.setPorcentajeDescuento(new Double(((BigDecimal)rs.getValueAt(i,3 )).floatValue()));

                UtilidadesLog.debug("Porcentaje de descuento " + rs.getValueAt(i,3 ).toString());

                escalas.add(esc);
            }
            baDTO.setEscalones(escalas);


            if (baDTO.getOidBase()!= null)
            {
                sql = " select " + 
                "    bad.MAPR_OID_MARC_PROD,    "+  //0
                " 		bad.UNEG_OID_UNID_NEGO, "+  //1
                "		bad.NEGO_OID_NEGO,      "+  //2
                "		bad.SGEN_OID_SUPE_GENE, "+  //3
                "		bad.GENE_OID_GENE,      "+  //4
                "		bad.IND_EXCL_TIPO_OFER, "+  //5
                "		bad.TOFE_OID_TIPO_OFER, "+  //6
                "		bad.CIVI_OID_CICL_VIDA, "+  //7
                "		bad.PROD_OID_PROD,      "+  //8
                "		smp.DES_MARC_PROD, "+
                "		PQ_APL_AUX.Valor_Gen_I18n_Sicc("+ConstantesSEG.IDIOMA_DEFECTO+",bad.uneg_oid_unid_nego ,'MAE_UNIDA_NEGOC') as desUnidadNegocio, "+
                "		PQ_APL_AUX.Valor_Gen_I18n_Sicc("+ConstantesSEG.IDIOMA_DEFECTO+",bad.nego_oid_nego ,'MAE_NEGOC') as desNegocio "+
                " from                          "+
                " 		DTO_BASE_APLIC_DETAL bad, SEG_MARCA_PRODU smp "+
                " where                         "+
                "      bad.MAPR_OID_MARC_PROD = smp.OID_MARC_PROD(+) "+
                "  	   AND bad.BACA_OID_CABE =                     "  + "?";

            Vector params = new Vector();
            params.add(baDTO.getOidBase());
            rs = UtilidadesDTO.getQuery(sql, params);
                ArrayList detalle = new ArrayList();

            for(int i = 0 ; i < rs.getRowCount(); i++ ){
                DTOSBaseAplicacionDetalle det = new DTOSBaseAplicacionDetalle();
                if(rs.getValueAt(i,0)!=null){
                    det.setMarca(UtilidadesDTO.getLong(rs.getValueAt(i,0)));
                }

                if(rs.getValueAt(i,1)!=null){
                    det.setUnidadNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,1)));
                }

                if(rs.getValueAt(i,2)!=null){
                    det.setNegocio(UtilidadesDTO.getLong(rs.getValueAt(i,2)));
                }

                if(rs.getValueAt(i,3)!=null){
                    det.setSupergenerico(UtilidadesDTO.getLong(rs.getValueAt(i,3)));
                }

                if(rs.getValueAt(i,4)!=null){
                    det.setGenerico(UtilidadesDTO.getLong(rs.getValueAt(i,4)));
                }

                if ((rs.getValueAt(i,5)) == null) {
                    det.setExclusionTipoOferta(Boolean.FALSE);
                } else {
                    det.setExclusionTipoOferta(UtilidadesDTO.getBoole(UtilidadesDTO.getLong(rs.getValueAt(i,5))));
                }

                if(rs.getValueAt(i,6)!=null){
                    det.setTipoOferta(UtilidadesDTO.getLong(rs.getValueAt(i,6)));
                }

                det.setCicloVida(UtilidadesDTO.getLong(rs.getValueAt(i,7)));

                if(rs.getValueAt(i,8)!=null){
                    det.setProducto(UtilidadesDTO.getLong(rs.getValueAt(i,8)));
                }

                if(rs.getValueAt(i,9)!=null){
                    det.setDescripcionMarca(rs.getValueAt(i,9).toString());
                }

                if(rs.getValueAt(i,10)!=null){
                    det.setDescripcionUnidadNegocio(rs.getValueAt(i,10).toString());
                }

                if(rs.getValueAt(i,11)!=null){
                    det.setDescripcionNegocio(rs.getValueAt(i,11).toString());
                }
        
                detalle.add(det);
            }
            baDTO.setDetalle(detalle);
        }
        }catch(NoResultException e){
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODescuento.obtenerDTOBaseAplicacion(): Salida");

        return baDTO;
    }

    /**
     * Retorna RecordSet con las basesAplicacion para un oidDescuento.
     */
    public RecordSet consultarBasesAplicacionDTO (Long oidDescuento) throws MareException{
        UtilidadesLog.info("DAODescuento.consultarBasesAplicacionDTO(): Entrada");

        /*    
        Entrada: oidDescuento 
        Proceso: 
        -> Hacer consulta JDBC sobre la tabla DTO_BASE_APLIC_CABEC filtrando por el oidDescuento de entrada y obteniendo el oid de base de aplicación de todos los registros que se encuentren. 
        -> Devolver RecordSet obtenido de la consulta
        */
        String sql = " SELECT        " +
            "		 bac.OID_CABE   " +
            "	FROM                " +
            "		 DTO_BASE_APLIC_CABEC bac " +
            "	WHERE               " +
            "	     bac.DCTO_OID_DESC = " + oidDescuento;

        UtilidadesLog.info("DAODescuento.consultarBasesAplicacionDTO(): Salida");

        return UtilidadesDTO.getQuery(sql);
    }
    
   
    /**
     * 
     */
	public DTOSalida obtenerDTOAlcanceClasificacion (DTOEBuscarAlcanceClasificacionDTO dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceClasificacion(): Entrada");
        /*
        Entrada: DTOEBuscarAlcanceClasificacionDTO (oid de descuento) 
        Proceso: 
        -> Hacer consutla JDBC sobre la tabla DTO_ALCAN_DTO_CLASI_CLIEN filtrando por oid de descuento, y obtener la descripción internacionalizada del Tipo de Clasificación, la descripción internazionalizada de la clasificación y el porcentaje de descuento adicional, haciendo las join correspondientes con la tabla MAE_CLASI_CLIEN y MAE_TIPO_CLASI. Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 
        -> Devolver el RecordSet obtenido en un objeto DTOSalida
        */
        // vbongiov -- cambio DTO-08 -- 3/07/2008
        // se reemplaza la obtencion del campo cc.VAL_PORC_ADIC por 0
		String sQuery = " select cc.OID_ALCA_DTO_CLAS_CLTE oid , i2.VAL_I18N tipo_clas  ,i.VAL_I18N clasificacion  ,  0 VAL_PORC_ADIC " +
 		" from " +
		 " DTO_ALCAN_DTO_CLASI_CLIEN cc, " +
		 " v_gen_i18n_sicc i, " +
 		" v_gen_i18n_sicc i2, " +
		" MAE_CLASI mcc, " +
		" MAE_TIPO_CLASI_CLIEN mtc	" +
		" where DCTO_OID_DESC = ? " +
		" and cc.CLAS_OID_CLAS = mcc.OID_CLAS(+)  " +
		" and i.ATTR_ENTI(+) = 'MAE_CLASI'  " +
		" and i.VAL_OID(+) = mcc.OID_CLAS " +
        "   AND i.ATTR_NUM_ATRI(+) = 1 " +
		" and i2.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' " +
        "   AND i2.ATTR_NUM_ATRI = 1 " +
		" and i2.VAL_OID = mtc.OID_TIPO_CLAS " +
		" and cc.TCCL_OID_TIPO_CLAS = mtc.OID_TIPO_CLAS " +
		" and i.IDIO_OID_IDIO(+) = ? " +
		" and i2.IDIO_OID_IDIO = ? " ;

		Vector vec = new Vector();
		vec.addElement(dto.getOidDescuento());
		vec.addElement(dto.getOidIdioma());
		vec.addElement(dto.getOidIdioma());
		DTOSalida dtos = new DTOSalida();
		dtos.setResultado(UtilidadesDTO.getQuery(UtilidadesPaginacion.armarQueryPaginacion(sQuery,dto), vec));
        UtilidadesLog.info("DAODescuento.obtenerDTOAlcanceClasificacion(): Salida");

		return dtos;
	}



// // **************************************************************************************	
// // Metodos generales
// // **************************************************************************************

	private Vector getDescripcion(Long oid, Long idioma) throws MareException {
        UtilidadesLog.info("DAODescuento.getDescripcion(): Entrada");
        
        Long idiomaChequeado;
		try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }


       idiomaChequeado = idioma;

		StringBuffer sQuery = new StringBuffer();
    
    sQuery.append("SELECT i.val_i18n ");
    sQuery.append(", i.IDIO_OID_IDIO ");
		sQuery.append("FROM gen_i18n_sicc_pais i ");
		sQuery.append("WHERE i.attr_enti = 'DTO_DESCU' ");
    sQuery.append("AND i.ATTR_NUM_ATRI = 1 ");
    if (idioma!=null){
      sQuery.append("AND i.idio_oid_idio =  ? ");
    }
		sQuery.append("AND i.val_oid = ? ");

		Vector bindVar  = new Vector();
    if (idioma!=null){
        bindVar.add(idiomaChequeado);
    }
		bindVar.add(oid);
	
		RecordSet r = null;
		try {
			UtilidadesLog.debug(" - Ejecuta la consulta");
			r = bs.dbService.executePreparedQuery(sQuery.toString(),bindVar);
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        Vector i18nVec  = new Vector();
        for (int i=0;i<r.getRowCount();i++){
          DTOI18nSICC inter = new DTOI18nSICC();
          inter.setOidAtriuto(new Long(1));
          inter.setValorI18n(r.getValueAt(i,0).toString());
          inter.setOidIdioma(new Long(((BigDecimal)r.getValueAt(i, 1)).longValue()));
          i18nVec.add(inter);
        }
        UtilidadesLog.info("DAODescuento.getDescripcion(): Salida");
        
        return i18nVec;
	}



    private String getDescripcionStr(Long oid, Long idioma) throws MareException {
        UtilidadesLog.info("DAODescuento.getDescripcionStr(): Entrada");
        Long idiomaChequeado;
		try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        // Si no viene el idioma, se setea el idioma por defecto
        if (idioma != null) {
            idiomaChequeado = idioma;
        } else {
            idiomaChequeado = new Long(1);
        }

		String sQuery = "SELECT i.val_i18n " +
				"FROM v_gen_i18n_sicc i " +
				"WHERE i.attr_enti = 'DTO_DESCU' "+
                "   AND i.ATTR_NUM_ATRI = 1 " +
			    "AND i.idio_oid_idio =  ? " + 
				"AND i.val_oid = ? " ; 

		Vector bindVar  = new Vector();
		bindVar.add(idiomaChequeado);
		bindVar.add(oid);
	
		RecordSet r = null;
		try {
			UtilidadesLog.debug(" - Ejecuta la consulta");
			r = bs.dbService.executePreparedQuery(sQuery,bindVar);
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        UtilidadesLog.info("DAODescuento.getDescripcionStr(): Salida");
        if (r.esVacio() || r.getValueAt(0,0)== null){
            return "";
        }else{
            return r.getValueAt(0,0).toString();
        }

	}




	private DTOOIDs getAccesos(Long oid) throws MareException{
        UtilidadesLog.info("DAODescuento.getAccesos(): Entrada");

		//String sQuery = "select OID_DESC_ACCE "  +
		String sQuery = "select ACCE_OID_ACCE "  +        
						"from DTO_DESCU_ACCES " +
						"where DCTO_OID_DESC = " + oid ; 
	
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
		DTOOIDs oids = new DTOOIDs();
		oids.setOids(UtilidadesDTO.vec2Longs(getDataColumns(r)));
        UtilidadesLog.info("DAODescuento.getAccesos(): Salida");

		return oids;
		
	}
//Hacer consulta JDBC sobre la tabla DTO_DESCU_TIPO_CLIEN, obtener los campos TICL_OID_TIPO_CLIE y haciendo join con la tabla MAE_TIPO_CLIEN obtener la descripción internacionalizada del tipo de cliente, filtrando por el campo DCTO_OID_DESC = oid del dto de entrada 
	private RecordSet getTipoClient(Long oid, Long idioma) throws MareException{
        UtilidadesLog.info("DAODescuento.getTipoClient(): Entrada");
		
		String sQuery = "select " + 
        "    	dtc.TICL_OID_TIPO_CLIE, i.VAL_I18N  " + 
        "        from " + 
        "    	DTO_DESCU_TIPO_CLIEN dtc, " + 
        "    	MAE_TIPO_CLIEN mtc, " + 
        "    	GEN_i18n_sicc i " + 
        "        where " + 
        "        dtc.DCTO_OID_DESC = " + oid +  
        "        and dtc.TICL_OID_TIPO_CLIE = mtc.OID_TIPO_CLIE " + 
        "        and i.VAL_OID = dtc.TICL_OID_TIPO_CLIE " + 
        "        and i.ATTR_NUM_ATRI = 1 " + 
        "        and i.IDIO_OID_IDIO = " + idioma + 
        "        and i.ATTR_ENTI = 'MAE_TIPO_CLIEN'" ; 
	
    UtilidadesLog.info("sQuery"+sQuery);
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
        UtilidadesLog.info("DAODescuento.getTipoClient(): Salida");
 
		return r;
        
	}


    private Vector getDataColumns(RecordSet rs ){
       UtilidadesLog.info("DAODescuento.getDataColumns(): Entrada");
        Vector dat = new Vector();
        for(int i = 0 ; i < rs.getRowCount(); i++){
            UtilidadesLog.debug("rs.getValueAt(0, i) : " + rs.getValueAt(i, 0));
            dat.add(new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue()));
        }
        UtilidadesLog.info("DAODescuento.getDataColumns(): Salida");
        return dat;
    }
    
//Hacer consulta JDBC sobre la tabla DTO_DESCU_SUBTI_CLIEN, obtener los campos SBTI_OID_SUBT_CLIE y haciendo join con la tabla MAE_SUBTI_CLIEN obtener la descripción internacionalizada del subtipo de cliente y el campo MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE 

	private RecordSet getSubTipoClient(Long oid, Long idioma) throws MareException {
       UtilidadesLog.info("DAODescuento.getSubTipoClient(): Entrada");

		String sQuery = "select " + 
"	stc.SBTI_OID_SUBT_CLIE, i.VAL_I18N, mst.TICL_OID_TIPO_CLIE  " +
"   from " + 
"	DTO_DESCU_SUBTI_CLIEN stc, " + 
"	MAE_SUBTI_CLIEN mst, " + 
"	GEN_i18n_sicc i " + 
"   where " + 
"   stc.DCTO_OID_DESC = " + oid +
"   and stc.SBTI_OID_SUBT_CLIE = mst.OID_SUBT_CLIE  " + 
"   and i.VAL_OID = stc.SBTI_OID_SUBT_CLIE " + 
"   and i.ATTR_NUM_ATRI = 1 " + 
"   and i.IDIO_OID_IDIO = " + idioma + 
"   and i.ATTR_ENTI = 'MAE_SUBTI_CLIEN' "; 
	
    UtilidadesLog.info("sQuery"+sQuery);
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
       UtilidadesLog.info("DAODescuento.getSubTipoClient(): Salida");

		return r;
		
	}
	//-> Hacer consutla JDBC sobre la tabla DTO_ALCAN_DTO_CLASI_CLIEN filtrando por oid de descuento, y obtener los campos

	private RecordSet getAlcanceClasif(DTOOID dto) throws MareException{
       UtilidadesLog.info("DAODescuento.getAlcanceClasif(): Entrada");

        // Hacer consutla JDBC sobre la tabla DTO_ALCAN_DTO_CLASI_CLIEN filtrando por oid de descuento, 
        // y obtener la descripción internacionalizada del Tipo de Clasificación, la descripción internazionalizada 
        // de la clasificación y el porcentaje de descuento adicional, haciendo las join correspondientes con la 
        // tabla MAE_CLASI_CLIEN y MAE_TIPO_CLASI. Esta consulta es paginada, por tanto habra que tener en cuenta 
        // las siguientes consideraciones: 

		//String sQuery = "select OID_ALCA_DTO_CLAS_CLTE, i.VAL_I18N, i2.VAL_I18N, cc.VAL_PORC_ADIC, cl.TCCL_OID_TIPO_CLAS   " + 
        
        // vbongiov -- cambio DTO-08 -- 3/07/2008
        // se reemplaza la obtencion del campo cc.VAL_PORC_ADIC por 0
		String sQuery = "select CLAS_OID_CLAS, i.VAL_I18N, i2.VAL_I18N, 0 VAL_PORC_ADIC, cc.TCCL_OID_TIPO_CLAS   " + 
                        " from DTO_ALCAN_DTO_CLASI_CLIEN cc,  " +
                        " v_gen_i18n_sicc i, " + 
                        " v_gen_i18n_sicc i2, " +  
                        " MAE_CLASI cl " +
                        //" ,MAE_TIPO_CLASI_CLIEN tc " +
                        " where DCTO_OID_DESC = " + dto.getOid() + 
                        " and i.ATTR_ENTI(+) = 'MAE_CLASI' " +
                        " and i.IDIO_OID_IDIO(+) = " +  dto.getOidIdioma() +
                        " and i.VAL_OID(+) = cl.OID_CLAS " + 
                        "   AND i.ATTR_NUM_ATRI(+) = 1 " +
                        " and i2.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' " +
                        "   AND i2.ATTR_NUM_ATRI = 1 " +
                        " and i2.IDIO_OID_IDIO =  " + dto.getOidIdioma() + 
                        " and i2.VAL_OID = cc.TCCL_OID_TIPO_CLAS " +
                        " and cc.CLAS_OID_CLAS = cl.OID_CLAS(+) ";
   		RecordSet r = UtilidadesDTO.getQuery(sQuery);
        UtilidadesLog.info("DAODescuento.getAlcanceClasif(): Salida");

		return r;
	}


	public Integer ultimoNumeroCorrelativo (Long pais, Long marca, Long canal) throws MareException{
        UtilidadesLog.info("DAODescuento.ultimoNumeroCorrelativo(): Entrada");
        /*
            Entrada: pais (oidPais), marca (oidMarca), canal (oidCanal) 
        Proceso: 
        -> Hacer consulta JDBC sobre la tabla DTO_DESCU para obtener el máximo número correlativo para los criterios de entrada: pais, marca y canal. 
        -> Devolver el número obtenido en un Integer.
        */
		try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		String sQuery = "	select max(NUM_DESC_CORR) "	+
						"	from DTO_DESCU       "	+
						"	where 				 "	+
						"	PAIS_OID_PAIS = ?	 "	+
						"	and    MARC_OID_MARC = ? "	+
						"	and CANA_OID_CANA = ? ";

		Vector bindVar  = new Vector();
		bindVar.add(pais);
		bindVar.add(marca);
		bindVar.add(canal);	

		RecordSet r = null;
		try {
			r = bs.dbService.executePreparedQuery(sQuery,bindVar);
            UtilidadesLog.debug("RecordSet " + r);
            if(r.getValueAt(0,0) == null){
                return new Integer(1) ;
            }
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        UtilidadesLog.info("DAODescuento.ultimoNumeroCorrelativo(): Salida");

		return new Integer(((BigDecimal)r.getValueAt(0,0)).intValue()+1);
	}
 
 
	public Integer ultimoNumeroDescuentoPais(Long pais) throws MareException{
        UtilidadesLog.info("DAODescuento.ultimoNumeroDescuentoPais(): Entrada");
		try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		String sQuery = "	select max(NUM_DESC) "	+
						"	from DTO_DESCU       "	+
						"	where 				 "	+
						"	PAIS_OID_PAIS = ?	 ";


		Vector bindVar  = new Vector();
		bindVar.add(pais);

		RecordSet r = null;
		try {
			r = bs.dbService.executePreparedQuery(sQuery,bindVar);
            UtilidadesLog.debug("RecordSet " + r);
            if(r.getValueAt(0,0) == null){
                return new Integer(0);
            }
		} catch(Exception e) {
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}
        UtilidadesLog.info("DAODescuento.ultimoNumeroDescuentoPais(): Salida");
     
		return  new Integer(((BigDecimal)r.getValueAt(0,0)).intValue()+1);
	}


    public RecordSet obtenerAccesosDescuento (Long oidDescuento)throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerAccesosDescuento(): Entrada");

    /*
        Entrada: oidDescuento 
        Proceso: 
        -> Hacer consulta JDBC sobre la entidad DTO_DESCU_ACCES para obtener el campo OID_DESC_ACCE, filtrando por el campo DCTO_OID_DESC = oidDescuento 
        -> Devolver RecordSet obtenido
     */
        String sQuery = "select OID_DESC_ACCE "  +
						"from DTO_DESCU_ACCES " +
						"where DCTO_OID_DESC = " + oidDescuento ; 
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
        UtilidadesLog.info("DAODescuento.obtenerAccesosDescuento(): Salida");
        return r;
    }

    public RecordSet obtenerSubaccesosDescuento (Long oidDescuento) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosDescuento(): Entrada");

    /*
        Entrada: oidDescuento 
        Proceso:  
        -> Hacer consulta JDBC sobre la entidad DTO_DESCU_ACCES para obtener el campo OID_DESC_ACCE, filtrando por el campo DCTO_OID_DESC = oidDescuento 
        -> Devolver RecordSet obtenido
     */
        String sQuery = "select OID_DESC_SBAC "  +
						"from DTO_DESCU_SUBAC " +
						"where DCTO_OID_DESC = " + oidDescuento ; 
		RecordSet r = UtilidadesDTO.getQuery(sQuery);
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosDescuento(): Salida");
        return r;
    }


	
	private DTOOIDs getSubAccesos(Long oid) throws MareException {
        UtilidadesLog.info("DAODescuento.getSubAccesos(): Entrada");
		
		//String sql1 = "select OID_DESC_SBAC "  +
		String sql1 = "select SBAC_OID_SBAC "  +        
						"from DTO_DESCU_SUBAC " +
						"where DCTO_OID_DESC = " + oid ; 

		RecordSet r = UtilidadesDTO.getQuery(sql1);
		DTOOIDs oids = new DTOOIDs();
		oids.setOids(UtilidadesDTO.vec2Longs(getDataColumns(r)));
        UtilidadesLog.info("DAODescuento.getSubAccesos(): Salida");

		return oids;
	}
  

   /**
    * CHANGELOG
    * ---------
    * cvalenzu, 25/02/2005 - Se ha agregado la funcion to_date, para el manejo de las fechas
    * dmorello, 19/11/2008 - Se elimina de la query la tabla DTO_HISTO_DTO, ya inexistente
    */
    public DTOSalida buscarClientesDTO(DTOEBuscarClientesDTO dto) throws MareException { 
        UtilidadesLog.info("DAODescuento.buscarClientesDTO(): Entrada");
        
          DTOSalida dtoSalida = new DTOSalida(); 
          StringBuffer query = new StringBuffer(); 
          RecordSet rs; 
    
          Long oidCliente = null; 
    
          MAEEjbLocators maeEJB = new MAEEjbLocators(); 
    
          if(dto.getOidCliente()!=null) { 
            UtilidadesLog.debug("********* oid de Cliente = " + dto.getOidCliente()); 
            UtilidadesLog.debug("********* codigo de Cliente = " + dto.getCodigoCliente()); 
            oidCliente = dto.getOidCliente(); 
          }           
    
          if((dto.getOidCliente()==null) && (dto.getCodigoCliente() != null)) { 
            UtilidadesLog.debug("********* oid de Cliente = null "); 
            UtilidadesLog.debug("********* codigo de Cliente = " + dto.getCodigoCliente()); 
            UtilidadesLog.debug("********* Obteniendo el oid de Cliente del MONClientes "); 
    
            try { 
              MONClientesHome mch = maeEJB.getMONClientesHome(); 
              MONClientes mc = mch.create();         
              oidCliente = mc.obtenerOidCliente(dto.getOidPais(), dto.getCodigoCliente()); 
              UtilidadesLog.debug("********* oid de Cliente = " + oidCliente);           
            } 
            catch(Exception ex) { 
              UtilidadesLog.error(ex); 
            }         
              
    
            if(oidCliente==null) { 
              UtilidadesLog.debug("********* No se encontro el oid de Cliente para el codigo " + dto.getCodigoCliente()); 
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)); 
            }           
          }     
    
          query.append(" SELECT DISTINCT m.OID_CLIE AS oid, m.COD_CLIE, m.VAL_NOM1 || ' ' || m.VAL_NOM2 AS NOMBRE, ");   
          query.append(" m.VAL_APE1 || ' ' || m.VAL_APE2 AS APELLIDO "); 
    
          query.append(" FROM MAE_CLIEN m, PED_SOLIC_CABEC p, "); 
          query.append(" CRA_PERIO c"); 
          if(dto.getPeriodoDesde()!=null) { 
              query.append(", CRA_PERIO perio_ini "); 
          } 
          if(dto.getPeriodoHasta()!=null) { 
              query.append(", CRA_PERIO perio_fin "); 
          } 
    
          query.append(" WHERE p.CLIE_OID_CLIE = m.OID_CLIE "); 
    
          if(oidCliente!=null) { 
            query.append(" and m.OID_CLIE = " + oidCliente.toString());   
          }     
          
          query.append(" and p.PERD_OID_PERI = c.OID_PERI "); 
    
          if(dto.getOidMarca()!=null) { 
            query.append(" and c.MARC_OID_MARC = " + dto.getOidMarca().toString());   
          } 
    
          if(dto.getOidCanal()!=null) { 
            query.append(" and c.CANA_OID_CANA = " + dto.getOidCanal().toString());   
          }     
          
          query.append(" and c.PAIS_OID_PAIS = " + dto.getOidPais().toString()); 
    
          if(dto.getPeriodoDesde()!=null) { 
            query.append(" and perio_ini.OID_PERI = " + dto.getPeriodoDesde().toString());         
            query.append(" and perio_ini.FEC_INIC <= c.FEC_INIC ");       
          }     
    
          if(dto.getPeriodoHasta()!=null) { 
            query.append(" and perio_fin.OID_PERI = " + dto.getPeriodoHasta().toString());         
            query.append(" and perio_fin.FEC_FINA >= c.FEC_FINA "); 
          }       
          
          try { 
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto)); 
          } 
          catch (Exception e) { 
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
          } 
          
          if (rs.esVacio()) { 
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)); 
          } 
          
          dtoSalida.setResultado(rs); 
          UtilidadesLog.info("DAODescuento.buscarClientesDTO(): Salida");
          return dtoSalida;     
    } 
  
  
  /**
   * CHANGELOG
   * ---------
   * cvalenzu, 25/02/2005 - Se ha agregado la funcion to_date, para el manejo de las fechas
   * dmorello, 19/11/2008 - Se elimina de la query la tabla DTO_HISTO_DTO, ya inexistente
   */
  public DTOSalida buscarSolicitudesPorClienteDTO(DTOEBuscarSolicitudesClienteDTO dto) throws MareException {
        UtilidadesLog.info("DAODescuento.buscarSolicitudesPorClienteDTO(): Entrada");
          
    DTOSalida dtoSalida = new DTOSalida();
    StringBuffer query = new StringBuffer();
    RecordSet rs;

    query.append(" SELECT DISTINCT p.OID_SOLI_CABE as oid, p.VAL_NUME_SOLI, ");   
    query.append(" p.FEC_CRON, p.VAL_PREC_CATA_TOTA_LOCA, p.VAL_IMPO_DESC_3_TOTA_LOCA ");

    query.append(" FROM PED_SOLIC_CABEC p, CRA_PERIO c, ");
    query.append(" CRA_PERIO perio_ini, CRA_PERIO perio_fin ");

    query.append(" WHERE p.CLIE_OID_CLIE = " + dto.getOidCliente().toString());      
    query.append(" and p.PERD_OID_PERI = c.OID_PERI ");

    if(dto.getOidMarca()!=null) {
      query.append(" and c.MARC_OID_MARC = " + dto.getOidMarca().toString());  
    }

    if(dto.getOidCanal()!=null) {
      query.append(" and c.CANA_OID_CANA = " + dto.getOidCanal().toString());  
    }

    if(dto.getOidPais()!=null) {
      query.append(" and c.PAIS_OID_PAIS = " + dto.getOidPais().toString());  
    }

    if(dto.getPeriodoDesde()!=null) {
      query.append(" and perio_ini.OID_PERI = " + dto.getPeriodoDesde().toString());        
      query.append(" and perio_ini.FEC_INIC <= c.FEC_INIC ");   
    }   

    if(dto.getPeriodoHasta()!=null) {
      query.append(" and perio_fin.OID_PERI = " + dto.getPeriodoHasta().toString());      
      query.append(" and perio_fin.FEC_FINA >= c.FEC_FINA ");
    }   
      
    try {
      rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
      
    if (rs.esVacio()) {
      throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
      
    dtoSalida.setResultado(rs);
    UtilidadesLog.info("DAODescuento.buscarSolicitudesPorClienteDTO(): Salida");
    return dtoSalida;    
  }


  /**
   * CHANGELOG
   * ---------
   * dmorello, 25/11/2008 - Dado que DTO_HISTO_DTO no existe mas, se dejan en NULL
   *                        los valores que se obtenian de esa tabla
   */
  public DTOSalida buscarDetalleSolicitudDTO(DTOEBuscarDetalleSolicitudDTO dto) throws MareException {
        UtilidadesLog.info("DAODescuento.buscarDetalleSolicitudDTO(): Entrada");

    DTOSalida dtoSalida = new DTOSalida();
    StringBuffer query = new StringBuffer();
    RecordSet rs;

    query.append("  SELECT DISTINCT o.prod_oid_prod AS OID, s.val_codi_vent, m.des_cort,  "); 
    query.append("                  s.num_unid_dema,  "); 
    query.append("                  NULL AS val_base_calc,  "); 
    query.append("                  s.val_porc_desc, s.val_impo_desc_tota_loca,  "); 
    query.append("                  DECODE (ind_afec_fact,  "); 
    query.append("                          1, 'Facturas',  "); 
    query.append("                          'Cuentas Corrientes'  "); 
    query.append("                         ) AS aplicar,  "); 
    query.append("                  e.fec_fact, NULL AS fec_proc, t.ind_afec_cc, s.ofde_oid_deta_ofer,  "); 
    query.append("                  o.tofe_oid_tipo_ofer, o.civi_oid_ciclo_vida, s.oid_soli_posi  "); 
    query.append("             FROM ped_solic_posic s,  "); 
    query.append("                  pre_ofert_detal o,  "); 
    query.append("                  mae_produ m,  "); 
    query.append("                  pre_matri_factu f,  "); 
    query.append("                  dto_descu t,  "); 
    query.append("                  ped_solic_cabec e  "); 
    query.append("            WHERE s.soca_oid_soli_cabe =   " + dto.getOidSolicitudCabecera().toString()); 
    query.append("              AND o.oid_deta_ofer = s.ofde_oid_deta_ofer  "); 
    query.append("              AND m.oid_prod = o.prod_oid_prod  "); 
    query.append("              AND f.ofde_oid_deta_ofer = o.oid_deta_ofer  "); 
    query.append("              AND o.oid_deta_ofer = s.ofde_oid_deta_ofer  "); 
    query.append("              AND e.oid_soli_cabe = s.soca_oid_soli_cabe  "); 
      
      
    try {
      rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
      
    if (rs.esVacio()) {
      throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
      
    dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAODescuento.buscarDetalleSolicitudDTO(): Salida");

    return dtoSalida;      
  }  


    /**
     * 
     */
    public DTOSalida obtenerDescuentosActivos(DTOSiccPaginacion dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerDescuentosActivos() Entrada");
        /*            
        Entrada: 
        - dto : DTOSiccPaginacion 
        Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_DESCU para obtener los campos OID_DESC, NUM_DESC, descripción internacionalizada del descuento y IND_APRO 
        -> Haciendo join con DTO_DESCU_TIPO_CLIEN recuperar la concatenación de las descripciones de todos los tipos de cliente separadas por comas. 
        -> Haciendo join con CRA_PERIO, DTO_DESCU.PERD_OID_PERI = CRA_PERIO.OID_PERI obtener la descripción internacionalizada del periodo desde 
        -> Haciendo join con CRA_PERIO, DTO_DESCU.PERD_OID_PERI_LIMI_FIN = CRA_PERIO.OID_PERI obtener la descripción internacionalizada del periodo hasta 
        -> Filtrar por el campo DTO_DESCU.PAIS_OID_PAIS = dto.pais 

        -> Se obtiene un RecordSet con los campos en este orden: 

        - oidDescuento (columna oculta) 
        - numeroDescuento 
        - descripcionDescuento 
        - concatenación de descripciones de tipo de cliente 
        - descripcionPeriodoDesde 
        - descripcionPeriodoHasta 
        - aprobado. 

        Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 

        -> Devolver RecordSet obtenido en objeto DTOSalida
        */
String sql ="    SELECT  " +
            " d.OID_DESC OID, d.NUM_DESC, i.val_i18n descu ,'', pd.VAL_NOMB_PERI peri1, ph.VAL_NOMB_PERI peri2, d.IND_APRO " +
            " FROM  " + 
		   " DTO_DESCU d,  " +
    	   " v_gen_i18n_sicc i, " + 
		   " CRA_PERIO pd, " +
		   " CRA_PERIO ph  " + 
	" WHERE " +
	"	  i.attr_enti = 'DTO_DESCU' " +
   	"	  AND i.idio_oid_idio = " +  dto.getOidIdioma() + 
   	"	  AND i.val_oid = d.OID_DESC " +
   	"	  AND i.attr_num_atri = 1 " +
	"	  AND d.PERD_OID_PERI = pd.OID_PERI " +
	"	  AND d.PERD_OID_PERI_LIMI_FIN = ph.OID_PERI (+) " +
	"	  AND d.PAIS_OID_PAIS = " +  dto.getOidPais();

    RecordSet rs = UtilidadesDTO.getQuery(UtilidadesPaginacion.armarQueryPaginacion(sql,dto));
    for(int i = 0; i < rs.getRowCount() ; i++ ){
        String sqlIn = "select i.VAL_I18N " +
    	" from  DTO_DESCU_TIPO_CLIEN d, " + 
    	" 	  v_gen_i18n_sicc i   " + 
    	" WHERE d.DCTO_OID_DESC =  " + ((BigDecimal) rs.getValueAt(i, 0)).toString() + 
    	" AND   i.ATTR_ENTI='MAE_TIPO_CLIEN' " +  
    	" AND	  i.IDIO_OID_IDIO = " + dto.getOidIdioma() + 
    	" AND	  i.ATTR_NUM_ATRI = 1  " +
    	" AND	  i.VAL_OID = d.TICL_OID_TIPO_CLIE" ;

        RecordSet rsIn = UtilidadesDTO.getQuery(sqlIn);
        String tipos = "";
        for(int ii = 0; ii < rsIn.getRowCount() ; ii++ ){        
            tipos += (String)rsIn.getValueAt(ii, 0) ;
	// No funciono ya que incrementa y luego compara por tanto para no cambiar mucho 
	// saco la coma al final            
	if(ii < rsIn.getRowCount()){
                tipos += " , ";
            }
        }
        if(tipos.length() > 2){
            tipos = tipos.substring(0, tipos.length() - 2 );
        }
        rs.setValueAt(tipos,i, 3); 
    }

    DTOSalida dtos = new DTOSalida();
    dtos.setResultado(rs);
        UtilidadesLog.info("DAODescuento.obtenerDescuentosActivos() Salida");
    return dtos;
  } 

    
    /**
     * Retorna los descuentos especiales a cliente para un oidDescuento.
     * Retorna valorPorcentajeDescuento y valorImporteFijoDescueto de DTO_ALCAN_DTO_CLIEN entre otros.
     */
    public RecordSet obtenerDescuentosACliente (Long oidDescuento) throws MareException { 
        UtilidadesLog.debug("DAODescuento.obtenerDescuentosACliente(): Entrada");
        /* 
        Entrada: oidDescuento 
        Proceso: 
        -> Hacer consulta JDBC sobre la tabla DTO_ALCAN_DTO_CLIEN para recuperar 
        los campos OID_ALCA_DTO_CLIE, VAL_PORC_DESC e IMP_FIJO y haciendo join 
        con la tabla MAE_CLIEN recuperar los campos VAL_NOM1 + VAL_NOM2 como Nombre 
        y VAL_APE1 + VAL_APE2 como apellidos,
        filtrando por el oid de descuento de entrada. 
        -> Devolver RecordSet obtenido de la consulta anterior, que llevará los siguientes campos: 

        - oidAlcanceDescuentoCliente 
        - valorPorcentajeDescuento 
        - valorImporteFijoDescueto 
        - Nombre 
        - Apellidos
        - oidCliente
        */

        String sql = "	SELECT " +
        "		   ac.OID_ALCA_DTO_CLIE oidAlcanceDescuentoCliente , " +
        "		   ac.VAL_PORC_DESC valorPorcentajeDescuento, " +
        "		   ac.IMP_FIJO valorImporteFijoDescuento, " +
        "		   m.VAL_NOM1 || ' ' || m.VAL_NOM2 Nombre , " +
        "		   m.VAL_APE1 ||  ' '  || m.VAL_APE2 Apellidos, " +
        "		   ac.CLIE_OID_CLIE oidCliente " +        
        "	FROM " +
        "		 DTO_ALCAN_DTO_CLIEN ac, " +
        "		 MAE_CLIEN m " +
        "	WHERE " + 
        "		 ac.CLIE_OID_CLIE = m.OID_CLIE " + 
        "		 AND ac.DCTO_OID_DESC = " + oidDescuento;
    
        UtilidadesLog.debug("DAODescuento.obtenerDescuentosACliente(): Salida");
    
        return UtilidadesDTO.getQuery(sql);
    }


    /**
     * 
     */
    public DTOSalida contarSolicitudesGrupo (DTOEGrupoReversion dto)throws MareException{
        UtilidadesLog.debug("DAODescuento.contarSolicitudesGrupo(): Entrada");

		StringBuffer query = new StringBuffer();
        RecordSet respuesta= null;

        try {
			query.append(" SELECT COUNT(*) AS NUMERO ");
			query.append(" FROM PED_SOLIC_CABEC ");
			query.append(" WHERE VAL_GRUP_REVE = " + "'" + dto.getGrupoReversion() + "'");
			respuesta = UtilidadesDTO.getQuery(query.toString());
			
		}catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

		DTOSalida dtosalida = new DTOSalida();
	    dtosalida.setResultado(respuesta);
        UtilidadesLog.debug("DAODescuento.contarSolicitudesGrupo(): Salida");

		return dtosalida;
	}

  /**
     * @author vconte
     * @date 21/11/2005
     * @throws java.lang.Exception
     * @return DTOListaBasesAplicacionDto
     * @param dtoe
     * Este método obtiene las bases de aplicación de un descuento 
     * 
     */
    public DTOListaBasesAplicacionDto obtenerBasesAplicacionDTO(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerBasesAplicacionDTO(DTOOID dtoe): Entrada");
        
        DTOListaBasesAplicacionDto dtoListaBA = new DTOListaBasesAplicacionDto();
        DTOSBaseAplicacion[] dtoSBaseAplicAux = null;
        ArrayList listaDtoSBaseAplicAux = new ArrayList();
        StringBuffer query = null;
        RecordSet rs= null;
        int cantReg; //auxiliar para el conteo de registros
        int i;
        int j;
        DTOSBaseAplicacion dtoSBA = null;
        DTOSBaseAplicacionDetalle dtoSBAdeta = null;
        Long tmpOidCabeActual = null;
        Long tmpOidCabeAux = null;
        ArrayList listBaseAplicDeta = null;

        
        /*Hago consulta sobre DTO_BASE_APLIC_CABEC ,
         * DTO_BASE_APLIC_DETAL para obtener y  descripciones 
         * */
        query = obtenerQueryDTOCabecDetal(dtoe);
       
        try {
            rs = UtilidadesDTO.getQuery(query.toString());
    		}catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        cantReg = rs.getRowCount(); //auxiliar para el conteo de registros
        UtilidadesLog.debug("query ejecudato totalRegistros =" + cantReg);
        // Se hace un corte de control por oid de la base de aplicación 
        
        
        for (i= 0; i < cantReg; i++){
            
            dtoSBA = new DTOSBaseAplicacion();
            dtoSBA.setOidDescuento(dtoe.getOid());
            tmpOidCabeActual = getLong(rs.getValueAt(i,"OID_CABE"));
            UtilidadesLog.debug("tmpOidCabeActual =" + tmpOidCabeActual);
            dtoSBA.setOidBase(tmpOidCabeActual);
            dtoSBA.setNumeroUnidadesObligatorias(getInt(rs.getValueAt(i,"NUM_UNID_OBLI")));

            /*mientras el atributo oid de base aplicación cabecera sea el mismo
            * el oid de la base se va a repetir por cada detalle 
            */
            listBaseAplicDeta = new ArrayList();
            for (j = i; j < cantReg; j++){
                dtoSBAdeta = new DTOSBaseAplicacionDetalle();
                tmpOidCabeAux = getLong(rs.getValueAt(j,"OID_CABE"));
                UtilidadesLog.debug("tmpOidCabeAux =" + tmpOidCabeAux);
                if (tmpOidCabeActual.longValue() == tmpOidCabeAux.longValue()){
                    // marca
                    UtilidadesLog.debug("son iguales armo detalle ");
                    dtoSBAdeta.setMarca(getLong(rs.getValueAt(j,"MAPR_OID_MARC_PROD")));
                    dtoSBAdeta.setDescripcionMarca((String)rs.getValueAt(j,"DES_MARC_PROD"));
                    //unidad negocio
                    dtoSBAdeta.setUnidadNegocio(getLong(rs.getValueAt(j,"UNEG_OID_UNID_NEGO")));
                    dtoSBAdeta.setDescripcionUnidadNegocio((String)rs.getValueAt(j,"DESCUNIDADNEGOCIO"));
                    //negocio
                    dtoSBAdeta.setNegocio(getLong(rs.getValueAt(j,"NEGO_OID_NEGO")));
                    dtoSBAdeta.setDescripcionNegocio((String)rs.getValueAt(j,"DESCNEGOCIO"));
                    //supergenerico
                    dtoSBAdeta.setSupergenerico(getLong(rs.getValueAt(j,"SGEN_OID_SUPE_GENE")));
                    dtoSBAdeta.setDescripcionSupergenerico((String)rs.getValueAt(j,"DESCSUPERGENER"));
                    //generico
                    dtoSBAdeta.setGenerico(getLong(rs.getValueAt(j,"GENE_OID_GENE")));
                    dtoSBAdeta.setDescripcionGenerico((String)rs.getValueAt(j,"DESCGENER"));
                    //indicador tipo oferta
                    dtoSBAdeta.setExclusionTipoOferta(getBoolean(rs.getValueAt(j,"IND_EXCL_TIPO_OFER")));
                    //tipo oferta
                    dtoSBAdeta.setTipoOferta(getLong(rs.getValueAt(j,"TOFE_OID_TIPO_OFER")));
                    dtoSBAdeta.setDescripcionTipoOferta((String)rs.getValueAt(j,"DESCTIPOOFERTA"));
                    //ciclo de vida
                    dtoSBAdeta.setCicloVida(getLong(rs.getValueAt(j,"CIVI_OID_CICL_VIDA")));
                    dtoSBAdeta.setDescripcionCicloVida((String)rs.getValueAt(j,"DESCCICLOVIDA"));
                    //producto
                    dtoSBAdeta.setProducto(getLong(rs.getValueAt(j,"PROD_OID_PROD")));
                    dtoSBAdeta.setDescripcionProducto((String)rs.getValueAt(j,"DESCPRODUCTO"));
                    
                    listBaseAplicDeta.add(dtoSBAdeta);
                    //sino se pone este i = j, y todos pertenecen a la misma cabecera cuando termina de recorrer
                    //nadie seteo i, entonces sigue con i = 2 y genera otra cabecera para los detalles que quedan
                    //desde el 2 en adelante.
                    i = j;
                }else{
                    i = j - 1;
                    break;
                }
                
            }
            dtoSBA.setDetalle(listBaseAplicDeta);
            /* utilizo un arraylist (listaDtoSBaseAplicAux) en lugar del vector porque como no se sabe
             * el tamaño que va a tener no se lo puede inicializar por ende acumulo todo en un arraylist
             * y despues lo paso al vector
             */
            listaDtoSBaseAplicAux.add(dtoSBA); 
        }
        UtilidadesLog.debug(" termino la asignacion ");
        //Meter el objeto DTOSBaseAplicacion en DTOListaBasesAplicacionDto.basesAplicacion 
        dtoSBaseAplicAux = new DTOSBaseAplicacion[listaDtoSBaseAplicAux.size()];
        listaDtoSBaseAplicAux.toArray(dtoSBaseAplicAux);
        dtoListaBA.setBasesAplicacion(dtoSBaseAplicAux);
        
        query = null;
        // A partir de aca obtengo los escalones
        query = obtenerQueryDTOCabecEscal(dtoe);
         try {
			rs = UtilidadesDTO.getQuery(query.toString());
		}catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        cantReg = rs.getRowCount(); //Cuento los registros del query por descuento escalones
        UtilidadesLog.debug(" cantidad registros Escalones= "+cantReg);
        DTOSBaseAplicacion[] dtoSBAEscal = dtoListaBA.getBasesAplicacion(); 
        Long tmpOidBaseCabec =null; //temporal para saber que oid se esta procesando
        Integer pos= null; //temporal para saber en que posicion del vector se encuentra el oid
        DTOEscalon dtoEsca = null; 
        ArrayList tmpLista = null; // auxiliar para la asignacion de los Escalones
        
        for (i = 0; i < cantReg; i++){
            tmpOidBaseCabec = getLong(rs.getValueAt(i,"OID_CABE"));
            pos = buscaElementoDTOSBaseAplicacion(dtoSBAEscal, tmpOidBaseCabec);
            UtilidadesLog.debug("pos= "+pos);
            if (pos != null) {
                dtoEsca = new DTOEscalon();
                dtoEsca.setOidEscalon(getLong(rs.getValueAt(i,"OID_ESLN")));
                dtoEsca.setEscalaDesde(getBigDecimal(rs.getValueAt(i,"VAL_DESD")));
                dtoEsca.setEscalaHasta(getBigDecimal(rs.getValueAt(i,"VAL_HAST")));
                dtoEsca.setPorcentajeDescuento(getDouble(rs.getValueAt(i,"VAL_PORC_DESC")));
                // se almacena en el array de escalones de la base encontrada anteriormente 
                tmpLista = dtoSBAEscal[pos.intValue()].getEscalones();
             
                if (tmpLista == null){
                    tmpLista = new ArrayList();
                }
                tmpLista.add(dtoEsca);
                dtoSBAEscal[pos.intValue()].setEscalones(tmpLista);
            }
        
        }
        
        UtilidadesLog.info("DAODescuento.obtenerBasesAplicacionDTO(DTOOID dtoe): Salida");
        return dtoListaBA;
    }
    /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * Arma el query para obtener el join entre DTOCabecera y los DTOEscalones
     */
     private StringBuffer obtenerQueryDTOCabecEscal(DTOOID dtoe){
        UtilidadesLog.info("DAODescuento.obtenerQueryDTOCabecEscal(DTOOID dtoe): Entrada");
        
        StringBuffer query =  new StringBuffer();
        query.append(" SELECT ");
            query.append("  dtobac.OID_CABE ");
            query.append(" ,dtoEsca.OID_ESLN ");
            query.append(" ,dtoEsca.VAL_DESD ");
            query.append(" ,dtoEsca.VAL_HAST ");
            query.append(" ,dtoEsca.VAL_PORC_DESC ");
        query.append(" FROM  ");
            query.append("   DTO_BASE_APLIC_CABEC dtobac ");
            query.append(" , DTO_ESCLN dtoEsca ");
        query.append(" WHERE  ");
            query.append("      dtobac.DCTO_OID_DESC = " + dtoe.getOid());
            query.append(" AND  dtoEsca.BACA_OID_CABE = dtobac.OID_CABE ");
        query.append(" order by dtobac.OID_CABE ");
        UtilidadesLog.info("query:"+query); 
        UtilidadesLog.info("DAODescuento.obtenerQueryDTOCabecEscal(DTOOID dtoe): Salida");
        return query;
     }
    
    /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * @param
     * Arma el query para obtener el join entre DTOCabecera, DTODetalle y sus
     * respectivas descripciones
     */
     private StringBuffer obtenerQueryDTOCabecDetal(DTOOID dtoe){
        UtilidadesLog.info("DAODescuento.obtenerQueryDTOCabecDetal(DTOOID dtoe): Entrada");
        StringBuffer query = new StringBuffer();
        Long tmpOidIdioma = dtoe.getOidIdioma();
        query.append(" SELECT  ");
            query.append("   dtobac.OID_CABE  ");
            query.append(" , dtobac.NUM_UNID_OBLI ");
            query.append(" , dtobad.MAPR_OID_MARC_PROD ");  //marca
            query.append(" , segMP.DES_MARC_PROD ");
            query.append(" , dtobad.UNEG_OID_UNID_NEGO ");  //unidad de negocio
            query.append(" , i1.VAL_I18N DESCUNIDADNEGOCIO ");
            query.append(" , dtobad.NEGO_OID_NEGO ");       //negocio
            query.append(" , i2.VAL_I18N DESCNEGOCIO ");
            query.append(" , dtobad.SGEN_OID_SUPE_GENE ");  //supergenerico
            query.append(" , i3.VAL_I18N DESCSUPERGENER ");
            query.append(" , dtobad.GENE_OID_GENE ");       //generico
            query.append(" , i4.VAL_I18N DESCGENER ");
            query.append(" , dtobad.IND_EXCL_TIPO_OFER ");  // indicador tipo oferta excluyente
            query.append(" , dtobad.TOFE_OID_TIPO_OFER ");  //tipo oferta
            query.append(" , i5.VAL_I18N DESCTIPOOFERTA ");
            query.append(" , dtobad.CIVI_OID_CICL_VIDA ");  //ciclo de vida
            query.append(" , i6.VAL_I18N DESCCICLOVIDA ");
            query.append(" , dtobad.PROD_OID_PROD ");       //producto
            query.append(" , i7.VAL_I18N DESCPRODUCTO ");
        query.append(" FROM   ");
            query.append("   DTO_BASE_APLIC_CABEC dtobac ");
            query.append(" , DTO_BASE_APLIC_DETAL dtobad ");
            query.append(" , SEG_MARCA_PRODU      segMP ");
            query.append(" , V_GEN_I18N_SICC  i1 ");
            query.append(" , V_GEN_I18N_SICC  i2 ");
            query.append(" , V_GEN_I18N_SICC  i3 ");
            query.append(" , V_GEN_I18N_SICC  i4 ");
            query.append(" , V_GEN_I18N_SICC  i5 ");
            query.append(" , V_GEN_I18N_SICC  i6 ");
            query.append(" , V_GEN_I18N_SICC  i7 ");
        query.append(" WHERE ");
            query.append("       dtobac.DCTO_OID_DESC = " + dtoe.getOid());
            query.append(" AND   dtobac.OID_CABE = dtobad.BACA_OID_CABE ");
            query.append(" AND   segMP.OID_MARC_PROD (+) =  dtobad.MAPR_OID_MARC_PROD ");
            query.append(" AND   i1.ATTR_ENTI (+)= 'MAE_UNIDA_NEGOC' ");
            query.append(" AND   i1.VAL_OID (+)= dtobad.UNEG_OID_UNID_NEGO ");
            query.append(" AND   i1.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i1.IDIO_OID_IDIO (+)= " +  tmpOidIdioma);
            query.append(" AND   i2.ATTR_ENTI (+)= 'MAE_NEGOC' ");
            query.append(" AND   i2.VAL_OID (+)= dtobad.NEGO_OID_NEGO ");
            query.append(" AND   i2.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i2.IDIO_OID_IDIO (+)= " + tmpOidIdioma );
            query.append(" AND   i3.ATTR_ENTI (+)= 'MAE_SUPER_GENER' ");
            query.append(" AND   i3.VAL_OID (+)= dtobad.SGEN_OID_SUPE_GENE ");
            query.append(" AND   i3.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i3.IDIO_OID_IDIO (+)= " + tmpOidIdioma);
            query.append(" AND   i4.ATTR_ENTI (+)= 'MAE_GENER' ");
            query.append(" AND   i4.VAL_OID (+)= dtobad.GENE_OID_GENE ");
            query.append(" AND   i4.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i4.IDIO_OID_IDIO (+)= " + tmpOidIdioma);
            query.append(" AND   i5.ATTR_ENTI (+)= 'PRE_TIPO_OFERT' ");
            query.append(" AND   i5.VAL_OID (+)= dtobad.TOFE_OID_TIPO_OFER ");
            query.append(" AND   i5.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i5.idio_oid_idio(+) = 1 ");
            query.append(" AND   i6.ATTR_ENTI (+)= 'PRE_CICLO_VIDA' ");
            query.append(" AND   i6.VAL_OID (+)= dtobad.CIVI_OID_CICL_VIDA ");
            query.append(" AND   i6.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i6.IDIO_OID_IDIO (+)= " + tmpOidIdioma);
            query.append(" AND   i7.ATTR_ENTI (+)= 'MAE_PRODU' ");
            query.append(" AND   i7.VAL_OID (+)= dtobad.PROD_OID_PROD ");
            query.append(" AND   i7.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND   i7.IDIO_OID_IDIO (+)= " + tmpOidIdioma);
        query.append(" order by dtobac.OID_CABE ");
        
        UtilidadesLog.info("query:"+query);
        UtilidadesLog.info("DAODescuento.obtenerQueryDTOCabecDetal(DTOOID dtoe): Salida");
        return query;
     }
    /**
     * @author vconte
     * @date 21/11/2005
     * @return Long
     * Se construye como auxiliar
     */
    private Long getLong(Object obj){
        Long tmpLong = null; // auxiliar para la obtencion de valores Long del recordset
        if (obj!= null){
           tmpLong =  new Long(((BigDecimal)obj).longValue());
        }
        return tmpLong;
    }
    
    /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * Se construye como auxiliar
     */
    private Integer getInt(Object obj){
        Integer tmpInteger = null; // auxiliar para la obtencion de valores Integer del recordset
        if (obj!= null){
           tmpInteger =  new Integer(((BigDecimal)obj).intValue());
        }
        return tmpInteger;
    }
    
    /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * Se construye como auxiliar
     */
    private Boolean getBoolean(Object obj){
        Boolean tmpBoolean = null; // auxiliar para la obtencion de valores Boolean del recordset
        if (obj!= null){
            if (((BigDecimal)obj).intValue() == 0){
                tmpBoolean =  Boolean.FALSE;
            }else {
                tmpBoolean =  Boolean.TRUE;
            }
        }
        return tmpBoolean;
    }
    
     /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * Se construye como auxiliar
     */
    private BigDecimal getBigDecimal(Object obj){
        BigDecimal tmpBigDecimal = null; // auxiliar para la obtencion de valores BigDecimal del recordset
        if (obj!= null){
           tmpBigDecimal =  (BigDecimal)obj;
        }
        return tmpBigDecimal;
    }
    /**
     * @author vconte
     * @date 21/11/2005
     * @return 
     * Se construye como auxiliar
     */
    private Double getDouble(Object obj){
        Double tmpDouble = null; // auxiliar para la obtencion de valores Double del recordset
        if (obj!= null){
           tmpDouble =  new Double(((BigDecimal)obj).doubleValue());
        }
        return tmpDouble;
    }
    
    /**
     * @author vconte
     * @date  21/11/2005
     * @return 
     * Se construye como auxiliar 
     * Hace una búsqueda de un oid en el listado de DTOSBaseAplicacion
     */
     private Integer buscaElementoDTOSBaseAplicacion(DTOSBaseAplicacion[] dtoSBAEscal, Long oidBuscado) {
        UtilidadesLog.info("DAODescuento.buscaElementoDTOSBaseAplicacion" +
                          "(DTOSBaseAplicacion[] dtoSBAEscal, Long oidBuscado):Entrada");
        DTOSBaseAplicacion dtoSBAEscalTmp = null;
        int i;
        int cantDtos = dtoSBAEscal.length;

        for (i = 0; i < cantDtos ; i++){
            dtoSBAEscalTmp = dtoSBAEscal[i];
            if (dtoSBAEscalTmp.getOidBase().equals(oidBuscado)){
                return new Integer(i);
            }
        }
        UtilidadesLog.info("DAODescuento.buscaElementoDTOSBaseAplicacion" +
                          "(DTOSBaseAplicacion[] dtoSBAEscal, Long oidBuscado):Salida");
        return null;
    }  

    /**
     * @author ciglesias
     * @date  02/11/2006
     * @return DTOTipoSolicitudProceso 
     * Obtiene los datos faltantes para generar la solicitud en aplicarDescuento
     */
     public DTOTipoSolicitudProceso  obtenerTipoSolProcDTO(DTOTipoSolicitud dtoE) 
     throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerTipoSolProcDTO Entrada");

        StringBuffer query = new StringBuffer();
        query.append(" SELECT  ");
            query.append("   a.tspa_oid_tipo_soli_pais ");
            query.append(" , a.tpos_oid_tipo_posi ");
            query.append(" , a.stpo_oid_subt_posi ");  
        query.append(" FROM   ");
            query.append("   ped_tipo_solic_proce a ");
            query.append(" , ped_tipo_solic_pais b ");
            query.append(" , ped_tipo_solic c ");
        query.append(" WHERE ");
            query.append("     a.oper_oid_oper = " + ConstantesBEL.DTO017.toString());
            query.append(" AND a.prod_oid_prod IS NOT NULL ");
            query.append(" AND a.tspa_oid_tipo_soli_pais = b.oid_tipo_soli_pais ");
            query.append(" AND b.pais_oid_pais = " + dtoE.getOidPais());
            query.append(" AND b.tsol_oid_tipo_soli = 40 ");
            query.append(" AND c.marc_oid_marc = " + dtoE.getMarca());
            query.append(" AND c.acce_oid_acce = " + dtoE.getAcceso());
            query.append(" AND c.sbac_oid_sbac = " + dtoE.getSubacceso());
            query.append(" AND c.ticl_oid_tipo_clie = " + dtoE.getTipoCliente());
        
        UtilidadesLog.info("query: "+query);
        
        RecordSet rs = UtilidadesDTO.getQuery(query.toString());
        
        if (rs != null)
        {
             DTOTipoSolicitudProceso dtoRetorno = new DTOTipoSolicitudProceso();
             dtoRetorno.setTipoSolicitud(rs.getValueAt(0,"tspa_oid_tipo_soli_pais")==null?null:new Long(rs.getValueAt(0,"tspa_oid_tipo_soli_pais").toString()));
             dtoRetorno.setTipoPosicion(rs.getValueAt(0,"tpos_oid_tipo_posi")==null?null:new Long(rs.getValueAt(0,"tpos_oid_tipo_posi").toString()));
             dtoRetorno.setSubtipoPosicion(rs.getValueAt(0,"stpo_oid_subt_posi")==null?null:new Long(rs.getValueAt(0,"stpo_oid_subt_posi").toString()));
             
             return dtoRetorno;
        }

        UtilidadesLog.info("DAODescuento.obtenerTipoSolProcDTO Salida");
        return null;
 
        
    }  

}