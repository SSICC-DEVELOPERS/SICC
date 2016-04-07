import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ape.DTODatosPallet;
import es.indra.sicc.dtos.ape.DTODatosPallets;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPCubicajeAFP extends LPSICCBase {
    private String accion;
    private String opcionMenu;
    private Long idioma;
    private Long pais;

    public LPCubicajeAFP() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            this.setTrazaFichero();
            UtilidadesLog.debug("LPCubicajeAFP.ejecucion(): Entrada");
            this.rastreo();
            
            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            
            if (accion.equals("")) {
                cargarPantalla();
            } else if(accion.equals("guardarListaDatosPallet")) {
                guardarListaDatosPallet();
            } else if(accion.equals("buscarListaDatosPallet")) {
                buscarListaDatosPallet();
            } else if(accion.equals("datosAgrupacionVer")) {
                datosAgrupacionVer();
            } else if(accion.equals("desdoblar")) {
                desdoblarLista();
            }
            
            UtilidadesLog.debug("LPCubicajeAFP.ejecucion(): Salida");
            
        } catch (Exception e) {
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }
    }

    private void cargarPantalla() throws Exception{
        
        UtilidadesLog.debug("LPCubicajeAFP.cargarPantalla(): Entrada");
    
        // Asignar pagina
        this.pagina("contenido_cubicaje_articulos_fuera_pedido");

        configuracionesDeSiempre();
        this.asignarAtributoPagina("cod","ApeCubicArticFueraPed.query.label");
        this.getConfiguracionMenu("LPCubicajeAFP");
        
        // Preparando datos para el subsistema de carga inicial
        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);
        
        ComposerViewElementList cv = new ComposerViewElementList();
        
		// Carga de combo Centro Distribucion
        ComposerViewElement cbCentroDistribucion = new ComposerViewElement();
		cbCentroDistribucion.setIDBusiness("APEObtenerDescripcionesCD");
		cbCentroDistribucion.setDTOE(dtoBel);
		cbCentroDistribucion.setPosOID((byte)0);
		cbCentroDistribucion.setPosDesc((byte)1);
        // Carga de combo marca
        ComposerViewElement cbMarca = new ComposerViewElement();
        cbMarca.setIDBusiness("SEGConsultaMarcas");
        cbMarca.setDTOE(dtoBel);
        // Carga de combo canales
        ComposerViewElement cbCanales = new ComposerViewElement();
        cbCanales.setIDBusiness("SEGConsultaCanales");
        cbCanales.setDTOE(dtoBel);
        
        cv.addViewElement(cbCentroDistribucion);
        cv.addViewElement(cbMarca);
        cv.addViewElement(cbCanales);   
        
        // Invocando al Subsistema de Carga Inicial
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        this.asignar("COMBO","cbCentroDistribucion",resultados,"APEObtenerDescripcionesCD");
        this.asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
        this.asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
        
        this.asignarAtributo("CTEXTO", "txtFecha", "valor", UtilidadesBelcorp.fechaFormateada(new Date(),UtilidadesSession.getFormatoFecha(this)));
        
        UtilidadesLog.debug("LPCubicajeAFP.cargarPantalla(): Salida");
        
    }

    public void guardarListaDatosPallet() throws Exception {

        UtilidadesLog.debug("LPCubicajeAFP.guardarListaDatosPallet(): Entrada");
        this.pagina("salidaGenerica");
        
        //configuracionesDeSiempre();
        
        String ejecutarOK = "ejecutaOK();";
        String ejecutarError = "ejecutaERROR();";

        try{
            // Se recibe la cadena y se procesa para separar las lineas
            // y generar la lista de DTOs
            // | separador de lineas
            // ; separador de columnas
            String lineas = this.conectorParametroLimpia("hLineas","",true);
            UtilidadesLog.debug("lineas: "+lineas);
            
            DTODatosPallets dtos = new DTODatosPallets();
            ArrayList listaDtos = new ArrayList();
            
            StringTokenizer tkLineas = new StringTokenizer(lineas,"|");
            
            int i = 0;
            String linea = null;
            while(tkLineas.hasMoreElements()){
                linea = (String)tkLineas.nextElement();
                DTODatosPallet dto = new DTODatosPallet();
				dto.setOidPais(pais);
				dto.setOidIdioma(idioma);
                StringTokenizer tkColumnas = new StringTokenizer(linea,";");
                int j = 0;
                String columna = null;
                while(tkColumnas.hasMoreElements()){
                    columna = ((String)tkColumnas.nextElement()).trim();
                    switch(j){
                        case  0: if(!columna.equals("")) dto.setOid(new Long(columna)); break;
                        case  1: if(!columna.equals("")) dto.setCodigoProducto(columna); break; // Codigo de Producto
                        case  4: if(!columna.equals("")) dto.setUnidadesProducto(new Long(this.desFormatearNumero(columna,this.FORMATO_DEFAULT))); break;
                        case  5: if(!columna.equals("")) dto.setNumeroPallet(new Long(this.desFormatearNumero(columna,this.FORMATO_DEFAULT))); break;
                        case  6: if(!columna.equals("")) dto.setOidCabecera(new Long(columna)); break;
                        case  7: if(!columna.equals("")) dto.setOidProducto(new Long(columna)); break;
                        case  8: if(!columna.equals("")) dto.setValorLinea(new BigDecimal(columna)); break;
                        case  9: if(!columna.equals("")) dto.setOidTipoCajaEmbalaje(new Long(columna));break;
                        case 10: if(!columna.equals("")) dto.setOidMapaCentroDistribucionDetalle(new Long(columna)); break;
                        case 11: if(!columna.equals("")) dto.setOidSistemaPicado(new Long(columna)); break;
                        case 12: if(!columna.equals("")) dto.setCodigoPosicion(new Long(columna)); break;
                        case 13: if(!columna.equals("")) dto.setIndicadorImpresion(columna); break;
                        case 14: if(!columna.equals("")) dto.setUnidadesPicadas(new Long(columna)); break;
                        case 15: if(!columna.equals("")) dto.setNombrePicador(columna); break;
                        case 16: if(!columna.equals("")) dto.setUnidadesChequeadas(new Long(columna)); break;
                        case 17: if(!columna.equals("")) dto.setNombreChequeador(columna); break;
                    }
                    j++;
                }
                listaDtos.add(dto);
                i++;
            }
            
            // Se agrega la lista de DTOs en otro DTO
            dtos.setListaPallets(listaDtos);
            dtos.setOidPais(pais);
            
            UtilidadesLog.debug("LPCubicajeAFP.guardarListaDatosPallet(): dto Construido");
            UtilidadesLog.debug(dtos);
            // El nuevo DTO se envia por el conector
            this.traza("LPMantenerParamBalanceoAreaChequeo.guardarListaDatosPallet(): Por invocar el conector guardar");
            Vector params = new Vector();
            params.add(dtos);
            params.add(new MareBusinessID("APEGuardarListaDatosPallet"));
            this.conectar("ConectorGuardarListaDatosPallet", params);
            this.asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
            
            this.traza("LPCubicajeAFP.guardarListaDatosPallet(): Salida, ejecucion satisfactoria");
            
        } catch(Exception e){
            UtilidadesLog.debug("Excepcion: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
            throw e;
        }
        
    }

    private void logStackTrace(Throwable e) throws Exception {
        UtilidadesLog.debug("Se produjo la excepcion, en LPCubicajeAFP: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        UtilidadesLog.debug("stack Trace : " + pila.toString());
    }
    
    private void configuracionesDeSiempre() throws Exception {
    
        this.getFormatosValidaciones();

        this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        this.asignarAtributo("VAR", "accion", "valor", accion);
        this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
        this.asignarAtributo("VAR", "varPais", "valor", pais.toString());
    
    }
    
    private void datosAgrupacionVer() throws Exception {
        UtilidadesLog.debug("LPCubicajeAFP.datosAgrupacionVer(): Entrada");
        // Asignar pagina
        this.pagina("contenido_datos_agrupacion_ver");

        configuracionesDeSiempre();
        this.asignarAtributoPagina("cod","ApeCubicArticFueraPed.query.label");
        this.getConfiguracionMenu("LPCubicajeAFP","modal");
        
        this.asignarAtributo("VAR", "hOidCentroDistribucion", "valor", this.conectorParametroLimpia("oidCentroDistribucion","",true));
        this.asignarAtributo("VAR", "hCodAgrupacion", "valor", this.conectorParametroLimpia("codAgrupacion","",true));
        
        UtilidadesLog.debug("LPCubicajeAFP.datosAgrupacionVer(): Salida");
    }

    private void buscarListaDatosPallet() throws Exception {
        UtilidadesLog.debug("LPCubicajeAFP.buscarListaDatosPallet(): Entrada");
        // Asignar pagina
        this.pagina("contenido_pallets_asignar");

        configuracionesDeSiempre();
        this.asignarAtributoPagina("cod","ApeCubicArticFueraPed.query.label");
        this.getConfiguracionMenu("LPCubicajeAFP","guardar");
        
        this.asignarAtributo("VAR", "hOidListaPicadoCabecera", "valor", this.conectorParametroLimpia("oidListaPicadoCabecera","",true));
        
        UtilidadesLog.debug("LPCubicajeAFP.buscarListaDatosPallet(): Salida");
    }

    private void desdoblarLista() throws Exception {
        UtilidadesLog.debug("LPCubicajeAFP.desdoblarLista(): Entrada");
        // Asignar pagina
        this.pagina("contenido_cubicaje_articulos_fuera_pedido2");

        configuracionesDeSiempre();
        this.asignarAtributoPagina("cod","ApeCubicArticFueraPed.query.label");
        this.getConfiguracionMenu("LPCubicajeAFP","modal");
        
        this.asignarAtributo("VAR", "hNumUnidades", "valor", this.conectorParametroLimpia("numUnidades","",true));
        
        UtilidadesLog.debug("LPCubicajeAFP.desdoblarLista(): Salida");
    }

}
