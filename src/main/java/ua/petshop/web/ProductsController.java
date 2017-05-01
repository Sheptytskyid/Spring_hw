package ua.petshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.petshop.model.Product;
import ua.petshop.service.ProductsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {

    ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product") @Valid Product product, Errors errors) {
        if (!errors.hasErrors()) {
            productsService.addProduct(product);
        }
        ModelAndView model = new ModelAndView("redirect:/products");
        return model;
    }

    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deleteProduct(@PathVariable long id) {
        productsService.deleteProduct(id);
        ModelAndView model = new ModelAndView("redirect:/products");
        return model;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute("product") Product product, @PathVariable long id) {
        productsService.updateProduct(product);
        ModelAndView model = new ModelAndView("redirect:/products/" + id);
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
