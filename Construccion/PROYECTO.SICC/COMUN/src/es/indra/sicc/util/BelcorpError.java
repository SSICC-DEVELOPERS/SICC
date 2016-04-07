/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.exception.MareMguInvalidCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

import java.lang.reflect.InvocationTargetException;


/**
 * Sistema:           Belcorp
 * Modulo:            COMUN
 * Componente:
 * Fecha:             30/05/2003
 * Observaciones:
 * Descripcion:
 * @version           1.0
 * @autor             Agustin Palacios
 */
public class BelcorpError implements IBelcorpError {
    private static final int UNKNOWN_ERROR = 0;
    private static final String LENGUAJE_ESPANIOL = "es";
    private static final String PAIS_ESPANIA = "ES";
    private static final String INTERNAL_ERROR = "INTERNAL ERROR";

    public BelcorpError() {
    }

    //jrivas 23/10/2008 MIGRACION

    public DTOError obtenerError(Throwable exception, String language,
                                 String country) {
        DTOError dtoError = new DTOError("0", INTERNAL_ERROR);
        boolean encontroORAException = false;
        try {
            dtoError = this.obtenerError(UNKNOWN_ERROR, language, country);

            if (exception instanceof MareException) {
                //UtilidadesLog.debug("obtenerError: es MareException");
                MareException mareException = (MareException)exception;

                Throwable origen = mareException;
                while (origen.getCause() != null) {
                    origen = origen.getCause();
                }

                if (origen instanceof MareMguInvalidCredentials) {
                    UtilidadesLog.debug("obtenerError: es MareMguInvalidCredentials");
                    //utilizo la severidad para informar
                    //que es un error de credenciales por lo
                    //que la session de usuario debe limpiarse: 9999
                    int codigo = ((MareMguInvalidCredentials)origen).getCode();
                    switch (codigo) {
                    case 20003: //expired
                        dtoError = obtenerError(303, language, country);
                        dtoError.setSeveridad(9999);
                        break;
                    case 20004: //low_quality
                        dtoError = obtenerError(301, language, country);
                        dtoError.setSeveridad(0);//no mata sesion
                        break;
                    case 20005: //in_history
                        dtoError = obtenerError(302, language, country);
                        dtoError.setSeveridad(0);//no mata sesion
                        break;
                    case 20006: //TRIES_EXCCEDED
                        dtoError = obtenerError(313, language, country);
                        dtoError.setSeveridad(9999);
                        break;
                    case 20007: //USER_BLOCKED
                        dtoError = obtenerError(306, language, country);
                        dtoError.setSeveridad(9999);
                        break;
                    case 20002: //INVALID
                    default:
                        dtoError = obtenerError(308, language, country);
                        dtoError.setSeveridad(9999);
                    }
                    
                    UtilidadesLog.debug("2-MareMguInvalidCredentials procesada. " +
                                "Codigo: "+dtoError.getCodigoError()+" - "+
                                "Severidad: "+dtoError.getSeveridad()+ " - " +
                                "Descripcion: "+dtoError.getDescripcionError());

                    
                } else {


                    //UtilidadesLog.debug("mareException.getCause()" + mareException.getCause());
                    if (mareException.getCause() != null) {
                        if (mareException.getCause().toString().indexOf("ORA-02292") !=
                            -1) {
                            // Violacion de integrity constraint
                            dtoError = obtenerError(6, language, country);
                            encontroORAException = true;
                        } else if (mareException.getCause().toString().indexOf("ORA-00001") !=
                                   -1) {
                            // Clave Duplicada
                            dtoError = obtenerError(4, language, country);
                            encontroORAException = true;
                        } else if (mareException.getCause().toString().indexOf("ORA-01400") !=
                                   -1) {
                            // Cannot Insert Null
                            dtoError = obtenerError(201, language, country);
                            encontroORAException = true;
                        }
                    }
                    if (!encontroORAException) {
                        //UtilidadesLog.debug("mareException.getCode() " + mareException.getCode());
                        if (mareException.getCode() != -1) {
                            dtoError =
                                    obtenerError(mareException.getCode(), language,
                                                 country);
                        } else {
                            Throwable t = mareException.getCause();
                            if (t != null) {
                                dtoError = obtenerError(t, language, country);
                            } else {
                                dtoError =
                                        this.obtenerError(-1, language, country);
                            }
                        }
                    }

                    if (exception instanceof ExcepcionParametrizada) {
                        //UtilidadesLog.debug("obtenerError: es ExcepcionParametrizada");
                        ExcepcionParametrizada paramEx =
                            (ExcepcionParametrizada)exception;
                        String paramError =
                            paramEx.obtenerErrorParametrizado(dtoError.getDescripcionError());
                        dtoError.setDescripcionError(paramError);
                    }
                }
            } else if (exception instanceof InvocationTargetException) {
                UtilidadesLog.debug("obtenerError: es InvocationTargetException");

                if (((InvocationTargetException)exception).getTargetException() instanceof
                    MareException) {
                    UtilidadesLog.debug("obtenerError: es MareException");

                    Throwable origen =
                        ((InvocationTargetException)exception).getTargetException();
                    while (origen.getCause() != null) {
                        origen = origen.getCause();
                    }

                    if (origen instanceof MareMguInvalidCredentials) {
                        UtilidadesLog.debug("obtenerError: es MareMguInvalidCredentials");

                        //utilizo la severidad para informar
                        //que es un error de credenciales por lo
                        //que la session de usuario debe limpiarse: 9999                        
                        
                        int codigo =
                            ((MareMguInvalidCredentials)origen).getCode();
                        switch (codigo) {
                        case 20003: //expired
                            dtoError = obtenerError(303, language, country);
                            dtoError.setSeveridad(9999);
                            break;
                        case 20004: //low_quality
                            dtoError = obtenerError(301, language, country);
                            dtoError.setSeveridad(0);//no mata la sesion
                            break;
                        case 20005: //in_history
                            dtoError = obtenerError(302, language, country);
                            dtoError.setSeveridad(0);//no mata la sesion
                            break;
                        case 20006: //TRIES_EXCCEDED
                            dtoError = obtenerError(313, language, country);
                            dtoError.setSeveridad(9999);
                            break;
                        case 20007: //USER_BLOCKED
                            dtoError = obtenerError(306, language, country);
                            dtoError.setSeveridad(9999);
                            break;
                        case 20002: //INVALID
                        default:
                            dtoError = obtenerError(308, language, country);
                            dtoError.setSeveridad(9999);
                        }
                        UtilidadesLog.debug("2-MareMguInvalidCredentials procesada. " +
                                    "Codigo: "+dtoError.getCodigoError()+" - "+
                                    "Severidad: "+dtoError.getSeveridad()+ " - " +
                                    "Descripcion: "+dtoError.getDescripcionError());

                    } else {
                        MareException mareException =
                            (MareException)((InvocationTargetException)exception).getTargetException();
                        dtoError =
                                obtenerError(mareException, language, country);
                    }
                }
            }
        } catch (Throwable t) {
            ;
        } finally {
            return dtoError;
        }
    }

    public DTOError obtenerError(Throwable exception) {
        return this.obtenerError(exception, LENGUAJE_ESPANIOL, PAIS_ESPANIA);
    }

    private DTOError obtenerError(int codigoError, String language,
                                  String country) {
        String descError = null;
        DTOError dtoError = new DTOError("0", INTERNAL_ERROR);

        try {
            descError =
                    ErrorManager.getErrorMessage(codigoError, language, country);
            dtoError.setError(String.valueOf(codigoError),
                              ((descError == null) ?
                               ("Error: " + String.valueOf(codigoError)) :
                               descError));

            //Agregado de Gacevedo
            //Se usa MGC para obtener la severidad de error, se plantea
            //que la severidad por defecto sea el codigo 0, el cual no sera
            //necesario que se especifique en el archivo de properties correspondiente
            MareMGC mgc =
                (MareMGC)MareMii.getService(new MareTopic("Configuration"));
            String severidadError =
                (String)mgc.getProperty("Err_" + codigoError);

            if (severidadError == null) {
                severidadError = "0";
            }

            try {
                dtoError.setSeveridad(Integer.parseInt(severidadError));
            } catch (NumberFormatException ex) {
                //               logError(ex);
                dtoError.setSeveridad(0);
            }
        } catch (Exception e) {
            ;
        } finally {
            return dtoError;
        }
    }


}
