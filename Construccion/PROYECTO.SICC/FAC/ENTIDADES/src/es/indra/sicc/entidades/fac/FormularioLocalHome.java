package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.FormularioLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FormularioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public FormularioLocal create(String codigo, Short numLineasPagina, String tamanio, String rutinaDisenyoFormato, Boolean imprimible, Boolean preimpreso, Boolean spoolIndividualPaquetei, Long tecnologia, String nombre, Boolean activo, Boolean numeracionOficial, Short numLineasSaltoPagina, Long tipoDocumento, Long destino) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_FORS_SEQ");
		FormularioLocal local = new FormularioLocal(oid, codigo, numLineasPagina, tamanio, rutinaDisenyoFormato, imprimible, preimpreso, spoolIndividualPaquetei, tecnologia, nombre, activo, numeracionOficial, numLineasSaltoPagina, tipoDocumento, destino);
		em.persist(local);
		et.commit();
		return local;
	}

        public FormularioLocal create(String codigo, Short numLineasPagina, String tamanio, String rutinaDisenyoFormato, Boolean imprimible, Boolean preimpreso, Boolean spoolIndividualPaquetei, Long tecnologia, String nombre, Boolean activo, Boolean numeracionOficial, Short numLineasSaltoPagina, Long tipoDocumento, Long destino, Long TipoFormulario) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_FORS_SEQ");
                FormularioLocal local = new FormularioLocal(oid, codigo, numLineasPagina, tamanio, rutinaDisenyoFormato, imprimible, preimpreso, spoolIndividualPaquetei, tecnologia, nombre, activo, numeracionOficial, numLineasSaltoPagina, tipoDocumento, destino, TipoFormulario);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(FormularioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormularioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormularioLocal findByPrimaryKey(Long  oid) {
		FormularioLocal local = (FormularioLocal)em.find(FormularioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("FormularioLocal.FindAll");
		return (query.getResultList());
	}

	public Collection findByTipoDocumento(Long param1) {
		Query query=em.createNamedQuery("FormularioLocal.FindByTipoDocumento");
		query.setParameter(1, param1);
		return (query.getResultList());
	}

}
