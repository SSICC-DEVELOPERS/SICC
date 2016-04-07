package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import es.indra.sicc.util.UtilidadesLog;

public class RegistroAnchoFijo extends Registro 
{
  private static UtilidadesLog logAux = new UtilidadesLog();
  public RegistroAnchoFijo( String relleno, String rellenoNumerico, boolean comillas)
  {
    super( relleno, rellenoNumerico, comillas );
  }
  
  protected List separarCampos( String registro ) throws InterfacesException
  {
    ArrayList listaCampos = new ArrayList();
    Campo campo;
    String valor;
    Iterator it = campos.iterator();
    UtilidadesLog.info("registro: "+registro + " length " + registro.length());     
    
    int size= sumaLengthCampos(campos); 
    UtilidadesLog.info("cant de campos "+ campos.size()+ " size "+size);
    
    if(size==registro.length()){//las interfaces de siempre
        while( it.hasNext() )
        {
          campo = (Campo)it.next();
          try
          {
            valor = (String)registro.substring( 0, campo.getAncho() );
            //doliva -- cambio Optimizacion Logs -- 24/03/2010
            if(logAux.isInfoEnabled()) { 
                UtilidadesLog.info("valor: "+valor+" Ancho: "+campo.getAncho());
            }
          } catch( IndexOutOfBoundsException iex )
          {
            throw new InterfacesException( "Error al parsear registro: \n" + registro, iex );
          }
    
                            listaCampos.add( valor );
          registro = registro.substring( campo.getAncho() );
        }
    }else{//pedido para RUV
      boolean hayException= false;
         while( it.hasNext() )
         {
           campo = (Campo)it.next();
           try
           {
             valor = (String)registro.substring( 0, campo.getAncho() );
             if(logAux.isInfoEnabled()) { 
                 UtilidadesLog.info("valor: "+valor+" Ancho: "+campo.getAncho());
             }
           } catch( IndexOutOfBoundsException iex )
           {
             //throw new InterfacesException( "Error al parsear registro: \n" + registro, iex );
             valor="";
               hayException=true;
           }
            // UtilidadesLog.info("valor: "+valor+" Ancho: "+campo.getAncho());
            listaCampos.add( valor );
            if(!hayException)
              registro = registro.substring( campo.getAncho() );
         }
    }

    return listaCampos;
  }
	
	protected BigDecimal parsearBigDecimal( String strBigDecimal, String relleno, int decimales )
		throws InterfacesException {
		
		if( strBigDecimal == null || strBigDecimal.equals( "" ) )
		{
			strBigDecimal = "0";
		} else {
			// Eliminamos los caracteres de relleno de la parte izquierda
			StringBuffer buffer = new StringBuffer( strBigDecimal );
			while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) )
				buffer.delete(0,1);
			strBigDecimal = buffer.toString();
		}
			
		return super.parsearBigDecimal( strBigDecimal, relleno, decimales );
	}
	
	protected String serializarString( String string, int ancho ) {

		if( string == null )
			return iterarCaracter( relleno, ancho );

		StringBuffer str = new StringBuffer( super.serializarString( string, ancho ) );
		if( str.length() < ancho )
			str.append( iterarCaracter( relleno, ancho-str.length() ) );
			
		return str.toString();
	}

	  /*
	   * rgiorgi - 27-8-2005: se agrega el método
	   * */
	  protected String serializarLong( Long largo, int ancho ) {
		  String str = super.serializarLong( largo, ancho );
		  return recortarADerecha(str, ancho);
	  }

	  /*
	   * rgiorgi - 27-8-2005: se agrega el método
	   * */	  
	  protected String serializarInteger( Integer integer, int ancho ) {
		  String str = super.serializarInteger( integer, ancho );
		  return recortarADerecha( str, ancho );
	  }
	  
	protected String serializarFloat( Float flotante, int ancho, int decimales )
		throws InterfacesException {
		
		if( flotante == null )
			return iterarCaracter( rellenoNumerico, ancho );
			
		String patronDecimal = iterarCaracter( getRellenoNumerico(), decimales );
		if( flotante.doubleValue() < 0 ) ancho--;
		String patronEntera = iterarCaracter( getRellenoNumerico(), ancho-decimales );
		StringBuffer patron = new StringBuffer( patronEntera + PUNTO + patronDecimal );
		patron.append( PUNTO_Y_COMA + patron + SIGNO_NEGATIVO );
	
		return super.serializarNumeroDecimal( new Double( flotante.doubleValue() ), patron );
	}
	
	protected String serializarBigDecimal( BigDecimal bigDecimal, int ancho, int decimales, String coma )
		throws InterfacesException {
	
		if( bigDecimal == null )
			return iterarCaracter( rellenoNumerico, ancho );

		String patronDecimal = iterarCaracter( "0", decimales );
		if( bigDecimal.doubleValue() < 0 ) ancho--;
		String patronEntera = iterarCaracter( "0", ancho-decimales );
		StringBuffer patron = new StringBuffer( patronEntera + PUNTO + patronDecimal );
		patron.append( ";" + SIGNO_NEGATIVO + patron );
	
		return super.serializarNumeroDecimal( new Double( bigDecimal.doubleValue() ), patron );

	}
  
  public static void main( String[] args ) {
	  RegistroAnchoFijo reg = new RegistroAnchoFijo( " ", "0",false );
		
	  try {
		UtilidadesLog.debug( new BigDecimal("0000000100010"));
		UtilidadesLog.debug( reg.serializarBigDecimal( new BigDecimal("0000000100010"),13,2,","));
		System.exit(666);
		reg.addCampo( "codigoPais", Class.forName(STRING), 3, 0, null );
		reg.addCampo( "empresa", Class.forName(STRING), 4, 0, null );
		reg.addCampo( "numeroLote", Class.forName(INTEGER), 5, 0, null );
		reg.addCampo( "consecutivoTransaccion", Class.forName(INTEGER), 10, 0, null );
		reg.addCampo( "numeroFacturaBoleta", Class.forName(INTEGER), 8, 0, null );
		reg.addCampo( "fechaPago", Class.forName(DATE), 8, 0, null );
		reg.addCampo( "valorPago", Class.forName(FLOAT), 15, 2, "." );
		reg.addCampo( "codigoBancoSICC", Class.forName(STRING), 6, 0, null );
		reg.addCampo( "numeroCupon", Class.forName(INTEGER), 8, 0, null );
		reg.addCampo( "codigoConsultora", Class.forName(STRING), 15, 0, null );
		reg.addCampo( "digitoChequeoNumeroFactura", Class.forName(STRING), 2, 0, null );
		reg.addCampo( "oficinaRecaudadora", Class.forName(STRING), 5, 0, null );
		reg.addCampo( "nombreOficina", Class.forName(STRING), 30, 0, null );
		reg.addCampo( "tipoTransaccion", Class.forName(STRING), 5, 0, null );
		reg.addCampo( "numeroDocumento", Class.forName(STRING), 15, 0, null );
		reg.addCampo( "horarioNormalAdicional", Class.forName(STRING), 1, 0, null );
		reg.addCampo( "usuarioProceso", Class.forName(STRING), 10, 0, null );
		reg.addCampo( "fechaProceso", Class.forName(DATE), 8, 0, null );
		reg.addCampo( "horaProceso", Class.forName(STRING), 8, 0, null );
		
		String cadena = "PE SOCP0009500000000010000000020041020000000000005747WIESE 00000000007252390        021                                                               20041021164007  I               0A               ";
		
		IRegistroSicc regSicc = reg.parsear( cadena );
		UtilidadesLog.debug( String.valueOf(regSicc.numeroCampos()) );
		
		
	  } catch( InterfacesException iex ) {
		  UtilidadesLog.debug( iex.getMotivo() );
	  } catch( Exception ex ) {
		  ex.printStackTrace();
	  }
  }
   /*
    * sb retorna la cantidad de caracteres fijos que debe tenre los campos
    * */
    private int sumaLengthCampos(List campos) {
        Iterator it = campos.iterator();
        int suma=0;
        while( it.hasNext() )
        {
          Campo campo = (Campo)it.next();
          suma+=campo.getAncho();
        }
        return suma;
    }
}
