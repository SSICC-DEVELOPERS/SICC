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
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
/*inicio enozigli COL-PRE-002*/
import es.indra.sicc.dtos.pre.DTORangoPrecios;
/*fin enozigli COL-PRE-002*/
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.lang.reflect.Method;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOSalida;


public class LPDefinirOfertaPerf extends LPSICCBase {
    //definicion de variables
    private String accion = null;
    private Long oidCabeceraMF = null;
    private Long oidEstrategia = null;
    private Long idioma = null;
    private Long pais = null;
    private String usuario = null;
    private String programa = null;  

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

    //variables para operar con la reflection antes de guardar
    private DTOOferta dtoOferta;
    private DTODetalleOferta dtoDetalle;
    private DTOPromocion dtoPromo;
    private DTOLineaPromocion dtoLineaPromo;

	/*inicio enozigli COL-PRE-002*/
    private DTORangoPrecios dtoRangoPrecios;
	/*fin enozigli COL-PRE-002*/

    private DTOGrupo dtoGrupo;
    private DTOVentaExclusiva dtoVtaExcl;

    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;

    //Contructor
    public LPDefinirOfertaPerf() {
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

            //Traemos las variables de la pagina
            accion = (conectorParametro("accion") == null) ? ""
                                                           : conectorParametro(
                    "accion");
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            usuario = UtilidadesSession.getIdUsuario(this);
            programa = UtilidadesSession.getFuncion(this);
            
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
                conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
                conectorAction("LPSeleccionarMF");
                conectorActionParametro("nueva", "true");
            } else if (accion.equals("Matriz seleccionada")) {
                matrizSeleccionada();
            } else if (accion.equals("EstrategiaSeleccionada")) {
                cargarPantalla();
            }  else if (accion.equals("Comprobar restricciones")) {//esta accion se eliminara hay que pasarla a js             
                comprobarRestricciones();
            } else if (accion.equals("Guardar oferta")) {
                guardarOferta();
            }

        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
            
        TiempoDeCargaFin = System.currentTimeMillis();        
        traza("El tiempo de carga de LPDefinirOfertaPerf es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
        
        } catch (Exception e) {
            cargarPantalla();
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
            conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
            conectorAction("LPDefinirCondicionOfertaPerf");
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
                        conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
                        conectorAction("LPCrearGrupoPerf");
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
                        conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
                        conectorAction("LPCrearGrupoPerf");
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
                        conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
                        conectorAction("LPCrearGrupoPerf");
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
                        conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
                        conectorAction("LPCrearGrupoPerf");
                        llamoaotracosa = true;
                    }
                }
            }
        }

        if (ranking.equals(new Boolean(true))&&!llamoaotracosa) { //ranking
            conectorParametroSesion("ranking", new Boolean(false));            
            conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
            conectorAction("LPEvaluarRankingPorDemandaPerf");
            llamoaotracosa = true;
        }
        //traza("llamoaotracosa: "+llamoaotracosa);
        if (!llamoaotracosa)  {
            //traza("entro en guardar"+!llamoaotracosa);
            guardarOferta();
        }       
        
    }

    private void guardarOferta() throws Exception {

        traza("LPDefinirOferta.guardarOferta():Entrada");
        dtoOferta = new DTOOferta();
        
        cargarDatosGeneralesOferta();
        cargarDetallesOferta();
        cargarVentasExclusivas();
        cargarPromociones();
        cargarGrupos();
      
        traza("DTO oferta a guardar:"+dtoOferta);
        
        pagina("salidaGenerica");        

        dtoOferta.setIpCliente(usuario);
        dtoOferta.setPrograma(programa);

        Vector vec = new Vector();
        vec.add(dtoOferta);
        vec.add(new MareBusinessID("PREGuardarOferta"));
        conectar("ConectorGuardarOferta", vec);
        
        asignarAtributo("VAR","ejecutar","valor","fLimpiar();");
        asignarAtributo("VAR","ejecutarError","valor"," ShowError();");       

        traza("LPDefinirOferta.guardarOferta():Salida");
    }

    private void cargarDatosGeneralesOferta() throws Exception {
        traza("LPDefinirOferta.cargarDatosGeneralesOferta():Entrada");
        String sDatosGralesOferta = conectorParametro("sDatosGralesOferta");
        
        StringTokenizer stDat = new StringTokenizer(sDatosGralesOferta, "|");
        
        while(stDat.hasMoreTokens()){
            asignarADTO(stDat.nextToken(), dtoOferta , "=");
        }
        dtoOferta.setOidIdioma(idioma);
        dtoOferta.setOidPais(pais);
        dtoOferta.setIpCliente(usuario);
        dtoOferta.setPrograma(programa);
        
        traza("LPDefinirOferta.cargarDatosGeneralesOferta():Salida");
    }
 
  private void asignarADTO(String datos, Object dto, String separator) throws Exception {
      traza("LPDefinirOferta.asignarADTO()-Previo:Entrada");
  
      StringTokenizer propValor = new StringTokenizer(datos, separator);
      
      String nombreProperty = propValor.nextToken();
      String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";   
      
      asignarADTO(nombreProperty, valorASetear, dto);
      
      traza("LPDefinirOferta.asignarADTO()-Previo:Salida");
  }
    
  private void asignarADTO(String nombreProperty, Object valorASetear, Object dto) throws Exception {      
      traza("LPDefinirOferta.asignarADTO():Entrada");
      
      if ((valorASetear!=null)&&(!valorASetear.equals(""))) {
          Method metodo = obtenerMetodo(nombreProperty, dto);
          
          if (metodo!=null) {
              try {
              
                Class claseDelParametro = metodo.getParameterTypes()[0];
                traza("Clase del parametro:"+claseDelParametro.getName());
                if(claseDelParametro.isPrimitive()&&("char".equals(claseDelParametro.getName()))) {
                  traza("El tipo es primitivo char");   
                  Object[] args = {new Character(valorASetear.toString().charAt(0))};
                  Object res = metodo.invoke(dto,args);   
                } else {                  
                  Class[] paramParamType = {valorASetear.getClass()};
                  Object[] paramsParam = {valorASetear};
                  Object param = claseDelParametro.getConstructor(paramParamType).newInstance(paramsParam);                  
                  Object[] args = {param};               
                  Object res = metodo.invoke(dto,args);
                }
              } catch (Exception e) {
                traza("Pincho la asignacion del parametro "+ nombreProperty +" en "+ dto.getClass().getName() +", con el valor "+valorASetear);
                logStackTrace(e);
              }
          } else {
              traza("No se encontro el setter correspondiente a "+ nombreProperty +" en "+ dto.getClass().getName() +", puede que no exista.");
          }
      }
      traza("LPDefinirOferta.asignarADTO():Salida");        
  }

  private Method obtenerMetodo(String nombreProp, Object dto) throws Exception {
  
        traza("LPDefinirOferta.obtenerMetodo()");
        String primerLetra = nombreProp.substring(0, 1).toUpperCase();
        String restoNombre = nombreProp.substring(1);
        String methodName = "set" + primerLetra + restoNombre;
        
        Class clsDTO = dto.getClass();
        
        Method[] metodos = clsDTO.getMethods();
        
        int i=0;
        int cant = metodos.length;
       
        while (i<cant) {
            if (methodName.equals(metodos[i].getName())) {
              return metodos[i];
            }
            i++;
        }        
        return null;
  }
  
	private void cargarDetallesOferta() throws Exception {
		traza("LPDefinirOferta.cargarDetallesOferta():Entrada");
		String sDetallesOferta = conectorParametro("sDetallesOferta");
		StringTokenizer filasDetalle = new StringTokenizer(sDetallesOferta, "$");
		
		if (filasDetalle.hasMoreTokens()) { 
		  dtoOferta.setDetalleOferta(new Vector()); 
		  
		  while(filasDetalle.hasMoreTokens()) {
			  StringTokenizer unaFilaDetalle = new StringTokenizer(filasDetalle.nextToken(), "|");
			  
			  dtoDetalle = new DTODetalleOferta();
			  while(unaFilaDetalle.hasMoreTokens()){
				  /*inicio enozigli COL-PRE-002*/
				  StringTokenizer propValor = new StringTokenizer(unaFilaDetalle.nextToken(), "=");
				  
				  String nombreProperty = propValor.nextToken();
				  String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";
				  
				  if ("rangosPrecios".equals(nombreProperty)) {
					   //proceso los rangos de Precios del detalle
					   
					   StringTokenizer rangosPrecios = new StringTokenizer(valorASetear, "#");
					   
					   if (rangosPrecios.hasMoreTokens()) {                   
						   dtoDetalle.setRangosPrecios(new Vector());
						   
						   while(rangosPrecios.hasMoreTokens()){
							   StringTokenizer unrangoPreciosEnTokens = new StringTokenizer(rangosPrecios.nextToken(), "&"); 
							   
							   dtoRangoPrecios = new DTORangoPrecios();
							   while (unrangoPreciosEnTokens.hasMoreTokens()) {                               
								   asignarADTO(unrangoPreciosEnTokens.nextToken(), dtoRangoPrecios, "¿");
							   }
							   dtoDetalle.getRangosPrecios().add(dtoRangoPrecios);
						   }                       
					   }
				  } else {
					  asignarADTO(nombreProperty, valorASetear, dtoDetalle);  
				  }
				  /*fin enozigli COL-PRE-002*/
			  }
			  dtoDetalle.setOidIdioma(idioma);
			  dtoDetalle.setOidPais(pais);
			  dtoDetalle.setIpCliente(usuario);
			  dtoDetalle.setPrograma(programa);
			  
			  dtoOferta.getDetalleOferta().add(dtoDetalle);
		  }
		}
		
		traza("LPDefinirOferta.cargarDetallesOferta():Salida");
	}

	private void cargarGrupos() throws Exception {
		traza("LPDefinirOferta.cargarGrupos():Entrada");
		String sGrupos = conectorParametro("sGrupos");
    StringTokenizer grupos = new StringTokenizer(sGrupos, "$");
    
    if (grupos.hasMoreTokens()) { 
      dtoOferta.setGrupo(new Vector()); 
      
      while(grupos.hasMoreTokens()) {
          StringTokenizer unaGrupoEnTokens = new StringTokenizer(grupos.nextToken(), "|");
          
          dtoGrupo = new DTOGrupo();
          while(unaGrupoEnTokens.hasMoreTokens()){
              asignarADTO(unaGrupoEnTokens.nextToken(), dtoGrupo, "=");
          }
          dtoGrupo.setOidIdioma(idioma);
          dtoGrupo.setOidPais(pais);
          dtoGrupo.setIpCliente(usuario);
          dtoGrupo.setPrograma(programa);
          
          dtoOferta.getGrupo().add(dtoGrupo);
      }
    }
    
		traza("LPDefinirOferta.cargarGrupos():Salida");
	}
	
	private void cargarPromociones() throws Exception {
		traza("LPDefinirOferta.cargarPromociones():Entrada");
		String sPromociones = conectorParametro("sPromociones");
		StringTokenizer promociones = new StringTokenizer(sPromociones, "$");
    
		if (promociones.hasMoreTokens()) { 
			dtoOferta.setPromocion(new Vector()); 
      
		while(promociones.hasMoreTokens()) {
          StringTokenizer unaPromoEnTokens = new StringTokenizer(promociones.nextToken(), "|");
          
          dtoPromo = new DTOPromocion();
          
          while(unaPromoEnTokens.hasMoreTokens()){             
              StringTokenizer propValor = new StringTokenizer(unaPromoEnTokens.nextToken(), "=");
              
              String nombreProperty = propValor.nextToken();
              String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";
              
              if ("lineaPromocion".equals(nombreProperty)) {
                   //proceso la linea de Promocion
                   
                   StringTokenizer lineasPromo = new StringTokenizer(valorASetear, "#");
                   
                   if (lineasPromo.hasMoreTokens()) {                   
                       dtoPromo.setLineaPromocion(new Vector());
                       
                       while(lineasPromo.hasMoreTokens()){
                           StringTokenizer unlineaPromoEnTokens = new StringTokenizer(lineasPromo.nextToken(), "&"); 
                           
                           dtoLineaPromo = new DTOLineaPromocion();
                           while (unlineaPromoEnTokens.hasMoreTokens()) {                               
                               asignarADTO(unlineaPromoEnTokens.nextToken(), dtoLineaPromo, "¿");
                           }
                           dtoPromo.getLineaPromocion().add(dtoLineaPromo);
                       }                       
                   }
              } else {
                  asignarADTO(nombreProperty, valorASetear, dtoPromo);  
              }              
          }
          dtoPromo.setOidIdioma(idioma);
          dtoPromo.setOidPais(pais);
          dtoPromo.setIpCliente(usuario);
          dtoPromo.setPrograma(programa);
          
          dtoOferta.getPromocion().add(dtoPromo);
      }
    }
    
	traza("LPDefinirOferta.cargarPromociones():Salida");
	}
    
	private void cargarVentasExclusivas() throws Exception {
		traza("LPDefinirOferta.cargarVentasExclusivas():Entrada");
		String sVentasExclusivas = conectorParametro("sVentasExclusivas");
	  StringTokenizer ventasExclusivas = new StringTokenizer(sVentasExclusivas, "$");
    
    if (ventasExclusivas.hasMoreTokens()) { 
      dtoOferta.setVentaExvlusiva(new Vector()); 
      
      while(ventasExclusivas.hasMoreTokens()) {
          StringTokenizer unaVtaEnTokens = new StringTokenizer(ventasExclusivas.nextToken(), "|");
          
          dtoVtaExcl = new DTOVentaExclusiva();
          while(unaVtaEnTokens.hasMoreTokens()){
              asignarADTO(unaVtaEnTokens.nextToken(), dtoVtaExcl, "=");
          }
          dtoVtaExcl.setOidIdioma(idioma);
          dtoVtaExcl.setOidPais(pais);
          dtoVtaExcl.setIpCliente(usuario);
          dtoVtaExcl.setPrograma(programa);
          
          dtoOferta.getVentaExclusiva().add(dtoVtaExcl);
      }
    }
    			
		traza("LPDefinirOferta.cargarVentasExclusivas():Salida");
	}
    
    private void matrizSeleccionada() throws Exception {
        conectorParametroSesion("UltimaLP", "LPDefinirOfertaPerf");
        conectorAction("LPSeleccionarEstrategia");
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
        pagina("contenido_oferta_definir_perf");
        getFormatosValidaciones();

        this.getConfiguracionMenu("LPDefinirOfertaPerf", "");

        oidCabeceraMF = (Long) conectorParametroSesion("oidCabeceraMF");
        oidEstrategia = (Long) conectorParametroSesion("oidEstrategia");

        
        DTOECargarCriteriosDefinirOferta dto = new DTOECargarCriteriosDefinirOferta();
        dto.setOidCabeceraMF(oidCabeceraMF);
        dto.setOidEstrategia(oidEstrategia);
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        dto.setIpCliente(usuario);
        dto.setPrograma(programa);

        MareBusinessID bid = new MareBusinessID("PRECargarCriteriosDefinirOferta");
        Vector vec = new Vector();
        vec.add(dto);
        vec.add(bid);
        traza("cargarPantalla();--1--llamando al conector");

        DTOSCargarCriteriosDefinirOferta dtoS = (DTOSCargarCriteriosDefinirOferta) conectar("ConectorCargarCriteriosDefinirOferta",
                vec).objeto("dtoSalida");
        if (UtilidadesSession.getAccesoPorDefecto(this)!=null)
          asignarAtributo("VAR","hAccesoDef","valor",UtilidadesSession.getAccesoPorDefecto(this).toString());
        if (UtilidadesSession.getSubaccesoPorDefecto(this)!=null)              
          asignarAtributo("VAR","hSubaccesoDef","valor",UtilidadesSession.getSubaccesoPorDefecto(this).toString());   

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
        //seteo de algunas variables
        asignarAtributo("VAR","oidCabeceraMF","valor",((oidCabeceraMF==null)?"":oidCabeceraMF.toString()));
        asignarAtributo("VAR","oidEstrategia","valor",((oidEstrategia==null)?"":oidEstrategia.toString()));
        asignarAtributo("VAR","hCtePREMF","valor",ConstantesPRE.MF);
        
        //seteo las variables para las validaciones
        asignarAtributo("VAR","argumentoVta","valor",((oidArguPosi==null)?"":oidArguPosi.toString()));
        asignarAtributo("VAR","maxGrupo","valor",((dtoS.getEstrategia().getMaxGrupos()==null)?"":dtoS.getEstrategia().getMaxGrupos().toString()));
        asignarAtributo("VAR","maxGruposCondicionantes","valor",((dtoS.getEstrategia().getMaxGruposCondicionantes()==null)?"":dtoS.getEstrategia().getMaxGruposCondicionantes().toString()));
        asignarAtributo("VAR","maxGruposCondicionados","valor",((dtoS.getEstrategia().getMaxGruposCondicionados()==null)?"":dtoS.getEstrategia().getMaxGruposCondicionados().toString()));
        asignarAtributo("VAR","cuadreGrupos","valor",((dtoS.getEstrategia().getCuadreGrupos()==null)?"false":dtoS.getEstrategia().getCuadreGrupos().toString()));        

        if ((new Integer(dtoS.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.CONDICIONADA) {
          asignarAtributo("VAR","condicionada","valor","S");
        } else {
          asignarAtributo("VAR","condicionada","valor","N"); 
        }
        
        //seteo variables para validaciones de cargas
        if ((dtoS.getTipoEstrategia().isEstrategiaVS() != null) &&
                dtoS.getTipoEstrategia().isEstrategiaVS().equals(new Boolean(
                        true))) {
            asignarAtributo("VAR","promociones","valor","S");
        } else {
            asignarAtributo("VAR","promociones","valor","N");
        }

        if ((dtoS.getEstrategia().getListaRanking() != null) &&
                dtoS.getEstrategia().getListaRanking().equals(new Boolean(
                        true))) {
            asignarAtributo("VAR","ranking","valor","S");            
        } else {
            asignarAtributo("VAR","ranking","valor","N");
        }
        
        configurarPantalla(dtoS);

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
        
        RecordSet indCuadresRS = dtoS.getIndicadoresCuadre();
        //INDC_OID_INDI_CUAD, VAL_I18N, OID_IND_CUAD_TIPO_ESTR, IND_OFER_MONO_GRUP
        StringBuffer lstIdCuadresMono = new StringBuffer();
        StringBuffer lstIdCuadresMulti = new StringBuffer();
        
        for (int i=0;i<indCuadresRS.getRowCount();i++)	{
          Integer indOfer = BigToInteger(indCuadresRS.getValueAt(i,3));
          if (indOfer==null||indOfer.equals(new Integer(0))) {
              lstIdCuadresMulti.append("|");
              lstIdCuadresMulti.append(indCuadresRS.getValueAt(i,2)+"&");//0
              lstIdCuadresMulti.append(indCuadresRS.getValueAt(i,1)+"#");//1
              lstIdCuadresMulti.append(indCuadresRS.getValueAt(i,0));             
          } else {
              lstIdCuadresMono.append("|"); 
              lstIdCuadresMono.append(indCuadresRS.getValueAt(i,2)+"&");//0
              lstIdCuadresMono.append(indCuadresRS.getValueAt(i,1)+"#");//1
              lstIdCuadresMono.append(indCuadresRS.getValueAt(i,0));
          }
          // | divisor de registro y & divisor de dato
        }
        
        this.asignarAtributo("VAR", "hlstIdCuadresMono", "valor", lstIdCuadresMono.toString());
        this.asignarAtributo("VAR", "hlstIdCuadresMulti", "valor", lstIdCuadresMulti.toString());

		Long oidMarca = dtoS.getOidMarca();
		Long oidCanal = dtoS.getOidCanal();

		this.cargarZonas(oidMarca, oidCanal);
		this.cargarRegiones(oidMarca, oidCanal);
        
        traza("salio de cargarPantalla();");
    }

    private void configurarPantalla(DTOSCargarCriteriosDefinirOferta dtoS) throws Exception {
        traza("configurarPantalla");

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
        
       dtobcp.setOidIdioma(idioma);
       dtobcp.setOidPais(pais);
      
       ComposerViewElement ci1 = new ComposerViewElement();
       ci1.setIDBusiness("MAVCargarCatalagosBP");          
       ci1.setDTOE(dtobcp);
       lista.addViewElement(ci1);
      
        return lista;    
    }
    /*fin metodos para la carga del combo de catalogo*/
   
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322

 private void cargarRegiones(Long oidMarca, Long oidCanal)
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dto);
        vector.add(new MareBusinessID("ZONObtenerRegionesPorPais"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConector(dtosalida.getResultado(), "dtoSalida", "OID", "DESCRIPCION", "MARCA", "CANAL", null, null);
        asignar("COMBO", "cbRegion", druidaconector, "dtoSalida");
    }

    private void cargarZonas(Long oidMarca, Long oidCanal)
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOUnidadAdministrativa dtounidadadministrativa = new DTOUnidadAdministrativa();
        dtounidadadministrativa.setOidIdioma(idioma);
        dtounidadadministrativa.setOidPais(pais);
        dtounidadadministrativa.setOidMarca(oidMarca);
        dtounidadadministrativa.setOidCanal(oidCanal);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dtounidadadministrativa);
        vector.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConectorZona(dtosalida.getResultado(), "dtoSalida", "OID_ZONA","DES_ZONA", "ZORG_OID_REGI", "MARCA", "CANAL", null);
        asignar("COMBO", "cbZona", druidaconector, "dtoSalida");
    }

    private DruidaConector generaConector(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
		StringBuffer arrRegiones = new StringBuffer();
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }

			arrRegiones.append(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
			arrRegiones.append("&");
			arrRegiones.append(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
			arrRegiones.append("|");
        }

		asignarAtributo("VAR", "arrRegiones", "valor", arrRegiones.toString());

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
  private DruidaConector generaConectorZona(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
		StringBuffer arrZonas = new StringBuffer();
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            ///// OJO  SUMA DE STRINGS
			org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString()+"x"+recordset.getValueAt(i, s3).toString()  : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
			arrZonas.append(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
			arrZonas.append("&");
			arrZonas.append(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
			arrZonas.append("&");
			arrZonas.append(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
			arrZonas.append("|");
        }

		asignarAtributo("VAR", "arrZonas", "valor", arrZonas.toString());
        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
}
