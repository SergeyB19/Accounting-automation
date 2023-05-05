package pro.sky.java.test.accountingautomation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.java.test.accountingautomation.model.Socks;

import java.util.Collection;
import java.util.HashMap;

@Service
public class SocksService {

    private final HashMap<Long, Socks> socks = new HashMap<>();
    private long quantity = 0;

    public Socks createSocks(Socks socks) {
        socks.setQuantity(quantity++);
        socks.put(quantity, socks);
        return socks;
    }

    public Socks findSocks(long quantity) {
        return socks.get(quantity);
    }

    public Socks editSocks(Socks socks) {
        if (socks.containsKey(socks.getQuantity())) {
            socks.put(socks.getQuantity(), socks);
            return socks;
        }
        return null;
    }

    public Socks deleteSocks(long quantity) {
        return socks.remove(quantity);
    }


    public <Collection<Socks>> getAllSocks() {
        return socks.values();
    }
}
