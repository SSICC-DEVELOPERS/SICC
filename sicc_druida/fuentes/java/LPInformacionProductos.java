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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.ConstantesCMN;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesSession;
//import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;

public class LPInformacionProductos extends LPSICCBase {
         
    private String accion = null;
    private String casoUso = null;
    private Long pais;
    private Long idioma;
    private String oidContacto;

    public LPInformacionProductos() {
        super();
    }
          
    public void inicio() throws Exception {
    // Asignar nombre de la vista
        pagina("contenido_informacion_producto_buscar");    
    }
          
    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("*** HSH Entrada -  LPInformacionProductos - ejecucion ***");

        try {
            traza("*** HSH LPInformacionProductos: Entrada ***");
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            this.accion = conectorParametroLimpia("accion","", true);
            this.oidContacto = conectorParametroLimpia("oidContacto","",true);

            traza("HSH accion=: "+accion);

            asignar("VAR", "idioma", idioma.toString());
            traza("HSH idioma=: "+idioma);
            asignar("VAR", "pais", pais.toString());    
            traza("HSH pais : "+pais);

            if (this.accion.equals("")) {
                getConfiguracionMenu("LPInformacionProductos", accion);
                this.cargaInicial(pais, idioma);
            } else if (this.accion.equals("detalle")) {
                this.accionDetalle(pais, idioma);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }

        traza("*** HSH Salida -  LPInformacionProductos - ejecucion ***");
    }

    private void cargaInicial(Long pais, Long idioma) throws Exception {
        traza("*** HSH Entrada -  LPInformacionProductos - cargaInicial ***");

        try{

            // Campos hidden para realizar la validacion de números con formato de miles y decimales
            String formatoNumerico = UtilidadesSession.getFormatoNumerico(this);
            String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
            String separadorMiles = ",";
            if (separadorDecimales.equals(",")) {
                separadorMiles = ".";
            }
            asignarAtributo("VAR","hid_SeparadorMiles","valor",separadorMiles);
            asignarAtributo("VAR","hid_NumeroDecimales","valor",formatoNumerico);
            asignarAtributo("VAR","hid_SeparadorDecimales","valor",separadorDecimales);


            ComposerViewElementList listelem = new ComposerViewElementList();
            ComposerViewElement elem = null;

            String[] idBussines = new String[5];
            idBussines[0] = new String("SEGRecuperarMarcasProducto");
            idBussines[1] = new String("MAEObtenerUnidadesNegocioPorPais");
            idBussines[2] = new String("MAEObtenerNegocioPorPais");
            idBussines[3] = new String("MAEObtenerLineaProductoPorPais");
            idBussines[4] = new String("MAEObtenerEstatusProductoPorPais");

            DTOBelcorp dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(pais);
            dtoBelcorp.setOidIdioma(idioma);
   
            for (int i = 0; i < idBussines.length; i++) {
                elem=new ComposerViewElement(); 
                elem.setIDBusiness(idBussines[i]);
                elem.setDTOE(dtoBelcorp);
                listelem.addViewElement(elem);
	        }

            traza("HSH Elementos anadidos");
                  
            // Llamamos al subsistema GestorCargaPantalla. 
            ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
            traza("HSH conector creado");
            conector.ejecucion();
            traza("HSH ejecutado");
                  
            DruidaConector conConsulta = conector.getConector();
            traza("HSH Obtener consulta");
                   
            asignar("COMBO","cbMarcaProducto", conConsulta, "SEGRecuperarMarcasProducto");
            traza("HSH Combo cbMarcaProducto asignado");
            asignar("COMBO","cbUnidadNegocio", conConsulta, "MAEObtenerUnidadesNegocioPorPais");
            traza("HSH Combo cbUnidadNegocio asignado");
            asignar("COMBO","cbNegocio", conConsulta, "MAEObtenerNegocioPorPais");
            traza("HSH Combo cbNegocio asignado");
            asignar("COMBO","cbLinea", conConsulta, "MAEObtenerLineaProductoPorPais");
            traza("HSH Combo cbLinea asignado");
            asignar("COMBO","cbEstatusProducto", conConsulta, "MAEObtenerEstatusProductoPorPais");
            traza("HSH Combo cbEstatusProducto asignado");

            asignarAtributo("VAR", "MAE_TXT_PRODUCTO", "valor", ConstantesMAE.TXT_PRODUCTO);
            asignarAtributo("VAR", "MAE_TXT_SERVICIO", "valor", ConstantesMAE.TXT_SERVICIO);
            asignarAtributo("VAR", "MAE_TXT_PRODUCTO_ACTIVO", "valor", ConstantesMAE.TXT_PRODUCTO_ACTIVO);
            asignarAtributo("VAR", "MAE_TXT_PRODUCTO_INACTIVO", "valor", ConstantesMAE.TXT_PRODUCTO_INACTIVO);
            asignarAtributo("VAR", "CMN_VAL_FALSE", "valor", ConstantesCMN.VAL_FALSE.toString());
            asignarAtributo("VAR", "CMN_VAL_TRUE", "valor", ConstantesCMN.VAL_TRUE.toString());
            asignarAtributo("VAR", "MAE_PRODUCTO_ACTIVO", "valor", ConstantesMAE.PRODUCTO_ACTIVO);
            asignarAtributo("VAR", "MAE_PRODUCTO_INACTIVO", "valor", ConstantesMAE.PRODUCTO_INACTIVO);

            asignar("VAR", "oidContacto", this.oidContacto);

        }catch ( Exception e ){
            e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
        }

        traza("*** HSH Salida -  LPInformacionProductos - cargaInicial ***");
    }

    private void accionDetalle(Long pais, Long idioma) throws Exception {
        traza("*** HSH Entrada -  LPInformacionProductos - accionDetalle ***");

        pagina("contenido_informacion_producto_detalle");    

        getConfiguracionMenu("LPInformacionProductos", "detalle");

        String oid = conectorParametroLimpia("oid","", true);
  
        DTOOID dtoOid = new DTOOID();

        dtoOid.setOidIdioma(idioma);
        dtoOid.setOidPais(pais);       
        dtoOid.setOid(new Long(oid));
        // idBusiness = "CALDetalleInformacionProducto"
traza("HSH Detalle-->Antes del MareBusinessID");			
        MareBusinessID idBusiness = new MareBusinessID("CALDetalleInformacionProducto");

        // Parametros de entrada del conector			
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoOid);
        paramEntrada.add(idBusiness);
traza("HSH Detalle-->Antes de conectar");			
        // Se invoca al conector 
        DruidaConector conector = conectar("ConectorDetalleInformacionProducto", paramEntrada);
traza("HSH Detalle--> Despues de conectar");
        DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
traza("HSH Detalle--> Antes de asignar atributos");

        // Asignamos los valores del DTOSalida a la página
        asignarAtributo("LABELC", "lbldtCodSAP", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "CODSAP")));
        asignarAtributo("LABELC", "lbldtCodAntiguo", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "CODANTIGUO")));
        asignarAtributo("LABELC", "lbldtDescripcionCorta", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "DESCCORTA")));
        asignarAtributo("LABELC", "lbldtProductoServicio", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "PRODUCTOSERVICIO")));
        asignarAtributo("LABELC", "lbldtMarcaProducto", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "MARCAPRODUCTO")));
        asignarAtributo("LABELC", "lbldtUnidadesNegocio", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "UNIDADNEGOCIO")));
        asignarAtributo("LABELC", "lbldtNegocio", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "NEGOCIO")));
        asignarAtributo("LABELC", "lbldtLinea", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "LINEA")));
        // Incidencia BELC300012516
        asignarAtributo("LABELC", "lbldtPrecioCatalogo", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "PRECIOCATALOGO")));
        asignarAtributo("LABELC", "lbldtPrecioContable", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "PRECIOCONTABLE")));
        asignarAtributo("LABELC", "lbldtSituacion", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "SITUACION")));
        asignarAtributo("LABELC", "lbldtEstatusProducto", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "ESTATUSPRODUCTO")));
        asignarAtributo("LABELC", "lbldtIndicadorDentroCaja", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "CAJABOLSA")));
        asignarAtributo("LABELC", "lbldtCodPagoFraccionado", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "CODFORMAPAGO")));
        asignarAtributo("LABELC", "lbldtCodImpuesto", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "CODIMPUESTO")));
        asignarAtributo("LABELC", "lbldtDescripcionSAP", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "DESCSAP")));
        asignarAtributo("LABELC", "lbldtGenerico", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "GENERICO")));
        asignarAtributo("LABELC", "lbldtSupergenerico", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "SUPERGENERICO")));
        asignarAtributo("LABELC", "lbldtJerarquia1", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "JERARQUIA1")));
        asignarAtributo("LABELC", "lbldtJerarquia2", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "JERARQUIA2")));
        asignarAtributo("LABELC", "lbldtJerarquia3", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "JERARQUIA3")));
        asignarAtributo("LABELC", "lbldtAtributo1", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "ATRIBUTO1")));
        asignarAtributo("LABELC", "lbldtAtributo2", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "ATRIBUTO2")));
        asignarAtributo("LABELC", "lbldtAtributo3", "valor", 
validarToString(dtoSalida.getResultado().getValueAt(0, "ATRIBUTO3")));
        asignarAtributo("LABELC", "lbldtDimensionAlto", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "ALTO")));
        asignarAtributo("LABELC", "lbldtDimensionLargo", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "LARGO")));
        asignarAtributo("LABELC", "lbldtDimensionAncho", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "ANCHO")));
        asignarAtributo("LABELC", "lbldtUnidadesMedidaDimension", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "UNIDADMEDIDADIMENSIONES")));
        asignarAtributo("LABELC", "lbldtVolumen", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "VOLUMEN")));
        asignarAtributo("LABELC", "lbldtPeso", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "PESO")));
        asignarAtributo("LABELC", "lbldtUnidadMedidaPeso", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "UNIDADMEDIDAPESO")));
        asignarAtributo("LABELC", "lbldtUnidadesDentroPedido", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "UNIDADESPEDIDO")));
        asignarAtributo("LABELC", "lbldtUnidadesCaja", "valor", validarToString(dtoSalida.getResultado().getValueAt(0, "UNIDADESCAJA")));

        traza("*** HSH Salida -  LPInformacionProductos - accionDetalle ***");
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);		
        traza("Stack Trace: " + baos.toString());
    }      

    private String validarToString(Object entrada) {
        if(entrada==null){
            return "";
        } else {
            return entrada.toString();
        }
    }
}