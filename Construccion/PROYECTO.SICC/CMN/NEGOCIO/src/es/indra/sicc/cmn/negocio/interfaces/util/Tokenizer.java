package es.indra.sicc.cmn.negocio.interfaces.util;

import java.util.ArrayList;
import es.indra.sicc.util.UtilidadesLog;

public class Tokenizer {
 
	private String string;
	private String delim;
 
	private int currPos = 0;
	private int maxPos;
 
	private String[] tokens;
 

	public Tokenizer( String str, String delim ) {
		this.string = str;
		this.delim = delim;
		if ( str != null ) {
			maxPos = str.length();
			tokenize();
		}
	}
 

	public boolean hasMoreTokens() {
		return ( tokens != null && tokens.length > currPos );
	}
	
	public String nextToken() {
		String str = tokens[currPos];
		currPos++;
		return str;
	}
	
	private void tokenize() {
		int curr = 0;
		int max = maxPos;
		int next = 0;
		ArrayList list = new ArrayList();
		String token = "";
		while ( next >= 0 ) {
			next = string.indexOf( delim, curr );
			if ( next == curr ) { // el primer carácter es un delimitador
				token = "";
				curr = curr+1;
			} else if( next > curr ) {
				token = string.substring( curr, next );
				curr = next+1;
			} else if ( next < 0 ) { // delimitador no encontrado
				token = string.substring( curr, max );
			}
			
			list.add( token ); 
		}	
		tokens = new String[list.size()];
		for ( int i=0; i<list.size(); i++ ) {
			tokens[i] = (String)list.get(i);		
		}
	}
	
	public int countTokens() {
		int size = 0;
		if ( tokens != null ) {
			size = tokens.length;
		}
		return size;
	}
 

	public static void main( String[] args ) {
		String str2 = "PE;220000908;EQUIPO SONIDO H.T CV 17062000;P;99;050;0502;"+
		";;;;;;000000;000000;000000;;000000;000000;05;0000000000.00;;KG; ";
		Tokenizer stok2 = new Tokenizer( str2, ";" );
 
		UtilidadesLog.debug( "Tokens en str2 = " + String.valueOf(stok2.countTokens()) );
		
		//while ( stok2.hasMoreTokens() ) {
		//	UtilidadesLog.debug( "*" + stok2.nextToken() + "*" );
		//}	
	}
}
