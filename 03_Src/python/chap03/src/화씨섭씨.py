# 섭씨 화씨 구하기 
for f in range(0, 101, 10):
    c = 5/9*(f-32)
    # print (f, '==>', c)
    # print("%3d ====> %6.2f" % (f, c))
    # print(f"{f} ====> {c}")        
    # print(f"{f:3d} ====> {c:6.2f}")
    # print(f"{f:3} ====> {c:6.2f}")

# Ascii code for문을 이용해서 출력하기. 
for ch in range(127+1):
    # print(ch, chr(ch))
    # print("%3d [%c]" % (ch, chr(ch)))
    print(f"{ch:3d} [{chr(ch)}]")

print("Program End...")




