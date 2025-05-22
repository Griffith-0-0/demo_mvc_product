package org.example.demomvcproducts;

import org.example.demomvcproducts.entities.Product;
import org.example.demomvcproducts.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMvcProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMvcProductsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            // utiliser builder au lieu du constructeur avec args
            /*Product product= Product.builder()
                    .name("IPhone 6").price(1000).quantity(9)
                    .build();
            productRepository.save(product);
            productRepository.save(Product.builder().name("Galaxy S21").price(1500).quantity(5).build());
            productRepository.save(Product.builder().name("Nothing 2").price(1200).quantity(3).build());
            productRepository.save(Product.builder().name("Pixel 9").price(1220).quantity(4).build());
            productRepository.save(Product.builder().name("iPhone 16").price(1500).quantity(6).build());
            productRepository.findAll().forEach(System.out::println);*/

        };
    }

}
