package es.indra.sicc.logicanegocio.pre;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * 
 * @date 
 * @author pperanzola
 */
public class CatalogoPromociones 
{
    /**
     * 
     * @date 
     */
    Hashtable lineasProductos = new Hashtable();
    Hashtable productos = new Hashtable();
    Hashtable paginas = new Hashtable();
    Hashtable ofertas = new Hashtable();
    Long oidCatalogo;
    
    public CatalogoPromociones()  {
    }
    
    public void setOidCatalogo (Long oidCatalogo){
        this.oidCatalogo=oidCatalogo;
    }
    
    public Long getOidCatalogo (){
        return this.oidCatalogo;
    }
    public void agregarProducto (Long producto){
         if (producto!=null && this.productos.get(producto)==null){
            this.productos.put(producto,producto);
         }
    }
    
    public void agregarPagina(Integer pagina){
        if (pagina!= null && this.paginas.get(pagina)==null){
            this.paginas.put(pagina,pagina);
        }
    }
    
    public void agregarLineasProductos(Long lineasProductos){
        if (lineasProductos != null && this.lineasProductos.get(lineasProductos)==null){
            this.lineasProductos.put(lineasProductos,lineasProductos);
        }
    }
    
    public String obtenerProductosString(){
        return productos.values().toString().substring(1,productos.values().toString().length()-1);
       
    }
    
    public String obtenerLineaProductosString(){
        return lineasProductos.values().toString().substring(1,lineasProductos.values().toString().length()-1);
    }
    public String obtenerPaginasString(){    
        return paginas.values().toString().substring(1,paginas.values().toString().length()-1);
    }
    
    public String obtenerPaginasStringDesdeHasta(){
        String concatena = new String();
        if (paginas.size()>0){
            Iterator it = (Iterator)paginas.elements();
            concatena = new String();
            concatena = concatena + "1 = 2 ";
            while (it.hasNext()){
                Integer pagina = (Integer) it.next();
                concatena = concatena + (" OR ("+ pagina +" >=DESDE AND "+ pagina+ "<= HASTA )  ");
            }
        }
        return concatena ;
    }
    
    public void agregarOfertas(Long ofertas){
        if (ofertas != null && this.ofertas.get(ofertas)==null){
            this.ofertas.put(ofertas,ofertas);
        }
    }
     public String obtenerOfertasString(){    
        return ofertas.values().toString().substring(1,ofertas.values().toString().length()-1);
    }
    
    
}