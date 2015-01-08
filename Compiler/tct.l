%{
#include <cstdio>
#include <iostream>
using namespace std;
#define YY_DECL extern "C" int yylex()
#include "txt.tab.h"  // to get the token types that we return
int linenum=0;
%}
%%
[ \t]           ;
[ \n]		 linenum++;
TEXT	{
	return TEXT;
}
LINE	{
	yylval.nval=linenum;
	return LI;
}
[a-zA-Z0-9]+      {
	// we have to copy because we can't rely on yytext not changing underneath us:
	yylval.ival = strdup(yytext);
	return prnt;
}
.                ;
%%