package es.indra.sicc.dtos.men;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOEntradaSeleccionarFuncionesFavoritas extends DTOAuditableSICC 
{
	private String IdUsuario;
	private Vector IdFuncionMarcadas;
	private Vector IdFuncionesDesmarcadas;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

	public DTOEntradaSeleccionarFuncionesFavoritas()
	{
	}

	public String getIdUsuario()
	{
		return IdUsuario;
	}

	public void setIdUsuario(String newIdUsuario)
	{
		IdUsuario = newIdUsuario;
	}

	public Vector getIdFuncionMarcadas()
	{
		return IdFuncionMarcadas;
	}

	public void setIdFuncionMarcadas(Vector newIdFuncionMarcadas)
	{
		IdFuncionMarcadas = newIdFuncionMarcadas;
	}

	public Vector getIdFuncionesDesmarcadas()
	{
		return IdFuncionesDesmarcadas;
	}

	public void setIdFuncionesDesmarcadas(Vector newIdFuncionesDesmarcadas)
	{
		IdFuncionesDesmarcadas = newIdFuncionesDesmarcadas;
	}
}