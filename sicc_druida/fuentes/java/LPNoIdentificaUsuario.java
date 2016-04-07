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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;

import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.BelcorpError;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.*;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.sicc.dtos.men.DTOSFormato;
import es.indra.sicc.dtos.seg.ParametrosClaveDTO;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;

import java.rmi.RemoteException;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.AuthenticationException;

import javax.servlet.http.HttpSession;


public final class LPNoIdentificaUsuario extends LPSICCBase {
    private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService"; //Nombre del servicio de MGU.
    private String accion = "";
    private String usuario = "usuario1";
    private String contrasenia = "belcorp";
	private HashMap propiedasdesMGU;

    public LPNoIdentificaUsuario() {
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
/*            usuario = conectorParametroLimpia("usuario", "", true);
            contrasenia = conectorParametroLimpia("contrasenia", "", true); */

            if (accion.equals("")) {
                final Enumeration nombres = this.getRequest().getSession().getAttributeNames();
                final HttpSession mySesion = this.getRequest().getSession();

                while (nombres.hasMoreElements()) {
                    mySesion.removeAttribute((String) nombres.nextElement());
                }

                //recupero parametros de clave.
                //recuperarParametrosClave();
            } 

			if (accion.equals("validar")) {
                    validaUsuario(usuario, contrasenia);
            }
			
        } catch (Exception ex) {
            asignarAtributo("VAR", "nombreDevuelto", "valor", "" + usuario);
			lanzarPaginaError(ex);
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
        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_DECIMALES, (String) dtoSalida.getSeparadorDecimal());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_DECIMALES, pTmp);
        pTmp = new Property(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_MILES, (String) dtoSalida.getSeperadorMiles());
        propsUser.put(IVariablesSesion.FORMATO_NUMERICO_SEPARADOR_MILES, pTmp);
    }

    private void validaUsuario(final String usuario, final String contrasenia) throws java.lang.Exception {
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

            if (mgu.authenticate()) {

				conectorParametroSesion("DruidaUsuario", usuario);
				conectorParametroSesion("DruidaPassword", contrasenia);		

				propiedasdesMGU =  mgu.getMergedProperties();
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

                if ((pIdioma != null) && !pIdioma.getValue().toString().equals("")) {
                    //setea la Collection de idiomas.
                    this.getIdiomas();

                    //obtengo el iso buscando en la collection
                    codigoISO = this.getISO(new Long(pIdioma.getValue().toString()));

                    //SetDruidaLang
                    setIdioma(codigoISO); //obtengo iso y seteo 
                }

                //**** Validación de usuario habilitado. ****//
                if ((pUsuarioHabilitado != null) && (pUsuarioHabilitado.getValue() != null) && pUsuarioHabilitado.getValue().toString().equals("N")) {
                    //asignarAtributo("VAR", "validado", "valor", "N");
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.USUARIO_DESHABILITADO));
                } else {

                    //**** INI - Valido el rango de fechas de habilitación ****//
					if ( validaRango(pHabilitadoDesde, pHabilitadoHasta) == false){

	                    throw new MareException(null, null, 
							UtilidadesError.armarCodigoError(CodigosError.USUARIO_DESHABILITADO));
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
                    HashMap propsUser = propiedasdesMGU;

                    if (propsUser != null) {
                        propsUser.put(IVariablesSesion.IDIOMA_ISO, 
							new Property(IVariablesSesion.IDIOMA_ISO, codigoISO));
                        conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO, propsUser);

                        //Agrego las propiedades de Formatos.
                        obtenerFormatos(propsUser);
                    }

                    if ((userP == null) || ((String) userP.getValue() == null)) {
                        status = "S";
                    } else {
						//**** INI - Valido rango de fecha de sustitucion ****//
						if ( validaRango( pSustitucionDesde, pSustitucionHasta) == true){
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
						traza("Exception :" + e.getClass().getName());
					}

                    asignarAtributo("VAR", "validado", "valor", status);
                } else {
                    asignarAtributo("VAR", "validado", "valor", "E");
                }

            } else {
                traza("despues de authenticate.. false");
                mgu.shutdown();
                throw new MareException(null, null, 
					UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
            }
       } catch(RemoteException re){   
    		  traza("RemoteException: " + re);
           OrionRemoteException or = (OrionRemoteException)re;   
           re = ((RemoteException)or.getOriginal());   
   
           if(re.detail instanceof MareMguInvalidCredentials){   

              final MareMguInvalidCredentials mgue = (MareMguInvalidCredentials)re.detail;
              traza("MareMguInvalidCredentials:" + mgue);
              
              if(mgue.getCode() == MareMguInvalidCredentials.EXPIRED){   
                  asignarAtributo("VAR", "validado", "valor", "E");
				  throw new MareException(null,null,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_CADUCADA));
              } else{   
                  asignarAtributo("VAR", "errCodigo", "valor", "" + mgue.getCode());   
                  asignarAtributo("VAR", "errDescripcion", "valor", "" + mgue.toString());   
              }   
           } else{   

              if(re.detail instanceof MareMguAccessException){   
						traza("MareMguAccessException : " + re.detail);
                  asignarAtributo("VAR", "errCodigo", "valor", "");   
                  asignarAtributo("VAR", "errDescripcion", "valor", "ERR_45");   
              } else{   

                  asignarAtributo("VAR", "errCodigo", "valor", "");   
                  asignarAtributo("VAR", "errDescripcion", "valor", "" + re.detail.toString());   
              }   
           }            
        } catch (MareMiiServiceNotFoundException miie) {
            traza("MareMiiServiceNotFoundException: " + miie.toString());
            MareException me = new MareException(null, null, 
				UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
            asignarAtributo("VAR", "validado", "valor", "N");
            lanzarPaginaError(me);
        } catch (MareException me) {
            traza("MareException: " + me.toString());
			asignarAtributo("VAR", "validado", "valor", "N");
			lanzarPaginaError(me);
        } catch (Exception ex) {
            asignarAtributo("VAR", "errCodigo", "valor", "");
            asignarAtributo("VAR", "errDescripcion", "valor", ex.getMessage());
        } finally {
            try {
                if (mgu != null) { mgu.shutdown(); }
                asignarAtributo("VAR", "nombreDevuelto", "valor", usuario);
            } catch (Exception exf) {}
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

	private boolean validaRango(Property fInicio, Property fFin) throws Exception{

		long lFechaActual = System.currentTimeMillis();
		long lFechaInicio = 0;
		long lFechaFin = 0;
		boolean bRangoValido = true;

		if ( fInicio != null && fInicio.getValue() != null && !(fInicio.getValue().equals("")) ){						
			lFechaInicio = Long.parseLong( fInicio.getValue().toString() );
		}

		if ( fFin != null && fFin.getValue()!= null && !(fFin.getValue().equals("")) ){
			lFechaFin = Long.parseLong( fFin.getValue().toString() );
		}

		if ( lFechaInicio!=0 ){
			if ( lFechaInicio < lFechaActual ) {
				//rango valido.
			} else { bRangoValido = false; }
		}

		if ( lFechaFin!=0 ){
			if ( lFechaActual < lFechaFin ) {
				//rango valido.
			} else { bRangoValido = false; }
		}

		traza("" + bRangoValido);

		return bRangoValido;
	}

}
