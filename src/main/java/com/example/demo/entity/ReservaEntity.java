package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RESERVA")
public class ReservaEntity implements Serializable{

	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReserva")
	@Column(name = "ID_RESERVA")
	@SequenceGenerator(sequenceName = "SEQ_RESERVA", allocationSize = 1, name = "seqReserva")
	private Long id;

	@Column(name = "CLASE")
	private char clase;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", nullable = false)
	private ClienteEntity cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", nullable = false)
	private HotelEntity hotel;
	
	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL", nullable = false)
	private SucursalEntity sucursal;
	
	@ManyToOne
	@JoinColumn(name="ID_VUELO", nullable = false)
	private VueloEntity vuelo;
	
}
