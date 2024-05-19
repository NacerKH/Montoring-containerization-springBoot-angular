### STAGE 1: Build ###
FROM node:16.18.1-alpine as build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build
# Debugging step: Verify the contents of the build output directory
RUN ls -la /usr/src/app/dist/frontend
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY docker/nginx/sites.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/frontend /usr/share/nginx/html
