/**
 * string mode에서는 8진수 033이 아닌 16진수를 사용해야함. 
 * 
 */
class VT100 {
	static F_BLACK 		= 30;
	static F_RED		= 31;
	static F_GREEN		= 32;
	static F_YELLOW		= 33;
	static F_BLUE		= 34;
	static F_MAGENTA	= 35;
	static F_CYAN		= 36;
    static F_WHITE		= 37;
    
	static B_BLACK 		= 40;
	static B_RED		= 41;
	static B_GREEN		= 42;
	static B_YELLOW		= 43;
	static B_BLUE		= 44;
	static B_MAGENTA	= 45;
	static B_CYAN		= 46;
    static B_WHITE		= 47;
    
	static num = 100;	// 속성(필드)
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
		process.stdout.write(str+"");
	}
}


class Alpha {
	// 속성을 정의. 
/*	line =0;
	column =0;
	fg =0;
	bg =0;
	ch =0;*/
	
	constructor( ) {	// 생성자 	변수가 필드로 생성됨. 
		this.line = parseInt(Math.random()*20 +1);
		this.column = parseInt(Math.random()*40 +1);
		this.fg = parseInt(Math.random()*8+30);
		this.bg = parseInt(Math.random()*8+40);
		this.ch = String.fromCharCode(Math.random()*26 + "A".charCodeAt(0));
	}



	show(){
		VT100.cursorMove(this.line, this.column);
		VT100.setForeground(this.fg);
		VT100.setBackground(this.bg);
		VT100.print(this.ch);
	}
	
	hide(){
		VT100.cursorMove(this.line, this.column);
		VT100.reset();
		VT100.print(' ');
	}
	
	move(){
	this.hide();
	
	switch(this.direction) {
	case 0: // right
		this.column++;
		break;
	case 1: // bottom
		this.line++;
		break;
	case 2: // left
		this.column--;
		break;
	case 3: // top
		this.line--;
		break;
	}
		
		
	if (this.line==1 && this.column==40)
		this.direction=1;
	else if(this.line==20 && this.column==40)
		this.direction=2;
	else if(this.line==20 && this.column==1)
		this.direction=3;
	else if(this.line==1 && this.column==1)
		this.direction=0;

		
	this.show();	
	}

}

	
	VT100.reset();
	VT100.clearScrean();
	
	let alphas = [new Alpha(), new Alpha(), new Alpha(), new Alpha()];
	
	
	
	console.log(alphas);
	console.log("====================================1");
	console.log(alphas.sort((a, b) => a.line-b.line && a.column-b.column))
	console.log("====================================2");
	console.log(alphas.sort((a, b) => b.column-a.column && a.line-b.line ));
	console.log("====================================3");
	console.log(alphas.sort((a, b) =>  b.column-a.column && b.line-a.line));
	console.log("====================================4");
	
	let rect = new boolean[20][40];	// false/true
	let saveRect = new int[3][20][40];
	
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
	
	let li = this.line -1;
	let ci =  this.colum -1;
	saveRect[0][li][ci]= ch;
	saveRect[1][li][ci]= fg;
	saveRect[2][li][ci]= bg;
	
	if (!rect[line-1][column-1]) {
		rect[line-1][column-1] = true;
		count++;
		VT100.cursorMove(2, 42);
		VT100.reset();
		VT100.print("count = " + count);
	}
	
	if (count==800){		
		clearInterval(id);
		VT100.cursorMove(22, 1);
		VT100.setForeground(VT100.F_RED);
		VT100.setBackground(VT100.B_BLUE);
		VT100.print("End...");
		VT100.reset();
	}
	
	for(let i=0; i<20; i++) {
		for (let j=0; j<40; j++) {
			this.line = i+1;
			this.column = j+1;
			this.ch = saveRect[0][i][j]
			this.fg = saveRect[1][i][j]
			this.bg = saveRect[2][i][j]
			
			//03_Src/java/chap05/src/AlphaExample8.java
		}
	}
}

//id = setInterval(loop, 10);
// javascript Lambda ()=> 
id = setInterval(()=> loop(), 1);
 
 