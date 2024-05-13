# PrimeGenerator

PrimeGenerator is a Java application built using Spring Boot that generates prime numbers within a given range using different strategies.

## Getting Started

These instructions will help you set up and run the PrimeGenerator project on your local machine.

### Prerequisites

- Java 17 or higher
- Maven
- Git
- Your preferred IDE (e.g., IntelliJ IDEA, Eclipse)

### Installing

1. Clone the repository:
```
git clone https://github.com/shru-239/PrimeNumGenerator.git
```

2. Open the project in your IDE.

3. Build the project using Maven:
```
mvn clean install
```

## Running the Application

You can run the application using Maven:
```
mvn spring-boot:run
```

Alternatively, you can run it as a standalone JAR file:
```
java -jar target/prime-generator.jar
```

## Usage

Once the application is running, you can access the prime number generation API using the following endpoints:

- GET /api/prime/generate: Generates prime numbers within a given range.
  - Parameters:
    - startRange: Start of the range (inclusive)
    - endRange: End of the range (inclusive)
    - strategy (optional): Strategy for prime number generation (brute, sieve, trial)
- POST /api/prime/generate: Generates prime numbers within a given range and stores the result in the database.
  - Request Body: PrimeEntity object with startRange, endRange, and strategy fields

## PrimeGenerator Strategies

The PrimeGenerator supports three strategies for generating prime numbers:

- *Brute Force*: Checks each number in the range for primality by dividing it by all numbers up to its square root.
- *Sieve of Eratosthenes*: Marks multiples of each prime number as non-prime, leaving only the prime numbers.
- *Trial Division*: Checks each number in the range for primality by dividing it by all numbers up to its square root.

## Database Storage

The application stores the prime number generation results in a MySQL database. The PrimeEntity class represents the data stored in the database, including the start range, end range, strategy used, number of primes generated, and timestamp.

## Contributing

Contributions are welcome! Please submit a pull request if you would like to contribute to this project
