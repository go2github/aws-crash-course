package aws.crash.course.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class Publisher {
    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;
    @Value("${sqs.uri}")
    String endpoint;

    public void sendMessageToSQS(String message){
        log.info("sqs message "+message);
        queueMessagingTemplate.convertAndSend(endpoint,message);
    }
    @PostConstruct
    void init(){
        sendMessageToSQS("test message t");
    }
}
