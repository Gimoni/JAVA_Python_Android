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
	line =1;
	column =1;
/*	fg =0;
	bg =0;
	ch =0;*/
	constructor(line, column, fg, bg, ch ) {	// 생성자 	변수가 필드로 생성됨. 
		this.line =  line;
		this.column = column;
		this.fg = parseInt(Math.random()*8+30);
		this.bg = parseInt(Math.random()*8+40);
		this.ch = String.fromCharCode(Math.random()*26 + "A".charCodeAt(0));
				
		this.show();
		
		this.timerId =	setTimeout(()=> this.race(), Math.random()*100 + 10);
		
	
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
	
	static ranking = 0;
	

	race(){
		this.hide();
		this.column ++;
		this.show();	
		
		if (this.column==50) {
			clearTimeout(this.timerId);
			Alpha.ranking++;
			VT100.cursorMove(this.line, this.column+2);
			VT100.reset();
			VT100.print(Alpha.ranking + "등");
		} else
			this.timerId =	setTimeout(()=> this.race(), Math.random()*100 + 10);
		
		if (Alpha.ranking ==5) {
			VT100.cursorMove(15, 1)
			VT100.reset();
			VT100.print("Racing End...");
		}

	}
	
	// 필드
	blink = true;
	
	loop() {
		if (this.blink)
			this.show();
		else
			this.hide();
		
		this.blink = !this.blink;
	}
}

VT100.reset();
VT100.clearScrean();

let a = new Alpha(5, 5);
let b = new Alpha(6, 5);
let c = new Alpha(7, 5);
let d = new Alpha(8, 5);
let e = new Alpha(9, 5);
let f = new Alpha(10, 5);







 