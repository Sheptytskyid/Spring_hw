package ua.petshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.petshop.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

    ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", productsService.getById(1L));
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
