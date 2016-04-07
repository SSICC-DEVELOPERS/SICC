package es.indra.sicc.cmn.negocio.auditoria;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;

import java.io.File;
import java.io.FileInputStream;

import java.sql.Date;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONAuditoriaBean implements SessionBean {
    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {}

    public DTOConfiguracionRastreo obtenerConfiguracionRastreo()
        throws MareException {
        DTOConfiguracionRastreo dtoConfiguracionRastreo = new DTOConfiguracionRastreo();

        HashSet funcionesRastreadas = new HashSet();
        HashMap usuariosRastreados = new HashMap();

        try {
            StringBuffer usrQuery = new StringBuffer();
            usrQuery.append(" select p.NAME, pv.STRINGVALUE, pv2.STRINGVALUE fin, pv3.STRINGVALUE inicio ");
            usrQuery.append(" from PROPERTYVALUES pv, PRINCIPALS p, propertyvalues pv2, propertyvalues pv3 ");
            usrQuery.append(" where p.IDPRINCIPAL = pv.IDPRINCIPAL and ");
            usrQuery.append(" pv.IDPROPERTY = 18 and pv.STRINGVALUE in ('ACCESO', 'TOTAL') ");
            usrQuery.append(" AND pv2.idproperty = 44 ");
            usrQuery.append(" AND pv3.idproperty = 45 ");
            usrQuery.append(" AND p.idprincipal = pv2.idprincipal ");
            usrQuery.append(" AND p.idprincipal = pv3.idprincipal ");

            StringBuffer funcQuery = new StringBuffer();
            funcQuery.append("select VAL_NOMB_PROG from MEN_FUNCI where IND_RAST = 1 ");

            RecordSet rtaUsr = BelcorpService.getInstance().dbService.executeStaticQuery(usrQuery.toString());
            RecordSet rtaFunc = BelcorpService.getInstance().dbService.executeStaticQuery(funcQuery.toString());

            for(int row = 0; row < rtaUsr.getRowCount(); row++) {
                Long rastreo = (rtaUsr.getValueAt(row, "STRINGVALUE").toString().equalsIgnoreCase("TOTAL") ? new Long(1) : new Long(0));

                if(validaRango(rtaUsr.getRow(row)))
                    usuariosRastreados.put((String)rtaUsr.getValueAt(row, "NAME"), rastreo);
            }

            for(int row = 0; row < rtaFunc.getRowCount(); row++) {
                funcionesRastreadas.add((String)rtaFunc.getValueAt(row, "VAL_NOMB_PROG"));
            }
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoConfiguracionRastreo.setFuncionesRastreadas(funcionesRastreadas);
        dtoConfiguracionRastreo.setUsuariosRastreados(usuariosRastreados);

        return dtoConfiguracionRastreo;
    }

    public HashMap obtenerConfiguracionAuditoria() {
        try {
            String mareRoot = System.getProperty("MareConfigurationRoot");

            if(!mareRoot.endsWith(File.separator))
                mareRoot += File.separator;

            mareRoot += "ConfiguracionAuditoria.properties";

            Properties p = new Properties();
            File f = new File(mareRoot);
            p.load(new FileInputStream(f));

            return new HashMap(p);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void auditar(String codFunc, String usuario, String Entidad, Long pkEntidad, Integer op, String Dump)
        throws MareException {
        // Este método es el que se encarga de realizar un insert en la tabla de auditoría.
        String codigoError;
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        Long nextOid;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            nextOid = SecuenciadorOID.obtenerSiguienteValor("GEN_GAUD_SEQ");
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(usuario == null) {
            throw new MareException("No se encuentran el parametros ipCliente. Se deben setear antes de la invocacion al entity.");
        }

        if(codFunc == null) {
            throw new MareException("No se encuentran la codFunc.");
        }

        if(pkEntidad == null) {
            throw new MareException("No se encuentran la pkEntidad.");
        }

        if(Entidad == null) {
            throw new MareException("No se encuentran la Entidad.");
        }

        try {
            buf.append(" INSERT INTO GEN_AUDIT (OID_AUDI, FECH, ENTI, ENTI_OID, ").append(" USUA, ENTI_DUMP, TIPO_OPER, VAL_NOMB_PROG) ");
            buf.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");

            Calendar nuevaFecha = Calendar.getInstance();

            java.sql.Date fecha = new java.sql.Date(nuevaFecha.getTime().getTime());
            Vector v = new Vector();
            v.add(nextOid);
            v.add(fecha);
            v.add(Entidad);
            v.add(pkEntidad);
            v.add(usuario);
            v.add(Dump);
            v.add(op);
            v.add(codFunc);

            int res = bs.dbService.executePreparedUpdate(buf.toString(), v);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private boolean validaRango(Vector row) throws Exception {
        long lFechaFin = new Long(row.get(2).toString()).longValue();
        long lFechaInicio = new Long(row.get(3).toString()).longValue();

        long lFechaActual = System.currentTimeMillis();
        boolean bRangoValido = true;
        long dia = 24L * 60L * 60L * 1000L;

        if(lFechaInicio != 0) {
            if(lFechaInicio <= lFechaActual) {
                //rango valido.
            } else
                bRangoValido = false;
        }

        if(lFechaFin != 0) {
            //Le sumo un dia para compara por las horas de mas en System.currentTimeMillis();
            lFechaFin = lFechaFin + dia;

            if(lFechaActual <= lFechaFin) {
                //rango valido.
            } else
                bRangoValido = false;
        }

        return bRangoValido;
    }
}