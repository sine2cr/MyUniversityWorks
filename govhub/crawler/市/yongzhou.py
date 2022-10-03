# -*- coding: UTF-8 -*-
import urllib.request,urllib.error
from bs4 import BeautifulSoup
import re
import pymysql
from db import *
import selenium.webdriver as wb
from selenium.webdriver.common.by import By
import time,datetime
findlink = re.compile(r'<a href="(.*?)" target="_blank">')
findnews = re.compile(r'target="_blank">(.*?)</a>')
findtime = re.compile(r'<span>(.*?)</span>')
datalist = []#储存总体数据
def main():
    url = 'http://www.yzcity.gov.cn/cnyz/yzyw/list.shtml'
    datalist = getData(url)
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
        print(br.page_source)
        while (1):
            try:
                if "下一页" in br.page_source:  # 翻页
                    right = br.find_element(By.XPATH, '//div[@id="page_div"]/div[@class="pagination_index"]/span[@class="arrow"]/a[contains(text(),"下一页")]')
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
    for html in html:
        soup=BeautifulSoup(html,'html.parser')
        for item in soup.select('.list_right > ul > li'):  # http://www.yzcity.gov.cn/cnyz/yzyw/202207/f63a32bea2944b4881d793474341ec34.shtml
            data = []
            item = str(item)
            item = item.replace('\n', '')
            item = item.replace('<br/>', '')
            link = re.findall(findlink, item)  # 链接
            news = re.findall(findnews, item)  # 题目
            time = re.findall(findtime, item)  # 时间
            if '2022' not in time[0]:
                break
            data.append('http://www.yzcity.gov.cn' + link[0])
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
            truncate table yongzhou'''
    cursor.execute(sql1)
    conn.commit()
    for data in datalist:#每一个专题
        for index in range(len(data)):#一个列表的内容
            data[index]='"'+str(data[index])+'"'
        sql2='''
        insert into yongzhou(
        url,title,time)
        values(%s)'''%','.join(data)
        cursor.execute(sql2)
        conn.commit()
    conn.close()
    cursor.close()


if __name__=='__main__':
    main()
    print('永州完成')