package itson.daos;


import itson.interfaces.IInteraccionDAO;
import itson.matchu_dominio.models.Interaccion;
import itson.matchu_dominio.models.Interaccion.TipoInteraccion;
import itson.matchu_utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ricardo
 */
public class InteraccionDAO implements IInteraccionDAO{

    @Override
    public Interaccion guardar(Interaccion interaccion) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(interaccion);
            em.getTransaction().commit();
            return interaccion;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar interacción: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Interaccion> buscar(Long idEmisor, Long idReceptor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Interaccion> res = em.createQuery(
                "SELECT i FROM Interaccion i " +
                "WHERE i.emisor.idEstudiante = :e AND i.receptor.idEstudiante = :r",
                Interaccion.class
            ).setParameter("e", idEmisor).setParameter("r", idReceptor).getResultList();
            return res.isEmpty() ? Optional.empty() : Optional.of(res.get(0));
        } finally {
            em.close();
        }
    }

    @Override
    public boolean dioCLikeA(Long idEmisor, Long idReceptor) {
        return buscar(idEmisor, idReceptor)
               .map(i -> i.getTipo() == TipoInteraccion.LIKE)
               .orElse(false);
    }

    @Override
    public List<Interaccion> listarLikesEnviados(Long idEmisor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT i FROM Interaccion i " +
                "WHERE i.emisor.idEstudiante = :id AND i.tipo = :tipo",
                Interaccion.class
            ).setParameter("id", idEmisor)
             .setParameter("tipo", TipoInteraccion.LIKE)
             .getResultList();
        } finally {
            em.close();
        }
    }
}