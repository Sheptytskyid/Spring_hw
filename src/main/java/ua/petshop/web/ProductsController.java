package ua.petshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.petshop.model.Product;
import ua.petshop.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

    ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        productsService.addProduct(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public String updateBook(@ModelAttribute("product") Product product, @PathVariable long id) {
        productsService.updateProduct(product);
        return "redirect:/products/" + id;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView getProduct(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product" , productsService.getById(id));
        modelAndView.setViewName("productInfo");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productslist", productsService.getAll());
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
