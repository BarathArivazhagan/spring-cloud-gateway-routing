FROM node:18-buster-slim as builder

WORKDIR /app
COPY package.json .
RUN npm install
COPY src src
COPY public public
COPY tsconfig.json .
COPY webpack.config.ts .
RUN npm run build

FROM nginx:1.22.1
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=builder /app/build .
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]