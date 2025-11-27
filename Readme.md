# ClusteredData Warehouse

## Project Overview
**ClusteredData Warehouse** is a data warehouse application designed to help Bloomberg analyze FX deals. The system accepts FX deal details, validates them, and persists them in a database. It ensures no duplicate deals are imported and maintains all successfully imported data without rollback.

This project is implemented as a Maven-based Java application, fully containerized using Docker Compose for easy deployment.

---

## Features
- Accept FX deal details with the following fields:
    - Deal Unique Id
    - From Currency ISO Code ("Ordering Currency")
    - To Currency ISO Code
    - Deal Timestamp
    - Deal Amount in Ordering Currency
- Validate incoming request data:
    - Check for missing fields
    - Validate data types and formats
- Prevent duplicate imports
- Persist all valid deals in a database
- Proper error handling and logging
- Unit testing with coverage
- Docker Compose setup for database and application
- Makefile for streamlined execution

---

## Tech Stack
- **Language:** Java
- **FrameWork:** Spring
- **Build Tool:** Maven
- **Database:**  MySQL
- **Containerization:** Docker, Docker Compose
- **Testing:** JUnit, Mockito, JaCoCo
- **Logging:** SLF4J
- **Version Control:** GitHub

---

## Setup and Installation

### Prerequisites
- Docker & Docker Compose installed
- Maven installed
- Java 17 or above

### Running the Project

1. **Clone the repository:**
```bash
git clone https://github.com/Azzedine-zemmari/FxDeals.git
```

2. **Start the database and application using makeFile:**
```bash
make start-app
```
3. **To run test**
```bash
make test
```
## The endpoint to test the project 
http://localhost:8090/api/v1/deal
- Request fields : example
```json
{
    "id" : 1234567870270109,
    "fromCurrency" : "USD",
    "toCurrency" : "EUR",
    "amount" : 350,
    "timestamp": "2024-01-15T10:30:00" 
}
```
