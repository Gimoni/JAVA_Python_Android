
let n = 0;
let a = 'A';

function number() {
	console.log(n++); 	
	if (n==10)
		clearInterval(timerId1)
}

function alpha() {
	console.log(a);
	a = String.fromCharCode(a.charCodeAt(0) + 1);
	if (a=='Z')
		clearInterval(timerId2)
}

let timerId1 = setInterval(number, 100);
let timerId2 = setInterval(alpha, 100);



