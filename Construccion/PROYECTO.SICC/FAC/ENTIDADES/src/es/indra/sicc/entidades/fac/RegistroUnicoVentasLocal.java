package es.indra.sicc.entidades.fac;
import javax.ejb.EJBLocalObject;
import java.sql.Date;
import java.math.BigDecimal;

public interface RegistroUnicoVentasLocal extends EJBLocalObject  {
	Long getOidNumeroRUV();

	Date getFechaEmision();

	void setFechaEmision(Date newFechaEmision);

	String getNombre1();

	void setNombre1(String newNombre1);

	String getNombre2();

	void setNombre2(String newNombre2);

	String getApellido1();

	void setApellido1(String newApellido1);

	String getApellido2();

	void setApellido2(String newApellido2);

	String getPuntoEmision();

	void setPuntoEmision(String newPuntoEmision);

	String getSerieDocumentoLegal();

	void setSerieDocumentoLegal(String newSerieDocumentoLegal);

	Long getNumeroDocumentoLegal();

	void setNumeroDocumentoLegal(Long newNumeroDocumentoLegal);

	String getEjercicioDocumentoInterno();

	void setEjercicioDocumentoInterno(String newEjercicioDocumentoInterno);

	Long getDocumentoInterno();

	void setDocumentoInterno(Long newDocumentoInterno);

	String getNumeroIdentificacionFiscal();

	void setNumeroIdentificacionFiscal(String newNumeroIdentificacionFiscal);

	String getNumeroIdentificacionNacional();

	void setNumeroIdentificacionNacional(String newNumeroIdentificacionNacional);

	String getSerieDocumentoReferencia();

	void setSerieDocumentoReferencia(String newSerieDocumentoReferencia);

	Long getNumeroDocumentoReferencia();

	void setNumeroDocumentoReferencia(Long newNumeroDocumentoReferencia);

	BigDecimal getBaseImponible();

	void setBaseImponible(BigDecimal newBaseImponible);

	BigDecimal getBaseImponibleNeto();

	void setBaseImponibleNeto(BigDecimal newBaseImponibleNeto);

	BigDecimal getImporteImpuesto();

	void setImporteImpuesto(BigDecimal newImporteImpuesto);

	BigDecimal getImporteTotal();

	void setImporteTotal(BigDecimal newImporteTotal);

	BigDecimal getInteresesMora();

	void setInteresesMora(BigDecimal newInteresesMora);

	BigDecimal getDescuento();

	void setDescuento(BigDecimal newDescuento);

	BigDecimal getComisiones();

	void setComisiones(BigDecimal newComisiones);

	BigDecimal getFlete();

	void setFlete(BigDecimal newFlete);

	Boolean getFacturaGratuita();

	void setFacturaGratuita(Boolean newFacturaGratuita);

	Boolean getTransferenciaGratuita();

	void setTransferenciaGratuita(Boolean newTransferenciaGratuita);

	Date getFechaCierre();

	void setFechaCierre(Date newFechaCierre);

	Boolean getEstado();

	void setEstado(Boolean newEstado);

	String getEstadoRUV();

	void setEstadoRUV(String newEstadoRUV);

	Long getCliente();

	void setCliente(Long newCliente);

	Long getTipoDocumentoReferencia();

	void setTipoDocumentoReferencia(Long newTipoDocumentoReferencia);

	Long getSubacceso();

	void setSubacceso(Long newSubacceso);

	Long getSociedadVenta();

	void setSociedadVenta(Long newSociedadVenta);

	Long getPais();

	void setPais(Long newPais);

	Long getCabDocContable();

	void setCabDocContable(Long newCabDocContable);

	Long getImpuesto();

	void setImpuesto(Long newImpuesto);

	Long getTipoDocumentoLegal();

	void setTipoDocumentoLegal(Long newTipoDocumentoLegal);

	String getDocumentoInternoHipersale();

	void setDocumentoInternoHipersale(String newDocumentoInternoHipersale);

	public String getFechaEmisionDocumento();

	public void setFechaEmisionDocumento(String fechaEmisionDocumento);

	public Long getOidTipoDocumentoIdentidad();
        
	public void setOidTipoDocumentoIdentidad(Long oidTipoDocumentoIdentidad);
        
	public String getValNombreCliente();
        
        public void setValNombreCliente(String valNombreCliente);
}