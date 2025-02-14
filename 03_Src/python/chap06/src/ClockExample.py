from datetime import date, datetime
from time import time
from util.Font import clearScreen, cursorMove, reset, printFont
from util.getDateTime import printDate, printTime, getWeekDay


current = time(); 
clearScreen()

cursorMove(7, 10)
print("만든이: 손진희")
cursorMove(8, 10)
print("교과목: Python")

year = 2023
month = 3
day = 21

week = 'Tuesday'

hour = int(current)//60//60%24 + 9
minute = int(current)//60%60
second = int(current)%60


# week= ['MON','TUE','WED','THU','FRY','SAT','SUN']


# date = '2023-03-20'
printDate = f'{year:04d}-{month:02d}-{day:02d}'
for i in range(len(printDate)):
    ch = printDate[i]        # 저장 
    # print(date[i])
    # print(ch)
    printFont(ch, 10, 10 + i*7)
    
printTime = f'{hour:02d}:{minute:02d}:{second:02d}'
for i in range(len(printTime)):
        ch = printTime[i]
        printFont(ch, 20, 25 + i*7)

getWeekDay =f'{week}'
for i in range(len(getWeekDay)):
        ch = week[i]
        cursorMove(20, 10)
        print(f"\033[93m", end='')
        print(getWeekDay)

# blink = True
#
#     while(True):
    

reset()
print("\n\n\n\n\n")
print(printDate)
print(getWeekDay)
print(printTime)




reset()

print("Program End")