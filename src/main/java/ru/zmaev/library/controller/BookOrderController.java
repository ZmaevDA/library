package ru.zmaev.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zmaev.library.model.dto.response.BookResponse;
import ru.zmaev.library.model.dto.response.ClientResponse;
import ru.zmaev.library.service.BookOrderService;
import ru.zmaev.library.service.BookService;
import ru.zmaev.library.service.ClientService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class BookOrderController {

    private final BookOrderService bookOrderService;
    private final BookService bookService;
    private final ClientService clientService;

    @GetMapping("/create")
    public String showCreateOrderForm(@RequestParam(defaultValue = "0") int bookPageNumber,
                                      @RequestParam(defaultValue = "0") int clientPageNumber,
                                      @RequestParam(defaultValue = "10") int pageSize,
                                      Model model) {

        Page<BookResponse> books = bookService.findAll(bookPageNumber, pageSize);
        Page<ClientResponse> clients = clientService.findAll(clientPageNumber, pageSize);

        model.addAttribute("books", books);
        model.addAttribute("clients", clients);
        model.addAttribute("bookPageNumber", bookPageNumber);
        model.addAttribute("clientPageNumber", clientPageNumber);
        model.addAttribute("pageSize", pageSize);
        return "orders/create";
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam("bookId") UUID bookId, @RequestParam("clientId") UUID clientId) {
        bookOrderService.assignBookToClient(bookId, clientId);
        return "redirect:/orders/create";
    }
}




