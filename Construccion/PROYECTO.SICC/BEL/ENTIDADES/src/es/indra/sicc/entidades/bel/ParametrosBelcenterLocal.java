package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="BEL_PARAM_BELCE")
@NamedQueries({
@NamedQuery(name="ParametrosBelcenterLocal.FindByUK",query="SELECT OBJECT(a) FROM ParametrosBelcenterLocal AS a WHERE a.pais=?1 AND a.subacceso=?2")
})
public class ParametrosBelcenterLocal implements Serializable {

	public ParametrosBelcenterLocal() {}

	public ParametrosBelcenterLocal(Long oid, Long subacceso, String direccion, 
                    BigDecimal montoMaximoDiferencia, BigDecimal limiteEfectivoCaja, 
                    Integer numeroDeCajas, String nombreDeLocal, Integer tiempoDeReposicion, 
                    Float factorLocal, Integer numeroMaximoProductos, BigDecimal alertaStock, 
                    String usuario, Long cliente, Long empresa, Long tipoTransaccion, 
                    Long cuentaCorriente, Long tipoMovimientoCobrar, Long tipoMovimientoCierre, 
                    Long movimientoConfirmarStock, Long movimientoConfirmarStockEnTransito, 
                    Long movimientoStockEnTransito, Long movimientoStockDevolucion, 
                    Long movimientoRegularizacion, Long movimientoRegularizacionSAP, 
                    Long movimientoDevolverStockExistencias, Long movimientoPeticionExistencias, 
                    Long pais)	{
		this.oid=oid;
                this.subacceso = subacceso;
                this.direccion = direccion;
                this.montoMaximoDiferencia = montoMaximoDiferencia;
                this.limiteEfectivoCaja = limiteEfectivoCaja;
                this.numeroDeCajas = numeroDeCajas;
                this.nombreDeLocal = nombreDeLocal;
                this.tiempoDeReposicion = tiempoDeReposicion;
                this.factorLocal = factorLocal;
                this.numeroMaximoProductos = numeroMaximoProductos;
                this.alertaStock = alertaStock;
                this.usuario = usuario;
                this.cliente = cliente;
                this.empresa = empresa;
                this.tipoTransaccion = tipoTransaccion;
                this.cuentaCorriente = cuentaCorriente;
                this.tipoMovimientoCobrar = tipoMovimientoCobrar;
                this.tipoMovimientoCierre = tipoMovimientoCierre;
                this.movimientoConfirmarStock = movimientoConfirmarStock;
                this.movimientoConfirmarStockEnTransito = movimientoConfirmarStockEnTransito;
                this.movimientoStockEnTransito = movimientoStockEnTransito;
                this.movimientoStockDevolucion = movimientoStockDevolucion;
                this.movimientoRegularizacion = movimientoRegularizacion;
                this.movimientoRegularizacionSAP = movimientoRegularizacionSAP;
                this.movimientoDevolverStockExistencias = movimientoDevolverStockExistencias;
                this.movimientoPeticionExistencias = movimientoPeticionExistencias;
                this.pais = pais;
	}

	@Id
	@Column(name="OID_PARA")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="VAL_DIRE")
	private String direccion;
	@Column(name="VAL_TFNO")
	private String telefono;
	@Column(name="VAL_MONT_MAXI_DIFE")
	private java.math.BigDecimal montoMaximoDiferencia;
	@Column(name="VAL_LIMI_EFEC_CAJA")
	private java.math.BigDecimal limiteEfectivoCaja;
	@Column(name="NUM_CAJA")
	private Integer numeroDeCajas;
	@Column(name="VAL_NOMB_LOCA")
	private String nombreDeLocal;
	@Column(name="VAL_TIEMP_REPO")
	private Integer tiempoDeReposicion;
	@Column(name="VAL_FACT_LOCA")
	private Float factorLocal;
	@Column(name="NUM_MAXI_PROD")
	private Integer numeroMaximoProductos;
	@Column(name="VAL_ALER_STOC")
	private java.math.BigDecimal alertaStock;
	@Column(name="VAL_USUA")
	private String usuario;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="TTRA_OID_TIPO_TRAN")
	private Long tipoTransaccion;
	@Column(name="CCBA_OID_CUEN_CORR_BANC")
	private Long cuentaCorriente;
	@Column(name="TMVC_OID_COBR")
	private Long tipoMovimientoCobrar;
	@Column(name="TMVC_OID_CIER")
	private Long tipoMovimientoCierre;
	@Column(name="TMAL_OID_CONF_STOC")
	private Long movimientoConfirmarStock;
	@Column(name="TMAL_OID_CONF_STOC_TRAN")
	private Long movimientoConfirmarStockEnTransito;
	@Column(name="TMAL_OID_STOC_TRAN")
	private Long movimientoStockEnTransito;
	@Column(name="TMAL_OID_STOC_DEVO")
	private Long movimientoStockDevolucion;
	@Column(name="TMAL_OID_REGU")
	private Long movimientoRegularizacion;
	@Column(name="TMAL_OID_REGU_SAP")
	private Long movimientoRegularizacionSAP;
	@Column(name="TMAL_OID_DEVO_STOC")
	private Long movimientoDevolverStockExistencias;
	@Column(name="TMAL_OID_PETI_EXIS")
	private Long movimientoPeticionExistencias;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public String getDireccion() {return direccion;}
      
	public void setDireccion(String direccion){this.direccion=direccion;}
		
	public String getTelefono() {return telefono;}
      
	public void setTelefono(String telefono){this.telefono=telefono;}
		
	public java.math.BigDecimal getMontoMaximoDiferencia() {return montoMaximoDiferencia;}
      
	public void setMontoMaximoDiferencia(java.math.BigDecimal montoMaximoDiferencia){this.montoMaximoDiferencia=montoMaximoDiferencia;}
		
	public java.math.BigDecimal getLimiteEfectivoCaja() {return limiteEfectivoCaja;}
      
	public void setLimiteEfectivoCaja(java.math.BigDecimal limiteEfectivoCaja){this.limiteEfectivoCaja=limiteEfectivoCaja;}
		
	public Integer getNumeroDeCajas() {return numeroDeCajas;}
      
	public void setNumeroDeCajas(Integer numeroDeCajas){this.numeroDeCajas=numeroDeCajas;}
		
	public String getNombreDeLocal() {return nombreDeLocal;}
      
	public void setNombreDeLocal(String nombreDeLocal){this.nombreDeLocal=nombreDeLocal;}
		
	public Integer getTiempoDeReposicion() {return tiempoDeReposicion;}
      
	public void setTiempoDeReposicion(Integer tiempoDeReposicion){this.tiempoDeReposicion=tiempoDeReposicion;}
		
	public Float getFactorLocal() {return factorLocal;}
      
	public void setFactorLocal(Float factorLocal){this.factorLocal=factorLocal;}
		
	public Integer getNumeroMaximoProductos() {return numeroMaximoProductos;}
      
	public void setNumeroMaximoProductos(Integer numeroMaximoProductos){this.numeroMaximoProductos=numeroMaximoProductos;}
		
	public java.math.BigDecimal getAlertaStock() {return alertaStock;}
      
	public void setAlertaStock(java.math.BigDecimal alertaStock){this.alertaStock=alertaStock;}
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getTipoTransaccion() {return tipoTransaccion;}
      
	public void setTipoTransaccion(Long tipoTransaccion){this.tipoTransaccion=tipoTransaccion;}
		
	public Long getCuentaCorriente() {return cuentaCorriente;}
      
	public void setCuentaCorriente(Long cuentaCorriente){this.cuentaCorriente=cuentaCorriente;}
		
	public Long getTipoMovimientoCobrar() {return tipoMovimientoCobrar;}
      
	public void setTipoMovimientoCobrar(Long tipoMovimientoCobrar){this.tipoMovimientoCobrar=tipoMovimientoCobrar;}
		
	public Long getTipoMovimientoCierre() {return tipoMovimientoCierre;}
      
	public void setTipoMovimientoCierre(Long tipoMovimientoCierre){this.tipoMovimientoCierre=tipoMovimientoCierre;}
		
	public Long getMovimientoConfirmarStock() {return movimientoConfirmarStock;}
      
	public void setMovimientoConfirmarStock(Long movimientoConfirmarStock){this.movimientoConfirmarStock=movimientoConfirmarStock;}
		
	public Long getMovimientoConfirmarStockEnTransito() {return movimientoConfirmarStockEnTransito;}
      
	public void setMovimientoConfirmarStockEnTransito(Long movimientoConfirmarStockEnTransito){this.movimientoConfirmarStockEnTransito=movimientoConfirmarStockEnTransito;}
		
	public Long getMovimientoStockEnTransito() {return movimientoStockEnTransito;}
      
	public void setMovimientoStockEnTransito(Long movimientoStockEnTransito){this.movimientoStockEnTransito=movimientoStockEnTransito;}
		
	public Long getMovimientoStockDevolucion() {return movimientoStockDevolucion;}
      
	public void setMovimientoStockDevolucion(Long movimientoStockDevolucion){this.movimientoStockDevolucion=movimientoStockDevolucion;}
		
	public Long getMovimientoRegularizacion() {return movimientoRegularizacion;}
      
	public void setMovimientoRegularizacion(Long movimientoRegularizacion){this.movimientoRegularizacion=movimientoRegularizacion;}
		
	public Long getMovimientoRegularizacionSAP() {return movimientoRegularizacionSAP;}
      
	public void setMovimientoRegularizacionSAP(Long movimientoRegularizacionSAP){this.movimientoRegularizacionSAP=movimientoRegularizacionSAP;}
		
	public Long getMovimientoDevolverStockExistencias() {return movimientoDevolverStockExistencias;}
      
	public void setMovimientoDevolverStockExistencias(Long movimientoDevolverStockExistencias){this.movimientoDevolverStockExistencias=movimientoDevolverStockExistencias;}
		
	public Long getMovimientoPeticionExistencias() {return movimientoPeticionExistencias;}
      
	public void setMovimientoPeticionExistencias(Long movimientoPeticionExistencias){this.movimientoPeticionExistencias=movimientoPeticionExistencias;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
