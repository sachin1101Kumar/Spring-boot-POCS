package com.rabbitmq.publisher;


import com.rabbitmq.publisher.beans.SimpleMessage;
import org.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqPublisherApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	/*@Value(${rabbitmq.exchange.name})

	private String exchangeName;

	@Value(${rabbitmq.exchange.name})
	private String exchangeName;*/
	@Autowired
	private AmqpTemplate amqpTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String exchangeName="header-exchange";
		String departmentName="finance";
		/* Demo how we can deliver the message to Direct queue */
		//String name="Hello Rabbit MQ";
		SimpleMessage simpleMessage=new SimpleMessage();
		simpleMessage.setName("simpleMessage");
		simpleMessage.setDescription("simpleDescription");

		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name","Ankit Kumar");
		jsonObject.put("age","27");
		jsonObject.put("Interest","Data Analyst");


		//rabbitTemplate.convertAndSend("newTopicExchange","topic",simpleMessage);
		/*publishing messages to Direct exchange*/
		//rabbitTemplate.convertAndSend("NewFanoutExchange","ac",jsonObject.toString().getBytes());

		/*publishing messages to fanout exchange*/
		//rabbitTemplate.convertAndSend("fanout exchange","",jsonObject.toString().getBytes());

		/*publishing messages to topic exchange*/
		//rabbitTemplate.convertAndSend("newTopicExchange","*.ac.*",jsonObject.toString().getBytes());
		//rabbitTemplate.convertAndSend("newTopicExchange","#.ac",jsonObject.toString().getBytes());
		//the below routing key will also match with #.ac routing
		//rabbitTemplate.convertAndSend("newTopicExchange","my.good.ac",jsonObject.toString().getBytes());

		/*Sending the data to the header's exchange*/
		/*As in case of headers exchange we deal with headers not routing keys*/
		/*ConnectionFactory connectionFactory=new ConnectionFactory();
		Connection connection=connectionFactory.newConnection();
		Channel channel=connection.createChannel();

		Map<String,Object> headersMap=new HashMap<>();
		headersMap.put("item2","tv");



		AMQP.BasicProperties basicProperties=new AMQP.BasicProperties();
		basicProperties.builder().headers(headersMap).build();

		channel.basicPublish("DigitalHeadersExchange","mobile",basicProperties,jsonObject.toString().getBytes());
*/
//		rabbitTemplate.convertAndSend("Headers-Exchange","",basicProperties,jsonObject.toString().getBytes());

		// Sending the data to the headers exchange using amqp template
		/*MessageProperties messageProperties=new MessageProperties();
		messageProperties.setHeader("department","marketing");

		MessageConverter messageConverter=new SimpleMessageConverter();
		Message message=messageConverter.toMessage("Hey there this is a message",messageProperties);

		amqpTemplate.send(exchangeName,"",message);*/

		/*Lets send the data using Rabbittemplate itself to headers exchange*/
		MessageProperties messageProperties=new MessageProperties();
		messageProperties.setHeader("department","marketing");

		MessageConverter messageConverter=new SimpleMessageConverter();

		Message message=messageConverter.toMessage(simpleMessage,messageProperties);

		rabbitTemplate.send(exchangeName,"",message);
	}

}
