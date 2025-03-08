# mstack Example Application

Welcome to the example application for **mstack**, a flexible Java framework that allows developers to build applications that can run as either a monolith or microservices with the same codebase. This repository demonstrates how to use framework with a sample backend and a React Vite frontend.

## Framework Overview

**MyFramework** empowers developers to craft a single, robust codebase that seamlessly adapts to both **monolithic** and **microservices** architectures—without compromise. Engineered for modern distributed systems, this Java framework abstracts complexity and delivers cutting-edge features out of the box:

- **Dynamic Deployment**: Write once, deploy anywhere. Toggle between a tightly coupled monolith or a fully distributed microservices ecosystem with zero code changes, leveraging Maven profiles for build-time flexibility.
- **Service Orchestration**: Built-in **service discovery**, **load balancing**, and **intelligent routing** eliminate manual configuration. MyFramework ensures services locate and scale effortlessly, even under heavy load.
- **Versatile Connectivity**: Expose your backend to the world via **RSocket**, **HTTP**, or **WebSocket**. Whether it’s real-time streams, RESTful APIs, or reactive messaging, MyFramework supports it all with minimal overhead.
- **Persistent Powerhouse**: Our integrated persistence layer auto-generates optimized queries, slashing boilerplate code while unlocking advanced features like schema evolution, transaction management, and cross-service consistency.
- **Distributed Resilience**: A native **distributed service discovery** mechanism pairs with a **distributed event streaming** system to enable seamless inter-service communication—no bottlenecks, no single points of failure. Every component thrives in a decentralized microservices topology.
- **Fault Tolerance**: Designed with a "no single point of failure" philosophy, MyFramework distributes critical functions across nodes, ensuring high availability and uninterrupted operation.

With MyFramework, you’re not just building applications—you’re architecting scalable, resilient systems that adapt to your needs, from rapid prototyping to production-grade microservices.

## Prerequisites

- Java JDK 8
- Maven 3.8+
- Node.js 18+ and npm/yarn
- **Git**: To clone this repository


## Features

- **Architecture Flexibility**: Build once, deploy as monolith or microservices
- **Automatic Service Discovery**: Built-in distributed service discovery
- **Roubst Inter-services communication**: Build-in distributed event streams for microservice communication
- **React Vite UI**: Modern frontend included in the example
- **Single Configuration**: Consistent configuration approach for both deployment models
- **Minimal Dependencies**: Lightweight core with modular extensions


## Project Structure

```
example-app/
├── backend/
│   ├── lib/                 # Framework JAR files
|   ├── app/                 # Example application main project
│   ├── services/            # Service modules
│   │   ├── auth-service/    # Authentication service
│   │   ├── user-service/    # User management service 
│   │   └── ...
│   └── pom.xml              # Maven build file
├── frontend/
│   ├── src/                 # React Vite application
│   ├── package.json
│   └── vite.config.js
├── config/
│   ├── application.yml      # Common configuration
│   ├── monolith.yml         # Monolith-specific settings
│   └── microservices.yml    # Microservice-specific settings
└── scripts/
    ├── start-monolith.sh    # Script to start application as monolith
    └── start-services.sh    # Script to start as microservices
```

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/Chamith-Nimmitha/mstack-example.git
cd mstak-examples
```

### Building the Application

To build both the backend and frontend:

```bash
# Build backend
cd backend
mvn clean install

# Build frontend
cd ../frontend
npm install
npm run build
```

### Running as a Monolith

The monolith mode runs all services in a single JVM instance:

```bash
./scripts/start-monolith.sh
```

Or manually:

```bash
java -jar backend/target/example-app.jar
```

### Running as Microservices

The microservice mode runs each service in its own process:

```bash
# Start service registry first
java -jar backend/services/registry-service/target/registry-service.jar

# Then start other services
java -jar backend/services/auth-service/target/auth-service.jar
java -jar backend/services/user-service/target/user-service.jar
# ... start other services as needed
```

### Accessing the Application
- **Frontend Dev Server**: http://localhost:5173 (when running `npm run dev`)

## Framework Configuration

### Application Properties

The framework uses a unified configuration approach. Main settings are in `config/application.yml` with deployment-specific overrides.

```yaml
# Sample application.yml
framework:
  app-name: example-app
  version: 1.0.0
  
  # Service discovery settings
  discovery:
    enabled: true
    heartbeat-interval: 30s
```

### Application Properties

The framework uses a unified configuration approach. Main settings are in `config/application.yml` with deployment-specific overrides.

```yaml
# Sample application.yml
framework:
  app-name: example-app
  version: 1.0.0
  
  # Service discovery settings
  discovery:
    enabled: true
    heartbeat-interval: 30s
```

### Switching Deployment Models

To switch between monolith and microservice modes, set the appropriate profile:

```
# For monolith
java -jar app.jar --framework.deployment=monolith

# For microservices
java -jar app.jar --framework.deployment=microservice
```

## Framework JARs

The framework JARs are located in the `backend/lib` directory:

- `framework-core-1.0.0.jar` - Core framework functionality
- `framework-discovery-1.0.0.jar` - Service discovery module
- `framework-web-1.0.0.jar` - Web server components
- `framework-data-1.0.0.jar` - Data access layer

To use these JARs in another project, add them to your classpath or Maven dependencies.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
