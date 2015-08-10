package com.activemq.queue.message;

import java.io.Serializable;

import com.activemq.queue.producer.State;

public interface Message extends Serializable {

	public String getId();

	public void setMessage(String message);

	public void setEstado(State enviado);
}

