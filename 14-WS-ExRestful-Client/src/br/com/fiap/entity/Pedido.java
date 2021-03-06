package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="pedido",sequenceName="SQ_T_PEDIDO",allocationSize=1)
public class Pedido {

	@Id
	@GeneratedValue(generator="pedido",strategy=GenerationType.SEQUENCE )
	@Column(name = "cd_pedido")
	private int codigo;
	
	@Column(name= "nm_pedido")
	private String cliente;
	
	@Column(name="vl_valor")
	private double valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
