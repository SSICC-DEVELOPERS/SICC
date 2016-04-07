package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.UsuariosGruposUsuariosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class UsuariosGruposUsuariosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public UsuariosGruposUsuariosLocal create(Long usuario, Long grupoUsuario) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_UGUC_SEQ");
		et.begin();
		UsuariosGruposUsuariosLocal local = new UsuariosGruposUsuariosLocal(oid, usuario, grupoUsuario);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(UsuariosGruposUsuariosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(UsuariosGruposUsuariosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public UsuariosGruposUsuariosLocal findByPrimaryKey(Long  oid) {
		UsuariosGruposUsuariosLocal local = (UsuariosGruposUsuariosLocal)em.find(UsuariosGruposUsuariosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("UsuariosGruposUsuariosLocal.FindAll");          
            return query.getResultList();
        }

}
