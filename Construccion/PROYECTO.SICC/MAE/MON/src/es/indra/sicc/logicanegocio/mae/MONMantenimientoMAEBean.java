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
package es.indra.sicc.logicanegocio.mae;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.StringTokenizer;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.DTOString;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            SEG - Seguridad
 * Componente:        MONMantenimientoMAEBean
 * Fecha:             04/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Viviana Bongiovanni
 */ 

public class MONMantenimientoMAEBean implements SessionBean  {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    public DTOSalida recuperaTiposNSEPPorPais(Long oidPais, Long oidIdioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoMAE.recuperaTiposNSEPPorPais(oidPais, oidIdioma): Entrada"); 
    
        BelcorpService bs;
        RecordSet respuesta;
        DTOSalida dtos = new DTOSalida();
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("select a.OID_NSEP, VAL_I18N desc_nsep_il8n ");         
            buf.append("from MAE_TIPO_NIVEL_SOCEC_PERSO a, GEN_I18N_SICC  ");            

            sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {
                        "PAIS_OID_PAIS"},
                    new Object[] {
                        oidPais}, new boolean[] {false});

            buf.append(sqlWhere);

            buf.append(" and VAL_OID = a.OID_NSEP ");
            buf.append(" and ATTR_ENTI = 'MAE_TIPO_NIVEL_SOCEC_PERSO' ");
            buf.append(" and ATTR_NUM_ATRI = 1 ");
           
            respuesta = bs.dbService.executeStaticQuery(UtilidadesI18N.armarSQLPatronI18n(buf,oidIdioma," order by desc_nsep_il8n "));
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

       dtos.setResultado(respuesta);
       UtilidadesLog.info("MONMantenimientoMAE.recuperaTiposNSEPPorPais(oidPais, oidIdioma): Salida"); 

       return dtos;  

    }

    public DTOSalida obtenerFecha(DTOString dtoE) throws MareException {
        UtilidadesLog.debug("MONMantenimientoMAE.obtenerFecha(DTOString dtoE): Entrada");
        UtilidadesLog.debug("dtoE\n"+dtoE);
        
        DTOSalida dtoS = new DTOSalida();
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer consulta = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            consulta.append("SELECT 1 OID, TO_CHAR(SYSDATE");
            
            
            
            if(dtoE.getCadena()!=null && dtoE.getCadena().length()> 0){
            
                StringTokenizer st = new StringTokenizer(dtoE.getCadena(),"!%!");
                
                String desplazamiento = null;
                String formatoFecha = null;
                
                int valor = 0;
                try{
                    desplazamiento = st.nextToken();
                    valor = Integer.parseInt(desplazamiento);
                }catch(Exception e){
                    UtilidadesLog.error("El desplazamiento no es valido ["+desplazamiento+"]");
                }
                if(valor!=0){
                    consulta.append(valor);
                }
                

                try{
                    formatoFecha = st.nextToken();
                }catch(Exception e){
                    UtilidadesLog.error("El formato de fecha no es valido ["+formatoFecha+"]. Se usa formato DD/MM/YYYY");
                    formatoFecha = "DD/MM/YYYY";
                }
                
                consulta.append(",'"+formatoFecha+"'");
                
            }
            consulta.append(") FECHA FROM DUAL");
            
            respuesta = bs.dbService.executeStaticQuery(consulta.toString());
            
            dtoS.setResultado(respuesta);
            
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

       UtilidadesLog.debug("MONMantenimientoMAE.obtenerFecha(DTOString dtoE): Salida");
       
       return dtoS;
    }
}