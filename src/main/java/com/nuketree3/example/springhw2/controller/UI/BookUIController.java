package com.nuketree3.example.springhw2.controller.UI;

import com.nuketree3.example.springhw2.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BookUIController {

    private final BookService bookService;

    @GetMapping("/ui/books")
    @Operation(summary = "get book ui information", description = "возвращает страницу со всей информацией по книге с данным id")
    public String books(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
