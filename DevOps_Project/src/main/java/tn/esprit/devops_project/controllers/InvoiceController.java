package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.services.Iservices.IInvoiceService;

import java.util.Date;
import java.util.List;


@RestController
@AllArgsConstructor
public class InvoiceController {

    IInvoiceService invoiceService;

    @GetMapping("/invoice")
    public List<Invoice> getInvoices() {
       return invoiceService.retrieveAllInvoices();
    }

    @GetMapping("/invoice/{invoiceId}")
    public Invoice retrieveInvoice(@PathVariable Long invoiceId) {
        return invoiceService.retrieveInvoice(invoiceId);
    }

    @PutMapping("/invoice/{invoiceId}")
    public void cancelInvoice(@PathVariable Long invoiceId) {
        invoiceService.cancelInvoice(invoiceId);
    }

    @GetMapping("/invoice/supplier/{supplierId}")
    public List<Invoice> getInvoicesBySupplier(@PathVariable Long supplierId) {
        return invoiceService.getInvoicesBySupplier(supplierId);
    }

    @PutMapping(value = "/invoice/operator/{idOperator}/{idInvoice}")
    public void assignOperatorToInvoice(@PathVariable Long idOperator,@PathVariable Long idInvoice) {
        invoiceService.assignOperatorToInvoice(idOperator, idInvoice);
    }

    @GetMapping("/invoice/price/{startDate}/{endDate}")
    public float getTotalAmountInvoiceBetweenDates(@PathVariable Date startDate,@PathVariable Date endDate){
        return invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }


}
