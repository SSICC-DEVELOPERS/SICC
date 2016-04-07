package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

import java.io.Serializable;

@Entity
@Table(name="COB_USUAR_COBRA")
@NamedQueries({
@NamedQuery(name="UsuariosCobranzasLocal.FindAll",query="select object(o) from UsuariosCobranzasLocal o"),
@NamedQuery(name="UsuariosCobranzasLocal.FindByIndUsuarioSupervisor",query="SELECT OBJECT(a) "
+ "  FROM UsuariosCobranzasLocal AS a "
+ "  WHERE a.indUsuaSupe = ?1"),
@NamedQuery(name="UsuariosCobranzasLocal.FindByUK",query="select object (e) from UsuariosCobranzasLocal as e where e.paisOidPais = ?1 and e.userOidUsuaCobr = ?2")
})
public class UsuariosCobranzasLocal implements Serializable {

	public UsuariosCobranzasLocal() {}

	public UsuariosCobranzasLocal(Long oid, Date fechaUltimoEstado,
                        Boolean indJefeCobranza,
                        Boolean indUsuarioSupervisor,
                        Boolean indUsuarioExterno,
                        String turnoHorarioEntrada,
                        String turnoHorarioSalida,
                        String observaciones,
                        Long paisOidPais, 
                        Long esusOidEstaUsua,
                        Long userOidUsuaSupe,
                        Long userOidUsuaCobr,                                
                        Long userOidUsuaResp)	{
	
		this.oid=oid;
                this.setFecUltiEsta(fechaUltimoEstado);       // Fecha en la que se realizo el ultimo cambio de estado       
	        this.setIndJefeCobr(indJefeCobranza);         // Si el usuario es Jefe de Cobranzas o no. Posibles Valores:Si / No 
	        this.setIndUsuaSupe(indUsuarioSupervisor);    // Si el usuario es Supervisor Especial o no. Posibles Valores:Si / No
	        this.setIndUsuaExte(indUsuarioExterno);       // Si el usuario es externo o no. Posibles Valores:Si / No
	        this.setValTurnHoraEntr(turnoHorarioEntrada); // Inicio de turno de ese usuario a nivel informativo.
	        this.setValTurnHoraSali(turnoHorarioSalida);  // Salida de turno de ese usuario a nivel informativo.
	        this.setValObse(observaciones);               // Observaciones al respecto del usuario de usuarios.
	        this.setEsusOidEstaUsua(esusOidEstaUsua);
	        this.setPaisOidPais(paisOidPais); 
	        this.setUserOidUsuaSupe(userOidUsuaSupe);
	        this.setUserOidUsuaCobr(userOidUsuaCobr);
	        this.setUserOidUsuaResp(userOidUsuaResp);     
	
	}

	@Id
	@Column(name="OID_USUA_COBR")
	private Long oid;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Date fecUltiEsta;
	@Column(name="IND_JEFE_COBR")
	private Boolean indJefeCobr;
	@Column(name="IND_USUA_SUPE")
	private Boolean indUsuaSupe;
	@Column(name="IND_USUA_EXTE")
	private Boolean indUsuaExte;
	@Column(name="VAL_TURN_HORA_ENTR")
	private String valTurnHoraEntr;
	@Column(name="VAL_TURN_HORA_SALI")
	private String valTurnHoraSali;
	@Column(name="VAL_OBSE")
	private String valObse;
	@Column(name="PAIS_OID_PAIS")
	private Long paisOidPais;
	@Column(name="ESUS_OID_ESTA_USUA")
	private Long esusOidEstaUsua;
	@Column(name="USER_OID_USUA_SUPE")
	private Long userOidUsuaSupe;
	@Column(name="USER_OID_USUA_COBR")
	private Long userOidUsuaCobr;
	@Column(name="USER_OID_USUA_RESP")
	private Long userOidUsuaResp;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFecUltiEsta() {return fecUltiEsta;}
      
	public void setFecUltiEsta(java.sql.Date fecUltiEsta){this.fecUltiEsta=fecUltiEsta;}
		
	public Boolean getIndJefeCobr() {return indJefeCobr;}
      
	public void setIndJefeCobr(Boolean indJefeCobr){this.indJefeCobr=indJefeCobr;}
		
	public Boolean getIndUsuaSupe() {return indUsuaSupe;}
      
	public void setIndUsuaSupe(Boolean indUsuaSupe){this.indUsuaSupe=indUsuaSupe;}
		
	public Boolean getIndUsuaExte() {return indUsuaExte;}
      
	public void setIndUsuaExte(Boolean indUsuaExte){this.indUsuaExte=indUsuaExte;}
		
	public String getValTurnHoraEntr() {return valTurnHoraEntr;}
      
	public void setValTurnHoraEntr(String valTurnHoraEntr){this.valTurnHoraEntr=valTurnHoraEntr;}
		
	public String getValTurnHoraSali() {return valTurnHoraSali;}
      
	public void setValTurnHoraSali(String valTurnHoraSali){this.valTurnHoraSali=valTurnHoraSali;}
		
	public String getValObse() {return valObse;}
      
	public void setValObse(String valObse){this.valObse=valObse;}
		
	public Long getPaisOidPais() {return paisOidPais;}
      
	public void setPaisOidPais(Long paisOidPais){this.paisOidPais=paisOidPais;}
		
	public Long getEsusOidEstaUsua() {return esusOidEstaUsua;}
      
	public void setEsusOidEstaUsua(Long esusOidEstaUsua){this.esusOidEstaUsua=esusOidEstaUsua;}
		
	public Long getUserOidUsuaSupe() {return userOidUsuaSupe;}
      
	public void setUserOidUsuaSupe(Long userOidUsuaSupe){this.userOidUsuaSupe=userOidUsuaSupe;}
		
	public Long getUserOidUsuaCobr() {return userOidUsuaCobr;}
      
	public void setUserOidUsuaCobr(Long userOidUsuaCobr){this.userOidUsuaCobr=userOidUsuaCobr;}
		
	public Long getUserOidUsuaResp() {return userOidUsuaResp;}
      
	public void setUserOidUsuaResp(Long userOidUsuaResp){this.userOidUsuaResp=userOidUsuaResp;}
			
	
}
