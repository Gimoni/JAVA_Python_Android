/*
함수를 만드는 3가지 방법 
1. named function declaration (명명 함수 선언)
2. anonymous function expression (익명 함수 표현)
3. named function expression (명명 함수 표현)
4. Immediately-invoked expression (즉시 실행 표현)
5. function constructor
6. arrow function (화살표 함수)
*/

xxx(); 	// 함수의 위치에 상관없이 출력하능. 

function xxx () {	// function key word 사용한 단독 선언적 함수 // 전역함수 어디서든 호출가능. 
	console.log("xxx 입니다.");
}

let add = function(a, b) { // 표현식함수 이름이 없는 함수 : 함수 선언 이후에 함수 호출가능. 
	return a + b;
};

let add2 = function add(a, b) { // 표현식함수 이름이 없는 함수 : 함수 선언 이후에 함수 호출가능. 
	return a + b;
};

let mul = (a, b) => a*b;	// 화살표 함수 (람다식 함수) 

add(10, 20);	// 표현식함수는 함수 선언 이후에 함수 호출 가능. 


console.log(add(20,25));
console.log(mul(3, 3));

