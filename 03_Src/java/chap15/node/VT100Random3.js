/**
 * string mode에서는 8진수 033이 아닌 16진수를 사용해야함. 
 * 
 */
class VT100 {
	static clearScrean() {
		process.stdout.write("\x1b[2J");
	}
	
	static cursorMove(line, column) {
		process.stdout.write("\x1b["+line+";"+column+"H");
	}
	
	static setForeground(fg) {
		process.stdout.write("\x1b["+fg+"m");
	}
	static setBackground(bg) {
		process.stdout.write("\x1b["+bg+"m");
	}
	
	static reset(bg){
		process.stdout.write("\x1b["+"0m");
	}
	
	static print(str){
		process.stdout.write(str);
	}
}

VT100.clearScrean();

// 2차원 배열 생성
let rect = [];
for (let i=0; i<20; i++) {
	rect[i] = [];
	for (let j=0; j<40; j++) {
		rect[i][j] = false;
	}
}

// count 초기화
let forCount=0;
let count=0;
//ctrl shift c = format.. 

let id;
function loop() {
	
	forCount++;
	VT100.cursorMove(1, 42);
	VT100.reset();
	VT100.print("forCount= " + forCount);
	
	
	let line	= Math.trunc(Math.random()*20 + 1);
	let column	= Math.trunc(Math.random()*40 + 1);
	let fg;
	let bg;
	do {
		fg		= Math.trunc(Math.random()*8 + 30);
		bg		= Math.trunc(Math.random()*8 + 40);
	} while (fg==bg);
	let ch		= Math.trunc(Math.random()*25 + 'A'.codePointAt(0))
	ch = String.fromCodePoint(ch);
	
	VT100.cursorMove(line, column);
	VT100.setForeground(fg);
	VT100.setBackground(bg);
	VT100.print(ch);
	
	if (!rect[line-1][column-1]) {
		rect[line-1][column-1] = true;
		count++;
		VT100.cursorMove(2, 42);
		VT100.reset();
		VT100.print("count = " + count);
	}
	
	if (count==800){		
		clearInterval(id);
		VT100.reset();
		VT100.cursorMove(21, 1);
		VT100.print("End...");
	}
}

//id = setInterval(loop, 10);
// javascript Lambda ()=> 
id = setInterval(()=> loop(), 10);



 