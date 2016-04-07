//Creado para Walter Villafañe
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import LPSICCBase;

//MGU
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.*;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.mare.common.mln.MareBusinessID;
import java.lang.reflect.*;
import java.util.*;
import es.indra.sicc.util.*;
import java.io.*;
import java.util.Locale;

import es.indra.mare.common.mgu.manager.Property;
//MEN
import es.indra.sicc.util.UtilidadesSession;

//Otros
import java.util.HashMap;
import java.util.Locale;
import java.util.Date;
import java.text.DateFormat;

public class LPActualizarFrame extends LPSICCBase {

	private static String ACTION_MOSTRAR_FECHAHORA = "MOSTRAR_FECHAHORA";
	private static String ACTION_SINACCION = "";
	private static String ACCION = "accion";
	private static String CADENA_NULA = "";
	public static final String FORMATO_DEFAULT_HORA = "hh:mm"; 

	protected void traza(Object o) {}	
	public void inicio() throws Exception { 
	//	traza("1");
		pagina("cabecera"); 
		traza("Metodo Inicio de LPActualizarFrame() ");
//		traza("2");		
	}

	public void ejecucion() throws Exception {
		setTrazaFichero();

		try{
//		traza("3");		
			String sAction = conectorParametroLimpia( ACCION, CADENA_NULA, true);
			traza( "sAction " + sAction);
			if ( sAction.equals( ACTION_SINACCION ) ){
					//	traza("4");		
				mostrarDatos();
			} 
			else if ( sAction.equals( ACTION_MOSTRAR_FECHAHORA ) ){
			//			traza("5");		
				mostrarDatos();
			}
				//	traza("6");		
		}
		catch(Throwable th){
			imprimirStack(th);
		}
			
	
	}

	private void imprimirStack(Throwable th){
		try{
			ByteArrayOutputStream stack = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(stack);
			th.printStackTrace(out);
			traza(  stack.toString());
		}
		catch(Exception ex){

		}
	}

	private void mostrarDatos() throws Exception{
		//Viene del menu
		//Hay que descomentar todo lo que se está hardcodeando.
		
		//**********************		DATOS DEL USUARIO ********************
		String usuario = null;
		StringBuffer buf = new StringBuffer();
		//traza("7");

		try{
     //traza("Primer Nombre");
			buf.append( nullString( UtilidadesSession.getPrimerNombre(this) ) );
      buf.append(" ");
			//traza("Primer Nombre: " + buf.toString() );
      
		}
		catch(Exception ex){
			//imprimirStack(ex);
		}
		
		//traza("8");
		try{
      //traza("2do Nombre");    
//			buf.append(  nullString( UtilidadesSession.getSegundoNombre(this) ) );
//			buf.append(" ");
			//traza("Segundo Nombre: " + buf.toString() );
		}
		catch(Exception ex){
			//imprimirStack(ex);
		}
		
		//traza("9");
		try{
      //traza("1er Ape");
			buf.append(  nullString( UtilidadesSession.getPrimerApellido(this) ) );
			buf.append(" ");
			//traza("Primer Apellido: " + buf.toString() );
 		}
		catch(Exception ex){
			//imprimirStack(ex);		
		}
		
//		traza("4");
		try{
      //traza("2do Ape");
	//		buf.append(  nullString( UtilidadesSession.getSegundoApellido(this) )  );
	//		buf.append(" ");
			//traza("Segundo Apellido: " + buf.toString() );
		}
		catch(Exception ex){
			// imprimirStack(ex);		
		}

//		traza("5");
		usuario = buf.toString();

		//traza("usuario " + usuario);

		//traza("10");
		HashMap hs = (HashMap) conectorParametroSesion( IVariablesSesion.PROPERTIES_USUARIO );
		traza("hs properties: " + hs.toString() );
    
		Property prop = (Property) hs.get( "Idioma_ISO" ) ;
    //traza("Idioma_ISO: " + prop.toString() );
		//traza("Idioma_ISO "  + prop.getValue().toString() );
 		//traza("11");
		Property prop2 = (Property) hs.get( "DescripcionPaisDefecto" ) ;
    //traza("DescripcionPaisDefecto: " + prop2.toString() );
		//traza("DescripcionPaisDefecto "  + prop2.getValue().toString() );
		/*
		HashMap propsUser = (HashMap) conectorParametroSesion("propiedades");
		final Property propNombre_1 = (Property)propsUser.get("nombre1");
		final Property propNombre_2 = (Property)propsUser.get("nombre2");
		final Property propApellido_1 = (Property)propsUser.get("ape1");
		final Property propApellido_2 = (Property)propsUser.get("ape2");                        
		

		String usuario = propNombre_1.getValue() + " " +  propNombre_2.getValue() + " " + propApellido_1.getValue() + " " + propApellido_2.getValue()
		*/

		//**********************		PAIS DEL USUARIO ********************
		 
		
		
		//**********************************************************************

		//**********************************************************************
		//**********************		FECHA HORA DEL SISTEMA ********************
		String hora = null;
		String fecha = null;

		/*
		//traza("12");
		Locale locale = null;
		try{
			locale = new Locale( UtilidadesSession.getIdioma_ISO( this),"" ); 	
		}
		catch(Exception ex){
			locale = Locale.getDefault();
		}
		*/
		
		//		traza("13");
	
		String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
		//DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT,locale);
		Date fechaHoy = new Date();

		//fecha = dateFormatter.format(fechaHoy);
		fecha =UtilidadesBelcorp.fechaFormateada(fechaHoy ,formatoFechaPais);
		//DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT,locale);
		//hora = timeFormatter.format(fechaHoy);
		hora = UtilidadesBelcorp.horaFormateada(fechaHoy ,FORMATO_DEFAULT_HORA);

		String fechaHora = fecha + " " + hora;

// + " " +
//    
    

    Integer ancho = null;

    
    String sPais = UtilidadesSession.getDescripcionPais(this);
    ancho = anchoLabel(sPais);
    
    asignarAtributo("LABELC", "lblPais", "valor", UtilidadesSession.getDescripcionPais( this ) );
    asignarAtributo("LABELC", "lblPais", "ancho", ancho.toString() );
    //traza("Texto pais: " + sPais);
    //traza("Cant. caracteres: " + sPais.length() );
    //traza("Ancho: " + ancho.toString() );
    
    asignarAtributo("LABELC", "lblHora", "valor", hora );
	asignarAtributo("VAR", "loaded", "valor", "true");
  	asignarAtributo("LABELC", "lblFecha", "valor", fecha );    
    //buf = new StringBuffer();
    //buf.append("W");
    ancho = anchoLabel( buf.toString() );
    asignarAtributo("LABELC", "lblNombre", "valor", buf.toString() );
    asignarAtributo("LABELC", "lblNombre", "ancho", ancho.toString() );
    //traza("Texto Nombre: " + buf.toString());
    //traza("Cant. caracteres: " + buf.toString().length() );
    //traza("Ancho: " + ancho.toString() );

    
		//asignarAtributo("VAR", "hidFechaHora", "valor", fechaHora);
		//asignarAtributo("VAR", "hidUsuario", "valor", usuario);
		//asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getDescripcionPais( this ));

	}

  private Integer anchoLabel(String cadena)
  {
      Integer anchoLabel = null;
      int longitud = cadena.length();
      
      anchoLabel = new Integer(longitud * 10);

      if (anchoLabel.intValue() > 300 )
        anchoLabel = new Integer(300);

      return anchoLabel;
  
  }

  


	private String nullString( Object obj) throws Exception {
    //traza("Funcion nullString ");
		String sRetorno = null;
		if ( obj == null){
      //traza("obj es nulo");
			sRetorno = "";
		}
		else{
      
			sRetorno = obj.toString();
		}
    //traza("sREtorno: " + sRetorno);
		return sRetorno;
	}
/*
	private String getDescripcionPais(LPSICCBase lp ) throws Exception{
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais( new Long(1) );
		
		Vector vecPaises = new Vector(2);
		vecPaises.add( new MareBusinessID("MENConsultaPaises") );
		vecPaises.add( dto );
		traza("1");
		lpWally tapon =  lp;
		traza("1");
		DruidaConector dc =  tapon.taponConectar( " " , vecPaises );


		return null;
		 
	}
*/
}
