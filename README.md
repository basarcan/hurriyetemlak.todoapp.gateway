# hurriyetemlak.todoapp.gateway

This is a todo app task for Hurriyet Emlak and it is a gateway for microservices

## Installation

First you need to pull docker image

```bash
docker pull cavitcanbasar/hurriyetemlak.userapi:latest
```

and than run but before that make sure other micro services are on

```bash
docker run -i -t -p 8080:80 cavitcanbasar/hurriyetemlak.gateway
```



## Usage

You can view all the controllers from swagger

