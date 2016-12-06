// C program for Implementation of Tournament Sort

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define SIZE 30000

// Function to perform tournament sort which returns index of smallest number
int tournament_sort(int arr[], int two_power)
{
     int counter, index = 1;
     
     for (counter = two_power - 1; counter > 0; counter--)
     {
         if(arr[2 * counter] < arr[2 * counter + 1])
         {
             arr[counter] = arr[2 * counter];
         }
         else
         {
             arr[counter] = arr[2 * counter + 1];
         }
     }
     
     while (index < two_power)
     {
         if (arr[index] == arr[2 * index])
             index = 2 * index;
         else
             index = 2 * index + 1;
     }
     
     /*printf("\n The elements are - %d\n", index);
     for(counter = 1; counter < 2 * two_power; counter++)
         printf("\t%d", arr[counter]);*/
         
    return index;
}
 
int main()
{
    int size, counter, counter2, flag, arr[SIZE], output[SIZE], index, max = 0, two_power = 1;
    char temp[SIZE];

    system("clear");    
    do
    {
        flag = 0;
        printf("\n Enter the number of integers to be inserted : ");
        scanf("%s", temp);
        for(counter = 0; counter < strlen(temp); counter++)
        {
            if (temp[counter] < 48 || temp[counter] > 57)
            {
                printf("\n Invalid Data Type Entered .. Please input valid data type ... ");
                flag = 1;
                break;
            }
        }
        size = atoi(temp);
    }while(flag == 1);
    
    while (size > two_power)
        two_power *= 2;
        
    for (counter = two_power; counter < two_power + size; counter++)
    {
        do
        {
            flag = 0;
            printf("\n Enter an integer : ");
            scanf("%s", temp);
            for(counter2 = 0; counter2 < strlen(temp); counter2++)
            {
                if (temp[counter2] < 48 || temp[counter2] > 57)
                {
                    printf("\n Invalid Data Type Entered .. Please input valid data type ... ");
                    flag = 1;
                    break;
                }
            }
            arr[counter] = atoi(temp);
            if (arr[counter] > max)
                max = arr[counter];
        }while(flag == 1);
    }
    
    for (counter = two_power + size; counter < 2 * two_power; counter++)
    {
        arr[counter] = max + 1;
    }

    // The elements stores after tournament sort are such that arr[index] has smallest element
    // Put arr[index] in output array, replace arr[index] with max + 1 and re-run tournament sort n times to get n smallest integer
    for (counter = 0; counter < size; counter++)
    {
        index = tournament_sort(arr, two_power);
        output[counter] = arr[index];
        arr[index] = max + 1;
    }
    

    printf("\n Sorted array is ");
    for (counter = 0; counter < size; counter++)
        printf("\t%d", output[counter]);
    printf("\n");
    return 0;
}