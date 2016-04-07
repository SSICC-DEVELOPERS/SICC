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
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.rec.DTOGestionProductosNoRecogibles;
import es.indra.sicc.dtos.rec.DTOProductoNoRecogible;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.reflect.Method;

public class LPGestionarProductosNoRecogibles extends LPSICCBase{
    private static final String nombreLogica = "LPGestionarProductosNoRecogibles";
    private Long oidIdioma = null;
    private Long oidPais = null;
    private String accion = "";
    private String casoDeUso = "";

    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private String ipCliente = "";

	DTOGestionProductosNoRecogibles dtoG = null;
	DTOProductoNoRecogible dtoP = null;

    public LPGestionarProductosNoRecogibles(){
        super();
    }

    // Va siempre, se invoca a la pagina involucrada	
    public void inicio() throws Exception{
        setTrazaFichero();
        pagina("contenido_productos_no_recojibles_gestionar");
		getFormatosValidaciones();
        this.getConfiguracionMenu("LPGestionarProductosNoRecogibles","");
    }

    // Va siempre - Metodo ejecucion()
    public void ejecucion() throws Exception{
	
        TiempoDeCargaInicio=System.currentTimeMillis();
        try{
            //agregado Por el caso de uso modificar grupos
            String casoDeUso = conectorParametroLimpia("casoDeUso","",true);
            asignarAtributo("VAR","casoDeUso","valor",casoDeUso);

            accion = conectorParametroLimpia("accion","",true);
            rastreo();
            traza("Accion: " + accion);
            oidPais = UtilidadesSession.getPais(this);
            oidIdioma = UtilidadesSession.getIdioma(this);
            ipCliente = UtilidadesBelcorp.getIPCliente(this);                        
            
            if (accion.equals("")) {
                cargarPantalla();
            } else if (accion.equals("guardar")) {
				guardar();
            }
            
			TiempoDeCargaFin = System.currentTimeMillis();
			traza("El tiempo de carga de LPGestionarProductosNoRecogibles es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));      
			
        } catch (Exception ex) {

            traza("exception: " + ex);
            this.logStackTrace(ex);
   			this.lanzarPaginaError(ex);

  		}

        this.getConfiguracionMenu();
    }//ejecucion()

	private void logStackTrace(Throwable e) throws Exception{

		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		
		if (e instanceof MareException){
			MareException e2 = (MareException)e;
			traza("Es una mare Exception con codigo de error: " + e2.getCode());
		}

		e.printStackTrace(out);
		traza("stack Trace : " + pila.toString());

	}//logStackTrace()

	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");

		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("antes del conector.ejecucion");
		conector.ejecucion();
		traza("despues del conector");
		DruidaConector resultados = conector.getConector();
			 
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGRecuperaCanales");

		traza("Salio de cargarMarcaCanal()");
	}

	 private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(oidPais);
      dtoBel.setOidIdioma(oidIdioma);
           
      ComposerViewElement marcas = new ComposerViewElement();
      marcas.setIDBusiness("SEGConsultaMarcas");
      marcas.setDTOE(dtoBel);
           
      lista.addViewElement(marcas);

	  ComposerViewElement canales = new ComposerViewElement();
      canales.setIDBusiness("SEGRecuperaCanales");
      canales.setDTOE(dtoBel);
           
      lista.addViewElement(canales);
      
      return lista;
    }

	private void cargarPeriodosYActual(Long oidPais, Long oidMarca, Long oidCanal) throws Exception{
		traza("Entró de cargarPeriodosYActual(Long oidPais, Long oidMarca, Long oidCanal)");
		DTOPeriodo paisMarcaCanal = new DTOPeriodo();
		paisMarcaCanal.setOidIdioma(oidIdioma);
		paisMarcaCanal.setPais(oidPais);
		paisMarcaCanal.setMarca(oidMarca);
		paisMarcaCanal.setCanal(oidCanal);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAObtienePeriodoActual"));
		DruidaConector conectorCargarPeriodo = conectar("ConectorObjeto", paramEntrada);

		IMareDTO dtoSalida = (IMareDTO)conectorCargarPeriodo.objeto("DTOSalida");
		DTOPeriodo dtoPeriodo = (DTOPeriodo)(dtoSalida.getProperty("periodoActual"));

		String periodoActual = dtoPeriodo.getOid().toString();
		asignarAtributo("VAR","hidPeriodo","valor",periodoActual);
		traza("asigno periodo actual:"+periodoActual);

		traza("Salió de cargarPeriodosYActual(Long oidPais, Long oidMarca, Long oidCanal)");
	}// Fin metodo cargarPeriodosYActual()

    private void cargarPantalla() throws Exception {

		Long oidMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
		Long oidCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);

		cargarMarcaCanal();
		cargarPeriodosYActual(oidPais, oidMarcaDefecto, oidCanalDefecto);
 
		asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","hidMarca","valor",oidMarcaDefecto.toString());
        asignarAtributo("VAR","hidCanal","valor",oidCanalDefecto.toString());
        asignarAtributo("VAR","oidPais","valor",oidPais.toString());
        asignarAtributo("VAR","oidIdioma","valor",oidIdioma.toString());

    }// Fin metodo cargarPantalla()
   
    private void guardar() throws Exception {
		traza("LPGestionarProductosNoRecogibles.guardar():Entrada");
		dtoG = new DTOGestionProductosNoRecogibles();
		dtoG.setProductosNoRecogibles(new ArrayList());
		cargarDTOGestionProductosNoRecogibles();
		cargarDTOProductosNoRecogibles();
		dtoG.setOidIdioma(oidIdioma);

		pagina("salidaGenerica");        

        Vector vec = new Vector();
        vec.add(dtoG);
        vec.add(new MareBusinessID("RECGuardarProductosNoRecogibles"));
        conectar("ConectorGuardarProductosNoRecogibles", vec);
        
        asignarAtributo("VAR","ejecutar","valor","limpiar();");
        asignarAtributo("VAR","ejecutarError","valor"," ShowError();");       
		
		traza("LPGestionarProductosNoRecogibles.guardar():Entrada");
	}

	private void asignarADTO(String datos, Object dto, String separator) throws Exception {
		  traza("LPGestionarProductosNoRecogibles.asignarADTO()-Previo:Entrada");
	  
		  StringTokenizer propValor = new StringTokenizer(datos, separator);
		  
		  String nombreProperty = propValor.nextToken();
		  String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";   
		  
		  asignarADTO(nombreProperty, valorASetear, dto);
		  
		  traza("LPGestionarProductosNoRecogibles.asignarADTO()-Previo:Salida");
	}
		
    private void asignarADTO(String nombreProperty, Object valorASetear, Object dto) throws Exception {      
		  traza("LPGestionarProductosNoRecogibles.asignarADTO():Entrada");
		  
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
		  traza("LPGestionarProductosNoRecogibles.asignarADTO():Salida");        
	  }

  private Method obtenerMetodo(String nombreProp, Object dto) throws Exception {
  
        traza("LPGestionarProductosNoRecogibles.obtenerMetodo()");
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

  private void cargarDTOProductosNoRecogibles() throws Exception {
		traza("LPGestionarProductosNoRecogibles.cargarDTOProductosNoRecogibles():Entrada");
		String sDTOProductosNoRecogibles = conectorParametro("dTOProductoNoRecogibles");
		StringTokenizer filas = new StringTokenizer(sDTOProductosNoRecogibles, "&");
		
		if (filas.hasMoreTokens()) { 		  		  
		  while(filas.hasMoreTokens()) {
			  StringTokenizer dto = new StringTokenizer(filas.nextToken(), "|");
			  dtoP = new DTOProductoNoRecogible();
			  while(dto.hasMoreTokens()) {
				asignarADTO(dto.nextToken(), dtoP, "=");
			  }
			  dtoG.getProductosNoRecogibles().add(dtoP);
		  }
		}
		
		traza("LPGestionarProductosNoRecogibles.cargarDTOProductosNoRecogibles():Salida");
  }   
  
  private void cargarDTOGestionProductosNoRecogibles() throws Exception {
		traza("LPGestionarProductosNoRecogibles.cargarDTOGestionProductosNoRecogibles():Entrada");
		String sDTOGestionProductosNoRecogibles = conectorParametro("dTOGestionProductosNoRecogibles");
		StringTokenizer filas = new StringTokenizer(sDTOGestionProductosNoRecogibles, "|");
		
		if (filas.hasMoreTokens()) { 		  		  
		  while(filas.hasMoreTokens()) {
			  asignarADTO(filas.nextToken(), dtoG, "=");
		  }
		}
		
		traza("LPGestionarProductosNoRecogibles.cargarDTOGestionProductosNoRecogibles():Salida");
  }    
}
