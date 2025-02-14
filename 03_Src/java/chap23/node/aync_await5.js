
// 객체 리터럴 활용
let job = {
	jobName : null,
	
	n : 0,
	a : 'A',
	
	// 함수 생성
	numberJob : function() {
			console.log(this.n++)
			if(this.n==10) {
				clearInterval(this.timerId);
				this.resolve();
				this.n = 0;
			}
	}, 
	alphaJob: function() {
			console.log(this.a)
			this.a = String.fromCharCode(this.a.charCodeAt(0)+1);
			if (this.a == 'Z') {
				clearInterval(this.timerId);
				this.resolve();
				this.a = 'A';
			}
	}, 	
	then : function(resolve, reject) {	// then method
		this.resolve = resolve;
		this.reject = reject;
		
		if(this.jobName=='number')
			this.timerId = setInterval(() => this.numberJob(), 100);
		else if (this.jobName=='alpha')
			this.timerId = setInterval(() => this.alphaJob(), 50);
	}
}

// 비동기 처리 
async function main() {
	job.jobName = "number";
	await job;
	
	job.jobName = "alpha";
	await job;	
	
	console.log("main() End...")
}

main();
console.log("End...")

