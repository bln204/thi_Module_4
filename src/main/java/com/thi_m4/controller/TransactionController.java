package com.thi_m4.controller;


import com.thi_m4.model.Transaction;
import com.thi_m4.repository.CustomerRepository;
import com.thi_m4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String listTransaction(Model model){
        List<Transaction> list = transactionService.findAll();
        model.addAttribute("transactions", list);
        return "transaction/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("customer", customerRepository.findAll());
        return "transaction/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Transaction transaction){
        transactionService.save(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model){
        Transaction transaction = transactionService.findById(id).orElse(null);
        if(transaction == null){
            return "error/404";
        }
        model.addAttribute("transaction", transaction);
        return "transaction/detail";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        transactionService.deleteById(id);
        return "redirect:/transaction";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String customerName,
                         @RequestParam(defaultValue = "") String type,
                         Model model){
        List<Transaction> result = transactionService.search(customerName, type);
        model.addAttribute("transactions", result);
        return "transaction/list";
    }

}



