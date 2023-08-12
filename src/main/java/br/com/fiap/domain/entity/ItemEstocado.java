package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ITEM", uniqueConstraints = {
        @UniqueConstraint(name = "UK_ITEM_NR_SERIE", columnNames = {"NR_SERIE"})
})
public class ItemEstocado {
    @Id
    @SequenceGenerator(name = "SQ_ITEM", sequenceName = "SQ_ITEM", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ITEM")
    @Column(name = "ID_ITEM")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO", foreignKey = @ForeignKey(name = "FK_PRODUTO"))
    private Produto produto;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_DEPOSITO", referencedColumnName = "ID_DEPOSITO", foreignKey = @ForeignKey(name = "FK_DEPOSITO"))
    private Deposito deposito;
    @Column(name = "DT_ENTRADA", nullable = false)
    private LocalDateTime entrada;
    @Column(name = "DT_SAIDA")
    private LocalDateTime saida;
    @Column(name = "NR_SERIE", nullable = false)
    private String numeroSerie;

    public ItemEstocado() {
    }

    public ItemEstocado(Long id, Produto produto, Deposito deposito, LocalDateTime entrada, LocalDateTime saida, String numeroSerie) {
        this.id = id;
        this.produto = produto;
        this.deposito = deposito;
        this.entrada = entrada;
        this.saida = saida;
        this.numeroSerie = numeroSerie;
    }

    public Long getId() {
        return id;
    }

    public ItemEstocado setId(Long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemEstocado setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public ItemEstocado setDeposito(Deposito deposito) {
        this.deposito = deposito;
        return this;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public ItemEstocado setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public ItemEstocado setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public ItemEstocado setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
        return this;
    }

    @Override
    public String toString() {
        return "ItemEstocado{" +
                "id=" + id +
                ", produto=" + produto +
                ", deposito=" + deposito +
                ", entrada=" + entrada +
                ", saida=" + saida +
                ", numeroSerie='" + numeroSerie + '\'' +
                '}';
    }
}
