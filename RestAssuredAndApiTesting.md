# REST Assured API Testing

## 📌 Project Overview

This project contains automated API tests using **REST Assured** and **TestNG**.

The project currently covers basic GET and POST API testing, including response status and response body validation.

## 🛠️ Tech Stack

- Java
- REST Assured
- TestNG
- Maven
- Hamcrest

## 🧪 Test Scenarios

### GET API

**Endpoint:** `/api/users/2`

- Verify response status code is `200`
- Verify user first name is `Janet`
- Verify user ID is `2`

### POST API

**Endpoint:** `/api/users`

- Create a new user
- Verify response status code is `201`
- Verify returned name
- Verify returned job

### PUT API

**Endpoint:** `/api/users`

- Update user
- Verify response status code is `201`
- Verify returned name
- Verify returned job

### DELETE API

**Endpoint:** `/api/users`

- Delete user
- Verify response status code is `204`

## 📂 Project Structure

```text
src
└── test
    └── java
        └── api
            └── ReqresApiTest.java
```

## ▶️ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Maven dependencies are downloaded.
4. Run `ReqresApiTest.java` using TestNG.

## 📊 Current Coverage

- GET request validation
- POST request validation
- PUT request validation
- DELETE request validation
- HTTP status code validation
- JSON response body validation
- Request body handling