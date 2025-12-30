package com.pastebin.demo.controller;

import com.pastebin.demo.model.Paste;
import com.pastebin.demo.repository.PasteRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ViewController {

    @Autowired
    private PasteRepository repository;

    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/p/{id}")
    public String viewPaste(@PathVariable String id, Model model, HttpServletRequest request) {
        Paste paste = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // REQUIREMENT: Must return 404 if expired
        if (PasteApiController.isExpired(paste, request)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paste Expired");
        }

        paste.setViewCount(paste.getViewCount() + 1);
        repository.save(paste);

        model.addAttribute("paste", paste);
        return "view";
    }
}