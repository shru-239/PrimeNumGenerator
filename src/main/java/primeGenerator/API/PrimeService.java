package primeGenerator.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import primegenerator.PrimeGenerator;

import java.util.List;

@Service
public class PrimeService {

    private final PrimeRepository primeRepository;

    @Autowired
    public PrimeService(PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }

    public List<Integer> generatePrimes(int startRange, int endRange, String strategy) {
        // Implement logic to generate prime numbers using the chosen strategy
        PrimeGenerator primeGenerator = new PrimeGenerator(startRange, endRange);
        return primeGenerator.generate(strategy);
    }

    public void saveResult(PrimeEntity primeEntity) {
        primeRepository.save(primeEntity);
    }
}

