
def getDate1():
    year = 2023
    month = 3
    day = 20
    return "%04d-%02d-%02d" % (year, month, day)

date1 = getDate1()
print(date1)

import time
def getDateTime():
    epoch = time.time() 
    
    year = 2023
    month = 3
    day = 20
    week = 0
    hour = 0
    minute = 0
    second = 0
    return year, month, day, week, hour, minute, second


year, month, day, week, hour, minute, second = getDateTime()








print("Program End...")