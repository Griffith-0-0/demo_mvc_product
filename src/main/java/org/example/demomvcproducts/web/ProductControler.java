package org.example.demomvcproducts.web;

import jakarta.validation.Valid;
import org.example.demomvcproducts.entities.Product;
import org.example.demomvcproducts.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


import java.util.List;
import java.util.Optional;

@Controller
public class ProductControler {
    private ProductRepository productRepository;

    public ProductControler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value="/")
    public String index(){
        return "redirect:/user/index";
    }

    @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public String chercher(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "mc", defaultValue = "") String motCle
                           ) {
        Page<Product> pageProducts = productRepository.chercherProduits(
                "%" + motCle + "%", PageRequest.of(page, size)
        );
                model.addAttribute("listProduits", pageProducts.getContent());
                model.addAttribute("mc", motCle);
                model.addAttribute("pageCourante", page);
                int[] pages = new int[pageProducts.getTotalPages()];
                for (int i = 0; i < pages.length; i++) {
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);
                return "products";
    }

    @RequestMapping(value = "/admin/form")
    @PreAuthorize("hasRole('ADMIN')")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "formProduit";
    }
//---------------
    @RequestMapping(value = "/admin/formModifier", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String formModifier(@RequestParam(name= "id") Long id, Model model) {
        Optional<Product> product=productRepository.findById(id);
        productRepository.deleteById(id);
        model.addAttribute("product", product);
        return "formModifier";
    }

    @RequestMapping(value = "/admin/modifierProduit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String modifier(Model model, @Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/formModifier";
        }
        model.addAttribute("product", product);
        return "confirmation";
    }
//---------------
    @RequestMapping(value = "/admin/saveProduit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String save(Model model, @Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/formProduit";
        }
        model.addAttribute("product", product);
        return "confirmation";
    }

    @RequestMapping(value = "/admin/confim", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String confirmation(Model model, Product product) {
        productRepository.save(product);
        model.addAttribute("product", product);
        return "redirect:/user/index";
    }

    @GetMapping("/admin/deleteProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam(name= "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized(){
        return "notAuthorized";
    }

}


