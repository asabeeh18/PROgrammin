#include <string.h>
#include <stdio.h>

int main()
{
   const char str[80] = "This is www\ntutoria lspoint com website";
   const char s[] = "[\n ]";
   char *token;
   char *tok;
   /* get the first token */
  token=strtok(str,s);
   /* walk through other tokens */
   while( token != NULL ) 
   {
      printf( "%s-", token);
    
      token =strtok(NULL, s);
   }
   
   return(0);
}