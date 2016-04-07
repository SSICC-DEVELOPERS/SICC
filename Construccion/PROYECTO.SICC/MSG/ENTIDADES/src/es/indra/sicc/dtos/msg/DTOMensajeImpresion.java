package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;
import java.util.Vector;

public class DTOMensajeImpresion extends DTOAuditableSICC {

	private Long oidMensaje;
	private String texto;
	private Long oidTipoPermanencia;
	private Date fechaPermanenciaDesde;
	private Date fechaPermanenciaHasta;
	private Long oidTipoMensaje;
	private String codigoPeriodoInicial;
	private String codigoPeriodoDesde;
	private String codigoPeriodoHasta;	
	private Vector buzon;	
	private Vector destinatario;
  private Long oidPeriodo;
    private Long contadorUnidadAdministrativa;
  private Boolean exclusionTipologia;

	public DTOMensajeImpresion() {
	}


	public void setOidMensaje(Long newOidMensaje) {
        oidMensaje = newOidMensaje;
    }

    public Long getOidMensaje() {
        return oidMensaje;
    }

	public void setTexto(String newTexto) {
        texto = newTexto;
    }

    public String getTexto() {
        return texto;
    }

	public void setOidTipoPermanencia(Long newOidTipoPermanencia) {
        oidTipoPermanencia = newOidTipoPermanencia;
    }

    public Long getOidTipoPermanencia() {
        return oidTipoPermanencia;
    }

	public void setFechaPermanenciaDesde(Date newFechaPermanenciaDesde) {
        fechaPermanenciaDesde = newFechaPermanenciaDesde;
    }

    public Date getFechaPermanenciaDesde() {
        return fechaPermanenciaDesde;
    }

	public void setFechaPermanenciaHasta(Date newFechaPermanenciaHasta) {
        fechaPermanenciaHasta = newFechaPermanenciaHasta;
    }

    public Date getFechaPermanenciaHasta() {
        return fechaPermanenciaHasta;
    }

	public void setOidTipoMensaje(Long newOidTipoMensaje) {
        oidTipoMensaje = newOidTipoMensaje;
    }

    public Long getOidTipoMensaje() {
        return oidTipoMensaje;
    }   

	public void setCodigoPeriodoInicial(String newCodigoPeriodoInicial) {
        codigoPeriodoInicial = newCodigoPeriodoInicial;
    }

    public String getCodigoPeriodoInicial() {
        return codigoPeriodoInicial;
    }

	public void setCodigoPeriodoDesde(String newCodigoPeriodoDesde) {
        codigoPeriodoDesde = newCodigoPeriodoDesde;
    }

    public String getCodigoPeriodoDesde() {
        return codigoPeriodoDesde;
    }

	public void setCodigoPeriodoHasta(String newCodigoPeriodoHasta) {
        codigoPeriodoHasta = newCodigoPeriodoHasta;
    }

    public String getCodigoPeriodoHasta() {
        return codigoPeriodoHasta;
    }

	public void setBuzon(Vector newBuzon) {
        buzon = newBuzon;
    }

    public Vector getBuzon() {
        return buzon;
    }

	public void setDestinatario(Vector newDestinatario) {
        destinatario = newDestinatario;
    }

    public Vector getDestinatario() {
        return destinatario;
    }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

    public Long getContadorUnidadAdministrativa()
    {
        return contadorUnidadAdministrativa;
    }

    public void setContadorUnidadAdministrativa(Long contadorUnidadAdministrativa)
    {
        this.contadorUnidadAdministrativa = contadorUnidadAdministrativa;
    }

  public Boolean getExclusionTipologia()
  {
    return exclusionTipologia;
  }

  public void setExclusionTipologia(Boolean exclusionTipologia)
  {
    this.exclusionTipologia = exclusionTipologia;
  }
	
}