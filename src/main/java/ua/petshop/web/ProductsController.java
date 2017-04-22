package ua.petshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String addProduct(Product product) {
        if (product.getId() == 0) {
            productsService.addProduct(product);
        } else {
            productsService.updateProduct(product);
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView updateBook(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productsService.getById(id));
        modelAndView.addObject("productsList", productsService.getAll());
        modelAndView.setViewName("products");
        return modelAndView;
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
