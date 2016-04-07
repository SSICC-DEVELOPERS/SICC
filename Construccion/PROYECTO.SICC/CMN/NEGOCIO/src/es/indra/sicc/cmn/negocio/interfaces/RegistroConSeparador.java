package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.util.Tokenizer;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import es.indra.sicc.util.UtilidadesLog;

/*
 * 14-05-2005 - rgiorgi: inc. 17977
 * 31-05-2005 - rgiorgi: inc. 18668
 * */
public class RegistroConSeparador extends Registro 
{
  private String separadorCampos;

  public RegistroConSeparador( String separadorCampos, String relleno, String rellenoNumerico, boolean comillas )
  {
    super( relleno, rellenoNumerico, comillas );
    this.separadorCampos = separadorCampos;
  }

  protected List separarCampos( String reg )
  {
	// Modificado porque la clase de Java no reconoce campos vacíos
    //StringTokenizer parser = new StringTokenizer( reg, separadorCampos );
	Tokenizer parser = new Tokenizer( reg, separadorCampos );
    ArrayList listaCampos = new ArrayList();
    while( parser.hasMoreTokens() )
      listaCampos.add( parser.nextToken() );
      
    return listaCampos;
  }
  
  public String serializar( IRegistroSicc registroSicc ) throws InterfacesException
  {
    String str = super.serializar( registroSicc );
	// Se elimina el carácter de separación de la última posición
    return str.substring( 0, str.length()-1 );
  }

  protected String serializarString( String string, int ancho )
  {
		if( string == null )
			return CADENA_VACIA + separadorCampos;

    String str = super.serializarString( string, ancho );
    return str + separadorCampos;
  }
  
  protected String serializarDate( Date date, int ancho ) {
	  String str = super.serializarDate( date, ancho );
	  return str + separadorCampos;
  }

  /*
   * 1/8/2005 - rgiorgi: inc. BELC300020151
   * */  
  protected String serializarFloat( Float flotante, int ancho, int decimales )
	throws InterfacesException {

		if( flotante == null ) {
            return CADENA_VACIA + separadorCampos;
		}

		String patronDecimal = iterarCaracter( getRellenoNumerico(), decimales );
		if( flotante.doubleValue() < 0 ) ancho--;
		String patronEntera = getRellenoNumerico();
		StringBuffer patron = new StringBuffer( patronEntera + PUNTO + patronDecimal );
		patron.append( PUNTO_Y_COMA + patron + SIGNO_NEGATIVO );
	
		String str = super.serializarNumeroDecimal( new Double( flotante.doubleValue() ), patron );
		//rgiorgi - 27/8/2005: no se debe rellenar en registros con separador
		//str = recortarADerecha(str,ancho);
	  return str + separadorCampos;
  }

  /*
   * 31/5/2005 - rgiorgi: inc. 18668
   * 27/8/2005 - rgiorgi: quito la llamada al serializar de Registro para que
   * 						no rellene cuando viene a null.
   * */
  protected String serializarLong( Long largo, int ancho ) {
	  if (largo != null){
		  return largo.toString() + separadorCampos;
	  }else{
		  return "" + separadorCampos;
	  }
  }

  /*
   * 27/8/2005 - rgiorgi: quito la llamada al serializar de Registro para que
   * 						no rellene cuando viene a null.
   * */  
  protected String serializarInteger( Integer integer, int ancho ) {
	  if (integer != null){
		  return integer.toString() + separadorCampos;
	  }else{
		  return "" + separadorCampos;
	  }
  }
  
  /*
   * 1/8/2005 - rgiorgi: inc. BELC300020151
   * */
  protected String serializarBigDecimal( BigDecimal bigDecimal, int ancho, int decimales, String coma )
	throws InterfacesException {

		if( bigDecimal == null )
			return CADENA_VACIA + separadorCampos;

		String patronDecimal = iterarCaracter( "0", decimales );
		if( bigDecimal.doubleValue() < 0 ) ancho--;
		String patronEntera = "0";
		StringBuffer patron = new StringBuffer( patronEntera + PUNTO + patronDecimal );
		patron.append( PUNTO_Y_COMA + SIGNO_NEGATIVO + patron );
        
        // splatas - DBLG700000004 - 29/09/2006
        /*  
            String str = super.serializarNumeroDecimal( 
                new Double( bigDecimal.doubleValue() ), patron ) ;
        */
		String str = serializarNumero( 
			new Double( bigDecimal.doubleValue() ), patron ) ;
		// splatas - DBLG700000004 - 29/09/2006
        

        //rgiorgi - 27/8/2005: no se debe rellenar en registros con separador
		//return recortarADerecha(str, ancho) + separadorCampos;
        
        return str + separadorCampos;
  }
  
  protected String serializarNumero( Double doble, StringBuffer patron )
		throws InterfacesException {

		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setMinusSign( SIGNO_NEGATIVO );
		DecimalFormat formatter = new DecimalFormat( patron.toString(), simbolos );
	
		StringBuffer str = new StringBuffer( formatter.format( doble ) );
		char[] separador = { simbolos.getDecimalSeparator() };
		String sep = new String( separador );
		
		return str.toString();
  }
  
  public static void main( String[] args )
  {
    RegistroConSeparador reg = new RegistroConSeparador( ";", " ", "0",false );
    try
    {
      reg.addCampo( "codigo", Class.forName("java.lang.String"), 9, 0, null );
      reg.addCampo( "codigoIdioma", Class.forName("java.lang.String"), 2, 0, null );
	  reg.addCampo( "importe", Class.forName("java.math.BigDecimal"), 10, 2, "," );
	  reg.addCampo( "numero", Class.forName("java.lang.Integer"), 6, 0, null );
      reg.addCampo( "descripcion", Class.forName("java.lang.String"), 40, 0, null );
    } catch( Exception ex )
    {
      ex.printStackTrace();
    }
    IRegistroSicc regSicc = new RegistroSicc();
    
    try
    {
      regSicc.anyadirCampo( "codigo", "Codigo" );
	  regSicc.anyadirCampo( "codigoIdioma", "ES" );
	  regSicc.anyadirCampo( "descripcion", "DESC" );
	  regSicc.anyadirCampo( "importe", new BigDecimal(12345) );
	  regSicc.anyadirCampo( "numero", new Integer(1234) );
	  
	  String str = reg.serializar(regSicc);
	  UtilidadesLog.debug(str);
    } catch( InterfacesException ex ) 
    {
      UtilidadesLog.debug( ex.getMotivo() );
    }
    
    //UtilidadesLog.debug( regSicc.obtenerCampo("codigo"));
    //UtilidadesLog.debug( regSicc.obtenerCampo("codigoIdioma"));
    //UtilidadesLog.debug( regSicc.obtenerCampo("descripcion"));
    
  }

}