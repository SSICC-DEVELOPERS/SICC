package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOUsuarEtapaCobraDetal extends DTOSiccPaginacion {
          
     private Long oidMarca;
     private Long oidCanal;
     private Long oidSeccion;
     private Long oidZona;
     private Long oidTerritorio;
     private Long oidSubgeVentas;
     private Long oidRegion;
     private Long oidEtapaDeudaTCarg;
     private Long oidUsuarioEtapCobra;
     private Long oidMetodoLiqui;
     private Long oidGuionArgCabec;
     private Long oidTipoCargo;
     private String observaciones;
     private Long oidUsuarioCobDeta;
     
     public DTOUsuarEtapaCobraDetal() {
	   }
     
     
     
     
     public Long getOidMarca(){
        return oidMarca;
     }
  
     public void setOidMarca(Long newOidMarca){
       oidMarca = newOidMarca;
     }
     
     public Long getOidCanal(){
        return oidCanal;
     }
  
     public void setOidCanal(Long newOidCanal){
       oidCanal = newOidCanal;
     }
     
     public Long getOidSeccion(){
        return oidSeccion;
     }
  
     public void setOidSeccion(Long newOidSeccion){
       oidSeccion = newOidSeccion;
     }
     
     public Long getOidZona(){
        return oidZona;
     }
  
     public void setOidZona(Long newOidZona){
       oidZona = newOidZona;
     }
     
     public Long getOidTerritorio(){
        return oidTerritorio;
     }
  
     public void setOidTerritorio(Long newOidTerritorio){
       oidTerritorio = newOidTerritorio;
     }
     
     public Long getOidSubgeVentas(){
        return oidSubgeVentas;
     }
  
     public void setOidSubgeVentas(Long newOidSubgeVentas){
       oidSubgeVentas = newOidSubgeVentas;
     }
     
     public Long getOidRegion(){
        return oidRegion;
     }
  
     public void setOidRegion(Long newOidRegion){
       oidRegion = newOidRegion;
     }
     
     public Long getOidEtapaDeudaTCarg(){
        return oidEtapaDeudaTCarg;
     }
  
     public void setOidEtapaDeudaTCarg(Long newOidEtapaDeudaTCarg){
       oidEtapaDeudaTCarg = newOidEtapaDeudaTCarg;
     }
     
     public Long getOidUsuarioEtapCobra(){
        return oidUsuarioEtapCobra;
     }
  
     public void setOidUsuarioEtapCobra(Long newOidUsuarioEtapCobra){
       oidUsuarioEtapCobra = newOidUsuarioEtapCobra;
     }
     
     public Long getOidMetodoLiqui(){
        return oidMetodoLiqui;
     }
  
     public void setOidMetodoLiqui(Long newOidMetodoLiqui){
       oidMetodoLiqui = newOidMetodoLiqui;
     }
     
     public Long getOidGuionArgCabec(){
        return oidGuionArgCabec;
     }
  
     public void setOidGuionArgCabec(Long newOidGuionArgCabec){
       oidGuionArgCabec = newOidGuionArgCabec;
     }
     
     public Long getOidTipoCargo(){
        return oidTipoCargo;
     }
  
     public void setOidTipoCargo(Long newOidTipoCargo){
       oidTipoCargo = newOidTipoCargo;
     }
     
     public String getObservaciones(){
        return observaciones;
     }
  
     public void setObservaciones(String newObservaciones){
       observaciones = newObservaciones;
     }
     
     public Long getOidUsuarioCobDeta(){
        return oidUsuarioCobDeta;
     }
  
     public void setOidUsuarioCobDeta(Long newOidUsuarioCobDeta){
       oidUsuarioCobDeta = newOidUsuarioCobDeta;
     }
     
}

