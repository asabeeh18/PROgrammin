/*
func();
Ahmed Sabeeh
2016CS16
*/

#include<stdio.h>
#include<dirent.h>
#include<string.h>
#include<regex.h>
//
/*
\(.*?\)
then manually check for semicolon at end and not if while for
*/
int lineCount=0;
int funcCount=0;
regex_t regex;
char msgbuf[100];
char *trimwhitespace(char *str)
{
  char *end;

  // Trim leading space
  while(isspace((unsigned char)*str)) str++;

  if(*str == 0)  // All spaces?
    return str;

  // Trim trailing space
  end = str + strlen(str) - 1;
  while(end > str && isspace((unsigned char)*end)) end--;

  // Write new null terminator
  *(end+1) = 0;

  return str;
}

void moreMatch(char *line)
{
	line=trimwhitespace(line);
	
	if(line[strlen(line)-1]!=';')	//not a function declaration
		return;

	if(strstr("if(",line)==NULL && strstr("for(",line)==NULL && strstr("while(",line)==NULL  )	//not if while for
		funcCount++;

}
void match(char *line)
{
	int reti = regexec(&regex, line, 0, NULL, 0);
	if (!reti) 
	{
		moreMatch(line);
	}
	else if (reti == REG_NOMATCH) 
	{
		puts("No match");
	}
	else 
	{
		regerror(reti, &regex, msgbuf, sizeof(msgbuf));
		printf("Regex match failed: %s\n", msgbuf);
		//exit(1);
	}
}
void readThis(char* file)
{
	FILE *f;
	char *line;
	size_t s=512;
	int d=0;
	f=fopen(file,"r+");
	scanf("%d",&d);
	while(!feof(f))
	{
//		d=fscanf(f,"%s",&line);
		if(getline(&line,&s,f)==-1)
			printf("Error reading\n");
		lineCount++;
		match(line);
//		printf("Line:%s\n",line);
		
		printf("fCOunt:%d lCount:%d\n",funcCount,lineCount);
		
	}
//	while(1);
}
void dirOpen()
{
	DIR *dir;
	int c;
	struct dirent *ent;
	if ((dir = opendir ("./")) != NULL) 
	{
	  /* print all the files and directories within directory */
	  while ((ent = readdir (dir)) != NULL) 
	  {
		printf ("%s\n", ent->d_name);
		if(ent->d_name[strlen(ent->d_name)-1]=='c' && ent->d_name[strlen(ent->d_name)-2]=='.')
			readThis(ent->d_name);
		scanf("%d",&c);
	  }

	  closedir(dir);
	}
	else
	{
	  /* could not open directory */
	  perror ("could not open directory");

	}
}
void main()
{
	//system("find . -name '*.c' | xargs wc -l");
	//printf("Total number of lines of code: %d\n",system("( find ./ -name '*.c' -print0 | xargs -0 cat ) | wc -l");
	//grep or line by line reading fro function call check (a-zA-Z0-9)*

	int reti;
	//char msgbuf[100];
	FILE *f;
    char c;
    //f=fopen("test.txt","rt");

    //Compile Regex
//    reti = regcomp(&regex, "(.*)", 0);
	reti = regcomp(&regex, "[a-zA-Z0-9](.*)",REG_EXTENDED);
	if(reti)
	{
		fprintf(stderr, "Could not compile regex\n");
		//exit(1);
	}

    dirOpen();
}
