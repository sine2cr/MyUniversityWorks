# -*- coding: UTF-8 -*-
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
from db import *
findlink = re.compile(r'<a href="(.*?)" target')
findnews = re.compile(r'<p>·  (.*?)</p>')
findtime = re.compile(r'<span>\[(.*?)\]</span>')
datalist = []#储存总体数据
def main():
    url='https://www.hengyang.gov.cn/xxgk/dtxx/hydt/index.html'
    getData(url)
    for i in range(2, 51):
        url = 'https://www.hengyang.gov.cn/xxgk/dtxx/hydt/pages/{}.html'.format(i)
        getData(url)
    saveData(datalist)
def askURL(url):
    head={
        "User-Agent":'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36',

    }

    request=urllib.request.Request(url=url,headers=head)
    html=''
    try:
        response=urllib.request.urlopen(request)
        html=response.read().decode('utf-8')

    except urllib.error.URLError as e:  # hasattr判断对象是否包含属性e
        if hasattr(e, "code"):
            print(e.code)
        if hasattr(e, "reason"):
            print(e.reason)
    return html

def getData(url):
    html=askURL(url)
    soup=BeautifulSoup(html,'html.parser')
    for item in soup.select('.list > li'):  # http://www.czs.gov.cn/html/dtxx/zwdt/zwyw/content_3468919.html
        data = []
        item = str(item)
        item = item.replace('\n', '')
        item = item.replace('<br/>', '')
        link = re.findall(findlink, item)  # 链接
        news = re.findall(findnews, item)  # 题目
        news =news[0].replace('"','')
        time = re.findall(findtime, item)  # 时间
        if '2022' not in time[0]:
            break
        data.append(link[0])
        data.append(news)
        if time:
            data.append(time[0])
        else:
            data.append('')
        datalist.append(data)
    return datalist

def saveData(datalist):
    conn = pymysql.connect(host=host, port=port, user=user, password=password,db=db)
    cursor = conn.cursor()
    sql1 = '''
            truncate table hengyang'''
    cursor.execute(sql1)
    conn.commit()
    for data in datalist:#每一个专题
        for index in range(len(data)):#一个列表的内容
            data[index]='"'+str(data[index])+'"'
        sql2='''
        insert into hengyang(
        url,title,time)
        values(%s)'''%','.join(data)
        cursor.execute(sql2)
        conn.commit()
    conn.close()
    cursor.close()


if __name__=='__main__':
    main()
    print('衡阳完成')