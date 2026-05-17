# Wikimedia Streaming Microservices

A real-time event streaming system built with Java, Spring Boot, and Apache Kafka using the Wikimedia Recent Changes Stream.

This project demonstrates an event-driven microservices architecture where live Wikimedia events are consumed from an external streaming API, published to Kafka, and asynchronously processed by downstream services.

---

## Architecture

```text
Wikimedia Stream API
        ↓
Producer Service
(Spring Boot + Kafka Producer)
        ↓
Apache Kafka Topic
        ↓
Consumer Service
(Spring Boot + Kafka Consumer)
        ↓
PostgreSQL Database
```

---

## Microservices

### 1. Producer Service

The producer service connects to the Wikimedia Recent Changes Stream and continuously consumes live event data.

Responsibilities:

- Connect to Wikimedia SSE stream
- Consume live event updates
- Publish events to Kafka topics
- Handle asynchronous streaming operations

Technologies:

- Java
- Spring Boot
- Spring Kafka
- WebClient / EventSource
- Apache Kafka

---

### 2. Consumer Service

The consumer service subscribes to Kafka topics, processes incoming events, and persists them into the database.

Responsibilities:

- Subscribe to Kafka topics
- Consume streaming events
- Deserialize event payloads
- Persist data into PostgreSQL
- Handle event-driven processing

Technologies:

- Java
- Spring Boot
- Spring Kafka
- Spring Data JPA
- PostgreSQL

---

## Features

- Real-time event streaming
- Event-driven microservices architecture
- Apache Kafka integration
- Asynchronous message processing
- Producer and consumer separation
- Database persistence
- Scalable service design
- Loose coupling between services

---

## Tech Stack

| Technology        | Purpose                  |
|-------------------|--------------------------|
| Java              | Backend development      |
| Spring Boot       | Microservice framework   |
| Apache Kafka      | Event streaming platform |
| Spring Kafka      | Kafka integration        |
| PostgreSQL        | Data persistence         |
| Maven             | Dependency management    | 

---

## Project Structure

```text
wikimedia-microservices/
│
├── wikimedia-producer/
│   ├── controller/
│   ├── service/
│   ├── config/
│   └── producer/
│
├── wikimedia-consumer/
│   ├── consumer/
│   ├── entity/
│   ├── repository/
│   ├── service/
│   └── config/
│
└── pom.xml
```

---

## Kafka Flow

1. Producer connects to the Wikimedia streaming endpoint.
2. Streaming events are received continuously.
3. Events are published to a Kafka topic.
4. Consumer service subscribes to the topic.
5. Consumer processes and stores the data in PostgreSQL.

---

## Kafka Topic Example

```text
wikimedia_recentchange
```

---

## Database

The consumer service persists streaming data into PostgreSQL.

Stroed fields:
- id (long, auto-generated)
- wiki_event_data 
Annotate with @lob

---

## Getting Started

### Prerequisites

Ensure the following are installed:

- Java 21+
- Maven
- Apache Kafka
- PostgreSQL

---

## Clone the Project

```bash
git clone <repository-url>
cd wikimedia-microservices
```

---

## Build the Project

```bash
mvn clean install
```

Skip tests:

```bash
mvn clean install -DskipTests
```

---

## Run Producer Service

```bash
cd Wikimedia-Producer
mvn spring-boot:run
```

---

## Run Consumer Service

```bash
cd Wikimedia-Consumer
mvn spring-boot:run
```

---

## Configuration

Example Kafka configuration:

```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
```

Example PostgreSQL configuration:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/wikimedia_db
    username: postgres
    password: password
```

---

## Learning Objectives

This project demonstrates:

- Microservices communication
- Event-driven systems
- Distributed messaging with Kafka
- Real-time stream processing
- Asynchronous architectures
- Database persistence workflows
- Decoupled service design

---

## Future Improvements

Potential enhancements:

- Docker Compose support
- Kafka Connect integration
- Monitoring with Prometheus and Grafana
- Distributed tracing
- Retry and dead-letter queues
- Elasticsearch integration
- Kubernetes deployment
- Authentication and authorization
- Stream analytics

---

## License

This project is open-source and available under the MIT License.
