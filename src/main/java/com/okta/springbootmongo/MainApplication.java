package com.okta.springbootmongo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class MainApplication {
  public static void main(String[] args) { SpringApplication.run(MainApplication.class, args);  }

  @Bean
  ApplicationRunner init(MusicRepository repository) {

    Object[][] data = {
            {"True Believer", "Widowspeak", 1, true},
            {"The Power of Equality", "Red Hot Chilli Peppers", 2, true},
            {"Lonely Day", "System of a Down", 3, false}
    };

    return args -> {
      repository
              .deleteAll()
              .thenMany(
                      Flux.just(data)
                              .map(array -> {
                                return new Music((String) array[0], (String) array[1], (Number) array[2], (Boolean) array[3]);
                              })
                              .flatMap(repository::save)
              )
              .thenMany(repository.findAll())
              .subscribe(kayak -> System.out.println("saving " + kayak.toString()));
    };
  }
}


