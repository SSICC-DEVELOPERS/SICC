package es.indra.sicc.dtos.ccc;


import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
public class DTOGenerarRegistrosCargosYAbonos extends DTOBelcorp {

private ArrayList movCCSaldados;
private ArrayList movBancAplicados;
private Long tipoAbonoTES;
private Long tipoAbonoCCC;
private Long oidSubprocesoCCC;
private Long cuentaContable;
private Long[] marcasSalida;
private Long tipoCargoAbonoTES;
private Long tipoCargoAbonoCCC;
//Gacevedo. Se agrega el atributo
//en respuesta a la incidencia V-CCC-008. 13/11/2006
private Boolean indicadorActualizaCuotaConImportePagado;

	public DTOGenerarRegistrosCargosYAbonos() {
	}

	public Long getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(Long newCuentaContable) {
		cuentaContable = newCuentaContable;
	}

	public Long[] getMarcasSalida() {
		return marcasSalida;
	}

	public void setMarcasSalida(Long[] newMarcasSalida) {
		marcasSalida = newMarcasSalida;
	}

	public ArrayList getMovBancAplicados() {
		return movBancAplicados;
	}

	public void setMovBancAplicados(ArrayList newMovBancAplicados) {
		movBancAplicados = newMovBancAplicados;
	}

	public ArrayList getMovCCSaldados() {
		return movCCSaldados;
	}

	public void setMovCCSaldados(ArrayList newMovCCSaldados) {
		movCCSaldados = newMovCCSaldados;
	}

	public Long getOidSubprocesoCCC() {
		return oidSubprocesoCCC;
	}

	public void setOidSubprocesoCCC(Long newOidSubprocesoCCC) {
		oidSubprocesoCCC = newOidSubprocesoCCC;
	}

	public Long getTipoAbonoCCC() {
		return tipoAbonoCCC;
	}

	public void setTipoAbonoCCC(Long newTipoAbonoCCC) {
		tipoAbonoCCC = newTipoAbonoCCC;
	}

	public Long getTipoAbonoTES() {
		return tipoAbonoTES;
	}

	public void setTipoAbonoTES(Long newTipoAbonoTES) {
		tipoAbonoTES = newTipoAbonoTES;
	}
    
	public Long getTipoCargoAbonoTES() {
		return tipoCargoAbonoTES;
	}

	public void setTipoCargoAbonoTES(Long newTipoCargoAbonoTES) {
		tipoCargoAbonoTES = newTipoCargoAbonoTES;
	}
    
	public Long getTipoCargoAbonoCCC() {
		return tipoCargoAbonoCCC;
	}

	public void setTipoCargoAbonoCCC(Long newTipoCargoAbonoCCC) {
		tipoCargoAbonoCCC = newTipoCargoAbonoCCC;
	}


   public void setIndicadorActualizaCuotaConImportePagado(Boolean indicadorActualizaCuotaConImportePagado) {
      this.indicadorActualizaCuotaConImportePagado = indicadorActualizaCuotaConImportePagado;
   }


   public Boolean getIndicadorActualizaCuotaConImportePagado() {
      return indicadorActualizaCuotaConImportePagado;
   }

}