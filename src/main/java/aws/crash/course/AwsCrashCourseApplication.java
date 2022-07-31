package aws.crash.course;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
public class AwsCrashCourseApplication implements InitializingBean, DisposableBean {
    @Value("${AWSAccessKeyId}")
    private String accesskey;
    @Value("${AWSSecretKey}")
    private String secretKey;


    public static void main(String[] args) {
        SpringApplication.run(AwsCrashCourseApplication.class, args);

    }

    @GetMapping("/welcome")
    private ResponseEntity<String> welcome() {
        return ResponseEntity.status(HttpStatus.OK).body("Aws crash course tutorial");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
