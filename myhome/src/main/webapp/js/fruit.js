/**
 * fruit/js
 */

	 document.querySelector('#addBtn').addEventListener('click', function() {
		 // 요소생성(createElement)
		 // 자식요소(appendChild)
		 let txt = document.querySelector('input').value;  // input태그의 값을 value에 저장
		 let price = document.querySelector('input:nth-of-type(2)').value;
		 let li = document.createElement('li'); // li 요소 생성
		 li.innerText = txt + '(' + price + ')'; // li에 value값 저장
		 
		 // 삭제버튼
		 let btn = document.createElement('button');
		 btn.innerText = '삭제';
		 li.appendChild(btn);
		 btn.addEventListener('click', function(){
			this.parentElement.remove(); // parentElement. : 상위(부모)요소(=li)
		 });
	

		 let ul = document.querySelector('ul');
		 ul.appendChild(li); 
		 
	 });