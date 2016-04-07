package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.dto.DTOEMatrizAccesos;
import es.indra.sicc.dtos.dto.DTOEMatrizCanal;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTOEMatrizTipoClasificacion;
import es.indra.sicc.dtos.dto.DTOEMatrizTiposCliente;
import es.indra.sicc.dtos.dto.DTOSCargarPaginaCrearMatrizDTO;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.logicanegocio.dto.UtilidadesDTO;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.util.Vector;


//import es.indra.sicc.logicanegocio

//import es.indra.sicc.logicanegocio.mae.ConstantesMAE;


public class DAOMatrizDescuentos  {


    public DAOMatrizDescuentos(){

    }


    public DTOSalida obtenerTiposClienteDTOMatrizSeleccionada (DTOOID dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerTiposClienteDTOMatrizSeleccionada(): Entrada");
       /*
        * Entrada: DTOOID (oid de Cabecera de Matriz de Descuento Seleccionada) 
        Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_VALOR_PARAM_TIPO_CLIEN haciendo join con la tabla 
        MAE_TIPO_CLIEN para obtener el oid y la descripción internacionalizada del tipo de cliente. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
        * */
        
        String sQuery = "SELECT d.TICL_OID_TIPO_CLIE , v.val_i18n " +                         
        "    FROM dto_param_tipo_descu p, dto_valor_param_tipo_clien d, " + 
        "         v_gen_i18n_sicc v " +
        "   WHERE p.mdes_oid_tipo_desc = ?" + 
        "     AND p.padt_oid_para = 9 " +   //oid del parametro de tipo cliente
        "     AND p.oid_para_tipo_desc = d.ptdt_oid_para_tipo_desc " +  //join del parametro asociado a la matriz, con los valores posibles del parametro
        "     AND d.ticl_oid_tipo_clie = v.val_oid " +  // join de valor del parametro con internacionalizacion
        "     AND v.attr_enti = 'MAE_TIPO_CLIEN' " +
        "     AND v.idio_oid_idio = ?" + 
        "     AND v.attr_num_atri = 1";


        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOid()); // Oid de la cabecera de la Matriz
		bindVars.addElement(dto.getOidIdioma()); // Idioma

        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerTiposClienteDTOMatrizSeleccionada(): Salida");
		return output;
    }

                      
    public DTOSalida obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada (DTOEMatrizTiposCliente dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(): Entrada");

    /*
     * Entrada: DTOEMatrizAccesos 
        - oidCabeceraMatrizDTO 
        - DTOOIDs (oids de tipoCliente) 
        Proceso: 
        -> Hacer consulta JDBC contra la tabla DTO_VALOR_PARAM_SUBTI_CLIEN haciendo join con las 
        tablas MAE_SUBTI_CLIEN, MAE_TIPO_CLIEN, DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU, para 
        obtener oid y descripción internacionalizada de los subtipos de cliente de la matriz 
        cuyo oid de cabecera está en el dto de entrada, y filtrando también por los oids 
        contenidos en el DTOOIDs contenido en el dto de entrada. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
     * */

        String sQuery = "SELECT  d.SBTI_OID_SUBT_CLIE, v.VAL_I18N " +
        "    FROM DTO_VALOR_PARAM_SUBTI_CLIEN d,   " +
	    "         DTO_PARAM_TIPO_DESCU p, " + 
	    "         MAE_SUBTI_CLIEN msc, " + 
	    "         V_GEN_I18N_SICC v " +
        "   WHERE p.MDES_OID_TIPO_DESC = ?" + //oid de la matriz cabecera
     	"     AND p.PADT_OID_PARA = 9" +  // este es el numero del parametro segun la tabla
	    "     AND p.OID_PARA_TIPO_DESC = d.PTDT_PARA_TIPO_DESC " +
	    "     AND d.SBTI_OID_SUBT_CLIE = v.VAL_OID" +
	    "     AND v.ATTR_ENTI = 'MAE_SUBTI_CLIEN' " +
	    "     AND v.IDIO_OID_IDIO = ?" + 
        "     AND v.ATTR_NUM_ATRI = 1" + 
        "     AND d.SBTI_OID_SUBT_CLIE = msc.OID_SUBT_CLIE " + 
        "     AND msc.TICL_OID_TIPO_CLIE  IN(" + cantOids(dto.getTiposCliente().getOids()) +")";  // oid tipoCliente que me referencia el DTOOIDs

        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOidCabeceraMatrizDTO()); 
		bindVars.addElement(dto.getOidIdioma());
        for (int i=0;i<dto.getTiposCliente().getOids().length;i++){
           bindVars.addElement(dto.getTiposCliente().getOids()[i]);
        }
//        
        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerSubtiposClienteMultiTipoClienteDTOMatrizSeleccionada(): Salida");
		return output;
    }


    public DTOSalida obtenerSubtiposClienteDTOMatrizSeleccionada (DTOOID dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerSubtiposClienteDTOMatrizSeleccionada(): Entrada");

        /*
         * Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_VALOR_PARAM_SUBTI_CLIEN haciendo join con la tabla 
        MAE_SUBTI_CLIEN para obtener el oid y la descripción
        11internacionalizada del subtipo de cliente. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
         * 
         * */
        String sQuery = "SELECT  d.SBTI_OID_SUBT_CLIE, v.VAL_I18N, mae.TICL_OID_TIPO_CLIE " +
        "      FROM DTO_VALOR_PARAM_SUBTI_CLIEN d,  " +
        "           DTO_PARAM_TIPO_DESCU p, " +
        "           V_GEN_I18N_SICC v,  " + 
        "	        mae_subti_clien mae "+
        "     WHERE p.MDES_OID_TIPO_DESC = ?" + //oid de la matriz cabecera
	    "       AND p.PADT_OID_PARA = 9 " + //este es el numero del parametro segun la tabla
	    "       AND p.OID_PARA_TIPO_DESC = d.PTDT_PARA_TIPO_DESC " + 
        "       AND d.SBTI_OID_SUBT_CLIE = v.VAL_OID  " +
        "       AND d.SBTI_OID_SUBT_CLIE = mae.OID_SUBT_CLIE  "+        
        "       AND v.ATTR_ENTI = 'MAE_SUBTI_CLIEN' " + 
        "       AND v.IDIO_OID_IDIO = ?" + 
        "       AND v.ATTR_NUM_ATRI = 1";

    
        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOid()); 
		bindVars.addElement(dto.getOidIdioma());
        
        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerSubtiposClienteDTOMatrizSeleccionada(): Salida");

		return output;
    }


    public DTOSalida obtenerMatricesDTOActivas (DTOSiccPaginacion dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerMatricesDTOActivas(): Entrada");
        /*
         * Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_MATRI_DESCU, para obtener los campos OID_TIPO_DESC y la 
        descripción internacionalizada, donde IND_MATR_ACTI sea igual a 1 
        (lo cual indica que es activa) 
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 

        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 

        -> Devolver RecordSet obtenido en objeto DTOSalida 
         * */

        String sQuery = "  SELECT dtom.oid_tipo_desc, v.val_i18n  " +
        "   FROM dto_matri_descu dtom, v_gen_i18n_sicc v   " +
        "  WHERE dtom.ind_matr_acti = 1   " +
        "    AND dtom.oid_tipo_desc = v.val_oid  " +
        "    AND v.attr_enti = 'DTO_MATRI_DESCU'    " +
        "    AND v.idio_oid_idio = " + dto.getOidIdioma() +
        "    AND dtom.PAIS_OID_PAIS = " + dto.getOidPais() + 
        "    AND v.attr_num_atri = 1 ";
        
        String sql = UtilidadesPaginacion.armarQueryPaginacion(sQuery,dto);

        RecordSet r = UtilidadesDTO.getQuery(sql);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerMatricesDTOActivas(): Salida");
		return output;
    }   
    
     public DTOSalida obtenerMatricesDTOActivasREP (DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerMatricesDTOActivasREP(): Entrada");

        /*
         * Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_MATRI_DESCU, para obtener los campos OID_TIPO_DESC y la 
        descripción internacionalizada, donde IND_MATR_ACTI sea igual a 1 
        (lo cual indica que es activa) 
        Esta búsqueda es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 

        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 

        -> Devolver RecordSet obtenido en objeto DTOSalida 
         * */

        String sQuery = "  SELECT dtom.oid_tipo_desc, v.val_i18n  " +
        "   FROM dto_matri_descu dtom, v_gen_i18n_sicc v   " +
        "  WHERE dtom.ind_matr_acti = 1   " +
        "    AND dtom.oid_tipo_desc = v.val_oid  " +
        "    AND v.attr_enti = 'DTO_MATRI_DESCU'    " +
        "    AND v.idio_oid_idio = " + dto.getOidIdioma() +
        "    AND dtom.PAIS_OID_PAIS = " + dto.getOidPais() + 
        "    AND v.attr_num_atri = 1 ";
        
        
        RecordSet r = UtilidadesDTO.getQuery(sQuery);        

        DTOSalida output = new DTOSalida();
		    output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerMatricesDTOActivasREP(): Salida");

		    return output;
    }    


//No se usa en la nueva version.
    public DTOSalida obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada (DTOEMatrizSubtiposCliente dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(): Entrada");

        /*
       Entrada: DTOEMatrizSubtiposCliente 
- oidCabeceraMatrizDTO 
-   DTOOIDs (oids de subtiposCliente) 
    Proceso: 
->  Hacer consulta JDBC sobre tabla MAE_TIPO_CLASI_CLIEN, para obtener oid de tipoClasificación,
    oid de subtipoCliente y descripción internacionalizada del tipoClasificacion, filtrando por 
    los oid contenidos en el dto de entrada, y al mismo tiempo que los oid de tipos de clasificación 
    que se obtengan estén en la tabla MAE_CLASI para oids de clasificaciones que estén contenidos en 
    la tabla DTO_VALOR_PARAM_CLASI. 
->  Devolver RecordSet obtenido en un objeto DTOSalida
        */

        String sQuery = "SELECT mtc.OID_TIPO_CLAS,mtc.SBTI_OID_SUBT_CLIE,  v.VAL_I18N " + 
        "      FROM MAE_TIPO_CLASI_CLIEN mtc, " +
        "           MAE_CLASI mc, " + 
        "           V_GEN_I18N_SICC v " + 
        "     WHERE mtc.OID_TIPO_CLAS  IN(" + cantOids(dto.getSubtiposCliente().getOids())+")" +  //esto se compara con los oids contenidos en el DTOOIDs
        "       AND mc.TCCL_OID_TIPO_CLAS = mtc.OID_TIPO_CLAS " +
        "       AND v.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' " + 
        "       AND v.VAL_OID = mtc.OID_TIPO_CLAS " + 
        "       AND v.IDIO_OID_IDIO = ?" + //este es el idioma 
        "       AND v.ATTR_NUM_ATRI = 1 " +
        "       AND mtc.oid_tipo_clas IN (" + 
        "              SELECT pc.cl s_oid_clas" + 
        "                FROM dto_valor_param_clasi pc" + 
        "               WHERE pc.PTDT_PARA_TIPO_DESC =" + 
        "                        (SELECT dtop.oid_para_tipo_desc " + 
        "                           FROM dto_param_tipo_descu dtop " + 
        "                          WHERE dtop.mdes_oid_tipo_desc = " + dto.getOidCabeceraMatrizDTO() +  
        "                            AND dtop.padt_oid_para = 10)) ";

        Vector bindVars = new Vector();
        for (int i=0;i<dto.getSubtiposCliente().getOids().length;i++)  {
            bindVars.addElement(dto.getSubtiposCliente().getOids()[i]);            
        }
        UtilidadesLog.debug("El idioma es " + dto.getOidIdioma());
        bindVars.addElement(dto.getOidIdioma());

        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);        
        
        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(): Salida");
		return output;
    }

    public DTOSalida obtenerMarcasDTOMatrizSeleccionada (DTOOID dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerMarcasDTOMatrizSeleccionada(): Entrada");

        /*
        Documentation
        Entrada: DTOOID (oid de Cabecera de Matriz de Descuento Seleccionada) 
        Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_VALOR_PARAM_MARCA haciendo join con la tabla SEG_MARCA, 
        DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU para obtener el oid y la descripción de marca, 
        filtrando por el oid de cabecera de matriz de descuento del dto de entrada 
        y por el código de parámetro de marca. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
         * */

        String sQuery = "SELECT pm.MARC_OID_MARC, sm.DES_MARC " +
        "      FROM  DTO_VALOR_PARAM_MARCA pm, " + 
        "            SEG_MARCA sm, " +
        "            DTO_PARAM_TIPO_DESCU p " +
        "      WHERE p.MDES_OID_TIPO_DESC = ?" + //el oid de la cabecera de la matriz esta contenido en el DTOOID
        "        AND p.PADT_OID_PARA = 3 " + //codigo del parametro MARCA
        "        AND pm.PTDT_PARA_TIPO_DESC = p.OID_PARA_TIPO_DESC " +
        "        AND pm.MARC_OID_MARC = sm.OID_MARC ";

        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOid()); 
        
        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r);
        UtilidadesLog.info("DAODescuento.obtenerMarcasDTOMatrizSeleccionada(): Salida");
		return output;        
    }


    public DTOSalida obtenerCanalesDTOMatrizSeleccionada (DTOOID dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerCanalesDTOMatrizSeleccionada(): Entrada");

        /*
        Documentation
        Entrada: DTOOID (oid de Cabecera de Matriz de Descuento Seleccionada) 
        Proceso: 
        -> Hacer consulta JDBC sobre tabla DTO_VALOR_PARAM_CANAL haciendo join con la tabla 
        SEG_CANAL, DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU para obtener el oid y la 
        descripción internacionalizada de canal, filtrando por el oid de cabecera de matriz de 
        descuento del dto de entrada y por el código de parámetro de canal. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
         * */

        String sQuery = "SELECT  pc.CANA_OID_CANA, v.VAL_I18N " + 
        "      FROM DTO_VALOR_PARAM_CANAL pc, " + 
        "           DTO_PARAM_TIPO_DESCU p, " + 
        "           V_GEN_I18N_SICC v " +
        "     WHERE p.MDES_OID_TIPO_DESC = ?" + //este es el oid de la matriz que esta contenido en el DTOOID
        "       AND p.PADT_OID_PARA = 4"  +//este el codigo de parametro de CANAL
        "       AND pc.PTDT_PARA_TIPO_DESC = p.OID_PARA_TIPO_DESC " + 
        "       AND v.ATTR_ENTI = 'SEG_CANAL' " + 
        "       AND v.VAL_OID = pc.CANA_OID_CANA " + 
        "       AND v.IDIO_OID_IDIO = ?" + 
        "       AND v.ATTR_NUM_ATRI = 1";

        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOid()); 
        bindVars.addElement(dto.getOidIdioma());
            
        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerCanalesDTOMatrizSeleccionada(): Salida");

		return output;        
    }

    public DTOSalida obtenerAccesosPorCanalDTOMatrizSeleccionada (DTOEMatrizCanal dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerAccesosPorCanalDTOMatrizSeleccionada(): Entrada");
        /*
        Documentation
        Entrada: DTOEMatrizCanal 
        - oidCabeceraMatrizDTO 
        - oidCanal 
        Proceso: 
        -> Hacer consulta JDBC contra la tabla DTO_VALOR_PARAM_ACCES haciendo join con las tablas SEG_ACCES, 
        SEG_CANAL, DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU, para obtener oid y descripción internacionalizada de 
        los accesos de la matriz cuyo oid de cabecera está en el dto de entrada, y filtrando también por el oid de 
        canal del dto de entrada. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
         * */
         
        String sQuery = "SELECT pa.ACCE_OID_ACCE, v.VAL_I18N " +
        "     FROM DTO_VALOR_PARAM_ACCES pa, " +
        "          SEG_ACCES sa, " + 
        "          DTO_PARAM_TIPO_DESCU p, " +
        "          V_GEN_I18N_SICC v " +
        "    WHERE p.MDES_OID_TIPO_DESC = ? " + //este oid esta contenido en el DTOEMatrizCanal
        "      AND p.PADT_OID_PARA = 5" + //este es el codigo de ACCESO CANAL
        "      AND pa.PTDT_PARA_TIPO_DESC = p.OID_PARA_TIPO_DESC " +
        "      AND pa.ACCE_OID_ACCE = sa.OID_ACCE " + 
        "      AND sa.CANA_OID_CANA = ? " +//el oid del canal esta contenido en DTOEMatrizCanal
	    "      AND v.VAL_OID = pa.ACCE_OID_ACCE	" + 
        "      AND v.ATTR_ENTI = 'SEG_ACCES' " + 
        "      AND v.IDIO_OID_IDIO = ? " + 
        "	   AND v.ATTR_NUM_ATRI = 1 ";         

        Vector bindVars = new Vector();
		bindVars.add(dto.getOidCabeceraMatrizDTO()); 
        bindVars.add(dto.getOidCanal());
        bindVars.add(dto.getOidIdioma());

        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerAccesosPorCanalDTOMatrizSeleccionada(): Salida");
		return output;                
    }

    public DTOSalida obtenerSubaccesosMultiaccesoDTOMatrizSeleccionada (DTOEMatrizAccesos dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosMultiaccesoDTOMatrizSeleccionada(): Entrada");

        /*
        Documentation
        Entrada: DTOEMatrizAccesos 
        - oidCabeceraMatrizDTO 
        - DTOOIDs (oid de accesos) 
        Proceso: 
        -> Hacer consulta JDBC contra la tabla DTO_VALOR_PARAM_SUBAC haciendo join con las tablas 
        SEG_SUBAC, SEG_ACCES, DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU, para obtener oid y 
        descripción internacionalizada de los subaccesos de la matriz cuyo oid de cabecera está 
        en el dto de entrada, y filtrando también por los oids contenidos en el DTOOIDs 
        contenido en el dto de entrada. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
         * */

        String sQuery = "SELECT psac.SBAC_OID_SBAC, v.VAL_I18N " + 
        "        FROM DTO_VALOR_PARAM_SUBAC psac," +
        "             SEG_SUBAC sac, " + 
        "             DTO_PARAM_TIPO_DESCU p, " +
        "             V_GEN_I18N_SICC v " +
        "       WHERE p.MDES_OID_TIPO_DESC = ?" +// este oid esta contenido en el DTOEMatriz Accesos   
        "         AND p.PADT_OID_PARA = 6" + //codigo del parametro Subacceso
        "         AND psac.PTDT_PARA_TIPO_DESC = p.OID_PARA_TIPO_DESC " + 
        "         AND sac.OID_SBAC = psac.SBAC_OID_SBAC " +
        "         AND sac.ACCE_OID_ACCE  IN(" + cantOids(dto.getAccesos().getOids()) + ")"+ //estos oid estan contenidos en DTOOIDs
        "         AND v.VAL_OID = psac.SBAC_OID_SBAC " + 
        "         AND v.IDIO_OID_IDIO = ?" + 
        "         AND v.ATTR_ENTI = 'SEG_SUBAC' " + 
        "         AND v.ATTR_NUM_ATRI = 1 ";

        Vector bindVars = new Vector();
		bindVars.addElement(dto.getOidCabeceraMatrizDTO()); 
        for (int i=0;i<dto.getAccesos().getOids().length;i++)  {
            bindVars.addElement(dto.getAccesos().getOids()[i]);
        }
        bindVars.addElement(dto.getOidIdioma());
    
        RecordSet r = UtilidadesDTO.getQuery(sQuery,bindVars);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosMultiaccesoDTOMatrizSeleccionada(): Salida");
		return output;                         
    }


    public DTOSalida obtenerDatosParametros() throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerDatosParametros(): Entrada");

    /*
    Proceso: 
    -> Hacer consulta JDBC sobre tabla DTO_PARAM para obtener todos los campos de la tabla, que son: OID_PARA, COD_PARA, VAL_NOMB y IND_OBLI 
    -> Devolver RecordSet obtenido en objeto DTOSalida
     * */
        
        //<inicio> agregado por Sapaza, para recuperar los parametros de descuento
        String sQuery = "SELECT TO_NUMBER(COD_PARA), OID_PARA, VAL_NOMB, IND_OBLI " + 
        "        FROM DTO_PARAM " +
        "        ORDER BY TO_NUMBER(COD_PARA)";
        //<fin> modificado por Sapaza

        RecordSet r = UtilidadesDTO.getQuery(sQuery);        

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerDatosParametros(): Salida");

		return output;                         
    }

    public DTOSCargarPaginaCrearMatrizDTO cargarPaginaCrearMatrizDescuento(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAODescuento.cargarPaginaCrearMatrizDescuento(): Entrada");

/*Entrada : DTOBelcorp 
    Proceso : 
    -> Construir DTOSCargarPaginaCrearMatrizDTO 
    - marca 
    - canal 
    - acceso 
    - subacceso 
    - tipoCliente 
    - subtipoCliente 
    - tipoClasificacion 
    - clasificacion 
    - parametros 
* */
        DTOSCargarPaginaCrearMatrizDTO dtosCargarPaginaCrearMatrizDTO = new DTOSCargarPaginaCrearMatrizDTO();
        DTOSalida dtoSalida;
        DTOTipoSubtipo dtoTipoSubtipo;

        /*
        -> Obtener marcas mediante el método "MONMantenimientoSEG.recuperarMarcas() : DTOSalida" 
        -> Tomar el RecordSet del DTOSalida obtenido y asignarlo al atributo "marca" del dto creado al principio. 
         * */
        try {

            UtilidadesLog.debug("recupera marcas...");
			MONMantenimientoSEG mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome().create();
			dtoSalida = mmsHome.recuperarMarcas(dto);
            dtosCargarPaginaCrearMatrizDTO.setMarca(dtoSalida.getResultado());

            /*
            -> Obtener canales mediante el método "MONMantenimientoSEG.recuperarCanales(dto : DTOBelcorp) : DTOSalida" 
            -> Tomar el RecordSet del DTOSalida obtenido y asignarlo al atributo "canal" del dto creado al principio. 
             * */        
            UtilidadesLog.debug("recupera canales...");             
			dtoSalida = mmsHome.recuperarCanales(dto);
            dtosCargarPaginaCrearMatrizDTO.setCanal(dtoSalida.getResultado());
        
            /*
            -> Obtener accesos mediante el método "MONMantenimientoSEG.recuperarAccesos(dto : DTOBelcorp) : DTOSalida" 
            -> Tomar el RecordSet del DTOSalida obtenido y asignarlo al atributo "acceso" del dto creado al principio. 
             * */        
            UtilidadesLog.debug("recupera accesos...");             
			dtoSalida = mmsHome.recuperarAccesos(dto);
            dtosCargarPaginaCrearMatrizDTO.setAcceso(dtoSalida.getResultado());

            /*
            -> Obtener subaccesos mediante el método "MONMantenimientoSEG.recuperarSubaccesos(dto : DTOBelcorp) : DTOSalida" 
            -> Tomar el RecordSet del DTOSalida obtenido y asignarlo al atributo "subacceso" del dto creado al principio. 
            ***/        
            UtilidadesLog.debug("recupera subaccesos...");            
			dtoSalida = mmsHome.recuperarSubaccesos(dto);
            dtosCargarPaginaCrearMatrizDTO.setSubacceso(dtoSalida.getResultado());

            /*
            -> Obtener tipos de cliente y subtipos de cliente mediante el método 
            "MONConfiguracionClientes.obtenerTipoSubtipo(dto : DTOBelcorp) : DTOTipoSubtipo" del dto 
            creado al principio 
            -> Tomar el RecordSet del atributo "DTOTipoSubtipo.tipos" y asignarlo al atributo 
            "tipoCliente" del dto creado al principio 
            -> Tomar el RecordSet del atributo "DTOTipoSubtipo.subtipos y asignarlo al atributo "subtipoCliente" del 
            dto creado al principio 
            */        
            UtilidadesLog.debug("recupera tipo subtipo...");            
			MONConfiguracionClientes mccHome = MAEEjbLocators.getMONConfiguracionClientesHome().create();
			dtoTipoSubtipo = mccHome.obtenerTipoSubtipo(dto);
            dtosCargarPaginaCrearMatrizDTO.setSubtipoCliente(dtoTipoSubtipo.getSubtipos());
            dtosCargarPaginaCrearMatrizDTO.setTipoCliente(dtoTipoSubtipo.getTipos());
        
            /*
            -> Obtener tipos de cliente y subtipos de cliente mediante el método "MONConfiguracionClientes.obtenerClasificaciones(dto : DTOBelcorp) : DTOClasificaciones" del dto creado al principio 
            -> Tomar el RecordSet del atributo "DTOClasificaciones.tiposClasificacion" y asignarlo al atributo "tipoClasificacion" del dto creado al principio 
            -> Tomar el RecordSet del atributo "DTOClasificaciones.clasificaciones" y asignarlo al atributo "clasificacion" del dto creado al principio 
             * */

            DTOClasificaciones dtoClasificacion = new DTOClasificaciones();
            dtoClasificacion = mccHome.obtenerClasificaciones(dto);
            
            dtosCargarPaginaCrearMatrizDTO.setTipoClasificacion(dtoClasificacion.getTipoClasificacion());
            dtosCargarPaginaCrearMatrizDTO.setSubtipoClasificacion(dtoClasificacion.getClasificacion());

            
		} catch (Exception e) {
			throw new MareException(e,
				UtilidadesError.armarCodigoError( CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

        /*
        -> Llamar al método de esta clase "obtenerDatosParametros() : DTOSalida" 
        -> Tomar el RecordSet obtenido en actividad anterior y asignarlos al atributo "parametros" del dto creado al principio 
        */
        dtoSalida = this.obtenerDatosParametros();
        dtosCargarPaginaCrearMatrizDTO.setParametros(dtoSalida.getResultado());

        /*
        -> Devolver "DTOSCargarPaginaCrearMatrizDTO" creado y rellenado.
        */
        UtilidadesLog.info("DAODescuento.cargarPaginaCrearMatrizDescuento(): Salida");

        return dtosCargarPaginaCrearMatrizDTO;
    }


    public DTOSalida obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(DTOEMatrizTipoClasificacion dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(): Entrada");
        /*
        Entrada: DTOOIDs (Contiene por este orden un oid de cabecera de matriz, y un oid de tipo de clasificación) 
        Proceso: 
        -> Hacer consulta JDBC sobre tabla MAE_CLASI, para obtener oid de clasificación, 
        oid de tipo de clasificación y descripción internacionalizada de la clasificación, 
        filtrando por el oid de cabecera de matriz de descuento y por el oid de tipo de 
        clasificación contenidos en el dto de entrada, y al mismo tiempo que los oid de 
        clasificación que se obtengan estén en la tabla MAE_CLASI para oids de clasificaciones que 
        estén contenidos en la tabla DTO_VALOR_PARAM_CLASI. 
        -> Devolver RecordSet obtenido en un objeto DTOSalida
         * */

/*        String sQuery = "  SELECT mac.OID_CLAS, mac.TCCL_OID_TIPO_CLAS, v.VAL_I18N  " + 
        "     FROM mae_clasi mac, v_gen_i18n_sicc v   " +
        "    WHERE mac.OID_CLAS = v.VAL_OID           " + 
        "      AND v.ATTR_ENTI = 'MAE_CLASI'          " + 
        "      AND v.ATTR_NUM_ATRI = 1                " +         
        "      AND v.IDIO_OID_IDIO = "  + dto.getOidIdioma() + 
        "      AND mac.TCCL_OID_TIPO_CLAS = 2  " + dto.getOids()[1] + 
        "      AND mac.OID_CLAS IN  " + 
        "        ( SELECT  dtoc.CLAS_OID_CLAS  " + 
        "            FROM  DTO_VALOR_PARAM_CLASI dtoc   " +         
        "           WHERE dtoc.PTDT_PARA_TIPO_DESC =   " + 
        "                (SELECT dtop.OID_PARA_TIPO_DESC    " +
        "                   FROM DTO_PARAM_TIPO_DESCU dtop  " + 
        "                  WHERE dtop.MDES_OID_TIPO_DESC =  " + dto.getOids()[0] + 
        "                    AND dtop.PADT_OID_PARA = 10 )" +         
        "        ) " ;*/

    String sQuery = "  SELECT mac.OID_CLAS, mac.TCCL_OID_TIPO_CLAS, v.VAL_I18N  " + 
        "     FROM mae_clasi mac, v_gen_i18n_sicc v   " +
        "    WHERE mac.OID_CLAS = v.VAL_OID           " + 
        "      AND v.ATTR_ENTI = 'MAE_CLASI'          " + 
        "      AND v.ATTR_NUM_ATRI = 1                " +         
        "      AND v.IDIO_OID_IDIO = "  + dto.getOidIdioma() + 
        "      AND mac.TCCL_OID_TIPO_CLAS = " + dto.getOidTipoClasificacion() + 
        "      AND mac.OID_CLAS IN  " + 
        "        ( SELECT  dtoc.CLAS_OID_CLAS  " + 
        "            FROM  DTO_VALOR_PARAM_CLASI dtoc   " +         
        "           WHERE dtoc.PTDT_PARA_TIPO_DESC =   " + 
        "                (SELECT dtop.OID_PARA_TIPO_DESC    " +
        "                   FROM DTO_PARAM_TIPO_DESCU dtop  " + 
        "                  WHERE dtop.MDES_OID_TIPO_DESC =  " + dto.getOidCabeceraMatrizDTO() + 
        "                    AND dtop.PADT_OID_PARA = 10 )" +         
        "        ) " ;

        RecordSet r = UtilidadesDTO.getQuery(sQuery);

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerClasificacionesPorTipoClasificacionDTOMatrizSeleccionada(): Salida");

		return output;                         

    }

    public DTOSalida obtenerSubaccesosDTOMatrizSeleccionada(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosDTOMatrizSeleccionada(): Entrada");

        /*              
        Entrada: DTOOID (oid de cabecera de matriz seleccionada) 
        Proceso: 
        -> Hacer consulta JDBC contra la tabla DTO_VALOR_PARAM_SUBAC haciendo join con las 
        tablas SEG_SUBAC, DTO_PARAM_TIPO_DESCU y DTO_TIPO_DESCU, para 
        obtener el oid de subacceso, el oid de acceso y la 
        descripción internacionalizada de los subaccesos de la matriz cuyo 
        oid de cabecera es el del dto de entrada. 
        -> Devolver RecordSet obtenido en objeto DTOSalida.
        */

        String sQuery = " " +
        "  SELECT dtosa.SBAC_OID_SBAC, segsa.ACCE_OID_ACCE, v.VAL_I18N   " +
        "    FROM DTO_VALOR_PARAM_SUBAC dtosa, SEG_SUBAC segsa,   " +
        "     DTO_PARAM_TIPO_DESCU dtop, v_gen_i18n_sicc v        " +
        "   WHERE dtop.MDES_OID_TIPO_DESC = " + dto.getOid() + 
        "     AND dtop.PADT_OID_PARA = 6    " +
        "	  AND dtop.OID_PARA_TIPO_DESC = dtosa.PTDT_PARA_TIPO_DESC  " +
        "  	  AND dtosa.SBAC_OID_SBAC = segsa.OID_SBAC     " +
        "  	  AND dtosa.SBAC_OID_SBAC = v.VAL_OID     " +
        " 	  AND v.IDIO_OID_IDIO = " + dto.getOidIdioma() + 
        "	  AND v.ATTR_NUM_ATRI = 1  " +
        "     AND v.ATTR_ENTI = 'SEG_SUBAC'  ";
        
        RecordSet r = UtilidadesDTO.getQuery(sQuery);

        DTOSalida output = new DTOSalida();
		output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerSubaccesosDTOMatrizSeleccionada(): Salida");

		return output;                         

    }

    private String cantOids(Long[] vOIDs) {
        UtilidadesLog.info("DAODescuento.cantOids(): Entrada");

        String parametros = new String();
        int i = 0;

        parametros = "?";
        i++;
        while (i< vOIDs.length){
            parametros +=",?";
            i++;
        }
        UtilidadesLog.info("DAODescuento.cantOids(): Salida");

       return parametros;
    }
    
    /*
     * mdolce
     * 23/02/2005
     * Metodo para devolver los numeros de descuento del pais
     * param dtoBelcorp
     * return dtoSalida
     * */
    
    public DTOSalida obtenerNumerosDescuentos(DTOOID dto) throws MareException{
        UtilidadesLog.info("DAODescuento.obtenerNumerosDescuentos(): Entrada");

    /*
    Proceso: 
    -> Hacer consulta JDBC sobre tabla DTO_PARAM para obtener todos los campos de la tabla, que son: OID_PARA, COD_PARA, VAL_NOMB y IND_OBLI 
    -> Devolver RecordSet obtenido en objeto DTOSalida
     * */

        String sQuery = "select des.PAIS_OID_PAIS, des.MDES_OID_TIPO_DESC,des.oid_desc, des.num_desc  " + 
        "       from   dto_descu des " +
        "       order by 4 ";

        RecordSet r = UtilidadesDTO.getQuery(sQuery);        

        DTOSalida output = new DTOSalida();
        output.setResultado(r) ;
        UtilidadesLog.info("DAODescuento.obtenerNumerosDescuentos(): Salida");
        return output;                         
    }
    
}