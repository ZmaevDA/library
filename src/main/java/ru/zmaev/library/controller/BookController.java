package ru.zmaev.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zmaev.library.model.dto.request.BookRequest;
import ru.zmaev.library.model.dto.response.BookResponse;
import ru.zmaev.library.service.BookService;

import java.util.UUID;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {
        Page<BookResponse> books = bookService.findAll(pageNumber, pageSize);
        model.addAttribute("books", books.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPages", books.getTotalPages());
        return "books/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bookRequest", new BookRequest());
        return "books/create";
    }

    @PostMapping
    public String createBook(@ModelAttribute BookRequest bookRequest) {
        bookService.save(bookRequest);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable UUID id, Model model) {
        BookResponse book = bookService.findById(id);
        model.addAttribute("bookRequest", book);
        return "books/edit";
    }

    @PostMapping("/{id}")
    public String updateBook(
            @PathVariable UUID id,
            @ModelAttribute BookRequest bookRequest) {
        bookService.update(id, bookRequest);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable UUID id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
