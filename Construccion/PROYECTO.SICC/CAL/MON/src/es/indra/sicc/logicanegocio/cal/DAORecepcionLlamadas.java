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
 */

package es.indra.sicc.logicanegocio.cal;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cal.DTOCabeceraPedido;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTODescTipificacion;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTODetallePedido;
import es.indra.sicc.dtos.cal.DTONombre;
import es.indra.sicc.dtos.cal.DTOTipificacion;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;

import java.math.BigDecimal;
import es.indra.sicc.dtos.cal.DTOBloqueoAdm;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import javax.ejb.DuplicateKeyException;

import java.util.Date;
import java.util.Vector;
import java.util.HashMap;

public class DAORecepcionLlamadas 
{
  public DAORecepcionLlamadas()
  {
  }

    public RecordSet obtenerClientes(DTOCliente DTOE) throws MareException
    {
    
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerClientes(DTOCliente DTOE): Entrada");
    
        //Realiza una búsqueda de todos los clientes que cumplan las condiciones del DTOE utilizando el servicio DBService. 
        //De los campos marcados con --DESCRIPCION debe obtenerse únicamente la descripcion, son internacionalizables 
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        consulta.append(" SELECT A.OID_CLIE, ");
        consulta.append("A.COD_CLIE, ");
        consulta.append("B.TICL_OID_TIPO_CLIE, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = B.TICL_OID_TIPO_CLIE ), ");
        // Fin subselect
        consulta.append("D.TDOC_OID_TIPO_DOCU, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.TDOC_OID_TIPO_DOCU ), ");
        // Fin subselect
        consulta.append("D.NUM_DOCU_IDEN, ");
        consulta.append("A.VAL_APE1, ");
        consulta.append("A.VAL_APE2, ");
        consulta.append("A.VAL_APEL_CASA, ");
        consulta.append(" A.VAL_NOM1, ");
        consulta.append(" A.VAL_NOM2  ");
        consulta.append("FROM MAE_CLIEN A, ");
        consulta.append("MAE_CLIEN_TIPO_SUBTI B, ");
        consulta.append("MAE_CLIEN_IDENT D ");

        if(DTOE.getOidMarca()!=null && DTOE.getOidCanal()!=null)
        {
            consulta.append(", CRA_PERIO F ");
            consulta.append(", MAE_CLIEN_UNIDA_ADMIN G ");
        }
        if(DTOE.getOidSubgerenciaVentas()!=null)
        {
            consulta.append(", ZON_SUB_GEREN_VENTA H ");
        }
        if(DTOE.getOidRegion()!=null)
        {
            consulta.append(", ZON_REGIO J ");
        }
        /* Incidencia 12237 */
        if(DTOE.getOidZona()!=null)
        {
            consulta.append(", ZON_ZONA K ");
        }
        consulta.append("WHERE A.PAIS_OID_PAIS = ? "); //DTOE.pais
        parametros.add(DTOE.getOidPais());
        consulta.append("AND B.CLIE_OID_CLIE = A.OID_CLIE ");
        consulta.append("AND D.CLIE_OID_CLIE = A.OID_CLIE ");
        if(DTOE.getCodCliente()!=null) 
        {
            consulta.append("AND A.COD_CLIE = ? ");
            parametros.add(DTOE.getCodCliente()); 
        }
        if(DTOE.getDocIdentidad()!=null)
        {
            consulta.append("AND D.NUM_DOCU_IDEN = ? "); //DTOE.docIdentidad
            parametros.add(DTOE.getDocIdentidad());
        }
        if(DTOE.getOidTipoDocumento()!=null)
        {
            consulta.append("AND D.TDOC_OID_TIPO_DOCU = ? "); //DTOE.oidTipoDocumento
            parametros.add(DTOE.getOidTipoDocumento());
        }
        if(DTOE.getApellido1()!=null)
        {
            consulta.append("AND A.VAL_APE1 LIKE ? "); //DTOE.apellido1
            parametros.add(DTOE.getApellido1());
        }
        if(DTOE.getApellido2()!=null)
        {
            consulta.append("AND A.VAL_APE2 LIKE ? "); //DTOE.apellido2
            parametros.add(DTOE.getApellido2());
        }
        if(DTOE.getApellidoCasada()!=null)
        {
            consulta.append("AND A.VAL_APEL_CASA LIKE ? "); //DTOE.apellidoCasada
            parametros.add(DTOE.getApellidoCasada());
        }
        if(DTOE.getNombre1()!=null)
        {
            consulta.append("AND A.VAL_NOM1 LIKE ? "); //DTOE.nombre1
            parametros.add(DTOE.getNombre1());
        }
        if(DTOE.getNombre2()!=null)
        {
            consulta.append("AND A.VAL_NOM2 LIKE ? "); //DTOE.nombre2
            parametros.add(DTOE.getNombre2());
        }
        if(DTOE.getOidMarca()!=null && DTOE.getOidCanal()!=null)
        {
            consulta.append(" AND F.PAIS_OID_PAIS = A.PAIS_OID_PAIS ");
            consulta.append(" AND F.MARC_OID_MARC = ? "); //DTOE.oidMarca
            parametros.add(DTOE.getOidMarca());
            consulta.append(" AND F.CANA_OID_CANA = ? "); //DTOE.oidCanal
            parametros.add(DTOE.getOidCanal());
            consulta.append(" AND F.OID_PERI = G.PERD_OID_PERI_INI ");
            consulta.append(" AND G.CLIE_OID_CLIE = A.OID_CLIE ");
                   
        }
        if(DTOE.getOidSubgerenciaVentas()!=null)
        {
            consulta.append("AND H.CLIE_OID_CLIE (+) = A.OID_CLIE ");
            consulta.append("AND H.OID_SUBG_VENT (+) = ? "); //DTOE.oidSubgerenciaVentas
            parametros.add(DTOE.getOidSubgerenciaVentas());
        }
        if(DTOE.getOidRegion()!=null)
        {
            consulta.append("AND J.CLIE_OID_CLIE (+) = A.OID_CLIE ");
            consulta.append("AND J.OID_REGI (+) = ? "); //DTOE.oidRegion
            parametros.add(DTOE.getOidRegion());
        }
        if(DTOE.getOidZona()!=null) //incidencia 12237
        {
            consulta.append("AND K.CLIE_OID_CLIE (+) = A.OID_CLIE ");
            consulta.append("AND K.OID_ZONA (+) = ? "); //DTOE.oidZona 
            parametros.add(DTOE.getOidZona());
        }
        consulta.append("ORDER BY A.OID_CLIE, B.TICL_OID_TIPO_CLIE ");
        consulta.append(") XY ) WHERE linea > " + DTOE.getIndicadorSituacion() + " AND ROWNUM <= " + DTOE.getTamanioPagina() );
        //Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes 
        //consideraciones: 
        //1.- oid del registro encontrado > DTOE.indicadorSituacion 
        //2.- ROWNUM <= DTOE.tamanioPagina 
        this.logSql("obtenerClientes. SQL: ", consulta.toString(), parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerClientes: Exception",e);
            this.logSql("obtenerClientes. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /* En negocio nos piden llamar a una LP si no devuelve datos, por tanto no lanzamos excepcion
         * if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerClientes: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerClientes(DTOCliente DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerClientePorCodigo(DTOCliente DTOE) throws MareException {
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerClientePorCodigo(DTOCliente DTOE): Entrada");
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * FROM (SELECT ROWNUM AS linea, xy.* ");
        consulta.append("FROM (SELECT a.oid_clie, a.cod_clie, NULL AS oid_tipo, ");
        consulta.append(" NULL desc_tipo, d.tdoc_oid_tipo_docu, ");
        consulta.append("(SELECT idio.val_i18n FROM v_gen_i18n_sicc idio ");
        consulta.append(" WHERE idio.attr_enti = 'MAE_TIPO_DOCUM' ");
        consulta.append(" AND idio.idio_oid_idio =  ").append(DTOE.getOidIdioma());
        consulta.append(" AND idio.val_oid = d.tdoc_oid_tipo_docu), ");
        consulta.append(" d.num_docu_iden, a.val_ape1, a.val_ape2, ");
        consulta.append(" a.val_apel_casa, a.val_nom1, a.val_nom2 ");
        consulta.append(" FROM mae_clien a,  (SELECT *  FROM (SELECT   * ");
        consulta.append(" FROM mae_clien_ident m  WHERE m.clie_oid_clie = ");
        consulta.append(" (SELECT oid_clie  FROM mae_clien WHERE cod_clie = '").append(DTOE.getCodCliente()).
                            append("' AND ROWNUM = 1) ");
        consulta.append(" ORDER BY m.val_iden_docu_prin DESC) WHERE ROWNUM = 1) d ");
        consulta.append(" WHERE d.clie_oid_clie = a.oid_clie) xy) ");
        consulta.append(" WHERE linea > ").append(DTOE.getIndicadorSituacion());
        consulta.append( " AND ROWNUM <=  ").append(DTOE.getTamanioPagina());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerClientePorCodigo: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerClientePorCodigo(DTOCliente DTOE): Salida");
        return resultado;        
    }
    
    
    public RecordSet obtenerTiposCliente (DTOCodigoCliente DTOE) throws MareException
    {
        //Realiza una búsqueda de todos los tipos de cliente para un cliente determinado, utilizando el servicio DBService. 

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTiposCliente (DTOCodigoCliente DTOE): Entrada");
        
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT DISTINCT ");
        consulta.append("A.OID_CLIE, ");
        consulta.append("A.COD_CLIE, ");
        consulta.append("B.TICL_OID_TIPO_CLIE, ");
        consulta.append("C.COD_TIPO_CLIE, ");
        consulta.append("A.VAL_NOM1, ");
        consulta.append("A.VAL_NOM2, ");
        consulta.append("A.VAL_APE1, ");
        consulta.append("A.VAL_APE2 ");
        consulta.append("FROM MAE_CLIEN A, ");
        consulta.append("MAE_CLIEN_TIPO_SUBTI B, ");
        consulta.append("MAE_TIPO_CLIEN C ");
        consulta.append(" WHERE A.COD_CLIE = ?");
        parametros.add(DTOE.getCodigoCliente());
        consulta.append(" AND A.PAIS_OID_PAIS = ? ");
        parametros.add(DTOE.getOidPais());
        consulta.append("AND B.CLIE_OID_CLIE = A.OID_CLIE ");
        consulta.append("AND C.OID_TIPO_CLIE = B.TICL_OID_TIPO_CLIE ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerTiposCliente: Exception",e);
			this.logSql("obtenerTiposCliente. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    /*
        if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerTiposCliente: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }
        */
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTiposCliente (DTOCodigoCliente DTOE): Salida");
        
        
        return resultado;
    }
    
    public DTOCliente obtenerDatosGeneralesCliente (DTOCliente DTOE) throws MareException{
        //Obtiene los datos generales de un cliente determinado, utilizando el servicio DBService. 
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosGeneralesCliente (DTOCliente DTOE): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT A.OID_CLIE, ");
        consulta.append("A.COD_CLIE, ");
        consulta.append("A.VAL_APE1, ");
        consulta.append("A.VAL_APE2, ");
        consulta.append("A.VAL_APEL_CASA, ");
        consulta.append("A.VAL_NOM1, ");
        consulta.append("A.VAL_NOM2, ");
        consulta.append("PQ_APL_AUX.Valor_Gen_I18n_Sicc(?, k.oid_tipo_trat,'MAE_TIPO_TRATA') destratamiento,");
        parametros.add(DTOE.getOidIdioma());
        consulta.append("B.NUM_DOCU_IDEN, ");
        consulta.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc(?, c.oid_tipo_docu,'MAE_TIPO_DOCUM')tipo_docu_des, ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append("D.IMP_MONT_LINE_CRED, D.IND_ACTI, ");
        consulta.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc(?, e.oid_esta_clie,'MAE_ESTAT_CLIEN')esta_clien_des, ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append("F.VAL_TEXT_COMU TELEFONO, "); //--telefono
        consulta.append("F1.VAL_TEXT_COMU EMAIL, "); //--email 
        consulta.append("G.FEC_SIGU_CONT FECHAPROXIMOCONTACTO , ");
        consulta.append("A.FEC_INGR FECHAINGRESO , ");
        consulta.append("I.VAL_NOMB_PERI, ");
        consulta.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc(?, j.oid_nive_ries,'CAR_NIVEL_RIESG')nive_ries_des, ");
        parametros.add(DTOE.getOidIdioma());
        //Gacevedo(22/06/2007): Se implanta el pedido de cambio CAL-002
        consulta.append(" d.FEC_NACI fechanacimiento ");
        consulta.append("FROM MAE_CLIEN A, ");
        consulta.append("MAE_CLIEN_IDENT B, ");
        consulta.append("MAE_TIPO_DOCUM C, ");
        consulta.append("MAE_CLIEN_DATOS_ADICI D, ");
        consulta.append("MAE_ESTAT_CLIEN E, ");
        consulta.append("MAE_CLIEN_COMUN F, ");
        consulta.append("MAE_CLIEN_COMUN F1, ");
        consulta.append("MAE_CLIEN_PRIME_CONTA G, ");
        consulta.append("MAE_CLIEN_HISTO_ESTAT H, ");
        consulta.append("CRA_PERIO I, ");
        consulta.append("CAR_NIVEL_RIESG J, ");
        consulta.append("MAE_TIPO_TRATA K "); // 12884 
        consulta.append("WHERE A.OID_CLIE = ? "); //DTOE.oidCliente 
        parametros.add(DTOE.getOidCliente());
        consulta.append("AND B.CLIE_OID_CLIE = A.OID_CLIE ");
        consulta.append("AND B.VAL_IDEN_DOCU_PRIN = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND C.OID_TIPO_DOCU (+) = B.TDOC_OID_TIPO_DOCU ");
        consulta.append("AND C.COD_TIPO_DOCU (+) = ? "); //ConstantesMAE.TIPO_DOCUMENTO_DNI 
        parametros.add(ConstantesMAE.TIPO_DOCUMENTO_DNI); //incidencia 12602
        consulta.append("AND C.PAIS_OID_PAIS (+) = ? "); //DTOE.pais
        parametros.add(DTOE.getOidPais());
        consulta.append("AND D.CLIE_OID_CLIE = A.OID_CLIE ");
        consulta.append("AND E.OID_ESTA_CLIE (+) = D.ESTA_OID_ESTA_CLIE ");
        consulta.append(" AND F.CLIE_OID_CLIE (+) = A.OID_CLIE ");
        consulta.append("AND F.TICM_OID_TIPO_COMU (+) = ? "); //ConstantesMAE.TIPO_COMUNICACION_TFNO
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO);
        consulta.append("AND F1.CLIE_OID_CLIE (+) = A.OID_CLIE ");
        consulta.append("AND F1.TICM_OID_TIPO_COMU (+) = ? "); //ConstantesMAE.TIPO_COMUNICACION_EMAIL
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_EMAIL);
        consulta.append("AND G.CLIE_OID_CLIE (+) = A.OID_CLIE ");
        consulta.append("AND H.CLIE_OID_CLIE (+) = A.OID_CLIE ");
        consulta.append("AND H.ESTA_OID_ESTA_CLIE (+) = ? "); //ConstantesMAE.OID_ESTATUS_NUEVA
        parametros.add(ConstantesMAE.OID_ESTATUS_NUEVA);
        consulta.append("AND I.OID_PERI (+) = H.PERD_OID_PERI ");
        consulta.append("AND J.OID_NIVE_RIES (+) = D.NIRI_OID_NIVE_RIES ");

        consulta.append("AND K.OID_TIPO_TRAT (+) = A.VAL_TRAT "); //PENDIENTE 12884 DESCOMENTAR 
       
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerDatosGeneralesCliente: Exception",e);
			this.logSql("obtenerDatosGeneralesCliente. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.debug("obtenerDatosGeneralesCliente: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }
        DTOCliente dtoS = new DTOCliente();
        dtoS.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(0,"OID_CLIE")).longValue())); //A.OID_CLIE
        dtoS.setCodCliente(((String)resultado.getValueAt(0,"COD_CLIE"))); //A.COD_CLIE 
        if(resultado.getValueAt(0,"VAL_APE1")!=null){
          dtoS.setApellido1((String)resultado.getValueAt(0,"VAL_APE1")); //A.VAL_APE1
        }
        if(resultado.getValueAt(0,"VAL_APE2")!=null){
            dtoS.setApellido2(((String)resultado.getValueAt(0,"VAL_APE2"))); //A.VAL_APE2 
        }
        if(resultado.getValueAt(0,"VAL_APEL_CASA")!=null){
            dtoS.setApellidoCasada(((String)resultado.getValueAt(0,"VAL_APEL_CASA"))); //A.VAL_APEL_CASA 
        }
        if(resultado.getValueAt(0,"VAL_NOM1")!=null){
            dtoS.setNombre1(((String)resultado.getValueAt(0,"VAL_NOM1"))); //A.VAL_NOM1 
        }
        if(resultado.getValueAt(0,"VAL_NOM2")!=null){
            dtoS.setNombre2(((String)resultado.getValueAt(0,"VAL_NOM2"))); //A.VAL_NOM2 
        }
        if(resultado.getValueAt(0,"DESTRATAMIENTO")!=null){
            dtoS.setDesTratamiento(((String)resultado.getValueAt(0,"DESTRATAMIENTO"))); //DECODE (A.VAL_TRAT,0, 'Sr.', 1, 'Sra.', 2, 'Srta.')
        }
        dtoS.setDocIdentidad(((String)resultado.getValueAt(0,"NUM_DOCU_IDEN"))); //B.NUM_DOCU_IDEN 
        if(resultado.getValueAt(0,"TIPO_DOCU_DES")!=null){
            dtoS.setDesTipoDocumento(((String)resultado.getValueAt(0,"TIPO_DOCU_DES"))); //C.OID_TIPO_DOCU (descripcion) 
        }
        if(resultado.getValueAt(0,"ESTA_CLIEN_DES")!=null){
            dtoS.setDesEstatus(((String)resultado.getValueAt(0,"ESTA_CLIEN_DES"))); //E.OID_ESTA_CLIE (descripcion)
        }
        if(resultado.getValueAt(0,"TELEFONO")!=null){
            dtoS.setTelefono(((String)resultado.getValueAt(0,"TELEFONO"))); //F.VAL_TEXT_COMU 
        }
        if(resultado.getValueAt(0,"EMAIL")!=null){
            dtoS.setEmail(((String)resultado.getValueAt(0,"EMAIL"))); //F1.VAL_TEXT_COMU 
        }
        if(resultado.getValueAt(0,"FECHAPROXIMOCONTACTO")!=null){
            dtoS.setFechaProximoContacto((Date)resultado.getValueAt(0,"FECHAPROXIMOCONTACTO")); //TO_DATE (G.FEC_SIGU_CONT, 'DD/MM/YYYY') 
        }
        if(resultado.getValueAt(0,"FECHAINGRESO")!=null){
            dtoS.setFechaIngreso((Date)resultado.getValueAt(0,"FECHAINGRESO")); //TO_DATE (A.FEC_INGR, 'DD/MM/YYYY') 
        }
        if(resultado.getValueAt(0,"VAL_NOMB_PERI")!=null){
            dtoS.setDesPeriodoIngreso(((String)resultado.getValueAt(0,"VAL_NOMB_PERI"))); //I.VAL_NOMB_PERI
        }
        if(resultado.getValueAt(0,"IMP_MONT_LINE_CRED")!=null){
            dtoS.setMontoLineaCredito(new Long(((BigDecimal)resultado.getValueAt(0,"IMP_MONT_LINE_CRED")).longValue())); //D.IMP_MONT_LINE_CRED 
        }
        if(resultado.getValueAt(0,"IND_ACTI") != null)
          {
              if(((BigDecimal)resultado.getValueAt(0,"IND_ACTI")).equals(new BigDecimal("1")))
                {
                        dtoS.setIndicadorActico("Activo");
                 }else
                 {
                        dtoS.setIndicadorActico("No Activo");
                 }
         }
        if(resultado.getValueAt(0,"NIVE_RIES_DES")!=null){
            dtoS.setDesNivelRiesgo(((String)resultado.getValueAt(0,"NIVE_RIES_DES"))); //J.OID_NIVE_RIES (descripcion) */
        }
        //Gacevedo(22/06/2007): Se implanta el pedido de cambio CAL-002
        if(resultado.getValueAt(0,"FECHANACIMIENTO")!=null){
            dtoS.setFechaNacimiento((Date)resultado.getValueAt(0,"FECHANACIMIENTO"));
        }
        
        //Gacevedo(22/06/2007): Se implanta el pedido de cambio CAL-002
        //ak obtenemos los datos de ultimo pedido y saldo unico del cliente.
        obtenerDatosPedidoSaldoUnico(DTOE, dtoS);
        //Obtenemos la direccion del cliente
        obtenerDireccionPrincipal(DTOE, dtoS);
        UtilidadesLog.debug("-GA- DTOSalida:"+dtoS);
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosGeneralesCliente (DTOCliente DTOE): Salida");
        return dtoS;
    }
    
    
    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080589 - dmorello, 09/09/2008
     *     Se agregan a la descripcion de unidad geografica los niveles 4 a 9 en caso de existir
     *     Para ello, se recuperan por separado los diferentes niveles en la query anidada
     *     y en la query anidada se concatenan formando la nueva descripcion
     */
    private void obtenerDireccionPrincipal(DTOCliente DTOE, DTOCliente DTOS)throws MareException{
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDireccionPrincipal(DTOCliente DTOE, DTOCliente DTOS): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector params = new Vector();
        //este select trae las direcciones del cliente,
        //ordenando por indicador principal desciendente,
        //de forma que si no existe, igualmente se informe
        //alguna direccion.
        consulta.append(" SELECT tipodir, des_abrv_tipo_via, val_nomb_via, num_ppal, val_obse ");
        consulta.append("      , nivel_1 ");
        consulta.append("          || DECODE(nivel_2, NULL, '', '/' || nivel_2) ");
        consulta.append("          || DECODE(nivel_3, NULL, '', '/' || nivel_3) ");
        consulta.append("          || DECODE(nivel_4, NULL, '', '/' || nivel_4) ");
        consulta.append("          || DECODE(nivel_5, NULL, '', '/' || nivel_5) ");
        consulta.append("          || DECODE(nivel_6, NULL, '', '/' || nivel_6) ");
        consulta.append("          || DECODE(nivel_7, NULL, '', '/' || nivel_7) ");
        consulta.append("          || DECODE(nivel_8, NULL, '', '/' || nivel_8) ");
        consulta.append("          || DECODE(nivel_9, NULL, '', '/' || nivel_9) AS desc_uni ");
        consulta.append(" FROM ");
        
        consulta.append(" (SELECT   A.OID_CLIE_DIRE OID, ");
        consulta.append("PQ_APL_AUX.Valor_Gen_I18n_Sicc(?,B.OID_TIPO_DIRE,'MAE_TIPO_DIREC') TIPODIR, ");
        params.add(DTOE.getOidIdioma());
        consulta.append("C.DES_ABRV_TIPO_VIA, A.VAL_NOMB_VIA, A.NUM_PPAL,  A.VAL_OBSE, ");
        
        consulta.append("  (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 IS NULL) AS nivel_1 ");
        consulta.append(", (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("      AND orde_3 IS NULL) AS nivel_2 ");
        consulta.append(", (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("      AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("      AND orde_4 IS NULL) AS nivel_3 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 18 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_4 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 24 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_5 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 30 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_6 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 36 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_7 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 42 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 = SUBSTR (a.cod_unid_geog, 43, 6) ");
        consulta.append("          AND orde_9 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_8 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 48 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 = SUBSTR (a.cod_unid_geog, 43, 6) ");
        consulta.append("          AND orde_9 = SUBSTR (a.cod_unid_geog, 49, 6)) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_9 ");
        
        consulta.append("FROM MAE_CLIEN_DIREC A, MAE_TIPO_DIREC B, SEG_TIPO_VIA C, MAE_CLIEN D ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? AND A.IND_ELIM = 0 AND B.OID_TIPO_DIRE = A.TIDC_OID_TIPO_DIRE ");
        params.add(DTOE.getOidCliente());
        consulta.append("AND C.OID_TIPO_VIA = A.TIVI_OID_TIPO_VIA AND D.OID_CLIE = A.CLIE_OID_CLIE ");
        consulta.append("ORDER BY A.IND_DIRE_PPAL DESC) ");
        consulta.append("WHERE ROWNUM = 1 ");
        
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = UtilidadesEJB.getBelcorpService().dbService.executePreparedQuery(consulta.toString(), 
				params);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerDatosPedidoSaldoUnico: Exception",e);
			this.logSql("obtenerDatosPedidoSaldoUnico. SQL: ",consulta.toString(),
				params);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        if(resultado.esVacio()){return;}
        if(resultado.getValueAt(0,"TIPODIR")!=null){
            DTOS.setTipoDireccion(resultado.getValueAt(0,"TIPODIR").toString());
        }else{
            DTOS.setTipoDireccion("");
        }
        if(resultado.getValueAt(0,"DES_ABRV_TIPO_VIA")!=null){
            DTOS.setTipoVia(resultado.getValueAt(0,"DES_ABRV_TIPO_VIA").toString());
        }else{
            DTOS.setTipoVia("");
        }
        if(resultado.getValueAt(0,"VAL_NOMB_VIA")!=null){
            DTOS.setNombreVia(resultado.getValueAt(0,"VAL_NOMB_VIA").toString());
        }else{
            DTOS.setNombreVia("");
        }
        if(resultado.getValueAt(0,"NUM_PPAL")!=null){
            DTOS.setNumeroPrincipal(resultado.getValueAt(0,"NUM_PPAL").toString());
        }else{
            DTOS.setNumeroPrincipal("");
        }
        if(resultado.getValueAt(0,"VAL_OBSE")!=null){
            DTOS.setObservacionesDireccion(resultado.getValueAt(0,"VAL_OBSE").toString());
        }else{
            DTOS.setObservacionesDireccion("");
        }
        if(resultado.getValueAt(0,"DESC_UNI")!=null){
            DTOS.setDescUniGeo(resultado.getValueAt(0,"DESC_UNI").toString());
        }else{
            DTOS.setDescUniGeo("");
        }
       UtilidadesLog.info("DAORecepcionLlamadas.obtenerDireccionPrincipal(DTOCliente DTOE, DTOCliente DTOS): Salida"); 
    }
    
    
    //Gacevedo(22/06/2007): Se implanta el pedido de cambio CAL-002
    private void obtenerDatosPedidoSaldoUnico(DTOCliente dtoClienteEntrada, DTOCliente dtoClienteSalida )throws MareException{
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosPedidoSaldoUnico (DTOCliente dtoClienteEntrada, DTOCliente dtoClienteSalida): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT * ");
        consulta.append(" FROM (SELECT PEDIDO.*, CONSOLIDADO.VAL_NUME_SOLI VAL_NUME_SOLI_CONSO, ");
        consulta.append(" SUM (MVC.IMP_PEND) OVER () SUM_IMP_PEND_CONSO ");
        consulta.append(" FROM (SELECT * ");
        consulta.append(" FROM (SELECT   PS.OID_SOLI_CABE, PS.FEC_FACT, ");
        consulta.append(" PS.PERD_OID_PERI, CPR.VAL_NOMB_PERI, ");
        consulta.append(" PS.SOCA_OID_SOLI_CABE, ");
        consulta.append(" (SELECT PQ_APL_REP.FN_CU_CALC_SALDO_CTA_CTE(PS.CLIE_OID_CLIE) FROM DUAL) SALDO_UNICO ");
        consulta.append(" FROM PED_SOLIC_CABEC PS, CRA_PERIO CPR ");
        consulta.append(" WHERE EXISTS (SELECT * FROM PED_SOLIC_CABEC_ACUM2 PS2 ");
        consulta.append(" WHERE PS2.CLIE_OID_CLIE = PS.CLIE_OID_CLIE AND PS2.PERD_OID_PERI = PS.PERD_OID_PERI ");
        consulta.append(" AND PS2.CLIE_OID_CLIE = ?) ");
        parametros.add(dtoClienteEntrada.getOidCliente());
        consulta.append(" AND PS.CLIE_OID_CLIE = ? AND PS.FEC_FACT IS NOT NULL ");
        parametros.add(dtoClienteEntrada.getOidCliente());
        consulta.append(" AND PS.IND_OC = 1 AND PS.PERD_OID_PERI = CPR.OID_PERI ");
        consulta.append(" AND PS.PAIS_OID_PAIS = ? ");
        parametros.add(dtoClienteEntrada.getOidPais());
        consulta.append(" ORDER BY FEC_FACT DESC) ");
        consulta.append(" WHERE ROWNUM = 1) PEDIDO, PED_SOLIC_CABEC CONSOLIDADO, CCC_MOVIM_CUENT_CORRI MVC ");
        consulta.append(" WHERE PEDIDO.SOCA_OID_SOLI_CABE = CONSOLIDADO.OID_SOLI_CABE ");
        consulta.append(" AND MVC.SOCA_OID_SOLI_CABE = CONSOLIDADO.OID_SOLI_CABE ");
        consulta.append(" AND MVC.CLIE_OID_CLIE = CONSOLIDADO.CLIE_OID_CLIE ");
        consulta.append(" AND MVC.PERD_OID_PERI = CONSOLIDADO.PERD_OID_PERI) ");
        consulta.append(" WHERE ROWNUM = 1 ");
        
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = UtilidadesEJB.getBelcorpService().dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerDatosPedidoSaldoUnico: Exception",e);
			this.logSql("obtenerDatosPedidoSaldoUnico. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        if(resultado.esVacio()){return;}
        
        if(resultado.getValueAt(0,"VAL_NOMB_PERI")!=null){
            dtoClienteSalida.setDescUltimaCampaniaPedido((String)resultado.getValueAt(0,"VAL_NOMB_PERI"));    
        }
        if(resultado.getValueAt(0,"FEC_FACT")!=null){
            dtoClienteSalida.setFechaUltimoPedido((Date)resultado.getValueAt(0,"FEC_FACT"));
        }
        if(resultado.getValueAt(0,"SALDO_UNICO")!=null){
            dtoClienteSalida.setSaldoUnicoCCC(new Double(((BigDecimal)resultado.getValueAt(0,"SALDO_UNICO")).doubleValue()));
        }
        if(resultado.getValueAt(0,"VAL_NUME_SOLI_CONSO")!=null){
            dtoClienteSalida.setNumeroUltimaBoletaDespacho(new Long(resultado.getValueAt(0,"VAL_NUME_SOLI_CONSO").toString()));
        }
        if(resultado.getValueAt(0,"SUM_IMP_PEND_CONSO")!=null){
            dtoClienteSalida.setMontoUltimaBoletaDespacho(new Double(((BigDecimal)resultado.getValueAt(0,"SUM_IMP_PEND_CONSO")).doubleValue()));
        }
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosPedidoSaldoUnico (DTOCliente dtoClienteEntrada, DTOCliente dtoClienteSalida): Salida");
    }
    
    public DTODescTipificacion obtenerTipificacionCliente (DTOCliente DTOE) throws MareException{
        //Obtiene las distintas tipificaciones de un cliente determinado, utilizando el servicio DBService. 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipificacionCliente (DTOCliente DTOE): Entrada");
        
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLIEN' AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.TICL_OID_TIPO_CLIE ) AS TIPOCLIENTE, ");

        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  WHERE idio.ATTR_ENTI = 'MAE_SUBTI_CLIEN' AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.SBTI_OID_SUBT_CLIE ) AS SUBTIPOCLIENTE, "); 

        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN'  AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.TCCL_OID_TIPO_CLASI ) AS TIPOCLASIFICACION, "); 

        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  WHERE idio.ATTR_ENTI = 'MAE_CLASI' AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.CLAS_OID_CLAS ) AS CLASIFICACION, "); 
        consulta.append("TICL_OID_TIPO_CLIE OID_TIPO_CLIENTE ");
        consulta.append("FROM V_MAE_TIPIF_CLIEN A ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //DTOE.oidCliente
        parametros.add(DTOE.getOidCliente());
        //Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
        //se quita el filtro de tipo subtipo cliente y
        //los ordeno para poder armar el arbol.
        //consulta.append("AND A.TICL_OID_TIPO_CLIE = ? "); //DTOE.oidTipoCliente
        //parametros.add(DTOE.getOidTipoCliente());
        //consulta.append("AND A.SBTI_OID_SUBT_CLIE = ? "); //DTOE.oidSubtipoCliente
        //parametros.add(DTOE.getOidSubtipoCliente());
        consulta.append("ORDER BY A.TICL_OID_TIPO_CLIE, A.SBTI_OID_SUBT_CLIE, A.TCCL_OID_TIPO_CLASI, A.CLAS_OID_CLAS");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerTipificacionCliente: Exception",e);
			this.logSql("obtenerTipificacionCliente. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        DTODescTipificacion dtoTipifi = new DTODescTipificacion();
        if (!resultado.esVacio()) {
            //Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
            //dejamos que se complete como antes para guardar compatibilidad,
            //pero a su vez, agregamos el arbol completo de tipificacion en el
            //atributo del DTODescTipificacion agregado a tal efecto.
            if(resultado.getValueAt(0,"TIPOCLIENTE")!=null)
                dtoTipifi.setDesTipoCliente((String)resultado.getValueAt(0,"TIPOCLIENTE"));
           
            if(resultado.getValueAt(0,"SUBTIPOCLIENTE")!=null)
                dtoTipifi.setDesSubtipoCliente((String)resultado.getValueAt(0,"SUBTIPOCLIENTE"));
           
            if(resultado.getValueAt(0,"TIPOCLASIFICACION")!=null)
                dtoTipifi.setDesTipoClasificacion((String)resultado.getValueAt(0,"TIPOCLASIFICACION"));
           
            if(resultado.getValueAt(0,"CLASIFICACION")!=null)
                dtoTipifi.setDesClasificacion((String)resultado.getValueAt(0,"CLASIFICACION"));
                
            //Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
            //aqui cargamos el arbol de tipificacion.
            //Cada Tipo de cliente sera la raiz del arbol.
            int largo = resultado.getRowCount();
            String strTipoCliente = null;
            String strSubTipoCliente = null;
            String strTipoClasi = null;
            String strClasi = null;
            HashMap hashTipificacion = new HashMap();
            DTOTipificacion dtoTipoCliente = null;
            DTOTipificacion dtoSubTipoCliente = null;
            DTOTipificacion dtoTipoClasi = null;
            DTOTipificacion dtoClasi = null;
            for(int i=0; i< largo;i++){
                //el recordset trae la tipificacion ordenada, por:
                //tipoCliente/subTipoCliente/tipoClasificacion/clasificacion
                strTipoCliente = resultado.getValueAt(i,"TIPOCLIENTE").toString();
                dtoTipoCliente = (DTOTipificacion)hashTipificacion.get(strTipoCliente);
                if(dtoTipoCliente==null){
                    //Es nuevo, lo creamos y lo guardamos en el hash.
                    dtoTipoCliente = new DTOTipificacion(new Integer(DTOTipificacion.TIPIFICACION_TIPO_CLIENTE));
                    dtoTipoCliente.setDescripcionTipificacion(strTipoCliente);
                    dtoTipoCliente.setDependientesTipificacion(new HashMap());
                    //esto se usa en la pantalla para saber si es gerente.
                    dtoTipoCliente.setOidTipificacion(new Long(((BigDecimal)resultado.getValueAt(i,"OID_TIPO_CLIENTE")).longValue()));
                    hashTipificacion.put(new String(strTipoCliente), dtoTipoCliente);
                }
                //ahora, agrego los hijos en orden, si no existen, los creo.
                strSubTipoCliente = (String)resultado.getValueAt(i,"SUBTIPOCLIENTE");
                if(strSubTipoCliente!=null){
                    dtoSubTipoCliente = (DTOTipificacion)dtoTipoCliente.getDependientesTipificacion().get(strSubTipoCliente);
                    if(dtoSubTipoCliente==null){
                        //no existe, lo creo y agrego como hijo del tipo actual
                       dtoSubTipoCliente =  new DTOTipificacion(new Integer(DTOTipificacion.TIPIFICACION_SUBTIPO_CLIENTE));
                       dtoSubTipoCliente.setDescripcionTipificacion(strSubTipoCliente);
                       dtoSubTipoCliente.setDependientesTipificacion(new HashMap());
                       dtoTipoCliente.getDependientesTipificacion().put(new String(strSubTipoCliente),dtoSubTipoCliente );
                    }
                }
                if(dtoSubTipoCliente!=null){//por la dudas, pero no deberia pasar jamas
                    strTipoClasi = (String)resultado.getValueAt(i,"TIPOCLASIFICACION");
                    if(strTipoClasi!=null){
                        dtoTipoClasi = (DTOTipificacion)dtoSubTipoCliente.getDependientesTipificacion().get(strTipoClasi);
                        if(dtoTipoClasi==null){
                           dtoTipoClasi = new DTOTipificacion(new Integer(DTOTipificacion.TIPIFICACION_TIPO_CLASIFICACION_CLIENTE));
                           dtoTipoClasi.setDependientesTipificacion(new HashMap());
                           dtoTipoClasi.setDescripcionTipificacion(strTipoClasi);
                           dtoSubTipoCliente.getDependientesTipificacion().put(new String(strTipoClasi),dtoTipoClasi);
                           //ahora, por ultimo, agregamos la clasificacion. Esto se hace aqui porq
                           //no puede tener clasificacion si no tiene tipo de clasificacion.
                           strClasi = (String)resultado.getValueAt(i,"CLASIFICACION");
                           if(strClasi!=null){
                               dtoClasi = (DTOTipificacion)dtoTipoClasi.getDependientesTipificacion().get(strClasi);
                               if(dtoClasi==null){
                                   dtoClasi = new DTOTipificacion(new Integer(DTOTipificacion.TIPIFICACION_CLASIFICACION_CLIENTE));
                                   dtoClasi.setDescripcionTipificacion(strClasi);
                                   dtoTipoClasi.getDependientesTipificacion().put(new String(strClasi),dtoClasi);
                               }
                           }
                        }
                    }else{
                        //si no tiene tipo de clasificacion no tiene clasificacion.
                        //siguiente registro.
                        continue;
                    }
                }else{
                    UtilidadesLog.debug("-GA- El subtipo de cliente no se encontro, no deberia pasar algo asi. oidCliente: "
                                        +DTOE.getOidCliente());
                }
            }
            dtoTipifi.setArbolTipificacionCliente(hashTipificacion);
        }
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipificacionCliente (DTOCliente DTOE): Salida");
        return dtoTipifi;
    }
    
    public DTONombre obtenerNombreGerenteZona (Long oidCliente) throws MareException {
        //Obtiene el nombre del gerente de zona del cliente que nos pasan como argumento, utilizando el servicio DBService. 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreGerenteZona (Long oidCliente): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT E.VAL_NOM1, ");
        consulta.append("E.VAL_NOM2, ");
        consulta.append("E.VAL_APE1, ");
        consulta.append("E.VAL_APE2, ");
        consulta.append("E.VAL_APEL_CASA ");
        consulta.append("FROM MAE_CLIEN_UNIDA_ADMIN A, ");
        consulta.append("ZON_TERRI_ADMIN B, ");
        consulta.append("ZON_SECCI C, ");
        consulta.append("ZON_ZONA D, ");
        consulta.append("MAE_CLIEN E ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //oidCliente
        parametros.add(oidCliente);
        consulta.append("AND A.IND_ACTI = ? ");
        parametros.add(ConstantesCAL.ACTIVO); //ConstantesCAL.ACTIVO
        consulta.append("AND B.OID_TERR_ADMI = A.ZTAD_OID_TERR_ADMI ");
        consulta.append("AND B.IND_BORR = ? ");
        parametros.add(ConstantesCAL.INACTIVO); //ConstantesCAL.INACTIVO
        consulta.append("AND C.OID_SECC = B.ZSCC_OID_SECC ");
        consulta.append("AND C.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND C.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND D.OID_ZONA = C.ZZON_OID_ZONA ");
        consulta.append("AND D.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND D.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND D.CLIE_OID_CLIE = E.OID_CLIE (+) ");
        consulta.append("AND ROWNUM < 2 ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerNombreGerenteZona: Exception",e);
			this.logSql("obtenerNombreGerenteZona. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        DTONombre dtoNomb = new DTONombre();
        if (!resultado.esVacio()) {
            if(resultado.getValueAt(0,"VAL_NOM1")!=null)
                dtoNomb.setNombre1((String)resultado.getValueAt(0,"VAL_NOM1"));
            if(resultado.getValueAt(0,"VAL_NOM2")!=null)
                dtoNomb.setNombre2((String)resultado.getValueAt(0,"VAL_NOM2"));
            if(resultado.getValueAt(0,"VAL_APE1")!=null)
                dtoNomb.setApellido1((String)resultado.getValueAt(0,"VAL_APE1"));
            if(resultado.getValueAt(0,"VAL_APE2")!=null)
                dtoNomb.setApellido2((String)resultado.getValueAt(0,"VAL_APE2"));
            if(resultado.getValueAt(0,"VAL_APEL_CASA")!=null)
                dtoNomb.setApellidoCasada((String)resultado.getValueAt(0,"VAL_APEL_CASA"));
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreGerenteZona (Long oidCliente): Salida");
        
        
        return dtoNomb;
    }
    
    public DTONombre obtenerNombreGerenteRegional (Long oidCliente) throws MareException
    {
        //Obtiene el nombre del gerente de zona del cliente que nos pasan como argumento, utilizando el servicio DBService. 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreGerenteRegional (Long oidCliente): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT F.VAL_NOM1, ");
        consulta.append("F.VAL_NOM2, ");
        consulta.append("F.VAL_APE1, ");
        consulta.append("F.VAL_APE2, ");
        consulta.append("F.VAL_APEL_CASA ");
        consulta.append("FROM MAE_CLIEN_UNIDA_ADMIN A, ");
        consulta.append("ZON_TERRI_ADMIN B, ");
        consulta.append("ZON_SECCI C, ");
        consulta.append("ZON_ZONA D, ");
        consulta.append("ZON_REGIO E, ");
        consulta.append("MAE_CLIEN F ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //oidCliente
        parametros.add(oidCliente);
        consulta.append("AND A.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND B.OID_TERR_ADMI = A.ZTAD_OID_TERR_ADMI ");
        consulta.append("AND B.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND C.OID_SECC = B.ZSCC_OID_SECC ");
        consulta.append("AND C.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND C.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND D.OID_ZONA = C.ZZON_OID_ZONA ");
        consulta.append("AND D.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND D.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND E.OID_REGI = D.ZORG_OID_REGI ");
        consulta.append("AND E.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND E.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND E.CLIE_OID_CLIE = F.OID_CLIE (+) ");
        consulta.append("AND ROWNUM < 2 ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerNombreGerenteRegional: Exception",e);
			this.logSql("obtenerNombreGerenteRegional. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        DTONombre dtoNomb = new DTONombre();
        if (!resultado.esVacio()) {
            if(resultado.getValueAt(0,"VAL_NOM1")!=null)
                dtoNomb.setNombre1((String)resultado.getValueAt(0,"VAL_NOM1"));
            if(resultado.getValueAt(0,"VAL_NOM2")!=null)
                dtoNomb.setNombre2((String)resultado.getValueAt(0,"VAL_NOM2"));
            if(resultado.getValueAt(0,"VAL_APE1")!=null)
                dtoNomb.setApellido1((String)resultado.getValueAt(0,"VAL_APE1"));
            if(resultado.getValueAt(0,"VAL_APE2")!=null)
                dtoNomb.setApellido2((String)resultado.getValueAt(0,"VAL_APE2"));
            if(resultado.getValueAt(0,"VAL_APEL_CASA")!=null)
                dtoNomb.setApellidoCasada((String)resultado.getValueAt(0,"VAL_APEL_CASA"));
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreGerenteRegional (Long oidCliente): Salida");
        
        return dtoNomb;
    }
    
    public DTONombre obtenerNombreSubgerenteVentas (Long oidCliente) throws MareException
    {
        //Obtiene el nombre del gerente de zona del cliente que nos pasan como argumento, utilizando el servicio DBService.
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreSubgerenteVentas (Long oidCliente): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT G.VAL_NOM1, ");
        consulta.append("G.VAL_NOM2, ");
        consulta.append("G.VAL_APE1, ");
        consulta.append("G.VAL_APE2, ");
        consulta.append("G.VAL_APEL_CASA ");
        consulta.append("FROM MAE_CLIEN_UNIDA_ADMIN A, ");
        consulta.append("ZON_TERRI_ADMIN B, ");
        consulta.append("ZON_SECCI C, ");
        consulta.append("ZON_ZONA D, ");
        consulta.append("ZON_REGIO E, ");
        consulta.append("ZON_SUB_GEREN_VENTA F, ");
        consulta.append("MAE_CLIEN G ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //oidCliente
        parametros.add(oidCliente);
        consulta.append("AND A.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND B.OID_TERR_ADMI = A.ZTAD_OID_TERR_ADMI ");
        consulta.append("AND B.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND C.OID_SECC = B.ZSCC_OID_SECC ");
        consulta.append("AND C.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND C.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND D.OID_ZONA = C.ZZON_OID_ZONA ");
        consulta.append("AND D.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND D.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND E.OID_REGI = D.ZORG_OID_REGI ");
        consulta.append("AND E.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND E.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND F.OID_SUBG_VENT = E.ZSGV_OID_SUBG_VENT ");
        consulta.append("AND F.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND F.IND_BORR = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND F.CLIE_OID_CLIE = G.OID_CLIE (+) ");
        consulta.append("AND F.CLIE_OID_CLIE = G.OID_CLIE (+) ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerNombreSubgerenteVentas: Exception",e);
			this.logSql("obtenerNombreSubgerenteVentas. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        DTONombre dtoNomb = new DTONombre();
        if (!resultado.esVacio()) {
            if(resultado.getValueAt(0,"VAL_NOM1")!=null)
                dtoNomb.setNombre1(((String)resultado.getValueAt(0,"VAL_NOM1")));
            if(resultado.getValueAt(0,"VAL_NOM2")!=null)
                dtoNomb.setNombre2(((String)resultado.getValueAt(0,"VAL_NOM2")));
            if(resultado.getValueAt(0,"VAL_APE1")!=null)
                dtoNomb.setApellido1(((String)resultado.getValueAt(0,"VAL_APE1")));
            if(resultado.getValueAt(0,"VAL_APE2")!=null)
                dtoNomb.setApellido2(((String)resultado.getValueAt(0,"VAL_APE2")));
            if(resultado.getValueAt(0,"VAL_APEL_CASA")!=null)
                dtoNomb.setApellidoCasada(((String)resultado.getValueAt(0,"VAL_APEL_CASA")));
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerNombreSubgerenteVentas (Long oidCliente): Salida");
        
        return dtoNomb;        
    }
    
    public RecordSet obtenerUnidadesAdministrativas (DTOCliente DTOE) throws MareException
    {
        //Obtiene las unidades administrativas del cliente, utilizando el servicio DBService. 
        //Los campos marcados con --DESCRIPCION indican que sólo debe obtenerse la descripción,son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerUnidadesAdministrativas (DTOCliente DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT h.OID_CLIE_UNID_ADMI OID, ");    //BELC300012938
        consulta.append(" I.VAL_NOMB_PERI PERIODO, ");  //no es internacionalizable
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" L.DES_MARC MARCA, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_CANAL' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = M.OID_CANA ), ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" G.DES_SUBG_VENT SUBVENTAS, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" F.DES_REGI REGION, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" E.DES_ZONA ZONA, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" D.DES_SECCI SECCION, ");
        // Fin subselect
        consulta.append("B.COD_TERR, ");
        consulta.append("DECODE( h.ind_acti,1,'SI',0,'NO') indicadorActivo, ");
        consulta.append(" n.VAL_NOMB_PERI periodoFin ");
        
        consulta.append("FROM  ");
        consulta.append("ZON_TERRI B, ");
        consulta.append("ZON_TERRI_ADMIN C, ");
        consulta.append("ZON_SECCI D, ");
        consulta.append("ZON_ZONA E, ");
        consulta.append("ZON_REGIO F, ");
        consulta.append("ZON_SUB_GEREN_VENTA G, ");
        consulta.append("MAE_CLIEN_UNIDA_ADMIN H, ");
        consulta.append("CRA_PERIO I, ");
        consulta.append("SEG_PERIO_CORPO J, ");
        consulta.append("SEG_TIPO_PERIO K, ");
        consulta.append("SEG_MARCA L, ");
        consulta.append("SEG_CANAL M, ");
        consulta.append(" cra_perio n, ");
        consulta.append(" seg_perio_corpo o  ");
        
        consulta.append("WHERE H.CLIE_OID_CLIE = ? "); //DTOE.oidCliente
        parametros.add(DTOE.getOidCliente());
       // consulta.append("AND A.IND_DIRE_PPAL = ? "); //ConstantesCAL.ACTIVO
        //parametros.add(ConstantesCAL.ACTIVO);
        //consulta.append("AND A.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
         consulta.append("AND C.OID_TERR_ADMI = h.ZTAD_OID_TERR_ADMI ");
        consulta.append("AND B.OID_TERR = c.TERR_OID_TERR ");
        
        
        consulta.append("AND D.OID_SECC = C.ZSCC_OID_SECC ");
        consulta.append("AND E.OID_ZONA = D.ZZON_OID_ZONA ");
        consulta.append("AND F.OID_REGI = E.ZORG_OID_REGI ");
        consulta.append("AND G.OID_SUBG_VENT = F.ZSGV_OID_SUBG_VENT ");
        consulta.append("AND H.CLIE_OID_CLIE = H.CLIE_OID_CLIE ");
        //consulta.append("AND H.IND_ACTI = ? "); //ConstantesCAL.ACTIVO
        //parametros.add(ConstantesCAL.ACTIVO);
        consulta.append("AND I.OID_PERI = H.PERD_OID_PERI_INI ");
        consulta.append(" AND n.OID_PERI(+) = H.PERD_OID_PERI_FIN ");
        consulta.append(" AND J.OID_PERI = I.PERI_OID_PERI ");
        consulta.append(" AND o.oid_peri(+) = n.peri_oid_peri ");
        consulta.append("AND K.OID_TIPO_PERI = J.TIPE_OID_TIPO_PERI ");
        
        //Jrivas 9/3/2006 BDLG5000426
        //consulta.append("AND L.OID_MARC = I.MARC_OID_MARC ");
        //consulta.append("AND M.OID_CANA = I.CANA_OID_CANA ");
        consulta.append("AND L.OID_MARC = G.MARC_OID_MARC ");
        consulta.append("AND M.OID_CANA = G.CANA_OID_CANA ");
        // vbongiov -- RI 20070444 -- 21/04/2009 
        //consulta.append("AND C.IND_BORR = 0 "); //27-07-2007 (Sapaza), agregado por incidencia SiCC-20070367
        consulta.append(" ORDER BY indicadoractivo desc, periodo desc ");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerUnidadesAdministrativas: Exception",e);
			this.logSql("obtenerUnidadesAdministrativas. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        /*if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerUnidadesAdministrativas: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerUnidadesAdministrativas (DTOCliente DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerUltimosPedidos (DTOCliente DTOE) throws MareException
    {
        //Obtiene los últimos 5 pedidos del cliente, utilizando el servicio DBService. 
        //Los campos marcados con --DESCRIPCION indican que sólo debe obtenerse la descripción, son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerUltimosPedidos (DTOCliente DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT A.OID_SOLI_CABE,"); //BELC300012950
        consulta.append(" A.VAL_NUME_SOLI, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_ESTAD_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = B.OID_ESTA_SOLI ) OID_ESTA_SOLI, ");
        // Fin subselect
        consulta.append(" DECODE (NVL(A.MONE_OID_MONE, 0), 0, A.VAL_TOTA_PAGA_LOCA, A.VAL_TOTA_PAGA_DOCU), ");  //BELC300012950
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'CAR_ESTAT_PEDID' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = C.OID_ESTA_PEDI ) OID_ESTA_PEDI ");
        // Fin subselect
        consulta.append("FROM PED_SOLIC_CABEC A, ");
        consulta.append("PED_ESTAD_SOLIC B, ");
        consulta.append("CAR_ESTAT_PEDID C ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //DTOE.oidCliente
        parametros.add(DTOE.getOidCliente());
        consulta.append("AND A.IND_TS_NO_CONSO = ? "); //ConstantesCAL.INACTIVO
        parametros.add(ConstantesCAL.INACTIVO);
        consulta.append("AND A.GRPR_OID_GRUP_PROC = ? "); //ConstantesPED.GP5
        parametros.add(ConstantesPED.GP5);
        consulta.append("AND B.OID_ESTA_SOLI = A.ESSO_OID_ESTA_SOLI ");
        consulta.append("AND C.OID_ESTA_PEDI (+) = A.ESPE_OID_ESTA_PEDI "); 
        consulta.append("AND ROWNUM<6 ");
        consulta.append("ORDER BY A.FEC_CRON DESC ");
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerUltimosPedidos: Exception",e);
			this.logSql("obtenerUltimosPedidos. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        /*if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerUltimosPedidos: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerUltimosPedidos (DTOCliente DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerContactos (DTOCliente DTOE) throws MareException
    {
        //Obtiene los contactos del cliente, utilizando el servicio DBService. 
        //De los campos marcados con --DESCRIPCION debe obtenerse únicamente 
        //la descripcion, son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerContactos (DTOCliente DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        consulta.append("SELECT A.COD_OPER CODIGO, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'CAL_MOTIV_CONTA' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = B.OID_MOTI_CONT ) OID_MOTI_CONT, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'CAL_TIPO_ESTAD_CONTA' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.OID_TIPO_ESTA_CONT ) OID_TIPO_ESTA_CONT, ");
        // Fin subselect
        consulta.append("A.FEC_CONT ");
        consulta.append("FROM CAL_CONTA A, ");
        consulta.append("CAL_MOTIV_CONTA B, ");
        consulta.append("CAL_ATRIB_ESTAD_CONTA C, ");
        consulta.append("CAL_TIPO_ESTAD_CONTA D ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //DTOE.oidCliente
        parametros.add(DTOE.getOidCliente());
        consulta.append("AND B.OID_MOTI_CONT = A.MOCO_OID_MOTI_CONT ");
        consulta.append("AND C.OID_ATRI_ESTA_CONT = A.ATEC_OID_ATRI_ESTA_CONT ");
        consulta.append("AND D.OID_TIPO_ESTA_CONT = C.TECO_OID_TIPO_ESTA_CONT ");
        consulta.append("AND D.OID_TIPO_ESTA_CONT<> ? "); //ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_CERRADO
        parametros.add(ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_CERRADO);
        consulta.append("ORDER BY A.FEC_CONT DESC ");
        consulta.append(") XY ) WHERE linea > " + DTOE.getIndicadorSituacion() + " AND ROWNUM <= " + DTOE.getTamanioPagina() );
        /*
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes 
        consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina 
        */
        this.logSql("obtenerContactos. SQL: ", consulta.toString(), parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerContactos: Exception",e);
            this.logSql("obtenerContactos. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

       /* if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerContactos: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerContactos (DTOCliente DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerCuentasCorrientes (DTOOIDPaginado DTOE) throws MareException
    {
        //Obtiene los movimientos de las cuentas corrientes del cliente, utilizando el servicio DBService. 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerCuentasCorrientes (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT A.OID_MOVI_CC OID, B.VAL_NOMB_PERI, ");
        consulta.append("A.VAL_EJER_CUOT, ");
        consulta.append("A.NUM_IDEN_CUOT, ");
        consulta.append("A.NUM_ORDE_CUOT, ");
        consulta.append("C.DES_TIPO_DOCU , ");
        consulta.append("A.IND_DTO_CARG_APLI, ");
        consulta.append("A.VAL_REFE_NUME_DOCU_EXTE, ");
        consulta.append("A.FEC_DOCU, ");
        consulta.append("A.FEC_VENC, ");
        consulta.append("A.FEC_VALO, ");
        consulta.append("A.IMP_MOVI, ");
        consulta.append("A.IMP_PAGA, ");
        consulta.append("A.VAL_OBSE ");
        consulta.append("FROM CCC_MOVIM_CUENT_CORRI A, ");
        consulta.append("CRA_PERIO B, ");
        consulta.append("FAC_TIPO_DOCUM C ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //DTOE.oid
        parametros.add(DTOE.getOid());
        consulta.append("AND B.OID_PERI = A.PERD_OID_PERI ");
        consulta.append("AND C.OID_TIPO_DOCU (+) = A.TIDO_OID_TIPO_DOCU ");
        /*
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes 
        consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina
        */
        String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE); //incidencia 12536
        this.logSql("obtenerCuentasCorrientes. SQL: ",sql, parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerCuentasCorrientes: Exception",e);
            this.logSql("obtenerCuentasCorrientes. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

       /* if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerCuentasCorrientes: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerCuentasCorrientes (DTOOIDPaginado DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerVinculos (DTOOIDPaginado DTOE) throws MareException
    {
        //Incidencia 12536 -> cambia el dto de entrada de DTOOID a DTOOIDPaginado
        //Obtiene los vínculos del cliente, utilizando el servicio DBService. 
        //El campo marcado con --DESCRIPCION, indica que sólo se mostrará la descripción, son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerVinculos (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT B.OID_CLIE_VINC OID, A.COD_CLIE, ");
        consulta.append("B.FEC_DESD, ");
        consulta.append("B.FEC_HAST, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_VINCU' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = C.OID_TIPO_VINC ) OID_TIPO_VINC ");
        // Fin subselect
        consulta.append("FROM MAE_CLIEN A, ");
        consulta.append("MAE_CLIEN_VINCU B, ");
        consulta.append("MAE_TIPO_VINCU C ");
        consulta.append("WHERE B.CLIE_OID_CLIE_VNTE = ? "); //DTOE.oid
        parametros.add(DTOE.getOid());
        consulta.append("AND A.OID_CLIE = B.CLIE_OID_CLIE_VNDO ");
        consulta.append("AND C.OID_TIPO_VINC = B.TIVC_OID_TIPO_VINC ");
        /*Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes 
        consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina
        */
        String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE);
        this.logSql("obtenerVinculos. SQL: ",sql, parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerVinculos: Exception",e);
            this.logSql("obtenerVinculos. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAORecepcionLlamadas.obtenerVinculos (DTOOIDPaginado DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerDocumentos (DTOOIDPaginado DTOE) throws MareException
    {
       //Incidencia 12536 -> cambia el dto de entrada de DTOOID a DTOOIDPaginado
        //Obtiene los números de documentos escaneables del cliente, utilizando el servicio DBService. 
        //La tabla no estaba creada cuando se diseño, revisar bien los nombres de los campos y de la tabla 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDocumentos (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT OID_DOCU_ESCA OID, NUM_DOCU_ESCA  ");
        consulta.append("FROM CAL_DOCUM_ESCAN ");
        consulta.append("WHERE CLIE_OID_CLIE = ? "); //DTOE.oid
        parametros.add(DTOE.getOid());
        
        /*
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes 
        consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina
        */
        String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE);
        this.logSql("obtenerDocumentos. SQL: ",sql, parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerDocumentos: Exception",e);
            this.logSql("obtenerDocumentos. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDocumentos (DTOOIDPaginado DTOE): Salida");
        
        return resultado;
    }
    
    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080589 - dmorello, 09/09/2008
     *     Se agregan a la descripcion de unidad geografica los niveles 4 a 9 en caso de existir
     *     Para ello, se recuperan por separado los diferentes niveles
     *     y la query se anida en otra que los concatena formando la nueva descripcion
     */
    public RecordSet obtenerDirecciones (DTOOIDPaginado DTOE) throws MareException
    {
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDirecciones (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT oid, descripcion, des_abrv_tipo_via ");
        consulta.append("      , nivel_1 ");
        consulta.append("          || DECODE(nivel_2, NULL, '', '/' || nivel_2) ");
        consulta.append("          || DECODE(nivel_3, NULL, '', '/' || nivel_3) ");
        consulta.append("          || DECODE(nivel_4, NULL, '', '/' || nivel_4) ");
        consulta.append("          || DECODE(nivel_5, NULL, '', '/' || nivel_5) ");
        consulta.append("          || DECODE(nivel_6, NULL, '', '/' || nivel_6) ");
        consulta.append("          || DECODE(nivel_7, NULL, '', '/' || nivel_7) ");
        consulta.append("          || DECODE(nivel_8, NULL, '', '/' || nivel_8) ");
        consulta.append("          || DECODE(nivel_9, NULL, '', '/' || nivel_9) AS orde ");
        consulta.append("      , cod_terr, val_nomb_via, num_ppal, val_cod_post, val_inte ");
        consulta.append("      , val_manz, val_lote, val_km, val_obse, ind_dire_ppal, ");
        consulta.append("      DECODE(IND_ELIM, 0,'SI',1,'NO')INDICADORELIMINADA ");
        consulta.append(" FROM ( ");
        
        consulta.append("SELECT A.OID_CLIE_DIRE OID, ");
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_DIREC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO =  " + DTOE.getOidIdioma());
        //parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = B.OID_TIPO_DIRE ) AS descripcion, ");
        consulta.append("C.DES_ABRV_TIPO_VIA, ");
        
        consulta.append("  (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 IS NULL) AS nivel_1 ");
        consulta.append(", (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("      AND orde_3 IS NULL) AS nivel_2 ");
        consulta.append(", (SELECT des_geog ");
        consulta.append("     FROM zon_valor_estru_geopo ");
        consulta.append("    WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("      AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("      AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("      AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("      AND orde_4 IS NULL) AS nivel_3 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 18 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_4 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 24 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_5 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 30 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_6 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 36 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_7 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 42 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 = SUBSTR (a.cod_unid_geog, 43, 6) ");
        consulta.append("          AND orde_9 IS NULL) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_8 ");
        consulta.append(", CASE WHEN LENGTH (a.cod_unid_geog) > 48 THEN ");
        consulta.append("      (SELECT des_geog ");
        consulta.append("         FROM zon_valor_estru_geopo ");
        consulta.append("        WHERE pais_oid_pais = d.pais_oid_pais ");
        consulta.append("          AND orde_1 = SUBSTR (a.cod_unid_geog, 1, 6) ");
        consulta.append("          AND orde_2 = SUBSTR (a.cod_unid_geog, 7, 6) ");
        consulta.append("          AND orde_3 = SUBSTR (a.cod_unid_geog, 13, 6) ");
        consulta.append("          AND orde_4 = SUBSTR (a.cod_unid_geog, 19, 6) ");
        consulta.append("          AND orde_5 = SUBSTR (a.cod_unid_geog, 25, 6) ");
        consulta.append("          AND orde_6 = SUBSTR (a.cod_unid_geog, 31, 6) ");
        consulta.append("          AND orde_7 = SUBSTR (a.cod_unid_geog, 37, 6) ");
        consulta.append("          AND orde_8 = SUBSTR (a.cod_unid_geog, 43, 6) ");
        consulta.append("          AND orde_9 = SUBSTR (a.cod_unid_geog, 49, 6)) ");
        consulta.append("  ELSE NULL ");
        consulta.append("  END AS nivel_9, ");
        
        consulta.append("D.COD_TERR, ");
        consulta.append("A.VAL_NOMB_VIA, ");
        consulta.append("A.NUM_PPAL, ");
        consulta.append("A.VAL_COD_POST, ");
        consulta.append("A.VAL_INTE, ");
        consulta.append("A.VAL_MANZ, ");
        consulta.append("A.VAL_LOTE, ");
        consulta.append("A.VAL_KM, ");
        consulta.append("A.VAL_OBSE, ");
        consulta.append("A.IND_DIRE_PPAL, ");
        consulta.append("A.IND_ELIM ");
        
        consulta.append("FROM MAE_CLIEN_DIREC A, ");
        consulta.append("MAE_TIPO_DIREC B, ");
        consulta.append("SEG_TIPO_VIA C, ");
        consulta.append("ZON_TERRI D, ");
        consulta.append("ZON_VALOR_ESTRU_GEOPO E ");
        consulta.append("WHERE A.CLIE_OID_CLIE =  " + DTOE.getOid()); //DTOE.oid
       // parametros.add(DTOE.getOid());
        //consulta.append("AND A.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        consulta.append("AND B.OID_TIPO_DIRE = A.TIDC_OID_TIPO_DIRE ");
        consulta.append("AND C.OID_TIPO_VIA = A.TIVI_OID_TIPO_VIA ");
        consulta.append("AND D.OID_TERR = A.TERR_OID_TERR ");
        consulta.append("AND E.OID_VALO_ESTR_GEOP (+) = D.VEPO_OID_VALO_ESTR_GEOP ");
        
        consulta.append(" ORDER BY  ind_elim,  ind_dire_ppal DESC ) ");
        
        /*Esta búsqueda es paginada, por tanto habrá que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina*/
        String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE);
        this.logSql("obtenerDirecciones. SQL: ",sql, parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
            //executePreparedQuery(sql,parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerDirecciones: Exception",e);
            this.logSql("obtenerDirecciones. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDirecciones (DTOOIDPaginado DTOE): Salida");
        
        return resultado;
    }
    
    public RecordSet obtenerCabeceraPedidos (DTOOIDPaginado DTOE) throws MareException
    {
        //Incidencia 12536 -> cambia el dto de entrada de DTOOID a DTOOIDPaginado
        //Obtiene las cabeceras de pedidos del cliente, utilizando el servicio DBService. 
        //El campo marcado con --DESCRIPCION, indica que sólo se mostrará la descripción, son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerCabeceraPedidos (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        consulta.append("SELECT A.OID_SOLI_CABE OID, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_ESTAD_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.ESSO_OID_ESTA_SOLI ) AS ESTA_SOLI, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.OID_TIPO_SOLI ) AS TIPO_SOLI, ");
        // Fin subselect
        consulta.append("A.VAL_NUME_SOLI, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_CLASE_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.CLSO_OID_CLAS_SOLI ) AS CLAS_SOLI, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = G.TIPE_OID_TIPO_PERI ) AS TIPO_PERI, ");
        // Fin subselect
        consulta.append("F.VAL_NOMB_PERI, ");
        consulta.append("A.FEC_CRON, ");
        consulta.append("I.VAL_NOMB_CORT_MONE, ");
        //Añadido por incidencia 12970
        // Subselect para obtener la descripcion del tipoDocumentoLegal
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.TDOC_OID_TIPO_DOCU ) AS TIPO_DOCU, ");
        // Fin subselect
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_PREC_NETO_TOTA_LOCA, A.VAL_PREC_NETO_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_DESC_1_TOTA_LOCA, A.VAL_IMPO_DESC_1_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_PREC_CONT_TOTA_LOCA, A.VAL_PREC_CONT_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_DESC_TOTA_LOCA, A.VAL_IMPO_DESC_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_FLET_LOCA, A.VAL_IMPO_FLET_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_FLET_TOTA_LOCA, A.VAL_IMPO_FLET_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_IMPU_TOTA_LOCA, A.VAL_IMPO_IMPU_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_TOTA_PAGA_LOCA, A.VAL_TOTA_PAGA_DOCU) ");
        consulta.append("FROM PED_SOLIC_CABEC A, ");
        consulta.append("PED_TIPO_SOLIC_PAIS C, ");
        consulta.append("PED_TIPO_SOLIC D, ");
        consulta.append("CRA_PERIO F, ");
        consulta.append("SEG_PERIO_CORPO G, ");
        consulta.append("SEG_MONED I ");
        consulta.append("WHERE A.CLIE_OID_CLIE = ? "); //INCIDENCIA 12415
        parametros.add(DTOE.getOid());
        consulta.append("AND C.OID_TIPO_SOLI_PAIS = A.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("AND D.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
        consulta.append("AND F.OID_PERI = A.PERD_OID_PERI ");
        consulta.append("AND G.OID_PERI = F.PERI_OID_PERI ");
        consulta.append("AND I.OID_MONE (+) = A.MONE_OID_MONE ");
        consulta.append("ORDER BY FEC_CRON DESC ");
        consulta.append(") XY ) WHERE linea > " + DTOE.getIndicadorSituacion() + " AND ROWNUM <= " + DTOE.getTamanioPagina() );
        /*Esta búsqueda es paginada, por tanto habrá que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina*/
        this.logSql("obtenerCabeceraPedidos. SQL: ",consulta.toString(), parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerCabeceraPedidos: Exception",e);
            this.logSql("obtenerCabeceraPedidos. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerCabeceraPedidos: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerCabeceraPedidos (DTOOIDPaginado DTOE): Salida");
       
        return resultado;
    }
    
    public RecordSet obtenerDetalleCabecera (DTOOIDPaginado DTOE) throws MareException
    {
        //Incidencia 12536 -> cambia el dto de entrada de DTOOID a DTOOIDPaginado
        //Obtiene los detalles de pedidos para una cabecera determinada, utilizando el servicio DBService. 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDetalleCabecera (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT A.OID_SOLI_POSI OID, ");
        consulta.append("A.VAL_CODI_VENT, ");
        consulta.append("A.VAL_LOTE_PROD, ");
        consulta.append("A.NUM_UNID_DEMA, ");
        consulta.append("A.NUM_UNID_POR_ATEN, ");
        consulta.append("A.NUM_UNID_COMPR, ");
        consulta.append("A.NUM_UNID_ATEN, ");
        consulta.append("DECODE (NVL(B.MONE_OID_MONE,0), 0, A.VAL_PREC_CATA_TOTA_LOCA, A.VAL_PREC_CATA_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(B.MONE_OID_MONE,0), 0, A.VAL_IMPO_DESC_TOTA_LOCA, A.VAL_IMPO_DESC_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(B.MONE_OID_MONE,0), 0, A.VAL_IMPO_IMPU_TOTA_LOCA, A.VAL_IMPO_IMPU_TOTA_DOCU) ");
        consulta.append("FROM PED_SOLIC_POSIC A, ");
        consulta.append("PED_SOLIC_CABEC B ");
        consulta.append("WHERE A.SOCA_OID_SOLI_CABE = ? "); //DTOE.oid
        parametros.add(DTOE.getOid());
        consulta.append("AND B.OID_SOLI_CABE = A.SOCA_OID_SOLI_CABE ");
        /*Esta búsqueda es paginada, por tanto habrá que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina */
        String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE); 
        this.logSql("obtenerDetalleCabecera. SQL: ",sql, parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerDetalleCabecera: Exception",e);
            this.logSql("obtenerDetalleCabecera. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.debug("obtenerDetalleCabecera: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDetalleCabecera (DTOOIDPaginado DTOE): Salida");
        
        return resultado;
    }
    
    public  DTOCabeceraPedido obtenerDatosAdicionalesCabecera (DTOOID DTOE) throws MareException
    {
        //Obtiene los datos adicionales de la cabecera, utilizando el servicio DBService. 
        //Los campos marcados con --DESCRIPCION debe obtenerse únicamente la descripcion, son internacionalizables 
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosAdicionalesCabecera (DTOOID DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'CAR_CODIG_APROB' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = R.COAP_OID_CODI_APRO ) AS COD_APR, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'CAR_ESTAT_PEDID' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.ESPE_OID_ESTA_PEDI ) AS ESTA_PED, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_CANAL' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = C.CANA_OID_CANA ) AS CANAL, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_ACCES' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = E.ACCE_OID_ACCE ) AS ACCESO, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_SUBAC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = E.OID_SBAC ) AS SUBACCESO, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_ACCES_FISIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.ACFI_OID_ACCE_FISI ) AS ACCE_FISI, ");
        // Fin subselect
        consulta.append(" I.COD_CLIE , ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_DIREC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = M.TIDC_OID_TIPO_DIRE ) AS TIPO_DIRE, ");
        // Fin subselect
        consulta.append("J.COD_CLIE, "); //--PAGADOR
        consulta.append("K.COD_CLIE, "); //--RECEPTOR FACTURA 
        consulta.append("L.COD_CLIE, "); //--CONSULTORA ASOCIADA 
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_MODUL' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.MODU_OID_MODU ) AS MODULO, ");
        // Fin subselect
        consulta.append("A.IND_ESTA, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'BEL_ALMAC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.ALMC_OID_ALMA ) AS ALMACEN, ");
        // Fin subselect
        consulta.append("P.VAL_DENO, ");
        consulta.append("A.VAL_GLOS_OBSE, ");
        consulta.append("A.FEC_FACT, ");
        consulta.append("A.FEC_PROG_FACT ");
        consulta.append("FROM PED_SOLIC_CABEC A, ");
        consulta.append("CRA_PERIO C, ");
        consulta.append("SEG_SUBAC E, ");
        consulta.append("MAE_CLIEN I, ");
        consulta.append("MAE_CLIEN J, ");
        consulta.append("MAE_CLIEN K, ");
        consulta.append("MAE_CLIEN L, ");
        consulta.append("MAE_CLIEN_DIREC M, ");
        consulta.append("SEG_SOCIE P, ");
        consulta.append("CAR_SOLI_ENTR_BLOQ R ");
        consulta.append("WHERE A.OID_SOLI_CABE = ? "); //DTOE.oid
        parametros.add(DTOE.getOid());
        consulta.append("AND C.OID_PERI = A.PERD_OID_PERI ");
        consulta.append("AND E.OID_SBAC = A.SBAC_OID_SBAC ");
        consulta.append("AND I.OID_CLIE (+) = A.CLIE_OID_CLIE_DEST ");
        consulta.append("AND J.OID_CLIE = A.CLIE_OID_CLIE_PAGA ");
        consulta.append("AND K.OID_CLIE = A.CLIE_OID_CLIE_RECE_FACT ");
        consulta.append("AND L.OID_CLIE (+) = A.CLIE_OID_CONS_ASOC ");
        consulta.append("AND M.OID_CLIE_DIRE (+) = A.CLDI_OID_CLIE_DIRE ");
        consulta.append("AND P.OID_SOCI = A.SOCI_OID_SOCI ");
        consulta.append("AND R.SOCA_OID_SOLI_CABE (+) = A.OID_SOLI_CABE ");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerDatosAdicionalesCabecera: Exception",e);
			this.logSql("obtenerDatosAdicionalesCabecera. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
         if (resultado.esVacio()) {
            UtilidadesLog.debug("obtenerDatosAdicionalesCabecera: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(codigoError));
        }
        /* Incidencia 12384 DTOCabeceraPedido
        Crear un dtoCabecera del tipo DTOCabecera con la siguiente informacion: 
        dtoCabecera.motivoAprobacion = descripcion (S.OID_CODI_APRO) 
        dtoCabecera.estadoCredito = descripcion (B.OID_ESTA_PEDI) 
        dtoCabecera.canal = descripcion (D.OID_CANA) 
        dtoCabecera.acceso = descripcion (F.OID_ACCE) 
        dtoCabecera.localSubacceso = descripcion (E.OID_SBAC) 
        dtoCabecera.accesoFisico = descripcion (G.OID_ACCE_FISI) 
        dtoCabecera.destinatario = I.COD_CLIE 
        dtoCabecera.destino = descripcion (N.OID_TIPO_DIRE) 
        dtoCabecera.pagador = J.COD_CLIE 
        dtoCabecera.consultoraAsociada = L.COD_CLIE 
        dtoCabecera.receptorFactura = K.COD_CLIE 
        dtoCabecera.moduloGeneraPedido = descripcion (O.OID_MODU) 
        dtoCabecera.estadisticable = A.IND_ESTA 
        dtoCabecera.almacenSalida = descripcion (H.OID_ALMA) 
        dtoCabecera.sociedadVentas = P.VAL_DENO 
        dtoCabecera.glosa = A.VAL_GLOS_OBSE 
        dtoCabecera.fechaFacturacion = A.FEC_FACT 
        dtoCabecera.fechaProgFacturacion = A.FEC_PROG_FACT 
        
        Devolver el dtoCabecera
        */
        DTOCabeceraPedido dtoCabecera = new DTOCabeceraPedido();
        dtoCabecera.setMotivoAprobacion(resultado.getValueAt(0,0) != null ? resultado.getValueAt(0,0).toString() : null); //descripcion (S.OID_CODI_APRO) 
        dtoCabecera.setEstadoCredito(resultado.getValueAt(0,1) != null ? resultado.getValueAt(0,1).toString() : null); // descripcion (B.OID_ESTA_PEDI) 
        dtoCabecera.setCanal(resultado.getValueAt(0,2) != null ? resultado.getValueAt(0,2).toString() : null); // descripcion (D.OID_CANA) 
        dtoCabecera.setAcceso(resultado.getValueAt(0,3) != null ? resultado.getValueAt(0,3).toString() : null); // descripcion (F.OID_ACCE) 
        dtoCabecera.setLocalSubacceso(resultado.getValueAt(0,4) != null ? resultado.getValueAt(0,4).toString() : null); // descripcion (E.OID_SBAC) 
        dtoCabecera.setAccesoFisico(resultado.getValueAt(0,5) != null ? resultado.getValueAt(0,5).toString() : null); // descripcion (G.OID_ACCE_FISI) 
        dtoCabecera.setDestinatario(resultado.getValueAt(0,6) != null ? resultado.getValueAt(0,6).toString() :  null); // I.COD_CLIE 
        dtoCabecera.setDestino(resultado.getValueAt(0,7) != null ? resultado.getValueAt(0,7).toString() : null); // descripcion (N.OID_TIPO_DIRE) 
        dtoCabecera.setPagador(resultado.getValueAt(0,8) != null ? resultado.getValueAt(0,8).toString() : null); // J.COD_CLIE 
        dtoCabecera.setConsultoraAsociada(resultado.getValueAt(0,10) != null ? resultado.getValueAt(0,10).toString() : null); // L.COD_CLIE 
        dtoCabecera.setReceptorFactura(resultado.getValueAt(0,9) != null ? resultado.getValueAt(0,9).toString() : null); // K.COD_CLIE 
        dtoCabecera.setModuloGeneraPedido(resultado.getValueAt(0,11) != null ? resultado.getValueAt(0,11).toString() : null); // descripcion (O.OID_MODU) 
        dtoCabecera.setEstadisticable(resultado.getValueAt(0,12) != null ? resultado.getValueAt(0,12).toString() : null); // A.IND_ESTA 
        dtoCabecera.setAlmacenSalida(resultado.getValueAt(0,13) != null ? resultado.getValueAt(0,13).toString() : null); // descripcion (H.OID_ALMA) 
        dtoCabecera.setSociedadVentas(resultado.getValueAt(0,14) != null ? resultado.getValueAt(0,14).toString() : null); // P.VAL_DENO 
        dtoCabecera.setGlosa(resultado.getValueAt(0,15) != null ? resultado.getValueAt(0,15).toString() : null); // A.VAL_GLOS_OBSE 
        dtoCabecera.setFechaFacturacion(resultado.getValueAt(0,16) != null ? (Date)resultado.getValueAt(0,16) : null); // A.FEC_FACT 
        dtoCabecera.setFechaProgFacturacion(resultado.getValueAt(0,17) != null ? (Date)resultado.getValueAt(0,17) :  null); // A.FEC_PROG_FACT 
                
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosAdicionalesCabecera (DTOOID DTOE): Salida");
        
        return dtoCabecera;
    }
    
    public DTODetallePedido obtenerDatosAdicionalesDetalle (DTOOID DTOE) throws MareException {
        // **** Modificado por incidencia 12384
        //Obtiene los datos adicionales del detalle, utilizando el servicio DBService. 
        //Los campos marcados con --DESCRIPCION debe obtenerse únicamente la descripcion, son internacionalizables 

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosAdicionalesDetalle (DTOOID DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT ");
        
        // Subselect para obtener la descripcion internacionalizable  D.OID_TIPO_SOLI, --DESCRIPCION 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = C.TSOL_OID_TIPO_SOLI ) AS TIPO_SOLI, ");
        
        consulta.append(" B2.VAL_NUME_SOLI NUMERODESOLICITUDORIGEN, ");
        
        // Subselect para obtener la descripcion internacionalizable   E.OID_ESTA_POSI, --DESCRIPCION 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_ESTAD_POSIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A1.ESPO_OID_ESTA_POSI ) AS ESTA_POSI, ");
        
         // Subselect para obtener la descripcion internacionalizable   F.OID_TIPO_POSI, --DESCRIPCION 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_POSIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A1.TPOS_OID_TIPO_POSI ) AS TIPO_POSI, ");
        
        consulta.append(" B3.VAL_NUME_SOLI, A1.IND_LIMI_VENT, A1.IND_CTRL_STOC, ");
        consulta.append(" A1.IND_CTRL_LIQU, ");
        
        
         // Subselect para obtener la descripcion internacionalizable    G.OID_FORM_PAGO --DESCRIPCION 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'BEL_FORMA_PAGO' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID =  A1.FOPA_OID_FORM_PAGO ) AS FORM_PAGO ");
        
        consulta.append("  FROM PED_SOLIC_POSIC A1, PED_SOLIC_POSIC A2, ");
        consulta.append(" PED_SOLIC_CABEC B1, PED_SOLIC_CABEC B2, PED_SOLIC_CABEC B3, ");
        consulta.append(" PED_TIPO_SOLIC_PAIS C ");
        
        
        consulta.append(" WHERE A1.OID_SOLI_POSI = ? ");
        parametros.add(DTOE.getOid());
        consulta.append(" AND B1.OID_SOLI_CABE = A1.SOCA_OID_SOLI_CABE ");
        consulta.append(" AND B2.OID_SOLI_CABE (+) = B1.SOCA_OID_DOCU_REFE ");
        consulta.append(" AND C.OID_TIPO_SOLI_PAIS (+) = B2.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND A2.OID_SOLI_POSI (+) = A1.SOPO_OID_SOLI_POSI ");
        consulta.append(" AND B3.OID_SOLI_CABE (+) = A2.SOCA_OID_SOLI_CABE ");
        
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerDatosAdicionalesDetalle: Exception",e);
            this.logSql(" obtenerDatosAdicionalesDetalle. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        //  Incidencia 12384 DTODetallePedido
        /*Crear un dtoDetalle del tipo DTODetallePedido con la siguiente informacion: 
        tipoSolicitudOrigen = D.OID_TIPO_SOLI //descripcion 
        numSolicitudOrigen = B2.VAL_NUME_SOLI 
        estadoPosicion = E.OID_ESTA_POSI //DESCRIPCION 
        tipoPosicion = F.OID_TIPO_POSI //DESCRIPCION 
        numSolicitudRecuperacion = B3.VAL_NUME_SOLI 
        limiteVenta = A1.IND_LIMI_VENT 
        controlStock = A1.IND_CTRL_STOC 
        controlLiquidacion = A1.IND_CTRL_LIQU 
        formaPago = G.OID_FORM_PAGO //DESCRIPCION 
        */
        DTODetallePedido dtoDetalle = new DTODetallePedido();
        dtoDetalle.setTipoSolicitudOrigen(rs.getValueAt(0,0)!= null ? rs.getValueAt(0,0).toString():null);
        dtoDetalle.setNumSolicitudRecuperacion(rs.getValueAt(0,1)!= null ? rs.getValueAt(0,1).toString() :null);
        dtoDetalle.setEstadoPosicion(rs.getValueAt(0,2)!= null ? rs.getValueAt(0,2).toString() :null);
        dtoDetalle.setTipoPosicion(rs.getValueAt(0,3)!= null ? rs.getValueAt(0,3).toString() :null);
        dtoDetalle.setNumSolicitudRecuperacion(rs.getValueAt(0,4)!= null ? rs.getValueAt(0,4).toString() :null);
        dtoDetalle.setLimiteVenta(rs.getValueAt(0,5)!= null ? rs.getValueAt(0,5).toString() :null);
        dtoDetalle.setControlStock(rs.getValueAt(0,6)!= null ? rs.getValueAt(0,6).toString() :null);
        dtoDetalle.setControlLiquidacion(rs.getValueAt(0,7)!= null ? rs.getValueAt(0,7).toString() :null);
        dtoDetalle.setFormaPago(rs.getValueAt(0,8)!= null ? rs.getValueAt(0,8).toString() :null);
        
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDatosAdicionalesDetalle (DTOOID DTOE): Salida");
        
        return dtoDetalle;
    }
    public DTOSalida obtenerEstadoContacto(DTOBelcorp dto) throws MareException{

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerEstadoContacto(DTOBelcorp dto): Entrada");
        
        /*Documentation
        Obtiene los estados de contacto. 
        */
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
   
        consulta.append(" SELECT A.OID_TIPO_ESTA_CONT AS OID, ");
        consulta.append(" B.VAL_I18N AS DESCRIPCION "); 
            
        consulta.append(" FROM  CAL_TIPO_ESTAD_CONTA A, ");
        consulta.append(" V_GEN_I18N_SICC B "); 
            
        consulta.append(" WHERE B.ATTR_ENTI = 'CAL_TIPO_ESTAD_CONTA' ");
        consulta.append(" AND B.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND B.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        consulta.append(" AND B.VAL_OID = A.OID_TIPO_ESTA_CONT ");
        consulta.append(" ORDER BY DESCRIPCION ");
       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerEstadoContacto: Exception",e);
            this.logSql(" obtenerEstadoContacto. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        DTOSalida salida = new DTOSalida();
        if(rs != null){
            if(!rs.esVacio()){
                //Se retornan las columnas: oid, descripcion
                salida.setResultado(rs);
            }
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerEstadoContacto(DTOBelcorp dto): Salida");
        
        return salida;
    }

    public DTOSalida obtenerAtributoEstado(DTOOID dto) throws MareException{
    
        /*Documentation
        Obtiene los atributos de un estado de contacto determinado. 
        */
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerAtributoEstado(DTOOID dto): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
   
        consulta.append(" SELECT A.OID_ATRI_ESTA_CONT AS OID, ");
        consulta.append(" B.VAL_I18N AS DESCRIPCION "); 

        consulta.append(" FROM CAL_ATRIB_ESTAD_CONTA  A, ");
        consulta.append(" V_GEN_I18N_SICC B ");
        
        consulta.append(" WHERE ");
        consulta.append(" A.TECO_OID_TIPO_ESTA_CONT = ? ");
        parametros.add(dto.getOid());
        consulta.append(" AND B.ATTR_ENTI = 'CAL_ATRIB_ESTAD_CONTA' ");
        consulta.append(" AND B.ATTR_NUM_ATRI= 1 ");
        consulta.append(" AND B.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        consulta.append(" AND B.VAL_OID = A.OID_ATRI_ESTA_CONT "); 
        consulta.append(" ORDER BY DESCRIPCION ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerEstadoContacto: Exception",e);
            this.logSql(" obtenerEstadoContacto. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        DTOSalida salida = new DTOSalida();
        if(rs != null){
            if(!rs.esVacio()){
                //Se retornan las columnas: oid, descripcion
                salida.setResultado(rs);
            }
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerAtributoEstado(DTOOID dto): Salida");
        
        return salida;
    }


    /** 
     * Método para obtener los tipos de llamada
     * @param dto DTOBelcorp con el pais e idioma del usuario
     * @return DTOSalida con los datos encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida obtenerTipoLlamada(DTOBelcorp dto) throws MareException{

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipoLlamada(DTOBelcorp dto): Entrada");
        
        /*Documentation
        Obtiene los tipos de llamada. 
        */
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
   
        consulta.append(" SELECT A.OID_TIPO_LLAM AS OID, ");
        consulta.append(" B.VAL_I18N AS DESCRIPCION "); 
            
        consulta.append(" FROM  CAL_TIPO_LLAMA A, ");
        consulta.append(" V_GEN_I18N_SICC B "); 
            
        consulta.append(" WHERE B.ATTR_ENTI = 'CAL_TIPO_LLAMA' ");
        consulta.append(" AND B.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND B.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        consulta.append(" AND B.VAL_OID = A.OID_TIPO_LLAM ");
        consulta.append(" ORDER BY DESCRIPCION ");
       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
           rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerTipoLlamada: Exception",e);
            this.logSql(" obtenerTipoLlamada. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipoLlamada(DTOBelcorp dto): Salida");
        
        return new DTOSalida(rs);
    }
    
    /**
     * Agregado por incidencia CAL-04
     * Obtiene la cabecera de pedido no facturado del cliente, utilizando el servicio DBService.
     */
    public RecordSet obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE) throws MareException{    
    UtilidadesLog.info("DAORecepcionLlamadas.obtenerCabeceraPedidoNoFacturado (DTOOIDPaginado DTOE): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        consulta.append("SELECT A.OID_SOLI_CABE OID, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N OID FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_ESTAD_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.ESSO_OID_ESTA_SOLI ) AS ESTA_SOLI, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.OID_TIPO_SOLI ) AS TIPO_SOLI, ");
        // Fin subselect
        consulta.append("A.VAL_NUME_SOLI, ");
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'PED_CLASE_SOLIC' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = D.CLSO_OID_CLAS_SOLI ) AS CLAS_SOLI, ");
        // Fin subselect
        // Subselect para obtener la descripcion internacionalizable 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = G.TIPE_OID_TIPO_PERI ) AS TIPO_PERI, ");
        // Fin subselect
        consulta.append("F.VAL_NOMB_PERI, ");
        consulta.append("A.FEC_CRON, ");
        consulta.append("I.VAL_NOMB_CORT_MONE, ");
        //Añadido por incidencia 12970
        // Subselect para obtener la descripcion del tipoDocumentoLegal
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = A.TDOC_OID_TIPO_DOCU ) AS TIPO_DOCU, ");
        // Fin subselect
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_PREC_NETO_TOTA_LOCA, A.VAL_PREC_NETO_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_DESC_1_TOTA_LOCA, A.VAL_IMPO_DESC_1_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_PREC_CONT_TOTA_LOCA, A.VAL_PREC_CONT_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_DESC_TOTA_LOCA, A.VAL_IMPO_DESC_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_FLET_LOCA, A.VAL_IMPO_FLET_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_FLET_TOTA_LOCA, A.VAL_IMPO_FLET_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_IMPO_IMPU_TOTA_LOCA, A.VAL_IMPO_IMPU_TOTA_DOCU), ");
        consulta.append("DECODE (NVL(A.MONE_OID_MONE, 0), 0 ,A.VAL_TOTA_PAGA_LOCA, A.VAL_TOTA_PAGA_DOCU) ");
        consulta.append("FROM PED_SOLIC_CABEC A, ");
        consulta.append("PED_TIPO_SOLIC_PAIS C, ");
        consulta.append("PED_TIPO_SOLIC D, ");
        consulta.append("CRA_PERIO F, ");
        consulta.append("SEG_PERIO_CORPO G, ");
        consulta.append("SEG_MONED I ");
        consulta.append("WHERE A.OID_SOLI_CABE = ? "); //INCIDENCIA 12415
        parametros.add(DTOE.getOid());
        consulta.append("AND C.OID_TIPO_SOLI_PAIS = A.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("AND D.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
        consulta.append("AND F.OID_PERI = A.PERD_OID_PERI ");
        consulta.append("AND G.OID_PERI = F.PERI_OID_PERI ");
        consulta.append("AND I.OID_MONE (+) = A.MONE_OID_MONE ");
        consulta.append("ORDER BY FEC_CRON DESC ");
        consulta.append(") XY ) WHERE linea > " + DTOE.getIndicadorSituacion() + " AND ROWNUM <= " + DTOE.getTamanioPagina() );
        /*Esta búsqueda es paginada, por tanto habrá que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > DTOE.indicadorSituacion 
        2.- ROWNUM <= DTOE.tamanioPagina*/
        this.logSql("obtenerCabeceraPedidos. SQL: ",consulta.toString(), parametros);
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerCabeceraPedidos: Exception",e);
            this.logSql("obtenerCabeceraPedidos. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*if(resultado!=null){
            if (resultado.esVacio()) {
                UtilidadesLog.info("obtenerCabeceraPedidos: no hay datos ");				
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(new Exception(),
                            UtilidadesError.armarCodigoError(codigoError));
            }
        }*/
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerCabeceraPedidoNoFacturado (DTOOIDPaginado DTOE): Salida");
        return resultado;
    }
    
    private void logSql(String metodo, String sql, Vector params)
    {
		UtilidadesLog.info(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.info(metodo + sParams);
		}
    }
    
    /**
     * Agregado por cambio COL-blo-01 (SCS-23/10/2007)
     */
    public String obtenerDescrBloqueo(Long oidClie, Long oidPais, Long oidIdio) throws MareException{    
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDescrBloqueo(Long oidClie, Long oidPais, Long oidIdio): Entrada");
        String descrBloq = null;
        RecordSet resultado = null;
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT i1.VAL_I18N FROM MAE_TIPO_BLOQU MTB, ");
        consulta.append("MAE_CLIEN_BLOQU MCB, MAE_CLIEN mc, V_GEN_I18N_SICC i1 ");
        consulta.append("WHERE MCB.FEC_DESB IS NULL ");
        consulta.append("AND mc.OID_CLIE = MCB.CLIE_OID_CLIE ");
        consulta.append("AND mc.PAIS_OID_PAIS = " + oidPais.longValue());
        consulta.append(" AND MCB.CLIE_OID_CLIE = " + oidClie.longValue());
        consulta.append(" AND MCB.TIBQ_OID_TIPO_BLOQ = MTB.OID_TIPO_BLOQ ");
        consulta.append("AND i1.VAL_OID = MTB.OID_TIPO_BLOQ ");
        consulta.append("AND i1.ATTR_ENTI = 'MAE_TIPO_BLOQU' ");
        consulta.append("AND i1.ATTR_NUM_ATRI = 1 ");
        consulta.append("AND i1.IDIO_OID_IDIO = " + oidIdio.longValue());
        consulta.append("ORDER BY MCB.FEC_BLOQ DESC");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerDescrBloqueo: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  
        if ((resultado!=null) && (resultado.getRowCount()>0)){
            descrBloq = (String)resultado.getValueAt(0,"VAL_I18N");
        }
        
        UtilidadesLog.info("DAORecepcionLlamadas.obtenerDescrBloqueo(Long oidClie, Long oidPais, Long oidIdio): Salida");
        return descrBloq;
    }
    
    /**
     * Agregado por cambio COL-blo-01 (SCS-23/10/2007)
     */
    public boolean verificacionDeBloqueo(Long oidClie, Long oidPais) throws MareException{    
        UtilidadesLog.info("DAORecepcionLlamadas.verificacionDeBloqueo(Long oidClie, Long oidPais): Entrada");
        String descrBloq = null;
        RecordSet resultado = null;
        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * FROM ");
        consulta.append("MAE_CLIEN_BLOQU MCB, MAE_CLIEN mc ");
        consulta.append("WHERE MCB.FEC_DESB IS NULL ");
        consulta.append("AND mc.OID_CLIE = MCB.CLIE_OID_CLIE ");
        consulta.append("AND mc.PAIS_OID_PAIS = " + oidPais.longValue());
        consulta.append(" AND MCB.CLIE_OID_CLIE = " + oidClie.longValue());
        consulta.append("ORDER BY MCB.FEC_BLOQ DESC");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("verificacionDeBloqueo: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  
        if ((resultado!=null) && (resultado.getRowCount()>0)){
            UtilidadesLog.info("DAORecepcionLlamadas.verificacionDeBloqueo(Long oidClie, Long oidPais): Salida");
            return true;
        }else{
            UtilidadesLog.info("DAORecepcionLlamadas.verificacionDeBloqueo(Long oidClie, Long oidPais): Salida");
            return false;
        }
    }    
    
    /**
     * este tamb.!
     */
   public DTOSalida obtenerTiposBloqueo(long idio, String usuario) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTiposBloqueo(DTOOID dtoEnt): Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
            // vbongiov -- 30/05/2008
            buf.append(" SELECT MTB.OID_TIPO_BLOQ, idio.VAL_I18N ");
            buf.append(" FROM mae_tipo_bloqu MTB, V_GEN_I18N_SICC idio, mae_valor_usuar_bloqu vub, ");
            buf.append(" principals p,  MAE_USUAR_BLOQU ub ");
            buf.append(" WHERE MTB.MAAB_OID_VALO_ACCI_BLOQ IN (1001, 1002)  ");
            buf.append(" AND  NVL(MTB.IND_BLOQ_FINA,0) = 0 ");
            buf.append(" AND ub.tibq_oid_tipo_bloq = mtb.oid_tipo_bloq ");
            buf.append(" AND vub.oid_valo_usua_bloq = ub.mvub_oid_valo_usua_bloq ");
            buf.append(" AND (vub.cod_valo_bloq = 'L' OR vub.cod_valo_bloq = 'A') ");
            buf.append(" AND idio.ATTR_ENTI = 'MAE_TIPO_BLOQU' ");
            buf.append(" AND idio.IDIO_OID_IDIO = " + idio);
            buf.append(" AND idio.VAL_OID = MTB.OID_TIPO_BLOQ ");
            buf.append(" AND ub.user_oid_user = p.idprincipal ");
            buf.append(" AND p.NAME = '" + usuario + "' ");
            
            
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTiposBloqueo(DTOOID dtoEnt): Salida");
        return new DTOSalida(respuesta);
   }
   
    /**
     * este tamb.!
     */
   public void guardoBloqueo(DTOBloqueoAdm dtoGuardado, String usua) throws MareException {
       UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.guardoBloqueo(DTOBloqueoAdm dtoGuardado): Entrada");
       StringBuffer query1 = new StringBuffer();
       Long oidBloq = null;
       StringBuffer query = new StringBuffer();                        
       RecordSet rs = null;
       query.append(" SELECT MAE_CLBL_SEQ.NEXTVAL FROM DUAL");                                  
      
       rs = this.executeQuery(query.toString());
       if(rs != null && !rs.esVacio()){
           oidBloq = this.bigDecimalToLong(rs.getValueAt(0,0));
       
           query1.append(" INSERT INTO MAE_CLIEN_BLOQU (OID_BLOQ, ");
           query1.append(" CLIE_OID_CLIE, ");
           query1.append(" TIBQ_OID_TIPO_BLOQ, ");
           query1.append(" MAAB_OID_VALO_ACCI_BLOQ, ");
           query1.append(" FEC_BLOQ, ");
           query1.append(" VAL_MOTI_BLOQ, ");
           query1.append(" OBS_BLOQ, ");
           query1.append(" VAL_USUA_BLOQ");
           query1.append(" ) VALUES ( " + oidBloq + ", " + dtoGuardado.getOidCliente().longValue() + ", " + dtoGuardado.getOidTipoBloqueo().longValue() + ", (SELECT MVAB.OID_VALO_ACCI_BLOQ FROM MAE_VALOR_ACCIO_BLOQU MVAB WHERE MVAB.COD_VALO_BLOQ = 'M')");
           query1.append(", SYSDATE" + ", '" + dtoGuardado.getMotivoBloqueo() + "', '" + dtoGuardado.getObsBloqueo() + "', '");
           query1.append(usua + "')");
           UtilidadesLog.debug("antes de insert....");
           try {
              BelcorpService bs = UtilidadesEJB.getBelcorpService();
              bs.dbService.executeUpdate(query1.toString());     
           } catch (DuplicateKeyException ex) {
              UtilidadesLog.error(ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_CLAVE_DUPLICADA));
           } catch (Exception e){        
              UtilidadesLog.error("insert MAE_CLIEN_BLOQU: Exception", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           } 
           UtilidadesLog.debug("luego de insert....");       
       }
       UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.guardoBloqueo(DTOBloqueoAdm dtoGuardado): Salida");
   }
 
  private Long bigDecimalToLong(Object numero) {
      if (numero != null) {
          return new Long(((BigDecimal) numero).longValue());
      } else {
          return null;
      }
  }
  
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.executeQuery(String query): Salida");  
    return rs;
  }
  
    public RecordSet obtenerTipoComunicacion(DTOCliente DTOE) throws MareException{
           
           UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipoComunicacion(DTOCliente DTOE): Entrada");
           StringBuffer consulta = new StringBuffer();
           Vector parametros = new Vector();
          
              BelcorpService  bs = BelcorpService.getInstance();
              consulta.append(" SELECT mae_clien_comun.OID_CLIE_COMU as OID, ");
              consulta.append("        V_GEN_I18N_SICC.VAL_I18N ");
              consulta.append("        , MAE_CLIEN_COMUN.VAL_TEXT_COMU, decode( MAE_CLIEN_COMUN.IND_COMU_PPAL,1, 'Pincipal', '') INDICADORPRINCIPAL ");
              consulta.append("        FROM MAE_CLIEN_COMUN, MAE_TIPO_COMUN, V_GEN_I18N_SICC ");
              consulta.append("        WHERE ");
              consulta.append("        MAE_CLIEN_COMUN.CLIE_OID_CLIE =  " + DTOE.getOidCliente());
              consulta.append("        AND MAE_CLIEN_COMUN.TICM_OID_TIPO_COMU = MAE_TIPO_COMUN.OID_TIPO_COMU ");
              consulta.append("        AND V_GEN_I18N_SICC.ATTR_ENTI(+) = 'MAE_TIPO_COMUN' ");
              consulta.append("        AND V_GEN_I18N_SICC.ATTR_NUM_ATRI (+)= 1 ");
              consulta.append("        AND V_GEN_I18N_SICC.IDIO_OID_IDIO(+) = 1 ");
              consulta.append("        AND V_GEN_I18N_SICC.VAL_OID = MAE_TIPO_COMUN.OID_TIPO_COMU ");
             
              RecordSet respuesta = null;
              String codigoError = null;
              try{
               respuesta = bs.dbService.executeStaticQuery(consulta.toString());
              } catch (Exception e) {
                 codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                 UtilidadesLog.error("obtenerUltimosPedidos: Exception",e);              
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
              
           }
             UtilidadesLog.info("DAORecepcionLlamadas.obtenerTipoComunicacion(DTOCliente DTOE): Entrada");
             return respuesta;
       }
           
   public DTOCliente obtenerIndicadorActivo(DTOCliente dtoe)throws MareException
   {
        UtilidadesLog.info("DAORecepcionLlamada.obtenerIndicadorActico(DTOCliente dtoe): Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        try{
          bs = BelcorpService.getInstance();
          buf.append(" SELECT decode( MAE_CLIEN_DATOS_ADICI.IND_ACTI,1,'Activo',0,'No Activo')INDICADORACTIVO ");
          buf.append("  from MAE_CLIEN_DATOS_ADICI ");
          buf.append("  where MAE_CLIEN_DATOS_ADICI.CLIE_OID_CLIE =  " + dtoe.getOidCliente());
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(MareMiiServiceNotFoundException e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           } catch(Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
           }
           DTOCliente dtos = new DTOCliente();
           dtos.setIndicadorActico((String) respuesta.getValueAt(0,"INDICADORACTIVO"));
           UtilidadesLog.info("DAORecepcionLlamada.obtenerIndicadorActico(DTOCliente dtoe): Salida");    
           return dtos;
        
    }
    
}