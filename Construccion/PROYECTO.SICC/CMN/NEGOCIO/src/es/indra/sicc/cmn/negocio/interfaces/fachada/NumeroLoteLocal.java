package es.indra.sicc.cmn.negocio.interfaces.fachada;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import es.indra.sicc.cmn.negocio.interfaces.fachada.NumeroLoteLocalHome;

import java.io.Serializable;

import java.util.Calendar;

@Entity
@Table(name="CMN_NUMER_LOTE")
@NamedQueries({
@NamedQuery(name="NumeroLoteLocal.FindAll",query="select object(o) from NumeroLoteLocal o")
})
public class NumeroLoteLocal implements Serializable {

        public NumeroLoteLocal() { }

	public NumeroLoteLocal(String id)	{
		this.id = id;
		this.cadenaFecha = obtenerCadenaFecha();
		this.contador = 0;
	}

	@Id
	@Column(name="OID_NUME_LOTE")
	private String id;
	@Column(name="NUM_CONT")
	private int contador;
	@Column(name="VAL_CADE_FECH")
	private String cadenaFecha;

	
	public String getId() {return id;}
      
	public String getPrimaryKey() {return id;}		
		
	public int getContador() {return contador;}
      
	public void setContador(int contador){this.contador=contador;}
		
	public String getCadenaFecha() {return cadenaFecha;}
      
	public void setCadenaFecha(String cadenaFecha){this.cadenaFecha=cadenaFecha;}
	
	public String obtenerNumeroLote() {
	
		String cadenaFecha = obtenerCadenaFecha();
		if( !cadenaFecha.equals( getCadenaFecha() ) ) {
		    System.out.println(" actualizo contador y fecha");
			setCadenaFecha( cadenaFecha );
			setContador(0);
		}

		String numeroLote = cadenaFecha + formatearContador();
                System.out.println(" getContador() antes: " + getContador());
		setContador( getContador() + 1 );
                System.out.println(" getContador() despues: " + getContador());
                
                NumeroLoteLocalHome mumeroLoteLocalHome = new NumeroLoteLocalHome();
	        mumeroLoteLocalHome.merge(this);

		return numeroLote;
	}

	
	private String obtenerCadenaFecha() {
		Calendar calendar = Calendar.getInstance();
		String anyo = new Integer( calendar.get(Calendar.YEAR) ).toString();
		String mes = new Integer( calendar.get(Calendar.MONTH) + 1 ).toString();
		String dia = new Integer( calendar.get(Calendar.DATE) ).toString();
		if( mes.length() == 1 )
			mes = "0" + mes;
		if( dia.length() == 1 )
			dia = "0" + dia;

		return anyo + mes + dia;
	}

	private String formatearContador() {
		String contador = new Integer(this.getContador()).toString();
		int numCeros = 4 - contador.length();
		for( int i = 0; i < numCeros; i++ )
			contador = "0" + contador;
		return contador;
	}
	
}
