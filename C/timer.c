#include<stdio.h>
#include<stdlib.h>
#include <time.h>
int main () {

    clock_t startTime;
    startTime = clock();

    int i;
    for (i = 0; i <= 2000000000; i++) {
        // Do nothing
    }
    clock_t endTime;
    endTime = clock();

    float totalTime = endTime - startTime;
    printf("%f", totalTime/1000);

    return 0;
}