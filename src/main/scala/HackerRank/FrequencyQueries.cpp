// C++ program to illustrate
// unordered_map::insert({key, element})
#include <bits/stdc++.h>
#include <iostream>
#include <unordered_map>
using namespace std;

std::unordered_map<long, long> nums = {};
std::unordered_map<long, long> freq = {};

void solve(long op, long v) {
   // local variable declaration
   if (op == 1){
     long oldV = nums[v];
     nums[v] += 1;
     if(oldV) freq[oldV] -= 1;
     freq[nums[v]] += 1;
   }else if(op==2){
       long oldV = nums[v];
       if(oldV) {
            nums[v] -= 1;
            freq[oldV] -= 1;
            freq[nums[v]] += 1;
       }
   }else if(op==3){
    if(freq[v]) {
        cout << 1 << endl;
    } else {
        cout << 0 << endl;
    }
   }

}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int q;
    cin >> q;
    for(int i = 0; i < q; i++){
        long op, v;
        cin >> op >> v;
        solve(op, v);
    }
}
