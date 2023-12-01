package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="VUELO")
public class VueloEntity implements Serializable{

	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name = "ID_VUELO")
	@SequenceGenerator(sequenceName = "SEQ_VUELO", allocationSize = 1, name = "seqVuelo")
	private Long id;

	@Column(name = "FECHA_SALIDA")
	private Date fecha_salida;

	@Column(name = "HORA_SALIDA")
	private Date hora_salida;

	@Column(name = "FECHA_LLEGADA")
	private Date fecha_llegada;

	@Column(name = "HORA_LLEGADA")
	private Date hora_llegada;
	
	@Column(name = "ORIGEN")
	private String origen;

	@Column(name = "DESTINO")
	private String destino;
	
	@Column(name = "NUMERO_PLAZAS_TOTALES")
	private Integer numero_plazas_totales;	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vuelo")
	@JsonIgnore
	private Set<ReservaEntity> reserva;
	
}
