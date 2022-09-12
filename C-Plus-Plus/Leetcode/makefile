CC = g++
CFLAGS = -O

lis: main.o lis.o
	$(CC) $(CFLAGS) -o lis main.o lis.o

twoSum: main.o twoSum.o
	$(CC) $(CFLAGS) -o twoSum main.o twoSum.o

main.o: main.cpp
	$(CC) $(CFLAGS) -c main.cpp

twoSum.o: twoSum.cpp
	$(CC) $(CFLAGS) -c twoSum.cpp

lis.o: lis.cpp
	$(CC) $(CFLAGS) -c lis.cpp

clean:
	rm -f core *.o
