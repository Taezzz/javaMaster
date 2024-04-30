/*
* object.js (객체, 함수)
* 객체(속성, 메소드)
*/
const obj = {
	name : "홍길동",
	age : 20,
	showInfo: function (){
		return `이름은 ${this.name}, 나이는 ${this.age}살 입니다.`;
	}
	
} // new Object();


obj.name = "Hongkildong";
obj.age = 22;	

for (let prop in obj){
	console.log(`속성 : ${prop}, 값 : ${obj[prop]}`)
};
console.log('이름 : ' + obj.name + ', ' +'나이 : ' + obj.age);
console.log(`이름 : ${obj.name}, 나이 : ${obj.age}`);
console.log(obj.showInfo());

console.log(window);
// alert('확인!');

