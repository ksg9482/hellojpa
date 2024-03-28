package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //이게 정석 코드. 안되면 롤백하고, 끝나면 엔티티메니저 닫아주고.
        tx.begin(); //트랜잭션 시작
        try {
            Member member = new Member();
            member.setId(1l);
            member.setName("helloA");

            em.persist(member); //영속화(저장)
            tx.commit(); //트랜잭션 종료하고 내용 커밋

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();
    }
}
