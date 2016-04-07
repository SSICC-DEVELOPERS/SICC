package es.indra.sicc.logicanegocio.pre;

public class OfertaCondicionada extends OfertaOrdenar {

  public OfertaCondicionada() {
  
  }
  
  public int compareTo(Object oferta) {
    if ((this.getIndicadorCondicionado()!=null&&this.getIndicadorCondicionado().booleanValue())&&
        (((OfertaOrdenar)oferta).getIndicadorCondicionado()==null||
        (((OfertaOrdenar)oferta).getIndicadorCondicionado()!=null&&(!((OfertaOrdenar)oferta).getIndicadorCondicionado().booleanValue())))) {
      return -1;
    } else if ((((OfertaOrdenar)oferta).getIndicadorCondicionado()!=null&&((OfertaOrdenar)oferta).getIndicadorCondicionado().booleanValue())&&
              (this.getIndicadorCondicionado()==null||
              (this.getIndicadorCondicionado()!=null&&(!this.getIndicadorCondicionado().booleanValue())))) {
      return 1;
    } else {
      if (this.getNumeroGrupo()!=null&&((OfertaOrdenar)oferta).getNumeroGrupo()!=null) {
        if (this.getNumeroGrupo().compareTo(((OfertaOrdenar)oferta).getNumeroGrupo())==0) {
          if (this.getTextoBreve()!=null&&((OfertaOrdenar)oferta).getTextoBreve()!=null) {
            return this.getTextoBreve().compareTo(((OfertaOrdenar)oferta).getTextoBreve());
          } else if (this.getTextoBreve()==null) {
            if (((OfertaOrdenar)oferta).getTextoBreve()==null) return 0;
            return -1;
          } else {
            return 1;
          }           
        } else {
          return this.getNumeroGrupo().compareTo(((OfertaOrdenar)oferta).getNumeroGrupo());
        }
      } else if (this.getNumeroGrupo()==null&&((OfertaOrdenar)oferta).getNumeroGrupo()==null) {
        if (this.getTextoBreve()!=null&&((OfertaOrdenar)oferta).getTextoBreve()!=null) {
          return this.getTextoBreve().compareTo(((OfertaOrdenar)oferta).getTextoBreve());
        } else if (this.getTextoBreve()==null) {
          if (((OfertaOrdenar)oferta).getTextoBreve()==null) return 0;
          return -1;
        } else {
          return 1;
        }       
      } else if (this.getNumeroGrupo()==null) {
        return -1;
      } else {
        return 1;
      }      
    }
  }
}