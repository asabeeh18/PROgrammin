/*
Ahmed Sabeeh
2016CS16
27/09/2016
*/
/*

Write your program for ls command. You may use dirent (see opendir, dirent.h).
*/
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>

/*
Support for
-a ALL
-author

dev_t     st_dev;     /* ID of device containing file
               
               uid_t     st_uid;     /* user ID of owner 
               gid_t     st_gid;     /* group ID of owner 
               off_t     st_size;    /* total size, in bytes 
               time_t    st_atime;   /* time of last access 
               time_t    st_mtime;   /* time of last modification 
               time_t    st_ctime;   /* time of last status change 

*/
int main(int argc, char* argv[])
{
    DIR *mydir;
    struct dirent *myfile;
    struct stat mystat;
    char *file;
	int all=0,auth=0,i,s=0;;
	if(argc<2)
	{
		printf("Error in Arguments, Format: filenam -arg1 -arg2");
		exit(0);
	}	

    mydir = opendir(argv[1]);	
	for(i=2;i<argc;i++)
	{
		if(strcmp(argv[i],"-a")==0)
		{
			all=1;
		}
		else if(strcmp(argv[i],"-author")==0)
		{
			auth=1;
		}
		else if(strcmp(argv[i],"-s")==0)
		{
			s=1;
		}
		else
		{
			printf("Error!");
			exit(0);
		}
	}
	
	printf("Filename");
	if(auth==1)
		printf("\tUserId");
	if(s==1)
		printf("\tSize");
	printf("\n");
		
    while((myfile = readdir(mydir)) != NULL)
    {
		stat(myfile->d_name, &mystat);   
    	file=myfile->d_name;
    	if(file[0]=='.')
    	{
    		if(all==1)
				printf(" %-15s", file);    	
			else
				continue;
    	}
    	else
    	{
    		printf(" %-15s", file);	
    	}
    	
//    	printf("Error prone : \n");
    	
    	if(auth==1)
    		printf("%-5d",mystat.st_uid);
    	
    	if(s==1)
    		printf("\t%-5dBytes",mystat.st_size);    			
    	printf("\n");
    }
    closedir(mydir);
}
