package co.simplon.airbus_shop;

import co.simplon.airbus_shop.dao.ProductRepository;
import co.simplon.airbus_shop.dao.UserRepository;
import co.simplon.airbus_shop.entities.Products;
import co.simplon.airbus_shop.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;



@SpringBootApplication
public class AirbusShopApplication implements CommandLineRunner  {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RepositoryRestConfiguration restConfigurationUser;
    public static void main(String[] args) {
        SpringApplication.run(AirbusShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Products.class);
        productRepository.save(new Products(null,"macboook pro",1200,5));
        productRepository.save(new Products(null,"bracelets",300,3));
        productRepository.save(new Products(null,"parfum",40,6));
        productRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });
        restConfigurationUser.exposeIdsFor(User.class);
        userRepository.save(new User(null,"admin","azerty","admin"));
        userRepository.save(new User(null,"julien","chedotal","user"));
        userRepository.save(new User(null,"franck","mbajoumbe","user"));
        userRepository.save((new User(null,"timothe","laude","user")));
        userRepository.findAll().forEach(u->{
            System.out.println(u.toString());
        });
    }
}
