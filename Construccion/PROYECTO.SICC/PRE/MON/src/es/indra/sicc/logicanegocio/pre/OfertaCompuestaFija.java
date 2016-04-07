package es.indra.sicc.logicanegocio.pre;

public class OfertaCompuestaFija extends OfertaOrdenar {

  public OfertaCompuestaFija() {
  
  }
  
  public int compareTo(Object oferta) {
    if (this.getProductoPrincipal()!=null&&this.getProductoPrincipal().booleanValue()) {
      return -1;
    }
    
    if (this.getTextoBreve()!=null&&((OfertaOrdenar)oferta).getTextoBreve()!=null) {
      return this.getTextoBreve().compareTo(((OfertaOrdenar)oferta).getTextoBreve());
    } else if (this.getTextoBreve()==null) {
      if (((OfertaOrdenar)oferta).getTextoBreve()==null) return 0;
      return -1;
    } else {
      return 1;
    }    
  }
}