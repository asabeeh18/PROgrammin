#include<stdio.h>
#include<malloc.h>
#include<string.h>
#include<stdlib.h>
//#include<stdafx.h>
//#define _CRT_SECURE_NO_DEPRECATE
#pragma warning (disable : 4996)
#define LN 50

typedef struct Macro
{
	char macroName[50];
	int index, len;
};

struct ALA
{
	char *name[LN];
	int index[LN];
};

struct MDT
{
	char def[LN][LN];
	int index[LN];
};

int macroCtr = -1;
int argsCtr = -1;

/*
void expandMacro(FILE *fp, int index, int len)
{
	int i;
	for (i = index; i<(index + len - 1); i++)
		fputs(MDT[i], fp);
}
*/
void main()
{
	char buff[50], *nameBuff, c;
	int i, j = 0, k = 0, l;
	char *token, *arg;
	char *cat;
	FILE *fpSrc, *fpInt, *fpDes;
	struct ALA ala;
	struct MDT mdt;
	struct MDT mnt;
	fpSrc = fopen("SourceFile.txt", "r");
//	fpInt = fopen("Interm.txt", "w");
//	fpDes = fopen("Destination.txt", "w");
	//printf("0");
	arg = "dsfdsfdsfd";
	
	fgets(buff, 50, fpSrc);
	/*
	token = strtok(str, s);


	while (token != NULL)
	{
	printf(" %s\n", token);

	token = strtok(NULL, s);
	}
	*/
	while (!feof(fpSrc))
	{
		//printf("=%s", buff);
		if (strncmp(buff, "MACRO", 5) == 0)
		{
			l = 0;
			macroCtr++;
			token = strtok(buff, " ");
			//found MACRO goto next line

			fgets(buff, 50, fpSrc);
		//	printf("&= %s\n", buff);
			nameBuff = strtok(buff, " ");
			strcpy(mnt.def[macroCtr],token);
			//printf("%s\n", mnt.def[macroCtr]);
			//Args
			while ((arg=strtok(NULL, " ")) != NULL)
			{
				ala.index [argsCtr]= ++argsCtr;
				ala.name[argsCtr] = arg;
				printf("%s\n", ala.name[argsCtr]);
			}


printf("\nLIST OF ARGUMENTS:\n");
	for (i = 0; i <= argsCtr; i++)
		printf("%d %s\n", ala.index[i], ala.name[i]);
		
			//mdt
			mdt.index[macroCtr] = macroCtr;
			//mdt.def[macroCtr] = "";
			//cat = "a\0";
			cat = (char *)malloc(40*sizeof(char));
			cat[0] = '\0';
			l = 0;
			do
			{
				fgets(buff, 50, fpSrc);
				for (j = 0; j < strlen(buff); j++)
				{
					cat[j+l] = buff[j];
				}
			
				cat[j + l] = '\0';
				l = strlen(cat);
				//printf("+%s", mdt.def[macroCtr]);
			}while (strncmp(buff, "MEND", 4) != 0);
			//printf("%s", cat);
			strcpy(mdt.def[macroCtr], cat);
			printf("=%s=", mdt.def[macroCtr]);
			
		}
		else
			fputs(buff, fpInt);

		fgets(buff, 50, fpSrc);
	}
	printf("\nMNT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%s\n", mnt.def[i]);
	
	printf("\nMDT:\n");
	for (i = 0; i<=macroCtr; i++)
		printf("%s\n", mdt.def[i]);

	
printf("\nLIST OF ARGUMENTS:\n");
	for (i = 0; i <= argsCtr; i++)
		printf("%d %s\n", ala.index[i], ala.name[i]);

	while (1);
	/*		printf("\nMNT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%s", MNT[i].macroName);

	printf("\nMDT:\n");
//	for (i = 0; i<50; i++)
	//	printf("%s", MDT[i]);

	printf("\nLIST OF ARGUMENTS:\n");
	/*for (i = 0; i <= argsCtr; i++)
	printf("%c%c\n", ALA[i][0], ALA[i][1]);
	
	printf("\n");

	fclose(fpInt);
	fpInt = fopen("Interm.txt", "r");

	fgets(buff, 50, fpInt);
	while (!feof(fpInt))
	{
		for (i = 0; i <= macroCtr; i++)
			if (strcmp(buff, MNT[i].macroName) == 0)
			{
//			expandMacro(fpDes, MNT[i].index, MNT[i].len);
			break;
			}

		if (i>macroCtr)
			fputs(buff, fpDes);

		fgets(buff, 50, fpInt);
	}
	*/
}
