/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ape.DTOTipoCajaProducto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

 
public class LPMantenimientoTipoCajaProducto extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPMantenimientoTipoCajaProducto() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - ejecucion ***");
      
        try {
            rastreo();
            setTrazaFichero();

            accion = conectorParametroLimpia("accion", "", true);
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
            traza("  accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + 
                  " / idioma: " + oidIdioma);
            
            if (accion.equals("")) {
                 cargarPagina();
            } else if (accion.equals("insertarTipoCaja")) {
                 insertarTipoCaja();
            } else if (accion.equals("detalle")) {
                 mostrarDetalle();
            }
            
        } catch (Exception e) {
            traza(" --- Excepcion - LPMantenimientoTipoCajaProducto");
            logStackTrace(e);
            traza(" --- accion: " + accion + " / opcionMenu: " + opcionMenu + 
                  " / pais: " + oidPais + " / idioma: " + oidIdioma);
            if (accion.equals("insertarTipoCaja") && opcionMenu.equals("insertar")) {
                cargarPGInsertarTipoCajaProducto();
                asignarAtributo("CTEXTO", "txtCodigoCaja", "valor", conectorParametro("txtCodigoCaja"));
                asignarAtributo("CTEXTO", "txtDescripcion", "valor", conectorParametro("txtDescripcion"));
                preservaHiddensI18n(new Integer(1), "APP_TIPO_CAJA_PRODU", "formulario", "txtDescripcion", false);
            }
            
            lanzarPaginaError(e);
        }
           
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - ejecucion ***");
    }
    
    
    public void cargarPagina() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - cargarPagina ***");
        
        opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        traza("    opcionMenu: " + opcionMenu);
        
        if (opcionMenu.equals("insertar")) {
            cargarPGInsertarTipoCajaProducto();
            anyadeHiddensI18N(false, "APP_TIPO_CAJA_PRODU", null, new Integer(1), "formulario", "txtDescripcion", false);
        } else if (opcionMenu.equals("consultar") || opcionMenu.equals("modificar") || opcionMenu.equals("eliminar")) {
            cargarPGConsultarTipoCajaProducto();
        }
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - cargarPagina ***");
    }
    
    
    public void insertarTipoCaja() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - insertarTipoCaja ***");
        
        DTOTipoCajaProducto dto = this.crearDTOTipoCajaProducto();
        MareBusinessID businessID = new MareBusinessID("APEInsertarTipoCajaProducto");
        
        Vector parametros = new Vector();
        parametros.add(dto);  
        parametros.add(businessID);
        
        conectar("ConectorInsertarTipoCajaProducto", parametros);
        
        cargarPGInsertarTipoCajaProducto();
        anyadeHiddensI18N(false, "APP_TIPO_CAJA_PRODU", null, new Integer(1), "formulario", "txtDescripcion", false);
        
        if(opcionMenu.equals("modificar")) {
            asignarAtributo("VAR", "cerrar", "valor", "S");
		}
        
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - insertarTipoCaja ***");
    }
    
    
    public void mostrarDetalle() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - mostrarDetalle ***");
        String sOidTipoCajaProducto         = conectorParametroLimpia("oidTipoCajaProdu", "", true);
        String sCodigoTipoCajaProducto      = conectorParametroLimpia("codigoTipoCajaProdu", "", true);
        String sDescripcionTipoCajaProducto = conectorParametroLimpia("descripcionTipoCajaProdu", "", true);


        traza("    TipoCajaProducto oid_" + sOidTipoCajaProducto + " codigo_" + sCodigoTipoCajaProducto +
              " descripcion_" + sDescripcionTipoCajaProducto);
        
        cargarPGInsertarTipoCajaProducto();

        asignarAtributo("VAR",    "oidTipoCaja",    "valor", sOidTipoCajaProducto);
        asignarAtributo("CTEXTO", "txtCodigoCaja",  "valor", sCodigoTipoCajaProducto);
        asignarAtributo("CTEXTO", "txtDescripcion", "valor", sDescripcionTipoCajaProducto);  // Internacionalizable

        boolean soloLectura;
        asignarAtributoElemento("txtCodigoCaja", "disabled", "S"); // Deshabilita el campo siempre

        if (opcionMenu.equals("modificar")) {
            asignarAtributo("VAR", "hDescripcion", "valor", sDescripcionTipoCajaProducto);  // Memoria de fLimpiar
            soloLectura = false;
        } else { // consultar eliminar
            asignarAtributoElemento("txtDescripcion", "disabled", "S"); // Deshabilita
            soloLectura = true;
        }
        
        anyadeHiddensI18N(true, "APP_TIPO_CAJA_PRODU", new Long(sOidTipoCajaProducto), new Integer(1), 
                          "formulario", "txtDescripcion", soloLectura);
        
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - mostrarDetalle ***");
    }
    
    
    private DTOTipoCajaProducto crearDTOTipoCajaProducto() throws Exception {
        DTOTipoCajaProducto dto = new DTOTipoCajaProducto();
        
        dto.setOidPais(oidPais);
        dto.setOidIdioma(oidIdioma);
        
        Vector traducciones = recuperaTraduccionesI18N(new Integer(1));
        
        if (opcionMenu.equals("insertar")) {
            dto.setOid(null);
            traducciones = quitarTraduccionesEnBlanco(traducciones);
        } else {
            String sOidTipoCaja = conectorParametroLimpia("oidTipoCaja", "", true); // VAR de pagina insertar
            dto.setOid(Long.valueOf(sOidTipoCaja));
        }
        
        dto.setCodigoCaja(conectorParametroLimpia("txtCodigoCaja", "", true));
        dto.setDescripcion(conectorParametroLimpia("txtDescripcion", "", true)); // Viene la descripcion con el idioma cargado inicialmente
        
        dto.setAttriTraducible(traducciones);
        traza(" el dto DTOTipoCajaProducto creado es: " + dto);
        return dto;
    }
        
    private void cargarPGConsultarTipoCajaProducto()throws Exception {
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - cargarPGConsultarTipoCajaProducto ***");
        
        pagina("contenido_tipos_caja_prod_modificar");
        this.getFormatosValidaciones();
        
        if (opcionMenu.equals("consultar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "consultar");
            asignarAtributoPagina("cod","01057");
        } else if (opcionMenu.equals("modificar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "modificar");
            asignarAtributoPagina("cod","01058");
        } else if (opcionMenu.equals("eliminar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "eliminar");
            asignarAtributoPagina("cod","01059");
        }
        
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());                        
        
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - cargarPGConsultarTipoCajaProducto ***");
    }


    private void cargarPGInsertarTipoCajaProducto()throws Exception{
        traza("*** Entrada - LPMantenimientoTipoCajaProducto - cargarPGInsertarTipoCajaProducto ***");
        pagina("contenido_tipos_caja_prod_insertar");
        this.getFormatosValidaciones();
        
        if (opcionMenu.equals("insertar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "insertar");
            asignarAtributoPagina("cod","01056");
        } else if (opcionMenu.equals("consultar") || opcionMenu.equals("eliminar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "detalle");
            asignarAtributoPagina("cod","01060");
        } else if (opcionMenu.equals("modificar")) {
            getConfiguracionMenu("LPMantenimientoTipoCajaProducto", "modificarDetalle");
            asignarAtributoPagina("cod","01058");
        }
        
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());                        
        
        traza("*** Salida  - LPMantenimientoTipoCajaProducto - cargarPGInsertarTipoCajaProducto ***");
    }
    
    
    /**
     * Limpieza de descripciones internacionalizables en blanco. Quitamos los
     * dto de los idiomas que no tienen una descripcion para que no se
     * inserte en blanco ya que sino no funciona la recuperacion de la
     * descripcion por defecto cuando no se guardo una alternativa.
     */
    private Vector quitarTraduccionesEnBlanco(Vector traducciones) throws Exception {
            ArrayList traduccionesEnBlanco = new ArrayList();
            traza(" traducciones antes_" + traducciones);
            
            Iterator iter = traducciones.iterator();
            
            while (iter.hasNext()) {
                DTOI18nSICC i18n = (DTOI18nSICC) iter.next();
                String descripcionI18n = (String)i18n.getValorI18n();
                
                if (descripcionI18n == null || descripcionI18n.equals(" ")) {
                    traduccionesEnBlanco.add(i18n);
                }
            }
            traducciones.removeAll(traduccionesEnBlanco);
            traza(" traducciones despues_" + traducciones);
            return traducciones;
    }
    
    
    private String getDescripcionI18N(Vector vec, Long idioma) throws Exception {
        Iterator iter = vec.iterator();

        while (iter.hasNext()) {
            DTOI18nSICC dtoI18 = (DTOI18nSICC)iter.next();
            
            if (dtoI18.getOidIdioma().equals(idioma)) {
                return dtoI18.getValorI18n();
            }
        }
        return "";
    }
    
    
    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }
    
}

