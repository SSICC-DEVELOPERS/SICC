/*
    INDRA/CAR/PROY
    $Id: LPConsultaConfiguracionCampos.java,v 1.1 2009/12/03 18:40:27 pecbazalar Exp $
    DESC
*/

import LPSICCBase;
import es.indra.sicc.util.DTOOID;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mae.DTOConsultaConfiguracionCampos;


public class LPConsultaConfiguracionCampos extends LPSICCBase  {

        String casoDeUso;
        String accion;

        String oIDConsultar;

  public LPConsultaConfiguracionCampos ()  {
    super();
  }

  public void inicio() throws Exception  {
    pagina("contenido_campos_parametrizables_insertar");
    getConfiguracionMenu();
  }

  public void ejecucion() throws Exception  {

    try{
      rastreo();
        setTrazaFichero();
        casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
        accion = conectorParametroLimpia("accion","",true);

        traza(" ");
        traza("********************************************************");
        traza("********************* ejecucion() LPConsultar **********************");
        traza("********************************************************");
        traza("casoDeUso : " + casoDeUso);
        traza("accion : " + accion);

  //accion == " " ---------------------------------------------------------------------------
      if (accion.equals("")) {

          traza("Entra en accion vacia" );
        oIDConsultar = conectorParametroLimpia("clave0","",true);
          traza("oIDConsultar : "   + oIDConsultar);
        DTOOID dtoOID= new DTOOID();
        dtoOID.setOid(new Long(oIDConsultar));
        Vector objBussines = new Vector();
        objBussines.add(dtoOID);
        objBussines.add( new MareBusinessID("MAEConsultarConfiguracionCampo") );
        DruidaConector con = conectar("ConectorConsultarConfiguracionCampos",objBussines);
          traza("ConectorConsultarConfiguracionCampos");
        DTOConsultaConfiguracionCampos  dto = (DTOConsultaConfiguracionCampos ) con.objeto("DTOSalida");
            traza("Registro a visualizar DTOSalida: " + dto);
        if ( dto.getIndClienteProducto().booleanValue() )  {
          traza("dentro del if"); 
          asignarAtributo("VAR","hTipoCampo","valor","0");
          asignarAtributo("VAR","hTipoCliente","valor",dto.getTipoCliente().toString());
          asignarAtributo("VAR","hSubtipoCliente","valor",dto.getSubtipoCliente().toString());
        }
        else {
        traza("en el else");
          asignarAtributo("VAR","hTipoCampo","valor","1");
        }
        
        asignarAtributo("VAR","hNombreCampo","valor",dto.getCampo().toString());
        traza("despues de asignar");

        if ( dto.getObligatorio().booleanValue()){
           traza("segundo if");
           asignarAtributo("VAR","hObligatorio","valor","S"); 
        }else{ 
           traza("segundo else");
           asignarAtributo("VAR","hObligatorio","valor","N"); 
        }

        if ( dto.getModificable().booleanValue()){
           traza("tercer if");
           asignarAtributo("VAR","hModificable","valor","S"); 
        }else{ 
           traza("tercer else");
           asignarAtributo("VAR","hModificable","valor","N"); 
        }
        traza("antes de asiganr ctexto");

        if(dto.getValorDefecto() == null){
           asignarAtributo("CTEXTO","txtValorPorDefecto","valor","");
        }else{
           asignarAtributo("CTEXTO","txtValorPorDefecto","valor",dto.getValorDefecto());

        }

        traza("antes de asignar caso de uso");
        asignarAtributo("VAR","hCasoDeUso","valor","Consultar");
          traza("Sale de accion vacia" );
      }

    } catch (Exception e) {
        lanzarPaginaError(e);
      }

	  if(casoDeUso.equals("Consultar")){
		asignarAtributoPagina("cod","0371");
	  }else if(casoDeUso.equals("Eliminar")){
		asignarAtributoPagina("cod","0370");
	  }

   }



}

/***************************************************************************************************
si accion ="" { 
-idBusiness = "MAEConsultarConfiguracionCampos" 
-Se crea un DTOOID con el oid que hemos recibido como parametro de la LP de consulta 
-Se llama al ConectorConsultarConfiguracionCampos 
-Con el DTOConsultaConfiguracionCampos que obtenemos rellenamos los campos de la pantalla 

-Ninguno de los campos se puede modificar y el botón guardar está desabilitado 
}

Los radioB obligatorio y modificable tienen las opciones "SI" y "NO" (en el idioma del usuario) y los valores true y false respectivamente 

El combo indClienteProducto tiene dos opciones: "Cliente" y "Producto" con los valores true y false respectivamente. Este campo no se va a guardar, sino que simplemente influye en la interfaz gráfica de la siguiente mamera: 
Cuando este seleccionada la opción producto (false) se ocultan los combos tipoCliente y subtipoCliente (estarán en una capa), y por tanto dejan de ser obligatorios. 

Cada vez que cambie el combo tipoCliente se debe recargar el de subtipoCliente filtrando por el tipo elegido (tenemos un array oculto con todas las posibilidades). 

Cada vez que se cambie el indClienteProducto (que inicialmente está a true) se recarga el combo campo de la siguiente forma: si indCliente pasa a valer true se carga en campo el array camposClientes, si es false se carga el array camposProductos (estos arrays fueron guardados por la LP). 

Todos los campos son obligatorios salvo los de tipo y subtipo cuando están ocultos.

*****************************************************************************************************/
