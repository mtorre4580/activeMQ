package com.activemq.test.cola;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.activemq.queue.message.MessageRequest;
import com.activemq.queue.producer.State;
import com.activemq.queue.sender.SenderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-producer-config.xml" })
public class PruebaActiveMQ {

	private static final Logger logger = LoggerFactory
			.getLogger(PruebaActiveMQ.class);
	
	@Autowired
	private SenderService senderService;
	
	@Test
	public void enviarMensajesAQueueMatias() {
		try {
			MessageRequest messageRequest=new MessageRequest();
			messageRequest.setEstado(State.CREADO);
			messageRequest.setFechaCreacion(new Date());
			messageRequest.setMessage("Se envia un mensaje a la cola de matias...");
			messageRequest.setInfoAdicional("pruebas");
			senderService.sendMessage(messageRequest);
		} catch (Exception e) {
			logger.error("Error en el test enviarRecibosAQueueSueldo: " + e);
		}
	}

	
}
