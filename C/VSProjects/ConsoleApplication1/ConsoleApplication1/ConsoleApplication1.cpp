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
	char name[LN][LN];
	int index[LN];
};

struct MDT
{
	char def[LN][LN];
	int index[LN];
};

int macroCtr = -1;
int argsCtr = -1;


void expandMacro(FILE *fp, int index, struct MDT mdt, struct ALA ala)
{
	int i;
	char *dog;
	char *cat;
	char *arg;
	char *rat;

	rat = (char *)malloc(40 * sizeof(char));
	rat[0] = '\0';
	cat = (char *)malloc(40 * sizeof(char));
	cat[0] = '\0';
	dog = (char *)malloc(40 * sizeof(char));
	dog[0] = '\0';

	arg = (char *)malloc(40 * sizeof(char));
	arg[0] = '\0';
	strcpy(cat, mdt.def[index]);
	//for (i = index; i<(index + len - 1); i++)
	for (i = 0; i <= argsCtr; i++)
	{
		sprintf(arg, "$%d", ala.index[i]);
		rat = strstr(cat, arg);
		while (rat != NULL)
		{
			strcpy(dog, rat);
			if (dog == NULL)
				continue;
			cat[strlen(cat) - strlen(dog)] = '\0';
			dog = &dog[strlen(ala.name[i])];
			//strncpy(cat, cat, strlen(cat) - strlen(dog));
			//printf("%s.", cat);
			//printf("%s %s %d", cat, ala.name[i], strlen(dog));
			//sprintf(cat, "%s %s", cat, ala.name[i]);
			sprintf(cat, "%s%s%s", cat, ala.name[i], dog);

			sprintf(arg, "$%d", ala.index[i]);
			rat = strstr(cat, arg);
		}
	}
	//printf("md:%s", cat);
	fputs(cat, fp);
}

void main()
{
	char buff[50], *nameBuff, c;
	int i, j = 0, k = 0, l;
	char *token, *arg;
	char *cat, *dog;
	FILE *fpSrc, *fpInt, *fpDes;
	struct ALA ala;
	struct MDT mdt;
	struct MDT mnt;
	fpSrc = fopen("SourceFile.txt", "r");
	fpInt = fopen("Interm.txt", "w");
	fpDes = fopen("Destination.txt", "w");
	//printf("0");
	arg = "dsfdsfdsfd";

	//fgets(buff, 50, fpSrc);
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
		fgets(buff, 50, fpSrc);
		if (strncmp(buff, "MACRO", 5) == 0)
		{
			l = 0;
			macroCtr++;
			token = strtok(buff, " ");
			//found MACRO onto next line

			fgets(buff, 50, fpSrc);

			nameBuff = strtok(buff, " ");
			strcpy(mnt.def[macroCtr], token);
			mnt.index[macroCtr] = macroCtr;
			//Args
			while ((arg = strtok(NULL, " ")) != NULL)
			{
				++argsCtr;
				ala.index[argsCtr] = argsCtr;
				dog = strstr(arg, "\n");
				if (dog != NULL)
					dog[0] = '\0';
				strcpy(ala.name[argsCtr], arg);
				//printf("%s\n", ala.name[argsCtr]);
			}


			//mdt
			mdt.index[macroCtr] = macroCtr;

			cat = (char *)malloc(40 * sizeof(char));

			cat[0] = '\0';
			l = 0;
			fgets(buff, 50, fpSrc);
			while (strncmp(buff, "MEND", 4) != 0)
			{

				sprintf(cat, "%s%s", cat, buff);
				fgets(buff, 50, fpSrc);
				//printf("+%s", mdt.def[macroCtr]);
			}
			//printf("%s", cat);

			//arg substitution
			l = 0;
			dog = (char *)malloc(40 * sizeof(char));
			dog[0] = '\0';

			for (i = 0; i <= argsCtr; i++)
			{
				dog = strstr(cat, ala.name[i]);
				while (dog != NULL)
				{
					if (dog == NULL)
						continue;
					cat[strlen(cat) - strlen(dog)] = '\0';
					dog = &dog[strlen(ala.name[i])];
					//strncpy(cat, cat, strlen(cat) - strlen(dog));
					//printf("%s.", cat);
					sprintf(cat, "%s$%d%s", cat, ala.index[i], dog);
					dog = strstr(cat, ala.name[i]);
				}
			}
			strcpy(mdt.def[macroCtr], cat);
			//printf("=%s=", mdt.def[macroCtr]);

		}
		else
			fputs(buff, fpInt);
	}
	printf("\nMNT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%d-%s\n", mnt.index[i], mnt.def[i]);

	printf("\nMDT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%d-%s\n", mdt.index[i], mdt.def[i]);


	printf("\nLIST OF ARGUMENTS:\n");
	for (i = 0; i <= argsCtr; i++)
		printf("%d %s\n", ala.index[i], ala.name[i]);

	fclose(fpSrc);
	fclose(fpInt);
	//printf("MACROs STORED NOW EXPAND\n");
	fpInt = fopen("Interm.txt", "r");

	//-============MACRO STORED NOW EXPAND
	j = 0;
	while (!feof(fpInt))
	{
		fgets(buff, 50, fpInt);
		strcpy(cat, buff);

		for (i = 0; i <= macroCtr; i++)
		{
			dog = strstr(buff, mnt.def[i]);
			if (dog == NULL)
				continue;
			arg = strtok(dog, "[\n ]");
			arg = strtok(NULL, "[\n ]");
			//update ALA
			while (arg != NULL)
			{
				strcpy(ala.name[j], arg);
				arg = strtok(NULL, "[\n ]");
				j++;
			}

			cat[strlen(cat) - strlen(dog)] = '\0';
			//fputs(cat, fpDes);
			//fputs("-cat-", fpDes);
			//	fputs("-break-", fpDes);
			expandMacro(fpDes, mnt.index[i], mdt, ala);
			//dog = strstr(dog, mnt.def[i]);
			break;
		}
		if (i > macroCtr)
		{
			fputs(buff, fpDes);
		}
	}
	fcloseall();
	printf("END");
}
