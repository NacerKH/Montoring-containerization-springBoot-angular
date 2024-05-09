
# Dockerization of Spring Boot and Angular Project 🐳

This repository contains a Dockerized setup for a Spring Boot backend and Angular frontend project.

## Application Structure 📁

The application consists of two main folders:

1. **app/backend**: Contains the Spring Boot backend code.
2. **app/frontend**: Contains the Angular frontend code.

## Infrastructure Setup 🛠️

The `infrastructure` folder contains Docker Compose file with services like Jenkins, Grafana, and Prometheus.

### Jenkins 🛠️

- **Image:** jenkins/jenkins:lts
- **Container Name:** jenkins
- **Ports:**
  - 8080: Jenkins UI
  - 50000: Jenkins agent port
- **Volumes:**
  - ./jenkins_home:/var/jenkins_home
- **Networks:** backend-network
- **Notes:**
  - Jenkins is accessible at [http://localhost:8080](http://localhost:8080)
  - Jenkins home directory is persisted at `./jenkins_home`

### Grafana 📊

- **Image:** grafana/grafana
- **Container Name:** grafana
- **Ports:**
  - 3000: Grafana UI
  - 9090: Prometheus data source
- **Volumes:**
  - ./grafana:/var/lib/grafana
- **Networks:** backend-network
- **Notes:**
  - Grafana is accessible at [http://localhost:3000](http://localhost:3000)

### Prometheus 📈

- **Image:** prom/prometheus
- **Container Name:** prometheus
- **Ports:**
  - 8090: Prometheus UI
- **Volumes:**
  - ./prometheus:/etc/prometheus
  - ./prometheus/data:/prometheus
- **Networks:** backend-network
- **Notes:**
  - Prometheus is accessible at [http://localhost:8090](http://localhost:8090)

## Usage 🚀

1. **Application Setup**:

   - Navigate to the `app` directory.
   - Place your Spring Boot backend code in the `backend` folder and Angular frontend code in the `frontend` folder.
   - Ensure your backend application is configured to connect to the MySQL database using the correct credentials.
2. **Infrastructure Setup**:

   - Navigate to the `infrastructure` directory.
   - Run `docker-compose up -d` to start the infrastructure services.
3. **Running the Application**:

   - Navigate to the `app` directory.
   - Run `docker-compose up -d` to start the backend, frontend, and database services.
4. **Access your services**:

   - Backend: [http://localhost:8080](http://localhost:8080)
   - Frontend: [http://localhost:4200](http://localhost:4200)
   - Grafana: [http://localhost:3000](http://localhost:3000)
   - Prometheus: [http://localhost:8090](http://localhost:8090)
   - Jenkins: [http://localhost:8080](http://localhost:8080)

## Notes 📝

- Ensure Docker is installed and running on your system.
- Modify Dockerfiles and configuration files according to your project requirements.
