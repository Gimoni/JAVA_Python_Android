


import turtle
from tkinter import mainloop
from math import sin, radians


t = turtle.Turtle('turtle')


t.up()
t.backward(180)
t.down()
t.speed(0.1)

for x in range(360):
    y = sin(radians(x)) * 200
   
    print (x-180, y)
    t.setpos(x-180, y)
    turtle.goto(x,y)



mainloop()


