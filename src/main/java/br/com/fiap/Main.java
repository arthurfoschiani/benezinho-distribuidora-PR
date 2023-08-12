package br.com.fiap;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.ItemEstocado;
import br.com.fiap.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deposito dep1 = new Deposito().setId(null).setName("Vila Mariana");
        Deposito dep2 = new Deposito().setId(null).setName("Vila Romana");

        Produto p1 = new Produto().setId(null).setNome("Abacaxi").setDescricao("Fruta deliciosa").setValor(BigDecimal.valueOf(5.99));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(dep1);
        manager.persist(dep2);
        manager.persist(p1);

        var count = 0;
        var qntd = 50;

        while (count < qntd) {
            var item = new ItemEstocado().setId(null).setDeposito(dep1).setProduto(p1).setEntrada(LocalDateTime.now()).setNumeroSerie(count + "NR" + qntd + "-" + p1.getId() + "-" + dep1.getId());
            var itemDep2 = new ItemEstocado().setId(null).setDeposito(dep2).setProduto(p1).setEntrada(LocalDateTime.now()).setNumeroSerie(count + "NR" + qntd + "-" + p1.getId() + "-" + dep2.getId());
            manager.persist(item);
            manager.persist(itemDep2);
            count ++;
        }

        manager.getTransaction().commit();

        var jpbl = "FROM ItemEstocado i join fetch i.deposito where i.deposito.id = 2L";
        List list = manager.createQuery(jpbl).getResultList();
        list.forEach(System.out::println);
        manager.close();
        factory.close();
    }
}