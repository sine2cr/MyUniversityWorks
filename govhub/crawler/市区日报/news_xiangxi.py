# -*- coding: UTF-8 -*-
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
from db import *
import selenium.webdriver as wb
from selenium.webdriver.common.by import By
import time,datetime

findlink=re.compile(r'<a href="(.*?)">')
findnews=re.compile(r'<h4>(.*?)</h4>')
findtime=re.compile(r'(\d*-\d*-\d*)')
def main():
    url='http://www.xxnet.com.cn/szb/tjbpc/'
    datalist=getData(url)
    saveData(datalist)


def askURL(url):
    chrome_driver = r'E:\python3\Scripts\chromedriver.exe'
    chrome_options = wb.ChromeOptions()
    prefs = {'profile.managed_default_content_settings.images': 2}
    chrome_options.add_experimental_option('prefs', prefs)
    br = wb.Chrome(executable_path=chrome_driver, options=chrome_options)
    br.maximize_window()
    br.get(url)
    time.sleep(1)
    try:
        html = []
        html.append(br.page_source)
        while(1):
            try:
                if "下<br>一<br>版" in br.page_source:#翻页
                    right = br.find_element(By.XPATH, '//div[@class="right-btn"]/ul/li/a[@class="b-btn"]')
                    right.click()
                    time.sleep(1)
                    html.append(br.page_source)
                else:
                    break
            except:
                 break
    except urllib.error.URLError as e:  # hasattr判断对象是否包含属性e
        if hasattr(e, "code"):
            print(e.code)
        if hasattr(e, "reason"):
            print(e.reason)
    return html

def getData(url):
    html=askURL(url)#
    datalist = []
    for html in html:
        soup=BeautifulSoup(html,'html.parser')
        for item in soup.select('div.news-list > ul > li.resultList >a'):
            data = []
            item = str(item)
            item=item.replace('\n','')
            link = re.findall(findlink, item)  # 链接 http://xtrb.xtol.cn/xtrbpc/content/202208/18/c76624.html
            news = re.findall(findnews, item)  # 题目
            if news[0] != '':
                news[0]=news[0].replace('“','')
                #time = re.findall(findtime, item)  # 时间
                data.append(link[0])
                data.append(news[0])
                data.append(datetime.datetime.now().strftime('%Y-%m-%d'))
                datalist.append(data)
    return datalist

def saveData(datalist):
    conn = pymysql.connect(host=host, port=port, user=user, password=password,db=db)
    cursor = conn.cursor()
    # sql1 = '''
    #         truncate table huaihua'''
    # cursor.execute(sql1)
    # conn.commit()
    for data in datalist:  # 每一个专题
        try:
            for index in range(len(data)):  # 一个列表的内容
                data[index] = '"' + str(data[index]) + '"'
            sql2 = '''
            insert into xiangxitujia(
            url,title,time)
            values(%s)''' % ','.join(data)
            cursor.execute(sql2)
            conn.commit()
        except:
            print('未更新')
            continue
    conn.close()
    cursor.close()


if __name__=='__main__':
    main()
    print('湘西完成')