
import time as t 
from util.Font import printFont
from util.VT100 import clearScreen, cursorMove, setForeground, reset

def getDateTime():
    epoch = int(t.time()) + 9*60*60;
    
    year = 1970
    week = 4        # 19707년 1월 1일은 목요일
    while True: 
        dayOfYear = 365
        if year%4==0 and year%100!=0 or year%400==0:
            dayOfYear += 1
        
        if epoch - dayOfYear*24*60*60 >= 0 :
            epoch -= dayOfYear*24*60*60
            year += 1 
            week += dayOfYear
        else: 
            break
            
    
    dayOfMonth = [31, 28, 31 ,30, 31, 30, 31, 31, 30, 31, 30, 31]        
    if year%4==0 and year%100!=0 or year%400==0:
        dayOfMonth[1] = 29
    
    month = 0
    for i in range(1, 12):
        if epoch - dayOfMonth[i-1]*24*60*60 >= 0 :
           epoch -= dayOfMonth[i-1]*24*60*60 
           week += dayOfMonth[i-1]
        else: 
            month = i
            break
        
    
    day = epoch//60//60//24   # 1일에 해당하는 
    epoch -= day*24*60*60
    week += day
    
    day += 1    # 오늘 날짜 추가
    
    week = week%7  
    
    hour = epoch//60//60%24 
    minute = epoch//60%60
    second = epoch%60
    
    return year, month, day, week, hour, minute, second
    pass

clearScreen()


blink = True 


while True : 
    year, month, day, week, hour, minute, second = getDateTime()
    
    dayofweek = ["일요일","월요일", "화요일", "수요일","목요일", "금요일"]
    
    date = f"{year:04d}-{month:02d}-{day:02d}"
    
    if blink:
        time = f"{hour:02d}:{minute:02d}:{second:02d}"
    else:
        time = f"{hour:02d} {minute:02d} {second:02d}"
    
    blink = not blink
    
    for i in range(len(date)):
        ch = date[i]
        printFont(ch, 10, 10 + i*7)

    cursorMove(17, 10)
    reset()
    setForeground(31)
    
    if blink:
        print(dayofweek[week], end='')
    else:
        print('        ', end='')
        
    for i in range(len(time)):
        ch = time[i]
        printFont(ch, 17, 24 + i*7)

    t.sleep(1)

# print(date)
# print(time)
print()
print("Program End")