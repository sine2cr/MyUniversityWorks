# -*- coding: UTF-8 -*-
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
from db import *
findlink = re.compile(r'<a href="(.*?)" target')
findnews = re.compile(r'"_blank">(.*?)<span>')
findtime = re.compile(r'(\d*-\d*-\d*)')
datalist = []#储存总体数据
def main():
    url='http://yueyang.gov.cn/zwdt/default.htm'
    getData(url)
    for i in range(1, 51):
        url = 'http://yueyang.gov.cn/zwdt/default.jsp?pager.offset={}&pager.desc=false'.format(i*15)
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
        html=response.read().decode('gb2312')

    except urllib.error.URLError as e:  # hasattr判断对象是否包含属性e
        if hasattr(e, "code"):
            print(e.code)
        if hasattr(e, "reason"):
            print(e.reason)
    return html

def getData(url):
    html=askURL(url)
    soup=BeautifulSoup(html,'html.parser')
    for item in soup.select('.col-12 > ul > li'):  # http://yueyang.gov.cn/zwdt/content_1966551.html
        data = []
        item = str(item)
        if 'line' not in item:
            item = item.replace('\n', '')
            item = item.replace('<br/>', '')
            link = re.findall(findlink, item)  # 链接
            news = re.findall(findnews, item)  # 题目
            time = re.findall(findtime, item)  # 时间
            if '2022' not in time[0]:
                break
            data.append('http://yueyang.gov.cn/zwdt/' + link[0])
            data.append(news[0])
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
            truncate table yueyang'''
    cursor.execute(sql1)
    conn.commit()
    for data in datalist:#每一个专题
        for index in range(len(data)):#一个列表的内容
            data[index]='"'+str(data[index])+'"'
        sql2='''
        insert into yueyang(
        url,title,time)
        values(%s)'''%','.join(data)
        cursor.execute(sql2)
        conn.commit()
    conn.close()
    cursor.close()


if __name__=='__main__':
    main()
    print('岳阳完成')