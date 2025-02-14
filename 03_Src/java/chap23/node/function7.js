/*
callback function



*/

// callback 함수 선언 
function triangle(predict) {
	
	// 반복문 
	for(let i=0; i<5; i++) {
		for (let j=0; j<5; j++) {
			// 매개변수로 전달된 함수 호출
			if (predict(i, j))
				process.stdout.write("*");
			else
				process.stdout.write(" ");
		}
		console.log("");
	}	
}

function number1(i, j) {
	return i>=j;
}
console.log("1.")
triangle(number1);	// callback 함수 호출 . 

console.log("2.")
triangle(function(i, j) {		// 이름 있는 함수 callback 함수 호출
	return i<=j
});

console.log("3.")
triangle((i, j) => i+j<=4);		// 화살표 함수 호출 

console.log("4.")
triangle((i, j) => i+j>=4);	
