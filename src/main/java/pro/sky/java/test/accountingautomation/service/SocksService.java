package pro.sky.java.test.accountingautomation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.java.test.accountingautomation.model.Socks;
import pro.sky.java.test.accountingautomation.repository.SocksRepository;

import java.util.Collection;
import java.util.HashMap;

@Service
public class SocksService {

    private SocksRepository socksRepository;

    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public Socks createSocks(Socks socks) {
        return socksRepository.save(socks);
    }

    public Socks findSocks(long quantity) {
        return socksRepository.findById(quantity).get();
    }

    public Socks editSocks(Socks socks) {
        return socksRepository.save(socks);
    }

    public void deleteSocks(long quantity) {
        socksRepository.deleteById(quantity);
    }


    public <Collection<Socks>> getAllSocks() {
        return socks.values();
    }
}
