package co.simplon.airbus_shop.web;

import co.simplon.airbus_shop.dao.ProductRepository;
import co.simplon.airbus_shop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class CatalogueRestController {
   // @Autowired
    private ProductRepository productRepository;
    public CatalogueRestController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Picture/Products/"+p.getPhotoName()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        p.setPhotoName(id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/Picture/Products/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);
    }
}
