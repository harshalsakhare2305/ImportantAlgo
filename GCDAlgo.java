
//Time Complexity of Eucledian Algorithm is O(log(max(a,b))

//we know if b>a  gcd(a,b)=gcd(a,b-a)

//ultimate is gcd(a,b)=gcd(b%a,a)
public int gcd(int a,int b){
if(a==0){
  return b;
}

  return gcd(b%a,a);
}
