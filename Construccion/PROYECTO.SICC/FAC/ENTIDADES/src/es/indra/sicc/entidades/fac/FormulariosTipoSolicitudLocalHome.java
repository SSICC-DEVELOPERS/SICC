package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.FormulariosTipoSolicitudLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FormulariosTipoSolicitudLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public FormulariosTipoSolicitudLocal create(Long formulario, Long tipoSolicitud, Short numOrdenSecuencia) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_FTSO_SEQ");
		FormulariosTipoSolicitudLocal local = new FormulariosTipoSolicitudLocal(oid, formulario, tipoSolicitud, numOrdenSecuencia);
		em.persist(local);
		et.commit();
		return local;
	}
        
	public void remove(FormulariosTipoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormulariosTipoSolicitudLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormulariosTipoSolicitudLocal findByPrimaryKey(Long  oid) {
		FormulariosTipoSolicitudLocal local = (FormulariosTipoSolicitudLocal)em.find(FormulariosTipoSolicitudLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByTipoSolicitud(Long param1) {
		Query query=em.createNamedQuery("FormulariosTipoSolicitudLocal.FindByTipoSolicitud");		
		query.setParameter(1, param1);
		return (query.getResultList());
	}

}
