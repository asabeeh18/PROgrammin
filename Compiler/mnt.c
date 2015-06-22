#include<stdio.h>
#include<malloc.h>
#include<string.h>
#define LN 50

struct Macro
{
	char macroName[50];
	int index, len;
};

//used for both MNT and MDT use Union next tym (Y)
struct MDT
{
	char def[LN][LN];
	int index[LN];
};

int macroCtr = -1;

void main()
{
	char buff[50], *nameBuff, c;
	int i, j = 0, k = 0, l;
	char *token;
	char *cat,*dog;
	FILE *fpSrc;
	struct MDT mdt;
	struct MDT mnt;
	fpSrc = fopen("SourceFile.txt", "r");
	
	while (!feof(fpSrc))
	{
		fgets(buff, 50, fpSrc);
		if (strncmp(buff, "MACRO", 5) == 0)
		{
			macroCtr++;
			token = strtok(buff, " ");
			
			//found MACRO onto next line
			fgets(buff, 50, fpSrc);
			nameBuff = strtok(buff, " ");
			strcpy(mnt.def[macroCtr], token);
			mnt.index[macroCtr] = macroCtr;
			
			//Store mdt
			mdt.index[macroCtr] = macroCtr;

			cat = (char *)malloc(40 * sizeof(char));

			cat[0] = '\0';
			fgets(buff, 50, fpSrc);
			while (strncmp(buff, "MEND", 4) != 0)
			{
				sprintf(cat, "%s%s", cat, buff);
				fgets(buff, 50, fpSrc);	
			}
			strcpy(mdt.def[macroCtr], cat);
		}
		//no-process strings go here
	}
	
	//PRINT to console
	printf("\nMNT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%d-%s\n", mnt.index[i], mnt.def[i]);

	printf("\nMDT:\n");
	for (i = 0; i <= macroCtr; i++)
		printf("%d\n%s\n", mdt.index[i], mdt.def[i]);
	fcloseall();
}
