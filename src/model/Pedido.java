package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe simples que representa um Pedido feito por um Cliente
public class Pedido {

    private int id;
    private Date data;
    private String formaPagamento;
    private String status; // ABERTO, EM PREPARO, SAIU PARA ENTREGA, ENTREGUE, CANCELADO
    private double total;
    private int idCliente;
    private List<ItemPedido> itens; // lista de itens que compoem o pedido

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = "ABERTO";
        this.data = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
        calcularTotal();
    }

    // Soma o subtotal de todos os itens do pedido e atualiza o total
    public double calcularTotal() {
        double soma = 0.0;
        for (ItemPedido item : itens) {
            soma += item.calcularSubtotal();
        }
        this.total = soma;
        return this.total;
    }
}
