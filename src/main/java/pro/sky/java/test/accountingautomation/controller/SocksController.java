package pro.sky.java.test.accountingautomation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.test.accountingautomation.model.Socks;
import pro.sky.java.test.accountingautomation.repository.SocksRepository;
import pro.sky.java.test.accountingautomation.service.SocksService;

import java.util.Collection;

@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;
    private final SocksRepository socksRepository;

    public SocksController(SocksService socksService,
                           SocksRepository socksRepository) {
        this.socksService = socksService;
        this.socksRepository = socksRepository;
    }

    @GetMapping(path = "{quantity}")
    public ResponseEntity<Socks> getSocksInfo(@PathVariable Long quantity) {
        Socks socks = socksService.findSocks(quantity);
        if (socks == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(socks);
    }

    @GetMapping
    public <Collection<Socks>> getAllSocks() {
        return socksRepository.findAll();
    }

    @PostMapping
    public Socks createSocks(@RequestBody Socks socks) {
        return socksService.createSocks(socks);
    }

    @PutMapping
    public ResponseEntity<Socks> editSocks(@RequestBody Socks socks) {
        Socks foundSocks = socksService.editSocks(socks);
        if (foundSocks == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundSocks);
    }

    @DeleteMapping(path = "{quantity}")
    public ResponseEntity deleteSocks(@PathVariable Long quantity) {
        socksService.deleteSocks(quantity);
        return ResponseEntity.ok().build();
    }
}
