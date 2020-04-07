FROM golang 
#:onbuild

MAINTAINER mini-alem

RUN mkdir /ascii-docker

ADD . /ascii-docker
WORKDIR /ascii-docker/ascii-web
RUN go build main.go

CMD ["/ascii-docker/ascii-web/main"]
