# list 인덱스로 2차원 list 만들기

print([False])
print(type[False])

print("="*50)
print([False]*40)
print([[False]*40]*20)      # 20*40 20행 40열

rect = [];     # 20*40
for i in range(20):
    rect.append([False]*40)     # 추가..

print("rect len= ", len(rect))          #20
print("rect[0] len= ", len(rect[0]))    #40

rect[0][0] = True

for i in range(len(rect)):
    for j in range(len(rect[i])):
        # print("%r," % rect[i][j], end='')       # True :1 , False:0
        print("%d," % rect[i][j], end='')       # True :1 , False:0
    print()

    
print("Program End...")