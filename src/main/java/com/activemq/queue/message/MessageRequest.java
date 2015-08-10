package com.activemq.queue.message;

import java.util.Date;

import com.activemq.queue.producer.State;

/**
 * El request del mensaje Modificarlo a su gusto si necesitan atributos
 * diferentes para enviar...
 *
 */
public class MessageRequest implements Message {

	private static final long serialVersionUID = -6266569415172611862L;
	private String id;
	private String message;
	private Date fechaCreacion;
	private Date fechaRespuesta;
	private State estado;
	private String infoAdicional;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public State getEstado() {
		return estado;
	}

	public void setEstado(State estado) {
		this.estado = estado;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	
}
