# 함수 사용. 

def clearScreen():
    print("\033[2J", end='', flush=True)
    pass

def cursorMove(line, column):
    print(f"\033[{line};{column}H", end='')
    pass

def setForeground(fg):
    print(f"\033[{fg}m", end='')
    pass

def setBackground(bg):
    print(f"\033[{bg}m", end='')
    pass

def reset():
    print(f"\033[0m", end='', flush=True)
    pass

clearScreen()

cursorMove(10, 20)
setForeground(31)       # red
setBackground(44)       # blue
print("Hello World")

reset()
print("Program End")






