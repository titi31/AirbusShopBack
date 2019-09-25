package co.simplon.airbus_shop;

import co.simplon.airbus_shop.dao.CategoryRepository;
import co.simplon.airbus_shop.dao.ProductRepository;
import co.simplon.airbus_shop.dao.UserRepository;
import co.simplon.airbus_shop.entities.Category;
import co.simplon.airbus_shop.entities.Product;
import co.simplon.airbus_shop.entities.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication
public class AirbusShopApplication implements CommandLineRunner  {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration restConfigurationUser;
    public static void main(String[] args) {
        SpringApplication.run(AirbusShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class);
       //categoryRepository.save(new Category(null,"computer",null,null ,null));
       categoryRepository.save( new Category(null,"jewelry",null,null,null ));
       categoryRepository.save( new Category(null,"perfumery",null,null,null ));
       categoryRepository.save(new Category(null,"computer",null,null,null ));
       Random rnd= new Random();
        categoryRepository.findAll().forEach(c -> {
            for(int i=0;i<10;i++) {
                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentprice(100 + rnd.nextInt(10000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);
            }
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
