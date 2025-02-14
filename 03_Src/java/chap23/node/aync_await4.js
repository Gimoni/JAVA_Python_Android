
// 객체 리터럴 활용
let job = {
	jobName : null,
	// 함수 생성
	numberJob : function() {
		for (let i=0; i<=10; i++) 
			console.log(i)
	}, 
	alphaJob: function() {
		for (let i='A'.charCodeAt(0); i<='Z'.charCodeAt(0); i++)
			console.log(String.fromCharCode(i))
	}, 	
	then : function(resolve, reject) {	// then method
		if(this.jobName=='number')
			this.numberJob();
		else if (this.jobName=='alpha')
			this.alphaJob();
			
		resolve();		// 작업이 종료됨을 await에 호출함. resolve 성공 / reject 실패 
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

