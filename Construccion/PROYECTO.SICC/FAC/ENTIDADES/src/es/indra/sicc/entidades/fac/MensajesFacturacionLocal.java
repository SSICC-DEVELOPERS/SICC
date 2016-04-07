package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_MENSA_FACTU")
public class MensajesFacturacionLocal implements Serializable {

	public MensajesFacturacionLocal() {}

	public MensajesFacturacionLocal(Long oid, Long cliente, Long numeroSecuencial, Timestamp fecha, String datoVariable1, String datoVariable2, String datoVariable3, String datoVariable4, String datoVariable5, String datoVariable6, String datoVariable7, String datoVariable8, Long periodo, Long modulo, Boolean listaConsultoras, Boolean permanenciaMensaje, Boolean borrado, String codMensaje, Long cabecera, Long buzonMensaje)	{
            this.oid=oid;
	    this.cliente = cliente;                               
	    this.numeroSecuencial = numeroSecuencial;
	    this.fecha = fecha;                                  
	    this.datoVariable1 = datoVariable1;                 
	    this.datoVariable2 = datoVariable2;                 
	    this.datoVariable3 = datoVariable3;                 
	    this.datoVariable4 = datoVariable4;                 
	    this.datoVariable5 = datoVariable5;                 
	    this.datoVariable6 = datoVariable6;                 
	    this.datoVariable7 = datoVariable7;                 
	    this.datoVariable8 = datoVariable8;                 
	    this.periodo = periodo;                               
	    this.modulo = modulo;                                 
	    this.listaConsultoras = listaConsultoras;                       
	    this.permanenciaMensaje = permanenciaMensaje;      
	    this.borrado = borrado;   
	    this.codMensaje = codMensaje;
	    this.cabecera = cabecera;
	    this.buzonMensaje = buzonMensaje;
	}

        public MensajesFacturacionLocal(Long oid, Long cliente, Long numeroSecuencial, Timestamp fecha, String datoVariable1, Long modulo, Boolean listaConsultoras, Boolean borrado, String codMensaje, Long cabecera, Long buzonMensaje)       {
            this.oid=oid;
            this.cliente = cliente;                               
            this.numeroSecuencial = numeroSecuencial;
            this.fecha = fecha;                                  
            this.datoVariable1 = datoVariable1;                 
            this.modulo = modulo;                                 
            this.listaConsultoras = listaConsultoras;                       
            this.borrado = borrado;   
            this.codMensaje = codMensaje;
            this.cabecera = cabecera;
            this.buzonMensaje = buzonMensaje;        
        }

	@Id
	@Column(name="OID_MENS_FACT")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="VAL_NUME_SECU")
	private Long numeroSecuencial;
	@Column(name="FEC_MENS_FACT")
	private java.sql.Timestamp fecha;
	@Column(name="VAL_DATO_VAR1")
	private String datoVariable1;
	@Column(name="VAL_DATO_VAR2")
	private String datoVariable2;
	@Column(name="VAL_DATO_VAR3")
	private String datoVariable3;
	@Column(name="VAL_DATO_VAR4")
	private String datoVariable4;
	@Column(name="VAL_DATO_VAR5")
	private String datoVariable5;
	@Column(name="VAL_DATO_VAR6")
	private String datoVariable6;
	@Column(name="VAL_DATO_VAR7")
	private String datoVariable7;
	@Column(name="VAL_DATO_VAR8")
	private String datoVariable8;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="MODU_OID_MODU")
	private Long modulo;
	@Column(name="IND_LIST_CONS")
	private Boolean listaConsultoras;
	@Column(name="IND_PERM_MENS")
	private Boolean permanenciaMensaje;
	@Column(name="IND_BORR")
	private Boolean borrado;
	@Column(name="DCCA_OID_CABE")
	private Long cabecera;
	@Column(name="COD_MENS")
	private String codMensaje;
	@Column(name="VAL_BUZO_MENS")
	private Long buzonMensaje;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getNumeroSecuencial() {return numeroSecuencial;}
      
	public void setNumeroSecuencial(Long numeroSecuencial){this.numeroSecuencial=numeroSecuencial;}
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public String getDatoVariable1() {return datoVariable1;}
      
	public void setDatoVariable1(String datoVariable1){this.datoVariable1=datoVariable1;}
		
	public String getDatoVariable2() {return datoVariable2;}
      
	public void setDatoVariable2(String datoVariable2){this.datoVariable2=datoVariable2;}
		
	public String getDatoVariable3() {return datoVariable3;}
      
	public void setDatoVariable3(String datoVariable3){this.datoVariable3=datoVariable3;}
		
	public String getDatoVariable4() {return datoVariable4;}
      
	public void setDatoVariable4(String datoVariable4){this.datoVariable4=datoVariable4;}
		
	public String getDatoVariable5() {return datoVariable5;}
      
	public void setDatoVariable5(String datoVariable5){this.datoVariable5=datoVariable5;}
		
	public String getDatoVariable6() {return datoVariable6;}
      
	public void setDatoVariable6(String datoVariable6){this.datoVariable6=datoVariable6;}
		
	public String getDatoVariable7() {return datoVariable7;}
      
	public void setDatoVariable7(String datoVariable7){this.datoVariable7=datoVariable7;}
		
	public String getDatoVariable8() {return datoVariable8;}
      
	public void setDatoVariable8(String datoVariable8){this.datoVariable8=datoVariable8;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getModulo() {return modulo;}
      
	public void setModulo(Long modulo){this.modulo=modulo;}
		
	public Boolean getListaConsultoras() {return listaConsultoras;}
      
	public void setListaConsultoras(Boolean listaConsultoras){this.listaConsultoras=listaConsultoras;}
		
	public Boolean getPermanenciaMensaje() {return permanenciaMensaje;}
      
	public void setPermanenciaMensaje(Boolean permanenciaMensaje){this.permanenciaMensaje=permanenciaMensaje;}
		
	public Boolean getBorrado() {return borrado;}
      
	public void setBorrado(Boolean borrado){this.borrado=borrado;}
		
	public Long getCabecera() {return cabecera;}
      
	public void setCabecera(Long cabecera){this.cabecera=cabecera;}
		
	public String getCodMensaje() {return codMensaje;}
      
	public void setCodMensaje(String codMensaje){this.codMensaje=codMensaje;}
		
	public Long getBuzonMensaje() {return buzonMensaje;}
      
	public void setBuzonMensaje(Long buzonMensaje){this.buzonMensaje=buzonMensaje;}
			
	
}
