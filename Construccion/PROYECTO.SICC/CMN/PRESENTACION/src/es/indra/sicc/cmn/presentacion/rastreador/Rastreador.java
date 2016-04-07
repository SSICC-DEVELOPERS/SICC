package es.indra.sicc.cmn.presentacion.rastreador;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.cmn.negocio.auditoria.DTOConfiguracionRastreo;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import javax.ejb.CreateException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;


public class Rastreador implements IRastreador {
    private static Rastreador rastreador;
    private static java.util.Date timeConf;
    private static String conf;
    private static long confTimeout;
    private static DTOConfiguracionRastreo dtoConf = null;
    private HashMap usuariosRastreados;
    private HashSet funcionesRastreadas;
    private String LPIdentificarUsuario = "LPIdentificarUsuario";
    private String LPSustitucionUsuario = "LPSustitucionUsuario";

    private Rastreador() {}

    public static Rastreador getInstance() {

        if(rastreador == null)
            rastreador = new Rastreador();

        return rastreador;
    }

    public HashMap getUsuariosRastreados() {
        return usuariosRastreados;
    }

    public void setUsuariosRastreados(HashMap newUsuariosRastreados) {
        usuariosRastreados = newUsuariosRastreados;
    }

    public HashSet getFuncionesRastreadas() {
        return funcionesRastreadas;
    }

    public void setFuncionesRastreadas(HashSet newFuncionesRastreadas) {
        funcionesRastreadas = newFuncionesRastreadas;
    }

    public void RastrearFuncion(Date fechaHora, String codigoFuncion, String usuario, String password)
        throws MareException {

        if(this.getConf() || cargarConfiguracion().booleanValue()) {

            // llama al metodo del mon y setea los HashSet
            if (dtoConf == null){
                dtoConf = obtenerConfiguracionRastreo(usuario, password);
            }
            this.funcionesRastreadas = dtoConf.getFuncionesRastreadas();
            this.usuariosRastreados = dtoConf.getUsuariosRastreados();
        }

        int aux = usuario.indexOf(" as ");
        String usuarioAux = usuario;

        if(aux != -1)
            usuarioAux = usuario.substring(0, aux);

        Long tipoRastreo = null;

        if(usuariosRastreados.containsKey(usuarioAux)) {
            tipoRastreo = (Long)usuariosRastreados.get(usuarioAux);
        }

        // ver si son rastreables
        if(tipoRastreo != null) {
            if((tipoRastreo.longValue() == 1) && funcionesRastreadas.contains(codigoFuncion)) {
                java.util.Date date = new java.util.Date(fechaHora.getTime());
                write(date + " " + codigoFuncion + " " + usuario);
            } else {
                if((codigoFuncion.equalsIgnoreCase(LPIdentificarUsuario)) || (codigoFuncion.equalsIgnoreCase(LPSustitucionUsuario))) {
                    java.util.Date date = new java.util.Date(fechaHora.getTime());
                    write(date + " " + codigoFuncion + " " + usuario);
                }
            }
        }

        /*MareMGC mgc;
        String salida;
        mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        salida = (String)mgc.getProperty("confRastreoTimeout");*/
    }

    public Boolean cargarConfiguracion() {
        return new Boolean((usuariosRastreados == null) || (funcionesRastreadas == null));
    }

    private String getFileName() {
        String mareRoot = System.getProperty("MareConfigurationRoot");

        if(!mareRoot.endsWith(File.separator))
            mareRoot += File.separator;

        mareRoot += "fichero_rastreo.log";

        return mareRoot;
    }

    private void write(String str) throws MareException {
        try {
            RandomAccessFile logFile = new RandomAccessFile(getFileName(), "rw");
            logFile.seek(logFile.length());

            logFile.writeBytes(str + "\n");

            logFile.close();
        } catch(FileNotFoundException e) {
			e.printStackTrace();
            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(IOException e) {
			e.printStackTrace();
            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private DTOConfiguracionRastreo obtenerConfiguracionRastreo(String usuario, String password)
        throws MareException {
        try {
            MareBusinessID businessId = new MareBusinessID("CMNObtenerConfiguracionRastreo");
            Context context = getInitialContext(usuario, password);
            BusinessFacadeHome mONHome = (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("mare.mln.BusinessFacade"),
                    BusinessFacadeHome.class);
            BusinessFacade businessFacade;

            businessFacade = mONHome.create(); 
            IMareDTO dtos = businessFacade.execute(new MareDTO(), businessId);
            DTOConfiguracionRastreo dtoConf = (DTOConfiguracionRastreo)dtos.getProperty("resultado");
            return dtoConf;
        } catch(CreateException ne) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
        } catch(NamingException ne) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
        } catch(RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private Context getInitialContext(String usuario, String password) throws MareException {
        Hashtable env = new Hashtable();

        try {
            String txContext = es.indra.druida.Contexto.getPropiedad("EJB.CONTEXT");
            String txURL = es.indra.druida.Contexto.getPropiedad("EJB.URL");
            String txUsuario;
            if (usuario == null || usuario.trim().length() == 0) {
                txUsuario = es.indra.druida.Contexto.getPropiedad("EJB.USER");
            } else {
                txUsuario = usuario;
            }
            String txPassword;
            if (password == null || password.trim().length() == 0) {
                txPassword = es.indra.druida.Contexto.getPropiedad("EJB.PASSWORD");
            } else {
                txPassword = password;
            }

            env.put(Context.INITIAL_CONTEXT_FACTORY, txContext);
            env.put(Context.PROVIDER_URL, txURL);
            env.put(Context.SECURITY_PRINCIPAL, txUsuario);
            env.put(Context.SECURITY_CREDENTIALS, txPassword);

            return new InitialContext(env);
        } catch(NamingException ne) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
        } catch(Exception ne) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public boolean getConf() throws MareException {
        try {
            MareMGC mgc;
            mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
            conf = (String)mgc.getProperty("confRastreoTimeout");
            confTimeout = new Long(conf).longValue() * 1000; //Las fechas estan en milisegundos
            java.util.Date timeActual = new java.util.Date();

            if((conf == null) || (timeConf == null) || ((timeConf.getTime() + confTimeout) <= timeActual.getTime())) {
                timeConf = timeActual;
                return true;
            }

            return false;
        } catch(Exception e) {
            //Si se produce alguna excepcion recargo la configuracion.
            return true;
        }
    }

}