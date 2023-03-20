# test example
from util.VT100 import clearScreen, reset
from util.Font import printFont
from util.getDateTime import printTime, printDate
import time
from util import getDateTime
from FontExample7 import year

current = time.time(); 
clearScreen()

year=2023
month=3
day=20

hour = int(current)//60//60%24 + 9
minute = int(current)//60%60
second = int(current)%60

# date = '2023-03-20'
date = f'{year:04d}-{month:02d}-{day:02d} & printDate(year, month, day)'
for i in range(len(date)):
    ch = date[i]        # 저장 
    # print(date[i])
    # print(ch)
    printFont(ch, 10, 10 + i*7)
    
time = f'{hour:02d}:{minute:02d}:{second:02d}'
for i in range(len(time)):
        ch = time[i]
        printFont(ch, 20, 20 + i*7)

print()
print(date)
print(time)




reset()

print("Program End")
