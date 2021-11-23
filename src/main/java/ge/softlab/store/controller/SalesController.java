package ge.softlab.store.controller;

import ge.softlab.store.model.Sales;
import ge.softlab.store.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController {
    SalesService salesService;
    @Autowired
    SalesController(SalesService salesServiceImpl){
        this.salesService = salesServiceImpl;
    }
    @GetMapping("{date}")
    public List<Sales> get(@PathVariable LocalDateTime date){


        return salesService.getByDate(date);

    }
}
