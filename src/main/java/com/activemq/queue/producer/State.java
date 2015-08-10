package com.activemq.queue.producer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class State implements Serializable {

	private static final long serialVersionUID = 1625411572808873641L;
	private String name;
	public static final State CREADO = new State("CREADO");
	public static final State ENVIADO = new State("ENVIADO");
	public static final State RESPONDIDO = new State("RESPONDIDO");
	public static final State ERROR = new State("ERROR");
	public static final State EXITOSO = new State("EXITOSO");
	@SuppressWarnings("rawtypes")
	private static final Map INSTANCES = new HashMap();

	static {
		INSTANCES.put(CREADO.toString(), CREADO);
		INSTANCES.put(ENVIADO.toString(), ENVIADO);
		INSTANCES.put(RESPONDIDO.toString(), RESPONDIDO);
		INSTANCES.put(ERROR.toString(), ERROR);
		INSTANCES.put(EXITOSO.toString(), EXITOSO);
	}

	private State(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	private Object readResolve() {
		return getInstance(name);
	}

	public static State getInstance(String name) {
		return (State) INSTANCES.get(name);
	}
}
