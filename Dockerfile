# Start from the official Jenkins LTS image
FROM jenkins/jenkins:lts

# Switch to root to install tools
USER root

# Install Docker CLI and Git
RUN apt-get update && \
    apt-get install -y docker.io git && \
    apt-get clean