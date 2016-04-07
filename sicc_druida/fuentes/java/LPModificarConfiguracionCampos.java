/*
    INDRA/CAR/PROY
    $Id: LPModificarConfiguracionCampos.java,v 1.1 2009/12/03 18:35:58 pecbazalar Exp $
    DESC
*/

import LPSICCBase;
import es.indra.sicc.util.DTOOID;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mae.DTOConsultaConfiguracionCampos;
import es.indra.sicc.dtos.mae.DTOConfiguracionCampo;


public class LPModificarConfiguracionCampos extends LPSICCBase {

        String casoDeUso;
        String accion;

        String oIDModificar;
        String tipoCampo;
        String nombreCampo;
        String obligatorio;
        String modificable;
        String valorxdefecto;
        String tipoCliente;
        String subtipoCliente;

    public LPModificarConfiguracionCampos ()  {
      super();
    }

    public void inicio() throws Exception  {
      pagina("contenido_campos_parametrizables_insertar");
    }

    public void ejecucion() throws Exception  {
      try{
        rastreo();
          setTrazaFichero();
        casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
        accion = conectorParametroLimpia("accion","",true);

        traza(" ");
        traza("********************************************************");
        traza("********************* ejecucion() LPModificar **********************");
        traza("********************************************************");
        traza("casoDeUso : "     + casoDeUso);
        traza("accion : "        + accion);
        
        traza("oIDModificar : "  + oIDModificar);
        traza("tipoCampo : "     + tipoCampo);
        traza("nombreCampo : "   + nombreCampo);
        traza("obligatorio : "   + obligatorio);
        traza("modificable : "   + modificable);
        traza("valorxdefecto : " + valorxdefecto);
        traza("tipoCliente : "   + tipoCliente);
        traza("subtipoCliente : "+ subtipoCliente);

  //accion == " " ---------------------------------------------------------------------------
        if (accion.equals(""))  {

          oIDModificar = conectorParametro("clave0");
            traza("oIDModificar : "  + oIDModificar);
            traza( "Entro en accion " + accion );
          DTOOID dtoOID = new DTOOID();
          dtoOID.setOid( new Long(oIDModificar) );
          Vector objBussines = new Vector();
          objBussines.add(dtoOID);
          objBussines.add( new MareBusinessID("MAEConsultarConfiguracionCampo") );
          DruidaConector con = conectar("ConectorConsultarConfiguracionCampos",objBussines);
          DTOConsultaConfiguracionCampos dto = (DTOConsultaConfiguracionCampos) con.objeto("DTOSalida");
            traza("Registro a modificar: dto " + dto);
          if ( dto.getObligatorio().booleanValue() ){ 
             asignarAtributo("VAR","hObligatorio","valor","S"); 
          }else{ 
             asignarAtributo("VAR","hObligatorio","valor","N"); 
          }
          traza("paso el if de obligatorio");

          if(dto.getModificable().booleanValue()){ 
             asignarAtributo("VAR","hModificable","valor","S"); 
          }else{ 
             asignarAtributo("VAR","hModificable","valor","N"); 
          }
          traza("paso el if de modificable");
          
          if (dto.getIndClienteProducto().booleanValue() )  {
            
            asignarAtributo("VAR","hTipoCampo","valor","0");
            asignarAtributo("VAR","hTipoCliente","valor",dto.getTipoCliente().toString());
            asignarAtributo("VAR","hSubtipoCliente","valor",dto.getSubtipoCliente().toString());             
          }
          else {
            asignarAtributo("VAR","hTipoCampo","valor","1");
          }
          traza("dewspues if idn producto");
          asignarAtributo("VAR","hNombreCampo","valor",dto.getCampo().toString());
          traza("despues de var nombre campo");
          
          
          traza("despues de var nombre campo");
         
          if((dto.getValorDefecto() == null) || (dto.getValorDefecto().equals(""))){
             asignarAtributo("VAR","hValorPorDefecto","valor","");
             asignarAtributo("CTEXTO","txtValorPorDefecto","valor","");
          }else{
             asignarAtributo("VAR","hValorPorDefecto","valor",dto.getValorDefecto().toString());
             asignarAtributo("CTEXTO","txtValorPorDefecto","valor",dto.getValorDefecto().toString());
          }
             
          traza("despues de var valor por def");
          asignarAtributo("VAR","hCasoDeUso","valor","Modificar");
          traza("despues de var caso de uso");
          asignarAtributo("VAR","hOID","valor",oIDModificar);
          traza("despues de var oid");
            traza("Sale de accion vacia");

        }


  //accion == "Guardar" ----------------------------------------------------------------------
        if (accion.equals("Guardar"))  {

          pagina("salidaGenerica");
          oIDModificar = conectorParametroLimpia("hOID","",true);
          obligatorio = conectorParametroLimpia("IngresoObligatorio","",true);
          modificable = conectorParametroLimpia("ModificableporUsuario","",true);
          valorxdefecto = conectorParametroLimpia("txtValorPorDefecto","",true);
          tipoCampo = conectorParametroLimpia("hTipoCampo","",true);
          nombreCampo = conectorParametroLimpia("hNombreCampo","",true);
          tipoCliente = conectorParametroLimpia("hTipoCliente","",true);
          subtipoCliente = conectorParametroLimpia("hSubtipoCliente","",true);
            traza( "Entro en accion " + accion );
          DTOConfiguracionCampo  dtoGuardar = new DTOConfiguracionCampo();
          dtoGuardar.setOid( new Long(oIDModificar) );
          if ( obligatorio.equals("S") ) { dtoGuardar.setObligatorio( Boolean.TRUE); }
          else { dtoGuardar.setObligatorio( Boolean.FALSE); }
          if ( modificable.equals("S") ) { dtoGuardar.setModificable( Boolean.TRUE ); }
          else { dtoGuardar.setModificable( Boolean.FALSE ); }
          dtoGuardar.setValorDefecto(valorxdefecto);          
            traza("Registro a guardar dtoGuardar" + dtoGuardar);
          Vector objBussines = new Vector();
          objBussines.add(dtoGuardar);
          objBussines.add( new MareBusinessID("MAEModificarConfiguracionCampo") );
          conectar("ConectorGuardarConfiguracionCampos",objBussines);
            traza("ConectorGuardarConfiguracionCampos");
            traza("Sale de accion Guardar");

        }


      } catch (Exception e) {
          lanzarPaginaError(e); 
      }

		if(casoDeUso.equals("Modificar")){
			asignarAtributoPagina("cod","0369");
		}else if(casoDeUso.equals("Eliminar")){
			asignarAtributoPagina("cod","0370");
		}
      getConfiguracionMenu();

    }



}
/*****************************************************************************************************
si accion="" { 
-El oid recibido se guarda en un campo oculto 

- idBusiness = "MAEConsultarConfiguracionCampo" 
-Se crea un DTOOID con el oid que hemos recibido como parametro de la LP de consulta 
-Se llama al ConectorConsultarConfiguracionCampos 
-Con el DTOConsultaConfiguracionCampos que obtenemos rellenamos los campos de la pantalla 

-Los únicos campos que se pueden modificar son obligatorio, modificable y valorDefecto 
Si el campo indClienteProducto está a false se ocultan los campos tipoCliente y subtipoCliente 
} 

si accion ="Guardar" { 
-idBusiness = "MAEModificarConfiguracionCampo" 
-Se crea un DTOConfiguracionCampo y se rellenan los siguientes atributos: 
oid: con el oid oculto recibido de la página de consulta 
valorDefecto, modificable y obligatorio se rellenan con los valores de sus correspondientes campos de la pantalla 
-ConectorGuardarConfiguracionCampos 
}
*****************************************************************************************************/
