package SegmentTree;

import java.util.Scanner;

public class SegTree {
    static class Pair{
        int open;
        int close;
        int full;

        Pair(int op,int cl,int fl){
            this.open=op;
            this.close=cl;
            this.full=fl;
        }
    }
    static class SegmentTree{
         static int[] seg;
         static Pair[] seg1;
         static int[] lazy;
        public SegmentTree(int n){
            seg =new int[4*n+1];
            seg1=new Pair[4*n+1];
            lazy=new int[4*n+1];
            for(int i=0;i<seg1.length;i++){
                seg1[i]=new Pair(0, 0, 0);
            }
        }

        public static  void buildmin(int idx,int low,int high,int[]arr){
            //Base Case
            if(low==high){
               seg[idx]=arr[low];
               return;
            } 
            int mid=(low+high)/2;

            buildmin(2*idx+1, low, mid, arr);
            buildmin(2*idx+2, mid+1, high, arr);
            seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);
        }

        public static int QueryMin(int idx,int low,int high,int l,int r,int[] arr){
            if(high<l || r<low) return Integer.MAX_VALUE;

            if(low>=l && high<=r) return seg[idx];
             int mid =(low+high)/2;
            int left =QueryMin(2*idx+1, low, mid, l, r, arr);
            int right =QueryMin(2*idx+2, mid+1, high, l, r, arr);

            return Math.min(left,right);
        }

        public static void updateMin(int idx,int low,int high,int i,int val,int[] arr){
            if(low==high){
                seg[idx]=val;
                return;
            }
              int mid =(low+high)/2;
              if(i<=mid){
                updateMin(2*idx+1, low, mid,i, val, arr);
              }else{
                updateMin(2*idx+2, mid+1, high, mid, val, arr);
              }
         
          

            seg[idx]=Math.min(seg[2*idx+1], seg[2*idx+2]);
        }

        public static void BuildSum(int idx,int low,int high,int[]arr){
            if(low==high){
                seg[idx]=arr[low];
                return;
            }

            int mid =(low+high)/2;

          BuildSum(2*idx+1, low, mid, arr);
          BuildSum(2*idx+2, mid+1, high, arr);
          seg[idx]=seg[2*idx+1]+seg[2*idx+2];
        }

        public static int QuerySum(int idx,int low,int high,int l,int r,int[]arr){
            //No overlap
            if(high<l || r<low) return 0;
        
             //Complete Overlap

            if(low>=l && high<=r) return seg[idx];

            //Partial OverLap

            int mid =(low+high)/2;
            int left =QuerySum(2*idx+1, low,mid, l, r, arr);
            int right=QuerySum(2*idx+2, mid+1, high, l, r, arr);

            return left+right;
        }

        public static void updateSum(int idx,int low,int high,int i,int val,int[] arr){
            if(low==high){
                seg[idx]=val;
                return ;
            }

            int mid =(low+high)/2;
            if(i<=mid){
              updateSum(2*idx+1, low,mid,i, val, arr);
            }else{
                updateSum(2*idx+2,mid+1, high,i, val, arr);
            }

            seg[idx]=seg[2*idx+1]+seg[2*idx+2];
        }

        public static void updateslazy(int idx,int low,int high,int l,int r,int val,int[] arr){

            //update if lzy of idx is equal to 0 
             if(lazy[idx]!=0){
                seg[idx]+=(high-low+1)*lazy[idx];
                if(low!=high){
                    lazy[2*idx+1]+=lazy[idx];
                    lazy[2*idx+2]+=lazy[idx];
                }

                lazy[idx]=0;
             }

            if(high<l || r<low ) return ;

            if(low>=l && high<=r ){
                seg[idx]+=(high-low+1)*val;
                if(low!=high){
                    lazy[2*idx+1]+=lazy[idx];
                    lazy[2*idx+2]+=lazy[idx];
                }

                return ;
            }   

            int mid =(low+high)/2;
            updateslazy(2*idx+1, low, mid, l, r, val, arr);
            updateslazy(2*idx+2, mid+1, high, l, r, val, arr);

          seg[idx]=seg[2*idx+1]+seg[2*idx+2];

             
        }

        public static int QueryLazy(int idx,int low,int high,int l,int r,int[] arr){
              //update if lzy of idx is equal to 0 
              if(lazy[idx]!=0){
                seg[idx]+=(high-low+1)*lazy[idx];
                if(low!=high){
                    lazy[2*idx+1]+=lazy[idx];
                    lazy[2*idx+2]+=lazy[idx];
                }

                lazy[idx]=0;
             }

             if(high<l || r<low ) return 0;

             if(low>=l && high<=r ){
                return seg[idx];
            }   
            int mid =(low+high)/2;
            int left =QueryLazy(2*idx+1, low, mid, l, r, arr);
            int right =QueryLazy(2*idx+2, mid+1, high, l, r, arr);

            return left+right;

        }

        public static Pair Merge(Pair p1,Pair p2){
            int full =Math.min(p1.open,p2.close)+p1.full+p2.full;
            int op =p1.open+p2.open-Math.min(p1.open,p2.close);
            int cl =p1.close+p2.close-Math.min(p1.open,p2.close);

            return new Pair(op, cl, full);
        }

        public static void BuildPar(int idx,int low,int high,StringBuilder s){
            if(low==high){
                int op=0;
                int cl=0;
                if(s.charAt(low)=='(') op++;
                else if(s.charAt(low)==')') cl++;
               seg1[idx]=new Pair(op, cl, 0);
               return ;
            }

            int mid =(low+high)/2;
            BuildPar(2*idx+1, low, mid, s);
            BuildPar(2*idx+2, mid+1, high, s);

            seg1[idx]=Merge(seg1[2*idx+1],seg1[2*idx+2]);
        }

        public static Pair QueryPar(int idx,int low,int high,int l,int r,StringBuilder s){
               //No overlap
               if(high<l || r<low) return new Pair(0, 0, 0);
        
               //Complete Overlap
  
              if(low>=l && high<=r) return  seg1[idx];
  
              //Partial OverLap
  
              int mid =(low+high)/2;
              Pair left =QueryPar(2*idx+1, low,mid, l, r, s);
              Pair right=QueryPar(2*idx+2, mid+1, high, l, r, s);
  
              return Merge(left, right);
        }

        public static void updatePar(int idx,int low,int high,int i,Character ch,StringBuilder s){
            if(low==high){
                int op =seg1[idx].open;
                int cl=seg1[idx].close;
                int full =seg1[idx].full;
               
                if(s.charAt(i)=='('){
                    op--;
                    cl++;
                }else if(s.charAt(i)==')'){
                    op++;
                    cl--;
                }

                seg1[idx]=new Pair(op, cl, full);
            }

            int mid =(low+high)/2;
            if(i<=mid){
                updatePar(2*idx+1, low, mid,i, ch, s);
            }else{
                updatePar(2*idx+2, mid+1, high, i, ch, s);
            }

            seg1[idx]=Merge(seg1[2*idx+1], seg1[2*idx+2]);
        }
    }



    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr1 =new int[n];
        //  String  str =sc.nextLine();
        //  StringBuilder sb =new StringBuilder(str);
        //  int n=sb.length();
         
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }


        SegmentTree s =new SegmentTree(n);
        s.BuildSum(0, 0, n-1, arr1);
        System.out.println(s.QueryLazy(0, 0, n-1, 1, 4, arr1));
         s.updateslazy(0, 0, n-1, 1, 4, 5, arr1);
         System.out.println(s.QueryLazy(0, 0, n-1, 1, 4, arr1));
         System.out.println(s.QueryLazy(0, 0, n-1, 2, 5, arr1));


        // s.BuildSum(0, 0, n-1, arr1);
        // System.out.println(s.QuerySum(0, 0, n-1, 1, 3, arr1));
        // s.updateSum(0, 0, n-1, 2,6, arr1);
        // System.out.println(s.QuerySum(0, 0, n-1, 1, 3, arr1));

        // s.BuildPar(0, 0, n-1, sb);
        // System.out.println(s.QueryPar(0, 0, n-1, 0, n-1, sb).full*2);

    }
}
