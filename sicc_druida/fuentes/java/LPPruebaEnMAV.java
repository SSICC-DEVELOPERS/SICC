import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.conector.DruidaCampo;
import es.indra.druida.base.ConectorBase;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mav.DTODetalleMAV;

// Definicion de la clase
public class LPPruebaEnMAV extends LPSICCBase 
{
    public void inicio() throws Exception 
    {	

    }

 public void ejecucion() throws Exception
 {
    setTrazaFichero();
//    this.rastreo();
    traza("YYYYYYYYYYYYYYYYY");
    try{
        pagina("PaginaPrueba");
        
        String idioma = UtilidadesSession.getIdioma_ISO(this);
        String pais = UtilidadesSession.getDescripcionPais(this);
        this.asignarAtributo("LABELC","lblPaisActual","valor","HOLA!!!!");
        this.asignarAtributo("LABELC","lblMarcaActual","valor",idioma);
        traza("-----Construyendo DTO -----");
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(Long.valueOf("1130"));
        dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoOid.setOidPais(UtilidadesSession.getPais(this));
        traza("-----Creando MareBusinessID----- " + dtoOid);
        MareBusinessID bussId = new MareBusinessID("MAVObtieneDetalleMAV"); 
        Vector params = new Vector();
        params.add(dtoOid);   
        params.add(bussId);
        traza("-----Antes de Conectar-----AAAA");
        DruidaConector con = this.conectar("ConectorObtieneDetalleMAV", params);
        traza("-----Desp de Conectar-----" + con);
        DTODetalleMAV dtoMAv = (DTODetalleMAV)con.objeto("dtoSalida");
        traza("----------Dto salida Obtenido: " + dtoMAv);
        this.asignarAtributo("CTEXTO","textPrecio",
                "valor",dtoMAv.getPrecio().toString());
        this.asignarAtributo("CTEXTO","textPrecioContable",
                "valor",dtoMAv.getPrecioContable().toString());
        this.asignarAtributo("CTEXTO","textPrecioEstandar",
                "valor",dtoMAv.getPrecioEstandar().toString());
        traza("-----Datos de precio Cargados-----");
    }catch (Exception e){
        traza("Error------------------------");
        this.lanzarPaginaError(e);
    }
 }

}


