#triplets
pythag<-function(x)
{
s<-x[1]
t<-x[2]
a<-s^2-t^2
b<-2*s*t
c<-t^2+s^2
cat("TRIPLET: ",a,b,c,"\n")
}