#!/usr/bin/env python3
import socket

NUM_OF_TESTS = 10
PORT = 9999


def main():

    # Connect over TCP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect(('localhost', PORT))

    for i in range(NUM_OF_TESTS):
        print('Starting test {}'.format(i))

if __name__ == '__main__':
    main()
