package com.nuketree3.example.springhw2.controller.UI;

import com.nuketree3.example.springhw2.enums.Roles;
import com.nuketree3.example.springhw2.service.IssueService;
import com.nuketree3.example.springhw2.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@AllArgsConstructor
public class IssueUIController {

    private final IssueService issueService;
    private final ReaderService readerService;

    @GetMapping("/ui/issue")
    @Operation(summary = "get issue ui information", description = "возвращает страницу с информацией о конкретной записи")
    public String showIssue(Model model) {
        model.addAttribute("issues", issueService.getAllIssues());
        return "issues";
    }
}
