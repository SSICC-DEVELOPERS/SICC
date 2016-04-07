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
import es.indra.sicc.dtos.rec.DTOBoletas;
import es.indra.sicc.dtos.rec.DTOBoletaRecojoTemporal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import es.indra.sicc.util.DTOBoolean;
import java.text.ParseException;

public class LPCapturarBoletasRecojo extends LPSICCBase{
    private static final String nombreLogica = "LPCapturarBoletasRecojo";
    private Long oidIdioma = null;
    private Long oidPais = null;
    private String accion = "";
    private String casoDeUso = "";

    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private String ipCliente = "";
	private String usuario = "";

	DTOBoletas dtoB = null;
	DTOBoletaRecojoTemporal dtoBrT = null;

    public LPCapturarBoletasRecojo(){
        super();
    }

    // Va siempre, se invoca a la pagina involucrada	
    public void inicio() throws Exception{
        setTrazaFichero();
        pagina("contenido_boleta_recojo_capturar");
		getFormatosValidaciones();
        this.getConfiguracionMenu("LPCapturarBoletasRecojo","");
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
			usuario = UtilidadesSession.getIdUsuario(this); 			
            
            if (accion.equals("")) {
                cargarPantalla();
            } else if (accion.equals("guardar")) {
				guardar(false);
            } else if (accion.equals("procesar")) {
				guardar(true);
            }
            
			TiempoDeCargaFin = System.currentTimeMillis();
			traza("El tiempo de carga de LPCapturarBoletasRecojo es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));      
			
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

	private void cargarEstadoRecojo(boolean indEstaManual) throws Exception{
		traza("Entró de cargarEstadoRecojo()");
		DTOBoolean dtoBoolean = new DTOBoolean();
		dtoBoolean.setValor(indEstaManual);

		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoBoolean);

		paramEntrada.add(new MareBusinessID("RECObtenerEstadosRecojo"));
		DruidaConector conectorObtenerEstadosRecojo = conectar("ConectorObtenerEstadosRecojo", paramEntrada);

		asignar("COMBO", "cbEstado", conectorObtenerEstadosRecojo, "dtoSalida.estados_ROWSET");

		traza("Salio de cargarEstadoRecojo()");
	}// Fin metodo cargarEstadoRecojo()

    private void cargarPantalla() throws Exception {

		cargarEstadoRecojo(true);

		asignarAtributo("VAR","hFechaIni","valor",hoyAString());
		asignarAtributo("VAR","hUsuario","valor",usuario);
		asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","oidPais","valor",oidPais.toString());
        asignarAtributo("VAR","oidIdioma","valor",oidIdioma.toString());

    }// Fin metodo cargarPantalla()
   
    private void guardar(boolean procesar) throws Exception {
		traza("LPCapturarBoletasRecojo.guardar():Entrada");
		dtoB = new DTOBoletas();
		dtoB.setBoletas(new ArrayList());
		cargarDTOBoletas();
		cargarDTOBoletasRecojoTemporal();
		dtoB.setOidIdioma(oidIdioma);

		String fechaCaptura = conectorParametroLimpia("hFechaCaptura","",true);

		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		try	{
			java.util.Date fecha = formateador.parse(fechaCaptura);
			dtoB.setFechaCaptura(fecha);
		} catch (ParseException e) {
		   // Error, la cadena de texto no se puede convertir en fecha.
		}

		if (procesar) {
			dtoB.setIndProcesar(true);
		}

		pagina("salidaGenerica");        

        Vector vec = new Vector();
        vec.add(dtoB);
        vec.add(new MareBusinessID("RECProcesarBoletasRecojoTemporal"));
        DruidaConector conectorProcesarBoletasRecojoTemporal = conectar("ConectorProcesarBoletasRecojoTemporal", vec);
	    DTOBoletas dtoS = (DTOBoletas) conectorProcesarBoletasRecojoTemporal.objeto("dtoSalida");  
        
		if (procesar) {
			ArrayList boletas = dtoS.getBoletas();
			if (boletas.size()==0) {
				//hay que limpiar la lista editable.
		        asignarAtributo("VAR","ejecutar","valor","procesoOK();");
			} else {
				//hay que actualizar la lista con los resultados de los que salieron Validacion KO con su TextoValidacion.
				StringBuffer resultado = new StringBuffer();
				for (int i=0; i<boletas.size(); i++) {
					DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i);
					resultado.append(dtoB.getOrdenIngreso()+"#"+dtoB.getTextoValidacion()+"&");
				}
		        asignarAtributo("VAR","ejecutar","valor","procesarResultado('"+resultado.toString()+"');");
			}
		} else {
			asignarAtributo("VAR","ejecutar","valor","guardoOK();");
		}
        asignarAtributo("VAR","ejecutarError","valor"," ShowError();");       
		
		traza("LPCapturarBoletasRecojo.guardar():Salida");
	}

	private void asignarADTO(String datos, Object dto, String separator) throws Exception {
		  traza("LPCapturarBoletasRecojo.asignarADTO()-Previo:Entrada");
	  
		  StringTokenizer propValor = new StringTokenizer(datos, separator);
		  
		  String nombreProperty = propValor.nextToken();
		  String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";   
		  
		  asignarADTO(nombreProperty, valorASetear, dto);
		  
		  traza("LPCapturarBoletasRecojo.asignarADTO()-Previo:Salida");
	}
		
    private void asignarADTO(String nombreProperty, Object valorASetear, Object dto) throws Exception {      
		  traza("LPCapturarBoletasRecojo.asignarADTO():Entrada");
		  
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
		  traza("LPCapturarBoletasRecojo.asignarADTO():Salida");        
	  }

  private Method obtenerMetodo(String nombreProp, Object dto) throws Exception {
  
        traza("LPCapturarBoletasRecojo.obtenerMetodo()");
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

  private void cargarDTOBoletasRecojoTemporal() throws Exception {
		traza("LPCapturarBoletasRecojo.cargarDTOBoletasRecojoTemporal():Entrada");
		String sBoletas = conectorParametro("hBoletas");
		StringTokenizer filas = new StringTokenizer(sBoletas, "&");
		
		if (filas.hasMoreTokens()) { 		  		  
		  while(filas.hasMoreTokens()) {
			  StringTokenizer dto = new StringTokenizer(filas.nextToken(), "|");
			  dtoBrT = new DTOBoletaRecojoTemporal();
			  while(dto.hasMoreTokens()) {
				asignarADTO(dto.nextToken(), dtoBrT, "=");
			  }
			  dtoB.getBoletas().add(dtoBrT);
		  }
		}
		
		traza("LPCapturarBoletasRecojo.cargarDTOBoletasRecojoTemporal():Salida");
  }   
  
  private void cargarDTOBoletas() throws Exception {
		traza("LPCapturarBoletasRecojo.cargarDTOBoletas():Entrada");
		String sDTOBoletas = conectorParametro("hdtoBoletas");
		StringTokenizer filas = new StringTokenizer(sDTOBoletas, "|");
		
		if (filas.hasMoreTokens()) { 		  		  
		  while(filas.hasMoreTokens()) {
			  asignarADTO(filas.nextToken(), dtoB, "=");
		  }
		}
		
		traza("LPCapturarBoletasRecojo.cargarDTOBoletas():Salida");
  }    

    private String hoyAString() throws Exception {
      String formato = UtilidadesSession.getFormatoFecha(this);
      traza("Formato fecha: "+formato);
      int pos = formato.indexOf("mm");
      if ( pos > -1) 
          formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
      SimpleDateFormat sdf = new SimpleDateFormat(formato);
      String fecha = sdf.format(new java.util.Date());
      traza("Fecha: "+fecha);

      return fecha;
  }
}
