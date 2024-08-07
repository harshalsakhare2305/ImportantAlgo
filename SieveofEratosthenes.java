 public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        boolean[] prime =new boolean[n+1];
        prime[1]=false;
        Arrays.fill(prime,true);
        for(int i=2;i<=n;i++){
           if(!prime[i])continue;
         if(i*i<=n){
            for(int j=i*i;j<=n;j+=i){
                prime[j]=false;
             }
         }
        }

        
    }
