package es.uclm.library.business.entity;

import java.sql.Date;


public class Disponibilidad {

	Inmueble inmueble;
	PoliticaCancelacion politicaCancelación;
	private Date fechaInicio;
	private Date fechaFin;
	private double precio;
	private boolean directa;

}