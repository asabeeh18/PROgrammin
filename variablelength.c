#include <stdio.h>
#include <string.h>

#define OK       0
#define NO_INPUT 1
#define TOO_LONG 2
static int getLine (char *prmpt, char *buff, size_t sz) {
    int ch, extra;

    // Get line with buffer overrun protection.
    if (prmpt != NULL) {
        printf ("%s", prmpt);
        fflush (stdout);
    }
    if (fgets (buff, sz, stdin) == NULL)
        return NO_INPUT;

    // If it was too long, there'll be no newline. In that case, we flush
    // to end of line so that excess doesn't affect the next call.
    if (buff[strlen(buff)-1] != '\n') {
        extra = 0;
        while (((ch = getchar()) != '\n') && (ch != EOF))
            extra = 1;
        return (extra == 1) ? TOO_LONG : OK;
    }

    // Otherwise remove newline and give string back to caller.
    buff[strlen(buff)-1] = '\0';
    return OK;
}
// Test program for getLine().

int main (void) {
    int rc;
    char buff[10];

    rc = getLine ("Enter string> ", buff, sizeof(buff));
    if (rc == NO_INPUT) {
        // Extra NL since my system doesn't output that on EOF.
        printf ("\nNo input\n");
        return 1;
    }

    if (rc == TOO_LONG) {
        printf ("Input too long [%s]\n", buff);
        return 1;
    }

    printf ("OK [%s]\n", buff);

    return 0;
}


/*OR USE
int main(){
	int mem=64;
	char *str=malloc(mem);
	fgets(str,mem,stdin);
	while(str[strlen(str)-1]!='\n'){//checks if we ran out of space
		mem*=2;
		str=realloc(str,mem);//double the amount of space
		fgets(str+mem/2-1,mem/2+1,stdin);//read the rest (hopefully) of the line into the new space.
	}
	printf("%s",str);
}
*/