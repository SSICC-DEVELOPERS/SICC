import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ape.DTOTiposCajaEmbalaje;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Vector;


public class LPMantenimientoTiposCajaEmbalaje extends LPSICCBase {

    private static final String NRO_ETIQUETAS_DEFECTO = "1";
    
    private String accion;
    private String opcionMenu;
    private Long idioma;
    private Long pais;

    public LPMantenimientoTiposCajaEmbalaje() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            this.setTrazaFichero();
            this.traza("LPMantenimientoTiposCajaEmbalaje.ejecucion(): Entrada");
            this.rastreo();

            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);

            if (accion.equals("")) {
                inicializar();
            } else if (accion.equals("guardar")) {
                guardar();
            } else if (accion.equals("modificar")) {
                modificarTiposCajaEmbalaje();
            } else if (accion.equals("detalle")) {
                detalleTiposCajaEmbalaje();
            }

            this.getFormatosValidaciones();

            this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
            this.asignarAtributo("VAR", "accion", "valor", accion);
            this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
            this.asignarAtributo("VAR", "varPais", "valor", pais.toString());

            this.traza("LPMantenimientoTiposCajaEmbalaje.ejecucion(): Salida");
        } catch (Exception e) {
            this.preservaHiddensI18n(new Integer(1),"APE_TIPO_CAJA_EMBAL","formulario","txtDescripcion", false);
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }
    }

    private void inicializar() throws Exception {
        if (opcionMenu.equals("InsertarTiposCajaEmbalaje")) {
            cargarPGInsertarTiposCajaEmbalaje(null);
        } else if (opcionMenu.equals("ModificarTiposCajaEmbalaje") || opcionMenu.equals("ConsultarTiposCajaEmbalaje") || opcionMenu.equals("EliminarTiposCajaEmbalaje")) {
            cargarPGConsultarTiposCajaEmbalaje();
        }
    }

    private void cargarPGInsertarTiposCajaEmbalaje(Vector oidsMultiLenguaje) throws Exception {

        boolean i18Cargado = true;
        boolean i18Lectura = true;

        this.pagina("contenido_tipos_caja_insertar");

        // Configurar titulo de caso de uso
        if (opcionMenu.equals("ConsultarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0983");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Detalle");
        } else if (opcionMenu.equals("ModificarTiposCajaEmbalaje")) {
            i18Lectura = false;
            this.asignarAtributoPagina("cod","0982");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Modificar");
        } else if (opcionMenu.equals("EliminarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0984");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Detalle");
        } else if (opcionMenu.equals("InsertarTiposCajaEmbalaje")) {
            i18Lectura = false;
            this.asignarAtributoPagina("cod","0981");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Guardar");
            
            this.asignarAtributo("CTEXTO", "txtNumEtiquetaCaja", "valor", NRO_ETIQUETAS_DEFECTO);            
            
        }
        
        if(accion!=null&&(accion.equals("guardar")||accion.equals("modificar"))){
            i18Cargado = false;
        }
        
        anyadeHiddensI18N(i18Cargado, "APE_TIPO_CAJA_EMBAL", oidsMultiLenguaje!=null ? (Long)oidsMultiLenguaje.get(0) : null, new Integer(1), "formulario", "txtDescripcion", i18Lectura);
        
        cargarCombos("insertar");
        
    }

    private void cargarPGConsultarTiposCajaEmbalaje() throws Exception {

        this.pagina("contenido_tipos_caja_modificar");

        // Configurar titulo de caso de uso
        if (opcionMenu.equals("ConsultarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0983");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Consultar");
        } else if (opcionMenu.equals("ModificarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0982");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Consultar");
        } else if (opcionMenu.equals("EliminarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0984");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Eliminar");
        } /*else if (opcionMenu.equals("InsertarTiposCajaEmbalaje")) {
            this.asignarAtributoPagina("cod","0981");
            this.getConfiguracionMenu("LPMantenimientoTiposCajaEmbalaje","Guardar");
        }*/
        cargarCombos(null);
    }
    
    private void cargarCombos(String metodo) throws Exception{
    
        // Creamos el ComposerViewElememtList
        ComposerViewElementList listElement = new ComposerViewElementList();

        // Carga los Centros de Distribucion
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(pais);
        dtoe.setOidIdioma(idioma);
        ComposerViewElement elem1 = new ComposerViewElement();
        elem1.setIDBusiness("APEObtenerDescripcionesCD");
        elem1.setDTOE(dtoe);
        elem1.setPosOID((byte) 0);
        elem1.setPosDesc((byte) 1);
        listElement.addViewElement(elem1);
        

        if((metodo!=null)&&(metodo.equals("insertar"))){
            // Carga las unidades de medida de Volumen 
            DTOString dtoOid1 = new DTOString();
            dtoOid1.setCadena(ConstantesAPE.MAGNITUD_VOLUMEN);
            dtoOid1.setOidPais(pais);
            dtoOid1.setOidIdioma(idioma);
            ComposerViewElement elem2 = new ComposerViewElement();
            elem2.setIDBusiness("APEObtenerUnidadesMedidaPorMagnitud");
            elem2.setDTOE(dtoOid1);
            listElement.addViewElement(elem2);
    
            // Carga las unidades de medida de Longitud
            DTOString dtoOid2 = new DTOString();
            dtoOid2.setCadena(ConstantesAPE.MAGNITUD_LONGITUD);
            dtoOid2.setOidPais(pais);
            dtoOid2.setOidIdioma(idioma);
            ComposerViewElement elem3 = new ComposerViewElement();
            elem3.setIDBusiness("APEObtenerUnidadesMedidaXMagnitud");
            elem3.setDTOE(dtoOid2);
            listElement.addViewElement(elem3);
        }

        //Llamar al subsistema GestorCargaPantalla
        ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
        traza("GestorCargaPantalla creado");
        conector.ejecucion();
        traza("GestorCargaPantalla ejecutado");

        DruidaConector conConsultar = conector.getConector();
        asignar("COMBO", "cbCentroDistribucion", conConsultar, "APEObtenerDescripcionesCD");
        if((metodo!=null)&&(metodo.equals("insertar"))){
            asignar("COMBO", "cbUnidadMedidaCapacidad", conConsultar, "APEObtenerUnidadesMedidaPorMagnitud");
            asignar("COMBO", "cbUnidadMedida", conConsultar, "APEObtenerUnidadesMedidaXMagnitud");
        }
        traza("Combos asignados");
        
        // Carga Valores por defecto
        DTOBelcorp dtoBel = new DTOBelcorp();      
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);
        MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
        Vector params = new Vector();		
        params.addElement(dtoBel);
        params.addElement(mareBusinessID);
        traza("antes del conector VD");
        DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
        traza("despues del conector VD");
        DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");
        
        // Asignar Valor por defecto al Combo
        // Se guarda en un variable de la pagina y se establece con JS
        RecordSet rs = dtoSalida.getResultado();
        int i = 0;
        boolean hallado = false;
        while(i<rs.getRowCount()&&!hallado){
            if(((String)rs.getValueAt(i,"combo")).equals(ConstantesAPE.CONFIGURACION_CD)){
                this.asignarAtributo("VAR", "centroDistribucionVD", "valor", rs.getValueAt(i,"OID").toString());
                traza("Valor por defecto: ["+rs.getValueAt(i,"OID").toString()+"]");
                hallado = true;
            }
            i++;
        }
    
    }

    private void guardar() throws Exception {
        this.traza("LPMantenimientoTiposCajaEmbalaje.guardar(): Entrada");

        this.pagina("salidaGenerica");
        String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        String ejecutarOK = null;
        String ejecutarError = null;

        if (opcionMenu.equals("InsertarTiposCajaEmbalaje")) {
            ejecutarOK = "fLimpiar();";
            ejecutarError = "focalizaCD();";
        } else if (opcionMenu.equals("ModificarTiposCajaEmbalaje")) {
            ejecutarOK = "cerrarModal();";
            ejecutarError = "focalizaCD();";
        }

        try {
            DTOTiposCajaEmbalaje dtoTCE = crearDTOTiposCajaEmbalaje();
            Vector params = new Vector();
            params.add(dtoTCE);
            params.add(new MareBusinessID("APEActualizarTiposCajaEmbalajeLineas"));
            this.traza("LPMantenimientoTiposCajaEmbalaje.guardar(): Por invocar el conector guardar");
            conectar("ConectorActualizarTiposCajaEmbalaje", params);
            asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
            this.traza("LPMantenimientoTiposCajaEmbalaje.guardar(): GUARDADO");
        } catch (Exception e) {
            traza("Excepcion: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
            throw e;
        }
    }

    private DTOTiposCajaEmbalaje crearDTOTiposCajaEmbalaje() throws Exception{
    
        this.traza("LPMantenimientoTiposCajaEmbalaje.crearDTOTiposCajaEmbalaje(): Por leer datos de pantalla");

        String oidTiposCajaEmbalaje = this.conectorParametroLimpia("oidTiposCajaEmbalaje", "", true);
        String oidCentroDistribucion = this.conectorParametroLimpia("oidCentroDistribucion", "", true);
        String codTipoCaja = this.conectorParametroLimpia("txtCodTipoCaja", "", true); //
        String descripcion = this.conectorParametroLimpia("txtDescripcion", "", true);
        String lineasAnteriores = this.conectorParametroLimpia("lineasAnteriores", "", true);
        String lineasSeleccionadas = this.conectorParametroLimpia("lineasSeleccionadas", "", true);
        String oidUnidadMedidaCapacidad = this.conectorParametroLimpia("oidUnidadMedidaCapacidad", "", true);
        String capacidad = this.conectorParametroNumero("txtCapacidad", this.FORMATO_DEFAULT);
        String capacidadMinima = this.conectorParametroNumero("txtCapacidadMinima", this.FORMATO_DEFAULT);
        String cubicaje = this.conectorParametroLimpia("chkCubicaje", "", true); // 
        String seguridad = this.conectorParametroNumero("txtSeguridad", this.FORMATO_DEFAULT);
        String nivelAplicacion = this.conectorParametroNumero("txtNivelAplicacion", this.FORMATO_DEFAULT);
        String numEtiquetaCaja = this.conectorParametroNumero("txtNumEtiquetaCaja", this.FORMATO_DEFAULT);
        String oidUnidadMedida = this.conectorParametroLimpia("oidUnidadMedida", "", true);
        String alto = this.conectorParametroNumero("txtAlto", this.FORMATO_DEFAULT);
        String ancho = this.conectorParametroNumero("txtAncho", this.FORMATO_DEFAULT);
        String largo = this.conectorParametroNumero("txtLargo", this.FORMATO_DEFAULT);
        Vector inter = recuperaTraduccionesI18N(new Integer(1));

        this.traza("LPMantenimientoTiposCajaEmbalaje.crearDTOTiposCajaEmbalaje(): Por construir el DTO");

        // Llenando el DTO
        DTOTiposCajaEmbalaje dtoTCE = new DTOTiposCajaEmbalaje();
        
        dtoTCE.setVectorConTraducciones(inter);
        
        dtoTCE.setOidPais(pais);
        dtoTCE.setOidIdioma(idioma);

        if (!oidTiposCajaEmbalaje.equals("")) {
            dtoTCE.setOid(new Long(oidTiposCajaEmbalaje));
        }
        if (!oidCentroDistribucion.equals("")) {
            dtoTCE.setCentroDistribucion(new Long(oidCentroDistribucion));
        }
        if (!codTipoCaja.equals("")) {
            dtoTCE.setTipoCaja(codTipoCaja);
        }
        if (!descripcion.equals("")) {
            dtoTCE.setDescripcion(descripcion);
        }
        if (!oidUnidadMedidaCapacidad.equals("")) {
            dtoTCE.setOidUnidadMedidaCapacidad(new Long(oidUnidadMedidaCapacidad));
        }
        if (!capacidad.equals("")) {
            dtoTCE.setCapacidad(new BigDecimal(capacidad));
        }
        if (!capacidadMinima.equals("")) {
            dtoTCE.setCapacidadMinima(new BigDecimal(capacidadMinima));
        }
        if (!cubicaje.equals("")) {
            dtoTCE.setIndicadorCubicaje((cubicaje.toUpperCase().equals("S")?Boolean.TRUE:Boolean.FALSE));
        }
        if (!seguridad.equals("")) {
            dtoTCE.setPorcentajeSeguridad(new BigDecimal(seguridad));
        }
        if (!nivelAplicacion.equals("")) {
            dtoTCE.setNivelAplicacion(new BigDecimal(nivelAplicacion));
        }
        if (!numEtiquetaCaja.equals("")) {
            dtoTCE.setNumeroEtiquetas(new Long(numEtiquetaCaja));
        }
        if (!oidUnidadMedida.equals("")) {
            dtoTCE.setOidUnidadMedidaExterior(new Long(oidUnidadMedida));
        }
        if (!alto.equals("")) {
            dtoTCE.setAlto(new BigDecimal(alto));
        }
        if (!ancho.equals("")) {
            dtoTCE.setAncho(new BigDecimal(ancho));
        }
        if (!largo.equals("")) {
            dtoTCE.setLargo(new BigDecimal(largo));
        }
        
        
        String[] vAnterior = lineasAnteriores.split(",");
        String[] vSeleccion = lineasSeleccionadas.split(",");
        String iEsimo = null;
        boolean enGrupo = false;
        
        Vector vOidsEliminar = new Vector();
        Vector vOidsInsertar = new Vector();
        
        for(int i = 0; i<vAnterior.length; i++){
            iEsimo = vAnterior[i].trim();
            if(iEsimo.length()>0){
                enGrupo = false;
                for(int j = 0; j< vSeleccion.length; j++){
                    if(iEsimo.equals(vSeleccion[j])){
                        enGrupo=true;
                        break;
                    }
                }
                if(!enGrupo){
                    vOidsEliminar.add(iEsimo);
                }
            }
        }

        for(int i = 0; i<vSeleccion.length; i++){
            iEsimo = vSeleccion[i].trim();
            if(iEsimo.length()>0){
                enGrupo = false;
                for(int j = 0; j< vAnterior.length; j++){
                    if(iEsimo.equals(vAnterior[j])){
                        enGrupo=true;
                        break;
                    }
                }
                if(!enGrupo){
                    vOidsInsertar.add(iEsimo);
                }
            }
        }
        
        if(vOidsEliminar.size()>0){
            Long[] oids = new Long[vOidsEliminar.size()];
            for(int i = 0; i < vOidsEliminar.size(); i++) 
                oids[i] = new Long((String)vOidsEliminar.get(i));
            DTOOIDs dto = new DTOOIDs();
            dto.setOids(oids);
            dtoTCE.setLineasArmadoEliminadas(dto);
        }
        
        if(vOidsInsertar.size()>0){
            Long[] oids = new Long[vOidsInsertar.size()];
            for(int i = 0; i < vOidsInsertar.size(); i++) 
                oids[i] = new Long((String)vOidsInsertar.get(i));
            DTOOIDs dto = new DTOOIDs();
            dto.setOids(oids);
            dtoTCE.setLineasArmadoInsertadas(dto);
        }

        //this.traza("***********\n"+dtoTCE+"\n***********");
        
        this.traza("LPMantenimientoTiposCajaEmbalaje.crearDTOTiposCajaEmbalaje(): DTO creado");

        return dtoTCE;
    }

    private void modificarTiposCajaEmbalaje() throws Exception{
        cargaValores();
    }

    private void detalleTiposCajaEmbalaje() throws Exception{
        cargaValores();
    }

    private DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje(Long oid) throws Exception{
        DTOOID dto = new DTOOID();
        dto.setOid(oid);
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        Vector params = new Vector();
        params.add(dto);
        params.add(new MareBusinessID("APEObtenerTiposCajaEmbalaje"));
        this.traza("LPMantenimientoTiposCajaEmbalaje.obtenerTiposCajaEmbalaje(): Por invocar el conector APEObtenerTiposCajaEmbalaje");
        
        DruidaConector conector = this.conectar("ConectorObtenerTiposCajaEmbalaje", params);
        
        DTOTiposCajaEmbalaje dtoTCE = (DTOTiposCajaEmbalaje) conector.objeto("DTOSalida");
        
        this.traza("LPMantenimientoTiposCajaEmbalaje.obtenerTiposCajaEmbalaje(): Valores obtenidos");
        
        return dtoTCE;
    }

    private void mostrarDatosTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoe) throws Exception{
        this.asignarAtributo("VAR", "oidTiposCajaEmbalaje", "valor", dtoe.getOid().toString());
        this.asignarAtributo("VAR", "oidCentroDistribucion", "valor", dtoe.getCentroDistribucion().toString());
        this.asignarAtributo("VAR", "oidUnidadMedidaCapacidad", "valor", dtoe.getOidUnidadMedidaCapacidad().toString());
        this.asignarAtributo("VAR", "oidUnidadMedida", "valor", dtoe.getOidUnidadMedidaExterior().toString());
        
        DTOOIDs dtoOids = dtoe.getLineasArmadoInsertadas();
        String strLineasArmado = "";
        
        if(dtoOids!=null&&dtoOids.getOids().length>0){
            Long[] oidsLineas = dtoOids.getOids();
            int i = 0;
            for( ; i < oidsLineas.length; i++){
                strLineasArmado += oidsLineas[i].toString() + ",";
            }
            if(i > 0){
                strLineasArmado = strLineasArmado.substring(0,strLineasArmado.length()-1);
            }
        }
        
        this.asignarAtributo("VAR", "lineasAnteriores", "valor", strLineasArmado);
        // En la pagina debe seleccionar estos valores con JS
        
        if(dtoe.getIndicadorCubicaje().booleanValue()){
            this.asignarAtributo("CHECKBOX", "chkCubicaje", "check", "S");
        }else{
            this.asignarAtributo("CHECKBOX", "chkCubicaje", "check", "N");
        }
        this.asignarAtributo("CTEXTO", "txtCodTipoCaja", "valor", dtoe.getTipoCaja());
        this.asignarAtributo("CTEXTO", "txtDescripcion", "valor", dtoe.getDescripcion());
        this.asignarAtributo("CTEXTO", "txtCapacidad", "valor", dtoe.getCapacidad().toString());
        this.asignarAtributo("CTEXTO", "txtCapacidadMinima", "valor", dtoe.getCapacidadMinima().toString());
        this.asignarAtributo("CTEXTO", "txtSeguridad", "valor", dtoe.getPorcentajeSeguridad().toString());
        this.asignarAtributo("CTEXTO", "txtNivelAplicacion", "valor", dtoe.getNivelAplicacion().toString());
        this.asignarAtributo("CTEXTO", "txtNumEtiquetaCaja", "valor", dtoe.getNumeroEtiquetas().toString());
        this.asignarAtributo("CTEXTO", "txtAlto", "valor", dtoe.getAlto().toString());
        this.asignarAtributo("CTEXTO", "txtAncho", "valor", dtoe.getAncho().toString());
        this.asignarAtributo("CTEXTO", "txtLargo", "valor", dtoe.getLargo().toString());
        
    }


    private void cargaValores() throws Exception {
        this.traza("LPMantenimientoTiposCajaEmbalaje.cargaValores(): Por cargar los valores");
        String oidTiposCajaEmbalaje = this.conectorParametroLimpia("oidTiposCajaEmbalaje", "", true);
        DTOTiposCajaEmbalaje dtoTCE = obtenerTiposCajaEmbalaje(new Long(oidTiposCajaEmbalaje));
        Vector vc = new Vector();
        vc.add(new Long(oidTiposCajaEmbalaje));
        cargarPGInsertarTiposCajaEmbalaje(vc);
        mostrarDatosTiposCajaEmbalaje(dtoTCE);
        /*
         * los campos se deshabilitan segun caso de uso con JS
         */
        this.traza("LPMantenimientoTiposCajaEmbalaje.cargaValores(): Valores cargados");
    }

    private void logStackTrace(Throwable e) throws Exception {
        this.traza("Se produjo la excepcion, en LPMantenimientoTiposCajaEmbalaje: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        this.traza("stack Trace : " + pila.toString());
    }

}
