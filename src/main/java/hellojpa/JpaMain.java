package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //code
        tx.begin(); //트랜잭션 시작
        Member member = new Member();
        member.setId(1l);
        member.setName("helloA");
        em.persist(member); //영속화(저장)

        tx.commit(); //트랜잭션 종료하고 내용 커밋

        em.close();
        emf.close();
    }
}
