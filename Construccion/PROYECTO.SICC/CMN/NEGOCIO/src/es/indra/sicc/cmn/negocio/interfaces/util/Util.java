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

package es.indra.sicc.cmn.negocio.interfaces.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.IMareMGC;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.cmn.negocio.interfaces.HistoricoLotesLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.Interfaz;
import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.Registro;
import es.indra.sicc.cmn.negocio.interfaces.RegistroAnchoFijo;
import es.indra.sicc.cmn.negocio.interfaces.RegistroConSeparador;
import es.indra.sicc.cmn.negocio.interfaces.Sistema;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.fachada.NumeroLoteLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.DTONotificacion;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.DTONotificacionEmail;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.DTONotificacionRMI;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.DTONotificacionSAPBC;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.DTONotificacionSAPJCO;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.INotificador;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.Notificador;

import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificadorEmail;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificadorRMI;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificadorSAPBC;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificadorSAPJCO;
import java.util.HashMap;
import org.apache.commons.logging.Log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import org.dom4j.io.SAXReader;

import java.io.File;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import es.indra.sicc.util.UtilidadesLog;

/*
 * 05-08-2005 - rgiorgi: inc. BELC300020079
 * */					
public class Util {
    private static final String FLOAT = "java.lang.Float";
    private static final String BIGDECIMAL = "java.math.BigDecimal";
    private static final String COMA_POR_DEFECTO = ",";
    private static Log logMare = null;
    private static IMareMGC mgc = null;
    private static final String FICHERO_INTERFACES = "interfaces.conf";
    private static final String NODOS_SISTEMAS = "//sistemas/sistema";
    private static final String ATTR_ID_SISTEMA = "id";
    private static final String NODOS_INTERFACES = "interfaces/interfaz";
    private static final String ATTR_TIPO = "tipo";
    private static final String ID_SICC = "SICC";

    public Util() {
    }

    public static synchronized Log getMareLog() throws MareException {
        if (logMare == null) {
            try {
                logMare = ((LoggingService) MareMii.getService(new MareTopic(MareMii.SERVICE_LOGGING))).getMareLog();
            } catch (MareMiiServiceNotFoundException ex) {
                System.err.println("Servicio no encontrado: " + MareMii.SERVICE_LOGGING);
                System.err.println(ex);
                throw new MareException("Servicio no encontrado: " + MareMii.SERVICE_LOGGING, ex);
            }
        }

        return logMare;
    }

    public static Logger getLogger(Class clazz, String logLevel) {
        Logger logger = Logger.getLogger(clazz);
        logger.setLevel(Level.toLevel(logLevel));

        return logger;
    }

    public static synchronized Map cargarInterfaces() throws InterfacesException, MareException {
        return Util.obtenerConfiguracionInterfaces();
    }

    public static synchronized IMareMGC getMGC() throws MareException {
        if (mgc == null) {
            try {
                mgc = ((MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC)));
            } catch (MareMiiServiceNotFoundException ex) {
                throw new MareException("Servicio no encontrado: " + MareMii.SERVICE_MGC, ex);
            }
        }

        return mgc;
    }

    private static synchronized Map obtenerConfiguracionInterfaces() throws InterfacesException, MareException {
        Document document = null;

        Map registroInterfaces = new Hashtable();

        mgc = getMGC();

        File pathConf = new File((String) mgc.getProperty(FICHERO_INTERFACES));

        if (!pathConf.exists()) {
            throw new InterfacesException("Fichero de configuración no encontrado: " + pathConf);
        }

        //UtilidadesLog.info( "Archivo de interfaces: " + pathConf );
        SAXReader reader = new SAXReader();

        try {
            document = reader.read(pathConf);
        //} catch (MalformedURLException ex) {
        //    throw new InterfacesException("Fichero de configuración incorrecto: " + pathConf, ex);
        } catch (DocumentException dex) {
            throw new InterfacesException("Error al procesar el archivo de configuración de interfaces", dex);
        }

        String idSistema;
        String claseInterfaz;
        String codigo;
        String logPattern;
        String logLevel;
        String patronNombre = null;
        String formato;
        String nombreCampo = null;
        Class claseCampo = null;
        int ancho = 0;
        int decimales = 0;
        String coma;
        String relleno;
        String separador;
        String rellenoNumerico;
        InterfazDef def = null;
        String tipoNotificador;
        //String direccionEmail;
        Boolean comillas;
        //try {
        Element root = document.getRootElement();

        List sistemas = document.selectNodes(NODOS_SISTEMAS);

        // SISTEMAS
        for (Iterator j = sistemas.iterator(); j.hasNext();) {
            Element sistema = (Element) j.next();
            idSistema = sistema.attributeValue(ATTR_ID_SISTEMA);

            //logMare.info( "idSistema: " + idSistema );
            List listaInterfaces = sistema.selectNodes(NODOS_INTERFACES);


// INTERFACES
interfaces: 
            for (Iterator k = listaInterfaces.iterator(); k.hasNext();) {
                try {
                    def = new InterfazDef();

                    Element interfaz = (Element) k.next();

                    codigo = interfaz.attributeValue("codigo");

                    //logMare.info("codigo: " + codigo );
                    claseInterfaz = interfaz.attributeValue(ATTR_TIPO);

                    //logMare.info("claseInterfaz: " + claseInterfaz);
                    logPattern = interfaz.attributeValue("logPattern");

                    //logMare.info("logPattern: " + interfaz.attributeValue("logPattern"));
                    logLevel = interfaz.attributeValue("logLevel");

                    //logMare.info("logLevel: " + interfaz.attributeValue("logLevel"));
                    patronNombre = interfaz.attributeValue("patronNombre");

                    //logMare.info("patronNombre: " + interfaz.attributeValue("patronNombre"));
                    if (claseInterfaz.toUpperCase().equals(Interfaz.INTERFAZ_ENTRADA)) {
                        def.setSistemaOrigen(new Sistema(interfaz.attributeValue("Sistema")));
                        def.setSistemaDestino(new Sistema(ID_SICC));
                        def.setTipo(Interfaz.INTERFAZ_ENTRADA);
                    } else if (claseInterfaz.toUpperCase().equals(Interfaz.INTERFAZ_SALIDA)) {
                        def.setSistemaOrigen(new Sistema(ID_SICC));
                        def.setSistemaDestino(new Sistema(interfaz.attributeValue("Sistema")));
                        def.setTipo(Interfaz.INTERFAZ_SALIDA);
                    } else {
                        throw new InterfacesException("Tipo de interfaz desconocido: " + claseInterfaz);
                    }

                    def.setCodigo(codigo);
                    def.setNivelLog(logLevel);
                    def.setPatronLog(logPattern);

                    def.setDescripcion(interfaz.attributeValue("desc"));

                    def.setExtension(interfaz.attributeValue("extension"));

                    //logMare.info("extension: " + interfaz.attributeValue("extension"));
                    if (patronNombre == null) {
                        patronNombre = ".*\\." + def.getExtension();
                    }

                    def.setPatronNombreFicheros(patronNombre);

                    Boolean logErrores = new Boolean(interfaz.attributeValue("logErrores"));
                    def.setLogErrores(logErrores.booleanValue());

                    Boolean logTransferencia = new Boolean(interfaz.attributeValue("logTransferencia"));
                    def.setLogTransferencia(logTransferencia.booleanValue());

                    def.setPathBuzonES(interfaz.element("buzonES").getStringValue());

                    //logMare.info("buzonES: " + interfaz.element("buzonES").getStringValue());
                    def.setPathBuzonTemporal(interfaz.element("buzonTemporal").getStringValue());

                    //logMare.info("buzonTemporal: " + interfaz.element("buzonTemporal").getStringValue());
                    def.setPathLog(interfaz.element("buzonLog").getStringValue());

                    //logMare.info("buzonLog: " + interfaz.element("buzonLog").getStringValue());
                    def.setPathBuzonHistorico(interfaz.element("buzonHistorico").getStringValue());

                    //logMare.info("buzonHistorico: " + interfaz.element("buzonHistorico").getStringValue());
                    formato = interfaz.attributeValue("formato");
                    relleno = interfaz.attributeValue("relleno");

                    if (relleno == null) {
                        relleno = " ";
                    }

                    rellenoNumerico = interfaz.attributeValue("rellenoNumerico");

                    if (rellenoNumerico == null) {
                        rellenoNumerico = "0";
                    }

                    separador = interfaz.attributeValue("separador");

                    if (separador == null) {
                        separador = ";";
                    }

					/*
					 * 05-08-2005 - rgiorgi: inc. BELC300020079
					 * */					
					if (separador.equals("\\" + "t")){
						separador = new String("\t");
					}

					if (separador.equals("\\" + "n")){
						separador = new String("\n");
					}
				    try{                        
                       comillas = new Boolean(interfaz.attributeValue("comillas"));
                        def.setComillas(comillas.booleanValue());
                     }catch(NullPointerException npe){
                        def.setComillas(false);
                    }
                    if (formato.equals(Registro.ANCHO_FIJO)) {
                        def.setRegistro(new RegistroAnchoFijo(relleno, rellenoNumerico, def.isComillas()));
                    } else if (formato.equals(Registro.CON_SEPARADOR)) {
                        def.setRegistro(new RegistroConSeparador(separador, relleno, rellenoNumerico, def.isComillas()));

                        //logMare.info("separador: " + interfaz.attributeValue("separador"));
                    } else {
                        String mensaje = "Formato de registro desconocido: " + formato;
                        getMareLog().error(mensaje);
                        throw new InterfacesException(mensaje);
                    }

                    //logMare.info("relleno: " + interfaz.attributeValue("relleno"));
                    //logMare.info("rellenoNumerico: " + interfaz.attributeValue("rellenoNumerico"));
                    // CAMPOS
                    List campos = interfaz.selectNodes("campos/campo");

                    for (Iterator l = campos.iterator(); l.hasNext();) {
                        Element campo = (Element) l.next();
                        nombreCampo = campo.element("nombre").getStringValue();

                        //logMare.info("nombreCampo: " + nombreCampo);
                        claseCampo = Class.forName(campo.element("tipo").getStringValue());

                        //logMare.info("claseCampo: " + claseCampo);
                        try {
                            ancho = Integer.valueOf(campo.element("ancho").getStringValue()).intValue();
                        } catch (NumberFormatException nex) {
                            UtilidadesLog.error("Ancho de campo erróneo");
                            UtilidadesLog.error("Ancho: " + campo.element("ancho").getStringValue());

                            continue interfaces;
                        }

                        //logMare.info("ancho: " + ancho);
                        decimales = 0;
                        coma = null;

                        if (claseCampo.equals(Class.forName(FLOAT)) || claseCampo.equals(Class.forName(BIGDECIMAL))) {
                            try {
                                if (campo.element("decimales") != null) {
                                    decimales = Integer.valueOf(campo.element("decimales").getStringValue()).intValue();
                                } else {
                                    decimales = 0;
                                }
                            } catch (NumberFormatException nex) {
                                UtilidadesLog.error("Número de decimales erróneo");
                                UtilidadesLog.error("Decimales: " + campo.element("decimales").getStringValue());

                                continue interfaces;
                            }

                            //logMare.info("decimales: " + decimales);
                            try {
                                coma = campo.element("comaDecimal").getStringValue();
                            } catch (NullPointerException npex) {
                                coma = COMA_POR_DEFECTO;
                            }

                            //logMare.info("coma: " + coma);
                        }

                        def.getRegistro().addCampo(nombreCampo, claseCampo, ancho, decimales, coma);
                    }

                    // NOTIFICADORES
                    List notificadores = interfaz.selectNodes("notificadores/notificador");
                    getMareLog().info("Antes de los notificadores: "+notificadores);   
                    for (Iterator n = notificadores.iterator(); n.hasNext();) {
                        Element notificadorEle = (Element) n.next();
                        tipoNotificador = notificadorEle.attributeValue("tipo");

                        getMareLog().info("Tipo de notificador: " + tipoNotificador );   
                        DTONotificacion dtoNotificacion=null;
                        Notificador notificador=null;
                        
                        if(INotificador.EMAIL.equals(tipoNotificador)) {
                                getMareLog().info("ENTRA Tipo de notificador EMAIL: "); 
                                dtoNotificacion=new DTONotificacionEmail();
                                
                                //LLENAR EL DTO
                                ((DTONotificacionEmail)dtoNotificacion).setDirCorreo(notificadorEle.element("dir-correo").getStringValue());
                                ((DTONotificacionEmail)dtoNotificacion).setMensaje(notificadorEle.element("mensaje").getStringValue());

                                //CREAR EL NOTIFICADOR
                                getMareLog().info("------CODIGO DE INT: -----"+def.getCodigo()); 
                                dtoNotificacion.setCodigoInt(def.getCodigo());
                                notificador=new NotificadorEmail(dtoNotificacion); 
                        } else if(INotificador.RMI.equals(tipoNotificador)) {
                                getMareLog().info("ENTRA Tipo de notificador RMI: "); 
                                dtoNotificacion=new DTONotificacionRMI();
                                
                                //LLENAR EL DTO
                                String puerto=notificadorEle.element("puerto").getStringValue();
                                if(puerto!=null && puerto!="") {
                                    ((DTONotificacionRMI)dtoNotificacion).setPuerto(Integer.parseInt(puerto));
                                }                                
                                ((DTONotificacionRMI)dtoNotificacion).setServidor(notificadorEle.element("servidor").getStringValue());
                                
                                //CREAR EL NOTIFICADOR
                                dtoNotificacion.setCodigoInt(def.getCodigo());
                                notificador=new NotificadorRMI(dtoNotificacion);                             
                        } else if(INotificador.SAPBC.equals(tipoNotificador)) {
                                getMareLog().info("ENTRA Tipo de notificador SAPBC: ");                         
                                dtoNotificacion=new DTONotificacionSAPBC();
                                
                                //LLENAR EL DTO
                                ((DTONotificacionSAPBC)dtoNotificacion).setBapi(notificadorEle.element("bapi").getStringValue());
                                ((DTONotificacionSAPBC)dtoNotificacion).setContrasena(notificadorEle.element("contrasena").getStringValue());
                                ((DTONotificacionSAPBC)dtoNotificacion).setIdUsuario(notificadorEle.element("usuario").getStringValue());
                                ((DTONotificacionSAPBC)dtoNotificacion).setPaquete(notificadorEle.element("paquete").getStringValue());
                                String puerto=notificadorEle.element("puerto").getStringValue();
                                if(puerto!=null && puerto!="") {
                                    ((DTONotificacionSAPBC)dtoNotificacion).setPuerto(Integer.parseInt(puerto));
                                }  
                                ((DTONotificacionSAPBC)dtoNotificacion).setServidor(notificadorEle.element("servidor").getStringValue());
                                
                                //CREAR EL NOTIFICADOR
                                dtoNotificacion.setCodigoInt(def.getCodigo());
                                notificador=new NotificadorSAPBC(dtoNotificacion);                              
                        } else if(INotificador.SAPJCO.equals(tipoNotificador)) {
                                getMareLog().info("ENTRA Tipo de notificador SAPJCO: "); 
                                dtoNotificacion=new DTONotificacionSAPJCO();
                                
                                //LLENAR EL DTO
                                ((DTONotificacionSAPJCO)dtoNotificacion).setCentro(notificadorEle.element("centro").getStringValue());
                                ((DTONotificacionSAPJCO)dtoNotificacion).setContrasena(notificadorEle.element("contrasena").getStringValue());
                                ((DTONotificacionSAPJCO)dtoNotificacion).setMandante(notificadorEle.element("mandante").getStringValue());
                                ((DTONotificacionSAPJCO)dtoNotificacion).setServidor(notificadorEle.element("servidor").getStringValue());
                                ((DTONotificacionSAPJCO)dtoNotificacion).setUsuario(notificadorEle.element("usuario").getStringValue());
                                ((DTONotificacionSAPJCO)dtoNotificacion).setRepositorio(notificadorEle.element("repositorio").getStringValue());
                                
                                Element eleFunc=notificadorEle.element("funcion");
                                if(eleFunc!=null) {
                                    //Obtener el nombre de la funcion
                                    ((DTONotificacionSAPJCO)dtoNotificacion).setFuncion(eleFunc.attributeValue("funcNombre"));
                                    
                                    //Obtener coleccion de parametros
                                    HashMap funcParamsHM=new HashMap();
                                    List funcParams = notificadorEle.selectNodes("funcion/parametro");
                                    getMareLog().info("Notificador SAPJCO, Num de Parametros de Funcion "+eleFunc.attributeValue("funcNombre")+ "->"+funcParams.size());
                                    for (Iterator nit = funcParams.iterator(); nit.hasNext();) {
                                        Element funcParam = (Element) nit.next();                
                                        funcParamsHM.put(funcParam.attributeValue("parValor"), 
                                                         funcParam.attributeValue("parNombre"));
                                        /*funcParamsHM.put(funcParam.attributeValue("parNombre"), 
                                                         funcParam.attributeValue("parValor"));*/                                                    
                                        getMareLog().info("Notificador SAPJCO, parametro:"+funcParam.attributeValue("parNombre")+"->"+funcParam.attributeValue("parValor"));
                                    }
                                    ((DTONotificacionSAPJCO)dtoNotificacion).setFuncion_parametros(funcParamsHM);
                                }
                                
                                //CREAR EL NOTIFICADOR
                                dtoNotificacion.setCodigoInt(def.getCodigo());
                                notificador=new NotificadorSAPJCO(dtoNotificacion);                               
                        }                        
                                                
                        /*try {*/
                           def.anyadirNotificador(notificador);
                        /*} catch (InterfacesException iex) {
                            UtilidadesLog.error("Error al crear notificador ", iex);
                        }*/
                    }
                } catch (ClassNotFoundException ex) {
                    UtilidadesLog.error("Interfaz no cargada: " + def.getCodigo(), ex);
                    UtilidadesLog.error("Clase desconocida: " + claseCampo);

                    continue;
                }

                registroInterfaces.put(def.getCodigo(), def);
                
                UtilidadesLog.debug("Entrada agregada a registroInterfaces:");
                UtilidadesLog.debug("codigo=" + def.getCodigo());
                UtilidadesLog.debug("descripcion=" + def.getDescripcion());
            }
        }

        return registroInterfaces;
    }

}
