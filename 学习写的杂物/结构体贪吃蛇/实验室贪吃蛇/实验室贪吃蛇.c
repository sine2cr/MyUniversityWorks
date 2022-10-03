
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<Windows.h>
#define C 26
#define K 26
int	a[C][K];
int i, j;
int initsnake(void);
int setColor(int c);
int gotoXY(int x, int y);
void map();
#define UP 1
#define DOWN 2
#define LEFT 3
#define RIGHT 4
int direction = RIGHT;
int sleepTime = 350;
typedef struct _snake_t
{
	int x;
	int y;
	struct _snake_t *next;
	
}snake_t;
snake_t* head = NULL;
snake_t* tmp = NULL;
snake_t* foodnode = NULL;
snake_t* new = NULL;
int aaaa()
{
	printf("使用方向键控制蛇的移动\n");
	printf("按下空格暂停游戏");
}
int isbitself()
{
	snake_t* tmp = NULL;
	tmp = head->next;
	while (tmp != NULL)
	{
		if (head->x == tmp->x && head->y == tmp->y)
		{
			return 1;
		}
		tmp = tmp->next;
	}
}
int isHitwall()
{
	//26,26
	if (head->x == 0 || head->x == 13 || head->x == 0 || head->y == 26)
	{
		exit(0);
		return 1;
	}
	return 0;
}
int contralSnake(void)
{
	direction = RIGHT;
	while (1)
	{
		moveSnake();
		Sleep(sleepTime);
		if (GetAsyncKeyState(VK_UP) && direction != DOWN)
		{
			direction = UP;
		}
		if (GetAsyncKeyState(VK_DOWN) && direction != UP)
		{
			direction = DOWN;
		}
		if (GetAsyncKeyState(VK_LEFT) && direction != RIGHT)
		{
			direction = LEFT;
		}
		if (GetAsyncKeyState(VK_RIGHT) && direction != LEFT)
		{
			direction = RIGHT;
		}
		if (GetAsyncKeyState(VK_SPACE))
		{
			while (1)
			{
				Sleep(3000000000);
				break;
			}
			
		}
		
		Sleep(sleepTime);
		moveSnake();
		if (isHitwall())
		{
		//ndStatus = 1;
			Sleep(10000);
			printf("你死了");
			exit(0);
			break;
		}
		/*
		if (isbitself())
		{
			printf("你死了");
			Sleep(800);
			exit(0);
		}*/

		

		
		
	}



	return 0;

}
int moveSnake(void)
{
	snake_t* new = NULL;
	snake_t* tmp = NULL;
	snake_t* save = NULL;
	new = malloc(sizeof(snake_t));
	if (NULL == new)
	{
		printf("malloc failed .....\n");
		return -1;
	}
	memset(new, 0, sizeof(snake_t));
	if (UP == direction)
	{
		new->x = head->x;
		new->y = head->y - 1;
	}
	if (DOWN == direction)
	{
		new->x = head->x;
		new->y = head->y + 1;
	}
	if (LEFT == direction)
	{
		new->x = head->x - 2;
		new->y = head->y;
	}
	if (RIGHT == direction)
	{
		new->x = head->x + 2;
		new->y = head->y;
	}
	new->next = head;
	head = new;
	
	/*
	这下面一句代码有问题

	*/


	tmp = new;
	/*
	tmp = new->next;
	*/
	if ((new->x == foodnode->x) && (new->y == foodnode->y))
	{
		while (tmp!=NULL)
		{
			
			gotoXY(tmp->x, tmp->y);
			if (head == tmp)
			{
				printf("■");
			}
			else
			{
				printf("*");
			
			}
			tmp = tmp->next;
			randfood();
		}
	}
	else
	{
		while (tmp->next!=NULL)
		{
			gotoXY(tmp->x, tmp->y);
			if (head == tmp)
			{
				printf("■");
			}
			else
			{
				printf("*");
			}
			save = tmp;
			tmp = tmp->next;

		}
		gotoXY(tmp->x, tmp->y);
		printf("  ");
		save->next = NULL;
		free(tmp);
	}

	return 0;
}
int randfood()
{
	//不能在墙
	//不能在蛇

	srand(time(NULL));
	foodnode = malloc(sizeof(snake_t));
	if (foodnode == NULL)
	{
		/*gotoXY(1, 28);
		printf("failed......\n");
		return -1;*/
		return -1;
	}
	memset(foodnode, 0, sizeof(snake_t));
	while (1)
	{
		while (1)
		{
			foodnode->x = rand() % 48 +2;
			if (0 == foodnode->x % 2)
				break;
		}
		foodnode->y = rand() % 24 + 1;
		tmp = head;
		//判断食物不在蛇身上
		while (tmp != NULL)
		{
			if ((foodnode->x == tmp->x) && (foodnode->y == tmp->y))
			{
				break;
			}
			tmp = tmp->next;
		}
		/*gotoXY(foodnode->x, foodnode->y);
		setColor(12);
		printf("*");*/
		if (tmp == NULL)
		{
			gotoXY(foodnode->x, foodnode->y);
			setColor(12);
			printf("*");
			break;
	
		}
		else
		{
			continue;
		}
		break;
	}
	return 0;
}
int initsnake(void)
{
	
	
	snake_t* new = NULL;
	snake_t* tmp = NULL;
	
	
	
	for (int i = 0; i < 4; i++)
	{
		
		new = malloc(sizeof(snake_t));
		if (new == NULL)
		{
			printf("malloc initsnake failed........\n");
			return -1;
		}
		memset(new, 0, sizeof(snake_t));
		new->x = 24 + i * 2;
		new->y = 5;
		new->next = head;
		head = new;
	}

	tmp = head;
	while (head != NULL)
	{
		setColor(14);
		//gotoXY(tmp->x, tmp->y);
		if (head == tmp)
		{
			printf("#");
		}
		else
		{
			printf("*");
		}
		
		tmp = tmp->next;
	}
	return 0;
}
int initsnake1()
{
	/*snake_t* new =NULL;
	snake_t* tmp = NULL;
	int i;
	new = malloc(sizeof(snake_t));
	new->x = 24;
	new->y = 5;
	new->next = NULL;
	for (i = 0; i < 4; i++)
	{
		head = malloc(sizeof(snake_t));
		head->next = new;
		head->x = 24 + 2 * i;
		head->y = 5;
		new = head;

	}
	tmp = new;

	while (new != NULL)
	{
		gotoXY(new->x, new->y);
		if (new == head)
		{
			printf("■");
		}
		else
		{
			printf("*");
		}
		new = new->next;*/
	snake_t* new;
	new = malloc(sizeof(snake_t));
	new->x = 24;
	new->y = 5;
	new->next = NULL;
	for (int i = 0; i < 4; i++)
	{
		new = malloc(sizeof(snake_t));
		new->x = 24 + 2 * i;
		new->y = 5;
		new->next = head;
		head = new;
	}
	tmp = head;
	//此时new是最右的节点；当最右的节点
	while (tmp != NULL)
	{
		gotoXY(tmp->x, tmp->y);
		if (head == tmp)
			printf("■");
		else
			printf("*");
		tmp = tmp->next;
	}
	return 0;
}
int setColor(int c)
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), c);
	return 0;
}
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
void map()
{

	for (i = 0;i < K; i++)
	{
		a[0][i] = 1;
		a[C - 1][i] = 1;
	}
	//打印竖
	for (j = 0; j < C; j++)
	{
		a[j][0] = 1;
		a[j][K - 1] = 1;
	}
	//遍历整个数组0输出空格，1输出符号
	for (i = 0; i < C; i++)
	{
		for (j = 0; j < K; j++)
		{
			if (a[i][j] == 0)
				printf("  ");
			else
				printf("■");
		}
		printf("\n");
	}
}
int main()
{
	//设置文本颜色
//	setColor(00);
	system("mode con cols=100 lines=30");
	srand(time(NULL));
	gotoXY(20, 8);
	setColor(10);
	printf("贪吃蛇小游戏\n");
	printf("开始游戏按1\n");
	printf("退出游戏按2\n");
	printf("游戏帮助请按3\n");

	//设置光标位置
	/*int b;
	scanf("%d", &b);
	switch (b)
	{
	case 1:
		gotoXY(10, 10);
		printf("欢迎开始贪吃蛇小游戏");
		gotoXY(0, 11); break;
	case 2:
		system("cls");
		map();
		initsnake();
		while (1)
		{
			;
		}
		return 0;
	}
	*/

	//system("cls");
	//map();
	//gotoXY(2, 20);
	//printf("***********************************************");//只能打印47个
	//地图大小为（26，26）


	//
	while (1)
	{

		int num;
		scanf_s("%d", &num);

		switch (num)
		{
		case 1:
			system("title ");
			system("cls");
			map();
			initsnake1();
			randfood();
			moveSnake();
			contralSnake();
			break;
		case 2:
			return 0;
			break;

		case 3:
			aaaa();
			printf("请再次输入");
			break;
		default:
			printf("请重新输入");
			break;
		}


	}
}