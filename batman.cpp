#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
#define maxn 10010
char s[maxn];
int a[11];
struct node{
    int id[maxn];
    int cnt;
}num[12];
char ss[maxn];
int ans1=3000000;
int main()
{
    int i,j,n,m,ii;
    while(scanf("%d%d",&n,&m)!=EOF){
        scanf("%s",s); int len=strlen(s);
        char ans[maxn]; ans1=30000000;
        for(i=0;i<=10;i++)
            num[i].cnt=0;
        memset(a,0,sizeof(a));
        for(i=0;i<len;i++){
            a[s[i]-'0']++;
        }
        for(i=0;i<=9;i++){
            if(a[i]>=m){
                printf("0\n%s\n",s);
                break;
            }
        }
        if(i>9)
		{
        for(i=0;i<len;i++){
            int len=num[s[i]-'0'].cnt;
            num[s[i]-'0'].id[len++]=i;
            num[s[i]-'0'].cnt++;
        }
        for(j=0;j<=9;j++){
            strcpy(ss,s);
            int tot=0,tt=0;
            int cha=m-a[j];
            bool f=true; int jia=0;
            i=j;
            for(i=j+1,ii=j-1;;i++,ii--){
                if(i<=9&&f){
                    int aa=a[i]; int jj=0;
                    while(aa){
                        tt++;
                        tot+=j-ii;
                        ss[num[i].id[jj++]]=j+'0';
                        if(tt>=cha){
                            f=false;
                            break;
                        }
                        aa--;
                    }
                }
                if(!f) break;
                if(ii>=0&&f){
                    int aa=a[ii];
                    while(aa){
                        tt++;
                        tot+=j-ii;
                        ss[num[ii].id[aa-1]]=j+'0';
                        if(tt>=cha){ f=false; break; }
                        aa--;
                    }
                }
            }
            if(tot<ans1){ ans1=tot; strcpy(ans,ss); }
             else if(tot==ans1){
                if(j==0) strcpy(ans,ss);
                if(strcmp(ans,ss)>0)
                    strcpy(ans,ss);
            }else continue;
        }
        printf("%d\n%s\n",ans1,ans);
        }
    }
    return 0;
}
