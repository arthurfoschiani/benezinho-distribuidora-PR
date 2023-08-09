package br.com.fiap.domain.entity;

import java.time.LocalDateTime;

public class ItemEstocado {
    private Long id;
    private Produto produto;
    private Deposito deposito;
    private LocalDateTime entrada;
    private LocalDateTime saida;
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
