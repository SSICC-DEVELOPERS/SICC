package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.Date;

public class DTOINTDatosConsultora extends DTOBelcorp{
    public DTOINTDatosConsultora()
    {
    }
    
     private   Date fechaNacimiento;           
        private Long oidConsultora;     
        private BigDecimal deudaBanco;     
        
        private String indicadorEstrella;                  
        private String indicadorEstrellaCosmeticos;        
        private String indicadorEstrellaAccesorios;        
        private String indicadorEstrellaSM;                
        private String indicadorEstrellaRegalables;        
        private String indicadorEstrellaHogar;             
        private Integer indicadorConsultoraTerritorial;  
        private Integer indicadorLider;           		
        private Integer indicadorGerenteZona;
        private Integer indicadorGerenteRegion;
        private Integer indicadorActiva;
        private Integer indicadorPerteneceClubElite;
        private Integer indicadorActivaClubElite;
        private Integer flagSelect;
                                                               
        private String anioCampaniaUltimoPedido;
        private String estadoCivil;
        private String codigoConsultora;
        private String codigoTerritorio;
        private String nombreApellidos;
        private String nombreConsultora;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String NSE;
        private String anioCampaniaIngreso;
        private Long codigoUltimoTipoCursoRecibido;
        private String tipoDocumentoIdentidad;
        private String numeroDocumentoIdentidad;
        private String estatusVentaVigente;
        private String estatusCorporativoEquivalente;
        private String telefono;
        private String telefonoTrabajo;
        private String nombreDepartamento;
        private String provincia;
        private String distrito;
        private String direccion;
                                                                
        private String campaniaPromocion;
        private String descripcionTipocentroPoblado;
        private String descripcionCentroPoblado;
        private String nombre1Lider;
        private String nombre2Lider;
        private String apellido1Lider;
        private String apellido2Lider;
        private String codigoTipoCentroPoblado;
        private String codigoCentroPoblado;
        private String orden1; 
        private String orden2; 
        private String orden3; 
        private String orden4; 
        private String orden5; 
        private String orden6; 
        private String orden7; 
        private String orden8; 
        private String orden9; 
        private String codigoConsultoraRecomendante;
        private String codigoFuenteIngreso;
        private String codigoAnterior;
        private String codigoUbigeo;
        private Integer flagTipoAccion;  
    private String nombre1Consultora;
    private String nombre2Consultora;
    private String apellido1Consultora;
    private String apellido2Consultora;

    public String getNSE()
    {
        return NSE;
    }

    public void setNSE(String NSE)
    {
        this.NSE = NSE;
    }

    public String getAnioCampaniaIngreso()
    {
        return anioCampaniaIngreso;
    }

    public void setAnioCampaniaIngreso(String anioCampaniaIngreso)
    {
        this.anioCampaniaIngreso = anioCampaniaIngreso;
    }

    public String getAnioCampaniaUltimoPedido()
    {
        return anioCampaniaUltimoPedido;
    }

    public void setAnioCampaniaUltimoPedido(String anioCampaniaUltimoPedido)
    {
        this.anioCampaniaUltimoPedido = anioCampaniaUltimoPedido;
    }

    public String getApellido1Lider()
    {
        return apellido1Lider;
    }

    public void setApellido1Lider(String apellido1Lider)
    {
        this.apellido1Lider = apellido1Lider;
    }

    public String getApellido2Lider()
    {
        return apellido2Lider;
    }

    public void setApellido2Lider(String apellido2Lider)
    {
        this.apellido2Lider = apellido2Lider;
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCampaniaPromocion()
    {
        return campaniaPromocion;
    }

    public void setCampaniaPromocion(String campaniaPromocion)
    {
        this.campaniaPromocion = campaniaPromocion;
    }

    public String getCodigoAnterior()
    {
        return codigoAnterior;
    }

    public void setCodigoAnterior(String codigoAnterior)
    {
        this.codigoAnterior = codigoAnterior;
    }

    public String getCodigoCentroPoblado()
    {
        return codigoCentroPoblado;
    }

    public void setCodigoCentroPoblado(String codigoCentroPoblado)
    {
        this.codigoCentroPoblado = codigoCentroPoblado;
    }

    public String getCodigoConsultora()
    {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String codigoConsultora)
    {
        this.codigoConsultora = codigoConsultora;
    }

    public String getCodigoConsultoraRecomendante()
    {
        return codigoConsultoraRecomendante;
    }

    public void setCodigoConsultoraRecomendante(String codigoConsultoraRecomendante)
    {
        this.codigoConsultoraRecomendante = codigoConsultoraRecomendante;
    }

    public String getCodigoFuenteIngreso()
    {
        return codigoFuenteIngreso;
    }

    public void setCodigoFuenteIngreso(String codigoFuenteIngreso)
    {
        this.codigoFuenteIngreso = codigoFuenteIngreso;
    }

    public String getCodigoTerritorio()
    {
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(String codigoTerritorio)
    {
        this.codigoTerritorio = codigoTerritorio;
    }

    public String getCodigoTipoCentroPoblado()
    {
        return codigoTipoCentroPoblado;
    }

    public void setCodigoTipoCentroPoblado(String codigoTipoCentroPoblado)
    {
        this.codigoTipoCentroPoblado = codigoTipoCentroPoblado;
    }

    public Long getCodigoUltimoTipoCursoRecibido()
    {
        return codigoUltimoTipoCursoRecibido;
    }

    public void setCodigoUltimoTipoCursoRecibido(Long codigoUltimoTipoCursoRecibido)
    {
        this.codigoUltimoTipoCursoRecibido = codigoUltimoTipoCursoRecibido;
    }

    public String getDescripcionCentroPoblado()
    {
        return descripcionCentroPoblado;
    }

    public void setDescripcionCentroPoblado(String descripcionCentroPoblado)
    {
        this.descripcionCentroPoblado = descripcionCentroPoblado;
    }

    public String getDescripcionTipocentroPoblado()
    {
        return descripcionTipocentroPoblado;
    }

    public void setDescripcionTipocentroPoblado(String descripcionTipocentroPoblado)
    {
        this.descripcionTipocentroPoblado = descripcionTipocentroPoblado;
    }

    public BigDecimal getDeudaBanco()
    {
        return deudaBanco;
    }

    public void setDeudaBanco(BigDecimal deudaBanco)
    {
        this.deudaBanco = deudaBanco;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getDistrito()
    {
        return distrito;
    }

    public void setDistrito(String distrito)
    {
        this.distrito = distrito;
    }

    public String getEstadoCivil()
    {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
        this.estadoCivil = estadoCivil;
    }

    public String getEstatusCorporativoEquivalente()
    {
        return estatusCorporativoEquivalente;
    }

    public void setEstatusCorporativoEquivalente(String estatusCorporativoEquivalente)
    {
        this.estatusCorporativoEquivalente = estatusCorporativoEquivalente;
    }

    public String getEstatusVentaVigente()
    {
        return estatusVentaVigente;
    }

    public void setEstatusVentaVigente(String estatusVentaVigente)
    {
        this.estatusVentaVigente = estatusVentaVigente;
    }

    public Date getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFlagSelect()
    {
        return flagSelect;
    }

    public void setFlagSelect(Integer flagSelect)
    {
        this.flagSelect = flagSelect;
    }

    public Integer getIndicadorActiva()
    {
        return indicadorActiva;
    }

    public void setIndicadorActiva(Integer indicadorActiva)
    {
        this.indicadorActiva = indicadorActiva;
    }

    public Integer getIndicadorActivaClubElite()
    {
        return indicadorActivaClubElite;
    }

    public void setIndicadorActivaClubElite(Integer indicadorActivaClubElite)
    {
        this.indicadorActivaClubElite = indicadorActivaClubElite;
    }

    public Integer getIndicadorConsultoraTerritorial()
    {
        return indicadorConsultoraTerritorial;
    }

    public void setIndicadorConsultoraTerritorial(Integer indicadorConsultoraTerritorial)
    {
        this.indicadorConsultoraTerritorial = indicadorConsultoraTerritorial;
    }

    public String getIndicadorEstrella()
    {
        return indicadorEstrella;
    }

    public void setIndicadorEstrella(String indicadorEstrella)
    {
        this.indicadorEstrella = indicadorEstrella;
    }

    public String getIndicadorEstrellaAccesorios()
    {
        return indicadorEstrellaAccesorios;
    }

    public void setIndicadorEstrellaAccesorios(String indicadorEstrellaAccesorios)
    {
        this.indicadorEstrellaAccesorios = indicadorEstrellaAccesorios;
    }

    public String getIndicadorEstrellaCosmeticos()
    {
        return indicadorEstrellaCosmeticos;
    }

    public void setIndicadorEstrellaCosmeticos(String indicadorEstrellaCosmeticos)
    {
        this.indicadorEstrellaCosmeticos = indicadorEstrellaCosmeticos;
    }

    public String getIndicadorEstrellaHogar()
    {
        return indicadorEstrellaHogar;
    }

    public void setIndicadorEstrellaHogar(String indicadorEstrellaHogar)
    {
        this.indicadorEstrellaHogar = indicadorEstrellaHogar;
    }

    public String getIndicadorEstrellaRegalables()
    {
        return indicadorEstrellaRegalables;
    }

    public void setIndicadorEstrellaRegalables(String indicadorEstrellaRegalables)
    {
        this.indicadorEstrellaRegalables = indicadorEstrellaRegalables;
    }

    public String getIndicadorEstrellaSM()
    {
        return indicadorEstrellaSM;
    }

    public void setIndicadorEstrellaSM(String indicadorEstrellaSM)
    {
        this.indicadorEstrellaSM = indicadorEstrellaSM;
    }

    public Integer getIndicadorGerenteRegion()
    {
        return indicadorGerenteRegion;
    }

    public void setIndicadorGerenteRegion(Integer indicadorGerenteRegion)
    {
        this.indicadorGerenteRegion = indicadorGerenteRegion;
    }

    public Integer getIndicadorGerenteZona()
    {
        return indicadorGerenteZona;
    }

    public void setIndicadorGerenteZona(Integer indicadorGerenteZona)
    {
        this.indicadorGerenteZona = indicadorGerenteZona;
    }

    public Integer getIndicadorLider()
    {
        return indicadorLider;
    }

    public void setIndicadorLider(Integer indicadorLider)
    {
        this.indicadorLider = indicadorLider;
    }

    public Integer getIndicadorPerteneceClubElite()
    {
        return indicadorPerteneceClubElite;
    }

    public void setIndicadorPerteneceClubElite(Integer indicadorPerteneceClubElite)
    {
        this.indicadorPerteneceClubElite = indicadorPerteneceClubElite;
    }

    public String getNombre1Lider()
    {
        return nombre1Lider;
    }

    public void setNombre1Lider(String nombre1Lider)
    {
        this.nombre1Lider = nombre1Lider;
    }

    public String getNombre2Lider()
    {
        return nombre2Lider;
    }

    public void setNombre2Lider(String nombre2Lider)
    {
        this.nombre2Lider = nombre2Lider;
    }

    public String getNombreApellidos()
    {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos)
    {
        this.nombreApellidos = nombreApellidos;
    }

    public String getNombreConsultora()
    {
        return nombreConsultora;
    }

    public void setNombreConsultora(String nombreConsultora)
    {
        this.nombreConsultora = nombreConsultora;
    }

    public String getNombreDepartamento()
    {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento)
    {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNumeroDocumentoIdentidad()
    {
        return numeroDocumentoIdentidad;
    }

    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad)
    {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }

    public Long getOidConsultora()
    {
        return oidConsultora;
    }

    public void setOidConsultora(Long oidConsultora)
    {
        this.oidConsultora = oidConsultora;
    }

    public String getOrden1()
    {
        return orden1;
    }

    public void setOrden1(String orden1)
    {
        this.orden1 = orden1;
    }

    public String getOrden2()
    {
        return orden2;
    }

    public void setOrden2(String orden2)
    {
        this.orden2 = orden2;
    }

    public String getOrden3()
    {
        return orden3;
    }

    public void setOrden3(String orden3)
    {
        this.orden3 = orden3;
    }

    public String getOrden4()
    {
        return orden4;
    }

    public void setOrden4(String orden4)
    {
        this.orden4 = orden4;
    }

    public String getOrden5()
    {
        return orden5;
    }

    public void setOrden5(String orden5)
    {
        this.orden5 = orden5;
    }

    public String getOrden6()
    {
        return orden6;
    }

    public void setOrden6(String orden6)
    {
        this.orden6 = orden6;
    }

    public String getOrden7()
    {
        return orden7;
    }

    public void setOrden7(String orden7)
    {
        this.orden7 = orden7;
    }

    public String getOrden8()
    {
        return orden8;
    }

    public void setOrden8(String orden8)
    {
        this.orden8 = orden8;
    }

    public String getOrden9()
    {
        return orden9;
    }

    public void setOrden9(String orden9)
    {
        this.orden9 = orden9;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefonoTrabajo()
    {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo)
    {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getTipoDocumentoIdentidad()
    {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(String tipoDocumentoIdentidad)
    {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getCodigoUbigeo()
    {
        return codigoUbigeo;
    }

    public void setCodigoUbigeo(String codigoUbigeo)
    {
        this.codigoUbigeo = codigoUbigeo;
    }

    public Integer getFlagTipoAccion()
    {
        return flagTipoAccion;
    }

    public void setFlagTipoAccion(Integer flagTipoAccion)
    {
        this.flagTipoAccion = flagTipoAccion;
    }

    public String getNombre1Consultora() {
        return nombre1Consultora;
    }

    public void setNombre1Consultora(String nombre1Consultora) {
        this.nombre1Consultora = nombre1Consultora;
    }

    public String getNombre2Consultora() {
        return nombre2Consultora;
    }

    public void setNombre2Consultora(String nombre2Consultora) {
        this.nombre2Consultora = nombre2Consultora;
    }

    public String getApellido1Consultora() {
        return apellido1Consultora;
    }

    public void setApellido1Consultora(String apellido1Consultora) {
        this.apellido1Consultora = apellido1Consultora;
    }

    public String getApellido2Consultora() {
        return apellido2Consultora;
    }

    public void setApellido2Consultora(String apellido2Consultora) {
        this.apellido2Consultora = apellido2Consultora;
    }
}