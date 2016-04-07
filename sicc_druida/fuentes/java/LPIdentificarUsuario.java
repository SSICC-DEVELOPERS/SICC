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
import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.MareMguAccessException;
import es.indra.mare.common.mgu.exception.MareMguInvalidCredentials;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.men.DTOSFormato;
import es.indra.sicc.dtos.seg.ParametrosClaveDTO;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.rmi.RemoteException;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpSession;


public final class LPIdentificarUsuario extends LPSICCBase {
    private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService"; //Nombre del servicio de MGU.
    private String accion = "";
    private String usuario = "";
    private String contrasenia = "";
    private HashMap propiedasdesMGU;
	
	//11/10/2005 - rgiorgi: se recupera el pais
	private String codigoPais = "";
    // Agregado por HRCS - Fecha 22/05/2007
    private static HashMap paises = new HashMap();

    public LPIdentificarUsuario() {
        super();
    }

    public void inicio() throws Exception {
        pagina("validacion");
    }

    /*
     * status: se utiliza esta variable para retornar la accion a seguir en la pagina de validacion.xml
     *         Los valores pueden ser N, S, U, C y E. U y C son usados para redigir el ingreso del usuario
     *                          a la pantalla que corresponda: Sustitucion de Usuario o Cambio de Clave.
     */
    public void ejecucion() throws Exception {
        setTrazaFichero();

        try {
            accion = conectorParametroLimpia("accion", "", true);
            usuario = conectorParametroLimpia("usuario", "", true).toUpperCase();
            contrasenia = conectorParametroLimpia("contrasenia", "", true);
			
			//11/10/2005 - rgiorgi: se recupera el pais
			codigoPais = conectorParametroLimpia("codigoPais", "", true); 
			
            if (accion.equals("")) {

                //11/10/2005 - rgiorgi: recupera URLs, carga pantalla
					 cargaPantalla();
				
                final Enumeration nombres = this.getRequest().getSession().getAttributeNames();
                final HttpSession mySesion = this.getRequest().getSession();

                while (nombres.hasMoreElements()) {
                    mySesion.removeAttribute((String) nombres.nextElement());
                }

                //recupero parametros de clave.
                //recuperarParametrosClave();
			}

            if (accion.equals("validar")) {
				System.out.println("codigoPais: " + codigoPais);
				traza("codigoPais: " + codigoPais);
				
				recuperarUsuarioPais();
				System.out.println("usuario recuperado: " + usuario);
				//  Modificado por HRCS - Fecha 22/05/2007
                validaUsuario(usuario, contrasenia, codigoPais );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logStackTrace(ex);
            asignarAtributo("VAR", "nombreDevuelto", "valor", "" + usuario);
            lanzarPaginaError(ex);
        }
    }

    /*
     * Autor: rgiorgi
     * Fecha: 11/10/2005
     * Descripción: en este metodo se carga la pantalla de login
     * */
    private void cargaPantalla() throws Exception {
        DTOOID dtoParamPais = new DTOOID();
        dtoParamPais.setOid(new Long(-1)); //TODO: revisar hardcode.
        dtoParamPais.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);

        Vector parametros = new Vector();
        parametros.add(dtoParamPais);
        parametros.add(new MareBusinessID("SEGRecuperaPais"));

        DruidaConector conectorBusquedaPais = conectar("ConectorRecuperarPais", parametros);

        DTOSalida dtoSalida = (DTOSalida) conectorBusquedaPais.objeto("dtoSalidaObjeto");

        if (dtoSalida.getResultado().esVacio() == false) {

            //3.- Llenar el combo de pais con los campos OID_PAIS y VAL_I18N de todos los elementos de la listaOculta.
            //TODO: hacer en capa cliente, incidencia
            Vector columnasComboPais = new Vector();
            columnasComboPais.add("OID_PAIS");
            columnasComboPais.add("VAL_I18N");

            Vector columnasComboPaisURL = new Vector();
            columnasComboPaisURL.add("COD_PAIS");
            columnasComboPaisURL.add("VAL_URL");

            RecordSet newListaOcultaPaises = new RecordSet();
            newListaOcultaPaises.setColumnIdentifiers(columnasComboPais);

            RecordSet newListaOcultaPaisesURL = new RecordSet();
            newListaOcultaPaisesURL.setColumnIdentifiers(columnasComboPaisURL);

            for (int i = 0; i < dtoSalida.getResultado().getRowCount(); i++) {
                newListaOcultaPaises.addRow(new Object[] {
                        dtoSalida.getResultado().getValueAt(i, 0),
                        dtoSalida.getResultado().getValueAt(i, 3)
                    });

                newListaOcultaPaisesURL.addRow(new Object[] {
                        dtoSalida.getResultado().getValueAt(i, 2),
                        dtoSalida.getResultado().getValueAt(i, 27)
                    });
				//  Agregado por HRCS - Fecha 22/05/2007
                if (dtoSalida.getResultado().getValueAt(i,2)!=null && 
                    dtoSalida.getResultado().getValueAt(i,0)!=null)   {
                    paises.put( dtoSalida.getResultado().getValueAt(i,2), new Long(dtoSalida.getResultado().getValueAt(i,0).toString()) );
                }
            }

            asignar("COMBO", "cbPais", UtilidadesBelcorp.generarConector("ROWSET", newListaOcultaPaises, columnasComboPais), "ROWSET");

            asignar("COMBO", "cbPaisURL", UtilidadesBelcorp.generarConector("ROWSET", newListaOcultaPaisesURL, columnasComboPaisURL), "ROWSET");
        }
    }

	/*
	 * Autor: rgiorgi
	 * Fecha: 11/10/2005
	 * Descripción: este metodo debe reemplazar el strUsuarioCorpo por el mismo con el prefijo del codigo de pais 
	 * 				de manera de transformarlo en el usuario del pais y almacenar en strURL la URL del pais.
	 * */
	private void recuperarUsuarioPais() throws Exception{
		if (codigoPais !=null && codigoPais.length()>0){
			usuario = codigoPais + usuario;
			usuario = usuario.trim();
		}
	}

 
    private void obtenerFormatos(HashMap propsUser) throws Exception {
        Vector parametros = new Vector();
        DTOPais dtoPais = new DTOPais();

        final Property pPaisDefecto = (Property) propsUser.get(IVariablesSesion.PAIS_DEFECTO);

        if ((pPaisDefecto != null) && !pPaisDefecto.getValue().toString().equals("")) {
            dtoPais.setPais(new Long(pPaisDefecto.getValue().toString()));
        }

        final Property pIdioma = (Property) propsUser.get(IVariablesSesion.IDIOMA);

        if ((pIdioma != null) && !pIdioma.getValue().toString().equals("")) {
            dtoPais.setOidIdioma(new Long(pIdioma.getValue().toString()));
        }

        parametros.add(dtoPais);
        parametros.add(new MareBusinessID("MENCargarFormato"));

        DruidaConector conectorFormatos = conectar("ConectorCargaFormatos", parametros);

        DTOSFormato dtoSalida = (DTOSFormato) conectorFormatos.objeto("dtoSalida");

        //Seteo las propiedades obtenidas
        Property pTmp = null;

        pTmp = new Property(IVariablesSesion.DESCRIPCION_PAIS_DEFECTO, (String) dtoSalida.getDescripcion());
        propsUser.put(IVariablesSesion.DESCRIPCION_PAIS_DEFECTO, pTmp);
        pTmp = new Property(IVariablesSesion.FORMATOFECHA, (String) dtoSalida.getFormatoFecha());
        propsUser.put(IVariablesSesion.FORMATOFECHA, pTmp);

        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO, (String) dtoSalida.getNumeroDeDecimales());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO, pTmp);
        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO_ALTERNATIVO, (String) dtoSalida.getNumeroDeDecimalesAlternativa());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO_ALTERNATIVO, pTmp);
        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_DECIMALES, (String) dtoSalida.getSeparadorDecimal());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_DECIMALES, pTmp);
        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_MILES, (String) dtoSalida.getSeperadorMiles());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_MILES, pTmp);
    }

    private void validaUsuario(final String usuario, final String contrasenia, final String pais) throws java.lang.Exception {
        //metodo encargado de validar al usuario, usando la
        //combinacion usuario-contrasenia, si valida, guarda las
        //credenciales en la session sino, eleva una java.lang.Exception
        //o MareMguInvalidCredentials con el error
        MGUService mgu = null;
        String status = "";

        try {
            UserIDSICC oUsuario = new UserIDSICC(usuario);
            final MareCredentials credenciales = new MareCredentials(oUsuario, contrasenia);
            mgu = (MGUService) MareMii.getService(new MareTopic(NOMBRE_SERVICIO_MGUSERVICE, credenciales));

            String logicaDeInicio = "";

            //guardo las credenciales
            conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS, credenciales);

            //actualizarPropiedadesLocales(usuario); 
            propiedasdesMGU = mgu.getMergedProperties();

            final Property userP2 = (Property) propiedasdesMGU.get("TipoUsuario");
            String tipoUsuar = (String) userP2.getValue();

            if (tipoUsuar.equalsIgnoreCase("BATCH")) {
                throw new MareException(null, null, UtilidadesError.armarCodigoError("312"));
            }

            if (mgu.authenticate()) {
                conectorParametroSesion("DruidaUsuario", usuario);
                conectorParametroSesion("DruidaPassword", contrasenia);

                //propiedasdesMGU =  mgu.getMergedProperties();
                //Usuario de Sustitucion.
                final Property userP = (Property) propiedasdesMGU.get("UsuarioSustitucion");
                final Property pSustitucionDesde = (Property) propiedasdesMGU.get("FechaSustitucionDesde");
                final Property pSustitucionHasta = (Property) propiedasdesMGU.get("FechaSustitucionHasta");

                //Obtengo el indicador de Clave Inicial del usuario.
                final Property pClaveInicial = (Property) propiedasdesMGU.get("IndicacionClaveInicial");

                //Obtengo el indicador de Usuario Habilitado.
                final Property pUsuarioHabilitado = (Property) propiedasdesMGU.get("UsuarioHabilitado");
                final Property pHabilitadoDesde = (Property) propiedasdesMGU.get("PeriodoValidezFechaDesde");
                final Property pHabilitadoHasta = (Property) propiedasdesMGU.get("PeriodoValidezFechaHasta");

                /* Seteo el DruidaLang */
                final Property pIdioma = (Property) propiedasdesMGU.get(IVariablesSesion.IDIOMA);

                String codigoISO = null;
                String codigo_ISO = null;

                if ((pIdioma != null) && !pIdioma.getValue().toString().equals("")) {
                    //setea la Collection de idiomas.
                    this.getIdiomas();

                    //obtengo el iso buscando en la collection
                    codigoISO = this.getISO(new Long(pIdioma.getValue().toString()));
                    codigo_ISO = this.get_ISO(new Long(pIdioma.getValue().toString()));

                    //SetDruidaLang
                    setIdioma(codigoISO); //obtengo iso y seteo 
                }

                propiedasdesMGU.put(IVariablesSesion.IDIOMA_ISO, new Property(IVariablesSesion.IDIOMA_ISO, codigoISO));
                propiedasdesMGU.put(IVariablesSesion.IDIOMA__ISO, new Property(IVariablesSesion.IDIOMA__ISO, codigo_ISO));

                //  Agregado por HRCS - Fecha 22/05/2007
                if (paises.size()==0)   {
                    DTOOID dtoParamPais = new DTOOID();
                    dtoParamPais.setOid(new Long(-1)); //TODO: revisar hardcode.
                    dtoParamPais.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                    Vector parametros = new Vector();
                    parametros.add(dtoParamPais);
                    parametros.add(new MareBusinessID("SEGRecuperaPais"));
                    DruidaConector conectorBusquedaPais = conectar("ConectorRecuperarPais", parametros);
                    DTOSalida dtoSalida = (DTOSalida) conectorBusquedaPais.objeto("dtoSalidaObjeto");
                    for (int i = 0; i < dtoSalida.getResultado().getRowCount(); i++) {
                        paises.put( (String)dtoSalida.getResultado().getValueAt(i,2), new Long(dtoSalida.getResultado().getValueAt(i,0).toString()) );
                    }
                }
                Long oidPais = (Long)paises.get( pais );
                if (oidPais!=null)  {
                    propiedasdesMGU.put(IVariablesSesion.PAIS_DEFECTO, new Property(IVariablesSesion.PAIS_DEFECTO, oidPais.toString()));
                } else {
                    traza("Valor oidPais es nulo. Permanece pais por defecto.");
                }

                conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO, propiedasdesMGU);

                //Agrego las propiedades de Formatos.
                obtenerFormatos(propiedasdesMGU);

                //**** Validación de usuario habilitado. ****//
                if ((pUsuarioHabilitado != null) && (pUsuarioHabilitado.getValue() != null) && pUsuarioHabilitado.getValue().toString().equals("N")) {
                    //asignarAtributo("VAR", "validado", "valor", "N");
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_DESHABILITADO));
                } else {
                    //**** INI - Valido el rango de fechas de habilitación ****//
                    if (validaRango(pHabilitadoDesde, pHabilitadoHasta) == false) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_DESHABILITADO));
                    }

                    //**** FIN - Valido el rango de fechas de habilitación ****//
                }

                //**** Longitud mínima clave ****//

                /*
                String pLongitudMinina = UtilidadesSession.getLongitudMinina(this);

                if ((pLongitudMinina != null) && !(pLongitudMinina.equals(""))) {
                    int longPermitida = Integer.parseInt(pLongitudMinina.toString());

                    if (credenciales.getPassword().toString().length() < longPermitida) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_CLAVE_LONGITUD_MINIMA));
                    }
                }
                */

                //**** Verifico la Clave Inicial ****//
                if ((pClaveInicial == null) || pClaveInicial.getValue().toString().equals("N")) {
                    if ((userP == null) || ((String) userP.getValue() == null)) {
                        status = "S";
                    } else {
                        //**** INI - Valido rango de fecha de sustitucion ****//
                        if (validaRango(pSustitucionDesde, pSustitucionHasta) == true) {
                            status = "U";
                        } else {
                            //Si la fecha actual no esta dentro del rango
                            //no pasa por la pantalla de sustitucion.
                            status = "S";
                        }

                        //**** FIN - Valido rango de fecha de sustitucion ****//
                    }

                    try {
                        traza("status :" + status);

                        if (status.equalsIgnoreCase("S")) {
                            rastreo(); //Se logueo
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        logStackTrace(e);
                        traza("Exception :" + e.getClass().getName());
                    }

                    asignarAtributo("VAR", "validado", "valor", status);
                } else {
                    asignarAtributo("VAR", "validado", "valor", "E");
                }
            } else {
                traza("despues de authenticate.. false");
                mgu.shutdown();
                throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
            }
        } catch (RemoteException re) {
            traza("RemoteException: " + re);
            re.printStackTrace();
            logStackTrace(re);

            OrionRemoteException or = (OrionRemoteException) re;
            re = ((RemoteException) or.getOriginal());

            if (re.detail instanceof MareMguInvalidCredentials) {
                final MareMguInvalidCredentials mgue = (MareMguInvalidCredentials) re.detail;
                traza("MareMguInvalidCredentials:" + mgue);

                if (mgue.getCode() == MareMguInvalidCredentials.EXPIRED) {
                    asignarAtributo("VAR", "validado", "valor", "E");
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_CADUCADA));
                } else {
                    asignarAtributo("VAR", "errCodigo", "valor", "" + mgue.getCode());
                    asignarAtributo("VAR", "errDescripcion", "valor", "" + mgue.toString());
                }
            } else {
                if (re.detail instanceof MareMguAccessException) {
                    traza("MareMguAccessException : " + re.detail);
                    asignarAtributo("VAR", "errCodigo", "valor", "");
                    asignarAtributo("VAR", "errDescripcion", "valor", "ERR_45");
                } else {
                    asignarAtributo("VAR", "errCodigo", "valor", "");
                    asignarAtributo("VAR", "errDescripcion", "valor", "" + re.detail.toString());
                }
            }
        } catch (MareMiiServiceNotFoundException miie) {
            logStackTrace(miie);
            traza("MareMiiServiceNotFoundException: " + miie.toString());

            MareException me = new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
            asignarAtributo("VAR", "validado", "valor", "N");
            lanzarPaginaError(me);
        } catch (MareException me) {
            logStackTrace(me);

            if (me instanceof MareMguInvalidCredentials) {
                traza("Es una MareException de tipo MareMguInvalidCredentials");

                if (me.getCode() == 20003) {
                    asignarAtributo("VAR", "validado", "valor", "C");
                } else {
                    asignarAtributo("VAR", "validado", "valor", "N");
                }
            } else {
                asignarAtributo("VAR", "validado", "valor", "N");
            }

            lanzarPaginaError(me);
        } catch (Exception ex) {
            logStackTrace(ex);
            ex.printStackTrace();
            asignarAtributo("VAR", "errCodigo", "valor", "");
            asignarAtributo("VAR", "errDescripcion", "valor", ex.getMessage());
        } finally {
            try {
                if (mgu != null) {
                    mgu.shutdown();
                }

                asignarAtributo("VAR", "nombreDevuelto", "valor", usuario);
            } catch (Exception exf) {
                logStackTrace(exf);
            }
        }
    }

    private void recuperarParametrosClave() throws Exception {
        ParametrosClaveDTO parametrosclavedto = new ParametrosClaveDTO();
        MareBusinessID marebusinessid = new MareBusinessID("MLNFBusquedaParametrosClave");

        Vector paramEntrada = new Vector();
        paramEntrada.add(null);
        paramEntrada.add(marebusinessid);

        DruidaConector conector = conectar("ConectorBusquedaParametrosClave", paramEntrada);

        parametrosclavedto = (ParametrosClaveDTO) conector.objeto("dtoSalida");

        String s1 = parametrosclavedto.getDiasCambio().toString();
        String s3 = parametrosclavedto.getNumeroRepeticiones().toString();
        String s5 = parametrosclavedto.getLongitudMinina().toString();
        String s7 = parametrosclavedto.getNumeroMaximoIntentos().toString();

        conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_DIAS_CAMBIO, s1);
        conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_NRO_REPETICIONES, s3);
        conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_LONGITUD_MINIMA, s5);
        conectorParametroSesion(IVariablesSesion.PARAMETROS_CLAVE_NRO_INTENTOS, s7);
    }

    private boolean validaRango(Property fInicio, Property fFin) throws Exception {
        long lFechaActual = System.currentTimeMillis();
        long lFechaInicio = 0;
        long lFechaFin = 0;
        boolean bRangoValido = true;
        long dia = 24L * 60L * 60L * 1000L;

        if ((fInicio != null) && (fInicio.getValue() != null) && !(fInicio.getValue().equals(""))) {
            lFechaInicio = Long.parseLong(fInicio.getValue().toString());
        }

        if ((fFin != null) && (fFin.getValue() != null) && !(fFin.getValue().equals(""))) {
            lFechaFin = Long.parseLong(fFin.getValue().toString());
        }

        if (lFechaInicio != 0) {
            if (lFechaInicio <= lFechaActual) {
                //rango valido.
            } else {
                bRangoValido = false;
            }
        }

        if (lFechaFin != 0) {
            //Le sumo un dia para compara por las horas de mas en System.currentTimeMillis();
            lFechaFin = lFechaFin + dia;

            if (lFechaActual <= lFechaFin) {
                //rango valido.
            } else {
                bRangoValido = false;
            }
        }

        return bRangoValido;
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    /*
        private void actualizarPropiedadesLocales(String usuario)
            throws Exception
        {
            MareBusinessID marebusinessid = new MareBusinessID("MENActualizarPropiedadesLocales");
            DTOIdentUsuario dtoEntrada = new DTOIdentUsuario();
            dtoEntrada.setCodUsuario(usuario);
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoEntrada);
            paramEntrada.add(marebusinessid);
            DruidaConector conector = conectar("ConectorBusquedaParametrosClave", paramEntrada);
        }
    */
}
