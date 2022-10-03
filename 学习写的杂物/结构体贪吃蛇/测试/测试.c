#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
#include<string.h>
#include<time.h>
typedef struct _snake_t
{
	int x;
	int y;
	struct _snake_t* next;

}snake_t;
snake_t* foodnode = NULL;
int gotoXY(int x, int y)
{
	//空间坐标体类型
	COORD c;
	c.X = x;
	c.Y = y;
	//GetStdHandle (GetStdHandle)获取当前标准输出句柄
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), c);
	return 0;
}
int setColor(int c)
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), c);
	return 0;
}
/*int randfood()
{
	snake_t*food_1;
	snake_t* head;
	snake_t* q;
	srand((unsigned)time(NULL));
	food_1 = malloc(sizeof(snake_t));
	while ((food_1->x % 2) != 0) //保证其为偶数，使得食物能与蛇头对其
	{
		food_1->x = rand() % 52 + 2;
	}
	food_1->y = rand() % 24 + 1;
	q = head;
	while (q->next == NULL)
	{
		if ((q->x == food_1->x) && (q->y == food_1->y)) //判断蛇身是否与食物重合
		{
			free(food_1);
			randfood();
		}
		q = q->next;
	}
	gotoXY(food_1->x, food_1->y);
	//food = food_1;
	printf("■");
	return 0;
}*/

int main()
{
	snake_t* new;
	snake_t* head=NULL;
	snake_t* tmp;
	new = malloc(sizeof(snake_t));
	new->x = 20;
	new->y = 6;
	//new->next = head;
	for (int i = 0; i < 4; i++)
	{
		new->x =24+ 2 * i;
		new->y = 6;
		gotoXY(new->x,new->y);
		printf("*");
		new->next = head;
		head = new;

	}
	

	//randfood();
}
/*

//随机的食物不能够出现在墙壁上
	//随机的食物不能够出现在蛇身上
	//随机的食物X坐标一定是偶数
	//分配空间
	foodnode = malloc(sizeof(snake_t));
	if (NULL == foodnode)
	{
		gotoXY(1, 20);
	}
*/