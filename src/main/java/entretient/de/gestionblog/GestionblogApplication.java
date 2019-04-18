package entretient.de.gestionblog;

import entretient.de.gestionblog.entites.AppRole;
import entretient.de.gestionblog.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class GestionblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionblogApplication.class, args);
    }
     /* @Bean
      CommandLineRunner start(AccountService accountService){
        return args->{
         //  accountService.save(new AppRole("USER"));
         // accountService.save(new AppRole("REDUCTEUR"));
            Stream.of("user1").forEach(un->{
                accountService.saveUser("mmm","mmm","user1","1234","1234");
            });
            accountService.addRoleToUser("user1","USER");
      };
   }*/
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}
