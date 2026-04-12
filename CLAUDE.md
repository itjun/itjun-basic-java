# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a **Java learning and reference project** using Spring Boot 3.3.2 with Java 21. The codebase contains educational examples organized by topics, with most examples designed to run as standalone classes with a `main` method.

## Build Commands

```bash
# Build the project
./mvnw clean package

# Run the Spring Boot application
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a specific test class
./mvnw test -Dtest=MapTest

# Run a specific test method
./mvnw test -Dtest=AtomicIntegerTest#test_1
```

## Code Conventions

- **Logging**: Use `@Slf4j` annotation from Lombok. Log via `log.info()`, `log.debug()`, etc.
- **Console Output**: When `main` methods need console output, use `System.out.println()` instead of logging.
- **Chinese Comments**: Code comments are in Chinese as this is a learning project.

## Project Structure

- `src/main/java/io/itjun/basic/` - Main source code
  - `chap02`, `chap03`, etc. - Chapter-based Java basics examples
  - `core/dayXX` - Core Java topics organized by day (oop, exceptions, threads, etc.)
  - `cache/` - Caffeine cache performance tests
  - `base64/` - Base64 encoding/decoding utilities
  - `config/` - Spring configuration classes
  - `loadbalance/`, `queue/` - Additional topic examples with README files
- `src/test/java/io/itjun/basic/` - JUnit 5 test examples
  - `collection/` - Collections framework tests
  - `concurrent/atomic/` - java.util.concurrent.atomic examples
  - `lambda/future/` - CompletableFuture examples
  - `mongo/` - MongoDB integration examples
  - `thread/`, `thread/virtual/` - Threading and virtual thread examples
  - `json/gson/` - JSON serialization examples
  - `string/` - String manipulation tests

## Key Dependencies

- Spring Boot 3.3.2 (web, data-redis-reactive, devtools)
- Caffeine cache (3.2.2)
- Google ZXing (QR code generation/parsing)
- BoofCV (computer vision)
- Redisson, Jedis (Redis clients)
- MongoDB driver
- Lombok
- JUnit 5 (JUnit Jupiter)
