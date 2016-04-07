
import es.indra.sicc.dtos.com.DTODatosGerenteCongelacion;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import es.indra.mare.common.exception.MareException;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesSession;
import java.lang.Exception;
import java.util.Date;
import java.math.BigDecimal;
import java.text.DateFormat;



public class LPMantenimientoGerenteCongelado extends LPSICCBase {

public String accion;
public Long aPais;
public Long aIdioma;




    public LPMantenimientoGerenteCongelado() {
        super();
    }


	 public void inicio() throws Exception{


	}

	public void ejecucion() throws Exception {
    aPais = UtilidadesSession.getPais(this);
    aIdioma = UtilidadesSession.getIdioma(this);

		setTrazaFichero();
        
        /**
        Si (accion == "") entonces 
        
        Si no Si (accion == "insertar") entonces 
        -> ejecutar método "insertarGerenteCongelado()" 
        Si no Si (accion == "consultar") entonces 
        -> ejecutar método "consultarGerenteCongelado()" 
        Si no Si (accion == "guardar") entonces 
        -> ejecutar método "guardarGerenteCongelado()" 
        Si no Si (accion == "modificar") entonces 
        -> ejecutar método "modificarGerenteCongelado()" 
        Fin si 
        */
        try {                    
            accion = conectorParametroLimpia("accion", "", true);
            if (accion.equals("insertar")) {
                traza("Antes de llamar al metodo insertarGerenteCongelado ..");
                insertarGerenteCongelado();
                traza("Despues de llamar al metodo insertarGerenteCongelado ..");
            } else if (accion.equals("consulta")) {
                traza("Antes de llamar al metodo consultarGerenteCongelado ..");
                consultarGerenteCongelado();
                traza("Despues de llamar al metodo consultarGerenteCongelado ..");
            }  else if (accion.equals("guardar")) {
                traza("Antes de llamar al metodo guardarGerenteCongelado() ..");
                guardarGerenteCongelado();
                traza("Despues de llamar al metodo guardarGerenteCongelado() ..");
            }  else if (accion.equals("modificacion")) {
                traza("Antes de llamar al metodo modificarGerenteCongelado() ..");
                modificarGerenteCongelado();
                traza("Despues de llamar al metodo modificarGerenteCongelado() .."); 
            }

			
        } catch (Exception ex)  {
              traza(ex);
              lanzarPaginaError(ex);
        } 

	}




  public void insertarGerenteCongelado () throws Exception {
		/**
		-> Crear variable llamada "datos" de tipo DTODatosGerenteCongelacion 

		-> datos.fechaDesde = fechaDesde tomada de la pantalla llamante 
		-> datos.fechaHasta = fechaHasta tomada de la pantalla llamante 
		-> datos.oidCliente = oidCliente tomado de la pantalla llamante (si viene nulo se setea nulo) 
		-> datos.codigoCliente = codigoCliente tomado de la pantalla llamante 
		-> datos.descongelacion = descAutomatica tomada de la pantalla llamante 


		-> Crear idBusiness = "COMInsertarGerenteCongelado" 

		-> Asignar conector "ConectorInsertarGerenteCongelado" con idBusiness y DTODatosGerenteCongelacion creado 

		*/
		setTrazaFichero();
		traza("insertarGerenteCongelado 1");
		DTODatosGerenteCongelacion datos= new DTODatosGerenteCongelacion();
		Date fDesde = new Date(conectorParametro("fechaDesde"));
		Date fHasta = new Date(conectorParametro("fechaHasta"));
		Long oidCliente = (conectorParametro("oidCliente").equals(""))? null : new Long(conectorParametro("oidCliente"));
		String codCli = conectorParametro("codigoCliente");
		BigDecimal importe=new BigDecimal(conectorParametro("importe"));		
		Boolean descongela = new Boolean (false);
		if(conectorParametro("descongelacionAutomatica").equals("S"))
			descongela= new Boolean (true);

					
		traza("insertarGerenteCongelado 2");
    datos.setFechaDesde(fDesde);				
    datos.setFechaHasta(fHasta);		    
		datos.setImporte(importe);
		datos.setOidCliente(oidCliente);
		datos.setCodigoCliente(codCli);
		datos.setDescongelacion(descongela);
		datos.setOidPais(aPais);
		datos.setOidIdioma(aIdioma);				
		
		traza("setea página insertar");
		pagina("contenido_mantenimiento_gerente_congelado_insertar");
		this.getFormatosValidaciones();
    asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		// idBusiness= "COMInsertarGerenteCongelado" 
		
    try{
      
      MareBusinessID idBusiness = new MareBusinessID("COMInsertarGerenteCongelado");
      
      Vector vector = new Vector();
      vector.addElement(datos);
      vector.addElement(idBusiness);
      
      
      traza("****JAS****");
      traza("DTODatosGerenteCongelacion tiene: " + datos);
      traza("****JAS****");
      
      
      traza(" insertarGerenteCongelado ANTES DE CONECTAR");
      DruidaConector druidaconector = conectar("ConectorInsertarGerenteCongelado",vector);
      traza(" DESPUES DE CONECTAR");
      getConfiguracionMenu("LPMantenimientoGerenteCongelado","insertar");
      
      }catch(Exception e){
        this.logStackTrace(e);
        this.lanzarPaginaError(e);
      }
  
  }

	public void consultarGerenteCongelado ()throws Exception  {

		/**
		-> Asignar página contenido_mantenimiento_gerente_congelado_mostrar.xml 
		-> Setear variable casoDeUso = "consulta" 
		-> Mapear los datos de la pantalla llamante en la ventana modal 
		*/


		
		traza("Entro a inicio consultarGerenteCongelado");
		
		String fechaDesde=conectorParametro("fechaDesde");
		String fechaHasta=conectorParametro("fechaHasta");
		String oidCliente=conectorParametro("oidCliente");
		String codigoCliente=conectorParametro("codigoCliente");
		String oidCongelado=conectorParametro("oidCongelado");
		String importe=conectorParametro("importe");
		String descongelacionAutomatica=conectorParametro("descongelacionAutomatica");
		String vigente=conectorParametro("vigente");

		
		traza("consultarGerenteCongelado 1");
    pagina("contenido_mantenimiento_gerente_congelado_mostrar");
		this.getFormatosValidaciones();
		asignarAtributo("VAR", "casoDeUso", "valor", "consulta");
    asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

		traza("consultarGerenteCongelado 2");

		asignarAtributo("VAR", "fechaDesde", "valor", (fechaDesde!=null)? fechaDesde: "");
		asignarAtributo("VAR", "fechaHasta", "valor", (fechaHasta!=null)?fechaHasta: "");
		asignarAtributo("VAR", "oidCliente", "valor", (oidCliente!=null)?oidCliente: "");
		asignarAtributo("VAR", "codigoCliente", "valor", (codigoCliente!=null)?codigoCliente: "");
		asignarAtributo("VAR", "oidCongelado", "valor", (oidCongelado!=null)?oidCongelado: "");
		asignarAtributo("VAR", "importe", "valor", (importe!=null)?importe: "");
		asignarAtributo("VAR", "descongelacionAutomatica", "valor", (descongelacionAutomatica.equals("1"))?"S": "N");
		asignarAtributo("VAR", "vigente", "valor", (vigente!=null)?vigente: "");
		asignarAtributo("VAR", "varPais", "valor", aPais.toString());
		asignarAtributo("VAR", "varIdioma", "valor", aIdioma.toString());
		getConfiguracionMenu("LPMantenimientoGerenteCongelado","consulta");

		traza("consultarGerenteCongelado 3");
	
	}

    public void guardarGerenteCongelado () throws Exception  {

		/**
		-> Crear variable llamada "datos" de tipo DTODatosGerenteCongelacion 

		-> datos.fechaDesde = fechaDesde tomada de la pantalla llamante 
		-> datos.fechaHasta = fechaHasta tomada de la pantalla llamante 
		-> datos.oidCliente = oidCliente tomado de la pantalla llamante (si viene nulo se setea nulo) 
		-> datos.codigoCliente = codigoCliente tomado de la pantalla llamante 
		-> datos.descongelacion = descAutomatica tomada de la pantalla llamante 


		-> Crear idBusiness = "COMModificarGerenteCongelado" 

		-> Asignar conector "ConectorModificarGerenteCongelado" con idBusiness y DTODatosGerenteCongelacion creado 
		*/

		traza("Entro guardarGerenteCongelado 1");
		DTODatosGerenteCongelacion datos= new DTODatosGerenteCongelacion();
		Date fDesde = new Date(conectorParametro("fechaDesde"));
		Date fHasta = new Date(conectorParametro("fechaHasta"));
		Long oidCliente = conectorParametro("oidCliente").equals("") ? null : new Long(conectorParametro("oidCliente"));
		String codCli = conectorParametro("codigoCliente");
		Boolean descongela = new Boolean (false);
		if(conectorParametro("descongelacionAutomatica").equals("S")) descongela= new Boolean (true);
		Long oidCongelado= conectorParametro("oidCongelado").equals("") ? null : new Long(conectorParametro("oidCongelado"));
		BigDecimal importe= new BigDecimal(conectorParametro("importe"));
		traza("oid= " + oidCongelado + " imp= " + importe);

		
		traza("setea página modificar");
	  pagina("contenido_mantenimiento_gerente_congelado_modificar");
		this.getFormatosValidaciones();
    asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
	
		datos.setFechaDesde(fDesde);				
        datos.setFechaHasta(fHasta);		
		datos.setOidCliente(oidCliente);
		datos.setCodigoCliente(codCli);
		datos.setDescongelacion(descongela);
		datos.setOidPais(aPais);
		datos.setOidIdioma(aIdioma);
		datos.setOidCongelado(oidCongelado);
		datos.setImporte(importe);

		traza("guardarGerenteCongelado 2");

		// idBusiness= "COMInsertarGerenteCongelado" 
		MareBusinessID idBusiness = new MareBusinessID("COMModificarGerenteCongelado");
		Vector vector = new Vector();
        vector.addElement(datos);
        vector.addElement(idBusiness);

         traza(" guardarGerenteCongelado  ANTES DE CONECTAR");
         DruidaConector druidaconector = conectar("ConectorModificarGerenteCongelado",vector);
         traza(" DESPUES DE CONECTAR");

		 getConfiguracionMenu("LPMantenimientoGerenteCongelado","guardar");


	}

	public void modificarGerenteCongelado () throws Exception {

		/**
		-> Asignar página contenido_mantenimiento_gerente_congelado_mostrar.xml 
		-> Setear variable casoDeUso = "modificacion" 
		-> Mapear los datos de la pantalla llamante en la ventana modal
		*/


		traza("Entro a inicio modificarGerenteCongelado");

				
		String fechaDesde=conectorParametro("fechaDesde");
		String fechaHasta=conectorParametro("fechaHasta");
		String oidCliente=conectorParametro("oidCliente");
		String codigoCliente=conectorParametro("codigoCliente");
		String oidCongelado=conectorParametro("oidCongelado");
		String importe=conectorParametro("importe");
		String descongelacionAutomatica=conectorParametro("descongelacionAutomatica");
		String vigente=conectorParametro("vigente");


		pagina("contenido_mantenimiento_gerente_congelado_mostrar");
		this.getFormatosValidaciones();
    asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

		asignarAtributo("VAR", "casoDeUso", "valor", "modificacion");


		asignarAtributo("VAR", "fechaDesde", "valor", (fechaDesde!=null)? fechaDesde: "");
		asignarAtributo("VAR", "fechaHasta", "valor", (fechaHasta!=null)?fechaHasta: "");
		asignarAtributo("VAR", "oidCliente", "valor", (oidCliente!=null)?oidCliente: "");
		asignarAtributo("VAR", "codigoCliente", "valor", (codigoCliente!=null)?codigoCliente: "");
		asignarAtributo("VAR", "oidCongelado", "valor", (oidCongelado!=null)?oidCongelado: "");
		asignarAtributo("VAR", "importe", "valor", (importe!=null)?importe: "");
		asignarAtributo("VAR", "descongelacionAutomatica", "valor", (descongelacionAutomatica.equals("1"))?"S": "N");
		asignarAtributo("VAR", "vigente", "valor", (vigente!=null)?vigente: "");
		asignarAtributo("VAR", "varPais", "valor", aPais.toString());
		asignarAtributo("VAR", "varIdioma", "valor", aIdioma.toString());

		getConfiguracionMenu("LPMantenimientoGerenteCongelado","modificacion");

}


  private void logStackTrace(Throwable e) throws Exception {
  
    traza("Se produjo la excepcion: " + e.getMessage());
    
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    e.printStackTrace(ps);
    
    traza("Stack Trace: " + baos.toString());

  }




}

