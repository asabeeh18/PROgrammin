#include<stdio.h>
#include<malloc.h>
#include<string.h>
#include<stdlib.h>
//#include<stdafx.h>
//#define _CRT_SECURE_NO_DEPRECATE
#pragma warning (disable : 4996)
#define LN 50
int macroCtr = -1;
int argsCtr = -1;

typedef struct Macro
{
	char macroName[50];
	int index, len;
};

struct ALA
{
	char *name[LN];
	int index;
};

struct MDT
{
	char *def[LN];
	int index[LN];
};

struct Macro MNT[10]; //Array of size 100 too large for TurboC, check Linux
//char ALA[100][2];
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
	FILE *fpSrc, *fpInt, *fpDes;
	struct ALA ala;
	struct MDT mdt;
	fpSrc = fopen("SourceFile.txt", "r");
	fpInt = fopen("Interm.txt", "w");
	fpDes = fopen("Destination.txt", "w");
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
			printf("&= %s\n", buff);
			nameBuff = strtok(buff, " ");
			printf("%s\n", nameBuff);
//			printf("&= %s", strtok(NULL, " "));
	//		printf("&= %s", strtok(NULL, " "));
			while ((arg=strtok(NULL, " ")) != NULL)
			{
				ala.index = ++argsCtr;
				//printf("%s", strtok(NULL, " "));
			//	printf("%s %s", buff ,buff);
				//strcpy(arg, strtok(NULL, " "));
				//printf("%s\n",arg);
				ala.name[argsCtr] = arg;
				printf("%s\n", ala.name[argsCtr]);
			}
			printf("out");
			//while (1);
			//fgets(buff, 50, fpSrc);..dh
			/*  dh
			for (k = 0; k < 50; k++)
			{
			if (buff[k] == '&')
			{
			argsCtr++;

			ALA[argsCtr][0] = buff[k];
			ALA[argsCtr][1] = buff[++k];
			}
			}
			*/
			//MNT ?????
			strcpy(MNT[macroCtr].macroName, nameBuff);
			MNT[macroCtr].index = j;
			//mdt
			mdt.index[macroCtr] = macroCtr;
			mdt.def[macroCtr] = "";
			do
			{
				fgets(buff, 50, fpSrc);
				printf("\n=%s=\n", buff);
				mdt.def[macroCtr]= strcat(mdt.def[macroCtr],buff);
				//printf("+%s", mdt.def[macroCtr]);
			}while (strncmp(buff, "MEND", 4) != 0);
			printf("%s", mdt.def[macroCtr]);
			MNT[macroCtr].len = l;
		}
		else
			fputs(buff, fpInt);

		fgets(buff, 50, fpSrc);
	}
	
	printf("\nMNT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%s", MNT[i].macroName);

	printf("\nMDT:\n");
//	for (i = 0; i<50; i++)
	//	printf("%s", MDT[i]);

	printf("\nLIST OF ARGUMENTS:\n");
	/*for (i = 0; i <= argsCtr; i++)
	printf("%c%c\n", ALA[i][0], ALA[i][1]);
	*/
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
}
