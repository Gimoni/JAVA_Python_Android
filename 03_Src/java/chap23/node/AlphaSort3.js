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
		do { // fg,bg 중복 제거
			this.fg = parseInt(Math.random()*8+30);
			this.bg = parseInt(Math.random()*8+40);
		} while(this.fg==this.bg);
		this.ch = String.fromCharCode(Math.random()*26 + "A".charCodeAt(0));
	}
}


class AlphaSort extends Alpha {
	constructor() {
		super() 
	}
	show() {
		VT100.cursorMove(this.line, this.column);
		VT100.setForeground(this.fg);
		VT100.setBackground(this.bg);
		VT100.print(this.ch);
	}
}	


VT100.reset();
VT100.clearScrean();

let alphas = [];


for(;;) {
	
	let alpha = new AlphaSort();
	
	// 화면에 알파 출력
	alpha.show();
	
	// find index : 인덱스를 찾아서 ~ 
	let findex = alphas.findIndex( a =>a.line==alpha.line&& a.column==alpha.column);
	
	// 인덱스가 비어있다면 채워 넣어라 ~
	if (findex < 0)
		alphas.push(alpha);
	else {
		alpha[findex] = alpha;
	}
	
	// 메소드를 사용해서 a를 alphas에 저장
	// alphas.push(alpha);
	
	
	if (alphas.length==800) 
		break;
}

VT100.cursorMove(21,1);
VT100.reset();
VT100.print("Program End...");

/*console.log("size = ", alphas.length);

//line asc, column asc
alphas.sort((a, b) => {
	let rtn = a.line - b.line;
	if (rtn==0)
		rtn = a.column - b.column;
	return rtn;
});

// ch는 산술연산이 안되기 때문에 삼항연산자를 사용. ch asc
alphas.sort((a, b) => a.ch>b.ch ? 1 : -1);

//ch dsc 
alphas.sort((a, b) => b.ch.charCodeAt(0) - a.ch.charAt(0));

console.table(alphas);*/


 