
//Time Complexity of Eucledian Algorithm is O(log(max(a,b))
public int gcd(int a,int b){
if(a==0){
  return b;
}

  return gcd(b%a,a);
}
