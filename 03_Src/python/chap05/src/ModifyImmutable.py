
def modify1(v):
    print("v : ", v, id(v))
    v += "###"
    print("v : ", v, id(v))
    
value = "Hello"



print("전 :" ,value, id(value))
modify1(v=value)
print("후 :" ,value, id(value))

print("#"*20)

def modify2(v):
    v += [10]*3
    
    
value = [1, 2, 3, 4]

print("전 :", value, id(value))
modify2(value)
print("후 :", value, id(value))

def modify3(v):
    v += 10
    
value = 10 

print("전 :", value, id(value))
modify3(value)
print("후 :", value, id(value))


print("Program End...")

# value -> Hello 
# value 의 참조가 v 에 대잇 
# value 의 id = Hello
# v의 id = Hello

# value 자체는 변경되지는 않지만 
# 값을 나타내는 참조 값이 변경됨. 
