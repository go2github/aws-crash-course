package aws.crash.course.sqs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class Consumer {


    @SqsListener( "aws-crash-course-queue")
    public void processMessage(String message) {
        log.info("Message from SQS ************** {}", message);
    }
}
