import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;

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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.math.BigDecimal;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.StringTokenizer;
import java.util.Vector;


public class LPMantenimientoFactoresConversion extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;
    private Long idioma;
    private Long pais;

    public LPMantenimientoFactoresConversion() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            this.setTrazaFichero();
            this.traza("LPMantenimientoFactoresConversion.ejecucion(): Entrada");
            this.rastreo();

            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);

            if (accion.equals("")) {
                inicializar();
            } else if (accion.equals("guardar")) {
                // invocar al metodo guardar 
                guardar();
            } else if (accion.equals("modificar")) {
                this.pagina("contenido_factores_conversion_insertar");
                // Configurar titulo de caso de uso
                if (opcionMenu.equals("ConsultarFactoresConversion")) {
                    this.traza("ConsultarFactoresConversion");
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.query.label");
                } else if (opcionMenu.equals("ModificarFactoresConversion")) {
                    this.traza("ModificarFactoresConversion");
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.update.label");
                } else if (opcionMenu.equals("EliminarFactoresConversion")) {
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.remove.label");
                }
                this.getConfiguracionMenu("LPMantenimientoFactoresConversion", "modificarDetalle");
                // cargar los valores
                cargaValores();
            } else if (accion.equals("detalle")) {
                this.pagina("contenido_factores_conversion_insertar");
                // Configurar titulo de caso de uso
                if (opcionMenu.equals("ConsultarFactoresConversion")) {
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.query.label");
                    
                } else if (opcionMenu.equals("ModificarFactoresConversion")) {
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.update.label");
                } else if (opcionMenu.equals("EliminarFactoresConversion")) {
                    this.asignarAtributoPagina("cod","ApeFactoresConversion.remove.label");
                }
                this.getConfiguracionMenu("LPMantenimientoFactoresConversion","detalle");
                // cargar los valores
                cargaValores();
            }
            this.getFormatosValidaciones();

            this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
            this.asignarAtributo("VAR", "accion", "valor", accion);
            this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
            this.asignarAtributo("VAR", "varPais", "valor", pais.toString());
            this.asignarAtributo("VAR", "hCantidadDecimalesPais", "valor", "3");

            this.traza("LPMantenimientoFactoresConversion.ejecucion(): Salida");
        } catch (Exception e) {
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }
    }

    private void inicializar() throws Exception {
        if (opcionMenu.equals("InsertarFactoresConversion")) {
            this.pagina("contenido_factores_conversion_insertar");
            this.asignarAtributoPagina("cod","ApeFactoresConversion.create.label");
            this.getConfiguracionMenu("LPMantenimientoFactoresConversion","Guardar");
            cargarPGInsertarFactoresConversion();
        } else if (opcionMenu.equals("ConsultarFactoresConversion") || opcionMenu.equals("ModificarFactoresConversion") || opcionMenu.equals("EliminarFactoresConversion")) {
            cargarPGConsultarFactoresConversion();
        }
    }

    private void cargarPGInsertarFactoresConversion() throws Exception {
        //cargarCombos();
        // Creamos lista composerView
        ComposerViewElementList listElement = new ComposerViewElementList();
        // Creamos DTOBelcorp
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(pais);
        dtoe.setOidIdioma(idioma);
        // Carga los Centros de Distribucion
        ComposerViewElement elem1 = new ComposerViewElement();
        elem1.setIDBusiness("APEObtenerMagnitudes");
        elem1.setDTOE(dtoe);
        elem1.setPosOID((byte) 0);
        elem1.setPosDesc((byte) 1);
        listElement.addViewElement(elem1);
        //Llamar al subsistema GestorCargaPantalla
        ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
        traza("conector creado");
        conector.ejecucion();
        traza("ejecutado");
        DruidaConector conConsultar = conector.getConector();
        traza("Obtener conConsultar");
        asignar("COMBO", "cbMagnitud", conConsultar, "APEObtenerMagnitudes");
        /*
                Si accion == "modificar"
                Se deshabilitan los siguientes campos:
                - Deshabilita cbMagnitud
                - Deshabilita cbUnidadMedidaOrigen
                - Deshabilita cbUnidadMedidaDestino
                Fin si

                Mostrar la página PGInsertarFactoresConversion pasándole además:
                - accion
                - opcionMenu

        */
    }

    private void cargarPGConsultarFactoresConversion() throws Exception {
        this.pagina("contenido_factores_conversion_modificar");
        // Configurar titulo de caso de uso
        if (opcionMenu.equals("ConsultarFactoresConversion")) {
            this.getConfiguracionMenu("LPMantenimientoFactoresConversion","consultar");
            this.asignarAtributoPagina("cod","ApeFactoresConversion.query.label");
        } else if (opcionMenu.equals("ModificarFactoresConversion")) {
            this.getConfiguracionMenu("LPMantenimientoFactoresConversion","consultar");
            this.asignarAtributoPagina("cod", "ApeFactoresConversion.update.label");
        } else if (opcionMenu.equals("EliminarFactoresConversion")) {
            this.getConfiguracionMenu("LPMantenimientoFactoresConversion","eliminar");
            this.asignarAtributoPagina("cod", "ApeFactoresConversion.remove.label");
        }
        cargarPGInsertarFactoresConversion();
        // Habilitando y deshabilitando botones
        /* if(!opcionMenu.equals("ConsultarFactoresConversion")){
                this.asignarAtributo("BOTON", "btnDetalle", "Style","Display:none" );
         }
         else if(!opcionMenu.equals("ModificarFactoresConversion")){
                this.asignarAtributo("BOTON", "btnModificar", "Style","Display:none" );
         }
         else if(!opcionMenu.equals("EliminarFactoresConversion")){
                this.asignarAtributo("BOTON", "btnDetalle", "Style","Display:none" );
         }
         */
    }

    private void guardar() throws Exception {
        this.traza(
            "LPMantenimientoFactoresConversion.guardar(): Por asignar SALIDAGENERICA");
        this.pagina("salidaGenerica");

        String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        String ejecutarOK = null;
        String ejecutarError = null;

        if (opcionMenu.equals("InsertarFactoresConversion")) {
            ejecutarOK = "fLimpiar();";
            ejecutarError = "focalizaCD();";
        } else if (opcionMenu.equals("ModificarFactoresConversion")) {
            ejecutarOK = "cerrarModal();";
            ejecutarError = "focalizaCD();";
        }

        try {
            this.traza("LPMantenimientoFactoresConversion.guardar(): Por leer datos de pantalla");

            // Obtener valores ocultos
            String oidFactores = this.conectorParametroLimpia("oidFactoresConversion","", true);
            this.traza("oidFactores:" + oidFactores);

            // Obtener valores de la pantalla
            String oidMagnitud = this.conectorParametroLimpia("oidMagnitud","", true);
            String oidUnidMedOrigen = this.conectorParametroLimpia("oidUnidMedOrigen","", true);
            String oidcbUnidMedDestino = this.conectorParametroLimpia("oidcbUnidMedDestino","", true);
            //String factor = this.conectorParametroLimpia("txtFactor", "", true);
            String factor = this.conectorParametroNumero("txtFactor",this.FORMATO_DEFAULT);
            this.traza("factor:" + factor);

            this.traza("LPMantenimientoFactoresConversion.guardar(): Por construir el DTO");

            // Llenando el DTO
            DTOFactoresConversion dtoFC = new DTOFactoresConversion();

            if (!oidFactores.equals("")) {
                dtoFC.setOidFactoresConversion(new Long(oidFactores));
            }

            if (!oidMagnitud.equals("")) {
                dtoFC.setOidMagnitud(new Long(oidMagnitud));
            }

            if (!oidUnidMedOrigen.equals("")) {
                dtoFC.setOidUnidadMedidaOrigen(new Long(oidUnidMedOrigen));
            }

            if (!oidcbUnidMedDestino.equals("")) {
                dtoFC.setOidUnidadMedidaDestino(new Long(oidcbUnidMedDestino));
            }

            if (!factor.equals("")) {
                dtoFC.setFactorConversion(new BigDecimal(factor));
            }

            Vector params = new Vector();
            params.add(dtoFC);
            params.add(new MareBusinessID("APEActualizarFactoresConversion"));
            this.traza("LPMantenimientoFactoresConversion.guardar(): Por invocar el conector guardar");
            conectar("ConectorActualizarFactoresConversion", params);
            asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
            this.traza("LPMantenimientoFactoresConversion.guardar(): Valor GUARDADO");
        } catch (Exception e) {
            traza("Excepcion: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
            throw e;
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
        this.traza(
            "Se produjo la excepcion, en LPMantenimientoFactoresConversion: " +
            e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        this.traza("stack Trace : " + pila.toString());
    }

    private void cargaValores() throws Exception {
        // Obtener valores ocultos
        String oidFactoresConversion = this.conectorParametroLimpia("oidFactoresConversion","", true);

        // Obtener valores de la pantalla
        String oidMagnitud = this.conectorParametroLimpia("oidMagnitud", "",true);
        String oidUnidMedOrigen = this.conectorParametroLimpia("oidUnidMedOrigen","", true);
        String oidcbUnidMedDestino = this.conectorParametroLimpia("oidcbUnidMedDestino","", true);
        String factorConversion = this.conectorParametroLimpia("factorConversion","", true);

        // Obtener valores de descrpciones de combos
        String magnitud = this.conectorParametroLimpia("magnitud", "", true);
        String unidMedOrigen = this.conectorParametroLimpia("unidMedOrigen","", true);
        String unidMedDestino = this.conectorParametroLimpia("unidMedDestino","", true);

        // Asignar a tags de pantalla
        // Valores ocultos
        this.asignarAtributo("VAR", "oidFactoresConversion", "valor", oidFactoresConversion);
        this.asignarAtributo("VAR", "oidMagnitud", "valor", oidMagnitud);
        this.asignarAtributo("VAR", "oidUnidMedOrigen", "valor",oidUnidMedOrigen);
        this.asignarAtributo("VAR", "oidcbUnidMedDestino", "valor",oidcbUnidMedDestino);

        // TAGS XML
        this.asignarAtributo("CTEXTO", "txtFactor", "valor", factorConversion);

        // Combos XML
        RecordSet rs = new RecordSet();
        rs.addColumn("oid");
        rs.addColumn("des");
        rs.addRow(new Object[] { oidMagnitud, magnitud });
        this.asignar("COMBO", "cbMagnitud",generarConector("ROWSET", rs, (Vector) rs.getColumnIdentifiers()),"ROWSET");

        RecordSet rs2 = new RecordSet();
        rs2.addColumn("oid");
        rs2.addColumn("des");
        rs2.addRow(new Object[] { oidUnidMedOrigen, unidMedOrigen });
        this.asignar("COMBO", "cbUnidMedOrigen",generarConector("ROWSET", rs2, (Vector) rs2.getColumnIdentifiers()),"ROWSET");

        RecordSet rs3 = new RecordSet();
        rs3.addColumn("oid");
        rs3.addColumn("des");
        rs3.addRow(new Object[] { oidcbUnidMedDestino, unidMedDestino });
        this.asignar("COMBO", "cbUnidMedDestino",generarConector("ROWSET", rs3, (Vector) rs3.getColumnIdentifiers()),"ROWSET");
    }

    private DruidaConector generarConector(String rowsetID, RecordSet datos,
        Vector columns) throws DOMException, Exception {
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();

        if (columns == null) {
            columns = new Vector();
        }

        Vector columsDesc = datos.getColumnIdentifiers();
        DruidaConector conectorValoresPosibles = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < sizeRows; i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo0 = docDestino.createElement("CAMPO");

            for (int j = 0; j < sizeColums; j++) {
                if (columns.contains(columsDesc.elementAt(j))) {
                    Element e_campo2 = docDestino.createElement("CAMPO");

                    if (j == 0) {
                        e_campo0.setAttribute("NOMBRE", "oculto");
                    } else {
                        e_campo2.setAttribute("NOMBRE",
                            columsDesc.elementAt(j).toString());
                    }

                    e_campo2.setAttribute("TIPO", "OBJECTO");
                    e_campo2.setAttribute("LONGITUD", "50");

                    Text txt0 = docDestino.createTextNode(((datos.getValueAt(
                                i, j) == null) ? ""
                                               : datos.getValueAt(i, j)
                                                      .toString()));
                    e_campo2.appendChild(txt0);
                    e_row.appendChild(e_campo2);
                }
            }
        }

        conectorValoresPosibles.setXML(docDestino.getDocumentElement());

        return conectorValoresPosibles;
    }
}
