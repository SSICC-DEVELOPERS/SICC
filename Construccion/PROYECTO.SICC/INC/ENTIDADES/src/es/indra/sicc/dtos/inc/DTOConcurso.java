package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOConcurso extends DTOBelcorp {
  private DTOPlantilla plantilla;
  private DTOParametrosGeneralesConcurso paramGenerales;
  private DTOProgramaNuevas programaNuevas;
  private DTOListaAmbitosGeograficos listaAmbitosGeograficos;
  private DTOListaEstatusVenta estatusVenta;
  private DTOObtencionPuntos obtencionPuntos;
  private DTOPremios premios;
  private DTOListaMontoVentaRecomendadas listaMontoVentaRecomendadas;
  private DTOParametrosConsultoras paramConsultoras;
  private DTOClasificacionParticipantes clasificParticipantes;
  private DTOParametrosGeneralesPremiacion paramGralesPremiacion;
  private DTORequisitosPremiacion requisitosPremiacion; 
  private DTONivelPremiacion nivelPremiacion;
  private DTOProducto productosValidos;
  private DTOProducto productosExcluidos;
  private DTOProducto productosBonificados;
  private DTOProducto productosExigidos;
  private DTOProducto productosACalificar;
  private DTOProducto productosExcluidosCalificacion;
  private DTOParametrosCalificacion paramCalificacion;
  private Boolean indParamGenerales;
  private Boolean indAmbitosGeograficos;
  private Boolean indProductosExcluidos;
  private Boolean indProductosBonificados;
  private Boolean indProductosExigidos;
  private Boolean indProductosACalificar;
  private Boolean indProductosExcluidosCalificacion;
  private Boolean indObtencionPuntos;
  private Boolean indProgramaNuevas;
  private Boolean indPremios;
  private Boolean indRequisitosPremacion;
  private Boolean indDespachoPremios;
  private Boolean indCalificacion;
  private Boolean indGerentes;
  private Boolean indConsultoras;
  private Boolean indMultinivel;
  private Boolean indProductosValidos;
  private Boolean indEstatusVenta;
  private Boolean indMontoVentaRecomendadas;
  private Boolean indClasificacionParticipantes;
  private Boolean indCursosExigidosPremiacion;
  private Boolean indProductosExigidosPremiacion;
  private Boolean indNivelPremiacion;
  private Boolean indObligParamGenerales;
  private Boolean indObligAmbitosGeograficos;
  private Boolean indObligProductos;
  private Boolean indObligObtencionPuntos;
  private Boolean indObligProgramaNuevas;
  private Boolean indObligPremios;
  private Boolean indObligRequisitosPremiacion;
  private Boolean indObligDespachoPremios;
  private Boolean indObligCalificacion;
  private Boolean indObligGerentes;
  private Boolean indObligConsultoras;
  private Boolean indObligMultinivel;
  private Boolean indObligProductosValidos;
  private Boolean indObligProductosExcluidos;
  private Boolean indObligProductosBonificados;
  private Boolean indObligProductosExigidos;
  private Boolean indObligProductosACalificar;
  private Boolean indObligProductosExcluidosCalificacion;
  private DTOCalificacionParticipantes calificacionParticipantes;
  private Boolean indClasificacionParticipantesCalificacion;
  private DTOCursosExigidosPremiacion listaCursosExigidosPremiacion;
  private DTOProductosExigidosPremiacion listaProductosExigidosPremiacion;
  private DTODespachoPremios despachoPremios;
  private Boolean indVariablesVenta;
  private Boolean indVariablesVentaProyectada;
  private Boolean indVariablesVentaRanking;
  private Boolean indObligVariablesVentaRanking;
  private DTOVariablesVenta variablesVenta;
  private DTOMultinivel multinivel;
  private DTOVariablesVentaProyectada variablesVentaProyectada;
  private DTOListaVariablesVentaRanking variablesVentaRanking;
  private DTOParametrosGerentes paramGerentes;
  private DTONivelesPremiacion listaNivelesPremiacion;
  private Boolean indParamCalificacion;
  private DTOParametrosConsultorasRanking paramConsultorasRanking;
  private Boolean indBorradoAmbitosGeograficos;
  private Boolean indBorradoVariablesVentaRanking;
  private Boolean indBorradoProductosValidos;
  private Boolean indBorradoProductosExcluidos;
  private Boolean indBorradoPremios;
  private Boolean indBorradoGerentes;
  private Boolean indBorradoClasificacionParticipantes;
  private Boolean indBorradoConsultorasRanking;
  private Boolean indBorradoEstatusVenta;
  //Cleal - Inc
  private DTOListaEstatusVenta estatusVentaConsultoras; 
  private Boolean indEstatusVentaConsultoras;
  private Boolean indBorradoProdACalificar;
  private Boolean indBorradoProdExcluidosCalificacion;
  //Agregado por cvalenzu - 8/5/2006
  private Boolean indBorradoProductosExigidos;
  private Boolean indBorradoProductosBonificados;  
  //FIN - Agregado por cvalenzu - 8/5/2006
  
  public Boolean getIndBorradoProductosExigidos() {
    return this.indBorradoProductosExigidos;    
  }
  
  public void setIndBorradoProductosExigidos(Boolean indBorradoProductosExigidos) {
    this.indBorradoProductosExigidos = indBorradoProductosExigidos;
  }
  
  public Boolean getIndBorradoProductosBonificados()  {
    return this.indBorradoProductosBonificados;
  }
  
  public void setIndBorradoProductosBonificados(Boolean indBorradoProductosBonificados)  {
   this.indBorradoProductosBonificados = indBorradoProductosBonificados;
  }  

  public DTOPlantilla getPlantilla()
  {
    return plantilla;
  }

  public void setPlantilla(DTOPlantilla plantilla)
  {
    this.plantilla = plantilla;
  }

  public DTOParametrosGeneralesConcurso getParamGenerales()
  {
    return paramGenerales;
  }

  public void setParamGenerales(DTOParametrosGeneralesConcurso paramGenerales)
  {
    this.paramGenerales = paramGenerales;
  }

  public DTOProgramaNuevas getProgramaNuevas()
  {
    return programaNuevas;
  }

  public void setProgramaNuevas(DTOProgramaNuevas programaNuevas)
  {
    this.programaNuevas = programaNuevas;
  }

  public DTOListaAmbitosGeograficos getListaAmbitosGeograficos()
  {
    return listaAmbitosGeograficos;
  }

  public void setListaAmbitosGeograficos(DTOListaAmbitosGeograficos listaAmbitosGeograficos)
  {
    this.listaAmbitosGeograficos = listaAmbitosGeograficos;
  }

  public DTOListaEstatusVenta getEstatusVenta()
  {
    return estatusVenta;
  }

  public void setEstatusVenta(DTOListaEstatusVenta estatusVenta)
  {
    this.estatusVenta = estatusVenta;
  }

  public DTOObtencionPuntos getObtencionPuntos()
  {
    return obtencionPuntos;
  }

  public void setObtencionPuntos(DTOObtencionPuntos obtencionPuntos)
  {
    this.obtencionPuntos = obtencionPuntos;
  }

  public DTOPremios getPremios()
  {
    return premios;
  }

  public void setPremios(DTOPremios premios)
  {
    this.premios = premios;
  }

  public DTOListaMontoVentaRecomendadas getListaMontoVentaRecomendadas()
  {
    return listaMontoVentaRecomendadas;
  }

  public void setListaMontoVentaRecomendadas(DTOListaMontoVentaRecomendadas listaMontoVentaRecomendadas)
  {
    this.listaMontoVentaRecomendadas = listaMontoVentaRecomendadas;
  }

  public DTOParametrosConsultoras getParamConsultoras()
  {
    return paramConsultoras;
  }

  public void setParamConsultoras(DTOParametrosConsultoras paramConsultoras)
  {
    this.paramConsultoras = paramConsultoras;
  }

  public DTOClasificacionParticipantes getClasificParticipantes()
  {
    return clasificParticipantes;
  }

  public void setClasificParticipantes(DTOClasificacionParticipantes clasificParticipantes)
  {
    this.clasificParticipantes = clasificParticipantes;
  }

  public DTOParametrosGeneralesPremiacion getParamGralesPremiacion()
  {
    return paramGralesPremiacion;
  }

  public void setParamGralesPremiacion(DTOParametrosGeneralesPremiacion paramGralesPremiacion)
  {
    this.paramGralesPremiacion = paramGralesPremiacion;
  }

  public DTONivelPremiacion getNivelPremiacion()
  {
    return nivelPremiacion;
  }

  public void setNivelPremiacion(DTONivelPremiacion nivelPremiacion)
  {
    this.nivelPremiacion = nivelPremiacion;
  }

  public DTOProducto getProductosValidos()
  {
    return productosValidos;
  }

  public void setProductosValidos(DTOProducto productosValidos)
  {
    this.productosValidos = productosValidos;
  }

  public DTOProducto getProductosExcluidos()
  {
    return productosExcluidos;
  }

  public void setProductosExcluidos(DTOProducto productosExcluidos)
  {
    this.productosExcluidos = productosExcluidos;
  }

  public DTOProducto getProductosBonificados()
  {
    return productosBonificados;
  }

  public void setProductosBonificados(DTOProducto productosBonificados)
  {
    this.productosBonificados = productosBonificados;
  }

  public DTOProducto getProductosExigidos()
  {
    return productosExigidos;
  }

  public void setProductosExigidos(DTOProducto productosExigidos)
  {
    this.productosExigidos = productosExigidos;
  }

  public DTOProducto getProductosACalificar()
  {
    return productosACalificar;
  }

  public void setProductosACalificar(DTOProducto productosACalificar)
  {
    this.productosACalificar = productosACalificar;
  }

  public DTOProducto getProductosExcluidosCalificacion()
  {
    return productosExcluidosCalificacion;
  }

  public void setProductosExcluidosCalificacion(DTOProducto productosExcluidosCalificacion)
  {
    this.productosExcluidosCalificacion = productosExcluidosCalificacion;
  }

  public DTOParametrosCalificacion getParamCalificacion()
  {
    return paramCalificacion;
  }

  public void setParamCalificacion(DTOParametrosCalificacion paramCalificacion)
  {
    this.paramCalificacion = paramCalificacion;
  }

  public Boolean getIndParamGenerales()
  {
    return indParamGenerales;
  }

  public void setIndParamGenerales(Boolean indParamGenerales)
  {
    this.indParamGenerales = indParamGenerales;
  }

  public Boolean getIndAmbitosGeograficos()
  {
    return indAmbitosGeograficos;
  }

  public void setIndAmbitosGeograficos(Boolean indAmbitosGeograficos)
  {
    this.indAmbitosGeograficos = indAmbitosGeograficos;
  }

  public Boolean getIndProductosExcluidos()
  {
    return indProductosExcluidos;
  }

  public void setIndProductosExcluidos(Boolean indProductosExcluidos)
  {
    this.indProductosExcluidos = indProductosExcluidos;
  }

  public Boolean getIndProductosBonificados()
  {
    return indProductosBonificados;
  }

  public void setIndProductosBonificados(Boolean indProductosBonificados)
  {
    this.indProductosBonificados = indProductosBonificados;
  }

  public Boolean getIndProductosExigidos()
  {
    return indProductosExigidos;
  }

  public void setIndProductosExigidos(Boolean indProductosExigidos)
  {
    this.indProductosExigidos = indProductosExigidos;
  }

  public Boolean getIndProductosACalificar()
  {
    return indProductosACalificar;
  }

  public void setIndProductosACalificar(Boolean indProductosACalificar)
  {
    this.indProductosACalificar = indProductosACalificar;
  }

  public Boolean getIndProductosExcluidosCalificacion()
  {
    return indProductosExcluidosCalificacion;
  }

  public void setIndProductosExcluidosCalificacion(Boolean indProductosExcluidosCalificacion)
  {
    this.indProductosExcluidosCalificacion = indProductosExcluidosCalificacion;
  }

  public Boolean getIndObtencionPuntos()
  {
    return indObtencionPuntos;
  }

  public void setIndObtencionPuntos(Boolean indObtencionPuntos)
  {
    this.indObtencionPuntos = indObtencionPuntos;
  }

  public Boolean getIndProgramaNuevas()
  {
    return indProgramaNuevas;
  }

  public void setIndProgramaNuevas(Boolean indProgramaNuevas)
  {
    this.indProgramaNuevas = indProgramaNuevas;
  }

  public Boolean getIndPremios()
  {
    return indPremios;
  }

  public void setIndPremios(Boolean indPremios)
  {
    this.indPremios = indPremios;
  }

  public Boolean getIndRequisitosPremacion()
  {
    return indRequisitosPremacion;
  }

  public void setIndRequisitosPremacion(Boolean indRequisitosPremacion)
  {
    this.indRequisitosPremacion = indRequisitosPremacion;
  }

  public Boolean getIndDespachoPremios()
  {
    return indDespachoPremios;
  }

  public void setIndDespachoPremios(Boolean indDespachoPremios)
  {
    this.indDespachoPremios = indDespachoPremios;
  }

  public Boolean getIndCalificacion()
  {
    return indCalificacion;
  }

  public void setIndCalificacion(Boolean indCalificacion)
  {
    this.indCalificacion = indCalificacion;
  }

  public Boolean getIndGerentes()
  {
    return indGerentes;
  }

  public void setIndGerentes(Boolean indGerentes)
  {
    this.indGerentes = indGerentes;
  }

  public Boolean getIndConsultoras()
  {
    return indConsultoras;
  }

  public void setIndConsultoras(Boolean indConsultoras)
  {
    this.indConsultoras = indConsultoras;
  }

  public Boolean getIndMultinivel()
  {
    return indMultinivel;
  }

  public void setIndMultinivel(Boolean indMultinivel)
  {
    this.indMultinivel = indMultinivel;
  }

  public Boolean getIndProductosValidos()
  {
    return indProductosValidos;
  }

  public void setIndProductosValidos(Boolean indProductosValidos)
  {
    this.indProductosValidos = indProductosValidos;
  }

  public Boolean getIndEstatusVenta()
  {
    return indEstatusVenta;
  }

  public void setIndEstatusVenta(Boolean indEstatusVenta)
  {
    this.indEstatusVenta = indEstatusVenta;
  }

  public Boolean getIndMontoVentaRecomendadas()
  {
    return indMontoVentaRecomendadas;
  }

  public void setIndMontoVentaRecomendadas(Boolean indMontoVentaRecomendadas)
  {
    this.indMontoVentaRecomendadas = indMontoVentaRecomendadas;
  }

  public Boolean getIndClasificacionParticipantes()
  {
    return indClasificacionParticipantes;
  }

  public void setIndClasificacionParticipantes(Boolean indClasificacionParticipantes)
  {
    this.indClasificacionParticipantes = indClasificacionParticipantes;
  }

  public Boolean getIndCursosExigidosPremiacion()
  {
    return indCursosExigidosPremiacion;
  }

  public void setIndCursosExigidosPremiacion(Boolean indCursosExigidosPremiacion)
  {
    this.indCursosExigidosPremiacion = indCursosExigidosPremiacion;
  }

  public Boolean getIndProductosExigidosPremiacion()
  {
    return indProductosExigidosPremiacion;
  }

  public void setIndProductosExigidosPremiacion(Boolean indProductosExigidosPremiacion)
  {
    this.indProductosExigidosPremiacion = indProductosExigidosPremiacion;
  }

  public Boolean getIndNivelPremiacion()
  {
    return indNivelPremiacion;
  }

  public void setIndNivelPremiacion(Boolean indNivelPremiacion)
  {
    this.indNivelPremiacion = indNivelPremiacion;
  }

  public Boolean getIndObligParamGenerales()
  {
    return indObligParamGenerales;
  }

  public void setIndObligParamGenerales(Boolean indObligParamGenerales)
  {
    this.indObligParamGenerales = indObligParamGenerales;
  }

  public Boolean getIndObligAmbitosGeograficos()
  {
    return indObligAmbitosGeograficos;
  }

  public void setIndObligAmbitosGeograficos(Boolean indObligAmbitosGeograficos)
  {
    this.indObligAmbitosGeograficos = indObligAmbitosGeograficos;
  }

  public Boolean getIndObligProductos()
  {
    return indObligProductos;
  }

  public void setIndObligProductos(Boolean indObligProductos)
  {
    this.indObligProductos = indObligProductos;
  }

  public Boolean getIndObligObtencionPuntos()
  {
    return indObligObtencionPuntos;
  }

  public void setIndObligObtencionPuntos(Boolean indObligObtencionPuntos)
  {
    this.indObligObtencionPuntos = indObligObtencionPuntos;
  }

  public Boolean getIndObligProgramaNuevas()
  {
    return indObligProgramaNuevas;
  }

  public void setIndObligProgramaNuevas(Boolean indObligProgramaNuevas)
  {
    this.indObligProgramaNuevas = indObligProgramaNuevas;
  }

  public Boolean getIndObligPremios()
  {
    return indObligPremios;
  }

  public void setIndObligPremios(Boolean indObligPremios)
  {
    this.indObligPremios = indObligPremios;
  }

  public Boolean getIndObligRequisitosPremiacion()
  {
    return indObligRequisitosPremiacion;
  }

  public void setIndObligRequisitosPremiacion(Boolean indObligRequisitosPremiacion)
  {
    this.indObligRequisitosPremiacion = indObligRequisitosPremiacion;
  }

  public Boolean getIndObligDespachoPremios()
  {
    return indObligDespachoPremios;
  }

  public void setIndObligDespachoPremios(Boolean indObligDespachoPremios)
  {
    this.indObligDespachoPremios = indObligDespachoPremios;
  }

  public Boolean getIndObligCalificacion()
  {
    return indObligCalificacion;
  }

  public void setIndObligCalificacion(Boolean indObligCalificacion)
  {
    this.indObligCalificacion = indObligCalificacion;
  }

  public Boolean getIndObligGerentes()
  {
    return indObligGerentes;
  }

  public void setIndObligGerentes(Boolean indObligGerentes)
  {
    this.indObligGerentes = indObligGerentes;
  }

  public Boolean getIndObligConsultoras()
  {
    return indObligConsultoras;
  }

  public void setIndObligConsultoras(Boolean indObligConsultoras)
  {
    this.indObligConsultoras = indObligConsultoras;
  }

  public Boolean getIndObligMultinivel()
  {
    return indObligMultinivel;
  }

  public void setIndObligMultinivel(Boolean indObligMultinivel)
  {
    this.indObligMultinivel = indObligMultinivel;
  }

  public Boolean getIndObligProductosValidos()
  {
    return indObligProductosValidos;
  }

  public void setIndObligProductosValidos(Boolean indObligProductosValidos)
  {
    this.indObligProductosValidos = indObligProductosValidos;
  }

  public Boolean getIndObligProductosExcluidos()
  {
    return indObligProductosExcluidos;
  }

  public void setIndObligProductosExcluidos(Boolean indObligProductosExcluidos)
  {
    this.indObligProductosExcluidos = indObligProductosExcluidos;
  }

  public Boolean getIndObligProductosBonificados()
  {
    return indObligProductosBonificados;
  }

  public void setIndObligProductosBonificados(Boolean indObligProductosBonificados)
  {
    this.indObligProductosBonificados = indObligProductosBonificados;
  }

  public Boolean getIndObligProductosExigidos()
  {
    return indObligProductosExigidos;
  }

  public void setIndObligProductosExigidos(Boolean indObligProductosExigidos)
  {
    this.indObligProductosExigidos = indObligProductosExigidos;
  }

  public Boolean getIndObligProductosACalificar()
  {
    return indObligProductosACalificar;
  }

  public void setIndObligProductosACalificar(Boolean indObligProductosACalificar)
  {
    this.indObligProductosACalificar = indObligProductosACalificar;
  }

  public Boolean getIndObligProductosExcluidosCalificacion()
  {
    return indObligProductosExcluidosCalificacion;
  }

  public void setIndObligProductosExcluidosCalificacion(Boolean indObligProductosExcluidosCalificacion)
  {
    this.indObligProductosExcluidosCalificacion = indObligProductosExcluidosCalificacion;
  }

  public DTOCalificacionParticipantes getCalificacionParticipantes()
  {
    return calificacionParticipantes;
  }

  public void setCalificacionParticipantes(DTOCalificacionParticipantes calificacionParticipantes)
  {
    this.calificacionParticipantes = calificacionParticipantes;
  }

  public Boolean getIndClasificacionParticipantesCalificacion()
  {
    return indClasificacionParticipantesCalificacion;
  }

  public void setIndClasificacionParticipantesCalificacion(Boolean indClasificacionParticipantesCalificacion)
  {
    this.indClasificacionParticipantesCalificacion = indClasificacionParticipantesCalificacion;
  }

  public DTORequisitosPremiacion getRequisitosPremiacion()
  {
    return requisitosPremiacion;
  }

  public void setRequisitosPremiacion(DTORequisitosPremiacion requisitosPremiacion)
  {
    this.requisitosPremiacion = requisitosPremiacion;
  }

  public DTOCursosExigidosPremiacion getListaCursosExigidosPremiacion()
  {
    return listaCursosExigidosPremiacion;
  }

  public void setListaCursosExigidosPremiacion(DTOCursosExigidosPremiacion listaCursosExigidosPremiacion)
  {
    this.listaCursosExigidosPremiacion = listaCursosExigidosPremiacion;
  }

  public DTOProductosExigidosPremiacion getListaProductosExigidosPremiacion()
  {
    return listaProductosExigidosPremiacion;
  }

  public void setListaProductosExigidosPremiacion(DTOProductosExigidosPremiacion listaProductosExigidosPremiacion)
  {
    this.listaProductosExigidosPremiacion = listaProductosExigidosPremiacion;
  }

  public DTODespachoPremios getDespachoPremios()
  {
    return despachoPremios;
  }

  public void setDespachoPremios(DTODespachoPremios despachoPremios)
  {
    this.despachoPremios = despachoPremios;
  }

  public Boolean getIndVariablesVenta()
  {
    return indVariablesVenta;
  }

  public void setIndVariablesVenta(Boolean indVariablesVenta)
  {
    this.indVariablesVenta = indVariablesVenta;
  }

  public Boolean getIndVariablesVentaProyectada()
  {
    return indVariablesVentaProyectada;
  }

  public void setIndVariablesVentaProyectada(Boolean indVariablesVentaProyectada)
  {
    this.indVariablesVentaProyectada = indVariablesVentaProyectada;
  }

  public Boolean getIndVariablesVentaRanking()
  {
    return indVariablesVentaRanking;
  }

  public void setIndVariablesVentaRanking(Boolean indVariablesVentaRanking)
  {
    this.indVariablesVentaRanking = indVariablesVentaRanking;
  }

  public Boolean getIndObligVariablesVentaRanking()
  {
    return indObligVariablesVentaRanking;
  }

  public void setIndObligVariablesVentaRanking(Boolean indObligVariablesVentaRanking)
  {
    this.indObligVariablesVentaRanking = indObligVariablesVentaRanking;
  }

  public DTOVariablesVenta getVariablesVenta()
  {
    return variablesVenta;
  }

  public void setVariablesVenta(DTOVariablesVenta variablesVenta)
  {
    this.variablesVenta = variablesVenta;
  }

  public DTOMultinivel getMultinivel()
  {
    return multinivel;
  }

  public void setMultinivel(DTOMultinivel multinivel)
  {
    this.multinivel = multinivel;
  }

  public DTOVariablesVentaProyectada getVariablesVentaProyectada()
  {
    return variablesVentaProyectada;
  }

  public void setVariablesVentaProyectada(DTOVariablesVentaProyectada variablesVentaProyectada)
  {
    this.variablesVentaProyectada = variablesVentaProyectada;
  }

  public DTOListaVariablesVentaRanking getVariablesVentaRanking()
  {
    return variablesVentaRanking;
  }

  public void setVariablesVentaRanking(DTOListaVariablesVentaRanking variablesVentaRanking)
  {
    this.variablesVentaRanking = variablesVentaRanking;
  }

  public DTOParametrosGerentes getParamGerentes()
  {
    return paramGerentes;
  }

  public void setParamGerentes(DTOParametrosGerentes paramGerentes)
  {
    this.paramGerentes = paramGerentes;
  }

  public DTONivelesPremiacion getListaNivelesPremiacion()
  {
    return listaNivelesPremiacion;
  }

  public void setListaNivelesPremiacion(DTONivelesPremiacion listaNivelesPremiacion)
  {
    this.listaNivelesPremiacion = listaNivelesPremiacion;
  }

  public Boolean getIndParamCalificacion(){
    return this.indParamCalificacion;
  }

  public void setIndParamCalificacion(Boolean indParamCalificacion){
    this.indParamCalificacion = indParamCalificacion;
  }

  public DTOParametrosConsultorasRanking getParamConsultorasRanking()
  {
    return paramConsultorasRanking;
  }

  public void setParamConsultorasRanking(DTOParametrosConsultorasRanking paramConsultorasRanking)
  {
    this.paramConsultorasRanking = paramConsultorasRanking;
  }

  public Boolean getIndBorradoAmbitosGeograficos() {
    return indBorradoAmbitosGeograficos;
  }

  public void setIndBorradoAmbitosGeograficos(Boolean indBorradoAmbitosGeograficos) {
    this.indBorradoAmbitosGeograficos = indBorradoAmbitosGeograficos;
  }

  public Boolean getIndBorradoVariablesVentaRanking() {
    return indBorradoVariablesVentaRanking;
  }

  public void setIndBorradoVariablesVentaRanking(Boolean indBorradoVariablesVentaRanking) {
    this.indBorradoVariablesVentaRanking = indBorradoVariablesVentaRanking;
  }

  public Boolean getIndBorradoProductosValidos() {
    return indBorradoProductosValidos;
  }

  public void setIndBorradoProductosValidos(Boolean indBorradoProductosValidos) {
    this.indBorradoProductosValidos = indBorradoProductosValidos;
  }

  public Boolean getIndBorradoProductosExcluidos() {
    return indBorradoProductosExcluidos;
  }

  public void setIndBorradoProductosExcluidos(Boolean indBorradoProductosExcluidos) {
    this.indBorradoProductosExcluidos = indBorradoProductosExcluidos;
  }

  public Boolean getIndBorradoPremios() {
    return indBorradoPremios;
  }

  public void setIndBorradoPremios(Boolean indBorradoPremios) {
    this.indBorradoPremios = indBorradoPremios;
  }

  public Boolean getIndBorradoGerentes() {
    return indBorradoGerentes;
  }

  public void setIndBorradoGerentes(Boolean indBorradoGerentes) {
    this.indBorradoGerentes = indBorradoGerentes;
  }

  public Boolean getIndBorradoClasificacionParticipantes() {
    return indBorradoClasificacionParticipantes;
  }

  public void setIndBorradoClasificacionParticipantes(Boolean indBorradoClasificacionParticipantes) {
    this.indBorradoClasificacionParticipantes = indBorradoClasificacionParticipantes;
  }

  public Boolean getIndBorradoConsultorasRanking() {
    return indBorradoConsultorasRanking;
  }

  public void setIndBorradoConsultorasRanking(Boolean indBorradoConsultorasRanking) {
    this.indBorradoConsultorasRanking = indBorradoConsultorasRanking;
  }

  public Boolean getIndBorradoEstatusVenta() {
    return indBorradoEstatusVenta;
  }

  public void setIndBorradoEstatusVenta(Boolean indBorradoEstatusVenta) {
    this.indBorradoEstatusVenta = indBorradoEstatusVenta;
  }


    public void setEstatusVentaConsultoras(DTOListaEstatusVenta estatusVentaConsultoras)
    {
        this.estatusVentaConsultoras = estatusVentaConsultoras;
    }


    public DTOListaEstatusVenta getEstatusVentaConsultoras()
    {
        return estatusVentaConsultoras;
    }


    public void setIndEstatusVentaConsultoras(Boolean indEstatusVentaConsultoras)
    {
        this.indEstatusVentaConsultoras = indEstatusVentaConsultoras;
    }


    public Boolean getIndEstatusVentaConsultoras()
    {
        return indEstatusVentaConsultoras;
    }

  public Boolean getIndBorradoProdACalificar() {
    return indBorradoProdACalificar;
  }

  public void setIndBorradoProdACalificar(Boolean indBorradoProdACalificar) {
    this.indBorradoProdACalificar = indBorradoProdACalificar;
  }

  public Boolean getIndBorradoProdExcluidosCalificacion() {
    return indBorradoProdExcluidosCalificacion;
  }

  public void setIndBorradoProdExcluidosCalificacion(Boolean indBorradoProdExcluidosCalificacion) {
    this.indBorradoProdExcluidosCalificacion = indBorradoProdExcluidosCalificacion;
  }
  
}