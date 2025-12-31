# Pastebin-Lite

## Project Description
A Spring Boot application that allows users to create text pastes with optional time-based expiry (TTL) and view-count limits. This project was built as a technical assessment.

## Deployed URL
https://pastebin-5.onrender.com

## How to Run Locally
1. Ensure you have Java 17 and Maven installed.
2. Clone this repository: `git clone https://github.com/Shejalmal/[your-repo-name].git`
3. Run `mvn clean install`
4. Run `mvn spring-boot:run`
5. The app will be available at `http://localhost:8080`.

## Persistence Layer
I used **PostgreSQL** hosted on Render. This choice ensures that data survives application restarts in a serverless environment and provides robust support for managing paste metadata and constraints.

## Design Decisions
- **Test Mode Implementation:** The application checks for the `TEST_MODE=1` environment variable. When active, it respects the `x-test-now-ms` header to allow for deterministic testing of expiration logic.
- **Safety:** Paste content is stored and served such that no script execution can occur (rendered safely in HTML).
- **Dockerization:** A multi-stage Dockerfile is used to keep the final image lightweight and secure.
