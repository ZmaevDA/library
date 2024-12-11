package ru.zmaev.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zmaev.library.model.dto.request.ClientRequest;
import ru.zmaev.library.model.dto.response.ClientResponse;
import ru.zmaev.library.service.ClientService;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String findAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            Model model) {
        Page<ClientResponse> clients = clientService.findAll(pageNumber, pageSize);
        model.addAttribute("clients", clients.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPages", clients.getTotalPages());
        return "clients/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("clientRequest", new ClientRequest());
        return "clients/create";
    }

    @PostMapping
    public String createClient(@ModelAttribute("clientRequest") ClientRequest clientRequest) {
        clientService.save(clientRequest);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable UUID id, Model model) {
        ClientResponse client = clientService.findById(id);
        model.addAttribute("clientRequest", client);
        return "clients/edit";
    }

    @PostMapping("/{id}")
    public String updateClient(
            @PathVariable UUID id,
            @ModelAttribute ClientRequest clientRequest) {
        clientService.update(id, clientRequest);
        return "redirect:/clients";
    }

    @PostMapping("/{id}/delete")
    public String deleteClient(@PathVariable UUID id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}


