package org.example.demomvcproducts.repository;

import org.example.demomvcproducts.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// avec JpaRepository la class qui implements l'interface est creer auto et contient les methodes classiques
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByName(String name);

    @Query("select  p from Product  p where p.name like :x")
    public Page<Product> chercherProduits(@Param("x") String name, Pageable pageable);
}
