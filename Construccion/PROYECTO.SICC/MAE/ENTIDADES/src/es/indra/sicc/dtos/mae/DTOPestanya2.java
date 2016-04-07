package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPestanya2 extends DTOAuditableSICC  {

        private DTOPestanya2Base base;
        private RecordSet nacionalidad;
        private RecordSet estadoCivil;
        private RecordSet nivelEstudios;
        private RecordSet NSEP;
        private RecordSet ciclosVida;
        private RecordSet paises;
        private RecordSet tiposPreferencias;
        private RecordSet marcas;
        private RecordSet tiposVinculo;
    		private RecordSet longitudesCodigoClientePais;
        private RecordSet tipoCliente;
        private RecordSet canales;

    public RecordSet getNSEP() {
        return NSEP;
    }

    public void setNSEP(RecordSet newNSEP) {
        NSEP = newNSEP;
    }

    public DTOPestanya2Base getBase() {
        return base;
    }

    public void setBase(DTOPestanya2Base newBase) {
        base = newBase;
    }

    public RecordSet getCiclosVida() {
        return ciclosVida;
    }

    public void setCiclosVida(RecordSet newCiclosVida) {
        ciclosVida = newCiclosVida;
    }

    public RecordSet getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(RecordSet newEstadoCivil) {
        estadoCivil = newEstadoCivil;
    }

    public RecordSet getMarcas() {
        return marcas;
    }

    public void setMarcas(RecordSet newMarcas) {
        marcas = newMarcas;
    }

    public RecordSet getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(RecordSet newNacionalidad) {
        nacionalidad = newNacionalidad;
    }

    public RecordSet getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(RecordSet newNivelEstudios) {
        nivelEstudios = newNivelEstudios;
    }

    public RecordSet getPaises() {
        return paises;
    }

    public void setPaises(RecordSet newPaises) {
        paises = newPaises;
    }

    public RecordSet getTiposPreferencias() {
        return tiposPreferencias;
    }

    public void setTiposPreferencias(RecordSet newTiposPreferencias) {
        tiposPreferencias = newTiposPreferencias;
    }

    public RecordSet getTiposVinculo() {
        return tiposVinculo;
    }

    public void setTiposVinculo(RecordSet newTiposVinculo) {
        tiposVinculo = newTiposVinculo;
    }

   public void setLongitudesCodigoClientePais(RecordSet newLongitudesCodigoClientePais){
		longitudesCodigoClientePais = newLongitudesCodigoClientePais;
   }

  public RecordSet getLongitudesCodigoClientePais() {
        return longitudesCodigoClientePais;
    }
	 public RecordSet getTipoCliente() {
        return tipoCliente;
    }
	public void setTipoCliente(RecordSet newTipoCliente){
		tipoCliente = newTipoCliente;
   }

  public RecordSet getCanales() { return this.canales; }
  public void setCanales(RecordSet canales) { this.canales = canales; }
   
}