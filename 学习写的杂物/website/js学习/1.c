#include<stdio.h>
#include<malloc.h>
#include<vector>
#include<iostream>
#include<algorithm>
using namespace std;

//typedef struct LinkNode{
//	char str;
//	int num;
//	struct LinkNode* next;
//
//}Node;

typedef struct LinkTree{
	char data;
	int value;
	LinkTree* left;
	LinkTree* right;
}Tree;
void print(Tree* root) {
	if (root == NULL) return;
	printf("%d", root->value);
	if (root->left != NULL) {
		print(root->left);
	}
	if (root->right != NULL) {
		print(root->right);
	}

}

void sort(vector<Tree> &v) {
	for (int i = 0; i < v.size()-1; i++) {
		for (int j = 0; j < v.size() - i-1; j++) {
			if (v[j].value < v[j + 1].value) {
				Tree temp = v[j];
				v[j] = v[j + 1];
				v[j + 1] = temp;
			}
		}
	}
}
void createHuffmanTree(vector<Tree> &v) {
	Tree* left,*right;
	left = (Tree*)malloc(sizeof(Tree));
	right = (Tree*)malloc(sizeof(Tree));
	while (v.size() > 1) {
		
		sort(v);
		for (int i = 0; i < v.size(); i++) {
			printf("%d ", v[i].value);

		}
		printf("\n");
		 *left = v[v.size()-1];
		 *right = v[v.size()-2];
		v.pop_back();
		v.pop_back();
		Tree* T;
		T = (Tree*)malloc(sizeof(Tree));
		T->left = left;
		T->right = right;
		T->value = right->value + left->value;
		v.push_back(*T);
		printf("%d,%d,%d \n", v[v.size() - 1].value, v[v.size() - 1].left->value, v[v.size() - 1].right->value);
		printf("*************************************************--------*****************************************\n");

		}
		
	printf("%d", v[0].right->right->value);
}
int main() {

	int n;
	printf("请输入字符数n:");
	scanf_s("%d", &n);
	
	char str;
	int num;

	Tree* node;
	vector<Tree> v;
	
	for (int i = 0; i < n; i++) {
		scanf_s("%d,%c", &num, &str);
		node = (Tree*)malloc(sizeof(Tree));
		node->value = num;
		node->data = str;
		node->left = NULL;
		node->right = NULL;

		v.push_back(*node);
	}
	  createHuffmanTree( v);
	/*print(&T);*/
	getchar();
	return 0;
}
