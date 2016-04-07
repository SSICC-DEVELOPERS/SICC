package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.StringTokenizer;


public class DAOUsuarios {
    private String usu = null;

    public DAOUsuarios() {
    }

    public DAOUsuarios(String usuario) {
        usu = usuario;
    }
  
    public RecordSet consultaUsuarios(Long idprincipal, Long oidPais) throws MareException {
        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("DAOUsuarios.consultaUsuarios(Long idprincipal, Long oidPais):Entrada");
        RecordSet rs = null;

        query.append(" SELECT p.IDPRINCIPAL,CONCAT(p.name,CONCAT(' ',CONCAT(pv.STRINGVALUE,CONCAT(' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE)))))))) descripcion");
        query.append(" FROM Principals p ");
        query.append(" LEFT JOIN PROPERTYVALUES pv  ON  pv.IDPROPERTY=2 AND  pv.IDPRINCIPAL=p.IDPRINCIPAL ");
        query.append(" LEFT JOIN PROPERTYVALUES pv2 ON pv2.IDPROPERTY=3 AND pv2.IDPRINCIPAL=p.IDPRINCIPAL ");
        query.append(" LEFT JOIN PROPERTYVALUES pv3 ON pv3.IDPROPERTY=5 AND pv3.IDPRINCIPAL=p.IDPRINCIPAL ");
        query.append(" LEFT JOIN PROPERTYVALUES pv4 ON pv4.IDPROPERTY=6 AND pv4.IDPRINCIPAL=p.IDPRINCIPAL,");

        if (oidPais != null) {
        //query.append(" LEFT JOIN PROPERTYVALUES pv5 ON pv5.IDPRINCIPAL=p.IDPRINCIPAL and pv5.IDPROPERTY=31 AND pv5.STRINGVALUE= '" + oidPais + "' ");
        query.append(" propertyvalues pv5,");        
        }
        
        query.append(" USERS u ");
        query.append(" WHERE u.IDUSER=p.IDPRINCIPAL ");

        if (idprincipal != null) {
            query.append(" AND p.IDPRINCIPAL= " + idprincipal);
        }
        if (oidPais != null) {            
            query.append(" AND pv5.idprincipal = p.idprincipal ");        
            query.append(" AND pv5.idproperty  = 31 ");        
            query.append(" AND pv5.stringvalue = '" + oidPais + "' ");
        }        
        query.append(" ORDER BY descripcion ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("DAOUsuarios.consultaUsuarios(Long idprincipal, Long oidPais):Salida");
        return rs;
    }

    /**@Autor: Hugo A. Mansi
     * @Fecha: 03/11/2004
     * @DMCO: Ver Incidencia 9802
     * @Modifico: --
     * @Modificado: --
     * @Descripción: Llama al metodo DAOUsuarios.consultaCodUsuarios pasandole
     *               el dtoin.gerPais().
     *               Con el RecordSet recibido se crea un DTOSalida que retorna
     *               el metodo.
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public RecordSet consultaCodUsuarios(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOUsuarios.consultaCodUsuarios(Long oidPais):Entrada");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append(" SELECT   p.idprincipal, p.name coduser ");
        query.append(" FROM principals p, ");
        query.append(" propertyvalues pv5, ");
        query.append(" USERS u ");
        query.append(" WHERE u.iduser = p.idprincipal ");
        query.append(" and pv5.idprincipal = p.idprincipal ");
        query.append(" and pv5.idproperty = 31 ");
		
        if (oidPais != null) {
          query.append(" and pv5.STRINGVALUE= '" + oidPais + "' ");
        }
        query.append(" ORDER BY coduser");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("DAOUsuarios.consultaCodUsuarios(Long oidPais):Salida");
        return rs;
    }
    
    public DTOIdentUsuario obtenerUsuario(DTOIdentUsuario dtoe) throws MareException
    {
        UtilidadesLog.info("DAOUsuarios.obtenerUsuario(DTOIdentUsuario dtoe):Entrada");
        DTOIdentUsuario dtoIdentUsuario = new DTOIdentUsuario();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;        
        query.append(" SELECT p.IDPRINCIPAL, ");
        query.append(" p.name, ");
        query.append(" CONCAT('',CONCAT(pv.STRINGVALUE,CONCAT(' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE))))))) NOMBRE ");        
        query.append(" FROM Principals p ");
        query.append(" LEFT JOIN PROPERTYVALUES pv ON pv.IDPROPERTY=2 AND pv.IDPRINCIPAL=p.IDPRINCIPAL ");
        query.append(" LEFT JOIN PROPERTYVALUES pv2 ON pv2.IDPROPERTY=3 AND pv2.IDPRINCIPAL=p.IDPRINCIPAL ");
        query.append(" LEFT JOIN PROPERTYVALUES pv3 ON pv3.IDPROPERTY=5 AND pv3.IDPRINCIPAL=p.IDPRINCIPAL "); 
        query.append(" LEFT JOIN PROPERTYVALUES pv4 ON pv4.IDPROPERTY=6 AND pv4.IDPRINCIPAL=p.IDPRINCIPAL, ");
        query.append(" USERS u ");
        query.append(" WHERE u.IDUSER=p.IDPRINCIPAL ");
        if(dtoe.getCodUsuario() != null && !"".equals(dtoe.getCodUsuario()))
          query.append(" AND p.name= '" + dtoe.getCodUsuario() + "' ");
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        if(!rs.esVacio() && dtoe.getCodUsuario() != null && !"".equals(dtoe.getCodUsuario()))
        {
          dtoIdentUsuario.setIdUsuario(new Long(rs.getValueAt(0,0).toString())); // getValue(0,1)
          UtilidadesLog.debug("rs.getValueAt(0,1).toString() : " + rs.getValueAt(0,1).toString());
          dtoIdentUsuario.setCodUsuario(rs.getValueAt(0,1).toString()); // getValue(0,2)
          UtilidadesLog.debug("rs.getValueAt(0,2).toString() : " + rs.getValueAt(0,2).toString());
          dtoIdentUsuario.setCadenaNombre(rs.getValueAt(0,2).toString()); // getValue(0,3)
        }
        UtilidadesLog.info("DAOUsuarios.obtenerUsuario(DTOIdentUsuario dtoe):Salida");
        return dtoIdentUsuario;      
    }
    
    
    
    /**
     * Metodo para obtener los accesos sin filtro para la pantalla de mantenimiento de usuarios
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con Recorset que contien la informacion
     * @param dtoe con OIDs de canales de los que se desea sus accesos
     * @date 14/05/2007
     */
    public DTOSalida recargaAccesosScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaAccesosScr(DTOString dtoe):Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida salida = null;

        String canales = "";
        String accesos = "";
        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaAccesosScr: Error en formato de peticion");
                return null;
            }
            canales = st.nextToken();
            canales = canales.substring(1,canales.length()-1);
            accesos = st.nextToken();
            accesos = accesos.substring(1,accesos.length()-1);
        }
        
        query.append("SELECT acce.oid_acce, ");
        query.append("       (SELECT i18.val_i18n ");
        query.append("          FROM gen_i18n_sicc i18 ");
        query.append("         WHERE i18.attr_enti = 'SEG_ACCES' ");
        query.append("           AND i18.attr_num_atri = 1 ");
        query.append("           AND i18.idio_oid_idio = " + dtoe.getOidIdioma() + " ");
        query.append("           AND i18.val_oid = acce.oid_acce) des_acce ");
        query.append("  FROM seg_acces acce ");
        query.append(" WHERE 1=1 ");
        if(canales.length()>0){
            query.append(" AND acce.CANA_OID_CANA IN (" + convertirStringTOStringComas(canales) + ") ");
        }
        if(accesos.length()>0){
            query.append(" AND acce.OID_ACCE IN (" + convertirStringTOStringComas(accesos) + ") ");
        }
        
        try {
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            salida = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaAccesosScr(DTOString dtoe):Salida");
        return salida;
    }

    /**
     * Metodo para obtener los subaccesos dado uno o varios accesos, para la pantalla de mantenimiento de usuarios
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con Recorset que contien la informacion
     * @param dtoe con OIDs de los accesos de los que se desea sus subaccesos
     * @date 14/05/2007
     */
    public DTOSalida recargaSubAccesosScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaSubAccesosScr(DTOString dtoe):Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida salida = null;

        String accesos = "";
        String subaccesos = "";

        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaSubAccesosScr: Error en formato de peticion");
                return null;
            }
            accesos = st.nextToken();
            accesos = accesos.substring(1,accesos.length()-1);
            subaccesos = st.nextToken();
            subaccesos = subaccesos.substring(1,subaccesos.length()-1);
        }
        
        query.append("SELECT sbac.oid_sbac, ");
        query.append("       (SELECT i18.val_i18n ");
        query.append("          FROM gen_i18n_sicc i18 ");
        query.append("         WHERE i18.attr_enti = 'SEG_SUBAC' ");
        query.append("           AND i18.attr_num_atri = 1 ");
        query.append("           AND i18.idio_oid_idio = " + dtoe.getOidIdioma() + " ");
        query.append("           AND i18.val_oid = sbac.oid_sbac) des_sbac ");
        query.append("  FROM seg_subac sbac ");
        query.append(" WHERE 1=1 ");
        if(accesos.length()>0){
            query.append(" AND sbac.acce_oid_acce IN (" + convertirStringTOStringComas(accesos) + ") ");
        }
        if(subaccesos.length()>0){
            query.append(" AND sbac.oid_sbac IN (" + convertirStringTOStringComas(subaccesos) + ") ");
        }
        
        try {
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            salida = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaSubAccesosScr(DTOString dtoe):Salida");
        return salida;
    }


    /**
     * Metodo para obtener las Sociedades filtradas por Pais
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las sociedades filtradas por Pais
     * @param dtoe con OIDs de paises que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaSociedadesScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaSociedadesScr(DTOString dtoe):Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida salida = null;

        String paises = "";
        String sociedades = "";

        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaSociedadesScr: Error en formato de peticion");
                return null;
            }
            
            paises = st.nextToken();
            paises = paises.substring(1,paises.length()-1);
            sociedades = st.nextToken();
            sociedades = sociedades.substring(1,sociedades.length()-1);
        }
        
        query.append("SELECT   oid_soci, val_deno ");
        query.append("    FROM seg_socie ");
        query.append(" WHERE 1=1 ");
        if(paises.length()>0){
            query.append("   AND pais_oid_pais IN ("+convertirStringTOStringComas(paises)+") ");
        }
        if(sociedades.length()>0){
            query.append("   AND oid_soci IN ("+convertirStringTOStringComas(sociedades)+") ");
        }
        query.append("ORDER BY val_deno ");

        try {
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            salida = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaSociedadesScr(DTOString dtoe):Salida");
        return salida;
    }

    /**
     * Metodo para obtener las Sub Gerencias de Ventas filtradas por Pais, Marca y Canal.
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las subgerencias filtradas por Pais, Marca y Canal
     * @param dtoe con expresion de filtro para obtener subgerencias
     * @date 14/05/2007
     */
    public DTOSalida recargaSubGerenciasScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaSubGerenciasScr(DTOString dtoe):Entrada");
        UtilidadesLog.debug(dtoe);
        StringBuffer query = new StringBuffer();
        DTOSalida salida = null;
        try{
            String marcas = "";
            String canales = "";
            String paises = "";
            String sgvs = "";

            if(dtoe.getCadena()!=null){
                StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
                if(st.countTokens()!=4){
                    UtilidadesLog.error("DAOUsuarios.recargaSubGerenciasScr: Error en formato de peticion");
                    return null;
                }
                marcas = st.nextToken();
                marcas = marcas.substring(1,marcas.length()-1);
                canales = st.nextToken();
                canales = canales.substring(1,canales.length()-1);
                paises = st.nextToken();
                paises = paises.substring(1,paises.length()-1);
                sgvs = st.nextToken();
                sgvs = sgvs.substring(1,sgvs.length()-1);
            }
            
            
            query.append("SELECT oid_subg_vent, des_subg_vent ");
            query.append("  FROM zon_sub_geren_venta ");
            query.append(" WHERE ind_borr = 0 ");
            query.append("   AND ind_acti = 1 ");
            if(paises.length()>0){
                query.append("   AND pais_oid_pais IN ("+convertirStringTOStringComas(paises)+") ");
            }
            if(marcas.length()>0){
                query.append("   AND marc_oid_marc IN ("+convertirStringTOStringComas(marcas)+") ");
            }
            if(canales.length()>0){
                query.append("   AND cana_oid_cana IN ("+convertirStringTOStringComas(canales)+") ");
            }
            if(sgvs.length()>0){
                query.append("   AND oid_subg_vent IN ("+convertirStringTOStringComas(sgvs)+") ");
            }
        }catch(Exception e){
            UtilidadesLog.debug("ERROR en SGVs:", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_PARAMETROS_INCORRECTOS));
        }
        
        try {
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            salida = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaSubGerenciasScr(DTOString dtoe):Salida");
        return salida;
    }    


    /**
     * Metodo para obtener las Regiones filtradas por SGVs
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Regiones
     * @param dtoe con OIDs de SGV que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaRegionesScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaRegionesScr(recargarRegionesRep) : Entrada");	
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
                
        String sgvs = "";
        String regiones = "";
        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaRegionesScr: Error en formato de peticion");
                return null;
            }
            sgvs = st.nextToken();
            sgvs = sgvs.substring(1,sgvs.length()-1);
            regiones = st.nextToken();
            regiones = regiones.substring(1,regiones.length()-1);
        }

        query.append(" SELECT region.oid_regi, region.des_regi ");
        query.append(" FROM zon_regio region ");
        query.append(" WHERE region.ind_acti = 1 ");
        query.append(" AND region.ind_borr = 0 ");
        if(sgvs.length()>0){
            query.append(" and region.ZSGV_OID_SUBG_VENT in (" +convertirStringTOStringComas(sgvs) +") ");
        }
        if(regiones.length()>0){
            query.append(" and region.oid_regi in (" +convertirStringTOStringComas(regiones) +") ");
        }
               
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
         
        UtilidadesLog.debug("DAOUsuarios.recargaRegionesScr(DTOBelcorp dto):Salida");
        return dtoS;
    }

    /**
     * Metodo para obtener las Zonas filtradas por Regiones
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Zonas
     * @param dtoe con OIDs de regiones que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaZonasScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaZonasScr(DTOString) : Entrada");	
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
        
        String regiones = "";
        String zonas = "";
        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaZonasScr: Error en formato de peticion");
                return null;
            }
            
            regiones = st.nextToken();
            regiones = regiones.substring(1,regiones.length()-1);
            zonas = st.nextToken();
            zonas = zonas.substring(1,zonas.length()-1);
        }
        

        query.append(" SELECT  zona.oid_zona, zona.des_zona ");
        query.append(" FROM zon_zona zona ");
        query.append(" WHERE zona.ind_acti = 1 ");
        query.append(" AND zona.ind_borr = 0 ");
        if(regiones.length()>0){
            query.append(" AND zona.ZORG_OID_REGI in(" + convertirStringTOStringComas(regiones) + ") ");
        }
        if(zonas.length()>0){
            query.append(" AND zona.oid_zona in(" + convertirStringTOStringComas(zonas) + ") ");
        }
        query.append(" ORDER BY zona.des_zona ");
        
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaZonasScr(DTOString dto):Salida");
        return dtoS;
    }

    /**
     * Metodo para obtener las Secciones filtradas por Zonas
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Secciones
     * @param dtoe con OIDs de zonas que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaSeccionesScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug("DAOUsuarios.recargaSeccionesScr(DTOString) : Entrada");	
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
        
        String zonas = "";
        String secciones = "";
        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaSeccionesScr: Error en formato de peticion");
                return null;
            }
            
            zonas = st.nextToken();
            zonas = zonas.substring(1,zonas.length()-1);
            secciones = st.nextToken();
            secciones = secciones.substring(1,secciones.length()-1);
        }
        

        query.append("  SELECT   seccion.oid_secc, seccion.des_secci ");
        query.append("  FROM zon_secci seccion ");
        query.append("  WHERE seccion.ind_acti = 1 ");
        query.append("  AND seccion.ind_borr = 0 ");
        if(zonas.length()>0){
            query.append("  AND seccion.zzon_oid_zona IN (" + convertirStringTOStringComas(zonas) + ") ");
        }
        if(secciones.length()>0){
            query.append("  AND seccion.oid_secc IN (" + convertirStringTOStringComas(secciones) + ") ");
        }
        query.append("  ORDER BY seccion.des_secci ");
        
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaSeccionesScr(DTOString dto):Salida");
        return dtoS;  
    }

    /**
     * Metodo para obtener los Territorios filtrados por Secciones
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de los Territorios
     * @param dtoe con OIDs de secciones que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaTerritoriosPorSeccionesScr(DTOString dtoe) throws MareException {
        UtilidadesLog.debug(" DAOUsuarios.recargaTerritoriosPorSeccionesScr(DTOString) : Entrada");	
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;

        String secciones = "";
        String territorios = "";
        if(dtoe.getCadena()!=null){
            StringTokenizer st = new StringTokenizer(dtoe.getCadena(), "z");
            
            if(st.countTokens()!=2){
                UtilidadesLog.error("DAOUsuarios.recargaTerritoriosPorSeccionesScr: Error en formato de peticion");
                return null;
            }
            
            secciones = st.nextToken();
            secciones = secciones.substring(1,secciones.length()-1);
            territorios = st.nextToken();
            territorios = territorios.substring(1,territorios.length()-1);
        }
        
        
        query.append(" SELECT DISTINCT ta.terr_oid_terr, t.cod_terr ");
        query.append(" FROM zon_terri t, zon_terri_admin ta ");
        query.append(" WHERE t.oid_terr = ta.terr_oid_terr ");
        query.append(" AND t.ind_borr = 0 ");
        query.append(" AND ta.ind_borr = 0 ");
        if(secciones.length()>0){
            query.append(" AND ta.zscc_oid_secc IN ( " + convertirStringTOStringComas(secciones)+ " ) ");
        }
        if(territorios.length()>0){
            query.append(" AND ta.terr_oid_terr IN ( " + convertirStringTOStringComas(territorios)+ " ) ");
        }
        query.append(" ORDER BY t.cod_terr ");
        
        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recargaTerritoriosPorSeccionesScr(DTOString dto):Salida");
        return dtoS;     
    }
    
    /**
     * Metodo para obtener los usuarios de sustitucion
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de los usuarios de sustitucion
     * @param dto con usuario actual
     * @date 17/05/2007
     */
    public DTOSalida recuperaUsuarios(DTOString dtoe) throws MareException {
        UtilidadesLog.debug(" DAOUsuarios.recuperaUsuarios(DTOString) : Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
        
        query.append("SELECT   p.NAME, ");
        query.append("            TRIM (pp1.stringvalue) ");
        query.append("         || ',' ");
        query.append("         || TRIM (pp2.stringvalue) ");
        query.append("         || ' ' ");
        query.append("         || TRIM (pp3.stringvalue) nombre ");
        query.append("    FROM principals p, ");
        query.append("         users u, ");
        query.append("         propertyvalues pp1, ");
        query.append("         propertyvalues pp2, ");
        query.append("         propertyvalues pp3 ");
        query.append("   WHERE u.iduser = p.idprincipal ");
        query.append("     AND pp1.idprincipal = p.idprincipal ");
        query.append("     AND pp1.idproperty = 5 ");
        query.append("     AND pp2.idprincipal = p.idprincipal ");
        query.append("     AND pp2.idproperty = 2 ");
        query.append("     AND pp3.idprincipal = p.idprincipal ");
        query.append("     AND pp3.idproperty = 3 ");
        query.append("     AND p.NAME NOT IN ('admin' ");
        if(dtoe.getCadena()!=null){
            query.append(", '" + dtoe.getCadena()+ "' ");
        }
        query.append(") ");
        query.append("ORDER BY nombre ");

        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.recuperaUsuarios(DTOString dto):Salida");
        return dtoS;     
    }

    /**
       * El método consulta las propiedades del usuario recibido en el argumento
       * de entrada y obtiene las descripciones de los OIDs relacionados
       *
       * @param DTOConsultarUsuario dtoe
       * @return DTOSalida
       * @throws MareException
      */
    public DTOSalida consultarUsuario2(DTOEntradaConsultarUsuario dtoe) throws MareException {
        UtilidadesLog.debug(" DAOUsuarios.consultarUsuario2(DTOEntradaConsultarUsuario): Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
        
        query.append("SELECT pp.idproperty, pp.multivalued, pp.description, pv.stringvalue, ");
        query.append("       CASE ");
        query.append("          WHEN pp.idproperty IN (9) ");
        query.append("             THEN (SELECT i18.val_i18n ");
        query.append("                     FROM v_gen_i18n_sicc i18 ");
        query.append("                    WHERE attr_enti = 'SEG_DEPTO_EMPRE' ");
        query.append("                      AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND i18.attr_num_atri = 1 ");
        query.append("                      AND i18.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (19) ");
        query.append("             THEN (SELECT    TRIM (pp1.stringvalue) ");
        query.append("                          || ',' ");
        query.append("                          || TRIM (pp2.stringvalue) ");
        query.append("                          || ' ' ");
        query.append("                          || TRIM (pp3.stringvalue) nombre ");
        query.append("                     FROM principals p, ");
        query.append("                          users u, ");
        query.append("                          propertyvalues pp1, ");
        query.append("                          propertyvalues pp2, ");
        query.append("                          propertyvalues pp3 ");
        query.append("                    WHERE u.iduser = p.idprincipal ");
        query.append("                      AND pp1.idprincipal = p.idprincipal ");
        query.append("                      AND pp1.idproperty = 5 ");
        query.append("                      AND pp2.idprincipal = p.idprincipal ");
        query.append("                      AND pp2.idproperty = 2 ");
        query.append("                      AND pp3.idprincipal = p.idprincipal ");
        query.append("                      AND pp3.idproperty = 3 ");
        query.append("                      AND p.NAME = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (30, 48) ");
        query.append("             THEN (SELECT soc.val_deno ");
        query.append("                     FROM seg_socie soc ");
        query.append("                    WHERE soc.oid_soci = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (24, 49) ");
        query.append("             THEN (SELECT des_marc AS val_i18n ");
        query.append("                     FROM vca_seg_marca ");
        query.append("                    WHERE cod_usua = '"+usu+"' AND oid_marc = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (25, 50) ");
        query.append("             THEN (SELECT icanal.val_i18n ");
        query.append("                     FROM vca_seg_canal c, v_gen_i18n_sicc icanal ");
        query.append("                    WHERE icanal.attr_enti = 'SEG_CANAL' ");
        query.append("                      AND icanal.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND icanal.val_oid = c.oid_cana ");
        query.append("                      AND icanal.attr_num_atri = 1 ");
        query.append("                      AND c.cod_usua = '"+usu+"' ");
        query.append("                      AND icanal.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (26, 51) ");
        query.append("             THEN (SELECT i18.val_i18n ");
        query.append("                     FROM v_gen_i18n_sicc i18 ");
        query.append("                    WHERE i18.attr_enti = 'SEG_ACCES' ");
        query.append("                      AND i18.attr_num_atri = 1 ");
        query.append("                      AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND i18.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (27, 52) ");
        query.append("             THEN (SELECT i18.val_i18n ");
        query.append("                     FROM v_gen_i18n_sicc i18 ");
        query.append("                    WHERE i18.attr_enti = 'SEG_SUBAC' ");
        query.append("                      AND i18.attr_num_atri = 1 ");
        query.append("                      AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND i18.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (28) ");
        query.append("             THEN (SELECT i18.val_i18n ");
        query.append("                     FROM v_gen_i18n_sicc i18 ");
        query.append("                    WHERE i18.attr_enti = 'SEG_IDIOM' ");
        query.append("                      AND i18.attr_num_atri = 1 ");
        query.append("                      AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND i18.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (31, 36) ");
        query.append("             THEN (SELECT i18.val_i18n ");
        query.append("                     FROM v_gen_i18n_sicc i18 ");
        query.append("                    WHERE i18.attr_enti = 'SEG_PAIS' ");
        query.append("                      AND i18.attr_num_atri = 1 ");
        query.append("                      AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
        query.append("                      AND i18.val_oid = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (42, 43) ");
        query.append("             THEN (SELECT sgv.des_subg_vent ");
        query.append("                     FROM zon_sub_geren_venta sgv ");
        query.append("                    WHERE sgv.oid_subg_vent = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (33, 38) ");
        query.append("             THEN (SELECT reg.des_regi ");
        query.append("                     FROM zon_regio reg ");
        query.append("                    WHERE reg.oid_regi = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (34, 39) ");
        query.append("             THEN (SELECT zon.des_zona ");
        query.append("                     FROM zon_zona zon ");
        query.append("                    WHERE zon.oid_zona = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (35, 40) ");
        query.append("             THEN (SELECT sec.des_secci ");
        query.append("                     FROM zon_secci sec ");
        query.append("                    WHERE sec.oid_secc = pv.stringvalue) ");
        query.append("          WHEN pp.idproperty IN (41, 53) ");
        query.append("             THEN (SELECT TO_CHAR (ter.cod_terr) ");
        query.append("                     FROM zon_terri ter ");
        query.append("                    WHERE ter.oid_terr = pv.stringvalue) ");
        query.append("            WHEN pp.idproperty IN (29) ");
        query.append("               THEN (SELECT i.val_i18n funcionmen ");
        query.append("                       FROM men_funci mf, v_gen_i18n_sicc i ");
        query.append("                      WHERE mf.val_nomb_prog IS NOT NULL ");
        query.append("                        AND i.attr_enti = 'MEN_FUNCI' ");
        query.append("                        AND i.attr_num_atri = 1 ");
        query.append("                        AND i.idio_oid_idio = 1 ");
        query.append("                        AND i.val_oid = mf.oid_func ");
        query.append("                        AND mf.val_nomb_prog = pv.stringvalue) ");
        query.append("          ELSE NULL ");
        query.append("       END descripcion ");
        query.append("  FROM principals pr, properties pp, propertyvalues pv ");
        query.append(" WHERE pr.idprincipal = pv.idprincipal ");
        query.append("   AND pv.idproperty = pp.idproperty ");
        query.append("   AND pr.NAME = '"+dtoe.getIdUsuario()+"' ");        

        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.consultarUsuario2(DTOEntradaConsultarUsuario): Salida");
        return dtoS;     
    }
    
    public DTOSalida consultarPerfilesUsuario(DTOEntradaConsultarUsuario dtoe) throws MareException{
        UtilidadesLog.debug(" DAOUsuarios.consultarPerfilesUsuario(DTOEntradaConsultarUsuario): Entrada");
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = null;
        
        query.append(" SELECT perfiles.NAME  perfil ");
        query.append(" FROM memberof m, principals p, ");
        query.append("     (SELECT p.idprincipal, p.NAME ");
        query.append("        FROM principals p, principals p2, memberof m ");
        query.append("       WHERE p2.NAME = 'PerfilesSICC' ");
        query.append("         AND m.idmember = p2.idprincipal ");
        query.append("         AND m.idrole = p.idprincipal) perfiles ");
        query.append(" WHERE m.idrole = perfiles.idprincipal ");
        query.append(" AND p.idprincipal = m.idmember ");
        query.append(" AND p.NAME = '" + dtoe.getIdUsuario() + "'");

        try{
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            dtoS = new DTOSalida(rs);
        }catch (Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("DAOUsuarios.consultarPerfilesUsuario(DTOEntradaConsultarUsuario): Salida");
        return dtoS;     
    }

    private String convertirStringTOStringComas(String cadena) throws MareException {
        //Recibe un string separado por x y ldevuelve un string separado por comas
        if(cadena.length()==0) return "-1";
        StringTokenizer st = new StringTokenizer(cadena, "x");
        String cadenaSalida = new String();
        while (st.countTokens()> 0) {
            cadenaSalida = cadenaSalida + st.nextToken();
            if(cadenaSalida!=null){
                cadenaSalida = cadenaSalida + ",";
            }
        }
        cadenaSalida = cadenaSalida.substring(0, cadenaSalida.length() -1);
        return cadenaSalida;
    } 

}