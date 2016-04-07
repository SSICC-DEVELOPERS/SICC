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

package es.indra.sicc.logicanegocio.edu;

import java.util.Vector;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.edu.DTORelacionesCurso;

import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;

import es.indra.sicc.cmn.negocio.ConstantesCMN;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.edu.DTOBusquedaFichaTecnica;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.text.SimpleDateFormat;



public class DAOCursos 
{
  public DAOCursos()
  {
  }
  
  public DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws MareException {
        //incidencia 12320,incidencia 12556
        //Consulta los cursos que se encuentran en histórico para un cliente determinado
    	UtilidadesLog.info(" DAOCursos.consultarCursosReuniones(DTOBuscarCursosReuniones) : Entrada");	
    
        Vector parametros = new Vector();
		StringBuffer sql=new StringBuffer();
        
        sql.append(" SELECT * FROM ( ");
        sql.append(" SELECT ");
        sql.append(" ROWNUM as linea, ");           
        sql.append(" oidCurso OID, ");
        sql.append(" marca, ");
        sql.append(" codCurso, ");
        sql.append(" descCurso, ");
        sql.append(" tipoCurso, ");
        sql.append(" fechaConcretaCurso, ");
        sql.append(" apta, ");
        sql.append(" invitada, ");
        sql.append(" fechaAsistencia, ");
        sql.append(" objetivoCurso ");

        sql.append(" FROM ( ");
        sql.append(" (SELECT ");
        sql.append(" A.mcur_oid_curs as oidCurso, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",b.marc_oid_marc,'SEG_MARCA') AS marca, ");
        sql.append(" B.cod_curs as codCurso, ");
        sql.append(" B.des_curs as descCurso, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",b.ticu_oid_tipo_curs,'EDU_TIPO_CURSO') AS tipocurso, ");
        sql.append(" B.fec_conc_curs as fechaConcretaCurso, ");
        sql.append(" A.ind_apta as apta, ");
        sql.append(" A.ind_invit as invitada, ");
        sql.append(" A.fec_asis as fechaAsistencia, ");
        sql.append(" B.val_obje_curs as objetivoCurso ");

        sql.append(" FROM ");
        sql.append(" edu_histo_curso A, ");
        sql.append(" edu_matri_curso B");

        sql.append(" WHERE ");
        sql.append(" A.clie_oid_clie = ? AND ");
        parametros.add(dto.getOidCliente());
        sql.append(" B.oid_curs = A.mcur_oid_curs) ");
        sql.append(" UNION ");

        sql.append(" (SELECT ");
        sql.append(" A.mcur_oid_curs as oidCurso, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",b.marc_oid_marc,'SEG_MARCA') AS marca, ");
        sql.append(" B.cod_curs as codCurso, ");
        sql.append(" B.des_curs as descCurso, ");
        sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",b.ticu_oid_tipo_curs,'EDU_TIPO_CURSO') AS tipocurso, ");
        sql.append(" B.fec_conc_curs as fechaConcretaCurso, ");
        sql.append(" A.ind_apta_curs as apta, ");
        sql.append(" A.ind_invi as invitada, ");
        sql.append(" A.fec_asis as fechaAsistencia, ");
        sql.append(" B.val_obje_curs as objetivoCurso ");

        sql.append(" FROM ");
        sql.append(" edu_aptas_curso A, ");
        sql.append(" edu_matri_curso B ");
        sql.append(" WHERE ");
        sql.append(" A.clie_oid_clie = ? AND ");
        parametros.add(dto.getOidCliente());
        sql.append(" A.ind_asis = ? AND ");
        parametros.add(ConstantesCMN.VAL_TRUE);
        sql.append(" B.oid_curs = A.mcur_oid_curs) ");
        sql.append(" ) ");

        sql.append(" ORDER BY fechaConcretaCurso DESC ");
        sql.append(" ) ");
        sql.append(" WHERE ");
        sql.append(" linea > ? AND ");
        parametros.add(dto.getIndicadorSituacion());
        sql.append(" ROWNUM <= ? ");
        parametros.add(dto.getTamanioPagina());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try {
          rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
        } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("consultarCursosReuniones: Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
        // Se crea un DTOSalida a partir del RecordSet
        DTOSalida dtoSalida = new DTOSalida(rs);
                
    	  UtilidadesLog.info(" DAOCursos.consultarCursosReuniones(DTOBuscarCursosReuniones) : Salida");	
        return dtoSalida;
  }
  
  public DTOSalida obtenerCursos(DTORelacionesCurso dto) throws MareException{
     UtilidadesLog.info(" DAOCursos.obtenerCursos(DTORelacionesCurso) : Entrada");	
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
            bs = BelcorpService.getInstance();
	
            query.append(" select emc.OID_CURS, emc.COD_CURS ");
            query.append(" from   edu_matri_curso emc ");
            query.append(" where  emc.PAIS_OID_PAIS =  " + dto.getOidPais());
            
            if((dto.getOidMarca() != null ) &&(!dto.getOidMarca().equals(""))){
               query.append(" and    emc.MARC_OID_MARC =  " + dto.getOidMarca());
            }
            
            if((dto.getOidCanal() != null) && (!dto.getOidCanal().equals(""))){
               query.append(" and    emc.CANA_OID_CANA  =  " + dto.getOidCanal());
            }
            
            if((dto.getOidTipoCurso() != null) &&(!dto.getOidTipoCurso().equals(""))){
               query.append(" and    emc.TICU_OID_TIPO_CURS  =  " + dto.getOidTipoCurso());
            }
            
            if((dto.getOidPlantilla() != null) && (!dto.getOidPlantilla().equals(""))){
               query.append(" and    emc.CPLC_OID_CABE_PLAN_CURS   =  " + dto.getOidPlantilla());
            }
             
            query.append("  order by 2 ");
               
		        resultado = bs.dbService.executeStaticQuery(query.toString());
      
		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
     UtilidadesLog.info(" DAOCursos.obtenerCursos(DTORelacionesCurso) : Salida");	
     return dtoS;
   }

  
  public DTOSalida obtenerTipoCurso(DTOBelcorp dto) throws MareException{
     UtilidadesLog.info(" DAOCursos.obtenerTipoCurso(DTOBelcorp) : Entrada");	
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
            bs = BelcorpService.getInstance();
	
            query.append(" select etc.OID_TIPO_CURS, etc.cod_tipo_curs ");
            query.append(" from   edu_tipo_curso etc");
            query.append(" order by 2 ");
     

	   resultado = bs.dbService.executeStaticQuery(query.toString());
      
		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
     UtilidadesLog.info(" DAOCursos.obtenerTipoCurso(DTOBelcorp) : Salida");	
     return dtoS;
   }
   
    public DTOSalida obtenerOidPlantilla(DTOBelcorp dto) throws MareException{
     UtilidadesLog.info(" DAOCursos.obtenerOidPlantilla(DTOBelcorp) : Entrada");	
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
            bs = BelcorpService.getInstance();
	
            query.append(" select epcc.OID_CABE, epcc.OID_CABE ");
            query.append(" from   edu_plant_curso_cabec epcc ");
            query.append(" order by 1 ");

	          resultado = bs.dbService.executeStaticQuery(query.toString());
      
		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }  
     UtilidadesLog.info(" DAOCursos.obtenerOidPlantilla(DTOBelcorp) : Salida");	

     return dtoS;
   }
   
   public DTOSalida buscarFichaTecnica(DTOBusquedaFichaTecnica dto) throws MareException{
     UtilidadesLog.info(" DAOCursos.buscarFichaTecnica(DTOBusquedaFichaTecnica) : Entrada");	
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();
     SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");

     try {
           bs = BelcorpService.getInstance();
	
           query.append(" SELECT DISTINCT emc.oid_curs as OID, gen.VAL_I18N, emc.cplc_oid_cabe_plan_curs, etc.cod_tipo_curs, ");
           query.append(" emc.cod_curs, emc.des_curs, emc.fec_disp_curs, emc.fec_lanz, ");
           query.append(" emc.fec_fin_curs ");
           query.append(" FROM edu_matri_curso emc, edu_tipo_curso etc, gen_i18n_sicc gen ");
           query.append(" WHERE emc.ticu_oid_tipo_curs = etc.oid_tipo_curs ");
           query.append(" and emc.PAIS_OID_PAIS = gen.VAL_OID ");
			     query.append(" and gen.ATTR_NUM_ATRI = 1");
			     query.append(" and gen.ATTR_ENTI = 'SEG_PAIS' ");
           
           if((dto.getOidPais() != null) && (!dto.getOidPais().equals(""))){
              query.append(" AND emc.pais_oid_pais = " + dto.getOidPais());
           }
           
           if((dto.getOidTipoCurso() != null) && (!dto.getOidTipoCurso().equals(""))){
              query.append(" AND emc.ticu_oid_tipo_curs = " + dto.getOidTipoCurso());
           }
           
           if((dto.getCodigoCurso() != null) && (!dto.getCodigoCurso().equals(""))){
              query.append(" and emc.cod_curs = '" + dto.getCodigoCurso() + "'");
           }
           
           String sFDisp="";
           if((dto.getFechaDisponible() != null) && (!dto.getFechaDisponible().equals(""))){
              sFDisp = simpledateformat.format(dto.getFechaDisponible());
              query.append(" and emc.fec_disp_curs = to_date('" + sFDisp + "', 'DD-MM-YYYY') ");
           }
           
           String sFLanz = "";
           if((dto.getFechaLanzamiento() != null) && (!dto.getFechaLanzamiento().equals(""))){
              sFLanz = simpledateformat.format(dto.getFechaLanzamiento());
              query.append(" and emc.FEC_LANZ = to_date('" + sFLanz + "', 'DD-MM-YYYY') ");
           }
           
           String sFFin = "";        
           if((dto.getFechaFinCurso() != null) && (!dto.getFechaFinCurso().equals(""))){
              sFFin = simpledateformat.format(dto.getFechaFinCurso());
              query.append(" and emc.FEC_FIN_CURS = to_date('" + sFFin + "', 'DD-MM-YYYY') ");
           }
           
           
           String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
	         resultado = bs.dbService.executeStaticQuery(sqlPaginacion);
      
		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
     UtilidadesLog.info(" DAOCursos.buscarFichaTecnica(DTOBusquedaFichaTecnica) : Salida");	
     return dtoS;
   
  }
   
  
  
}