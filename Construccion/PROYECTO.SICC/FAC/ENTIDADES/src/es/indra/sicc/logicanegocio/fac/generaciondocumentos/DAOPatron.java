package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.Vector;
import java.util.ArrayList;
import java.math.BigDecimal;
//import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOPatron;
//import  es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOSeccion;
//import  es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOMensaje;

import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.util.DTOOID;



public class DAOPatron  {
    private UtilidadesLog log = new UtilidadesLog();
    
	public DAOPatron() {
	}

  // Modificado por BELC300012722, BELC300012930 
	 public DTOPatron recuperarEstructuraPatron (DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOPatron.recuperarEstructuraPatron (DTOOID dtoe): Entrada"); 

        // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
        StringBuffer consulta = new StringBuffer();
        boolean indCorporativo = false;

        consulta.append(" SELECT pp.val_para ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + dtoe.getOidPais());
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = 'MSG'");
        consulta.append("    AND pp.nom_para = 'indBNCorpo' ");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null) {                 
            if("1".equals(rs.getValueAt(0,0).toString()))
                indCorporativo = true;
        }

        consulta=new StringBuffer("");
        Vector parametros=new Vector();

        // sapaza -- PER-SiCC-2013-0600 -- 29/05/2013
        consulta.append("SELECT A.OID_PATR, SUBSTR(A.COD_PATR,1,4) COD_PATR, A.DES_PATR, A.FORS_OID_FORM, B.COD_FORM, ");
        consulta.append("A.MEEP_OID_MEDI_ENVI_PAIS, D.DES_MEDI_ENVI, A.IND_ACTI, A.IND_PATR_PERI, ");
        consulta.append("DECODE (A.IND_PATR_PERI, 1, (SELECT E.PATR_OID_PATR_ORIG FROM MSG_PATRO_PERIO E "); 
        consulta.append("WHERE E.PATR_OID_PATR = A.OID_PATR), NULL) PATR_OID_PATR_ORIG, ");
        consulta.append("DECODE (A.IND_PATR_PERI, 1, (SELECT E.PERI_OID_PERI FROM MSG_PATRO_PERIO E ");
        consulta.append("WHERE E.PATR_OID_PATR = A.OID_PATR), NULL) PERI_OID_PERI, ");
        consulta.append("DECODE (A.IND_PATR_PERI, 1, (SELECT E.OID_PATR_PERI FROM MSG_PATRO_PERIO E ");
        consulta.append("WHERE E.PATR_OID_PATR = A.OID_PATR), NULL) OID_PATR_PERI, ");
        consulta.append("A.PAIS_OID_PAIS, F.PATR_OID_PATR, F.OID_PATR_SECC, F.COD_SECC, F.NUM_ORDE_SECC, ");
        consulta.append("F.METC_OID_META, G.VAL_LITE_IDEN, H.VAL_I18N, I.MENS_OID_MENS, I.NUM_ORDE_IMPR, ");
        consulta.append("J.VAL_TEXT ");
        
        if(indCorporativo) {
            consulta.append(", (select IDE_SECC from MSG_SECCI_DOCUM x where x.COD_SECC_DOCU  = F.MSEC_COD_SECC_DOCU ");
            consulta.append("      AND X.IND_ACTI= 1 AND X.EST_REGI='1' ) IDE_SECC ");
            consulta.append(", (select NIV_SECC from MSG_SECCI_DOCUM x where x.COD_SECC_DOCU  = F.MSEC_COD_SECC_DOCU ");
            consulta.append("      AND X.IND_ACTI= 1 AND X.EST_REGI='1' ) NIV_SECC ");
            consulta.append(", (select IND_GRUP_SECC from MSG_SECCI_DOCUM x where x.COD_SECC_DOCU  = F.MSEC_COD_SECC_DOCU ");
            consulta.append("      AND X.IND_ACTI= 1 AND X.EST_REGI='1' ) IND_GRUP_SECC ");
        } else {
            consulta.append(", NULL IDE_SECC ");
            consulta.append(", NULL NIV_SECC ");
            consulta.append(", NULL IND_GRUP_SECC ");
        }
        
        consulta.append("FROM MSG_PATRO A, FAC_FORMU B, MSG_MEDIO_ENVIO_PAIS C, MSG_MEDIO_ENVIO D, ");
        consulta.append("MSG_PATRO_SECCI F, MSG_METAC G, V_GEN_I18N_SICC H, MSG_PATRO_MENSA I, MSG_MENSA J ");
        
        consulta.append("WHERE ");
        consulta.append("A.OID_PATR = ? ");
        parametros.add(dtoe.getOid());
        consulta.append("AND A.IND_ACTI = 1 ");
        consulta.append("AND B.OID_FORM = A.FORS_OID_FORM ");
        consulta.append("AND C.OID_MEDI_ENVI_PAIS = A.MEEP_OID_MEDI_ENVI_PAIS ");
        consulta.append("AND D.OID_MEDI_ENVI = C.MEEN_OID_MEDI_ENVI ");
        consulta.append("AND F.PATR_OID_PATR = A.OID_PATR ");
        consulta.append("AND F.METC_OID_META = G.OID_META (+) ");
        consulta.append("AND G.OID_META = H.VAL_OID (+) ");
        consulta.append("AND H.ATTR_ENTI (+) = 'MSG_METAC' ");
        consulta.append("AND H.IDIO_OID_IDIO (+) = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append("AND I.PASE_OID_PATR_SECC = F.OID_PATR_SECC ");
        consulta.append("AND J.OID_MENS = I.MENS_OID_MENS ");

        consulta.append("ORDER BY F.NUM_ORDE_SECC, I.NUM_ORDE_IMPR ");
    
        //BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        try {
          resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            e.printStackTrace();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    	}

        // Si no encuentro registros, algo ha ido mal. Lanzamos excepción
        /*if(resultado.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("DAOpatron.recuperarEstructuraPatron oid="+dtoe.getOid(), 
                                    UtilidadesError.armarCodigoError(codigoError));
        }*/
        //  Incidencia Sicc20080546
        DTOPatron dtoP = new DTOPatron();
        if(!resultado.esVacio()) {
            // Datos del patrón
            if(resultado.getValueAt(0,"OID_PATR")!=null){ 
                dtoP.setOidPatron(new Long(((BigDecimal)resultado.getValueAt(0,"OID_PATR")).longValue()));
            } 
            if(resultado.getValueAt(0,"COD_PATR")!=null){ 
                dtoP.setCodigo((String)resultado.getValueAt(0,"COD_PATR")); 
            } 
            if(resultado.getValueAt(0,"DES_PATR")!=null){ 
                dtoP.setDescripcion((String)resultado.getValueAt(0,"DES_PATR")); 
            } 
            if(resultado.getValueAt(0,"FORS_OID_FORM")!=null){ 
                dtoP.setOidFormulario(new Long(((BigDecimal)resultado.getValueAt(0,"FORS_OID_FORM")).longValue()));
            } 
            if(resultado.getValueAt(0, "COD_FORM")!=null){
                dtoP.setCodigoFormulario((String)resultado.getValueAt(0, "COD_FORM"));
            }
            if(resultado.getValueAt(0,"MEEP_OID_MEDI_ENVI_PAIS")!=null){ 
                dtoP.setOidMedioEnvio(new Long(((BigDecimal)resultado.getValueAt(0,"MEEP_OID_MEDI_ENVI_PAIS")).longValue()));
            } 
            if(resultado.getValueAt(0,"DES_MEDI_ENVI")!=null){ 
                dtoP.setDescripcionMedioEnvio((String)resultado.getValueAt(0,"DES_MEDI_ENVI"));
            } 
            if(resultado.getValueAt(0,"IND_ACTI")!=null){ 
                if((((BigDecimal)resultado.getValueAt(0,"IND_ACTI")).intValue())==1) { 
                    dtoP.setActivo(Boolean.TRUE); 
                }else{ 
                    dtoP.setActivo(Boolean.FALSE); 
                } 
            } 
            if(resultado.getValueAt(0,"IND_PATR_PERI")!=null){ 
                if((((BigDecimal)resultado.getValueAt(0,"IND_PATR_PERI")).intValue())==1) {
                dtoP.setPatronPeriodo(Boolean.TRUE); 
                    }else{ 
                      dtoP.setPatronPeriodo(Boolean.FALSE); 
                } 
            } 
            if(resultado.getValueAt(0,"PATR_OID_PATR_ORIG")!=null){ 
                dtoP.setOidPatronOrigen(new Long(((BigDecimal)resultado.getValueAt(0,"PATR_OID_PATR_ORIG")).longValue()));
            } 
            if(resultado.getValueAt(0,"PERI_OID_PERI")!=null){ 
                dtoP.setOidPeriodo(new Long(((BigDecimal)resultado.getValueAt(0,"PERI_OID_PERI")).longValue()));
            } 
            if(resultado.getValueAt(0,"OID_PATR_PERI")!=null){ 
                dtoP.setOidPatronPeriodo(new Long(((BigDecimal)resultado.getValueAt(0,"OID_PATR_PERI")).longValue()));
            } 
            if(resultado.getValueAt(0,"PAIS_OID_PAIS")!=null){ 
                dtoP.setOidPais(new Long(((BigDecimal)resultado.getValueAt(0,"PAIS_OID_PAIS")).longValue()));
            } 
    
            ArrayList arrayListSeccion = new ArrayList();
            ArrayList arrayListMensaje = null;
            DTOSeccion dtoSeccion = null;
            DTOMensajeSeccion dtoMensajes = null;
            
            Long oidSeccionActual = null;
            Long oidMensajeActual = null;
            Long oidSeccionAnterior = null;
            Long oidMensajeAnterior = null;
            
            // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
            Long grupoActual = null;
            Long grupoAnterior = null;
            String literalSuperiorActual = null;
            String literalSuperiorAnterior = null;
            boolean hayCambioGrupo = false;
    
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("***oidPatron="+dtoP.getOidPatron());
            
            // Recorremos el RecordSet
            for(int i = 0; i<resultado.getRowCount(); i++) {
                // Obtengo el oid de la sección y el mensaje en que nos encontramos
                if(resultado.getValueAt(i, "OID_PATR_SECC")!=null){ 
                    oidSeccionActual = new Long(((BigDecimal)resultado.getValueAt(i,"OID_PATR_SECC")).longValue());
                }
                if(resultado.getValueAt(i, "MENS_OID_MENS")!=null){ 
                    oidMensajeActual = new Long(((BigDecimal)resultado.getValueAt(i,"MENS_OID_MENS")).longValue());
                }
                
                // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
                if(indCorporativo) {
                    if(resultado.getValueAt(i, "IND_GRUP_SECC")!=null){ 
                        grupoActual = new Long(((BigDecimal)resultado.getValueAt(i,"IND_GRUP_SECC")).longValue());
                    } else
                        grupoActual = null;
                        
                    if(resultado.getValueAt(i, "IDE_SECC")!=null){ 
                        literalSuperiorActual = resultado.getValueAt(i, "IDE_SECC").toString();
                    } else
                        literalSuperiorActual = null;    
                }        
              
                // Si cambia la sección, la creo nueva
                if((oidSeccionAnterior==null)||(oidSeccionActual.longValue()!=oidSeccionAnterior.longValue())){
                    if(indCorporativo) {
                        if((grupoActual!=null) && ((grupoAnterior==null) || (grupoActual.longValue() != grupoAnterior.longValue()))) {
                            hayCambioGrupo = true;
                        } else {
                            hayCambioGrupo = false;
                        }
                    }    
                
                    // Si NO es la primera, guardo los datos de la sección, para poder pasar a la siguiente
                    if(oidSeccionAnterior!=null){
                       dtoSeccion.setMensajes(arrayListMensaje); 
                       arrayListSeccion.add(dtoSeccion);
                       
                       if(hayCambioGrupo) {
                           dtoSeccion.setLiteralSuperiorFin(literalSuperiorAnterior);
                       }
                    }
                    dtoSeccion = new DTOSeccion();
                    arrayListMensaje = new ArrayList();
                    
                    // Actualizo la sección anterior
                    oidSeccionAnterior = new Long(oidSeccionActual.longValue());
                    
                    // Datos de la nueva sección:
                    if(resultado.getValueAt(i, "PATR_OID_PATR")!=null){ 
                        dtoSeccion.setOidPatron(new Long(((BigDecimal)resultado.getValueAt(i, "PATR_OID_PATR")).longValue()));
                    } 
                    if(resultado.getValueAt(i, "OID_PATR_SECC")!=null){ 
                        dtoSeccion.setOidSeccion(new Long(((BigDecimal)resultado.getValueAt(i, "OID_PATR_SECC")).longValue()));
                    } 
                    if(resultado.getValueAt(i, "COD_SECC")!=null){ 
                        dtoSeccion.setCodigo((String)resultado.getValueAt(i, "COD_SECC")); 
                    } 
                    if(resultado.getValueAt(i, "NUM_ORDE_SECC")!=null){ 
                        dtoSeccion.setOrdenSecuencia(new Integer(((BigDecimal)resultado.getValueAt(i, "NUM_ORDE_SECC")).intValue()));
                    } 
                    if(resultado.getValueAt(i, "METC_OID_META")!=null){ 
                        dtoSeccion.setOidMetacaracter(new Long(((BigDecimal)resultado.getValueAt(i, "METC_OID_META")).longValue()));
                    } 
                    if(resultado.getValueAt(i, "VAL_I18N")!=null){ 
                        dtoSeccion.setDesMetacaracter(((String)resultado.getValueAt(i, "VAL_I18N")));
                    } 
                    if(resultado.getValueAt(i,"VAL_LITE_IDEN")!=null){ 
                        dtoSeccion.setLiteralIdentificador((String)resultado.getValueAt(i,"VAL_LITE_IDEN"));
                    } 
                    
                    // Actualizo el grupo sección anterior
                    if(grupoActual != null)
                        grupoAnterior = new Long(grupoActual.longValue());
                    else
                        grupoAnterior = null;
                    if(literalSuperiorActual != null)
                        literalSuperiorAnterior = new String(literalSuperiorActual);
                    else
                        literalSuperiorAnterior = null;                        
                    
                    if(hayCambioGrupo) {
                        dtoSeccion.setLiteralSuperiorInicio(literalSuperiorActual);
                    }
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                      UtilidadesLog.debug("***oidSeccion="+dtoSeccion.getOidSeccion());
                }
                dtoMensajes = new DTOMensajeSeccion();
                // Datos del mensaje
                if(resultado.getValueAt(i, "MENS_OID_MENS")!=null){ 
                    dtoMensajes.setOidMensaje(new Long(((BigDecimal)resultado.getValueAt(i, "MENS_OID_MENS")).longValue()));
                }
                if(resultado.getValueAt(i, "NUM_ORDE_IMPR")!=null){ 
                    dtoMensajes.setOrdenImpresion(new Integer(((BigDecimal)resultado.getValueAt(i, "NUM_ORDE_IMPR")).intValue()));
                } 
                if(resultado.getValueAt(i, "VAL_TEXT")!=null){ 
                    dtoMensajes.setTexto((String)resultado.getValueAt(i, "VAL_TEXT")); 
                }
                arrayListMensaje.add(dtoMensajes);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("**oidMensaje="+dtoMensajes.getOidMensaje());
                }
                
                if(literalSuperiorAnterior!=null)
                    dtoSeccion.setLiteralSuperiorFin(literalSuperiorAnterior);
                
                // Siempre queda el último elemento por insertar
                dtoSeccion.setMensajes(arrayListMensaje); 
                arrayListSeccion.add(dtoSeccion);
                
                // Añadimos las secciones al patrón
                dtoP.setSecciones(arrayListSeccion);
            }
            UtilidadesLog.info("DAOPatron.recuperarEstructuraPatron (DTOOID dtoe): Salida"); 
            
            return dtoP;
        }		
}//clase