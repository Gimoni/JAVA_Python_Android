/**
 * 객체 리터럴(Object Literal) 
 */

let arr = [10, 20, 30];		// 배열 리터럴
let obj = {};				// 객체 리터럴

let obj2 = {// 객체 리터럴 선언
	line: 10,
	column: 20,
	fg: 31,
	bg: 44,
	ch: 'A',	
	hide: () => { // 
		console.log("[" + this.fg + "," + this.bg + "]");	
		console.log(this);
		console.log(typeof this)
	},
	show: function() {
		console.log("[" + this.line + "," + this.column + "]");	
	},
};

console.log(obj2);
console.log(obj2.line);
console.log(obj2.show());
console.log(obj2.fg);
console.log(obj2.bg);

obj2.show();
obj2.hide();

console.log(obj2['line']);

 