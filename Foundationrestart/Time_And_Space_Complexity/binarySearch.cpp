#include<iostream>

#include<vector>

using namespace std;
int binarySearch(vector < int > & arr, int data, int si, int ei) {
    while (si <= ei) {
        int mid = (si + ei) / 2;
        if (arr[mid] == data) {
            return mid;
        } else if (arr[mid] < data) {
            si = mid + 1;
        } else {
            ei = mid - 1;
        }
    }
    return -1;
}
int main() {
    int n;
    cin>>n;
    int data, si, ei;
    vector < int > arr(n, 0);
    for (int i = 0; i < arr.size(); i++) {
        cin >> arr[i];
    }
    cin >> data >> si >> ei;
    cout << binarySearch(arr, data, si, ei);
}