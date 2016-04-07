package es.indra.sicc.logicanegocio.dto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;

/**
 * @author Federico I. Hofman
 *
 * Created on 7/09/2004
 * Tipo de dato : DTOSBaseAplicacionDetalleComparator
 *  
 */
public class DTOSBaseAplicacionDetalleComparator implements Comparator {
		
   /**
	 * Constructor
	 * 
	 * 
	 */
	public DTOSBaseAplicacionDetalleComparator() {
		super();
	}


	public int compare(Object o1, Object o2) {
		DTOSBaseAplicacionDetalle dto1 = (DTOSBaseAplicacionDetalle)o1;
		DTOSBaseAplicacionDetalle dto2 = (DTOSBaseAplicacionDetalle)o2;
		int may = -1;
		int men = 1;
		if(dto1.getProducto() == null){
			return men;
		}
		if(dto2.getProducto() == null){
			return may;
		}
		if(dto1.getProducto().compareTo(dto2.getProducto()) > 0){
			return may;
		}else
		if(dto1.getProducto().compareTo(dto2.getProducto()) < 0){
			return men;
		}else
		if(dto1.getProducto().compareTo(dto2.getProducto()) == 0){
			if(dto1.getCicloVida() == null){
				return men;
			}
			if(dto2.getCicloVida() == null){
				return may;
			}
			if(dto1.getCicloVida().compareTo(dto2.getCicloVida()) > 0){
				return may;
			}
			if(dto1.getCicloVida().compareTo(dto2.getCicloVida()) < 0){
				return men;
			}
			if(dto1.getCicloVida().compareTo(dto2.getCicloVida()) == 0){
				if(dto1.getTipoOferta() == null){
					return men;
				}
				if(dto2.getTipoOferta() == null){
					return may;
				}
				if(dto1.getTipoOferta().compareTo(dto2.getTipoOferta()) > 0){
					return may;
				}
				if(dto1.getTipoOferta().compareTo(dto2.getTipoOferta()) < 0){
					return men;
				}
				if(dto1.getTipoOferta().compareTo(dto2.getTipoOferta()) == 0){
					if(dto1.getGenerico() == null){
						return men;
					}
					if(dto2.getGenerico() == null){
						return may;
					}
					if(dto1.getGenerico().compareTo(dto2.getGenerico()) > 0){
						return may;					
					}
					if(dto1.getGenerico().compareTo(dto2.getGenerico()) < 0){
						return men;					
					}
					if(dto1.getGenerico().compareTo(dto2.getGenerico()) == 0){
						if(dto1.getSupergenerico() == null){
							return men;
						}
						if(dto2.getSupergenerico() == null){
							return may;
						}
						if(dto1.getSupergenerico().compareTo(dto2.getSupergenerico()) > 0){
							return may;					
						}
						if(dto1.getSupergenerico().compareTo(dto2.getSupergenerico()) < 0){
							return men;					
						}
						if(dto1.getSupergenerico().compareTo(dto2.getSupergenerico()) == 0){
							if(dto1.getNegocio() == null){
								return men;
							}
							if(dto2.getNegocio() == null){
								return may;
							}
							if(dto1.getNegocio().compareTo(dto2.getNegocio()) > 0){
								return may;					
							}
							if(dto1.getNegocio().compareTo(dto2.getNegocio()) < 0){
								return men;					
							}
							if(dto1.getNegocio().compareTo(dto2.getNegocio()) == 0){
								if(dto1.getUnidadNegocio() == null){
									return men;
								}
								if(dto2.getUnidadNegocio() == null){
									return may;
								}
								if(dto1.getUnidadNegocio().compareTo(dto2.getUnidadNegocio()) > 0){
									return may;					
								}
								if(dto1.getUnidadNegocio().compareTo(dto2.getUnidadNegocio()) < 0){
									return men;					
								}
								if(dto1.getUnidadNegocio().compareTo(dto2.getUnidadNegocio()) == 0){
									if(dto1.getMarca() == null){
										return men;
									}
									if(dto2.getMarca() == null){
										return may;
									}
									if(dto1.getMarca().compareTo(dto2.getMarca()) > 0){
										return may;					
									}
									if(dto1.getMarca().compareTo(dto2.getMarca()) < 0){
										return men;					
									}
									if(dto1.getMarca().compareTo(dto2.getMarca()) == 0){
										return 0;
									}
								}	
							}								
						}
												
					}
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		DTOSBaseAplicacionDetalle dto = new DTOSBaseAplicacionDetalle();
		dto.setDescripcionProducto("Producto 1");
		dto.setDescripcionCicloVida("Ciclo Vida 2");
		dto.setDescripcionTipoOferta("Tipo Oferta 1");
		
		al.add(dto);
		
		DTOSBaseAplicacionDetalle dto1 = new DTOSBaseAplicacionDetalle();
		dto1.setDescripcionProducto("Producto 3");
		dto1.setDescripcionCicloVida("Ciclo Vida 1");
		dto1.setDescripcionTipoOferta("Tipo Oferta 1");
		al.add(dto1);
		
		DTOSBaseAplicacionDetalle dto2 = new DTOSBaseAplicacionDetalle();
		dto2.setDescripcionProducto(null);
		dto2.setDescripcionCicloVida("Ciclo Vida 2");
		dto2.setDescripcionTipoOferta("Tipo Oferta 1");
		al.add(dto2);
		
		DTOSBaseAplicacionDetalle dto3 = new DTOSBaseAplicacionDetalle();
		dto3.setDescripcionProducto("Producto 1");
		dto3.setDescripcionCicloVida("Ciclo Vida 2");
		dto3.setDescripcionTipoOferta(null);
		al.add(dto3);
		
		System.out.println(al);
		Collections.sort(al, new DTOSBaseAplicacionDetalleComparator());
		System.out.println(al);
	}
}
