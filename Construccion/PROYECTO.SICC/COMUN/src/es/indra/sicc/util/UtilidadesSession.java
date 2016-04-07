package es.indra.sicc.util;


import es.indra.druida.DruidaBase;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;

import es.indra.sicc.cmn.presentacion.i18n.Idioma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * Modo de uso:
 *         Esta clase contiene métodos de acceso a las variables de sesión y está pensada
 *  para ser accedida desde las Lógicas de Presentación de Druida.
 *
 * Ya que ésta clase se accede desde todas las Lógicas de Presentación y los
 * datos a extraer son "particulares" a "esa session" HTTP, se requiere que cuando
 * se llame a los métodos estaticos de ésta clase se la pase a cada uno de los
 * métodos una referencia a la "Lógica de Presentación".<BR>
 * EJ:
 *         String s = UtilidadesSession.getIdUsuario( this );
 *  //Donde "this" es la referencia a la instancia de la "Lógica de Presentación"
 *
 * <BR>
 * Nota:<BR>
 *         Los datos de ésta clase se cargan en el proceso de "login" del sistema.
 * */
public class UtilidadesSession {
    /**
     * Fecha : 06/11/2003
     * Obtiene el IdUsuario de la sesion HTPP. El IdUsuario es el nombre del usuario.
     * El dato se obtiene desde las MareCredentials que se guardaron en sesion para el usuario.
     *
     * wvillafa
     * */
    public static synchronized String getIdUsuario(DruidaBase lp) throws MareException {
        String usuario;

        try {
            MareCredentials mc = (MareCredentials) lp.conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS);
            usuario = mc.getUser().getName();
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_MARE_CREDENTIALS_SESSION));
        }

        int index = usuario.indexOf(" as ");

        if (index != -1) {
            usuario = usuario.substring(index + 4, usuario.length());
        }

        return usuario;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene las MareCredentials del usuario desde la sesión HTTP.
     *
     * wvillafa
     * */
    public static synchronized MareCredentials getMareCredentials(DruidaBase lp) {
        return (MareCredentials) lp.conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS);
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el código del pais del usuario. Este código es el de la tabla
     * SEG_PAIS.
     *
     * wvillafa, vbongiov
     * */
    public static synchronized Long getPais(DruidaBase lp) throws MareException {
        Long pais;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property paisDefecto = (Property) hs.get(IVariablesSesion.PAIS_DEFECTO);

            //pais = new Long(((Integer)paisDefecto.getValue()).longValue());
            pais = new Long(paisDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_PAIS_SESSION));
        }

        return pais;
    }

    /**
     *
     *
     * */
    public static synchronized String getDescripcionPais(DruidaBase lp) throws Exception {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.DESCRIPCION_PAIS_DEFECTO);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el tipo de usuario. Este código es el de la tabla
     * PROPERTYVALUES de OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getTipoUsuario(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property TipoUsuario = (Property) hs.get(IVariablesSesion.TIPO_DE_USUARIO);

        return TipoUsuario.getValue().toString();
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el perfil de usuario. Este código es el de la tabla
     * PROPERTYVALUES de OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getPerfil(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.PERFIL_USUARIO);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el canal del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getCanal(DruidaBase lp) {
        /*
                    HashMap hs = (HashMap)lp.conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
                    Property  prop = (Property) hs.get( IVariablesSesion.CANAL );
                    return        Integer.valueOf(  prop.getValue().toString() );
        */
        return null;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene la Marca del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getMarca(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.MARCA);

        return Integer.valueOf(prop.getValue().toString());
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene la Sociedad (Empresa) del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getSociedad(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.SOCIEDAD);

        return Integer.valueOf(prop.getValue().toString());
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el SubAcceso del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getSubAcceso(DruidaBase lp) {
        /*
                    HashMap hs = (HashMap)lp.conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
                    Property  prop = (Property) hs.get( IVariablesSesion.SUBACCESO );
                    return        Integer.valueOf(  prop.getValue().toString() );
        */
        return null;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene la Subgerencia de ventas del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getSubGerenciaVentas(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.SUBGERENCIAVENTAS);

        return Integer.valueOf(prop.getValue().toString());
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene la Región del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getRegion(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.REGION);

        return Integer.valueOf(prop.getValue().toString());
    }

    /**
     * Fecha : 06/8/2004
     * Obtiene la Zona por Defecto del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Long getZonaPorDefecto(DruidaBase lp) throws MareException {
        Long zona;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property zonaDefecto = (Property) hs.get(IVariablesSesion.ZONA);
            zona = new Long(zonaDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_ZONA_SESSION));
        }

        return zona;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene la Seccion del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getSeccion(DruidaBase lp) {
        /*
                    HashMap hs = (HashMap)lp.conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
                    Property  prop = (Property) hs.get( IVariablesSesion.SECCION );
                    return        Integer.valueOf(  prop.getValue().toString() );
        */
        return null;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el Territorio del usuario de la session HTTP.
     *
     * wvillafa
     * */
    public static synchronized Integer getTerritorio(DruidaBase lp) {
        /*
                    HashMap hs = (HashMap)lp.conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
                    Property  prop = (Property) hs.get( IVariablesSesion.TERRITORIO );
                    return        Integer.valueOf(  prop.getValue().toString() );
        */
        return null;
    }

    /**
     * Fecha : 06/11/2003
     * Obtiene el Formato de la Fecha de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getFormatoFecha(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.FORMATOFECHA);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 07/11/2003
     * Obtiene el Primer Apellido de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getPrimerApellido(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.PRIMER_APELLIDO);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 07/11/2003
     * Obtiene el Segundo Apellido de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getSegundoApellido(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.SEGUNDO_APELLIDO);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 07/11/2003
     * Obtiene el Primer Nombre de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getPrimerNombre(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.PRIMER_NOMBRE);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 07/11/2003
     * Obtiene el Segundo Nombre de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * wvillafa
     * */
    public static synchronized String getSegundoNombre(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.SEGUNDO_NOMBRE);

        return prop.getValue().toString();
    }

    /**
         * Fecha : 01/12/2003
         * Obtiene el codigo ISO del pais desde la session HTTP. Este dato se obtiene
         * de PROPERTIES en OWN_MARE.
         *
         * vbongiov
         * */
    public static synchronized String _ISO(DruidaBase lp) throws MareException {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.IDIOMA__ISO);

        return prop.getValue().toString();
    }

    /**
         * Fecha : 01/12/2003
         * Obtiene el codigo ISO del idioma desde la session HTTP. Este dato se obtiene
         * de PROPERTIES en OWN_MARE.
         *
         * vbongiov
         * */
    public static synchronized String getIdioma_ISO(DruidaBase lp) throws MareException {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.IDIOMA_ISO);

        return prop.getValue().toString();
    }

    /**
         * Fecha : 17/11/2003
         * Obtiene el Idioma de la session HTTP. Este dato se obtiene
         * de PROPERTIES en OWN_MARE.
         *
         * vbongiov
         * */
    public static synchronized Long getIdioma(DruidaBase lp) throws MareException {
        Long idiomaUsu;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property idioma = (Property) hs.get(IVariablesSesion.IDIOMA);
            idiomaUsu = Long.valueOf((String) idioma.getValue());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_IDIOMA_SESSION));
        }

        return idiomaUsu;
    }

    /**
     * Fecha: 21/11/2003
     * Obtiene la Funcion de la ultima lp que se selecciono en el
     * menu principal de la aplicacion del SICC, este valor lo guarda
     * en seccion el servlet sicc0000jg.java
     */
    public static synchronized String getFuncion(DruidaBase lp) throws MareException {
        try {
            /*
             String salida = "";
             Object idFuncion = lp.conectorParametroSesion(IVariablesSesion.ID_FUNCION);
            if(idFuncion!=null){
              salida = idFuncion.toString();
            }
            return salida;
            */
            String salida = lp.getClass().getName();
            StringTokenizer tokens = new StringTokenizer(salida, ".");

            while (tokens.hasMoreTokens()) {
                salida = tokens.nextToken();
            }

            return salida;
        } catch (Exception e) {
            throw new MareException(e.getMessage());
        }
    }

    //Métodos de propiedades de la clave:
    public static synchronized String getDiasCambio(DruidaBase lp) throws MareException {
        String diasCambio = (String) lp.conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_DIAS_CAMBIO);

        return diasCambio;
    }

    public static synchronized String getLongitudMinina(DruidaBase lp) throws MareException {
        String longitudMinina = (String) lp.conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_LONGITUD_MINIMA);

        return longitudMinina;
    }

    public static synchronized String getNumeroMaximoIntentos(DruidaBase lp) throws MareException {
        String numeroMaximoIntentos = (String) lp.conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_NRO_INTENTOS);

        return numeroMaximoIntentos;
    }

    public static synchronized String getNumeroRepeticiones(DruidaBase lp) throws MareException {
        String numeroRepeticiones = (String) lp.conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_NRO_REPETICIONES);

        return numeroRepeticiones;
    }

    /**
     * Fecha : 16/02/2004
     * Obtiene la separador de decimales del usuario de la session HTTP.
     *
     * dnhrusze
     * */
    public static synchronized String getSeparadorDecimales(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_DECIMALES);

        return prop.getValue().toString();
    }

    /**
     * Fecha : 16/02/2004
     * Obtiene la formato fecha del usuario de la session HTTP.
     *
     * dnhrusze
     * */
    public static synchronized String getFormatoNumerico(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.FORMATO_NUMERICO);

        return prop.getValue().toString();
    }

    /**
     * @author Gacevedo
     *
     */
    public static synchronized String getFormatoNumericoAlternativo(DruidaBase lp) {
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property prop = (Property) hs.get(IVariablesSesion.FORMATO_NUMERICO_ALTERNATIVO);

        return prop.getValue().toString();
    }

    /**
    * Retorna la fecha formateada como String según el formato que hay en
    * sesión.
    */
    public static String fechalongToString(DruidaBase lp, long fecha) {
        String formato = null;

        try {
            formato = UtilidadesSession.getFormatoFecha(lp);
        } catch (Exception e) {
            formato = "";
        }

        return UtilidadesBelcorp.fechaFormateada(new java.sql.Date(fecha), formato);
    }

    /*
     * Genera un DTOError con la descripcion, codigo y severidad de la exception
     * recibida. Requiere la LP para obtener el idioma y el pais (codigos ISO, ej. es, ES).
     * */
    public static final DTOError recuperarDatosException(Exception e, DruidaBase lp) {
        BelcorpError belcorpError = new BelcorpError();
        DTOError dtoError = null;

        try {
            String h = getIdioma_ISO(lp);
            String t = _ISO(lp);
            dtoError = belcorpError.obtenerError(e, getIdioma_ISO(lp), _ISO(lp)); //this._ISO(lp));
        } catch (Exception ex) {
            dtoError = belcorpError.obtenerError(e); //Si falla usa el idioma default
        }

        return dtoError;
    }

    /*
     * Método utilizado para internacionalizar el error en DruidaTransaction
     * */
    public static final void lanzarPaginaErrorDT(Exception e, DruidaBase lp) throws Exception {
        DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(e, lp);
        throw new Exception(dtoError.getDescripcionError());
    }

    /*
     * Temporal, borrorar. Es para ver un log porque la traza no funciona
     * */
    /*        private static String getFileName() {
                    String mareRoot = System.getProperty("MareConfigurationRoot");

                    if(!mareRoot.endsWith(File.separator))
                            mareRoot += File.separator;

                    mareRoot += "fichero_rastreo.log";
                    UtilidadesLog.debug("Archivo Rastreo: " + mareRoot);

                    return mareRoot;
            }*/
    /*
     * Temporal, borrorar. Es para ver un log porque la traza no funciona
     * */
    /*        private static void write(String str) {
                    try {
                            RandomAccessFile logFile = new RandomAccessFile(getFileName(), "rw");
                            logFile.seek(logFile.length());

                            logFile.writeBytes(str + "\n");

                            logFile.close();
                    } catch(FileNotFoundException e) {
                            e.UtilidadesLog.error();
                            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
                            //throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    } catch(IOException e) {
                            e.UtilidadesLog.error();
                            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;
                            //throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    }
            }*/

    /**
     * Fecha : 29/03/2004
    * Obtiene la Marca por defecto de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * */
    public static synchronized Long getMarcaPorDefecto(DruidaBase lp) throws MareException {
        Long marca;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property marcaDefecto = (Property) hs.get(IVariablesSesion.MARCA_DEFECTO);
            marca = new Long(marcaDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_MARCA_SESSION));
        }

        return marca;
    }

    /**
     * Fecha : 29/03/2004
    * Obtiene el Canal por defecto de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * */
    public static synchronized Long getCanalPorDefecto(DruidaBase lp) throws MareException {
        Long canal;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property canalDefecto = (Property) hs.get(IVariablesSesion.CANAL_DEFECTO);
            canal = new Long(canalDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_CANAL_SESSION));
        }

        return canal;
    }

    /**
     * Fecha : 29/03/2004
    * Obtiene el Acceso por defecto de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * */
    public static synchronized Long getAccesoPorDefecto(DruidaBase lp) throws MareException {
        Long acceso;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property accesoDefecto = (Property) hs.get(IVariablesSesion.ACCESO_DEFECTO);
            acceso = new Long(accesoDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_ACCESO_SESSION));
        }

        return acceso;
    }

    /**
     * Fecha : 29/03/2004
    * Obtiene el Subacceso por defecto de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * */
    public static synchronized Long getSubaccesoPorDefecto(DruidaBase lp) throws MareException {
        Long subacceso;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property subaccesoDefecto = (Property) hs.get(IVariablesSesion.SUBACCESO_DEFECTO);
            subacceso = new Long(subaccesoDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_SUBACCESO_SESSION));
        }

        return subacceso;
    }

    /**
     * @Fecha : 29/03/2004
     * Obtiene la Sociedad por defecto de la session HTTP. Este dato se obtiene
     * de PROPERTIES en OWN_MARE.
     *
     * */
    /**
     * @Modificado: 03/12/2004
     * @Modificó: Hugo Mansi
     * @Incidencia: BELC300011176
     *
     */
    /**Lo comentado se quito por la incidencia de referencia*/
    /********************************************************************************************
         * public static synchronized Long getSociedadPorDefecto(DruidaBase lp) throws MareException {
        Long sociedad;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property sociedadDefecto = (Property) hs.get(IVariablesSesion.SOCIEDAD_DEFECTO);
            sociedad = new Long(sociedadDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_SOCIEDAD_SESSION));
        }*****************************************************************************************/
    public static synchronized Long getSociedadPorDefecto(DruidaBase lp) {
        Long sociedad;
        HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
        Property sociedadDefecto = (Property) hs.get(IVariablesSesion.SOCIEDAD_DEFECTO);
        sociedad = new Long(sociedadDefecto.getValue().toString());
        return sociedad;
    }

    public static synchronized Long getSGVPorDefecto(DruidaBase lp) throws MareException {
        Long sgv;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property sgvDefecto = (Property) hs.get(IVariablesSesion.SGV_DEFECTO);
            sgv = new Long(sgvDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_SOCIEDAD_SESSION));
        }

        return sgv;
    }
    
    /**
         * Fecha : 12/01/2005
         * Obtiene la region por defecto de la session HTTP. 
         *
         * vbongiov
         * */
    public static synchronized Long getRegionPorDefecto(DruidaBase lp) throws MareException {
        Long region;

        try {
            HashMap hs = (HashMap) lp.conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
            Property regionDefecto = (Property) hs.get(IVariablesSesion.REGION);
            region = new Long(regionDefecto.getValue().toString());
        } catch (Exception e) {
            throw new MareException(e.getMessage(), UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_SOCIEDAD_SESSION));
        }

        return region;
    }

    /**
     * Obtiene el usuario que se ha logueado y se guardo en la session para el uso
     * de la seguridad de druida
     * @param lp
     * @return
     * @throws MareException
     */
    public static synchronized String getDruidaUsuario(DruidaBase lp) throws MareException{
        return (String)lp.conectorParametroSesion("DruidaUsuario");
    }
    /**
     * Obtiene el password del usuario que se ha logueado y se guardo en la session para el uso
     * de la seguridad de druida
     * @param lp
     * @return
     * @throws MareException
     */
    public static synchronized String getDruidaPassword(DruidaBase lp) throws MareException{
        return (String)lp.conectorParametroSesion("DruidaPassword");
    }
}
