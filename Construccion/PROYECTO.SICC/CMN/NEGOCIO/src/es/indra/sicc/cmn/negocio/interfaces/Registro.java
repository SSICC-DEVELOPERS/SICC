package es.indra.sicc.cmn.negocio.interfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import es.indra.sicc.util.UtilidadesLog;

public abstract class Registro 
{
  public static final String ANCHO_FIJO ="ANCHO_FIJO";
  public static final String CON_SEPARADOR = "CON_SEPARADOR";
  
  protected static final char SIGNO_NEGATIVO = '-';
	protected static final String PUNTO = ".";
	protected static final String PUNTO_Y_COMA = ";";
	protected static final String CADENA_VACIA = "";
    protected static final String COMILLA = "\"";
  
  protected static final String TRUE = "1";
  protected static final String FALSE = "0";
  
  protected static final String STRING = "java.lang.String";
  protected static final String FLOAT = "java.lang.Float";
  protected static final String INTEGER = "java.lang.Integer";
  protected static final String DATE = "java.util.Date";
  protected static final String BIGDECIMAL = "java.math.BigDecimal";
  protected static final String LONG = "java.lang.Long";
  protected static final String BOOLEAN = "java.lang.Boolean";

  protected List campos;
  protected String relleno;
  protected String rellenoNumerico;
  protected boolean comillas;

  public Registro( String relleno, String rellenoNumerico,boolean comillas )
  {
    this.relleno = relleno;
    this.rellenoNumerico = rellenoNumerico;
    this.comillas = comillas;
    campos = new ArrayList();
  }

  public void addCampo( String nombre, Class clase, int ancho, int decimales, String coma )
  {
    campos.add( new Campo( nombre, clase, ancho, decimales, coma ) );
  }

  public Campo getCampo( int i )
  { 
    return (Campo)campos.get(i);
  }

  public String serializar( IRegistroSicc registroSicc ) throws InterfacesException
  {
		if( registroSicc == null )
			throw new InterfacesException( "Se intentó serializar un registro nulo" );

    if( numeroCampos() != registroSicc.numeroCampos() )
			throw new InterfacesException( 
			"Error de serialización - el número de campos no coincide" + 
			System.getProperty( "line.separator" ) + 
			"Registro de entrada: " + registroSicc );

    Campo campo;
    String nombre;
    Class clase;
    int ancho;
    int decimales;
    String coma;

    Object valor;

    StringBuffer registro = new StringBuffer();
    
    for( int i = 0; i < campos.size(); i++ )
    {
      campo = (Campo)campos.get(i);
      nombre = campo.getNombre();
      clase = campo.getClase();
      ancho = campo.getAncho();
      decimales = campo.getDecimales();
      coma = campo.getComa();
      
      valor = registroSicc.obtenerCampo( nombre );
	  // Comentado para admitir que la lógica de negocio
	  // pase campos nulos
	  /**
      if( valor == null )
        throw new InterfacesException( 
			"Error de serialización - el campo [" + nombre + 
			"] no existe en el registro de entrada" );
	  **/

      try
      {
        if( clase.equals( Class.forName( STRING ) ) )
          registro.append( serializarString( (String)valor, ancho ) );

        else if( clase.equals( Class.forName( INTEGER ) ) )
          registro.append( serializarInteger( (Integer)valor, ancho ) );

        else if( clase.equals( Class.forName( FLOAT ) ) )
			registro.append( serializarFloat( (Float)valor, ancho, decimales ) );

        else if( clase.equals( Class.forName( DATE ) ) )
          registro.append( serializarDate( (Date)valor, ancho ) );

		else if( clase.equals( Class.forName( BIGDECIMAL ) ) )
		  registro.append( serializarBigDecimal( (BigDecimal)valor, ancho, decimales, coma ) );
		  
		else if( clase.equals( Class.forName( LONG ) ) )
			registro.append( serializarLong( (Long)valor, ancho ) );
			
		else if( clase.equals( Class.forName( BOOLEAN ) ) )
			registro.append( serializarBoolean( (Boolean)valor ) );

		else
          throw new InterfacesException( 
			"Error de serialización - clase no serializable: " + clase );
      }
      catch( ClassNotFoundException cex )
      {
        throw new InterfacesException( "Error de serialización - clase: " + clase, cex );
      }
	  catch( ClassCastException ccex ) {
		  throw new InterfacesException( "Error de serialización - clase: " + clase + 
										" - campo: " + nombre + 
										" - valor: " + valor, ccex );
	  }
              
    }
    return registro.toString();
  }
  
  protected abstract List separarCampos( String registro ) throws InterfacesException;

  public IRegistroSicc parsear( String registro ) throws InterfacesException
  {
    IRegistroSicc registroSicc = new RegistroSicc();
    List listaCampos = separarCampos( registro );
    if( listaCampos.size() != campos.size() )
    {
      throw new InterfacesException( 
			"Error de parseo - los números de campos no coinciden\n" + 
			"Número campos registro de entrada: " + listaCampos.size() + 
			"\nNúmero campos registro SICC: " + campos.size() +
			"\nRegistro: " + registro );
    }
    
    Campo campo;
    String nombre;
    Class clase;
    int ancho;
    int decimales;
    String coma;
    String valor;
    
    for( int i = 0; i < campos.size(); i++ )
    {
      campo = (Campo)campos.get(i);
      nombre = campo.getNombre();
      clase = campo.getClase();
      ancho = campo.getAncho();
      decimales = campo.getDecimales();

      valor = (String)listaCampos.get(i);

      try
      {
        if( clase.equals( Class.forName(STRING) ) )
          registroSicc.anyadirCampo( nombre, parsearString( valor, relleno, ancho  ) );

        else if( clase.equals( Class.forName(INTEGER) ) )
        {
          try
          {
            registroSicc.anyadirCampo( nombre, parsearInteger( valor, rellenoNumerico ) );
          } catch( NumberFormatException nex )
          {
            throw new InterfacesException( "Error al parsear número entero: " + 
              nombre + "(" + valor + ")" );
          }
        }
		
		else if( clase.equals( Class.forName(LONG) ) )
        {
          try
          {
            registroSicc.anyadirCampo( nombre, parsearLong( valor, rellenoNumerico ) );
          } catch( NumberFormatException nex )
          {
            throw new InterfacesException( "Error al parsear número Long: " + 
              nombre + "(" + valor + ")" );
          }
        }
          
        else if( clase.equals( Class.forName(FLOAT) ) )
        {
          try
          {
            registroSicc.anyadirCampo( nombre, parsearFloat( valor, rellenoNumerico, decimales ) );
          } catch( NumberFormatException nex )
          {
            throw new InterfacesException( "Error al parsear número Float: " + 
              nombre + "(" + valor + ")" );
          }
        }
		
		else if( clase.equals( Class.forName(BIGDECIMAL) ) )
        {
          try
          {
            registroSicc.anyadirCampo( nombre, parsearBigDecimal( valor, rellenoNumerico, decimales ) );
          } catch( NumberFormatException nex )
          {
            throw new InterfacesException( "Error al parsear número BigDecimal: " + 
              nombre + "(" + valor + ")" );
          }
        }
          
        else if( clase.equals( Class.forName(DATE) ) )
          registroSicc.anyadirCampo( nombre, parsearDate( valor ) );

        else
          throw new InterfacesException( "Error de parseo - clase no parseable: " + clase );
      }
      catch( ClassNotFoundException cex )
      {
        throw new InterfacesException( "Error de parseo - clase: " + clase, cex );
      }

    }
    
    return registroSicc;

  }
  
  protected String serializarString( String string, int ancho )
  {
    if( string.length() > ancho ){
      string = string.substring( 0, ancho );
    }
    if(this.comillas){
      string = COMILLA +string+ COMILLA;
    }
    return string;
  }
    
  protected String serializarDate(Date date, int ancho)
  {
		if( date == null )
			return iterarCaracter( relleno, ancho );
		
		String patron = null;
		if( ancho == 8 )
			patron = "yyyyMMdd";
		else
		if( ancho == 6 )
			patron = "yyMMdd";
		DateFormat formatter = new SimpleDateFormat( patron );
		String fecha = formatter.format( date );
	
		return fecha;
  }

  /*
   * 1/8/2005 - rgiorgi: inc. BELC300020151
   * */  
  protected String recortarADerecha(String cadena, int ancho ){
	
	StringBuffer str = new StringBuffer( cadena.toString() );
    if( str.length() > ancho )
      // Hay que truncar por la derecha
	  str.delete( 0, str.length()-ancho );
    else if( str.length() < ancho )
    {
      // Hay que rellenar por la izquierda
      str.reverse();
      while( str.length() < ancho )
        str.append( rellenoNumerico );
      str.reverse();
    }
	
	return str.toString();
  }

  /*
   * 1/8/2005 - rgiorgi: inc. BELC300020151
   * 27/8/2005 - rgiorgi: se mueve el relleno a RegistroAnchoFijo
   * */
  protected String serializarInteger( Integer integer, int ancho )
  {
		if( integer == null )
			return iterarCaracter( rellenoNumerico, ancho );

    //String str = recortarADerecha( integer.toString(), ancho );        
    return integer.toString();
  }

  /*
   * 1/8/2005 - rgiorgi: inc. BELC300020151
   * 27/8/2005 - rgiorgi: se mueve el relleno a RegistroAnchoFijo
   * */  
  protected String serializarLong( Long largo, int ancho ) {
	  if( largo == null )
		return iterarCaracter( rellenoNumerico, ancho );

    //String str = recortarADerecha(largo.toString(), ancho);    
    return largo.toString();
  }
	

  protected abstract String serializarFloat( Float flotante, int ancho, int decimales )
    throws InterfacesException;

  protected abstract String serializarBigDecimal( BigDecimal bigDecimal, int ancho, int decimales, String coma )
		throws InterfacesException;
	
	protected String serializarNumeroDecimal( Double doble, StringBuffer patron )
		throws InterfacesException {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setMinusSign( SIGNO_NEGATIVO );
		DecimalFormat formatter = new DecimalFormat( patron.toString(), simbolos );
	
		StringBuffer str = new StringBuffer( formatter.format( doble ) );
		char[] separador = { simbolos.getDecimalSeparator() };
		String sep = new String( separador );
		str.deleteCharAt( str.indexOf( sep ) );
	
		return str.toString();
  }
  
  public String serializarBoolean( Boolean boole ) {
  
	if( boole == null )
		return FALSE;
		
	if( boole.booleanValue() ) return TRUE;
	else return FALSE;
  }

  protected Date parsearDate( String date ) throws InterfacesException
  {
		if ( date == null || date.trim().length() == 0  ) {
			return null;
        }
	
		// El subsistema contempla fechas de anchura 8(AAAAMMDD) y 6(AAMMDD)
    if( date.length() != 8 && date.length() != 6 )
      throw new InterfacesException( "Longitud de fecha incorrecta: " + date );
			
		String patron = null;
		if( date.length() == 8 )
			patron = "yyyyMMdd";
		else if( date.length() == 6 ) 
			patron = "yyMMdd";
	
		DateFormat formatter = new SimpleDateFormat( patron );
		Date fecha = null;
		try {
			fecha = formatter.parse( date );
		} catch( ParseException pex ) {
			throw new InterfacesException( "Error al parsear fecha: " + date, pex );
		}
	
		return fecha;
  }
  
  protected String parsearString( String string, String relleno, int ancho )
  {
    // Eliminamos los caracteres de relleno de la derecha
    StringBuffer buffer = new StringBuffer( string ).reverse();
    if(this.comillas){
        if(buffer.length() > 0 && buffer.substring(0,1).equals(COMILLA)){
           buffer.deleteCharAt(0); 
        }
        buffer.reverse();
        if(buffer.length() > 0 && buffer.substring(0,1).equals(COMILLA)){
           buffer.deleteCharAt(0);
        }
        buffer.reverse();
        
    }
    while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) ){
      buffer.delete(0,1);
    }
    return buffer.reverse().toString();
  }
  
  protected Float parsearFloat( String strFlotante, String relleno, int decimales ) 
    throws InterfacesException
  {
		if( strFlotante == null || strFlotante.trim().equals( "" ) )
			strFlotante = getRellenoNumerico();
	
    Float flotante;

    // Eliminamos los caracteres de relleno de la parte izquierda
    StringBuffer buffer = new StringBuffer( strFlotante );
    while( buffer.length() > 1 && buffer.substring(0,1).equals(relleno) )
      buffer.delete(0,1);
      
    String str = buffer.toString();

    try {
      flotante = new Float( str );
    } catch( NumberFormatException ex ) {
      throw new InterfacesException( 
        "Formato de número decimal incorrecto: " + strFlotante, ex );
    }
    
    double divisor = Math.pow( 10, decimales );

    return new Float( flotante.doubleValue() / divisor );
  }
  
  protected BigDecimal parsearBigDecimal( String strBigDecimal, String relleno, int decimales )
	throws InterfacesException {
	
		if( strBigDecimal == null || strBigDecimal.trim().equals( "" ) )
			strBigDecimal = getRellenoNumerico();
	
		BigDecimal bigDecimal;

    try {
      bigDecimal = new BigDecimal( strBigDecimal );
    } catch( NumberFormatException ex ) {
      throw new InterfacesException( 
        "Formato de número decimal incorrecto: " + strBigDecimal, ex );
    }
        // Eliminamos los caracteres de relleno de la parte izquierda
    //StringBuffer buffer = new StringBuffer( strBigDecimal );
    //while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) )
    //  buffer.delete(0,1);
      
    //String str = buffer.toString();
    double divisor = Math.pow( 10, decimales );
    return new BigDecimal( bigDecimal.doubleValue() / divisor );
	}
  
  protected Integer parsearInteger( String strInteger, String relleno )
    throws InterfacesException
  {
		if( strInteger == null || strInteger.trim().equals( "" ) )
			strInteger = getRellenoNumerico();
	
    Integer entero;

    // Eliminamos los caracteres de relleno de la parte izquierda
    StringBuffer buffer = new StringBuffer( strInteger );
    while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) )
      buffer.delete(0,1);
	if( buffer.length() == 0 )
		return new Integer(0);
      
    String str = buffer.toString();
    
    try
    {
      entero = new Integer( str );
    } catch( NumberFormatException nex )
    {
      throw new InterfacesException( 
        "Formato de número entero incorrecto: " + str, nex );
    }
    
    return entero;
  }

  protected Long parsearLong( String strLong, String relleno )
    throws InterfacesException
  {
		if( strLong == null || strLong.trim().equals( "" ) )
			strLong = getRellenoNumerico();
	
    Long largo;

    // Eliminamos los caracteres de relleno de la parte izquierda
    StringBuffer buffer = new StringBuffer( strLong );
    while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) )
      buffer.delete(0,1);
		if( buffer.length() == 0 )
			return new Long(0);
      
    String str = buffer.toString();
    
    try
    {
      largo = new Long( str );
    } catch( NumberFormatException nex )
    {
      throw new InterfacesException( 
        "Formato de número Long incorrecto: " + str, nex );
    }
    
    return largo;
  }
  
  public Boolean parsearBoolean( String boole ) {
  
		if( boole.trim().equals( TRUE ) || boole.trim().toUpperCase().equals( "TRUE" ) )
			return Boolean.TRUE;
		return Boolean.FALSE;
  }
  
  protected String iterarCaracter(String caracter, int numero)
  {
    StringBuffer cadena = new StringBuffer( "" );
    for( int i = 0; i < numero; i++ )
      cadena.append( caracter );

    return cadena.toString();
  }

	public int numeroCampos() {
		return campos.size();
	}
  
  public String toString() 
  {
    StringBuffer buffer = new StringBuffer();
    Iterator it = campos.iterator();
    Campo campo;
    while( it.hasNext() ) 
    {
      campo = (Campo)it.next();
      buffer.append( campo.getNombre() + " - " );
    }
    
    return buffer.toString();
  }

  public String getRelleno()
  {
    return relleno;
  }

  public void setRelleno(String relleno)
  {
    this.relleno = relleno;
  }

  public String getRellenoNumerico()
  {
    return rellenoNumerico;
  }

  public void setRellenoNumerico(String rellenoNumerico)
  {
    this.rellenoNumerico = rellenoNumerico;
  }
  
	/**
	 * 
	 * @param args
	 */
  public static void main( String[] args )
  {
    Registro reg = new RegistroConSeparador( ";", " ", "0",false );
		Registro reg2 = new RegistroAnchoFijo( " ", "0",false );
		IRegistroSicc registro = new RegistroSicc();
		
	try {
		//UtilidadesLog.debug( reg.serializarBigDecimal( new BigDecimal("-0000123456"), 15, 2, "," ) );
		//UtilidadesLog.debug( reg.parsearBigDecimal( "0", CERO, 2) );
		//UtilidadesLog.debug( reg.serializarFloat( new Float("4.5"), 4, 2) );
		//UtilidadesLog.debug( reg2.parsearFloat( null, "0", 2 ) );
		UtilidadesLog.debug( reg2.serializarInteger( new Integer("123456"), 3) );
		System.exit(666);

		
		BigDecimal bd = new BigDecimal(1234.567);
		UtilidadesLog.debug( bd );
		UtilidadesLog.debug( reg.serializarBigDecimal( bd, 10, 2, "." ) ); 
		System.exit(666);

		UtilidadesLog.debug( reg.serializarBoolean( new Boolean("1") ) );
		UtilidadesLog.debug( reg.parsearBoolean( "00" ) );
		UtilidadesLog.debug( reg.parsearDate("20050303"));
		UtilidadesLog.debug( reg.serializarDate( new Date(), 8 ));
		UtilidadesLog.debug( reg.serializarDate( new Date(), 6 ));
		UtilidadesLog.debug( reg.serializarBigDecimal( new BigDecimal("12345.67"),10, 2, "," ) );
		UtilidadesLog.debug( reg.serializarString( null, 10 ));
	} catch( InterfacesException ex ) {
		UtilidadesLog.debug( ex.getMotivo() );
	}

    try
    {
      reg2.addCampo( "codigoCliente", Class.forName(STRING), 11, 0, null );
      reg2.addCampo( "nivelRiesgo", Class.forName(STRING), 1, 0, null );
      reg2.addCampo( "lineaCredito", Class.forName(BIGDECIMAL), 18, 2, "," );
			reg2.addCampo( "creditoDisponible", Class.forName(BIGDECIMAL), 18, 2, "," );
			
			registro.anyadirCampo( "codigoCliente", "00000000001" );
			registro.anyadirCampo( "nivelRiesgo", "A" );
			registro.anyadirCampo( "lineaCredito", new BigDecimal("0") );
			registro.anyadirCampo( "creditoDisponible", new BigDecimal("-1191") );
			
			UtilidadesLog.debug( reg2.serializar( registro ) );
			
    } catch( Exception ex )
    {
      ex.printStackTrace();
    }
		
		System.exit(666);
    
    try
    {
	  registro.anyadirCampo( "codigo", "ABC" );
	  registro.anyadirCampo( "codigoIdioma", null );
	  registro.anyadirCampo( "descripcion", null );
	  
	  UtilidadesLog.debug( reg.serializar( registro ) );
      //UtilidadesLog.debug( reg.parsearDate("20030123") );
      //UtilidadesLog.debug( reg.parsearFloat( "0 012345", "0", 1) );
      //UtilidadesLog.debug( reg.parsearInteger( "1204500000000000", "0" ) );
      //UtilidadesLog.debug( reg.parsearString( "En un lugar$$$$", "$", 15 ) );
      
      //UtilidadesLog.debug( reg.serializarFloat( new Float(123.45678), 5, 2 ) );
      
      //UtilidadesLog.debug( reg.serializarInteger( new Integer(12345), 4 ) );
      
      //registro = reg.parsear("000050001;ES;ULTRA RUBORES");
      
      //UtilidadesLog.debug( registro.obtenerCampo("codigo"));
      //UtilidadesLog.debug( registro.obtenerCampo("codigoIdioma"));
      //UtilidadesLog.debug( registro.obtenerCampo("descripcion"));
      
    } catch( InterfacesException ex )
    {
      UtilidadesLog.debug( ex.getMotivo() );
      ex.printStackTrace();
    }
  }
}