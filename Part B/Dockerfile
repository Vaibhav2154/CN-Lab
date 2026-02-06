FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    ns2 \
    nam \
    x11-apps \
    tk \
    tcl \
    vim \
    && apt-get clean

WORKDIR /workspace

CMD ["/bin/bash"]