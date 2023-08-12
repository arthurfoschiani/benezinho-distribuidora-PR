package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_DEPOSITO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_DEPOSITO", columnNames = {"NM_DEPOSITO"})
})
public class Deposito {
    @Id
    @SequenceGenerator(name = "SQ_DEPOSITO", sequenceName = "SQ_DEPOSITO", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPOSITO")
    @Column(name = "ID_DEPOSITO")
    private Long id;
    @Column(name = "NM_DEPOSITO", nullable = false)
    private String name;

    public Deposito() {
    }

    public Deposito(Long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public Deposito setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Deposito setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
