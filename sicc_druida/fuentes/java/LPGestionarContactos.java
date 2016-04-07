/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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



//~--- non-JDK imports --------------------------------------------------------

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.logicanegocio.cal.ConstantesCAL;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;

//~--- JDK imports ------------------------------------------------------------

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Vector;

public class LPGestionarContactos extends LPSICCBase {
    private String accion      = null;
    private String casoDeUso   = null;
    private String oidContacto = null;
    private Long   idioma;
    private Long   pais;

//  Definicion del constructor
    public LPGestionarContactos() {
        super();
    }

//  Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

//      Defino el nombre de la vista
        pagina("contenido_contactos_gestionar");
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

        // rastreo();
        try {
            setTrazaFichero();
            traza("***Entrada - LPGestionarContactos - ejecucion***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais   = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", idioma.toString());
            asignar("VAR", "pais", pais.toString());
            this.accion    = conectorParametroLimpia("accion", "", true);
            this.casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
            asignar("VAR", "accion", this.accion);
            asignar("VAR", "casoDeUso", this.casoDeUso);
            traza("***accion : " + this.accion);
            traza("***caso de uso : " + this.casoDeUso);
            getConfiguracionMenu("LPGestionarContactos", "");

            // Bifurcamos la accion
            if (accion.equals("")) {
                cargaInicial();
            } else if (accion.equals("ejecutar")) {
                ejecutarMotivo();
            } else if (accion.equals("recuperarSesion")) {
                recuperarSesion();
            }

            traza("***Salida - LPGestionarContactos - ejecucion***");
        } catch (Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }

    private void cargaInicial() throws Exception {
        try {
            traza("***Entrada - LPGestionarContactos - cargaInicial***");
            asignarAtributo("PAGINA", "contenido_contactos_gestionar", "msgle", "Gestionar contactos");
            asignar("VAR", "casoDeUso", conectorParametroLimpia("casoDeUso", "", true));
            traza("********** caso>uso pestaña: " + conectorParametroLimpia("casoDeUso", "", true));

            /*
             * if (!conectorParametroLimpia("casoDeUso", "", true).equals("Presentar"))
             *       asignarAtributo("PAGINA", "contenido_contactos_gestionar", "cod", "0559");
             */
            this.generarHiddenFormatoFecha();

            // Los parámetros recibidos se cargan en las variables ocultas de la pantalla:
            String oidCliente           = conectorParametroLimpia("oidCliente", "", true);
            String codCliente           = conectorParametroLimpia("codCliente", "", true);
            String oidTipoCliente       = conectorParametroLimpia("oidTipoCliente", "", true);
            String oidContacto          = conectorParametroLimpia("oidContacto", "", true);
            String indConsultoraInterna = conectorParametroLimpia("indConsultoraInterna", "", true);

            // Ariel D. agregado por incidencia CAL-04
            String oidSubTipoCliente = conectorParametroLimpia("oidSubTipoCliente", "", true);

            // quitar despues
            // if (oidCliente.equals("")) oidCliente = "1";
            // if (oidTipoCliente.equals("")) oidTipoCliente = "4";
            traza("-------------- oidCliente: " + oidCliente);
            traza("-------------- codCliente: " + codCliente);
            traza("-------------- oidTipoCliente: " + oidTipoCliente);
            asignar("VAR", "oidCliente", oidCliente);
            asignar("VAR", "codCliente", codCliente);
            asignar("VAR", "oidTipoCliente", oidTipoCliente);
            asignar("VAR", "oidContacto", oidContacto);
            asignar("VAR", "indConsultoraInterna", indConsultoraInterna);

            // Ariel D. agregado por incidencia CAL-04
            asignar("VAR", "oidSubTipoCliente", oidSubTipoCliente);

            // Se crea un DTOOID (dtoe)
            DTOOID dtoe = new DTOOID();

            dtoe.setOidPais(pais);
            dtoe.setOidIdioma(idioma);
            dtoe.setOid(new Long(oidCliente));

            // Se invoca el conector ConectorObtenerZonaMarcaCanal
            MareBusinessID idNegocio     = new MareBusinessID("CALObtenerZonaMarcaCanal");
            Vector         paramsEntrada = new Vector();

            paramsEntrada.add(dtoe);
            paramsEntrada.add(idNegocio);
            traza("Antes de ConectorObtenerZonaMarcaCanal");

            DruidaConector conector = conectar("ConectorObtenerZonaMarcaCanal", paramsEntrada);

            traza("Despues de ConectorObtenerZonaMarcaCanal");

            // Con el primer registro obtenido en DTOSalida.resultado, se cargan las variables ocultas de la pantalla:
            DTOSalida dtoSalida = (DTOSalida) conector.objeto("DTOSalida");

            /*
             * Long oidMarca = new Long (((BigDecimal)dtoSalida.getResultado().getValueAt(0,"oidMarca")).longValue());
             * Long oidCanal = new Long (((BigDecimal)dtoSalida.getResultado().getValueAt(0,"oidCanal")).longValue());
             * Long oidZona = new Long (((BigDecimal)dtoSalida.getResultado().getValueAt(0,"oidZona")).longValue());
             */
            Long oidMarca = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, 0)).longValue());    // oidMarca
            Long oidCanal = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, 1)).longValue());    // oidCanal
            Long oidZona  = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, 2)).longValue());    // oidZona

            // Ariel D. agregado por incidencia CAL-05
			// vbongiov -- 4/12/2008 -- Eliminado por migracion 
            //Long oidPeriodo = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, "oidPeriodo")).longValue());

            traza("Marca: " + oidMarca);
            traza("Canal: " + oidCanal);
            traza("Zona: " + oidZona);

            // Ariel D. agregado por incidencia CAL-05
            asignar("VAR", "oidMarca", oidMarca.toString());
            asignar("VAR", "oidCanal", oidCanal.toString());
            asignar("VAR", "oidZona", oidZona.toString());

            // Ariel D. agregado por incidencia CAL-05
			// vbongiov -- 4/12/2008 -- Eliminado por migracion 
            asignar("VAR", "oidPeriodo", "");

            DTOPeriodo dtoPeriodo = new DTOPeriodo();

            dtoPeriodo.setPais(this.pais);
            dtoPeriodo.setOidPais(this.pais);
            dtoPeriodo.setMarca(oidMarca);
            dtoPeriodo.setCanal(oidCanal);

            ComposerViewElementList listElement = new ComposerViewElementList();
            ComposerViewElement     elem1       = new ComposerViewElement();

            elem1.setIDBusiness("CRAObtienePeriodos");
            elem1.setDTOE(dtoPeriodo);
            elem1.setPosOID((byte) 0);
            elem1.setPosDesc((byte) 1);
            listElement.addViewElement(elem1);
            traza("elemento añadido");

            // llamar al subsistema GestorCargaPantalla
            ConectorComposerView conectorComposer = new ConectorComposerView(listElement, this.getRequest());

            traza("conector creado");
            conectorComposer.ejecucion();
            traza("ejecutado");

            DruidaConector conConsultar = conectorComposer.getConector();

            traza("Obtener conConsultar");
            asignar("COMBO", "cbPeriodo", conConsultar, "CRAObtienePeriodos");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }

        traza("***Salida - LPGestionarContactos - ejecucion***");
    }

    private void ejecutarMotivo() throws Exception {
        try {
            traza("***Entrada - LPGestionarContactos - ejecutarMotivo***");
            pagina("salidaGenerica");
            asignar("VAR", "cerrarVentana", "false");

            DTOCliente dtoe = new DTOCliente();

            dtoe.setOidPais(this.pais);
            dtoe.setOidIdioma(this.idioma);

            String oidMotivoContacto = conectorParametroLimpia("oidMotivoContacto", "", true);

            traza(" oidMotivoContacto:   " + oidMotivoContacto);
            dtoe.setOidMotivoContacto(new Long(oidMotivoContacto));

            String oidCliente     = conectorParametroLimpia("oidCliente", "", true);
            String oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
            String codProceso     = conectorParametroLimpia("codProceso", "", true);

            traza(" oidCliente: " + oidCliente);
            traza(" oidTipoCliente: " + oidTipoCliente);
            traza(" codProceso: " + codProceso);
            dtoe.setOidCliente(new Long(oidCliente));
            dtoe.setOidTipoCliente(new Long(oidTipoCliente));

            MareBusinessID idNegocio     = new MareBusinessID("CALGuardarContacto");
            Vector         paramsEntrada = new Vector();

            paramsEntrada.add(dtoe);
            paramsEntrada.add(idNegocio);
            traza("Antes de ConectorGuardarContacto");

            DruidaConector conector = conectar("ConectorGuardarContacto", paramsEntrada);

            traza("Despues de ConectorGuardarContacto");

            DTOOID dtoOID = (DTOOID) conector.objeto("DTOOID");

            this.oidContacto = dtoOID.getOid().toString();

            // asignar("VAR", "oidContacto", this.oidContacto);
            if ((codProceso != null) && (!codProceso.equals(""))) {
                this.ejecutarProceso(codProceso);
            }    /*
                  * else { comentado por incidencia 21402 - dmaneiro - 05/01/2006
                  *     asignarAtributo("PAGINA","salidaGenerica","onload","window.returnValue="+this.oidContacto+";window.close();");
                  *     //asignar("VAR", "ejecutar", "noDisponible();");
                  *
                  * }
                  */

            traza("***Salida - LPGestionarContactos - ejecutarMotivo***");
        } catch (Exception e) {
            asignarAtributo("PAGINA", "salidaGenerica", "onload",
                            "cdos_mostrarAlert(GestionarMensaje('1458'));window.returnValue=-1;window.close();");
            e.printStackTrace();
            logStackTrace(e);

//          lanzarPaginaError(e);
        }
    }

    private void ejecutarProceso(String codProceso) throws Exception {
        try {
            traza("***Entrada - LPGestionarContactos - ejecutarProceso***");
            pagina("salidaGenerica");
            asignar("VAR", "cerrarVentana", "false");
			
            String codCliente = conectorParametroLimpia("codCliente", "", true);
			
            traza("codCliente para pasar hacia otro CU es_" + codCliente);
			traza("codProceso: " + codProceso);	
            // El nombre de la LP a la que hay que llamar está en la variable de entrada codProceso
            if (codProceso.equals(ConstantesCAL.COD_PROCESO_COMPRA)) {
                conectorAction(codProceso);
                conectorActionParametro("pais", this.pais.toString());
				

                String oidCliente = conectorParametroLimpia("oidCliente", "", true);

                conectorActionParametro("oidCliente", oidCliente);
                conectorActionParametro("accion", "callcenter");
            } else if (codProceso.equals(ConstantesCAL.COD_PROCESO_INGRESAR_RECLAMO)) {
                conectorAction(codProceso);
                conectorActionParametro("accion", "insertar_menu_principal");
            } else if (codProceso.equals(ConstantesCAL.COD_PROCESO_CONSULTAR_MENSAJES)) {
                conectorAction(codProceso);
                conectorActionParametro("accion", "");
                conectorActionParametro("opcionMenu", ConstantesCAL.OPCION_MENU_CONSULTAR_MENSAJES);
                conectorActionParametro("codigoCliente", codCliente);                        // DBLG700000144
                conectorActionParametro("casoDeUso", "Consulta Mensajes por Consultora");    // DBLG700000144
            } else if (codProceso.equals("LPBusquedaCliente")) {
                conectorAction(codProceso);
                conectorActionParametro("accion", "");
                conectorActionParametro("casoDeUso", "consultar");
			//CCC-04 jrivas 29/7/2008
			} else if (codProceso.equals("CCCConsultaCC")) {
                conectorAction(codProceso);
                conectorActionParametro("accion", "generarConsulta");
                conectorActionParametro("codigoConsultora", codCliente);
                conectorActionParametro("casoDeUso", "");
               /// vbongiov -- INC-014 -- 6/09/2008
			} else if (codProceso.equals("LPConsultaGeneralConcurso")) {
                conectorAction(codProceso);
                conectorActionParametro("accion", "gestionarContacto");
                conectorActionParametro("codigoCliente", codCliente);                        
            
            } else {
                conectorAction(codProceso);

                String oidCliente     = conectorParametroLimpia("oidCliente", "", true);
                String oidTipoCliente = conectorParametroLimpia("oidTipoCliente", "", true);
                String periodo        = conectorParametroLimpia("oidPeriodo", "", true);
                String marca          = conectorParametroLimpia("oidMarca", "", true);
                String canal          = conectorParametroLimpia("oidCanal", "", true);
                String zona           = conectorParametroLimpia("oidZona", "", true);

                // Agregado por incidencia CAL-04
                String oidSubTipoCliente    = conectorParametroLimpia("oidSubTipoCliente", "", true);
                String indConsultoraInterna = conectorParametroLimpia("indConsultoraInterna", "", true);

                // fin agregado
                traza(" recogidos los valores de la pagina; oidCliente: " + oidCliente);
				traza(" ");
                traza("pasandole parametros a la LP que se llama");
                conectorActionParametro("accion", "");
                conectorActionParametro("pais", this.pais.toString());
                conectorActionParametro("oidCliente", oidCliente);
                conectorActionParametro("codCliente", codCliente);    // DBLG700000144
                conectorActionParametro("oidTipoCliente", oidTipoCliente);
                conectorActionParametro("oidPeriodo", periodo);
                conectorActionParametro("oidMarca", marca);
                conectorActionParametro("oidCanal", canal);
				traza("77777777ATT oidZona: " + zona);
                conectorActionParametro("oidZona", zona);
                conectorActionParametro("oidContacto", this.oidContacto);

                // conectorActionParametro("esModal", "true");  //Para manejar MenuSecundario Inc.BELC300018493

                // Agregado por incidencia CAL-04
                conectorActionParametro("oidSubTipoCliente", oidSubTipoCliente);
                conectorActionParametro("indConsultoraInterna", indConsultoraInterna);

                // fin agregado
                traza("parametros pasados");
            }

            /* Se bloquea la ejecución hasta el cierre de la ventana emergente */

            // Se muestra la pantalla emergente y modal de actualizar estado contacto (PGEstadoContacto)
            traza("***Salida - LPGestionarContactos - ejecutarProceso***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }

    // Agregado por incidencia 21402 - dmaneiro - 05/01/2006
    protected void recuperarSesion() throws Exception {
        try {
            traza("***Entrada - LPGestionarContactos - recuperarSesion***");
            pagina("salidaGenerica");
            asignar("VAR", "cerrarVentana", "false");

            String oidContacto          = conectorParametroSesion("oidContacto").toString();
            String recuperarOidContacto = "oidRecuperado('" + oidContacto + "');";

            traza("recuperarOidContacto" + recuperarOidContacto);
            asignarAtributo("VAR", "ejecutar", "valor", recuperarOidContacto);
            traza("***Salida - LPGestionarContactos - recuperarSesion***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
        }
    }

    protected void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream           ps   = new PrintStream(baos);

        e.printStackTrace(ps);
        traza("Stack Trace: " + baos.toString());
    }
}
