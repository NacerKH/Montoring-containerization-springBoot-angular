# Start with the official Jenkins image
FROM jenkins/jenkins:lts

# Switch to root user to install Docker
USER root

# Update the package list and install Docker
RUN apt-get update && \
    apt-get install -y apt-transport-https ca-certificates curl gnupg2 software-properties-common && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" && \
    apt-get update && \
    apt-get install -y docker-ce-cli && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Create the Docker group and add the Jenkins user to it
RUN groupadd docker && usermod -aG docker jenkins

# Switch back to the Jenkins user
USER jenkins

# Expose Jenkins port
EXPOSE 8080

# Set the default Jenkins home directory
VOLUME /var/jenkins_home


