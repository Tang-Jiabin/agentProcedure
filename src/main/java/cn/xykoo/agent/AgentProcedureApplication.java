package cn.xykoo.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author J.Tang
 */
@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "cn.xykoo.agent.repository")
@ComponentScan(basePackages = {"cn.xykoo"})
public class AgentProcedureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentProcedureApplication.class, args);
	}

}

