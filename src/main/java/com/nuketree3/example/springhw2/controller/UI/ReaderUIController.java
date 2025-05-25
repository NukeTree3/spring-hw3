package com.nuketree3.example.springhw2.controller.UI;

import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ReaderUIController {

    private final ReaderService readerService;
    private final IssueService issueService;

    @GetMapping("/ui/readers")
    @Operation(summary = "get book ui information", description = "возвращает страницу со списком всех читателей")
    public String readers(Model model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return "readers";
    }

    @GetMapping("/ui/reader/{id}")
    @Operation(summary = "get reader issue ui", description = "возвращает страницу с информацией о всех выдачах книг у читателя с id")
    public String readerBooks(Model model, @PathVariable long id) {
        model.addAttribute("readerName", readerService.getReader(id).getName());
        model.addAttribute("readerBookHistory", issueService.getAllReaderNoReturnedBooks(id));
        return "reader";
    }
}
