package SegmentTree;

import java.util.Scanner;

public class SegTree {
    static class SegmentTree{
         static int[] seg;
        public SegmentTree(int n){
            seg =new int[4*n+1];
        }
        public static  void build(int idx,int low,int high,int[]arr){
            //Base Case
            if(low==high){
               seg[idx]=arr[low];
               return;
            } 
            int mid=(low+high)/2;

            build(2*idx+1, low, mid, arr);
            build(2*idx+2, mid+1, high, arr);
            seg[idx]=Math.min(seg[2*idx+1],seg[2*idx+2]);
        }

        public static int Query(int idx,int low,int high,int l,int r,int[] arr){
            if(high<l || r<low) return Integer.MAX_VALUE;

            if(low>=l && high<=r) return seg[idx];
             int mid =(low+high)/2;
            int left =Query(2*idx+1, low, mid, l, r, arr);
            int right =Query(2*idx+2, mid+1, high, l, r, arr);

            return Math.min(left,right);
        }

        public static void update(int idx,int low,int high,int i,int val,int[] arr){
            if(low==high){
                seg[idx]=val;
                return;
            }
              int mid =(low+high)/2;
              if(i<=mid){
                update(2*idx+1, low, mid,i, val, arr);
              }else{
                update(2*idx+2, mid+1, high, mid, val, arr);
              }
         
          

            seg[idx]=Math.min(seg[2*idx+1], seg[2*idx+2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr1 =new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        SegmentTree s =new SegmentTree(n);
        s.build(0, 0, n-1, arr1);
        System.out.println(s.Query(0, 0, n-1, 1, 3, arr1));
    }
}
