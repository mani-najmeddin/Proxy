# SimpleProxy

A lightweight multithreaded TCP proxy server written in Java.

## Features

- TCP traffic relay
- Multithreaded client handling
- Pure Java implementation
- Simple socket-based architecture
- Easy to modify and extend

---

## Requirements

- Java 8 or newer

Check Java version:

```bash
java -version
```

---

## Compile

```bash
javac SimpleProxy.java
```

---

## Run

```bash
java SimpleProxy
```

Server output:

```text
Proxy running on port 1080
```

---

## Project Structure

```text
SimpleProxy.java
README.md
```

---

## How It Works

1. The proxy listens on port `1080`
2. A client connects to the server
3. The destination host and port are parsed
4. A socket connection to the target is created
5. Data is forwarded between both sockets

---

## Example

Example target format:

```text
example.com:80
```

---

## Core Concepts

- Java Sockets
- TCP Networking
- Input/Output Streams
- Multithreading
- Data Relay

---

## Limitations

Current version does not include:

- SOCKS5 support
- HTTPS tunneling
- Authentication
- Encryption
- Logging
- Timeout management

---

## Possible Improvements

- SOCKS5 protocol support
- HTTPS proxy support
- Thread pool optimization
- Connection logging
- Better error handling
- Async/NIO implementation

---

## Educational Use

This project demonstrates the basics of socket programming and proxy server architecture using Java.
