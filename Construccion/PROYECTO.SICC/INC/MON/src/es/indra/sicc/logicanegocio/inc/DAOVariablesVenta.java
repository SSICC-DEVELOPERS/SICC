package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;

public class DAOVariablesVenta 
{
  public DAOVariablesVenta()
  {
  }

  public ArrayList obtenerGerentesConcursos(DTOFACProcesoCierre dtoe) throws MareException
/*
      Autor:DVJUIZ 
      Fecha:26/04/2005 
      
      Descripcion: obtiene los gerentes y concursos relacionados junto con los totales de monto y unidades para un periodo. 
      
      Implementacion: 
      
      1.- Ejecutar una consulta que tenga las siguientes caracteristicas: 
      
      1.1.- Tablas, filtros, joins y agrupamientos: 
      1.1.1.- Efectuar un join entre las entidades INC:SolicitudConcursoPuntaje (solConcu) e 
      INC:ConcursoParametrosGenerales(concParam) igualando: 
      solConcu.concurso = concParam.oid 
      1.1.2.- Filtrar por: 
      1.1.2.1.- concParam.activo = true 
      1.1.2.2.- concParam.periodoDesde <= dtoe.periodo < concParam.periodoHasta 
      1.1.2.3.- concParam.dirigidoA = ConstantesINC.TIPO_GERENTE 
      1.1.3.- Efectuar un join entre las entidades INC:ConcursoParametrosGenerales(concParam) e 
      INC:ConcursoParametrosGerentes (paramGeren) igualando: 
      concParam.oid = paramGeren.concurso 
      1.1.4.- Filtrar por paramCalif.formaCalculo = Interfaces:INC:ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA 
      1.1.5.- Filtrar por solConcu.periodo 
      1.1.6.- Agrupar por solConcu.periodo 
      1.2.- Campos a recuperar: 
      1.2.1.- solConcu.concurso 
      1.2.2.- solConcu.gerente 
      1.2.3.- Totalizar el atributo solConcu.monto 
      1.2.4.- Totalizar el atributo solConcu.unidades. 
      2.- Crear un ArrayList para guardar el resultado de la consulta. 
      3.- Por cada elemento recuperado en el punto 1 crear un objeto de la clase DTOGerentesConcursos y agregarlo al ArrayList creado 
      en el punto anterior. 
      4.- Retornar el ArrayList completado en el punto anterior
*/
  {
    
    
    return null;
  }

}