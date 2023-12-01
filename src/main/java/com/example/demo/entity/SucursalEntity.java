package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SUCURSAL")
public class SucursalEntity implements Serializable{

	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSucursal")
	@Column(name = "ID_SUCURSAL")
	@SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqSucursal")
	private Long id;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "LOCALIDAD")
	private String localidad;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "TELEFONO")
	private Integer telefono;	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sucursal")
	@JsonIgnore
	private Set<ReservaEntity> reserva;
	
}
