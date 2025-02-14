/**
 * async / await 비동기 사용 alpha sort 작성
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
	constructor( ) {	// 생성자 	변수가 필드로 생성됨. 
		this.line = parseInt(Math.random()*20 +1);
		this.column = parseInt(Math.random()*40 +1);
		do { // fg,bg 중복 제거
			this.fg = parseInt(Math.random()*8+30);
			this.bg = parseInt(Math.random()*8+40);
		} while(this.fg+10==this.bg);
		this.ch = String.fromCharCode(Math.random()*26 + "A".charCodeAt(0));
	}
}

class AlphaSort extends Alpha {
	constructor() {
		super() 
	}
	show(offsetLine=1, offsetColumn=1) { // 매개변수에 디폴트 값 설정. 
		VT100.cursorMove(this.line+offsetLine-1, this.column+offsetColumn-1);
		VT100.setForeground(this.fg);
		VT100.setBackground(this.bg);
		VT100.print(this.ch);
	}
}	


VT100.reset();
VT100.clearScrean();


// 객체 생성
let job = {
	alphas : [],
	name : "step1",
	index : 0,
	
	// 800개 구하는 로직
	step1 : function() {
		// 알파 생성
		let alpha = new AlphaSort();
		// 화면에 알파 출력
		alpha.show();
		
		// find index : 인덱스를 찾아서 ~ 
		let findex = this.alphas.findIndex( a =>a.line==alpha.line&& a.column==alpha.column);
		
		// 인덱스가 비어있다면 채워 넣어라 ~
		if (findex < 0)
			this.alphas.push(alpha);
		else {
			this.alphas[findex] = alpha;
		}
		
		// 배열 800개 종료
		if (this.alphas.length==800) {
			clearInterval(this.timerId)
			this.resolve();
		}
	},
	
	isSort : false,
	step2 : function() {
		if (!this.isSort) {
			this.alphas.sort((a, b) => {
				let rtn = a.line - b.line;
				if (rtn==0)
					rtn = a.column - b.column;
				return rtn;
			});
			this.isSort = true;
		}
		
		this.alphas[this.index++].show(1, 42);
		
		if (this.index == this.alphas.length) {
			clearInterval(this.timerId);		
			this.resolve();
			this.isSort = false;	// 초기화
			this.index = 0;			// 초기화
		}
	},
	step3 : function() {
		if (!this.isSort) {
			this.alphas.sort((a, b) => {
				let rtn = a.line - b.line;
				if (rtn == 0)
					rtn = a.column - b.column;
				return rtn;
			});
			this.isSort = true;
		}

		this.alphas[this.index++].show(1, 42);

		if (this.index == this.alphas.length) {
			clearInterval(this.timerId);
			this.resolve();
			this.isSort = false;	// 초기화
			this.index = 0;			// 초기화
		}
		this.resolve();
	},
	step4 : function() {
		if (!this.isSort) {
			this.alphas.sort((a, b) => {
				let rtn = a.line - b.line;
				if (rtn == 0)
					rtn = a.column - b.column;
				return rtn;
			});
			this.isSort = true;
		}

		this.alphas[this.index++].show(1, 42);

		if (this.index == this.alphas.length) {
			clearInterval(this.timerId);
			this.resolve();
			this.isSort = false;	// 초기화
			this.index = 0;			// 초기화
		}
		
		this.resolve();
	},
	
	then : function(resolve, reject) {
		this.resolve = resolve;
		this.reject = reject;
		if(this.name=="step1")
			this.timerId= setInterval(()=> this.step1(), 0.3);
		else if (this.name=="step2")
			this.timerId= setInterval(()=> this.step2(), 10);
		else if (this.name=="step3")
			this.timerId= setInterval(()=> this.step3(), 10);
		else if (this.name=="step4")
			this.timerId = setInterval(()=> this.step4(), 10);
	}
};

async function main() {
	job.name = "step1";
	await job;
	
	job.name = "step2";
	await job;
	
	VT100.cursorMove(21, 1);
	VT100.reset();
	VT100.print("Program End..")
}

main();


 