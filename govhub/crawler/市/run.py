# -*- coding: UTF-8 -*-
import time
import multiprocessing
import os


def loudi():
    os.system('python ./loudi.py')
def yueyang():
    os.system('python ./yueyang.py')
def changde():
    os.system('python ./changde.py')
def zhangjiajie():
    os.system('python ./zhangjiajie.py')
def huaihua():
    os.system('python ./huaihua.py')
def zhuzhou():
    os.system('python ./zhuzhou.py')
def yongzhou():
    os.system('python ./yongzhou.py')
def xiangtan():
    os.system('python ./xiangtan.py')
def xiangxitujia():
    os.system('python ./xiangxi.py')
def yiyang():
    os.system('python ./yiyang.py')
def hengyang():
    os.system('python ./hengyang.py')
def shaoyang():
    os.system('python ./shaoyang.py')
def chenzhou():
    os.system('python ./chenzhou.py')
def changsha():
    os.system('python ./changsha.py')


if __name__ == '__main__':
    start = time.time()
    p1 = multiprocessing.Process(target=loudi, )
    p2 = multiprocessing.Process(target=yueyang, )
    p3 = multiprocessing.Process(target=changde, )
    p4 = multiprocessing.Process(target=zhangjiajie, )
    p5 = multiprocessing.Process(target=huaihua, )
    p6 = multiprocessing.Process(target=zhuzhou, )
    p7 = multiprocessing.Process(target=yongzhou, )
    p8 = multiprocessing.Process(target=xiangtan, )
    p9 = multiprocessing.Process(target=xiangxitujia, )
    p10 = multiprocessing.Process(target=yiyang, )
    p11= multiprocessing.Process(target=hengyang, )
    p12 = multiprocessing.Process(target=shaoyang, )
    p13 = multiprocessing.Process(target=chenzhou, )
    p14 = multiprocessing.Process(target=changsha, )

    p1.start()
    p2.start()
    p3.start()
    p4.start()
    p5.start()
    p6.start()
    p7.start()
    p8.start()
    p9.start()
    p10.start()
    p11.start()
    p12.start()
    p13.start()
    p14.start()

    p1.join()
    p2.join()
    p3.join()
    p4.join()
    p5.join()
    p6.join()
    p7.join()
    p8.join()
    p9.join()
    p10.join()
    p11.join()
    p12.join()
    p13.join()
    p14.join()

    end = time.time()
