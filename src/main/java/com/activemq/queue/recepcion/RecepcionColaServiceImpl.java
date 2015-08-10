package com.activemq.queue.recepcion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.activemq.queue.listener.ListenerService;
import com.activemq.queue.listener.ListenerServiceQueueBaseImpl;

public class RecepcionColaServiceImpl extends ListenerServiceQueueBaseImpl
		implements ListenerService {

	private Logger logger = LoggerFactory
			.getLogger(RecepcionColaServiceImpl.class);

	public void receiveMessageFromQueue(String executionId, String message,
			String infoAdicional) {

		logger.info("Se reciben los mensajes enviados...");

		logger.info("Mensaje recibido: " + message + "Informacion adicional: "
				+ infoAdicional);
	}

}
