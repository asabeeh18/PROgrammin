%{
#include <cstdio>
#include <iostream>
using namespace std;
//#include "txt.tab.h"  // to get the token types that we return

extern "C" int yylex();
extern "C" int yyparse();
extern "C" FILE *yyin;
 
void yyerror(const char *s);
%}

%union 
{
	char* ival;
	int nval;
}

%token <ival> prnt
%token <nval> LI
%token TEXT

%%
yo:
	yo TEXT prnt	{ cout << "bison found an int: " << $3 << endl; }
	|
	TEXT prnt 	{ cout << "bison found an int: " << $2 << endl; }
	|
	yo LI	{ cout << "bison found an int: " << $2 << endl; }
	;
%%

main(int argc, char *argv[]) {

	FILE *myfile = fopen("sa.f", "r");
	if (!myfile) {
		cout << "I can't open a.snazzle.file!" << endl;
		return -1;
	}
	yyin = myfile;
	do 
	{
		yyparse();
	} while (!feof(yyin));
	
}

void yyerror(const char *s) 
{
	cout << "parse error!  Message: " << s << endl;
	exit(-1);
}
