package primeGenerator.API;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.time.LocalDateTime;

//import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrimeEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
//        @CreationTimestamp
	    private LocalDateTime timestamp;
	    private int startRange;
	    private int endRange;
	    private String strategy;
	    private int numberOfPrimes;

	    // Constructors, getters, and setters

	    public PrimeEntity() {
	        this.timestamp = LocalDateTime.now();
	    }

	    public PrimeEntity(int startRange, int endRange, String strategy, int numberOfPrimes) {
	        this.timestamp = LocalDateTime.now();
	        this.startRange = startRange;
	        this.endRange = endRange;
	        this.strategy = strategy;
	        this.numberOfPrimes = numberOfPrimes;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(LocalDateTime timestamp) {
	        this.timestamp = timestamp;
	    }

	    public int getStartRange() {
	        return startRange;
	    }

	    public void setStartRange(int startRange) {
	        this.startRange = startRange;
	    }

	    public int getEndRange() {
	        return endRange;
	    }

	    public void setEndRange(int endRange) {
	        this.endRange = endRange;
	    }

	    public String getStrategy() {
	        return strategy;
	    }

	    public void setStrategy(String strategy) {
	        this.strategy = strategy;
	    }

	    public int getNumberOfPrimes() {
	        return numberOfPrimes;
	    }

	    public void setNumberOfPrimes(int numberOfPrimes) {
	        this.numberOfPrimes = numberOfPrimes;
	    }
	}


