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

import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.MareMguAccessException;
import es.indra.mare.common.mgu.exception.MareMguInvalidCredentials;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.men.DTOSFormato;
import es.indra.sicc.mgu.UserIDSICC;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.UtilidadesError;

import java.rmi.RemoteException;

import java.util.HashMap;
import java.util.Vector;

public final class LPSustitucionUsuario extends LPSICCBase {
    private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService";
    String accion = "";

    public LPSustitucionUsuario() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_usuarios_identificar");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
		String usuario = "";
		String usuarioSustituto = "";
        try {
            accion = conectorParametroLimpia("accion", "", true);

            MareCredentials mc = (MareCredentials) conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS);
            HashMap properties = (HashMap) conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);

            if (accion.equals("")) {
                Property userP = (Property) properties.get("UsuarioSustitucion");

                if ((userP == null) || (((String) userP.getValue()) == null)) {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.USR_SUST_NO_EXISTE));
                } else {
                    usuarioSustituto = (String) userP.getValue();
                }

                if (mc.getUser() != null) {
					usuario = mc.getUser().toString();
                    asignarAtributo("VAR", "usuario", "valor", usuario);
                }

                asignarAtributo("VAR", "accion", "valor", "sustitucion");
                asignarAtributo("VAR", "usuarioSustitucion", "valor", usuarioSustituto);
            }

            if (accion.equals("sustitucion")) {
				usuarioSustituto = conectorParametroLimpia("usuarioSustitucion", "", true);
				usuario = conectorParametroLimpia("usuario", "", true);
                asignarAtributo("VAR", "usuarioSustitucion", "valor", usuarioSustituto);
                asignarAtributo("VAR", "usuario", "valor", usuario);
				int usuarioSeleccionado = 0;

                if (conectorParametroLimpia("radioButon", "", true).equals("N")) {
                    usuarioSeleccionado = 1;
                }

				sustitucionUsuario(usuarioSeleccionado, mc, properties);
            }

            getConfiguracionMenu("LPSustitucionUsuario"); //menú secundario
        } catch (Exception ex) {
			traza(ex);
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
            dtoPais.setOidIdioma(new Long(pPaisDefecto.getValue().toString()));
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

    private void sustitucionUsuario(int usuarioSeleccionado, MareCredentials mc, HashMap properties) throws Exception {
        MGUService mgu = null;
        MareCredentials nuevasCredenciales = null;
        try {
            if (usuarioSeleccionado != 0) {
                UserIDSICC sustituto = new UserIDSICC(mc.getUser().toString(), new UserIDSICC((String) ((Property) properties.get("UsuarioSustitucion")).getValue()));
                nuevasCredenciales = new MareCredentials(sustituto, mc.getPassword());

                mgu = (MGUService) MareMii.getService(new MareTopic(NOMBRE_SERVICIO_MGUSERVICE, nuevasCredenciales));

                HashMap propsUser = mgu.getMergedProperties();

                //Obtengo el indicador de Usuario Habilitado.
                final Property pUsuarioHabilitado = (Property) propsUser.get("UsuarioHabilitado");
                final Property pHabilitadoDesde = (Property) propsUser.get("PeriodoValidezFechaDesde");
                final Property pHabilitadoHasta = (Property) propsUser.get("PeriodoValidezFechaHasta");

				final Property userP2 = (Property) propsUser.get("TipoUsuario");
				String tipoUsuar = (String)userP2.getValue();
				if (tipoUsuar.equalsIgnoreCase("BATCH")) {
						throw new MareException(null, null, 
							UtilidadesError.armarCodigoError("312"));
				}

                if (mgu.authenticate()) {
					conectorParametroSesion("DruidaUsuario", sustituto.getSubstitutionUser().toString());
					conectorParametroSesion("DruidaPassword",  mc.getPassword());
					
                    final Property pIdioma = (Property) propsUser.get(IVariablesSesion.IDIOMA);
                    String codigoISO = null;
                    String codigo_ISO = null;

                    if ((pIdioma != null) && !pIdioma.getValue().toString().equals("")) {
                        this.getIdiomas();
                        codigoISO = this.getISO(new Long(pIdioma.getValue().toString()));
						codigo_ISO = this.get_ISO(new Long(pIdioma.getValue().toString()));

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

					propsUser.put(IVariablesSesion.IDIOMA_ISO, 
						new Property(IVariablesSesion.IDIOMA_ISO, codigoISO));
					propsUser.put(IVariablesSesion.IDIOMA__ISO, 
						new Property(IVariablesSesion.IDIOMA__ISO, codigo_ISO));
					conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO, propsUser);

                    conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS, ((usuarioSeleccionado != 0) ? nuevasCredenciales : mc));
					obtenerFormatos(propsUser);

                } else {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.USR_SUST_NO_VALIDO));
                }
            } 

			//uso esta asignacion como flag, no como valor.
			asignarAtributo("VAR", "pantallaInicio", "valor", "InicioBelcorp");
		
			rastreo(); //Se logueo
				
        } catch (RemoteException re) {
            if (re.detail instanceof MareMguInvalidCredentials) {
                MareMguInvalidCredentials mgue = (MareMguInvalidCredentials) re.detail;

                if (mgue.getCode() == MareMguInvalidCredentials.EXPIRED) {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_CADUCADA));
                }

                if (mgue.getCode() == MareMguInvalidCredentials.IN_HISTORY) {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_UTILIZADA));
                }

                if (mgue.getCode() == MareMguInvalidCredentials.LOW_QUALITY) {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_TRIVIAL));
                }
            } else {
                if (re.detail instanceof MareMguAccessException) {
                    throw new MareException(null, null, 
						UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_INVALIDA));
                } else {
                    throw (Exception) re.detail;
                }
            }
        } catch (MareMiiServiceNotFoundException miie) {
            throw new MareException(null, null, 
				UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
        } catch (MareException ex) {
			throw ex;
		} catch (Exception ex) {
            throw new MareException(null, null, 
				UtilidadesError.armarCodigoError(CodigosError.USUARIO_NO_VALIDO));
        } finally {
            if (mgu != null) {
                mgu.shutdown();
            }

            try {
                asignarAtributo("VAR", "nombreDevuelto", "valor", mc.getUser().toString());
            } catch (Exception exf) {
            }
        }
    }

	private boolean validaRango(Property fInicio, Property fFin) throws Exception{

		long lFechaActual = System.currentTimeMillis();
		long lFechaInicio = 0;
		long lFechaFin = 0;
		boolean bRangoValido = true;
		long dia = 24l * 60l * 60l * 1000l;

		if ( fInicio != null && fInicio.getValue() != null && !(fInicio.getValue().equals("")) ){						
			lFechaInicio = Long.parseLong( fInicio.getValue().toString() );
		}

		if ( fFin != null && fFin.getValue()!= null && !(fFin.getValue().equals("")) ){
			lFechaFin = Long.parseLong( fFin.getValue().toString() );
		}


		if ( lFechaInicio!=0 ){
			if ( lFechaInicio <= lFechaActual ) {
				//rango valido.
			} else { bRangoValido = false; }
		}

		if ( lFechaFin!=0 ){
			//Le sumo un dia para compara por las horas de mas en System.currentTimeMillis();
			lFechaFin = lFechaFin+ dia;
			if ( lFechaActual <= lFechaFin ) {
				//rango valido.
			} else { bRangoValido = false; }
		}

		traza("" + bRangoValido);

		return bRangoValido;
	}
}
