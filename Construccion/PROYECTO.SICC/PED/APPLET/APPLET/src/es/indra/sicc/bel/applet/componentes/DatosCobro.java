package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.componentes.FrameDatosCobro;
import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
import es.indra.sicc.comunapplet.Communicator;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesFrames;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.PropertiesApplet;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.bel.DTOCargaCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.DTOOID;

import java.math.BigDecimal;

public class DatosCobro {
  private CobrarBelcenter owner;
  private DTOOID dtooid=null;
  private Long oidPais= null;
  private Long oidIdioma=null;
  private DTOCargaMedioPago[] dtoCargaMedioPago = null;
  private FrameDatosCobro frame=null;
  
  private Communicator communicator;
  private Boolean accionCancelada;
  private String userName = "";
  
  
  public DatosCobro(CobrarBelcenter padre){
    this.owner=padre;
    
    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE);
    this.frame = new FrameDatosCobro(this, 
      PropertiesApplet.getPropertie(ConstantesFrames.FRAMES_DATOS_COBRO, ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE));
    communicator = new Communicator();
  }
  
  public void inicializar(String userName) throws AppletException {
    this.userName = userName;
    
    this.setAccionCancelada(Boolean.FALSE);
 
    if(owner.getFrameCobrarBelcenter().getCargaCobro()==null){
      dtooid=new DTOOID();
      dtooid.setOid(owner.getFrameCobrarBelcenter().getOidSubacceso());  //getSubAcceso());
      dtooid.setOidIdioma(this.oidIdioma);
      dtooid.setOidPais(this.oidPais);
      
      MareDTO  DTOMare = null;
      
      if(owner.$DEBUG){
        //se elimina esto
        owner.getFrameCobrarBelcenter().setCargaCobro(owner.dtoCargaCobroBelcenter);
      }else{
      
        //dtooid.setProperty(ConstantesApplet.USER_NAME, userName);
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtooid);
        dtoApplet.setUserName(this.userName);
        DTOMare = communicator.ejecutarNegocio(owner.getUrl(), "BELCargarCobroBelcenter" , "es.indra.sicc.dtos.bel.DTOApplet", dtoApplet);
        
        
        /*
        if(DTOMare != null){
          System.out.println("dtomare es null");
        }else{
          System.out.println("clase de dtomare: " + DTOMare.getClass().getName() );
        }
        */
        owner.getFrameCobrarBelcenter().setCargaCobro((DTOCargaCobroBelcenter)DTOMare);
      }
    }

    //Vaciar combos antes de cargarlos
    this.frame.getCbMedioPago().removeAllItems();
    this.frame.getCbMoneda().removeAllItems();
    this.frame.getCbBanco().removeAllItems();
    this.frame.getCbTipoTarjeta().removeAllItems();
    
    //Carga de combo Medio de pago
    this.dtoCargaMedioPago = 
      owner.getFrameCobrarBelcenter().getCargaCobro().getMedioPago();
    frame.getCbMedioPago().addItem("", "");
    
    for(int index=0;index<this.dtoCargaMedioPago.length;index++)
      frame.getCbMedioPago().addItem(dtoCargaMedioPago[index].getOid().toString(), 
        dtoCargaMedioPago[index].getDescripcion());

    //Carga de combo de Moneda
    DTOCargaMoneda moneda = owner.getFrameCobrarBelcenter().getCargaCobro().getMoneda();
    
    this.frame.getCbMoneda().addItem("", "");
    this.frame.getCbMoneda().addItem(moneda.getOid().toString(), moneda.getDescripcion());
    
    //Carga de combo de Banco
    DTODatosCombo[] banco = owner.getFrameCobrarBelcenter().getCargaCobro().getBanco();
    
    this.frame.getCbBanco().addItem("", "");
    for(int index=0;index<banco.length;index++)
        this.frame.getCbBanco().addItem(banco[index].getOid().toString(), banco[index].getDesc());
    
    //Carga combo Tipo de tarjeta
    DTODatosCombo[] tipoTarjeta = 
      owner.getFrameCobrarBelcenter().getCargaCobro().getTipoTarjeta();
    
    this.frame.getCbTipoTarjeta().addItem("", "");
    
    for(int index=0;index<tipoTarjeta.length;index++)
      this.frame.getCbTipoTarjeta().addItem(tipoTarjeta[index].getOid().toString(), 
        tipoTarjeta[index].getDesc());
        
    //Inicializacion de valores en campos y combos
    //yyy
    this.frame.getTxtImporte().setText("");
    this.frame.getTxtImporteDivisa().setText("");
    this.frame.getTxtNumeroCheque().setText("");
    this.frame.getTxtNumeroNotaCredito().setText("");
    this.frame.getTxtNumeroTarjeta().setText("");
    this.frame.getTxtNumeroValeCompra().setText("");
    this.frame.getTxtTipoCambio().setText("");
    
    this.frame.getCbBanco().setSelectedIndexByKey("");
    this.frame.getCbMedioPago().setSelectedIndexByKey("");
    this.frame.getCbMoneda().setSelectedIndexByKey("");
    this.frame.getCbTipoTarjeta().setSelectedIndexByKey("");
  }
  
  public void changeCbMoneda(){
  
    System.out.println("entra a changeCbMoneda");

    this.frame.setTxtImporteDivisa("");
    this.frame.setTxtImporte("");

  
    if(this.frame.getCbMoneda().getKey().equals("")){
      this.frame.getTxtImporte().setEnabled(true);
      this.frame.getTxtImporteDivisa().setEnabled(false);
      this.frame.setTxtTipoCambio("");
      this.frame.setImporteObligatorio(true);
    }else{
      this.frame.getTxtImporte().setEnabled(false);
      this.frame.getTxtImporteDivisa().setEnabled(true);
     
      try{
        frame.setTxtTipoCambio(owner.getFrameCobrarBelcenter().getCargaCobro().getTipoCambio().setScale(
          owner.getFrameCobrarBelcenter().getCargaCobro().getMoneda().getDecimales().intValue(), 
          BigDecimal.ROUND_HALF_EVEN).toString());
          
          //DEBUG 
          System.out.println("Tipo Cambio: " + owner.getFrameCobrarBelcenter().getCargaCobro().getTipoCambio());
          System.out.println("Cant Decimales: " + owner.getFrameCobrarBelcenter().getCargaCobro().getMoneda().getDecimales().intValue());

      }catch(Exception e){}
      
      this.frame.setImporteObligatorio(false);
    }
  }
  
  public void changeCbMedioPago(){
  
    System.out.println("entra a changeCbMedioPago");
  
    DTOCargaMedioPago cargaMedioPago=null;
    for (int index=0;index<this.dtoCargaMedioPago.length;index++){
      if(this.frame.getCbMedioPago().getKey().equals(dtoCargaMedioPago[index].getOid().toString()))
        cargaMedioPago = this.dtoCargaMedioPago[index];
    }
    
    if(cargaMedioPago==null) {
      System.out.println("cargaMedioPago==null");
      return;
    }
        
    this.frame.getCbBanco().setEnabled(false);
    this.frame.getTxtNumeroCheque().setEnabled(false);
    this.frame.getCbTipoTarjeta().setEnabled(false);
    this.frame.getTxtNumeroTarjeta().setEnabled(false);
    this.frame.getTxtNumeroValeCompra().setEnabled(false);
    this.frame.getTxtNumeroNotaCredito().setEnabled(false);
    this.frame.setBancoObligatorio(false);
    this.frame.setChequeObligatorio(false); 
    this.frame.setTarjetaObligatorio(false);
    this.frame.setValeCompraObligatorio(false);
    this.frame.setNotaCreditoObligatorio(false);
    Long medioPago=cargaMedioPago.getOidTipoMedioPago();
    if (ConstantesBEL.TIPO_MP_CHEQUE.equals(medioPago) ) { 
      this.frame.getCbBanco().setEnabled(true);
      this.frame.getTxtNumeroCheque().setEnabled(true); 
      this.frame.setBancoObligatorio(true);
      this.frame.setChequeObligatorio(true);
    } else if (ConstantesBEL.TIPO_MP_DEPOSITO_BANCO.equals(medioPago)) { 
          this.frame.getCbBanco().setEnabled(true);
          this.frame.setBancoObligatorio(true);
    } else if(ConstantesBEL.TIPO_MP_TARJETA.equals(medioPago)) { 
        this.frame.getCbTipoTarjeta().setEnabled(true); 
        this.frame.getTxtNumeroTarjeta().setEnabled(true); 
        this.frame.setTarjetaObligatorio(true);
    } else if (ConstantesBEL.TIPO_MP_VALES_COMPRA.equals(medioPago)) { 
        this.frame.getTxtNumeroValeCompra().setEnabled(true);
        this.frame.setValeCompraObligatorio(true);
    } else if (ConstantesBEL.TIPO_MP_NOTA_CREDITO.equals(medioPago)) { 
        this.frame.getTxtNumeroNotaCredito().setEnabled(true); 
        this.frame.setNotaCreditoObligatorio(true);
    } 
  }
  
  public void Aceptar (){

    if(this.frame.getCbMedioPago().getKey().trim().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_MEDIO_PAGO_ES_OBLIGATORIO, 
        this.frame);
      this.frame.getCbMedioPago().requestFocus();
      //System.out.println("no se cargo medio pago");
      return;
    }
    
    if(this.frame.getImporteObligatorio() && 
        this.frame.getTxtImporte().getText().trim().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_IMPORTE_ES_OBLIGATORIO, this.frame);    
      this.frame.getTxtImporte().requestFocus();
      //System.out.println("no se cargo importe");
      return;
    }
    
    if(!this.frame.getImporteObligatorio() && 
        this.frame.getTxtImporteDivisa().getText().trim().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_IMPORTE_DIVISA_ES_OBLIGATORIO, 
        this.frame);
      this.frame.getTxtImporteDivisa().requestFocus();
      //System.out.println("no se cargo importe divisa");
      return;
    }

    if(this.frame.getBancoObligatorio() && 
        this.frame.getCbBanco().getKey().trim().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_BANCO_ES_OBLIGATORIO, this.frame);
      this.frame.getCbBanco().requestFocus();
      //System.out.println("no se cargo banco");
      return;
    }

    if(this.frame.getChequeObligatorio() && 
        this.frame.getTxtNumeroCheque().getText().trim().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_N_CHEQUE_ES_OBLIGATORIO, this.frame);
      this.frame.getTxtNumeroCheque().requestFocus();
      //System.out.println("no se cargo numero cheque");
      return;
    }

    if(this.frame.getTarjetaObligatorio()){  
      if(this.frame.getCbTipoTarjeta().getKey().trim().equals("")){
        Dialogos.mensajeError(ConstantesApplet.CAMPO_TIPO_TARJETA_ES_OBLIGATORIO, 
          this.frame);    
        this.frame.getCbTipoTarjeta().requestFocus();
       // System.out.println("no se cargo tipo tarjeta");
        return;
      }
      if(this.frame.getTxtNumeroTarjeta().getText().trim().equals("")){
        Dialogos.mensajeError(ConstantesApplet.CAMPO_N_TARJETA_ES_OBLIGATORIO, 
          this.frame);    
        this.frame.getTxtNumeroTarjeta().requestFocus();
        //System.out.println("no se cargo numero tarjeta");
        return;
      }
   }

    if(this.frame.getValeCompraObligatorio() && 
        this.frame.getTxtNumeroValeCompra().getText().equals("")){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_N_VALE_COMPRA_ES_OBLIGATORIO, 
                            this.frame);    
        this.frame.getTxtNumeroValeCompra().requestFocus();
        //System.out.println("no se cargo numero vale compra");
        return;
    }
  
    if( this.frame.getNotaCreditoObligatorio() && 
        this.frame.getTxtNumeroNotaCredito().getText().trim().equals("") ){
      Dialogos.mensajeError(ConstantesApplet.CAMPO_N_NOTA_CREDITO_ES_OBLIGATORIO, 
                            this.frame);
      this.frame.getTxtNumeroNotaCredito().requestFocus();
      //System.out.println("no se cargo numero nota credito");
      return;
    }
    
    //Valida el consolidado 
    if(this.frame.getNotaCreditoObligatorio() == true ){ 
      DTOObtenerSolicitudCobro dtoObtenerSolicitudCobro = new DTOObtenerSolicitudCobro();
      dtoObtenerSolicitudCobro.setOidPais(this.oidPais);
      
      //DEBUG
      System.out.println(owner.getFrameCobrarBelcenter().getOidSubacceso());
      dtoObtenerSolicitudCobro.setOidSubacceso(owner.getFrameCobrarBelcenter().getOidSubacceso());

      dtoObtenerSolicitudCobro.setNumeroSolicitud(this.frame.getTxtNumeroNotaCredito().getText());
      dtoObtenerSolicitudCobro.setImporte(new BigDecimal(this.frame.getTxtImporte().getText()));
      
      //INCIDENCIA DBLG400000769
      if (!this.frame.getTxtImporteDivisa().getText().trim().equals(""))
         dtoObtenerSolicitudCobro.setImporteDivisa(new BigDecimal(this.frame.getTxtImporteDivisa().getText()));        
      
      try{
        MareDTO DTOMare = communicator.ejecutarNegocio(owner.getUrl(), 
                                    "BELObtenerSolicitudCobro" , 
                                    "es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro",
                                    dtoObtenerSolicitudCobro);
        if(DTOMare instanceof es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired) {
          this.frame.setVisible(false); 
          return;
        } else {
          this.frame.setOidSolicitudNotaCredito(((DTOOID)DTOMare).getOid());
        }                                            
      }catch(AppletException e){
        UtilApplet.procesarError(e, this.frame);                
      }

    }
    this.frame.setVisible(false);
  }
  
  public void cancelar(){
    this.setAccionCancelada(Boolean.TRUE);
    this.frame.getCbMedioPago().setSelectedIndexByKey("");
    this.frame.getCbMoneda().setSelectedIndexByKey("");
    this.frame.getTxtImporte().setText("");
    this.frame.getTxtImporteDivisa().setText("");
    this.frame.getTxtTipoCambio().setText("");
    this.frame.getCbBanco().setSelectedIndexByKey("");
    this.frame.getTxtNumeroCheque().setText("");
    this.frame.getCbTipoTarjeta().setSelectedIndexByKey("");
    this.frame.getTxtNumeroTarjeta().setText("");
    this.frame.getTxtNumeroValeCompra().setText("");
    this.frame.getTxtNumeroNotaCredito().setText("");
  }
  
  public void  txtImporteDivisa_lostFocus() {
    if(!"".equals(this.frame.getTxtImporteDivisa().getText().trim())) {
      try {
        double impDiv = Double.parseDouble(this.frame.getTxtImporteDivisa().getText().trim());
        double tasa = Double.parseDouble(this.frame.getTxtTipoCambio().getText());
        
        System.out.println("tasa = " + tasa);
        if(tasa == 0) {
          tasa = 1;
        }
        
        BigDecimal importe = new BigDecimal(Double.toString(impDiv / tasa)).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        this.frame.getTxtImporte().setText(importe.toString());
        
      } catch (NumberFormatException e) {
        //TODO
        this.frame.getTxtImporteDivisa().requestFocus();
        Dialogos.mensajeError(ConstantesApplet.NUMERO_INVALIDO, this.frame);        
      }      
    }
  }
  
  public void changeImporteDivisa()
  {
 //     this.frame.setTxtImporte(new BigDecimal(this.frame.getTxtImporteDivisa()).multiply(new BigDecimal(this.frame.getTxtTipoCambio())).setScale(owner.getCargaCobro().getMoneda().getNumeroDecimales(),BigDecimal.ROUND_HALF_UP).toString());
  }
  
  public void seleccionarValoresDefecto()
  {
      this.frame.getCbMedioPago().setSelectedIndexByKey(1);
      this.frame.getCbMoneda().setSelectedIndexByKey(0);
      this.frame.getCbBanco().setSelectedIndexByKey(0);
      this.frame.getCbTipoTarjeta().setSelectedIndexByKey(0);
      this.frame.setModal(true);
      this.changeCbMoneda();
      this.changeCbMedioPago();      
  }
  
  public void mostrarDetalle (DetalleCobroDevolucion fila){
  
    //System.out.println("medio pago que llega: " + fila.getMedioPago());
  
    //this.frame.getCbMedioPago().setSelectedIndexByKey(fila.getMedioPago());
    this.frame.getCbMedioPago().setSelectedIndexByText(fila.getMedioPago());
    
    
    this.frame.getCbMoneda().setSelectedIndexByText(fila.getMoneda());
    
    this.frame.setTxtImporte(fila.getImporte()!=null?fila.getImporte().toString():null);
    this.frame.setTxtImporteDivisa(fila.getImporteDivisa()!=null?fila.getImporteDivisa().toString():null);
    this.frame.setTxtTipoCambio(fila.getTipoCambio());
    
    this.frame.getCbBanco().setSelectedIndexByText(fila.getBanco());
    
    this.frame.getTxtNumeroCheque().setText(fila.getNumeroCheque());
    
    this.frame.getCbTipoTarjeta().setSelectedIndexByText(fila.getTipoTarjeta());
    this.frame.getTxtNumeroTarjeta().setText(fila.getNumeroTarjeta());
    this.frame.getTxtNumeroValeCompra().setText(fila.getNumeroValeCompra());
    this.frame.getTxtNumeroNotaCredito().setText(fila.getNumeroNotaCredito());
    this.frame.setVisible(true);
  }
  
  public DetalleCobroDevolucion generarDetalleCobro (){
    String n = null;
    DetalleCobroDevolucion fila = new DetalleCobroDevolucion();
    
    if(frame.getCbMedioPago().getSelectedItem() != null) {
      fila.setMedioPago(frame.getCbMedioPago().getSelectedItem().toString());
    }
    if(frame.getCbMoneda().getSelectedItem() != null) {
      fila.setMoneda(frame.getCbMoneda().getSelectedItem().toString());
    }


    try{
      n = null;
      fila.setImporteDivisa((n=this.frame.getTxtImporteDivisa().getText())!=null?new BigDecimal(n):null);
    }catch(NumberFormatException nfe){}
        
    fila.setTipoCambio(this.frame.getTxtTipoCambio().getText());
    
    try{
      n = null;
      if(this.getFrame().getImporteObligatorio() || 
        ( this.frame.getTxtImporte().getText() != null &&
        this.frame.getTxtImporte().getText().length() < 1)){
        fila.setImporte((n = this.frame.getTxtImporte().getText()) != null ? new BigDecimal(n) : null);
      }else{
        String iDiv = this.getFrame().getTxtImporteDivisa().getText();
        String iTC = this.getFrame().getTxtTipoCambio().getText();
        
        if(iDiv != null && iDiv.length() > 0 && iTC != null && iTC.length() > 0){
          double dIDiv = Double.valueOf(iDiv).doubleValue();
          double dITC = Double.valueOf(iTC).doubleValue();
          
          fila.setImporte(new BigDecimal(Double.toString(dIDiv / dITC)));
        }
      }
      
    }catch(NumberFormatException nfe){}
    
    //fila.setBanco(this.frame.getCbBanco().getKey());
    if (frame.getCbBanco().getSelectedIndex() > 0) {
      fila.setBanco(frame.getCbBanco().getSelectedItem().toString());
    }
    
    fila.setNumeroCheque(this.frame.getTxtNumeroCheque().getText());
    if (frame.getCbTipoTarjeta().getSelectedIndex() > 0) {
      fila.setTipoTarjeta(frame.getCbTipoTarjeta().getSelectedItem().toString());
    }
    
    fila.setNumeroTarjeta(this.frame.getTxtNumeroTarjeta().getText());
    fila.setNumeroValeCompra(this.frame.getTxtNumeroValeCompra().getText());
    fila.setNumeroNotaCredito(this.frame.getTxtNumeroNotaCredito().getText());
    return fila;
  }
  
  public FrameDatosCobro getFrame()
  {
    return this.frame;
  }
  public void setVisible(boolean visible){
    this.frame.setVisible(visible);
  }

  public Boolean getAccionCancelada()
  {
    return accionCancelada;
  }

  public void setAccionCancelada(Boolean accionCancelada)
  {
    this.accionCancelada = accionCancelada;
  }
  
  public Long getOidPais(){
    return this.oidPais;
  }
  
  public void setOidPais(Long oidPais){
    this.oidPais = oidPais;
  }
  
  public Long getOidIdioma(){
    return this.oidIdioma;
  }
  
  public void setOidIdioma(Long oidIdioma){
    this.oidIdioma = oidIdioma;
  }
  
}