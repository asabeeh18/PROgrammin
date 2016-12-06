all:hello 

hello: call.o insertion.o bubble.o selection.o heap.o bucket.o
	gcc call.o insertion.o bubble.o  selection.o heap.o bucket.o -o hello
	
call.o: call.c
	gcc -c call.c

insertion.o: insertion.c
	gcc -c insertion.c
	
bubble.o: bubble.c
	gcc -c bubble.c

selection.o:selection.c 
	gcc -c selection.c

heap.o:heap.c
	gcc -c heap.c

bucket.o:bucket.c
	gcc -c bucket.c
