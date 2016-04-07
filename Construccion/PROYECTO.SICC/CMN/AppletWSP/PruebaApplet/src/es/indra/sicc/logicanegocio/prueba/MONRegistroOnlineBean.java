package es.indra.sicc.logicanegocio.prueba;
import es.indra.sicc.dtos.prueba.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.prueba.DTODatosCliente;
import es.indra.sicc.dtos.prueba.DTODatosCombo;
import es.indra.sicc.dtos.prueba.DTOTipoDocumento;
import es.indra.sicc.dtos.prueba.DTOTiposSolicitud;

import java.math.BigDecimal;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRegistroOnlineBean implements SessionBean  {
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }
  /**
   *  Se crea un objeto dtoOut del tipo DTOCargaRegistroCliente 
   *  
      Se asignan los siguiente valores: 
      dtoOut.txtSubAcceso="001" 
      dtoOut.oidSubAccesio = 1 

      Se crean los siguiente DTODatosCombo y se agrega al atributo dtoOut.Periodos: 
      1,"200456" 
      2,"200457" 

      Se crean los siguiente DTODatosCombo y se agrega al atributo dtoOut.accesosFisico 
      1,"Gerente Zona" 
      2,"Fax" 
      3,"Mail" 
      4,"Otros" 

      Se crean los siguiente DTODatosCombo y se agrega al atributo dtoOut.tiposDespacho. 
      1,"Normal" 
      2,"Express" 

      Se crean los siguiente DTODatosCombo y se agrega al atributo dtoOut.formaPago. 
      1,"Contado Soles" 
      2,"Crédito Diferido 21 días" 
      3,"Crédito fraccionado 2 cuotas" 
      4,"Crédito fraccionado 3 cuotas" 

      Se asigna NULL al atributo valoresDefecto. 

      Se crean los siguiente DTOTiposSolicitud y se agrega al DTOCargaRegistroCliente.tiposSolicitud. 
      "Grupo EBEL","Venta Directa", "BelCenter",1,"C2",1,"USD" 
      "Grupo Esika","Mayorista","BelCenter",1,"C3",NULL,NULL 

      Se retorna el dtoOut. 
   */
  public DTOCargaRegistroOnline obtenerCargaInicial(Long oidPais, String codUsuario) throws Exception {
      DTOCargaRegistroOnline dto = new DTOCargaRegistroOnline();
      dto.setOidSubAcceso(Long.valueOf("1"));
      dto.setTxtsubAcceso("001");

      DTODatosCombo dtoD1 = new DTODatosCombo();
      DTODatosCombo dtoD2 = new DTODatosCombo();
      dtoD1.setOid(Long.valueOf("1"));
      dtoD1.setDesc("200456");
      dtoD2.setOid(Long.valueOf("2"));
      dtoD2.setDesc("200457");
      DTODatosCombo[] dtoF = {dtoD1, dtoD2};
      dto.setPeriodos(dtoF);

      DTODatosCombo dtoD3 = new DTODatosCombo();
      DTODatosCombo dtoD4 = new DTODatosCombo();
      DTODatosCombo dtoD5 = new DTODatosCombo();
      DTODatosCombo dtoD6 = new DTODatosCombo();
      dtoD3.setOid(Long.valueOf("1"));
      dtoD3.setDesc("Gerente Zona");
      dtoD4.setOid(Long.valueOf("2"));
      dtoD4.setDesc("Fax");
      dtoD5.setOid(Long.valueOf("3"));
      dtoD5.setDesc("Fax");
      dtoD6.setOid(Long.valueOf("4"));
      dtoD6.setDesc("Otros");
      DTODatosCombo[] dtoF2 = {dtoD3, dtoD4, dtoD5, dtoD6};
      dto.setAccesosFisico(dtoF2);

      dtoD1 = new DTODatosCombo();
      dtoD2 = new DTODatosCombo();
      dtoD1.setOid(Long.valueOf("1"));
      dtoD1.setDesc("Normal");
      dtoD2.setOid(Long.valueOf("2"));
      dtoD2.setDesc("Express");
      DTODatosCombo[] dtoF3 = {dtoD1, dtoD2};
      dto.setTiposDespacho(dtoF3);

      DTODatosCombo dtoD7 = new DTODatosCombo();
      DTODatosCombo dtoD8 = new DTODatosCombo();
      DTODatosCombo dtoD9 = new DTODatosCombo();
      DTODatosCombo dtoD10 = new DTODatosCombo();
      dtoD7.setOid(Long.valueOf("1"));
      dtoD7.setDesc("Contado Soles");
      dtoD8.setOid(Long.valueOf("2"));
      dtoD8.setDesc("Crédito Diferido 21 días");
      dtoD9.setOid(Long.valueOf("3"));
      dtoD9.setDesc("Crédito fraccionado 2 cuotas");
      dtoD10.setOid(Long.valueOf("4"));
      dtoD10.setDesc("Crédito fraccionado 3 cuotas");
      DTODatosCombo[] dtoF4 = {dtoD7, dtoD8, dtoD9, dtoD10};
      dto.setFormasPago(dtoF4);
      
      dto.setValoreDefecto(null);
  
      DTOTiposSolicitud dtoTipo1 = new DTOTiposSolicitud();
      DTOTiposSolicitud dtoTipo2 = new DTOTiposSolicitud();
      dtoTipo1.setMarca("Grupo EBEL");
      dtoTipo1.setCanal("Venta Directa");
      dtoTipo1.setAcceso("BelCenter");
      dtoTipo1.setOidTipoSolicitud(Long.valueOf("1"));
      dtoTipo1.setTipoSolicitud("C2");
      dtoTipo1.setOidMoneda(Long.valueOf("1"));
      dtoTipo1.setTipoSolicitud("USD");
      dtoTipo2.setMarca("Grupo Esika");
      dtoTipo2.setCanal("Mayorista");
      dtoTipo2.setAcceso("BelCenter");
      dtoTipo2.setOidTipoSolicitud(Long.valueOf("1"));
      dtoTipo2.setTipoSolicitud("C3");

      DTOTiposSolicitud[] dtoT1 = {dtoTipo1, dtoTipo2};
      dto.setTiposSolicitud(dtoT1);


      return dto;
  }

  /**
   *  Se crea un objeto dtoOut del tipo DTODatosCliente 

      Se asignan los siguiente valores: 
      dtoOut.nombre = "Jose Arturo" 
      dtoOut.apellidos = "Gonzalez Marquez" 
      dtoOut.lineaCredito = 50000 
      dtoOut.lineaDisp = 25000 
      dtoOut.DeudaVencida = 5000 

      Se crea un DTODatosCombo para cada registro a continuacion y se agregan en el atributo dirreciones: 
      1,"calle Hatillo, 45, Apartamente 143, Lima, Peru" 
      2,"calle Loma del Cielo, 123, Casa La colina, Bogota, Colombia" 

      Se crea un DTOTipoDocumento para cada registro a continuacion y se agregan en el atributo tiposDocumento 
      1,"1234567890",1,"Documento Nacional Identidad (DNI)" 
      2,"0987654321"2,"Registro Unico Contribuyente" 

      Se retorna el dtoOuT construido.
   */
  public DTODatosCliente buscarDatosCliente(String codCliente, Long oidPais) throws Exception {
      DTODatosCliente dto = new DTODatosCliente();
      dto.setNombre("Jose Arturo");
      dto.setApellidos("Gonzalez Marquez");
      dto.setLineaCredito(new BigDecimal(50000));
      dto.setLineaDisp(new BigDecimal(25000));
      dto.setDeudaVencida(new BigDecimal(5000));
      DTODatosCombo dtoD1 = new DTODatosCombo();
      DTODatosCombo dtoD2 = new DTODatosCombo();
      dtoD1.setOid(Long.valueOf("1"));
      dtoD1.setDesc("calle Hatillo, 45, Apartamente 143, Lima, Peru");
      dtoD2.setOid(Long.valueOf("2"));
      dtoD2.setDesc("calle Loma del Cielo, 123, Casa La colina, Bogota, Colombia");
      DTODatosCombo[] dtoF = {dtoD1, dtoD2};
      dto.setDirecciones(dtoF);

      DTOTipoDocumento dtoT1 = new DTOTipoDocumento();
      DTOTipoDocumento dtoT2 = new DTOTipoDocumento();
      dtoT1.setOid(Long.valueOf("1"));
      dtoT1.setDesc("1234567890");
      dtoT1.setOidDocLegal(Long.valueOf("1"));
      dtoT1.setDesDocLegal("Documento Nacional Identidad (DNI)");
      dtoT2.setOid(Long.valueOf("2"));
      dtoT2.setDesc("0987654321");
      dtoT2.setOidDocLegal(Long.valueOf("2"));
      dtoT2.setDesDocLegal("Registro Unico Contribuyente");
      DTOTipoDocumento[] dtoF2 = {dtoT1, dtoT2};
      dto.setTiposDocumento(dtoF2);

      return dto;
      
  }

  public void validarCabecera() {
  }
}