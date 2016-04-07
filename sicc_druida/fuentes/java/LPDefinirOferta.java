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
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPDefinirOferta extends LPSICCBase {
    //definicion de variables
    private String accion = null;
    private Long oidCabeceraMF = null;
    private Long oidEstrategia = null;
    private Long idioma = null;
    private Long pais = null;
    private Long oidTipoCliente = null;
    private Long oidSubtipoCliente = null;
    private Long oidTipoClasificacion = null;
    private Long oidClasificacion = null;
    private Long oidEstatus = null;
    private String desTipoCliente = null;
    private String desSubtipoCliente = null;
    private String desTipoClasificacion = null;
    private String desClasificacion = null;
    private String desEstatus = null;
    private Long oidVentaExclusiva = null;
    private String estatus2;
    private String elementosSeleccionadosVentaExclusiva = null;
    private String elementosSeleccionadosProductosAsociados = null;

    //Variables bandera para habilitacion de los campos de la pantalla
    private String numGrupos = null;
    private String numPaqu = null;
    private String indCuadre = null;
    private String numGrupCondtes = null;
    private String numGrupCondos = null;
    private String condCondos = null;
    private String condCondtes = null;
    private String despAuto = null;
    private String despCompl = null;
    private String btnBPPpal = null;
    private String btnBPAsoc = null;

    //variables a recuperar de la pantalla
    private Long oidAcceso = null;
    private Long oidSubacceso = null;
    private Long oidArgumentoVenta = null;
    private String despachoCompleto = null;
    private String despachoAutomatico = null;
    private Long oidIndicadorCuadre = null;
    private Integer numeroGrupos = null;
    private Integer numeroPaquetes = null;
    private Integer numeroGruposCondicionantes = null;
    private Integer numeroGruposCondicionados = null;
    private String condicionCondicionantes = null;
    private String condicionCondicionados = null;
    private Long oidFormaPago = null;
    
    private Long oidCatalogo = null;
    private String recupObligatoria = null;

    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;    
   

    //Contructor
    public LPDefinirOferta() {
        super();
    }

    public void inicio() throws Exception {
        //En este metodo no lleva nada porque debe ir a otr LP al principio del caso de uso
    }

    public void ejecucion() throws Exception {
        TiempoDeCargaInicio=System.currentTimeMillis();    
        try {
            setTrazaFichero();
            this.rastreo();

            //Traemos las varia     bles de la pagina
            accion = (conectorParametro("accion") == null) ? ""
                                                           : conectorParametro(
                    "accion");
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            oidCabeceraMF = ((conectorParametro("oidCabeceraMF") == null) ||
                conectorParametro("oidCabeceraMF").equals("")) ? null
                                                               : Long.valueOf(conectorParametro(
                        "oidCabeceraMF"));
            oidEstrategia = ((conectorParametro("oidEstrategia") == null) ||
                conectorParametro("oidEstrategia").equals("")) ? null
                                                               : Long.valueOf(conectorParametro(
                        "oidEstrategia"));
            traza("Accion: " + accion);

            //preguntamos por la accion
            if (accion.equals("")) {
                limpiarSesion();
                conectorParametroSesion("UltimaLP", "LPDefinirOferta");
                conectorAction("LPSeleccionarMF");
                conectorActionParametro("nueva", "true");
            } else if (accion.equals("Matriz seleccionada")) {
                matrizSeleccionada();
            } else if (accion.equals("EstrategiaSeleccionada")) {
                this.meterValoresdePantallaenDTOOferta();
                cargarPantalla();
                this.sacarValoresdeDTOparaCargarPantalla();
                asignarAtributo("VAR", "hrbVentaExclusiva", "valor","N");
            } else if (accion.equals("Numero de grupos introducido")) {
                this.meterValoresdePantallaenDTOOferta();
                cargarPantalla();
                cambiaNumeroGrupos();
                this.sacarValoresdeDTOparaCargarPantalla();
            } else if (accion.equals("Añadir venta exclusiva")) {
                this.meterValoresdePantallaenDTOOferta();
                cargarPantalla();
                anadirVentaExclusiva();
                this.sacarValoresdeDTOparaCargarPantalla();
            } else if (accion.equals("Eliminar venta exclusiva")) {
                this.meterValoresdePantallaenDTOOferta();
                cargarPantalla();
                eliminarVentaExclusiva();
                this.sacarValoresdeDTOparaCargarPantalla();
            } else if (accion.equals("Buscar producto principal")) {
                this.meterValoresdePantallaenDTOOferta();
                buscarProductoPrincipal();
            } else if (accion.equals("Buscar producto asociado")) {
                this.meterValoresdePantallaenDTOOferta();
                buscarProductoAsociado();
            } else if (accion.equals("Producto seleccionado")) {
                cargarPantalla();
                productoSeleccionado();
                this.sacarValoresdeDTOparaCargarPantalla();
            } else if (accion.equals("Eliminar productos asociados")) {
                this.meterValoresdePantallaenDTOOferta();
                cargarPantalla();
                eliminarProductosAsociados();
                this.sacarValoresdeDTOparaCargarPantalla();
            } else if (accion.equals("Crear oferta")) {
                this.meterValoresdePantallaenDTOOferta();
                crearOferta();
                comprobarRestricciones();
            } else if (accion.equals("Comprobar restricciones")) {                
                comprobarRestricciones();
            } else if (accion.equals("Guardar oferta")) {
                this.meterValoresdePantallaenDTOOferta();
                guardarOferta();
            } else if (accion.equals("Limpiar")){
                this.cargarPantalla();
                this.limpiar();
            }
            
        TiempoDeCargaFin = System.currentTimeMillis();        
        traza("El tiempo de carga de LPDefinirOferta es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
        
        } catch (Exception e) {
            cargarPantalla();
            this.sacarValoresdeDTOparaCargarPantalla();
            logStackTrace(e);
            lanzarPaginaError(e);
        }
    }

    private void comprobarRestricciones() throws Exception {
        traza("Entre a Comprobar Restricciones");

        //recuperamos de sesion el dto DTOSCargarCriteriosDefinirOferta
        DTOSCargarCriteriosDefinirOferta dtoCritDefOf = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion(
                "DTOSCargarCriteriosDefinirOferta");

        boolean llamoaotracosa = false; 
        //recupera de la sesion las variables promociones, grupos y ranking
        Boolean promociones = (Boolean) conectorParametroSesion("promociones");
        Boolean grupos = (Boolean) conectorParametroSesion("grupos");
        Boolean ranking = (Boolean) conectorParametroSesion("ranking");

        if (promociones.equals(new Boolean(true))) {
            traza("Hay promociones, llamo a Definir Condicion Oferta");
            conectorParametroSesion("promociones", new Boolean(false));
            conectorParametroSesion("UltimaLP", "LPDefinirOferta");
            conectorAction("LPDefinirCondicionOferta");
            llamoaotracosa = true;
        }
         //aca deberia ir un else porque sino sigue ejecutando luego de setear la LP

        if (grupos.equals(new Boolean(true))) {
            DTOOferta dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");

            //guarda en sesion los valores si no existen
            if (conectorParametroSesion("grupoActual") == null) {
                conectorParametroSesion("grupoActual", new Integer(0));
            }

            if (conectorParametroSesion("numeroGrupos") == null) {
                if (dtoOf.getNumeroGrupos() != null) {
                    conectorParametroSesion("numeroGrupos",
                        dtoOf.getNumeroGrupos());
                }
            }

            if (conectorParametroSesion("numeroPaquetes") == null) {
                if (dtoOf.getNumeroPaquetes() != null) {
                    conectorParametroSesion("numeroPaquetes",
                        dtoOf.getNumeroPaquetes());
                }
            }

            if (conectorParametroSesion("gruposCondicionantes") == null) {
                if (dtoOf.getNumeroGruposCondicionantes() != null) {
                    conectorParametroSesion("gruposCondicionantes",
                        dtoOf.getNumeroGruposCondicionantes());
                }
            }

            if (conectorParametroSesion("gruposCondicionados") == null) {
                if (dtoOf.getNumeroGruposCondicionados() != null) {
                    conectorParametroSesion("gruposCondicionados",
                        dtoOf.getNumeroGruposCondicionados());
                }
            }
            traza("Voy a recuperar de sesion los valores");
            //recupera de sesion los valores
            Integer grupoActual = (Integer) conectorParametroSesion(
                    "grupoActual");
            Integer numeroGrupos = (Integer) conectorParametroSesion(
                    "numeroGrupos");
            Integer numeroPaquetes = (Integer) conectorParametroSesion(
                    "numeroPaquetes");

            Integer gruposCondicionantes = (Integer) conectorParametroSesion(
                    "gruposCondicionantes");
            Integer gruposCondicionados = (Integer) conectorParametroSesion(
                    "gruposCondicionados");

            traza("Valores Recuperados : paquetes - "+numeroPaquetes+" - grupos - "+numeroGrupos+" - grupoactual - "+grupoActual);

            if ((numeroGrupos != null) && numeroGrupos.equals(new Integer(0)) &&
                    (numeroPaquetes != null) &&
                    numeroPaquetes.equals(new Integer(0)) &&
                    (gruposCondicionantes != null) &&
                    gruposCondicionantes.equals(new Integer(0)) &&
                    (gruposCondicionados != null) &&
                    gruposCondicionados.equals(new Integer(0))) {
                conectorParametroSesion("grupos", new Boolean(false));
                accion = "Comprobar restricciones";
            } else if (!llamoaotracosa){
                //Creamos un grupo, paquete, grupo condicionante a grupo condicionado en función de los parametros recogidos de sesión 
                //Comprobamos si la estrategia es condicionada
                if ((new Integer(dtoCritDefOf.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.CONDICIONADA) {
                    if ((gruposCondicionantes != null) &&
                            (gruposCondicionantes.compareTo(new Integer(0)) > 0)) { //condicionantes
                        //Guardo en sesion
                        grupoActual = new Integer(grupoActual.intValue() + 1);
                        conectorParametroSesion("grupoActual", grupoActual);

                        if (numeroGrupos != null) {
                            conectorParametroSesion("numeroGrupos", numeroGrupos);
                        }

                        if (numeroPaquetes != null) {
                            conectorParametroSesion("numeroPaquetes",
                                numeroPaquetes);
                        }

                        gruposCondicionantes = new Integer(gruposCondicionantes.intValue() -
                                1);
                        conectorParametroSesion("gruposCondicionantes",
                            gruposCondicionantes);

                        if (gruposCondicionados != null) {
                            conectorParametroSesion("gruposCondicionados",
                                gruposCondicionados);
                        }

                        conectorParametroSesion("grupo", new Boolean(false));
                        conectorParametroSesion("paquete", new Boolean(false));
                        conectorParametroSesion("condicionante",
                            new Boolean(true));
                        conectorParametroSesion("condicionado",
                            new Boolean(false));

                        //activo LP
                        conectorParametroSesion("UltimaLP", "LPDefinirOferta");
                        conectorAction("LPCrearGrupo");
                        llamoaotracosa = true;
                    } else if ((gruposCondicionados != null) &&
                            (gruposCondicionados.compareTo(new Integer(0)) > 0)) { //condicionados

                        //Guardo en sesion
                        grupoActual = new Integer(grupoActual.intValue() + 1);
                        conectorParametroSesion("grupoActual", grupoActual);

                        if (numeroGrupos != null) {
                            conectorParametroSesion("numeroGrupos", numeroGrupos);
                        }

                        if (numeroPaquetes != null) {
                            conectorParametroSesion("numeroPaquetes",
                                numeroPaquetes);
                        }

                        if (gruposCondicionantes != null) {
                            conectorParametroSesion("gruposCondicionantes",
                                gruposCondicionantes);
                        }

                        gruposCondicionados = new Integer(gruposCondicionados.intValue() -
                                1);
                        conectorParametroSesion("gruposCondicionados",
                            gruposCondicionados);
                        conectorParametroSesion("grupo", new Boolean(false));
                        conectorParametroSesion("paquete", new Boolean(false));
                        conectorParametroSesion("condicionante",
                            new Boolean(false));
                        conectorParametroSesion("condicionado",
                            new Boolean(true));

                        //activo LP
                        conectorParametroSesion("UltimaLP", "LPDefinirOferta");
                        conectorAction("LPCrearGrupo");
                        llamoaotracosa = true;
                    }
                } else { //la estrategia no es condicionada
                    //traza("comprobarRestricciones28");
                    if ((numeroGrupos != null) &&
                            (numeroGrupos.compareTo(new Integer(0)) > 0)) { //grupos

                        //Guardo en sesion
                        grupoActual = new Integer(grupoActual.intValue() + 1);
                        conectorParametroSesion("grupoActual", grupoActual);
                        numeroGrupos = new Integer(numeroGrupos.intValue() - 1);
                        conectorParametroSesion("numeroGrupos", numeroGrupos);

                        if (numeroPaquetes != null) {
                            conectorParametroSesion("numeroPaquetes",
                                numeroPaquetes);
                        }

                        if (gruposCondicionantes != null) {
                            conectorParametroSesion("gruposCondicionantes",
                                gruposCondicionantes);
                        }

                        if (gruposCondicionados != null) {
                            conectorParametroSesion("gruposCondicionados",
                                gruposCondicionados);
                        }

                        conectorParametroSesion("grupo", new Boolean(true));
                        conectorParametroSesion("paquete", new Boolean(false));
                        conectorParametroSesion("condicionante",
                            new Boolean(false));
                        conectorParametroSesion("condicionado",
                            new Boolean(false));

                        //activo LP
                        conectorParametroSesion("UltimaLP", "LPDefinirOferta");
                        conectorAction("LPCrearGrupo");
                        llamoaotracosa = true;
                    } else if ((numeroPaquetes != null) &&
                            (numeroPaquetes.compareTo(new Integer(0)) > 0)) { //paquetes
                        //traza("comprobarRestricciones29");
                        //Guardo en sesion
                        grupoActual = new Integer(grupoActual.intValue() + 1);
                        conectorParametroSesion("grupoActual", grupoActual);

                        if (numeroGrupos != null) {
                            conectorParametroSesion("numeroGrupos", numeroGrupos);
                        }

                        numeroPaquetes = new Integer(numeroPaquetes.intValue() - 1);
                        conectorParametroSesion("numeroPaquetes", numeroPaquetes);

                        if (gruposCondicionantes != null) {
                            conectorParametroSesion("gruposCondicionantes",
                                gruposCondicionantes);
                        }

                        if (gruposCondicionados != null) {
                            conectorParametroSesion("gruposCondicionados",
                                gruposCondicionados);
                        }

                        conectorParametroSesion("grupo", new Boolean(false));
                        conectorParametroSesion("paquete", new Boolean(true));
                        conectorParametroSesion("condicionante",
                            new Boolean(false));
                        conectorParametroSesion("condicionado",
                            new Boolean(false));

                        //activo LP
                        conectorParametroSesion("UltimaLP", "LPDefinirOferta");
                        conectorAction("LPCrearGrupo");
                        llamoaotracosa = true;
                    }
                }
            }
        }

        if (ranking.equals(new Boolean(true))&&!llamoaotracosa) { //ranking
            conectorParametroSesion("ranking", new Boolean(false));            
            conectorParametroSesion("UltimaLP", "LPDefinirOferta");
            conectorAction("LPEvaluarRankingPorDemanda");
            llamoaotracosa = true;
        }
        //traza("llamoaotracosa: "+llamoaotracosa);
        if (!llamoaotracosa)  {
            //traza("entro en guardar"+!llamoaotracosa);
            guardarOferta();
        }       
        
    }

    private void guardarOferta() throws Exception {       

        traza("guardarOferta");
        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
        
        traza("DTO a guardar:"+dto);
        
        dto.setIpCliente(UtilidadesSession.getIdUsuario(this));
        dto.setPrograma(UtilidadesSession.getFuncion(this));

        Vector vec = new Vector();
        vec.add(dto);
        vec.add(new MareBusinessID("PREGuardarOferta"));
        conectar("ConectorGuardarOferta", vec);
        
        //incidencia BELC300011961
        limpiarSesionParaSeguirDefiniendo();
        conectorAction("LPDefinirOferta");
        conectorActionParametro("accion","EstrategiaSeleccionada");
    }
    private void limpiarSesionParaSeguirDefiniendo(){
      this.getRequest().getSession().removeAttribute("DTOOferta");
      this.getRequest().getSession().removeAttribute("DTOSCargarCriteriosDefinirOferta");
      this.getRequest().getSession().removeAttribute("promociones");
      this.getRequest().getSession().removeAttribute("grupos");
      this.getRequest().getSession().removeAttribute("ranking");
      this.getRequest().getSession().removeAttribute("ProductosOferta");
      this.getRequest().getSession().removeAttribute("ProductoOfertaPrincipal");
      this.getRequest().getSession().removeAttribute("UltimaLP");
      this.getRequest().getSession().removeAttribute("grupoActual");
      this.getRequest().getSession().removeAttribute("numeroGrupos");
      this.getRequest().getSession().removeAttribute("numeroPaquetes");
      this.getRequest().getSession().removeAttribute("gruposCondicionantes");
      this.getRequest().getSession().removeAttribute("gruposCondicionados");
      this.getRequest().getSession().removeAttribute("grupo");
      this.getRequest().getSession().removeAttribute("paquete");      
      this.getRequest().getSession().removeAttribute("condicionante");      
      this.getRequest().getSession().removeAttribute("condicionado");
      this.getRequest().getSession().removeAttribute("productoprincipal");
      this.getRequest().getSession().removeAttribute("Productos");   
      this.getRequest().getSession().removeAttribute("oidAcceso");
      this.getRequest().getSession().removeAttribute("oidSubacceso");      
      this.getRequest().getSession().removeAttribute("volverLPBuscarProducto");
      this.getRequest().getSession().removeAttribute("productoPrincipal");
      this.getRequest().getSession().removeAttribute("numeroCondicion");//incidencia 5988
    }
    private void limpiarSesion(){
      this.getRequest().getSession().removeAttribute("DTOOferta");
      this.getRequest().getSession().removeAttribute("DTOSCargarCriteriosDefinirOferta");
      //this.getRequest().getSession().removeAttribute("oidCabeceraMF");
      this.getRequest().getSession().removeAttribute("oidEstrategia");
      this.getRequest().getSession().removeAttribute("promociones");
      this.getRequest().getSession().removeAttribute("grupos");
      this.getRequest().getSession().removeAttribute("ranking");
      this.getRequest().getSession().removeAttribute("ProductosOferta");
      this.getRequest().getSession().removeAttribute("ProductoOfertaPrincipal");
      this.getRequest().getSession().removeAttribute("UltimaLP");
      this.getRequest().getSession().removeAttribute("grupoActual");
      this.getRequest().getSession().removeAttribute("numeroGrupos");
      this.getRequest().getSession().removeAttribute("numeroPaquetes");
      this.getRequest().getSession().removeAttribute("gruposCondicionantes");
      this.getRequest().getSession().removeAttribute("gruposCondicionados");
      this.getRequest().getSession().removeAttribute("grupo");
      this.getRequest().getSession().removeAttribute("paquete");      
      this.getRequest().getSession().removeAttribute("condicionante");      
      this.getRequest().getSession().removeAttribute("condicionado");
      this.getRequest().getSession().removeAttribute("productoprincipal");
      this.getRequest().getSession().removeAttribute("Productos");   
      this.getRequest().getSession().removeAttribute("oidAcceso");
      this.getRequest().getSession().removeAttribute("oidSubacceso");      
      this.getRequest().getSession().removeAttribute("volverLPBuscarProducto");
      this.getRequest().getSession().removeAttribute("productoPrincipal");
      this.getRequest().getSession().removeAttribute("numeroCondicion");//incidencia 5988
    }
    private void crearOferta() throws Exception {
        //Lo recupero de la sesion porque si no existia al inicio fue creado en cargarPantalla()
        DTOOferta dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");

        recuperaValoresPantalla();
        oidCabeceraMF = (Long) conectorParametroSesion("oidCabeceraMF");
        oidEstrategia = (Long) conectorParametroSesion("oidEstrategia");

        DTOSCargarCriteriosDefinirOferta dtoCritDefOf = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion(
                "DTOSCargarCriteriosDefinirOferta");
        
        //enozigli 27/09/2005 BELC300021032
        String soidCatalogo = conectorParametroLimpia("cbCatalogo","",true);
        String descripcionCatalogo = conectorParametroLimpia("descCatalogo","",true);

        dtoOf.setOidCabeceraMF(oidCabeceraMF);
        dtoOf.setOidEstrategia(oidEstrategia);
        dtoOf.setNumeroOrden(null);
        traza("oidAcceso:"+oidAcceso+" oidSubacceso:"+oidSubacceso+" oidArgumentoVenta"+oidArgumentoVenta+" Catalogo"+soidCatalogo);
        dtoOf.setOidAcceso(oidAcceso);        
        dtoOf.setOidSubacceso(oidSubacceso);
        dtoOf.setNumeroOferta(null);
        dtoOf.setOidArgumentoVenta(oidArgumentoVenta);
        //enozigli 27/09/2005 BELC300021032
        dtoOf.setOidCatalogo(new Long(soidCatalogo));
        dtoOf.setDescripcionCatalogo(descripcionCatalogo);
        dtoOf.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOf.setOidPais(UtilidadesSession.getPais(this));
        dtoOf.setIpCliente(UtilidadesSession.getIdUsuario(this));
        dtoOf.setPrograma(UtilidadesSession.getFuncion(this));
        if (despachoCompleto==null) {
            dtoOf.setDespachoCompleto(null);
        } else {
            dtoOf.setDespachoCompleto((despachoCompleto.equals("S"))?new Boolean(true):new Boolean(false));
        }

        if (despachoAutomatico==null) {
            dtoOf.setDespachoAutomatico(null);
        } else {
            dtoOf.setDespachoAutomatico((despachoAutomatico.equals("S"))?new Boolean(true):new Boolean(false));
        }        
        dtoOf.setOidIndCuadre(oidIndicadorCuadre); //no estaba en el dto //inc. 1911
        
        traza("numeroGruposCondicionados "+numeroGruposCondicionados+" numeroGruposCondicionantes"+numeroGruposCondicionantes);
        if ((new Integer(dtoCritDefOf.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.CONDICIONADA) {
          dtoOf.setNumeroGrupos(new Integer(numeroGruposCondicionados.intValue()+numeroGruposCondicionantes.intValue()));
        } else {
          dtoOf.setNumeroGrupos(numeroGrupos); // No podra ser mayor que el valor definido para la estrategia 
                                               // DTOSCargarCriteriosDefinirOferta.estrategia.maxGrupos
        }
        dtoOf.setNumeroPaquetes(numeroPaquetes); // Si esta habilitado sera obligatorio haber introducido un 
                                                 // valor. No podra ser mayor que el valor definido para 
                                                 //la estrategia DTOSCargarCriteriosDefinirOferta.estrategia.maxGrupos  

        dtoOf.setNumeroGruposCondicionantes(numeroGruposCondicionantes); // Si esta habilitado sera obligatorio 

        //haber introducido un valor. No podra ser mayor que el valor 
        //definido para la estrategia DTOSCargarCriteriosDefinirOferta.estrategia.maxGruposCondicionantes 
        dtoOf.setNumeroGruposCondicionados(numeroGruposCondicionados); // Si esta habilitado sera obligatorio

        if ((condicionCondicionantes != null) &&
                (!condicionCondicionantes.equals(""))) {
            dtoOf.setCondicionCondicionantes(condicionCondicionantes); //char// Si esta habilitado sera obligatorio haber introducido un valor. Solo admite los valores Y / O    
        } else {
            traza("No se seteo condicionCondicionantes.");
        }

        if ((condicionCondicionados != null) &&
                (!condicionCondicionados.equals(""))) {
            dtoOf.setCondicionCondicionados(condicionCondicionados); //char// Si esta habilitado sera obligatorio haber introducido un valor. Solo admite los valores Y / O    
        } else {
            traza("No se seteo condicionCondicionados.");
        }

        dtoOf.setPrimeraPosicionRanking(null);
        dtoOf.setUltimaPosicionRanking(null);
        dtoOf.setCodigoVentaGenerado(new Boolean(false));
        dtoOf.setMatrizFacturacionGenerada(new Boolean(false));
        dtoOf.setOidFormaPago(oidFormaPago);        
        //dtoOf.setRecuperacionObligatoria(new Boolean(false));        
        dtoOf.setRegistroEstadisticoGenerado(new Boolean(false));  

        /*Por cada producto añadido a la oferta (principal o asociado) se crea un DTODetalleOferta
          y se añade a DTOOferta
          Si existe producto principal, se habra guardado en sesión en el DTOProductoPrincipal.
          Si existen productos asociados, se habran guardado en sesión en el Vector productosAsociados*/
          Hashtable dtoProdPrinc = (Hashtable)( (conectorParametroSesion("ProductoOfertaPrincipal") == null) ? new Hashtable() 
                                                         : conectorParametroSesion("ProductoOfertaPrincipal")); 
          Hashtable dtoProdAsoc = (Hashtable)( (conectorParametroSesion("ProductosOferta") == null) ? new Hashtable() 
                                               : conectorParametroSesion("ProductosOferta"));
        Enumeration enum = dtoProdAsoc.elements();
        Enumeration enumPrinc = dtoProdPrinc.elements();
        //traza("crear3");
        Boolean productoPrincipal = (Boolean) conectorParametroSesion("productoPrincipal");
        Vector vDetallesOferta = new Vector();
        int lineaOferta = 1;

        while (enumPrinc.hasMoreElements()){//PRINCIPAL
            DTOProducto dtoProd = (DTOProducto) enumPrinc.nextElement();
            DTODetalleOferta dtoDetOf = new DTODetalleOferta();
            
            //if (productoPrincipal.booleanValue()){
                dtoDetOf.setLineaOferta(new Integer(lineaOferta));
                lineaOferta++;
                dtoDetOf.setOidSAP(dtoProd.getOid());
                dtoDetOf.setDescripcion(dtoProd.getTextoBreve());
                dtoDetOf.setUnidadesEstimadas(dtoProd.getUnidadesEstimadas());
                dtoDetOf.setOrigen(ConstantesPRE.MF);
                dtoDetOf.setFactorRepeticion(dtoProd.getFactorRepeticion()); //Dif tipos de dato 1913 (+)
                //cambio por inc 10779
                dtoDetOf.setDigitable(dtoProd.getDigitable());//dtoDetOf.setDigitable(new Boolean(true));
                dtoDetOf.setImpresionGP(dtoProd.getImprimible());//dtoDetOf.setImpresionGP(new Boolean(true));
                dtoDetOf.setPosicionRanking(null);
                dtoDetOf.setOidFormaPago(oidFormaPago);
                //traza("crear4");
                dtoDetOf.setOidGrupo(null); //no estaba en el dto original del diseño
                dtoDetOf.setProductoPrincipal(new Boolean(true));
                dtoDetOf.setPrecioCatalogo(dtoProd.getPrecioCatalogo()); //uno es Float y el otro Double
                dtoDetOf.setPosicionPagina(dtoProd.getPosicionPagina());
                dtoDetOf.setPrecioPosicionamiento(dtoProd.getPrecioPosicionamiento());
                //dtoDetOf.setOidMoneda(dtoCritDefOf.getOidMoneda());
                dtoDetOf.setCosteEstandar(dtoProd.getCosteEstandar());
                dtoDetOf.setVentaNetaEstimada(dtoProd.getVentaNetaEstimada());
                dtoDetOf.setOidCatalogo(dtoProd.getOidCatalogo());
                dtoDetOf.setPaginaCatalogo(dtoProd.getPaginaCatalogo());
                dtoDetOf.setOidCondicionPromocion(dtoProd.getOidCondicionPromocion());
                dtoDetOf.setOidTipoOferta(dtoProd.getOidTipoOferta());
                dtoDetOf.setOidCicloVida(dtoProd.getOidCicloVida());
                dtoDetOf.setCentro(dtoProd.getCentro());
                dtoDetOf.setCodigoVentaGenerado(new Boolean(false));
                dtoDetOf.setMatrizFacturacionGenerada(new Boolean(false));
                dtoDetOf.setOidIdioma(UtilidadesSession.getIdioma(this));
                dtoDetOf.setOidPais(UtilidadesSession.getPais(this));
                dtoDetOf.setIpCliente(UtilidadesSession.getIdUsuario(this));
                dtoDetOf.setPrograma(UtilidadesSession.getFuncion(this));
				/*enozigli SC-PRE-MAE-INT-001-1*/
				dtoDetOf.setProgramaFidelizacion(dtoProd.getProgramaFidelizacion());
				dtoDetOf.setVariantes(dtoProd.getVariantes());
				dtoDetOf.setPuntajeFijo(dtoProd.getPuntajeFijo());
                //traza("crear5");
                vDetallesOferta.add(dtoDetOf);
              } 
            while (enum.hasMoreElements()) {//ASOCIADOS 
                //traza("crear6"); 
    
                DTOProducto dtoProd = (DTOProducto) enum.nextElement(); 
                DTODetalleOferta dtoDetOf = new DTODetalleOferta(); 

                dtoDetOf.setLineaOferta(new Integer(lineaOferta));
                lineaOferta++;
                dtoDetOf.setOidSAP(dtoProd.getOid());
                dtoDetOf.setDescripcion(dtoProd.getTextoBreve());
                dtoDetOf.setUnidadesEstimadas(dtoProd.getUnidadesEstimadas());
                dtoDetOf.setOrigen(ConstantesPRE.MF);
                dtoDetOf.setFactorRepeticion(dtoProd.getFactorRepeticion()); // inc. 1913
                //cambio por inc 10779
                dtoDetOf.setDigitable(dtoProd.getDigitable());//dtoDetOf.setDigitable(new Boolean(false));
                dtoDetOf.setImpresionGP(dtoProd.getImprimible());//dtoDetOf.setImpresionGP(new Boolean(false));
                dtoDetOf.setPosicionRanking(null);
                dtoDetOf.setOidFormaPago(oidFormaPago);
                dtoDetOf.setOidGrupo(null); //no estaba en el dto original del diseño
                dtoDetOf.setProductoPrincipal(new Boolean(false));
                dtoDetOf.setPrecioCatalogo(dtoProd.getPrecioCatalogo()); //uno es Float y el otro Double
                dtoDetOf.setPosicionPagina(dtoProd.getPosicionPagina());
                dtoDetOf.setPrecioPosicionamiento(dtoProd.getPrecioPosicionamiento());
                //dtoDetOf.setOidMoneda(dtoCritDefOf.getOidMoneda());
                dtoDetOf.setCosteEstandar(dtoProd.getCosteEstandar());
                dtoDetOf.setVentaNetaEstimada(dtoProd.getVentaNetaEstimada());
                dtoDetOf.setOidCatalogo(dtoProd.getOidCatalogo());
                dtoDetOf.setPaginaCatalogo(dtoProd.getPaginaCatalogo());
                dtoDetOf.setOidCondicionPromocion(dtoProd.getOidCondicionPromocion());
                dtoDetOf.setOidTipoOferta(dtoProd.getOidTipoOferta());
                dtoDetOf.setOidCicloVida(dtoProd.getOidCicloVida());
                dtoDetOf.setCentro(dtoProd.getCentro());
                dtoDetOf.setCodigoVentaGenerado(new Boolean(false));
                dtoDetOf.setMatrizFacturacionGenerada(new Boolean(false));
                dtoDetOf.setOidIdioma(UtilidadesSession.getIdioma(this));
                dtoDetOf.setOidPais(UtilidadesSession.getPais(this));
                dtoDetOf.setIpCliente(UtilidadesSession.getIdUsuario(this));
                dtoDetOf.setPrograma(UtilidadesSession.getFuncion(this));
				/*enozigli SC-PRE-MAE-INT-001-1*/
				dtoDetOf.setProgramaFidelizacion(dtoProd.getProgramaFidelizacion());
				dtoDetOf.setVariantes(dtoProd.getVariantes());
				dtoDetOf.setPuntajeFijo(dtoProd.getPuntajeFijo());
                vDetallesOferta.add(dtoDetOf);
            }
        //}

        //traza("crear7");

        //No se realiza la parte del diseño en donde dice que se agregen las ventas exclusivas porque se van
        //agregando una a una cuando se seleccionan en el caso de uso.
        //Se vuelve a colocar en sesion el DTOOferta porque se guarda al final todo.
        dtoOf.setDetalleOferta(vDetallesOferta);
        conectorParametroSesion("DTOOferta", dtoOf);

        //Se comprueba si la oferta requiere promociones, grupos y control de ranking
        Boolean promociones = new Boolean(false);
        Boolean grupos = new Boolean(false);
        Boolean ranking = new Boolean(false);

        //traza("crear8");

        if ((dtoCritDefOf.getTipoEstrategia().isEstrategiaVS() != null) &&
                dtoCritDefOf.getTipoEstrategia().isEstrategiaVS().equals(new Boolean(
                        true))) {
            promociones = new Boolean(true);
        }

        if (((dtoOf.getNumeroGrupos() != null) &&
                (dtoOf.getNumeroGrupos().compareTo(new Integer(0)) > 0)) ||
                ((dtoOf.getNumeroPaquetes() != null) &&
                (dtoOf.getNumeroPaquetes().compareTo(new Integer(0)) > 0))) {
            grupos = new Boolean(true);
        }

        if ((dtoCritDefOf.getEstrategia().getListaRanking() != null) &&
                dtoCritDefOf.getEstrategia().getListaRanking().equals(new Boolean(
                        true))) {
            ranking = new Boolean(true);
        }

        //traza("crear9");
        conectorParametroSesion("promociones", promociones);
        conectorParametroSesion("grupos", grupos);
        conectorParametroSesion("ranking", ranking);

        //accion = "Comprobar parametros"  no existe esta accion en la LP //Inc. 1939 (dice que esto no va)
    }

    private void buscarProductoAsociado() throws Exception {    
        if (oidAcceso!=null)
            conectorParametroSesion("oidAcceso", oidAcceso);
        if (oidSubacceso!=null)
            conectorParametroSesion("oidSubacceso", oidSubacceso);
        conectorParametroSesion("productoPrincipal", new Boolean(false));
        
        String soidCatalogo = conectorParametroLimpia("cbCatalogo","",true);
        String descripcionCatalogo = conectorParametroLimpia("descCatalogo","",true);

        conectorParametroSesion("oidCatalogo", soidCatalogo);
        conectorParametroSesion("descripcionCatalogo", descripcionCatalogo);
        conectorParametroSesion("volverLPBuscarProducto", "LPDefinirOferta");        
        conectorAction("LPBuscarProducto");
        conectorActionParametro("multiseleccion", "true");
        conectorActionParametro("mostrarValoresAdicionales", "true");
    }

    private void productoSeleccionado() throws Exception { //Inc. 1895 rechazada
        traza("Volvi de Buscar Producto");

        Boolean productoPrincipal = (Boolean) conectorParametroSesion(
                "productoPrincipal");
        traza("productoPrincipal: " + productoPrincipal);
        
        if (productoPrincipal!=null) {       
        
            Hashtable htp = (Hashtable) conectorParametroSesion("Productos");
            //traza("Hash Devuelto: " + htp);
            Hashtable htpOf = null;
            
            if (productoPrincipal.booleanValue()==true){
                htpOf = (Hashtable) conectorParametroSesion("Productos");
                conectorParametroSesion("ProductoOfertaPrincipal",htpOf); 
            } else {            
                if (conectorParametroSesion("ProductosOferta")!=null){
                  htpOf = (Hashtable) conectorParametroSesion("ProductosOferta");
              
                  Enumeration enProd = htp.elements();
                  while  (enProd.hasMoreElements()) {
                        DTOProducto dtoP = (DTOProducto) enProd.nextElement();
                        Enumeration enProdOfer = htpOf.elements();
                        //boolean noesta = true;
                        while (enProdOfer.hasMoreElements()) {
                              DTOProducto dtoPOf = (DTOProducto) enProdOfer.nextElement();
                              if (dtoP.getOid().equals(dtoPOf.getOid())){
                                //noesta = false;
                                htpOf.remove(dtoPOf);
                              }
                        }
                        /*if (noesta)*/ htpOf.put(dtoP.getOid(), dtoP);
                  }
                } else {
                  htpOf = (Hashtable) conectorParametroSesion("Productos");
                }
            //}
            conectorParametroSesion("ProductosOferta",htpOf);           
        }
    }
   }
    private void agregarProductoALista() throws Exception {
        traza("Volvi de Buscar Producto");

        Boolean productoPrincipal = (Boolean) conectorParametroSesion(
                "productoPrincipal");
        //if (productoPrincipal!=null) {        
            traza("productoPrincipal: " + productoPrincipal);

            Hashtable htp = (Hashtable) conectorParametroSesion("ProductosOferta");
            //traza("Hash Devuelto Asociados: " + htp);
            
            String listado = "listado2";
            if (htp!=null){ 
             generaRecordSetProductos(htp, false, listado);
            /*String listado = productoPrincipal.booleanValue() ? "listado1"
                                                              : "listado2";
            generaRecordSetProductos(htp, productoPrincipal.booleanValue(), listado);*/
            }
             Hashtable htpprinc = (Hashtable) conectorParametroSesion("ProductoOfertaPrincipal"); 
             //traza("Hash Devuelto Principal: " + htpprinc); 
                      
             if (htpprinc!=null){ 
                      listado = "listado1"; 
                      generaRecordSetProductos(htpprinc, true, listado); 
             } 
     //      } 
    }

    private void generaRecordSetProductos(Hashtable table, boolean principal,
        String listado) throws Exception {
        RecordSet recordSet = new RecordSet();

        if (table.size() == 0) {
            traza("hash vacio");

            // throw new RuntimeException();
        }

        if ((table.size() > 1) && principal) {
            traza("Hash con mas de un elemento para principal");
            throw new RuntimeException();
        }

        //recordSet.setRowCount(table.size() - 1);
        DTOSCargarCriteriosDefinirOferta ccdo = (DTOSCargarCriteriosDefinirOferta)this.conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        llenarRecordSetProductos(recordSet);

        Enumeration enum = table.elements();
        int i = 0;

        while (enum.hasMoreElements()) {
            DTOProducto dto = (DTOProducto) enum.nextElement();
            recordSet.addRow(new Vector());
            recordSet.setValueAt(dto.getOid(), i, 0);

            /*if (dto.getCodigoSAP() != null) recordSet.setValueAt(dto.getCodigoSAP(), i, 1);            
            if (dto.getDescripcionSAP() != null) recordSet.setValueAt(dto.getDescripcionSAP(), i, 2);            
            if (dto.getPrecioCatalogo() != null) recordSet.setValueAt(dto.getPrecioCatalogo(), i, 3);            
            if (dto.getPaginaCatalogo() != null) recordSet.setValueAt(dto.getPaginaCatalogo(), i, 4);            
            if (dto.getDescripcionTipoOferta() != null) recordSet.setValueAt(dto.getDescripcionTipoOferta(), i, 5);            
            if (dto.getDescripcionCicloVida() != null) recordSet.setValueAt(dto.getDescripcionCicloVida(), i, 6);            
            if (dto.getAtributo1() != null) recordSet.setValueAt(dto.getAtributo1(), i, 7);            
            if (dto.getAtributo2() != null) recordSet.setValueAt(dto.getAtributo2(), i, 8);            
            if (dto.getAtributo3() != null) recordSet.setValueAt(dto.getAtributo3(), i, 9);            
            if (dto.getPosicionPagina() != null) recordSet.setValueAt(dto.getPosicionPagina(), i, 10);            
            if (dto.getUnidadesEstimadas() != null) recordSet.setValueAt(dto.getUnidadesEstimadas(), i, 11);            
            if (dto.getFactorRepeticion() != null) recordSet.setValueAt(dto.getFactorRepeticion(), i, 12);            
            if (dto.getVentaNetaEstimada() != null) recordSet.setValueAt(dto.getVentaNetaEstimada(), i, 13);            
            if (dto.getPrecioPosicionamiento() != null) recordSet.setValueAt(dto.getPrecioPosicionamiento(), i, 14);            
            if (dto.getCosteEstandar() != null) recordSet.setValueAt(dto.getCosteEstandar(), i, 15);            
            if (dto.getOidCatalogo() != null) recordSet.setValueAt(dto.getOidCatalogo(), i, 16);            
            //recordSet.setValueAt(null,i,17);//no esta la descripcion del catalogo en el dto
            if (dto.getOidTipoOferta() != null) recordSet.setValueAt(dto.getOidTipoOferta(), i, 18);            
            if (dto.getOidCicloVida() != null) recordSet.setValueAt(dto.getOidCicloVida(), i, 19);
            if (dto.getCentro() != null)  recordSet.setValueAt(dto.getCentro(), i, 20); */
            //Por cambio
            if (dto.getCodigoSAP() != null) recordSet.setValueAt(dto.getCodigoSAP(), i, 1);            
            if (dto.getTextoBreve() != null) recordSet.setValueAt(dto.getTextoBreve(), i, 2);
            if (dto.getDescripcionTipoOferta() != null){
                recordSet.setValueAt(dto.getDescripcionTipoOferta(), i, 3);
            } else {
              RecordSet rs = ccdo.getTiposOferta();
              if (dto.getOidTipoOferta()!=null && !rs.esVacio()) {                
                for(int j=0; j<rs.getRowCount(); j++){  
                    Long tipoOfert = rs.getValueAt(j,0)==null ? null : new Long(rs.getValueAt(j,0).toString());
                    if(tipoOfert.equals(dto.getOidTipoOferta()) ){
                        recordSet.setValueAt(rs.getValueAt(j,1), i, 3);
                        break;
                    }
                }              
              }
            }
            if (dto.getDescripcionCicloVida() != null){
                recordSet.setValueAt(dto.getDescripcionCicloVida(), i, 4);
            } else {
               RecordSet rs = ccdo.getCiclosVida();
               if (dto.getOidCicloVida()!=null && !rs.esVacio() ) {                
                for(int j=0; j<rs.getRowCount(); j++){  
                    Long civi = rs.getValueAt(j,0)==null ? null : new Long(rs.getValueAt(j,0).toString());
                    if(civi.equals(dto.getOidCicloVida()) ){
                        recordSet.setValueAt(rs.getValueAt(j,1), i, 4);
                        break;
                    }
                }                 
               }
            }
            if (dto.getFactorRepeticion() != null) recordSet.setValueAt(dto.getFactorRepeticion(), i, 5);
            if (dto.getPrecioCatalogo() != null) recordSet.setValueAt(UtilidadesBelcorp.formateaNumeroSICC(dto.getPrecioCatalogo().toString(),  this.FORMATO_DEFAULT,this), i, 6);
            if (dto.getAtributo1() != null) recordSet.setValueAt(dto.getAtributo1(), i, 7);            
            if (dto.getAtributo2() != null) recordSet.setValueAt(dto.getAtributo2(), i, 8);            
            if (dto.getAtributo3() != null) recordSet.setValueAt(dto.getAtributo3(), i, 9);
            if (dto.getPaginaCatalogo() != null) recordSet.setValueAt(dto.getPaginaCatalogo(), i, 10);            
            if (dto.getPosicionPagina() != null) recordSet.setValueAt(dto.getPosicionPagina(), i, 11);            
            if (dto.getUnidadesEstimadas() != null) recordSet.setValueAt(dto.getUnidadesEstimadas(), i, 12);            
            if (dto.getVentaNetaEstimada() != null) recordSet.setValueAt(dto.getVentaNetaEstimada(), i, 13);            
            if (dto.getPrecioPosicionamiento() != null) recordSet.setValueAt(dto.getPrecioPosicionamiento(), i, 14);            
            if (dto.getCosteEstandar() != null) recordSet.setValueAt(dto.getCosteEstandar(), i, 15);            
            if (dto.getOidCatalogo() != null) recordSet.setValueAt(dto.getOidCatalogo(), i, 16);            
            //recordSet.setValueAt(null,i,17);//no esta la descripcion del catalogo en el dto
            if (dto.getOidTipoOferta() != null) recordSet.setValueAt(dto.getOidTipoOferta(), i, 18);            
            if (dto.getOidCicloVida() != null) recordSet.setValueAt(dto.getOidCicloVida(), i, 19);
            if (dto.getCentro() != null)  recordSet.setValueAt(dto.getCentro(), i, 20);

            i++;
        }

        asignar("LISTADOA", listado,
            UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()), "dtoSalida");
        //conectorParametroSesion("DTOProductoPrincipal", table); //Subo la hash, no el dto
    }

    private void llenarRecordSetProductos(RecordSet r) {
        /*r.addColumn("OID");
        r.addColumn("COD_SAP");
        r.addColumn("DES_SAP");
        r.addColumn("IMP_PREC_CATA");
        r.addColumn("NUM_PAGI_CATA");
        r.addColumn("DES_TIPO_OFER");
        r.addColumn("DES_CICL_VIDA");
        r.addColumn("VAL_ATRI_1");
        r.addColumn("VAL_ATRI_2");
        r.addColumn("VAL_ATRI_3");
        r.addColumn("VAL_POSI_PAGI");
        r.addColumn("NUM_UNID_ESTI");
        r.addColumn("VAL_FACT_REPE");
        r.addColumn("IMP_VENT_NETA");
        r.addColumn("IMP_PREC_POSI");
        r.addColumn("VAL_COST_ESTA");
        r.addColumn("OCAT_OID_CATA");
        r.addColumn("DES_CATA");
        r.addColumn("TOFE_OID_TIPO_OFER");
        r.addColumn("CIVI_OID_CICL_VIDA");
        r.addColumn("VAL_CENT");*/
        r.addColumn("OID");
        r.addColumn("COD_SAP");
        r.addColumn("VAL_TEXT_BREV");
        r.addColumn("DES_TIPO_OFER");
        r.addColumn("DES_CICL_VIDA");
        r.addColumn("VAL_FACT_REPE");
        r.addColumn("IMP_PREC_CATA");
        r.addColumn("VAL_ATRI_1");
        r.addColumn("VAL_ATRI_2");
        r.addColumn("VAL_ATRI_3");
        r.addColumn("NUM_PAGI_CATA");
        r.addColumn("VAL_POSI_PAGI");
        r.addColumn("NUM_UNID_ESTI");
        r.addColumn("IMP_VENT_NETA");
        r.addColumn("IMP_PREC_POSI");
        r.addColumn("VAL_COST_ESTA");
        r.addColumn("OCAT_OID_CATA");
        r.addColumn("DES_CATA");
        r.addColumn("TOFE_OID_TIPO_OFER");
        r.addColumn("CIVI_OID_CICL_VIDA");
        r.addColumn("VAL_CENT");
    }

    private void llenarRecordSetVentaExclusiva(RecordSet r) {
        r.addColumn("OID");
        r.addColumn("DES_TIPO_CLIE");
        r.addColumn("DES_SUB_TIPO_CLIE");
        r.addColumn("DES_TIPO_CLAS");
        r.addColumn("DES_CLAS");
        r.addColumn("ESTATUS1");
        r.addColumn("ESTATUS2");        
    }

    private void matrizSeleccionada() throws Exception {
        conectorParametroSesion("UltimaLP", "LPDefinirOferta");
        conectorAction("LPSeleccionarEstrategia");
    }

    private void cambiaNumeroGrupos() throws Exception { //Inc. 1887 y 1885

        DTOSCargarCriteriosDefinirOferta dtoS = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion(
                "DTOSCargarCriteriosDefinirOferta");

        //se recupera el valor del campo numero de grupos
        String snumGrupos = conectorParametro("txtNGrupos");
        int nroGrp = 0;
        traza("cambiaNumeroGrupos1" + snumGrupos);

        if ((snumGrupos != null) && (!snumGrupos.equals(""))) {
            nroGrp = (new Integer(snumGrupos)).intValue();

            if (nroGrp > 0) {
                if (nroGrp == 1) {
                    //Cargar en el combo los indicadores con 
                    //PRESCargarCriteriosDefinirOferta.indicadoresCuadre.monogrupo == True
                    RecordSet rs = dtoS.getIndicadoresCuadre();

                    RecordSet rsFiltra = new RecordSet();
                    rsFiltra = RecordSet.clone(rs);

                    int cantRows = rsFiltra.getRowCount();

                    //Hay que filtrar el Recordset y generar el conector
                    traza("cambiaNumeroGrupos1a");

                    for (int i = (cantRows - 1); i >= 0; i--) {
                        /*traza("clase:" +
                            rsFiltra.getValueAt(i, "IND_OFER_MONO_GRUP")
                                    .getClass().getName());*/

                        if (((String) rsFiltra.getValueAt(i,
                                    "IND_OFER_MONO_GRUP")).equals(
                                    new String("1"))) {
                            //este registro va                          
                        } else {
                            //se quita esta fila
                            rsFiltra.removeRow(i);
                        }
                    }

                    //traza("cambiaNumeroGrupos1a1");
                    asignar("COMBO", "cbIdCuadre",
                        UtilidadesBelcorp.generarConector("dtoSalida",
                            rsFiltra, rsFiltra.getColumnIdentifiers()),
                        "dtoSalida");
                } else {
                    //Cargar en el combo los indicadores con 
                    //PRECargarCriteriosDefinirOferta.indicadoresCuadre.monogrupo == False
                    RecordSet rs = dtoS.getIndicadoresCuadre();
                    //traza("cambiaNumeroGrupos1b");

                    RecordSet rsFiltra = new RecordSet();
                    rsFiltra = RecordSet.clone(rs);

                    int cantRows = rsFiltra.getRowCount();

                    //Hay que filtrar el Recordset y generar el conector  
                    for (int i = (cantRows - 1); i >= 0; i--) {
                        if (((String) rsFiltra.getValueAt(i,
                                    "IND_OFER_MONO_GRUP")).equals(
                                    new String("0"))) {
                            //este registro va                          
                        } else {
                            //se quita esta fila
                            rsFiltra.removeRow(i);
                        }
                    }

                    //traza("cambiaNumeroGrupos1b1");
                    asignar("COMBO", "cbIdCuadre",
                        UtilidadesBelcorp.generarConector("dtoSalida",
                            rsFiltra, rsFiltra.getColumnIdentifiers()),
                        "dtoSalida");
                }
            }
        } else {
            //el campo numero de grupos no tiene valor
            traza("el campo numero de grupos no tiene valor");
        }
    }

    private void anadirVentaExclusiva() throws Exception {
        this.recuperaValoresPantalla();


        DTOVentaExclusiva dtoV = new DTOVentaExclusiva();
        dtoV.setOidClasificacion(oidClasificacion);
        dtoV.setDescripcionClasificacion(desClasificacion);
        dtoV.setOidTipoClasificacion(oidTipoClasificacion);
        dtoV.setDescripcionTipoClasificacion(desTipoClasificacion);
        dtoV.setOidTipoCliente(oidTipoCliente);
        dtoV.setDescripcionTipoCliente(desTipoCliente);
        dtoV.setOidSubtipoCliente(oidSubtipoCliente);
        dtoV.setDescripcionSubtipoCliente(desSubtipoCliente);
        dtoV.setOidEstatus(oidEstatus);
        dtoV.setDescripcionEstatus(desEstatus);
        dtoV.setEstatus2(estatus2);

        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
        traza("anadirVentaExclusiva1"+dtoV);
        if (dto.getVentaExclusiva() == null) {
            dto.setVentaExvlusiva(new Vector());
            dtoV.setOidVentaExclusiva(new Long(1));
            traza("anadirVentaExclusiva2a");
        } else {
            Vector v = dto.getVentaExclusiva();
           
            Enumeration enVec = v.elements();
            Long maxOid = new Long(0);
            traza("anadirVentaExclusiva2b");
            while (enVec.hasMoreElements()) {
                traza("anadirVentaExclusiva2b1");
                DTOVentaExclusiva dtoAux = (DTOVentaExclusiva) enVec.nextElement();
                if (((dtoAux.getOidClasificacion()!=null&&dtoAux.getOidClasificacion().equals(dtoV.getOidClasificacion()))||(dtoAux.getOidClasificacion()==null&&dtoV.getOidClasificacion()==null))&&
                    ((dtoAux.getOidTipoClasificacion()!=null&&dtoAux.getOidTipoClasificacion().equals(dtoV.getOidTipoClasificacion()))||(dtoAux.getOidTipoClasificacion()==null&&dtoV.getOidTipoClasificacion()==null))&&
                    ((dtoAux.getOidClasificacion()!=null&&dtoAux.getOidTipoCliente().equals(dtoV.getOidTipoCliente()))||(dtoAux.getOidClasificacion()==null&&dtoV.getOidClasificacion()==null))&&
                    ((dtoAux.getOidSubtipoCliente()!=null&&dtoAux.getOidSubtipoCliente().equals(dtoV.getOidSubtipoCliente()))||(dtoAux.getOidSubtipoCliente()==null&&dtoV.getOidSubtipoCliente()==null))&&
                    ((dtoAux.getOidEstatus()!=null&&dtoAux.getOidEstatus().equals(dtoV.getOidEstatus()))||(dtoAux.getOidEstatus()==null&&dtoV.getOidEstatus()==null))){
                    throw new MareException(new Exception(),50047);
                }  
                traza("anadirVentaExclusiva2b2");
                if ((dtoAux.getOidVentaExclusiva() != null) &&
                        (maxOid.longValue() < dtoAux.getOidVentaExclusiva()
                                                        .longValue())) {
                    maxOid = dtoAux.getOidVentaExclusiva();
                }
                traza("anadirVentaExclusiva3maxoid"+maxOid);
            }
            traza("anadirVentaExclusiva4");
            maxOid = new Long(maxOid.longValue() + 1);
            dtoV.setOidVentaExclusiva(maxOid);
            traza("anadirVentaExclusiva5");
        }

        dto.getVentaExclusiva().add(dtoV);
        traza("anadirVentaExclusiva6");
        conectorParametroSesion("DTOOferta", dto);
        
    }

    private void eliminarVentaExclusiva() throws Exception {
        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
        elementosSeleccionadosVentaExclusiva = conectorParametro("elemSelecc");

        Vector elem = parsearElementosLista(elementosSeleccionadosVentaExclusiva);
        Enumeration enum = elem.elements();

        while (enum.hasMoreElements()) {
            Long oid = (Long) enum.nextElement();
            Enumeration enumV = dto.getVentaExclusiva().elements();

            while (enumV.hasMoreElements()) {
                DTOVentaExclusiva dtoV = (DTOVentaExclusiva) enumV.nextElement();

                if (dtoV.getOidVentaExclusiva().equals(oid)) {
                    if (dto.getVentaExclusiva().contains(dtoV)) {
                        dto.getVentaExclusiva().remove(dtoV);
                    } else {
                        traza(
                            "No puedo encontrar la venta Exclusiva en el DTOOferta");
                    }
                }
            }
        }

        conectorParametroSesion("DTOOferta", dto);
        cambiaVentaExclusiva(dto.getVentaExclusiva());
    }

    private void cambiaVentaExclusiva(Vector vec) throws Exception { //Asigna a la pantalla las ventas exclusivas

        RecordSet recordSet = new RecordSet();
        llenarRecordSetVentaExclusiva(recordSet);

        Enumeration enum = vec.elements();
        //recordSet.setRowCount(vec.size() - 1);

        int i = 0;
        traza("cambiaVentaExclusiva1"+vec.size());

        while (enum.hasMoreElements()) {
            recordSet.addRow(new Vector());

            DTOVentaExclusiva dto = (DTOVentaExclusiva) enum.nextElement();
            recordSet.setValueAt(dto.getOidVentaExclusiva(), i, 0);
            //traza("cambiaVentaExclusiva1_" + i +" "+dto.getDescripcionTipoCliente());
            recordSet.setValueAt(dto.getDescripcionTipoCliente(), i, 1);
            recordSet.setValueAt(dto.getDescripcionSubtipoCliente(), i, 2);
            recordSet.setValueAt(dto.getDescripcionTipoClasificacion(), i, 3);
            recordSet.setValueAt(dto.getDescripcionClasificacion(), i, 4);
            recordSet.setValueAt(dto.getDescripcionEstatus(), i, 5);
            recordSet.setValueAt(dto.getEstatus2(), i, 6);
            i++;
        }
        //traza("recordset "+recordSet.toString());

        /*traza("cambiaVentaExclusiva2"+UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()).getXML());*/
        asignar("LISTADOA", "listado3",
            UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()), "dtoSalida");
        traza("cambiaVentaExclusiva3");
    }
    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }  
    private Integer BigToInteger(Object num) {
        if (num != null) {
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            return null;
        }
    }
    private void cargarPantalla() throws Exception {
        traza("entro de cargarPantalla()");
        pagina("contenido_oferta_definir");

        this.getConfiguracionMenu("LPDefinirOferta", "");

        oidCabeceraMF = (Long) conectorParametroSesion("oidCabeceraMF");
        oidEstrategia = (Long) conectorParametroSesion("oidEstrategia");

        if (conectorParametroSesion("DTOSCargarCriteriosDefinirOferta") == null) {
            DTOECargarCriteriosDefinirOferta dto = new DTOECargarCriteriosDefinirOferta();
            dto.setOidCabeceraMF(oidCabeceraMF);
            dto.setOidEstrategia(oidEstrategia);
            dto.setOidPais(pais);
            dto.setOidIdioma(idioma);
            dto.setIpCliente(UtilidadesSession.getIdUsuario(this));
            dto.setPrograma(UtilidadesSession.getFuncion(this));

            MareBusinessID bid = new MareBusinessID(
                    "PRECargarCriteriosDefinirOferta");
            Vector vec = new Vector();
            vec.add(dto);
            vec.add(bid);
            traza("cargarPantalla();--1--llamando al conector");

            DTOSCargarCriteriosDefinirOferta dtoS = (DTOSCargarCriteriosDefinirOferta) conectar("ConectorCargarCriteriosDefinirOferta",
                    vec).objeto("dtoSalida");
            traza("acc sbac def " + UtilidadesSession.getAccesoPorDefecto(this) + " "+UtilidadesSession.getSubaccesoPorDefecto(this));
            if (UtilidadesSession.getAccesoPorDefecto(this)!=null)
              asignarAtributo("VAR","hAccesoDef","valor",UtilidadesSession.getAccesoPorDefecto(this).toString());
            if (UtilidadesSession.getSubaccesoPorDefecto(this)!=null)              
              asignarAtributo("VAR","hSubaccesoDef","valor",UtilidadesSession.getSubaccesoPorDefecto(this).toString());
            asignarAtributo("VAR","primeraEjecucion","valor","true");
            conectorParametroSesion("DTOSCargarCriteriosDefinirOferta", dtoS); //Esta linea siempre debe estar antes de llamar al metodo configurarPantalla()
            //traza("cargarPantalla();--3--llamando a confirgurar pantalla");
        }

        DTOSCargarCriteriosDefinirOferta dtoS = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion(
                "DTOSCargarCriteriosDefinirOferta");

        //obtengo el argumento de venta del tipo de estrategia y si hay mas de uno obtengo el de 
        //COD_ARGUM_VENTA mas bajo
        RecordSet rsArg = dtoS.getArgumentosVenta();
        Long oidTipoEstraOferta = dtoS.getEstrategia().getOidTipoEstr();
        Long oidArguPosi = null;
        Integer codArguPosi = null;
        for(int i=0;i<rsArg.getRowCount();i++){
            Long oidArguAct = BigToLong(rsArg.getValueAt(i,"OID_ARGU_VENT"));
            Long oidTipoEsAct = BigToLong(rsArg.getValueAt(i,"TIES_OID_TIPO_ESTR"));
            Integer codArguAct = BigToInteger(rsArg.getValueAt(i,"COD_ARGU_VENT"));
            if (i==0){
               oidArguPosi = oidArguAct;
            }            
            if ((oidTipoEsAct!=null)&&(oidTipoEsAct.equals(oidTipoEstraOferta))){
               if((codArguPosi==null)||(codArguAct.compareTo(codArguPosi)<0)){
                  codArguPosi = codArguAct;
                  oidArguPosi = oidArguAct;
               }
            }
        }
        
        //seteo las variables para las validaciones
        asignarAtributo("VAR","argumentoVta","valor",((oidArguPosi==null)?"":oidArguPosi.toString()));
        asignarAtributo("VAR","maxGrupo","valor",((dtoS.getEstrategia().getMaxGrupos()==null)?"":dtoS.getEstrategia().getMaxGrupos().toString()));
        asignarAtributo("VAR","maxGruposCondicionantes","valor",((dtoS.getEstrategia().getMaxGruposCondicionantes()==null)?"":dtoS.getEstrategia().getMaxGruposCondicionantes().toString()));
        asignarAtributo("VAR","maxGruposCondicionados","valor",((dtoS.getEstrategia().getMaxGruposCondicionados()==null)?"":dtoS.getEstrategia().getMaxGruposCondicionados().toString()));
        //asignarAtributo("VAR","hArgumentoVenta","valor",((dtoS.getTipoEstrategia().getgetMaxGruposCondicionantes()==null)?"":dtoS.getEstrategia().getMaxGruposCondicionantes().toString()));
        
        configurarPantalla();

        asignar("COMBO", "cbAcceso",
            UtilidadesBelcorp.generarConector("dtoSalida", dtoS.getAccesos(),
                dtoS.getAccesos().getColumnIdentifiers()), "dtoSalida");
        asignar("COMBO", "cbArgumentoVenta",
            UtilidadesBelcorp.generarConector("dtoSalida",
                dtoS.getArgumentosVenta(),
                dtoS.getArgumentosVenta().getColumnIdentifiers()), "dtoSalida");
        asignar("COMBO", "cbTipoCliente",
            UtilidadesBelcorp.generarConector("dtoSalida",
                dtoS.getTiposCliente(),
                dtoS.getTiposCliente().getColumnIdentifiers()), "dtoSalida");
        asignar("COMBO", "cbEstatusCliente",
            UtilidadesBelcorp.generarConector("dtoSalida", dtoS.getEstatus(),
                dtoS.getEstatus().getColumnIdentifiers()), "dtoSalida");
        asignar("COMBO", "cbFormaPago",
            UtilidadesBelcorp.generarConector("dtoSalida",
                dtoS.getFormasPago(),
                dtoS.getFormasPago().getColumnIdentifiers()), "dtoSalida");
        cargarCatalogo();        
        cambiaNumeroGrupos();

        traza("salio de cargarPantalla();");
    }

    private void buscarProductoPrincipal() throws Exception {
        traza("oidAcceso "+oidAcceso+" oidSubacceso "+oidSubacceso);
        if (oidAcceso!=null){
            conectorParametroSesion("oidAcceso", oidAcceso);
        }
        if (oidSubacceso!=null){
            conectorParametroSesion("oidSubacceso", oidSubacceso);
        }
        conectorParametroSesion("productoPrincipal", new Boolean(true));

        String soidCatalogo = conectorParametroLimpia("cbCatalogo","",true);
        String descripcionCatalogo = conectorParametroLimpia("descCatalogo","",true);

        conectorParametroSesion("oidCatalogo", soidCatalogo);
        conectorParametroSesion("descripcionCatalogo", descripcionCatalogo);
        conectorParametroSesion("volverLPBuscarProducto", "LPDefinirOferta");
        conectorAction("LPBuscarProducto");
        conectorActionParametro("multiseleccion", "false");
        conectorActionParametro("mostrarValoresAdicionales", "true");
    }

    private void eliminarProductosAsociados() throws Exception {
        traza("eliminarProductosAsociados1");
        elementosSeleccionadosProductosAsociados = conectorParametro("elemSelecc");
        Vector vec = this.parsearElementosLista(this.elementosSeleccionadosProductosAsociados);
        Hashtable hash = (Hashtable) conectorParametroSesion(
                "ProductosOferta");
        //traza("Hash Inicial"+hash);
        Enumeration enum = vec.elements();
        //traza("eliminarProductosAsociados2"+elementosSeleccionadosProductosAsociados +"  "+vec);
        while (enum.hasMoreElements()) {
            Long oid = (Long) enum.nextElement();
            Enumeration enum2 = hash.elements();
            traza("eliminarProductosAsociados3");
            while (enum2.hasMoreElements()) {
                DTOProducto dto = (DTOProducto) enum2.nextElement();
                traza("eliminarProductosAsociados3"+dto.getOid()+"  "+oid);
                if (dto.getOid().equals(oid)) {
                    hash.remove(oid);
                    traza("Borro");
                    //break;
                }
            }
        }
        //traza("Hash Final"+hash);
        conectorParametroSesion("ProductosOferta",hash);//igual se modifica el hash directo en sesion
        
        traza("eliminarProductosAsociados fin");
    }

    private void configurarPantalla() throws Exception {
        traza("configurarPantalla");

        DTOSCargarCriteriosDefinirOferta dtoS = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion(
                "DTOSCargarCriteriosDefinirOferta");

        numGrupos = new String("false");
        numPaqu = new String("false");
        indCuadre = new String("false");
        numGrupCondtes = new String("false");
        numGrupCondos = new String("false");
        condCondos = new String("false");
        condCondtes = new String("false");
        despAuto = new String("false");
        despCompl = new String("false");

        /*String btnBPPpal = new String("false");
        String btnBPAsoc = new String("false");*/
        traza("configurarPantalla1" +
            dtoS.getTipoEstrategia().getCodigoTipoEstrategia());

        if (((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_VARIABLE) ||
                ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO)) {
            numGrupos = "true";
            traza("configurarPantalla1a");
        } else {
            numGrupos = "false";
        }

        if ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO) {
            numPaqu = "true";
        } else {
            numPaqu = "false";
        }

        traza("configurarPantalla2");

        if (((dtoS.getTipoEstrategia().getEstrategiaGrupo() != null) &&
                dtoS.getTipoEstrategia().getEstrategiaGrupo().equals(new Boolean(
                        true))) &&
                (((dtoS.getEstrategia().getCuadreGrupos() != null) &&
                dtoS.getEstrategia().getCuadreGrupos().equals(new Boolean(false)))||
                (dtoS.getEstrategia().getCuadreGrupos()==null))) {
            indCuadre = "true";
        } else {
            indCuadre = "false";
        }

        if ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.CONDICIONADA) {
            numGrupCondtes = "true";
            numGrupCondos = "true";
            condCondos = "true";
            condCondtes = "true";
        } else {
            numGrupCondtes = "false";
            numGrupCondos = "false";
            condCondos = "false";
            condCondtes = "false";
        }

        traza("configurarPantalla3");

        if (((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.INDIVIDUAL_VS_GRUPO) ||
                ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO) ||
                ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO)) {
            condCondtes = "true";
            //condCondos = "true";
        }

        if ((dtoS.getEstrategia().getModificableDespachoAutomatico() != null) &&
                dtoS.getEstrategia().getModificableDespachoAutomatico().equals(new Boolean(
                        true))) {
            despAuto = "true";
        } else {
            despAuto = "false";
        }
        //se le asigna por defecto el valor que viene en el dto
        String cvDespAuto = new String("");

        if ((dtoS.getEstrategia().getCvDespachoAutomatico() != null) &&
                dtoS.getEstrategia().getCvDespachoAutomatico().equals(new Boolean(
                        true))) {
            cvDespAuto = "S";
        } else {
            cvDespAuto = "N";
        }
        asignarAtributo("VAR", "cvDespAuto", "valor", cvDespAuto);        

        traza("configurarPantalla4");

        //enozigli 16/12/2004 cambio por incidencia BELC300011333
        if (((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA) ||
                ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO)) {
            despCompl = "true";
        } else {
            despCompl = "false";
        }

        if (((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.INDIVIDUAL)|| 
                              ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA)){
            //habilitar boton buscar prod ppal
            btnBPPpal = "true";
        } else {
            //deshabilitar boton buscar prod ppal
            btnBPPpal = "false";
        }

        if (((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA) ||
                ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.INDIVIDUAL_VS_GRUPO)) {
            //habilitar boton buscar prod asoc
            btnBPAsoc = "true";
        } else {
            //deshabilitar boton buscar prod asoc
            btnBPAsoc = "false";
        }

        traza("configurarPantalla5");

        //asignaciones
        asignarAtributo("VAR", "numGrupos", "valor", numGrupos);
        asignarAtributo("VAR", "numPaqu", "valor", numPaqu);
        asignarAtributo("VAR", "indCuadre", "valor", indCuadre);
        asignarAtributo("VAR", "numGrupCondtes", "valor", numGrupCondtes);
        asignarAtributo("VAR", "numGrupCondos", "valor", numGrupCondos);
        asignarAtributo("VAR", "condCondos", "valor", condCondos);
        asignarAtributo("VAR", "condCondtes", "valor", condCondtes);
        asignarAtributo("VAR", "despAuto", "valor", despAuto);
        asignarAtributo("VAR", "despCompl", "valor", despCompl);
        asignarAtributo("VAR", "btnBPPpal", "valor", btnBPPpal);
        asignarAtributo("VAR", "btnBPAsoc", "valor", btnBPAsoc);
        traza("configurarPantalla fin");
    }

    //METODOS AGREGADOS DE SOPORTE A LA LP
    private Vector parsearElementosLista(String lista)
        throws Exception {
        Vector vec = new Vector();
        StringTokenizer st = new StringTokenizer(lista, "|");

      try{
        while (st.hasMoreElements()) {
            vec.addElement(new Long(st.nextToken()));
        }
      }catch(java.lang.NumberFormatException nf){
          StringTokenizer st2 = new StringTokenizer(lista, ",");
          while (st2.hasMoreElements()) {
            vec.addElement(new Long(st2.nextToken()));
          }
      }

        return vec;
    }
  

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    private void recuperaBanderasPantalla() throws Exception {
        numGrupos = conectorParametro("numGrupos");
        numPaqu = conectorParametro("numPaqu");
        indCuadre = conectorParametro("indCuadre");
        numGrupCondtes = conectorParametro("numGrupCondtes");
        numGrupCondos = conectorParametro("numGrupCondos");
        condCondos = conectorParametro("condCondos");
        condCondtes = conectorParametro("condCondtes");
        despAuto = conectorParametro("despAuto");
        despCompl = conectorParametro("despCompl");
        btnBPAsoc = conectorParametro("btnBPAsoc");
        btnBPPpal = conectorParametro("btnBPPpal");
    }

    private void recuperaValoresPantalla() throws Exception {
        traza("recuperaValoresPantalla");
        oidAcceso = ((conectorParametro("cbAcceso") == null) ||
            conectorParametro("cbAcceso").equals("")) ? null
                                                      : Long.valueOf(conectorParametro(
                    "cbAcceso"));
        traza("ParametroSubacceso"+conectorParametro("cbSubacceso"));
        oidSubacceso = ((conectorParametro("cbSubacceso") == null) ||
            conectorParametro("cbSubacceso").equals("")) ? null
                                                              : Long.valueOf(conectorParametro(
                    "cbSubacceso"));
        oidArgumentoVenta = ((conectorParametro("cbArgumentoVenta") == null) ||
            conectorParametro("cbArgumentoVenta").equals("")) ? null
                                                              : Long.valueOf(conectorParametro(
                    "cbArgumentoVenta"));
                    
        oidCatalogo = ((conectorParametro("cbCatalogo") == null) ||
            conectorParametro("cbCatalogo").equals("")) ? null
                                                              : Long.valueOf(conectorParametro(
                    "cbCatalogo"));
        if ((conectorParametro("ckDespachoCompleto") == null) ||
                conectorParametro("ckDespachoCompleto").equals("")) {
            despachoCompleto = null;
        } else {
            if (conectorParametro("ckDespachoCompleto").equals("S")) {
                despachoCompleto = "S";
            } else if (conectorParametro("ckDespachoCompleto").equals("N")) {
                despachoCompleto = "N";
            }
        }

        traza("recuperaValoresPantalla2");

        if ((conectorParametro("ckDespachoAutomatico") == null) ||
                conectorParametro("ckDespachoAutomatico").equals("")) {
            despachoAutomatico = null;
        } else {
            if (conectorParametro("ckDespachoAutomatico").equals("S")) {
                despachoAutomatico = "S";
            } else if (conectorParametro("ckDespachoAutomatico").equals("N")) {
                despachoAutomatico = "N";
            }
        }

        traza("recuperaValoresPantalla3");
        numeroGrupos = ((conectorParametro("txtNGrupos") == null) ||
            conectorParametro("txtNGrupos").equals("")) ? null
                                                        : Integer.valueOf(conectorParametro(
                    "txtNGrupos"));
        numeroPaquetes = ((conectorParametro("txtNPaquetes") == null) ||
            conectorParametro("txtNPaquetes").equals("")) ? null
                                                          : Integer.valueOf(conectorParametro(
                    "txtNPaquetes"));
        numeroGruposCondicionantes = ((conectorParametro(
                "txtNGrupCondicionantes") == null) ||
            conectorParametro("txtNGrupCondicionantes").equals("")) ? null
                                                                    : Integer.valueOf(conectorParametro(
                    "txtNGrupCondicionantes"));
        numeroGruposCondicionados = ((conectorParametro("txtNGrupCondicionados") == null) ||
            conectorParametro("txtNGrupCondicionados").equals("")) ? null
                                                                   : Integer.valueOf(conectorParametro(
                    "txtNGrupCondicionados"));
        traza("recuperaValoresPantalla4" + conectorParametro("txtNGrupos"));

        if ((conectorParametro("rbCondicionantes") == null) ||
                conectorParametro("rbCondicionantes").equals("")) {
            condicionCondicionantes = "";
        } else {
            condicionCondicionantes = (conectorParametro("rbCondicionantes")
                                           .equals("N")) ? "O" : "Y";
        }

        traza("condicionCondicionantes" +
            conectorParametro("rbCondicionantes"));

        if ((conectorParametro("rbCondicionados") == null) ||
                conectorParametro("rbCondicionados").equals("")) {
            condicionCondicionados = "";
        } else {
            condicionCondicionados = (conectorParametro("rbCondicionados")
                                          .equals("N")) ? "O" : "Y";
        }

        traza("condicionCondicionados" + conectorParametro("rbCondicionados"));

        oidFormaPago = ((conectorParametro("cbFormaPago") == null) ||
            conectorParametro("cbFormaPago").equals("")) ? null
                                                         : Long.valueOf(conectorParametro(
                    "cbFormaPago"));
        oidIndicadorCuadre = ((conectorParametro("cbIdCuadre") == null) ||
            conectorParametro("cbIdCuadre").equals("")) ? null : Long.valueOf(conectorParametro("cbIdCuadre"));

        traza("oidIndicadorCuadre "+oidIndicadorCuadre+" conectorParametro(cbIdCuadre) "+conectorParametro("cbIdCuadre"));
        oidClasificacion = ((conectorParametro("cbClasificacion") == null) ||
            conectorParametro("cbClasificacion").equals("")) ? null
                                                             : Long.valueOf(conectorParametro(
                    "cbClasificacion"));
        oidTipoClasificacion = ((conectorParametro("cbTipoClasificacion") == null) ||
            conectorParametro("cbTipoClasificacion").equals("")) ? null
                                                                 : Long.valueOf(conectorParametro(
                    "cbTipoClasificacion"));
        oidTipoCliente = ((conectorParametro("cbTipoCliente") == null) ||
            conectorParametro("cbTipoCliente").equals("")) ? null
                                                           : Long.valueOf(conectorParametro(
                    "cbTipoCliente"));
        oidSubtipoCliente = ((conectorParametro("cbSubtipoCliente") == null) ||
            conectorParametro("cbSubtipoCliente").equals("")) ? null
                                                              : Long.valueOf(conectorParametro(
                    "cbSubtipoCliente"));
        oidEstatus = ((conectorParametro("cbEstatusCliente") == null) ||
            conectorParametro("cbEstatusCliente").equals("")) ? null
                                                              : Long.valueOf(conectorParametro(
                    "cbEstatusCliente"));
        estatus2 = conectorParametro("txtEstatus2");
        oidVentaExclusiva = null;

        desClasificacion = conectorParametro("hDesClasificacion");
        desTipoClasificacion = conectorParametro("hDesTipoClasificacion");
        desTipoCliente = conectorParametro("hDesTipoCliente");
        desSubtipoCliente = conectorParametro("hDesSubtipoCliente");
        desEstatus = conectorParametro("hDesEstatusCliente");
        /*traza("numeroOrden" + conectorParametro("txtNOrden"));
        numeroOrden = ((conectorParametro("txtNOrden") == null) ||
            conectorParametro("txtNOrden").equals("")) ? null
                                                       : Integer.valueOf(conectorParametro(
                    "txtNOrden"));*/
        traza("recupObligatoria" + conectorParametro("ckRecObligPedido"));
        recupObligatoria = ((conectorParametro("ckRecObligPedido") == null) ||
            conectorParametro("ckRecObligPedido").equals("")) ? null
                                                              : conectorParametro(
                "ckRecObligPedido");
    }

    private void meterValoresdePantallaenDTOOferta() throws Exception {
        traza("meterValoresdePantallaenDTOOferta 1");
        recuperaValoresPantalla();

        DTOOferta dtoOf;

        //Si el DToOferta no existe lo creo para que las acciones que le van agregando datos puedan hacerlo
        traza("meterValoresdePantallaenDTOOferta 2");

        if (conectorParametroSesion("DTOOferta") == null) {
            dtoOf = new DTOOferta();
        } else {
            dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");
        }

        traza("meterValoresdePantallaenDTOOferta 3");
        dtoOf.setOidAcceso(this.oidAcceso);
        dtoOf.setOidSubacceso(this.oidSubacceso);
        dtoOf.setOidArgumentoVenta(this.oidArgumentoVenta);
        dtoOf.setOidCatalogo(this.oidCatalogo);
        
        dtoOf.setNumeroGrupos(this.numeroGrupos);
        dtoOf.setNumeroPaquetes(this.numeroPaquetes);
        dtoOf.setOidIndCuadre(this.oidIndicadorCuadre);
        traza("meterValoresdePantallaenDTOOferta 4");
        dtoOf.setNumeroGruposCondicionantes(this.numeroGruposCondicionantes);
        dtoOf.setCondicionCondicionantes(this.condicionCondicionantes);
        dtoOf.setNumeroGruposCondicionados(this.numeroGruposCondicionados);
        dtoOf.setCondicionCondicionados(this.condicionCondicionados);
        traza("meterValoresdePantallaenDTOOferta 5"+despachoCompleto+" "+despachoAutomatico+" "+recupObligatoria);
        traza("meterValoresdePantallaenDTOOferta 5"+(((despachoCompleto == null) ||
            despachoCompleto.equals("N")) ? "false" : "true" )+" "+(((despachoAutomatico == null) ||
            despachoAutomatico.equals("N")) ? "false" : "true" ));

        if (despachoCompleto==null) dtoOf.setDespachoCompleto(null); 
        else dtoOf.setDespachoCompleto((despachoCompleto.equals("N")) ? new Boolean(false) : new Boolean(true));

        if (despachoAutomatico==null) dtoOf.setDespachoAutomatico(null); 
        else dtoOf.setDespachoAutomatico((despachoAutomatico.equals("N")) ? new Boolean(false) : new Boolean(true));

        traza("recupObligatoria--->"+recupObligatoria);
        if (recupObligatoria!=null)         
            traza("recupObligatoria val--->"+recupObligatoria.equals("S"));
        if (recupObligatoria==null) dtoOf.setRecuperacionObligatoria(null); 
        else dtoOf.setRecuperacionObligatoria((recupObligatoria.equals("N")) ? new Boolean(false) : new Boolean(true));
            
        dtoOf.setOidFormaPago(this.oidFormaPago);
        traza("meterValoresdePantallaenDTOOferta 6a");

        conectorParametroSesion("VentaExclusiva",
            (conectorParametro("ckVentaExclusiva") == null) ? ""
                                                            : conectorParametro(
                "ckVentaExclusiva"));
                
        traza("ckVentaExclusiva:"+conectorParametro("ckVentaExclusiva"));
        if ((conectorParametro("ckVentaExclusiva")!=null)&&(conectorParametro("ckVentaExclusiva").equalsIgnoreCase("N"))){
            traza("ckVentaExclusiva:"+conectorParametro("ckVentaExclusiva"));
            //entonces saco las venta exclusivas del dto
            dtoOf.setVentaExvlusiva(null);
        }
        
        conectorParametroSesion("DTOOferta", dtoOf);
        traza("meterValoresdePantallaenDTOOferta fin");
    }

    private void sacarValoresdeDTOparaCargarPantalla()
        throws Exception {
        DTOOferta dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");

        asignarAtributo("VAR", "hAcceso", "valor",
            (dtoOf.getOidAcceso() == null) ? "" : dtoOf.getOidAcceso().toString());
        asignarAtributo("VAR", "hSubacceso", "valor",
            (dtoOf.getOidSubacceso() == null) ? ""
                                              : dtoOf.getOidSubacceso()
                                                     .toString());
        asignarAtributo("VAR", "hArgumentoVenta", "valor",
            (dtoOf.getOidArgumentoVenta() == null) ? ""
                                                   : dtoOf.getOidArgumentoVenta()
                                                          .toString());
        asignarAtributo("VAR", "hCatalogoSel", "valor",
            (dtoOf.getOidCatalogo() == null) ? ""
                                             : dtoOf.getOidCatalogo().toString());
        asignarAtributo("CTEXTO", "txtNGrupos", "valor",
            (dtoOf.getNumeroGrupos() == null) ? ""
                                              : dtoOf.getNumeroGrupos()
                                                     .toString());
        asignarAtributo("CTEXTO", "txtNPaquetes", "valor",
            (dtoOf.getNumeroPaquetes() == null) ? ""
                                                : dtoOf.getNumeroPaquetes()
                                                       .toString());
        asignarAtributo("VAR", "hIndCuadre", "valor",
            (dtoOf.getOidIndCuadre() == null) ? ""
                                              : dtoOf.getOidIndCuadre()
                                                     .toString());
        asignarAtributo("CTEXTO", "txtNGrupCondicionantes", "valor",
            (dtoOf.getNumeroGruposCondicionantes() == null) ? ""
                                                            : dtoOf.getNumeroGruposCondicionantes()
                                                                   .toString());

        if ((dtoOf.getCondicionCondicionantes() == null) ||
                dtoOf.getCondicionCondicionantes().equals("")) {
            asignarAtributo("VAR", "hrbCondicionantes", "valor", "");
        } else {
            asignarAtributo("VAR", "hrbCondicionantes", "valor",
                (dtoOf.getCondicionCondicionantes().equals("O")) ? "N" : "S");
        }

        asignarAtributo("CTEXTO", "txtNGrupCondicionados", "valor",
            (dtoOf.getNumeroGruposCondicionados() == null) ? ""
                                                           : dtoOf.getNumeroGruposCondicionados()
                                                                  .toString());

        if ((dtoOf.getCondicionCondicionados() == null) ||
                dtoOf.getCondicionCondicionados().equals("")) {
            asignarAtributo("VAR", "hrbCondicionados", "valor", "");
        } else {
            asignarAtributo("VAR", "hrbCondicionados", "valor",
                (dtoOf.getCondicionCondicionados().equals("O")) ? "N" : "S");
        }

        traza("a ver esto:"+dtoOf.getDespachoCompleto()+" "+(((dtoOf.getDespachoCompleto() == null) ||
            dtoOf.getDespachoCompleto().equals(new Boolean(false))) ? "N" : "S"));

        if (dtoOf.getDespachoCompleto() == null) {
            asignarAtributo("VAR", "hrbDespachoCompleto", "valor", "");
        } else {
            asignarAtributo("VAR", "hrbDespachoCompleto", "valor",
                (dtoOf.getDespachoCompleto().equals(new Boolean(false))) ? "N" : "S");
        }            

            
        traza("a ver esto otro:"+dtoOf.getDespachoAutomatico()+" "+(((dtoOf.getDespachoAutomatico() == null) ||
            dtoOf.getDespachoAutomatico().equals(new Boolean(false))) ? "N" : "S"));  

        if (dtoOf.getDespachoAutomatico() == null) {
            asignarAtributo("VAR", "hrbDespachoAutomatico", "valor", "");
        } else {
            asignarAtributo("VAR", "hrbDespachoAutomatico", "valor",
                (dtoOf.getDespachoAutomatico().equals(new Boolean(false))) ? "N" : "S");
        }               

        if (dtoOf.getRecuperacionObligatoria() == null) {
            asignarAtributo("VAR", "hrbRecObligPedido", "valor", "");
        } else {
            asignarAtributo("VAR", "hrbRecObligPedido", "valor",
                (dtoOf.getRecuperacionObligatoria().equals(new Boolean(false))) ? "N" : "S");
        }               
                        
        asignarAtributo("VAR", "hFormaPago", "valor",
            (dtoOf.getOidFormaPago() == null) ? ""
                                              : dtoOf.getOidFormaPago()
                                                     .toString());
        //traza("sacarValoresdeDTOparaCargarPantalla1");
        asignarAtributo("VAR", "hrbVentaExclusiva", "valor",
            (String) conectorParametroSesion("VentaExclusiva"));
        //traza("sacarValoresdeDTOparaCargarPantalla2");
        if (dtoOf.getVentaExclusiva()!=null) cambiaVentaExclusiva(dtoOf.getVentaExclusiva());
        //traza("sacarValoresdeDTOparaCargarPantalla3");
        agregarProductoALista();
        traza("sacarValoresdeDTOparaCargarPantalla4");
    }
    private void limpiar() throws Exception{
      this.getRequest().getSession().removeAttribute("ProductosOferta");
      this.getRequest().getSession().removeAttribute("ProductoOfertaPrincipal");
      this.getRequest().getSession().removeAttribute("Productos");
      this.getRequest().getSession().removeAttribute("productoprincipal");
      this.getRequest().getSession().removeAttribute("DTOOferta");
      if (UtilidadesSession.getAccesoPorDefecto(this)!=null)
        asignarAtributo("VAR","hAccesoDef","valor",UtilidadesSession.getAccesoPorDefecto(this).toString());
      if (UtilidadesSession.getSubaccesoPorDefecto(this)!=null)              
        asignarAtributo("VAR","hSubaccesoDef","valor",UtilidadesSession.getSubaccesoPorDefecto(this).toString());
      asignarAtributo("VAR","primeraEjecucion","valor","true");        
      RecordSet recordSet = new RecordSet();      
      asignar("LISTADOA", "listado1", UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
        recordSet.getColumnIdentifiers()), "dtoSalida");      
      asignar("LISTADOA", "listado2", UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
        recordSet.getColumnIdentifiers()), "dtoSalida");
      asignar("LISTADOA", "listado3", UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
              recordSet.getColumnIdentifiers()), "dtoSalida");        
    }
    
    
    /*metodos para la carga del combo de catalogo*/
    private void cargarCatalogo() throws Exception {
        traza(" >>>>Entra en cargarCatalogo ");
        ComposerViewElementList cv = crearParametrosEntrada();
        traza(" >>>Se crearon Parametros de Entrada ");
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        traza(" >>>Se ejecuto el conector ");
        DruidaConector resultados = conector.getConector();
        asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
        traza(" >>>Se asignaron los valores ");
    
    }

     private ComposerViewElementList crearParametrosEntrada() throws Exception {
       ComposerViewElementList lista = new ComposerViewElementList(); 
       DTOBelcorp dtobcp = new DTOBelcorp();
       UtilidadesSession sesion = new UtilidadesSession();
        
       dtobcp.setOidIdioma(sesion.getIdioma(this));
       dtobcp.setOidPais(sesion.getPais(this));
      
       ComposerViewElement ci1 = new ComposerViewElement();
       ci1.setIDBusiness("MAVCargarCatalagosBP");          
       ci1.setDTOE(dtobcp);
       lista.addViewElement(ci1);
      
        return lista;    
    }
    /*fin metodos para la carga del combo de catalogo*/
   
}
