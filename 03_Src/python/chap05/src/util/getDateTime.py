from time import time


def printDate(year, month, day):

    while(True):
        global current
        # year = 1970
        week = 4
        dayOfYear = 365
        if(year%4==0 and year%100!=0 or year%400==0):
            dayOfYear+=1
            
        secondOfYear = dayOfYear*24*60*60
        
        if (int(current)-secondOfYear >=0):
            current -= secondOfYear
            week += dayOfYear
        else: 
            break
        
    year +=1
    return year

    while(True):
        for i in range(1,13):
            dayOfMonth =[31,28,31,30,31,30,31,31,30,31,30,31]
            if(year%4==0 and year%100!=0 or year%400==0):
                dayOfYear[1] = 29
        
        secondOfMonth = int(dayOfMonth)*24*60*60
        if (int(current)-int(secondOfMonth) >= 0):
            current -= int(secondOfMonth)
            week += dayOfMonth
        else : 
            dayOfMonth = i
            break
    return month
    
    while(True):
        day = int(current)//60//60//24
        week += day
        if (int(current)-day*24*60*60 > 0):
            day +=1
        
    return day
    # return week
    
    # year = int(current)//60
    # month = int(current)//60//60
    # day = int(current)//60//60%24
    # return day
    # return "%04d-%02d-%02d" % (year, month, day)


year, month, day = printDate()


#### 해결하기.. 
def getWeekDay(week):
    week += printDate.day    
    while(True):        
        weekName = ['MON','TUE','WED','THU','FRY','SAT','SUN']
        week=(4+int(current)/60/60/24)%7
        if(int(current) - printDate.day*24*60*60 >0 ):
            week = week%7 
            print(week)
    return week


def printTime(hour, minute, second):    
    current = time()
    hour = int(current)//60//60%24 + 9
    minute = int(current)//60%60
    second = int(current)%60
    
    return hour
    return minute
    return second
hour, minute, second = printTime()
