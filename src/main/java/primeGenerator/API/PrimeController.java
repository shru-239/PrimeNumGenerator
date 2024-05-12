package primeGenerator.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prime")
public class PrimeController {

    private final PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> generatePrimes(
            @RequestParam int startRange,
            @RequestParam int endRange,
            @RequestParam(required = false, defaultValue = "brute") String strategy
    ) {
        List<Integer> primes = primeService.generatePrimes(startRange, endRange, strategy);
       // saveExecutionResult(startRange, endRange, strategy, primes.size());
        return new ResponseEntity<>(primes, HttpStatus.OK);
     }

    @PostMapping("/generate")
   
    public ResponseEntity<List<Integer>> generatePrimes(
            @RequestBody PrimeEntity request
    ) {
        List<Integer> primes = primeService.generatePrimes(request.getStartRange(), request.getEndRange(), request.getStrategy());
        
        // Store the prime generation result in the database
        PrimeEntity result = new PrimeEntity();
       
        result.setStartRange(request.getStartRange());
        result.setEndRange(request.getEndRange());
        result.setNumberOfPrimes(primes.size());
        result.setStrategy(request.getStrategy());
        result.setTimestamp(LocalDateTime.now());
        
       
        primeService.saveResult(result);
        
        return ResponseEntity.ok(primes);
    }

}

