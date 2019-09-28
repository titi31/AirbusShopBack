package co.simplon.airbus_shop;

import co.simplon.airbus_shop.dao.CategoryRepository;
import co.simplon.airbus_shop.dao.ProductRepository;
import co.simplon.airbus_shop.dao.UserRepository;
import co.simplon.airbus_shop.entities.Category;
import co.simplon.airbus_shop.entities.Product;
import co.simplon.airbus_shop.entities.User;
import co.simplon.airbus_shop.service.AccountService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import co.simplon.airbus_shop.service.AccountService;
import co.simplon.airbus_shop.entities.AppRole;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Random;
import java.util.stream.Stream;


@SpringBootApplication
public class AirbusShopApplication implements  CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public static void main(String[] args) {
        SpringApplication.run(AirbusShopApplication.class, args);
    }

   @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class,Category.class,User.class);
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
                p.setPrice(100 + rnd.nextInt(10000));
                p.setQuantity(100 + rnd.nextInt(10000));
                p.setPhotoName("wordpress-categories-640x400 (1).png");
                productRepository.save(p);
            }
        });}
        @Bean
        CommandLineRunner start(AccountService accountService) {
            return args->{
                accountService.save(new AppRole(null,"USER"));
                accountService.save(new AppRole(null,"ADMIN"));
                Stream.of("user1","user2","user3","admin").forEach(un->{
                    accountService.saveUser(un,"1234","1234");
                });
                accountService.addRoleToUser("admin","ADMIN");
            };
        }
      /* @Bean
        BCryptPasswordEncoder getBCPE(){
            return new BCryptPasswordEncoder();
        }*/

    }
//}
