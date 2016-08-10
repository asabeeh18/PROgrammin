#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include<sys/types.h>
static void child(int fd, const int *a)
{
	pid_t pid = fork();
	int i, loc[2], n = 5, len = 2;

	printf("begin");
	for (i = 0; i<n; i++)
	{
		if (a[i] == 56)
		{
			loc[0] = i;
			break;
		}
	}
	if (pid < 0)
	{
		fprintf(stderr, "%.5d: failed to fork (%d: %s)\n",
			(int)getpid(), errno, strerror(errno));
		exit(1);
	}
	else if (pid > 0)
		return;
	else if (write(fd, loc, len) != len)
	{
		fprintf(stderr, "%.5d: failed to write on pipe %d (%d: %s)\n",
			(int)getpid(), fd, errno, strerror(errno));
		exit(1);
	}
	else
		exit(0);
}

int main(int argc, char *argv[])
{
	int a[5] = { 12, 4, 56, 77, 34 }; //creating an array with a max size of 100
	int p[2]; // Pipe descriptor array
	int i;
	char buf[12];
	if (pipe(p) == -1)
	{
		fprintf(stderr, "Pipe Failed"); // pipe fail
		return 1;
	}

	for (i = 0; i < 3; i++)
	{
		sprintf(buf, "Child: %d\n", i);
		child(p[1], a);
		if (i == 1)
			wait
	}
	int nbytes;
	close(p[1]); // close the write end
	wait();
	while ((nbytes = read(p[0], a, sizeof(a))) > 0)
	{
		printf("%.*s\n", nbytes, a[0]); // print 
		wait();
	}
	return 0;
}