/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

import es.indra.sicc.logicanegocio.dto.ConstantesDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;

import es.indra.sicc.dtos.dto.DTOGlobalDescuento; 

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPDescuentos
 * Fecha:               02/11/2005
 * Modelo:		          DMCO-DTO-BELC300014763
 * Observaciones:
 * @version             3.6
 * @author              Emilio Noziglia
 * Notas:
 *    @wancho 21/11/2005, Inc.0014763
 */

public abstract class LPDescuentos extends LPSICCBase {

  private static final String CTE_DTO_CACHE = "claveDTODescuentos";
  protected String idPestanyaDest;
  protected Integer nIdPestanyaDest;
  
  protected String accion;
  protected String casoDeUso;
  
	       
  public LPDescuentos() {
    super();
  }
    
	public abstract void inicio() throws Exception;
  
	public abstract void ejecucion() throws Exception;    
  
	public abstract void almacenar() throws Exception;

	public abstract void cargarPantalla() throws Exception;  
  
  public abstract void siguiente() throws Exception;  
  
	public DTOGlobalDescuento getDescuento() throws Exception {
		DTOGlobalDescuento descuento = null;
    
		traza("entra a getDescuento");
    
		try {
			traza("this.getSessionCache(): " + this.getSessionCache());

			descuento = (DTOGlobalDescuento)this.getSessionCache().get(
                                                LPDescuentos.CTE_DTO_CACHE);
		} catch (Exception e){
			traza("no se encontro el DTOGlobalDescuento en sesion");
		}
    traza("termina getDescuento");
		return descuento;
	}
  
	public void setDescuento(DTOGlobalDescuento dto) {
		this.getSessionCache().put(LPDescuentos.CTE_DTO_CACHE, dto);
	}
  
 /**
   * @author Emilio Noziglia
   * @fecha  01/11/2005
   * @throws java.lang.Exception
   * @param  idPestanyaDest
   */
	public void redirigir() throws Exception {
    
      traza("LPDescuentos.redirigir():Entrada");
  
      this.idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
  
      traza("idPestanyaDest: " + idPestanyaDest);
  
      
      if(idPestanyaDest == null){
          return;
      }
  
      try{
          nIdPestanyaDest = new Integer(idPestanyaDest);
          traza("nIdPestanyaDest: " + nIdPestanyaDest.toString() );
      }catch(NumberFormatException nfe){
          return;
      }
  
      if (this.nIdPestanyaDest.equals(ConstantesDTO.PESTANYA_DATOS_GENERALES)){
          this.invocarLP("LPMantenimientoDTODG", "cargar pantalla");
      } else if (this.nIdPestanyaDest.equals(ConstantesDTO.PESTANYA_TIPO_CLIENTES)){
          this.invocarLP("LPMantenimientoAlcanceTipoCliente", "");
      } else if (this.nIdPestanyaDest.equals(ConstantesDTO.PESTANYA_ALCANCE_ADMINISTRATIVO)){
          this.invocarLP("LPMantenimientoAlcanceAdministrativo", "");
      } else if (this.nIdPestanyaDest.equals(ConstantesDTO.PESTANYA_BASE_CALCULO)){
          this.invocarLP("LPMantenimientoBaseCalculo", "");
      } else if (this.nIdPestanyaDest.equals(ConstantesDTO.PESTANYA_BASE_APLICACION)){
          this.invocarLP("LPMantenimientoBaseAplicacion", "");
      };
      
      traza("LPDescuentos.redirigir():Salida");        
  }
   /**
     * @author Emilio Noziglia
     * @fecha  02/11/2005
     * @throws java.lang.Exception
     * @param  lp
     * @param  accion     
     */
    private void invocarLP(String lp, String accion) throws Exception {
        traza("Invocar LP " + lp + " - accion: " + accion);
        this.conectorAction(lp);
        this.accion = accion;
        this.conectorActionParametro("accion", accion);
        this.conectorActionParametro("casoDeUso", casoDeUso);
    }

    /**
     * @author Emilio Noziglia
     * @fecha  02/11/2005
     * @throws java.lang.Exception
     */
    public void guardar() throws Exception{
      traza("LPDescuentos.guardar():Entrada");
      
      DTOGlobalDescuento dtoDescuento = getDescuento();
      
      boolean indActivar = false;
      
      traza("LPDescuentos.guardar():casoDeUso:"+casoDeUso);
      
      if (Boolean.TRUE.equals(dtoDescuento.getIndDatosGralesDto()) && 
          Boolean.TRUE.equals(dtoDescuento.getIndAlcanceTipoCliente()) &&
          Boolean.TRUE.equals(dtoDescuento.getIndAlcanceAdministrativo()) &&
          Boolean.TRUE.equals(dtoDescuento.getIndBaseCalculo()) &&
          Boolean.TRUE.equals(dtoDescuento.getIndBaseAplicacion())) {
          indActivar = true;
      
          // Si se seleccionó definir el alcance a nivel cliente validar que se 
          // haya ingresado información en dicha pantalla 
          if  (Boolean.TRUE.equals(dtoDescuento.getAlcanceTipoCliente().
                  getDefinirCliente())) { 
              indActivar = (dtoDescuento.getIndAlcanceCliente()!=null)?
                      dtoDescuento.getIndAlcanceCliente().booleanValue():false;
          } 
      }

      if (Boolean.TRUE.equals(dtoDescuento.getDatosGralesDto().getActivo())) { 
          if (!indActivar) {
            throw new MareException(new Exception(),70000011);
          } else { 

            this.guardarDescuento();            
                                   
            this.conectorParametroSesion("DTODatosGenerales",dtoDescuento.
                                                          getDatosGralesDto());
          
          /*
            Lo siguiente se hará por js de la siguiente manera:
            Se agregará una variable oculta en cada pestaña hExito "S" o "N" o ""
            la cual se seteara aqui si se guardo con exito el descuento activo
            y en el onLoad() de cada pagina se preguntara si esta en "S"; y en
            ese caso se llamara a un metodo que se agrega en utilidadesDTO.js
            guardoConExito(); que mostrara el mensaje mencionado y redirigira a la 
            LPOrdenamientoDTO.
            -Si no se produjo ningún error, mostrar el mensaje de error UIDTO-0012 
            -Llamar a la Lp LPOrdenamientoDTO con acción "descuentoDefinido"            
          */
            
            this.asignarAtributo("VAR","hExito","valor","S");            
          } 
      } else {         
        if (indActivar) { 
          this.guardarDescuento();
          
          this.conectorParametroSesion("DTODatosGenerales",dtoDescuento.getDatosGralesDto());
          
          this.invocarLP("LPOrdenacionDTO","descuentoDefinido");
        } else { 
          if (Boolean.TRUE.equals(dtoDescuento.getIndDatosGralesDto())) { 
            this.guardarDescuento();
            //enozigli 09/11/2005 cambio por inc. BELC300021700
            if ("insertar".equals(casoDeUso)){
                this.invocarLP("LPSeleccionarMatrizDTO","");
            } else {                
                this.asignarAtributo("VAR","hExito","valor","M");                
            }
          } else {            
            throw new MareException(new Exception(),70000013);
          } 
        } 
      } 

      
      traza("LPDescuentos.guardar():Salida");
    }
  
    /**
     * @author Emilio Noziglia
     * @fecha  02/11/2005
     * @throws java.lang.Exception
     */
    private void guardarDescuento() throws Exception {    
        traza("LPDescuentos.guardarDescuento():Entrada");
    
        MareBusinessID IDBusiness = new MareBusinessID("DTOGuardarDatosDescuento");
        Vector params = new Vector();
        params.add(getDescuento());
        params.add(IDBusiness);
        
        traza("Va a guardar.");
        this.conectar("ConectorGuardarDatosDescuento", params);
        traza("Guardó.");
        
        traza("LPDescuentos.guardarDescuento():Salida");
    }    
}
