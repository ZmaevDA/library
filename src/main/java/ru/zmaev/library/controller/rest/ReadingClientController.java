package ru.zmaev.library.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zmaev.library.model.dto.response.ReadingClientResponse;
import ru.zmaev.library.service.BookOrderService;

@RestController
@RequestMapping("/api/v1/reading-clients")
@RequiredArgsConstructor
public class ReadingClientController {

    private final BookOrderService bookOrderService;

    @GetMapping
    public ResponseEntity<Page<ReadingClientResponse>> getAllReadingClients(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(bookOrderService.findAllReading(pageNumber, pageSize));
    }
}
