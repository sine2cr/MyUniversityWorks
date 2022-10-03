# -*- coding: UTF-8 -*-
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
from db import *
import  time,datetime

findlink = re.compile(r'<a href="../../../(.*?)">')
findnews = re.compile(r'<h4>(.*?)</h4>')
datalist = []#储存总体数据
def main():
    today_time=time.strftime('%Y%m/%d')
    for i in range(1,10):
        try:
            url='http://xtrb.xtol.cn/xtrbpc/column/'+str(today_time)+'/lA0{}.html'.format(i)
            getData(url)
        except:
            break
    print(datalist)
    saveData(datalist)
def askURL(url):
    head={
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding": "gzip, deflate",
    "Upgrade-Insecure-Requests": "1",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",

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
    for item in soup.select('.news-list > ul > .resultList'):  # http://www.xiangtan.gov.cn/109/171/172/content_1048667.html
        data = []
        item = str(item)
        item = item.replace('\n', '')
        item = item.replace('<br/>', '')
        link = re.findall(findlink, item)  # 链接 http://xtrb.xtol.cn/xtrbpc/content/202209/09/c77926.html
        news = re.findall(findnews, item)  # 题目
        data.append('http://xtrb.xtol.cn/xtrbpc/' + link[0])
        data.append(news[0])
        if time:
            data.append(datetime.datetime.now().strftime('%Y-%m-%d'))
        else:
            data.append('')
        datalist.append(data)
    return datalist

def saveData(datalist):
    conn = pymysql.connect(host=host, port=port, user=user, password=password,db=db)
    cursor = conn.cursor()
    for data in datalist:#每一个专题
        for index in range(len(data)):#一个列表的内容
            data[index]='"'+str(data[index])+'"'
        sql2='''
        insert into xiangtan(
        url,title,time)
        values(%s)'''%','.join(data)
        cursor.execute(sql2)
        conn.commit()
    conn.close()
    cursor.close()


if __name__=='__main__':
    main()
    print('湘潭完成')